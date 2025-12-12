package zb;

import android.content.Intent;
import android.view.View;
import flix.com.vision.App;
import flix.com.vision.activities.SettingsActivity;
import flix.com.vision.activities.player.WebPlayerActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f22673b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ WebPlayerActivity f22674m;

    public /* synthetic */ m(WebPlayerActivity webPlayerActivity, int i10) {
        this.f22673b = i10;
        this.f22674m = webPlayerActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f22673b;
        WebPlayerActivity webPlayerActivity = this.f22674m;
        switch (i10) {
            case 0:
                webPlayerActivity.f12030q0 = false;
                break;
            case 1:
                int i11 = WebPlayerActivity.f12013u0;
                webPlayerActivity.getClass();
                try {
                    App.getInstance().f11572t.removeActiveCheckin();
                    webPlayerActivity.T.removeCallbacks(webPlayerActivity.U);
                    webPlayerActivity.finish();
                    webPlayerActivity.f12030q0 = false;
                    break;
                } catch (Exception unused) {
                    webPlayerActivity.finish();
                    return;
                }
            case 2:
                webPlayerActivity.f12030q0 = false;
                break;
            case 3:
                webPlayerActivity.f12030q0 = false;
                break;
            case 4:
                webPlayerActivity.f12030q0 = false;
                break;
            default:
                webPlayerActivity.f12031r0 = true;
                webPlayerActivity.startActivity(new Intent(webPlayerActivity, (Class<?>) SettingsActivity.class));
                break;
        }
    }
}
