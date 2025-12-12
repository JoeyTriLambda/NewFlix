package w5;

import android.os.SystemClock;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.unity3d.services.core.device.MimeTypes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import k6.d;
import k6.m;
import l6.i;
import l6.u;
import v5.k;
import v5.l;
import w5.a;

/* compiled from: DefaultDashChunkSource.java */
/* loaded from: classes.dex */
public final class h implements w5.a {

    /* renamed from: a, reason: collision with root package name */
    public final m f21004a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f21005b;

    /* renamed from: c, reason: collision with root package name */
    public final j6.f f21006c;

    /* renamed from: d, reason: collision with root package name */
    public final int f21007d;

    /* renamed from: e, reason: collision with root package name */
    public final k6.d f21008e;

    /* renamed from: f, reason: collision with root package name */
    public final long f21009f;

    /* renamed from: g, reason: collision with root package name */
    public final int f21010g;

    /* renamed from: h, reason: collision with root package name */
    public final b[] f21011h;

    /* renamed from: i, reason: collision with root package name */
    public x5.b f21012i;

    /* renamed from: j, reason: collision with root package name */
    public int f21013j;

    /* renamed from: k, reason: collision with root package name */
    public BehindLiveWindowException f21014k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f21015l;

    /* compiled from: DefaultDashChunkSource.java */
    public static final class a implements a.InterfaceC0304a {

        /* renamed from: a, reason: collision with root package name */
        public final d.a f21016a;

        /* renamed from: b, reason: collision with root package name */
        public final int f21017b;

        public a(d.a aVar) {
            this(aVar, 1);
        }

        public w5.a createDashChunkSource(m mVar, x5.b bVar, int i10, int[] iArr, j6.f fVar, int i11, long j10, boolean z10, boolean z11) {
            return new h(mVar, bVar, i10, iArr, fVar, i11, this.f21016a.createDataSource(), j10, this.f21017b, z10, z11);
        }

        public a(d.a aVar, int i10) {
            this.f21016a = aVar;
            this.f21017b = i10;
        }
    }

    /* compiled from: DefaultDashChunkSource.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final v5.d f21018a;

        /* renamed from: b, reason: collision with root package name */
        public x5.g f21019b;

        /* renamed from: c, reason: collision with root package name */
        public f f21020c;

        /* renamed from: d, reason: collision with root package name */
        public long f21021d;

        /* renamed from: e, reason: collision with root package name */
        public int f21022e;

        public b(long j10, x5.g gVar, boolean z10, boolean z11) {
            g5.e eVar;
            this.f21021d = j10;
            this.f21019b = gVar;
            String str = gVar.f21591a.f5119p;
            if (i.isText(str) || "application/ttml+xml".equals(str)) {
                this.f21018a = null;
            } else {
                boolean zEquals = "application/x-rawcc".equals(str);
                c5.i iVar = gVar.f21591a;
                if (zEquals) {
                    eVar = new m5.a(iVar);
                } else {
                    if (str.startsWith(MimeTypes.VIDEO_WEBM) || str.startsWith("audio/webm") || str.startsWith("application/webm")) {
                        eVar = new i5.d(1);
                    } else {
                        int i10 = z10 ? 4 : 0;
                        eVar = new k5.e(z11 ? i10 | 8 : i10);
                    }
                }
                this.f21018a = new v5.d(eVar, iVar);
            }
            this.f21020c = gVar.getIndex();
        }

        public final void a(long j10, x5.g gVar) throws BehindLiveWindowException {
            int segmentCount;
            f index = this.f21019b.getIndex();
            f index2 = gVar.getIndex();
            this.f21021d = j10;
            this.f21019b = gVar;
            if (index == null) {
                return;
            }
            this.f21020c = index2;
            if (index.isExplicit() && (segmentCount = index.getSegmentCount(this.f21021d)) != 0) {
                int firstSegmentNum = (index.getFirstSegmentNum() + segmentCount) - 1;
                long durationUs = index.getDurationUs(firstSegmentNum, this.f21021d) + index.getTimeUs(firstSegmentNum);
                int firstSegmentNum2 = index2.getFirstSegmentNum();
                long timeUs = index2.getTimeUs(firstSegmentNum2);
                if (durationUs == timeUs) {
                    this.f21022e = ((firstSegmentNum + 1) - firstSegmentNum2) + this.f21022e;
                } else {
                    if (durationUs < timeUs) {
                        throw new BehindLiveWindowException();
                    }
                    this.f21022e = (index.getSegmentNum(timeUs, this.f21021d) - firstSegmentNum2) + this.f21022e;
                }
            }
        }

        public int getFirstSegmentNum() {
            return this.f21020c.getFirstSegmentNum() + this.f21022e;
        }

