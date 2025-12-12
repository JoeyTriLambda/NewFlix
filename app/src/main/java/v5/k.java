package v5;

import java.io.IOException;
import l6.u;

/* compiled from: InitializationChunk.java */
/* loaded from: classes.dex */
public final class k extends c {

    /* renamed from: i, reason: collision with root package name */
    public final d f20516i;

    /* renamed from: j, reason: collision with root package name */
    public volatile int f20517j;

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f20518k;

    public k(k6.d dVar, k6.f fVar, c5.i iVar, int i10, Object obj, d dVar2) {
        super(dVar, fVar, 2, iVar, i10, obj, -9223372036854775807L, -9223372036854775807L);
        this.f20516i = dVar2;
    }

    @Override // v5.c
    public long bytesLoaded() {
        return this.f20517j;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void cancelLoad() {
        this.f20518k = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public boolean isLoadCanceled() {
        return this.f20518k;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void load() throws InterruptedException, IOException {
        k6.f fVarSubrange = this.f20466a.subrange(this.f20517j);
        try {
            k6.d dVar = this.f20473h;
            g5.b bVar = new g5.b(dVar, fVarSubrange.f14961c, dVar.open(fVarSubrange));
            if (this.f20517j == 0) {
                this.f20516i.init(null);
            }
            try {
                g5.e eVar = this.f20516i.f20474b;
                int i10 = 0;
                while (i10 == 0 && !this.f20518k) {
                    i10 = eVar.read(bVar, null);
                }
                l6.a.checkState(i10 != 1);
            } finally {
                this.f20517j = (int) (bVar.getPosition() - this.f20466a.f14961c);
            }
        } finally {
            u.closeQuietly(this.f20473h);
        }
    }
}
