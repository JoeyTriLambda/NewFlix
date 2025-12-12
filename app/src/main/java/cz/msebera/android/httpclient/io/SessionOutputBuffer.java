package cz.msebera.android.httpclient.io;

import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

/* loaded from: classes2.dex */
public interface SessionOutputBuffer {
    void flush() throws IOException;

    HttpTransportMetrics getMetrics();

    void write(int i10) throws IOException;

    void write(byte[] bArr) throws IOException;

    void write(byte[] bArr, int i10, int i11) throws IOException;

    void writeLine(CharArrayBuffer charArrayBuffer) throws IOException;

    void writeLine(String str) throws IOException;
}
