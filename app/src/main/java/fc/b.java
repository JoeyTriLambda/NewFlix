package fc;

import flix.com.vision.bvp.BetterVideoPlayer;

/* compiled from: BetterVideoCallback.java */
/* loaded from: classes2.dex */
public interface b {
    void onBuffering(int i10);

    void onCompletion(BetterVideoPlayer betterVideoPlayer);

    void onError(BetterVideoPlayer betterVideoPlayer);

    void onPaused(BetterVideoPlayer betterVideoPlayer);

    void onPrepared(BetterVideoPlayer betterVideoPlayer);

    void onPreparing();

    void onStarted(BetterVideoPlayer betterVideoPlayer);

    void onToggleControls(boolean z10);
}
