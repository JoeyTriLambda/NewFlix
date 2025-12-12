package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.io.EofSensor;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.Socket;

@Deprecated
/* loaded from: classes2.dex */
public class SocketInputBuffer extends AbstractSessionInputBuffer implements EofSensor {
    private boolean eof;
    private final Socket socket;

    public SocketInputBuffer(Socket socket, int i10, HttpParams httpParams) throws IOException {
        Args.notNull(socket, "Socket");
        this.socket = socket;
        this.eof = false;
        i10 = i10 < 0 ? socket.getReceiveBufferSize() : i10;
        init(socket.getInputStream(), i10 < 1024 ? 1024 : i10, httpParams);
    }

    @Override // cz.msebera.android.httpclient.impl.io.AbstractSessionInputBuffer
    public int fillBuffer() throws IOException {
        int iFillBuffer = super.fillBuffer();
        this.eof = iFillBuffer == -1;
        return iFillBuffer;
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public boolean isDataAvailable(int i10) throws IOException {
        boolean zHasBufferedData = hasBufferedData();
        if (zHasBufferedData) {
            return zHasBufferedData;
        }
        int soTimeout = this.socket.getSoTimeout();
        try {
            this.socket.setSoTimeout(i10);
            fillBuffer();
            return hasBufferedData();
        } finally {
            this.socket.setSoTimeout(soTimeout);
        }
    }

    @Override // cz.msebera.android.httpclient.io.EofSensor
    public boolean isEof() {
        return this.eof;
    }
}
