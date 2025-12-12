package ob;

import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

/* compiled from: ScarInterstitialAdListener.java */
/* loaded from: classes2.dex */
public final class d extends ob.b {

    /* renamed from: a, reason: collision with root package name */
    public final a f17069a = new a();

    /* compiled from: ScarInterstitialAdListener.java */
    public class a extends InterstitialAdLoadCallback {
    }

    /* compiled from: ScarInterstitialAdListener.java */
    public class b extends FullScreenContentCallback {
    }

    public d(com.unity3d.scar.adapter.common.e eVar, c cVar) {
        new b();
    }

    public InterstitialAdLoadCallback getAdLoadListener() {
        return this.f17069a;
    }
}
