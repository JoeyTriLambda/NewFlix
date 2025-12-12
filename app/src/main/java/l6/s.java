package l6;

import android.os.Trace;

/* compiled from: TraceUtil.java */
/* loaded from: classes.dex */
public final class s {
    public static void beginSection(String str) {
        if (u.f15907a >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void endSection() {
        if (u.f15907a >= 18) {
            Trace.endSection();
        }
    }
}
