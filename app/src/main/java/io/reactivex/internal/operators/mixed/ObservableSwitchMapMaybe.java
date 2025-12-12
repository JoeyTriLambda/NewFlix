package io.reactivex.internal.operators.mixed;

import ff.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.h;
import ne.i;
import ne.k;
import ne.q;
import qe.b;
import se.n;

/* loaded from: classes2.dex */
public final class ObservableSwitchMapMaybe<T, R> extends k<R> {

    /* renamed from: b, reason: collision with root package name */
    public final k<T> f13676b;

    /* renamed from: m, reason: collision with root package name */
    public final n<? super T, ? extends i<? extends R>> f13677m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f13678n;

    public static final class SwitchMapMaybeMainObserver<T, R> extends AtomicInteger implements q<T>, b {
        private static final long serialVersionUID = -5402190102429853762L;

        /* renamed from: t, reason: collision with root package name */
        public static final SwitchMapMaybeObserver<Object> f13679t = new SwitchMapMaybeObserver<>(null);

        /* renamed from: b, reason: collision with root package name */
        public final q<? super R> f13680b;

        /* renamed from: m, reason: collision with root package name */
        public final n<? super T, ? extends i<? extends R>> f13681m;

        /* renamed from: n, reason: collision with root package name */
        public final boolean f13682n;

        /* renamed from: o, reason: collision with root package name */
        public final AtomicThrowable f13683o = new AtomicThrowable();

        /* renamed from: p, reason: collision with root package name */
        public final AtomicReference<SwitchMapMaybeObserver<R>> f13684p = new AtomicReference<>();

        /* renamed from: q, reason: collision with root package name */
        public b f13685q;

        /* renamed from: r, reason: collision with root package name */
        public volatile boolean f13686r;

        /* renamed from: s, reason: collision with root package name */
        public volatile boolean f13687s;

        public static final class SwitchMapMaybeObserver<R> extends AtomicReference<b> implements h<R> {
            private static final long serialVersionUID = 8042919737683345351L;

            /* renamed from: b, reason: collision with root package name */
            public final SwitchMapMaybeMainObserver<?, R> f13688b;

            /* renamed from: m, reason: collision with root package name */
            public volatile R f13689m;

            public SwitchMapMaybeObserver(SwitchMapMaybeMainObserver<?, R> switchMapMaybeMainObserver) {
                this.f13688b = switchMapMaybeMainObserver;
            }

            @Override // ne.h
            public void onComplete() {
                boolean z10;
                SwitchMapMaybeMainObserver<?, R> switchMapMaybeMainObserver = this.f13688b;
                AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = switchMapMaybeMainObserver.f13684p;
                while (true) {
                    if (atomicReference.compareAndSet(this, null)) {
                        z10 = true;
                        break;
                    } else if (atomicReference.get() != this) {
                        z10 = false;
                        break;
                    }
                }
                if (z10) {
                    switchMapMaybeMainObserver.b();
                }
            }

            @Override // ne.h
            public void onError(Throwable th2) {
                boolean z10;
                SwitchMapMaybeMainObserver<?, R> switchMapMaybeMainObserver = this.f13688b;
                AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = switchMapMaybeMainObserver.f13684p;
                while (true) {
                    if (atomicReference.compareAndSet(this, null)) {
                        z10 = true;
                        break;
                    } else if (atomicReference.get() != this) {
                        z10 = false;
                        break;
                    }
                }
                if (!z10 || !switchMapMaybeMainObserver.f13683o.addThrowable(th2)) {
                    a.onError(th2);
                    return;
                }
                if (!switchMapMaybeMainObserver.f13682n) {
                    switchMapMaybeMainObserver.f13685q.dispose();
                    switchMapMaybeMainObserver.a();
                }
                switchMapMaybeMainObserver.b();
            }

            @Override // ne.h
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // ne.h
            public void onSuccess(R r10) {
                this.f13689m = r10;
                this.f13688b.b();
            }
        }

