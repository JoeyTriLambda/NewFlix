package cz.msebera.android.httpclient.conn.scheme;

import cz.msebera.android.httpclient.params.BasicHttpParams;
import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

@Deprecated
/* loaded from: classes2.dex */
class SocketFactoryAdaptor implements SocketFactory {
    private final SchemeSocketFactory factory;

    public SocketFactoryAdaptor(SchemeSocketFactory schemeSocketFactory) {
        this.factory = schemeSocketFactory;
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SocketFactory
    public Socket connectSocket(Socket socket, String str, int i10, InetAddress inetAddress, int i11, HttpParams httpParams) throws IOException {
        InetSocketAddress inetSocketAddress;
        if (inetAddress != null || i11 > 0) {
            if (i11 <= 0) {
                i11 = 0;
            }
            inetSocketAddress = new InetSocketAddress(inetAddress, i11);
        } else {
            inetSocketAddress = null;
        }
        return this.factory.connectSocket(socket, new InetSocketAddress(InetAddress.getByName(str), i10), inetSocketAddress, httpParams);
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        return this.factory.createSocket(new BasicHttpParams());
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj instanceof SocketFactoryAdaptor ? this.factory.equals(((SocketFactoryAdaptor) obj).factory) : this.factory.equals(obj);
    }

    public SchemeSocketFactory getFactory() {
        return this.factory;
    }

    public int hashCode() {
        return this.factory.hashCode();
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SocketFactory
    public boolean isSecure(Socket socket) throws IllegalArgumentException {
        return this.factory.isSecure(socket);
    }
}
