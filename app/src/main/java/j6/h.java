package j6;

import c5.p;
import com.google.android.exoplayer2.ExoPlaybackException;
import u5.o;

/* compiled from: TrackSelector.java */
/* loaded from: classes.dex */
public abstract class h {

    /* compiled from: TrackSelector.java */
    public interface a {
    }

    public abstract void onSelectionActivated(Object obj);

    public abstract i selectTracks(p[] pVarArr, o oVar) throws ExoPlaybackException;

    public final void init(a aVar) {
    }
}
