package com.google.android.gms.internal.measurement;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzhn extends zzhg<Boolean> {
    public zzhn(zzho zzhoVar, String str, Boolean bool, boolean z10) {
        super(zzhoVar, str, bool);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* synthetic */ Boolean zza(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzgf.zzc.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (zzgf.zzd.matcher(str).matches()) {
                return Boolean.FALSE;
            }
        }
        Log.e("PhenotypeFlag", "Invalid boolean value for " + super.zzb() + ": " + String.valueOf(obj));
        return null;
    }
}
