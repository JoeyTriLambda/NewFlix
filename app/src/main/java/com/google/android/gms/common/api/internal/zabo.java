package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zabo implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zabp f7182b;

    public zabo(zabp zabpVar) {
        this.f7182b = zabpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Api.Client client = this.f7182b.f7183a.f7185b;
        client.disconnect(client.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
