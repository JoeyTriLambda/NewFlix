package com.google.android.gms.internal.cast;

import a2.n;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzbg {
    public n zza;
    private final Context zzb;

    public zzbg(Context context) {
        this.zzb = context;
    }

    public final n zza() {
        if (this.zza == null) {
            this.zza = n.getInstance(this.zzb);
        }
        return this.zza;
    }

    public final void zzb(n.a aVar) {
        n nVarZza = zza();
        if (nVarZza != null) {
            nVarZza.removeCallback(aVar);
        }
    }
}
