package ye;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import ne.r;

/* compiled from: ObservableBufferTimed.java */
/* loaded from: classes2.dex */
public final class l<T, U extends Collection<? super T>> extends ye.a<T, U> {

    /* renamed from: m, reason: collision with root package name */
    public final long f22217m;

    /* renamed from: n, reason: collision with root package name */
    public final long f22218n;

    /* renamed from: o, reason: collision with root package name */
    public final TimeUnit f22219o;

    /* renamed from: p, reason: collision with root package name */
    public final ne.r f22220p;

    /* renamed from: q, reason: collision with root package name */
    public final Callable<U> f22221q;

    /* renamed from: r, reason: collision with root package name */
    public final int f22222r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f22223s;

    /* compiled from: ObservableBufferTimed.java */
    public static final class a<T, U extends Collection<? super T>> extends we.j<T, U, U> implements Runnable, qe.b {
        public long A;
        public long B;

        /* renamed from: r, reason: collision with root package name */
        public final Callable<U> f22224r;

        /* renamed from: s, reason: collision with root package name */
        public final long f22225s;

        /* renamed from: t, reason: collision with root package name */
        public final TimeUnit f22226t;

        /* renamed from: u, reason: collision with root package name */
        public final int f22227u;

        /* renamed from: v, reason: collision with root package name */
        public final boolean f22228v;

        /* renamed from: w, reason: collision with root package name */
        public final r.c f22229w;

        /* renamed from: x, reason: collision with root package name */
        public U f22230x;

        /* renamed from: y, reason: collision with root package name */
        public qe.b f22231y;

        /* renamed from: z, reason: collision with root package name */
        public qe.b f22232z;

        public a(ef.e eVar, Callable callable, long j10, TimeUnit timeUnit, int i10, boolean z10, r.c cVar) {
            super(eVar, new MpscLinkedQueue());
            this.f22224r = callable;
            this.f22225s = j10;
            this.f22226t = timeUnit;
            this.f22227u = i10;
            this.f22228v = z10;
            this.f22229w = cVar;
        }

        @Override // we.j, cf.g
        public /* bridge */ /* synthetic */ void accept(ne.q qVar, Object obj) {
            accept((ne.q<? super ne.q>) qVar, (ne.q) obj);
        }

        @Override // qe.b
        public void dispose() {
            if (this.f21146o) {
                return;
            }
            this.f21146o = true;
            this.f22232z.dispose();
            this.f22229w.dispose();
            synchronized (this) {
                this.f22230x = null;
            }
        }

