package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpHost;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class HttpHostConnectException extends ConnectException {
    private static final long serialVersionUID = -3194482710275220224L;
    private final HttpHost host;

    @Deprecated
    public HttpHostConnectException(HttpHost httpHost, ConnectException connectException) {
        this(connectException, httpHost, null);
    }

    public HttpHost getHost() {
        return this.host;
    }

    public HttpHostConnectException(IOException iOException, HttpHost httpHost, InetAddress... inetAddressArr) {
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
            str2 = " refused";
        } else {
            str2 = " failed: " + iOException.getMessage();
        }
        sb2.append(str2);
        super(sb2.toString());
        this.host = httpHost;
        initCause(iOException);
    }
}
