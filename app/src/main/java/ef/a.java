package ef;

import ef.a;
import io.reactivex.internal.util.VolatileSizeArrayList;
import java.util.concurrent.CountDownLatch;

/* compiled from: BaseTestConsumer.java */
/* loaded from: classes2.dex */
public abstract class a<T, U extends a<T, U>> implements qe.b {

    /* renamed from: o, reason: collision with root package name */
    public boolean f11313o;

    /* renamed from: m, reason: collision with root package name */
    public final VolatileSizeArrayList f11311m = new VolatileSizeArrayList();

    /* renamed from: n, reason: collision with root package name */
    public final VolatileSizeArrayList f11312n = new VolatileSizeArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final CountDownLatch f11310b = new CountDownLatch(1);
}
