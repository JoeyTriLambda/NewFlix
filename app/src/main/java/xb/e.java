package xb;

import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.DramaHomeActivity;
import flix.com.vision.activities.TraktActivity;
import flix.com.vision.activities.TraktSignInActivity;
import flix.com.vision.activities.WatchedAcvivity;
import flix.com.vision.activities.leanback.MainActivityLeanback;
import flix.com.vision.filepickerlibrary.FilePickerActivity;
import flix.com.vision.filepickerlibrary.enums.Request;
import flix.com.vision.filepickerlibrary.enums.ThemeType;
import flix.com.vision.tv.M3UImportActivity;
import flix.com.vision.tv.MyImportActivity;
import r.x;
import ub.q0;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f21730b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ MainActivityLeanback f21731m;

    public /* synthetic */ e(MainActivityLeanback mainActivityLeanback, int i10) {
        this.f21730b = i10;
        this.f21731m = mainActivityLeanback;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f21730b;
        MainActivityLeanback mainActivityLeanback = this.f21731m;
        switch (i10) {
            case 0:
                int i11 = MainActivityLeanback.f11919g0;
                mainActivityLeanback.finish();
                break;
            case 1:
                int i12 = MainActivityLeanback.f11919g0;
                FragmentManager fragmentManager = mainActivityLeanback.getFragmentManager();
                kc.d dVarNewInstance = kc.d.newInstance(mainActivityLeanback, false);
                dVarNewInstance.setloading();
                try {
                    dVarNewInstance.show(fragmentManager, "");
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                App.getInstance().loadRemoteConfig();
                new Handler().postDelayed(new x(22, mainActivityLeanback, dVarNewInstance), 5000L);
                break;
            case 2:
                int i13 = MainActivityLeanback.f11919g0;
                mainActivityLeanback.getClass();
                if (App.getInstance().f11573u.getWatchedMoviesFromDb().size() != 0) {
                    mainActivityLeanback.startActivity(new Intent(mainActivityLeanback, (Class<?>) WatchedAcvivity.class));
                    mainActivityLeanback.e(true);
                    break;
                } else {
                    be.d.makeToast(mainActivityLeanback, "No Item Marked As Watched Yet", false);
                    break;
                }
            case 3:
                int i14 = MainActivityLeanback.f11919g0;
                mainActivityLeanback.getClass();
                mainActivityLeanback.startActivity(new Intent(mainActivityLeanback, (Class<?>) DramaHomeActivity.class));
                break;
            case 4:
                int i15 = MainActivityLeanback.f11919g0;
                mainActivityLeanback.getClass();
                if (App.getInstance().f11574v.getBoolean("trakt_user_logged_in", false)) {
                    mainActivityLeanback.startActivity(new Intent(mainActivityLeanback, (Class<?>) TraktActivity.class));
                    break;
                } else {
                    FragmentManager fragmentManager2 = mainActivityLeanback.getFragmentManager();
                    kc.d dVarNewInstance2 = kc.d.newInstance(mainActivityLeanback, false);
                    dVarNewInstance2.setTitle(mainActivityLeanback.getString(R.string.trakt_tv_label));
                    dVarNewInstance2.setCancelable(false);
                    dVarNewInstance2.setMessage(mainActivityLeanback.getString(R.string.connect_with_trakt_tv_enjoy_benefits_mess));
                    dVarNewInstance2.setButton1("CANCEL", new q0(19));
                    dVarNewInstance2.setButton2(mainActivityLeanback.getString(R.string.action_sign_in), new e(mainActivityLeanback, 10));
                    try {
                        dVarNewInstance2.show(fragmentManager2, "");
                        break;
                    } catch (Exception e11) {
                        e11.printStackTrace();
                        return;
                    }
                }
            case 5:
                int i16 = MainActivityLeanback.f11919g0;
                FragmentManager fragmentManager3 = mainActivityLeanback.getFragmentManager();
                kc.d dVarNewInstance3 = kc.d.newInstance(mainActivityLeanback, true);
                dVarNewInstance3.setTitle("M3U Import");
                dVarNewInstance3.setMessage("How do you want to import your M3U Playlist?");
                dVarNewInstance3.setButton2("From File", new e(mainActivityLeanback, 8));
                dVarNewInstance3.setButton1("From URL", new e(mainActivityLeanback, 9));
                try {
                    dVarNewInstance3.show(fragmentManager3, "");
                    break;
                } catch (Exception e12) {
                    e12.printStackTrace();
                    return;
                }
            case 6:
                int i17 = MainActivityLeanback.f11919g0;
                mainActivityLeanback.getClass();
                mainActivityLeanback.startActivity(new Intent(mainActivityLeanback, (Class<?>) MyImportActivity.class));
                break;
            case 7:
                int i18 = MainActivityLeanback.f11919g0;
                mainActivityLeanback.getClass();
                new Handler().postDelayed(new d(mainActivityLeanback, 3), 1000L);
                break;
            case 8:
                int i19 = MainActivityLeanback.f11919g0;
                mainActivityLeanback.getClass();
                try {
                    if (m0.a.checkSelfPermission(mainActivityLeanback, "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
                        l0.a.requestPermissions(mainActivityLeanback, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1000);
                        break;
                    }
                } catch (Exception e13) {
                    e13.printStackTrace();
                }
                Intent intent = new Intent(mainActivityLeanback, (Class<?>) FilePickerActivity.class);
                intent.putExtra("themeType", ThemeType.DIALOG);
                intent.putExtra("request", Request.FILE);
                mainActivityLeanback.startActivityForResult(intent, 12345);
                break;
            case 9:
                int i20 = MainActivityLeanback.f11919g0;
                mainActivityLeanback.getClass();
                mainActivityLeanback.startActivity(new Intent(mainActivityLeanback, (Class<?>) M3UImportActivity.class));
                break;
            case 10:
                int i21 = MainActivityLeanback.f11919g0;
                mainActivityLeanback.getClass();
                mainActivityLeanback.startActivity(new Intent(mainActivityLeanback, (Class<?>) TraktSignInActivity.class));
                break;
            default:
                int i22 = MainActivityLeanback.f11919g0;
                mainActivityLeanback.getClass();
                mainActivityLeanback.startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:flix.com.vision")), 2000);
                break;
        }
    }
}
