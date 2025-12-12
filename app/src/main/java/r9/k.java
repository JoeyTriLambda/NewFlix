package r9;

/* compiled from: SessionDatastore.kt */
/* loaded from: classes.dex */
public interface k {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f18869a = 0;

    /* compiled from: SessionDatastore.kt */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f18870a = new a();

        public final k getInstance() {
            Object obj = g8.h.getApp(g8.c.f12778a).get(k.class);
            zf.i.checkNotNullExpressionValue(obj, "Firebase.app[SessionDatastore::class.java]");
            return (k) obj;
        }
    }

    String getCurrentSessionId();

    void updateSessionId(String str);
}
