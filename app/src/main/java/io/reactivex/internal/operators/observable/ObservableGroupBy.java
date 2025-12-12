package io.reactivex.internal.operators.observable;

import df.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.o;
import ne.q;
import se.n;

/* loaded from: classes2.dex */
public final class ObservableGroupBy<T, K, V> extends ye.a<T, b<K, V>> {

    /* renamed from: m, reason: collision with root package name */
    public final n<? super T, ? extends K> f13941m;

    /* renamed from: n, reason: collision with root package name */
    public final n<? super T, ? extends V> f13942n;

    /* renamed from: o, reason: collision with root package name */
    public final int f13943o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f13944p;

    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements q<T>, qe.b {
        private static final long serialVersionUID = -3688291656102519502L;

        /* renamed from: t, reason: collision with root package name */
        public static final Object f13945t = new Object();

        /* renamed from: b, reason: collision with root package name */
        public final q<? super b<K, V>> f13946b;

        /* renamed from: m, reason: collision with root package name */
        public final n<? super T, ? extends K> f13947m;

        /* renamed from: n, reason: collision with root package name */
        public final n<? super T, ? extends V> f13948n;

        /* renamed from: o, reason: collision with root package name */
        public final int f13949o;

        /* renamed from: p, reason: collision with root package name */
        public final boolean f13950p;

        /* renamed from: r, reason: collision with root package name */
        public qe.b f13952r;

        /* renamed from: s, reason: collision with root package name */
        public final AtomicBoolean f13953s = new AtomicBoolean();

        /* renamed from: q, reason: collision with root package name */
        public final ConcurrentHashMap f13951q = new ConcurrentHashMap();

        public GroupByObserver(q<? super b<K, V>> qVar, n<? super T, ? extends K> nVar, n<? super T, ? extends V> nVar2, int i10, boolean z10) {
            this.f13946b = qVar;
            this.f13947m = nVar;
            this.f13948n = nVar2;
            this.f13949o = i10;
            this.f13950p = z10;
            lazySet(1);
        }

        public void cancel(K k10) {
            if (k10 == null) {
                k10 = (K) f13945t;
            }
            this.f13951q.remove(k10);
            if (decrementAndGet() == 0) {
                this.f13952r.dispose();
            }
        }

        @Override // qe.b
        public void dispose() {
            if (this.f13953s.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.f13952r.dispose();
            }
        }

        @Override // ne.q
        public void onComplete() {
            ConcurrentHashMap concurrentHashMap = this.f13951q;
            ArrayList arrayList = new ArrayList(concurrentHashMap.values());
            concurrentHashMap.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((a) it.next()).onComplete();
            }
            this.f13946b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            ConcurrentHashMap concurrentHashMap = this.f13951q;
            ArrayList arrayList = new ArrayList(concurrentHashMap.values());
            concurrentHashMap.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((a) it.next()).onError(th2);
            }
            this.f13946b.onError(th2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.util.concurrent.ConcurrentHashMap] */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v2, types: [io.reactivex.internal.operators.observable.ObservableGroupBy$a] */
        /* JADX WARN: Type inference failed for: r3v9 */
        @Override // ne.q
        public void onNext(T t10) {
            try {
                K kApply = this.f13947m.apply(t10);
                Object obj = kApply != null ? kApply : f13945t;
                ?? r22 = this.f13951q;
                a aVar = (a) r22.get(obj);
                ?? r32 = aVar;
                if (aVar == false) {
                    if (this.f13953s.get()) {
                        return;
                    }
                    Object objCreateWith = a.createWith(kApply, this.f13949o, this, this.f13950p);
                    r22.put(obj, objCreateWith);
                    getAndIncrement();
                    this.f13946b.onNext(objCreateWith);
                    r32 = objCreateWith;
                }
                try {
                    r32.onNext(ue.a.requireNonNull(this.f13948n.apply(t10), "The value supplied is null"));
                } catch (Throwable th2) {
                    re.a.throwIfFatal(th2);
                    this.f13952r.dispose();
                    onError(th2);
                }
            } catch (Throwable th3) {
                re.a.throwIfFatal(th3);
                this.f13952r.dispose();
                onError(th3);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f13952r, bVar)) {
                this.f13952r = bVar;
                this.f13946b.onSubscribe(this);
            }
        }
    }

    public static final class State<T, K> extends AtomicInteger implements qe.b, o<T> {
        private static final long serialVersionUID = -3852313036005250360L;

        /* renamed from: b, reason: collision with root package name */
        public final K f13954b;

        /* renamed from: m, reason: collision with root package name */
        public final af.a<T> f13955m;

        /* renamed from: n, reason: collision with root package name */
        public final GroupByObserver<?, K, T> f13956n;

        /* renamed from: o, reason: collision with root package name */
        public final boolean f13957o;

        /* renamed from: p, reason: collision with root package name */
        public volatile boolean f13958p;

        /* renamed from: q, reason: collision with root package name */
        public Throwable f13959q;

        /* renamed from: r, reason: collision with root package name */
        public final AtomicBoolean f13960r = new AtomicBoolean();

        /* renamed from: s, reason: collision with root package name */
        public final AtomicBoolean f13961s = new AtomicBoolean();

        /* renamed from: t, reason: collision with root package name */
        public final AtomicReference<q<? super T>> f13962t = new AtomicReference<>();

        /* JADX WARN: Multi-variable type inference failed */
        public State(Object obj, int i10, GroupByObserver groupByObserver, boolean z10) {
            this.f13955m = new af.a<>(i10);
            this.f13956n = groupByObserver;
            this.f13954b = obj;
            this.f13957o = z10;
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x006d A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a() {
            /*
                r13 = this;
                int r0 = r13.getAndIncrement()
                if (r0 == 0) goto L7
                return
            L7:
                af.a<T> r0 = r13.f13955m
                boolean r1 = r13.f13957o
                java.util.concurrent.atomic.AtomicReference<ne.q<? super T>> r2 = r13.f13962t
                java.lang.Object r2 = r2.get()
                ne.q r2 = (ne.q) r2
                r3 = 1
                r4 = 1
            L15:
                if (r2 == 0) goto L75
            L17:
                boolean r5 = r13.f13958p
                java.lang.Object r6 = r0.poll()
                r7 = 0
                if (r6 != 0) goto L22
                r8 = 1
                goto L23
            L22:
                r8 = 0
            L23:
                java.util.concurrent.atomic.AtomicBoolean r9 = r13.f13960r
                boolean r9 = r9.get()
                af.a<T> r10 = r13.f13955m
                java.util.concurrent.atomic.AtomicReference<ne.q<? super T>> r11 = r13.f13962t
                r12 = 0
                if (r9 == 0) goto L3f
                r10.clear()
                io.reactivex.internal.operators.observable.ObservableGroupBy$GroupByObserver<?, K, T> r5 = r13.f13956n
                K r7 = r13.f13954b
                r5.cancel(r7)
                r11.lazySet(r12)
            L3d:
                r7 = 1
                goto L6b
            L3f:
                if (r5 == 0) goto L6b
                if (r1 == 0) goto L54
                if (r8 == 0) goto L6b
                java.lang.Throwable r5 = r13.f13959q
                r11.lazySet(r12)
                if (r5 == 0) goto L50
                r2.onError(r5)
                goto L3d
            L50:
                r2.onComplete()
                goto L3d
            L54:
                java.lang.Throwable r5 = r13.f13959q
                if (r5 == 0) goto L62
                r10.clear()
                r11.lazySet(r12)
                r2.onError(r5)
                goto L3d
            L62:
                if (r8 == 0) goto L6b
                r11.lazySet(r12)
                r2.onComplete()
                goto L3d
            L6b:
                if (r7 == 0) goto L6e
                return
            L6e:
                if (r8 == 0) goto L71
                goto L75
            L71:
                r2.onNext(r6)
                goto L17
            L75:
                int r4 = -r4
                int r4 = r13.addAndGet(r4)
                if (r4 != 0) goto L7d
                return
            L7d:
                if (r2 != 0) goto L15
                java.util.concurrent.atomic.AtomicReference<ne.q<? super T>> r2 = r13.f13962t
                java.lang.Object r2 = r2.get()
                ne.q r2 = (ne.q) r2
                goto L15
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableGroupBy.State.a():void");
        }

        @Override // qe.b
        public void dispose() {
            if (this.f13960r.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.f13962t.lazySet(null);
                this.f13956n.cancel(this.f13954b);
            }
        }

        public void onComplete() {
            this.f13958p = true;
            a();
        }

        public void onError(Throwable th2) {
            this.f13959q = th2;
            this.f13958p = true;
            a();
        }

        public void onNext(T t10) {
            this.f13955m.offer(t10);
            a();
        }

        @Override // ne.o
        public void subscribe(q<? super T> qVar) {
            if (!this.f13961s.compareAndSet(false, true)) {
                EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), qVar);
                return;
            }
            qVar.onSubscribe(this);
            AtomicReference<q<? super T>> atomicReference = this.f13962t;
            atomicReference.lazySet(qVar);
            if (this.f13960r.get()) {
                atomicReference.lazySet(null);
            } else {
                a();
            }
        }
    }

    public static final class a<K, T> extends b<K, T> {

        /* renamed from: m, reason: collision with root package name */
        public final State<T, K> f13963m;

        public a(K k10, State<T, K> state) {
            super(k10);
            this.f13963m = state;
        }

        public static <T, K> a<K, T> createWith(K k10, int i10, GroupByObserver<?, K, T> groupByObserver, boolean z10) {
            return new a<>(k10, new State(k10, i10, groupByObserver, z10));
        }

        public void onComplete() {
            this.f13963m.onComplete();
        }

        public void onError(Throwable th2) {
            this.f13963m.onError(th2);
        }

        public void onNext(T t10) {
            this.f13963m.onNext(t10);
        }

        @Override // ne.k
        public void subscribeActual(q<? super T> qVar) {
            this.f13963m.subscribe(qVar);
        }
    }

    public ObservableGroupBy(o<T> oVar, n<? super T, ? extends K> nVar, n<? super T, ? extends V> nVar2, int i10, boolean z10) {
        super(oVar);
        this.f13941m = nVar;
        this.f13942n = nVar2;
        this.f13943o = i10;
        this.f13944p = z10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super b<K, V>> qVar) {
        this.f22058b.subscribe(new GroupByObserver(qVar, this.f13941m, this.f13942n, this.f13943o, this.f13944p));
    }
}
