package cz.msebera.android.httpclient.cookie;

import ac.c;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.TextUtils;
import java.util.Locale;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes2.dex */
public final class CookieOrigin {
    private final String host;
    private final String path;
    private final int port;
    private final boolean secure;

    public CookieOrigin(String str, int i10, String str2, boolean z10) {
        Args.notBlank(str, "Host");
        Args.notNegative(i10, "Port");
        Args.notNull(str2, "Path");
        this.host = str.toLowerCase(Locale.ROOT);
        this.port = i10;
        if (TextUtils.isBlank(str2)) {
            this.path = "/";
        } else {
            this.path = str2;
        }
        this.secure = z10;
    }

    public String getHost() {
        return this.host;
    }

    public String getPath() {
        return this.path;
    }

    public int getPort() {
        return this.port;
    }

    public boolean isSecure() {
        return this.secure;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        if (this.secure) {
            sb2.append("(secure)");
        }
        sb2.append(this.host);
        sb2.append(':');
        sb2.append(Integer.toString(this.port));
        return c.n(sb2, this.path, ']');
    }
}
