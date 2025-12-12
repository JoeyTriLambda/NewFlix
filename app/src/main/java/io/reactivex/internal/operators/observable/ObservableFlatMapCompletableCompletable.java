package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.c;
import ne.k;
import ne.o;
import ne.q;
import qe.b;
import se.n;

/* loaded from: classes2.dex */
public final class ObservableFlatMapCompletableCompletable<T> extends ne.a implements ve.a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final o<T> f13906a;

    /* renamed from: b, reason: collision with root package name */
    public final n<? super T, ? extends c> f13907b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f13908c;

    public static final class FlatMapCompletableMainObserver<T> extends AtomicInteger implements b, q<T> {
        private static final long serialVersionUID = 8443155186132538303L;

        /* renamed from: b, reason: collision with root package name */
        public final ne.b f13909b;

        /* renamed from: n, reason: collision with root package name */
        public final n<? super T, ? extends c> f13911n;

        /* renamed from: o, reason: collision with root package name */
        public final boolean f13912o;

        /* renamed from: q, reason: collision with root package name */
        public b f13914q;

        /* renamed from: r, reason: collision with root package name */
        public volatile boolean f13915r;

        /* renamed from: m, reason: collision with root package name */
        public final AtomicThrowable f13910m = new AtomicThrowable();

        /* renamed from: p, reason: collision with root package name */
        public final qe.a f13913p = new qe.a();

        public final class InnerObserver extends AtomicReference<b> implements ne.b, b {
            private static final long serialVersionUID = 8606673141535671828L;

            public InnerObserver() {
            }

            @Override // qe.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // ne.b
            public void onComplete() {
                FlatMapCompletableMainObserver flatMapCompletableMainObserver = FlatMapCompletableMainObserver.this;
                flatMapCompletableMainObserver.f13913p.delete(this);
                flatMapCompletableMainObserver.onComplete();
            }

            @Override // ne.b
            public void onError(Throwable th2) {
                FlatMapCompletableMainObserver flatMapCompletableMainObserver = FlatMapCompletableMainObserver.this;
                flatMapCompletableMainObserver.f13913p.delete(this);
                flatMapCompletableMainObserver.onError(th2);
            }

            @Override // ne.b
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        public FlatMapCompletableMainObserver(ne.b bVar, n<? super T, ? extends c> nVar, boolean z10) {
            this.f13909b = bVar;
            this.f13911n = nVar;
            this.f13912o = z10;
            lazySet(1);
        }

        @Override // qe.b
        public void dispose() {
            this.f13915r = true;
            this.f13914q.dispose();
            this.f13913p.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable thTerminate = this.f13910m.terminate();
                ne.b bVar = this.f13909b;
                if (thTerminate != null) {
                    bVar.onError(thTerminate);
                } else {
                    bVar.onComplete();
                }
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            AtomicThrowable atomicThrowable = this.f13910m;
            if (!atomicThrowable.addThrowable(th2)) {
                ff.a.onError(th2);
                return;
            }
            boolean z10 = this.f13912o;
            ne.b bVar = this.f13909b;
            if (z10) {
                if (decrementAndGet() == 0) {
                    bVar.onError(atomicThrowable.terminate());
                }
            } else {
                dispose();
                if (getAndSet(0) > 0) {
                    bVar.onError(atomicThrowable.terminate());
                }
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            try {
                c cVar = (c) ue.a.requireNonNull(this.f13911n.apply(t10), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.f13915r || !this.f13913p.add(innerObserver)) {
                    return;
                }
                cVar.subscribe(innerObserver);
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f13914q.dispose();
                onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f13914q, bVar)) {
                this.f13914q = bVar;
                this.f13909b.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapCompletableCompletable(o<T> oVar, n<? super T, ? extends c> nVar, boolean z10) {
        this.f13906a = oVar;
        this.f13907b = nVar;
        this.f13908c = z10;
    }

    @Override // ve.a
    public k<T> fuseToObservable() {
        return ff.a.onAssembly(new ObservableFlatMapCompletable(this.f13906a, this.f13907b, this.f13908c));
    }

    @Override // ne.a
    public void subscribeActual(ne.b bVar) {
        this.f13906a.subscribe(new FlatMapCompletableMainObserver(bVar, this.f13907b, this.f13908c));
    }
}
