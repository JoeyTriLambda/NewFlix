package oe;

import java.util.concurrent.Callable;
import ne.r;

/* compiled from: RxAndroidPlugins.java */
/* loaded from: classes2.dex */
public final class a {
    public static r initMainThreadScheduler(Callable<r> callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        try {
            r rVarCall = callable.call();
            if (rVarCall != null) {
                return rVarCall;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th2) {
            throw re.a.propagate(th2);
        }
    }

    public static r onMainThreadScheduler(r rVar) {
        if (rVar != null) {
            return rVar;
        }
        throw new NullPointerException("scheduler == null");
    }
}
