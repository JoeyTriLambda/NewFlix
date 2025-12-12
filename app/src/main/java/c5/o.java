package c5;

import c5.d;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.io.IOException;

/* compiled from: Renderer.java */
/* loaded from: classes.dex */
public interface o extends d.a {
    void disable();

    void enable(q qVar, i[] iVarArr, u5.k kVar, long j10, boolean z10, long j11) throws ExoPlaybackException;

    p getCapabilities();

    l6.h getMediaClock();

    int getState();

    u5.k getStream();

    int getTrackType();

    boolean hasReadStreamToEnd();

    boolean isCurrentStreamFinal();

    boolean isEnded();

    boolean isReady();

    void maybeThrowStreamError() throws IOException;

    void render(long j10, long j11) throws ExoPlaybackException;

    void replaceStream(i[] iVarArr, u5.k kVar, long j10) throws ExoPlaybackException;

    void resetPosition(long j10) throws ExoPlaybackException;

    void setCurrentStreamFinal();

    void setIndex(int i10);

    void start() throws ExoPlaybackException;

    void stop() throws ExoPlaybackException;
}
