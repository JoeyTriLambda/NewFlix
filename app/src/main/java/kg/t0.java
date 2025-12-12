package kg;

import java.util.concurrent.Future;

/* compiled from: Executors.kt */
/* loaded from: classes2.dex */
public final class t0 implements u0 {

    /* renamed from: b, reason: collision with root package name */
    public final Future<?> f15152b;

    public t0(Future<?> future) {
        this.f15152b = future;
    }

    @Override // kg.u0
    public void dispose() {
        this.f15152b.cancel(false);
    }

    public String toString() {
        return "DisposableFutureHandle[" + this.f15152b + ']';
    }
}
