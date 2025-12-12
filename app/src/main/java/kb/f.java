package kb;

import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

/* compiled from: ScarRewardedAdListener.java */
/* loaded from: classes2.dex */
public final class f extends kb.b {

    /* renamed from: a, reason: collision with root package name */
    public final a f15042a = new a();

    /* compiled from: ScarRewardedAdListener.java */
    public class a extends RewardedAdLoadCallback {
    }

    /* compiled from: ScarRewardedAdListener.java */
    public class b implements OnUserEarnedRewardListener {
    }

    /* compiled from: ScarRewardedAdListener.java */
    public class c extends FullScreenContentCallback {
    }

    public f(com.unity3d.scar.adapter.common.f fVar, e eVar) {
        new b();
        new c();
    }

    public RewardedAdLoadCallback getAdLoadListener() {
        return this.f15042a;
    }
}
