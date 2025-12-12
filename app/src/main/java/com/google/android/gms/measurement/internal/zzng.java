package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzng implements zzns {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zznd f8579a;

    public zzng(zznd zzndVar) {
        this.f8579a = zzndVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzns
    public final void zza(String str, String str2, Bundle bundle) throws IllegalStateException {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        zznd zzndVar = this.f8579a;
        if (!zIsEmpty) {
            zzndVar.zzl().zzb(new zznj(this, str, str2, bundle));
            return;
        }
        zzho zzhoVar = zzndVar.f8555l;
        if (zzhoVar != null) {
            zzhoVar.zzj().zzg().zza("AppId not known when logging event", str2);
        }
    }
}
