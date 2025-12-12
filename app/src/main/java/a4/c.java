package a4;

import android.util.Log;
import java.util.HashSet;
import p3.i;

/* compiled from: LogcatLogger.java */
/* loaded from: classes.dex */
public final class c implements i {

    /* renamed from: a, reason: collision with root package name */
    public static final HashSet f311a = new HashSet();

    public void debug(String str, Throwable th2) {
    }

    @Override // p3.i
    public void warning(String str) {
        warning(str, null);
    }

    @Override // p3.i
    public void debug(String str) {
        debug(str, null);
    }

    @Override // p3.i
    public void warning(String str, Throwable th2) {
        HashSet hashSet = f311a;
        if (hashSet.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th2);
        hashSet.add(str);
    }

    @Override // p3.i
    public void error(String str, Throwable th2) {
    }
}