        public SwitchMapMaybeMainObserver(q<? super R> qVar, n<? super T, ? extends i<? extends R>> nVar, boolean z10) {
            this.f13680b = qVar;
            this.f13681m = nVar;
            this.f13682n = z10;
        }

        public final void a() {
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.f13684p;
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver = f13679t;
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver2 = (SwitchMapMaybeObserver) atomicReference.getAndSet(switchMapMaybeObserver);
            if (switchMapMaybeObserver2 == null || switchMapMaybeObserver2 == switchMapMaybeObserver) {
                return;
            }
            DisposableHelper.dispose(switchMapMaybeObserver2);
        }

        public final void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            q<? super R> qVar = this.f13680b;
            AtomicThrowable atomicThrowable = this.f13683o;
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.f13684p;
            int iAddAndGet = 1;
            while (!this.f13687s) {
                if (atomicThrowable.get() != null && !this.f13682n) {
                    qVar.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z10 = this.f13686r;
                SwitchMapMaybeObserver<R> switchMapMaybeObserver = atomicReference.get();
                boolean z11 = switchMapMaybeObserver == null;
                if (z10 && z11) {
                    Throwable thTerminate = atomicThrowable.terminate();
                    if (thTerminate != null) {
                        qVar.onError(thTerminate);
                        return;
                    } else {
                        qVar.onComplete();
                        return;
                    }
                }
                if (z11 || switchMapMaybeObserver.f13689m == null) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    while (!atomicReference.compareAndSet(switchMapMaybeObserver, null) && atomicReference.get() == switchMapMaybeObserver) {
                    }
                    qVar.onNext(switchMapMaybeObserver.f13689m);
                }
            }
        }

        @Override // qe.b
        public void dispose() {
            this.f13687s = true;
            this.f13685q.dispose();
            a();
        }

        @Override // ne.q
        public void onComplete() {
            this.f13686r = true;
            b();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (!this.f13683o.addThrowable(th2)) {
                a.onError(th2);
                return;
            }
            if (!this.f13682n) {
                a();
            }
            this.f13686r = true;
            b();
        }

        @Override // ne.q
        public void onNext(T t10) {
            boolean z10;
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver = f13679t;
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.f13684p;
            SwitchMapMaybeObserver switchMapMaybeObserver2 = (SwitchMapMaybeObserver) atomicReference.get();
            if (switchMapMaybeObserver2 != null) {
                DisposableHelper.dispose(switchMapMaybeObserver2);
            }
            try {
                i iVar = (i) ue.a.requireNonNull(this.f13681m.apply(t10), "The mapper returned a null MaybeSource");
                SwitchMapMaybeObserver switchMapMaybeObserver3 = new SwitchMapMaybeObserver(this);
                do {
                    SwitchMapMaybeObserver<Object> switchMapMaybeObserver4 = (SwitchMapMaybeObserver) atomicReference.get();
                    if (switchMapMaybeObserver4 == switchMapMaybeObserver) {
                        return;
                    }
                    while (true) {
                        if (atomicReference.compareAndSet(switchMapMaybeObserver4, switchMapMaybeObserver3)) {
                            z10 = true;
                            break;
                        } else if (atomicReference.get() != switchMapMaybeObserver4) {
                            z10 = false;
                            break;
                        }
                    }
                } while (!z10);
                iVar.subscribe(switchMapMaybeObserver3);
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f13685q.dispose();
                atomicReference.getAndSet(switchMapMaybeObserver);
                onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f13685q, bVar)) {
                this.f13685q = bVar;
                this.f13680b.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapMaybe(k<T> kVar, n<? super T, ? extends i<? extends R>> nVar, boolean z10) {
        this.f13676b = kVar;
        this.f13677m = nVar;
        this.f13678n = z10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super R> qVar) {
        k<T> kVar = this.f13676b;
        n<? super T, ? extends i<? extends R>> nVar = this.f13677m;
        if (c8.i.o(kVar, nVar, qVar)) {
            return;
        }
        kVar.subscribe(new SwitchMapMaybeMainObserver(qVar, nVar, this.f13678n));
    }
}
