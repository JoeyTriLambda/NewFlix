package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzkd implements zzns {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zziy f8316a;

    public zzkd(zziy zziyVar) {
        this.f8316a = zziyVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzns
    public final void zza(String str, String str2, Bundle bundle) throws IllegalStateException {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        zziy zziyVar = this.f8316a;
        if (zIsEmpty) {
            zziyVar.zzb("auto", str2, bundle);
        } else {
            zziyVar.zza("auto", str2, bundle, str);
        }
    }
}
