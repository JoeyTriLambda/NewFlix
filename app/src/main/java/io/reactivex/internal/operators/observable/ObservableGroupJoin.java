package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.k;
import ne.o;
import ne.q;
import qe.b;
import se.c;
import se.n;

/* loaded from: classes2.dex */
public final class ObservableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends ye.a<TLeft, R> {

    /* renamed from: m, reason: collision with root package name */
    public final o<? extends TRight> f13964m;

    /* renamed from: n, reason: collision with root package name */
    public final n<? super TLeft, ? extends o<TLeftEnd>> f13965n;

    /* renamed from: o, reason: collision with root package name */
    public final n<? super TRight, ? extends o<TRightEnd>> f13966o;

    /* renamed from: p, reason: collision with root package name */
    public final c<? super TLeft, ? super k<TRight>, ? extends R> f13967p;

    public static final class GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements b, a {
        private static final long serialVersionUID = -6071216598687999801L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super R> f13970b;

        /* renamed from: r, reason: collision with root package name */
        public final n<? super TLeft, ? extends o<TLeftEnd>> f13976r;

        /* renamed from: s, reason: collision with root package name */
        public final n<? super TRight, ? extends o<TRightEnd>> f13977s;

        /* renamed from: t, reason: collision with root package name */
        public final c<? super TLeft, ? super k<TRight>, ? extends R> f13978t;

        /* renamed from: v, reason: collision with root package name */
        public int f13980v;

        /* renamed from: w, reason: collision with root package name */
        public int f13981w;

        /* renamed from: x, reason: collision with root package name */
        public volatile boolean f13982x;

        /* renamed from: y, reason: collision with root package name */
        public static final Integer f13968y = 1;

        /* renamed from: z, reason: collision with root package name */
        public static final Integer f13969z = 2;
        public static final Integer A = 3;
        public static final Integer B = 4;

        /* renamed from: n, reason: collision with root package name */
        public final qe.a f13972n = new qe.a();

        /* renamed from: m, reason: collision with root package name */
        public final af.a<Object> f13971m = new af.a<>(k.bufferSize());

        /* renamed from: o, reason: collision with root package name */
        public final LinkedHashMap f13973o = new LinkedHashMap();

        /* renamed from: p, reason: collision with root package name */
        public final LinkedHashMap f13974p = new LinkedHashMap();

        /* renamed from: q, reason: collision with root package name */
        public final AtomicReference<Throwable> f13975q = new AtomicReference<>();

        /* renamed from: u, reason: collision with root package name */
        public final AtomicInteger f13979u = new AtomicInteger(2);

        public GroupJoinDisposable(q<? super R> qVar, n<? super TLeft, ? extends o<TLeftEnd>> nVar, n<? super TRight, ? extends o<TRightEnd>> nVar2, c<? super TLeft, ? super k<TRight>, ? extends R> cVar) {
            this.f13970b = qVar;
            this.f13976r = nVar;
            this.f13977s = nVar2;
            this.f13978t = cVar;
        }

