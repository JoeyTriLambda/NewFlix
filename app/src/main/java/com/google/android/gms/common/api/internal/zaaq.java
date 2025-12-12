package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zaaq extends zabg {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zaaw f7153b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.signin.internal.zak f7154c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaaq(zaaw zaawVar, zaaw zaawVar2, com.google.android.gms.signin.internal.zak zakVar) {
        super(zaawVar);
        this.f7153b = zaawVar2;
        this.f7154c = zakVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabg
    public final void zaa() {
        zaaw zaawVar = this.f7153b;
        boolean z10 = false;
        if (zaawVar.g(0)) {
            com.google.android.gms.signin.internal.zak zakVar = this.f7154c;
            ConnectionResult connectionResultZaa = zakVar.zaa();
            if (!connectionResultZaa.isSuccess()) {
                if (zaawVar.f7163f && !connectionResultZaa.hasResolution()) {
                    z10 = true;
                }
                if (!z10) {
                    zaawVar.d(connectionResultZaa);
                    return;
                } else {
                    zaawVar.a();
                    zaawVar.f();
                    return;
                }
            }
            com.google.android.gms.common.internal.zav zavVar = (com.google.android.gms.common.internal.zav) Preconditions.checkNotNull(zakVar.zab());
            ConnectionResult connectionResultZaa2 = zavVar.zaa();
            if (!connectionResultZaa2.isSuccess()) {
                String strValueOf = String.valueOf(connectionResultZaa2);
                Log.wtf("GACConnecting", "Sign-in succeeded with resolve account failure: ".concat(strValueOf), new Exception());
                zaawVar.d(connectionResultZaa2);
                return;
            }
            zaawVar.f7165h = true;
            zaawVar.f7166i = (IAccountAccessor) Preconditions.checkNotNull(zavVar.zab());
            zaawVar.f7167j = zavVar.zac();
            zaawVar.f7168k = zavVar.zad();
            zaawVar.f();
        }
    }
}
