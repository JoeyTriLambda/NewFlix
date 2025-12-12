package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpInetConnection;
import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;
import java.net.Socket;

@Deprecated
/* loaded from: classes2.dex */
public interface OperatedClientConnection extends HttpClientConnection, HttpInetConnection {
    Socket getSocket();

    HttpHost getTargetHost();

    boolean isSecure();

    void openCompleted(boolean z10, HttpParams httpParams) throws IOException;

    void opening(Socket socket, HttpHost httpHost) throws IOException;

    void update(Socket socket, HttpHost httpHost, boolean z10, HttpParams httpParams) throws IOException;
}
