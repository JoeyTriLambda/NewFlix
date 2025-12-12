package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.o;
import ne.q;
import qe.b;
import se.n;
import ve.e;
import ve.f;

/* loaded from: classes2.dex */
public final class ObservableFlatMap<T, U> extends ye.a<T, U> {

    /* renamed from: m, reason: collision with root package name */
    public final n<? super T, ? extends o<? extends U>> f13872m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f13873n;

    /* renamed from: o, reason: collision with root package name */
    public final int f13874o;

    /* renamed from: p, reason: collision with root package name */
    public final int f13875p;

    public static final class InnerObserver<T, U> extends AtomicReference<b> implements q<U> {
        private static final long serialVersionUID = -4606175640614850599L;

        /* renamed from: b, reason: collision with root package name */
        public final long f13876b;

        /* renamed from: m, reason: collision with root package name */
        public final MergeObserver<T, U> f13877m;

        /* renamed from: n, reason: collision with root package name */
        public volatile boolean f13878n;

        /* renamed from: o, reason: collision with root package name */
        public volatile f<U> f13879o;

        /* renamed from: p, reason: collision with root package name */
        public int f13880p;

        public InnerObserver(MergeObserver<T, U> mergeObserver, long j10) {
            this.f13876b = j10;
            this.f13877m = mergeObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // ne.q
        public void onComplete() {
            this.f13878n = true;
            this.f13877m.c();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (!this.f13877m.f13888s.addThrowable(th2)) {
                ff.a.onError(th2);
                return;
            }
            MergeObserver<T, U> mergeObserver = this.f13877m;
            if (!mergeObserver.f13883n) {
                mergeObserver.b();
            }
            this.f13878n = true;
            this.f13877m.c();
        }

        @Override // ne.q
        public void onNext(U u10) {
            if (this.f13880p != 0) {
                this.f13877m.c();
                return;
            }
            MergeObserver<T, U> mergeObserver = this.f13877m;
            if (mergeObserver.get() == 0 && mergeObserver.compareAndSet(0, 1)) {
                mergeObserver.f13881b.onNext(u10);
                if (mergeObserver.decrementAndGet() == 0) {
                    return;
                }
            } else {
                f aVar = this.f13879o;
                if (aVar == null) {
                    aVar = new af.a(mergeObserver.f13885p);
                    this.f13879o = aVar;
                }
                aVar.offer(u10);
                if (mergeObserver.getAndIncrement() != 0) {
                    return;
                }
            }
            mergeObserver.d();
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.setOnce(this, bVar) && (bVar instanceof ve.b)) {
                ve.b bVar2 = (ve.b) bVar;
                int iRequestFusion = bVar2.requestFusion(7);
                if (iRequestFusion == 1) {
                    this.f13880p = iRequestFusion;
                    this.f13879o = bVar2;
                    this.f13878n = true;
                    this.f13877m.c();
                    return;
                }
                if (iRequestFusion == 2) {
                    this.f13880p = iRequestFusion;
                    this.f13879o = bVar2;
                }
            }
        }
    }

    public static final class MergeObserver<T, U> extends AtomicInteger implements b, q<T> {
        public static final InnerObserver<?, ?>[] B = new InnerObserver[0];
        public static final InnerObserver<?, ?>[] C = new InnerObserver[0];
        private static final long serialVersionUID = -2117620485640801370L;
        public int A;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super U> f13881b;

        /* renamed from: m, reason: collision with root package name */
        public final n<? super T, ? extends o<? extends U>> f13882m;

        /* renamed from: n, reason: collision with root package name */
        public final boolean f13883n;

        /* renamed from: o, reason: collision with root package name */
        public final int f13884o;

        /* renamed from: p, reason: collision with root package name */
        public final int f13885p;

        /* renamed from: q, reason: collision with root package name */
        public volatile e<U> f13886q;

        /* renamed from: r, reason: collision with root package name */
        public volatile boolean f13887r;

        /* renamed from: s, reason: collision with root package name */
        public final AtomicThrowable f13888s = new AtomicThrowable();

        /* renamed from: t, reason: collision with root package name */
        public volatile boolean f13889t;

        /* renamed from: u, reason: collision with root package name */
        public final AtomicReference<InnerObserver<?, ?>[]> f13890u;

