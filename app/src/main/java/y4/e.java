package y4;

import com.google.auto.value.AutoValue;
import com.loopj.android.http.AsyncHttpClient;

/* compiled from: EventStoreConfig.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final a f21869a;

    static {
        Long l10 = 10485760L;
        Integer num = 200;
        Integer numValueOf = Integer.valueOf(AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT);
        Long l11 = 604800000L;
        Integer num2 = 81920;
        String strB = l10 == null ? " maxStorageSizeInBytes" : "";
        if (num == null) {
            strB = strB.concat(" loadBatchSize");
        }
        if (numValueOf == null) {
            strB = ac.c.B(strB, " criticalSectionEnterTimeoutMs");
        }
        if (l11 == null) {
            strB = ac.c.B(strB, " eventCleanUpAge");
        }
        if (num2 == null) {
            strB = ac.c.B(strB, " maxBlobByteSizePerRow");
        }
        if (!strB.isEmpty()) {
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }
        f21869a = new a(l10.longValue(), num.intValue(), numValueOf.intValue(), l11.longValue(), num2.intValue());
    }

    public abstract int a();

    public abstract long b();

    public abstract int c();

    public abstract int d();

    public abstract long e();
}
