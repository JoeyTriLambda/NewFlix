package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.k;
import ne.o;
import ne.q;
import qe.b;
import se.n;

/* loaded from: classes2.dex */
public final class ObservableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends ye.a<T, U> {

    /* renamed from: m, reason: collision with root package name */
    public final Callable<U> f13736m;

    /* renamed from: n, reason: collision with root package name */
    public final o<? extends Open> f13737n;

    /* renamed from: o, reason: collision with root package name */
    public final n<? super Open, ? extends o<? extends Close>> f13738o;

    public static final class BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements q<T>, b {
        private static final long serialVersionUID = -8466418554264089604L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super C> f13739b;

        /* renamed from: m, reason: collision with root package name */
        public final Callable<C> f13740m;

        /* renamed from: n, reason: collision with root package name */
        public final o<? extends Open> f13741n;

        /* renamed from: o, reason: collision with root package name */
        public final n<? super Open, ? extends o<? extends Close>> f13742o;

        /* renamed from: s, reason: collision with root package name */
        public volatile boolean f13746s;

        /* renamed from: u, reason: collision with root package name */
        public volatile boolean f13748u;

        /* renamed from: v, reason: collision with root package name */
        public long f13749v;

        /* renamed from: t, reason: collision with root package name */
        public final af.a<C> f13747t = new af.a<>(k.bufferSize());

        /* renamed from: p, reason: collision with root package name */
        public final qe.a f13743p = new qe.a();

        /* renamed from: q, reason: collision with root package name */
        public final AtomicReference<b> f13744q = new AtomicReference<>();

        /* renamed from: w, reason: collision with root package name */
        public LinkedHashMap f13750w = new LinkedHashMap();

        /* renamed from: r, reason: collision with root package name */
        public final AtomicThrowable f13745r = new AtomicThrowable();

        public static final class BufferOpenObserver<Open> extends AtomicReference<b> implements q<Open>, b {
            private static final long serialVersionUID = -8498650778633225126L;

            /* renamed from: b, reason: collision with root package name */
            public final BufferBoundaryObserver<?, ?, Open, ?> f13751b;

            public BufferOpenObserver(BufferBoundaryObserver<?, ?, Open, ?> bufferBoundaryObserver) {
                this.f13751b = bufferBoundaryObserver;
            }

            @Override // qe.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // ne.q
            public void onComplete() {
                lazySet(DisposableHelper.f13533b);
                BufferBoundaryObserver<?, ?, Open, ?> bufferBoundaryObserver = this.f13751b;
                bufferBoundaryObserver.f13743p.delete(this);
                if (bufferBoundaryObserver.f13743p.size() == 0) {
                    DisposableHelper.dispose(bufferBoundaryObserver.f13744q);
                    bufferBoundaryObserver.f13746s = true;
                    bufferBoundaryObserver.b();
                }
            }

            @Override // ne.q
            public void onError(Throwable th2) {
                lazySet(DisposableHelper.f13533b);
                BufferBoundaryObserver<?, ?, Open, ?> bufferBoundaryObserver = this.f13751b;
                DisposableHelper.dispose(bufferBoundaryObserver.f13744q);
                bufferBoundaryObserver.f13743p.delete(this);
                bufferBoundaryObserver.onError(th2);
            }

            @Override // ne.q
            public void onNext(Open open) {
                BufferBoundaryObserver<?, ?, Open, ?> bufferBoundaryObserver = this.f13751b;
                bufferBoundaryObserver.getClass();
                try {
                    Collection collection = (Collection) ue.a.requireNonNull(bufferBoundaryObserver.f13740m.call(), "The bufferSupplier returned a null Collection");
                    o oVar = (o) ue.a.requireNonNull(bufferBoundaryObserver.f13742o.apply(open), "The bufferClose returned a null ObservableSource");
                    long j10 = bufferBoundaryObserver.f13749v;
                    bufferBoundaryObserver.f13749v = 1 + j10;
                    synchronized (bufferBoundaryObserver) {
                        LinkedHashMap linkedHashMap = bufferBoundaryObserver.f13750w;
                        if (linkedHashMap != null) {
                            linkedHashMap.put(Long.valueOf(j10), collection);
                            BufferCloseObserver bufferCloseObserver = new BufferCloseObserver(bufferBoundaryObserver, j10);
                            bufferBoundaryObserver.f13743p.add(bufferCloseObserver);
                            oVar.subscribe(bufferCloseObserver);
                        }
                    }
                } catch (Throwable th2) {
                    re.a.throwIfFatal(th2);
                    DisposableHelper.dispose(bufferBoundaryObserver.f13744q);
                    bufferBoundaryObserver.onError(th2);
                }
            }

