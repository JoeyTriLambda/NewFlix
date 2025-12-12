package p2;

import android.annotation.SuppressLint;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: Trace.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static long f17425a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f17426b;

    public static void beginSection(String str) {
        b.beginSection(str);
    }

    public static void endSection() {
        b.endSection();
    }

    @SuppressLint({"NewApi"})
    public static boolean isEnabled() {
        try {
            if (f17426b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        try {
            if (f17426b == null) {
                f17425a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f17426b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f17426b.invoke(null, Long.valueOf(f17425a))).booleanValue();
        } catch (Exception e10) {
            if (!(e10 instanceof InvocationTargetException)) {
                Log.v("Trace", "Unable to call isTagEnabled via reflection", e10);
                return false;
            }
            Throwable cause = e10.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }
}
