package io.reactivex.internal.operators.observable;

import ef.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.k;
import ne.o;
import ne.q;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableWindowBoundarySupplier<T, B> extends ye.a<T, k<T>> {

    /* renamed from: m, reason: collision with root package name */
    public final Callable<? extends o<B>> f14441m;

    /* renamed from: n, reason: collision with root package name */
    public final int f14442n;

    public static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements q<T>, b, Runnable {
        private static final long serialVersionUID = 2233020065421370272L;

        /* renamed from: w, reason: collision with root package name */
        public static final a<Object, Object> f14443w = new a<>(null);

        /* renamed from: x, reason: collision with root package name */
        public static final Object f14444x = new Object();

        /* renamed from: b, reason: collision with root package name */
        public final q<? super k<T>> f14445b;

        /* renamed from: m, reason: collision with root package name */
        public final int f14446m;

        /* renamed from: n, reason: collision with root package name */
        public final AtomicReference<a<T, B>> f14447n = new AtomicReference<>();

        /* renamed from: o, reason: collision with root package name */
        public final AtomicInteger f14448o = new AtomicInteger(1);

        /* renamed from: p, reason: collision with root package name */
        public final MpscLinkedQueue<Object> f14449p = new MpscLinkedQueue<>();

        /* renamed from: q, reason: collision with root package name */
        public final AtomicThrowable f14450q = new AtomicThrowable();

        /* renamed from: r, reason: collision with root package name */
        public final AtomicBoolean f14451r = new AtomicBoolean();

        /* renamed from: s, reason: collision with root package name */
        public final Callable<? extends o<B>> f14452s;

        /* renamed from: t, reason: collision with root package name */
        public b f14453t;

        /* renamed from: u, reason: collision with root package name */
        public volatile boolean f14454u;

        /* renamed from: v, reason: collision with root package name */
        public UnicastSubject<T> f14455v;

        public WindowBoundaryMainObserver(q<? super k<T>> qVar, int i10, Callable<? extends o<B>> callable) {
            this.f14445b = qVar;
            this.f14446m = i10;
            this.f14452s = callable;
        }

        public final void a() {
            AtomicReference<a<T, B>> atomicReference = this.f14447n;
            a<Object, Object> aVar = f14443w;
            b bVar = (b) atomicReference.getAndSet(aVar);
            if (bVar == null || bVar == aVar) {
                return;
            }
            bVar.dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            q<? super k<T>> qVar = this.f14445b;
            MpscLinkedQueue<Object> mpscLinkedQueue = this.f14449p;
            AtomicThrowable atomicThrowable = this.f14450q;
            int iAddAndGet = 1;
            while (this.f14448o.get() != 0) {
                UnicastSubject<T> unicastSubject = this.f14455v;
                boolean z10 = this.f14454u;
                if (z10 && atomicThrowable.get() != null) {
                    mpscLinkedQueue.clear();
                    Throwable thTerminate = atomicThrowable.terminate();
                    if (unicastSubject != 0) {
                        this.f14455v = null;
                        unicastSubject.onError(thTerminate);
                    }
                    qVar.onError(thTerminate);
                    return;
                }
                Object objPoll = mpscLinkedQueue.poll();
                boolean z11 = false;
                boolean z12 = objPoll == null;
                if (z10 && z12) {
                    Throwable thTerminate2 = atomicThrowable.terminate();
                    if (thTerminate2 == null) {
                        if (unicastSubject != 0) {
                            this.f14455v = null;
                            unicastSubject.onComplete();
                        }
                        qVar.onComplete();
                        return;
                    }
                    if (unicastSubject != 0) {
                        this.f14455v = null;
                        unicastSubject.onError(thTerminate2);
                    }
                    qVar.onError(thTerminate2);
                    return;
                }
                if (z12) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else if (objPoll != f14444x) {
                    unicastSubject.onNext(objPoll);
                } else {
                    if (unicastSubject != 0) {
                        this.f14455v = null;
                        unicastSubject.onComplete();
                    }
                    if (!this.f14451r.get()) {
                        UnicastSubject<T> unicastSubjectCreate = UnicastSubject.create(this.f14446m, this);
                        this.f14455v = unicastSubjectCreate;
                        this.f14448o.getAndIncrement();
                        try {
                            o oVar = (o) ue.a.requireNonNull(this.f14452s.call(), "The other Callable returned a null ObservableSource");
                            a<T, B> aVar = new a<>(this);
                            AtomicReference<a<T, B>> atomicReference = this.f14447n;
                            while (true) {
                                if (atomicReference.compareAndSet(null, aVar)) {
                                    z11 = true;
                                    break;
                                } else if (atomicReference.get() != null) {
                                    break;
                                }
                            }
                            if (z11) {
                                oVar.subscribe(aVar);
                                qVar.onNext(unicastSubjectCreate);
                            }
                        } catch (Throwable th2) {
                            re.a.throwIfFatal(th2);
                            atomicThrowable.addThrowable(th2);
                            this.f14454u = true;
                        }
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.f14455v = null;
        }

        @Override // qe.b
        public void dispose() {
            if (this.f14451r.compareAndSet(false, true)) {
                a();
                if (this.f14448o.decrementAndGet() == 0) {
                    this.f14453t.dispose();
                }
            }
        }

        @Override // ne.q
        public void onComplete() {
            a();
            this.f14454u = true;
            b();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            a();
            if (!this.f14450q.addThrowable(th2)) {
                ff.a.onError(th2);
            } else {
                this.f14454u = true;
                b();
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f14449p.offer(t10);
            b();
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f14453t, bVar)) {
                this.f14453t = bVar;
                this.f14445b.onSubscribe(this);
                this.f14449p.offer(f14444x);
                b();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f14448o.decrementAndGet() == 0) {
                this.f14453t.dispose();
            }
        }
    }

    public static final class a<T, B> extends c<B> {

        /* renamed from: m, reason: collision with root package name */
        public final WindowBoundaryMainObserver<T, B> f14456m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f14457n;

        public a(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.f14456m = windowBoundaryMainObserver;
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f14457n) {
                return;
            }
            this.f14457n = true;
            WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver = this.f14456m;
            windowBoundaryMainObserver.f14453t.dispose();
            windowBoundaryMainObserver.f14454u = true;
            windowBoundaryMainObserver.b();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f14457n) {
                ff.a.onError(th2);
                return;
            }
            this.f14457n = true;
            WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver = this.f14456m;
            windowBoundaryMainObserver.f14453t.dispose();
            if (!windowBoundaryMainObserver.f14450q.addThrowable(th2)) {
                ff.a.onError(th2);
            } else {
                windowBoundaryMainObserver.f14454u = true;
                windowBoundaryMainObserver.b();
            }
        }

        @Override // ne.q
        public void onNext(B b10) {
            if (this.f14457n) {
                return;
            }
            this.f14457n = true;
            dispose();
            WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver = this.f14456m;
            AtomicReference<a<T, B>> atomicReference = windowBoundaryMainObserver.f14447n;
            while (!atomicReference.compareAndSet(this, null) && atomicReference.get() == this) {
            }
            windowBoundaryMainObserver.f14449p.offer(WindowBoundaryMainObserver.f14444x);
            windowBoundaryMainObserver.b();
        }
    }

    public ObservableWindowBoundarySupplier(o<T> oVar, Callable<? extends o<B>> callable, int i10) {
        super(oVar);
        this.f14441m = callable;
        this.f14442n = i10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super k<T>> qVar) {
        this.f22058b.subscribe(new WindowBoundaryMainObserver(qVar, this.f14442n, this.f14441m));
    }
}
