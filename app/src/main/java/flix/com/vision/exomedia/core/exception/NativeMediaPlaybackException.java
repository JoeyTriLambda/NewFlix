package flix.com.vision.exomedia.core.exception;

import android.media.MediaPlayer;

/* loaded from: classes2.dex */
public class NativeMediaPlaybackException extends Exception {
    public NativeMediaPlaybackException(int i10, int i11) {
        super(MediaPlayer.class.getName() + " has had the error " + i10 + " with extras " + i11);
    }
}
