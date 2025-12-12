package gh;

/* compiled from: ParseSettings.java */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final c f12843c = new c(false, false);

    /* renamed from: d, reason: collision with root package name */
    public static final c f12844d = new c(true, true);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f12845a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f12846b;

    public c(boolean z10, boolean z11) {
        this.f12845a = z10;
        this.f12846b = z11;
    }

    public final String a(String str) {
        String strTrim = str.trim();
        return !this.f12845a ? eh.b.lowerCase(strTrim) : strTrim;
    }
}
