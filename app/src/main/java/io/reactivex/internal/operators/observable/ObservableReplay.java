package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.k;
import ne.o;
import ne.q;
import ne.r;
import se.n;

/* loaded from: classes2.dex */
public final class ObservableReplay<T> extends df.a<T> implements te.c {

    /* renamed from: p, reason: collision with root package name */
    public static final i f14136p = new i();

    /* renamed from: b, reason: collision with root package name */
    public final o<T> f14137b;

    /* renamed from: m, reason: collision with root package name */
    public final AtomicReference<ReplayObserver<T>> f14138m;

    /* renamed from: n, reason: collision with root package name */
    public final a<T> f14139n;

    /* renamed from: o, reason: collision with root package name */
    public final o<T> f14140o;

    public static final class InnerDisposable<T> extends AtomicInteger implements qe.b {
        private static final long serialVersionUID = 2728361546769921047L;

        /* renamed from: b, reason: collision with root package name */
        public final ReplayObserver<T> f14143b;

        /* renamed from: m, reason: collision with root package name */
        public final q<? super T> f14144m;

        /* renamed from: n, reason: collision with root package name */
        public Serializable f14145n;

        /* renamed from: o, reason: collision with root package name */
        public volatile boolean f14146o;

        public InnerDisposable(ReplayObserver<T> replayObserver, q<? super T> qVar) {
            this.f14143b = replayObserver;
            this.f14144m = qVar;
        }

        @Override // qe.b
        public void dispose() {
            if (this.f14146o) {
                return;
            }
            this.f14146o = true;
            this.f14143b.a(this);
            this.f14145n = null;
        }

        public boolean isDisposed() {
            return this.f14146o;
        }
    }

    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;

        /* renamed from: b, reason: collision with root package name */
        public final Object f14147b;

