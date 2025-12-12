package r8;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: ExecutorUtils.java */
/* loaded from: classes.dex */
public final class f0 extends d {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f18688b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ ExecutorService f18689m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ long f18690n = 2;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ TimeUnit f18691o;

    public f0(String str, ExecutorService executorService, TimeUnit timeUnit) {
        this.f18688b = str;
        this.f18689m = executorService;
        this.f18691o = timeUnit;
    }

    @Override // r8.d
    public void onRun() {
        String str = this.f18688b;
        ExecutorService executorService = this.f18689m;
        try {
            o8.e.getLogger().d("Executing shutdown hook for " + str);
            executorService.shutdown();
            if (executorService.awaitTermination(this.f18690n, this.f18691o)) {
                return;
            }
            o8.e.getLogger().d(str + " did not shut down in the allocated time. Requesting immediate shutdown.");
            executorService.shutdownNow();
        } catch (InterruptedException unused) {
            o8.e.getLogger().d(String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", str));
            executorService.shutdownNow();
        }
    }
}
