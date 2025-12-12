package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpHost;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class ConnectTimeoutException extends InterruptedIOException {
    private static final long serialVersionUID = -4816682903149535989L;
    private final HttpHost host;

    public ConnectTimeoutException() {
        this.host = null;
    }

    public HttpHost getHost() {
        return this.host;
    }

    public ConnectTimeoutException(String str) {
        super(str);
        this.host = null;
    }

    public ConnectTimeoutException(IOException iOException, HttpHost httpHost, InetAddress... inetAddressArr) {
        String str;
        String str2;
        StringBuilder sb2 = new StringBuilder("Connect to ");
        sb2.append(httpHost != null ? httpHost.toHostString() : "remote host");
        if (inetAddressArr == null || inetAddressArr.length <= 0) {
            str = "";
        } else {
            str = StringUtils.SPACE + Arrays.asList(inetAddressArr);
        }
        sb2.append(str);
        if (iOException == null || iOException.getMessage() == null) {
            str2 = " timed out";
        } else {
            str2 = " failed: " + iOException.getMessage();
        }
        sb2.append(str2);
        super(sb2.toString());
        this.host = httpHost;
        initCause(iOException);
    }
}
