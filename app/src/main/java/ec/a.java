package ec;

import android.os.Handler;
import android.os.Looper;
import flix.com.vision.api.realdebrid.RealDebridCommon;
import flix.com.vision.api.realdebrid.RealDebridLoginActivity;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11197b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ RealDebridLoginActivity f11198m;

    public /* synthetic */ a(RealDebridLoginActivity realDebridLoginActivity, int i10) {
        this.f11197b = i10;
        this.f11198m = realDebridLoginActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f11197b;
        RealDebridLoginActivity realDebridLoginActivity = this.f11198m;
        switch (i10) {
            case 0:
                realDebridLoginActivity.L.setText(realDebridLoginActivity.N);
                realDebridLoginActivity.K.setVisibility(8);
                realDebridLoginActivity.L.setVisibility(0);
                new Handler(Looper.getMainLooper()).postDelayed(new a(realDebridLoginActivity, 1), 5000L);
                break;
            case 1:
                int i11 = RealDebridLoginActivity.R;
                realDebridLoginActivity.getClass();
                new OkHttpClient().newCall(new Request.Builder().header("User-Agent", RealDebridCommon.f12055t).url(RealDebridCommon.f12052q + realDebridLoginActivity.M).build()).enqueue(new c(realDebridLoginActivity));
                break;
            default:
                int i12 = RealDebridLoginActivity.R;
                realDebridLoginActivity.getClass();
                new OkHttpClient().newCall(new Request.Builder().header("User-Agent", RealDebridCommon.f12055t).url(RealDebridCommon.f12054s).post(new FormBody.Builder().add("client_id", realDebridLoginActivity.O).add("client_secret", realDebridLoginActivity.P).add("code", realDebridLoginActivity.M).add("grant_type", "http://oauth.net/grant_type/device/1.0").build()).build()).enqueue(new d(realDebridLoginActivity));
                break;
        }
    }
}
