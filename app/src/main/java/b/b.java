package b;

/* compiled from: CoroutineDebugging.kt */
/* loaded from: classes.dex */
public final class b {
    public static final StackTraceElement access$artificialFrame(Throwable th2, String str) {
        StackTraceElement stackTraceElement = th2.getStackTrace()[0];
        return new StackTraceElement(ac.c.j("_COROUTINE.", str), "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
    }
}
