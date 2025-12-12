package c5;

import com.google.android.exoplayer2.ExoPlaybackException;

/* compiled from: Player.java */
/* loaded from: classes.dex */
public interface n {
    void onLoadingChanged(boolean z10);

    void onPlaybackParametersChanged(m mVar);

    void onPlayerError(ExoPlaybackException exoPlaybackException);

    void onPlayerStateChanged(boolean z10, int i10);

    void onPositionDiscontinuity();

    void onTimelineChanged(r rVar, Object obj);

    void onTracksChanged(u5.o oVar, j6.g gVar);
}
