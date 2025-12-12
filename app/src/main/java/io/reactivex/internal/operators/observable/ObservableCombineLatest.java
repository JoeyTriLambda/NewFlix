package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.k;
import ne.o;
import ne.q;
import qe.b;
import se.n;

/* loaded from: classes2.dex */
public final class ObservableCombineLatest<T, R> extends k<R> {

    /* renamed from: b, reason: collision with root package name */
    public final o<? extends T>[] f13773b;

    /* renamed from: m, reason: collision with root package name */
    public final Iterable<? extends o<? extends T>> f13774m;

    /* renamed from: n, reason: collision with root package name */
    public final n<? super Object[], ? extends R> f13775n;

    /* renamed from: o, reason: collision with root package name */
    public final int f13776o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f13777p;

    public static final class CombinerObserver<T, R> extends AtomicReference<b> implements q<T> {
        private static final long serialVersionUID = -4823716997131257941L;

        /* renamed from: b, reason: collision with root package name */
        public final LatestCoordinator<T, R> f13778b;

        /* renamed from: m, reason: collision with root package name */
        public final int f13779m;

        public CombinerObserver(LatestCoordinator<T, R> latestCoordinator, int i10) {
            this.f13778b = latestCoordinator;
            this.f13779m = i10;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d A[Catch: all -> 0x0029, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0009, B:8:0x000b, B:13:0x0015, B:16:0x001f, B:15:0x001d), top: B:24:0x0005 }] */
        @Override // ne.q
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onComplete() {
            /*
                r5 = this;
                io.reactivex.internal.operators.observable.ObservableCombineLatest$LatestCoordinator<T, R> r0 = r5.f13778b
                int r1 = r5.f13779m
                monitor-enter(r0)
                java.lang.Object[] r2 = r0.f13783o     // Catch: java.lang.Throwable -> L29
                if (r2 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L29
                goto L28
            Lb:
                r1 = r2[r1]     // Catch: java.lang.Throwable -> L29
                r3 = 1
                if (r1 != 0) goto L12
                r1 = 1
                goto L13
            L12:
                r1 = 0
            L13:
                if (r1 != 0) goto L1d
                int r4 = r0.f13790v     // Catch: java.lang.Throwable -> L29
                int r4 = r4 + r3
                r0.f13790v = r4     // Catch: java.lang.Throwable -> L29
                int r2 = r2.length     // Catch: java.lang.Throwable -> L29
                if (r4 != r2) goto L1f
            L1d:
                r0.f13787s = r3     // Catch: java.lang.Throwable -> L29
            L1f:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L29
                if (r1 == 0) goto L25
                r0.a()
            L25:
                r0.c()
            L28:
                return
            L29:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L29
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.CombinerObserver.onComplete():void");
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0029 A[Catch: all -> 0x002e, TryCatch #0 {, blocks: (B:7:0x0012, B:9:0x0016, B:11:0x0018, B:16:0x0021, B:19:0x002b, B:18:0x0029), top: B:29:0x0012 }] */
        @Override // ne.q
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onError(java.lang.Throwable r5) {
            /*
                r4 = this;
                io.reactivex.internal.operators.observable.ObservableCombineLatest$LatestCoordinator<T, R> r0 = r4.f13778b
                int r1 = r4.f13779m
                io.reactivex.internal.util.AtomicThrowable r2 = r0.f13788t
                boolean r2 = r2.addThrowable(r5)
                if (r2 == 0) goto L3a
                boolean r5 = r0.f13785q
                r2 = 1
                if (r5 == 0) goto L31
                monitor-enter(r0)
                java.lang.Object[] r5 = r0.f13783o     // Catch: java.lang.Throwable -> L2e
                if (r5 != 0) goto L18
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L2e
                goto L3d
            L18:
                r1 = r5[r1]     // Catch: java.lang.Throwable -> L2e
                if (r1 != 0) goto L1e
                r1 = 1
                goto L1f
            L1e:
                r1 = 0
            L1f:
                if (r1 != 0) goto L29
                int r3 = r0.f13790v     // Catch: java.lang.Throwable -> L2e
                int r3 = r3 + r2
                r0.f13790v = r3     // Catch: java.lang.Throwable -> L2e
                int r5 = r5.length     // Catch: java.lang.Throwable -> L2e
                if (r3 != r5) goto L2b
            L29:
                r0.f13787s = r2     // Catch: java.lang.Throwable -> L2e
            L2b:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L2e
                r2 = r1
                goto L31
            L2e:
                r5 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L2e
                throw r5
            L31:
                if (r2 == 0) goto L36
                r0.a()
            L36:
                r0.c()
                goto L3d
            L3a:
                ff.a.onError(r5)
            L3d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.CombinerObserver.onError(java.lang.Throwable):void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ne.q
        public void onNext(T t10) {
            boolean z10;
            LatestCoordinator<T, R> latestCoordinator = this.f13778b;
            int i10 = this.f13779m;
            synchronized (latestCoordinator) {
                Object[] objArr = latestCoordinator.f13783o;
                if (objArr == null) {
                    return;
                }
                Object obj = objArr[i10];
                int i11 = latestCoordinator.f13789u;
                if (obj == null) {
                    i11++;
                    latestCoordinator.f13789u = i11;
                }
                objArr[i10] = t10;
                if (i11 == objArr.length) {
                    latestCoordinator.f13784p.offer(objArr.clone());
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    latestCoordinator.c();
                }
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public static final class LatestCoordinator<T, R> extends AtomicInteger implements b {
        private static final long serialVersionUID = 8567835998786448817L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super R> f13780b;

        /* renamed from: m, reason: collision with root package name */
        public final n<? super Object[], ? extends R> f13781m;

        /* renamed from: n, reason: collision with root package name */
        public final CombinerObserver<T, R>[] f13782n;

        /* renamed from: o, reason: collision with root package name */
        public Object[] f13783o;

        /* renamed from: p, reason: collision with root package name */
        public final af.a<Object[]> f13784p;

        /* renamed from: q, reason: collision with root package name */
        public final boolean f13785q;

        /* renamed from: r, reason: collision with root package name */
        public volatile boolean f13786r;

        /* renamed from: s, reason: collision with root package name */
        public volatile boolean f13787s;

        /* renamed from: t, reason: collision with root package name */
        public final AtomicThrowable f13788t = new AtomicThrowable();

        /* renamed from: u, reason: collision with root package name */
        public int f13789u;

        /* renamed from: v, reason: collision with root package name */
        public int f13790v;

        public LatestCoordinator(int i10, int i11, q qVar, n nVar, boolean z10) {
            this.f13780b = qVar;
            this.f13781m = nVar;
            this.f13785q = z10;
            this.f13783o = new Object[i10];
            CombinerObserver<T, R>[] combinerObserverArr = new CombinerObserver[i10];
            for (int i12 = 0; i12 < i10; i12++) {
                combinerObserverArr[i12] = new CombinerObserver<>(this, i12);
            }
            this.f13782n = combinerObserverArr;
            this.f13784p = new af.a<>(i11);
        }

        public final void a() {
            for (CombinerObserver<T, R> combinerObserver : this.f13782n) {
                combinerObserver.dispose();
            }
        }

        public final void b(af.a<?> aVar) {
            synchronized (this) {
                this.f13783o = null;
            }
            aVar.clear();
        }

        public final void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            af.a<Object[]> aVar = this.f13784p;
            q<? super R> qVar = this.f13780b;
            boolean z10 = this.f13785q;
            int iAddAndGet = 1;
            while (!this.f13786r) {
                if (!z10 && this.f13788t.get() != null) {
                    a();
                    b(aVar);
                    qVar.onError(this.f13788t.terminate());
                    return;
                }
                boolean z11 = this.f13787s;
                Object[] objArrPoll = aVar.poll();
                boolean z12 = objArrPoll == null;
                if (z11 && z12) {
                    b(aVar);
                    Throwable thTerminate = this.f13788t.terminate();
                    if (thTerminate == null) {
                        qVar.onComplete();
                        return;
                    } else {
                        qVar.onError(thTerminate);
                        return;
                    }
                }
                if (z12) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    try {
                        qVar.onNext((Object) ue.a.requireNonNull(this.f13781m.apply(objArrPoll), "The combiner returned a null value"));
                    } catch (Throwable th2) {
                        re.a.throwIfFatal(th2);
                        this.f13788t.addThrowable(th2);
                        a();
                        b(aVar);
                        qVar.onError(this.f13788t.terminate());
                        return;
                    }
                }
            }
            b(aVar);
        }

