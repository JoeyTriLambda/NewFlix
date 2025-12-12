package eb;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.unity3d.scar.adapter.common.f;

/* compiled from: ScarRewardedAd.java */
/* loaded from: classes2.dex */
public final class d extends a {

    /* renamed from: e, reason: collision with root package name */
    public final RewardedAd f11193e;

    /* renamed from: f, reason: collision with root package name */
    public final e f11194f;

    public d(Context context, QueryInfo queryInfo, bb.c cVar, com.unity3d.scar.adapter.common.c cVar2, f fVar) {
        super(context, cVar, queryInfo, cVar2);
        RewardedAd rewardedAd = new RewardedAd(this.f11186a, this.f11187b.getAdUnitId());
        this.f11193e = rewardedAd;
        this.f11194f = new e(rewardedAd, fVar);
    }

    @Override // eb.a
    public void loadAdInternal(bb.b bVar, AdRequest adRequest) {
        e eVar = this.f11194f;
        eVar.setLoadListener(bVar);
        this.f11193e.loadAd(adRequest, eVar.getRewardedAdLoadCallback());
    }

    @Override // bb.a
    public void show(Activity activity) {
        RewardedAd rewardedAd = this.f11193e;
        if (rewardedAd.isLoaded()) {
            rewardedAd.show(activity, this.f11194f.getRewardedAdCallback());
        } else {
            this.f11189d.handleError(com.unity3d.scar.adapter.common.b.AdNotLoadedError(this.f11187b));
        }
    }
}
