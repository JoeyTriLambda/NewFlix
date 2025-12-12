package s4;

/* compiled from: DoubleCheck.java */
/* loaded from: classes.dex */
public final class a<T> implements jf.a<T> {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f19064c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile jf.a<T> f19065a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f19066b = f19064c;

    public a(jf.a<T> aVar) {
        this.f19065a = aVar;
    }

    public static <P extends jf.a<T>, T> jf.a<T> provider(P p10) {
        d.checkNotNull(p10);
        return p10 instanceof a ? p10 : new a(p10);
    }

    public static Object reentrantCheck(Object obj, Object obj2) {
        if (!(obj != f19064c) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // jf.a
    public T get() {
        T t10 = (T) this.f19066b;
        Object obj = f19064c;
        if (t10 == obj) {
            synchronized (this) {
                t10 = (T) this.f19066b;
                if (t10 == obj) {
                    t10 = this.f19065a.get();
                    this.f19066b = reentrantCheck(this.f19066b, t10);
                    this.f19065a = null;
                }
            }
        }
        return t10;
    }
}
