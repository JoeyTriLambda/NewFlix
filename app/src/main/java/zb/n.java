package zb;

import android.app.FragmentManager;
import flix.com.vision.App;
import flix.com.vision.activities.player.WebPlayerActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class n implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f22675b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ WebPlayerActivity f22676m;

    public /* synthetic */ n(WebPlayerActivity webPlayerActivity, int i10) {
        this.f22675b = i10;
        this.f22676m = webPlayerActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f22675b;
        WebPlayerActivity webPlayerActivity = this.f22676m;
        switch (i10) {
            case 0:
                if (!webPlayerActivity.S.isSeries()) {
                    App.getInstance().f11572t.checkInMovie(webPlayerActivity.S);
                    break;
                } else {
                    App.getInstance().f11572t.checkInEpisode(webPlayerActivity.S, webPlayerActivity.f12026m0);
                    break;
                }
            default:
                int i11 = WebPlayerActivity.f12013u0;
                FragmentManager fragmentManager = webPlayerActivity.getFragmentManager();
                kc.d dVarNewInstance = kc.d.newInstance(webPlayerActivity, false);
                dVarNewInstance.setTitle("Did you know?");
                dVarNewInstance.setCancelable(false);
                dVarNewInstance.setMessage("You can hide the server name and movie title at the top corner left from the settings");
                dVarNewInstance.setButton1("NO THANKS", new m(webPlayerActivity, 4));
                dVarNewInstance.setButton2("GO TO SETTINGS", new m(webPlayerActivity, 5));
                try {
                    dVarNewInstance.show(fragmentManager, "");
                } catch (Exception e10) {
                    webPlayerActivity.f12030q0 = false;
                    e10.printStackTrace();
                }
                o1.a.j(App.getInstance().f11574v, "pref_hide_watermark_tip", false);
                break;
        }
    }
}
