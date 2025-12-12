package ye;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.UnicastSubject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import ne.r;

/* compiled from: ObservableWindowTimed.java */
/* loaded from: classes2.dex */
public final class x1<T> extends ye.a<T, ne.k<T>> {

    /* renamed from: m, reason: collision with root package name */
    public final long f22474m;

    /* renamed from: n, reason: collision with root package name */
    public final long f22475n;

    /* renamed from: o, reason: collision with root package name */
    public final TimeUnit f22476o;

    /* renamed from: p, reason: collision with root package name */
    public final ne.r f22477p;

    /* renamed from: q, reason: collision with root package name */
    public final long f22478q;

    /* renamed from: r, reason: collision with root package name */
    public final int f22479r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f22480s;

    /* compiled from: ObservableWindowTimed.java */
    public static final class a<T> extends we.j<T, Object, ne.k<T>> implements qe.b {
        public qe.b A;
        public UnicastSubject<T> B;
        public volatile boolean C;
        public final SequentialDisposable D;

        /* renamed from: r, reason: collision with root package name */
        public final long f22481r;

        /* renamed from: s, reason: collision with root package name */
        public final TimeUnit f22482s;

        /* renamed from: t, reason: collision with root package name */
        public final ne.r f22483t;

        /* renamed from: u, reason: collision with root package name */
        public final int f22484u;

        /* renamed from: v, reason: collision with root package name */
        public final boolean f22485v;

        /* renamed from: w, reason: collision with root package name */
        public final long f22486w;

        /* renamed from: x, reason: collision with root package name */
        public final r.c f22487x;

        /* renamed from: y, reason: collision with root package name */
        public long f22488y;

        /* renamed from: z, reason: collision with root package name */
        public long f22489z;

        /* compiled from: ObservableWindowTimed.java */
        /* renamed from: ye.x1$a$a, reason: collision with other inner class name */
        public static final class RunnableC0327a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final long f22490b;

            /* renamed from: m, reason: collision with root package name */
            public final a<?> f22491m;

            public RunnableC0327a(long j10, a<?> aVar) {
                this.f22490b = j10;
                this.f22491m = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a<?> aVar = this.f22491m;
                if (aVar.f21146o) {
                    aVar.C = true;
                } else {
                    aVar.f21145n.offer(this);
                }
                if (aVar.enter()) {
                    aVar.a();
                }
            }
        }

