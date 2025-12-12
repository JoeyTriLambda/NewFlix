package com.google.android.gms.ads.identifier;

import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-identifier@@17.1.0 */
/* loaded from: classes.dex */
final class zza extends Thread {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f6058b;

    public zza(HashMap map) {
        this.f6058b = map;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Uri.Builder builderBuildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        Map map = this.f6058b;
        for (String str : map.keySet()) {
            builderBuildUpon.appendQueryParameter(str, (String) map.get(str));
        }
        zzc.zza(builderBuildUpon.build().toString());
    }
}
