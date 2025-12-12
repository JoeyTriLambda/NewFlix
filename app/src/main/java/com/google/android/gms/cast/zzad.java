package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzad extends zzaf {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f6921a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CastRemoteDisplayClient f6922b;

    public zzad(CastRemoteDisplayClient castRemoteDisplayClient, TaskCompletionSource taskCompletionSource) {
        this.f6922b = castRemoteDisplayClient;
        this.f6921a = taskCompletionSource;
    }

    @Override // com.google.android.gms.cast.zzaf, com.google.android.gms.internal.cast.zzds
    public final void zzd(int i10) throws RemoteException {
        CastRemoteDisplayClient castRemoteDisplayClient = this.f6922b;
        castRemoteDisplayClient.f6162j.d("onError: %d", Integer.valueOf(i10));
        CastRemoteDisplayClient.b(castRemoteDisplayClient);
        TaskUtil.setResultOrApiException(Status.f7071r, this.f6921a);
    }

    @Override // com.google.android.gms.cast.zzaf, com.google.android.gms.internal.cast.zzds
    public final void zzf() throws RemoteException {
        CastRemoteDisplayClient castRemoteDisplayClient = this.f6922b;
        castRemoteDisplayClient.f6162j.d("onDisconnected", new Object[0]);
        CastRemoteDisplayClient.b(castRemoteDisplayClient);
        TaskUtil.setResultOrApiException(Status.f7069p, this.f6921a);
    }
}