        public a(int i10, long j10, long j11, ef.e eVar, ne.r rVar, TimeUnit timeUnit, boolean z10) {
            super(eVar, new MpscLinkedQueue());
            this.D = new SequentialDisposable();
            this.f22481r = j10;
            this.f22482s = timeUnit;
            this.f22483t = rVar;
            this.f22484u = i10;
            this.f22486w = j11;
            this.f22485v = z10;
            if (z10) {
                this.f22487x = rVar.createWorker();
            } else {
                this.f22487x = null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.subjects.UnicastSubject<T>] */
        public final void a() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f21145n;
            ne.q<? super V> qVar = this.f21144m;
            UnicastSubject<T> unicastSubject = this.B;
            int iLeave = 1;
            while (!this.C) {
                boolean z10 = this.f21147p;
                Object objPoll = mpscLinkedQueue.poll();
                boolean z11 = objPoll == null;
                boolean z12 = objPoll instanceof RunnableC0327a;
                if (z10 && (z11 || z12)) {
                    this.B = null;
                    mpscLinkedQueue.clear();
                    Throwable th2 = this.f21148q;
                    if (th2 != null) {
                        unicastSubject.onError(th2);
                    } else {
                        unicastSubject.onComplete();
                    }
                    DisposableHelper.dispose(this.D);
                    r.c cVar = this.f22487x;
                    if (cVar != null) {
                        cVar.dispose();
                        return;
                    }
                    return;
                }
                if (z11) {
                    iLeave = leave(-iLeave);
                    if (iLeave == 0) {
                        return;
                    }
                } else if (z12) {
                    RunnableC0327a runnableC0327a = (RunnableC0327a) objPoll;
                    if (!this.f22485v || this.f22489z == runnableC0327a.f22490b) {
                        unicastSubject.onComplete();
                        this.f22488y = 0L;
                        unicastSubject = (UnicastSubject<T>) UnicastSubject.create(this.f22484u);
                        this.B = unicastSubject;
                        qVar.onNext(unicastSubject);
                    }
                } else {
                    unicastSubject.onNext(NotificationLite.getValue(objPoll));
                    long j10 = this.f22488y + 1;
                    if (j10 >= this.f22486w) {
                        this.f22489z++;
                        this.f22488y = 0L;
                        unicastSubject.onComplete();
                        unicastSubject = (UnicastSubject<T>) UnicastSubject.create(this.f22484u);
                        this.B = unicastSubject;
                        this.f21144m.onNext(unicastSubject);
                        if (this.f22485v) {
                            qe.b bVar = this.D.get();
                            bVar.dispose();
                            r.c cVar2 = this.f22487x;
                            RunnableC0327a runnableC0327a2 = new RunnableC0327a(this.f22489z, this);
                            long j11 = this.f22481r;
                            qe.b bVarSchedulePeriodically = cVar2.schedulePeriodically(runnableC0327a2, j11, j11, this.f22482s);
                            if (!this.D.compareAndSet(bVar, bVarSchedulePeriodically)) {
                                bVarSchedulePeriodically.dispose();
                            }
                        }
                    } else {
                        this.f22488y = j10;
                    }
                }
            }
            this.A.dispose();
            mpscLinkedQueue.clear();
            DisposableHelper.dispose(this.D);
            r.c cVar3 = this.f22487x;
            if (cVar3 != null) {
                cVar3.dispose();
            }
        }

        @Override // qe.b
        public void dispose() {
            this.f21146o = true;
        }

