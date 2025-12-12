package f3;

/* compiled from: Dependency.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f11401a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11402b;

    public a(String str, String str2) {
        zf.i.checkNotNullParameter(str, "workSpecId");
        zf.i.checkNotNullParameter(str2, "prerequisiteId");
        this.f11401a = str;
        this.f11402b = str2;
    }

    public final String getPrerequisiteId() {
        return this.f11402b;
    }

    public final String getWorkSpecId() {
        return this.f11401a;
    }
}
