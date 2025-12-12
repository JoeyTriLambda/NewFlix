package sf;

import zf.i;

/* compiled from: DebugProbes.kt */
/* loaded from: classes2.dex */
public final class f {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> qf.c<T> probeCoroutineCreated(qf.c<? super T> cVar) {
        i.checkNotNullParameter(cVar, "completion");
        return cVar;
    }

    public static final void probeCoroutineResumed(qf.c<?> cVar) {
        i.checkNotNullParameter(cVar, "frame");
    }

    public static final void probeCoroutineSuspended(qf.c<?> cVar) {
        i.checkNotNullParameter(cVar, "frame");
    }
}
