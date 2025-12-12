package okhttp3.internal.ws;

import ah.c;
import ah.d;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import okio.ByteString;
import zf.i;

/* compiled from: WebSocketWriter.kt */
/* loaded from: classes2.dex */
public final class WebSocketWriter implements Closeable {
    private final boolean isClient;
    private final c.a maskCursor;
    private final byte[] maskKey;
    private final c messageBuffer;
    private MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;
    private final Random random;
    private final d sink;
    private final c sinkBuffer;
    private boolean writerClosed;

    public WebSocketWriter(boolean z10, d dVar, Random random, boolean z11, boolean z12, long j10) {
        i.checkNotNullParameter(dVar, "sink");
        i.checkNotNullParameter(random, "random");
        this.isClient = z10;
        this.sink = dVar;
        this.random = random;
        this.perMessageDeflate = z11;
        this.noContextTakeover = z12;
        this.minimumDeflateSize = j10;
        this.messageBuffer = new c();
        this.sinkBuffer = dVar.getBuffer();
        this.maskKey = z10 ? new byte[4] : null;
        this.maskCursor = z10 ? new c.a() : null;
    }

    private final void writeControlFrame(int i10, ByteString byteString) throws IOException {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        int size = byteString.size();
        if (!(((long) size) <= 125)) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
        }
        this.sinkBuffer.writeByte(i10 | 128);
        if (this.isClient) {
            this.sinkBuffer.writeByte(size | 128);
            Random random = this.random;
            byte[] bArr = this.maskKey;
            i.checkNotNull(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.write(this.maskKey);
            if (size > 0) {
                long size2 = this.sinkBuffer.size();
                this.sinkBuffer.write(byteString);
                c cVar = this.sinkBuffer;
                c.a aVar = this.maskCursor;
                i.checkNotNull(aVar);
                cVar.readAndWriteUnsafe(aVar);
                this.maskCursor.seek(size2);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.writeByte(size);
            this.sinkBuffer.write(byteString);
        }
        this.sink.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        MessageDeflater messageDeflater = this.messageDeflater;
        if (messageDeflater == null) {
            return;
        }
        messageDeflater.close();
    }

    public final Random getRandom() {
        return this.random;
    }

    public final d getSink() {
        return this.sink;
    }

    public final void writeClose(int i10, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.f17102p;
        if (i10 != 0 || byteString != null) {
            if (i10 != 0) {
                WebSocketProtocol.INSTANCE.validateCloseCode(i10);
            }
            c cVar = new c();
            cVar.writeShort(i10);
            if (byteString != null) {
                cVar.write(byteString);
            }
            byteString2 = cVar.readByteString();
        }
        try {
            writeControlFrame(8, byteString2);
        } finally {
            this.writerClosed = true;
        }
    }

    public final void writeMessageFrame(int i10, ByteString byteString) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        i.checkNotNullParameter(byteString, JsonStorageKeyNames.DATA_KEY);
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        this.messageBuffer.write(byteString);
        int i11 = i10 | 128;
        if (this.perMessageDeflate && byteString.size() >= this.minimumDeflateSize) {
            MessageDeflater messageDeflater = this.messageDeflater;
            if (messageDeflater == null) {
                messageDeflater = new MessageDeflater(this.noContextTakeover);
                this.messageDeflater = messageDeflater;
            }
            messageDeflater.deflate(this.messageBuffer);
            i11 |= 64;
        }
        long size = this.messageBuffer.size();
        this.sinkBuffer.writeByte(i11);
        int i12 = this.isClient ? 128 : 0;
        if (size <= 125) {
            this.sinkBuffer.writeByte(((int) size) | i12);
        } else if (size <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            this.sinkBuffer.writeByte(i12 | 126);
            this.sinkBuffer.writeShort((int) size);
        } else {
            this.sinkBuffer.writeByte(i12 | 127);
            this.sinkBuffer.writeLong(size);
        }
        if (this.isClient) {
            Random random = this.random;
            byte[] bArr = this.maskKey;
            i.checkNotNull(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.write(this.maskKey);
            if (size > 0) {
                c cVar = this.messageBuffer;
                c.a aVar = this.maskCursor;
                i.checkNotNull(aVar);
                cVar.readAndWriteUnsafe(aVar);
                this.maskCursor.seek(0L);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        this.sinkBuffer.write(this.messageBuffer, size);
        this.sink.emit();
    }

    public final void writePing(ByteString byteString) throws IOException {
        i.checkNotNullParameter(byteString, "payload");
        writeControlFrame(9, byteString);
    }

    public final void writePong(ByteString byteString) throws IOException {
        i.checkNotNullParameter(byteString, "payload");
        writeControlFrame(10, byteString);
    }
}
