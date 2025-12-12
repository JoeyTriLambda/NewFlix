package dg;

import java.util.Random;
import zf.i;

/* compiled from: PlatformRandom.kt */
/* loaded from: classes2.dex */
public final class b extends dg.a {

    /* renamed from: n, reason: collision with root package name */
    public final a f11036n = new a();

    /* compiled from: PlatformRandom.kt */
    public static final class a extends ThreadLocal<Random> {
        @Override // java.lang.ThreadLocal
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // dg.a
    public Random getImpl() {
        Random random = this.f11036n.get();
        i.checkNotNullExpressionValue(random, "implStorage.get()");
        return random;
    }
}
