package com.google.android.gms.cast.framework;

import android.os.RemoteException;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.zzbt;
import com.google.android.gms.cast.zzbu;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzw extends zzaf {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CastSession f6798a;

    public /* synthetic */ zzw(CastSession castSession) {
        this.f6798a = castSession;
    }

    @Override // com.google.android.gms.cast.framework.zzag
    public final void zzb(int i10) throws IllegalArgumentException {
        CastSession castSession = this.f6798a;
        castSession.f6383h.zzi(i10);
        com.google.android.gms.cast.zzr zzrVar = castSession.f6384i;
        if (zzrVar != null) {
            zzrVar.zzf();
            castSession.f6384i = null;
        }
        castSession.f6386k = null;
        RemoteMediaClient remoteMediaClient = castSession.f6385j;
        if (remoteMediaClient != null) {
            remoteMediaClient.zzs(null);
            castSession.f6385j = null;
        }
    }

    @Override // com.google.android.gms.cast.framework.zzag
    public final void zzc(final String str, final String str2) {
        CastSession castSession = this.f6798a;
        com.google.android.gms.cast.zzr zzrVar = castSession.f6384i;
        if (zzrVar == null || !zzrVar.zzl()) {
            return;
        }
        final zzbt zzbtVar = (zzbt) castSession.f6384i;
        final zzbu zzbuVar = null;
        zzbtVar.doWrite(TaskApiCall.builder().run(new RemoteCall(str, str2, zzbuVar) { // from class: com.google.android.gms.cast.zzbd

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f6949b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f6950c;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                zzbt zzbtVar2 = this.f6948a;
                Preconditions.checkState(zzbtVar2.zzl(), "Not connected to device");
                ((com.google.android.gms.cast.internal.zzag) ((com.google.android.gms.cast.internal.zzx) obj).getService()).zzg(this.f6949b, this.f6950c, null);
                synchronized (zzbtVar2.f6984q) {
                    if (zzbtVar2.f6981n != null) {
                        zzbtVar2.e(2477);
                    }
                    zzbtVar2.f6981n = taskCompletionSource;
                }
            }
        }).setMethodKey(8407).build()).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.cast.framework.zzu
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                CastSession.a(this.f6797a.f6798a, "joinApplication", task);
            }
        });
    }

    @Override // com.google.android.gms.cast.framework.zzag
    public final void zzd(final String str, final LaunchOptions launchOptions) {
        CastSession castSession = this.f6798a;
        com.google.android.gms.cast.zzr zzrVar = castSession.f6384i;
        if (zzrVar == null || !zzrVar.zzl()) {
            return;
        }
        final zzbt zzbtVar = (zzbt) castSession.f6384i;
        zzbtVar.doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.cast.zzay
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                zzbt zzbtVar2 = zzbtVar;
                Preconditions.checkState(zzbtVar2.zzl(), "Not connected to device");
                ((com.google.android.gms.cast.internal.zzag) ((com.google.android.gms.cast.internal.zzx) obj).getService()).zzh(str, launchOptions);
                synchronized (zzbtVar2.f6984q) {
                    if (zzbtVar2.f6981n != null) {
                        zzbtVar2.e(2477);
                    }
                    zzbtVar2.f6981n = taskCompletionSource;
                }
            }
        }).setMethodKey(8406).build()).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.cast.framework.zzt
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                CastSession.a(this.f6796a.f6798a, "launchApplication", task);
            }
        });
    }

    @Override // com.google.android.gms.cast.framework.zzag
    public final void zze(final String str) {
        CastSession castSession = this.f6798a;
        com.google.android.gms.cast.zzr zzrVar = castSession.f6384i;
        if (zzrVar == null || !zzrVar.zzl()) {
            return;
        }
        final zzbt zzbtVar = (zzbt) castSession.f6384i;
        zzbtVar.doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.cast.zzbj
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzbt zzbtVar2 = zzbtVar;
                String str2 = str;
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                Preconditions.checkState(zzbtVar2.zzl(), "Not connected to device");
                ((com.google.android.gms.cast.internal.zzag) ((com.google.android.gms.cast.internal.zzx) obj).getService()).zzp(str2);
                synchronized (zzbtVar2.f6985r) {
                    if (zzbtVar2.f6982o != null) {
                        taskCompletionSource.setException(ApiExceptionUtil.fromStatus(new Status(2001)));
                    } else {
                        zzbtVar2.f6982o = taskCompletionSource;
                    }
                }
            }
        }).setMethodKey(8409).build());
    }
}
