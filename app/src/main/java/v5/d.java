package v5;

import android.util.SparseArray;
import g5.m;
import java.io.IOException;

/* compiled from: ChunkExtractorWrapper.java */
/* loaded from: classes.dex */
public final class d implements g5.g {

    /* renamed from: b, reason: collision with root package name */
    public final g5.e f20474b;

    /* renamed from: m, reason: collision with root package name */
    public final c5.i f20475m;

    /* renamed from: n, reason: collision with root package name */
    public final SparseArray<a> f20476n = new SparseArray<>();

    /* renamed from: o, reason: collision with root package name */
    public boolean f20477o;

    /* renamed from: p, reason: collision with root package name */
    public b f20478p;

    /* renamed from: q, reason: collision with root package name */
    public g5.l f20479q;

    /* renamed from: r, reason: collision with root package name */
    public c5.i[] f20480r;

    /* compiled from: ChunkExtractorWrapper.java */
    public static final class a implements g5.m {

        /* renamed from: a, reason: collision with root package name */
        public final int f20481a;

        /* renamed from: b, reason: collision with root package name */
        public final int f20482b;

        /* renamed from: c, reason: collision with root package name */
        public final c5.i f20483c;

        /* renamed from: d, reason: collision with root package name */
        public c5.i f20484d;

        /* renamed from: e, reason: collision with root package name */
        public g5.m f20485e;

        public a(int i10, int i11, c5.i iVar) {
            this.f20481a = i10;
            this.f20482b = i11;
            this.f20483c = iVar;
        }

        public void bind(b bVar) {
            if (bVar == null) {
                this.f20485e = new g5.d();
                return;
            }
            g5.m mVarTrack = ((v5.b) bVar).track(this.f20481a, this.f20482b);
            this.f20485e = mVarTrack;
            if (mVarTrack != null) {
                mVarTrack.format(this.f20484d);
            }
        }

        @Override // g5.m
        public void format(c5.i iVar) {
            c5.i iVarCopyWithManifestFormatInfo = iVar.copyWithManifestFormatInfo(this.f20483c);
            this.f20484d = iVarCopyWithManifestFormatInfo;
            this.f20485e.format(iVarCopyWithManifestFormatInfo);
        }

        @Override // g5.m
        public int sampleData(g5.f fVar, int i10, boolean z10) throws InterruptedException, IOException {
            return this.f20485e.sampleData(fVar, i10, z10);
        }

        @Override // g5.m
        public void sampleMetadata(long j10, int i10, int i11, int i12, m.a aVar) {
            this.f20485e.sampleMetadata(j10, i10, i11, i12, aVar);
        }

        @Override // g5.m
        public void sampleData(l6.l lVar, int i10) {
            this.f20485e.sampleData(lVar, i10);
        }
    }

    /* compiled from: ChunkExtractorWrapper.java */
    public interface b {
    }

    public d(g5.e eVar, c5.i iVar) {
        this.f20474b = eVar;
        this.f20475m = iVar;
    }

    @Override // g5.g
    public void endTracks() {
        SparseArray<a> sparseArray = this.f20476n;
        c5.i[] iVarArr = new c5.i[sparseArray.size()];
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            iVarArr[i10] = sparseArray.valueAt(i10).f20484d;
        }
        this.f20480r = iVarArr;
    }

    public c5.i[] getSampleFormats() {
        return this.f20480r;
    }

    public g5.l getSeekMap() {
        return this.f20479q;
    }

    public void init(b bVar) {
        this.f20478p = bVar;
        boolean z10 = this.f20477o;
        g5.e eVar = this.f20474b;
        if (!z10) {
            eVar.init(this);
            this.f20477o = true;
            return;
        }
        eVar.seek(0L, 0L);
        int i10 = 0;
        while (true) {
            SparseArray<a> sparseArray = this.f20476n;
            if (i10 >= sparseArray.size()) {
                return;
            }
            sparseArray.valueAt(i10).bind(bVar);
            i10++;
        }
    }

    @Override // g5.g
    public void seekMap(g5.l lVar) {
        this.f20479q = lVar;
    }

    @Override // g5.g
    public g5.m track(int i10, int i11) {
        SparseArray<a> sparseArray = this.f20476n;
        a aVar = sparseArray.get(i10);
        if (aVar != null) {
            return aVar;
        }
        l6.a.checkState(this.f20480r == null);
        a aVar2 = new a(i10, i11, this.f20475m);
        aVar2.bind(this.f20478p);
        sparseArray.put(i10, aVar2);
        return aVar2;
    }
}
