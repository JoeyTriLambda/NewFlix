package io.reactivex.internal.operators.mixed;

import c8.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import ne.a;
import ne.c;
import ne.k;
import ne.q;
import qe.b;
import se.n;

/* loaded from: classes2.dex */
public final class ObservableSwitchMapCompletable<T> extends a {

    /* renamed from: a, reason: collision with root package name */
    public final k<T> f13664a;

    /* renamed from: b, reason: collision with root package name */
    public final n<? super T, ? extends c> f13665b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f13666c;

    public static final class SwitchMapCompletableObserver<T> implements q<T>, b {

        /* renamed from: s, reason: collision with root package name */
        public static final SwitchMapInnerObserver f13667s = new SwitchMapInnerObserver(null);

        /* renamed from: b, reason: collision with root package name */
        public final ne.b f13668b;

        /* renamed from: m, reason: collision with root package name */
        public final n<? super T, ? extends c> f13669m;

        /* renamed from: n, reason: collision with root package name */
        public final boolean f13670n;

        /* renamed from: o, reason: collision with root package name */
        public final AtomicThrowable f13671o = new AtomicThrowable();

        /* renamed from: p, reason: collision with root package name */
        public final AtomicReference<SwitchMapInnerObserver> f13672p = new AtomicReference<>();

        /* renamed from: q, reason: collision with root package name */
        public volatile boolean f13673q;

        /* renamed from: r, reason: collision with root package name */
        public b f13674r;

        public static final class SwitchMapInnerObserver extends AtomicReference<b> implements ne.b {
            private static final long serialVersionUID = -8003404460084760287L;

            /* renamed from: b, reason: collision with root package name */
            public final SwitchMapCompletableObserver<?> f13675b;

            public SwitchMapInnerObserver(SwitchMapCompletableObserver<?> switchMapCompletableObserver) {
                this.f13675b = switchMapCompletableObserver;
            }

            @Override // ne.b
            public void onComplete() {
                boolean z10;
                SwitchMapCompletableObserver<?> switchMapCompletableObserver = this.f13675b;
                AtomicReference<SwitchMapInnerObserver> atomicReference = switchMapCompletableObserver.f13672p;
                while (true) {
                    if (atomicReference.compareAndSet(this, null)) {
                        z10 = true;
                        break;
                    } else if (atomicReference.get() != this) {
                        z10 = false;
                        break;
                    }
                }
                if (z10 && switchMapCompletableObserver.f13673q) {
                    Throwable thTerminate = switchMapCompletableObserver.f13671o.terminate();
                    if (thTerminate == null) {
                        switchMapCompletableObserver.f13668b.onComplete();
                    } else {
                        switchMapCompletableObserver.f13668b.onError(thTerminate);
                    }
                }
            }

            @Override // ne.b
            public void onError(Throwable th2) {
                boolean z10;
                SwitchMapCompletableObserver<?> switchMapCompletableObserver = this.f13675b;
                AtomicReference<SwitchMapInnerObserver> atomicReference = switchMapCompletableObserver.f13672p;
                while (true) {
                    if (atomicReference.compareAndSet(this, null)) {
                        z10 = true;
                        break;
                    } else if (atomicReference.get() != this) {
                        z10 = false;
                        break;
                    }
                }
                if (!z10 || !switchMapCompletableObserver.f13671o.addThrowable(th2)) {
                    ff.a.onError(th2);
                    return;
                }
                if (switchMapCompletableObserver.f13670n) {
                    if (switchMapCompletableObserver.f13673q) {
                        switchMapCompletableObserver.f13668b.onError(switchMapCompletableObserver.f13671o.terminate());
                        return;
                    }
                    return;
                }
                switchMapCompletableObserver.dispose();
                Throwable thTerminate = switchMapCompletableObserver.f13671o.terminate();
                if (thTerminate != ExceptionHelper.f14544a) {
                    switchMapCompletableObserver.f13668b.onError(thTerminate);
                }
            }

            @Override // ne.b
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        public SwitchMapCompletableObserver(ne.b bVar, n<? super T, ? extends c> nVar, boolean z10) {
            this.f13668b = bVar;
            this.f13669m = nVar;
            this.f13670n = z10;
        }

        @Override // qe.b
        public void dispose() {
            this.f13674r.dispose();
            AtomicReference<SwitchMapInnerObserver> atomicReference = this.f13672p;
            SwitchMapInnerObserver switchMapInnerObserver = f13667s;
            SwitchMapInnerObserver andSet = atomicReference.getAndSet(switchMapInnerObserver);
            if (andSet == null || andSet == switchMapInnerObserver) {
                return;
            }
            DisposableHelper.dispose(andSet);
        }

        @Override // ne.q
        public void onComplete() {
            this.f13673q = true;
            if (this.f13672p.get() == null) {
                Throwable thTerminate = this.f13671o.terminate();
                if (thTerminate == null) {
                    this.f13668b.onComplete();
                } else {
                    this.f13668b.onError(thTerminate);
                }
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            AtomicThrowable atomicThrowable = this.f13671o;
            if (!atomicThrowable.addThrowable(th2)) {
                ff.a.onError(th2);
                return;
            }
            if (this.f13670n) {
                onComplete();
                return;
            }
            AtomicReference<SwitchMapInnerObserver> atomicReference = this.f13672p;
            SwitchMapInnerObserver switchMapInnerObserver = f13667s;
            SwitchMapInnerObserver andSet = atomicReference.getAndSet(switchMapInnerObserver);
            if (andSet != null && andSet != switchMapInnerObserver) {
                DisposableHelper.dispose(andSet);
            }
            Throwable thTerminate = atomicThrowable.terminate();
            if (thTerminate != ExceptionHelper.f14544a) {
                this.f13668b.onError(thTerminate);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            SwitchMapInnerObserver switchMapInnerObserver;
            boolean z10;
            try {
                c cVar = (c) ue.a.requireNonNull(this.f13669m.apply(t10), "The mapper returned a null CompletableSource");
                SwitchMapInnerObserver switchMapInnerObserver2 = new SwitchMapInnerObserver(this);
                do {
                    AtomicReference<SwitchMapInnerObserver> atomicReference = this.f13672p;
                    switchMapInnerObserver = atomicReference.get();
                    if (switchMapInnerObserver == f13667s) {
                        return;
                    }
                    while (true) {
                        if (atomicReference.compareAndSet(switchMapInnerObserver, switchMapInnerObserver2)) {
                            z10 = true;
                            break;
                        } else if (atomicReference.get() != switchMapInnerObserver) {
                            z10 = false;
                            break;
                        }
                    }
                } while (!z10);
                if (switchMapInnerObserver != null) {
                    DisposableHelper.dispose(switchMapInnerObserver);
                }
                cVar.subscribe(switchMapInnerObserver2);
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f13674r.dispose();
                onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f13674r, bVar)) {
                this.f13674r = bVar;
                this.f13668b.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapCompletable(k<T> kVar, n<? super T, ? extends c> nVar, boolean z10) {
        this.f13664a = kVar;
        this.f13665b = nVar;
        this.f13666c = z10;
    }

    @Override // ne.a
    public void subscribeActual(ne.b bVar) {
        k<T> kVar = this.f13664a;
        n<? super T, ? extends c> nVar = this.f13665b;
        if (i.n(kVar, nVar, bVar)) {
            return;
        }
        kVar.subscribe(new SwitchMapCompletableObserver(bVar, nVar, this.f13666c));
    }
}
