package u5;

/* compiled from: CompositeSequenceableLoader.java */
/* loaded from: classes.dex */
public final class c implements l {

    /* renamed from: b, reason: collision with root package name */
    public final l[] f20011b;

    public c(l[] lVarArr) {
        this.f20011b = lVarArr;
    }

    @Override // u5.l
    public final boolean continueLoading(long j10) {
        boolean zContinueLoading;
        boolean z10 = false;
        do {
            long nextLoadPositionUs = getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                break;
            }
            zContinueLoading = false;
            for (l lVar : this.f20011b) {
                if (lVar.getNextLoadPositionUs() == nextLoadPositionUs) {
                    zContinueLoading |= lVar.continueLoading(j10);
                }
            }
            z10 |= zContinueLoading;
        } while (zContinueLoading);
        return z10;
    }

    @Override // u5.l
    public final long getBufferedPositionUs() {
        long jMin = Long.MAX_VALUE;
        for (l lVar : this.f20011b) {
            long bufferedPositionUs = lVar.getBufferedPositionUs();
            if (bufferedPositionUs != Long.MIN_VALUE) {
                jMin = Math.min(jMin, bufferedPositionUs);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // u5.l
    public final long getNextLoadPositionUs() {
        long jMin = Long.MAX_VALUE;
        for (l lVar : this.f20011b) {
            long nextLoadPositionUs = lVar.getNextLoadPositionUs();
            if (nextLoadPositionUs != Long.MIN_VALUE) {
                jMin = Math.min(jMin, nextLoadPositionUs);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }
}
