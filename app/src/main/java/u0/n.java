package u0;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

/* compiled from: RequestExecutor.java */
/* loaded from: classes.dex */
public final class n implements ThreadFactory {

    /* renamed from: b, reason: collision with root package name */
    public final String f19963b = "fonts-androidx";

    /* renamed from: m, reason: collision with root package name */
    public final int f19964m = 10;

    /* compiled from: RequestExecutor.java */
    public static class a extends Thread {

        /* renamed from: b, reason: collision with root package name */
        public final int f19965b;

        public a(Runnable runnable, String str, int i10) {
            super(runnable, str);
            this.f19965b = i10;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(this.f19965b);
            super.run();
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new a(runnable, this.f19963b, this.f19964m);
    }
}
