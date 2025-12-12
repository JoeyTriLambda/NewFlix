package nb;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;

/* compiled from: AdRequestFactory.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final ab.a f16783a;

    public a(ab.a aVar) {
        this.f16783a = aVar;
    }

    public AdRequest buildAdRequest() {
        return getAdRequest().build();
    }

    public AdRequest buildAdRequestWithAdString(String str) {
        return getAdRequest().setAdString(str).build();
    }

    public AdRequest.Builder getAdRequest() {
        AdRequest.Builder builder = new AdRequest.Builder();
        ab.a aVar = this.f16783a;
        return builder.setRequestAgent(aVar.getVersionName()).addNetworkExtrasBundle(AdMobAdapter.class, aVar.getExtras());
    }
}
