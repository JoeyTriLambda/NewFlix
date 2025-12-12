package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public final class zzd extends zzac {

    /* renamed from: a, reason: collision with root package name */
    public BaseGmsClient f7410a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7411b;

    public zzd(BaseGmsClient baseGmsClient, int i10) {
        this.f7410a = baseGmsClient;
        this.f7411b = i10;
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void onPostInitComplete(int i10, IBinder iBinder, Bundle bundle) {
        Preconditions.checkNotNull(this.f7410a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f7410a.onPostInitHandler(i10, iBinder, bundle, this.f7411b);
        this.f7410a = null;
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zzb(int i10, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zzc(int i10, IBinder iBinder, zzk zzkVar) {
        BaseGmsClient baseGmsClient = this.f7410a;
        Preconditions.checkNotNull(baseGmsClient, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        Preconditions.checkNotNull(zzkVar);
        BaseGmsClient.zzj(baseGmsClient, zzkVar);
        onPostInitComplete(i10, iBinder, zzkVar.f7418b);
    }
}
