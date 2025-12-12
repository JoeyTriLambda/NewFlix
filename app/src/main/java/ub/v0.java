package ub;

import android.content.SharedPreferences;
import android.os.Build;
import android.view.View;
import android.widget.Toast;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.models.Movie;
import flix.com.vision.tv.Constant;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class v0 implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20296b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ MainActivity f20297m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ kc.d f20298n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Movie f20299o;

    public /* synthetic */ v0(MainActivity mainActivity, kc.d dVar, Movie movie, int i10) {
        this.f20296b = i10;
        this.f20297m = mainActivity;
        this.f20298n = dVar;
        this.f20299o = movie;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f20296b;
        Movie movie = this.f20299o;
        kc.d dVar = this.f20298n;
        MainActivity mainActivity = this.f20297m;
        switch (i10) {
            case 0:
                int i11 = MainActivity.f11697v0;
                mainActivity.getClass();
                dVar.dismiss();
                if (movie != null) {
                    mainActivity.openMovieintent(movie);
                    break;
                }
                break;
            case 1:
                int i12 = MainActivity.f11697v0;
                mainActivity.getClass();
                dVar.dismiss();
                if (m0.a.checkSelfPermission(mainActivity, "android.permission.WRITE_EXTERNAL_STORAGE") != -1) {
                    if (Build.VERSION.SDK_INT >= 26 && !mainActivity.getPackageManager().canRequestPackageInstalls()) {
                        dVar.dismiss();
                        kc.d dVarNewInstance = kc.d.newInstance(mainActivity, true);
                        dVarNewInstance.setTitle("Grant install Permission");
                        dVarNewInstance.setMessage("Please grant the Permission to install the Update");
                        dVarNewInstance.setButton1("Cancel", new z0(dVarNewInstance, 5));
                        dVarNewInstance.setButton2("OK", new y0(mainActivity, 4));
                        dVarNewInstance.show(mainActivity.getFragmentManager(), "");
                        break;
                    } else {
                        SharedPreferences sharedPreferences = App.getInstance().f11574v;
                        String str = Constant.f12450b;
                        String string = sharedPreferences.getString("update_url", null);
                        if (string != null) {
                            String str2 = App.K ? ", Or use the Downloader Code: 108545" : "";
                            kc.d dVarNewInstance2 = kc.d.newInstance(mainActivity, true);
                            dVarNewInstance2.setMessage("You can't update if you are using a modded/pirated version of FlixVision. Please always use the official version on our webpage (flixvision.tv)".concat(str2));
                            dVarNewInstance2.setTitle("Warning!");
                            dVarNewInstance2.setButton1("CANCEL", new v0(mainActivity, dVarNewInstance2, movie, 2));
                            dVarNewInstance2.setButton2("DOWNLOAD UPDATE", new v(1, mainActivity, string));
                            dVarNewInstance2.show(mainActivity.getFragmentManager(), "");
                            break;
                        }
                    }
                } else {
                    Toast.makeText(mainActivity.getBaseContext(), mainActivity.getString(R.string.please_grant_permissions_label), 1).show();
                    l0.a.requestPermissions(mainActivity, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1000);
                    break;
                }
                break;
            default:
                int i13 = MainActivity.f11697v0;
                mainActivity.getClass();
                dVar.dismiss();
                mainActivity.openMovieintent(movie);
                break;
        }
    }
}
