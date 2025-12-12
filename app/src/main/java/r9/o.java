package r9;

/* compiled from: SessionFirelogPublisher.kt */
/* loaded from: classes.dex */
public interface o {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f18880a = 0;

    /* compiled from: SessionFirelogPublisher.kt */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f18881a = new a();

        public final o getInstance() {
            Object obj = g8.h.getApp(g8.c.f12778a).get(o.class);
            zf.i.checkNotNullExpressionValue(obj, "Firebase.app[SessionFirelogPublisher::class.java]");
            return (o) obj;
        }
    }

    void logSession(l lVar);
}
