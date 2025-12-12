package p2;

import android.os.Trace;

/* compiled from: TraceApi18Impl.java */
/* loaded from: classes.dex */
public final class b {
    public static void beginSection(String str) {
        Trace.beginSection(str);
    }

    public static void endSection() {
        Trace.endSection();
    }
}
