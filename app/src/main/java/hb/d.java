package hb;

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
    public final RewardedAd f12964e;

    /* renamed from: f, reason: collision with root package name */
    public final e f12965f;

    public d(Context context, QueryInfo queryInfo, bb.c cVar, com.unity3d.scar.adapter.common.c cVar2, f fVar) {
        super(context, cVar, queryInfo, cVar2);
        RewardedAd rewardedAd = new RewardedAd(this.f12957a, this.f12958b.getAdUnitId());
        this.f12964e = rewardedAd;
        this.f12965f = new e(rewardedAd, fVar);
    }

    @Override // hb.a
    public void loadAdInternal(bb.b bVar, AdRequest adRequest) {
        e eVar = this.f12965f;
        eVar.setLoadListener(bVar);
        this.f12964e.loadAd(adRequest, eVar.getRewardedAdLoadCallback());
    }

    @Override // bb.a
    public void show(Activity activity) {
        RewardedAd rewardedAd = this.f12964e;
        if (rewardedAd.isLoaded()) {
            rewardedAd.show(activity, this.f12965f.getRewardedAdCallback());
        } else {
            this.f12960d.handleError(com.unity3d.scar.adapter.common.b.AdNotLoadedError(this.f12958b));
        }
    }
}
