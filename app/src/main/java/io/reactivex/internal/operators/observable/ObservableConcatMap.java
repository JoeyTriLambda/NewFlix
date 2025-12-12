package io.reactivex.internal.operators.observable;

// REMOVED: Malware import
import ef.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.o;
import ne.q;
import qe.b;
import se.n;
import ve.f;

/* loaded from: classes2.dex */
public final class ObservableConcatMap<T, U> extends ye.a<T, U> {

    /* renamed from: m, reason: collision with root package name */
    public final n<? super T, ? extends o<? extends U>> f13791m;

    /* renamed from: n, reason: collision with root package name */
    public final int f13792n;

    /* renamed from: o, reason: collision with root package name */
    public final ErrorMode f13793o;

    public static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements q<T>, b {
        private static final long serialVersionUID = -6951100001833242599L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super R> f13794b;

        /* renamed from: m, reason: collision with root package name */
        public final n<? super T, ? extends o<? extends R>> f13795m;

        /* renamed from: n, reason: collision with root package name */
        public final int f13796n;

        /* renamed from: o, reason: collision with root package name */
        public final AtomicThrowable f13797o = new AtomicThrowable();

        /* renamed from: p, reason: collision with root package name */
        public final DelayErrorInnerObserver<R> f13798p;

        /* renamed from: q, reason: collision with root package name */
        public final boolean f13799q;

        /* renamed from: r, reason: collision with root package name */
        public f<T> f13800r;

        /* renamed from: s, reason: collision with root package name */
        public b f13801s;

        /* renamed from: t, reason: collision with root package name */
        public volatile boolean f13802t;

        /* renamed from: u, reason: collision with root package name */
        public volatile boolean f13803u;

        /* renamed from: v, reason: collision with root package name */
        public volatile boolean f13804v;

        /* renamed from: w, reason: collision with root package name */
        public int f13805w;

        public static final class DelayErrorInnerObserver<R> extends AtomicReference<b> implements q<R> {
            private static final long serialVersionUID = 2620149119579502636L;

            /* renamed from: b, reason: collision with root package name */
            public final q<? super R> f13806b;

            /* renamed from: m, reason: collision with root package name */
            public final ConcatMapDelayErrorObserver<?, R> f13807m;

            public DelayErrorInnerObserver(q<? super R> qVar, ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver) {
                this.f13806b = qVar;
                this.f13807m = concatMapDelayErrorObserver;
            }

            @Override // ne.q
            public void onComplete() {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.f13807m;
                concatMapDelayErrorObserver.f13802t = false;
                concatMapDelayErrorObserver.a();
            }

            @Override // ne.q
            public void onError(Throwable th2) {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.f13807m;
                if (!concatMapDelayErrorObserver.f13797o.addThrowable(th2)) {
                    ff.a.onError(th2);
                    return;
                }
                if (!concatMapDelayErrorObserver.f13799q) {
                    concatMapDelayErrorObserver.f13801s.dispose();
                }
                concatMapDelayErrorObserver.f13802t = false;
                concatMapDelayErrorObserver.a();
            }

            @Override // ne.q
            public void onNext(R r10) {
                this.f13806b.onNext(r10);
            }

            @Override // ne.q
            public void onSubscribe(b bVar) {
                DisposableHelper.replace(this, bVar);
            }
        }

        public ConcatMapDelayErrorObserver(q<? super R> qVar, n<? super T, ? extends o<? extends R>> nVar, int i10, boolean z10) {
            this.f13794b = qVar;
            this.f13795m = nVar;
            this.f13796n = i10;
            this.f13799q = z10;
            this.f13798p = new DelayErrorInnerObserver<>(qVar, this);
        }

        public final void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            q<? super R> qVar = this.f13794b;
            f<T> fVar = this.f13800r;
            AtomicThrowable atomicThrowable = this.f13797o;
            while (true) {
                if (!this.f13802t) {
                    if (this.f13804v) {
                        fVar.clear();
                        return;
                    }
                    if (!this.f13799q && atomicThrowable.get() != null) {
                        fVar.clear();
                        this.f13804v = true;
                        qVar.onError(atomicThrowable.terminate());
                        return;
                    }
                    boolean z10 = this.f13803u;
                    try {
                        T tPoll = fVar.poll();
                        boolean z11 = tPoll == null;
                        if (z10 && z11) {
                            this.f13804v = true;
                            Throwable thTerminate = atomicThrowable.terminate();
                            if (thTerminate != null) {
                                qVar.onError(thTerminate);
                                return;
                            } else {
                                qVar.onComplete();
                                return;
                            }
                        }
                        if (!z11) {
                            try {
                                o oVar = (o) ue.a.requireNonNull(this.f13795m.apply(tPoll), "The mapper returned a null ObservableSource");
                                if (oVar instanceof Callable) {
                                    try {
                                        MProxy mProxy = (Object) ((Callable) oVar).call();
                                        if (mProxy != null && !this.f13804v) {
                                            qVar.onNext(mProxy);
                                        }
                                    } catch (Throwable th2) {
                                        re.a.throwIfFatal(th2);
                                        atomicThrowable.addThrowable(th2);
                                    }
                                } else {
                                    this.f13802t = true;
                                    oVar.subscribe(this.f13798p);
                                }
                            } catch (Throwable th3) {
                                re.a.throwIfFatal(th3);
                                this.f13804v = true;
                                this.f13801s.dispose();
                                fVar.clear();
                                atomicThrowable.addThrowable(th3);
                                qVar.onError(atomicThrowable.terminate());
                                return;
                            }
                        }
                    } catch (Throwable th4) {
                        re.a.throwIfFatal(th4);
                        this.f13804v = true;
                        this.f13801s.dispose();
                        atomicThrowable.addThrowable(th4);
                        qVar.onError(atomicThrowable.terminate());
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // qe.b
        public void dispose() {
            this.f13804v = true;
            this.f13801s.dispose();
            DelayErrorInnerObserver<R> delayErrorInnerObserver = this.f13798p;
            delayErrorInnerObserver.getClass();
            DisposableHelper.dispose(delayErrorInnerObserver);
        }

        @Override // ne.q
        public void onComplete() {
            this.f13803u = true;
            a();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (!this.f13797o.addThrowable(th2)) {
                ff.a.onError(th2);
            } else {
                this.f13803u = true;
                a();
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f13805w == 0) {
                this.f13800r.offer(t10);
            }
            a();
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f13801s, bVar)) {
                this.f13801s = bVar;
                if (bVar instanceof ve.b) {
                    ve.b bVar2 = (ve.b) bVar;
                    int iRequestFusion = bVar2.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.f13805w = iRequestFusion;
                        this.f13800r = bVar2;
                        this.f13803u = true;
                        this.f13794b.onSubscribe(this);
                        a();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.f13805w = iRequestFusion;
                        this.f13800r = bVar2;
                        this.f13794b.onSubscribe(this);
                        return;
                    }
                }
                this.f13800r = new af.a(this.f13796n);
                this.f13794b.onSubscribe(this);
            }
        }
    }

