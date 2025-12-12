package g5;

import g5.m;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: DummyTrackOutput.java */
/* loaded from: classes.dex */
public final class d implements m {
    @Override // g5.m
    public int sampleData(f fVar, int i10, boolean z10) throws InterruptedException, IOException {
        int iSkip = ((b) fVar).skip(i10);
        if (iSkip != -1) {
            return iSkip;
        }
        if (z10) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // g5.m
    public void sampleData(l6.l lVar, int i10) {
        lVar.skipBytes(i10);
    }

    @Override // g5.m
    public void format(c5.i iVar) {
    }

    @Override // g5.m
    public void sampleMetadata(long j10, int i10, int i11, int i12, m.a aVar) {
    }
}
