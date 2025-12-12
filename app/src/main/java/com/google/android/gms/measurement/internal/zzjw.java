package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.unity3d.ads.metadata.MediationMetaData;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzjw implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f8293b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zziy f8294m;

    public zzjw(zziy zziyVar, Bundle bundle) {
        this.f8293b = bundle;
        this.f8294m = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zziy zziyVar = this.f8294m;
        zziyVar.zzt();
        zziyVar.zzu();
        Bundle bundle = this.f8293b;
        Preconditions.checkNotNull(bundle);
        String string = bundle.getString(MediationMetaData.KEY_NAME);
        String string2 = bundle.getString("origin");
        Preconditions.checkNotEmpty(string);
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotNull(bundle.get("value"));
        if (!zziyVar.f8189a.zzac()) {
            zziyVar.zzj().zzp().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzno zznoVar = new zzno(string, string2, bundle.getLong("triggered_timestamp"), bundle.get("value"));
        try {
            zznt zzntVarZzq = zziyVar.zzq();
            bundle.getString("app_id");
            zzbf zzbfVarG = zzntVarZzq.g(bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), string2, 0L, true);
            zznt zzntVarZzq2 = zziyVar.zzq();
            bundle.getString("app_id");
            zzbf zzbfVarG2 = zzntVarZzq2.g(bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), string2, 0L, true);
            zznt zzntVarZzq3 = zziyVar.zzq();
            bundle.getString("app_id");
            zziyVar.zzo().zza(new zzac(bundle.getString("app_id"), string2, zznoVar, bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), zzbfVarG2, bundle.getLong("trigger_timeout"), zzbfVarG, bundle.getLong("time_to_live"), zzntVarZzq3.g(bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), string2, 0L, true)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
