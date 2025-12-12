package r8;

import android.os.Process;

/* compiled from: BackgroundPriorityRunnable.java */
/* loaded from: classes.dex */
public abstract class d implements Runnable {
    public abstract void onRun();

    @Override // java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(10);
        onRun();
    }
}
