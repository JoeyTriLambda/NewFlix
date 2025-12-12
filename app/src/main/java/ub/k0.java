package ub;

import android.content.Intent;
import android.view.View;
import com.github.ybq.android.spinkit.SpinKitView;
import flix.com.vision.activities.LinksActivity;
import flix.com.vision.activities.SettingsActivity;
import flix.com.vision.helpers.Constants;
import org.greenrobot.eventbus.EventBus;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class k0 implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20216b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ LinksActivity f20217m;

    public /* synthetic */ k0(LinksActivity linksActivity, int i10) {
        this.f20216b = i10;
        this.f20217m = linksActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f20216b;
        LinksActivity linksActivity = this.f20217m;
        switch (i10) {
            case 0:
                int i11 = LinksActivity.C0;
                linksActivity.getClass();
                linksActivity.startActivity(new Intent(linksActivity, (Class<?>) SettingsActivity.class));
                break;
            case 1:
            default:
                int i12 = LinksActivity.C0;
                linksActivity.finish();
                linksActivity.startActivity(linksActivity.getIntent());
                break;
            case 2:
                int i13 = LinksActivity.C0;
                linksActivity.getClass();
                linksActivity.startActivity(new Intent(linksActivity, (Class<?>) SettingsActivity.class));
                break;
            case 3:
                int i14 = LinksActivity.C0;
                linksActivity.getClass();
                EventBus.getDefault().post(new Constants.a());
                SpinKitView spinKitView = linksActivity.S;
                if (spinKitView != null) {
                    spinKitView.setVisibility(8);
                }
                linksActivity.N.setVisibility(8);
                break;
            case 4:
                int i15 = LinksActivity.C0;
                linksActivity.finish();
                linksActivity.startActivity(linksActivity.getIntent());
                break;
        }
    }
}
