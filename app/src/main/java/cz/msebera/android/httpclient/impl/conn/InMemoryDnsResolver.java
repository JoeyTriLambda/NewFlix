package cz.msebera.android.httpclient.impl.conn;

import ac.c;
import cz.msebera.android.httpclient.conn.DnsResolver;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class InMemoryDnsResolver implements DnsResolver {
    public HttpClientAndroidLog log = new HttpClientAndroidLog(InMemoryDnsResolver.class);
    private final Map<String, InetAddress[]> dnsMap = new ConcurrentHashMap();

    public void add(String str, InetAddress... inetAddressArr) {
        Args.notNull(str, "Host name");
        Args.notNull(inetAddressArr, "Array of IP addresses");
        this.dnsMap.put(str, inetAddressArr);
    }

    @Override // cz.msebera.android.httpclient.conn.DnsResolver
    public InetAddress[] resolve(String str) throws UnknownHostException {
        InetAddress[] inetAddressArr = this.dnsMap.get(str);
        if (this.log.isInfoEnabled()) {
            HttpClientAndroidLog httpClientAndroidLog = this.log;
            StringBuilder sbV = c.v("Resolving ", str, " to ");
            sbV.append(Arrays.deepToString(inetAddressArr));
            httpClientAndroidLog.info(sbV.toString());
        }
        if (inetAddressArr != null) {
            return inetAddressArr;
        }
        throw new UnknownHostException(c.B(str, " cannot be resolved"));
    }
}
