package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import lf.a;
import zf.i;

/* compiled from: RouteException.kt */
/* loaded from: classes2.dex */
public final class RouteException extends RuntimeException {
    private final IOException firstConnectException;
    private IOException lastConnectException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteException(IOException iOException) {
        super(iOException);
        i.checkNotNullParameter(iOException, "firstConnectException");
        this.firstConnectException = iOException;
        this.lastConnectException = iOException;
    }

    public final void addConnectException(IOException iOException) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        i.checkNotNullParameter(iOException, "e");
        a.addSuppressed(this.firstConnectException, iOException);
        this.lastConnectException = iOException;
    }

    public final IOException getFirstConnectException() {
        return this.firstConnectException;
    }

    public final IOException getLastConnectException() {
        return this.lastConnectException;
    }
}
