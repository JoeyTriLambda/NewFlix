package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import ne.o;
import ne.q;
import ne.r;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableTakeLastTimed<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final long f14303m;

    /* renamed from: n, reason: collision with root package name */
    public final long f14304n;

    /* renamed from: o, reason: collision with root package name */
    public final TimeUnit f14305o;

    /* renamed from: p, reason: collision with root package name */
    public final r f14306p;

    /* renamed from: q, reason: collision with root package name */
    public final int f14307q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f14308r;

    public static final class TakeLastTimedObserver<T> extends AtomicBoolean implements q<T>, b {
        private static final long serialVersionUID = -5677354903406201275L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14309b;

        /* renamed from: m, reason: collision with root package name */
        public final long f14310m;

        /* renamed from: n, reason: collision with root package name */
        public final long f14311n;

        /* renamed from: o, reason: collision with root package name */
        public final TimeUnit f14312o;

        /* renamed from: p, reason: collision with root package name */
        public final r f14313p;

        /* renamed from: q, reason: collision with root package name */
        public final af.a<Object> f14314q;

        /* renamed from: r, reason: collision with root package name */
        public final boolean f14315r;

        /* renamed from: s, reason: collision with root package name */
        public b f14316s;

        /* renamed from: t, reason: collision with root package name */
        public volatile boolean f14317t;

        /* renamed from: u, reason: collision with root package name */
        public Throwable f14318u;

        public TakeLastTimedObserver(int i10, long j10, long j11, q qVar, r rVar, TimeUnit timeUnit, boolean z10) {
            this.f14309b = qVar;
            this.f14310m = j10;
            this.f14311n = j11;
            this.f14312o = timeUnit;
            this.f14313p = rVar;
            this.f14314q = new af.a<>(i10);
            this.f14315r = z10;
        }

        public final void a() {
            Throwable th2;
            if (compareAndSet(false, true)) {
                q<? super T> qVar = this.f14309b;
                af.a<Object> aVar = this.f14314q;
                boolean z10 = this.f14315r;
                long jNow = this.f14313p.now(this.f14312o) - this.f14311n;
                while (!this.f14317t) {
                    if (!z10 && (th2 = this.f14318u) != null) {
                        aVar.clear();
                        qVar.onError(th2);
                        return;
                    }
                    Object objPoll = aVar.poll();
                    if (objPoll == null) {
                        Throwable th3 = this.f14318u;
                        if (th3 != null) {
                            qVar.onError(th3);
                            return;
                        } else {
                            qVar.onComplete();
                            return;
                        }
                    }
                    Object objPoll2 = aVar.poll();
                    if (((Long) objPoll).longValue() >= jNow) {
                        qVar.onNext(objPoll2);
                    }
                }
                aVar.clear();
            }
        }

        @Override // qe.b
        public void dispose() {
            if (this.f14317t) {
                return;
            }
            this.f14317t = true;
            this.f14316s.dispose();
            if (compareAndSet(false, true)) {
                this.f14314q.clear();
            }
        }

        @Override // ne.q
        public void onComplete() {
            a();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f14318u = th2;
            a();
        }

        @Override // ne.q
        public void onNext(T t10) {
            long jNow = this.f14313p.now(this.f14312o);
            long j10 = this.f14310m;
            boolean z10 = j10 == Long.MAX_VALUE;
            Long lValueOf = Long.valueOf(jNow);
            af.a<Object> aVar = this.f14314q;
            aVar.offer(lValueOf, t10);
            while (!aVar.isEmpty()) {
                if (((Long) aVar.peek()).longValue() > jNow - this.f14311n && (z10 || (aVar.size() >> 1) <= j10)) {
                    return;
                }
                aVar.poll();
                aVar.poll();
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f14316s, bVar)) {
                this.f14316s = bVar;
                this.f14309b.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLastTimed(o<T> oVar, long j10, long j11, TimeUnit timeUnit, r rVar, int i10, boolean z10) {
        super(oVar);
        this.f14303m = j10;
        this.f14304n = j11;
        this.f14305o = timeUnit;
        this.f14306p = rVar;
        this.f14307q = i10;
        this.f14308r = z10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        long j10 = this.f14303m;
        long j11 = this.f14304n;
        TimeUnit timeUnit = this.f14305o;
        this.f22058b.subscribe(new TakeLastTimedObserver(this.f14307q, j10, j11, qVar, this.f14306p, timeUnit, this.f14308r));
    }
}