        public final void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            af.a<?> aVar = this.f13971m;
            q<? super R> qVar = this.f13970b;
            int iAddAndGet = 1;
            while (!this.f13982x) {
                if (this.f13975q.get() != null) {
                    aVar.clear();
                    this.f13972n.dispose();
                    b(qVar);
                    return;
                }
                boolean z10 = this.f13979u.get() == 0;
                Integer num = (Integer) aVar.poll();
                boolean z11 = num == null;
                if (z10 && z11) {
                    Iterator it = this.f13973o.values().iterator();
                    while (it.hasNext()) {
                        ((UnicastSubject) it.next()).onComplete();
                    }
                    this.f13973o.clear();
                    this.f13974p.clear();
                    this.f13972n.dispose();
                    qVar.onComplete();
                    return;
                }
                if (z11) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    Object objPoll = aVar.poll();
                    if (num == f13968y) {
                        UnicastSubject unicastSubjectCreate = UnicastSubject.create();
                        int i10 = this.f13980v;
                        this.f13980v = i10 + 1;
                        this.f13973o.put(Integer.valueOf(i10), unicastSubjectCreate);
                        try {
                            o oVar = (o) ue.a.requireNonNull(this.f13976r.apply(objPoll), "The leftEnd returned a null ObservableSource");
                            LeftRightEndObserver leftRightEndObserver = new LeftRightEndObserver(this, true, i10);
                            this.f13972n.add(leftRightEndObserver);
                            oVar.subscribe(leftRightEndObserver);
                            if (this.f13975q.get() != null) {
                                aVar.clear();
                                this.f13972n.dispose();
                                b(qVar);
                                return;
                            } else {
                                try {
                                    qVar.onNext((Object) ue.a.requireNonNull(this.f13978t.apply(objPoll, unicastSubjectCreate), "The resultSelector returned a null value"));
                                    Iterator it2 = this.f13974p.values().iterator();
                                    while (it2.hasNext()) {
                                        unicastSubjectCreate.onNext(it2.next());
                                    }
                                } catch (Throwable th2) {
                                    c(th2, qVar, aVar);
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            c(th3, qVar, aVar);
                            return;
                        }
                    } else if (num == f13969z) {
                        int i11 = this.f13981w;
                        this.f13981w = i11 + 1;
                        this.f13974p.put(Integer.valueOf(i11), objPoll);
                        try {
                            o oVar2 = (o) ue.a.requireNonNull(this.f13977s.apply(objPoll), "The rightEnd returned a null ObservableSource");
                            LeftRightEndObserver leftRightEndObserver2 = new LeftRightEndObserver(this, false, i11);
                            this.f13972n.add(leftRightEndObserver2);
                            oVar2.subscribe(leftRightEndObserver2);
                            if (this.f13975q.get() != null) {
                                aVar.clear();
                                this.f13972n.dispose();
                                b(qVar);
                                return;
                            } else {
                                Iterator it3 = this.f13973o.values().iterator();
                                while (it3.hasNext()) {
                                    ((UnicastSubject) it3.next()).onNext(objPoll);
                                }
                            }
                        } catch (Throwable th4) {
                            c(th4, qVar, aVar);
                            return;
                        }
                    } else if (num == A) {
                        LeftRightEndObserver leftRightEndObserver3 = (LeftRightEndObserver) objPoll;
                        UnicastSubject unicastSubject = (UnicastSubject) this.f13973o.remove(Integer.valueOf(leftRightEndObserver3.f13985n));
                        this.f13972n.remove(leftRightEndObserver3);
                        if (unicastSubject != null) {
                            unicastSubject.onComplete();
                        }
                    } else if (num == B) {
                        LeftRightEndObserver leftRightEndObserver4 = (LeftRightEndObserver) objPoll;
                        this.f13974p.remove(Integer.valueOf(leftRightEndObserver4.f13985n));
                        this.f13972n.remove(leftRightEndObserver4);
                    }
                }
            }
            aVar.clear();
        }

        public final void b(q<?> qVar) {
            Throwable thTerminate = ExceptionHelper.terminate(this.f13975q);
            LinkedHashMap linkedHashMap = this.f13973o;
            Iterator it = linkedHashMap.values().iterator();
            while (it.hasNext()) {
                ((UnicastSubject) it.next()).onError(thTerminate);
            }
            linkedHashMap.clear();
            this.f13974p.clear();
            qVar.onError(thTerminate);
        }

        public final void c(Throwable th2, q<?> qVar, af.a<?> aVar) {
            re.a.throwIfFatal(th2);
            ExceptionHelper.addThrowable(this.f13975q, th2);
            aVar.clear();
            this.f13972n.dispose();
            b(qVar);
        }

