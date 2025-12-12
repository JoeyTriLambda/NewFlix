package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzt {

    /* renamed from: a, reason: collision with root package name */
    public final zzho f8616a;

    public zzt(zzho zzhoVar) {
        this.f8616a = zzhoVar;
    }

    public final void a(String str, Bundle bundle) {
        String string;
        zzho zzhoVar = this.f8616a;
        zzhoVar.zzl().zzt();
        if (zzhoVar.zzac()) {
            return;
        }
        if (bundle.isEmpty()) {
            string = null;
        } else {
            if (str == null || str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            string = builder.build().toString();
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        zzhoVar.zzn().f8013x.zza(string);
        zzhoVar.zzn().f8014y.zza(zzhoVar.zzb().currentTimeMillis());
    }

    public final boolean b() {
        return this.f8616a.zzn().f8014y.zza() > 0;
    }

    public final boolean c() {
        if (!b()) {
            return false;
        }
        zzho zzhoVar = this.f8616a;
        return zzhoVar.zzb().currentTimeMillis() - zzhoVar.zzn().f8014y.zza() > zzhoVar.zzf().zzc(null, zzbh.U);
    }
}
