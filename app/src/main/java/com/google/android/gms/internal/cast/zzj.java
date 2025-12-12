package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.SessionState;
import com.google.android.gms.cast.framework.SessionTransferCallback;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzj extends SessionTransferCallback {
    final /* synthetic */ zzk zza;

    public zzj(zzk zzkVar) {
        this.zza = zzkVar;
    }

    @Override // com.google.android.gms.cast.framework.SessionTransferCallback
    public final void onTransferFailed(int i10, int i11) {
        zzk.zza.d("onTransferFailed with type = %d and reason = %d", Integer.valueOf(i10), Integer.valueOf(i11));
        this.zza.zzs();
        zzk zzkVar = this.zza;
        this.zza.zzb.zze(zzkVar.zzd.zzf(zzkVar.zzh, i10, i11), 232);
        this.zza.zzj = false;
    }

    @Override // com.google.android.gms.cast.framework.SessionTransferCallback
    public final void onTransferred(int i10, SessionState sessionState) {
        zzk.zza.d("onTransferred with type = %d", Integer.valueOf(i10));
        this.zza.zzs();
        zzk zzkVar = this.zza;
        this.zza.zzb.zze(zzkVar.zzd.zzg(zzkVar.zzh, i10), 231);
        this.zza.zzj = false;
        this.zza.zzh = null;
    }

    @Override // com.google.android.gms.cast.framework.SessionTransferCallback
    public final void onTransferring(int i10) {
        zzk.zza.d("onTransferring with type = %d", Integer.valueOf(i10));
        this.zza.zzj = true;
        this.zza.zzs();
        zzk zzkVar = this.zza;
        this.zza.zzb.zze(zzkVar.zzd.zzg(zzkVar.zzh, i10), 230);
    }
}
