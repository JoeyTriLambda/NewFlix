package cz.msebera.android.httpclient.impl.conn;

import ac.c;
import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
@Deprecated
/* loaded from: classes2.dex */
public class LoggingSessionOutputBuffer implements SessionOutputBuffer {
    private final String charset;
    private final SessionOutputBuffer out;
    private final Wire wire;

    public LoggingSessionOutputBuffer(SessionOutputBuffer sessionOutputBuffer, Wire wire, String str) {
        this.out = sessionOutputBuffer;
        this.wire = wire;
        this.charset = str == null ? Consts.ASCII.name() : str;
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.out.getMetrics();
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.out.write(bArr, i10, i11);
        if (this.wire.enabled()) {
            this.wire.output(bArr, i10, i11);
        }
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void writeLine(CharArrayBuffer charArrayBuffer) throws IOException {
        this.out.writeLine(charArrayBuffer);
        if (this.wire.enabled()) {
            this.wire.output(new String(charArrayBuffer.buffer(), 0, charArrayBuffer.length()).concat("\r\n").getBytes(this.charset));
        }
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void write(int i10) throws IOException {
        this.out.write(i10);
        if (this.wire.enabled()) {
            this.wire.output(i10);
        }
    }

    public LoggingSessionOutputBuffer(SessionOutputBuffer sessionOutputBuffer, Wire wire) {
        this(sessionOutputBuffer, wire, null);
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void writeLine(String str) throws IOException {
        this.out.writeLine(str);
        if (this.wire.enabled()) {
            this.wire.output(c.B(str, "\r\n").getBytes(this.charset));
        }
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void write(byte[] bArr) throws IOException {
        this.out.write(bArr);
        if (this.wire.enabled()) {
            this.wire.output(bArr);
        }
    }
}
