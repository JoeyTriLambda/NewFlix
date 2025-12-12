package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public final class zzf extends zza {

    /* renamed from: g, reason: collision with root package name */
    public final IBinder f7414g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ BaseGmsClient f7415h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzf(BaseGmsClient baseGmsClient, int i10, IBinder iBinder, Bundle bundle) {
        super(baseGmsClient, i10, bundle);
        this.f7415h = baseGmsClient;
        this.f7414g = iBinder;
    }

    @Override // com.google.android.gms.common.internal.zza
    public final void zzb(ConnectionResult connectionResult) {
        BaseGmsClient baseGmsClient = this.f7415h;
        if (baseGmsClient.zzx != null) {
            baseGmsClient.zzx.onConnectionFailed(connectionResult);
        }
        baseGmsClient.onConnectionFailed(connectionResult);
    }

    @Override // com.google.android.gms.common.internal.zza
    public final boolean zzd() throws RemoteException {
        IBinder iBinder = this.f7414g;
        try {
            Preconditions.checkNotNull(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            BaseGmsClient baseGmsClient = this.f7415h;
            if (!baseGmsClient.getServiceDescriptor().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + baseGmsClient.getServiceDescriptor() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceCreateServiceInterface = baseGmsClient.createServiceInterface(iBinder);
            if (iInterfaceCreateServiceInterface == null || !(BaseGmsClient.zzn(baseGmsClient, 2, 4, iInterfaceCreateServiceInterface) || BaseGmsClient.zzn(baseGmsClient, 3, 4, iInterfaceCreateServiceInterface))) {
                return false;
            }
            baseGmsClient.zzB = null;
            Bundle connectionHint = baseGmsClient.getConnectionHint();
            if (baseGmsClient.zzw == null) {
                return true;
            }
            baseGmsClient.zzw.onConnected(connectionHint);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
