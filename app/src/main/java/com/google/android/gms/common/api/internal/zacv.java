package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zacv extends TaskApiCall {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TaskApiCall.Builder f7243d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zacv(TaskApiCall.Builder builder, Feature[] featureArr, boolean z10, int i10) {
        super(featureArr, z10, i10);
        this.f7243d = builder;
    }

    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.f7243d.f7124a.accept(anyClient, taskCompletionSource);
    }
}
