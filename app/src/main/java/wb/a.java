package wb;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import flix.com.vision.App;
import flix.com.vision.helpers.Constants;
import r.j;

/* compiled from: BaseActivity.java */
/* loaded from: classes2.dex */
public abstract class a extends j implements IUnityAdsInitializationListener {

    /* compiled from: BaseActivity.java */
    /* renamed from: wb.a$a, reason: collision with other inner class name */
    public class C0307a implements IUnityAdsShowListener {
        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowClick(String str) {
            Log.v("UnityAdsExample", "onUnityAdsShowClick: " + str);
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
            Log.v("UnityAdsExample", "onUnityAdsShowComplete: " + str);
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
            Log.e("UnityAdsExample", "Unity Ads failed to show ad for " + str + " with error: [" + unityAdsShowError + "] " + str2);
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowStart(String str) {
            Log.v("UnityAdsExample", "onUnityAdsShowStart: " + str);
        }
    }

    public a() {
        new C0307a();
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (App.getInstance().f11574v.getBoolean("show_unity_ads", true)) {
            Context applicationContext = getApplicationContext();
            String str = Constants.f12319a;
            UnityAds.initialize(applicationContext, "5218941", true, this);
        }
    }

    @Override // r.j, androidx.fragment.app.p, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        try {
            super.onResume();
        } catch (Exception unused) {
        }
        requestAndDisplayAd();
    }

    public void Show() {
    }

    @Override // com.unity3d.ads.IUnityAdsInitializationListener
    public void onInitializationComplete() {
    }

    public void requestAndDisplayAd() {
    }

    @Override // com.unity3d.ads.IUnityAdsInitializationListener
    public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
    }
}
