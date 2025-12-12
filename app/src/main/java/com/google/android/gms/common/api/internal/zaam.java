package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zaam extends zabg {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ConnectionResult f7146b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zaao f7147c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaam(zaao zaaoVar, zaaw zaawVar, ConnectionResult connectionResult) {
        super(zaawVar);
        this.f7147c = zaaoVar;
        this.f7146b = connectionResult;
    }

    @Override // com.google.android.gms.common.api.internal.zabg
    public final void zaa() {
        this.f7147c.f7150n.d(this.f7146b);
    }
}