    public static final class SourceObserver<T, U> extends AtomicInteger implements q<T>, b {
        private static final long serialVersionUID = 8828587559905699186L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super U> f13808b;

        /* renamed from: m, reason: collision with root package name */
        public final n<? super T, ? extends o<? extends U>> f13809m;

        /* renamed from: n, reason: collision with root package name */
        public final InnerObserver<U> f13810n;

        /* renamed from: o, reason: collision with root package name */
        public final int f13811o;

        /* renamed from: p, reason: collision with root package name */
        public f<T> f13812p;

        /* renamed from: q, reason: collision with root package name */
        public b f13813q;

        /* renamed from: r, reason: collision with root package name */
        public volatile boolean f13814r;

        /* renamed from: s, reason: collision with root package name */
        public volatile boolean f13815s;

        /* renamed from: t, reason: collision with root package name */
        public volatile boolean f13816t;

        /* renamed from: u, reason: collision with root package name */
        public int f13817u;

        public static final class InnerObserver<U> extends AtomicReference<b> implements q<U> {
            private static final long serialVersionUID = -7449079488798789337L;

            /* renamed from: b, reason: collision with root package name */
            public final q<? super U> f13818b;

            /* renamed from: m, reason: collision with root package name */
            public final SourceObserver<?, ?> f13819m;

