package io.reactivex.internal.functions;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class Functions {

    /* renamed from: a, reason: collision with root package name */
    public static final s f13538a = new s();

    /* renamed from: b, reason: collision with root package name */
    public static final p f13539b = new p();

    /* renamed from: c, reason: collision with root package name */
    public static final n f13540c = new n();

    /* renamed from: d, reason: collision with root package name */
    public static final o f13541d = new o();

    /* renamed from: e, reason: collision with root package name */
    public static final a0 f13542e = new a0();

    /* renamed from: f, reason: collision with root package name */
    public static final f0 f13543f = new f0();

    /* renamed from: g, reason: collision with root package name */
    public static final r f13544g = new r();

    /* renamed from: h, reason: collision with root package name */
    public static final z f13545h = new z();

    /* renamed from: i, reason: collision with root package name */
    public static final v f13546i = new v();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class HashSetCallable implements Callable<Set<Object>> {

        /* renamed from: b, reason: collision with root package name */
        public static final HashSetCallable f13547b;

        /* renamed from: m, reason: collision with root package name */
        public static final /* synthetic */ HashSetCallable[] f13548m;

        static {
            HashSetCallable hashSetCallable = new HashSetCallable();
            f13547b = hashSetCallable;
            f13548m = new HashSetCallable[]{hashSetCallable};
        }

        public static HashSetCallable valueOf(String str) {
            return (HashSetCallable) Enum.valueOf(HashSetCallable.class, str);
        }

        public static HashSetCallable[] values() {
            return (HashSetCallable[]) f13548m.clone();
        }

        @Override // java.util.concurrent.Callable
        public Set<Object> call() throws Exception {
            return new HashSet();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class NaturalComparator implements Comparator<Object> {

        /* renamed from: b, reason: collision with root package name */
        public static final NaturalComparator f13549b;

        /* renamed from: m, reason: collision with root package name */
        public static final /* synthetic */ NaturalComparator[] f13550m;

        static {
            NaturalComparator naturalComparator = new NaturalComparator();
            f13549b = naturalComparator;
            f13550m = new NaturalComparator[]{naturalComparator};
        }

        public static NaturalComparator valueOf(String str) {
            return (NaturalComparator) Enum.valueOf(NaturalComparator.class, str);
        }

        public static NaturalComparator[] values() {
            return (NaturalComparator[]) f13550m.clone();
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    public static final class a<T> implements se.f<T> {

        /* renamed from: b, reason: collision with root package name */
        public final se.a f13551b;

        public a(se.a aVar) {
            this.f13551b = aVar;
        }

        @Override // se.f
        public void accept(T t10) throws Exception {
            this.f13551b.run();
        }
    }

    public static final class a0 implements se.f<Throwable> {
        @Override // se.f
        public void accept(Throwable th2) {
            ff.a.onError(new OnErrorNotImplementedException(th2));
        }
    }

    public static final class b<T1, T2, R> implements se.n<Object[], R> {

        /* renamed from: b, reason: collision with root package name */
        public final se.c<? super T1, ? super T2, ? extends R> f13552b;

        public b(se.c<? super T1, ? super T2, ? extends R> cVar) {
            this.f13552b = cVar;
        }

        @Override // se.n
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 2) {
                return this.f13552b.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    public static final class b0<T> implements se.n<T, gf.b<T>> {

        /* renamed from: b, reason: collision with root package name */
        public final TimeUnit f13553b;

        /* renamed from: m, reason: collision with root package name */
        public final ne.r f13554m;

        public b0(TimeUnit timeUnit, ne.r rVar) {
            this.f13553b = timeUnit;
            this.f13554m = rVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // se.n
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((b0<T>) obj);
        }

        @Override // se.n
        public gf.b<T> apply(T t10) throws Exception {
            ne.r rVar = this.f13554m;
            TimeUnit timeUnit = this.f13553b;
            return new gf.b<>(t10, rVar.now(timeUnit), timeUnit);
        }
    }

    public static final class c<T1, T2, T3, R> implements se.n<Object[], R> {
        @Override // se.n
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 3) {
                throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
            }
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Object obj3 = objArr[2];
            throw null;
        }
    }

    public static final class c0<K, T> implements se.b<Map<K, T>, T> {

        /* renamed from: a, reason: collision with root package name */
        public final se.n<? super T, ? extends K> f13555a;

        public c0(se.n<? super T, ? extends K> nVar) {
            this.f13555a = nVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // se.b
        public /* bridge */ /* synthetic */ void accept(Object obj, Object obj2) throws Exception {
            accept((Map<K, Map<K, T>>) obj, (Map<K, T>) obj2);
        }

        public void accept(Map<K, T> map, T t10) throws Exception {
            map.put(this.f13555a.apply(t10), t10);
        }
    }

    public static final class d<T1, T2, T3, T4, R> implements se.n<Object[], R> {
        @Override // se.n
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 4) {
                throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
            }
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Object obj3 = objArr[2];
            Object obj4 = objArr[3];
            throw null;
        }
    }

    public static final class d0<K, V, T> implements se.b<Map<K, V>, T> {

        /* renamed from: a, reason: collision with root package name */
        public final se.n<? super T, ? extends V> f13556a;

        /* renamed from: b, reason: collision with root package name */
        public final se.n<? super T, ? extends K> f13557b;

        public d0(se.n<? super T, ? extends V> nVar, se.n<? super T, ? extends K> nVar2) {
            this.f13556a = nVar;
            this.f13557b = nVar2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // se.b
        public /* bridge */ /* synthetic */ void accept(Object obj, Object obj2) throws Exception {
            accept((Map) obj, (Map<K, V>) obj2);
        }

        public void accept(Map<K, V> map, T t10) throws Exception {
            map.put(this.f13557b.apply(t10), this.f13556a.apply(t10));
        }
    }

    public static final class e<T1, T2, T3, T4, T5, R> implements se.n<Object[], R> {
        @Override // se.n
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 5) {
                throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
            }
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Object obj3 = objArr[2];
            Object obj4 = objArr[3];
            Object obj5 = objArr[4];
            throw null;
        }
    }

    public static final class e0<K, V, T> implements se.b<Map<K, Collection<V>>, T> {

        /* renamed from: a, reason: collision with root package name */
        public final se.n<? super K, ? extends Collection<? super V>> f13558a;

        /* renamed from: b, reason: collision with root package name */
        public final se.n<? super T, ? extends V> f13559b;

        /* renamed from: c, reason: collision with root package name */
        public final se.n<? super T, ? extends K> f13560c;

        public e0(se.n<? super K, ? extends Collection<? super V>> nVar, se.n<? super T, ? extends V> nVar2, se.n<? super T, ? extends K> nVar3) {
            this.f13558a = nVar;
            this.f13559b = nVar2;
            this.f13560c = nVar3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // se.b
        public /* bridge */ /* synthetic */ void accept(Object obj, Object obj2) throws Exception {
            accept((Map) obj, (Map<K, Collection<V>>) obj2);
        }

        public void accept(Map<K, Collection<V>> map, T t10) throws Exception {
            K kApply = this.f13560c.apply(t10);
            Collection<? super V> collectionApply = (Collection) map.get(kApply);
            if (collectionApply == null) {
                collectionApply = this.f13558a.apply(kApply);
                map.put(kApply, collectionApply);
            }
            collectionApply.add(this.f13559b.apply(t10));
        }
    }

    public static final class f<T1, T2, T3, T4, T5, T6, R> implements se.n<Object[], R> {
        @Override // se.n
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 6) {
                throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
            }
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Object obj3 = objArr[2];
            Object obj4 = objArr[3];
            Object obj5 = objArr[4];
            Object obj6 = objArr[5];
            throw null;
        }
    }

    public static final class f0 implements se.o<Object> {
        @Override // se.o
        public boolean test(Object obj) {
            return true;
        }
    }

    public static final class g<T1, T2, T3, T4, T5, T6, T7, R> implements se.n<Object[], R> {
        @Override // se.n
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 7) {
                throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
            }
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Object obj3 = objArr[2];
            Object obj4 = objArr[3];
            Object obj5 = objArr[4];
            Object obj6 = objArr[5];
            Object obj7 = objArr[6];
            throw null;
        }
    }

    public static final class h<T1, T2, T3, T4, T5, T6, T7, T8, R> implements se.n<Object[], R> {
        @Override // se.n
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 8) {
                throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
            }
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Object obj3 = objArr[2];
            Object obj4 = objArr[3];
            Object obj5 = objArr[4];
            Object obj6 = objArr[5];
            Object obj7 = objArr[6];
            Object obj8 = objArr[7];
            throw null;
        }
    }

    public static final class i<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements se.n<Object[], R> {
        @Override // se.n
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 9) {
                throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
            }
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Object obj3 = objArr[2];
            Object obj4 = objArr[3];
            Object obj5 = objArr[4];
            Object obj6 = objArr[5];
            Object obj7 = objArr[6];
            Object obj8 = objArr[7];
            Object obj9 = objArr[8];
            throw null;
        }
    }

    public static final class j<T> implements Callable<List<T>> {

        /* renamed from: b, reason: collision with root package name */
        public final int f13561b;

        public j(int i10) {
            this.f13561b = i10;
        }

        @Override // java.util.concurrent.Callable
        public List<T> call() throws Exception {
            return new ArrayList(this.f13561b);
        }
    }

    public static final class k<T> implements se.o<T> {
        @Override // se.o
        public boolean test(T t10) throws Exception {
            throw null;
        }
    }

    public static final class l<T, U> implements se.n<T, U> {

        /* renamed from: b, reason: collision with root package name */
        public final Class<U> f13562b;

        public l(Class<U> cls) {
            this.f13562b = cls;
        }

        @Override // se.n
        public U apply(T t10) throws Exception {
            return this.f13562b.cast(t10);
        }
    }

    public static final class m<T, U> implements se.o<T> {

        /* renamed from: b, reason: collision with root package name */
        public final Class<U> f13563b;

        public m(Class<U> cls) {
            this.f13563b = cls;
        }

        @Override // se.o
        public boolean test(T t10) throws Exception {
            return this.f13563b.isInstance(t10);
        }
    }

    public static final class q<T> implements se.o<T> {

        /* renamed from: b, reason: collision with root package name */
        public final T f13564b;

        public q(T t10) {
            this.f13564b = t10;
        }

        @Override // se.o
        public boolean test(T t10) throws Exception {
            return ue.a.equals(t10, this.f13564b);
        }
    }

    public static final class r implements se.o<Object> {
        @Override // se.o
        public boolean test(Object obj) {
            return false;
        }
    }

    public static final class t<T, U> implements Callable<U>, se.n<T, U> {

        /* renamed from: b, reason: collision with root package name */
        public final U f13565b;

        public t(U u10) {
            this.f13565b = u10;
        }

        @Override // se.n
        public U apply(T t10) throws Exception {
            return this.f13565b;
        }

        @Override // java.util.concurrent.Callable
        public U call() throws Exception {
            return this.f13565b;
        }
    }

    public static final class u<T> implements se.n<List<T>, List<T>> {

        /* renamed from: b, reason: collision with root package name */
        public final Comparator<? super T> f13566b;

        public u(Comparator<? super T> comparator) {
            this.f13566b = comparator;
        }

        @Override // se.n
        public List<T> apply(List<T> list) {
            Collections.sort(list, this.f13566b);
            return list;
        }
    }

    public static final class v implements Comparator<Object> {
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    public static final class w<T> implements se.a {

        /* renamed from: b, reason: collision with root package name */
        public final se.f<? super ne.j<T>> f13567b;

        public w(se.f<? super ne.j<T>> fVar) {
            this.f13567b = fVar;
        }

        @Override // se.a
        public void run() throws Exception {
            this.f13567b.accept(ne.j.createOnComplete());
        }
    }

    public static final class x<T> implements se.f<Throwable> {

        /* renamed from: b, reason: collision with root package name */
        public final se.f<? super ne.j<T>> f13568b;

        public x(se.f<? super ne.j<T>> fVar) {
            this.f13568b = fVar;
        }

        @Override // se.f
        public void accept(Throwable th2) throws Exception {
            this.f13568b.accept(ne.j.createOnError(th2));
        }
    }

    public static final class y<T> implements se.f<T> {

        /* renamed from: b, reason: collision with root package name */
        public final se.f<? super ne.j<T>> f13569b;

        public y(se.f<? super ne.j<T>> fVar) {
            this.f13569b = fVar;
        }

        @Override // se.f
        public void accept(T t10) throws Exception {
            this.f13569b.accept(ne.j.createOnNext(t10));
        }
    }

    public static final class z implements Callable<Object> {
        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    public static <T> se.f<T> actionConsumer(se.a aVar) {
        return new a(aVar);
    }

    public static <T> se.o<T> alwaysFalse() {
        return f13544g;
    }

    public static <T> se.o<T> alwaysTrue() {
        return f13543f;
    }

    public static <T, U> se.n<T, U> castFunction(Class<U> cls) {
        return new l(cls);
    }

    public static <T> Callable<List<T>> createArrayList(int i10) {
        return new j(i10);
    }

    public static <T> Callable<Set<T>> createHashSet() {
        return HashSetCallable.f13547b;
    }

    public static <T> se.f<T> emptyConsumer() {
        return f13541d;
    }

    public static <T> se.o<T> equalsWith(T t10) {
        return new q(t10);
    }

    public static <T> se.n<T, T> identity() {
        return f13538a;
    }

    public static <T, U> se.o<T> isInstanceOf(Class<U> cls) {
        return new m(cls);
    }

    public static <T> Callable<T> justCallable(T t10) {
        return new t(t10);
    }

    public static <T, U> se.n<T, U> justFunction(U u10) {
        return new t(u10);
    }

    public static <T> se.n<List<T>, List<T>> listSorter(Comparator<? super T> comparator) {
        return new u(comparator);
    }

    public static <T> Comparator<T> naturalComparator() {
        return NaturalComparator.f13549b;
    }

    public static <T> Comparator<T> naturalOrder() {
        return f13546i;
    }

    public static <T> se.a notificationOnComplete(se.f<? super ne.j<T>> fVar) {
        return new w(fVar);
    }

    public static <T> se.f<Throwable> notificationOnError(se.f<? super ne.j<T>> fVar) {
        return new x(fVar);
    }

    public static <T> se.f<T> notificationOnNext(se.f<? super ne.j<T>> fVar) {
        return new y(fVar);
    }

    public static <T> Callable<T> nullSupplier() {
        return f13545h;
    }

    public static <T> se.o<T> predicateReverseFor(se.e eVar) {
        return new k();
    }

    public static <T> se.n<T, gf.b<T>> timestampWith(TimeUnit timeUnit, ne.r rVar) {
        return new b0(timeUnit, rVar);
    }

    public static <T1, T2, R> se.n<Object[], R> toFunction(se.c<? super T1, ? super T2, ? extends R> cVar) {
        ue.a.requireNonNull(cVar, "f is null");
        return new b(cVar);
    }

    public static <T, K> se.b<Map<K, T>, T> toMapKeySelector(se.n<? super T, ? extends K> nVar) {
        return new c0(nVar);
    }

    public static <T, K, V> se.b<Map<K, V>, T> toMapKeyValueSelector(se.n<? super T, ? extends K> nVar, se.n<? super T, ? extends V> nVar2) {
        return new d0(nVar2, nVar);
    }

    public static <T, K, V> se.b<Map<K, Collection<V>>, T> toMultimapKeyValueSelector(se.n<? super T, ? extends K> nVar, se.n<? super T, ? extends V> nVar2, se.n<? super K, ? extends Collection<? super V>> nVar3) {
        return new e0(nVar3, nVar2, nVar);
    }

    public static <T1, T2, T3, R> se.n<Object[], R> toFunction(se.g<T1, T2, T3, R> gVar) {
        ue.a.requireNonNull(gVar, "f is null");
        return new c();
    }

    public static <T1, T2, T3, T4, R> se.n<Object[], R> toFunction(se.h<T1, T2, T3, T4, R> hVar) {
        ue.a.requireNonNull(hVar, "f is null");
        return new d();
    }

    public static <T1, T2, T3, T4, T5, R> se.n<Object[], R> toFunction(se.i<T1, T2, T3, T4, T5, R> iVar) {
        ue.a.requireNonNull(iVar, "f is null");
        return new e();
    }

    public static <T1, T2, T3, T4, T5, T6, R> se.n<Object[], R> toFunction(se.j<T1, T2, T3, T4, T5, T6, R> jVar) {
        ue.a.requireNonNull(jVar, "f is null");
        return new f();
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> se.n<Object[], R> toFunction(se.k<T1, T2, T3, T4, T5, T6, T7, R> kVar) {
        ue.a.requireNonNull(kVar, "f is null");
        return new g();
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> se.n<Object[], R> toFunction(se.l<T1, T2, T3, T4, T5, T6, T7, T8, R> lVar) {
        ue.a.requireNonNull(lVar, "f is null");
        return new h();
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> se.n<Object[], R> toFunction(se.m<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> mVar) {
        ue.a.requireNonNull(mVar, "f is null");
        return new i();
    }

    public static final class n implements se.a {
        public String toString() {
            return "EmptyAction";
        }

        @Override // se.a
        public void run() {
        }
    }

    public static final class p implements Runnable {
        public String toString() {
            return "EmptyRunnable";
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public static final class o implements se.f<Object> {
        public String toString() {
            return "EmptyConsumer";
        }

        @Override // se.f
        public void accept(Object obj) {
        }
    }

    public static final class s implements se.n<Object, Object> {
        public String toString() {
            return "IdentityFunction";
        }

        @Override // se.n
        public Object apply(Object obj) {
            return obj;
        }
    }
}
