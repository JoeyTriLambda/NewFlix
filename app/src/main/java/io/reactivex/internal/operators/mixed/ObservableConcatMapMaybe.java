package io.reactivex.internal.operators.mixed;

import af.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.h;
import ne.i;
import ne.k;
import ne.q;
import qe.b;
import se.n;

/* loaded from: classes2.dex */
public final class ObservableConcatMapMaybe<T, R> extends k<R> {

    /* renamed from: b, reason: collision with root package name */
    public final k<T> f13632b;

    /* renamed from: m, reason: collision with root package name */
    public final n<? super T, ? extends i<? extends R>> f13633m;

    /* renamed from: n, reason: collision with root package name */
    public final ErrorMode f13634n;

    /* renamed from: o, reason: collision with root package name */
    public final int f13635o;

    public static final class ConcatMapMaybeMainObserver<T, R> extends AtomicInteger implements q<T>, b {
        private static final long serialVersionUID = -9140123220065488293L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super R> f13636b;

        /* renamed from: m, reason: collision with root package name */
        public final n<? super T, ? extends i<? extends R>> f13637m;

        /* renamed from: n, reason: collision with root package name */
        public final AtomicThrowable f13638n = new AtomicThrowable();

        /* renamed from: o, reason: collision with root package name */
        public final ConcatMapMaybeObserver<R> f13639o = new ConcatMapMaybeObserver<>(this);

        /* renamed from: p, reason: collision with root package name */
        public final a f13640p;

        /* renamed from: q, reason: collision with root package name */
        public final ErrorMode f13641q;

        /* renamed from: r, reason: collision with root package name */
        public b f13642r;

        /* renamed from: s, reason: collision with root package name */
        public volatile boolean f13643s;

        /* renamed from: t, reason: collision with root package name */
        public volatile boolean f13644t;

        /* renamed from: u, reason: collision with root package name */
        public R f13645u;

        /* renamed from: v, reason: collision with root package name */
        public volatile int f13646v;

        public static final class ConcatMapMaybeObserver<R> extends AtomicReference<b> implements h<R> {
            private static final long serialVersionUID = -3051469169682093892L;

            /* renamed from: b, reason: collision with root package name */
            public final ConcatMapMaybeMainObserver<?, R> f13647b;

            public ConcatMapMaybeObserver(ConcatMapMaybeMainObserver<?, R> concatMapMaybeMainObserver) {
                this.f13647b = concatMapMaybeMainObserver;
            }

            @Override // ne.h
            public void onComplete() {
                ConcatMapMaybeMainObserver<?, R> concatMapMaybeMainObserver = this.f13647b;
                concatMapMaybeMainObserver.f13646v = 0;
                concatMapMaybeMainObserver.a();
            }

            @Override // ne.h
            public void onError(Throwable th2) {
                ConcatMapMaybeMainObserver<?, R> concatMapMaybeMainObserver = this.f13647b;
                if (!concatMapMaybeMainObserver.f13638n.addThrowable(th2)) {
                    ff.a.onError(th2);
                    return;
                }
                if (concatMapMaybeMainObserver.f13641q != ErrorMode.END) {
                    concatMapMaybeMainObserver.f13642r.dispose();
                }
                concatMapMaybeMainObserver.f13646v = 0;
                concatMapMaybeMainObserver.a();
            }

            @Override // ne.h
            public void onSubscribe(b bVar) {
                DisposableHelper.replace(this, bVar);
            }

            @Override // ne.h
            public void onSuccess(R r10) {
                ConcatMapMaybeMainObserver<?, R> concatMapMaybeMainObserver = this.f13647b;
                concatMapMaybeMainObserver.f13645u = r10;
                concatMapMaybeMainObserver.f13646v = 2;
                concatMapMaybeMainObserver.a();
            }
        }

