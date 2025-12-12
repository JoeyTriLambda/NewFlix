package w2;

import android.content.Context;
import androidx.work.WorkerParameters;

/* compiled from: WorkerFactory.java */
/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final String f20891a = g.tagWithPrefix("WorkerFactory");

    /* compiled from: WorkerFactory.java */
    public class a extends p {
        @Override // w2.p
        public androidx.work.c createWorker(Context context, String str, WorkerParameters workerParameters) {
            return null;
        }
    }

    public static p getDefaultWorkerFactory() {
        return new a();
    }

    public abstract androidx.work.c createWorker(Context context, String str, WorkerParameters workerParameters);

    public final androidx.work.c createWorkerWithDefaultFallback(Context context, String str, WorkerParameters workerParameters) {
        Class clsAsSubclass;
        String str2 = f20891a;
        androidx.work.c cVarCreateWorker = createWorker(context, str, workerParameters);
        if (cVarCreateWorker == null) {
            try {
                clsAsSubclass = Class.forName(str).asSubclass(androidx.work.c.class);
            } catch (Throwable th2) {
                g.get().error(str2, "Invalid class: " + str, th2);
                clsAsSubclass = null;
            }
            if (clsAsSubclass != null) {
                try {
                    cVarCreateWorker = (androidx.work.c) clsAsSubclass.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
                } catch (Throwable th3) {
                    g.get().error(str2, "Could not instantiate " + str, th3);
                }
            }
        }
        if (cVarCreateWorker == null || !cVarCreateWorker.isUsed()) {
            return cVarCreateWorker;
        }
        throw new IllegalStateException("WorkerFactory (" + getClass().getName() + ") returned an instance of a ListenableWorker (" + str + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
    }
}
