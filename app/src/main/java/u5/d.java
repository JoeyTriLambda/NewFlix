package u5;

import java.io.IOException;

/* compiled from: EmptySampleStream.java */
/* loaded from: classes.dex */
public final class d implements k {
    @Override // u5.k
    public boolean isReady() {
        return true;
    }

    @Override // u5.k
    public int readData(c5.j jVar, e5.e eVar, boolean z10) {
        eVar.setFlags(4);
        return -4;
    }

    @Override // u5.k
    public void maybeThrowError() throws IOException {
    }

    @Override // u5.k
    public void skipData(long j10) {
    }
}
