package y4;

/* compiled from: EventStoreModule_StoreConfigFactory.java */
/* loaded from: classes.dex */
public final class i implements s4.b<e> {

    /* compiled from: EventStoreModule_StoreConfigFactory.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final i f21873a = new i();
    }

    public static i create() {
        return a.f21873a;
    }

    public static e storeConfig() {
        return (e) s4.d.checkNotNull(e.f21869a, "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // jf.a
    public e get() {
        return storeConfig();
    }
}
