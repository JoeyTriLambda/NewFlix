package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zaar extends com.google.android.gms.signin.internal.zac {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference<zaaw> f7155a;

    public zaar(zaaw zaawVar) {
        this.f7155a = new WeakReference<>(zaawVar);
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zae
    public final void zab(com.google.android.gms.signin.internal.zak zakVar) {
        zaaw zaawVar = this.f7155a.get();
        if (zaawVar == null) {
            return;
        }
        new zaaq(zaawVar, zaawVar, zakVar);
        zaawVar.getClass();
        throw null;
    }
}
