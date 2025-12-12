package ne;

import io.reactivex.BackpressureStrategy;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.ForEachWhileObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableConcatMapSingle;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle;
import io.reactivex.internal.operators.observable.BlockingObservableIterable;
import io.reactivex.internal.operators.observable.ObservableAmb;
import io.reactivex.internal.operators.observable.ObservableBuffer;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary;
import io.reactivex.internal.operators.observable.ObservableCache;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableConcatMapEager;
import io.reactivex.internal.operators.observable.ObservableConcatWithCompletable;
import io.reactivex.internal.operators.observable.ObservableConcatWithMaybe;
import io.reactivex.internal.operators.observable.ObservableConcatWithSingle;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.internal.operators.observable.ObservableDoFinally;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.observable.ObservableFlatMapMaybe;
import io.reactivex.internal.operators.observable.ObservableFlatMapSingle;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableIntervalRange;
import io.reactivex.internal.operators.observable.ObservableJoin;
import io.reactivex.internal.operators.observable.ObservableMergeWithCompletable;
import io.reactivex.internal.operators.observable.ObservableMergeWithMaybe;
import io.reactivex.internal.operators.observable.ObservableMergeWithSingle;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservablePublish;
import io.reactivex.internal.operators.observable.ObservablePublishSelector;
import io.reactivex.internal.operators.observable.ObservableRange;
import io.reactivex.internal.operators.observable.ObservableRangeLong;
import io.reactivex.internal.operators.observable.ObservableRepeat;
import io.reactivex.internal.operators.observable.ObservableRepeatUntil;
import io.reactivex.internal.operators.observable.ObservableRepeatWhen;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.operators.observable.ObservableRetryBiPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryWhen;
import io.reactivex.internal.operators.observable.ObservableSampleTimed;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle;
import io.reactivex.internal.operators.observable.ObservableSkipLast;
import io.reactivex.internal.operators.observable.ObservableSkipLastTimed;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.internal.operators.observable.ObservableTakeLast;
import io.reactivex.internal.operators.observable.ObservableTakeLastTimed;
import io.reactivex.internal.operators.observable.ObservableTakeUntil;
import io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed;
import io.reactivex.internal.operators.observable.ObservableThrottleLatest;
import io.reactivex.internal.operators.observable.ObservableTimeout;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.internal.operators.observable.ObservableTimer;
import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn;
import io.reactivex.internal.operators.observable.ObservableUsing;
import io.reactivex.internal.operators.observable.ObservableWindow;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableWithLatestFrom;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany;
import io.reactivex.internal.operators.observable.ObservableZip;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.observers.TestObserver;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import ye.a0;
import ye.a1;
import ye.b1;
import ye.c0;
import ye.d0;
import ye.d1;
import ye.e0;
import ye.e1;
import ye.f0;
import ye.f1;
import ye.g0;
import ye.g1;
import ye.h0;
import ye.h1;
import ye.i0;
import ye.i1;
import ye.j0;
import ye.j1;
import ye.k0;
import ye.k1;
import ye.l0;
import ye.l1;
import ye.m0;
import ye.m1;
import ye.n0;
import ye.n1;
import ye.o0;
import ye.o1;
import ye.p0;
import ye.p1;
import ye.q0;
import ye.q1;
import ye.r0;
import ye.r1;
import ye.s0;
import ye.s1;
import ye.t0;
import ye.t1;
import ye.u0;
import ye.u1;
import ye.v;
import ye.v0;
import ye.v1;
import ye.w;
import ye.w0;
import ye.w1;
import ye.x;
import ye.x0;
import ye.x1;
import ye.y;
import ye.y0;
import ye.y1;
import ye.z;
import ye.z0;

/* compiled from: Observable.java */
/* loaded from: classes2.dex */
public abstract class k<T> implements o<T> {
    public static <T> k<T> amb(Iterable<? extends o<? extends T>> iterable) {
        ue.a.requireNonNull(iterable, "sources is null");
        return ff.a.onAssembly(new ObservableAmb(null, iterable));
    }

    public static <T> k<T> ambArray(o<? extends T>... oVarArr) {
        ue.a.requireNonNull(oVarArr, "sources is null");
        int length = oVarArr.length;
        return length == 0 ? empty() : length == 1 ? wrap(oVarArr[0]) : ff.a.onAssembly(new ObservableAmb(oVarArr, null));
    }

    public static int bufferSize() {
        return e.bufferSize();
    }

    public static <T, R> k<R> combineLatest(se.n<? super Object[], ? extends R> nVar, int i10, o<? extends T>... oVarArr) {
        return combineLatest(oVarArr, nVar, i10);
    }

    public static <T, R> k<R> combineLatestDelayError(o<? extends T>[] oVarArr, se.n<? super Object[], ? extends R> nVar) {
        return combineLatestDelayError(oVarArr, nVar, bufferSize());
    }

    public static <T> k<T> concat(Iterable<? extends o<? extends T>> iterable) {
        ue.a.requireNonNull(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(Functions.identity(), bufferSize(), false);
    }

    public static <T> k<T> concatArray(o<? extends T>... oVarArr) {
        return oVarArr.length == 0 ? empty() : oVarArr.length == 1 ? wrap(oVarArr[0]) : ff.a.onAssembly(new ObservableConcatMap(fromArray(oVarArr), Functions.identity(), bufferSize(), ErrorMode.BOUNDARY));
    }

    public static <T> k<T> concatArrayDelayError(o<? extends T>... oVarArr) {
        return oVarArr.length == 0 ? empty() : oVarArr.length == 1 ? wrap(oVarArr[0]) : concatDelayError(fromArray(oVarArr));
    }

    public static <T> k<T> concatArrayEager(o<? extends T>... oVarArr) {
        return concatArrayEager(bufferSize(), bufferSize(), oVarArr);
    }

    public static <T> k<T> concatArrayEagerDelayError(o<? extends T>... oVarArr) {
        return concatArrayEagerDelayError(bufferSize(), bufferSize(), oVarArr);
    }

    public static <T> k<T> concatDelayError(Iterable<? extends o<? extends T>> iterable) {
        ue.a.requireNonNull(iterable, "sources is null");
        return concatDelayError(fromIterable(iterable));
    }

    public static <T> k<T> concatEager(o<? extends o<? extends T>> oVar) {
        return concatEager(oVar, bufferSize(), bufferSize());
    }

    public static <T> k<T> create(m<T> mVar) {
        ue.a.requireNonNull(mVar, "source is null");
        return ff.a.onAssembly(new ObservableCreate(mVar));
    }

    public static <T> k<T> defer(Callable<? extends o<? extends T>> callable) {
        ue.a.requireNonNull(callable, "supplier is null");
        return ff.a.onAssembly(new ye.r(callable));
    }

    private k<T> doOnEach(se.f<? super T> fVar, se.f<? super Throwable> fVar2, se.a aVar, se.a aVar2) {
        ue.a.requireNonNull(fVar, "onNext is null");
        ue.a.requireNonNull(fVar2, "onError is null");
        ue.a.requireNonNull(aVar, "onComplete is null");
        ue.a.requireNonNull(aVar2, "onAfterTerminate is null");
        return ff.a.onAssembly(new z(this, fVar, fVar2, aVar, aVar2));
    }

    public static <T> k<T> empty() {
        return ff.a.onAssembly(e0.f22130b);
    }

    public static <T> k<T> error(Callable<? extends Throwable> callable) {
        ue.a.requireNonNull(callable, "errorSupplier is null");
        return ff.a.onAssembly(new f0(callable));
    }

    public static <T> k<T> fromArray(T... tArr) {
        ue.a.requireNonNull(tArr, "items is null");
        return tArr.length == 0 ? empty() : tArr.length == 1 ? just(tArr[0]) : ff.a.onAssembly(new i0(tArr));
    }

    public static <T> k<T> fromCallable(Callable<? extends T> callable) {
        ue.a.requireNonNull(callable, "supplier is null");
        return ff.a.onAssembly(new j0(callable));
    }

    public static <T> k<T> fromFuture(Future<? extends T> future) {
        ue.a.requireNonNull(future, "future is null");
        return ff.a.onAssembly(new k0(future, 0L, null));
    }

    public static <T> k<T> fromIterable(Iterable<? extends T> iterable) {
        ue.a.requireNonNull(iterable, "source is null");
        return ff.a.onAssembly(new l0(iterable));
    }

    public static <T> k<T> fromPublisher(zh.a<? extends T> aVar) {
        ue.a.requireNonNull(aVar, "publisher is null");
        return ff.a.onAssembly(new m0(aVar));
    }

    public static <T> k<T> generate(se.f<d<T>> fVar) {
        ue.a.requireNonNull(fVar, "generator is null");
        return generate(Functions.nullSupplier(), s0.simpleGenerator(fVar), Functions.emptyConsumer());
    }

    public static k<Long> interval(long j10, long j11, TimeUnit timeUnit) {
        return interval(j10, j11, timeUnit, gf.a.computation());
    }

    public static k<Long> intervalRange(long j10, long j11, long j12, long j13, TimeUnit timeUnit) {
        return intervalRange(j10, j11, j12, j13, timeUnit, gf.a.computation());
    }

    public static <T> k<T> just(T t10) {
        ue.a.requireNonNull(t10, "item is null");
        return ff.a.onAssembly(new io.reactivex.internal.operators.observable.a(t10));
    }

    public static <T> k<T> merge(Iterable<? extends o<? extends T>> iterable, int i10, int i11) {
        return fromIterable(iterable).flatMap(Functions.identity(), false, i10, i11);
    }

    public static <T> k<T> mergeArray(int i10, int i11, o<? extends T>... oVarArr) {
        return fromArray(oVarArr).flatMap(Functions.identity(), false, i10, i11);
    }

    public static <T> k<T> mergeArrayDelayError(int i10, int i11, o<? extends T>... oVarArr) {
        return fromArray(oVarArr).flatMap(Functions.identity(), true, i10, i11);
    }

    public static <T> k<T> mergeDelayError(Iterable<? extends o<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.identity(), true);
    }

    public static <T> k<T> never() {
        return ff.a.onAssembly(z0.f22536b);
    }

