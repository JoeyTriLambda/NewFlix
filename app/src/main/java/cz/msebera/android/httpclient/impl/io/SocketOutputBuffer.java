package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.Socket;

@Deprecated
/* loaded from: classes2.dex */
public class SocketOutputBuffer extends AbstractSessionOutputBuffer {
    public SocketOutputBuffer(Socket socket, int i10, HttpParams httpParams) throws IOException {
        Args.notNull(socket, "Socket");
        i10 = i10 < 0 ? socket.getSendBufferSize() : i10;
        init(socket.getOutputStream(), i10 < 1024 ? 1024 : i10, httpParams);
    }
}
