package ub;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.google.android.material.internal.NavigationMenuView;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.tv.Constant;
import java.util.Iterator;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class x0 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20316b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ MainActivity f20317m;

    public /* synthetic */ x0(MainActivity mainActivity, int i10) {
        this.f20316b = i10;
        this.f20317m = mainActivity;
    }

    @Override // java.lang.Runnable
    public final void run() throws PackageManager.NameNotFoundException {
        String str;
        NavigationMenuView navigationMenuView;
        int i10 = this.f20316b;
        MainActivity mainActivity = this.f20317m;
        switch (i10) {
            case 0:
                int i11 = MainActivity.f11697v0;
                mainActivity.recreate();
                break;
            case 1:
                int i12 = MainActivity.f11697v0;
                mainActivity.recreate();
                break;
            case 2:
                mainActivity.f(mainActivity.f11702e0);
                break;
            case 3:
                int i13 = MainActivity.f11697v0;
                mainActivity.recreate();
                break;
            case 4:
                int i14 = MainActivity.f11697v0;
                mainActivity.recreate();
                break;
            case 5:
                mainActivity.f11711n0 = false;
                break;
            case 6:
                mainActivity.f11701d0.requestFocus();
                break;
            case 7:
                int i15 = MainActivity.f11697v0;
                mainActivity.getClass();
                SharedPreferences sharedPreferences = App.getInstance().f11574v;
                String str2 = Constant.f12450b;
                int i16 = sharedPreferences.getInt("app_start_count", 0) + 1;
                App.getInstance().f11574v.edit().putInt("app_start_count", i16).apply();
                if (i16 >= 11 && !App.getInstance().f11574v.getBoolean("twitter_check", false)) {
                    mainActivity.j();
                }
                if (i16 >= 16 && !App.getInstance().f11574v.getBoolean("discord_check", false)) {
                    mainActivity.h();
                    break;
                }
                break;
            case 8:
                int i17 = MainActivity.f11697v0;
                mainActivity.getClass();
                try {
                    str = mainActivity.getPackageManager().getPackageInfo(mainActivity.getPackageName(), 0).versionName + "";
                } catch (Exception e10) {
                    e10.printStackTrace();
                    str = "x.x.x";
                }
                if (!App.getInstance().f11574v.getBoolean(str, false)) {
                    App.getInstance().f11574v.edit().putInt(mainActivity.getString(R.string.start_count_label), 0).apply();
                    Iterator<String> it = App.B.iterator();
                    String strB = "";
                    while (it.hasNext()) {
                        strB = ac.c.B(strB, it.next());
                    }
                    kc.d dVarNewInstance = kc.d.newInstance(mainActivity, true);
                    dVarNewInstance.setTitle("v" + str + " Release Note");
                    dVarNewInstance.setMessage(strB);
                    dVarNewInstance.setMessageTextSize(18.0f);
                    dVarNewInstance.setButton1("GO IT", new y0(mainActivity, 5));
                    try {
                        dVarNewInstance.setCancelable(true);
                        try {
                            dVarNewInstance.show(mainActivity.getFragmentManager(), "");
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
            case 9:
                int i18 = MainActivity.f11697v0;
                mainActivity.askToUpdateIfAny(false, null);
                break;
            case 10:
                int i19 = MainActivity.f11697v0;
                mainActivity.getClass();
                try {
                    int i20 = App.getInstance().f11574v.getInt("actual_menu_index", 1);
                    l7.c cVar = mainActivity.X;
                    if (cVar != null) {
                        cVar.getMenu().getItem(i20).setChecked(true);
                        break;
                    }
                } catch (Exception e13) {
                    e13.printStackTrace();
                    return;
                }
                break;
            case 11:
                int i21 = MainActivity.f11697v0;
                mainActivity.getClass();
                try {
                    l7.c cVar2 = mainActivity.X;
                    if (cVar2 != null && (navigationMenuView = (NavigationMenuView) cVar2.getChildAt(0)) != null) {
                        navigationMenuView.setVerticalScrollBarEnabled(false);
                        break;
                    }
                } catch (Exception e14) {
                    e14.printStackTrace();
                }
                break;
            default:
                int i22 = MainActivity.f11697v0;
                mainActivity.getClass();
                try {
                    if (m0.a.checkSelfPermission(mainActivity, "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
                        l0.a.requestPermissions(mainActivity, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 10001);
                        break;
                    }
                } catch (Exception e15) {
                    e15.printStackTrace();
                    return;
                }
                break;
        }
    }
}
