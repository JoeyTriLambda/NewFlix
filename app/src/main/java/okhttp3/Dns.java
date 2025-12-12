package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import zf.i;

/* compiled from: Dns.kt */
/* loaded from: classes2.dex */
public interface Dns {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final Dns SYSTEM = new Companion.DnsSystem();

    /* compiled from: Dns.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* compiled from: Dns.kt */
        public static final class DnsSystem implements Dns {
            @Override // okhttp3.Dns
            public List<InetAddress> lookup(String str) throws UnknownHostException {
                i.checkNotNullParameter(str, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(str);
                    i.checkNotNullExpressionValue(allByName, "getAllByName(hostname)");
                    return mf.i.toList(allByName);
                } catch (NullPointerException e10) {
                    UnknownHostException unknownHostException = new UnknownHostException(i.stringPlus("Broken system behaviour for dns lookup of ", str));
                    unknownHostException.initCause(e10);
                    throw unknownHostException;
                }
            }
        }

        private Companion() {
        }
    }

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
