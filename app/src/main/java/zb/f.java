package zb;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import flix.com.vision.App;
import flix.com.vision.activities.SettingsActivity;
import flix.com.vision.activities.player.SimpleVideoPlayer;
import flix.com.vision.filepickerlibrary.FilePickerActivity;
import flix.com.vision.filepickerlibrary.enums.Request;
import flix.com.vision.filepickerlibrary.enums.ThemeType;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f22662b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ SimpleVideoPlayer f22663m;

    public /* synthetic */ f(SimpleVideoPlayer simpleVideoPlayer, int i10) {
        this.f22662b = i10;
        this.f22663m = simpleVideoPlayer;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws UnsupportedEncodingException {
        int i10 = this.f22662b;
        SimpleVideoPlayer simpleVideoPlayer = this.f22663m;
        switch (i10) {
            case 0:
                SimpleVideoPlayer.d(simpleVideoPlayer);
                break;
            case 1:
                int i11 = simpleVideoPlayer.F0;
                int i12 = simpleVideoPlayer.E0;
                if (i11 > i12) {
                    simpleVideoPlayer.E0 = i12 + 1;
                    simpleVideoPlayer.l(i12);
                }
                simpleVideoPlayer.f11999q0.setVisibility(8);
                simpleVideoPlayer.B0 = false;
                break;
            case 2:
                int i13 = SimpleVideoPlayer.f11976g1;
                simpleVideoPlayer.getClass();
                try {
                    simpleVideoPlayer.h();
                    break;
                } catch (Exception unused) {
                    return;
                }
            case 3:
                ArrayList<hd.o> arrayList = simpleVideoPlayer.T;
                if (arrayList != null && !arrayList.isEmpty()) {
                    simpleVideoPlayer.g(simpleVideoPlayer.T);
                    break;
                }
                break;
            case 4:
                int i14 = SimpleVideoPlayer.f11976g1;
                simpleVideoPlayer.getClass();
                simpleVideoPlayer.startActivity(new Intent(simpleVideoPlayer, (Class<?>) SettingsActivity.class));
                break;
            case 5:
                ArrayList<hd.o> arrayList2 = simpleVideoPlayer.T;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    simpleVideoPlayer.g(simpleVideoPlayer.T);
                    break;
                }
                break;
            case 6:
                int i15 = SimpleVideoPlayer.f11976g1;
                simpleVideoPlayer.getClass();
                simpleVideoPlayer.startActivity(new Intent(simpleVideoPlayer, (Class<?>) SettingsActivity.class));
                break;
            case 7:
                if (simpleVideoPlayer.I0 > 5000) {
                    if (!simpleVideoPlayer.f11985e0.isPlaying()) {
                        simpleVideoPlayer.J0 = true;
                        break;
                    } else {
                        try {
                            simpleVideoPlayer.f11985e0.seekTo(simpleVideoPlayer.I0 - 5000);
                            break;
                        } catch (Exception unused2) {
                            return;
                        }
                    }
                }
                break;
            case 8:
                int i16 = SimpleVideoPlayer.f11976g1;
                simpleVideoPlayer.getClass();
                App.getInstance().f11574v.edit().remove(simpleVideoPlayer.f12006x0).apply();
                break;
            case 9:
                simpleVideoPlayer.f11985e0.removeCaptions();
                try {
                    ic.a.Success(simpleVideoPlayer.getApplicationContext(), "Subtitles Disabled", null, 48, 0);
                } catch (Exception unused3) {
                }
                simpleVideoPlayer.s();
                break;
            case 10:
                try {
                    kc.i.newInstance(simpleVideoPlayer.f11985e0).show(simpleVideoPlayer.getFragmentManager(), "");
                    break;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return;
                }
            case 11:
                int i17 = SimpleVideoPlayer.f11976g1;
                simpleVideoPlayer.getClass();
                try {
                    if (m0.a.checkSelfPermission(simpleVideoPlayer, "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
                        l0.a.requestPermissions(simpleVideoPlayer, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 10001);
                        Toast.makeText(simpleVideoPlayer.getBaseContext(), "Grant Storage permission First", 0).show();
                        break;
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                Intent intent = new Intent(simpleVideoPlayer, (Class<?>) FilePickerActivity.class);
                intent.putExtra("themeType", ThemeType.DIALOG);
                intent.putExtra("request", Request.FILE);
                simpleVideoPlayer.startActivityForResult(intent, 12345);
                break;
            default:
                ArrayList<hd.m> arrayList3 = simpleVideoPlayer.Z0;
                if (arrayList3 != null && !arrayList3.isEmpty()) {
                    simpleVideoPlayer.r();
                    break;
                } else {
                    simpleVideoPlayer.q(true);
                    String string = App.getInstance().f11574v.getInt("subtitle_source_index_2", 0) == 0 ? App.getInstance().f11574v.getString("sub_lang_code_1", "eng") : App.getInstance().f11574v.getString("subtitle_code_multi_1", "eng");
                    if (!simpleVideoPlayer.f11995m0.isSeries()) {
                        new xd.a(simpleVideoPlayer, simpleVideoPlayer.f11995m0, string).process();
                        break;
                    } else {
                        new xd.a(simpleVideoPlayer, simpleVideoPlayer.f11995m0, string).process(simpleVideoPlayer.D0, simpleVideoPlayer.E0, simpleVideoPlayer.f11995m0.getTitle(), simpleVideoPlayer.C0, simpleVideoPlayer.f11995m0.getYear());
                        break;
                    }
                }
        }
    }
}
