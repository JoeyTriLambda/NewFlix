package ob;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.interstitial.InterstitialAd;

/* compiled from: ScarInterstitialAd.java */
/* loaded from: classes2.dex */
public final class c extends a<InterstitialAd> {
    public c(Context context, nb.a aVar, bb.c cVar, com.unity3d.scar.adapter.common.c cVar2, com.unity3d.scar.adapter.common.e eVar) {
        super(context, cVar, aVar, cVar2);
        this.f17067d = new d(eVar, this);
    }

    @Override // ob.a
    public void loadAdInternal(AdRequest adRequest, bb.b bVar) {
        InterstitialAd.load(this.f17064a, this.f17065b.getAdUnitId(), adRequest, ((d) this.f17067d).getAdLoadListener());
    }

    @Override // bb.a
    public void show(Activity activity) {
        this.f17068e.handleError(com.unity3d.scar.adapter.common.b.AdNotLoadedError(this.f17065b));
    }
}
