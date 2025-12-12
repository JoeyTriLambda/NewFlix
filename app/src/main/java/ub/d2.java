package ub;

import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.d;
import com.thebluealliance.spectrum.a;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.SettingsActivity;
import flix.com.vision.activities.TraktSignInActivity;
import flix.com.vision.activities.player.YouTubeWebviewActivity;
import flix.com.vision.api.alldebrid.AllDebridCommon;
import flix.com.vision.api.premiumize.PremApiKeyEntryActivity;
import flix.com.vision.api.premiumize.PremiumizeCommon;
import flix.com.vision.api.realdebrid.RealDebridCommon;
import flix.com.vision.helpers.Constants;
import flix.com.vision.tv.Constant;
import java.io.File;
import java.io.IOException;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class d2 implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20166b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ SettingsActivity f20167m;

    public /* synthetic */ d2(SettingsActivity settingsActivity, int i10) {
        this.f20166b = i10;
        this.f20167m = settingsActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws ClassNotFoundException, IOException {
        int i10 = this.f20166b;
        final int i11 = 1;
        final int i12 = 0;
        final SettingsActivity settingsActivity = this.f20167m;
        switch (i10) {
            case 0:
                int i13 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                if (!App.K) {
                    new a.c(settingsActivity.getBaseContext()).setColors(R.array.sub_colors).setSelectedColorRes(App.getInstance().f11574v.getInt("subtitle_color", R.color.md_white_1)).setDismissOnColorSelected(true).setTitle(R.string.select_font_color_label).setOutlineWidth(2).setOnColorSelectedListener(new f2(settingsActivity, i12)).build().show(settingsActivity.getSupportFragmentManager(), "");
                    break;
                } else {
                    settingsActivity.d("subtitle_color", true);
                    break;
                }
            case 1:
                settingsActivity.V = true;
                o1.a.j(App.getInstance().f11574v, "clear_history_pending", true);
                try {
                    ic.a.Success(settingsActivity.getApplicationContext(), "Search history cleared", null, 48, 0);
                    break;
                } catch (Exception unused) {
                    return;
                }
            case 2:
                int i14 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                try {
                    settingsActivity.deleteDir(settingsActivity.getBaseContext().getCacheDir());
                    File file = new File(settingsActivity.getExternalCacheDir().getAbsolutePath() + "/subs/");
                    if (file.exists()) {
                        try {
                            file.delete();
                        } catch (Exception unused2) {
                        }
                    }
                    Toast.makeText(settingsActivity.getBaseContext(), R.string.cache_cleared, 1).show();
                    settingsActivity.f11849n0.setText("Clear Cache - 0 B");
                    break;
                } catch (Exception unused3) {
                    Toast.makeText(settingsActivity.getBaseContext(), "An Error Occurred", 1).show();
                    return;
                }
            case 3:
                int i15 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                ProgressDialog progressDialog = new ProgressDialog(settingsActivity);
                settingsActivity.U = progressDialog;
                progressDialog.setMessage("Checking updates...");
                settingsActivity.U.setProgressStyle(0);
                settingsActivity.U.setCancelable(false);
                settingsActivity.U.show();
                App.getInstance().loadRemoteConfig();
                new Handler().postDelayed(new Runnable() { // from class: ub.g2
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i16 = i11;
                        SettingsActivity settingsActivity2 = settingsActivity;
                        switch (i16) {
                            case 0:
                                settingsActivity2.Z0.setEnabled(true);
                                break;
                            default:
                                int i17 = SettingsActivity.f11809o2;
                                settingsActivity2.getClass();
                                try {
                                    SharedPreferences sharedPreferences = App.getInstance().f11574v;
                                    String str = Constant.f12450b;
                                    if (!sharedPreferences.getBoolean("update_available", false) || App.getInstance().f11574v.getString("update_url", "").length() <= 5) {
                                        Toast.makeText(settingsActivity2.getBaseContext(), "No Update available", 1).show();
                                    } else {
                                        FragmentManager fragmentManager = settingsActivity2.getFragmentManager();
                                        kc.d dVarNewInstance = kc.d.newInstance(settingsActivity2, true);
                                        dVarNewInstance.setTitle("Update " + App.getInstance().f11574v.getString("update_version_name", "N/A") + " available");
                                        dVarNewInstance.setMessage(settingsActivity2.getString(R.string.new_update_message) + App.getInstance().f11574v.getString("update_message", "") + settingsActivity2.getString(R.string.make_sure_you_get_it_mess));
                                        dVarNewInstance.setButton1("LATER", new q0(13));
                                        dVarNewInstance.setButton2("RESTART NOW", new d2(settingsActivity2, 14));
                                        try {
                                            dVarNewInstance.show(fragmentManager, "");
                                        } catch (Exception e10) {
                                            e10.printStackTrace();
                                        }
                                    }
                                    ProgressDialog progressDialog2 = settingsActivity2.U;
                                    if (progressDialog2 != null) {
                                        progressDialog2.dismiss();
                                        break;
                                    }
                                } catch (Exception unused4) {
                                    return;
                                }
                                break;
                        }
                    }
                }, 5000L);
                break;
            case 4:
                settingsActivity.Z0.setEnabled(false);
                jc.a.BackupPreferences(settingsActivity);
                new Handler().postDelayed(new Runnable() { // from class: ub.g2
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i16 = i12;
                        SettingsActivity settingsActivity2 = settingsActivity;
                        switch (i16) {
                            case 0:
                                settingsActivity2.Z0.setEnabled(true);
                                break;
                            default:
                                int i17 = SettingsActivity.f11809o2;
                                settingsActivity2.getClass();
                                try {
                                    SharedPreferences sharedPreferences = App.getInstance().f11574v;
                                    String str = Constant.f12450b;
                                    if (!sharedPreferences.getBoolean("update_available", false) || App.getInstance().f11574v.getString("update_url", "").length() <= 5) {
                                        Toast.makeText(settingsActivity2.getBaseContext(), "No Update available", 1).show();
                                    } else {
                                        FragmentManager fragmentManager = settingsActivity2.getFragmentManager();
                                        kc.d dVarNewInstance = kc.d.newInstance(settingsActivity2, true);
                                        dVarNewInstance.setTitle("Update " + App.getInstance().f11574v.getString("update_version_name", "N/A") + " available");
                                        dVarNewInstance.setMessage(settingsActivity2.getString(R.string.new_update_message) + App.getInstance().f11574v.getString("update_message", "") + settingsActivity2.getString(R.string.make_sure_you_get_it_mess));
                                        dVarNewInstance.setButton1("LATER", new q0(13));
                                        dVarNewInstance.setButton2("RESTART NOW", new d2(settingsActivity2, 14));
                                        try {
                                            dVarNewInstance.show(fragmentManager, "");
                                        } catch (Exception e10) {
                                            e10.printStackTrace();
                                        }
                                    }
                                    ProgressDialog progressDialog2 = settingsActivity2.U;
                                    if (progressDialog2 != null) {
                                        progressDialog2.dismiss();
                                        break;
                                    }
                                } catch (Exception unused4) {
                                    return;
                                }
                                break;
                        }
                    }
                }, 4000L);
                break;
            case 5:
                settingsActivity.f11811a1.setEnabled(false);
                jc.a.RestoreBackup(settingsActivity);
                new Handler().postDelayed(new i2(settingsActivity), 4000L);
                break;
            case 6:
                int i16 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                try {
                    kc.d dVarNewInstance = kc.d.newInstance(settingsActivity, true);
                    dVarNewInstance.setTitle("Check our FAQs on our website flixvision.tv");
                    dVarNewInstance.setMessage("You can also view them directly here ");
                    dVarNewInstance.setButton1("GOT IT", new z0(dVarNewInstance, 7));
                    dVarNewInstance.setButton2("OPEN HERE", new d2(settingsActivity, 13));
                    dVarNewInstance.show(settingsActivity.getFragmentManager(), "");
                    break;
                } catch (Exception unused4) {
                    return;
                }
            case 7:
                int i17 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                int i18 = App.getInstance().f11574v.getInt("player_index", 0);
                d.a aVar = new d.a(new ContextThemeWrapper(settingsActivity, R.style.AlertDialogCustom));
                aVar.setSingleChoiceItems(settingsActivity.X, i18, new e2(settingsActivity, 5));
                aVar.show();
                break;
            case 8:
                int i19 = SettingsActivity.f11809o2;
                if (!PremiumizeCommon.f12045b) {
                    settingsActivity.getClass();
                    settingsActivity.startActivity(new Intent(settingsActivity, (Class<?>) PremApiKeyEntryActivity.class));
                    break;
                } else {
                    FragmentManager fragmentManager = settingsActivity.getFragmentManager();
                    kc.d dVarNewInstance2 = kc.d.newInstance(settingsActivity, true);
                    dVarNewInstance2.setTitle("Premiumize Logout");
                    dVarNewInstance2.setMessage("Do you really want to unlink your Account ?");
                    int i20 = 12;
                    dVarNewInstance2.setButton1("CANCEL", new q0(i20));
                    dVarNewInstance2.setButton2("YES, LOGOUT", new d2(settingsActivity, i20));
                    try {
                        dVarNewInstance2.show(fragmentManager, "");
                        break;
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        return;
                    }
                }
            case 9:
                int i21 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                settingsActivity.startActivity(new Intent(settingsActivity, (Class<?>) TraktSignInActivity.class));
                break;
            case 10:
                int i22 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                App.getInstance().f11574v.edit().remove("ALL_DEBRID_LOGGED_IN").apply();
                SharedPreferences.Editor editorEdit = App.getInstance().f11574v.edit();
                String str = Constants.f12319a;
                editorEdit.remove("all_debrid_apikey").apply();
                App.getInstance().f11574v.edit().remove("ALL_DEBRID_PREMIUM_UNTIL").apply();
                App.getInstance().f11574v.edit().remove("ALL_DEBRID_IS_PREMIUM").apply();
                App.getInstance().f11574v.edit().remove("ALL_DEBRID_USERNAME").apply();
                AllDebridCommon.f12043n = false;
                settingsActivity.f11870x0.setVisibility(8);
                settingsActivity.f11874z0.setVisibility(8);
                settingsActivity.f11872y0.setText("Link your AllDebrid account to enjoy the best streaming experience");
                try {
                    ic.a.Success(settingsActivity.getApplicationContext(), "Successfully Logged out", null, 48, 0);
                    break;
                } catch (Exception unused5) {
                    return;
                }
            case 11:
                int i23 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                App.getInstance().f11574v.edit().remove("ACCESS_TOKEN").apply();
                App.getInstance().f11574v.edit().remove("REFRESH_TOKEN").apply();
                App.getInstance().f11574v.edit().remove("TOKEN_TYPE").apply();
                App.getInstance().f11574v.edit().remove("IS_RD_LOGGED_IN").apply();
                RealDebridCommon.f12051p = false;
                settingsActivity.f11831h0.setText("Link your Real Debrid account to enjoy the best streaming experience");
                try {
                    ic.a.Success(settingsActivity.getApplicationContext(), "Successfully Logged out", null, 48, 0);
                    break;
                } catch (Exception unused6) {
                    return;
                }
            case 12:
                int i24 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                App.getInstance().f11574v.edit().remove("PREM_LOGGED_IN").apply();
                SharedPreferences.Editor editorEdit2 = App.getInstance().f11574v.edit();
                String str2 = Constants.f12319a;
                editorEdit2.remove("prem_apikey").apply();
                App.getInstance().f11574v.edit().remove("PREM_PREMIUM_UNTIL").apply();
                PremiumizeCommon.f12045b = false;
                settingsActivity.f11825f0.setVisibility(8);
                settingsActivity.A0.setText("Link your Premiumize.me account to enjoy the best streaming experience");
                try {
                    ic.a.Success(settingsActivity.getApplicationContext(), "Successfully Logged out", null, 48, 0);
                    break;
                } catch (Exception unused7) {
                    return;
                }
            case 13:
                int i25 = SettingsActivity.f11809o2;
                settingsActivity.getClass();
                Intent intent = new Intent(settingsActivity, (Class<?>) YouTubeWebviewActivity.class);
                intent.putExtra("url", App.getInstance().f11578z + "/#faqs");
                settingsActivity.startActivity(intent);
                break;
            default:
                int i26 = SettingsActivity.f11809o2;
                settingsActivity.finish();
                App.getInstance().restartApp();
                break;
        }
    }
}
