package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public final class zzah {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f7402a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f7403b;

    /* renamed from: c, reason: collision with root package name */
    public static int f7404c;

    public static int zza(Context context) {
        Bundle bundle;
        synchronized (f7402a) {
            if (!f7403b) {
                f7403b = true;
                try {
                    bundle = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
                } catch (PackageManager.NameNotFoundException e10) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e10);
                }
                if (bundle != null) {
                    bundle.getString("com.google.app.id");
                    f7404c = bundle.getInt("com.google.android.gms.version");
                }
            }
        }
        return f7404c;
    }
}
