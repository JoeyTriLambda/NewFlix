package v5;

import java.io.IOException;
import l6.u;

/* compiled from: SingleSampleMediaChunk.java */
/* loaded from: classes.dex */
public final class m extends a {

    /* renamed from: l, reason: collision with root package name */
    public final int f20520l;

    /* renamed from: m, reason: collision with root package name */
    public final c5.i f20521m;

    /* renamed from: n, reason: collision with root package name */
    public volatile int f20522n;

    /* renamed from: o, reason: collision with root package name */
    public volatile boolean f20523o;

    /* renamed from: p, reason: collision with root package name */
    public volatile boolean f20524p;

    public m(k6.d dVar, k6.f fVar, c5.i iVar, int i10, Object obj, long j10, long j11, int i11, int i12, c5.i iVar2) {
        super(dVar, fVar, iVar, i10, obj, j10, j11, i11);
        this.f20520l = i12;
        this.f20521m = iVar2;
    }

    @Override // v5.c
    public long bytesLoaded() {
        return this.f20522n;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void cancelLoad() {
        this.f20523o = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public boolean isLoadCanceled() {
        return this.f20523o;
    }

    @Override // v5.l
    public boolean isLoadCompleted() {
        return this.f20524p;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void load() throws InterruptedException, IOException {
        try {
            long jOpen = this.f20473h.open(this.f20466a.subrange(this.f20522n));
            if (jOpen != -1) {
                jOpen += this.f20522n;
            }
            g5.b bVar = new g5.b(this.f20473h, this.f20522n, jOpen);
            b output = getOutput();
            output.setSampleOffsetUs(0L);
            g5.m mVarTrack = output.track(0, this.f20520l);
            mVarTrack.format(this.f20521m);
            for (int iSampleData = 0; iSampleData != -1; iSampleData = mVarTrack.sampleData(bVar, Integer.MAX_VALUE, true)) {
                this.f20522n += iSampleData;
            }
            mVarTrack.sampleMetadata(this.f20471f, 1, this.f20522n, 0, null);
            u.closeQuietly(this.f20473h);
            this.f20524p = true;
        } catch (Throwable th2) {
            u.closeQuietly(this.f20473h);
            throw th2;
        }
    }
}
