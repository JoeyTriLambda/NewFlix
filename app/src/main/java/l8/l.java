package l8;

/* compiled from: Dependency.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final r<?> f15972a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15973b;

    /* renamed from: c, reason: collision with root package name */
    public final int f15974c;

    public l(int i10, int i11, Class cls) {
        this((r<?>) r.unqualified(cls), i10, i11);
    }

    public static l deferred(Class<?> cls) {
        return new l(0, 2, cls);
    }

    public static l optionalProvider(Class<?> cls) {
        return new l(0, 1, cls);
    }

    public static l required(Class<?> cls) {
        return new l(1, 0, cls);
    }

    public static l requiredProvider(Class<?> cls) {
        return new l(1, 1, cls);
    }

    public static l setOf(Class<?> cls) {
        return new l(2, 0, cls);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f15972a.equals(lVar.f15972a) && this.f15973b == lVar.f15973b && this.f15974c == lVar.f15974c;
    }

    public r<?> getInterface() {
        return this.f15972a;
    }

    public int hashCode() {
        return ((((this.f15972a.hashCode() ^ 1000003) * 1000003) ^ this.f15973b) * 1000003) ^ this.f15974c;
    }

    public boolean isDeferred() {
        return this.f15974c == 2;
    }

    public boolean isDirectInjection() {
        return this.f15974c == 0;
    }

    public boolean isRequired() {
        return this.f15973b == 1;
    }

    public boolean isSet() {
        return this.f15973b == 2;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("Dependency{anInterface=");
        sb2.append(this.f15972a);
        sb2.append(", type=");
        int i10 = this.f15973b;
        sb2.append(i10 == 1 ? "required" : i10 == 0 ? "optional" : "set");
        sb2.append(", injection=");
        int i11 = this.f15974c;
        if (i11 == 0) {
            str = "direct";
        } else if (i11 == 1) {
            str = "provider";
        } else {
            if (i11 != 2) {
                throw new AssertionError(ac.c.f("Unsupported injection: ", i11));
            }
            str = "deferred";
        }
        return ac.c.o(sb2, str, "}");
    }

    public l(r<?> rVar, int i10, int i11) {
        this.f15972a = (r) q.checkNotNull(rVar, "Null dependency anInterface.");
        this.f15973b = i10;
        this.f15974c = i11;
    }

    public static l required(r<?> rVar) {
        return new l(rVar, 1, 0);
    }

    public static l requiredProvider(r<?> rVar) {
        return new l(rVar, 1, 1);
    }
}
