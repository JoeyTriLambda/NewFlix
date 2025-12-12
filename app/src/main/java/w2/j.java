package w2;

import android.os.Build;
import java.util.concurrent.TimeUnit;
import w2.o;

/* compiled from: PeriodicWorkRequest.kt */
/* loaded from: classes.dex */
public final class j extends o {

    /* compiled from: PeriodicWorkRequest.kt */
    public static final class a extends o.a<a, j> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class<? extends androidx.work.c> cls, long j10, TimeUnit timeUnit) {
            super(cls);
            zf.i.checkNotNullParameter(cls, "workerClass");
            zf.i.checkNotNullParameter(timeUnit, "repeatIntervalTimeUnit");
            getWorkSpec$work_runtime_release().setPeriodic(timeUnit.toMillis(j10));
        }

        @Override // w2.o.a
        public a getThisObject$work_runtime_release() {
            return this;
        }

        @Override // w2.o.a
        public j buildInternal$work_runtime_release() {
            if (!((getBackoffCriteriaSet$work_runtime_release() && Build.VERSION.SDK_INT >= 23 && getWorkSpec$work_runtime_release().f11435j.requiresDeviceIdle()) ? false : true)) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job".toString());
            }
            if (!getWorkSpec$work_runtime_release().f11442q) {
                return new j(this);
            }
            throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited".toString());
        }
    }

    /* compiled from: PeriodicWorkRequest.kt */
    public static final class b {
        public b(zf.f fVar) {
        }
    }

    static {
        new b(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(a aVar) {
        super(aVar.getId$work_runtime_release(), aVar.getWorkSpec$work_runtime_release(), aVar.getTags$work_runtime_release());
        zf.i.checkNotNullParameter(aVar, "builder");
    }
}
