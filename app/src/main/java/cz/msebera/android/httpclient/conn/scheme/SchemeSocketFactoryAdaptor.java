package cz.msebera.android.httpclient.conn.scheme;

import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

@Deprecated
/* loaded from: classes2.dex */
class SchemeSocketFactoryAdaptor implements SchemeSocketFactory {
    private final SocketFactory factory;

    public SchemeSocketFactoryAdaptor(SocketFactory socketFactory) {
        this.factory = socketFactory;
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory
    public Socket connectSocket(Socket socket, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, HttpParams httpParams) throws IOException {
        InetAddress address;
        int port;
        String hostName = inetSocketAddress.getHostName();
        int port2 = inetSocketAddress.getPort();
        if (inetSocketAddress2 != null) {
            address = inetSocketAddress2.getAddress();
            port = inetSocketAddress2.getPort();
        } else {
            address = null;
            port = 0;
        }
        return this.factory.connectSocket(socket, hostName, port2, address, port, httpParams);
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory
    public Socket createSocket(HttpParams httpParams) throws IOException {
        return this.factory.createSocket();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj instanceof SchemeSocketFactoryAdaptor ? this.factory.equals(((SchemeSocketFactoryAdaptor) obj).factory) : this.factory.equals(obj);
    }

    public SocketFactory getFactory() {
        return this.factory;
    }

    public int hashCode() {
        return this.factory.hashCode();
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory
    public boolean isSecure(Socket socket) throws IllegalArgumentException {
        return this.factory.isSecure(socket);
    }
}
