package u4;

import ac.c;
import android.os.Build;
import android.util.Log;

/* compiled from: Logging.java */
/* loaded from: classes.dex */
public final class a {
    public static String a(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return c.j("TRuntime.", str);
        }
        String strJ = c.j("TRuntime.", str);
        return strJ.length() > 23 ? strJ.substring(0, 23) : strJ;
    }

    public static void d(String str, String str2, Object obj) {
        String strA = a(str);
        if (Log.isLoggable(strA, 3)) {
            Log.d(strA, String.format(str2, obj));
        }
    }

    public static void e(String str, String str2, Throwable th2) {
        String strA = a(str);
        if (Log.isLoggable(strA, 6)) {
            Log.e(strA, str2, th2);
        }
    }

    public static void i(String str, String str2, Object obj) {
        String strA = a(str);
        if (Log.isLoggable(strA, 4)) {
            Log.i(strA, String.format(str2, obj));
        }
    }

    public static void w(String str, String str2, Object obj) {
        String strA = a(str);
        if (Log.isLoggable(strA, 5)) {
            Log.w(strA, String.format(str2, obj));
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        String strA = a(str);
        if (Log.isLoggable(strA, 3)) {
            Log.d(strA, String.format(str2, objArr));
        }
    }
}