        /* renamed from: v, reason: collision with root package name */
        public b f13891v;

        /* renamed from: w, reason: collision with root package name */
        public long f13892w;

        /* renamed from: x, reason: collision with root package name */
        public long f13893x;

        /* renamed from: y, reason: collision with root package name */
        public int f13894y;

        /* renamed from: z, reason: collision with root package name */
        public final ArrayDeque f13895z;

        public MergeObserver(int i10, int i11, q qVar, n nVar, boolean z10) {
            this.f13881b = qVar;
            this.f13882m = nVar;
            this.f13883n = z10;
            this.f13884o = i10;
            this.f13885p = i11;
            if (i10 != Integer.MAX_VALUE) {
                this.f13895z = new ArrayDeque(i10);
            }
            this.f13890u = new AtomicReference<>(B);
        }

        public final boolean a() {
            if (this.f13889t) {
                return true;
            }
            Throwable th2 = this.f13888s.get();
            if (this.f13883n || th2 == null) {
                return false;
            }
            b();
            Throwable thTerminate = this.f13888s.terminate();
            if (thTerminate != ExceptionHelper.f14544a) {
                this.f13881b.onError(thTerminate);
            }
            return true;
        }

        public final boolean b() {
            InnerObserver<?, ?>[] andSet;
            this.f13891v.dispose();
            AtomicReference<InnerObserver<?, ?>[]> atomicReference = this.f13890u;
            InnerObserver<?, ?>[] innerObserverArr = atomicReference.get();
            InnerObserver<?, ?>[] innerObserverArr2 = C;
            if (innerObserverArr == innerObserverArr2 || (andSet = atomicReference.getAndSet(innerObserverArr2)) == innerObserverArr2) {
                return false;
            }
            for (InnerObserver<?, ?> innerObserver : andSet) {
                innerObserver.dispose();
            }
            return true;
        }

