package t9;

import android.os.Trace;

/* compiled from: FirebaseTrace.java */
/* loaded from: classes.dex */
public final class b {
    public static void popTrace() {
        Trace.endSection();
    }

    public static void pushTrace(String str) {
        Trace.beginSection(str);
    }
}
