package vb;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import flix.com.vision.activities.adult.AdultCategoriesActivity;
import flix.com.vision.activities.adult.AdultZonePINEntryActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class l implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20671b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ AdultZonePINEntryActivity f20672m;

    public /* synthetic */ l(AdultZonePINEntryActivity adultZonePINEntryActivity, int i10) {
        this.f20671b = i10;
        this.f20672m = adultZonePINEntryActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f20671b;
        AdultZonePINEntryActivity adultZonePINEntryActivity = this.f20672m;
        switch (i10) {
            case 0:
                int i11 = AdultZonePINEntryActivity.U;
                adultZonePINEntryActivity.finish();
                break;
            case 1:
                int i12 = AdultZonePINEntryActivity.U;
                adultZonePINEntryActivity.d();
                break;
            case 2:
                int i13 = AdultZonePINEntryActivity.U;
                adultZonePINEntryActivity.finish();
                break;
            default:
                int i14 = AdultZonePINEntryActivity.U;
                adultZonePINEntryActivity.finish();
                adultZonePINEntryActivity.startActivity(new Intent(adultZonePINEntryActivity, (Class<?>) AdultCategoriesActivity.class));
                Toast.makeText(adultZonePINEntryActivity.getBaseContext(), "Login Successful!", 1).show();
                break;
        }
    }
}
