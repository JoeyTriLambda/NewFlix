package hb;

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
    public final InterstitialAd f12961e;

    /* renamed from: f, reason: collision with root package name */
    public final c f12962f;

    public b(Context context, QueryInfo queryInfo, bb.c cVar, com.unity3d.scar.adapter.common.c cVar2, com.unity3d.scar.adapter.common.e eVar) {
        super(context, cVar, queryInfo, cVar2);
        InterstitialAd interstitialAd = new InterstitialAd(this.f12957a);
        this.f12961e = interstitialAd;
        interstitialAd.setAdUnitId(this.f12958b.getAdUnitId());
        this.f12962f = new c(interstitialAd, eVar);
    }

    @Override // hb.a
    public void loadAdInternal(bb.b bVar, AdRequest adRequest) {
        c cVar = this.f12962f;
        AdListener adListener = cVar.getAdListener();
        InterstitialAd interstitialAd = this.f12961e;
        interstitialAd.setAdListener(adListener);
        cVar.setLoadListener(bVar);
        interstitialAd.loadAd(adRequest);
    }

    @Override // bb.a
    public void show(Activity activity) {
        InterstitialAd interstitialAd = this.f12961e;
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            this.f12960d.handleError(com.unity3d.scar.adapter.common.b.AdNotLoadedError(this.f12958b));
        }
    }
}
