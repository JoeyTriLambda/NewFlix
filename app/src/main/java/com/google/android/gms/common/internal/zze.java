package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public final class zze implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final int f7412a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseGmsClient f7413b;

    public zze(BaseGmsClient baseGmsClient, int i10) {
        this.f7413b = baseGmsClient;
        this.f7412a = i10;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        BaseGmsClient baseGmsClient = this.f7413b;
        if (iBinder == null) {
            BaseGmsClient.zzk(baseGmsClient, 16);
            return;
        }
        synchronized (baseGmsClient.zzq) {
            BaseGmsClient baseGmsClient2 = this.f7413b;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            baseGmsClient2.zzr = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IGmsServiceBroker)) ? new zzad(iBinder) : (IGmsServiceBroker) iInterfaceQueryLocalInterface;
        }
        this.f7413b.zzl(0, null, this.f7412a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f7413b.zzq) {
            this.f7413b.zzr = null;
        }
        BaseGmsClient baseGmsClient = this.f7413b;
        int i10 = this.f7412a;
        Handler handler = baseGmsClient.zzb;
        handler.sendMessage(handler.obtainMessage(6, i10, 1));
    }
}
