package oc;

import android.net.Uri;
import android.view.View;
import com.google.android.exoplayer2.drm.f;
import flix.com.vision.exomedia.ExoMedia$RendererType;
import flix.com.vision.exomedia.core.video.scale.ScaleType;
import java.util.Map;
import nc.c;
import u5.o;

/* compiled from: VideoViewApi.java */
/* loaded from: classes2.dex */
public interface a {
    Map<ExoMedia$RendererType, o> getAvailableTracks();

    int getBufferedPercent();

    long getCurrentPosition();

    long getDuration();

    boolean isPlaying();

    void onVideoSizeChanged(int i10, int i11);

    void pause();

    void release();

    void seekTo(long j10);

    void setDrmCallback(f fVar);

    void setListenerMux(c cVar);

    void setMeasureBasedOnAspectRatioEnabled(boolean z10);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setScaleType(ScaleType scaleType);

    void setVideoRotation(int i10, boolean z10);

    void setVideoUri(Uri uri);

    boolean setVolume(float f10);

    void start();

    void stopPlayback(boolean z10);
}
