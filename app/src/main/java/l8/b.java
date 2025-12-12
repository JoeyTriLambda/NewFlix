package l8;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Component.java */
/* loaded from: classes.dex */
public final class b<T> {

    /* renamed from: a, reason: collision with root package name */
    public final String f15934a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<r<? super T>> f15935b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<l> f15936c;

    /* renamed from: d, reason: collision with root package name */
    public final int f15937d;

    /* renamed from: e, reason: collision with root package name */
    public final int f15938e;

    /* renamed from: f, reason: collision with root package name */
    public final g<T> f15939f;

    /* renamed from: g, reason: collision with root package name */
    public final Set<Class<?>> f15940g;

    public b(String str, Set<r<? super T>> set, Set<l> set2, int i10, int i11, g<T> gVar, Set<Class<?>> set3) {
        this.f15934a = str;
        this.f15935b = Collections.unmodifiableSet(set);
        this.f15936c = Collections.unmodifiableSet(set2);
        this.f15937d = i10;
        this.f15938e = i11;
        this.f15939f = gVar;
        this.f15940g = Collections.unmodifiableSet(set3);
    }

    public static <T> a<T> builder(Class<T> cls) {
        return new a<>(cls, new Class[0]);
    }

    public static <T> b<T> intoSet(T t10, Class<T> cls) {
        return intoSetBuilder(cls).factory(new l8.a(t10, 0)).build();
    }

    public static <T> a<T> intoSetBuilder(Class<T> cls) {
        a<T> aVarBuilder = builder(cls);
        aVarBuilder.f15945e = 1;
        return aVarBuilder;
    }

    @SafeVarargs
    public static <T> b<T> of(T t10, Class<T> cls, Class<? super T>... clsArr) {
        return builder(cls, clsArr).factory(new l8.a(t10, 1)).build();
    }

    public Set<l> getDependencies() {
        return this.f15936c;
    }

    public g<T> getFactory() {
        return this.f15939f;
    }

    public String getName() {
        return this.f15934a;
    }

    public Set<r<? super T>> getProvidedInterfaces() {
        return this.f15935b;
    }

    public Set<Class<?>> getPublishedEvents() {
        return this.f15940g;
    }

    public boolean isAlwaysEager() {
        return this.f15937d == 1;
    }

    public boolean isEagerInDefaultApp() {
        return this.f15937d == 2;
    }

    public boolean isValue() {
        return this.f15938e == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f15935b.toArray()) + ">{" + this.f15937d + ", type=" + this.f15938e + ", deps=" + Arrays.toString(this.f15936c.toArray()) + "}";
    }

    public b<T> withFactory(g<T> gVar) {
        return new b<>(this.f15934a, this.f15935b, this.f15936c, this.f15937d, this.f15938e, gVar, this.f15940g);
    }

    @SafeVarargs
    public static <T> a<T> builder(Class<T> cls, Class<? super T>... clsArr) {
        return new a<>(cls, clsArr);
    }

    public static <T> a<T> builder(r<T> rVar) {
        return new a<>(rVar, new r[0]);
    }

    @SafeVarargs
    public static <T> a<T> builder(r<T> rVar, r<? super T>... rVarArr) {
        return new a<>(rVar, rVarArr);
    }

    /* compiled from: Component.java */
    public static class a<T> {

        /* renamed from: a, reason: collision with root package name */
        public String f15941a = null;

        /* renamed from: b, reason: collision with root package name */
        public final HashSet f15942b;

        /* renamed from: c, reason: collision with root package name */
        public final HashSet f15943c;

        /* renamed from: d, reason: collision with root package name */
        public int f15944d;

        /* renamed from: e, reason: collision with root package name */
        public int f15945e;

        /* renamed from: f, reason: collision with root package name */
        public g<T> f15946f;

        /* renamed from: g, reason: collision with root package name */
        public final HashSet f15947g;

        public a(Class cls, Class[] clsArr) {
            HashSet hashSet = new HashSet();
            this.f15942b = hashSet;
            this.f15943c = new HashSet();
            this.f15944d = 0;
            this.f15945e = 0;
            this.f15947g = new HashSet();
            q.checkNotNull(cls, "Null interface");
            hashSet.add(r.unqualified(cls));
            for (Class cls2 : clsArr) {
                q.checkNotNull(cls2, "Null interface");
                this.f15942b.add(r.unqualified(cls2));
            }
        }

        public a<T> add(l lVar) {
            q.checkNotNull(lVar, "Null dependency");
            q.checkArgument(!this.f15942b.contains(lVar.getInterface()), "Components are not allowed to depend on interfaces they themselves provide.");
            this.f15943c.add(lVar);
            return this;
        }

        public b<T> build() {
            q.checkState(this.f15946f != null, "Missing required property: factory.");
            return new b<>(this.f15941a, new HashSet(this.f15942b), new HashSet(this.f15943c), this.f15944d, this.f15945e, this.f15946f, this.f15947g);
        }

        public a<T> eagerInDefaultApp() {
            q.checkState(this.f15944d == 0, "Instantiation type has already been set.");
            this.f15944d = 2;
            return this;
        }

        public a<T> factory(g<T> gVar) {
            this.f15946f = (g) q.checkNotNull(gVar, "Null factory");
            return this;
        }

        public a<T> name(String str) {
            this.f15941a = str;
            return this;
        }

        public a(r rVar, r[] rVarArr) {
            HashSet hashSet = new HashSet();
            this.f15942b = hashSet;
            this.f15943c = new HashSet();
            this.f15944d = 0;
            this.f15945e = 0;
            this.f15947g = new HashSet();
            q.checkNotNull(rVar, "Null interface");
            hashSet.add(rVar);
            for (r rVar2 : rVarArr) {
                q.checkNotNull(rVar2, "Null interface");
            }
            Collections.addAll(this.f15942b, rVarArr);
        }
    }
}
