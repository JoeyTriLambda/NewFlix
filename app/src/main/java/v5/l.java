package v5;

/* compiled from: MediaChunk.java */
/* loaded from: classes.dex */
public abstract class l extends c {

    /* renamed from: i, reason: collision with root package name */
    public final int f20519i;

    public l(k6.d dVar, k6.f fVar, c5.i iVar, int i10, Object obj, long j10, long j11, int i11) {
        super(dVar, fVar, 1, iVar, i10, obj, j10, j11);
        l6.a.checkNotNull(iVar);
        this.f20519i = i11;
    }

    public int getNextChunkIndex() {
        return this.f20519i + 1;
    }

    public abstract boolean isLoadCompleted();
}
