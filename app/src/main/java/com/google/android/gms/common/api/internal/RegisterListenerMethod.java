package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
/* loaded from: classes.dex */
public abstract class RegisterListenerMethod<A extends Api.AnyClient, L> {

    /* renamed from: a, reason: collision with root package name */
    public final ListenerHolder<L> f7107a;

    /* renamed from: b, reason: collision with root package name */
    public final Feature[] f7108b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f7109c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7110d;

    @KeepForSdk
    public RegisterListenerMethod(ListenerHolder<L> listenerHolder, Feature[] featureArr, boolean z10, int i10) {
        this.f7107a = listenerHolder;
        this.f7108b = featureArr;
        this.f7109c = z10;
        this.f7110d = i10;
    }

    @KeepForSdk
    public void clearListener() {
        this.f7107a.clear();
    }

    @KeepForSdk
    public ListenerHolder.ListenerKey<L> getListenerKey() {
        return this.f7107a.getListenerKey();
    }

    @KeepForSdk
    public Feature[] getRequiredFeatures() {
        return this.f7108b;
    }

    @KeepForSdk
    public abstract void registerListener(A a10, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException;

    public final int zaa() {
        return this.f7110d;
    }

    public final boolean zab() {
        return this.f7109c;
    }
}
