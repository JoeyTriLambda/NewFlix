package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import ne.k;
import ne.q;
import ne.r;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableTimer extends k<Long> {

    /* renamed from: b, reason: collision with root package name */
    public final r f14388b;

    /* renamed from: m, reason: collision with root package name */
    public final long f14389m;

    /* renamed from: n, reason: collision with root package name */
    public final TimeUnit f14390n;

    public static final class TimerObserver extends AtomicReference<b> implements b, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super Long> f14391b;

        public TimerObserver(q<? super Long> qVar) {
            this.f14391b = qVar;
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
            q<? super Long> qVar = this.f14391b;
            qVar.onNext(0L);
            lazySet(EmptyDisposable.INSTANCE);
            qVar.onComplete();
        }

        public void setResource(b bVar) {
            DisposableHelper.trySet(this, bVar);
        }
    }

    public ObservableTimer(long j10, TimeUnit timeUnit, r rVar) {
        this.f14389m = j10;
        this.f14390n = timeUnit;
        this.f14388b = rVar;
    }

    @Override // ne.k
    public void subscribeActual(q<? super Long> qVar) {
        TimerObserver timerObserver = new TimerObserver(qVar);
        qVar.onSubscribe(timerObserver);
        timerObserver.setResource(this.f14388b.scheduleDirect(timerObserver, this.f14389m, this.f14390n));
    }
}
