package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zacq implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zact f7232b;

    public zacq(zact zactVar) {
        this.f7232b = zactVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7232b.f7242g.zae(new ConnectionResult(4));
    }
}
