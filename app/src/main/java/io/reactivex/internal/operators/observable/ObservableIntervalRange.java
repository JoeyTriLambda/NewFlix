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
public final class ObservableIntervalRange extends k<Long> {

    /* renamed from: b, reason: collision with root package name */
    public final r f13994b;

    /* renamed from: m, reason: collision with root package name */
    public final long f13995m;

    /* renamed from: n, reason: collision with root package name */
    public final long f13996n;

    /* renamed from: o, reason: collision with root package name */
    public final long f13997o;

    /* renamed from: p, reason: collision with root package name */
    public final long f13998p;

    /* renamed from: q, reason: collision with root package name */
    public final TimeUnit f13999q;

    public static final class IntervalRangeObserver extends AtomicReference<b> implements b, Runnable {
        private static final long serialVersionUID = 1891866368734007884L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super Long> f14000b;

        /* renamed from: m, reason: collision with root package name */
        public final long f14001m;

        /* renamed from: n, reason: collision with root package name */
        public long f14002n;

        public IntervalRangeObserver(q<? super Long> qVar, long j10, long j11) {
            this.f14000b = qVar;
            this.f14002n = j10;
            this.f14001m = j11;
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.f13533b;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (isDisposed()) {
                return;
            }
            long j10 = this.f14002n;
            Long lValueOf = Long.valueOf(j10);
            q<? super Long> qVar = this.f14000b;
            qVar.onNext(lValueOf);
            if (j10 != this.f14001m) {
                this.f14002n = j10 + 1;
            } else {
                DisposableHelper.dispose(this);
                qVar.onComplete();
            }
        }

        public void setResource(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public ObservableIntervalRange(long j10, long j11, long j12, long j13, TimeUnit timeUnit, r rVar) {
        this.f13997o = j12;
        this.f13998p = j13;
        this.f13999q = timeUnit;
        this.f13994b = rVar;
        this.f13995m = j10;
        this.f13996n = j11;
    }

    @Override // ne.k
    public void subscribeActual(q<? super Long> qVar) {
        IntervalRangeObserver intervalRangeObserver = new IntervalRangeObserver(qVar, this.f13995m, this.f13996n);
        qVar.onSubscribe(intervalRangeObserver);
        r rVar = this.f13994b;
        if (!(rVar instanceof g)) {
            intervalRangeObserver.setResource(rVar.schedulePeriodicallyDirect(intervalRangeObserver, this.f13997o, this.f13998p, this.f13999q));
            return;
        }
        r.c cVarCreateWorker = rVar.createWorker();
        intervalRangeObserver.setResource(cVarCreateWorker);
        cVarCreateWorker.schedulePeriodically(intervalRangeObserver, this.f13997o, this.f13998p, this.f13999q);
    }
}
