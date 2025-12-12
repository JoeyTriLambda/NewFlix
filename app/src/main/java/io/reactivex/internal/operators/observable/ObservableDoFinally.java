package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import ne.o;
import ne.q;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableDoFinally<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final se.a f13866m;

    public static final class DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements q<T> {
        private static final long serialVersionUID = 4109457741734051389L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f13867b;

        /* renamed from: m, reason: collision with root package name */
        public final se.a f13868m;

        /* renamed from: n, reason: collision with root package name */
        public b f13869n;

        /* renamed from: o, reason: collision with root package name */
        public ve.b<T> f13870o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f13871p;

        public DoFinallyObserver(q<? super T> qVar, se.a aVar) {
            this.f13867b = qVar;
            this.f13868m = aVar;
        }

        public final void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f13868m.run();
                } catch (Throwable th2) {
                    re.a.throwIfFatal(th2);
                    ff.a.onError(th2);
                }
            }
        }

        @Override // ve.f
        public void clear() {
            this.f13870o.clear();
        }

        @Override // qe.b
        public void dispose() {
            this.f13869n.dispose();
            a();
        }

        @Override // ve.f
        public boolean isEmpty() {
            return this.f13870o.isEmpty();
        }

        @Override // ne.q
        public void onComplete() {
            this.f13867b.onComplete();
            a();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f13867b.onError(th2);
            a();
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f13867b.onNext(t10);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f13869n, bVar)) {
                this.f13869n = bVar;
                if (bVar instanceof ve.b) {
                    this.f13870o = (ve.b) bVar;
                }
                this.f13867b.onSubscribe(this);
            }
        }

        @Override // ve.f
        public T poll() throws Exception {
            T tPoll = this.f13870o.poll();
            if (tPoll == null && this.f13871p) {
                a();
            }
            return tPoll;
        }

        @Override // ve.c
        public int requestFusion(int i10) {
            ve.b<T> bVar = this.f13870o;
            if (bVar == null || (i10 & 4) != 0) {
                return 0;
            }
            int iRequestFusion = bVar.requestFusion(i10);
            if (iRequestFusion != 0) {
                this.f13871p = iRequestFusion == 1;
            }
            return iRequestFusion;
        }
    }

    public ObservableDoFinally(o<T> oVar, se.a aVar) {
        super(oVar);
        this.f13866m = aVar;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        this.f22058b.subscribe(new DoFinallyObserver(qVar, this.f13866m));
    }
}
