package a6;

import a6.b;
import c5.i;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import j6.f;
import java.io.IOException;
import k5.j;
import k5.k;
import k6.d;
import k6.m;
import v5.h;
import v5.l;

/* compiled from: DefaultSsChunkSource.java */
/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final m f332a;

    /* renamed from: b, reason: collision with root package name */
    public final int f333b;

    /* renamed from: c, reason: collision with root package name */
    public final f f334c;

    /* renamed from: d, reason: collision with root package name */
    public final v5.d[] f335d;

    /* renamed from: e, reason: collision with root package name */
    public final k6.d f336e;

    /* renamed from: f, reason: collision with root package name */
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a f337f;

    /* renamed from: g, reason: collision with root package name */
    public int f338g;

    /* renamed from: h, reason: collision with root package name */
    public BehindLiveWindowException f339h;

    /* compiled from: DefaultSsChunkSource.java */
    /* renamed from: a6.a$a, reason: collision with other inner class name */
    public static final class C0005a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final d.a f340a;

        public C0005a(d.a aVar) {
            this.f340a = aVar;
        }

        public b createChunkSource(m mVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i10, f fVar, k[] kVarArr) {
            return new a(mVar, aVar, i10, fVar, this.f340a.createDataSource(), kVarArr);
        }
    }

    public a(m mVar, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, int i10, f fVar, k6.d dVar, k[] kVarArr) {
        this.f332a = mVar;
        this.f337f = aVar;
        this.f333b = i10;
        this.f334c = fVar;
        this.f336e = dVar;
        a.b bVar = aVar.f5995c[i10];
        this.f335d = new v5.d[fVar.length()];
        int i11 = 0;
        while (i11 < this.f335d.length) {
            int indexInTrackGroup = fVar.getIndexInTrackGroup(i11);
            i iVar = bVar.f6002c[indexInTrackGroup];
            int i12 = bVar.f6000a;
            int i13 = i11;
            this.f335d[i13] = new v5.d(new k5.e(3, null, new j(indexInTrackGroup, i12, bVar.f6001b, -9223372036854775807L, aVar.f5996d, iVar, 0, kVarArr, i12 == 2 ? 4 : 0, null, null)), iVar);
            i11 = i13 + 1;
        }
    }

    @Override // v5.g
    public final void getNextChunk(l lVar, long j10, v5.e eVar) {
        int nextChunkIndex;
        if (this.f339h != null) {
            return;
        }
        long j11 = lVar != null ? lVar.f20472g - j10 : 0L;
        f fVar = this.f334c;
        fVar.updateSelectedTrack(j11);
        a.b bVar = this.f337f.f5995c[this.f333b];
        if (bVar.f6003d == 0) {
            eVar.f20487b = !r5.f5993a;
            return;
        }
        if (lVar == null) {
            nextChunkIndex = bVar.getChunkIndex(j10);
        } else {
            nextChunkIndex = lVar.getNextChunkIndex() - this.f338g;
            if (nextChunkIndex < 0) {
                this.f339h = new BehindLiveWindowException();
                return;
            }
        }
        if (nextChunkIndex >= bVar.f6003d) {
            eVar.f20487b = !this.f337f.f5993a;
            return;
        }
        long startTimeUs = bVar.getStartTimeUs(nextChunkIndex);
        long chunkDurationUs = bVar.getChunkDurationUs(nextChunkIndex) + startTimeUs;
        int i10 = nextChunkIndex + this.f338g;
        int selectedIndex = fVar.getSelectedIndex();
        eVar.f20486a = new v5.i(this.f336e, new k6.f(bVar.buildRequestUri(fVar.getIndexInTrackGroup(selectedIndex), nextChunkIndex), 0L, -1L, null), fVar.getSelectedFormat(), fVar.getSelectionReason(), fVar.getSelectionData(), startTimeUs, chunkDurationUs, i10, 1, startTimeUs, this.f335d[selectedIndex]);
    }

    @Override // v5.g
    public void maybeThrowError() throws IOException {
        BehindLiveWindowException behindLiveWindowException = this.f339h;
        if (behindLiveWindowException != null) {
            throw behindLiveWindowException;
        }
        this.f332a.maybeThrowError();
    }

    @Override // v5.g
    public boolean onChunkLoadError(v5.c cVar, boolean z10, Exception exc) {
        if (z10) {
            i iVar = cVar.f20468c;
            f fVar = this.f334c;
            if (h.maybeBlacklistTrack(fVar, fVar.indexOf(iVar), exc)) {
                return true;
            }
        }
        return false;
    }

    @Override // a6.b
    public void updateManifest(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        a.b[] bVarArr = this.f337f.f5995c;
        int i10 = this.f333b;
        a.b bVar = bVarArr[i10];
        int i11 = bVar.f6003d;
        a.b bVar2 = aVar.f5995c[i10];
        if (i11 == 0 || bVar2.f6003d == 0) {
            this.f338g += i11;
        } else {
            int i12 = i11 - 1;
            long chunkDurationUs = bVar.getChunkDurationUs(i12) + bVar.getStartTimeUs(i12);
            long startTimeUs = bVar2.getStartTimeUs(0);
            if (chunkDurationUs <= startTimeUs) {
                this.f338g += i11;
            } else {
                this.f338g = bVar.getChunkIndex(startTimeUs) + this.f338g;
            }
        }
        this.f337f = aVar;
    }

    @Override // v5.g
    public void onChunkLoadCompleted(v5.c cVar) {
    }
}
