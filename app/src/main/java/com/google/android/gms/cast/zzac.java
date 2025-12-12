package com.google.android.gms.cast;

import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.RemoteException;
import android.view.Display;
import android.view.Surface;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzac extends zzaf {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f6917a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.cast.zzdo f6918b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CastRemoteDisplayClient f6919c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzal f6920d;

    public zzac(CastRemoteDisplayClient castRemoteDisplayClient, TaskCompletionSource taskCompletionSource, com.google.android.gms.internal.cast.zzdo zzdoVar, zzal zzalVar) {
        this.f6919c = castRemoteDisplayClient;
        this.f6917a = taskCompletionSource;
        this.f6918b = zzdoVar;
        this.f6920d = zzalVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.cast.zzaf, com.google.android.gms.internal.cast.zzds
    public final void zzb(int i10, int i11, Surface surface) throws RemoteException {
        CastRemoteDisplayClient castRemoteDisplayClient = this.f6919c;
        castRemoteDisplayClient.f6162j.d("onConnected", new Object[0]);
        DisplayManager displayManager = (DisplayManager) castRemoteDisplayClient.getApplicationContext().getSystemService("display");
        TaskCompletionSource taskCompletionSource = this.f6917a;
        if (displayManager == null) {
            castRemoteDisplayClient.f6162j.e("Unable to get the display manager", new Object[0]);
            TaskUtil.setResultOrApiException(Status.f7071r, null, taskCompletionSource);
            return;
        }
        CastRemoteDisplayClient.b(castRemoteDisplayClient);
        castRemoteDisplayClient.f6163k = displayManager.createVirtualDisplay("private_display", i10, i11, (Math.min(i10, i11) * 320) / 1080, surface, 2);
        VirtualDisplay virtualDisplay = castRemoteDisplayClient.f6163k;
        if (virtualDisplay == null) {
            castRemoteDisplayClient.f6162j.e("Unable to create virtual display", new Object[0]);
            TaskUtil.setResultOrApiException(Status.f7071r, null, taskCompletionSource);
            return;
        }
        Display display = virtualDisplay.getDisplay();
        if (display == null) {
            castRemoteDisplayClient.f6162j.e("Virtual display does not have a display", new Object[0]);
            TaskUtil.setResultOrApiException(Status.f7071r, null, taskCompletionSource);
        } else {
            try {
                ((com.google.android.gms.internal.cast.zzdt) this.f6918b.getService()).zzf(this, display.getDisplayId());
            } catch (RemoteException | IllegalStateException unused) {
                castRemoteDisplayClient.f6162j.e("Unable to provision the route's new virtual Display", new Object[0]);
                TaskUtil.setResultOrApiException(Status.f7071r, null, taskCompletionSource);
            }
        }
    }

    @Override // com.google.android.gms.cast.zzaf, com.google.android.gms.internal.cast.zzds
    public final void zzc() {
        CastRemoteDisplayClient castRemoteDisplayClient = this.f6919c;
        castRemoteDisplayClient.f6162j.d("onConnectedWithDisplay", new Object[0]);
        VirtualDisplay virtualDisplay = castRemoteDisplayClient.f6163k;
        TaskCompletionSource taskCompletionSource = this.f6917a;
        if (virtualDisplay == null) {
            castRemoteDisplayClient.f6162j.e("There is no virtual display", new Object[0]);
            TaskUtil.setResultOrApiException(Status.f7071r, null, taskCompletionSource);
        } else {
            Display display = virtualDisplay.getDisplay();
            if (display != null) {
                TaskUtil.setResultOrApiException(Status.f7069p, display, taskCompletionSource);
            } else {
                castRemoteDisplayClient.f6162j.e("Virtual display no longer has a display", new Object[0]);
                TaskUtil.setResultOrApiException(Status.f7071r, null, taskCompletionSource);
            }
        }
    }

    @Override // com.google.android.gms.cast.zzaf, com.google.android.gms.internal.cast.zzds
    public final void zzd(int i10) throws RemoteException {
        CastRemoteDisplayClient castRemoteDisplayClient = this.f6919c;
        castRemoteDisplayClient.f6162j.d("onError: %d", Integer.valueOf(i10));
        CastRemoteDisplayClient.b(castRemoteDisplayClient);
        TaskUtil.setResultOrApiException(Status.f7071r, null, this.f6917a);
    }

    @Override // com.google.android.gms.cast.zzaf, com.google.android.gms.internal.cast.zzds
    public final void zze(boolean z10) {
        this.f6919c.f6162j.d("onRemoteDisplayMuteStateChanged: %b", Boolean.valueOf(z10));
        if (this.f6920d == null) {
            return;
        }
        new StringBuilder("onRemoteDisplayMuteStateChanged: ").append(z10);
        Logger logger = CastRemoteDisplayLocalService.f6164w;
        throw null;
    }
}
