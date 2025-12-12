package io.reactivex.internal.operators.observable;

// REMOVED: Malware import
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.k;
import ne.o;
import ne.q;
import ne.t;
import ne.u;
import qe.b;
import se.n;

/* loaded from: classes2.dex */
public final class ObservableFlatMapSingle<T, R> extends ye.a<T, R> {

    /* renamed from: m, reason: collision with root package name */
    public final n<? super T, ? extends u<? extends R>> f13929m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f13930n;

    public static final class FlatMapSingleObserver<T, R> extends AtomicInteger implements q<T>, b {
        private static final long serialVersionUID = 8600231336733376951L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super R> f13931b;

        /* renamed from: m, reason: collision with root package name */
        public final boolean f13932m;

        /* renamed from: q, reason: collision with root package name */
        public final n<? super T, ? extends u<? extends R>> f13936q;

        /* renamed from: s, reason: collision with root package name */
        public b f13938s;

        /* renamed from: t, reason: collision with root package name */
        public volatile boolean f13939t;

        /* renamed from: n, reason: collision with root package name */
        public final qe.a f13933n = new qe.a();

        /* renamed from: p, reason: collision with root package name */
        public final AtomicThrowable f13935p = new AtomicThrowable();

        /* renamed from: o, reason: collision with root package name */
        public final AtomicInteger f13934o = new AtomicInteger(1);

        /* renamed from: r, reason: collision with root package name */
        public final AtomicReference<af.a<R>> f13937r = new AtomicReference<>();

        public final class InnerObserver extends AtomicReference<b> implements t<R>, b {
            private static final long serialVersionUID = -502562646270949838L;

            public InnerObserver() {
            }

            @Override // qe.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // ne.t
            public void onError(Throwable th2) {
                FlatMapSingleObserver flatMapSingleObserver = FlatMapSingleObserver.this;
                qe.a aVar = flatMapSingleObserver.f13933n;
                aVar.delete(this);
                if (!flatMapSingleObserver.f13935p.addThrowable(th2)) {
                    ff.a.onError(th2);
                    return;
                }
                if (!flatMapSingleObserver.f13932m) {
                    flatMapSingleObserver.f13938s.dispose();
                    aVar.dispose();
                }
                flatMapSingleObserver.f13934o.decrementAndGet();
                if (flatMapSingleObserver.getAndIncrement() == 0) {
                    flatMapSingleObserver.a();
                }
            }

            @Override // ne.t
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // ne.t
            public void onSuccess(R r10) {
                af.a<R> aVar;
                boolean z10;
                FlatMapSingleObserver flatMapSingleObserver = FlatMapSingleObserver.this;
                flatMapSingleObserver.f13933n.delete(this);
                if (flatMapSingleObserver.get() == 0 && flatMapSingleObserver.compareAndSet(0, 1)) {
                    flatMapSingleObserver.f13931b.onNext(r10);
                    boolean z11 = flatMapSingleObserver.f13934o.decrementAndGet() == 0;
                    af.a<R> aVar2 = flatMapSingleObserver.f13937r.get();
                    if (z11 && (aVar2 == null || aVar2.isEmpty())) {
                        Throwable thTerminate = flatMapSingleObserver.f13935p.terminate();
                        if (thTerminate != null) {
                            flatMapSingleObserver.f13931b.onError(thTerminate);
                            return;
                        } else {
                            flatMapSingleObserver.f13931b.onComplete();
                            return;
                        }
                    }
                    if (flatMapSingleObserver.decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    do {
                        AtomicReference<af.a<R>> atomicReference = flatMapSingleObserver.f13937r;
                        aVar = atomicReference.get();
                        if (aVar != null) {
                            break;
                        }
                        aVar = new af.a<>(k.bufferSize());
                        while (true) {
                            if (atomicReference.compareAndSet(null, aVar)) {
                                z10 = true;
                                break;
                            } else if (atomicReference.get() != null) {
                                z10 = false;
                                break;
                            }
                        }
                    } while (!z10);
                    synchronized (aVar) {
                        aVar.offer(r10);
                    }
                    flatMapSingleObserver.f13934o.decrementAndGet();
                    if (flatMapSingleObserver.getAndIncrement() != 0) {
                        return;
                    }
                }
                flatMapSingleObserver.a();
            }
        }

        public FlatMapSingleObserver(q<? super R> qVar, n<? super T, ? extends u<? extends R>> nVar, boolean z10) {
            this.f13931b = qVar;
            this.f13936q = nVar;
            this.f13932m = z10;
        }

        public final void a() {
            q<? super R> qVar = this.f13931b;
            AtomicInteger atomicInteger = this.f13934o;
            AtomicReference<af.a<R>> atomicReference = this.f13937r;
            int iAddAndGet = 1;
            while (!this.f13939t) {
                if (!this.f13932m && this.f13935p.get() != null) {
                    Throwable thTerminate = this.f13935p.terminate();
                    af.a<R> aVar = this.f13937r.get();
                    if (aVar != null) {
                        aVar.clear();
                    }
                    qVar.onError(thTerminate);
                    return;
                }
                boolean z10 = atomicInteger.get() == 0;
                af.a<R> aVar2 = atomicReference.get();
                MProxy mProxyPoll = aVar2 != null ? aVar2.poll() : null;
                boolean z11 = mProxyPoll == null;
                if (z10 && z11) {
                    Throwable thTerminate2 = this.f13935p.terminate();
                    if (thTerminate2 != null) {
                        qVar.onError(thTerminate2);
                        return;
                    } else {
                        qVar.onComplete();
                        return;
                    }
                }
                if (z11) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    qVar.onNext(mProxyPoll);
                }
            }
            af.a<R> aVar3 = this.f13937r.get();
            if (aVar3 != null) {
                aVar3.clear();
            }
        }

        @Override // qe.b
        public void dispose() {
            this.f13939t = true;
            this.f13938s.dispose();
            this.f13933n.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            this.f13934o.decrementAndGet();
            if (getAndIncrement() == 0) {
                a();
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f13934o.decrementAndGet();
            if (!this.f13935p.addThrowable(th2)) {
                ff.a.onError(th2);
                return;
            }
            if (!this.f13932m) {
                this.f13933n.dispose();
            }
            if (getAndIncrement() == 0) {
                a();
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            try {
                u uVar = (u) ue.a.requireNonNull(this.f13936q.apply(t10), "The mapper returned a null SingleSource");
                this.f13934o.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.f13939t || !this.f13933n.add(innerObserver)) {
                    return;
                }
                uVar.subscribe(innerObserver);
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f13938s.dispose();
                onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f13938s, bVar)) {
                this.f13938s = bVar;
                this.f13931b.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapSingle(o<T> oVar, n<? super T, ? extends u<? extends R>> nVar, boolean z10) {
        super(oVar);
        this.f13929m = nVar;
        this.f13930n = z10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super R> qVar) {
        this.f22058b.subscribe(new FlatMapSingleObserver(qVar, this.f13929m, this.f13930n));
    }
}
