package r9;

/* compiled from: EventGDTLogger.kt */
/* loaded from: classes.dex */
public final class e implements f {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f18858b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final h9.b<n4.f> f18859a;

    /* compiled from: EventGDTLogger.kt */
    public static final class a {
        public a(zf.f fVar) {
        }
    }

    static {
        new a(null);
    }

    public e(h9.b<n4.f> bVar) {
        zf.i.checkNotNullParameter(bVar, "transportFactoryProvider");
        this.f18859a = bVar;
    }

    @Override // r9.f
    public void log(m mVar) {
        zf.i.checkNotNullParameter(mVar, "sessionEvent");
        ((q4.q) this.f18859a.get().getTransport("FIREBASE_APPQUALITY_SESSION", m.class, n4.b.of("json"), new c1.c(this, 15))).send(n4.c.ofData(mVar));
    }
}