        public Node(Object obj) {
            this.f14147b = obj;
        }
    }

    public static final class ReplayObserver<T> extends AtomicReference<qe.b> implements q<T>, qe.b {

        /* renamed from: p, reason: collision with root package name */
        public static final InnerDisposable[] f14148p = new InnerDisposable[0];

        /* renamed from: q, reason: collision with root package name */
        public static final InnerDisposable[] f14149q = new InnerDisposable[0];
        private static final long serialVersionUID = -533785617179540163L;

        /* renamed from: b, reason: collision with root package name */
        public final e<T> f14150b;

        /* renamed from: m, reason: collision with root package name */
        public boolean f14151m;

        /* renamed from: n, reason: collision with root package name */
        public final AtomicReference<InnerDisposable[]> f14152n = new AtomicReference<>(f14148p);

        /* renamed from: o, reason: collision with root package name */
        public final AtomicBoolean f14153o = new AtomicBoolean();

        public ReplayObserver(e<T> eVar) {
            this.f14150b = eVar;
        }

        public final void a(InnerDisposable<T> innerDisposable) {
            boolean z10;
            InnerDisposable[] innerDisposableArr;
            do {
                AtomicReference<InnerDisposable[]> atomicReference = this.f14152n;
                InnerDisposable[] innerDisposableArr2 = atomicReference.get();
                int length = innerDisposableArr2.length;
                if (length == 0) {
                    return;
                }
                z10 = false;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        i10 = -1;
                        break;
                    } else if (innerDisposableArr2[i10].equals(innerDisposable)) {
                        break;
                    } else {
                        i10++;
                    }
                }
                if (i10 < 0) {
                    return;
                }
                if (length == 1) {
                    innerDisposableArr = f14148p;
                } else {
                    InnerDisposable[] innerDisposableArr3 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr2, 0, innerDisposableArr3, 0, i10);
                    System.arraycopy(innerDisposableArr2, i10 + 1, innerDisposableArr3, i10, (length - i10) - 1);
                    innerDisposableArr = innerDisposableArr3;
                }
                while (true) {
                    if (atomicReference.compareAndSet(innerDisposableArr2, innerDisposableArr)) {
                        z10 = true;
                        break;
                    } else if (atomicReference.get() != innerDisposableArr2) {
                        break;
                    }
                }
            } while (!z10);
        }

        @Override // qe.b
        public void dispose() {
            this.f14152n.set(f14149q);
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return this.f14152n.get() == f14149q;
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f14151m) {
                return;
            }
            this.f14151m = true;
            e<T> eVar = this.f14150b;
            eVar.complete();
            for (InnerDisposable<T> innerDisposable : this.f14152n.getAndSet(f14149q)) {
                eVar.replay(innerDisposable);
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f14151m) {
                ff.a.onError(th2);
                return;
            }
            this.f14151m = true;
            e<T> eVar = this.f14150b;
            eVar.error(th2);
            for (InnerDisposable<T> innerDisposable : this.f14152n.getAndSet(f14149q)) {
                eVar.replay(innerDisposable);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f14151m) {
                return;
            }
            e<T> eVar = this.f14150b;
            eVar.next(t10);
            for (InnerDisposable<T> innerDisposable : this.f14152n.get()) {
                eVar.replay(innerDisposable);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                for (InnerDisposable<T> innerDisposable : this.f14152n.get()) {
                    this.f14150b.replay(innerDisposable);
                }
            }
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;

        /* renamed from: n, reason: collision with root package name */
        public final r f14154n;

        /* renamed from: o, reason: collision with root package name */
        public final long f14155o;

        /* renamed from: p, reason: collision with root package name */
        public final TimeUnit f14156p;

        /* renamed from: q, reason: collision with root package name */
        public final int f14157q;

        public SizeAndTimeBoundReplayBuffer(int i10, long j10, TimeUnit timeUnit, r rVar) {
            this.f14154n = rVar;
            this.f14157q = i10;
            this.f14155o = j10;
            this.f14156p = timeUnit;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public final Object a(Object obj) {
            r rVar = this.f14154n;
            TimeUnit timeUnit = this.f14156p;
            return new gf.b(obj, rVar.now(timeUnit), timeUnit);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public final Node b() {
            Node node;
            long jNow = this.f14154n.now(this.f14156p) - this.f14155o;
            Node node2 = get();
            Node node3 = node2.get();
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null) {
                    break;
                }
                gf.b bVar = (gf.b) node2.f14147b;
                if (NotificationLite.isComplete(bVar.value()) || NotificationLite.isError(bVar.value()) || bVar.time() > jNow) {
                    break;
                }
                node3 = node2.get();
            }
            return node;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public final Object c(Object obj) {
            return ((gf.b) obj).value();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public final void d() {
            Node node;
            long jNow = this.f14154n.now(this.f14156p) - this.f14155o;
            Node node2 = get();
            Node node3 = node2.get();
            int i10 = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null) {
                    break;
                }
                int i11 = this.f14142m;
                if (i11 > this.f14157q && i11 > 1) {
                    i10++;
                    this.f14142m = i11 - 1;
                    node3 = node2.get();
                } else {
                    if (((gf.b) node2.f14147b).time() > jNow) {
                        break;
                    }
                    i10++;
                    this.f14142m--;
                    node3 = node2.get();
                }
            }
            if (i10 != 0) {
                set(node);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public final void e() {
            Node node;
            long jNow = this.f14154n.now(this.f14156p) - this.f14155o;
            Node node2 = get();
            Node node3 = node2.get();
            int i10 = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null || this.f14142m <= 1 || ((gf.b) node2.f14147b).time() > jNow) {
                    break;
                }
                i10++;
                this.f14142m--;
                node3 = node2.get();
            }
            if (i10 != 0) {
                set(node);
            }
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;

        /* renamed from: n, reason: collision with root package name */
        public final int f14158n;

        public SizeBoundReplayBuffer(int i10) {
            this.f14158n = i10;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public final void d() {
            if (this.f14142m > this.f14158n) {
                this.f14142m--;
                set(get().get());
            }
        }
    }

    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements e<T> {
        private static final long serialVersionUID = 7063189396499112664L;

        /* renamed from: b, reason: collision with root package name */
        public volatile int f14159b;

        public UnboundedReplayBuffer() {
            super(16);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public void complete() {
            add(NotificationLite.complete());
            this.f14159b++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public void error(Throwable th2) {
            add(NotificationLite.error(th2));
            this.f14159b++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public void next(T t10) {
            add(NotificationLite.next(t10));
            this.f14159b++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public void replay(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() != 0) {
                return;
            }
            q<? super T> qVar = innerDisposable.f14144m;
            int iAddAndGet = 1;
            while (!innerDisposable.isDisposed()) {
                int i10 = this.f14159b;
                Integer num = (Integer) innerDisposable.f14145n;
                int iIntValue = num != null ? num.intValue() : 0;
                while (iIntValue < i10) {
                    if (NotificationLite.accept(get(iIntValue), qVar) || innerDisposable.isDisposed()) {
                        return;
                    } else {
                        iIntValue++;
                    }
                }
                innerDisposable.f14145n = Integer.valueOf(iIntValue);
                iAddAndGet = innerDisposable.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }
    }

    public interface a<T> {
        e<T> call();
    }

    public static final class b<R> implements se.f<qe.b> {

        /* renamed from: b, reason: collision with root package name */
        public final ObserverResourceWrapper<R> f14160b;

        public b(ObserverResourceWrapper<R> observerResourceWrapper) {
            this.f14160b = observerResourceWrapper;
        }

        @Override // se.f
        public void accept(qe.b bVar) {
            this.f14160b.setResource(bVar);
        }
    }

    public static final class c<R, U> extends k<R> {

        /* renamed from: b, reason: collision with root package name */
        public final Callable<? extends df.a<U>> f14161b;

        /* renamed from: m, reason: collision with root package name */
        public final n<? super k<U>, ? extends o<R>> f14162m;

        public c(n nVar, Callable callable) {
            this.f14161b = callable;
            this.f14162m = nVar;
        }

        @Override // ne.k
        public void subscribeActual(q<? super R> qVar) {
            try {
                df.a aVar = (df.a) ue.a.requireNonNull(this.f14161b.call(), "The connectableFactory returned a null ConnectableObservable");
                o oVar = (o) ue.a.requireNonNull(this.f14162m.apply(aVar), "The selector returned a null ObservableSource");
                ObserverResourceWrapper observerResourceWrapper = new ObserverResourceWrapper(qVar);
                oVar.subscribe(observerResourceWrapper);
                aVar.connect(new b(observerResourceWrapper));
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                EmptyDisposable.error(th2, qVar);
            }
        }
    }

    public static final class d<T> extends df.a<T> {

        /* renamed from: b, reason: collision with root package name */
        public final df.a<T> f14163b;

        /* renamed from: m, reason: collision with root package name */
        public final k<T> f14164m;

        public d(df.a<T> aVar, k<T> kVar) {
            this.f14163b = aVar;
            this.f14164m = kVar;
        }

        @Override // df.a
        public void connect(se.f<? super qe.b> fVar) {
            this.f14163b.connect(fVar);
        }

        @Override // ne.k
        public void subscribeActual(q<? super T> qVar) {
            this.f14164m.subscribe(qVar);
        }
    }

    public interface e<T> {
        void complete();

        void error(Throwable th2);

        void next(T t10);

        void replay(InnerDisposable<T> innerDisposable);
    }

    public static final class f<T> implements a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final int f14165a;

        public f(int i10) {
            this.f14165a = i10;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.a
        public e<T> call() {
            return new SizeBoundReplayBuffer(this.f14165a);
        }
    }

    public static final class g<T> implements o<T> {

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReference<ReplayObserver<T>> f14166b;

        /* renamed from: m, reason: collision with root package name */
        public final a<T> f14167m;

        public g(AtomicReference<ReplayObserver<T>> atomicReference, a<T> aVar) {
            this.f14166b = atomicReference;
            this.f14167m = aVar;
        }

        @Override // ne.o
        public void subscribe(q<? super T> qVar) {
            ReplayObserver<T> replayObserver;
            boolean z10;
            boolean z11;
            while (true) {
                AtomicReference<ReplayObserver<T>> atomicReference = this.f14166b;
                replayObserver = atomicReference.get();
                if (replayObserver != null) {
                    break;
                }
                ReplayObserver<T> replayObserver2 = new ReplayObserver<>(this.f14167m.call());
                while (true) {
                    if (atomicReference.compareAndSet(null, replayObserver2)) {
                        z11 = true;
                        break;
                    } else if (atomicReference.get() != null) {
                        z11 = false;
                        break;
                    }
                }
                if (z11) {
                    replayObserver = replayObserver2;
                    break;
                }
            }
            InnerDisposable<T> innerDisposable = new InnerDisposable<>(replayObserver, qVar);
            qVar.onSubscribe(innerDisposable);
            do {
                AtomicReference<InnerDisposable[]> atomicReference2 = replayObserver.f14152n;
                InnerDisposable[] innerDisposableArr = atomicReference2.get();
                if (innerDisposableArr == ReplayObserver.f14149q) {
                    break;
                }
                int length = innerDisposableArr.length;
                InnerDisposable[] innerDisposableArr2 = new InnerDisposable[length + 1];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
                while (true) {
                    if (atomicReference2.compareAndSet(innerDisposableArr, innerDisposableArr2)) {
                        z10 = true;
                        break;
                    } else if (atomicReference2.get() != innerDisposableArr) {
                        z10 = false;
                        break;
                    }
                }
            } while (!z10);
            if (innerDisposable.isDisposed()) {
                replayObserver.a(innerDisposable);
            } else {
                replayObserver.f14150b.replay(innerDisposable);
            }
        }
    }

    public static final class h<T> implements a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final int f14168a;

        /* renamed from: b, reason: collision with root package name */
        public final long f14169b;

        /* renamed from: c, reason: collision with root package name */
        public final TimeUnit f14170c;

        /* renamed from: d, reason: collision with root package name */
        public final r f14171d;

        public h(int i10, long j10, TimeUnit timeUnit, r rVar) {
            this.f14168a = i10;
            this.f14169b = j10;
            this.f14170c = timeUnit;
            this.f14171d = rVar;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.a
        public e<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.f14168a, this.f14169b, this.f14170c, this.f14171d);
        }
    }

    public static final class i implements a<Object> {
        @Override // io.reactivex.internal.operators.observable.ObservableReplay.a
        public e<Object> call() {
            return new UnboundedReplayBuffer();
        }
    }

    public ObservableReplay(g gVar, o oVar, AtomicReference atomicReference, a aVar) {
        this.f14140o = gVar;
        this.f14137b = oVar;
        this.f14138m = atomicReference;
        this.f14139n = aVar;
    }

    public static <T> df.a<T> a(o<T> oVar, a<T> aVar) {
        AtomicReference atomicReference = new AtomicReference();
        return ff.a.onAssembly((df.a) new ObservableReplay(new g(atomicReference, aVar), oVar, atomicReference, aVar));
    }

    public static <T> df.a<T> create(o<T> oVar, int i10) {
        return i10 == Integer.MAX_VALUE ? createFrom(oVar) : a(oVar, new f(i10));
    }

    public static <T> df.a<T> createFrom(o<? extends T> oVar) {
        return a(oVar, f14136p);
    }

    public static <U, R> k<R> multicastSelector(Callable<? extends df.a<U>> callable, n<? super k<U>, ? extends o<R>> nVar) {
        return ff.a.onAssembly(new c(nVar, callable));
    }

    public static <T> df.a<T> observeOn(df.a<T> aVar, r rVar) {
        return ff.a.onAssembly((df.a) new d(aVar, aVar.observeOn(rVar)));
    }

    @Override // df.a
    public void connect(se.f<? super qe.b> fVar) {
        ReplayObserver<T> replayObserver;
        boolean z10;
        while (true) {
            AtomicReference<ReplayObserver<T>> atomicReference = this.f14138m;
            replayObserver = atomicReference.get();
            if (replayObserver != null && !replayObserver.isDisposed()) {
                break;
            }
            ReplayObserver<T> replayObserver2 = new ReplayObserver<>(this.f14139n.call());
            while (true) {
                if (atomicReference.compareAndSet(replayObserver, replayObserver2)) {
                    z10 = true;
                    break;
                } else if (atomicReference.get() != replayObserver) {
                    z10 = false;
                    break;
                }
            }
            if (z10) {
                replayObserver = replayObserver2;
                break;
            }
        }
        boolean z11 = replayObserver.f14153o.get();
        AtomicBoolean atomicBoolean = replayObserver.f14153o;
        boolean z12 = !z11 && atomicBoolean.compareAndSet(false, true);
        try {
            fVar.accept(replayObserver);
            if (z12) {
                this.f14137b.subscribe(replayObserver);
            }
        } catch (Throwable th2) {
            if (z12) {
                atomicBoolean.compareAndSet(true, false);
            }
            re.a.throwIfFatal(th2);
            throw ExceptionHelper.wrapOrThrow(th2);
        }
    }

    @Override // te.c
    public void resetIf(qe.b bVar) {
        AtomicReference<ReplayObserver<T>> atomicReference;
        ReplayObserver<T> replayObserver = (ReplayObserver) bVar;
        do {
            atomicReference = this.f14138m;
            if (atomicReference.compareAndSet(replayObserver, null)) {
                return;
            }
        } while (atomicReference.get() == replayObserver);
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        this.f14140o.subscribe(qVar);
    }

    public static <T> df.a<T> create(o<T> oVar, long j10, TimeUnit timeUnit, r rVar) {
        return create(oVar, j10, timeUnit, rVar, Integer.MAX_VALUE);
    }

    public static <T> df.a<T> create(o<T> oVar, long j10, TimeUnit timeUnit, r rVar, int i10) {
        return a(oVar, new h(i10, j10, timeUnit, rVar));
    }

    public static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements e<T> {
        private static final long serialVersionUID = 2346567790059478686L;

        /* renamed from: b, reason: collision with root package name */
        public Node f14141b;

        /* renamed from: m, reason: collision with root package name */
        public int f14142m;

        public BoundedReplayBuffer() {
            Node node = new Node(null);
            this.f14141b = node;
            set(node);
        }

        public Node b() {
            return get();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public final void complete() {
            Node node = new Node(a(NotificationLite.complete()));
            this.f14141b.set(node);
            this.f14141b = node;
            this.f14142m++;
            e();
        }

        public abstract void d();

        public void e() {
            Node node = get();
            if (node.f14147b != null) {
                Node node2 = new Node(null);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public final void error(Throwable th2) {
            Node node = new Node(a(NotificationLite.error(th2)));
            this.f14141b.set(node);
            this.f14141b = node;
            this.f14142m++;
            e();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public final void next(T t10) {
            Node node = new Node(a(NotificationLite.next(t10)));
            this.f14141b.set(node);
            this.f14141b = node;
            this.f14142m++;
            d();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.e
        public final void replay(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() != 0) {
                return;
            }
            int iAddAndGet = 1;
            do {
                Node nodeB = (Node) innerDisposable.f14145n;
                if (nodeB == null) {
                    nodeB = b();
                    innerDisposable.f14145n = nodeB;
                }
                while (!innerDisposable.isDisposed()) {
                    Node node = nodeB.get();
                    if (node == null) {
                        innerDisposable.f14145n = nodeB;
                        iAddAndGet = innerDisposable.addAndGet(-iAddAndGet);
                    } else {
                        if (NotificationLite.accept(c(node.f14147b), innerDisposable.f14144m)) {
                            innerDisposable.f14145n = null;
                            return;
                        }
                        nodeB = node;
                    }
                }
                innerDisposable.f14145n = null;
                return;
            } while (iAddAndGet != 0);
        }

        public Object a(Object obj) {
            return obj;
        }

        public Object c(Object obj) {
            return obj;
        }
    }
}
