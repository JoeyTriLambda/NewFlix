package ub;

import android.content.DialogInterface;
import flix.com.vision.App;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.activities.SearchActivityTV;
import flix.com.vision.activities.SettingsActivity;
import flix.com.vision.activities.TraktTvConfigActivity;
import flix.com.vision.activities.leanback.MainActivityLeanback;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class t0 implements DialogInterface.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20276b;

    public /* synthetic */ t0(int i10) {
        this.f20276b = i10;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        switch (this.f20276b) {
            case 0:
                int i11 = MainActivity.f11697v0;
                dialogInterface.dismiss();
                App.getInstance().f11572t.syncUserHistoryWithTrakt();
                break;
            case 1:
                int i12 = MainActivity.f11697v0;
                dialogInterface.dismiss();
                break;
            case 2:
                int i13 = MainActivity.f11697v0;
                dialogInterface.dismiss();
                break;
            case 3:
                int i14 = MainActivity.b.f11720e;
                dialogInterface.dismiss();
                break;
            case 4:
                int i15 = SearchActivityTV.b.f11785e;
                dialogInterface.dismiss();
                break;
            case 5:
                int i16 = SettingsActivity.f11809o2;
                dialogInterface.dismiss();
                break;
            case 6:
                int i17 = TraktTvConfigActivity.f11876a0;
                dialogInterface.dismiss();
                break;
            default:
                int i18 = MainActivityLeanback.a.f11926f;
                dialogInterface.dismiss();
                break;
        }
    }
}
