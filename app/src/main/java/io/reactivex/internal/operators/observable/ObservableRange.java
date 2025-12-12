package io.reactivex.internal.operators.observable;

import io.reactivex.internal.observers.BasicIntQueueDisposable;
import ne.k;
import ne.q;

/* loaded from: classes2.dex */
public final class ObservableRange extends k<Integer> {

    /* renamed from: b, reason: collision with root package name */
    public final int f14091b;

    /* renamed from: m, reason: collision with root package name */
    public final long f14092m;

    public static final class RangeDisposable extends BasicIntQueueDisposable<Integer> {
        private static final long serialVersionUID = 396518478098735504L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super Integer> f14093b;

        /* renamed from: m, reason: collision with root package name */
        public final long f14094m;

        /* renamed from: n, reason: collision with root package name */
        public long f14095n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f14096o;

        public RangeDisposable(q<? super Integer> qVar, long j10, long j11) {
            this.f14093b = qVar;
            this.f14095n = j10;
            this.f14094m = j11;
        }

        @Override // ve.f
        public void clear() {
            this.f14095n = this.f14094m;
            lazySet(1);
        }

        @Override // qe.b
        public void dispose() {
            set(1);
        }

        @Override // ve.f
        public boolean isEmpty() {
            return this.f14095n == this.f14094m;
        }

        @Override // ve.c
        public int requestFusion(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            this.f14096o = true;
            return 1;
        }

        @Override // ve.f
        public Integer poll() throws Exception {
            long j10 = this.f14095n;
            if (j10 != this.f14094m) {
                this.f14095n = 1 + j10;
                return Integer.valueOf((int) j10);
            }
            lazySet(1);
            return null;
        }
    }

    public ObservableRange(int i10, int i11) {
        this.f14091b = i10;
        this.f14092m = i10 + i11;
    }

    @Override // ne.k
    public void subscribeActual(q<? super Integer> qVar) {
        q<? super Integer> qVar2;
        RangeDisposable rangeDisposable = new RangeDisposable(qVar, this.f14091b, this.f14092m);
        qVar.onSubscribe(rangeDisposable);
        if (rangeDisposable.f14096o) {
            return;
        }
        long j10 = rangeDisposable.f14095n;
        while (true) {
            long j11 = rangeDisposable.f14094m;
            qVar2 = rangeDisposable.f14093b;
            if (j10 == j11 || rangeDisposable.get() != 0) {
                break;
            }
            qVar2.onNext(Integer.valueOf((int) j10));
            j10++;
        }
        if (rangeDisposable.get() == 0) {
            rangeDisposable.lazySet(1);
            qVar2.onComplete();
        }
    }
}
