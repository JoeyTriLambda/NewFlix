package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.io.EofSensor;
import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
@Deprecated
/* loaded from: classes2.dex */
public class LoggingSessionInputBuffer implements SessionInputBuffer, EofSensor {
    private final String charset;
    private final EofSensor eofSensor;
    private final SessionInputBuffer in;
    private final Wire wire;

    public LoggingSessionInputBuffer(SessionInputBuffer sessionInputBuffer, Wire wire, String str) {
        this.in = sessionInputBuffer;
        this.eofSensor = sessionInputBuffer instanceof EofSensor ? (EofSensor) sessionInputBuffer : null;
        this.wire = wire;
        this.charset = str == null ? Consts.ASCII.name() : str;
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.in.getMetrics();
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public boolean isDataAvailable(int i10) throws IOException {
        return this.in.isDataAvailable(i10);
    }

    @Override // cz.msebera.android.httpclient.io.EofSensor
    public boolean isEof() {
        EofSensor eofSensor = this.eofSensor;
        if (eofSensor != null) {
            return eofSensor.isEof();
        }
        return false;
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = this.in.read(bArr, i10, i11);
        if (this.wire.enabled() && i12 > 0) {
            this.wire.input(bArr, i10, i12);
        }
        return i12;
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public String readLine() throws IOException {
        String line = this.in.readLine();
        if (this.wire.enabled() && line != null) {
            this.wire.input(line.concat("\r\n").getBytes(this.charset));
        }
        return line;
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public int read() throws IOException {
        int i10 = this.in.read();
        if (this.wire.enabled() && i10 != -1) {
            this.wire.input(i10);
        }
        return i10;
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public int readLine(CharArrayBuffer charArrayBuffer) throws IOException {
        int line = this.in.readLine(charArrayBuffer);
        if (this.wire.enabled() && line >= 0) {
            this.wire.input(new String(charArrayBuffer.buffer(), charArrayBuffer.length() - line, line).concat("\r\n").getBytes(this.charset));
        }
        return line;
    }

    public LoggingSessionInputBuffer(SessionInputBuffer sessionInputBuffer, Wire wire) {
        this(sessionInputBuffer, wire, null);
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public int read(byte[] bArr) throws IOException {
        int i10 = this.in.read(bArr);
        if (this.wire.enabled() && i10 > 0) {
            this.wire.input(bArr, 0, i10);
        }
        return i10;
    }
}
