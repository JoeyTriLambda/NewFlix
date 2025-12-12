package ye;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: ObservableBufferExactBoundary.java */
/* loaded from: classes2.dex */
public final class k<T, U extends Collection<? super T>, B> extends ye.a<T, U> {

    /* renamed from: m, reason: collision with root package name */
    public final ne.o<B> f22199m;

    /* renamed from: n, reason: collision with root package name */
    public final Callable<U> f22200n;

    /* compiled from: ObservableBufferExactBoundary.java */
    public static final class a<T, U extends Collection<? super T>, B> extends ef.c<B> {

        /* renamed from: m, reason: collision with root package name */
        public final b<T, U, B> f22201m;

        public a(b<T, U, B> bVar) {
            this.f22201m = bVar;
        }

        @Override // ne.q
        public void onComplete() {
            this.f22201m.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f22201m.onError(th2);
        }

        @Override // ne.q
        public void onNext(B b10) {
            b<T, U, B> bVar = this.f22201m;
            bVar.getClass();
            try {
                U u10 = (U) ue.a.requireNonNull(bVar.f22202r.call(), "The buffer supplied is null");
                synchronized (bVar) {
                    U u11 = bVar.f22206v;
                    if (u11 != null) {
                        bVar.f22206v = u10;
                        bVar.fastPathEmit(u11, false, bVar);
                    }
                }
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                bVar.dispose();
                bVar.f21144m.onError(th2);
            }
        }
    }

    /* compiled from: ObservableBufferExactBoundary.java */
    public static final class b<T, U extends Collection<? super T>, B> extends we.j<T, U, U> implements qe.b {

        /* renamed from: r, reason: collision with root package name */
        public final Callable<U> f22202r;

        /* renamed from: s, reason: collision with root package name */
        public final ne.o<B> f22203s;

        /* renamed from: t, reason: collision with root package name */
        public qe.b f22204t;

        /* renamed from: u, reason: collision with root package name */
        public a f22205u;

        /* renamed from: v, reason: collision with root package name */
        public U f22206v;

        public b(ef.e eVar, Callable callable, ne.o oVar) {
            super(eVar, new MpscLinkedQueue());
            this.f22202r = callable;
            this.f22203s = oVar;
        }

        @Override // we.j, cf.g
        public /* bridge */ /* synthetic */ void accept(ne.q qVar, Object obj) {
            accept((ne.q<? super ne.q>) qVar, (ne.q) obj);
        }

        @Override // qe.b
        public void dispose() {
            if (this.f21146o) {
                return;
            }
            this.f21146o = true;
            this.f22205u.dispose();
            this.f22204t.dispose();
            if (enter()) {
                this.f21145n.clear();
            }
        }

        @Override // ne.q
        public void onComplete() {
            synchronized (this) {
                U u10 = this.f22206v;
                if (u10 == null) {
                    return;
                }
                this.f22206v = null;
                this.f21145n.offer(u10);
                this.f21147p = true;
                if (enter()) {
                    cf.j.drainLoop(this.f21145n, this.f21144m, false, this, this);
                }
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            dispose();
            this.f21144m.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            synchronized (this) {
                U u10 = this.f22206v;
                if (u10 == null) {
                    return;
                }
                u10.add(t10);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22204t, bVar)) {
                this.f22204t = bVar;
                try {
                    this.f22206v = (U) ue.a.requireNonNull(this.f22202r.call(), "The buffer supplied is null");
                    a aVar = new a(this);
                    this.f22205u = aVar;
                    this.f21144m.onSubscribe(this);
                    if (this.f21146o) {
                        return;
                    }
                    this.f22203s.subscribe(aVar);
                } catch (Throwable th2) {
                    re.a.throwIfFatal(th2);
                    this.f21146o = true;
                    bVar.dispose();
                    EmptyDisposable.error(th2, this.f21144m);
                }
            }
        }

        public void accept(ne.q<? super U> qVar, U u10) {
            this.f21144m.onNext(u10);
        }
    }

    public k(ne.o<T> oVar, ne.o<B> oVar2, Callable<U> callable) {
        super(oVar);
        this.f22199m = oVar2;
        this.f22200n = callable;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super U> qVar) {
        this.f22058b.subscribe(new b(new ef.e(qVar), this.f22200n, this.f22199m));
    }
}