        @Override // qe.b
        public void dispose() {
            if (this.f13982x) {
                return;
            }
            this.f13982x = true;
            this.f13972n.dispose();
            if (getAndIncrement() == 0) {
                this.f13971m.clear();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerClose(boolean z10, LeftRightEndObserver leftRightEndObserver) {
            synchronized (this) {
                this.f13971m.offer(z10 ? A : B, leftRightEndObserver);
            }
            a();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerCloseError(Throwable th2) {
            if (ExceptionHelper.addThrowable(this.f13975q, th2)) {
                a();
            } else {
                ff.a.onError(th2);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerComplete(LeftRightObserver leftRightObserver) {
            this.f13972n.delete(leftRightObserver);
            this.f13979u.decrementAndGet();
            a();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerError(Throwable th2) {
            if (!ExceptionHelper.addThrowable(this.f13975q, th2)) {
                ff.a.onError(th2);
            } else {
                this.f13979u.decrementAndGet();
                a();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerValue(boolean z10, Object obj) {
            synchronized (this) {
                this.f13971m.offer(z10 ? f13968y : f13969z, obj);
            }
            a();
        }
    }

    public static final class LeftRightEndObserver extends AtomicReference<b> implements q<Object>, b {
        private static final long serialVersionUID = 1883890389173668373L;

        /* renamed from: b, reason: collision with root package name */
        public final a f13983b;

        /* renamed from: m, reason: collision with root package name */
        public final boolean f13984m;

        /* renamed from: n, reason: collision with root package name */
        public final int f13985n;

        public LeftRightEndObserver(a aVar, boolean z10, int i10) {
            this.f13983b = aVar;
            this.f13984m = z10;
            this.f13985n = i10;
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // ne.q
        public void onComplete() {
            this.f13983b.innerClose(this.f13984m, this);
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f13983b.innerCloseError(th2);
        }

        @Override // ne.q
        public void onNext(Object obj) {
            if (DisposableHelper.dispose(this)) {
                this.f13983b.innerClose(this.f13984m, this);
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public static final class LeftRightObserver extends AtomicReference<b> implements q<Object>, b {
        private static final long serialVersionUID = 1883890389173668373L;

        /* renamed from: b, reason: collision with root package name */
        public final a f13986b;

        /* renamed from: m, reason: collision with root package name */
        public final boolean f13987m;

        public LeftRightObserver(a aVar, boolean z10) {
            this.f13986b = aVar;
            this.f13987m = z10;
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // ne.q
        public void onComplete() {
            this.f13986b.innerComplete(this);
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f13986b.innerError(th2);
        }

        @Override // ne.q
        public void onNext(Object obj) {
            this.f13986b.innerValue(this.f13987m, obj);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public interface a {
        void innerClose(boolean z10, LeftRightEndObserver leftRightEndObserver);

        void innerCloseError(Throwable th2);

        void innerComplete(LeftRightObserver leftRightObserver);

        void innerError(Throwable th2);

        void innerValue(boolean z10, Object obj);
    }

    public ObservableGroupJoin(o<TLeft> oVar, o<? extends TRight> oVar2, n<? super TLeft, ? extends o<TLeftEnd>> nVar, n<? super TRight, ? extends o<TRightEnd>> nVar2, c<? super TLeft, ? super k<TRight>, ? extends R> cVar) {
        super(oVar);
        this.f13964m = oVar2;
        this.f13965n = nVar;
        this.f13966o = nVar2;
        this.f13967p = cVar;
    }

    @Override // ne.k
    public void subscribeActual(q<? super R> qVar) {
        GroupJoinDisposable groupJoinDisposable = new GroupJoinDisposable(qVar, this.f13965n, this.f13966o, this.f13967p);
        qVar.onSubscribe(groupJoinDisposable);
        LeftRightObserver leftRightObserver = new LeftRightObserver(groupJoinDisposable, true);
        qe.a aVar = groupJoinDisposable.f13972n;
        aVar.add(leftRightObserver);
        LeftRightObserver leftRightObserver2 = new LeftRightObserver(groupJoinDisposable, false);
        aVar.add(leftRightObserver2);
        this.f22058b.subscribe(leftRightObserver);
        this.f13964m.subscribe(leftRightObserver2);
    }
}
