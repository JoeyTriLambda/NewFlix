package y4;

/* compiled from: EventStoreModule_SchemaVersionFactory.java */
/* loaded from: classes.dex */
public final class h implements s4.b<Integer> {

    /* compiled from: EventStoreModule_SchemaVersionFactory.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final h f21872a = new h();
    }

    public static h create() {
        return a.f21872a;
    }

    public static int schemaVersion() {
        return s.f21903o;
    }

    @Override // jf.a
    public Integer get() {
        return Integer.valueOf(schemaVersion());
    }
}