        @Override // ne.q
        public void onComplete() {
            this.f21147p = true;
            if (enter()) {
                a();
            }
            this.f21144m.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f21148q = th2;
            this.f21147p = true;
            if (enter()) {
                a();
            }
            this.f21144m.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.C) {
                return;
            }
            if (fastEnter()) {
                UnicastSubject<T> unicastSubject = this.B;
                unicastSubject.onNext(t10);
                long j10 = this.f22488y + 1;
                if (j10 >= this.f22486w) {
                    this.f22489z++;
                    this.f22488y = 0L;
                    unicastSubject.onComplete();
                    UnicastSubject<T> unicastSubjectCreate = UnicastSubject.create(this.f22484u);
                    this.B = unicastSubjectCreate;
                    this.f21144m.onNext(unicastSubjectCreate);
                    if (this.f22485v) {
                        this.D.get().dispose();
                        r.c cVar = this.f22487x;
                        RunnableC0327a runnableC0327a = new RunnableC0327a(this.f22489z, this);
                        long j11 = this.f22481r;
                        DisposableHelper.replace(this.D, cVar.schedulePeriodically(runnableC0327a, j11, j11, this.f22482s));
                    }
                } else {
                    this.f22488y = j10;
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.f21145n.offer(NotificationLite.next(t10));
                if (!enter()) {
                    return;
                }
            }
            a();
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            qe.b bVarSchedulePeriodicallyDirect;
            if (DisposableHelper.validate(this.A, bVar)) {
                this.A = bVar;
                ne.q<? super V> qVar = this.f21144m;
                qVar.onSubscribe(this);
                if (this.f21146o) {
                    return;
                }
                UnicastSubject<T> unicastSubjectCreate = UnicastSubject.create(this.f22484u);
                this.B = unicastSubjectCreate;
                qVar.onNext(unicastSubjectCreate);
                RunnableC0327a runnableC0327a = new RunnableC0327a(this.f22489z, this);
                if (this.f22485v) {
                    r.c cVar = this.f22487x;
                    long j10 = this.f22481r;
                    bVarSchedulePeriodicallyDirect = cVar.schedulePeriodically(runnableC0327a, j10, j10, this.f22482s);
                } else {
                    ne.r rVar = this.f22483t;
                    long j11 = this.f22481r;
                    bVarSchedulePeriodicallyDirect = rVar.schedulePeriodicallyDirect(runnableC0327a, j11, j11, this.f22482s);
                }
                this.D.replace(bVarSchedulePeriodicallyDirect);
            }
        }
    }

    /* compiled from: ObservableWindowTimed.java */
    public static final class b<T> extends we.j<T, Object, ne.k<T>> implements qe.b, Runnable {

        /* renamed from: z, reason: collision with root package name */
        public static final Object f22492z = new Object();

        /* renamed from: r, reason: collision with root package name */
        public final long f22493r;

        /* renamed from: s, reason: collision with root package name */
        public final TimeUnit f22494s;

        /* renamed from: t, reason: collision with root package name */
        public final ne.r f22495t;

        /* renamed from: u, reason: collision with root package name */
        public final int f22496u;

        /* renamed from: v, reason: collision with root package name */
        public qe.b f22497v;

        /* renamed from: w, reason: collision with root package name */
        public UnicastSubject<T> f22498w;

        /* renamed from: x, reason: collision with root package name */
        public final SequentialDisposable f22499x;

        /* renamed from: y, reason: collision with root package name */
        public volatile boolean f22500y;

        public b(ef.e eVar, long j10, TimeUnit timeUnit, ne.r rVar, int i10) {
            super(eVar, new MpscLinkedQueue());
            this.f22499x = new SequentialDisposable();
            this.f22493r = j10;
            this.f22494s = timeUnit;
            this.f22495t = rVar;
            this.f22496u = i10;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
        
            r8.f22499x.dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
        
            r8.f22498w = null;
            r0.clear();
            r0 = r8.f21148q;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
        
            if (r0 == null) goto L10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.subjects.UnicastSubject<T>] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a() {
            /*
                r8 = this;
                ve.e<U> r0 = r8.f21145n
                io.reactivex.internal.queue.MpscLinkedQueue r0 = (io.reactivex.internal.queue.MpscLinkedQueue) r0
                ne.q<? super V> r1 = r8.f21144m
                io.reactivex.subjects.UnicastSubject<T> r2 = r8.f22498w
                r3 = 1
            L9:
                boolean r4 = r8.f22500y
                boolean r5 = r8.f21147p
                java.lang.Object r6 = r0.poll()
                java.lang.Object r7 = ye.x1.b.f22492z
                if (r5 == 0) goto L30
                if (r6 == 0) goto L19
                if (r6 != r7) goto L30
            L19:
                r1 = 0
                r8.f22498w = r1
                r0.clear()
                java.lang.Throwable r0 = r8.f21148q
                if (r0 == 0) goto L27
                r2.onError(r0)
                goto L2a
            L27:
                r2.onComplete()
            L2a:
                io.reactivex.internal.disposables.SequentialDisposable r0 = r8.f22499x
                r0.dispose()
                return
            L30:
                if (r6 != 0) goto L3a
                int r3 = -r3
                int r3 = r8.leave(r3)
                if (r3 != 0) goto L9
                return
            L3a:
                if (r6 != r7) goto L53
                r2.onComplete()
                if (r4 != 0) goto L4d
                int r2 = r8.f22496u
                io.reactivex.subjects.UnicastSubject r2 = io.reactivex.subjects.UnicastSubject.create(r2)
                r8.f22498w = r2
                r1.onNext(r2)
                goto L9
            L4d:
                qe.b r4 = r8.f22497v
                r4.dispose()
                goto L9
            L53:
                java.lang.Object r4 = io.reactivex.internal.util.NotificationLite.getValue(r6)
                r2.onNext(r4)
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: ye.x1.b.a():void");
        }

        @Override // qe.b
        public void dispose() {
            this.f21146o = true;
        }

        @Override // ne.q
        public void onComplete() {
            this.f21147p = true;
            if (enter()) {
                a();
            }
            this.f21144m.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f21148q = th2;
            this.f21147p = true;
            if (enter()) {
                a();
            }
            this.f21144m.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22500y) {
                return;
            }
            if (fastEnter()) {
                this.f22498w.onNext(t10);
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.f21145n.offer(NotificationLite.next(t10));
                if (!enter()) {
                    return;
                }
            }
            a();
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22497v, bVar)) {
                this.f22497v = bVar;
                this.f22498w = UnicastSubject.create(this.f22496u);
                ne.q<? super V> qVar = this.f21144m;
                qVar.onSubscribe(this);
                qVar.onNext(this.f22498w);
                if (this.f21146o) {
                    return;
                }
                ne.r rVar = this.f22495t;
                long j10 = this.f22493r;
                this.f22499x.replace(rVar.schedulePeriodicallyDirect(this, j10, j10, this.f22494s));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f21146o) {
                this.f22500y = true;
            }
            this.f21145n.offer(f22492z);
            if (enter()) {
                a();
            }
        }
    }

    /* compiled from: ObservableWindowTimed.java */
    public static final class c<T> extends we.j<T, Object, ne.k<T>> implements qe.b, Runnable {

        /* renamed from: r, reason: collision with root package name */
        public final long f22501r;

        /* renamed from: s, reason: collision with root package name */
        public final long f22502s;

        /* renamed from: t, reason: collision with root package name */
        public final TimeUnit f22503t;

        /* renamed from: u, reason: collision with root package name */
        public final r.c f22504u;

        /* renamed from: v, reason: collision with root package name */
        public final int f22505v;

        /* renamed from: w, reason: collision with root package name */
        public final LinkedList f22506w;

        /* renamed from: x, reason: collision with root package name */
        public qe.b f22507x;

        /* renamed from: y, reason: collision with root package name */
        public volatile boolean f22508y;

        /* compiled from: ObservableWindowTimed.java */
        public final class a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final UnicastSubject<T> f22509b;

            public a(UnicastSubject<T> unicastSubject) {
                this.f22509b = unicastSubject;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                cVar.getClass();
                cVar.f21145n.offer(new b(this.f22509b, false));
                if (cVar.enter()) {
                    cVar.a();
                }
            }
        }

        /* compiled from: ObservableWindowTimed.java */
        public static final class b<T> {

            /* renamed from: a, reason: collision with root package name */
            public final UnicastSubject<T> f22511a;

            /* renamed from: b, reason: collision with root package name */
            public final boolean f22512b;

            public b(UnicastSubject<T> unicastSubject, boolean z10) {
                this.f22511a = unicastSubject;
                this.f22512b = z10;
            }
        }

        public c(ef.e eVar, long j10, long j11, TimeUnit timeUnit, r.c cVar, int i10) {
            super(eVar, new MpscLinkedQueue());
            this.f22501r = j10;
            this.f22502s = j11;
            this.f22503t = timeUnit;
            this.f22504u = cVar;
            this.f22505v = i10;
            this.f22506w = new LinkedList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f21145n;
            ne.q<? super V> qVar = this.f21144m;
            LinkedList linkedList = this.f22506w;
            int iLeave = 1;
            while (!this.f22508y) {
                boolean z10 = this.f21147p;
                Object objPoll = mpscLinkedQueue.poll();
                boolean z11 = objPoll == null;
                boolean z12 = objPoll instanceof b;
                if (z10 && (z11 || z12)) {
                    mpscLinkedQueue.clear();
                    Throwable th2 = this.f21148q;
                    if (th2 != null) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            ((UnicastSubject) it.next()).onError(th2);
                        }
                    } else {
                        Iterator it2 = linkedList.iterator();
                        while (it2.hasNext()) {
                            ((UnicastSubject) it2.next()).onComplete();
                        }
                    }
                    linkedList.clear();
                    this.f22504u.dispose();
                    return;
                }
                if (z11) {
                    iLeave = leave(-iLeave);
                    if (iLeave == 0) {
                        return;
                    }
                } else if (z12) {
                    b bVar = (b) objPoll;
                    if (!bVar.f22512b) {
                        linkedList.remove(bVar.f22511a);
                        bVar.f22511a.onComplete();
                        if (linkedList.isEmpty() && this.f21146o) {
                            this.f22508y = true;
                        }
                    } else if (!this.f21146o) {
                        UnicastSubject unicastSubjectCreate = UnicastSubject.create(this.f22505v);
                        linkedList.add(unicastSubjectCreate);
                        qVar.onNext(unicastSubjectCreate);
                        this.f22504u.schedule(new a(unicastSubjectCreate), this.f22501r, this.f22503t);
                    }
                } else {
                    Iterator it3 = linkedList.iterator();
                    while (it3.hasNext()) {
                        ((UnicastSubject) it3.next()).onNext(objPoll);
                    }
                }
            }
            this.f22507x.dispose();
            mpscLinkedQueue.clear();
            linkedList.clear();
            this.f22504u.dispose();
        }

        @Override // qe.b
        public void dispose() {
            this.f21146o = true;
        }

        @Override // ne.q
        public void onComplete() {
            this.f21147p = true;
            if (enter()) {
                a();
            }
            this.f21144m.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f21148q = th2;
            this.f21147p = true;
            if (enter()) {
                a();
            }
            this.f21144m.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (fastEnter()) {
                Iterator it = this.f22506w.iterator();
                while (it.hasNext()) {
                    ((UnicastSubject) it.next()).onNext(t10);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.f21145n.offer(t10);
                if (!enter()) {
                    return;
                }
            }
            a();
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22507x, bVar)) {
                this.f22507x = bVar;
                this.f21144m.onSubscribe(this);
                if (this.f21146o) {
                    return;
                }
                UnicastSubject unicastSubjectCreate = UnicastSubject.create(this.f22505v);
                this.f22506w.add(unicastSubjectCreate);
                this.f21144m.onNext(unicastSubjectCreate);
                this.f22504u.schedule(new a(unicastSubjectCreate), this.f22501r, this.f22503t);
                r.c cVar = this.f22504u;
                long j10 = this.f22502s;
                cVar.schedulePeriodically(this, j10, j10, this.f22503t);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = new b(UnicastSubject.create(this.f22505v), true);
            if (!this.f21146o) {
                this.f21145n.offer(bVar);
            }
            if (enter()) {
                a();
            }
        }
    }

    public x1(ne.o<T> oVar, long j10, long j11, TimeUnit timeUnit, ne.r rVar, long j12, int i10, boolean z10) {
        super(oVar);
        this.f22474m = j10;
        this.f22475n = j11;
        this.f22476o = timeUnit;
        this.f22477p = rVar;
        this.f22478q = j12;
        this.f22479r = i10;
        this.f22480s = z10;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super ne.k<T>> qVar) {
        ef.e eVar = new ef.e(qVar);
        long j10 = this.f22474m;
        long j11 = this.f22475n;
        ne.o<T> oVar = this.f22058b;
        if (j10 != j11) {
            oVar.subscribe(new c(eVar, j10, j11, this.f22476o, this.f22477p.createWorker(), this.f22479r));
            return;
        }
        long j12 = this.f22478q;
        if (j12 == Long.MAX_VALUE) {
            oVar.subscribe(new b(eVar, this.f22474m, this.f22476o, this.f22477p, this.f22479r));
            return;
        }
        TimeUnit timeUnit = this.f22476o;
        oVar.subscribe(new a(this.f22479r, j10, j12, eVar, this.f22477p, timeUnit, this.f22480s));
    }
}
