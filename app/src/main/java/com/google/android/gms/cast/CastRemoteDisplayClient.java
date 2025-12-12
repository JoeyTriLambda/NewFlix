package com.google.android.gms.cast;

import ac.c;
import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.VirtualDisplay;
import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@TargetApi(19)
@Deprecated
/* loaded from: classes.dex */
public class CastRemoteDisplayClient extends GoogleApi<Api.ApiOptions.NoOptions> {

    /* renamed from: l, reason: collision with root package name */
    public static final Api f6161l = new Api("CastRemoteDisplay.API", new zzab(), com.google.android.gms.cast.internal.zzak.f6819d);

    /* renamed from: j, reason: collision with root package name */
    public final Logger f6162j;

    /* renamed from: k, reason: collision with root package name */
    public VirtualDisplay f6163k;

    public CastRemoteDisplayClient(Context context) {
        super(context, f6161l, Api.ApiOptions.f7048g, GoogleApi.Settings.f7061c);
        this.f6162j = new Logger("CastRemoteDisplay");
    }

    public static /* bridge */ /* synthetic */ void b(CastRemoteDisplayClient castRemoteDisplayClient) {
        VirtualDisplay virtualDisplay = castRemoteDisplayClient.f6163k;
        if (virtualDisplay != null) {
            if (virtualDisplay.getDisplay() != null) {
                castRemoteDisplayClient.f6162j.d(c.f("releasing virtual display: ", castRemoteDisplayClient.f6163k.getDisplay().getDisplayId()), new Object[0]);
            }
            VirtualDisplay virtualDisplay2 = castRemoteDisplayClient.f6163k;
            if (virtualDisplay2 != null) {
                virtualDisplay2.release();
                castRemoteDisplayClient.f6163k = null;
            }
        }
    }

    public Task<Void> stopRemoteDisplay() {
        return doWrite(TaskApiCall.builder().setMethodKey(8402).run(new RemoteCall() { // from class: com.google.android.gms.cast.zzaa
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((com.google.android.gms.internal.cast.zzdt) ((com.google.android.gms.internal.cast.zzdo) obj).getService()).zzi(new zzad(this.f6916a, (TaskCompletionSource) obj2));
            }
        }).build());
    }
}