    public static k<Integer> range(int i10, int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException(ac.c.f("count >= 0 required but it was ", i11));
        }
        if (i11 == 0) {
            return empty();
        }
        if (i11 == 1) {
            return just(Integer.valueOf(i10));
        }
        if (i10 + (i11 - 1) <= 2147483647L) {
            return ff.a.onAssembly(new ObservableRange(i10, i11));
        }
        throw new IllegalArgumentException("Integer overflow");
    }

    public static k<Long> rangeLong(long j10, long j11) {
        if (j11 < 0) {
            throw new IllegalArgumentException(ac.c.h("count >= 0 required but it was ", j11));
        }
        if (j11 == 0) {
            return empty();
        }
        if (j11 == 1) {
            return just(Long.valueOf(j10));
        }
        long j12 = (j11 - 1) + j10;
        if (j10 <= 0 || j12 >= 0) {
            return ff.a.onAssembly(new ObservableRangeLong(j10, j11));
        }
        throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
    }

    public static <T> s<Boolean> sequenceEqual(o<? extends T> oVar, o<? extends T> oVar2) {
        return sequenceEqual(oVar, oVar2, ue.a.equalsPredicate(), bufferSize());
    }

    public static <T> k<T> switchOnNext(o<? extends o<? extends T>> oVar, int i10) {
        ue.a.requireNonNull(oVar, "sources is null");
        ue.a.verifyPositive(i10, "bufferSize");
        return ff.a.onAssembly(new ObservableSwitchMap(oVar, Functions.identity(), i10, false));
    }

    public static <T> k<T> switchOnNextDelayError(o<? extends o<? extends T>> oVar) {
        return switchOnNextDelayError(oVar, bufferSize());
    }

    private k<T> timeout0(long j10, TimeUnit timeUnit, o<? extends T> oVar, r rVar) {
        ue.a.requireNonNull(timeUnit, "timeUnit is null");
        ue.a.requireNonNull(rVar, "scheduler is null");
        return ff.a.onAssembly(new ObservableTimeoutTimed(this, j10, timeUnit, rVar, oVar));
    }

    public static k<Long> timer(long j10, TimeUnit timeUnit) {
        return timer(j10, timeUnit, gf.a.computation());
    }

    public static <T> k<T> unsafeCreate(o<T> oVar) {
        ue.a.requireNonNull(oVar, "onSubscribe is null");
        if (oVar instanceof k) {
            throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
        }
        return ff.a.onAssembly(new n0(oVar));
    }

    public static <T, D> k<T> using(Callable<? extends D> callable, se.n<? super D, ? extends o<? extends T>> nVar, se.f<? super D> fVar) {
        return using(callable, nVar, fVar, true);
    }

    public static <T> k<T> wrap(o<T> oVar) {
        ue.a.requireNonNull(oVar, "source is null");
        return oVar instanceof k ? ff.a.onAssembly((k) oVar) : ff.a.onAssembly(new n0(oVar));
    }

    public static <T, R> k<R> zip(Iterable<? extends o<? extends T>> iterable, se.n<? super Object[], ? extends R> nVar) {
        ue.a.requireNonNull(nVar, "zipper is null");
        ue.a.requireNonNull(iterable, "sources is null");
        return ff.a.onAssembly(new ObservableZip(null, iterable, nVar, bufferSize(), false));
    }

    public static <T, R> k<R> zipArray(se.n<? super Object[], ? extends R> nVar, boolean z10, int i10, o<? extends T>... oVarArr) {
        if (oVarArr.length == 0) {
            return empty();
        }
        ue.a.requireNonNull(nVar, "zipper is null");
        ue.a.verifyPositive(i10, "bufferSize");
        return ff.a.onAssembly(new ObservableZip(oVarArr, null, nVar, i10, z10));
    }

    public static <T, R> k<R> zipIterable(Iterable<? extends o<? extends T>> iterable, se.n<? super Object[], ? extends R> nVar, boolean z10, int i10) {
        ue.a.requireNonNull(nVar, "zipper is null");
        ue.a.requireNonNull(iterable, "sources is null");
        ue.a.verifyPositive(i10, "bufferSize");
        return ff.a.onAssembly(new ObservableZip(null, iterable, nVar, i10, z10));
    }

    public final s<Boolean> all(se.o<? super T> oVar) {
        ue.a.requireNonNull(oVar, "predicate is null");
        return ff.a.onAssembly(new ye.f(this, oVar));
    }

    public final k<T> ambWith(o<? extends T> oVar) {
        ue.a.requireNonNull(oVar, "other is null");
        return ambArray(this, oVar);
    }

    public final s<Boolean> any(se.o<? super T> oVar) {
        ue.a.requireNonNull(oVar, "predicate is null");
        return ff.a.onAssembly(new ye.h(this, oVar));
    }

    public final <R> R as(l<T, ? extends R> lVar) {
        return (R) ((l) ue.a.requireNonNull(lVar, "converter is null")).apply(this);
    }

    public final T blockingFirst() throws InterruptedException {
        we.d dVar = new we.d();
        subscribe(dVar);
        T tBlockingGet = dVar.blockingGet();
        if (tBlockingGet != null) {
            return tBlockingGet;
        }
        throw new NoSuchElementException();
    }

    public final void blockingForEach(se.f<? super T> fVar) {
        Iterator<T> it = blockingIterable().iterator();
        while (it.hasNext()) {
            try {
                fVar.accept(it.next());
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                ((qe.b) it).dispose();
                throw ExceptionHelper.wrapOrThrow(th2);
            }
        }
    }

    public final Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    public final T blockingLast() throws InterruptedException {
        we.e eVar = new we.e();
        subscribe(eVar);
        T tBlockingGet = eVar.blockingGet();
        if (tBlockingGet != null) {
            return tBlockingGet;
        }
        throw new NoSuchElementException();
    }

    public final Iterable<T> blockingLatest() {
        return new ye.b(this);
    }

    public final Iterable<T> blockingMostRecent(T t10) {
        return new ye.c(this, t10);
    }

    public final Iterable<T> blockingNext() {
        return new ye.d(this);
    }

    public final T blockingSingle() {
        T tBlockingGet = singleElement().blockingGet();
        if (tBlockingGet != null) {
            return tBlockingGet;
        }
        throw new NoSuchElementException();
    }

    public final void blockingSubscribe() {
        ye.i.subscribe(this);
    }

    public final k<List<T>> buffer(int i10) {
        return buffer(i10, i10);
    }

    public final k<T> cache() {
        return cacheWithInitialCapacity(16);
    }

    public final k<T> cacheWithInitialCapacity(int i10) {
        ue.a.verifyPositive(i10, "initialCapacity");
        return ff.a.onAssembly(new ObservableCache(this, i10));
    }

    public final <U> k<U> cast(Class<U> cls) {
        ue.a.requireNonNull(cls, "clazz is null");
        return (k<U>) map(Functions.castFunction(cls));
    }

    public final <U> s<U> collect(Callable<? extends U> callable, se.b<? super U, ? super T> bVar) {
        ue.a.requireNonNull(callable, "initialValueSupplier is null");
        ue.a.requireNonNull(bVar, "collector is null");
        return ff.a.onAssembly(new ye.n(this, callable, bVar));
    }

    public final <U> s<U> collectInto(U u10, se.b<? super U, ? super T> bVar) {
        ue.a.requireNonNull(u10, "initialValue is null");
        return collect(Functions.justCallable(u10), bVar);
    }

    public final <R> k<R> compose(p<? super T, ? extends R> pVar) {
        return wrap(((p) ue.a.requireNonNull(pVar, "composer is null")).apply(this));
    }

    public final <R> k<R> concatMap(se.n<? super T, ? extends o<? extends R>> nVar) {
        return concatMap(nVar, 2);
    }

    public final a concatMapCompletable(se.n<? super T, ? extends c> nVar) {
        return concatMapCompletable(nVar, 2);
    }

    public final a concatMapCompletableDelayError(se.n<? super T, ? extends c> nVar) {
        return concatMapCompletableDelayError(nVar, true, 2);
    }

    public final <R> k<R> concatMapDelayError(se.n<? super T, ? extends o<? extends R>> nVar) {
        return concatMapDelayError(nVar, bufferSize(), true);
    }

    public final <R> k<R> concatMapEager(se.n<? super T, ? extends o<? extends R>> nVar) {
        return concatMapEager(nVar, Integer.MAX_VALUE, bufferSize());
    }

    public final <R> k<R> concatMapEagerDelayError(se.n<? super T, ? extends o<? extends R>> nVar, boolean z10) {
        return concatMapEagerDelayError(nVar, Integer.MAX_VALUE, bufferSize(), z10);
    }

    public final <U> k<U> concatMapIterable(se.n<? super T, ? extends Iterable<? extends U>> nVar) {
        ue.a.requireNonNull(nVar, "mapper is null");
        return ff.a.onAssembly(new h0(this, nVar));
    }

    public final <R> k<R> concatMapMaybe(se.n<? super T, ? extends i<? extends R>> nVar) {
        return concatMapMaybe(nVar, 2);
    }

    public final <R> k<R> concatMapMaybeDelayError(se.n<? super T, ? extends i<? extends R>> nVar) {
        return concatMapMaybeDelayError(nVar, true, 2);
    }

    public final <R> k<R> concatMapSingle(se.n<? super T, ? extends u<? extends R>> nVar) {
        return concatMapSingle(nVar, 2);
    }

    public final <R> k<R> concatMapSingleDelayError(se.n<? super T, ? extends u<? extends R>> nVar) {
        return concatMapSingleDelayError(nVar, true, 2);
    }

    public final k<T> concatWith(o<? extends T> oVar) {
        ue.a.requireNonNull(oVar, "other is null");
        return concat(this, oVar);
    }

    public final s<Boolean> contains(Object obj) {
        ue.a.requireNonNull(obj, "element is null");
        return any(Functions.equalsWith(obj));
    }

    public final s<Long> count() {
        return ff.a.onAssembly(new ye.p(this));
    }

    public final <U> k<T> debounce(se.n<? super T, ? extends o<U>> nVar) {
        ue.a.requireNonNull(nVar, "debounceSelector is null");
        return ff.a.onAssembly(new ye.q(this, nVar));
    }

    public final k<T> defaultIfEmpty(T t10) {
        ue.a.requireNonNull(t10, "defaultItem is null");
        return switchIfEmpty(just(t10));
    }

    public final <U> k<T> delay(se.n<? super T, ? extends o<U>> nVar) {
        ue.a.requireNonNull(nVar, "itemDelay is null");
        return (k<T>) flatMap(s0.itemDelay(nVar));
    }

    public final <U> k<T> delaySubscription(o<U> oVar) {
        ue.a.requireNonNull(oVar, "other is null");
        return ff.a.onAssembly(new ye.t(this, oVar));
    }

    @Deprecated
    public final <T2> k<T2> dematerialize() {
        return ff.a.onAssembly(new ye.u(this, Functions.identity()));
    }

    public final k<T> distinct() {
        return distinct(Functions.identity(), Functions.createHashSet());
    }

    public final k<T> distinctUntilChanged() {
        return distinctUntilChanged(Functions.identity());
    }

    public final k<T> doAfterNext(se.f<? super T> fVar) {
        ue.a.requireNonNull(fVar, "onAfterNext is null");
        return ff.a.onAssembly(new y(this, fVar));
    }

    public final k<T> doAfterTerminate(se.a aVar) {
        ue.a.requireNonNull(aVar, "onFinally is null");
        return doOnEach(Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.f13540c, aVar);
    }

    public final k<T> doFinally(se.a aVar) {
        ue.a.requireNonNull(aVar, "onFinally is null");
        return ff.a.onAssembly(new ObservableDoFinally(this, aVar));
    }

    public final k<T> doOnComplete(se.a aVar) {
        return doOnEach(Functions.emptyConsumer(), Functions.emptyConsumer(), aVar, Functions.f13540c);
    }

    public final k<T> doOnDispose(se.a aVar) {
        return doOnLifecycle(Functions.emptyConsumer(), aVar);
    }

    public final k<T> doOnError(se.f<? super Throwable> fVar) {
        se.f<? super T> fVarEmptyConsumer = Functions.emptyConsumer();
        Functions.n nVar = Functions.f13540c;
        return doOnEach(fVarEmptyConsumer, fVar, nVar, nVar);
    }

    public final k<T> doOnLifecycle(se.f<? super qe.b> fVar, se.a aVar) {
        ue.a.requireNonNull(fVar, "onSubscribe is null");
        ue.a.requireNonNull(aVar, "onDispose is null");
        return ff.a.onAssembly(new a0(this, fVar, aVar));
    }

    public final k<T> doOnNext(se.f<? super T> fVar) {
        se.f<? super Throwable> fVarEmptyConsumer = Functions.emptyConsumer();
        Functions.n nVar = Functions.f13540c;
        return doOnEach(fVar, fVarEmptyConsumer, nVar, nVar);
    }

    public final k<T> doOnSubscribe(se.f<? super qe.b> fVar) {
        return doOnLifecycle(fVar, Functions.f13540c);
    }

    public final k<T> doOnTerminate(se.a aVar) {
        ue.a.requireNonNull(aVar, "onTerminate is null");
        return doOnEach(Functions.emptyConsumer(), Functions.actionConsumer(aVar), aVar, Functions.f13540c);
    }

    public final g<T> elementAt(long j10) {
        if (j10 >= 0) {
            return ff.a.onAssembly(new c0(this, j10));
        }
        throw new IndexOutOfBoundsException(ac.c.h("index >= 0 required but it was ", j10));
    }

    public final s<T> elementAtOrError(long j10) {
        if (j10 >= 0) {
            return ff.a.onAssembly(new d0(this, j10, null));
        }
        throw new IndexOutOfBoundsException(ac.c.h("index >= 0 required but it was ", j10));
    }

    public final k<T> filter(se.o<? super T> oVar) {
        ue.a.requireNonNull(oVar, "predicate is null");
        return ff.a.onAssembly(new g0(this, oVar));
    }

    public final s<T> first(T t10) {
        return elementAt(0L, t10);
    }

    public final g<T> firstElement() {
        return elementAt(0L);
    }

    public final s<T> firstOrError() {
        return elementAtOrError(0L);
    }

    public final <R> k<R> flatMap(se.n<? super T, ? extends o<? extends R>> nVar) {
        return flatMap((se.n) nVar, false);
    }

    public final a flatMapCompletable(se.n<? super T, ? extends c> nVar) {
        return flatMapCompletable(nVar, false);
    }

    public final <U> k<U> flatMapIterable(se.n<? super T, ? extends Iterable<? extends U>> nVar) {
        ue.a.requireNonNull(nVar, "mapper is null");
        return ff.a.onAssembly(new h0(this, nVar));
    }

    public final <R> k<R> flatMapMaybe(se.n<? super T, ? extends i<? extends R>> nVar) {
        return flatMapMaybe(nVar, false);
    }

    public final <R> k<R> flatMapSingle(se.n<? super T, ? extends u<? extends R>> nVar) {
        return flatMapSingle(nVar, false);
    }

    public final qe.b forEach(se.f<? super T> fVar) {
        return subscribe(fVar);
    }

    public final qe.b forEachWhile(se.o<? super T> oVar) {
        return forEachWhile(oVar, Functions.f13542e, Functions.f13540c);
    }

    public final <K> k<df.b<K, T>> groupBy(se.n<? super T, ? extends K> nVar) {
        return (k<df.b<K, T>>) groupBy(nVar, Functions.identity(), false, bufferSize());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> k<R> groupJoin(o<? extends TRight> oVar, se.n<? super T, ? extends o<TLeftEnd>> nVar, se.n<? super TRight, ? extends o<TRightEnd>> nVar2, se.c<? super T, ? super k<TRight>, ? extends R> cVar) {
        ue.a.requireNonNull(oVar, "other is null");
        ue.a.requireNonNull(nVar, "leftEnd is null");
        ue.a.requireNonNull(nVar2, "rightEnd is null");
        ue.a.requireNonNull(cVar, "resultSelector is null");
        return ff.a.onAssembly(new ObservableGroupJoin(this, oVar, nVar, nVar2, cVar));
    }

    public final k<T> hide() {
        return ff.a.onAssembly(new p0(this));
    }

    public final a ignoreElements() {
        return ff.a.onAssembly(new r0(this));
    }

    public final s<Boolean> isEmpty() {
        return all(Functions.alwaysFalse());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> k<R> join(o<? extends TRight> oVar, se.n<? super T, ? extends o<TLeftEnd>> nVar, se.n<? super TRight, ? extends o<TRightEnd>> nVar2, se.c<? super T, ? super TRight, ? extends R> cVar) {
        ue.a.requireNonNull(oVar, "other is null");
        ue.a.requireNonNull(nVar, "leftEnd is null");
        ue.a.requireNonNull(nVar2, "rightEnd is null");
        ue.a.requireNonNull(cVar, "resultSelector is null");
        return ff.a.onAssembly(new ObservableJoin(this, oVar, nVar, nVar2, cVar));
    }

    public final s<T> last(T t10) {
        ue.a.requireNonNull(t10, "defaultItem is null");
        return ff.a.onAssembly(new u0(this, t10));
    }

    public final g<T> lastElement() {
        return ff.a.onAssembly(new t0(this));
    }

    public final s<T> lastOrError() {
        return ff.a.onAssembly(new u0(this, null));
    }

    public final <R> k<R> lift(n<? extends R, ? super T> nVar) {
        ue.a.requireNonNull(nVar, "lifter is null");
        return ff.a.onAssembly(new v0(this, nVar));
    }

    public final <R> k<R> map(se.n<? super T, ? extends R> nVar) {
        ue.a.requireNonNull(nVar, "mapper is null");
        return ff.a.onAssembly(new w0(this, nVar));
    }

    public final k<j<T>> materialize() {
        return ff.a.onAssembly(new y0(this));
    }

    public final k<T> mergeWith(o<? extends T> oVar) {
        ue.a.requireNonNull(oVar, "other is null");
        return merge(this, oVar);
    }

    public final k<T> observeOn(r rVar) {
        return observeOn(rVar, false, bufferSize());
    }

    public final <U> k<U> ofType(Class<U> cls) {
        ue.a.requireNonNull(cls, "clazz is null");
        return filter(Functions.isInstanceOf(cls)).cast(cls);
    }

    public final k<T> onErrorResumeNext(se.n<? super Throwable, ? extends o<? extends T>> nVar) {
        ue.a.requireNonNull(nVar, "resumeFunction is null");
        return ff.a.onAssembly(new a1(this, nVar, false));
    }

    public final k<T> onErrorReturn(se.n<? super Throwable, ? extends T> nVar) {
        ue.a.requireNonNull(nVar, "valueSupplier is null");
        return ff.a.onAssembly(new b1(this, nVar));
    }

    public final k<T> onErrorReturnItem(T t10) {
        ue.a.requireNonNull(t10, "item is null");
        return onErrorReturn(Functions.justFunction(t10));
    }

    public final k<T> onExceptionResumeNext(o<? extends T> oVar) {
        ue.a.requireNonNull(oVar, "next is null");
        return ff.a.onAssembly(new a1(this, Functions.justFunction(oVar), true));
    }

    public final k<T> onTerminateDetach() {
        return ff.a.onAssembly(new v(this));
    }

    public final df.a<T> publish() {
        return ObservablePublish.create(this);
    }

    public final g<T> reduce(se.c<T, T, T> cVar) {
        ue.a.requireNonNull(cVar, "reducer is null");
        return ff.a.onAssembly(new d1(this, cVar));
    }

    public final <R> s<R> reduceWith(Callable<R> callable, se.c<R, ? super T, R> cVar) {
        ue.a.requireNonNull(callable, "seedSupplier is null");
        ue.a.requireNonNull(cVar, "reducer is null");
        return ff.a.onAssembly(new f1(this, callable, cVar));
    }

    public final k<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    public final k<T> repeatUntil(se.e eVar) {
        ue.a.requireNonNull(eVar, "stop is null");
        return ff.a.onAssembly(new ObservableRepeatUntil(this, eVar));
    }

    public final k<T> repeatWhen(se.n<? super k<Object>, ? extends o<?>> nVar) {
        ue.a.requireNonNull(nVar, "handler is null");
        return ff.a.onAssembly(new ObservableRepeatWhen(this, nVar));
    }

    public final df.a<T> replay() {
        return ObservableReplay.createFrom(this);
    }

    public final k<T> retry() {
        return retry(Long.MAX_VALUE, Functions.alwaysTrue());
    }

    public final k<T> retryUntil(se.e eVar) {
        ue.a.requireNonNull(eVar, "stop is null");
        return retry(Long.MAX_VALUE, Functions.predicateReverseFor(eVar));
    }

    public final k<T> retryWhen(se.n<? super k<Throwable>, ? extends o<?>> nVar) {
        ue.a.requireNonNull(nVar, "handler is null");
        return ff.a.onAssembly(new ObservableRetryWhen(this, nVar));
    }

    public final void safeSubscribe(q<? super T> qVar) {
        ue.a.requireNonNull(qVar, "observer is null");
        if (qVar instanceof ef.d) {
            subscribe(qVar);
        } else {
            subscribe(new ef.d(qVar));
        }
    }

    public final k<T> sample(long j10, TimeUnit timeUnit) {
        return sample(j10, timeUnit, gf.a.computation());
    }

    public final k<T> scan(se.c<T, T, T> cVar) {
        ue.a.requireNonNull(cVar, "accumulator is null");
        return ff.a.onAssembly(new g1(this, cVar));
    }

    public final <R> k<R> scanWith(Callable<R> callable, se.c<R, ? super T, R> cVar) {
        ue.a.requireNonNull(callable, "seedSupplier is null");
        ue.a.requireNonNull(cVar, "accumulator is null");
        return ff.a.onAssembly(new h1(this, callable, cVar));
    }

    public final k<T> serialize() {
        return ff.a.onAssembly(new i1(this));
    }

    public final k<T> share() {
        return publish().refCount();
    }

    public final s<T> single(T t10) {
        ue.a.requireNonNull(t10, "defaultItem is null");
        return ff.a.onAssembly(new k1(this, t10));
    }

    public final g<T> singleElement() {
        return ff.a.onAssembly(new j1(this));
    }

    public final s<T> singleOrError() {
        return ff.a.onAssembly(new k1(this, null));
    }

    public final k<T> skip(long j10) {
        return j10 <= 0 ? ff.a.onAssembly(this) : ff.a.onAssembly(new l1(this, j10));
    }

    public final k<T> skipLast(int i10) {
        if (i10 >= 0) {
            return i10 == 0 ? ff.a.onAssembly(this) : ff.a.onAssembly(new ObservableSkipLast(this, i10));
        }
        throw new IndexOutOfBoundsException(ac.c.f("count >= 0 required but it was ", i10));
    }

    public final <U> k<T> skipUntil(o<U> oVar) {
        ue.a.requireNonNull(oVar, "other is null");
        return ff.a.onAssembly(new m1(this, oVar));
    }

    public final k<T> skipWhile(se.o<? super T> oVar) {
        ue.a.requireNonNull(oVar, "predicate is null");
        return ff.a.onAssembly(new n1(this, oVar));
    }

    public final k<T> sorted() {
        return toList().toObservable().map(Functions.listSorter(Functions.naturalComparator())).flatMapIterable(Functions.identity());
    }

    public final k<T> startWith(Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    public final k<T> startWithArray(T... tArr) {
        k kVarFromArray = fromArray(tArr);
        return kVarFromArray == empty() ? ff.a.onAssembly(this) : concatArray(kVarFromArray, this);
    }

    public final qe.b subscribe() {
        return subscribe(Functions.emptyConsumer(), Functions.f13542e, Functions.f13540c, Functions.emptyConsumer());
    }

    public abstract void subscribeActual(q<? super T> qVar);

    public final k<T> subscribeOn(r rVar) {
        ue.a.requireNonNull(rVar, "scheduler is null");
        return ff.a.onAssembly(new ObservableSubscribeOn(this, rVar));
    }

    public final <E extends q<? super T>> E subscribeWith(E e10) {
        subscribe(e10);
        return e10;
    }

    public final k<T> switchIfEmpty(o<? extends T> oVar) {
        ue.a.requireNonNull(oVar, "other is null");
        return ff.a.onAssembly(new o1(this, oVar));
    }

    public final <R> k<R> switchMap(se.n<? super T, ? extends o<? extends R>> nVar) {
        return switchMap(nVar, bufferSize());
    }

    public final a switchMapCompletable(se.n<? super T, ? extends c> nVar) {
        ue.a.requireNonNull(nVar, "mapper is null");
        return ff.a.onAssembly(new ObservableSwitchMapCompletable(this, nVar, false));
    }

    public final a switchMapCompletableDelayError(se.n<? super T, ? extends c> nVar) {
        ue.a.requireNonNull(nVar, "mapper is null");
        return ff.a.onAssembly(new ObservableSwitchMapCompletable(this, nVar, true));
    }

    public final <R> k<R> switchMapDelayError(se.n<? super T, ? extends o<? extends R>> nVar) {
        return switchMapDelayError(nVar, bufferSize());
    }

    public final <R> k<R> switchMapMaybe(se.n<? super T, ? extends i<? extends R>> nVar) {
        ue.a.requireNonNull(nVar, "mapper is null");
        return ff.a.onAssembly(new ObservableSwitchMapMaybe(this, nVar, false));
    }

    public final <R> k<R> switchMapMaybeDelayError(se.n<? super T, ? extends i<? extends R>> nVar) {
        ue.a.requireNonNull(nVar, "mapper is null");
        return ff.a.onAssembly(new ObservableSwitchMapMaybe(this, nVar, true));
    }

    public final <R> k<R> switchMapSingle(se.n<? super T, ? extends u<? extends R>> nVar) {
        ue.a.requireNonNull(nVar, "mapper is null");
        return ff.a.onAssembly(new ObservableSwitchMapSingle(this, nVar, false));
    }

    public final <R> k<R> switchMapSingleDelayError(se.n<? super T, ? extends u<? extends R>> nVar) {
        ue.a.requireNonNull(nVar, "mapper is null");
        return ff.a.onAssembly(new ObservableSwitchMapSingle(this, nVar, true));
    }

    public final k<T> take(long j10) {
        if (j10 >= 0) {
            return ff.a.onAssembly(new p1(this, j10));
        }
        throw new IllegalArgumentException(ac.c.h("count >= 0 required but it was ", j10));
    }

    public final k<T> takeLast(int i10) {
        if (i10 >= 0) {
            return i10 == 0 ? ff.a.onAssembly(new q0(this)) : i10 == 1 ? ff.a.onAssembly(new q1(this)) : ff.a.onAssembly(new ObservableTakeLast(this, i10));
        }
        throw new IndexOutOfBoundsException(ac.c.f("count >= 0 required but it was ", i10));
    }

    public final <U> k<T> takeUntil(o<U> oVar) {
        ue.a.requireNonNull(oVar, "other is null");
        return ff.a.onAssembly(new ObservableTakeUntil(this, oVar));
    }

    public final k<T> takeWhile(se.o<? super T> oVar) {
        ue.a.requireNonNull(oVar, "predicate is null");
        return ff.a.onAssembly(new s1(this, oVar));
    }

    public final TestObserver<T> test() {
        TestObserver<T> testObserver = new TestObserver<>();
        subscribe(testObserver);
        return testObserver;
    }

    public final k<T> throttleFirst(long j10, TimeUnit timeUnit) {
        return throttleFirst(j10, timeUnit, gf.a.computation());
    }

    public final k<T> throttleLast(long j10, TimeUnit timeUnit) {
        return sample(j10, timeUnit);
    }

    public final k<T> throttleLatest(long j10, TimeUnit timeUnit) {
        return throttleLatest(j10, timeUnit, gf.a.computation(), false);
    }

    public final k<T> throttleWithTimeout(long j10, TimeUnit timeUnit) {
        return debounce(j10, timeUnit);
    }

    public final k<gf.b<T>> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, gf.a.computation());
    }

    public final <V> k<T> timeout(se.n<? super T, ? extends o<V>> nVar) {
        return timeout0(null, nVar, null);
    }

    public final k<gf.b<T>> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, gf.a.computation());
    }

    public final <R> R to(se.n<? super k<T>, R> nVar) {
        try {
            return (R) ((se.n) ue.a.requireNonNull(nVar, "converter is null")).apply(this);
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            throw ExceptionHelper.wrapOrThrow(th2);
        }
    }

    public final e<T> toFlowable(BackpressureStrategy backpressureStrategy) {
        xe.b bVar = new xe.b(this);
        int iOrdinal = backpressureStrategy.ordinal();
        return iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 3 ? iOrdinal != 4 ? bVar.onBackpressureBuffer() : bVar.onBackpressureLatest() : bVar.onBackpressureDrop() : ff.a.onAssembly(new FlowableOnBackpressureError(bVar)) : bVar;
    }

    public final Future<T> toFuture() {
        return (Future) subscribeWith(new we.h());
    }

    public final s<List<T>> toList() {
        return toList(16);
    }

    public final <K> s<Map<K, T>> toMap(se.n<? super T, ? extends K> nVar) {
        ue.a.requireNonNull(nVar, "keySelector is null");
        return (s<Map<K, T>>) collect(HashMapSupplier.asCallable(), Functions.toMapKeySelector(nVar));
    }

    public final <K> s<Map<K, Collection<T>>> toMultimap(se.n<? super T, ? extends K> nVar) {
        return (s<Map<K, Collection<T>>>) toMultimap(nVar, Functions.identity(), HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    public final s<List<T>> toSortedList() {
        return toSortedList(Functions.naturalOrder());
    }

    public final k<T> unsubscribeOn(r rVar) {
        ue.a.requireNonNull(rVar, "scheduler is null");
        return ff.a.onAssembly(new ObservableUnsubscribeOn(this, rVar));
    }

    public final k<k<T>> window(long j10) {
        return window(j10, j10, bufferSize());
    }

    public final <U, R> k<R> withLatestFrom(o<? extends U> oVar, se.c<? super T, ? super U, ? extends R> cVar) {
        ue.a.requireNonNull(oVar, "other is null");
        ue.a.requireNonNull(cVar, "combiner is null");
        return ff.a.onAssembly(new ObservableWithLatestFrom(this, cVar, oVar));
    }

    public final <U, R> k<R> zipWith(Iterable<U> iterable, se.c<? super T, ? super U, ? extends R> cVar) {
        ue.a.requireNonNull(iterable, "other is null");
        ue.a.requireNonNull(cVar, "zipper is null");
        return ff.a.onAssembly(new y1(this, iterable, cVar));
    }

    public static <T, R> k<R> combineLatest(Iterable<? extends o<? extends T>> iterable, se.n<? super Object[], ? extends R> nVar) {
        return combineLatest(iterable, nVar, bufferSize());
    }

    public static <T, R> k<R> combineLatestDelayError(se.n<? super Object[], ? extends R> nVar, int i10, o<? extends T>... oVarArr) {
        return combineLatestDelayError(oVarArr, nVar, i10);
    }

    public static <T> k<T> concatArrayEager(int i10, int i11, o<? extends T>... oVarArr) {
        return fromArray(oVarArr).concatMapEagerDelayError(Functions.identity(), i10, i11, false);
    }

    public static <T> k<T> concatArrayEagerDelayError(int i10, int i11, o<? extends T>... oVarArr) {
        return fromArray(oVarArr).concatMapEagerDelayError(Functions.identity(), i10, i11, true);
    }

    public static <T> k<T> concatEager(o<? extends o<? extends T>> oVar, int i10, int i11) {
        return wrap(oVar).concatMapEager(Functions.identity(), i10, i11);
    }

    public static k<Long> interval(long j10, long j11, TimeUnit timeUnit, r rVar) {
        ue.a.requireNonNull(timeUnit, "unit is null");
        ue.a.requireNonNull(rVar, "scheduler is null");
        return ff.a.onAssembly(new ObservableInterval(Math.max(0L, j10), Math.max(0L, j11), timeUnit, rVar));
    }

    public static k<Long> intervalRange(long j10, long j11, long j12, long j13, TimeUnit timeUnit, r rVar) {
        if (j11 < 0) {
            throw new IllegalArgumentException(ac.c.h("count >= 0 required but it was ", j11));
        }
        if (j11 == 0) {
            return empty().delay(j12, timeUnit, rVar);
        }
        long j14 = (j11 - 1) + j10;
        if (j10 > 0 && j14 < 0) {
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        ue.a.requireNonNull(timeUnit, "unit is null");
        ue.a.requireNonNull(rVar, "scheduler is null");
        return ff.a.onAssembly(new ObservableIntervalRange(j10, j14, Math.max(0L, j12), Math.max(0L, j13), timeUnit, rVar));
    }

    public static <T> k<T> merge(Iterable<? extends o<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.identity());
    }

    public static <T> k<T> mergeArray(o<? extends T>... oVarArr) {
        return fromArray(oVarArr).flatMap(Functions.identity(), oVarArr.length);
    }

    public static <T> k<T> mergeArrayDelayError(o<? extends T>... oVarArr) {
        return fromArray(oVarArr).flatMap(Functions.identity(), true, oVarArr.length);
    }

    public static <T> k<T> mergeDelayError(Iterable<? extends o<? extends T>> iterable, int i10, int i11) {
        return fromIterable(iterable).flatMap(Functions.identity(), true, i10, i11);
    }

    public static <T> s<Boolean> sequenceEqual(o<? extends T> oVar, o<? extends T> oVar2, se.d<? super T, ? super T> dVar) {
        return sequenceEqual(oVar, oVar2, dVar, bufferSize());
    }

    public static <T> k<T> switchOnNextDelayError(o<? extends o<? extends T>> oVar, int i10) {
        ue.a.requireNonNull(oVar, "sources is null");
        ue.a.verifyPositive(i10, "prefetch");
        return ff.a.onAssembly(new ObservableSwitchMap(oVar, Functions.identity(), i10, true));
    }

    public static k<Long> timer(long j10, TimeUnit timeUnit, r rVar) {
        ue.a.requireNonNull(timeUnit, "unit is null");
        ue.a.requireNonNull(rVar, "scheduler is null");
        return ff.a.onAssembly(new ObservableTimer(Math.max(j10, 0L), timeUnit, rVar));
    }

    public static <T, D> k<T> using(Callable<? extends D> callable, se.n<? super D, ? extends o<? extends T>> nVar, se.f<? super D> fVar, boolean z10) {
        ue.a.requireNonNull(callable, "resourceSupplier is null");
        ue.a.requireNonNull(nVar, "sourceSupplier is null");
        ue.a.requireNonNull(fVar, "disposer is null");
        return ff.a.onAssembly(new ObservableUsing(callable, nVar, fVar, z10));
    }

    public final Iterable<T> blockingIterable(int i10) {
        ue.a.verifyPositive(i10, "bufferSize");
        return new BlockingObservableIterable(this, i10);
    }

    public final void blockingSubscribe(se.f<? super T> fVar) {
        ye.i.subscribe(this, fVar, Functions.f13542e, Functions.f13540c);
    }

    public final k<List<T>> buffer(int i10, int i11) {
        return (k<List<T>>) buffer(i10, i11, ArrayListSupplier.asCallable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> k<R> concatMap(se.n<? super T, ? extends o<? extends R>> nVar, int i10) {
        ue.a.requireNonNull(nVar, "mapper is null");
        ue.a.verifyPositive(i10, "prefetch");
        if (!(this instanceof ve.d)) {
            return ff.a.onAssembly(new ObservableConcatMap(this, nVar, i10, ErrorMode.IMMEDIATE));
        }
        Object objCall = ((ve.d) this).call();
        return objCall == null ? empty() : ObservableScalarXMap.scalarXMap(objCall, nVar);
    }

    public final a concatMapCompletable(se.n<? super T, ? extends c> nVar, int i10) {
        ue.a.requireNonNull(nVar, "mapper is null");
        ue.a.verifyPositive(i10, "capacityHint");
        return ff.a.onAssembly(new ObservableConcatMapCompletable(this, nVar, ErrorMode.IMMEDIATE, i10));
    }

    public final a concatMapCompletableDelayError(se.n<? super T, ? extends c> nVar, boolean z10) {
        return concatMapCompletableDelayError(nVar, z10, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> k<R> concatMapDelayError(se.n<? super T, ? extends o<? extends R>> nVar, int i10, boolean z10) {
        ue.a.requireNonNull(nVar, "mapper is null");
        ue.a.verifyPositive(i10, "prefetch");
        if (!(this instanceof ve.d)) {
            return ff.a.onAssembly(new ObservableConcatMap(this, nVar, i10, z10 ? ErrorMode.END : ErrorMode.BOUNDARY));
        }
        Object objCall = ((ve.d) this).call();
        return objCall == null ? empty() : ObservableScalarXMap.scalarXMap(objCall, nVar);
    }

    public final <R> k<R> concatMapEager(se.n<? super T, ? extends o<? extends R>> nVar, int i10, int i11) {
        ue.a.requireNonNull(nVar, "mapper is null");
        ue.a.verifyPositive(i10, "maxConcurrency");
        ue.a.verifyPositive(i11, "prefetch");
        return ff.a.onAssembly(new ObservableConcatMapEager(this, nVar, ErrorMode.IMMEDIATE, i10, i11));
    }

    public final <R> k<R> concatMapEagerDelayError(se.n<? super T, ? extends o<? extends R>> nVar, int i10, int i11, boolean z10) {
        ue.a.requireNonNull(nVar, "mapper is null");
        ue.a.verifyPositive(i10, "maxConcurrency");
        ue.a.verifyPositive(i11, "prefetch");
        return ff.a.onAssembly(new ObservableConcatMapEager(this, nVar, z10 ? ErrorMode.END : ErrorMode.BOUNDARY, i10, i11));
    }

    public final <R> k<R> concatMapMaybe(se.n<? super T, ? extends i<? extends R>> nVar, int i10) {
        ue.a.requireNonNull(nVar, "mapper is null");
        ue.a.verifyPositive(i10, "prefetch");
        return ff.a.onAssembly(new ObservableConcatMapMaybe(this, nVar, ErrorMode.IMMEDIATE, i10));
    }

    public final <R> k<R> concatMapMaybeDelayError(se.n<? super T, ? extends i<? extends R>> nVar, boolean z10) {
        return concatMapMaybeDelayError(nVar, z10, 2);
    }

    public final <R> k<R> concatMapSingle(se.n<? super T, ? extends u<? extends R>> nVar, int i10) {
        ue.a.requireNonNull(nVar, "mapper is null");
        ue.a.verifyPositive(i10, "prefetch");
        return ff.a.onAssembly(new ObservableConcatMapSingle(this, nVar, ErrorMode.IMMEDIATE, i10));
    }

    public final <R> k<R> concatMapSingleDelayError(se.n<? super T, ? extends u<? extends R>> nVar, boolean z10) {
        return concatMapSingleDelayError(nVar, z10, 2);
    }

    public final <R> k<R> dematerialize(se.n<? super T, j<R>> nVar) {
        ue.a.requireNonNull(nVar, "selector is null");
        return ff.a.onAssembly(new ye.u(this, nVar));
    }

    public final <K> k<T> distinct(se.n<? super T, K> nVar) {
        return distinct(nVar, Functions.createHashSet());
    }

    public final <K> k<T> distinctUntilChanged(se.n<? super T, K> nVar) {
        ue.a.requireNonNull(nVar, "keySelector is null");
        return ff.a.onAssembly(new x(this, nVar, ue.a.equalsPredicate()));
    }

    public final <R> k<R> flatMap(se.n<? super T, ? extends o<? extends R>> nVar, boolean z10) {
        return flatMap(nVar, z10, Integer.MAX_VALUE);
    }

    public final a flatMapCompletable(se.n<? super T, ? extends c> nVar, boolean z10) {
        ue.a.requireNonNull(nVar, "mapper is null");
        return ff.a.onAssembly(new ObservableFlatMapCompletableCompletable(this, nVar, z10));
    }

    public final <R> k<R> flatMapMaybe(se.n<? super T, ? extends i<? extends R>> nVar, boolean z10) {
        ue.a.requireNonNull(nVar, "mapper is null");
        return ff.a.onAssembly(new ObservableFlatMapMaybe(this, nVar, z10));
    }

    public final <R> k<R> flatMapSingle(se.n<? super T, ? extends u<? extends R>> nVar, boolean z10) {
        ue.a.requireNonNull(nVar, "mapper is null");
        return ff.a.onAssembly(new ObservableFlatMapSingle(this, nVar, z10));
    }

    public final qe.b forEachWhile(se.o<? super T> oVar, se.f<? super Throwable> fVar) {
        return forEachWhile(oVar, fVar, Functions.f13540c);
    }

    public final <K> k<df.b<K, T>> groupBy(se.n<? super T, ? extends K> nVar, boolean z10) {
        return (k<df.b<K, T>>) groupBy(nVar, Functions.identity(), z10, bufferSize());
    }

    public final k<T> observeOn(r rVar, boolean z10) {
        return observeOn(rVar, z10, bufferSize());
    }

    public final <R> k<R> publish(se.n<? super k<T>, ? extends o<R>> nVar) {
        ue.a.requireNonNull(nVar, "selector is null");
        return ff.a.onAssembly(new ObservablePublishSelector(this, nVar));
    }

    public final k<T> repeat(long j10) {
        if (j10 >= 0) {
            return j10 == 0 ? empty() : ff.a.onAssembly(new ObservableRepeat(this, j10));
        }
        throw new IllegalArgumentException(ac.c.h("times >= 0 required but it was ", j10));
    }

    public final <R> k<R> replay(se.n<? super k<T>, ? extends o<R>> nVar) {
        ue.a.requireNonNull(nVar, "selector is null");
        return ObservableReplay.multicastSelector(s0.replayCallable(this), nVar);
    }

    public final k<T> retry(se.d<? super Integer, ? super Throwable> dVar) {
        ue.a.requireNonNull(dVar, "predicate is null");
        return ff.a.onAssembly(new ObservableRetryBiPredicate(this, dVar));
    }

    public final k<T> sample(long j10, TimeUnit timeUnit, boolean z10) {
        return sample(j10, timeUnit, gf.a.computation(), z10);
    }

    public final k<T> sorted(Comparator<? super T> comparator) {
        ue.a.requireNonNull(comparator, "sortFunction is null");
        return toList().toObservable().map(Functions.listSorter(comparator)).flatMapIterable(Functions.identity());
    }

    public final k<T> startWith(o<? extends T> oVar) {
        ue.a.requireNonNull(oVar, "other is null");
        return concatArray(oVar, this);
    }

    public final qe.b subscribe(se.f<? super T> fVar) {
        return subscribe(fVar, Functions.f13542e, Functions.f13540c, Functions.emptyConsumer());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> k<R> switchMap(se.n<? super T, ? extends o<? extends R>> nVar, int i10) {
        ue.a.requireNonNull(nVar, "mapper is null");
        ue.a.verifyPositive(i10, "bufferSize");
        if (!(this instanceof ve.d)) {
            return ff.a.onAssembly(new ObservableSwitchMap(this, nVar, i10, false));
        }
        Object objCall = ((ve.d) this).call();
        return objCall == null ? empty() : ObservableScalarXMap.scalarXMap(objCall, nVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> k<R> switchMapDelayError(se.n<? super T, ? extends o<? extends R>> nVar, int i10) {
        ue.a.requireNonNull(nVar, "mapper is null");
        ue.a.verifyPositive(i10, "bufferSize");
        if (!(this instanceof ve.d)) {
            return ff.a.onAssembly(new ObservableSwitchMap(this, nVar, i10, true));
        }
        Object objCall = ((ve.d) this).call();
        return objCall == null ? empty() : ObservableScalarXMap.scalarXMap(objCall, nVar);
    }

    public final k<T> throttleFirst(long j10, TimeUnit timeUnit, r rVar) {
        ue.a.requireNonNull(timeUnit, "unit is null");
        ue.a.requireNonNull(rVar, "scheduler is null");
        return ff.a.onAssembly(new ObservableThrottleFirstTimed(this, j10, timeUnit, rVar));
    }

    public final k<T> throttleLast(long j10, TimeUnit timeUnit, r rVar) {
        return sample(j10, timeUnit, rVar);
    }

    public final k<T> throttleLatest(long j10, TimeUnit timeUnit, boolean z10) {
        return throttleLatest(j10, timeUnit, gf.a.computation(), z10);
    }

    public final k<T> throttleWithTimeout(long j10, TimeUnit timeUnit, r rVar) {
        return debounce(j10, timeUnit, rVar);
    }

    public final k<gf.b<T>> timeInterval(r rVar) {
        return timeInterval(TimeUnit.MILLISECONDS, rVar);
    }

    public final <V> k<T> timeout(se.n<? super T, ? extends o<V>> nVar, o<? extends T> oVar) {
        ue.a.requireNonNull(oVar, "other is null");
        return timeout0(null, nVar, oVar);
    }

    public final k<gf.b<T>> timestamp(r rVar) {
        return timestamp(TimeUnit.MILLISECONDS, rVar);
    }

    public final s<List<T>> toList(int i10) {
        ue.a.verifyPositive(i10, "capacityHint");
        return ff.a.onAssembly(new v1(this, i10));
    }

    public final s<List<T>> toSortedList(Comparator<? super T> comparator) {
        ue.a.requireNonNull(comparator, "comparator is null");
        return (s<List<T>>) toList().map(Functions.listSorter(comparator));
    }

    public final k<k<T>> window(long j10, long j11) {
        return window(j10, j11, bufferSize());
    }

    public static <T, R> k<R> combineLatest(Iterable<? extends o<? extends T>> iterable, se.n<? super Object[], ? extends R> nVar, int i10) {
        ue.a.requireNonNull(iterable, "sources is null");
        ue.a.requireNonNull(nVar, "combiner is null");
        ue.a.verifyPositive(i10, "bufferSize");
        return ff.a.onAssembly(new ObservableCombineLatest(null, iterable, nVar, i10 << 1, false));
    }

    public static <T, R> k<R> combineLatestDelayError(o<? extends T>[] oVarArr, se.n<? super Object[], ? extends R> nVar, int i10) {
        ue.a.verifyPositive(i10, "bufferSize");
        ue.a.requireNonNull(nVar, "combiner is null");
        if (oVarArr.length == 0) {
            return empty();
        }
        return ff.a.onAssembly(new ObservableCombineLatest(oVarArr, null, nVar, i10 << 1, true));
    }

    public static <T> k<T> concat(o<? extends o<? extends T>> oVar) {
        return concat(oVar, bufferSize());
    }

    public static <T> k<T> concatDelayError(o<? extends o<? extends T>> oVar) {
        return concatDelayError(oVar, bufferSize(), true);
    }

    public static <T> k<T> concatEager(Iterable<? extends o<? extends T>> iterable) {
        return concatEager(iterable, bufferSize(), bufferSize());
    }

    public static <T> k<T> error(Throwable th2) {
        ue.a.requireNonNull(th2, "exception is null");
        return error((Callable<? extends Throwable>) Functions.justCallable(th2));
    }

    public static <T> k<T> fromFuture(Future<? extends T> future, long j10, TimeUnit timeUnit) {
        ue.a.requireNonNull(future, "future is null");
        ue.a.requireNonNull(timeUnit, "unit is null");
        return ff.a.onAssembly(new k0(future, j10, timeUnit));
    }

    public static <T> k<T> just(T t10, T t11) {
        ue.a.requireNonNull(t10, "item1 is null");
        ue.a.requireNonNull(t11, "item2 is null");
        return fromArray(t10, t11);
    }

    public static <T> k<T> merge(Iterable<? extends o<? extends T>> iterable, int i10) {
        return fromIterable(iterable).flatMap(Functions.identity(), i10);
    }

    public static <T> k<T> mergeDelayError(Iterable<? extends o<? extends T>> iterable, int i10) {
        return fromIterable(iterable).flatMap(Functions.identity(), true, i10);
    }

    public static <T> s<Boolean> sequenceEqual(o<? extends T> oVar, o<? extends T> oVar2, se.d<? super T, ? super T> dVar, int i10) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        ue.a.requireNonNull(dVar, "isEqual is null");
        ue.a.verifyPositive(i10, "bufferSize");
        return ff.a.onAssembly(new ObservableSequenceEqualSingle(oVar, oVar2, dVar, i10));
    }

    public final T blockingSingle(T t10) {
        return single(t10).blockingGet();
    }

    public final void blockingSubscribe(se.f<? super T> fVar, se.f<? super Throwable> fVar2) {
        ye.i.subscribe(this, fVar, fVar2, Functions.f13540c);
    }

    public final <U extends Collection<? super T>> k<U> buffer(int i10, int i11, Callable<U> callable) {
        ue.a.verifyPositive(i10, "count");
        ue.a.verifyPositive(i11, "skip");
        ue.a.requireNonNull(callable, "bufferSupplier is null");
        return ff.a.onAssembly(new ObservableBuffer(this, i10, i11, callable));
    }

    public final a concatMapCompletableDelayError(se.n<? super T, ? extends c> nVar, boolean z10, int i10) {
        ue.a.requireNonNull(nVar, "mapper is null");
        ue.a.verifyPositive(i10, "prefetch");
        return ff.a.onAssembly(new ObservableConcatMapCompletable(this, nVar, z10 ? ErrorMode.END : ErrorMode.BOUNDARY, i10));
    }

    public final <U> k<U> concatMapIterable(se.n<? super T, ? extends Iterable<? extends U>> nVar, int i10) {
        ue.a.requireNonNull(nVar, "mapper is null");
        ue.a.verifyPositive(i10, "prefetch");
        return (k<U>) concatMap(s0.flatMapIntoIterable(nVar), i10);
    }

    public final <R> k<R> concatMapMaybeDelayError(se.n<? super T, ? extends i<? extends R>> nVar, boolean z10, int i10) {
        ue.a.requireNonNull(nVar, "mapper is null");
        ue.a.verifyPositive(i10, "prefetch");
        return ff.a.onAssembly(new ObservableConcatMapMaybe(this, nVar, z10 ? ErrorMode.END : ErrorMode.BOUNDARY, i10));
    }

    public final <R> k<R> concatMapSingleDelayError(se.n<? super T, ? extends u<? extends R>> nVar, boolean z10, int i10) {
        ue.a.requireNonNull(nVar, "mapper is null");
        ue.a.verifyPositive(i10, "prefetch");
        return ff.a.onAssembly(new ObservableConcatMapSingle(this, nVar, z10 ? ErrorMode.END : ErrorMode.BOUNDARY, i10));
    }

    public final k<T> concatWith(u<? extends T> uVar) {
        ue.a.requireNonNull(uVar, "other is null");
        return ff.a.onAssembly(new ObservableConcatWithSingle(this, uVar));
    }

    public final k<T> debounce(long j10, TimeUnit timeUnit) {
        return debounce(j10, timeUnit, gf.a.computation());
    }

    public final k<T> delay(long j10, TimeUnit timeUnit) {
        return delay(j10, timeUnit, gf.a.computation(), false);
    }

    public final k<T> delaySubscription(long j10, TimeUnit timeUnit) {
        return delaySubscription(j10, timeUnit, gf.a.computation());
    }

    public final <K> k<T> distinct(se.n<? super T, K> nVar, Callable<? extends Collection<? super K>> callable) {
        ue.a.requireNonNull(nVar, "keySelector is null");
        ue.a.requireNonNull(callable, "collectionSupplier is null");
        return ff.a.onAssembly(new w(this, nVar, callable));
    }

    public final <R> k<R> flatMap(se.n<? super T, ? extends o<? extends R>> nVar, boolean z10, int i10) {
        return flatMap(nVar, z10, i10, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U, V> k<V> flatMapIterable(se.n<? super T, ? extends Iterable<? extends U>> nVar, se.c<? super T, ? super U, ? extends V> cVar) {
        ue.a.requireNonNull(nVar, "mapper is null");
        ue.a.requireNonNull(cVar, "resultSelector is null");
        return (k<V>) flatMap(s0.flatMapIntoIterable(nVar), cVar, false, bufferSize(), bufferSize());
    }

    public final qe.b forEachWhile(se.o<? super T> oVar, se.f<? super Throwable> fVar, se.a aVar) {
        ue.a.requireNonNull(oVar, "onNext is null");
        ue.a.requireNonNull(fVar, "onError is null");
        ue.a.requireNonNull(aVar, "onComplete is null");
        ForEachWhileObserver forEachWhileObserver = new ForEachWhileObserver(oVar, fVar, aVar);
        subscribe(forEachWhileObserver);
        return forEachWhileObserver;
    }

    public final <K, V> k<df.b<K, V>> groupBy(se.n<? super T, ? extends K> nVar, se.n<? super T, ? extends V> nVar2) {
        return groupBy(nVar, nVar2, false, bufferSize());
    }

    public final k<T> mergeWith(u<? extends T> uVar) {
        ue.a.requireNonNull(uVar, "other is null");
        return ff.a.onAssembly(new ObservableMergeWithSingle(this, uVar));
    }

    public final k<T> observeOn(r rVar, boolean z10, int i10) {
        ue.a.requireNonNull(rVar, "scheduler is null");
        ue.a.verifyPositive(i10, "bufferSize");
        return ff.a.onAssembly(new ObservableObserveOn(this, rVar, z10, i10));
    }

    public final k<T> onErrorResumeNext(o<? extends T> oVar) {
        ue.a.requireNonNull(oVar, "next is null");
        return onErrorResumeNext(Functions.justFunction(oVar));
    }

    public final <R> s<R> reduce(R r10, se.c<R, ? super T, R> cVar) {
        ue.a.requireNonNull(r10, "seed is null");
        ue.a.requireNonNull(cVar, "reducer is null");
        return ff.a.onAssembly(new e1(this, r10, cVar));
    }

    public final k<T> sample(long j10, TimeUnit timeUnit, r rVar) {
        ue.a.requireNonNull(timeUnit, "unit is null");
        ue.a.requireNonNull(rVar, "scheduler is null");
        return ff.a.onAssembly(new ObservableSampleTimed(this, j10, timeUnit, rVar, false));
    }

    public final <R> k<R> scan(R r10, se.c<R, ? super T, R> cVar) {
        ue.a.requireNonNull(r10, "initialValue is null");
        return scanWith(Functions.justCallable(r10), cVar);
    }

    public final k<T> skip(long j10, TimeUnit timeUnit) {
        return skipUntil(timer(j10, timeUnit));
    }

    public final qe.b subscribe(se.f<? super T> fVar, se.f<? super Throwable> fVar2) {
        return subscribe(fVar, fVar2, Functions.f13540c, Functions.emptyConsumer());
    }

    public final k<T> takeUntil(se.o<? super T> oVar) {
        ue.a.requireNonNull(oVar, "stopPredicate is null");
        return ff.a.onAssembly(new r1(this, oVar));
    }

    public final TestObserver<T> test(boolean z10) {
        TestObserver<T> testObserver = new TestObserver<>();
        if (z10) {
            testObserver.dispose();
        }
        subscribe(testObserver);
        return testObserver;
    }

    public final k<T> throttleLatest(long j10, TimeUnit timeUnit, r rVar) {
        return throttleLatest(j10, timeUnit, rVar, false);
    }

    public final k<gf.b<T>> timeInterval(TimeUnit timeUnit) {
        return timeInterval(timeUnit, gf.a.computation());
    }

    public final k<gf.b<T>> timestamp(TimeUnit timeUnit) {
        return timestamp(timeUnit, gf.a.computation());
    }

    public final <K, V> s<Map<K, V>> toMap(se.n<? super T, ? extends K> nVar, se.n<? super T, ? extends V> nVar2) {
        ue.a.requireNonNull(nVar, "keySelector is null");
        ue.a.requireNonNull(nVar2, "valueSelector is null");
        return (s<Map<K, V>>) collect(HashMapSupplier.asCallable(), Functions.toMapKeyValueSelector(nVar, nVar2));
    }

    public final k<k<T>> window(long j10, long j11, int i10) {
        ue.a.verifyPositive(j10, "count");
        ue.a.verifyPositive(j11, "skip");
        ue.a.verifyPositive(i10, "bufferSize");
        return ff.a.onAssembly(new ObservableWindow(this, j10, j11, i10));
    }

    public static <T> k<T> concat(o<? extends o<? extends T>> oVar, int i10) {
        ue.a.requireNonNull(oVar, "sources is null");
        ue.a.verifyPositive(i10, "prefetch");
        return ff.a.onAssembly(new ObservableConcatMap(oVar, Functions.identity(), i10, ErrorMode.IMMEDIATE));
    }

    public static <T> k<T> concatDelayError(o<? extends o<? extends T>> oVar, int i10, boolean z10) {
        ue.a.requireNonNull(oVar, "sources is null");
        ue.a.verifyPositive(i10, "prefetch is null");
        return ff.a.onAssembly(new ObservableConcatMap(oVar, Functions.identity(), i10, z10 ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    public static <T> k<T> concatEager(Iterable<? extends o<? extends T>> iterable, int i10, int i11) {
        return fromIterable(iterable).concatMapEagerDelayError(Functions.identity(), i10, i11, false);
    }

    public static <T> k<T> merge(o<? extends o<? extends T>> oVar) {
        ue.a.requireNonNull(oVar, "sources is null");
        return ff.a.onAssembly(new ObservableFlatMap(oVar, Functions.identity(), false, Integer.MAX_VALUE, bufferSize()));
    }

    public static <T> k<T> mergeDelayError(o<? extends o<? extends T>> oVar) {
        ue.a.requireNonNull(oVar, "sources is null");
        return ff.a.onAssembly(new ObservableFlatMap(oVar, Functions.identity(), true, Integer.MAX_VALUE, bufferSize()));
    }

    public static <T> k<T> switchOnNext(o<? extends o<? extends T>> oVar) {
        return switchOnNext(oVar, bufferSize());
    }

    private <U, V> k<T> timeout0(o<U> oVar, se.n<? super T, ? extends o<V>> nVar, o<? extends T> oVar2) {
        ue.a.requireNonNull(nVar, "itemTimeoutIndicator is null");
        return ff.a.onAssembly(new ObservableTimeout(this, oVar, nVar, oVar2));
    }

    public static <T, R> k<R> zip(o<? extends o<? extends T>> oVar, se.n<? super Object[], ? extends R> nVar) {
        ue.a.requireNonNull(nVar, "zipper is null");
        ue.a.requireNonNull(oVar, "sources is null");
        return ff.a.onAssembly(new u1(oVar, 16).flatMap(s0.zipIterable(nVar)));
    }

    public final void blockingSubscribe(se.f<? super T> fVar, se.f<? super Throwable> fVar2, se.a aVar) {
        ye.i.subscribe(this, fVar, fVar2, aVar);
    }

    public final k<T> debounce(long j10, TimeUnit timeUnit, r rVar) {
        ue.a.requireNonNull(timeUnit, "unit is null");
        ue.a.requireNonNull(rVar, "scheduler is null");
        return ff.a.onAssembly(new ObservableDebounceTimed(this, j10, timeUnit, rVar));
    }

    public final k<T> delay(long j10, TimeUnit timeUnit, boolean z10) {
        return delay(j10, timeUnit, gf.a.computation(), z10);
    }

    public final k<T> delaySubscription(long j10, TimeUnit timeUnit, r rVar) {
        return delaySubscription(timer(j10, timeUnit, rVar));
    }

    public final k<T> distinctUntilChanged(se.d<? super T, ? super T> dVar) {
        ue.a.requireNonNull(dVar, "comparer is null");
        return ff.a.onAssembly(new x(this, Functions.identity(), dVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> k<R> flatMap(se.n<? super T, ? extends o<? extends R>> nVar, boolean z10, int i10, int i11) {
        ue.a.requireNonNull(nVar, "mapper is null");
        ue.a.verifyPositive(i10, "maxConcurrency");
        ue.a.verifyPositive(i11, "bufferSize");
        if (this instanceof ve.d) {
            Object objCall = ((ve.d) this).call();
            if (objCall == null) {
                return empty();
            }
            return ObservableScalarXMap.scalarXMap(objCall, nVar);
        }
        return ff.a.onAssembly(new ObservableFlatMap(this, nVar, z10, i10, i11));
    }

    public final <K, V> k<df.b<K, V>> groupBy(se.n<? super T, ? extends K> nVar, se.n<? super T, ? extends V> nVar2, boolean z10) {
        return groupBy(nVar, nVar2, z10, bufferSize());
    }

    public final <R> k<R> replay(se.n<? super k<T>, ? extends o<R>> nVar, int i10) {
        ue.a.requireNonNull(nVar, "selector is null");
        ue.a.verifyPositive(i10, "bufferSize");
        return ObservableReplay.multicastSelector(s0.replayCallable(this, i10), nVar);
    }

    public final k<T> retry(long j10) {
        return retry(j10, Functions.alwaysTrue());
    }

    public final k<T> skip(long j10, TimeUnit timeUnit, r rVar) {
        return skipUntil(timer(j10, timeUnit, rVar));
    }

    public final k<T> startWith(T t10) {
        ue.a.requireNonNull(t10, "item is null");
        return concatArray(just(t10), this);
    }

    public final qe.b subscribe(se.f<? super T> fVar, se.f<? super Throwable> fVar2, se.a aVar) {
        return subscribe(fVar, fVar2, aVar, Functions.emptyConsumer());
    }

    public final k<T> throttleLatest(long j10, TimeUnit timeUnit, r rVar, boolean z10) {
        ue.a.requireNonNull(timeUnit, "unit is null");
        ue.a.requireNonNull(rVar, "scheduler is null");
        return ff.a.onAssembly(new ObservableThrottleLatest(this, j10, timeUnit, rVar, z10));
    }

    public final k<gf.b<T>> timeInterval(TimeUnit timeUnit, r rVar) {
        ue.a.requireNonNull(timeUnit, "unit is null");
        ue.a.requireNonNull(rVar, "scheduler is null");
        return ff.a.onAssembly(new t1(this, timeUnit, rVar));
    }

    public final k<T> timeout(long j10, TimeUnit timeUnit) {
        return timeout0(j10, timeUnit, null, gf.a.computation());
    }

    public final k<gf.b<T>> timestamp(TimeUnit timeUnit, r rVar) {
        ue.a.requireNonNull(timeUnit, "unit is null");
        ue.a.requireNonNull(rVar, "scheduler is null");
        return (k<gf.b<T>>) map(Functions.timestampWith(timeUnit, rVar));
    }

    public final <U extends Collection<? super T>> s<U> toList(Callable<U> callable) {
        ue.a.requireNonNull(callable, "collectionSupplier is null");
        return ff.a.onAssembly(new v1(this, callable));
    }

    public final s<List<T>> toSortedList(Comparator<? super T> comparator, int i10) {
        ue.a.requireNonNull(comparator, "comparator is null");
        return (s<List<T>>) toList(i10).map(Functions.listSorter(comparator));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, R> k<R> withLatestFrom(o<T1> oVar, o<T2> oVar2, se.g<? super T, ? super T1, ? super T2, R> gVar) {
        ue.a.requireNonNull(oVar, "o1 is null");
        ue.a.requireNonNull(oVar2, "o2 is null");
        ue.a.requireNonNull(gVar, "combiner is null");
        return withLatestFrom((o<?>[]) new o[]{oVar, oVar2}, Functions.toFunction(gVar));
    }

    public final <U, R> k<R> zipWith(o<? extends U> oVar, se.c<? super T, ? super U, ? extends R> cVar) {
        ue.a.requireNonNull(oVar, "other is null");
        return zip(this, oVar, cVar);
    }

    public static <T, S> k<T> generate(Callable<S> callable, se.b<S, d<T>> bVar) {
        ue.a.requireNonNull(bVar, "generator is null");
        return generate(callable, s0.simpleBiGenerator(bVar), Functions.emptyConsumer());
    }

    public static k<Long> interval(long j10, TimeUnit timeUnit) {
        return interval(j10, j10, timeUnit, gf.a.computation());
    }

    public final T blockingFirst(T t10) throws InterruptedException {
        we.d dVar = new we.d();
        subscribe(dVar);
        T tBlockingGet = dVar.blockingGet();
        return tBlockingGet != null ? tBlockingGet : t10;
    }

    public final T blockingLast(T t10) throws InterruptedException {
        we.e eVar = new we.e();
        subscribe(eVar);
        T tBlockingGet = eVar.blockingGet();
        return tBlockingGet != null ? tBlockingGet : t10;
    }

    public final void blockingSubscribe(q<? super T> qVar) {
        ye.i.subscribe(this, qVar);
    }

    public final k<T> concatWith(i<? extends T> iVar) {
        ue.a.requireNonNull(iVar, "other is null");
        return ff.a.onAssembly(new ObservableConcatWithMaybe(this, iVar));
    }

    public final k<T> delay(long j10, TimeUnit timeUnit, r rVar) {
        return delay(j10, timeUnit, rVar, false);
    }

    public final <K, V> k<df.b<K, V>> groupBy(se.n<? super T, ? extends K> nVar, se.n<? super T, ? extends V> nVar2, boolean z10, int i10) {
        ue.a.requireNonNull(nVar, "keySelector is null");
        ue.a.requireNonNull(nVar2, "valueSelector is null");
        ue.a.verifyPositive(i10, "bufferSize");
        return ff.a.onAssembly(new ObservableGroupBy(this, nVar, nVar2, i10, z10));
    }

    public final k<T> mergeWith(i<? extends T> iVar) {
        ue.a.requireNonNull(iVar, "other is null");
        return ff.a.onAssembly(new ObservableMergeWithMaybe(this, iVar));
    }

    public final k<T> retry(long j10, se.o<? super Throwable> oVar) {
        if (j10 >= 0) {
            ue.a.requireNonNull(oVar, "predicate is null");
            return ff.a.onAssembly(new ObservableRetryPredicate(this, j10, oVar));
        }
        throw new IllegalArgumentException(ac.c.h("times >= 0 required but it was ", j10));
    }

    public final qe.b subscribe(se.f<? super T> fVar, se.f<? super Throwable> fVar2, se.a aVar, se.f<? super qe.b> fVar3) {
        ue.a.requireNonNull(fVar, "onNext is null");
        ue.a.requireNonNull(fVar2, "onError is null");
        ue.a.requireNonNull(aVar, "onComplete is null");
        ue.a.requireNonNull(fVar3, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(fVar, fVar2, aVar, fVar3);
        subscribe(lambdaObserver);
        return lambdaObserver;
    }

    public final k<T> timeout(long j10, TimeUnit timeUnit, o<? extends T> oVar) {
        ue.a.requireNonNull(oVar, "other is null");
        return timeout0(j10, timeUnit, oVar, gf.a.computation());
    }

    public final <K, V> s<Map<K, Collection<V>>> toMultimap(se.n<? super T, ? extends K> nVar, se.n<? super T, ? extends V> nVar2) {
        return toMultimap(nVar, nVar2, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    public static <T> k<T> fromFuture(Future<? extends T> future, long j10, TimeUnit timeUnit, r rVar) {
        ue.a.requireNonNull(rVar, "scheduler is null");
        return fromFuture(future, j10, timeUnit).subscribeOn(rVar);
    }

    public static k<Long> interval(long j10, TimeUnit timeUnit, r rVar) {
        return interval(j10, j10, timeUnit, rVar);
    }

    public static <T> k<T> just(T t10, T t11, T t12) {
        ue.a.requireNonNull(t10, "item1 is null");
        ue.a.requireNonNull(t11, "item2 is null");
        ue.a.requireNonNull(t12, "item3 is null");
        return fromArray(t10, t11, t12);
    }

    public static <T> k<T> merge(o<? extends o<? extends T>> oVar, int i10) {
        ue.a.requireNonNull(oVar, "sources is null");
        ue.a.verifyPositive(i10, "maxConcurrency");
        return ff.a.onAssembly(new ObservableFlatMap(oVar, Functions.identity(), false, i10, bufferSize()));
    }

    public static <T> k<T> mergeDelayError(o<? extends o<? extends T>> oVar, int i10) {
        ue.a.requireNonNull(oVar, "sources is null");
        ue.a.verifyPositive(i10, "maxConcurrency");
        return ff.a.onAssembly(new ObservableFlatMap(oVar, Functions.identity(), true, i10, bufferSize()));
    }

    public final k<T> delay(long j10, TimeUnit timeUnit, r rVar, boolean z10) {
        ue.a.requireNonNull(timeUnit, "unit is null");
        ue.a.requireNonNull(rVar, "scheduler is null");
        return ff.a.onAssembly(new ye.s(this, j10, timeUnit, rVar, z10));
    }

    public final k<T> doOnEach(se.f<? super j<T>> fVar) {
        ue.a.requireNonNull(fVar, "onNotification is null");
        return doOnEach(Functions.notificationOnNext(fVar), Functions.notificationOnError(fVar), Functions.notificationOnComplete(fVar), Functions.f13540c);
    }

    public final k<T> sample(long j10, TimeUnit timeUnit, r rVar, boolean z10) {
        ue.a.requireNonNull(timeUnit, "unit is null");
        ue.a.requireNonNull(rVar, "scheduler is null");
        return ff.a.onAssembly(new ObservableSampleTimed(this, j10, timeUnit, rVar, z10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> s<Map<K, V>> toMap(se.n<? super T, ? extends K> nVar, se.n<? super T, ? extends V> nVar2, Callable<? extends Map<K, V>> callable) {
        ue.a.requireNonNull(nVar, "keySelector is null");
        ue.a.requireNonNull(nVar2, "valueSelector is null");
        ue.a.requireNonNull(callable, "mapSupplier is null");
        return (s<Map<K, V>>) collect(callable, Functions.toMapKeyValueSelector(nVar, nVar2));
    }

    public final s<List<T>> toSortedList(int i10) {
        return toSortedList(Functions.naturalOrder(), i10);
    }

    public final <U, R> k<R> zipWith(o<? extends U> oVar, se.c<? super T, ? super U, ? extends R> cVar, boolean z10) {
        return zip(this, oVar, cVar, z10);
    }

    public static <T, R> k<R> combineLatest(o<? extends T>[] oVarArr, se.n<? super Object[], ? extends R> nVar) {
        return combineLatest(oVarArr, nVar, bufferSize());
    }

    public static <T> k<T> concat(o<? extends T> oVar, o<? extends T> oVar2) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        return concatArray(oVar, oVar2);
    }

    public static <T, S> k<T> generate(Callable<S> callable, se.b<S, d<T>> bVar, se.f<? super S> fVar) {
        ue.a.requireNonNull(bVar, "generator is null");
        return generate(callable, s0.simpleBiGenerator(bVar), fVar);
    }

    public final <U extends Collection<? super T>> k<U> buffer(int i10, Callable<U> callable) {
        return buffer(i10, i10, callable);
    }

    public final k<T> concatWith(c cVar) {
        ue.a.requireNonNull(cVar, "other is null");
        return ff.a.onAssembly(new ObservableConcatWithCompletable(this, cVar));
    }

    public final k<T> mergeWith(c cVar) {
        ue.a.requireNonNull(cVar, "other is null");
        return ff.a.onAssembly(new ObservableMergeWithCompletable(this, cVar));
    }

    public final <R> k<R> replay(se.n<? super k<T>, ? extends o<R>> nVar, int i10, long j10, TimeUnit timeUnit) {
        return replay(nVar, i10, j10, timeUnit, gf.a.computation());
    }

    public final k<T> timeout(long j10, TimeUnit timeUnit, r rVar, o<? extends T> oVar) {
        ue.a.requireNonNull(oVar, "other is null");
        return timeout0(j10, timeUnit, oVar, rVar);
    }

    public final k<k<T>> window(long j10, long j11, TimeUnit timeUnit) {
        return window(j10, j11, timeUnit, gf.a.computation(), bufferSize());
    }

    public final <U, R> k<R> zipWith(o<? extends U> oVar, se.c<? super T, ? super U, ? extends R> cVar, boolean z10, int i10) {
        return zip(this, oVar, cVar, z10, i10);
    }

    public static <T, R> k<R> combineLatest(o<? extends T>[] oVarArr, se.n<? super Object[], ? extends R> nVar, int i10) {
        ue.a.requireNonNull(oVarArr, "sources is null");
        if (oVarArr.length == 0) {
            return empty();
        }
        ue.a.requireNonNull(nVar, "combiner is null");
        ue.a.verifyPositive(i10, "bufferSize");
        return ff.a.onAssembly(new ObservableCombineLatest(oVarArr, null, nVar, i10 << 1, false));
    }

    public static <T, R> k<R> combineLatestDelayError(Iterable<? extends o<? extends T>> iterable, se.n<? super Object[], ? extends R> nVar) {
        return combineLatestDelayError(iterable, nVar, bufferSize());
    }

    public static <T> s<Boolean> sequenceEqual(o<? extends T> oVar, o<? extends T> oVar2, int i10) {
        return sequenceEqual(oVar, oVar2, ue.a.equalsPredicate(), i10);
    }

    public final k<List<T>> buffer(long j10, long j11, TimeUnit timeUnit) {
        return (k<List<T>>) buffer(j10, j11, timeUnit, gf.a.computation(), ArrayListSupplier.asCallable());
    }

    public final <R> k<R> replay(se.n<? super k<T>, ? extends o<R>> nVar, int i10, long j10, TimeUnit timeUnit, r rVar) {
        ue.a.requireNonNull(nVar, "selector is null");
        ue.a.verifyPositive(i10, "bufferSize");
        ue.a.requireNonNull(timeUnit, "unit is null");
        ue.a.requireNonNull(rVar, "scheduler is null");
        return ObservableReplay.multicastSelector(s0.replayCallable(this, i10, j10, timeUnit, rVar), nVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> s<Map<K, Collection<V>>> toMultimap(se.n<? super T, ? extends K> nVar, se.n<? super T, ? extends V> nVar2, Callable<? extends Map<K, Collection<V>>> callable, se.n<? super K, ? extends Collection<? super V>> nVar3) {
        ue.a.requireNonNull(nVar, "keySelector is null");
        ue.a.requireNonNull(nVar2, "valueSelector is null");
        ue.a.requireNonNull(callable, "mapSupplier is null");
        ue.a.requireNonNull(nVar3, "collectionFactory is null");
        return (s<Map<K, Collection<V>>>) collect(callable, Functions.toMultimapKeyValueSelector(nVar, nVar2, nVar3));
    }

    public final k<k<T>> window(long j10, long j11, TimeUnit timeUnit, r rVar) {
        return window(j10, j11, timeUnit, rVar, bufferSize());
    }

    public static <T, R> k<R> combineLatestDelayError(Iterable<? extends o<? extends T>> iterable, se.n<? super Object[], ? extends R> nVar, int i10) {
        ue.a.requireNonNull(iterable, "sources is null");
        ue.a.requireNonNull(nVar, "combiner is null");
        ue.a.verifyPositive(i10, "bufferSize");
        return ff.a.onAssembly(new ObservableCombineLatest(null, iterable, nVar, i10 << 1, true));
    }

    public static <T> k<T> fromFuture(Future<? extends T> future, r rVar) {
        ue.a.requireNonNull(rVar, "scheduler is null");
        return fromFuture(future).subscribeOn(rVar);
    }

    public static <T, S> k<T> generate(Callable<S> callable, se.c<S, d<T>, S> cVar) {
        return generate(callable, cVar, Functions.emptyConsumer());
    }

    public static <T> k<T> merge(o<? extends T> oVar, o<? extends T> oVar2) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        return fromArray(oVar, oVar2).flatMap(Functions.identity(), false, 2);
    }

    public static <T> k<T> mergeDelayError(o<? extends T> oVar, o<? extends T> oVar2) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        return fromArray(oVar, oVar2).flatMap(Functions.identity(), true, 2);
    }

    public static <T1, T2, R> k<R> zip(o<? extends T1> oVar, o<? extends T2> oVar2, se.c<? super T1, ? super T2, ? extends R> cVar) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        return zipArray(Functions.toFunction(cVar), false, bufferSize(), oVar, oVar2);
    }

    public final k<List<T>> buffer(long j10, long j11, TimeUnit timeUnit, r rVar) {
        return (k<List<T>>) buffer(j10, j11, timeUnit, rVar, ArrayListSupplier.asCallable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U, V> k<T> delay(o<U> oVar, se.n<? super T, ? extends o<V>> nVar) {
        return delaySubscription(oVar).delay(nVar);
    }

    public final s<T> elementAt(long j10, T t10) {
        if (j10 >= 0) {
            ue.a.requireNonNull(t10, "defaultItem is null");
            return ff.a.onAssembly(new d0(this, j10, t10));
        }
        throw new IndexOutOfBoundsException(ac.c.h("index >= 0 required but it was ", j10));
    }

    public final <U> k<T> sample(o<U> oVar) {
        ue.a.requireNonNull(oVar, "sampler is null");
        return ff.a.onAssembly(new ObservableSampleWithObservable(this, oVar, false));
    }

    public final k<T> take(long j10, TimeUnit timeUnit) {
        return takeUntil(timer(j10, timeUnit));
    }

    public final k<T> timeout(long j10, TimeUnit timeUnit, r rVar) {
        return timeout0(j10, timeUnit, null, rVar);
    }

    public final k<k<T>> window(long j10, long j11, TimeUnit timeUnit, r rVar, int i10) {
        ue.a.verifyPositive(j10, "timespan");
        ue.a.verifyPositive(j11, "timeskip");
        ue.a.verifyPositive(i10, "bufferSize");
        ue.a.requireNonNull(rVar, "scheduler is null");
        ue.a.requireNonNull(timeUnit, "unit is null");
        return ff.a.onAssembly(new x1(this, j10, j11, timeUnit, rVar, Long.MAX_VALUE, i10, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, T3, R> k<R> withLatestFrom(o<T1> oVar, o<T2> oVar2, o<T3> oVar3, se.h<? super T, ? super T1, ? super T2, ? super T3, R> hVar) {
        ue.a.requireNonNull(oVar, "o1 is null");
        ue.a.requireNonNull(oVar2, "o2 is null");
        ue.a.requireNonNull(oVar3, "o3 is null");
        ue.a.requireNonNull(hVar, "combiner is null");
        return withLatestFrom((o<?>[]) new o[]{oVar, oVar2, oVar3}, Functions.toFunction(hVar));
    }

    public static <T> k<T> concat(o<? extends T> oVar, o<? extends T> oVar2, o<? extends T> oVar3) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        ue.a.requireNonNull(oVar3, "source3 is null");
        return concatArray(oVar, oVar2, oVar3);
    }

    public static <T, S> k<T> generate(Callable<S> callable, se.c<S, d<T>, S> cVar, se.f<? super S> fVar) {
        ue.a.requireNonNull(callable, "initialState is null");
        ue.a.requireNonNull(cVar, "generator is null");
        ue.a.requireNonNull(fVar, "disposeState is null");
        return ff.a.onAssembly(new o0(callable, cVar, fVar));
    }

    public static <T> k<T> just(T t10, T t11, T t12, T t13) {
        ue.a.requireNonNull(t10, "item1 is null");
        ue.a.requireNonNull(t11, "item2 is null");
        ue.a.requireNonNull(t12, "item3 is null");
        ue.a.requireNonNull(t13, "item4 is null");
        return fromArray(t10, t11, t12, t13);
    }

    public final <U extends Collection<? super T>> k<U> buffer(long j10, long j11, TimeUnit timeUnit, r rVar, Callable<U> callable) {
        ue.a.requireNonNull(timeUnit, "unit is null");
        ue.a.requireNonNull(rVar, "scheduler is null");
        ue.a.requireNonNull(callable, "bufferSupplier is null");
        return ff.a.onAssembly(new ye.l(this, j10, j11, timeUnit, rVar, callable, Integer.MAX_VALUE, false));
    }

    public final k<T> skipLast(long j10, TimeUnit timeUnit) {
        return skipLast(j10, timeUnit, gf.a.trampoline(), false, bufferSize());
    }

    public final k<T> take(long j10, TimeUnit timeUnit, r rVar) {
        return takeUntil(timer(j10, timeUnit, rVar));
    }

    public final <U, V> k<T> timeout(o<U> oVar, se.n<? super T, ? extends o<V>> nVar) {
        ue.a.requireNonNull(oVar, "firstTimeoutIndicator is null");
        return timeout0(oVar, nVar, null);
    }

    public final k<T> doOnEach(q<? super T> qVar) {
        ue.a.requireNonNull(qVar, "observer is null");
        return doOnEach(s0.observerOnNext(qVar), s0.observerOnError(qVar), s0.observerOnComplete(qVar), Functions.f13540c);
    }

    public final <U> k<T> sample(o<U> oVar, boolean z10) {
        ue.a.requireNonNull(oVar, "sampler is null");
        return ff.a.onAssembly(new ObservableSampleWithObservable(this, oVar, z10));
    }

    public final k<T> skipLast(long j10, TimeUnit timeUnit, boolean z10) {
        return skipLast(j10, timeUnit, gf.a.trampoline(), z10, bufferSize());
    }

    @Override // ne.o
    public final void subscribe(q<? super T> qVar) {
        ue.a.requireNonNull(qVar, "observer is null");
        try {
            q<? super T> qVarOnSubscribe = ff.a.onSubscribe(this, qVar);
            ue.a.requireNonNull(qVarOnSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            subscribeActual(qVarOnSubscribe);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            ff.a.onError(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    public final k<T> takeLast(long j10, long j11, TimeUnit timeUnit) {
        return takeLast(j10, j11, timeUnit, gf.a.trampoline(), false, bufferSize());
    }

    public static <T> k<T> merge(o<? extends T> oVar, o<? extends T> oVar2, o<? extends T> oVar3) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        ue.a.requireNonNull(oVar3, "source3 is null");
        return fromArray(oVar, oVar2, oVar3).flatMap(Functions.identity(), false, 3);
    }

    public static <T> k<T> mergeDelayError(o<? extends T> oVar, o<? extends T> oVar2, o<? extends T> oVar3) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        ue.a.requireNonNull(oVar3, "source3 is null");
        return fromArray(oVar, oVar2, oVar3).flatMap(Functions.identity(), true, 3);
    }

    public static <T1, T2, R> k<R> zip(o<? extends T1> oVar, o<? extends T2> oVar2, se.c<? super T1, ? super T2, ? extends R> cVar, boolean z10) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        return zipArray(Functions.toFunction(cVar), z10, bufferSize(), oVar, oVar2);
    }

    public final <R> k<R> flatMap(se.n<? super T, ? extends o<? extends R>> nVar, se.n<? super Throwable, ? extends o<? extends R>> nVar2, Callable<? extends o<? extends R>> callable) {
        ue.a.requireNonNull(nVar, "onNextMapper is null");
        ue.a.requireNonNull(nVar2, "onErrorMapper is null");
        ue.a.requireNonNull(callable, "onCompleteSupplier is null");
        return merge(new x0(this, nVar, nVar2, callable));
    }

    public final k<T> skipLast(long j10, TimeUnit timeUnit, r rVar) {
        return skipLast(j10, timeUnit, rVar, false, bufferSize());
    }

    public final k<T> takeLast(long j10, long j11, TimeUnit timeUnit, r rVar) {
        return takeLast(j10, j11, timeUnit, rVar, false, bufferSize());
    }

    public final <U, V> k<T> timeout(o<U> oVar, se.n<? super T, ? extends o<V>> nVar, o<? extends T> oVar2) {
        ue.a.requireNonNull(oVar, "firstTimeoutIndicator is null");
        ue.a.requireNonNull(oVar2, "other is null");
        return timeout0(oVar, nVar, oVar2);
    }

    public final k<T> skipLast(long j10, TimeUnit timeUnit, r rVar, boolean z10) {
        return skipLast(j10, timeUnit, rVar, z10, bufferSize());
    }

    public final k<T> takeLast(long j10, long j11, TimeUnit timeUnit, r rVar, boolean z10, int i10) {
        ue.a.requireNonNull(timeUnit, "unit is null");
        ue.a.requireNonNull(rVar, "scheduler is null");
        ue.a.verifyPositive(i10, "bufferSize");
        if (j10 >= 0) {
            return ff.a.onAssembly(new ObservableTakeLastTimed(this, j10, j11, timeUnit, rVar, i10, z10));
        }
        throw new IndexOutOfBoundsException(ac.c.h("count >= 0 required but it was ", j10));
    }

    public final <K, V> s<Map<K, Collection<V>>> toMultimap(se.n<? super T, ? extends K> nVar, se.n<? super T, ? extends V> nVar2, Callable<Map<K, Collection<V>>> callable) {
        return toMultimap(nVar, nVar2, callable, ArrayListSupplier.asFunction());
    }

    public static <T1, T2, R> k<R> combineLatest(o<? extends T1> oVar, o<? extends T2> oVar2, se.c<? super T1, ? super T2, ? extends R> cVar) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        return combineLatest(Functions.toFunction(cVar), bufferSize(), oVar, oVar2);
    }

    public static <T> k<T> concat(o<? extends T> oVar, o<? extends T> oVar2, o<? extends T> oVar3, o<? extends T> oVar4) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        ue.a.requireNonNull(oVar3, "source3 is null");
        ue.a.requireNonNull(oVar4, "source4 is null");
        return concatArray(oVar, oVar2, oVar3, oVar4);
    }

    public final k<List<T>> buffer(long j10, TimeUnit timeUnit) {
        return buffer(j10, timeUnit, gf.a.computation(), Integer.MAX_VALUE);
    }

    public final <R> k<R> replay(se.n<? super k<T>, ? extends o<R>> nVar, int i10, r rVar) {
        ue.a.requireNonNull(nVar, "selector is null");
        ue.a.requireNonNull(rVar, "scheduler is null");
        ue.a.verifyPositive(i10, "bufferSize");
        return ObservableReplay.multicastSelector(s0.replayCallable(this, i10), s0.replayFunction(nVar, rVar));
    }

    public final k<T> retry(se.o<? super Throwable> oVar) {
        return retry(Long.MAX_VALUE, oVar);
    }

    public final k<T> skipLast(long j10, TimeUnit timeUnit, r rVar, boolean z10, int i10) {
        ue.a.requireNonNull(timeUnit, "unit is null");
        ue.a.requireNonNull(rVar, "scheduler is null");
        ue.a.verifyPositive(i10, "bufferSize");
        return ff.a.onAssembly(new ObservableSkipLastTimed(this, j10, timeUnit, rVar, i10 << 1, z10));
    }

    public static <T> k<T> just(T t10, T t11, T t12, T t13, T t14) {
        ue.a.requireNonNull(t10, "item1 is null");
        ue.a.requireNonNull(t11, "item2 is null");
        ue.a.requireNonNull(t12, "item3 is null");
        ue.a.requireNonNull(t13, "item4 is null");
        ue.a.requireNonNull(t14, "item5 is null");
        return fromArray(t10, t11, t12, t13, t14);
    }

    public static <T1, T2, R> k<R> zip(o<? extends T1> oVar, o<? extends T2> oVar2, se.c<? super T1, ? super T2, ? extends R> cVar, boolean z10, int i10) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        return zipArray(Functions.toFunction(cVar), z10, i10, oVar, oVar2);
    }

    public final k<List<T>> buffer(long j10, TimeUnit timeUnit, int i10) {
        return buffer(j10, timeUnit, gf.a.computation(), i10);
    }

    public final k<k<T>> window(long j10, TimeUnit timeUnit) {
        return window(j10, timeUnit, gf.a.computation(), Long.MAX_VALUE, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, T3, T4, R> k<R> withLatestFrom(o<T1> oVar, o<T2> oVar2, o<T3> oVar3, o<T4> oVar4, se.i<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> iVar) {
        ue.a.requireNonNull(oVar, "o1 is null");
        ue.a.requireNonNull(oVar2, "o2 is null");
        ue.a.requireNonNull(oVar3, "o3 is null");
        ue.a.requireNonNull(oVar4, "o4 is null");
        ue.a.requireNonNull(iVar, "combiner is null");
        return withLatestFrom((o<?>[]) new o[]{oVar, oVar2, oVar3, oVar4}, Functions.toFunction(iVar));
    }

    public static <T> k<T> merge(o<? extends T> oVar, o<? extends T> oVar2, o<? extends T> oVar3, o<? extends T> oVar4) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        ue.a.requireNonNull(oVar3, "source3 is null");
        ue.a.requireNonNull(oVar4, "source4 is null");
        return fromArray(oVar, oVar2, oVar3, oVar4).flatMap(Functions.identity(), false, 4);
    }

    public static <T> k<T> mergeDelayError(o<? extends T> oVar, o<? extends T> oVar2, o<? extends T> oVar3, o<? extends T> oVar4) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        ue.a.requireNonNull(oVar3, "source3 is null");
        ue.a.requireNonNull(oVar4, "source4 is null");
        return fromArray(oVar, oVar2, oVar3, oVar4).flatMap(Functions.identity(), true, 4);
    }

    public final k<List<T>> buffer(long j10, TimeUnit timeUnit, r rVar, int i10) {
        return (k<List<T>>) buffer(j10, timeUnit, rVar, i10, ArrayListSupplier.asCallable(), false);
    }

    public final <R> k<R> flatMap(se.n<? super T, ? extends o<? extends R>> nVar, se.n<Throwable, ? extends o<? extends R>> nVar2, Callable<? extends o<? extends R>> callable, int i10) {
        ue.a.requireNonNull(nVar, "onNextMapper is null");
        ue.a.requireNonNull(nVar2, "onErrorMapper is null");
        ue.a.requireNonNull(callable, "onCompleteSupplier is null");
        return merge(new x0(this, nVar, nVar2, callable), i10);
    }

    public final k<k<T>> window(long j10, TimeUnit timeUnit, long j11) {
        return window(j10, timeUnit, gf.a.computation(), j11, false);
    }

    public static <T1, T2, T3, R> k<R> combineLatest(o<? extends T1> oVar, o<? extends T2> oVar2, o<? extends T3> oVar3, se.g<? super T1, ? super T2, ? super T3, ? extends R> gVar) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        ue.a.requireNonNull(oVar3, "source3 is null");
        return combineLatest(Functions.toFunction(gVar), bufferSize(), oVar, oVar2, oVar3);
    }

    public final <U extends Collection<? super T>> k<U> buffer(long j10, TimeUnit timeUnit, r rVar, int i10, Callable<U> callable, boolean z10) {
        ue.a.requireNonNull(timeUnit, "unit is null");
        ue.a.requireNonNull(rVar, "scheduler is null");
        ue.a.requireNonNull(callable, "bufferSupplier is null");
        ue.a.verifyPositive(i10, "count");
        return ff.a.onAssembly(new ye.l(this, j10, j10, timeUnit, rVar, callable, i10, z10));
    }

    public final k<k<T>> window(long j10, TimeUnit timeUnit, long j11, boolean z10) {
        return window(j10, timeUnit, gf.a.computation(), j11, z10);
    }

    public static <T1, T2, T3, R> k<R> zip(o<? extends T1> oVar, o<? extends T2> oVar2, o<? extends T3> oVar3, se.g<? super T1, ? super T2, ? super T3, ? extends R> gVar) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        ue.a.requireNonNull(oVar3, "source3 is null");
        return zipArray(Functions.toFunction(gVar), false, bufferSize(), oVar, oVar2, oVar3);
    }

    public final k<k<T>> window(long j10, TimeUnit timeUnit, r rVar) {
        return window(j10, timeUnit, rVar, Long.MAX_VALUE, false);
    }

    public final k<k<T>> window(long j10, TimeUnit timeUnit, r rVar, long j11) {
        return window(j10, timeUnit, rVar, j11, false);
    }

    public final <R> k<R> flatMap(se.n<? super T, ? extends o<? extends R>> nVar, int i10) {
        return flatMap((se.n) nVar, false, i10, bufferSize());
    }

    public final <R> k<R> replay(se.n<? super k<T>, ? extends o<R>> nVar, long j10, TimeUnit timeUnit) {
        return replay(nVar, j10, timeUnit, gf.a.computation());
    }

    public final k<k<T>> window(long j10, TimeUnit timeUnit, r rVar, long j11, boolean z10) {
        return window(j10, timeUnit, rVar, j11, z10, bufferSize());
    }

    public static <T1, T2, T3, T4, R> k<R> combineLatest(o<? extends T1> oVar, o<? extends T2> oVar2, o<? extends T3> oVar3, o<? extends T4> oVar4, se.h<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> hVar) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        ue.a.requireNonNull(oVar3, "source3 is null");
        ue.a.requireNonNull(oVar4, "source4 is null");
        return combineLatest(Functions.toFunction(hVar), bufferSize(), oVar, oVar2, oVar3, oVar4);
    }

    public static <T> k<T> just(T t10, T t11, T t12, T t13, T t14, T t15) {
        ue.a.requireNonNull(t10, "item1 is null");
        ue.a.requireNonNull(t11, "item2 is null");
        ue.a.requireNonNull(t12, "item3 is null");
        ue.a.requireNonNull(t13, "item4 is null");
        ue.a.requireNonNull(t14, "item5 is null");
        ue.a.requireNonNull(t15, "item6 is null");
        return fromArray(t10, t11, t12, t13, t14, t15);
    }

    public final <U, R> k<R> flatMap(se.n<? super T, ? extends o<? extends U>> nVar, se.c<? super T, ? super U, ? extends R> cVar) {
        return flatMap(nVar, cVar, false, bufferSize(), bufferSize());
    }

    public final <R> k<R> replay(se.n<? super k<T>, ? extends o<R>> nVar, long j10, TimeUnit timeUnit, r rVar) {
        ue.a.requireNonNull(nVar, "selector is null");
        ue.a.requireNonNull(timeUnit, "unit is null");
        ue.a.requireNonNull(rVar, "scheduler is null");
        return ObservableReplay.multicastSelector(s0.replayCallable(this, j10, timeUnit, rVar), nVar);
    }

    public final k<k<T>> window(long j10, TimeUnit timeUnit, r rVar, long j11, boolean z10, int i10) {
        ue.a.verifyPositive(i10, "bufferSize");
        ue.a.requireNonNull(rVar, "scheduler is null");
        ue.a.requireNonNull(timeUnit, "unit is null");
        ue.a.verifyPositive(j11, "count");
        return ff.a.onAssembly(new x1(this, j10, j10, timeUnit, rVar, j11, i10, z10));
    }

    public static <T1, T2, T3, T4, R> k<R> zip(o<? extends T1> oVar, o<? extends T2> oVar2, o<? extends T3> oVar3, o<? extends T4> oVar4, se.h<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> hVar) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        ue.a.requireNonNull(oVar3, "source3 is null");
        ue.a.requireNonNull(oVar4, "source4 is null");
        return zipArray(Functions.toFunction(hVar), false, bufferSize(), oVar, oVar2, oVar3, oVar4);
    }

    public final k<List<T>> buffer(long j10, TimeUnit timeUnit, r rVar) {
        return (k<List<T>>) buffer(j10, timeUnit, rVar, Integer.MAX_VALUE, ArrayListSupplier.asCallable(), false);
    }

    public final <U, R> k<R> flatMap(se.n<? super T, ? extends o<? extends U>> nVar, se.c<? super T, ? super U, ? extends R> cVar, boolean z10) {
        return flatMap(nVar, cVar, z10, bufferSize(), bufferSize());
    }

    public final <R> k<R> withLatestFrom(o<?>[] oVarArr, se.n<? super Object[], R> nVar) {
        ue.a.requireNonNull(oVarArr, "others is null");
        ue.a.requireNonNull(nVar, "combiner is null");
        return ff.a.onAssembly(new ObservableWithLatestFromMany(this, oVarArr, nVar));
    }

    public final <TOpening, TClosing> k<List<T>> buffer(o<? extends TOpening> oVar, se.n<? super TOpening, ? extends o<? extends TClosing>> nVar) {
        return (k<List<T>>) buffer(oVar, nVar, ArrayListSupplier.asCallable());
    }

    public final <U, R> k<R> flatMap(se.n<? super T, ? extends o<? extends U>> nVar, se.c<? super T, ? super U, ? extends R> cVar, boolean z10, int i10) {
        return flatMap(nVar, cVar, z10, i10, bufferSize());
    }

    public final <TOpening, TClosing, U extends Collection<? super T>> k<U> buffer(o<? extends TOpening> oVar, se.n<? super TOpening, ? extends o<? extends TClosing>> nVar, Callable<U> callable) {
        ue.a.requireNonNull(oVar, "openingIndicator is null");
        ue.a.requireNonNull(nVar, "closingIndicator is null");
        ue.a.requireNonNull(callable, "bufferSupplier is null");
        return ff.a.onAssembly(new ObservableBufferBoundary(this, oVar, nVar, callable));
    }

    public final <U, R> k<R> flatMap(se.n<? super T, ? extends o<? extends U>> nVar, se.c<? super T, ? super U, ? extends R> cVar, boolean z10, int i10, int i11) {
        ue.a.requireNonNull(nVar, "mapper is null");
        ue.a.requireNonNull(cVar, "combiner is null");
        return flatMap(s0.flatMapWithCombiner(nVar, cVar), z10, i10, i11);
    }

    public final k<T> takeLast(long j10, TimeUnit timeUnit) {
        return takeLast(j10, timeUnit, gf.a.trampoline(), false, bufferSize());
    }

    public final <R> k<R> replay(se.n<? super k<T>, ? extends o<R>> nVar, r rVar) {
        ue.a.requireNonNull(nVar, "selector is null");
        ue.a.requireNonNull(rVar, "scheduler is null");
        return ObservableReplay.multicastSelector(s0.replayCallable(this), s0.replayFunction(nVar, rVar));
    }

    public final k<T> takeLast(long j10, TimeUnit timeUnit, boolean z10) {
        return takeLast(j10, timeUnit, gf.a.trampoline(), z10, bufferSize());
    }

    public final <R> k<R> withLatestFrom(Iterable<? extends o<?>> iterable, se.n<? super Object[], R> nVar) {
        ue.a.requireNonNull(iterable, "others is null");
        ue.a.requireNonNull(nVar, "combiner is null");
        return ff.a.onAssembly(new ObservableWithLatestFromMany(this, iterable, nVar));
    }

    public static <T1, T2, T3, T4, T5, R> k<R> combineLatest(o<? extends T1> oVar, o<? extends T2> oVar2, o<? extends T3> oVar3, o<? extends T4> oVar4, o<? extends T5> oVar5, se.i<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> iVar) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        ue.a.requireNonNull(oVar3, "source3 is null");
        ue.a.requireNonNull(oVar4, "source4 is null");
        ue.a.requireNonNull(oVar5, "source5 is null");
        return combineLatest(Functions.toFunction(iVar), bufferSize(), oVar, oVar2, oVar3, oVar4, oVar5);
    }

    public final k<T> takeLast(long j10, TimeUnit timeUnit, r rVar) {
        return takeLast(j10, timeUnit, rVar, false, bufferSize());
    }

    public final <B> k<k<T>> window(o<B> oVar) {
        return window(oVar, bufferSize());
    }

    public static <T1, T2, T3, T4, T5, R> k<R> zip(o<? extends T1> oVar, o<? extends T2> oVar2, o<? extends T3> oVar3, o<? extends T4> oVar4, o<? extends T5> oVar5, se.i<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> iVar) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        ue.a.requireNonNull(oVar3, "source3 is null");
        ue.a.requireNonNull(oVar4, "source4 is null");
        ue.a.requireNonNull(oVar5, "source5 is null");
        return zipArray(Functions.toFunction(iVar), false, bufferSize(), oVar, oVar2, oVar3, oVar4, oVar5);
    }

    public final <U, R> k<R> flatMap(se.n<? super T, ? extends o<? extends U>> nVar, se.c<? super T, ? super U, ? extends R> cVar, int i10) {
        return flatMap(nVar, cVar, false, i10, bufferSize());
    }

    public final k<T> takeLast(long j10, TimeUnit timeUnit, r rVar, boolean z10) {
        return takeLast(j10, timeUnit, rVar, z10, bufferSize());
    }

    public final <B> k<k<T>> window(o<B> oVar, int i10) {
        ue.a.requireNonNull(oVar, "boundary is null");
        ue.a.verifyPositive(i10, "bufferSize");
        return ff.a.onAssembly(new ObservableWindowBoundary(this, oVar, i10));
    }

    public static <T> k<T> just(T t10, T t11, T t12, T t13, T t14, T t15, T t16) {
        ue.a.requireNonNull(t10, "item1 is null");
        ue.a.requireNonNull(t11, "item2 is null");
        ue.a.requireNonNull(t12, "item3 is null");
        ue.a.requireNonNull(t13, "item4 is null");
        ue.a.requireNonNull(t14, "item5 is null");
        ue.a.requireNonNull(t15, "item6 is null");
        ue.a.requireNonNull(t16, "item7 is null");
        return fromArray(t10, t11, t12, t13, t14, t15, t16);
    }

    public final <B> k<List<T>> buffer(o<B> oVar) {
        return (k<List<T>>) buffer(oVar, ArrayListSupplier.asCallable());
    }

    public final k<T> takeLast(long j10, TimeUnit timeUnit, r rVar, boolean z10, int i10) {
        return takeLast(Long.MAX_VALUE, j10, timeUnit, rVar, z10, i10);
    }

    public final <B> k<List<T>> buffer(o<B> oVar, int i10) {
        ue.a.verifyPositive(i10, "initialCapacity");
        return (k<List<T>>) buffer(oVar, Functions.createArrayList(i10));
    }

    public final df.a<T> replay(int i10) {
        ue.a.verifyPositive(i10, "bufferSize");
        return ObservableReplay.create(this, i10);
    }

    public final <U, V> k<k<T>> window(o<U> oVar, se.n<? super U, ? extends o<V>> nVar) {
        return window(oVar, nVar, bufferSize());
    }

    public final <B, U extends Collection<? super T>> k<U> buffer(o<B> oVar, Callable<U> callable) {
        ue.a.requireNonNull(oVar, "boundary is null");
        ue.a.requireNonNull(callable, "bufferSupplier is null");
        return ff.a.onAssembly(new ye.k(this, oVar, callable));
    }

    public final <U, V> k<k<T>> window(o<U> oVar, se.n<? super U, ? extends o<V>> nVar, int i10) {
        ue.a.requireNonNull(oVar, "openingIndicator is null");
        ue.a.requireNonNull(nVar, "closingIndicator is null");
        ue.a.verifyPositive(i10, "bufferSize");
        return ff.a.onAssembly(new w1(this, oVar, nVar, i10));
    }

    public static <T1, T2, T3, T4, T5, T6, R> k<R> combineLatest(o<? extends T1> oVar, o<? extends T2> oVar2, o<? extends T3> oVar3, o<? extends T4> oVar4, o<? extends T5> oVar5, o<? extends T6> oVar6, se.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> jVar) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        ue.a.requireNonNull(oVar3, "source3 is null");
        ue.a.requireNonNull(oVar4, "source4 is null");
        ue.a.requireNonNull(oVar5, "source5 is null");
        ue.a.requireNonNull(oVar6, "source6 is null");
        return combineLatest(Functions.toFunction(jVar), bufferSize(), oVar, oVar2, oVar3, oVar4, oVar5, oVar6);
    }

    public final df.a<T> replay(int i10, long j10, TimeUnit timeUnit) {
        return replay(i10, j10, timeUnit, gf.a.computation());
    }

    public static <T1, T2, T3, T4, T5, T6, R> k<R> zip(o<? extends T1> oVar, o<? extends T2> oVar2, o<? extends T3> oVar3, o<? extends T4> oVar4, o<? extends T5> oVar5, o<? extends T6> oVar6, se.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> jVar) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        ue.a.requireNonNull(oVar3, "source3 is null");
        ue.a.requireNonNull(oVar4, "source4 is null");
        ue.a.requireNonNull(oVar5, "source5 is null");
        ue.a.requireNonNull(oVar6, "source6 is null");
        return zipArray(Functions.toFunction(jVar), false, bufferSize(), oVar, oVar2, oVar3, oVar4, oVar5, oVar6);
    }

    public final df.a<T> replay(int i10, long j10, TimeUnit timeUnit, r rVar) {
        ue.a.verifyPositive(i10, "bufferSize");
        ue.a.requireNonNull(timeUnit, "unit is null");
        ue.a.requireNonNull(rVar, "scheduler is null");
        return ObservableReplay.create(this, j10, timeUnit, rVar, i10);
    }

    public final <B> k<List<T>> buffer(Callable<? extends o<B>> callable) {
        return (k<List<T>>) buffer(callable, ArrayListSupplier.asCallable());
    }

    public final <B, U extends Collection<? super T>> k<U> buffer(Callable<? extends o<B>> callable, Callable<U> callable2) {
        ue.a.requireNonNull(callable, "boundarySupplier is null");
        ue.a.requireNonNull(callable2, "bufferSupplier is null");
        return ff.a.onAssembly(new ye.j(this, callable, callable2));
    }

    public final <B> k<k<T>> window(Callable<? extends o<B>> callable) {
        return window(callable, bufferSize());
    }

    public static <T> k<T> just(T t10, T t11, T t12, T t13, T t14, T t15, T t16, T t17) {
        ue.a.requireNonNull(t10, "item1 is null");
        ue.a.requireNonNull(t11, "item2 is null");
        ue.a.requireNonNull(t12, "item3 is null");
        ue.a.requireNonNull(t13, "item4 is null");
        ue.a.requireNonNull(t14, "item5 is null");
        ue.a.requireNonNull(t15, "item6 is null");
        ue.a.requireNonNull(t16, "item7 is null");
        ue.a.requireNonNull(t17, "item8 is null");
        return fromArray(t10, t11, t12, t13, t14, t15, t16, t17);
    }

    public final <B> k<k<T>> window(Callable<? extends o<B>> callable, int i10) {
        ue.a.requireNonNull(callable, "boundary is null");
        ue.a.verifyPositive(i10, "bufferSize");
        return ff.a.onAssembly(new ObservableWindowBoundarySupplier(this, callable, i10));
    }

    public final df.a<T> replay(int i10, r rVar) {
        ue.a.verifyPositive(i10, "bufferSize");
        return ObservableReplay.observeOn(replay(i10), rVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> k<R> combineLatest(o<? extends T1> oVar, o<? extends T2> oVar2, o<? extends T3> oVar3, o<? extends T4> oVar4, o<? extends T5> oVar5, o<? extends T6> oVar6, o<? extends T7> oVar7, se.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> kVar) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        ue.a.requireNonNull(oVar3, "source3 is null");
        ue.a.requireNonNull(oVar4, "source4 is null");
        ue.a.requireNonNull(oVar5, "source5 is null");
        ue.a.requireNonNull(oVar6, "source6 is null");
        ue.a.requireNonNull(oVar7, "source7 is null");
        return combineLatest(Functions.toFunction(kVar), bufferSize(), oVar, oVar2, oVar3, oVar4, oVar5, oVar6, oVar7);
    }

    public final df.a<T> replay(long j10, TimeUnit timeUnit) {
        return replay(j10, timeUnit, gf.a.computation());
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> k<R> zip(o<? extends T1> oVar, o<? extends T2> oVar2, o<? extends T3> oVar3, o<? extends T4> oVar4, o<? extends T5> oVar5, o<? extends T6> oVar6, o<? extends T7> oVar7, se.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> kVar) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        ue.a.requireNonNull(oVar3, "source3 is null");
        ue.a.requireNonNull(oVar4, "source4 is null");
        ue.a.requireNonNull(oVar5, "source5 is null");
        ue.a.requireNonNull(oVar6, "source6 is null");
        ue.a.requireNonNull(oVar7, "source7 is null");
        return zipArray(Functions.toFunction(kVar), false, bufferSize(), oVar, oVar2, oVar3, oVar4, oVar5, oVar6, oVar7);
    }

    public final df.a<T> replay(long j10, TimeUnit timeUnit, r rVar) {
        ue.a.requireNonNull(timeUnit, "unit is null");
        ue.a.requireNonNull(rVar, "scheduler is null");
        return ObservableReplay.create(this, j10, timeUnit, rVar);
    }

    public final df.a<T> replay(r rVar) {
        ue.a.requireNonNull(rVar, "scheduler is null");
        return ObservableReplay.observeOn(replay(), rVar);
    }

    public static <T> k<T> just(T t10, T t11, T t12, T t13, T t14, T t15, T t16, T t17, T t18) {
        ue.a.requireNonNull(t10, "item1 is null");
        ue.a.requireNonNull(t11, "item2 is null");
        ue.a.requireNonNull(t12, "item3 is null");
        ue.a.requireNonNull(t13, "item4 is null");
        ue.a.requireNonNull(t14, "item5 is null");
        ue.a.requireNonNull(t15, "item6 is null");
        ue.a.requireNonNull(t16, "item7 is null");
        ue.a.requireNonNull(t17, "item8 is null");
        ue.a.requireNonNull(t18, "item9 is null");
        return fromArray(t10, t11, t12, t13, t14, t15, t16, t17, t18);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> k<R> combineLatest(o<? extends T1> oVar, o<? extends T2> oVar2, o<? extends T3> oVar3, o<? extends T4> oVar4, o<? extends T5> oVar5, o<? extends T6> oVar6, o<? extends T7> oVar7, o<? extends T8> oVar8, se.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> lVar) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        ue.a.requireNonNull(oVar3, "source3 is null");
        ue.a.requireNonNull(oVar4, "source4 is null");
        ue.a.requireNonNull(oVar5, "source5 is null");
        ue.a.requireNonNull(oVar6, "source6 is null");
        ue.a.requireNonNull(oVar7, "source7 is null");
        ue.a.requireNonNull(oVar8, "source8 is null");
        return combineLatest(Functions.toFunction(lVar), bufferSize(), oVar, oVar2, oVar3, oVar4, oVar5, oVar6, oVar7, oVar8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> k<R> zip(o<? extends T1> oVar, o<? extends T2> oVar2, o<? extends T3> oVar3, o<? extends T4> oVar4, o<? extends T5> oVar5, o<? extends T6> oVar6, o<? extends T7> oVar7, o<? extends T8> oVar8, se.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> lVar) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        ue.a.requireNonNull(oVar3, "source3 is null");
        ue.a.requireNonNull(oVar4, "source4 is null");
        ue.a.requireNonNull(oVar5, "source5 is null");
        ue.a.requireNonNull(oVar6, "source6 is null");
        ue.a.requireNonNull(oVar7, "source7 is null");
        ue.a.requireNonNull(oVar8, "source8 is null");
        return zipArray(Functions.toFunction(lVar), false, bufferSize(), oVar, oVar2, oVar3, oVar4, oVar5, oVar6, oVar7, oVar8);
    }

    public static <T> k<T> just(T t10, T t11, T t12, T t13, T t14, T t15, T t16, T t17, T t18, T t19) {
        ue.a.requireNonNull(t10, "item1 is null");
        ue.a.requireNonNull(t11, "item2 is null");
        ue.a.requireNonNull(t12, "item3 is null");
        ue.a.requireNonNull(t13, "item4 is null");
        ue.a.requireNonNull(t14, "item5 is null");
        ue.a.requireNonNull(t15, "item6 is null");
        ue.a.requireNonNull(t16, "item7 is null");
        ue.a.requireNonNull(t17, "item8 is null");
        ue.a.requireNonNull(t18, "item9 is null");
        ue.a.requireNonNull(t19, "item10 is null");
        return fromArray(t10, t11, t12, t13, t14, t15, t16, t17, t18, t19);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> k<R> combineLatest(o<? extends T1> oVar, o<? extends T2> oVar2, o<? extends T3> oVar3, o<? extends T4> oVar4, o<? extends T5> oVar5, o<? extends T6> oVar6, o<? extends T7> oVar7, o<? extends T8> oVar8, o<? extends T9> oVar9, se.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> mVar) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        ue.a.requireNonNull(oVar3, "source3 is null");
        ue.a.requireNonNull(oVar4, "source4 is null");
        ue.a.requireNonNull(oVar5, "source5 is null");
        ue.a.requireNonNull(oVar6, "source6 is null");
        ue.a.requireNonNull(oVar7, "source7 is null");
        ue.a.requireNonNull(oVar8, "source8 is null");
        ue.a.requireNonNull(oVar9, "source9 is null");
        return combineLatest(Functions.toFunction(mVar), bufferSize(), oVar, oVar2, oVar3, oVar4, oVar5, oVar6, oVar7, oVar8, oVar9);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> k<R> zip(o<? extends T1> oVar, o<? extends T2> oVar2, o<? extends T3> oVar3, o<? extends T4> oVar4, o<? extends T5> oVar5, o<? extends T6> oVar6, o<? extends T7> oVar7, o<? extends T8> oVar8, o<? extends T9> oVar9, se.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> mVar) {
        ue.a.requireNonNull(oVar, "source1 is null");
        ue.a.requireNonNull(oVar2, "source2 is null");
        ue.a.requireNonNull(oVar3, "source3 is null");
        ue.a.requireNonNull(oVar4, "source4 is null");
        ue.a.requireNonNull(oVar5, "source5 is null");
        ue.a.requireNonNull(oVar6, "source6 is null");
        ue.a.requireNonNull(oVar7, "source7 is null");
        ue.a.requireNonNull(oVar8, "source8 is null");
        ue.a.requireNonNull(oVar9, "source9 is null");
        return zipArray(Functions.toFunction(mVar), false, bufferSize(), oVar, oVar2, oVar3, oVar4, oVar5, oVar6, oVar7, oVar8, oVar9);
    }
}
