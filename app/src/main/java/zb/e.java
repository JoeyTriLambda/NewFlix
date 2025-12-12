package zb;

import android.app.FragmentManager;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.TextClock;
import flix.com.vision.R;
import flix.com.vision.activities.player.SimpleVideoPlayer;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f22660b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ SimpleVideoPlayer f22661m;

    public /* synthetic */ e(SimpleVideoPlayer simpleVideoPlayer, int i10) {
        this.f22660b = i10;
        this.f22661m = simpleVideoPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalArgumentException {
        int i10 = this.f22660b;
        int i11 = 7;
        SimpleVideoPlayer simpleVideoPlayer = this.f22661m;
        switch (i10) {
            case 0:
                simpleVideoPlayer.H0 = false;
                break;
            case 1:
                LinearLayout linearLayout = simpleVideoPlayer.f11999q0;
                if (linearLayout != null) {
                    if (linearLayout.getVisibility() != 0) {
                        simpleVideoPlayer.f11999q0.setVisibility(0);
                        simpleVideoPlayer.f11999q0.startAnimation(simpleVideoPlayer.N0);
                    }
                    simpleVideoPlayer.Q.requestFocus();
                    new Handler().postDelayed(new e(simpleVideoPlayer, i11), 15000L);
                    break;
                }
                break;
            case 2:
                if (simpleVideoPlayer.W0 == null) {
                    simpleVideoPlayer.f();
                    break;
                }
                break;
            case 3:
                if (simpleVideoPlayer.W0 == null) {
                    String str = simpleVideoPlayer.f11979b0;
                    if (str != null) {
                        simpleVideoPlayer.playLink(str, true);
                        break;
                    }
                } else {
                    simpleVideoPlayer.e(simpleVideoPlayer.f11979b0);
                    break;
                }
                break;
            case 4:
                simpleVideoPlayer.f11997o0.setVisibility(8);
                simpleVideoPlayer.f11997o0.setImageResource(R.drawable.bvp_action_pause);
                break;
            case 5:
                simpleVideoPlayer.f11997o0.setVisibility(8);
                simpleVideoPlayer.f11997o0.setImageResource(R.drawable.bvp_action_pause);
                break;
            case 6:
                simpleVideoPlayer.f12000r0.setVisibility(0);
                simpleVideoPlayer.f12000r0.startAnimation(simpleVideoPlayer.Q0);
                new Handler().postDelayed(new e(simpleVideoPlayer, 12), 8000L);
                break;
            case 7:
                int i12 = SimpleVideoPlayer.f11976g1;
                simpleVideoPlayer.j();
                simpleVideoPlayer.B0 = true;
                break;
            case 8:
                if (simpleVideoPlayer.I0 > 5000) {
                    FragmentManager fragmentManager = simpleVideoPlayer.getFragmentManager();
                    kc.d dVarNewInstance = kc.d.newInstance(simpleVideoPlayer, true);
                    dVarNewInstance.setTitle("Resume Playback");
                    dVarNewInstance.setMessage("Do you want to resume or start over ?");
                    dVarNewInstance.setButton1("Resume", new f(simpleVideoPlayer, 7));
                    dVarNewInstance.setButton2("Start Over", new f(simpleVideoPlayer, 8));
                    try {
                        dVarNewInstance.show(fragmentManager, "");
                        break;
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        return;
                    }
                }
                break;
            case 9:
                simpleVideoPlayer.f11997o0.setVisibility(8);
                simpleVideoPlayer.f11997o0.setImageResource(R.drawable.bvp_action_pause);
                break;
            case 10:
                simpleVideoPlayer.S0 = true;
                if (!simpleVideoPlayer.T.isEmpty()) {
                    int i13 = 0;
                    while (true) {
                        if (i13 < simpleVideoPlayer.T.size()) {
                            if (simpleVideoPlayer.T.get(i13).f13037m) {
                                simpleVideoPlayer.U0 = true;
                                simpleVideoPlayer.playLink(simpleVideoPlayer.T.get(i13).D, false);
                            } else if (simpleVideoPlayer.T.get(i13).C.toLowerCase().contains("german")) {
                                i13++;
                            } else {
                                simpleVideoPlayer.U0 = true;
                                simpleVideoPlayer.playLink(simpleVideoPlayer.T.get(i13).D, false);
                            }
                        }
                    }
                    simpleVideoPlayer.i();
                    break;
                }
                break;
            case 11:
                if (simpleVideoPlayer.f11985e0.isPlaying() || !simpleVideoPlayer.f11985e0.isPrepared()) {
                    simpleVideoPlayer.f11998p0.animate().alpha(0.0f).setDuration(400L).setListener(new j(simpleVideoPlayer));
                    TextClock textClock = simpleVideoPlayer.O;
                    if (textClock != null && simpleVideoPlayer.N) {
                        textClock.animate().alpha(0.0f).setDuration(400L).setListener(new k(simpleVideoPlayer));
                        break;
                    }
                }
                break;
            default:
                simpleVideoPlayer.Q0.cancel();
                simpleVideoPlayer.R0.cancel();
                simpleVideoPlayer.f12000r0.setAlpha(1.0f);
                simpleVideoPlayer.f12000r0.startAnimation(simpleVideoPlayer.R0);
                simpleVideoPlayer.f12000r0.setVisibility(8);
                break;
        }
    }
}
