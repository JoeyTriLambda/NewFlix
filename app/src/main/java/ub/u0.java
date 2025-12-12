package ub;

import android.content.DialogInterface;
import android.content.Intent;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.activities.TraktTvConfigActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class u0 implements DialogInterface.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20287b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ MainActivity f20288m;

    public /* synthetic */ u0(MainActivity mainActivity, int i10) {
        this.f20287b = i10;
        this.f20288m = mainActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        int i11 = this.f20287b;
        MainActivity mainActivity = this.f20288m;
        switch (i11) {
            case 0:
                int i12 = MainActivity.f11697v0;
                mainActivity.getClass();
                dialogInterface.dismiss();
                mainActivity.startActivity(new Intent(mainActivity, (Class<?>) TraktTvConfigActivity.class));
                break;
            default:
                int i13 = MainActivity.f11697v0;
                mainActivity.getClass();
                dialogInterface.dismiss();
                Intent launchIntentForPackage = mainActivity.getBaseContext().getPackageManager().getLaunchIntentForPackage(mainActivity.getBaseContext().getPackageName());
                launchIntentForPackage.addFlags(67108864);
                mainActivity.startActivity(launchIntentForPackage);
                break;
        }
    }
}
