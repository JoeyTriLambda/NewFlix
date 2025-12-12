package r9;

import android.content.ServiceConnection;
import android.os.Messenger;

/* compiled from: SessionLifecycleServiceBinder.kt */
/* loaded from: classes.dex */
public interface q {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f18889a = 0;

    /* compiled from: SessionLifecycleServiceBinder.kt */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f18890a = new a();

        public final q getInstance() {
            Object obj = g8.h.getApp(g8.c.f12778a).get(q.class);
            zf.i.checkNotNullExpressionValue(obj, "Firebase.app[SessionLife…erviceBinder::class.java]");
            return (q) obj;
        }
    }

    void bindToService(Messenger messenger, ServiceConnection serviceConnection);
}
