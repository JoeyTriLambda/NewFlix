package hb;

import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.unity3d.scar.adapter.common.f;

/* compiled from: ScarRewardedAdListener.java */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final a f12966a = new a();

    /* renamed from: b, reason: collision with root package name */
    public final b f12967b = new b();

    /* compiled from: ScarRewardedAdListener.java */
    public class a extends RewardedAdLoadCallback {
    }

    /* compiled from: ScarRewardedAdListener.java */
    public class b extends RewardedAdCallback {
    }

    public e(RewardedAd rewardedAd, f fVar) {
    }

    public RewardedAdCallback getRewardedAdCallback() {
        return this.f12967b;
    }

    public RewardedAdLoadCallback getRewardedAdLoadCallback() {
        return this.f12966a;
    }

    public void setLoadListener(bb.b bVar) {
    }
}
