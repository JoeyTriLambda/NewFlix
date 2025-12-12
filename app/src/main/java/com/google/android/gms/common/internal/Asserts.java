package com.google.android.gms.common.internal;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes.dex */
public final class Asserts {
    private Asserts() {
        throw new AssertionError("Uninstantiable");
    }

    @KeepForSdk
    public static void checkMainThread(String str) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return;
        }
        Log.e("Asserts", "checkMainThread: current thread " + String.valueOf(Thread.currentThread()) + " IS NOT the main thread " + String.valueOf(Looper.getMainLooper().getThread()) + "!");
        throw new IllegalStateException(str);
    }

    @KeepForSdk
    public static void checkNotMainThread(String str) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            return;
        }
        Log.e("Asserts", "checkNotMainThread: current thread " + String.valueOf(Thread.currentThread()) + " IS the main thread " + String.valueOf(Looper.getMainLooper().getThread()) + "!");
        throw new IllegalStateException(str);
    }
}
