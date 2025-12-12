package cz.msebera.android.httpclient.conn.scheme;

import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

@Deprecated
/* loaded from: classes2.dex */
class SchemeLayeredSocketFactoryAdaptor2 implements SchemeLayeredSocketFactory {
    private final LayeredSchemeSocketFactory factory;

    public SchemeLayeredSocketFactoryAdaptor2(LayeredSchemeSocketFactory layeredSchemeSocketFactory) {
        this.factory = layeredSchemeSocketFactory;
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory
    public Socket connectSocket(Socket socket, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, HttpParams httpParams) throws IOException {
        return this.factory.connectSocket(socket, inetSocketAddress, inetSocketAddress2, httpParams);
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SchemeLayeredSocketFactory
    public Socket createLayeredSocket(Socket socket, String str, int i10, HttpParams httpParams) throws IOException {
        return this.factory.createLayeredSocket(socket, str, i10, true);
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory
    public Socket createSocket(HttpParams httpParams) throws IOException {
        return this.factory.createSocket(httpParams);
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory
    public boolean isSecure(Socket socket) throws IllegalArgumentException {
        return this.factory.isSecure(socket);
    }
}
