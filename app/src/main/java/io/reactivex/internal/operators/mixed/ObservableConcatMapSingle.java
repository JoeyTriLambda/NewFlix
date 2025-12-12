package io.reactivex.internal.operators.mixed;

import af.a;
import c8.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.k;
import ne.q;
import ne.t;
import ne.u;
import qe.b;
import se.n;

/* loaded from: classes2.dex */
public final class ObservableConcatMapSingle<T, R> extends k<R> {

    /* renamed from: b, reason: collision with root package name */
    public final k<T> f13648b;

    /* renamed from: m, reason: collision with root package name */
    public final n<? super T, ? extends u<? extends R>> f13649m;

    /* renamed from: n, reason: collision with root package name */
    public final ErrorMode f13650n;

    /* renamed from: o, reason: collision with root package name */
    public final int f13651o;

    public static final class ConcatMapSingleMainObserver<T, R> extends AtomicInteger implements q<T>, b {
        private static final long serialVersionUID = -9140123220065488293L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super R> f13652b;

        /* renamed from: m, reason: collision with root package name */
        public final n<? super T, ? extends u<? extends R>> f13653m;

        /* renamed from: n, reason: collision with root package name */
        public final AtomicThrowable f13654n = new AtomicThrowable();

        /* renamed from: o, reason: collision with root package name */
        public final ConcatMapSingleObserver<R> f13655o = new ConcatMapSingleObserver<>(this);

        /* renamed from: p, reason: collision with root package name */
        public final a f13656p;

        /* renamed from: q, reason: collision with root package name */
        public final ErrorMode f13657q;

        /* renamed from: r, reason: collision with root package name */
        public b f13658r;

        /* renamed from: s, reason: collision with root package name */
        public volatile boolean f13659s;

        /* renamed from: t, reason: collision with root package name */
        public volatile boolean f13660t;

        /* renamed from: u, reason: collision with root package name */
        public R f13661u;

        /* renamed from: v, reason: collision with root package name */
        public volatile int f13662v;

        public static final class ConcatMapSingleObserver<R> extends AtomicReference<b> implements t<R> {
            private static final long serialVersionUID = -3051469169682093892L;

            /* renamed from: b, reason: collision with root package name */
            public final ConcatMapSingleMainObserver<?, R> f13663b;

            public ConcatMapSingleObserver(ConcatMapSingleMainObserver<?, R> concatMapSingleMainObserver) {
                this.f13663b = concatMapSingleMainObserver;
            }

            @Override // ne.t
            public void onError(Throwable th2) {
                ConcatMapSingleMainObserver<?, R> concatMapSingleMainObserver = this.f13663b;
                if (!concatMapSingleMainObserver.f13654n.addThrowable(th2)) {
                    ff.a.onError(th2);
                    return;
                }
                if (concatMapSingleMainObserver.f13657q != ErrorMode.END) {
                    concatMapSingleMainObserver.f13658r.dispose();
                }
                concatMapSingleMainObserver.f13662v = 0;
                concatMapSingleMainObserver.a();
            }

            @Override // ne.t
            public void onSubscribe(b bVar) {
                DisposableHelper.replace(this, bVar);
            }

            @Override // ne.t
            public void onSuccess(R r10) {
                ConcatMapSingleMainObserver<?, R> concatMapSingleMainObserver = this.f13663b;
                concatMapSingleMainObserver.f13661u = r10;
                concatMapSingleMainObserver.f13662v = 2;
                concatMapSingleMainObserver.a();
            }
        }

