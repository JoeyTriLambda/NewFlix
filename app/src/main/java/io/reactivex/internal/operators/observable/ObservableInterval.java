package io.reactivex.internal.operators.observable;

import bf.g;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import ne.k;
import ne.q;
import ne.r;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableInterval extends k<Long> {

    /* renamed from: b, reason: collision with root package name */
    public final r f13988b;

    /* renamed from: m, reason: collision with root package name */
    public final long f13989m;

    /* renamed from: n, reason: collision with root package name */
    public final long f13990n;

    /* renamed from: o, reason: collision with root package name */
    public final TimeUnit f13991o;

    public static final class IntervalObserver extends AtomicReference<b> implements b, Runnable {
        private static final long serialVersionUID = 346773832286157679L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super Long> f13992b;

        /* renamed from: m, reason: collision with root package name */
        public long f13993m;

        public IntervalObserver(q<? super Long> qVar) {
            this.f13992b = qVar;
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() != DisposableHelper.f13533b) {
                long j10 = this.f13993m;
                this.f13993m = 1 + j10;
                this.f13992b.onNext(Long.valueOf(j10));
            }
        }

        public void setResource(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public ObservableInterval(long j10, long j11, TimeUnit timeUnit, r rVar) {
        this.f13989m = j10;
        this.f13990n = j11;
        this.f13991o = timeUnit;
        this.f13988b = rVar;
    }

    @Override // ne.k
    public void subscribeActual(q<? super Long> qVar) {
        IntervalObserver intervalObserver = new IntervalObserver(qVar);
        qVar.onSubscribe(intervalObserver);
        r rVar = this.f13988b;
        if (!(rVar instanceof g)) {
            intervalObserver.setResource(rVar.schedulePeriodicallyDirect(intervalObserver, this.f13989m, this.f13990n, this.f13991o));
            return;
        }
        r.c cVarCreateWorker = rVar.createWorker();
        intervalObserver.setResource(cVarCreateWorker);
        cVarCreateWorker.schedulePeriodically(intervalObserver, this.f13989m, this.f13990n, this.f13991o);
    }
}
