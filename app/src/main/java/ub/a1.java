package ub;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import flix.com.vision.App;
import flix.com.vision.activities.MainActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class a1 implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20148b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ MainActivity f20149m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ kc.d f20150n;

    public /* synthetic */ a1(MainActivity mainActivity, kc.d dVar, int i10) {
        this.f20148b = i10;
        this.f20149m = mainActivity;
        this.f20150n = dVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f20148b;
        kc.d dVar = this.f20150n;
        MainActivity mainActivity = this.f20149m;
        switch (i10) {
            case 0:
                int i11 = MainActivity.f11697v0;
                mainActivity.getClass();
                dVar.dismiss();
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("https://twitter.com/FlixVisionApp"));
                    mainActivity.startActivity(intent);
                    break;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return;
                }
            case 1:
                int i12 = MainActivity.f11697v0;
                mainActivity.getClass();
                dVar.dismiss();
                if (!App.getInstance().f11573u.clearFavorites()) {
                    Toast.makeText(mainActivity.getBaseContext(), "An error occurred", 0).show();
                    break;
                } else {
                    Toast.makeText(mainActivity.getBaseContext(), "Favorites cleared", 0).show();
                    mainActivity.recreate();
                    break;
                }
            case 2:
                int i13 = MainActivity.f11697v0;
                mainActivity.getClass();
                dVar.dismiss();
                try {
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setData(Uri.parse("https://discord.gg/tKjc4PTvxu"));
                    mainActivity.startActivity(intent2);
                    break;
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            default:
                int i14 = MainActivity.f11697v0;
                mainActivity.getClass();
                dVar.dismiss();
                if (!App.getInstance().f11573u.clearHistory()) {
                    Toast.makeText(mainActivity.getBaseContext(), "An error occurred", 0).show();
                    break;
                } else {
                    Toast.makeText(mainActivity.getBaseContext(), "History cleared", 0).show();
                    mainActivity.recreate();
                    break;
                }
        }
    }
}
