package je;

import android.util.Log;
import io.netas.Netas;

/* loaded from: classes2.dex */
public final class a {
    public static void a(String str, String str2) {
        if (a(str, 2)) {
            Log.v(str, str2);
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        if (Log.isLoggable(str, 6)) {
            Log.e(str, String.format(str2, objArr));
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        if (a(str, 4)) {
            Log.i(str, String.format(str2, objArr));
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (a(str, 5)) {
            Log.w(str, String.format(str2, objArr));
        }
    }

    public static void a(String str, String str2, Throwable th2, Object... objArr) {
        if (a(str, 6)) {
            Log.e(str, String.format(str2, objArr), th2);
        }
    }

    public static void a(String str, String str2, Object... objArr) {
        if (a(str, 3)) {
            Log.d(str, String.format(str2, objArr));
        }
    }

    public static boolean a(String str, int i10) {
        try {
            Netas netasA = Netas.a(true);
            if (netasA == null || !netasA.o()) {
                if (!Log.isLoggable(str, i10)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e10) {
            Log.e(str, "Failed to getInstance on NetasService onCreate: ", e10);
            return false;
        }
    }
}
