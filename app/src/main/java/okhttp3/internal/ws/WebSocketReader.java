package okhttp3.internal.ws;

import ah.c;
import ah.e;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import java.util.zip.DataFormatException;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Settings;
import okio.ByteString;
import zf.i;

/* compiled from: WebSocketReader.kt */
/* loaded from: classes2.dex */
public final class WebSocketReader implements Closeable {
    private boolean closed;
    private final c controlFrameBuffer;
    private final FrameCallback frameCallback;
    private long frameLength;
    private final boolean isClient;
    private boolean isControlFrame;
    private boolean isFinalFrame;
    private final c.a maskCursor;
    private final byte[] maskKey;
    private final c messageFrameBuffer;
    private MessageInflater messageInflater;
    private final boolean noContextTakeover;
    private int opcode;
    private final boolean perMessageDeflate;
    private boolean readingCompressedMessage;
    private final e source;

    /* compiled from: WebSocketReader.kt */
    public interface FrameCallback {
        void onReadClose(int i10, String str);

        void onReadMessage(String str) throws IOException;

        void onReadMessage(ByteString byteString) throws IOException;

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    public WebSocketReader(boolean z10, e eVar, FrameCallback frameCallback, boolean z11, boolean z12) {
        i.checkNotNullParameter(eVar, "source");
        i.checkNotNullParameter(frameCallback, "frameCallback");
        this.isClient = z10;
        this.source = eVar;
        this.frameCallback = frameCallback;
        this.perMessageDeflate = z11;
        this.noContextTakeover = z12;
        this.controlFrameBuffer = new c();
        this.messageFrameBuffer = new c();
        this.maskKey = z10 ? null : new byte[4];
        this.maskCursor = z10 ? null : new c.a();
    }

    private final void readControlFrame() throws IOException {
        short s10;
        String utf8;
        long j10 = this.frameLength;
        if (j10 > 0) {
            this.source.readFully(this.controlFrameBuffer, j10);
            if (!this.isClient) {
                c cVar = this.controlFrameBuffer;
                c.a aVar = this.maskCursor;
                i.checkNotNull(aVar);
                cVar.readAndWriteUnsafe(aVar);
                this.maskCursor.seek(0L);
                WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                c.a aVar2 = this.maskCursor;
                byte[] bArr = this.maskKey;
                i.checkNotNull(bArr);
                webSocketProtocol.toggleMask(aVar2, bArr);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                long size = this.controlFrameBuffer.size();
                if (size == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (size != 0) {
                    s10 = this.controlFrameBuffer.readShort();
                    utf8 = this.controlFrameBuffer.readUtf8();
                    String strCloseCodeExceptionMessage = WebSocketProtocol.INSTANCE.closeCodeExceptionMessage(s10);
                    if (strCloseCodeExceptionMessage != null) {
                        throw new ProtocolException(strCloseCodeExceptionMessage);
                    }
                } else {
                    s10 = 1005;
                    utf8 = "";
                }
                this.frameCallback.onReadClose(s10, utf8);
                this.closed = true;
                return;
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.readByteString());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.readByteString());
                return;
            default:
                throw new ProtocolException(i.stringPlus("Unknown control opcode: ", Util.toHexString(this.opcode)));
        }
    }

    private final void readHeader() throws IOException {
        boolean z10;
        if (this.closed) {
            throw new IOException("closed");
        }
        long jTimeoutNanos = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        try {
            int iAnd = Util.and(this.source.readByte(), 255);
            this.source.timeout().timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            int i10 = iAnd & 15;
            this.opcode = i10;
            boolean z11 = (iAnd & 128) != 0;
            this.isFinalFrame = z11;
            boolean z12 = (iAnd & 8) != 0;
            this.isControlFrame = z12;
            if (z12 && !z11) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z13 = (iAnd & 64) != 0;
            if (i10 == 1 || i10 == 2) {
                if (!z13) {
                    z10 = false;
                } else {
                    if (!this.perMessageDeflate) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    z10 = true;
                }
                this.readingCompressedMessage = z10;
            } else if (z13) {
                throw new ProtocolException("Unexpected rsv1 flag");
            }
            if ((iAnd & 32) != 0) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            if ((iAnd & 16) != 0) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            int iAnd2 = Util.and(this.source.readByte(), 255);
            boolean z14 = (iAnd2 & 128) != 0;
            if (z14 == this.isClient) {
                throw new ProtocolException(this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j10 = iAnd2 & 127;
            this.frameLength = j10;
            if (j10 == 126) {
                this.frameLength = Util.and(this.source.readShort(), Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            } else if (j10 == 127) {
                long j11 = this.source.readLong();
                this.frameLength = j11;
                if (j11 < 0) {
                    throw new ProtocolException("Frame length 0x" + Util.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.isControlFrame && this.frameLength > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z14) {
                e eVar = this.source;
                byte[] bArr = this.maskKey;
                i.checkNotNull(bArr);
                eVar.readFully(bArr);
            }
        } catch (Throwable th2) {
            this.source.timeout().timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            throw th2;
        }
    }

    private final void readMessage() throws IOException {
        while (!this.closed) {
            long j10 = this.frameLength;
            if (j10 > 0) {
                this.source.readFully(this.messageFrameBuffer, j10);
                if (!this.isClient) {
                    c cVar = this.messageFrameBuffer;
                    c.a aVar = this.maskCursor;
                    i.checkNotNull(aVar);
                    cVar.readAndWriteUnsafe(aVar);
                    this.maskCursor.seek(this.messageFrameBuffer.size() - this.frameLength);
                    WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                    c.a aVar2 = this.maskCursor;
                    byte[] bArr = this.maskKey;
                    i.checkNotNull(bArr);
                    webSocketProtocol.toggleMask(aVar2, bArr);
                    this.maskCursor.close();
                }
            }
            if (this.isFinalFrame) {
                return;
            }
            readUntilNonControlFrame();
            if (this.opcode != 0) {
                throw new ProtocolException(i.stringPlus("Expected continuation opcode. Got: ", Util.toHexString(this.opcode)));
            }
        }
        throw new IOException("closed");
    }

    private final void readMessageFrame() throws DataFormatException, IOException {
        int i10 = this.opcode;
        if (i10 != 1 && i10 != 2) {
            throw new ProtocolException(i.stringPlus("Unknown opcode: ", Util.toHexString(i10)));
        }
        readMessage();
        if (this.readingCompressedMessage) {
            MessageInflater messageInflater = this.messageInflater;
            if (messageInflater == null) {
                messageInflater = new MessageInflater(this.noContextTakeover);
                this.messageInflater = messageInflater;
            }
            messageInflater.inflate(this.messageFrameBuffer);
        }
        if (i10 == 1) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
        } else {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.readByteString());
        }
    }

    private final void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (!this.isControlFrame) {
                return;
            } else {
                readControlFrame();
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        MessageInflater messageInflater = this.messageInflater;
        if (messageInflater == null) {
            return;
        }
        messageInflater.close();
    }

    public final e getSource() {
        return this.source;
    }

    public final void processNextFrame() throws DataFormatException, IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }
}
