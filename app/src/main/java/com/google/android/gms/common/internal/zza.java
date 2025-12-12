package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
abstract class zza extends zzc {

    /* renamed from: d, reason: collision with root package name */
    public final int f7398d;

    /* renamed from: e, reason: collision with root package name */
    public final Bundle f7399e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ BaseGmsClient f7400f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zza(BaseGmsClient baseGmsClient, int i10, Bundle bundle) {
        super(baseGmsClient, Boolean.TRUE);
        this.f7400f = baseGmsClient;
        this.f7398d = i10;
        this.f7399e = bundle;
    }

    @Override // com.google.android.gms.common.internal.zzc
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        BaseGmsClient baseGmsClient = this.f7400f;
        int i10 = this.f7398d;
        if (i10 != 0) {
            baseGmsClient.zzp(1, null);
            Bundle bundle = this.f7399e;
            zzb(new ConnectionResult(i10, bundle != null ? (PendingIntent) bundle.getParcelable(BaseGmsClient.KEY_PENDING_INTENT) : null));
        } else {
            if (zzd()) {
                return;
            }
            baseGmsClient.zzp(1, null);
            zzb(new ConnectionResult(8, null));
        }
    }

    public abstract void zzb(ConnectionResult connectionResult);

    public abstract boolean zzd();

    @Override // com.google.android.gms.common.internal.zzc
    public final void zzc() {
    }
}
