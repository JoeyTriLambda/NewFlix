package zb;

import flix.com.vision.activities.player.AdultVideoPlayerActivity;
import flix.com.vision.activities.player.SimpleVideoPlayer;
import flix.com.vision.bvp.BetterVideoPlayer;
import flix.com.vision.tv.PlayerActivityLiveExternal;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f22657b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ BetterVideoPlayer f22658m;

    public /* synthetic */ b(BetterVideoPlayer betterVideoPlayer, int i10) {
        this.f22657b = i10;
        this.f22658m = betterVideoPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f22657b;
        BetterVideoPlayer betterVideoPlayer = this.f22658m;
        switch (i10) {
            case 0:
                int i11 = AdultVideoPlayerActivity.f11962b0;
                betterVideoPlayer.start();
                break;
            case 1:
                int i12 = SimpleVideoPlayer.f11976g1;
                betterVideoPlayer.pause();
                break;
            case 2:
                betterVideoPlayer.start();
                break;
            default:
                int i13 = PlayerActivityLiveExternal.f12465h0;
                betterVideoPlayer.start();
                break;
        }
    }
}
