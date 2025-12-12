package zf;

/* compiled from: PackageReference.kt */
/* loaded from: classes2.dex */
public final class j implements c {

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f22727a;

    public j(Class<?> cls, String str) {
        i.checkNotNullParameter(cls, "jClass");
        i.checkNotNullParameter(str, "moduleName");
        this.f22727a = cls;
    }

    public boolean equals(Object obj) {
        return (obj instanceof j) && i.areEqual(getJClass(), ((j) obj).getJClass());
    }

    @Override // zf.c
    public Class<?> getJClass() {
        return this.f22727a;
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
