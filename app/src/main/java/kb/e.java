package kb;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.rewarded.RewardedAd;

/* compiled from: ScarRewardedAd.java */
/* loaded from: classes2.dex */
public final class e extends a<RewardedAd> {
    public e(Context context, QueryInfo queryInfo, bb.c cVar, com.unity3d.scar.adapter.common.c cVar2, com.unity3d.scar.adapter.common.f fVar) {
        super(context, cVar, queryInfo, cVar2);
        this.f15039d = new f(fVar, this);
    }

    @Override // kb.a
    public void loadAdInternal(AdRequest adRequest, bb.b bVar) {
        RewardedAd.load(this.f15036a, this.f15037b.getAdUnitId(), adRequest, ((f) this.f15039d).getAdLoadListener());
    }

    @Override // bb.a
    public void show(Activity activity) {
        this.f15040e.handleError(com.unity3d.scar.adapter.common.b.AdNotLoadedError(this.f15037b));
    }
}
