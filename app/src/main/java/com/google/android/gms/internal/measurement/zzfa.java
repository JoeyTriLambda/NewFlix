package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzds;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.6.1 */
/* loaded from: classes.dex */
final class zzfa extends zzds.zzb {
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ Activity zzd;
    private final /* synthetic */ zzds.zzc zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfa(zzds.zzc zzcVar, Bundle bundle, Activity activity) {
        super(zzds.this);
        this.zzc = bundle;
        this.zzd = activity;
        this.zze = zzcVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzds.zzb
    public final void zza() throws RemoteException {
        Bundle bundle;
        if (this.zzc != null) {
            bundle = new Bundle();
            if (this.zzc.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = this.zzc.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        ((zzdd) Preconditions.checkNotNull(zzds.this.zzj)).onActivityCreated(ObjectWrapper.wrap(this.zzd), bundle, this.zzb);
    }
}
