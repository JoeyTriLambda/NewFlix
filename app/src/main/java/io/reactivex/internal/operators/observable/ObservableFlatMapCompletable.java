package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;
import ne.c;
import ne.o;
import ne.q;
import qe.b;
import se.n;

/* loaded from: classes2.dex */
public final class ObservableFlatMapCompletable<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final n<? super T, ? extends c> f13896m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f13897n;

    public ObservableFlatMapCompletable(o<T> oVar, n<? super T, ? extends c> nVar, boolean z10) {
        super(oVar);
        this.f13896m = nVar;
        this.f13897n = z10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        this.f22058b.subscribe(new FlatMapCompletableMainObserver(qVar, this.f13896m, this.f13897n));
    }

    public static final class FlatMapCompletableMainObserver<T> extends BasicIntQueueDisposable<T> implements q<T> {
        private static final long serialVersionUID = 8443155186132538303L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f13898b;

        /* renamed from: n, reason: collision with root package name */
        public final n<? super T, ? extends c> f13900n;

        /* renamed from: o, reason: collision with root package name */
        public final boolean f13901o;

        /* renamed from: q, reason: collision with root package name */
        public b f13903q;

        /* renamed from: r, reason: collision with root package name */
        public volatile boolean f13904r;

        /* renamed from: m, reason: collision with root package name */
        public final AtomicThrowable f13899m = new AtomicThrowable();

        /* renamed from: p, reason: collision with root package name */
        public final qe.a f13902p = new qe.a();

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
                flatMapCompletableMainObserver.f13902p.delete(this);
                flatMapCompletableMainObserver.onComplete();
            }

            @Override // ne.b
            public void onError(Throwable th2) {
                FlatMapCompletableMainObserver flatMapCompletableMainObserver = FlatMapCompletableMainObserver.this;
                flatMapCompletableMainObserver.f13902p.delete(this);
                flatMapCompletableMainObserver.onError(th2);
            }

            @Override // ne.b
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        public FlatMapCompletableMainObserver(q<? super T> qVar, n<? super T, ? extends c> nVar, boolean z10) {
            this.f13898b = qVar;
            this.f13900n = nVar;
            this.f13901o = z10;
            lazySet(1);
        }

        @Override // qe.b
        public void dispose() {
            this.f13904r = true;
            this.f13903q.dispose();
            this.f13902p.dispose();
        }

        @Override // ve.f
        public boolean isEmpty() {
            return true;
        }

        @Override // ne.q
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable thTerminate = this.f13899m.terminate();
                q<? super T> qVar = this.f13898b;
                if (thTerminate != null) {
                    qVar.onError(thTerminate);
                } else {
                    qVar.onComplete();
                }
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            AtomicThrowable atomicThrowable = this.f13899m;
            if (!atomicThrowable.addThrowable(th2)) {
                ff.a.onError(th2);
                return;
            }
            boolean z10 = this.f13901o;
            q<? super T> qVar = this.f13898b;
            if (z10) {
                if (decrementAndGet() == 0) {
                    qVar.onError(atomicThrowable.terminate());
                }
            } else {
                dispose();
                if (getAndSet(0) > 0) {
                    qVar.onError(atomicThrowable.terminate());
                }
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            try {
                c cVar = (c) ue.a.requireNonNull(this.f13900n.apply(t10), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.f13904r || !this.f13902p.add(innerObserver)) {
                    return;
                }
                cVar.subscribe(innerObserver);
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f13903q.dispose();
                onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f13903q, bVar)) {
                this.f13903q = bVar;
                this.f13898b.onSubscribe(this);
            }
        }

        @Override // ve.f
        public T poll() throws Exception {
            return null;
        }

        @Override // ve.c
        public int requestFusion(int i10) {
            return i10 & 2;
        }

        @Override // ve.f
        public void clear() {
        }
    }
}
