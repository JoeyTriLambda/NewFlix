package kg;

import kotlinx.coroutines.TimeoutKt;

/* compiled from: Timeout.kt */
/* loaded from: classes2.dex */
public final class j2<U, T extends U> extends pg.x<T> implements Runnable {

    /* renamed from: p, reason: collision with root package name */
    public final long f15117p;

    public j2(long j10, qf.c<? super U> cVar) {
        super(cVar.getContext(), cVar);
        this.f15117p = j10;
    }

    @Override // kg.a, kg.r1
    public String nameString$kotlinx_coroutines_core() {
        return super.nameString$kotlinx_coroutines_core() + "(timeMillis=" + this.f15117p + ')';
    }

    @Override // java.lang.Runnable
    public void run() {
        cancelCoroutine(TimeoutKt.TimeoutCancellationException(this.f15117p, m0.getDelay(getContext()), this));
    }
}
