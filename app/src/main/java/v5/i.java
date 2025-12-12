package v5;

import java.io.IOException;
import l6.u;

/* compiled from: ContainerMediaChunk.java */
/* loaded from: classes.dex */
public final class i extends a {

    /* renamed from: l, reason: collision with root package name */
    public final int f20507l;

    /* renamed from: m, reason: collision with root package name */
    public final long f20508m;

    /* renamed from: n, reason: collision with root package name */
    public final d f20509n;

    /* renamed from: o, reason: collision with root package name */
    public volatile int f20510o;

    /* renamed from: p, reason: collision with root package name */
    public volatile boolean f20511p;

    /* renamed from: q, reason: collision with root package name */
    public volatile boolean f20512q;

    public i(k6.d dVar, k6.f fVar, c5.i iVar, int i10, Object obj, long j10, long j11, int i11, int i12, long j12, d dVar2) {
        super(dVar, fVar, iVar, i10, obj, j10, j11, i11);
        this.f20507l = i12;
        this.f20508m = j12;
        this.f20509n = dVar2;
    }

    @Override // v5.c
    public final long bytesLoaded() {
        return this.f20510o;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void cancelLoad() {
        this.f20511p = true;
    }

    @Override // v5.l
    public int getNextChunkIndex() {
        return this.f20519i + this.f20507l;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final boolean isLoadCanceled() {
        return this.f20511p;
    }

    @Override // v5.l
    public boolean isLoadCompleted() {
        return this.f20512q;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void load() throws InterruptedException, IOException {
        k6.f fVarSubrange = this.f20466a.subrange(this.f20510o);
        try {
            k6.d dVar = this.f20473h;
            g5.b bVar = new g5.b(dVar, fVarSubrange.f14961c, dVar.open(fVarSubrange));
            if (this.f20510o == 0) {
                b output = getOutput();
                output.setSampleOffsetUs(this.f20508m);
                this.f20509n.init(output);
            }
            try {
                g5.e eVar = this.f20509n.f20474b;
                int i10 = 0;
                while (i10 == 0 && !this.f20511p) {
                    i10 = eVar.read(bVar, null);
                }
                l6.a.checkState(i10 != 1);
                u.closeQuietly(this.f20473h);
                this.f20512q = true;
            } finally {
                this.f20510o = (int) (bVar.getPosition() - this.f20466a.f14961c);
            }
        } catch (Throwable th2) {
            u.closeQuietly(this.f20473h);
            throw th2;
        }
    }
}
