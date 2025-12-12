package pb;

import android.content.Context;
import cb.d;
import cb.e;
import cb.f;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfo;

/* compiled from: SignalsCollector.java */
/* loaded from: classes2.dex */
public final class b extends e {

    /* renamed from: a, reason: collision with root package name */
    public final nb.a f17646a;

    public b(nb.a aVar) {
        this.f17646a = aVar;
    }

    @Override // cb.c
    public void getSCARSignal(Context context, String str, boolean z10, com.unity3d.scar.adapter.common.a aVar, f fVar) {
        QueryInfo.generate(context, z10 ? AdFormat.INTERSTITIAL : AdFormat.REWARDED, this.f17646a.buildAdRequest(), new a(str, new d(aVar, fVar)));
    }

    @Override // cb.c
    public void getSCARSignal(Context context, boolean z10, com.unity3d.scar.adapter.common.a aVar, f fVar) {
        getSCARSignal(context, z10 ? "gmaScarBiddingInterstitialSignal" : "gmaScarBiddingRewardedSignal", z10, aVar, fVar);
    }
}
