package ub;

import com.thebluealliance.spectrum.a;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.SettingsActivity;
import org.greenrobot.eventbus.EventBus;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class f2 implements a.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20181a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SettingsActivity f20182b;

    public /* synthetic */ f2(SettingsActivity settingsActivity, int i10) {
        this.f20181a = i10;
        this.f20182b = settingsActivity;
    }

    public final void a(boolean z10, int i10) {
        int i11 = this.f20181a;
        int i12 = R.color.md_white_1;
        int i13 = 0;
        SettingsActivity settingsActivity = this.f20182b;
        switch (i11) {
            case 0:
                int i14 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                if (z10) {
                    String str = "#" + Integer.toHexString(i10).toUpperCase();
                    int[] iArr = settingsActivity.f11824e2;
                    int length = iArr.length;
                    while (true) {
                        if (i13 < length) {
                            int i15 = iArr[i13];
                            if (settingsActivity.getResources().getString(i15).equalsIgnoreCase(str)) {
                                App.getInstance().f11574v.edit().putInt("subtitle_color", i15).apply();
                                App.getInstance().f11574v.edit().putInt("subtitle_color_res60", i15).apply();
                                hd.l lVar = new hd.l();
                                lVar.f13030a = i15;
                                EventBus.getDefault().post(lVar);
                                i12 = i15;
                            } else {
                                i13++;
                            }
                        }
                    }
                    try {
                        settingsActivity.N.setBackgroundResource(i12);
                        break;
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
                break;
            default:
                int i16 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                if (z10) {
                    String str2 = "#" + Integer.toHexString(i10).toUpperCase();
                    int[] iArr2 = settingsActivity.f11824e2;
                    int length2 = iArr2.length;
                    while (true) {
                        if (i13 < length2) {
                            int i17 = iArr2[i13];
                            if (settingsActivity.getResources().getString(i17).equalsIgnoreCase(str2)) {
                                App.getInstance().f11574v.edit().putInt("mouse_toggle_color", i17).apply();
                                i12 = i17;
                            } else {
                                i13++;
                            }
                        }
                    }
                    try {
                        settingsActivity.f11839j2.setBackgroundResource(i12);
                        break;
                    } catch (Exception e11) {
                        e11.printStackTrace();
                        return;
                    }
                }
                break;
        }
    }
}
