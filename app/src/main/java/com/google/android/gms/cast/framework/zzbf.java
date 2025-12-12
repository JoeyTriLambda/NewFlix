package com.google.android.gms.cast.framework;

import android.content.Context;
import android.preference.PreferenceManager;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzbf {
    public static void zza(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("googlecast-introOverlayShown", true).apply();
    }
}
