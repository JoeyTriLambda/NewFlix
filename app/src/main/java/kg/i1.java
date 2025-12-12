package kg;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: JobSupport.kt */
/* loaded from: classes2.dex */
public final class i1 extends l1 {

    /* renamed from: q, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f15111q = AtomicIntegerFieldUpdater.newUpdater(i1.class, "_invoked");
    private volatile int _invoked;

    /* renamed from: p, reason: collision with root package name */
    public final yf.l<Throwable, lf.h> f15112p;

    /* JADX WARN: Multi-variable type inference failed */
    public i1(yf.l<? super Throwable, lf.h> lVar) {
        this.f15112p = lVar;
    }

    @Override // yf.l
    public /* bridge */ /* synthetic */ lf.h invoke(Throwable th2) {
        invoke2(th2);
        return lf.h.f16056a;
    }

    @Override // kg.b0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(Throwable th2) {
        if (f15111q.compareAndSet(this, 0, 1)) {
            this.f15112p.invoke(th2);
        }
    }
}