        public ConcatMapSingleMainObserver(q<? super R> qVar, n<? super T, ? extends u<? extends R>> nVar, int i10, ErrorMode errorMode) {
            this.f13652b = qVar;
            this.f13653m = nVar;
            this.f13657q = errorMode;
            this.f13656p = new a(i10);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        
            r2.clear();
            r10.f13661u = null;
            r0.onError(r3.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a() {
            /*
                r10 = this;
                int r0 = r10.getAndIncrement()
                if (r0 == 0) goto L7
                return
            L7:
                ne.q<? super R> r0 = r10.f13652b
                io.reactivex.internal.util.ErrorMode r1 = r10.f13657q
                af.a r2 = r10.f13656p
                io.reactivex.internal.util.AtomicThrowable r3 = r10.f13654n
                r4 = 1
                r5 = 1
            L11:
                boolean r6 = r10.f13660t
                r7 = 0
                if (r6 == 0) goto L1d
                r2.clear()
                r10.f13661u = r7
                goto L98
            L1d:
                int r6 = r10.f13662v
                java.lang.Object r8 = r3.get()
                if (r8 == 0) goto L3c
                io.reactivex.internal.util.ErrorMode r8 = io.reactivex.internal.util.ErrorMode.IMMEDIATE
                if (r1 == r8) goto L2f
                io.reactivex.internal.util.ErrorMode r8 = io.reactivex.internal.util.ErrorMode.BOUNDARY
                if (r1 != r8) goto L3c
                if (r6 != 0) goto L3c
            L2f:
                r2.clear()
                r10.f13661u = r7
                java.lang.Throwable r1 = r3.terminate()
                r0.onError(r1)
                return
            L3c:
                r8 = 0
                if (r6 != 0) goto L8a
                boolean r6 = r10.f13659s
                java.lang.Object r7 = r2.poll()
                if (r7 != 0) goto L48
                r8 = 1
            L48:
                if (r6 == 0) goto L5a
                if (r8 == 0) goto L5a
                java.lang.Throwable r1 = r3.terminate()
                if (r1 != 0) goto L56
                r0.onComplete()
                goto L59
            L56:
                r0.onError(r1)
            L59:
                return
            L5a:
                if (r8 == 0) goto L5d
                goto L98
            L5d:
                se.n<? super T, ? extends ne.u<? extends R>> r6 = r10.f13653m     // Catch: java.lang.Throwable -> L73
                java.lang.Object r6 = r6.apply(r7)     // Catch: java.lang.Throwable -> L73
                java.lang.String r7 = "The mapper returned a null SingleSource"
                java.lang.Object r6 = ue.a.requireNonNull(r6, r7)     // Catch: java.lang.Throwable -> L73
                ne.u r6 = (ne.u) r6     // Catch: java.lang.Throwable -> L73
                r10.f13662v = r4
                io.reactivex.internal.operators.mixed.ObservableConcatMapSingle$ConcatMapSingleMainObserver$ConcatMapSingleObserver<R> r7 = r10.f13655o
                r6.subscribe(r7)
                goto L98
            L73:
                r1 = move-exception
                re.a.throwIfFatal(r1)
                qe.b r4 = r10.f13658r
                r4.dispose()
                r2.clear()
                r3.addThrowable(r1)
                java.lang.Throwable r1 = r3.terminate()
                r0.onError(r1)
                return
            L8a:
                r9 = 2
                if (r6 != r9) goto L98
                R r6 = r10.f13661u
                r10.f13661u = r7
                r0.onNext(r6)
                r10.f13662v = r8
                goto L11
            L98:
                int r5 = -r5
                int r5 = r10.addAndGet(r5)
                if (r5 != 0) goto L11
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.mixed.ObservableConcatMapSingle.ConcatMapSingleMainObserver.a():void");
        }

        @Override // qe.b
        public void dispose() {
            this.f13660t = true;
            this.f13658r.dispose();
            ConcatMapSingleObserver<R> concatMapSingleObserver = this.f13655o;
            concatMapSingleObserver.getClass();
            DisposableHelper.dispose(concatMapSingleObserver);
            if (getAndIncrement() == 0) {
                this.f13656p.clear();
                this.f13661u = null;
            }
        }

        @Override // ne.q
        public void onComplete() {
            this.f13659s = true;
            a();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (!this.f13654n.addThrowable(th2)) {
                ff.a.onError(th2);
                return;
            }
            if (this.f13657q == ErrorMode.IMMEDIATE) {
                ConcatMapSingleObserver<R> concatMapSingleObserver = this.f13655o;
                concatMapSingleObserver.getClass();
                DisposableHelper.dispose(concatMapSingleObserver);
            }
            this.f13659s = true;
            a();
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f13656p.offer(t10);
            a();
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f13658r, bVar)) {
                this.f13658r = bVar;
                this.f13652b.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapSingle(k<T> kVar, n<? super T, ? extends u<? extends R>> nVar, ErrorMode errorMode, int i10) {
        this.f13648b = kVar;
        this.f13649m = nVar;
        this.f13650n = errorMode;
        this.f13651o = i10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super R> qVar) {
        k<T> kVar = this.f13648b;
        n<? super T, ? extends u<? extends R>> nVar = this.f13649m;
        if (i.p(kVar, nVar, qVar)) {
            return;
        }
        kVar.subscribe(new ConcatMapSingleMainObserver(qVar, nVar, this.f13651o, this.f13650n));
    }
}
