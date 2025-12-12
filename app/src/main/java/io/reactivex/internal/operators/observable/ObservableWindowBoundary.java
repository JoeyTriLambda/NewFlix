package io.reactivex.internal.operators.observable;

import ef.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.k;
import ne.o;
import ne.q;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableWindowBoundary<T, B> extends ye.a<T, k<T>> {

    /* renamed from: m, reason: collision with root package name */
    public final o<B> f14426m;

    /* renamed from: n, reason: collision with root package name */
    public final int f14427n;

    public static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements q<T>, b, Runnable {
        private static final long serialVersionUID = 2233020065421370272L;

        /* renamed from: v, reason: collision with root package name */
        public static final Object f14428v = new Object();

        /* renamed from: b, reason: collision with root package name */
        public final q<? super k<T>> f14429b;

        /* renamed from: m, reason: collision with root package name */
        public final int f14430m;

        /* renamed from: n, reason: collision with root package name */
        public final a<T, B> f14431n = new a<>(this);

        /* renamed from: o, reason: collision with root package name */
        public final AtomicReference<b> f14432o = new AtomicReference<>();

        /* renamed from: p, reason: collision with root package name */
        public final AtomicInteger f14433p = new AtomicInteger(1);

        /* renamed from: q, reason: collision with root package name */
        public final MpscLinkedQueue<Object> f14434q = new MpscLinkedQueue<>();

        /* renamed from: r, reason: collision with root package name */
        public final AtomicThrowable f14435r = new AtomicThrowable();

        /* renamed from: s, reason: collision with root package name */
        public final AtomicBoolean f14436s = new AtomicBoolean();

        /* renamed from: t, reason: collision with root package name */
        public volatile boolean f14437t;

        /* renamed from: u, reason: collision with root package name */
        public UnicastSubject<T> f14438u;

        public WindowBoundaryMainObserver(q<? super k<T>> qVar, int i10) {
            this.f14429b = qVar;
            this.f14430m = i10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            q<? super k<T>> qVar = this.f14429b;
            MpscLinkedQueue<Object> mpscLinkedQueue = this.f14434q;
            AtomicThrowable atomicThrowable = this.f14435r;
            int iAddAndGet = 1;
            while (this.f14433p.get() != 0) {
                UnicastSubject<T> unicastSubject = this.f14438u;
                boolean z10 = this.f14437t;
                if (z10 && atomicThrowable.get() != null) {
                    mpscLinkedQueue.clear();
                    Throwable thTerminate = atomicThrowable.terminate();
                    if (unicastSubject != 0) {
                        this.f14438u = null;
                        unicastSubject.onError(thTerminate);
                    }
                    qVar.onError(thTerminate);
                    return;
                }
                Object objPoll = mpscLinkedQueue.poll();
                boolean z11 = objPoll == null;
                if (z10 && z11) {
                    Throwable thTerminate2 = atomicThrowable.terminate();
                    if (thTerminate2 == null) {
                        if (unicastSubject != 0) {
                            this.f14438u = null;
                            unicastSubject.onComplete();
                        }
                        qVar.onComplete();
                        return;
                    }
                    if (unicastSubject != 0) {
                        this.f14438u = null;
                        unicastSubject.onError(thTerminate2);
                    }
                    qVar.onError(thTerminate2);
                    return;
                }
                if (z11) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else if (objPoll != f14428v) {
                    unicastSubject.onNext(objPoll);
                } else {
                    if (unicastSubject != 0) {
                        this.f14438u = null;
                        unicastSubject.onComplete();
                    }
                    if (!this.f14436s.get()) {
                        UnicastSubject<T> unicastSubjectCreate = UnicastSubject.create(this.f14430m, this);
                        this.f14438u = unicastSubjectCreate;
                        this.f14433p.getAndIncrement();
                        qVar.onNext(unicastSubjectCreate);
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.f14438u = null;
        }

        public final void b() {
            this.f14434q.offer(f14428v);
            a();
        }

        @Override // qe.b
        public void dispose() {
            if (this.f14436s.compareAndSet(false, true)) {
                this.f14431n.dispose();
                if (this.f14433p.decrementAndGet() == 0) {
                    DisposableHelper.dispose(this.f14432o);
                }
            }
        }

        @Override // ne.q
        public void onComplete() {
            this.f14431n.dispose();
            this.f14437t = true;
            a();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f14431n.dispose();
            if (!this.f14435r.addThrowable(th2)) {
                ff.a.onError(th2);
            } else {
                this.f14437t = true;
                a();
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f14434q.offer(t10);
            a();
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.setOnce(this.f14432o, bVar)) {
                b();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f14433p.decrementAndGet() == 0) {
                DisposableHelper.dispose(this.f14432o);
            }
        }
    }

    public static final class a<T, B> extends c<B> {

        /* renamed from: m, reason: collision with root package name */
        public final WindowBoundaryMainObserver<T, B> f14439m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f14440n;

        public a(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.f14439m = windowBoundaryMainObserver;
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f14440n) {
                return;
            }
            this.f14440n = true;
            WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver = this.f14439m;
            DisposableHelper.dispose(windowBoundaryMainObserver.f14432o);
            windowBoundaryMainObserver.f14437t = true;
            windowBoundaryMainObserver.a();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f14440n) {
                ff.a.onError(th2);
                return;
            }
            this.f14440n = true;
            WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver = this.f14439m;
            DisposableHelper.dispose(windowBoundaryMainObserver.f14432o);
            if (!windowBoundaryMainObserver.f14435r.addThrowable(th2)) {
                ff.a.onError(th2);
            } else {
                windowBoundaryMainObserver.f14437t = true;
                windowBoundaryMainObserver.a();
            }
        }

        @Override // ne.q
        public void onNext(B b10) {
            if (this.f14440n) {
                return;
            }
            this.f14439m.b();
        }
    }

    public ObservableWindowBoundary(o<T> oVar, o<B> oVar2, int i10) {
        super(oVar);
        this.f14426m = oVar2;
        this.f14427n = i10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super k<T>> qVar) {
        WindowBoundaryMainObserver windowBoundaryMainObserver = new WindowBoundaryMainObserver(qVar, this.f14427n);
        qVar.onSubscribe(windowBoundaryMainObserver);
        this.f14426m.subscribe(windowBoundaryMainObserver.f14431n);
        this.f22058b.subscribe(windowBoundaryMainObserver);
    }
}
