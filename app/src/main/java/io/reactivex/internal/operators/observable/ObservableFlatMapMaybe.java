package io.reactivex.internal.operators.observable;

// REMOVED: Malware import
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.h;
import ne.i;
import ne.k;
import ne.o;
import ne.q;
import qe.b;
import se.n;

/* loaded from: classes2.dex */
public final class ObservableFlatMapMaybe<T, R> extends ye.a<T, R> {

    /* renamed from: m, reason: collision with root package name */
    public final n<? super T, ? extends i<? extends R>> f13917m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f13918n;

    public static final class FlatMapMaybeObserver<T, R> extends AtomicInteger implements q<T>, b {
        private static final long serialVersionUID = 8600231336733376951L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super R> f13919b;

        /* renamed from: m, reason: collision with root package name */
        public final boolean f13920m;

        /* renamed from: q, reason: collision with root package name */
        public final n<? super T, ? extends i<? extends R>> f13924q;

        /* renamed from: s, reason: collision with root package name */
        public b f13926s;

        /* renamed from: t, reason: collision with root package name */
        public volatile boolean f13927t;

        /* renamed from: n, reason: collision with root package name */
        public final qe.a f13921n = new qe.a();

        /* renamed from: p, reason: collision with root package name */
        public final AtomicThrowable f13923p = new AtomicThrowable();

        /* renamed from: o, reason: collision with root package name */
        public final AtomicInteger f13922o = new AtomicInteger(1);

        /* renamed from: r, reason: collision with root package name */
        public final AtomicReference<af.a<R>> f13925r = new AtomicReference<>();

        public final class InnerObserver extends AtomicReference<b> implements h<R>, b {
            private static final long serialVersionUID = -502562646270949838L;

            public InnerObserver() {
            }

            @Override // qe.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // ne.h
            public void onComplete() {
                FlatMapMaybeObserver flatMapMaybeObserver = FlatMapMaybeObserver.this;
                flatMapMaybeObserver.f13921n.delete(this);
                int i10 = flatMapMaybeObserver.get();
                AtomicInteger atomicInteger = flatMapMaybeObserver.f13922o;
                if (i10 == 0) {
                    if (flatMapMaybeObserver.compareAndSet(0, 1)) {
                        boolean z10 = atomicInteger.decrementAndGet() == 0;
                        af.a<R> aVar = flatMapMaybeObserver.f13925r.get();
                        if (!z10 || (aVar != null && !aVar.isEmpty())) {
                            if (flatMapMaybeObserver.decrementAndGet() == 0) {
                                return;
                            }
                            flatMapMaybeObserver.a();
                            return;
                        } else {
                            Throwable thTerminate = flatMapMaybeObserver.f13923p.terminate();
                            q<? super R> qVar = flatMapMaybeObserver.f13919b;
                            if (thTerminate != null) {
                                qVar.onError(thTerminate);
                                return;
                            } else {
                                qVar.onComplete();
                                return;
                            }
                        }
                    }
                }
                atomicInteger.decrementAndGet();
                if (flatMapMaybeObserver.getAndIncrement() == 0) {
                    flatMapMaybeObserver.a();
                }
            }

            @Override // ne.h
            public void onError(Throwable th2) {
                FlatMapMaybeObserver flatMapMaybeObserver = FlatMapMaybeObserver.this;
                qe.a aVar = flatMapMaybeObserver.f13921n;
                aVar.delete(this);
                if (!flatMapMaybeObserver.f13923p.addThrowable(th2)) {
                    ff.a.onError(th2);
                    return;
                }
                if (!flatMapMaybeObserver.f13920m) {
                    flatMapMaybeObserver.f13926s.dispose();
                    aVar.dispose();
                }
                flatMapMaybeObserver.f13922o.decrementAndGet();
                if (flatMapMaybeObserver.getAndIncrement() == 0) {
                    flatMapMaybeObserver.a();
                }
            }

            @Override // ne.h
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // ne.h
            public void onSuccess(R r10) {
                af.a<R> aVar;
                boolean z10;
                FlatMapMaybeObserver flatMapMaybeObserver = FlatMapMaybeObserver.this;
                flatMapMaybeObserver.f13921n.delete(this);
                if (flatMapMaybeObserver.get() == 0 && flatMapMaybeObserver.compareAndSet(0, 1)) {
                    flatMapMaybeObserver.f13919b.onNext(r10);
                    boolean z11 = flatMapMaybeObserver.f13922o.decrementAndGet() == 0;
                    af.a<R> aVar2 = flatMapMaybeObserver.f13925r.get();
                    if (z11 && (aVar2 == null || aVar2.isEmpty())) {
                        Throwable thTerminate = flatMapMaybeObserver.f13923p.terminate();
                        if (thTerminate != null) {
                            flatMapMaybeObserver.f13919b.onError(thTerminate);
                            return;
                        } else {
                            flatMapMaybeObserver.f13919b.onComplete();
                            return;
                        }
                    }
                    if (flatMapMaybeObserver.decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    do {
                        AtomicReference<af.a<R>> atomicReference = flatMapMaybeObserver.f13925r;
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
                    flatMapMaybeObserver.f13922o.decrementAndGet();
                    if (flatMapMaybeObserver.getAndIncrement() != 0) {
                        return;
                    }
                }
                flatMapMaybeObserver.a();
            }
        }

        public FlatMapMaybeObserver(q<? super R> qVar, n<? super T, ? extends i<? extends R>> nVar, boolean z10) {
            this.f13919b = qVar;
            this.f13924q = nVar;
            this.f13920m = z10;
        }

        public final void a() {
            q<? super R> qVar = this.f13919b;
            AtomicInteger atomicInteger = this.f13922o;
            AtomicReference<af.a<R>> atomicReference = this.f13925r;
            int iAddAndGet = 1;
            while (!this.f13927t) {
                if (!this.f13920m && this.f13923p.get() != null) {
                    Throwable thTerminate = this.f13923p.terminate();
                    af.a<R> aVar = this.f13925r.get();
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
                    Throwable thTerminate2 = this.f13923p.terminate();
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
            af.a<R> aVar3 = this.f13925r.get();
            if (aVar3 != null) {
                aVar3.clear();
            }
        }

        @Override // qe.b
        public void dispose() {
            this.f13927t = true;
            this.f13926s.dispose();
            this.f13921n.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            this.f13922o.decrementAndGet();
            if (getAndIncrement() == 0) {
                a();
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f13922o.decrementAndGet();
            if (!this.f13923p.addThrowable(th2)) {
                ff.a.onError(th2);
                return;
            }
            if (!this.f13920m) {
                this.f13921n.dispose();
            }
            if (getAndIncrement() == 0) {
                a();
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            try {
                i iVar = (i) ue.a.requireNonNull(this.f13924q.apply(t10), "The mapper returned a null MaybeSource");
                this.f13922o.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.f13927t || !this.f13921n.add(innerObserver)) {
                    return;
                }
                iVar.subscribe(innerObserver);
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f13926s.dispose();
                onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f13926s, bVar)) {
                this.f13926s = bVar;
                this.f13919b.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapMaybe(o<T> oVar, n<? super T, ? extends i<? extends R>> nVar, boolean z10) {
        super(oVar);
        this.f13917m = nVar;
        this.f13918n = z10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super R> qVar) {
        this.f22058b.subscribe(new FlatMapMaybeObserver(qVar, this.f13917m, this.f13918n));
    }
}
