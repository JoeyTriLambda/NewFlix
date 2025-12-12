package zb;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Handler;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.SettingsActivity;
import flix.com.vision.activities.player.SimpleVideoPlayer;
import flix.com.vision.utils.JsonUtils;
import java.util.Objects;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class g implements xc.c, Toolbar.h, se.f {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SimpleVideoPlayer f22664b;

    public /* synthetic */ g(SimpleVideoPlayer simpleVideoPlayer) {
        this.f22664b = simpleVideoPlayer;
    }

    @Override // se.f
    public final void accept(Object obj) {
        int i10 = SimpleVideoPlayer.f11976g1;
        SimpleVideoPlayer simpleVideoPlayer = this.f22664b;
        simpleVideoPlayer.getClass();
        hd.o rDVideo = JsonUtils.parseRDVideo((com.google.gson.o) obj);
        if (rDVideo != null) {
            simpleVideoPlayer.OnSuccess(rDVideo);
        }
    }

    @Override // xc.c
    public final boolean onError(Exception exc) {
        String string;
        int i10 = SimpleVideoPlayer.f11976g1;
        SimpleVideoPlayer simpleVideoPlayer = this.f22664b;
        simpleVideoPlayer.getClass();
        if (exc == null || !(exc.getCause() instanceof UnrecognizedInputFormatException)) {
            if (exc == null || exc.getMessage() == null || exc.getMessage().length() <= 10) {
                Objects.requireNonNull(exc);
                Throwable cause = exc.getCause();
                Objects.requireNonNull(cause);
                string = cause.toString();
            } else {
                string = exc.getMessage();
            }
            FragmentManager fragmentManager = simpleVideoPlayer.getFragmentManager();
            kc.d dVarNewInstance = kc.d.newInstance(simpleVideoPlayer, true);
            dVarNewInstance.setTitle("An Error Occurred. Try external player if it persists");
            dVarNewInstance.setMessage("Message: " + string);
            dVarNewInstance.setButton1("GOT IT", new f(simpleVideoPlayer, 3));
            dVarNewInstance.setButton2("OPEN SETTINGS", new f(simpleVideoPlayer, 4));
            try {
                dVarNewInstance.show(fragmentManager, "");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } else {
            FragmentManager fragmentManager2 = simpleVideoPlayer.getFragmentManager();
            kc.d dVarNewInstance2 = kc.d.newInstance(simpleVideoPlayer, false);
            dVarNewInstance2.setTitle("Unsupported Video Format");
            dVarNewInstance2.setMessage("Our internal Player could not decode the video. Please try with a more powerful Player like VLC or MX Player. You can change Player in Settings");
            dVarNewInstance2.setButton1("GOT IT", new f(simpleVideoPlayer, 5));
            dVarNewInstance2.setButton2("OPEN SETTINGS", new f(simpleVideoPlayer, 6));
            try {
                dVarNewInstance2.show(fragmentManager2, "");
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return false;
    }

    @Override // androidx.appcompat.widget.Toolbar.h
    public final boolean onMenuItemClick(MenuItem menuItem) {
        int i10 = SimpleVideoPlayer.f11976g1;
        SimpleVideoPlayer simpleVideoPlayer = this.f22664b;
        simpleVideoPlayer.getClass();
        if (menuItem.getItemId() == R.id.play_pause_button) {
            try {
                if (simpleVideoPlayer.f11985e0.isPlaying()) {
                    simpleVideoPlayer.f11997o0.setVisibility(0);
                    simpleVideoPlayer.f11985e0.pause();
                    simpleVideoPlayer.f11985e0.getToolbar().getMenu().getItem(1).setIcon(R.drawable.ic_play_circle2);
                    if (simpleVideoPlayer.f12006x0 != null) {
                        App.getInstance().f11574v.edit().putInt(simpleVideoPlayer.f12006x0, simpleVideoPlayer.f11985e0.getCurrentPosition()).apply();
                    }
                    simpleVideoPlayer.requestAndDisplayAd();
                } else if (simpleVideoPlayer.f11985e0.isPrepared()) {
                    if (simpleVideoPlayer.L != null && simpleVideoPlayer.f11986e1) {
                        simpleVideoPlayer.W.setVisibility(8);
                    }
                    simpleVideoPlayer.f11997o0.setImageResource(R.drawable.ic_play);
                    new Handler().postDelayed(new e(simpleVideoPlayer, 9), 200L);
                    simpleVideoPlayer.J0 = false;
                    simpleVideoPlayer.f11985e0.getToolbar().getMenu().getItem(1).setIcon(R.drawable.ic_pause_cirlce);
                    simpleVideoPlayer.f11985e0.start();
                }
                simpleVideoPlayer.f11985e0.showControls();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } else if (menuItem.getItemId() == R.id.hd_button) {
            simpleVideoPlayer.g(simpleVideoPlayer.T);
        } else if (menuItem.getItemId() == R.id.aspect_ratio_button) {
            simpleVideoPlayer.f11985e0.setScaleType();
        } else if (menuItem.getItemId() == R.id.episodes_button) {
            if (simpleVideoPlayer.V.getVisibility() != 0) {
                simpleVideoPlayer.V.setVisibility(0);
                simpleVideoPlayer.V.startAnimation(simpleVideoPlayer.f11982c1);
                simpleVideoPlayer.X.requestFocus();
            } else {
                simpleVideoPlayer.k();
            }
        } else if (menuItem.getItemId() == R.id.subtitle_button) {
            if (simpleVideoPlayer.f11995m0 != null) {
                try {
                    simpleVideoPlayer.p();
                } catch (Exception unused) {
                }
            }
        } else if (menuItem.getItemId() == R.id.settings_button) {
            simpleVideoPlayer.startActivity(new Intent(simpleVideoPlayer, (Class<?>) SettingsActivity.class));
        }
        return true;
    }
}
