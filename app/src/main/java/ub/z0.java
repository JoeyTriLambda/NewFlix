package ub;

import android.graphics.Typeface;
import android.view.View;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.activities.SearchActivityTV;
import flix.com.vision.activities.SettingsActivity;
import flix.com.vision.activities.leanback.MainActivityLeanback;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class z0 implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20333b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ kc.d f20334m;

    public /* synthetic */ z0(kc.d dVar, int i10) {
        this.f20333b = i10;
        this.f20334m = dVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f20333b;
        kc.d dVar = this.f20334m;
        switch (i10) {
            case 0:
                int i11 = MainActivity.f11697v0;
                dVar.dismiss();
                break;
            case 1:
                int i12 = MainActivity.f11697v0;
                dVar.dismiss();
                break;
            case 2:
                int i13 = MainActivity.f11697v0;
                dVar.dismiss();
                break;
            case 3:
                int i14 = MainActivity.f11697v0;
                dVar.dismiss();
                break;
            case 4:
                int i15 = MainActivity.f11697v0;
                dVar.dismiss();
                break;
            case 5:
                int i16 = MainActivity.f11697v0;
                dVar.dismiss();
                break;
            case 6:
                int i17 = SearchActivityTV.f11775j0;
                dVar.dismiss();
                break;
            case 7:
                int i18 = SettingsActivity.f11809o2;
                dVar.dismiss();
                break;
            case 8:
                int i19 = MainActivityLeanback.f11919g0;
                dVar.dismiss();
                break;
            case 9:
                Typeface typeface = kc.d.f15050c0;
                dVar.dismiss();
                break;
            case 10:
                Typeface typeface2 = kc.d.f15050c0;
                dVar.dismiss();
                dVar.f15057n.onClick(view);
                break;
            case 11:
                Typeface typeface3 = kc.d.f15050c0;
                dVar.dismiss();
                dVar.f15056m.onClick(view);
                break;
            case 12:
                Typeface typeface4 = kc.d.f15050c0;
                dVar.dismiss();
                dVar.f15054b.onClick(view);
                break;
            default:
                Typeface typeface5 = kc.d.f15050c0;
                dVar.dismiss();
                break;
        }
    }
}
