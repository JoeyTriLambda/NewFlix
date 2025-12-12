package ye;

import io.reactivex.internal.functions.Functions;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: ObservableInternalHelper.java */
/* loaded from: classes2.dex */
public final class s0 {

    /* compiled from: ObservableInternalHelper.java */
    public static final class a<T> implements Callable<df.a<T>> {

        /* renamed from: b, reason: collision with root package name */
        public final ne.k<T> f22365b;

        /* renamed from: m, reason: collision with root package name */
        public final int f22366m;

        public a(ne.k<T> kVar, int i10) {
            this.f22365b = kVar;
            this.f22366m = i10;
        }

        @Override // java.util.concurrent.Callable
        public df.a<T> call() {
            return this.f22365b.replay(this.f22366m);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    public static final class b<T> implements Callable<df.a<T>> {

        /* renamed from: b, reason: collision with root package name */
        public final ne.k<T> f22367b;

        /* renamed from: m, reason: collision with root package name */
        public final int f22368m;

        /* renamed from: n, reason: collision with root package name */
        public final long f22369n;

        /* renamed from: o, reason: collision with root package name */
        public final TimeUnit f22370o;

        /* renamed from: p, reason: collision with root package name */
        public final ne.r f22371p;

        public b(ne.k<T> kVar, int i10, long j10, TimeUnit timeUnit, ne.r rVar) {
            this.f22367b = kVar;
            this.f22368m = i10;
            this.f22369n = j10;
            this.f22370o = timeUnit;
            this.f22371p = rVar;
        }

        @Override // java.util.concurrent.Callable
        public df.a<T> call() {
            return this.f22367b.replay(this.f22368m, this.f22369n, this.f22370o, this.f22371p);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    public static final class c<T, U> implements se.n<T, ne.o<U>> {

        /* renamed from: b, reason: collision with root package name */
        public final se.n<? super T, ? extends Iterable<? extends U>> f22372b;

        public c(se.n<? super T, ? extends Iterable<? extends U>> nVar) {
            this.f22372b = nVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // se.n
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((c<T, U>) obj);
        }

        @Override // se.n
        public ne.o<U> apply(T t10) throws Exception {
            return new l0((Iterable) ue.a.requireNonNull(this.f22372b.apply(t10), "The mapper returned a null Iterable"));
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    public static final class d<U, R, T> implements se.n<U, R> {

        /* renamed from: b, reason: collision with root package name */
        public final se.c<? super T, ? super U, ? extends R> f22373b;

        /* renamed from: m, reason: collision with root package name */
        public final T f22374m;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Object obj, se.c cVar) {
            this.f22373b = cVar;
            this.f22374m = obj;
        }

        @Override // se.n
        public R apply(U u10) throws Exception {
            return this.f22373b.apply(this.f22374m, u10);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    public static final class e<T, R, U> implements se.n<T, ne.o<R>> {

        /* renamed from: b, reason: collision with root package name */
        public final se.c<? super T, ? super U, ? extends R> f22375b;

        /* renamed from: m, reason: collision with root package name */
        public final se.n<? super T, ? extends ne.o<? extends U>> f22376m;

        public e(se.n nVar, se.c cVar) {
            this.f22375b = cVar;
            this.f22376m = nVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // se.n
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((e<T, R, U>) obj);
        }

        @Override // se.n
        public ne.o<R> apply(T t10) throws Exception {
            return new w0((ne.o) ue.a.requireNonNull(this.f22376m.apply(t10), "The mapper returned a null ObservableSource"), new d(t10, this.f22375b));
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    public static final class f<T, U> implements se.n<T, ne.o<T>> {

        /* renamed from: b, reason: collision with root package name */
        public final se.n<? super T, ? extends ne.o<U>> f22377b;

        public f(se.n<? super T, ? extends ne.o<U>> nVar) {
            this.f22377b = nVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // se.n
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((f<T, U>) obj);
        }

        @Override // se.n
        public ne.o<T> apply(T t10) throws Exception {
            return new p1((ne.o) ue.a.requireNonNull(this.f22377b.apply(t10), "The itemDelay returned a null ObservableSource"), 1L).map(Functions.justFunction(t10)).defaultIfEmpty(t10);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    public static final class g<T> implements se.a {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<T> f22378b;

        public g(ne.q<T> qVar) {
            this.f22378b = qVar;
        }

        @Override // se.a
        public void run() throws Exception {
            this.f22378b.onComplete();
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    public static final class h<T> implements se.f<Throwable> {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<T> f22379b;

        public h(ne.q<T> qVar) {
            this.f22379b = qVar;
        }

        @Override // se.f
        public void accept(Throwable th2) throws Exception {
            this.f22379b.onError(th2);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    public static final class i<T> implements se.f<T> {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<T> f22380b;

        public i(ne.q<T> qVar) {
            this.f22380b = qVar;
        }

        @Override // se.f
        public void accept(T t10) throws Exception {
            this.f22380b.onNext(t10);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    public static final class j<T> implements Callable<df.a<T>> {

        /* renamed from: b, reason: collision with root package name */
        public final ne.k<T> f22381b;

        public j(ne.k<T> kVar) {
            this.f22381b = kVar;
        }

        @Override // java.util.concurrent.Callable
        public df.a<T> call() {
            return this.f22381b.replay();
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    public static final class k<T, R> implements se.n<ne.k<T>, ne.o<R>> {

        /* renamed from: b, reason: collision with root package name */
        public final se.n<? super ne.k<T>, ? extends ne.o<R>> f22382b;

        /* renamed from: m, reason: collision with root package name */
        public final ne.r f22383m;

        public k(se.n<? super ne.k<T>, ? extends ne.o<R>> nVar, ne.r rVar) {
            this.f22382b = nVar;
            this.f22383m = rVar;
        }

        @Override // se.n
        public ne.o<R> apply(ne.k<T> kVar) throws Exception {
            return ne.k.wrap((ne.o) ue.a.requireNonNull(this.f22382b.apply(kVar), "The selector returned a null ObservableSource")).observeOn(this.f22383m);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    public static final class l<T, S> implements se.c<S, ne.d<T>, S> {

        /* renamed from: a, reason: collision with root package name */
        public final se.b<S, ne.d<T>> f22384a;

        public l(se.b<S, ne.d<T>> bVar) {
            this.f22384a = bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // se.c
        public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            return apply((l<T, S>) obj, (ne.d) obj2);
        }

        public S apply(S s10, ne.d<T> dVar) throws Exception {
            this.f22384a.accept(s10, dVar);
            return s10;
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    public static final class m<T, S> implements se.c<S, ne.d<T>, S> {

        /* renamed from: a, reason: collision with root package name */
        public final se.f<ne.d<T>> f22385a;

        public m(se.f<ne.d<T>> fVar) {
            this.f22385a = fVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // se.c
        public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            return apply((m<T, S>) obj, (ne.d) obj2);
        }

        public S apply(S s10, ne.d<T> dVar) throws Exception {
            this.f22385a.accept(dVar);
            return s10;
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    public static final class n<T> implements Callable<df.a<T>> {

        /* renamed from: b, reason: collision with root package name */
        public final ne.k<T> f22386b;

        /* renamed from: m, reason: collision with root package name */
        public final long f22387m;

        /* renamed from: n, reason: collision with root package name */
        public final TimeUnit f22388n;

        /* renamed from: o, reason: collision with root package name */
        public final ne.r f22389o;

        public n(ne.k<T> kVar, long j10, TimeUnit timeUnit, ne.r rVar) {
            this.f22386b = kVar;
            this.f22387m = j10;
            this.f22388n = timeUnit;
            this.f22389o = rVar;
        }

        @Override // java.util.concurrent.Callable
        public df.a<T> call() {
            return this.f22386b.replay(this.f22387m, this.f22388n, this.f22389o);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    public static final class o<T, R> implements se.n<List<ne.o<? extends T>>, ne.o<? extends R>> {

        /* renamed from: b, reason: collision with root package name */
        public final se.n<? super Object[], ? extends R> f22390b;

        public o(se.n<? super Object[], ? extends R> nVar) {
            this.f22390b = nVar;
        }

        @Override // se.n
        public ne.o<? extends R> apply(List<ne.o<? extends T>> list) {
            return ne.k.zipIterable(list, this.f22390b, false, ne.k.bufferSize());
        }
    }

    public static <T, U> se.n<T, ne.o<U>> flatMapIntoIterable(se.n<? super T, ? extends Iterable<? extends U>> nVar) {
        return new c(nVar);
    }

    public static <T, U, R> se.n<T, ne.o<R>> flatMapWithCombiner(se.n<? super T, ? extends ne.o<? extends U>> nVar, se.c<? super T, ? super U, ? extends R> cVar) {
        return new e(nVar, cVar);
    }

    public static <T, U> se.n<T, ne.o<T>> itemDelay(se.n<? super T, ? extends ne.o<U>> nVar) {
        return new f(nVar);
    }

    public static <T> se.a observerOnComplete(ne.q<T> qVar) {
        return new g(qVar);
    }

    public static <T> se.f<Throwable> observerOnError(ne.q<T> qVar) {
        return new h(qVar);
    }

    public static <T> se.f<T> observerOnNext(ne.q<T> qVar) {
        return new i(qVar);
    }

    public static <T> Callable<df.a<T>> replayCallable(ne.k<T> kVar) {
        return new j(kVar);
    }

    public static <T, R> se.n<ne.k<T>, ne.o<R>> replayFunction(se.n<? super ne.k<T>, ? extends ne.o<R>> nVar, ne.r rVar) {
        return new k(nVar, rVar);
    }

    public static <T, S> se.c<S, ne.d<T>, S> simpleBiGenerator(se.b<S, ne.d<T>> bVar) {
        return new l(bVar);
    }

    public static <T, S> se.c<S, ne.d<T>, S> simpleGenerator(se.f<ne.d<T>> fVar) {
        return new m(fVar);
    }

    public static <T, R> se.n<List<ne.o<? extends T>>, ne.o<? extends R>> zipIterable(se.n<? super Object[], ? extends R> nVar) {
        return new o(nVar);
    }

    public static <T> Callable<df.a<T>> replayCallable(ne.k<T> kVar, int i10) {
        return new a(kVar, i10);
    }

    public static <T> Callable<df.a<T>> replayCallable(ne.k<T> kVar, int i10, long j10, TimeUnit timeUnit, ne.r rVar) {
        return new b(kVar, i10, j10, timeUnit, rVar);
    }

    public static <T> Callable<df.a<T>> replayCallable(ne.k<T> kVar, long j10, TimeUnit timeUnit, ne.r rVar) {
        return new n(kVar, j10, timeUnit, rVar);
    }
}
