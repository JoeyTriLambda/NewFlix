package com.google.android.exoplayer2;

import java.io.IOException;

/* loaded from: classes.dex */
public final class ExoPlaybackException extends Exception {
    public ExoPlaybackException(Throwable th2) {
        super(null, th2);
    }

    public static ExoPlaybackException createForRenderer(Exception exc, int i10) {
        return new ExoPlaybackException(exc);
    }

    public static ExoPlaybackException createForSource(IOException iOException) {
        return new ExoPlaybackException(iOException);
    }
}
