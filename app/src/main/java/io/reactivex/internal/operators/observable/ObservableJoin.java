package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.util.ExceptionHelper;
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
public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends ye.a<TLeft, R> {

    /* renamed from: m, reason: collision with root package name */
    public final o<? extends TRight> f14003m;

    /* renamed from: n, reason: collision with root package name */
    public final n<? super TLeft, ? extends o<TLeftEnd>> f14004n;

    /* renamed from: o, reason: collision with root package name */
    public final n<? super TRight, ? extends o<TRightEnd>> f14005o;

    /* renamed from: p, reason: collision with root package name */
    public final c<? super TLeft, ? super TRight, ? extends R> f14006p;

    public static final class JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements b, ObservableGroupJoin.a {
        private static final long serialVersionUID = -6071216598687999801L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super R> f14009b;

        /* renamed from: r, reason: collision with root package name */
        public final n<? super TLeft, ? extends o<TLeftEnd>> f14015r;

        /* renamed from: s, reason: collision with root package name */
        public final n<? super TRight, ? extends o<TRightEnd>> f14016s;

        /* renamed from: t, reason: collision with root package name */
        public final c<? super TLeft, ? super TRight, ? extends R> f14017t;

        /* renamed from: v, reason: collision with root package name */
        public int f14019v;

        /* renamed from: w, reason: collision with root package name */
        public int f14020w;

        /* renamed from: x, reason: collision with root package name */
        public volatile boolean f14021x;

        /* renamed from: y, reason: collision with root package name */
        public static final Integer f14007y = 1;

        /* renamed from: z, reason: collision with root package name */
        public static final Integer f14008z = 2;
        public static final Integer A = 3;
        public static final Integer B = 4;

        /* renamed from: n, reason: collision with root package name */
        public final qe.a f14011n = new qe.a();

        /* renamed from: m, reason: collision with root package name */
        public final af.a<Object> f14010m = new af.a<>(k.bufferSize());

        /* renamed from: o, reason: collision with root package name */
        public final LinkedHashMap f14012o = new LinkedHashMap();

        /* renamed from: p, reason: collision with root package name */
        public final LinkedHashMap f14013p = new LinkedHashMap();

        /* renamed from: q, reason: collision with root package name */
        public final AtomicReference<Throwable> f14014q = new AtomicReference<>();

        /* renamed from: u, reason: collision with root package name */
        public final AtomicInteger f14018u = new AtomicInteger(2);

        public JoinDisposable(q<? super R> qVar, n<? super TLeft, ? extends o<TLeftEnd>> nVar, n<? super TRight, ? extends o<TRightEnd>> nVar2, c<? super TLeft, ? super TRight, ? extends R> cVar) {
            this.f14009b = qVar;
            this.f14015r = nVar;
            this.f14016s = nVar2;
            this.f14017t = cVar;
        }

        public final void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            af.a<?> aVar = this.f14010m;
            q<? super R> qVar = this.f14009b;
            int iAddAndGet = 1;
            while (!this.f14021x) {
                if (this.f14014q.get() != null) {
                    aVar.clear();
                    this.f14011n.dispose();
                    b(qVar);
                    return;
                }
                boolean z10 = this.f14018u.get() == 0;
                Integer num = (Integer) aVar.poll();
                boolean z11 = num == null;
                if (z10 && z11) {
                    this.f14012o.clear();
                    this.f14013p.clear();
                    this.f14011n.dispose();
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
                    if (num == f14007y) {
                        int i10 = this.f14019v;
                        this.f14019v = i10 + 1;
                        this.f14012o.put(Integer.valueOf(i10), objPoll);
                        try {
                            o oVar = (o) ue.a.requireNonNull(this.f14015r.apply(objPoll), "The leftEnd returned a null ObservableSource");
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver = new ObservableGroupJoin.LeftRightEndObserver(this, true, i10);
                            this.f14011n.add(leftRightEndObserver);
                            oVar.subscribe(leftRightEndObserver);
                            if (this.f14014q.get() != null) {
                                aVar.clear();
                                this.f14011n.dispose();
                                b(qVar);
                                return;
                            } else {
                                Iterator it = this.f14013p.values().iterator();
                                while (it.hasNext()) {
                                    try {
                                        qVar.onNext((Object) ue.a.requireNonNull(this.f14017t.apply(objPoll, it.next()), "The resultSelector returned a null value"));
                                    } catch (Throwable th2) {
                                        c(th2, qVar, aVar);
                                        return;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            c(th3, qVar, aVar);
                            return;
                        }
                    } else if (num == f14008z) {
                        int i11 = this.f14020w;
                        this.f14020w = i11 + 1;
                        this.f14013p.put(Integer.valueOf(i11), objPoll);
                        try {
                            o oVar2 = (o) ue.a.requireNonNull(this.f14016s.apply(objPoll), "The rightEnd returned a null ObservableSource");
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver2 = new ObservableGroupJoin.LeftRightEndObserver(this, false, i11);
                            this.f14011n.add(leftRightEndObserver2);
                            oVar2.subscribe(leftRightEndObserver2);
                            if (this.f14014q.get() != null) {
                                aVar.clear();
                                this.f14011n.dispose();
                                b(qVar);
                                return;
                            } else {
                                Iterator it2 = this.f14012o.values().iterator();
                                while (it2.hasNext()) {
                                    try {
                                        qVar.onNext((Object) ue.a.requireNonNull(this.f14017t.apply(it2.next(), objPoll), "The resultSelector returned a null value"));
                                    } catch (Throwable th4) {
                                        c(th4, qVar, aVar);
                                        return;
                                    }
                                }
                            }
                        } catch (Throwable th5) {
                            c(th5, qVar, aVar);
                            return;
                        }
                    } else if (num == A) {
                        ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver3 = (ObservableGroupJoin.LeftRightEndObserver) objPoll;
                        this.f14012o.remove(Integer.valueOf(leftRightEndObserver3.f13985n));
                        this.f14011n.remove(leftRightEndObserver3);
                    } else {
                        ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver4 = (ObservableGroupJoin.LeftRightEndObserver) objPoll;
                        this.f14013p.remove(Integer.valueOf(leftRightEndObserver4.f13985n));
                        this.f14011n.remove(leftRightEndObserver4);
                    }
                }
            }
            aVar.clear();
        }

        public final void b(q<?> qVar) {
            Throwable thTerminate = ExceptionHelper.terminate(this.f14014q);
            this.f14012o.clear();
            this.f14013p.clear();
            qVar.onError(thTerminate);
        }

        public final void c(Throwable th2, q<?> qVar, af.a<?> aVar) {
            re.a.throwIfFatal(th2);
            ExceptionHelper.addThrowable(this.f14014q, th2);
            aVar.clear();
            this.f14011n.dispose();
            b(qVar);
        }

        @Override // qe.b
        public void dispose() {
            if (this.f14021x) {
                return;
            }
            this.f14021x = true;
            this.f14011n.dispose();
            if (getAndIncrement() == 0) {
                this.f14010m.clear();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerClose(boolean z10, ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver) {
            synchronized (this) {
                this.f14010m.offer(z10 ? A : B, leftRightEndObserver);
            }
            a();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerCloseError(Throwable th2) {
            if (ExceptionHelper.addThrowable(this.f14014q, th2)) {
                a();
            } else {
                ff.a.onError(th2);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerComplete(ObservableGroupJoin.LeftRightObserver leftRightObserver) {
            this.f14011n.delete(leftRightObserver);
            this.f14018u.decrementAndGet();
            a();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerError(Throwable th2) {
            if (!ExceptionHelper.addThrowable(this.f14014q, th2)) {
                ff.a.onError(th2);
            } else {
                this.f14018u.decrementAndGet();
                a();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void innerValue(boolean z10, Object obj) {
            synchronized (this) {
                this.f14010m.offer(z10 ? f14007y : f14008z, obj);
            }
            a();
        }
    }

    public ObservableJoin(o<TLeft> oVar, o<? extends TRight> oVar2, n<? super TLeft, ? extends o<TLeftEnd>> nVar, n<? super TRight, ? extends o<TRightEnd>> nVar2, c<? super TLeft, ? super TRight, ? extends R> cVar) {
        super(oVar);
        this.f14003m = oVar2;
        this.f14004n = nVar;
        this.f14005o = nVar2;
        this.f14006p = cVar;
    }

    @Override // ne.k
    public void subscribeActual(q<? super R> qVar) {
        JoinDisposable joinDisposable = new JoinDisposable(qVar, this.f14004n, this.f14005o, this.f14006p);
        qVar.onSubscribe(joinDisposable);
        ObservableGroupJoin.LeftRightObserver leftRightObserver = new ObservableGroupJoin.LeftRightObserver(joinDisposable, true);
        qe.a aVar = joinDisposable.f14011n;
        aVar.add(leftRightObserver);
        ObservableGroupJoin.LeftRightObserver leftRightObserver2 = new ObservableGroupJoin.LeftRightObserver(joinDisposable, false);
        aVar.add(leftRightObserver2);
        this.f22058b.subscribe(leftRightObserver);
        this.f14003m.subscribe(leftRightObserver2);
    }
}
