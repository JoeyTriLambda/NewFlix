package f3;

/* compiled from: WorkTag.kt */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final String f11460a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11461b;

    public x(String str, String str2) {
        zf.i.checkNotNullParameter(str, "tag");
        zf.i.checkNotNullParameter(str2, "workSpecId");
        this.f11460a = str;
        this.f11461b = str2;
    }

    public final String getTag() {
        return this.f11460a;
    }

    public final String getWorkSpecId() {
        return this.f11461b;
    }
}
