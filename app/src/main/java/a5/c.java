package a5;

/* compiled from: TimeModule_UptimeClockFactory.java */
/* loaded from: classes.dex */
public final class c implements s4.b<a5.a> {

    /* compiled from: TimeModule_UptimeClockFactory.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final c f331a = new c();
    }

    public static c create() {
        return a.f331a;
    }

    public static a5.a uptimeClock() {
        return (a5.a) s4.d.checkNotNull(new d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // jf.a
    public a5.a get() {
        return uptimeClock();
    }
}
