package ye;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableBufferBoundarySupplier.java */
/* loaded from: classes2.dex */
public final class j<T, U extends Collection<? super T>, B> extends ye.a<T, U> {

    /* renamed from: m, reason: collision with root package name */
    public final Callable<? extends ne.o<B>> f22184m;

    /* renamed from: n, reason: collision with root package name */
    public final Callable<U> f22185n;

    /* compiled from: ObservableBufferBoundarySupplier.java */
    public static final class a<T, U extends Collection<? super T>, B> extends ef.c<B> {

        /* renamed from: m, reason: collision with root package name */
        public final b<T, U, B> f22186m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f22187n;

        public a(b<T, U, B> bVar) {
            this.f22186m = bVar;
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22187n) {
                return;
            }
            this.f22187n = true;
            this.f22186m.a();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22187n) {
                ff.a.onError(th2);
            } else {
                this.f22187n = true;
                this.f22186m.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(B b10) {
            if (this.f22187n) {
                return;
            }
            this.f22187n = true;
            dispose();
            this.f22186m.a();
        }
    }

    /* compiled from: ObservableBufferBoundarySupplier.java */
    public static final class b<T, U extends Collection<? super T>, B> extends we.j<T, U, U> implements qe.b {

        /* renamed from: r, reason: collision with root package name */
        public final Callable<U> f22188r;

        /* renamed from: s, reason: collision with root package name */
        public final Callable<? extends ne.o<B>> f22189s;

        /* renamed from: t, reason: collision with root package name */
        public qe.b f22190t;

        /* renamed from: u, reason: collision with root package name */
        public final AtomicReference<qe.b> f22191u;

        /* renamed from: v, reason: collision with root package name */
        public U f22192v;

        public b(ef.e eVar, Callable callable, Callable callable2) {
            super(eVar, new MpscLinkedQueue());
            this.f22191u = new AtomicReference<>();
            this.f22188r = callable;
            this.f22189s = callable2;
        }

        public final void a() {
            try {
                U u10 = (U) ue.a.requireNonNull(this.f22188r.call(), "The buffer supplied is null");
                try {
                    ne.o oVar = (ne.o) ue.a.requireNonNull(this.f22189s.call(), "The boundary ObservableSource supplied is null");
                    a aVar = new a(this);
                    if (DisposableHelper.replace(this.f22191u, aVar)) {
                        synchronized (this) {
                            U u11 = this.f22192v;
                            if (u11 == null) {
                                return;
                            }
                            this.f22192v = u10;
                            oVar.subscribe(aVar);
                            fastPathEmit(u11, false, this);
                        }
                    }
                } catch (Throwable th2) {
                    re.a.throwIfFatal(th2);
                    this.f21146o = true;
                    this.f22190t.dispose();
                    this.f21144m.onError(th2);
                }
            } catch (Throwable th3) {
                re.a.throwIfFatal(th3);
                dispose();
                this.f21144m.onError(th3);
            }
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
            this.f22190t.dispose();
            DisposableHelper.dispose(this.f22191u);
            if (enter()) {
                this.f21145n.clear();
            }
        }

        @Override // ne.q
        public void onComplete() {
            synchronized (this) {
                U u10 = this.f22192v;
                if (u10 == null) {
                    return;
                }
                this.f22192v = null;
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
                U u10 = this.f22192v;
                if (u10 == null) {
                    return;
                }
                u10.add(t10);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22190t, bVar)) {
                this.f22190t = bVar;
                ne.q<? super V> qVar = this.f21144m;
                try {
                    this.f22192v = (U) ue.a.requireNonNull(this.f22188r.call(), "The buffer supplied is null");
                    try {
                        ne.o oVar = (ne.o) ue.a.requireNonNull(this.f22189s.call(), "The boundary ObservableSource supplied is null");
                        a aVar = new a(this);
                        this.f22191u.set(aVar);
                        qVar.onSubscribe(this);
                        if (this.f21146o) {
                            return;
                        }
                        oVar.subscribe(aVar);
                    } catch (Throwable th2) {
                        re.a.throwIfFatal(th2);
                        this.f21146o = true;
                        bVar.dispose();
                        EmptyDisposable.error(th2, qVar);
                    }
                } catch (Throwable th3) {
                    re.a.throwIfFatal(th3);
                    this.f21146o = true;
                    bVar.dispose();
                    EmptyDisposable.error(th3, qVar);
                }
            }
        }

        public void accept(ne.q<? super U> qVar, U u10) {
            this.f21144m.onNext(u10);
        }
    }

    public j(ne.o<T> oVar, Callable<? extends ne.o<B>> callable, Callable<U> callable2) {
        super(oVar);
        this.f22184m = callable;
        this.f22185n = callable2;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super U> qVar) {
        this.f22058b.subscribe(new b(new ef.e(qVar), this.f22185n, this.f22184m));
    }
}