        public ConcatMapMaybeMainObserver(q<? super R> qVar, n<? super T, ? extends i<? extends R>> nVar, int i10, ErrorMode errorMode) {
            this.f13636b = qVar;
            this.f13637m = nVar;
            this.f13641q = errorMode;
            this.f13640p = new a(i10);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        
            r2.clear();
            r10.f13645u = null;
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
                ne.q<? super R> r0 = r10.f13636b
                io.reactivex.internal.util.ErrorMode r1 = r10.f13641q
                af.a r2 = r10.f13640p
                io.reactivex.internal.util.AtomicThrowable r3 = r10.f13638n
                r4 = 1
                r5 = 1
            L11:
                boolean r6 = r10.f13644t
                r7 = 0
                if (r6 == 0) goto L1d
                r2.clear()
                r10.f13645u = r7
                goto L98
            L1d:
                int r6 = r10.f13646v
                java.lang.Object r8 = r3.get()
                if (r8 == 0) goto L3c
                io.reactivex.internal.util.ErrorMode r8 = io.reactivex.internal.util.ErrorMode.IMMEDIATE
                if (r1 == r8) goto L2f
                io.reactivex.internal.util.ErrorMode r8 = io.reactivex.internal.util.ErrorMode.BOUNDARY
                if (r1 != r8) goto L3c
                if (r6 != 0) goto L3c
            L2f:
                r2.clear()
                r10.f13645u = r7
                java.lang.Throwable r1 = r3.terminate()
                r0.onError(r1)
                return
            L3c:
                r8 = 0
                if (r6 != 0) goto L8a
                boolean r6 = r10.f13643s
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
                se.n<? super T, ? extends ne.i<? extends R>> r6 = r10.f13637m     // Catch: java.lang.Throwable -> L73
                java.lang.Object r6 = r6.apply(r7)     // Catch: java.lang.Throwable -> L73
                java.lang.String r7 = "The mapper returned a null MaybeSource"
                java.lang.Object r6 = ue.a.requireNonNull(r6, r7)     // Catch: java.lang.Throwable -> L73
                ne.i r6 = (ne.i) r6     // Catch: java.lang.Throwable -> L73
                r10.f13646v = r4
                io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe$ConcatMapMaybeMainObserver$ConcatMapMaybeObserver<R> r7 = r10.f13639o
                r6.subscribe(r7)
                goto L98
            L73:
                r1 = move-exception
                re.a.throwIfFatal(r1)
                qe.b r4 = r10.f13642r
                r4.dispose()
                r2.clear()
                r3.addThrowable(r1)
                java.lang.Throwable r1 = r3.terminate()
                r0.onError(r1)
                return
            L8a:
                r9 = 2
                if (r6 != r9) goto L98
                R r6 = r10.f13645u
                r10.f13645u = r7
                r0.onNext(r6)
                r10.f13646v = r8
                goto L11
            L98:
                int r5 = -r5
                int r5 = r10.addAndGet(r5)
                if (r5 != 0) goto L11
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe.ConcatMapMaybeMainObserver.a():void");
        }

        @Override // qe.b
        public void dispose() {
            this.f13644t = true;
            this.f13642r.dispose();
            ConcatMapMaybeObserver<R> concatMapMaybeObserver = this.f13639o;
            concatMapMaybeObserver.getClass();
            DisposableHelper.dispose(concatMapMaybeObserver);
            if (getAndIncrement() == 0) {
                this.f13640p.clear();
                this.f13645u = null;
            }
        }

        @Override // ne.q
        public void onComplete() {
            this.f13643s = true;
            a();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (!this.f13638n.addThrowable(th2)) {
                ff.a.onError(th2);
                return;
            }
            if (this.f13641q == ErrorMode.IMMEDIATE) {
                ConcatMapMaybeObserver<R> concatMapMaybeObserver = this.f13639o;
                concatMapMaybeObserver.getClass();
                DisposableHelper.dispose(concatMapMaybeObserver);
            }
            this.f13643s = true;
            a();
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f13640p.offer(t10);
            a();
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f13642r, bVar)) {
                this.f13642r = bVar;
                this.f13636b.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapMaybe(k<T> kVar, n<? super T, ? extends i<? extends R>> nVar, ErrorMode errorMode, int i10) {
        this.f13632b = kVar;
        this.f13633m = nVar;
        this.f13634n = errorMode;
        this.f13635o = i10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super R> qVar) {
        k<T> kVar = this.f13632b;
        n<? super T, ? extends i<? extends R>> nVar = this.f13633m;
        if (c8.i.o(kVar, nVar, qVar)) {
            return;
        }
        kVar.subscribe(new ConcatMapMaybeMainObserver(qVar, nVar, this.f13635o, this.f13634n));
    }
}
