package eb;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.query.QueryInfo;

/* compiled from: ScarInterstitialAd.java */
/* loaded from: classes2.dex */
public final class b extends a {

    /* renamed from: e, reason: collision with root package name */
    public final InterstitialAd f11190e;

    /* renamed from: f, reason: collision with root package name */
    public final c f11191f;

    public b(Context context, QueryInfo queryInfo, bb.c cVar, com.unity3d.scar.adapter.common.c cVar2, com.unity3d.scar.adapter.common.e eVar) {
        super(context, cVar, queryInfo, cVar2);
        InterstitialAd interstitialAd = new InterstitialAd(this.f11186a);
        this.f11190e = interstitialAd;
        interstitialAd.setAdUnitId(this.f11187b.getAdUnitId());
        this.f11191f = new c(interstitialAd, eVar);
    }

    @Override // eb.a
    public void loadAdInternal(bb.b bVar, AdRequest adRequest) {
        c cVar = this.f11191f;
        AdListener adListener = cVar.getAdListener();
        InterstitialAd interstitialAd = this.f11190e;
        interstitialAd.setAdListener(adListener);
        cVar.setLoadListener(bVar);
        interstitialAd.loadAd(adRequest);
    }

    @Override // bb.a
    public void show(Activity activity) {
        InterstitialAd interstitialAd = this.f11190e;
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            this.f11189d.handleError(com.unity3d.scar.adapter.common.b.AdNotLoadedError(this.f11187b));
        }
    }
}
