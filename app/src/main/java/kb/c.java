package kb;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.query.QueryInfo;

/* compiled from: ScarInterstitialAd.java */
/* loaded from: classes2.dex */
public final class c extends a<InterstitialAd> {
    public c(Context context, QueryInfo queryInfo, bb.c cVar, com.unity3d.scar.adapter.common.c cVar2, com.unity3d.scar.adapter.common.e eVar) {
        super(context, cVar, queryInfo, cVar2);
        this.f15039d = new d(eVar, this);
    }

    @Override // kb.a
    public void loadAdInternal(AdRequest adRequest, bb.b bVar) {
        InterstitialAd.load(this.f15036a, this.f15037b.getAdUnitId(), adRequest, ((d) this.f15039d).getAdLoadListener());
    }

    @Override // bb.a
    public void show(Activity activity) {
        this.f15040e.handleError(com.unity3d.scar.adapter.common.b.AdNotLoadedError(this.f15037b));
    }
}
