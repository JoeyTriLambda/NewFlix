package y5;

import com.google.android.exoplayer2.source.hls.playlist.a;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import l6.r;
import q5.a;

/* compiled from: HlsMediaChunk.java */
/* loaded from: classes.dex */
public final class f extends v5.l {
    public static final AtomicInteger G = new AtomicInteger();
    public int A;
    public int B;
    public boolean C;
    public j D;
    public volatile boolean E;
    public volatile boolean F;

    /* renamed from: j, reason: collision with root package name */
    public final int f21940j;

    /* renamed from: k, reason: collision with root package name */
    public final int f21941k;

    /* renamed from: l, reason: collision with root package name */
    public final a.C0072a f21942l;

    /* renamed from: m, reason: collision with root package name */
    public final k6.d f21943m;

    /* renamed from: n, reason: collision with root package name */
    public final k6.f f21944n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f21945o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f21946p;

    /* renamed from: q, reason: collision with root package name */
    public final r f21947q;

    /* renamed from: r, reason: collision with root package name */
    public final String f21948r;

    /* renamed from: s, reason: collision with root package name */
    public final g5.e f21949s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f21950t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f21951u;

    /* renamed from: v, reason: collision with root package name */
    public final List<c5.i> f21952v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f21953w;

    /* renamed from: x, reason: collision with root package name */
    public final s5.g f21954x;

    /* renamed from: y, reason: collision with root package name */
    public final l6.l f21955y;

    /* renamed from: z, reason: collision with root package name */
    public g5.e f21956z;

    public f(k6.d dVar, k6.f fVar, k6.f fVar2, a.C0072a c0072a, List<c5.i> list, int i10, Object obj, long j10, long j11, int i11, int i12, boolean z10, r rVar, f fVar3, byte[] bArr, byte[] bArr2) {
        super((bArr == null || bArr2 == null) ? dVar : new a(dVar, bArr, bArr2), fVar, c0072a.f5912b, i10, obj, j10, j11, i11);
        this.f21941k = i12;
        this.f21944n = fVar2;
        this.f21942l = c0072a;
        this.f21952v = list;
        this.f21946p = z10;
        this.f21947q = rVar;
        this.f21945o = this.f20473h instanceof a;
        String lastPathSegment = fVar.f14959a.getLastPathSegment();
        this.f21948r = lastPathSegment;
        boolean z11 = lastPathSegment.endsWith(".aac") || lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3") || lastPathSegment.endsWith(".mp3");
        this.f21953w = z11;
        if (fVar3 != null) {
            this.f21954x = fVar3.f21954x;
            this.f21955y = fVar3.f21955y;
            this.f21949s = fVar3.f21956z;
            boolean z12 = fVar3.f21942l != c0072a;
            this.f21950t = z12;
            this.f21951u = fVar3.f21941k != i12 || z12;
        } else {
            this.f21954x = z11 ? new s5.g() : null;
            this.f21955y = z11 ? new l6.l(10) : null;
            this.f21949s = null;
            this.f21950t = false;
            this.f21951u = true;
        }
        this.f21943m = dVar;
        this.f21940j = G.getAndIncrement();
    }

    public final g5.e a(long j10) {
        g5.e aVar;
        String str = this.f21948r;
        if (str.endsWith(".aac")) {
            aVar = new n5.c(j10);
        } else if (str.endsWith(".ac3") || str.endsWith(".ec3")) {
            aVar = new n5.a(j10);
        } else {
            if (!str.endsWith(".mp3")) {
                throw new IllegalArgumentException("Unknown extension for audio file: " + str);
            }
            aVar = new j5.b(0, j10);
        }
        aVar.init(this.D);
        return aVar;
    }

    public final long b(g5.b bVar) throws InterruptedException, IOException {
        q5.a aVarDecode;
        bVar.resetPeekPosition();
        l6.l lVar = this.f21955y;
        if (!bVar.peekFully(lVar.f15881a, 0, 10, true)) {
            return -9223372036854775807L;
        }
        lVar.reset(10);
        if (lVar.readUnsignedInt24() != s5.g.f19091b) {
            return -9223372036854775807L;
        }
        lVar.skipBytes(3);
        int synchSafeInt = lVar.readSynchSafeInt();
        int i10 = synchSafeInt + 10;
        if (i10 > lVar.capacity()) {
            byte[] bArr = lVar.f15881a;
            lVar.reset(i10);
            System.arraycopy(bArr, 0, lVar.f15881a, 0, 10);
        }
        if (!bVar.peekFully(lVar.f15881a, 10, synchSafeInt, true) || (aVarDecode = this.f21954x.decode(lVar.f15881a, synchSafeInt)) == null) {
            return -9223372036854775807L;
        }
        int length = aVarDecode.length();
        for (int i11 = 0; i11 < length; i11++) {
            a.b bVar2 = aVarDecode.get(i11);
            if (bVar2 instanceof s5.i) {
                s5.i iVar = (s5.i) bVar2;
                if ("com.apple.streaming.transportStreamTimestamp".equals(iVar.f19097m)) {
                    System.arraycopy(iVar.f19098n, 0, lVar.f15881a, 0, 8);
                    lVar.reset(8);
                    return lVar.readLong();
                }
            }
        }
        return -9223372036854775807L;
    }

    @Override // v5.c
    public long bytesLoaded() {
        return this.B;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void cancelLoad() {
        this.E = true;
    }

    public void init(j jVar) {
        this.D = jVar;
        jVar.init(this.f21940j, this.f21950t);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public boolean isLoadCanceled() {
        return this.E;
    }

    @Override // v5.l
    public boolean isLoadCompleted() {
        return this.F;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0170 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x014b A[Catch: all -> 0x019d, TryCatch #3 {all -> 0x019d, blocks: (B:78:0x0139, B:80:0x014b, B:82:0x0158, B:84:0x0161, B:83:0x015f, B:86:0x0169, B:95:0x0189, B:93:0x017c, B:94:0x0188, B:88:0x0170, B:90:0x0174), top: B:106:0x0139, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0169 A[Catch: all -> 0x019d, TRY_LEAVE, TryCatch #3 {all -> 0x019d, blocks: (B:78:0x0139, B:80:0x014b, B:82:0x0158, B:84:0x0161, B:83:0x015f, B:86:0x0169, B:95:0x0189, B:93:0x017c, B:94:0x0188, B:88:0x0170, B:90:0x0174), top: B:106:0x0139, inners: #2 }] */
    @Override // com.google.android.exoplayer2.upstream.Loader.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void load() throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 421
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: y5.f.load():void");
    }
}
