package cz.msebera.android.httpclient.conn.socket;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public class PlainConnectionSocketFactory implements ConnectionSocketFactory {
    public static final PlainConnectionSocketFactory INSTANCE = new PlainConnectionSocketFactory();

    public static PlainConnectionSocketFactory getSocketFactory() {
        return INSTANCE;
    }

    @Override // cz.msebera.android.httpclient.conn.socket.ConnectionSocketFactory
    public Socket connectSocket(int i10, Socket socket, HttpHost httpHost, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, HttpContext httpContext) throws IOException {
        if (socket == null) {
            socket = createSocket(httpContext);
        }
        if (inetSocketAddress2 != null) {
            socket.bind(inetSocketAddress2);
        }
        try {
            socket.connect(inetSocketAddress, i10);
            return socket;
        } catch (IOException e10) {
            try {
                socket.close();
            } catch (IOException unused) {
            }
            throw e10;
        }
    }

    @Override // cz.msebera.android.httpclient.conn.socket.ConnectionSocketFactory
    public Socket createSocket(HttpContext httpContext) throws IOException {
        return new Socket();
    }
}
