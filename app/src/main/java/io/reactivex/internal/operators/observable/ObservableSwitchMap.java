package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.o;
import ne.q;
import qe.b;
import se.n;
import ve.f;

/* loaded from: classes2.dex */
public final class ObservableSwitchMap<T, R> extends ye.a<T, R> {

    /* renamed from: m, reason: collision with root package name */
    public final n<? super T, ? extends o<? extends R>> f14279m;

    /* renamed from: n, reason: collision with root package name */
    public final int f14280n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f14281o;

    public static final class SwitchMapInnerObserver<T, R> extends AtomicReference<b> implements q<R> {
        private static final long serialVersionUID = 3837284832786408377L;

        /* renamed from: b, reason: collision with root package name */
        public final SwitchMapObserver<T, R> f14282b;

        /* renamed from: m, reason: collision with root package name */
        public final long f14283m;

        /* renamed from: n, reason: collision with root package name */
        public final int f14284n;

        /* renamed from: o, reason: collision with root package name */
        public volatile f<R> f14285o;

        /* renamed from: p, reason: collision with root package name */
        public volatile boolean f14286p;

        public SwitchMapInnerObserver(SwitchMapObserver<T, R> switchMapObserver, long j10, int i10) {
            this.f14282b = switchMapObserver;
            this.f14283m = j10;
            this.f14284n = i10;
        }

        public void cancel() {
            DisposableHelper.dispose(this);
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f14283m == this.f14282b.f14297u) {
                this.f14286p = true;
                this.f14282b.b();
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            SwitchMapObserver<T, R> switchMapObserver = this.f14282b;
            switchMapObserver.getClass();
            if (this.f14283m != switchMapObserver.f14297u || !switchMapObserver.f14292p.addThrowable(th2)) {
                ff.a.onError(th2);
                return;
            }
            if (!switchMapObserver.f14291o) {
                switchMapObserver.f14295s.dispose();
                switchMapObserver.f14293q = true;
            }
            this.f14286p = true;
            switchMapObserver.b();
        }

        @Override // ne.q
        public void onNext(R r10) {
            if (this.f14283m == this.f14282b.f14297u) {
                if (r10 != null) {
                    this.f14285o.offer(r10);
                }
                this.f14282b.b();
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                if (bVar instanceof ve.b) {
                    ve.b bVar2 = (ve.b) bVar;
                    int iRequestFusion = bVar2.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.f14285o = bVar2;
                        this.f14286p = true;
                        this.f14282b.b();
                        return;
                    } else if (iRequestFusion == 2) {
                        this.f14285o = bVar2;
                        return;
                    }
                }
                this.f14285o = new af.a(this.f14284n);
            }
        }
    }

    public static final class SwitchMapObserver<T, R> extends AtomicInteger implements q<T>, b {
        private static final long serialVersionUID = -3491074160481096299L;

        /* renamed from: v, reason: collision with root package name */
        public static final SwitchMapInnerObserver<Object, Object> f14287v;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super R> f14288b;

        /* renamed from: m, reason: collision with root package name */
        public final n<? super T, ? extends o<? extends R>> f14289m;

        /* renamed from: n, reason: collision with root package name */
        public final int f14290n;

        /* renamed from: o, reason: collision with root package name */
        public final boolean f14291o;

        /* renamed from: q, reason: collision with root package name */
        public volatile boolean f14293q;

        /* renamed from: r, reason: collision with root package name */
        public volatile boolean f14294r;

        /* renamed from: s, reason: collision with root package name */
        public b f14295s;

        /* renamed from: u, reason: collision with root package name */
        public volatile long f14297u;

        /* renamed from: t, reason: collision with root package name */
        public final AtomicReference<SwitchMapInnerObserver<T, R>> f14296t = new AtomicReference<>();

        /* renamed from: p, reason: collision with root package name */
        public final AtomicThrowable f14292p = new AtomicThrowable();

        static {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver = new SwitchMapInnerObserver<>(null, -1L, 1);
            f14287v = switchMapInnerObserver;
            switchMapInnerObserver.cancel();
        }

        public SwitchMapObserver(q<? super R> qVar, n<? super T, ? extends o<? extends R>> nVar, int i10, boolean z10) {
            this.f14288b = qVar;
            this.f14289m = nVar;
            this.f14290n = i10;
            this.f14291o = z10;
        }

        public final void a() {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver;
            AtomicReference<SwitchMapInnerObserver<T, R>> atomicReference = this.f14296t;
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver2 = (SwitchMapInnerObserver) atomicReference.get();
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver3 = f14287v;
            if (switchMapInnerObserver2 == switchMapInnerObserver3 || (switchMapInnerObserver = (SwitchMapInnerObserver) atomicReference.getAndSet(switchMapInnerObserver3)) == switchMapInnerObserver3 || switchMapInnerObserver == null) {
                return;
            }
            switchMapInnerObserver.cancel();
        }

        /* JADX WARN: Removed duplicated region for block: B:115:0x0113 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:122:0x000f A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void b() {
            /*
                Method dump skipped, instructions count: 283
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapObserver.b():void");
        }

        @Override // qe.b
        public void dispose() {
            if (this.f14294r) {
                return;
            }
            this.f14294r = true;
            this.f14295s.dispose();
            a();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f14293q) {
                return;
            }
            this.f14293q = true;
            b();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f14293q || !this.f14292p.addThrowable(th2)) {
                ff.a.onError(th2);
                return;
            }
            if (!this.f14291o) {
                a();
            }
            this.f14293q = true;
            b();
        }

        @Override // ne.q
        public void onNext(T t10) {
            boolean z10;
            long j10 = this.f14297u + 1;
            this.f14297u = j10;
            SwitchMapInnerObserver<T, R> switchMapInnerObserver = this.f14296t.get();
            if (switchMapInnerObserver != null) {
                switchMapInnerObserver.cancel();
            }
            try {
                o oVar = (o) ue.a.requireNonNull(this.f14289m.apply(t10), "The ObservableSource returned is null");
                SwitchMapInnerObserver<T, R> switchMapInnerObserver2 = new SwitchMapInnerObserver<>(this, j10, this.f14290n);
                do {
                    SwitchMapInnerObserver<T, R> switchMapInnerObserver3 = this.f14296t.get();
                    if (switchMapInnerObserver3 == f14287v) {
                        return;
                    }
                    AtomicReference<SwitchMapInnerObserver<T, R>> atomicReference = this.f14296t;
                    while (true) {
                        if (atomicReference.compareAndSet(switchMapInnerObserver3, switchMapInnerObserver2)) {
                            z10 = true;
                            break;
                        } else if (atomicReference.get() != switchMapInnerObserver3) {
                            z10 = false;
                            break;
                        }
                    }
                } while (!z10);
                oVar.subscribe(switchMapInnerObserver2);
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f14295s.dispose();
                onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f14295s, bVar)) {
                this.f14295s = bVar;
                this.f14288b.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMap(o<T> oVar, n<? super T, ? extends o<? extends R>> nVar, int i10, boolean z10) {
        super(oVar);
        this.f14279m = nVar;
        this.f14280n = i10;
        this.f14281o = z10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super R> qVar) {
        o<T> oVar = this.f22058b;
        n<? super T, ? extends o<? extends R>> nVar = this.f14279m;
        if (ObservableScalarXMap.tryScalarXMapSubscribe(oVar, qVar, nVar)) {
            return;
        }
        oVar.subscribe(new SwitchMapObserver(qVar, nVar, this.f14280n, this.f14281o));
    }
}
