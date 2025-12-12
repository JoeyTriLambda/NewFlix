package io.reactivex.internal.operators.mixed;

import c8.i;
import ff.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.k;
import ne.q;
import ne.t;
import ne.u;
import qe.b;
import se.n;

/* loaded from: classes2.dex */
public final class ObservableSwitchMapSingle<T, R> extends k<R> {

    /* renamed from: b, reason: collision with root package name */
    public final k<T> f13690b;

    /* renamed from: m, reason: collision with root package name */
    public final n<? super T, ? extends u<? extends R>> f13691m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f13692n;

    public static final class SwitchMapSingleMainObserver<T, R> extends AtomicInteger implements q<T>, b {
        private static final long serialVersionUID = -5402190102429853762L;

        /* renamed from: t, reason: collision with root package name */
        public static final SwitchMapSingleObserver<Object> f13693t = new SwitchMapSingleObserver<>(null);

        /* renamed from: b, reason: collision with root package name */
        public final q<? super R> f13694b;

        /* renamed from: m, reason: collision with root package name */
        public final n<? super T, ? extends u<? extends R>> f13695m;

        /* renamed from: n, reason: collision with root package name */
        public final boolean f13696n;

        /* renamed from: o, reason: collision with root package name */
        public final AtomicThrowable f13697o = new AtomicThrowable();

        /* renamed from: p, reason: collision with root package name */
        public final AtomicReference<SwitchMapSingleObserver<R>> f13698p = new AtomicReference<>();

        /* renamed from: q, reason: collision with root package name */
        public b f13699q;

        /* renamed from: r, reason: collision with root package name */
        public volatile boolean f13700r;

        /* renamed from: s, reason: collision with root package name */
        public volatile boolean f13701s;

        public static final class SwitchMapSingleObserver<R> extends AtomicReference<b> implements t<R> {
            private static final long serialVersionUID = 8042919737683345351L;

            /* renamed from: b, reason: collision with root package name */
            public final SwitchMapSingleMainObserver<?, R> f13702b;

            /* renamed from: m, reason: collision with root package name */
            public volatile R f13703m;

            public SwitchMapSingleObserver(SwitchMapSingleMainObserver<?, R> switchMapSingleMainObserver) {
                this.f13702b = switchMapSingleMainObserver;
            }

            @Override // ne.t
            public void onError(Throwable th2) {
                boolean z10;
                SwitchMapSingleMainObserver<?, R> switchMapSingleMainObserver = this.f13702b;
                AtomicReference<SwitchMapSingleObserver<R>> atomicReference = switchMapSingleMainObserver.f13698p;
                while (true) {
                    if (atomicReference.compareAndSet(this, null)) {
                        z10 = true;
                        break;
                    } else if (atomicReference.get() != this) {
                        z10 = false;
                        break;
                    }
                }
                if (!z10 || !switchMapSingleMainObserver.f13697o.addThrowable(th2)) {
                    a.onError(th2);
                    return;
                }
                if (!switchMapSingleMainObserver.f13696n) {
                    switchMapSingleMainObserver.f13699q.dispose();
                    switchMapSingleMainObserver.a();
                }
                switchMapSingleMainObserver.b();
            }

            @Override // ne.t
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // ne.t
            public void onSuccess(R r10) {
                this.f13703m = r10;
                this.f13702b.b();
            }
        }

        public SwitchMapSingleMainObserver(q<? super R> qVar, n<? super T, ? extends u<? extends R>> nVar, boolean z10) {
            this.f13694b = qVar;
            this.f13695m = nVar;
            this.f13696n = z10;
        }

        public final void a() {
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.f13698p;
            SwitchMapSingleObserver<Object> switchMapSingleObserver = f13693t;
            SwitchMapSingleObserver<Object> switchMapSingleObserver2 = (SwitchMapSingleObserver) atomicReference.getAndSet(switchMapSingleObserver);
            if (switchMapSingleObserver2 == null || switchMapSingleObserver2 == switchMapSingleObserver) {
                return;
            }
            DisposableHelper.dispose(switchMapSingleObserver2);
        }

        public final void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            q<? super R> qVar = this.f13694b;
            AtomicThrowable atomicThrowable = this.f13697o;
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.f13698p;
            int iAddAndGet = 1;
            while (!this.f13701s) {
                if (atomicThrowable.get() != null && !this.f13696n) {
                    qVar.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z10 = this.f13700r;
                SwitchMapSingleObserver<R> switchMapSingleObserver = atomicReference.get();
                boolean z11 = switchMapSingleObserver == null;
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
                if (z11 || switchMapSingleObserver.f13703m == null) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    while (!atomicReference.compareAndSet(switchMapSingleObserver, null) && atomicReference.get() == switchMapSingleObserver) {
                    }
                    qVar.onNext(switchMapSingleObserver.f13703m);
                }
            }
        }

        @Override // qe.b
        public void dispose() {
            this.f13701s = true;
            this.f13699q.dispose();
            a();
        }

        @Override // ne.q
        public void onComplete() {
            this.f13700r = true;
            b();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (!this.f13697o.addThrowable(th2)) {
                a.onError(th2);
                return;
            }
            if (!this.f13696n) {
                a();
            }
            this.f13700r = true;
            b();
        }

        @Override // ne.q
        public void onNext(T t10) {
            boolean z10;
            SwitchMapSingleObserver<Object> switchMapSingleObserver = f13693t;
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.f13698p;
            SwitchMapSingleObserver switchMapSingleObserver2 = (SwitchMapSingleObserver) atomicReference.get();
            if (switchMapSingleObserver2 != null) {
                DisposableHelper.dispose(switchMapSingleObserver2);
            }
            try {
                u uVar = (u) ue.a.requireNonNull(this.f13695m.apply(t10), "The mapper returned a null SingleSource");
                SwitchMapSingleObserver switchMapSingleObserver3 = new SwitchMapSingleObserver(this);
                do {
                    SwitchMapSingleObserver<Object> switchMapSingleObserver4 = (SwitchMapSingleObserver) atomicReference.get();
                    if (switchMapSingleObserver4 == switchMapSingleObserver) {
                        return;
                    }
                    while (true) {
                        if (atomicReference.compareAndSet(switchMapSingleObserver4, switchMapSingleObserver3)) {
                            z10 = true;
                            break;
                        } else if (atomicReference.get() != switchMapSingleObserver4) {
                            z10 = false;
                            break;
                        }
                    }
                } while (!z10);
                uVar.subscribe(switchMapSingleObserver3);
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f13699q.dispose();
                atomicReference.getAndSet(switchMapSingleObserver);
                onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f13699q, bVar)) {
                this.f13699q = bVar;
                this.f13694b.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapSingle(k<T> kVar, n<? super T, ? extends u<? extends R>> nVar, boolean z10) {
        this.f13690b = kVar;
        this.f13691m = nVar;
        this.f13692n = z10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super R> qVar) {
        k<T> kVar = this.f13690b;
        n<? super T, ? extends u<? extends R>> nVar = this.f13691m;
        if (i.p(kVar, nVar, qVar)) {
            return;
        }
        kVar.subscribe(new SwitchMapSingleMainObserver(qVar, nVar, this.f13692n));
    }
}
