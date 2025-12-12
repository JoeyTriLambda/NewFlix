package xb;

import android.content.pm.PackageManager;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.leanback.MainActivityLeanback;
import java.util.Iterator;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f21728b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ MainActivityLeanback f21729m;

    public /* synthetic */ d(MainActivityLeanback mainActivityLeanback, int i10) {
        this.f21728b = i10;
        this.f21729m = mainActivityLeanback;
    }

    @Override // java.lang.Runnable
    public final void run() throws PackageManager.NameNotFoundException {
        String str;
        int i10 = this.f21728b;
        MainActivityLeanback mainActivityLeanback = this.f21729m;
        switch (i10) {
            case 0:
                int i11 = MainActivityLeanback.f11919g0;
                if (mainActivityLeanback.f()) {
                    mainActivityLeanback.d();
                    break;
                }
                break;
            case 1:
                int i12 = MainActivityLeanback.f11919g0;
                mainActivityLeanback.getClass();
                try {
                    str = mainActivityLeanback.getPackageManager().getPackageInfo(mainActivityLeanback.getPackageName(), 0).versionName + "";
                } catch (Exception e10) {
                    e10.printStackTrace();
                    str = "x.x.x";
                }
                if (!App.getInstance().f11574v.getBoolean(str, false)) {
                    App.getInstance().f11574v.edit().putInt(mainActivityLeanback.getString(R.string.start_count_label), 0).apply();
                    Iterator<String> it = App.B.iterator();
                    String strB = "";
                    while (it.hasNext()) {
                        strB = ac.c.B(strB, it.next());
                    }
                    kc.d dVarNewInstance = kc.d.newInstance(mainActivityLeanback, true);
                    dVarNewInstance.setTitle("v" + str + " Release Note");
                    dVarNewInstance.setMessage(strB);
                    dVarNewInstance.setMessageTextSize(18.0f);
                    dVarNewInstance.setButton1("GO IT", new e(mainActivityLeanback, 7));
                    try {
                        dVarNewInstance.setCancelable(true);
                        try {
                            dVarNewInstance.show(mainActivityLeanback.getFragmentManager(), "");
                        } catch (Exception e11) {
                            e11.printStackTrace();
                        }
                    } catch (Exception e12) {
                        e12.printStackTrace();
                    }
                    o1.a.j(App.getInstance().f11574v, str, true);
                    break;
                }
                break;
            case 2:
                if (!mainActivityLeanback.f11922c0.isFocused()) {
                    MainActivityLeanback.i(mainActivityLeanback.f11922c0, R.color.white);
                    mainActivityLeanback.f11922c0.setTextColor(mainActivityLeanback.getResources().getColor(R.color.color_grey));
                }
                if (!mainActivityLeanback.f11923d0.isFocused()) {
                    MainActivityLeanback.i(mainActivityLeanback.f11923d0, R.color.white);
                    mainActivityLeanback.f11923d0.setTextColor(mainActivityLeanback.getResources().getColor(R.color.color_grey));
                }
                if (!mainActivityLeanback.S.isFocused()) {
                    MainActivityLeanback.i(mainActivityLeanback.S, R.color.white);
                    mainActivityLeanback.S.setTextColor(mainActivityLeanback.getResources().getColor(R.color.color_grey));
                }
                if (!mainActivityLeanback.T.isFocused()) {
                    MainActivityLeanback.i(mainActivityLeanback.T, R.color.white);
                    mainActivityLeanback.T.setTextColor(mainActivityLeanback.getResources().getColor(R.color.color_grey));
                }
                if (!mainActivityLeanback.U.isFocused()) {
                    MainActivityLeanback.i(mainActivityLeanback.U, R.color.white);
                    mainActivityLeanback.U.setTextColor(mainActivityLeanback.getResources().getColor(R.color.color_grey));
                }
                if (!mainActivityLeanback.V.isFocused()) {
                    MainActivityLeanback.i(mainActivityLeanback.V, R.color.white);
                    mainActivityLeanback.V.setTextColor(mainActivityLeanback.getResources().getColor(R.color.color_grey));
                }
                if (!mainActivityLeanback.X.isFocused()) {
                    MainActivityLeanback.i(mainActivityLeanback.X, R.color.white);
                    mainActivityLeanback.X.setTextColor(mainActivityLeanback.getResources().getColor(R.color.color_grey));
                }
                if (!mainActivityLeanback.W.isFocused()) {
                    MainActivityLeanback.i(mainActivityLeanback.W, R.color.white);
                    mainActivityLeanback.W.setTextColor(mainActivityLeanback.getResources().getColor(R.color.color_grey));
                }
                if (!mainActivityLeanback.Y.isFocused()) {
                    MainActivityLeanback.i(mainActivityLeanback.Y, R.color.white);
                    mainActivityLeanback.Y.setTextColor(mainActivityLeanback.getResources().getColor(R.color.color_grey));
                }
                if (!mainActivityLeanback.f11921b0.isFocused()) {
                    MainActivityLeanback.i(mainActivityLeanback.f11921b0, R.color.white);
                    mainActivityLeanback.f11921b0.setTextColor(mainActivityLeanback.getResources().getColor(R.color.color_grey));
                }
                if (!mainActivityLeanback.Z.isFocused()) {
                    MainActivityLeanback.i(mainActivityLeanback.Z, R.color.white);
                    mainActivityLeanback.Z.setTextColor(mainActivityLeanback.getResources().getColor(R.color.color_grey));
                }
                if (!mainActivityLeanback.f11920a0.isFocused()) {
                    MainActivityLeanback.i(mainActivityLeanback.f11920a0, R.color.white);
                    mainActivityLeanback.f11920a0.setTextColor(mainActivityLeanback.getResources().getColor(R.color.color_grey));
                    break;
                }
                break;
            default:
                int i13 = MainActivityLeanback.f11919g0;
                mainActivityLeanback.getClass();
                try {
                    if (m0.a.checkSelfPermission(mainActivityLeanback, "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
                        l0.a.requestPermissions(mainActivityLeanback, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 10001);
                        break;
                    }
                } catch (Exception e13) {
                    e13.printStackTrace();
                    return;
                }
                break;
        }
    }
}
