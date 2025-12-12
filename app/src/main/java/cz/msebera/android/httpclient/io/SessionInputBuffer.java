package cz.msebera.android.httpclient.io;

import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

/* loaded from: classes2.dex */
public interface SessionInputBuffer {
    HttpTransportMetrics getMetrics();

    @Deprecated
    boolean isDataAvailable(int i10) throws IOException;

    int read() throws IOException;

    int read(byte[] bArr) throws IOException;

    int read(byte[] bArr, int i10, int i11) throws IOException;

    int readLine(CharArrayBuffer charArrayBuffer) throws IOException;

    String readLine() throws IOException;
}
