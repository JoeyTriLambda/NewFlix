package xb;

import android.content.SharedPreferences;
import android.os.Build;
import android.view.View;
import android.widget.Toast;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.leanback.MainActivityLeanback;
import flix.com.vision.models.Movie;
import flix.com.vision.tv.Constant;
import ub.v;
import ub.z0;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f21732b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ MainActivityLeanback f21733m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ kc.d f21734n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Movie f21735o;

    public /* synthetic */ f(MainActivityLeanback mainActivityLeanback, kc.d dVar, Movie movie, int i10) {
        this.f21732b = i10;
        this.f21733m = mainActivityLeanback;
        this.f21734n = dVar;
        this.f21735o = movie;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f21732b;
        Movie movie = this.f21735o;
        kc.d dVar = this.f21734n;
        MainActivityLeanback mainActivityLeanback = this.f21733m;
        switch (i10) {
            case 0:
                int i11 = MainActivityLeanback.f11919g0;
                mainActivityLeanback.getClass();
                dVar.dismiss();
                if (movie != null) {
                    mainActivityLeanback.h(movie);
                    break;
                }
                break;
            case 1:
                int i12 = MainActivityLeanback.f11919g0;
                mainActivityLeanback.getClass();
                dVar.dismiss();
                if (m0.a.checkSelfPermission(mainActivityLeanback, "android.permission.WRITE_EXTERNAL_STORAGE") != -1) {
                    if (Build.VERSION.SDK_INT >= 26 && !mainActivityLeanback.getPackageManager().canRequestPackageInstalls()) {
                        dVar.dismiss();
                        kc.d dVarNewInstance = kc.d.newInstance(mainActivityLeanback, true);
                        dVarNewInstance.setTitle("Grant install Permission");
                        dVarNewInstance.setMessage("Please grant the Permission to install the Update");
                        dVarNewInstance.setButton1("Cancel", new z0(dVarNewInstance, 8));
                        dVarNewInstance.setButton2("OK", new e(mainActivityLeanback, 11));
                        dVarNewInstance.show(mainActivityLeanback.getFragmentManager(), "");
                        break;
                    } else {
                        SharedPreferences sharedPreferences = App.getInstance().f11574v;
                        String str = Constant.f12450b;
                        String string = sharedPreferences.getString("update_url", null);
                        if (string != null) {
                            String str2 = App.K ? ", Or use the Downloader Code: 108545" : "";
                            kc.d dVarNewInstance2 = kc.d.newInstance(mainActivityLeanback, true);
                            dVarNewInstance2.setMessage("You can't update if you are using a modded/pirated version of FlixVision. Please always use the official version on our webpage (flixvision.tv)".concat(str2));
                            dVarNewInstance2.setTitle("Warning!");
                            dVarNewInstance2.setButton1("CANCEL", new f(mainActivityLeanback, dVarNewInstance2, movie, 2));
                            dVarNewInstance2.setButton2("DOWNLOAD UPDATE", new v(6, mainActivityLeanback, string));
                            dVarNewInstance2.show(mainActivityLeanback.getFragmentManager(), "");
                            break;
                        }
                    }
                } else {
                    Toast.makeText(mainActivityLeanback.getBaseContext(), mainActivityLeanback.getString(R.string.please_grant_permissions_label), 1).show();
                    l0.a.requestPermissions(mainActivityLeanback, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1000);
                    break;
                }
                break;
            default:
                int i13 = MainActivityLeanback.f11919g0;
                mainActivityLeanback.getClass();
                dVar.dismiss();
                mainActivityLeanback.h(movie);
                break;
        }
    }
}
