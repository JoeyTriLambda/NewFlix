package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
/* loaded from: classes.dex */
public abstract class UnregisterListenerMethod<A extends Api.AnyClient, L> {

    /* renamed from: a, reason: collision with root package name */
    public final ListenerHolder.ListenerKey<L> f7128a;

    @KeepForSdk
    public UnregisterListenerMethod(ListenerHolder.ListenerKey<L> listenerKey) {
        this.f7128a = listenerKey;
    }

    @KeepForSdk
    public ListenerHolder.ListenerKey<L> getListenerKey() {
        return this.f7128a;
    }

    @KeepForSdk
    public abstract void unregisterListener(A a10, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException;
}