        @Override // ne.q
        public void onComplete() {
            U u10;
            this.f22229w.dispose();
            synchronized (this) {
                u10 = this.f22230x;
                this.f22230x = null;
            }
            if (u10 != null) {
                this.f21145n.offer(u10);
                this.f21147p = true;
                if (enter()) {
                    cf.j.drainLoop(this.f21145n, this.f21144m, false, this, this);
                }
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            synchronized (this) {
                this.f22230x = null;
            }
            this.f21144m.onError(th2);
            this.f22229w.dispose();
        }

        @Override // ne.q
        public void onNext(T t10) {
            synchronized (this) {
                U u10 = this.f22230x;
                if (u10 == null) {
                    return;
                }
                u10.add(t10);
                if (u10.size() < this.f22227u) {
                    return;
                }
                this.f22230x = null;
                this.A++;
                if (this.f22228v) {
                    this.f22231y.dispose();
                }
                fastPathOrderedEmit(u10, false, this);
                try {
                    U u11 = (U) ue.a.requireNonNull(this.f22224r.call(), "The buffer supplied is null");
                    synchronized (this) {
                        this.f22230x = u11;
                        this.B++;
                    }
                    if (this.f22228v) {
                        r.c cVar = this.f22229w;
                        long j10 = this.f22225s;
                        this.f22231y = cVar.schedulePeriodically(this, j10, j10, this.f22226t);
                    }
                } catch (Throwable th2) {
                    re.a.throwIfFatal(th2);
                    this.f21144m.onError(th2);
                    dispose();
                }
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            ne.q<? super V> qVar = this.f21144m;
            if (DisposableHelper.validate(this.f22232z, bVar)) {
                this.f22232z = bVar;
                try {
                    this.f22230x = (U) ue.a.requireNonNull(this.f22224r.call(), "The buffer supplied is null");
                    qVar.onSubscribe(this);
                    r.c cVar = this.f22229w;
                    long j10 = this.f22225s;
                    this.f22231y = cVar.schedulePeriodically(this, j10, j10, this.f22226t);
                } catch (Throwable th2) {
                    re.a.throwIfFatal(th2);
                    bVar.dispose();
                    EmptyDisposable.error(th2, qVar);
                    this.f22229w.dispose();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u10 = (U) ue.a.requireNonNull(this.f22224r.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    U u11 = this.f22230x;
                    if (u11 != null && this.A == this.B) {
                        this.f22230x = u10;
                        fastPathOrderedEmit(u11, false, this);
                    }
                }
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                dispose();
                this.f21144m.onError(th2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void accept(ne.q<? super U> qVar, U u10) {
            qVar.onNext(u10);
        }
    }

    /* compiled from: ObservableBufferTimed.java */
    public static final class b<T, U extends Collection<? super T>> extends we.j<T, U, U> implements Runnable, qe.b {

        /* renamed from: r, reason: collision with root package name */
        public final Callable<U> f22233r;

        /* renamed from: s, reason: collision with root package name */
        public final long f22234s;

        /* renamed from: t, reason: collision with root package name */
        public final TimeUnit f22235t;

        /* renamed from: u, reason: collision with root package name */
        public final ne.r f22236u;

        /* renamed from: v, reason: collision with root package name */
        public qe.b f22237v;

        /* renamed from: w, reason: collision with root package name */
        public U f22238w;

        /* renamed from: x, reason: collision with root package name */
        public final AtomicReference<qe.b> f22239x;

        public b(ef.e eVar, Callable callable, long j10, TimeUnit timeUnit, ne.r rVar) {
            super(eVar, new MpscLinkedQueue());
            this.f22239x = new AtomicReference<>();
            this.f22233r = callable;
            this.f22234s = j10;
            this.f22235t = timeUnit;
            this.f22236u = rVar;
        }

        @Override // we.j, cf.g
        public /* bridge */ /* synthetic */ void accept(ne.q qVar, Object obj) {
            accept((ne.q<? super ne.q>) qVar, (ne.q) obj);
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this.f22239x);
            this.f22237v.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            U u10;
            synchronized (this) {
                u10 = this.f22238w;
                this.f22238w = null;
            }
            if (u10 != null) {
                this.f21145n.offer(u10);
                this.f21147p = true;
                if (enter()) {
                    cf.j.drainLoop(this.f21145n, this.f21144m, false, null, this);
                }
            }
            DisposableHelper.dispose(this.f22239x);
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            synchronized (this) {
                this.f22238w = null;
            }
            this.f21144m.onError(th2);
            DisposableHelper.dispose(this.f22239x);
        }

        @Override // ne.q
        public void onNext(T t10) {
            synchronized (this) {
                U u10 = this.f22238w;
                if (u10 == null) {
                    return;
                }
                u10.add(t10);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            boolean z10;
            if (DisposableHelper.validate(this.f22237v, bVar)) {
                this.f22237v = bVar;
                try {
                    this.f22238w = (U) ue.a.requireNonNull(this.f22233r.call(), "The buffer supplied is null");
                    this.f21144m.onSubscribe(this);
                    if (this.f21146o) {
                        return;
                    }
                    ne.r rVar = this.f22236u;
                    long j10 = this.f22234s;
                    qe.b bVarSchedulePeriodicallyDirect = rVar.schedulePeriodicallyDirect(this, j10, j10, this.f22235t);
                    AtomicReference<qe.b> atomicReference = this.f22239x;
                    while (true) {
                        if (atomicReference.compareAndSet(null, bVarSchedulePeriodicallyDirect)) {
                            z10 = true;
                            break;
                        } else if (atomicReference.get() != null) {
                            z10 = false;
                            break;
                        }
                    }
                    if (z10) {
                        return;
                    }
                    bVarSchedulePeriodicallyDirect.dispose();
                } catch (Throwable th2) {
                    re.a.throwIfFatal(th2);
                    dispose();
                    EmptyDisposable.error(th2, this.f21144m);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            U u10;
            try {
                U u11 = (U) ue.a.requireNonNull(this.f22233r.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    u10 = this.f22238w;
                    if (u10 != null) {
                        this.f22238w = u11;
                    }
                }
                if (u10 == null) {
                    DisposableHelper.dispose(this.f22239x);
                } else {
                    fastPathEmit(u10, false, this);
                }
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f21144m.onError(th2);
                dispose();
            }
        }

        public void accept(ne.q<? super U> qVar, U u10) {
            this.f21144m.onNext(u10);
        }
    }

    /* compiled from: ObservableBufferTimed.java */
    public static final class c<T, U extends Collection<? super T>> extends we.j<T, U, U> implements Runnable, qe.b {

        /* renamed from: r, reason: collision with root package name */
        public final Callable<U> f22240r;

        /* renamed from: s, reason: collision with root package name */
        public final long f22241s;

        /* renamed from: t, reason: collision with root package name */
        public final long f22242t;

        /* renamed from: u, reason: collision with root package name */
        public final TimeUnit f22243u;

        /* renamed from: v, reason: collision with root package name */
        public final r.c f22244v;

        /* renamed from: w, reason: collision with root package name */
        public final LinkedList f22245w;

        /* renamed from: x, reason: collision with root package name */
        public qe.b f22246x;

        /* compiled from: ObservableBufferTimed.java */
        public final class a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final U f22247b;

            public a(U u10) {
                this.f22247b = u10;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.f22245w.remove(this.f22247b);
                }
                c cVar = c.this;
                cVar.fastPathOrderedEmit(this.f22247b, false, cVar.f22244v);
            }
        }

        /* compiled from: ObservableBufferTimed.java */
        public final class b implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final U f22249b;

            public b(U u10) {
                this.f22249b = u10;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.f22245w.remove(this.f22249b);
                }
                c cVar = c.this;
                cVar.fastPathOrderedEmit(this.f22249b, false, cVar.f22244v);
            }
        }

        public c(ef.e eVar, Callable callable, long j10, long j11, TimeUnit timeUnit, r.c cVar) {
            super(eVar, new MpscLinkedQueue());
            this.f22240r = callable;
            this.f22241s = j10;
            this.f22242t = j11;
            this.f22243u = timeUnit;
            this.f22244v = cVar;
            this.f22245w = new LinkedList();
        }

        @Override // we.j, cf.g
        public /* bridge */ /* synthetic */ void accept(ne.q qVar, Object obj) {
            accept((ne.q<? super ne.q>) qVar, (ne.q) obj);
        }

        @Override // qe.b
        public void dispose() {
            if (this.f21146o) {
                return;
            }
            this.f21146o = true;
            synchronized (this) {
                this.f22245w.clear();
            }
            this.f22246x.dispose();
            this.f22244v.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.f22245w);
                this.f22245w.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f21145n.offer((Collection) it.next());
            }
            this.f21147p = true;
            if (enter()) {
                cf.j.drainLoop(this.f21145n, this.f21144m, false, this.f22244v, this);
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f21147p = true;
            synchronized (this) {
                this.f22245w.clear();
            }
            this.f21144m.onError(th2);
            this.f22244v.dispose();
        }

        @Override // ne.q
        public void onNext(T t10) {
            synchronized (this) {
                Iterator it = this.f22245w.iterator();
                while (it.hasNext()) {
                    ((Collection) it.next()).add(t10);
                }
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            r.c cVar = this.f22244v;
            ne.q<? super V> qVar = this.f21144m;
            if (DisposableHelper.validate(this.f22246x, bVar)) {
                this.f22246x = bVar;
                try {
                    Collection collection = (Collection) ue.a.requireNonNull(this.f22240r.call(), "The buffer supplied is null");
                    this.f22245w.add(collection);
                    qVar.onSubscribe(this);
                    r.c cVar2 = this.f22244v;
                    long j10 = this.f22242t;
                    cVar2.schedulePeriodically(this, j10, j10, this.f22243u);
                    cVar.schedule(new b(collection), this.f22241s, this.f22243u);
                } catch (Throwable th2) {
                    re.a.throwIfFatal(th2);
                    bVar.dispose();
                    EmptyDisposable.error(th2, qVar);
                    cVar.dispose();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f21146o) {
                return;
            }
            try {
                Collection collection = (Collection) ue.a.requireNonNull(this.f22240r.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    if (this.f21146o) {
                        return;
                    }
                    this.f22245w.add(collection);
                    this.f22244v.schedule(new a(collection), this.f22241s, this.f22243u);
                }
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f21144m.onError(th2);
                dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void accept(ne.q<? super U> qVar, U u10) {
            qVar.onNext(u10);
        }
    }

    public l(ne.o<T> oVar, long j10, long j11, TimeUnit timeUnit, ne.r rVar, Callable<U> callable, int i10, boolean z10) {
        super(oVar);
        this.f22217m = j10;
        this.f22218n = j11;
        this.f22219o = timeUnit;
        this.f22220p = rVar;
        this.f22221q = callable;
        this.f22222r = i10;
        this.f22223s = z10;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super U> qVar) {
        long j10 = this.f22217m;
        long j11 = this.f22218n;
        ne.o<T> oVar = this.f22058b;
        if (j10 == j11 && this.f22222r == Integer.MAX_VALUE) {
            oVar.subscribe(new b(new ef.e(qVar), this.f22221q, this.f22217m, this.f22219o, this.f22220p));
            return;
        }
        r.c cVarCreateWorker = this.f22220p.createWorker();
        if (j10 == j11) {
            oVar.subscribe(new a(new ef.e(qVar), this.f22221q, this.f22217m, this.f22219o, this.f22222r, this.f22223s, cVarCreateWorker));
        } else {
            oVar.subscribe(new c(new ef.e(qVar), this.f22221q, this.f22217m, this.f22218n, this.f22219o, cVarCreateWorker));
        }
    }
}
