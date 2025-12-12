package com.google.android.gms.cast.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.cast.zzax;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzn extends GoogleApi {

    /* renamed from: j, reason: collision with root package name */
    public static final Api f6862j = new Api("CastApi.API", new zzi(), new Api.ClientKey());

    public zzn(Context context) {
        super(context, f6862j, Api.ApiOptions.f7048g, GoogleApi.Settings.f7061c);
    }

    public final Task zza(final String[] strArr) {
        return doRead(TaskApiCall.builder().run(new RemoteCall(this) { // from class: com.google.android.gms.cast.internal.zzg
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((zzaj) ((zzo) obj).getService()).zzf(new zzk((TaskCompletionSource) obj2), strArr);
            }
        }).setFeatures(zzax.f6935b).setAutoResolveMissingFeatures(false).setMethodKey(8425).build());
    }
}
