package ye;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableWindowBoundarySelector.java */
/* loaded from: classes2.dex */
public final class w1<T, B, V> extends ye.a<T, ne.k<T>> {

    /* renamed from: m, reason: collision with root package name */
    public final ne.o<B> f22442m;

    /* renamed from: n, reason: collision with root package name */
    public final se.n<? super B, ? extends ne.o<V>> f22443n;

    /* renamed from: o, reason: collision with root package name */
    public final int f22444o;

    /* compiled from: ObservableWindowBoundarySelector.java */
    public static final class a<T, V> extends ef.c<V> {

        /* renamed from: m, reason: collision with root package name */
        public final c<T, ?, V> f22445m;

        /* renamed from: n, reason: collision with root package name */
        public final UnicastSubject<T> f22446n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f22447o;

        public a(c<T, ?, V> cVar, UnicastSubject<T> unicastSubject) {
            this.f22445m = cVar;
            this.f22446n = unicastSubject;
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22447o) {
                return;
            }
            this.f22447o = true;
            c<T, ?, V> cVar = this.f22445m;
            cVar.f22452u.delete(this);
            cVar.f21145n.offer(new d(this.f22446n, null));
            if (cVar.enter()) {
                cVar.a();
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22447o) {
                ff.a.onError(th2);
                return;
            }
            this.f22447o = true;
            c<T, ?, V> cVar = this.f22445m;
            cVar.f22453v.dispose();
            cVar.f22452u.dispose();
            cVar.onError(th2);
        }

