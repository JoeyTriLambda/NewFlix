package r8;

import java.util.concurrent.TimeoutException;
import r8.b0;

/* compiled from: CrashlyticsController.java */
/* loaded from: classes.dex */
public final class o implements b0.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f18730a;

    public o(r rVar) {
        this.f18730a = rVar;
    }

    public void onUncaughtException(y8.g gVar, Thread thread, Throwable th2) {
        r rVar = this.f18730a;
        synchronized (rVar) {
            o8.e.getLogger().d("Handling uncaught exception \"" + th2 + "\" from thread " + thread.getName());
            try {
                try {
                    p0.awaitEvenIfOnMainThread(rVar.f18748e.submitTask(new p(rVar, System.currentTimeMillis(), th2, thread, gVar)));
                } catch (Exception e10) {
                    o8.e.getLogger().e("Error handling uncaught exception", e10);
                }
            } catch (TimeoutException unused) {
                o8.e.getLogger().e("Cannot send reports. Timed out while fetching settings.");
            }
        }
    }
}