        public int getSegmentCount() {
            return this.f21020c.getSegmentCount(this.f21021d);
        }

        public long getSegmentEndTimeUs(int i10) {
            return this.f21020c.getDurationUs(i10 - this.f21022e, this.f21021d) + getSegmentStartTimeUs(i10);
        }

        public int getSegmentNum(long j10) {
            return this.f21020c.getSegmentNum(j10, this.f21021d) + this.f21022e;
        }

        public long getSegmentStartTimeUs(int i10) {
            return this.f21020c.getTimeUs(i10 - this.f21022e);
        }

        public x5.f getSegmentUrl(int i10) {
            return this.f21020c.getSegmentUrl(i10 - this.f21022e);
        }
    }

    public h(m mVar, x5.b bVar, int i10, int[] iArr, j6.f fVar, int i11, k6.d dVar, long j10, int i12, boolean z10, boolean z11) {
        this.f21004a = mVar;
        this.f21012i = bVar;
        this.f21005b = iArr;
        this.f21006c = fVar;
        this.f21007d = i11;
        this.f21008e = dVar;
        this.f21013j = i10;
        this.f21009f = j10;
        this.f21010g = i12;
        long periodDurationUs = bVar.getPeriodDurationUs(i10);
        ArrayList<x5.g> arrayListA = a();
        this.f21011h = new b[fVar.length()];
        for (int i13 = 0; i13 < this.f21011h.length; i13++) {
            this.f21011h[i13] = new b(periodDurationUs, arrayListA.get(fVar.getIndexInTrackGroup(i13)), z10, z11);
        }
    }

    public static v5.c newInitializationChunk(b bVar, k6.d dVar, c5.i iVar, int i10, Object obj, x5.f fVar, x5.f fVar2) {
        String str = bVar.f21019b.f21592b;
        if (fVar == null || (fVar2 = fVar.attemptMerge(fVar2, str)) != null) {
            fVar = fVar2;
        }
        return new k(dVar, new k6.f(fVar.resolveUri(str), fVar.f21587a, fVar.f21588b, bVar.f21019b.getCacheKey()), iVar, i10, obj, bVar.f21018a);
    }

    public static v5.c newMediaChunk(b bVar, k6.d dVar, int i10, c5.i iVar, int i11, Object obj, int i12, int i13) {
        x5.g gVar = bVar.f21019b;
        long segmentStartTimeUs = bVar.getSegmentStartTimeUs(i12);
        x5.f segmentUrl = bVar.getSegmentUrl(i12);
        String str = gVar.f21592b;
        if (bVar.f21018a == null) {
            return new v5.m(dVar, new k6.f(segmentUrl.resolveUri(str), segmentUrl.f21587a, segmentUrl.f21588b, gVar.getCacheKey()), iVar, i11, obj, segmentStartTimeUs, bVar.getSegmentEndTimeUs(i12), i12, i10, iVar);
        }
        int i14 = 1;
        int i15 = 1;
        while (i14 < i13) {
            x5.f fVarAttemptMerge = segmentUrl.attemptMerge(bVar.getSegmentUrl(i12 + i14), str);
            if (fVarAttemptMerge == null) {
                break;
            }
            i15++;
            i14++;
            segmentUrl = fVarAttemptMerge;
        }
        return new v5.i(dVar, new k6.f(segmentUrl.resolveUri(str), segmentUrl.f21587a, segmentUrl.f21588b, gVar.getCacheKey()), iVar, i11, obj, segmentStartTimeUs, bVar.getSegmentEndTimeUs((i12 + i15) - 1), i12, i15, -gVar.f21593c, bVar.f21018a);
    }

    public final ArrayList<x5.g> a() {
        List<x5.a> list = this.f21012i.getPeriod(this.f21013j).f21586c;
        ArrayList<x5.g> arrayList = new ArrayList<>();
        for (int i10 : this.f21005b) {
            arrayList.addAll(list.get(i10).f21559c);
        }
        return arrayList;
    }

    @Override // v5.g
    public void getNextChunk(l lVar, long j10, v5.e eVar) {
        int segmentNum;
        int nextChunkIndex;
        if (this.f21014k != null) {
            return;
        }
        long j11 = lVar != null ? lVar.f20472g - j10 : 0L;
        j6.f fVar = this.f21006c;
        fVar.updateSelectedTrack(j11);
        b bVar = this.f21011h[fVar.getSelectedIndex()];
        v5.d dVar = bVar.f21018a;
        if (dVar != null) {
            x5.g gVar = bVar.f21019b;
            x5.f initializationUri = dVar.getSampleFormats() == null ? gVar.getInitializationUri() : null;
            x5.f indexUri = bVar.f21020c == null ? gVar.getIndexUri() : null;
            if (initializationUri != null || indexUri != null) {
                eVar.f20486a = newInitializationChunk(bVar, this.f21008e, fVar.getSelectedFormat(), fVar.getSelectionReason(), fVar.getSelectionData(), initializationUri, indexUri);
                return;
            }
        }
        long j12 = this.f21009f;
        long jElapsedRealtime = (j12 != 0 ? SystemClock.elapsedRealtime() + j12 : System.currentTimeMillis()) * 1000;
        int segmentCount = bVar.getSegmentCount();
        if (segmentCount == 0) {
            x5.b bVar2 = this.f21012i;
            eVar.f20487b = !bVar2.f21564c || this.f21013j < bVar2.getPeriodCount() - 1;
            return;
        }
        int firstSegmentNum = bVar.getFirstSegmentNum();
        if (segmentCount == -1) {
            x5.b bVar3 = this.f21012i;
            long j13 = (jElapsedRealtime - (bVar3.f21562a * 1000)) - (bVar3.getPeriod(this.f21013j).f21585b * 1000);
            long j14 = this.f21012i.f21566e;
            if (j14 != -9223372036854775807L) {
                firstSegmentNum = Math.max(firstSegmentNum, bVar.getSegmentNum(j13 - (j14 * 1000)));
            }
            segmentNum = bVar.getSegmentNum(j13) - 1;
        } else {
            segmentNum = (segmentCount + firstSegmentNum) - 1;
        }
        if (lVar == null) {
            nextChunkIndex = u.constrainValue(bVar.getSegmentNum(j10), firstSegmentNum, segmentNum);
        } else {
            nextChunkIndex = lVar.getNextChunkIndex();
            if (nextChunkIndex < firstSegmentNum) {
                this.f21014k = new BehindLiveWindowException();
                return;
            }
        }
        if (nextChunkIndex <= segmentNum && (!this.f21015l || nextChunkIndex < segmentNum)) {
            eVar.f20486a = newMediaChunk(bVar, this.f21008e, this.f21007d, fVar.getSelectedFormat(), fVar.getSelectionReason(), fVar.getSelectionData(), nextChunkIndex, Math.min(this.f21010g, (segmentNum - nextChunkIndex) + 1));
        } else {
            x5.b bVar4 = this.f21012i;
            eVar.f20487b = !bVar4.f21564c || this.f21013j < bVar4.getPeriodCount() - 1;
        }
    }

    @Override // v5.g
    public void maybeThrowError() throws IOException {
        BehindLiveWindowException behindLiveWindowException = this.f21014k;
        if (behindLiveWindowException != null) {
            throw behindLiveWindowException;
        }
        this.f21004a.maybeThrowError();
    }

    @Override // v5.g
    public void onChunkLoadCompleted(v5.c cVar) {
        g5.l seekMap;
        if (cVar instanceof k) {
            b bVar = this.f21011h[this.f21006c.indexOf(((k) cVar).f20468c)];
            if (bVar.f21020c != null || (seekMap = bVar.f21018a.getSeekMap()) == null) {
                return;
            }
            bVar.f21020c = new g((g5.a) seekMap);
        }
    }

    @Override // v5.g
    public boolean onChunkLoadError(v5.c cVar, boolean z10, Exception exc) {
        if (!z10) {
            return false;
        }
        boolean z11 = this.f21012i.f21564c;
        j6.f fVar = this.f21006c;
        if (!z11 && (cVar instanceof l) && (exc instanceof HttpDataSource$InvalidResponseCodeException) && ((HttpDataSource$InvalidResponseCodeException) exc).f6027b == 404) {
            b bVar = this.f21011h[fVar.indexOf(cVar.f20468c)];
            int segmentCount = bVar.getSegmentCount();
            if (segmentCount != -1 && segmentCount != 0) {
                if (((l) cVar).getNextChunkIndex() > (bVar.getFirstSegmentNum() + segmentCount) - 1) {
                    this.f21015l = true;
                    return true;
                }
            }
        }
        return v5.h.maybeBlacklistTrack(fVar, fVar.indexOf(cVar.f20468c), exc);
    }

    @Override // w5.a
    public void updateManifest(x5.b bVar, int i10) {
        b[] bVarArr = this.f21011h;
        try {
            this.f21012i = bVar;
            this.f21013j = i10;
            long periodDurationUs = bVar.getPeriodDurationUs(i10);
            ArrayList<x5.g> arrayListA = a();
            for (int i11 = 0; i11 < bVarArr.length; i11++) {
                bVarArr[i11].a(periodDurationUs, arrayListA.get(this.f21006c.getIndexInTrackGroup(i11)));
            }
        } catch (BehindLiveWindowException e10) {
            this.f21014k = e10;
        }
    }
}
