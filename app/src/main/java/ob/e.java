package ob;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.rewarded.RewardedAd;

/* compiled from: ScarRewardedAd.java */
/* loaded from: classes2.dex */
public final class e extends a<RewardedAd> {
    public e(Context context, nb.a aVar, bb.c cVar, com.unity3d.scar.adapter.common.c cVar2, com.unity3d.scar.adapter.common.f fVar) {
        super(context, cVar, aVar, cVar2);
        this.f17067d = new f(fVar, this);
    }

    @Override // ob.a
    public void loadAdInternal(AdRequest adRequest, bb.b bVar) {
        RewardedAd.load(this.f17064a, this.f17065b.getAdUnitId(), adRequest, ((f) this.f17067d).getAdLoadListener());
    }

    @Override // bb.a
    public void show(Activity activity) {
        this.f17068e.handleError(com.unity3d.scar.adapter.common.b.AdNotLoadedError(this.f17065b));
    }
}
