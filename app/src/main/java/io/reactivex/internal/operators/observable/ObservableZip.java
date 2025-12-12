package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.k;
import ne.o;
import ne.q;
import qe.b;
import se.n;

/* loaded from: classes2.dex */
public final class ObservableZip<T, R> extends k<R> {

    /* renamed from: b, reason: collision with root package name */
    public final o<? extends T>[] f14479b;

    /* renamed from: m, reason: collision with root package name */
    public final Iterable<? extends o<? extends T>> f14480m;

    /* renamed from: n, reason: collision with root package name */
    public final n<? super Object[], ? extends R> f14481n;

    /* renamed from: o, reason: collision with root package name */
    public final int f14482o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f14483p;

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements b {
        private static final long serialVersionUID = 2983708048395377667L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super R> f14484b;

        /* renamed from: m, reason: collision with root package name */
        public final n<? super Object[], ? extends R> f14485m;

        /* renamed from: n, reason: collision with root package name */
        public final a<T, R>[] f14486n;

        /* renamed from: o, reason: collision with root package name */
        public final T[] f14487o;

        /* renamed from: p, reason: collision with root package name */
        public final boolean f14488p;

        /* renamed from: q, reason: collision with root package name */
        public volatile boolean f14489q;

        public ZipCoordinator(q<? super R> qVar, n<? super Object[], ? extends R> nVar, int i10, boolean z10) {
            this.f14484b = qVar;
            this.f14485m = nVar;
            this.f14486n = new a[i10];
            this.f14487o = (T[]) new Object[i10];
            this.f14488p = z10;
        }

        public final void a() {
            a<T, R>[] aVarArr = this.f14486n;
            for (a<T, R> aVar : aVarArr) {
                aVar.f14491m.clear();
            }
            for (a<T, R> aVar2 : aVarArr) {
                aVar2.dispose();
            }
        }

        @Override // qe.b
        public void dispose() {
            if (this.f14489q) {
                return;
            }
            this.f14489q = true;
            for (a<T, R> aVar : this.f14486n) {
                aVar.dispose();
            }
            if (getAndIncrement() == 0) {
                for (a<T, R> aVar2 : this.f14486n) {
                    aVar2.f14491m.clear();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0067 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void drain() {
            /*
                r16 = this;
                r1 = r16
                int r0 = r16.getAndIncrement()
                if (r0 == 0) goto L9
                return
            L9:
                io.reactivex.internal.operators.observable.ObservableZip$a<T, R>[] r0 = r1.f14486n
                ne.q<? super R> r2 = r1.f14484b
                T[] r3 = r1.f14487o
                boolean r4 = r1.f14488p
                r5 = 1
                r6 = 1
            L13:
                int r7 = r0.length
                r9 = 0
                r10 = 0
                r11 = 0
            L17:
                if (r9 >= r7) goto L88
                r12 = r0[r9]
                r13 = r3[r11]
                if (r13 != 0) goto L70
                boolean r13 = r12.f14492n
                af.a<T> r14 = r12.f14491m
                java.lang.Object r14 = r14.poll()
                if (r14 != 0) goto L2b
                r15 = 1
                goto L2c
            L2b:
                r15 = 0
            L2c:
                boolean r8 = r1.f14489q
                if (r8 == 0) goto L35
                r16.a()
            L33:
                r8 = 1
                goto L65
            L35:
                if (r13 == 0) goto L64
                if (r4 == 0) goto L4c
                if (r15 == 0) goto L64
                java.lang.Throwable r8 = r12.f14493o
                r1.f14489q = r5
                r16.a()
                if (r8 == 0) goto L48
                r2.onError(r8)
                goto L33
            L48:
                r2.onComplete()
                goto L33
            L4c:
                java.lang.Throwable r8 = r12.f14493o
                if (r8 == 0) goto L59
                r1.f14489q = r5
                r16.a()
                r2.onError(r8)
                goto L33
            L59:
                if (r15 == 0) goto L64
                r1.f14489q = r5
                r16.a()
                r2.onComplete()
                goto L33
            L64:
                r8 = 0
            L65:
                if (r8 == 0) goto L68
                return
            L68:
                if (r15 != 0) goto L6d
                r3[r11] = r14
                goto L83
            L6d:
                int r10 = r10 + 1
                goto L83
            L70:
                boolean r8 = r12.f14492n
                if (r8 == 0) goto L83
                if (r4 != 0) goto L83
                java.lang.Throwable r8 = r12.f14493o
                if (r8 == 0) goto L83
                r1.f14489q = r5
                r16.a()
                r2.onError(r8)
                return
            L83:
                int r11 = r11 + 1
                int r9 = r9 + 1
                goto L17
            L88:
                if (r10 == 0) goto L92
                int r6 = -r6
                int r6 = r1.addAndGet(r6)
                if (r6 != 0) goto L13
                return
            L92:
                se.n<? super java.lang.Object[], ? extends R> r7 = r1.f14485m     // Catch: java.lang.Throwable -> Lab
                java.lang.Object r8 = r3.clone()     // Catch: java.lang.Throwable -> Lab
                java.lang.Object r7 = r7.apply(r8)     // Catch: java.lang.Throwable -> Lab
                java.lang.String r8 = "The zipper returned a null value"
                java.lang.Object r7 = ue.a.requireNonNull(r7, r8)     // Catch: java.lang.Throwable -> Lab
                r2.onNext(r7)
                r7 = 0
                java.util.Arrays.fill(r3, r7)
                goto L13
            Lab:
                r0 = move-exception
                re.a.throwIfFatal(r0)
                r16.a()
                r2.onError(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableZip.ZipCoordinator.drain():void");
        }

        public void subscribe(o<? extends T>[] oVarArr, int i10) {
            a<T, R>[] aVarArr = this.f14486n;
            int length = aVarArr.length;
            for (int i11 = 0; i11 < length; i11++) {
                aVarArr[i11] = new a<>(this, i10);
            }
            lazySet(0);
            this.f14484b.onSubscribe(this);
            for (int i12 = 0; i12 < length && !this.f14489q; i12++) {
                oVarArr[i12].subscribe(aVarArr[i12]);
            }
        }
    }

    public static final class a<T, R> implements q<T> {

        /* renamed from: b, reason: collision with root package name */
        public final ZipCoordinator<T, R> f14490b;

        /* renamed from: m, reason: collision with root package name */
        public final af.a<T> f14491m;

        /* renamed from: n, reason: collision with root package name */
        public volatile boolean f14492n;

        /* renamed from: o, reason: collision with root package name */
        public Throwable f14493o;

        /* renamed from: p, reason: collision with root package name */
        public final AtomicReference<b> f14494p = new AtomicReference<>();

        public a(ZipCoordinator<T, R> zipCoordinator, int i10) {
            this.f14490b = zipCoordinator;
            this.f14491m = new af.a<>(i10);
        }

        public void dispose() {
            DisposableHelper.dispose(this.f14494p);
        }

        @Override // ne.q
        public void onComplete() {
            this.f14492n = true;
            this.f14490b.drain();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f14493o = th2;
            this.f14492n = true;
            this.f14490b.drain();
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f14491m.offer(t10);
            this.f14490b.drain();
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.f14494p, bVar);
        }
    }

    public ObservableZip(o<? extends T>[] oVarArr, Iterable<? extends o<? extends T>> iterable, n<? super Object[], ? extends R> nVar, int i10, boolean z10) {
        this.f14479b = oVarArr;
        this.f14480m = iterable;
        this.f14481n = nVar;
        this.f14482o = i10;
        this.f14483p = z10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super R> qVar) {
        int length;
        o<? extends T>[] oVarArr = this.f14479b;
        if (oVarArr == null) {
            oVarArr = new o[8];
            length = 0;
            for (o<? extends T> oVar : this.f14480m) {
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
        if (length == 0) {
            EmptyDisposable.complete(qVar);
        } else {
            new ZipCoordinator(qVar, this.f14481n, length, this.f14483p).subscribe(oVarArr, this.f14482o);
        }
    }
}
