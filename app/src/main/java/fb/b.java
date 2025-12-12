package fb;

import android.content.Context;
import cb.d;
import cb.e;
import cb.f;
import cb.g;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;

/* compiled from: SignalsCollector.java */
/* loaded from: classes2.dex */
public final class b extends e {

    /* renamed from: a, reason: collision with root package name */
    public final g<QueryInfo> f11532a;

    public b(g<QueryInfo> gVar) {
        this.f11532a = gVar;
    }

    @Override // cb.c
    public void getSCARSignal(Context context, String str, boolean z10, com.unity3d.scar.adapter.common.a aVar, f fVar) {
        QueryInfo.generate(context, z10 ? AdFormat.INTERSTITIAL : AdFormat.REWARDED, new AdRequest.Builder().build(), new a(str, new d(aVar, this.f11532a, fVar)));
    }

    @Override // cb.c
    public void getSCARSignal(Context context, boolean z10, com.unity3d.scar.adapter.common.a aVar, f fVar) {
        onOperationNotSupported("GMA v1920 - SCAR signal retrieval required a placementId", aVar, fVar);
    }
}