        @Override // qe.b
        public void dispose() {
            if (this.f13786r) {
                return;
            }
            this.f13786r = true;
            a();
            if (getAndIncrement() == 0) {
                b(this.f13784p);
            }
        }

        public void subscribe(o<? extends T>[] oVarArr) {
            CombinerObserver<T, R>[] combinerObserverArr = this.f13782n;
            int length = combinerObserverArr.length;
            this.f13780b.onSubscribe(this);
            for (int i10 = 0; i10 < length && !this.f13787s && !this.f13786r; i10++) {
                oVarArr[i10].subscribe(combinerObserverArr[i10]);
            }
        }
    }

    public ObservableCombineLatest(o<? extends T>[] oVarArr, Iterable<? extends o<? extends T>> iterable, n<? super Object[], ? extends R> nVar, int i10, boolean z10) {
        this.f13773b = oVarArr;
        this.f13774m = iterable;
        this.f13775n = nVar;
        this.f13776o = i10;
        this.f13777p = z10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super R> qVar) {
        int length;
        o<? extends T>[] oVarArr = this.f13773b;
        if (oVarArr == null) {
            oVarArr = new o[8];
            length = 0;
            for (o<? extends T> oVar : this.f13774m) {
                if (length == oVarArr.length) {
                    o<? extends T>[] oVarArr2 = new o[(length >> 2) + length];
                    System.arraycopy(oVarArr, 0, oVarArr2, 0, length);
                    oVarArr = oVarArr2;
                }
                oVarArr[length] = oVar;
                length++;
            }
        } else {
            length = oVarArr.length;
        }
        int i10 = length;
        if (i10 == 0) {
            EmptyDisposable.complete(qVar);
        } else {
            new LatestCoordinator(i10, this.f13776o, qVar, this.f13775n, this.f13777p).subscribe(oVarArr);
        }
    }
}
