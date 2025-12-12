package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzds;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.6.1 */
/* loaded from: classes.dex */
final class zzdx extends zzds.zzb {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ zzds zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdx(zzds zzdsVar, Activity activity, String str, String str2) {
        super(zzdsVar);
        this.zzc = activity;
        this.zzd = str;
        this.zze = str2;
        this.zzf = zzdsVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzds.zzb
    public final void zza() throws RemoteException {
        ((zzdd) Preconditions.checkNotNull(this.zzf.zzj)).setCurrentScreen(ObjectWrapper.wrap(this.zzc), this.zzd, this.zze, this.zza);
    }
}
