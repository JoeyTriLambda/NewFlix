package com.google.android.gms.common.internal;

import ac.c;
import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
final class zzb extends com.google.android.gms.internal.common.zzi {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseGmsClient f7406a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzb(BaseGmsClient baseGmsClient, Looper looper) {
        super(looper);
        this.f7406a = baseGmsClient;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        BaseGmsClient baseGmsClient = this.f7406a;
        if (baseGmsClient.zzd.get() != message.arg1) {
            int i10 = message.what;
            if (i10 == 2 || i10 == 1 || i10 == 7) {
                zzc zzcVar = (zzc) message.obj;
                zzcVar.zzc();
                zzcVar.zzg();
                return;
            }
            return;
        }
        int i11 = message.what;
        if ((i11 == 1 || i11 == 7 || ((i11 == 4 && !baseGmsClient.enableLocalFallback()) || message.what == 5)) && !baseGmsClient.isConnecting()) {
            zzc zzcVar2 = (zzc) message.obj;
            zzcVar2.zzc();
            zzcVar2.zzg();
            return;
        }
        int i12 = message.what;
        if (i12 == 4) {
            baseGmsClient.zzB = new ConnectionResult(message.arg2);
            if (BaseGmsClient.zzo(baseGmsClient) && !baseGmsClient.zzC) {
                baseGmsClient.zzp(3, null);
                return;
            }
            ConnectionResult connectionResult = baseGmsClient.zzB != null ? baseGmsClient.zzB : new ConnectionResult(8);
            baseGmsClient.zzc.onReportServiceBinding(connectionResult);
            baseGmsClient.onConnectionFailed(connectionResult);
            return;
        }
        if (i12 == 5) {
            ConnectionResult connectionResult2 = baseGmsClient.zzB != null ? baseGmsClient.zzB : new ConnectionResult(8);
            baseGmsClient.zzc.onReportServiceBinding(connectionResult2);
            baseGmsClient.onConnectionFailed(connectionResult2);
            return;
        }
        if (i12 == 3) {
            Object obj = message.obj;
            ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            baseGmsClient.zzc.onReportServiceBinding(connectionResult3);
            baseGmsClient.onConnectionFailed(connectionResult3);
            return;
        }
        if (i12 == 6) {
            baseGmsClient.zzp(5, null);
            if (baseGmsClient.zzw != null) {
                baseGmsClient.zzw.onConnectionSuspended(message.arg2);
            }
            baseGmsClient.onConnectionSuspended(message.arg2);
            BaseGmsClient.zzn(baseGmsClient, 5, 1, null);
            return;
        }
        if (i12 == 2 && !baseGmsClient.isConnected()) {
            zzc zzcVar3 = (zzc) message.obj;
            zzcVar3.zzc();
            zzcVar3.zzg();
        } else {
            int i13 = message.what;
            if (i13 == 2 || i13 == 1 || i13 == 7) {
                ((zzc) message.obj).zze();
            } else {
                Log.wtf("GmsClient", c.f("Don't know how to handle message: ", i13), new Exception());
            }
        }
    }
}
