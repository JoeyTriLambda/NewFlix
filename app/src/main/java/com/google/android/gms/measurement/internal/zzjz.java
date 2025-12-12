package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.unity3d.ads.metadata.MediationMetaData;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzjz implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f8301b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zziy f8302m;

    public zzjz(zziy zziyVar, Bundle bundle) {
        this.f8301b = bundle;
        this.f8302m = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zziy zziyVar = this.f8302m;
        zziyVar.zzt();
        zziyVar.zzu();
        Bundle bundle = this.f8301b;
        Preconditions.checkNotNull(bundle);
        String strCheckNotEmpty = Preconditions.checkNotEmpty(bundle.getString(MediationMetaData.KEY_NAME));
        if (!zziyVar.f8189a.zzac()) {
            zziyVar.zzj().zzp().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zzno zznoVar = new zzno(strCheckNotEmpty, "", 0L, null);
        try {
            zznt zzntVarZzq = zziyVar.zzq();
            bundle.getString("app_id");
            zziyVar.zzo().zza(new zzac(bundle.getString("app_id"), "", zznoVar, bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), zzntVarZzq.g(bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), "", bundle.getLong("creation_timestamp"), true)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
