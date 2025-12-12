package com.unity3d.scar.adapter.common;

import android.os.Handler;
import android.os.Looper;

/* compiled from: Utils.java */
/* loaded from: classes2.dex */
public final class i {
    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(runnable, 0L);
    }

    public static void runOnUiThread(Runnable runnable, long j10) {
        new Handler(Looper.getMainLooper()).postDelayed(runnable, j10);
    }
}
