package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import ne.o;
import ne.q;
import ne.r;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableSkipLastTimed<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final long f14259m;

    /* renamed from: n, reason: collision with root package name */
    public final TimeUnit f14260n;

    /* renamed from: o, reason: collision with root package name */
    public final r f14261o;

    /* renamed from: p, reason: collision with root package name */
    public final int f14262p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f14263q;

    public static final class SkipLastTimedObserver<T> extends AtomicInteger implements q<T>, b {
        private static final long serialVersionUID = -5677354903406201275L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14264b;

        /* renamed from: m, reason: collision with root package name */
        public final long f14265m;

        /* renamed from: n, reason: collision with root package name */
        public final TimeUnit f14266n;

        /* renamed from: o, reason: collision with root package name */
        public final r f14267o;

        /* renamed from: p, reason: collision with root package name */
        public final af.a<Object> f14268p;

        /* renamed from: q, reason: collision with root package name */
        public final boolean f14269q;

        /* renamed from: r, reason: collision with root package name */
        public b f14270r;

        /* renamed from: s, reason: collision with root package name */
        public volatile boolean f14271s;

        /* renamed from: t, reason: collision with root package name */
        public volatile boolean f14272t;

        /* renamed from: u, reason: collision with root package name */
        public Throwable f14273u;

        public SkipLastTimedObserver(q<? super T> qVar, long j10, TimeUnit timeUnit, r rVar, int i10, boolean z10) {
            this.f14264b = qVar;
            this.f14265m = j10;
            this.f14266n = timeUnit;
            this.f14267o = rVar;
            this.f14268p = new af.a<>(i10);
            this.f14269q = z10;
        }

        public final void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            q<? super T> qVar = this.f14264b;
            af.a<Object> aVar = this.f14268p;
            boolean z10 = this.f14269q;
            TimeUnit timeUnit = this.f14266n;
            r rVar = this.f14267o;
            long j10 = this.f14265m;
            int iAddAndGet = 1;
            while (!this.f14271s) {
                boolean z11 = this.f14272t;
                Long l10 = (Long) aVar.peek();
                boolean z12 = l10 == null;
                long jNow = rVar.now(timeUnit);
                if (!z12 && l10.longValue() > jNow - j10) {
                    z12 = true;
                }
                if (z11) {
                    if (!z10) {
                        Throwable th2 = this.f14273u;
                        if (th2 != null) {
                            this.f14268p.clear();
                            qVar.onError(th2);
                            return;
                        } else if (z12) {
                            qVar.onComplete();
                            return;
                        }
                    } else if (z12) {
                        Throwable th3 = this.f14273u;
                        if (th3 != null) {
                            qVar.onError(th3);
                            return;
                        } else {
                            qVar.onComplete();
                            return;
                        }
                    }
                }
                if (z12) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    aVar.poll();
                    qVar.onNext(aVar.poll());
                }
            }
            this.f14268p.clear();
        }

        @Override // qe.b
        public void dispose() {
            if (this.f14271s) {
                return;
            }
            this.f14271s = true;
            this.f14270r.dispose();
            if (getAndIncrement() == 0) {
                this.f14268p.clear();
            }
        }

        @Override // ne.q
        public void onComplete() {
            this.f14272t = true;
            a();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f14273u = th2;
            this.f14272t = true;
            a();
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f14268p.offer(Long.valueOf(this.f14267o.now(this.f14266n)), t10);
            a();
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f14270r, bVar)) {
                this.f14270r = bVar;
                this.f14264b.onSubscribe(this);
            }
        }
    }

    public ObservableSkipLastTimed(o<T> oVar, long j10, TimeUnit timeUnit, r rVar, int i10, boolean z10) {
        super(oVar);
        this.f14259m = j10;
        this.f14260n = timeUnit;
        this.f14261o = rVar;
        this.f14262p = i10;
        this.f14263q = z10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        this.f22058b.subscribe(new SkipLastTimedObserver(qVar, this.f14259m, this.f14260n, this.f14261o, this.f14262p, this.f14263q));
    }
}
