package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class zaci {

    /* renamed from: a, reason: collision with root package name */
    public final RegisterListenerMethod<Api.AnyClient, ?> f7225a;

    /* renamed from: b, reason: collision with root package name */
    public final UnregisterListenerMethod<Api.AnyClient, ?> f7226b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f7227c;

    public zaci(RegisterListenerMethod<Api.AnyClient, ?> registerListenerMethod, UnregisterListenerMethod<Api.AnyClient, ?> unregisterListenerMethod, Runnable runnable) {
        this.f7225a = registerListenerMethod;
        this.f7226b = unregisterListenerMethod;
        this.f7227c = runnable;
    }
}
