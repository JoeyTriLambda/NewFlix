package ah;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* compiled from: JvmOkio.kt */
/* loaded from: classes2.dex */
public final class x extends a {

    /* renamed from: a, reason: collision with root package name */
    public final Socket f733a;

    public x(Socket socket) {
        zf.i.checkNotNullParameter(socket, "socket");
        this.f733a = socket;
    }

    @Override // ah.a
    public IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // ah.a
    public void timedOut() throws IOException {
        Socket socket = this.f733a;
        try {
            socket.close();
        } catch (AssertionError e10) {
            if (!m.isAndroidGetsocknameError(e10)) {
                throw e10;
            }
            n.f704a.log(Level.WARNING, zf.i.stringPlus("Failed to close timed out socket ", socket), (Throwable) e10);
        } catch (Exception e11) {
            n.f704a.log(Level.WARNING, zf.i.stringPlus("Failed to close timed out socket ", socket), (Throwable) e11);
        }
    }
}
