package y4;

/* compiled from: EventStoreModule_DbNameFactory.java */
/* loaded from: classes.dex */
public final class f implements s4.b<String> {

    /* compiled from: EventStoreModule_DbNameFactory.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final f f21870a = new f();
    }

    public static f create() {
        return a.f21870a;
    }

    public static String dbName() {
        return (String) s4.d.checkNotNull("com.google.android.datatransport.events", "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // jf.a
    public String get() {
        return dbName();
    }
}
