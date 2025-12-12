package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.SessionState;
import com.google.android.gms.cast.framework.SessionTransferCallback;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzu extends SessionTransferCallback {
    final /* synthetic */ zzv zza;

    public zzu(zzv zzvVar) {
        this.zza = zzvVar;
    }

    @Override // com.google.android.gms.cast.framework.SessionTransferCallback
    public final void onTransferFailed(int i10, int i11) {
        zzy zzyVar = new zzy(11);
        zzyVar.zzb(Integer.valueOf(i11));
        zzyVar.zza(Boolean.valueOf(this.zza.zzb.zze()));
        zzv.zzf(this.zza, new zzz(zzyVar));
    }

    @Override // com.google.android.gms.cast.framework.SessionTransferCallback
    public final void onTransferring(int i10) {
        zzy zzyVar = new zzy(10);
        zzyVar.zza(Boolean.valueOf(this.zza.zzb.zze()));
        zzv.zzf(this.zza, new zzz(zzyVar));
        this.zza.zzg().zzd(new zzab(new zzaa(i10)));
    }

    @Override // com.google.android.gms.cast.framework.SessionTransferCallback
    public final void onTransferred(int i10, SessionState sessionState) {
    }
}
