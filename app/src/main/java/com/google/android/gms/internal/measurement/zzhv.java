package com.google.android.gms.internal.measurement;

import b8.e;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzhv {
    private final boolean zza;

    public zzhv(zzhu zzhuVar) {
        e.checkNotNull(zzhuVar, "BuildInfo must be non-null");
        this.zza = !zzhuVar.zza();
    }

    public final boolean zza(String str) {
        e.checkNotNull(str, "flagName must not be null");
        if (this.zza) {
            return zzhx.zza.get().containsValue(str);
        }
        return true;
    }
}
