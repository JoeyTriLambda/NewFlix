package kg;

import java.util.concurrent.Future;

/* compiled from: Future.kt */
/* loaded from: classes2.dex */
public final class i extends j {

    /* renamed from: b, reason: collision with root package name */
    public final Future<?> f15110b;

    public i(Future<?> future) {
        this.f15110b = future;
    }

    @Override // yf.l
    public /* bridge */ /* synthetic */ lf.h invoke(Throwable th2) {
        invoke2(th2);
        return lf.h.f16056a;
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.f15110b + ']';
    }

    @Override // kg.k
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(Throwable th2) {
        if (th2 != null) {
            this.f15110b.cancel(false);
        }
    }
}
