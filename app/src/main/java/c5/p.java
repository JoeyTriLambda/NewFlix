package c5;

import com.google.android.exoplayer2.ExoPlaybackException;

/* compiled from: RendererCapabilities.java */
/* loaded from: classes.dex */
public interface p {
    int supportsFormat(i iVar) throws ExoPlaybackException;

    int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException;
}
