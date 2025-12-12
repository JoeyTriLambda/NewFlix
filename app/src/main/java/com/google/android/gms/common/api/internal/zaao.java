package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
final class zaao extends zaav {

    /* renamed from: m, reason: collision with root package name */
    public final Map<Api.Client, zaal> f7149m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ zaaw f7150n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaao(zaaw zaawVar, Map<Api.Client, zaal> map) {
        super(zaawVar);
        this.f7150n = zaawVar;
        this.f7149m = map;
    }

    @Override // com.google.android.gms.common.api.internal.zaav
    public final void zaa() {
        com.google.android.gms.signin.zae zaeVar;
        zaaw zaawVar = this.f7150n;
        zaawVar.getClass();
        com.google.android.gms.common.internal.zal zalVar = new com.google.android.gms.common.internal.zal(null);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Map<Api.Client, zaal> map = this.f7149m;
        for (Api.Client client : map.keySet()) {
            if (!client.requiresGooglePlayServices() || map.get(client).f7145c) {
                arrayList2.add(client);
            } else {
                arrayList.add(client);
            }
        }
        boolean zIsEmpty = arrayList.isEmpty();
        zaawVar.getClass();
        int iZab = -1;
        int i10 = 0;
        if (!zIsEmpty) {
            int size = arrayList.size();
            while (i10 < size) {
                iZab = zalVar.zab(null, (Api.Client) arrayList.get(i10));
                i10++;
                if (iZab != 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList2.size();
            while (i10 < size2) {
                iZab = zalVar.zab(null, (Api.Client) arrayList2.get(i10));
                i10++;
                if (iZab == 0) {
                    break;
                }
            }
        }
        zaawVar.getClass();
        if (iZab != 0) {
            new zaam(this, zaawVar, new ConnectionResult(iZab, null));
            throw null;
        }
        if (zaawVar.f7164g && (zaeVar = zaawVar.f7162e) != null) {
            zaeVar.zab();
        }
        for (Api.Client client2 : map.keySet()) {
            zaal zaalVar = map.get(client2);
            if (client2.requiresGooglePlayServices() && zalVar.zab(null, client2) != 0) {
                new zaan(zaawVar, zaalVar);
                throw null;
            }
            client2.connect(zaalVar);
        }
    }
}
