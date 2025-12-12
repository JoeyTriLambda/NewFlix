package ae;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import flix.com.vision.activities.SettingsActivity;
import flix.com.vision.tv.TVCategoriesActivity2;
import flix.com.vision.tv.TVCategorySearchActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f649b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ TVCategoriesActivity2 f650m;

    public /* synthetic */ g(TVCategoriesActivity2 tVCategoriesActivity2, int i10) {
        this.f649b = i10;
        this.f650m = tVCategoriesActivity2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f649b;
        TVCategoriesActivity2 tVCategoriesActivity2 = this.f650m;
        switch (i10) {
            case 0:
                if (!tVCategoriesActivity2.f12486i0) {
                    tVCategoriesActivity2.finish();
                    break;
                } else {
                    Toast.makeText(tVCategoriesActivity2.getBaseContext(), "Yep, we made it!", 0).show();
                    break;
                }
            case 1:
                int i11 = TVCategoriesActivity2.f12477l0;
                tVCategoriesActivity2.getClass();
                tVCategoriesActivity2.startActivity(new Intent(tVCategoriesActivity2, (Class<?>) TVCategorySearchActivity.class));
                break;
            default:
                int i12 = TVCategoriesActivity2.f12477l0;
                tVCategoriesActivity2.getClass();
                tVCategoriesActivity2.startActivity(new Intent(tVCategoriesActivity2, (Class<?>) SettingsActivity.class));
                break;
        }
    }
}
