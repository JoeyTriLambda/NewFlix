package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzf extends com.google.android.gms.cast.internal.zzad {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f7005a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7006b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzf(GoogleApiClient googleApiClient, String str, String str2) {
        super(googleApiClient);
        this.f7005a = str;
        this.f7006b = str2;
    }

    @Override // com.google.android.gms.cast.internal.zzad, com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    /* renamed from: zza */
    public final void doExecute(com.google.android.gms.cast.internal.zzw zzwVar) throws RemoteException {
        try {
            zzwVar.zzQ(this.f7005a, this.f7006b, this);
        } catch (IllegalArgumentException | IllegalStateException unused) {
            zzc(2001);
        }
    }
}