            @Override // ne.q
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        public BufferBoundaryObserver(q<? super C> qVar, o<? extends Open> oVar, n<? super Open, ? extends o<? extends Close>> nVar, Callable<C> callable) {
            this.f13739b = qVar;
            this.f13740m = callable;
            this.f13741n = oVar;
            this.f13742o = nVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(BufferCloseObserver<T, C> bufferCloseObserver, long j10) {
            boolean z10;
            this.f13743p.delete(bufferCloseObserver);
            if (this.f13743p.size() == 0) {
                DisposableHelper.dispose(this.f13744q);
                z10 = true;
            } else {
                z10 = false;
            }
            synchronized (this) {
                LinkedHashMap linkedHashMap = this.f13750w;
                if (linkedHashMap == null) {
                    return;
                }
                this.f13747t.offer(linkedHashMap.remove(Long.valueOf(j10)));
                if (z10) {
                    this.f13746s = true;
                }
                b();
            }
        }

        public final void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            q<? super C> qVar = this.f13739b;
            af.a<C> aVar = this.f13747t;
            int iAddAndGet = 1;
            while (!this.f13748u) {
                boolean z10 = this.f13746s;
                if (z10 && this.f13745r.get() != null) {
                    aVar.clear();
                    qVar.onError(this.f13745r.terminate());
                    return;
                }
                C cPoll = aVar.poll();
                boolean z11 = cPoll == null;
                if (z10 && z11) {
                    qVar.onComplete();
                    return;
                } else if (z11) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    qVar.onNext(cPoll);
                }
            }
            aVar.clear();
        }

        @Override // qe.b
        public void dispose() {
            if (DisposableHelper.dispose(this.f13744q)) {
                this.f13748u = true;
                this.f13743p.dispose();
                synchronized (this) {
                    this.f13750w = null;
                }
                if (getAndIncrement() != 0) {
                    this.f13747t.clear();
                }
            }
        }

        @Override // ne.q
        public void onComplete() {
            this.f13743p.dispose();
            synchronized (this) {
                LinkedHashMap linkedHashMap = this.f13750w;
                if (linkedHashMap == null) {
                    return;
                }
                Iterator it = linkedHashMap.values().iterator();
                while (it.hasNext()) {
                    this.f13747t.offer((Collection) it.next());
                }
                this.f13750w = null;
                this.f13746s = true;
                b();
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (!this.f13745r.addThrowable(th2)) {
                ff.a.onError(th2);
                return;
            }
            this.f13743p.dispose();
            synchronized (this) {
                this.f13750w = null;
            }
            this.f13746s = true;
            b();
        }

        @Override // ne.q
        public void onNext(T t10) {
            synchronized (this) {
                LinkedHashMap linkedHashMap = this.f13750w;
                if (linkedHashMap == null) {
                    return;
                }
                Iterator it = linkedHashMap.values().iterator();
                while (it.hasNext()) {
                    ((Collection) it.next()).add(t10);
                }
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.setOnce(this.f13744q, bVar)) {
                BufferOpenObserver bufferOpenObserver = new BufferOpenObserver(this);
                this.f13743p.add(bufferOpenObserver);
                this.f13741n.subscribe(bufferOpenObserver);
            }
        }
    }

    public static final class BufferCloseObserver<T, C extends Collection<? super T>> extends AtomicReference<b> implements q<Object>, b {
        private static final long serialVersionUID = -8498650778633225126L;

        /* renamed from: b, reason: collision with root package name */
        public final BufferBoundaryObserver<T, C, ?, ?> f13752b;

        /* renamed from: m, reason: collision with root package name */
        public final long f13753m;

        public BufferCloseObserver(BufferBoundaryObserver<T, C, ?, ?> bufferBoundaryObserver, long j10) {
            this.f13752b = bufferBoundaryObserver;
            this.f13753m = j10;
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // ne.q
        public void onComplete() {
            b bVar = get();
            DisposableHelper disposableHelper = DisposableHelper.f13533b;
            if (bVar != disposableHelper) {
                lazySet(disposableHelper);
                this.f13752b.a(this, this.f13753m);
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            b bVar = get();
            DisposableHelper disposableHelper = DisposableHelper.f13533b;
            if (bVar == disposableHelper) {
                ff.a.onError(th2);
                return;
            }
            lazySet(disposableHelper);
            BufferBoundaryObserver<T, C, ?, ?> bufferBoundaryObserver = this.f13752b;
            DisposableHelper.dispose(bufferBoundaryObserver.f13744q);
            bufferBoundaryObserver.f13743p.delete(this);
            bufferBoundaryObserver.onError(th2);
        }

        @Override // ne.q
        public void onNext(Object obj) {
            b bVar = get();
            DisposableHelper disposableHelper = DisposableHelper.f13533b;
            if (bVar != disposableHelper) {
                lazySet(disposableHelper);
                bVar.dispose();
                this.f13752b.a(this, this.f13753m);
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public ObservableBufferBoundary(o<T> oVar, o<? extends Open> oVar2, n<? super Open, ? extends o<? extends Close>> nVar, Callable<U> callable) {
        super(oVar);
        this.f13737n = oVar2;
        this.f13738o = nVar;
        this.f13736m = callable;
    }

    @Override // ne.k
    public void subscribeActual(q<? super U> qVar) {
        BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(qVar, this.f13737n, this.f13738o, this.f13736m);
        qVar.onSubscribe(bufferBoundaryObserver);
        this.f22058b.subscribe(bufferBoundaryObserver);
    }
}
