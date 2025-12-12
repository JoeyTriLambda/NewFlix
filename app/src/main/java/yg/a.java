package yg;

import com.loopj.android.http.AsyncHttpClient;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;
import zf.i;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f22537a;

    /* renamed from: b, reason: collision with root package name */
    public Socket f22538b;

    public a(boolean z10) {
        this.f22537a = z10;
        Socket socket = this.f22538b;
        if (socket != null) {
            socket.isConnected();
        }
    }

    public final void a(String str, int i10) {
        i.checkNotNullParameter(str, "host");
        if (this.f22538b != null) {
            return;
        }
        try {
            Socket socketCreateSocket = this.f22537a ? SSLSocketFactory.getDefault().createSocket() : new Socket();
            socketCreateSocket.setTcpNoDelay(true);
            socketCreateSocket.setSendBufferSize(65536);
            socketCreateSocket.setReceiveBufferSize(65536);
            i.checkNotNullExpressionValue(socketCreateSocket, "if (secure) {\n          …ize = 64 * 1024\n        }");
            this.f22538b = socketCreateSocket;
            i.checkNotNull(socketCreateSocket);
            socketCreateSocket.connect(new InetSocketAddress(str, i10), AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT);
        } catch (Throwable th2) {
            this.f22538b = null;
            throw th2;
        }
    }
}
