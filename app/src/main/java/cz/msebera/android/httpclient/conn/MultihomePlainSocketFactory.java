package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.conn.scheme.SocketFactory;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
@Deprecated
/* loaded from: classes2.dex */
public final class MultihomePlainSocketFactory implements SocketFactory {
    private static final MultihomePlainSocketFactory DEFAULT_FACTORY = new MultihomePlainSocketFactory();

    private MultihomePlainSocketFactory() {
    }

    public static MultihomePlainSocketFactory getSocketFactory() {
        return DEFAULT_FACTORY;
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SocketFactory
    public Socket connectSocket(Socket socket, String str, int i10, InetAddress inetAddress, int i11, HttpParams httpParams) throws IOException {
        Args.notNull(str, "Target host");
        Args.notNull(httpParams, "HTTP parameters");
        if (socket == null) {
            socket = createSocket();
        }
        if (inetAddress != null || i11 > 0) {
            if (i11 <= 0) {
                i11 = 0;
            }
            socket.bind(new InetSocketAddress(inetAddress, i11));
        }
        int connectionTimeout = HttpConnectionParams.getConnectionTimeout(httpParams);
        InetAddress[] allByName = InetAddress.getAllByName(str);
        ArrayList arrayList = new ArrayList(allByName.length);
        arrayList.addAll(Arrays.asList(allByName));
        Collections.shuffle(arrayList);
        Iterator it = arrayList.iterator();
        IOException iOException = null;
        while (it.hasNext()) {
            InetAddress inetAddress2 = (InetAddress) it.next();
            try {
                socket.connect(new InetSocketAddress(inetAddress2, i10), connectionTimeout);
                break;
            } catch (SocketTimeoutException unused) {
                throw new ConnectTimeoutException("Connect to " + inetAddress2 + " timed out");
            } catch (IOException e10) {
                iOException = e10;
                socket = new Socket();
            }
        }
        if (iOException == null) {
            return socket;
        }
        throw iOException;
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SocketFactory
    public Socket createSocket() {
        return new Socket();
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SocketFactory
    public final boolean isSecure(Socket socket) throws IllegalArgumentException {
        Args.notNull(socket, "Socket");
        Asserts.check(!socket.isClosed(), "Socket is closed");
        return false;
    }
}