        @Override // ne.q
        public void onNext(V v10) {
            dispose();
            onComplete();
        }
    }

    /* compiled from: ObservableWindowBoundarySelector.java */
    public static final class b<T, B> extends ef.c<B> {

        /* renamed from: m, reason: collision with root package name */
        public final c<T, B, ?> f22448m;

        public b(c<T, B, ?> cVar) {
            this.f22448m = cVar;
        }

        @Override // ne.q
        public void onComplete() {
            this.f22448m.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            c<T, B, ?> cVar = this.f22448m;
            cVar.f22453v.dispose();
            cVar.f22452u.dispose();
            cVar.onError(th2);
        }

        @Override // ne.q
        public void onNext(B b10) {
            c<T, B, ?> cVar = this.f22448m;
            cVar.getClass();
            cVar.f21145n.offer(new d(null, b10));
            if (cVar.enter()) {
                cVar.a();
            }
        }
    }

    /* compiled from: ObservableWindowBoundarySelector.java */
    public static final class d<T, B> {

        /* renamed from: a, reason: collision with root package name */
        public final UnicastSubject<T> f22458a;

        /* renamed from: b, reason: collision with root package name */
        public final B f22459b;

        public d(UnicastSubject<T> unicastSubject, B b10) {
            this.f22458a = unicastSubject;
            this.f22459b = b10;
        }
    }

    public w1(ne.o<T> oVar, ne.o<B> oVar2, se.n<? super B, ? extends ne.o<V>> nVar, int i10) {
        super(oVar);
        this.f22442m = oVar2;
        this.f22443n = nVar;
        this.f22444o = i10;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super ne.k<T>> qVar) {
        this.f22058b.subscribe(new c(new ef.e(qVar), this.f22442m, this.f22443n, this.f22444o));
    }

    /* compiled from: ObservableWindowBoundarySelector.java */
    public static final class c<T, B, V> extends we.j<T, Object, ne.k<T>> implements qe.b {

        /* renamed from: r, reason: collision with root package name */
        public final ne.o<B> f22449r;

        /* renamed from: s, reason: collision with root package name */
        public final se.n<? super B, ? extends ne.o<V>> f22450s;

        /* renamed from: t, reason: collision with root package name */
        public final int f22451t;

        /* renamed from: u, reason: collision with root package name */
        public final qe.a f22452u;

        /* renamed from: v, reason: collision with root package name */
        public qe.b f22453v;

        /* renamed from: w, reason: collision with root package name */
        public final AtomicReference<qe.b> f22454w;

        /* renamed from: x, reason: collision with root package name */
        public final ArrayList f22455x;

        /* renamed from: y, reason: collision with root package name */
        public final AtomicLong f22456y;

        /* renamed from: z, reason: collision with root package name */
        public final AtomicBoolean f22457z;

        public c(ef.e eVar, ne.o oVar, se.n nVar, int i10) {
            super(eVar, new MpscLinkedQueue());
            this.f22454w = new AtomicReference<>();
            AtomicLong atomicLong = new AtomicLong();
            this.f22456y = atomicLong;
            this.f22457z = new AtomicBoolean();
            this.f22449r = oVar;
            this.f22450s = nVar;
            this.f22451t = i10;
            this.f22452u = new qe.a();
            this.f22455x = new ArrayList();
            atomicLong.lazySet(1L);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f21145n;
            ne.q<? super V> qVar = this.f21144m;
            ArrayList arrayList = this.f22455x;
            int iLeave = 1;
            while (true) {
                boolean z10 = this.f21147p;
                Object objPoll = mpscLinkedQueue.poll();
                boolean z11 = objPoll == null;
                if (z10 && z11) {
                    this.f22452u.dispose();
                    DisposableHelper.dispose(this.f22454w);
                    Throwable th2 = this.f21148q;
                    if (th2 != null) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((UnicastSubject) it.next()).onError(th2);
                        }
                    } else {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            ((UnicastSubject) it2.next()).onComplete();
                        }
                    }
                    arrayList.clear();
                    return;
                }
                if (z11) {
                    iLeave = leave(-iLeave);
                    if (iLeave == 0) {
                        return;
                    }
                } else if (objPoll instanceof d) {
                    d dVar = (d) objPoll;
                    UnicastSubject<T> unicastSubject = dVar.f22458a;
                    if (unicastSubject != null) {
                        if (arrayList.remove(unicastSubject)) {
                            dVar.f22458a.onComplete();
                            if (this.f22456y.decrementAndGet() == 0) {
                                this.f22452u.dispose();
                                DisposableHelper.dispose(this.f22454w);
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.f22457z.get()) {
                        UnicastSubject unicastSubjectCreate = UnicastSubject.create(this.f22451t);
                        arrayList.add(unicastSubjectCreate);
                        qVar.onNext(unicastSubjectCreate);
                        try {
                            ne.o oVar = (ne.o) ue.a.requireNonNull(this.f22450s.apply(dVar.f22459b), "The ObservableSource supplied is null");
                            a aVar = new a(this, unicastSubjectCreate);
                            if (this.f22452u.add(aVar)) {
                                this.f22456y.getAndIncrement();
                                oVar.subscribe(aVar);
                            }
                        } catch (Throwable th3) {
                            re.a.throwIfFatal(th3);
                            this.f22457z.set(true);
                            qVar.onError(th3);
                        }
                    }
                } else {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        ((UnicastSubject) it3.next()).onNext(NotificationLite.getValue(objPoll));
                    }
                }
            }
        }

        @Override // qe.b
        public void dispose() {
            if (this.f22457z.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.f22454w);
                if (this.f22456y.decrementAndGet() == 0) {
                    this.f22453v.dispose();
                }
            }
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f21147p) {
                return;
            }
            this.f21147p = true;
            if (enter()) {
                a();
            }
            if (this.f22456y.decrementAndGet() == 0) {
                this.f22452u.dispose();
            }
            this.f21144m.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f21147p) {
                ff.a.onError(th2);
                return;
            }
            this.f21148q = th2;
            this.f21147p = true;
            if (enter()) {
                a();
            }
            if (this.f22456y.decrementAndGet() == 0) {
                this.f22452u.dispose();
            }
            this.f21144m.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (fastEnter()) {
                Iterator it = this.f22455x.iterator();
                while (it.hasNext()) {
                    ((UnicastSubject) it.next()).onNext(t10);
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
            boolean z10;
            if (DisposableHelper.validate(this.f22453v, bVar)) {
                this.f22453v = bVar;
                this.f21144m.onSubscribe(this);
                if (this.f22457z.get()) {
                    return;
                }
                b bVar2 = new b(this);
                AtomicReference<qe.b> atomicReference = this.f22454w;
                while (true) {
                    if (atomicReference.compareAndSet(null, bVar2)) {
                        z10 = true;
                        break;
                    } else if (atomicReference.get() != null) {
                        z10 = false;
                        break;
                    }
                }
                if (z10) {
                    this.f22449r.subscribe(bVar2);
                }
            }
        }

        @Override // we.j, cf.g
        public void accept(ne.q<? super ne.k<T>> qVar, Object obj) {
        }
    }
}
