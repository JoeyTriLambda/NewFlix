package ub;

import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.d;
import com.thebluealliance.spectrum.a;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.SettingsActivity;
import flix.com.vision.activities.TraktActivity;
import flix.com.vision.activities.TraktTvConfigActivity;
import flix.com.vision.activities.adult.AdultPINSetupActivity;
import flix.com.vision.activities.adult.AdultZonePINEntryActivity;
import flix.com.vision.api.alldebrid.AllDebridApiKeyEntryActivity;
import flix.com.vision.api.alldebrid.AllDebridCommon;
import flix.com.vision.api.premiumize.PremiumizeCommon;
import flix.com.vision.api.realdebrid.RealDebridCommon;
import flix.com.vision.api.realdebrid.RealDebridLoginActivity;
import flix.com.vision.tv.Constant;
import java.util.HashSet;
import java.util.Set;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class z1 implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20335b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ SettingsActivity f20336m;

    public /* synthetic */ z1(SettingsActivity settingsActivity, int i10) {
        this.f20335b = i10;
        this.f20336m = settingsActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f20335b;
        int i11 = 6;
        int i12 = 7;
        int i13 = 2;
        int i14 = 1;
        int i15 = 0;
        final SettingsActivity settingsActivity = this.f20336m;
        switch (i10) {
            case 0:
                int i16 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                if (!RealDebridCommon.f12051p && !PremiumizeCommon.f12045b && !AllDebridCommon.f12043n) {
                    Toast.makeText(settingsActivity, "You have to connect a Premium account first", 0).show();
                    break;
                } else {
                    settingsActivity.Q1.performClick();
                    break;
                }
                break;
            case 1:
                int i17 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                if (!AllDebridCommon.f12043n) {
                    settingsActivity.startActivity(new Intent(settingsActivity, (Class<?>) AllDebridApiKeyEntryActivity.class));
                    break;
                } else {
                    FragmentManager fragmentManager = settingsActivity.getFragmentManager();
                    kc.d dVarNewInstance = kc.d.newInstance(settingsActivity, true);
                    dVarNewInstance.setTitle("AllDebrid Logout");
                    dVarNewInstance.setMessage("Do you really want to unlink your Account ?");
                    dVarNewInstance.setButton1("CANCEL", new q0(i12));
                    dVarNewInstance.setButton2("YES, LOGOUT", new d2(settingsActivity, 10));
                    try {
                        dVarNewInstance.show(fragmentManager, "");
                        break;
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        return;
                    }
                }
            case 2:
                int i18 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                int i19 = App.getInstance().f11574v.getInt("pref_tv_layout", 0);
                d.a aVar = new d.a(new ContextThemeWrapper(settingsActivity, R.style.AlertDialogCustom));
                aVar.setSingleChoiceItems(settingsActivity.Y, i19, new e2(settingsActivity, 4));
                aVar.show();
                break;
            case 3:
                int i20 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                if (App.getInstance().f11574v.getInt("subtitle_source_index_2", 0) == 0) {
                    int i21 = App.getInstance().f11574v.getInt("sub_lang_index_1", 19);
                    d.a aVar2 = new d.a(settingsActivity);
                    aVar2.setSingleChoiceItems(settingsActivity.f11842k2, i21, new e2(settingsActivity, i13));
                    aVar2.setOnDismissListener(new p0(i14));
                    aVar2.show();
                    break;
                } else {
                    CharSequence[] charSequenceArr = new CharSequence[settingsActivity.L.size()];
                    final boolean[] zArr = new boolean[settingsActivity.L.size()];
                    for (int i22 = 0; i22 < settingsActivity.L.size(); i22++) {
                        try {
                            charSequenceArr[i22] = settingsActivity.L.get(i22).split("--")[r2.length - 1];
                        } catch (Exception e11) {
                            e11.printStackTrace();
                            charSequenceArr[i22] = settingsActivity.L.get(i22);
                        }
                    }
                    HashSet hashSet = new HashSet();
                    hashSet.add("eng--English");
                    Set<String> stringSet = App.getInstance().f11574v.getStringSet("prefs_sub_lang_set_1", hashSet);
                    while (i15 < settingsActivity.L.size()) {
                        zArr[i15] = stringSet.contains(settingsActivity.L.get(i15));
                        i15++;
                    }
                    d.a aVar3 = new d.a(settingsActivity);
                    aVar3.setTitle("Subtitles Languages");
                    aVar3.setMultiChoiceItems(charSequenceArr, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: ub.h2
                        @Override // android.content.DialogInterface.OnMultiChoiceClickListener
                        public final void onClick(DialogInterface dialogInterface, int i23, boolean z10) {
                            int i24 = SettingsActivity.f11809o2;
                            SettingsActivity settingsActivity2 = settingsActivity;
                            settingsActivity2.getClass();
                            zArr[i23] = z10;
                            String str = settingsActivity2.L.get(i23);
                            Set<String> stringSet2 = App.getInstance().f11574v.getStringSet("prefs_sub_lang_set_1", new HashSet());
                            if (z10) {
                                stringSet2.add(str);
                                App.getInstance().f11574v.edit().putStringSet("prefs_sub_lang_set_1", stringSet2).apply();
                            } else {
                                stringSet2.remove(str);
                                App.getInstance().f11574v.edit().putStringSet("prefs_sub_lang_set_1", stringSet2).apply();
                            }
                            App.getInstance().f11565m = true;
                            settingsActivity2.j(stringSet2, true);
                        }
                    });
                    aVar3.setPositiveButton(settingsActivity.getString(R.string.ok_label), new t0(5));
                    aVar3.setOnDismissListener(new p0(i13));
                    aVar3.show();
                    break;
                }
            case 4:
                int i23 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                int i24 = App.getInstance().f11574v.getInt("pref_subtitle_size", 3);
                d.a aVar4 = new d.a(settingsActivity);
                aVar4.setTitle("Change Subtitle Size");
                aVar4.setSingleChoiceItems(settingsActivity.f11845l2, i24, new e2(settingsActivity, 3));
                aVar4.show();
                break;
            case 5:
                int i25 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                int i26 = App.getInstance().f11574v.getInt("pref_subtitle_encoding_index", 0);
                d.a aVar5 = new d.a(settingsActivity);
                aVar5.setTitle("Change Subtitle Encoding");
                aVar5.setSingleChoiceItems(settingsActivity.f11848m2, i26, new e2(settingsActivity, i14));
                aVar5.show();
                break;
            case 6:
                int i27 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                int i28 = App.getInstance().f11574v.getInt("subtitle_source_index_2", 0);
                d.a aVar6 = new d.a(new ContextThemeWrapper(settingsActivity, R.style.AlertDialogCustom));
                aVar6.setSingleChoiceItems(settingsActivity.f11810a0, i28, new e2(settingsActivity, i15));
                aVar6.show();
                break;
            case 7:
                int i29 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                if (!RealDebridCommon.f12051p) {
                    settingsActivity.startActivity(new Intent(settingsActivity, (Class<?>) RealDebridLoginActivity.class));
                    break;
                } else {
                    FragmentManager fragmentManager2 = settingsActivity.getFragmentManager();
                    kc.d dVarNewInstance2 = kc.d.newInstance(settingsActivity, true);
                    dVarNewInstance2.setTitle("Real Debrid Logout");
                    dVarNewInstance2.setMessage("Do you really want to unlink your Account ?");
                    int i30 = 11;
                    dVarNewInstance2.setButton1("CANCEL", new q0(i30));
                    dVarNewInstance2.setButton2("YES, LOGOUT", new d2(settingsActivity, i30));
                    try {
                        dVarNewInstance2.show(fragmentManager2, "");
                        break;
                    } catch (Exception e12) {
                        e12.printStackTrace();
                        return;
                    }
                }
            case 8:
                int i31 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                int i32 = App.getInstance().f11574v.getInt("pref_adult_zone_player", 0);
                d.a aVar7 = new d.a(new ContextThemeWrapper(settingsActivity, R.style.AlertDialogCustom));
                aVar7.setSingleChoiceItems(settingsActivity.X, i32, new e2(settingsActivity, i12));
                aVar7.show();
                break;
            case 9:
                int i33 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                if (App.getInstance().f11574v.getBoolean("pref_adult_zone_pin_set", false)) {
                    Intent intent = new Intent(settingsActivity, (Class<?>) AdultZonePINEntryActivity.class);
                    intent.putExtra("isPINChange", true);
                    settingsActivity.startActivity(intent);
                    break;
                } else {
                    settingsActivity.startActivity(new Intent(settingsActivity, (Class<?>) AdultPINSetupActivity.class));
                    break;
                }
            case 10:
                int i34 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                if (App.getInstance().f11574v.getBoolean("trakt_user_logged_in", false)) {
                    settingsActivity.startActivity(new Intent(settingsActivity, (Class<?>) TraktTvConfigActivity.class));
                    break;
                } else if (App.getInstance().f11574v.getBoolean("trakt_user_logged_in", false)) {
                    settingsActivity.startActivity(new Intent(settingsActivity, (Class<?>) TraktActivity.class));
                    break;
                } else {
                    FragmentManager fragmentManager3 = settingsActivity.getFragmentManager();
                    kc.d dVarNewInstance3 = kc.d.newInstance(settingsActivity, false);
                    dVarNewInstance3.setTitle(settingsActivity.getString(R.string.trakt_tv_label));
                    dVarNewInstance3.setCancelable(false);
                    dVarNewInstance3.setMessage(settingsActivity.getString(R.string.connect_with_trakt_tv_enjoy_benefits_mess));
                    dVarNewInstance3.setButton1("CANCEL", new q0(i11));
                    dVarNewInstance3.setButton2(settingsActivity.getString(R.string.action_sign_in), new d2(settingsActivity, 9));
                    try {
                        dVarNewInstance3.show(fragmentManager3, "");
                        break;
                    } catch (Exception e13) {
                        e13.printStackTrace();
                        return;
                    }
                }
            case 11:
                settingsActivity.O1.performClick();
                break;
            case 12:
                settingsActivity.N1.performClick();
                break;
            case 13:
                int i35 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                int i36 = App.getInstance().f11574v.getInt("pref_auto_play_minutes", 2);
                d.a aVar8 = new d.a(new ContextThemeWrapper(settingsActivity, R.style.AlertDialogCustom));
                aVar8.setSingleChoiceItems(settingsActivity.Z, i36, new e2(settingsActivity, i11));
                aVar8.show();
                break;
            case 14:
                settingsActivity.V1.performClick();
                break;
            case 15:
                settingsActivity.X1.performClick();
                break;
            case 16:
                settingsActivity.M1.performClick();
                break;
            case 17:
                settingsActivity.W1.performClick();
                break;
            case 18:
                settingsActivity.T1.performClick();
                break;
            case 19:
                settingsActivity.Y1.performClick();
                break;
            case 20:
                settingsActivity.Z1.performClick();
                break;
            case 21:
                settingsActivity.P1.performClick();
                break;
            case 22:
                settingsActivity.f11812a2.performClick();
                break;
            case 23:
                settingsActivity.U1.performClick();
                break;
            case 24:
                settingsActivity.S1.performClick();
                break;
            case 25:
                settingsActivity.f11815b2.performClick();
                break;
            case 26:
                settingsActivity.f11818c2.performClick();
                break;
            case 27:
                settingsActivity.R1.performClick();
                break;
            case 28:
                int i37 = SettingsActivity.f11809o2;
                settingsActivity.showReleaseNoteDialog();
                break;
            default:
                int i38 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                SharedPreferences sharedPreferences = App.getInstance().f11574v;
                String str = Constant.f12450b;
                if (sharedPreferences.getInt("mouse_toggle_mode", 0) != 0) {
                    Toast.makeText(settingsActivity.getBaseContext(), "Only Applicable for Circle Toggle", 0).show();
                    break;
                } else if (App.K) {
                    settingsActivity.d("mouse_toggle_color", false);
                    break;
                } else {
                    new a.c(settingsActivity.getBaseContext()).setColors(R.array.sub_colors).setSelectedColorRes(App.getInstance().f11574v.getInt("mouse_toggle_color", R.color.md_deep_orange_500)).setDismissOnColorSelected(true).setTitle(R.string.select_font_color_label).setOutlineWidth(2).setOnColorSelectedListener(new f2(settingsActivity, i14)).build().show(settingsActivity.getSupportFragmentManager(), "");
                    break;
                }
        }
    }
}