        public final void c() {
            if (getAndIncrement() == 0) {
                d();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:128:0x0004, code lost:
        
            continue;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:120:0x00ea A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:133:0x00f2 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x00eb  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x00f1 A[PHI: r4
  0x00f1: PHI (r4v10 int) = (r4v8 int), (r4v11 int) binds: [B:72:0x00d0, B:84:0x00ef] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void d() {
            /*
                Method dump skipped, instructions count: 299
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFlatMap.MergeObserver.d():void");
        }

        @Override // qe.b
        public void dispose() {
            Throwable thTerminate;
            if (this.f13889t) {
                return;
            }
            this.f13889t = true;
            if (!b() || (thTerminate = this.f13888s.terminate()) == null || thTerminate == ExceptionHelper.f14544a) {
                return;
            }
            ff.a.onError(thTerminate);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void e(InnerObserver<T, U> innerObserver) {
            boolean z10;
            InnerObserver<?, ?>[] innerObserverArr;
            do {
                AtomicReference<InnerObserver<?, ?>[]> atomicReference = this.f13890u;
                InnerObserver<?, ?>[] innerObserverArr2 = atomicReference.get();
                int length = innerObserverArr2.length;
                if (length == 0) {
                    return;
                }
                z10 = false;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        i10 = -1;
                        break;
                    } else if (innerObserverArr2[i10] == innerObserver) {
                        break;
                    } else {
                        i10++;
                    }
                }
                if (i10 < 0) {
                    return;
                }
                if (length == 1) {
                    innerObserverArr = B;
                } else {
                    InnerObserver<?, ?>[] innerObserverArr3 = new InnerObserver[length - 1];
                    System.arraycopy(innerObserverArr2, 0, innerObserverArr3, 0, i10);
                    System.arraycopy(innerObserverArr2, i10 + 1, innerObserverArr3, i10, (length - i10) - 1);
                    innerObserverArr = innerObserverArr3;
                }
                while (true) {
                    if (atomicReference.compareAndSet(innerObserverArr2, innerObserverArr)) {
                        z10 = true;
                        break;
                    } else if (atomicReference.get() != innerObserverArr2) {
                        break;
                    }
                }
            } while (!z10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v22 */
        /* JADX WARN: Type inference failed for: r3v23 */
        /* JADX WARN: Type inference failed for: r3v8, types: [ve.f] */
        public final void f(o<? extends U> oVar) {
            boolean z10;
            boolean z11;
            boolean z12;
            Object objCall;
            do {
                z10 = false;
                if (!(oVar instanceof Callable)) {
                    long j10 = this.f13892w;
                    this.f13892w = 1 + j10;
                    InnerObserver<?, ?> innerObserver = new InnerObserver<>(this, j10);
                    while (true) {
                        AtomicReference<InnerObserver<?, ?>[]> atomicReference = this.f13890u;
                        InnerObserver<?, ?>[] innerObserverArr = atomicReference.get();
                        if (innerObserverArr == C) {
                            innerObserver.dispose();
                            break;
                        }
                        int length = innerObserverArr.length;
                        InnerObserver<?, ?>[] innerObserverArr2 = new InnerObserver[length + 1];
                        System.arraycopy(innerObserverArr, 0, innerObserverArr2, 0, length);
                        innerObserverArr2[length] = innerObserver;
                        while (true) {
                            if (atomicReference.compareAndSet(innerObserverArr, innerObserverArr2)) {
                                z11 = true;
                                break;
                            } else if (atomicReference.get() != innerObserverArr) {
                                z11 = false;
                                break;
                            }
                        }
                        if (z11) {
                            z10 = true;
                            break;
                        }
                    }
                    if (z10) {
                        oVar.subscribe(innerObserver);
                        return;
                    }
                    return;
                }
                try {
                    objCall = ((Callable) oVar).call();
                } catch (Throwable th2) {
                    re.a.throwIfFatal(th2);
                    this.f13888s.addThrowable(th2);
                    c();
                }
                if (objCall != null) {
                    if (get() == 0 && compareAndSet(0, 1)) {
                        this.f13881b.onNext(objCall);
                        if (decrementAndGet() != 0) {
                            d();
                        }
                    } else {
                        e<U> eVar = this.f13886q;
                        ?? r32 = eVar;
                        if (eVar == false) {
                            e<U> aVar = this.f13884o == Integer.MAX_VALUE ? new af.a(this.f13885p) : new SpscArrayQueue(this.f13884o);
                            this.f13886q = aVar;
                            r32 = aVar;
                        }
                        if (r32.offer(objCall)) {
                            z12 = getAndIncrement() == 0;
                            d();
                        } else {
                            onError(new IllegalStateException("Scalar queue full?!"));
                        }
                    }
                }
                if (!z12 || this.f13884o == Integer.MAX_VALUE) {
                    return;
                }
                synchronized (this) {
                    oVar = (o) this.f13895z.poll();
                    if (oVar == null) {
                        this.A--;
                        z10 = true;
                    }
                }
            } while (!z10);
            c();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f13887r) {
                return;
            }
            this.f13887r = true;
            c();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f13887r) {
                ff.a.onError(th2);
            } else if (!this.f13888s.addThrowable(th2)) {
                ff.a.onError(th2);
            } else {
                this.f13887r = true;
                c();
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f13887r) {
                return;
            }
            try {
                o<? extends U> oVar = (o) ue.a.requireNonNull(this.f13882m.apply(t10), "The mapper returned a null ObservableSource");
                if (this.f13884o != Integer.MAX_VALUE) {
                    synchronized (this) {
                        int i10 = this.A;
                        if (i10 == this.f13884o) {
                            this.f13895z.offer(oVar);
                            return;
                        }
                        this.A = i10 + 1;
                    }
                }
                f(oVar);
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f13891v.dispose();
                onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f13891v, bVar)) {
                this.f13891v = bVar;
                this.f13881b.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMap(o<T> oVar, n<? super T, ? extends o<? extends U>> nVar, boolean z10, int i10, int i11) {
        super(oVar);
        this.f13872m = nVar;
        this.f13873n = z10;
        this.f13874o = i10;
        this.f13875p = i11;
    }

    @Override // ne.k
    public void subscribeActual(q<? super U> qVar) {
        n<? super T, ? extends o<? extends U>> nVar = this.f13872m;
        o<T> oVar = this.f22058b;
        if (ObservableScalarXMap.tryScalarXMapSubscribe(oVar, qVar, nVar)) {
            return;
        }
        oVar.subscribe(new MergeObserver(this.f13874o, this.f13875p, qVar, this.f13872m, this.f13873n));
    }
}
