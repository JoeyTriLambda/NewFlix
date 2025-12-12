package com.google.android.gms.common.util;

import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes.dex */
public class WorkSourceUtil {
    static {
        Process.myUid();
        try {
            WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception unused) {
        }
        if (PlatformVersion.isAtLeastJellyBeanMR2()) {
            try {
                WorkSource.class.getMethod("add", Integer.TYPE, String.class);
            } catch (Exception unused2) {
            }
        }
        try {
            WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception unused3) {
        }
        try {
            WorkSource.class.getMethod("get", Integer.TYPE);
        } catch (Exception unused4) {
        }
        if (PlatformVersion.isAtLeastJellyBeanMR2()) {
            try {
                WorkSource.class.getMethod("getName", Integer.TYPE);
            } catch (Exception unused5) {
            }
        }
        if (PlatformVersion.isAtLeastP()) {
            try {
                WorkSource.class.getMethod("createWorkChain", new Class[0]);
            } catch (Exception e10) {
                Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e10);
            }
        }
        if (PlatformVersion.isAtLeastP()) {
            try {
                Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", Integer.TYPE, String.class);
            } catch (Exception e11) {
                Log.w("WorkSourceUtil", "Missing WorkChain class", e11);
            }
        }
        if (PlatformVersion.isAtLeastP()) {
            try {
                WorkSource.class.getMethod("isEmpty", new Class[0]).setAccessible(true);
            } catch (Exception unused6) {
            }
        }
    }

    private WorkSourceUtil() {
    }
}
