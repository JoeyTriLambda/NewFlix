package n5;

import java.util.List;
import n5.v;

/* compiled from: SeiReader.java */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final List<c5.i> f16695a;

    /* renamed from: b, reason: collision with root package name */
    public final g5.m[] f16696b;

    public s(List<c5.i> list) {
        this.f16695a = list;
        this.f16696b = new g5.m[list.size()];
    }

    public void consume(long j10, l6.l lVar) {
        c6.g.consume(j10, lVar, this.f16696b);
    }

    public void createTracks(g5.g gVar, v.d dVar) {
        int i10 = 0;
        while (true) {
            g5.m[] mVarArr = this.f16696b;
            if (i10 >= mVarArr.length) {
                return;
            }
            dVar.generateNewId();
            g5.m mVarTrack = gVar.track(dVar.getTrackId(), 3);
            c5.i iVar = this.f16695a.get(i10);
            String str = iVar.f5120q;
            l6.a.checkArgument("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption mime type provided: " + str);
            String formatId = iVar.f5115b;
            if (formatId == null) {
                formatId = dVar.getFormatId();
            }
            mVarTrack.format(c5.i.createTextSampleFormat(formatId, str, (String) null, -1, iVar.I, iVar.J, iVar.K, (com.google.android.exoplayer2.drm.c) null));
            mVarArr[i10] = mVarTrack;
            i10++;
        }
    }
}