            public InnerObserver(e eVar, SourceObserver sourceObserver) {
                this.f13818b = eVar;
                this.f13819m = sourceObserver;
            }

            @Override // ne.q
            public void onComplete() {
                SourceObserver<?, ?> sourceObserver = this.f13819m;
                sourceObserver.f13814r = false;
                sourceObserver.a();
            }

            @Override // ne.q
            public void onError(Throwable th2) {
                this.f13819m.dispose();
                this.f13818b.onError(th2);
            }

            @Override // ne.q
            public void onNext(U u10) {
                this.f13818b.onNext(u10);
            }

            @Override // ne.q
            public void onSubscribe(b bVar) {
                DisposableHelper.replace(this, bVar);
            }
        }

        public SourceObserver(e eVar, n nVar, int i10) {
            this.f13808b = eVar;
            this.f13809m = nVar;
            this.f13811o = i10;
            this.f13810n = new InnerObserver<>(eVar, this);
        }

        public final void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.f13815s) {
                if (!this.f13814r) {
                    boolean z10 = this.f13816t;
                    try {
                        T tPoll = this.f13812p.poll();
                        boolean z11 = tPoll == null;
                        if (z10 && z11) {
                            this.f13815s = true;
                            this.f13808b.onComplete();
                            return;
                        } else if (!z11) {
                            try {
                                o oVar = (o) ue.a.requireNonNull(this.f13809m.apply(tPoll), "The mapper returned a null ObservableSource");
                                this.f13814r = true;
                                oVar.subscribe(this.f13810n);
                            } catch (Throwable th2) {
                                re.a.throwIfFatal(th2);
                                dispose();
                                this.f13812p.clear();
                                this.f13808b.onError(th2);
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        re.a.throwIfFatal(th3);
                        dispose();
                        this.f13812p.clear();
                        this.f13808b.onError(th3);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.f13812p.clear();
        }

        @Override // qe.b
        public void dispose() {
            this.f13815s = true;
            InnerObserver<U> innerObserver = this.f13810n;
            innerObserver.getClass();
            DisposableHelper.dispose(innerObserver);
            this.f13813q.dispose();
            if (getAndIncrement() == 0) {
                this.f13812p.clear();
            }
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f13816t) {
                return;
            }
            this.f13816t = true;
            a();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f13816t) {
                ff.a.onError(th2);
                return;
            }
            this.f13816t = true;
            dispose();
            this.f13808b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f13816t) {
                return;
            }
            if (this.f13817u == 0) {
                this.f13812p.offer(t10);
            }
            a();
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f13813q, bVar)) {
                this.f13813q = bVar;
                if (bVar instanceof ve.b) {
                    ve.b bVar2 = (ve.b) bVar;
                    int iRequestFusion = bVar2.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.f13817u = iRequestFusion;
                        this.f13812p = bVar2;
                        this.f13816t = true;
                        this.f13808b.onSubscribe(this);
                        a();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.f13817u = iRequestFusion;
                        this.f13812p = bVar2;
                        this.f13808b.onSubscribe(this);
                        return;
                    }
                }
                this.f13812p = new af.a(this.f13811o);
                this.f13808b.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMap(o<T> oVar, n<? super T, ? extends o<? extends U>> nVar, int i10, ErrorMode errorMode) {
        super(oVar);
        this.f13791m = nVar;
        this.f13793o = errorMode;
        this.f13792n = Math.max(8, i10);
    }

    @Override // ne.k
    public void subscribeActual(q<? super U> qVar) {
        o<T> oVar = this.f22058b;
        n<? super T, ? extends o<? extends U>> nVar = this.f13791m;
        if (ObservableScalarXMap.tryScalarXMapSubscribe(oVar, qVar, nVar)) {
            return;
        }
        ErrorMode errorMode = ErrorMode.IMMEDIATE;
        int i10 = this.f13792n;
        ErrorMode errorMode2 = this.f13793o;
        if (errorMode2 == errorMode) {
            oVar.subscribe(new SourceObserver(new e(qVar), nVar, i10));
        } else {
            oVar.subscribe(new ConcatMapDelayErrorObserver(qVar, nVar, i10, errorMode2 == ErrorMode.END));
        }
    }
}
