package n3;

import com.afollestad.materialdialogs.GravityEnum;

/* compiled from: ThemeSingleton.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: f, reason: collision with root package name */
    public static d f16477f;

    /* renamed from: a, reason: collision with root package name */
    public final GravityEnum f16478a;

    /* renamed from: b, reason: collision with root package name */
    public final GravityEnum f16479b;

    /* renamed from: c, reason: collision with root package name */
    public final GravityEnum f16480c;

    /* renamed from: d, reason: collision with root package name */
    public final GravityEnum f16481d;

    /* renamed from: e, reason: collision with root package name */
    public final GravityEnum f16482e;

    public d() {
        GravityEnum gravityEnum = GravityEnum.START;
        this.f16478a = gravityEnum;
        this.f16479b = gravityEnum;
        this.f16480c = GravityEnum.END;
        this.f16481d = gravityEnum;
        this.f16482e = gravityEnum;
    }

    public static d get(boolean z10) {
        if (f16477f == null && z10) {
            f16477f = new d();
        }
        return f16477f;
    }

    public static d get() {
        return get(true);
    }
}
