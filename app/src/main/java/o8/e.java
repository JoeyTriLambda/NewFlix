package o8;

import android.util.Log;

/* compiled from: Logger.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public static final e f17045c = new e("FirebaseCrashlytics");

    /* renamed from: a, reason: collision with root package name */
    public final String f17046a;

    /* renamed from: b, reason: collision with root package name */
    public final int f17047b = 4;

    public e(String str) {
        this.f17046a = str;
    }

    public static e getLogger() {
        return f17045c;
    }

    public final boolean a(int i10) {
        return this.f17047b <= i10 || Log.isLoggable(this.f17046a, i10);
    }

    public void d(String str, Throwable th2) {
        if (a(3)) {
            Log.d(this.f17046a, str, th2);
        }
    }

    public void e(String str, Throwable th2) {
        if (a(6)) {
            Log.e(this.f17046a, str, th2);
        }
    }

    public void i(String str, Throwable th2) {
        if (a(4)) {
            Log.i(this.f17046a, str, th2);
        }
    }

    public void v(String str, Throwable th2) {
        if (a(2)) {
            Log.v(this.f17046a, str, th2);
        }
    }

    public void w(String str, Throwable th2) {
        if (a(5)) {
            Log.w(this.f17046a, str, th2);
        }
    }

    public void d(String str) {
        d(str, null);
    }

    public void e(String str) {
        e(str, null);
    }

    public void i(String str) {
        i(str, null);
    }

    public void v(String str) {
        v(str, null);
    }

    public void w(String str) {
        w(str, null);
    }
}
