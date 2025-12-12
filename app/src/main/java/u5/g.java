package u5;

import java.io.IOException;
import u5.l;

/* compiled from: MediaPeriod.java */
/* loaded from: classes.dex */
public interface g extends l {

    /* compiled from: MediaPeriod.java */
    public interface a extends l.a<g> {
        void onPrepared(g gVar);
    }

    @Override // u5.l
    boolean continueLoading(long j10);

    void discardBuffer(long j10);

    @Override // u5.l
    long getBufferedPositionUs();

    @Override // u5.l
    long getNextLoadPositionUs();

    o getTrackGroups();

    void maybeThrowPrepareError() throws IOException;

    void prepare(a aVar, long j10);

    long readDiscontinuity();

    long seekToUs(long j10);

    long selectTracks(j6.f[] fVarArr, boolean[] zArr, k[] kVarArr, boolean[] zArr2, long j10);
}
