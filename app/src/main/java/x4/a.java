package x4;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;
import flix.com.vision.activities.TraktTvConfigActivity;
import flix.com.vision.activities.player.PlayerActivityLiveTV;
import flix.com.vision.helpers.Constants;
import org.greenrobot.eventbus.EventBus;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f21509b;

    public /* synthetic */ a(int i10) {
        this.f21509b = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f21509b) {
            case 0:
                int i10 = AlarmManagerSchedulerBroadcastReceiver.f5688a;
                break;
            case 1:
                int i11 = TraktTvConfigActivity.f11876a0;
                EventBus.getDefault().post(Constants.TRAKT_TV_EVENT.USER_LOGGED_OUT);
                break;
            default:
                int i12 = PlayerActivityLiveTV.f11967a0;
                EventBus.getDefault().post(PlayerActivityLiveTV.RESULT_EVENT_PLAYER_CTIVITY_LIVE.HIDE);
                break;
        }
    }
}
