package fc;

import flix.com.vision.bvp.BetterVideoPlayer2;

/* compiled from: BetterVideoCallback2.java */
/* loaded from: classes2.dex */
public interface a {
    void onBuffering();

    void onCompletion(BetterVideoPlayer2 betterVideoPlayer2);

    void onError();

    void onPaused(BetterVideoPlayer2 betterVideoPlayer2);

    void onPrepared(BetterVideoPlayer2 betterVideoPlayer2);

    void onPreparing();

    void onStarted();

    void onToggleControls(boolean z10);
}
