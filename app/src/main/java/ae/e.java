package ae;

import android.app.FragmentManager;
import android.content.Intent;
import android.view.View;
import flix.com.vision.filepickerlibrary.FilePickerActivity;
import flix.com.vision.filepickerlibrary.enums.Request;
import flix.com.vision.filepickerlibrary.enums.ThemeType;
import flix.com.vision.tv.M3UImportActivity;
import flix.com.vision.tv.MyImportActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f645b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ MyImportActivity f646m;

    public /* synthetic */ e(MyImportActivity myImportActivity, int i10) {
        this.f645b = i10;
        this.f646m = myImportActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f645b;
        MyImportActivity myImportActivity = this.f646m;
        switch (i10) {
            case 0:
                int i11 = MyImportActivity.P;
                FragmentManager fragmentManager = myImportActivity.getFragmentManager();
                kc.d dVarNewInstance = kc.d.newInstance(myImportActivity, true);
                dVarNewInstance.setTitle("M3U Import");
                dVarNewInstance.setMessage("How do you want to import your M3U Playlist?");
                dVarNewInstance.setButton2("From File", new e(myImportActivity, 1));
                dVarNewInstance.setButton1("From URL", new e(myImportActivity, 2));
                try {
                    dVarNewInstance.show(fragmentManager, "");
                    break;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return;
                }
            case 1:
                int i12 = MyImportActivity.P;
                myImportActivity.getClass();
                try {
                    if (m0.a.checkSelfPermission(myImportActivity, "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
                        l0.a.requestPermissions(myImportActivity, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1000);
                        break;
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                Intent intent = new Intent(myImportActivity, (Class<?>) FilePickerActivity.class);
                intent.putExtra("themeType", ThemeType.DIALOG);
                intent.putExtra("request", Request.FILE);
                myImportActivity.startActivityForResult(intent, 12345);
                break;
            default:
                int i13 = MyImportActivity.P;
                myImportActivity.getClass();
                myImportActivity.startActivity(new Intent(myImportActivity, (Class<?>) M3UImportActivity.class));
                break;
        }
    }
}
