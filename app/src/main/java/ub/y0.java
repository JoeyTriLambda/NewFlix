package ub;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.activities.TraktSignInActivity;
import flix.com.vision.filepickerlibrary.FilePickerActivity;
import flix.com.vision.filepickerlibrary.enums.Request;
import flix.com.vision.filepickerlibrary.enums.ThemeType;
import flix.com.vision.tv.M3UImportActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class y0 implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20324b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ MainActivity f20325m;

    public /* synthetic */ y0(MainActivity mainActivity, int i10) {
        this.f20324b = i10;
        this.f20325m = mainActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f20324b;
        MainActivity mainActivity = this.f20325m;
        switch (i10) {
            case 0:
                int i11 = MainActivity.f11697v0;
                mainActivity.getClass();
                try {
                    if (m0.a.checkSelfPermission(mainActivity, "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
                        l0.a.requestPermissions(mainActivity, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1000);
                        break;
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                Intent intent = new Intent(mainActivity, (Class<?>) FilePickerActivity.class);
                intent.putExtra("themeType", ThemeType.DIALOG);
                intent.putExtra("request", Request.FILE);
                mainActivity.startActivityForResult(intent, 12345);
                break;
            case 1:
                int i12 = MainActivity.f11697v0;
                mainActivity.getClass();
                mainActivity.startActivity(new Intent(mainActivity, (Class<?>) M3UImportActivity.class));
                break;
            case 2:
                int i13 = MainActivity.f11697v0;
                mainActivity.getClass();
                mainActivity.startActivity(new Intent(mainActivity, (Class<?>) TraktSignInActivity.class));
                break;
            case 3:
                int i14 = MainActivity.f11697v0;
                mainActivity.getClass();
                MainActivity.resetFilter();
                mainActivity.finish();
                break;
            case 4:
                int i15 = MainActivity.f11697v0;
                mainActivity.getClass();
                mainActivity.startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:flix.com.vision")), 2000);
                break;
            default:
                int i16 = MainActivity.f11697v0;
                mainActivity.getClass();
                new Handler().postDelayed(new x0(mainActivity, 12), 1000L);
                break;
        }
    }
}
