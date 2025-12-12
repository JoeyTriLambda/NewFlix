package io.reactivex.internal.operators.observable;

import io.reactivex.internal.observers.BasicIntQueueDisposable;
import ne.k;
import ne.q;

/* loaded from: classes2.dex */
public final class ObservableRangeLong extends k<Long> {

    /* renamed from: b, reason: collision with root package name */
    public final long f14097b;

    /* renamed from: m, reason: collision with root package name */
    public final long f14098m;

    public static final class RangeDisposable extends BasicIntQueueDisposable<Long> {
        private static final long serialVersionUID = 396518478098735504L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super Long> f14099b;

        /* renamed from: m, reason: collision with root package name */
        public final long f14100m;

        /* renamed from: n, reason: collision with root package name */
        public long f14101n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f14102o;

        public RangeDisposable(q<? super Long> qVar, long j10, long j11) {
            this.f14099b = qVar;
            this.f14101n = j10;
            this.f14100m = j11;
        }

        @Override // ve.f
        public void clear() {
            this.f14101n = this.f14100m;
            lazySet(1);
        }

        @Override // qe.b
        public void dispose() {
            set(1);
        }

        @Override // ve.f
        public boolean isEmpty() {
            return this.f14101n == this.f14100m;
        }

        @Override // ve.c
        public int requestFusion(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            this.f14102o = true;
            return 1;
        }

        @Override // ve.f
        public Long poll() throws Exception {
            long j10 = this.f14101n;
            if (j10 != this.f14100m) {
                this.f14101n = 1 + j10;
                return Long.valueOf(j10);
            }
            lazySet(1);
            return null;
        }
    }

    public ObservableRangeLong(long j10, long j11) {
        this.f14097b = j10;
        this.f14098m = j11;
    }

    @Override // ne.k
    public void subscribeActual(q<? super Long> qVar) {
        q<? super Long> qVar2;
        long j10 = this.f14097b;
        RangeDisposable rangeDisposable = new RangeDisposable(qVar, j10, j10 + this.f14098m);
        qVar.onSubscribe(rangeDisposable);
        if (rangeDisposable.f14102o) {
            return;
        }
        long j11 = rangeDisposable.f14101n;
        while (true) {
            long j12 = rangeDisposable.f14100m;
            qVar2 = rangeDisposable.f14099b;
            if (j11 == j12 || rangeDisposable.get() != 0) {
                break;
            }
            qVar2.onNext(Long.valueOf(j11));
            j11++;
        }
        if (rangeDisposable.get() == 0) {
            rangeDisposable.lazySet(1);
            qVar2.onComplete();
        }
    }
}
