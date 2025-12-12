package v9;

import com.google.gson.JsonIOException;
import com.google.gson.ReflectionAccessFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/* compiled from: ConstructorConstructor.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Type, com.google.gson.k<?>> f20626a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f20627b;

    /* renamed from: c, reason: collision with root package name */
    public final List<ReflectionAccessFilter> f20628c;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    public class a<T> implements u<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.google.gson.k f20629a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Type f20630b;

        public a(com.google.gson.k kVar, Type type) {
            this.f20629a = kVar;
            this.f20630b = type;
        }

        @Override // v9.u
        public T construct() {
            return (T) this.f20629a.createInstance(this.f20630b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    public class b<T> implements u<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.google.gson.k f20631a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Type f20632b;

        public b(com.google.gson.k kVar, Type type) {
            this.f20631a = kVar;
            this.f20632b = type;
        }

        @Override // v9.u
        public T construct() {
            return (T) this.f20631a.createInstance(this.f20632b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    public class c<T> implements u<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f20633a;

        public c(String str) {
            this.f20633a = str;
        }

        @Override // v9.u
        public T construct() {
            throw new JsonIOException(this.f20633a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    public class d<T> implements u<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f20634a;

        public d(String str) {
            this.f20634a = str;
        }

        @Override // v9.u
        public T construct() {
            throw new JsonIOException(this.f20634a);
        }
    }

    public l(Map<Type, com.google.gson.k<?>> map, boolean z10, List<ReflectionAccessFilter> list) {
        this.f20626a = map;
        this.f20627b = z10;
        this.f20628c = list;
    }

    public <T> u<T> get(y9.a<T> aVar) {
        u<T> rVar;
        String strTryMakeAccessible;
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        Map<Type, com.google.gson.k<?>> map = this.f20626a;
        com.google.gson.k<?> kVar = map.get(type);
        if (kVar != null) {
            return new a(kVar, type);
        }
        com.google.gson.k<?> kVar2 = map.get(rawType);
        if (kVar2 != null) {
            return new b(kVar2, type);
        }
        u<T> fVar = null;
        u<T> nVar = EnumSet.class.isAssignableFrom(rawType) ? new n(type) : rawType == EnumMap.class ? new o(type) : null;
        if (nVar != null) {
            return nVar;
        }
        ReflectionAccessFilter.FilterResult filterResult = x.getFilterResult(this.f20628c, rawType);
        boolean zIsAbstract = Modifier.isAbstract(rawType.getModifiers());
        ReflectionAccessFilter.FilterResult filterResult2 = ReflectionAccessFilter.FilterResult.ALLOW;
        if (zIsAbstract) {
            rVar = null;
        } else {
            try {
                Constructor<? super T> declaredConstructor = rawType.getDeclaredConstructor(new Class[0]);
                if (filterResult == filterResult2 || (x.canAccess(declaredConstructor, null) && (filterResult != ReflectionAccessFilter.FilterResult.BLOCK_ALL || Modifier.isPublic(declaredConstructor.getModifiers())))) {
                    rVar = (filterResult != filterResult2 || (strTryMakeAccessible = x9.a.tryMakeAccessible(declaredConstructor)) == null) ? new r(declaredConstructor) : new q(strTryMakeAccessible);
                } else {
                    rVar = new p("Unable to invoke no-args constructor of " + rawType + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
                }
            } catch (NoSuchMethodException unused) {
            }
        }
        if (rVar != null) {
            return rVar;
        }
        if (Collection.class.isAssignableFrom(rawType)) {
            fVar = SortedSet.class.isAssignableFrom(rawType) ? new v9.b() : Set.class.isAssignableFrom(rawType) ? new v9.c() : Queue.class.isAssignableFrom(rawType) ? new v9.d() : new e();
        } else if (Map.class.isAssignableFrom(rawType)) {
            fVar = ConcurrentNavigableMap.class.isAssignableFrom(rawType) ? new f() : ConcurrentMap.class.isAssignableFrom(rawType) ? new g() : SortedMap.class.isAssignableFrom(rawType) ? new h() : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(y9.a.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) ? new j() : new i();
        }
        if (fVar != null) {
            return fVar;
        }
        String strB = z.b(rawType);
        if (strB != null) {
            return new c(strB);
        }
        if (filterResult != filterResult2) {
            return new d("Unable to create instance of " + rawType + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
        }
        if (this.f20627b) {
            return new k(rawType);
        }
        return new m("Unable to create instance of " + rawType + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    public String toString() {
        return this.f20626a.toString();
    }
}
