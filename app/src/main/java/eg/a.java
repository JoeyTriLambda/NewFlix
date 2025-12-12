package eg;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import zf.i;

/* compiled from: PlatformThreadLocalRandom.kt */
/* loaded from: classes2.dex */
public final class a extends dg.a {
    @Override // dg.a
    public Random getImpl() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        i.checkNotNullExpressionValue(threadLocalRandomCurrent, "current()");
        return threadLocalRandomCurrent;
    }
}
