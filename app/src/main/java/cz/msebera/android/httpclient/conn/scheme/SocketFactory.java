package cz.msebera.android.httpclient.conn.scheme;

import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

@Deprecated
/* loaded from: classes2.dex */
public interface SocketFactory {
    Socket connectSocket(Socket socket, String str, int i10, InetAddress inetAddress, int i11, HttpParams httpParams) throws IOException;

    Socket createSocket() throws IOException;

    boolean isSecure(Socket socket) throws IllegalArgumentException;
}
