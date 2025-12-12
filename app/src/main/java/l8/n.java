package l8;

/* compiled from: Lazy.java */
/* loaded from: classes.dex */
public final class n<T> implements h9.b<T> {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f15978c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f15979a = f15978c;

    /* renamed from: b, reason: collision with root package name */
    public volatile h9.b<T> f15980b;

    public n(h9.b<T> bVar) {
        this.f15980b = bVar;
    }

    @Override // h9.b
    public T get() {
        T t10 = (T) this.f15979a;
        Object obj = f15978c;
        if (t10 == obj) {
            synchronized (this) {
                t10 = (T) this.f15979a;
                if (t10 == obj) {
                    t10 = this.f15980b.get();
                    this.f15979a = t10;
                    this.f15980b = null;
                }
            }
        }
        return t10;
    }
}
