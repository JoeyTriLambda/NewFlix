package ub;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.widget.Toast;
import flix.com.vision.App;
import flix.com.vision.activities.SettingsActivity;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class e2 implements DialogInterface.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20173b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ SettingsActivity f20174m;

    public /* synthetic */ e2(SettingsActivity settingsActivity, int i10) {
        this.f20173b = i10;
        this.f20174m = settingsActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        int i11 = this.f20173b;
        SettingsActivity settingsActivity = this.f20174m;
        switch (i11) {
            case 0:
                int i12 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                dialogInterface.dismiss();
                App.getInstance().f11565m = true;
                App.getInstance().f11574v.edit().putInt("subtitle_source_index_2", i10).apply();
                if (i10 <= 0) {
                    int i13 = App.getInstance().f11574v.getInt("sub_lang_index_1", 19);
                    settingsActivity.C0.setText(settingsActivity.f11842k2[i13]);
                    App.getInstance().f11574v.edit().putString("sub_lang_name_1", settingsActivity.f11842k2[i13]).apply();
                    settingsActivity.f11834i0.setText(settingsActivity.f11810a0[i10]);
                    break;
                } else {
                    settingsActivity.f11834i0.setText(settingsActivity.f11810a0[i10]);
                    settingsActivity.j(null, true);
                    break;
                }
            case 1:
                CharSequence[] charSequenceArr = settingsActivity.f11848m2;
                try {
                    settingsActivity.f11851n2 = true;
                    App.getInstance().f11574v.edit().putInt("pref_subtitle_encoding_index", i10).apply();
                    settingsActivity.f11816c0.setText(charSequenceArr[i10]);
                    dialogInterface.dismiss();
                    if (i10 > 0) {
                        String string = charSequenceArr[i10].toString();
                        App.getInstance().f11574v.edit().putString("pref_subtitle_encoding_label", string.split(StringUtils.SPACE)[string.split(StringUtils.SPACE).length - 1].trim()).apply();
                    } else {
                        App.getInstance().f11574v.edit().putString("pref_subtitle_encoding_label", "utf-8").apply();
                    }
                    break;
                } catch (Exception unused) {
                    return;
                }
            case 2:
                int i14 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                dialogInterface.dismiss();
                App.getInstance().f11565m = true;
                SharedPreferences.Editor editorEdit = App.getInstance().f11574v.edit();
                editorEdit.putInt("sub_lang_index_1", i10);
                editorEdit.putString("sub_lang_code_1", settingsActivity.L.get(i10).split("--")[0]);
                editorEdit.putString("sub_lang_name_1", settingsActivity.f11842k2[i10]);
                editorEdit.apply();
                settingsActivity.C0.setText(settingsActivity.f11842k2[i10]);
                break;
            case 3:
                int i15 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                App.getInstance().f11574v.edit().putInt("pref_subtitle_size", i10).apply();
                settingsActivity.B0.setText(settingsActivity.f11845l2[i10]);
                dialogInterface.dismiss();
                hd.l lVar = new hd.l();
                lVar.f13031b = i10;
                EventBus.getDefault().post(lVar);
                break;
            case 4:
                int i16 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                dialogInterface.dismiss();
                Toast.makeText(settingsActivity.getBaseContext(), "Please restart to see the changes", 1).show();
                App.getInstance().f11574v.edit().putInt("pref_tv_layout", i10).apply();
                settingsActivity.g();
                break;
            case 5:
                int i17 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                dialogInterface.dismiss();
                if (i10 != 0 && i10 != 4) {
                    Toast.makeText(settingsActivity.getBaseContext(), "Please make sure the selected App is installed to avoid issues", 1).show();
                }
                App.getInstance().f11574v.edit().putInt("player_index", i10).apply();
                settingsActivity.h();
                break;
            case 6:
                int i18 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                dialogInterface.dismiss();
                App.getInstance().f11574v.edit().putInt("pref_auto_play_minutes", i10).apply();
                settingsActivity.f11837j0.setText(settingsActivity.Z[i10]);
                break;
            default:
                int i19 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                dialogInterface.dismiss();
                if (i10 != 0 && i10 != 4) {
                    Toast.makeText(settingsActivity.getBaseContext(), "Please make sure the selected App is installed to avoid issues", 1).show();
                }
                App.getInstance().f11574v.edit().putInt("pref_adult_zone_player", i10).apply();
                settingsActivity.e();
                break;
        }
    }
}
