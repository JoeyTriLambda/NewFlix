package w5;

import android.util.Pair;
import android.util.SparseIntArray;
import c5.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import k6.m;
import u5.a;
import u5.g;
import u5.l;
import u5.n;
import u5.o;
import w5.a;

/* compiled from: DashMediaPeriod.java */
/* loaded from: classes.dex */
public final class b implements u5.g, l.a<v5.f<w5.a>> {

    /* renamed from: b, reason: collision with root package name */
    public final int f20953b;

    /* renamed from: m, reason: collision with root package name */
    public final a.InterfaceC0304a f20954m;

    /* renamed from: n, reason: collision with root package name */
    public final int f20955n;

    /* renamed from: o, reason: collision with root package name */
    public final a.C0284a f20956o;

    /* renamed from: p, reason: collision with root package name */
    public final long f20957p;

    /* renamed from: q, reason: collision with root package name */
    public final m f20958q;

    /* renamed from: r, reason: collision with root package name */
    public final k6.b f20959r;

    /* renamed from: s, reason: collision with root package name */
    public final o f20960s;

    /* renamed from: t, reason: collision with root package name */
    public final a[] f20961t;

    /* renamed from: u, reason: collision with root package name */
    public g.a f20962u;

    /* renamed from: v, reason: collision with root package name */
    public v5.f<w5.a>[] f20963v;

    /* renamed from: w, reason: collision with root package name */
    public u5.c f20964w;

    /* renamed from: x, reason: collision with root package name */
    public x5.b f20965x;

    /* renamed from: y, reason: collision with root package name */
    public int f20966y;

    /* renamed from: z, reason: collision with root package name */
    public List<x5.a> f20967z;

    /* compiled from: DashMediaPeriod.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f20968a;

        /* renamed from: b, reason: collision with root package name */
        public final int f20969b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f20970c;

        /* renamed from: d, reason: collision with root package name */
        public final int f20971d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f20972e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f20973f;

        public a(int i10, int[] iArr, int i11, boolean z10, boolean z11, boolean z12) {
            this.f20969b = i10;
            this.f20968a = iArr;
            this.f20971d = i11;
            this.f20970c = z10;
            this.f20972e = z11;
            this.f20973f = z12;
        }
    }

    public b(int i10, x5.b bVar, int i11, a.InterfaceC0304a interfaceC0304a, int i12, a.C0284a c0284a, long j10, m mVar, k6.b bVar2) {
        int i13;
        boolean z10;
        boolean z11;
        x5.d dVar;
        int i14;
        this.f20953b = i10;
        this.f20965x = bVar;
        this.f20966y = i11;
        this.f20954m = interfaceC0304a;
        this.f20955n = i12;
        this.f20956o = c0284a;
        this.f20957p = j10;
        this.f20958q = mVar;
        this.f20959r = bVar2;
        v5.f<w5.a>[] fVarArr = new v5.f[0];
        this.f20963v = fVarArr;
        this.f20964w = new u5.c(fVarArr);
        List<x5.a> list = bVar.getPeriod(i11).f21586c;
        this.f20967z = list;
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        for (int i15 = 0; i15 < size; i15++) {
            sparseIntArray.put(list.get(i15).f21557a, i15);
        }
        int[][] iArr = new int[size][];
        boolean[] zArr = new boolean[size];
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            if (!zArr[i17]) {
                zArr[i17] = true;
                List<x5.d> list2 = list.get(i17).f21561e;
                int i18 = 0;
                while (true) {
                    if (i18 >= list2.size()) {
                        dVar = null;
                        break;
                    }
                    x5.d dVar2 = list2.get(i18);
                    if ("urn:mpeg:dash:adaptation-set-switching:2016".equals(dVar2.f21581a)) {
                        dVar = dVar2;
                        break;
                    }
                    i18++;
                }
                if (dVar == null) {
                    i14 = i16 + 1;
                    iArr[i16] = new int[]{i17};
                } else {
                    String[] strArrSplit = dVar.f21582b.split(",");
                    int[] iArr2 = new int[strArrSplit.length + 1];
                    iArr2[0] = i17;
                    int i19 = 0;
                    while (i19 < strArrSplit.length) {
                        int i20 = sparseIntArray.get(Integer.parseInt(strArrSplit[i19]));
                        zArr[i20] = true;
                        i19++;
                        iArr2[i19] = i20;
                    }
                    i14 = i16 + 1;
                    iArr[i16] = iArr2;
                }
                i16 = i14;
            }
        }
        iArr = i16 < size ? (int[][]) Arrays.copyOf(iArr, i16) : iArr;
        int length = iArr.length;
        boolean[] zArr2 = new boolean[length];
        boolean[] zArr3 = new boolean[length];
        int i21 = length;
        for (int i22 = 0; i22 < length; i22++) {
            int[] iArr3 = iArr[i22];
            int length2 = iArr3.length;
            int i23 = 0;
            while (true) {
                if (i23 >= length2) {
                    z10 = false;
                    break;
                }
                List<x5.g> list3 = list.get(iArr3[i23]).f21559c;
                for (int i24 = 0; i24 < list3.size(); i24++) {
                    if (!list3.get(i24).f21594d.isEmpty()) {
                        z10 = true;
                        break;
                    }
                }
                i23++;
            }
            if (z10) {
                zArr2[i22] = true;
                i21++;
            }
            int[] iArr4 = iArr[i22];
            int length3 = iArr4.length;
            int i25 = 0;
            while (true) {
                if (i25 >= length3) {
                    z11 = false;
                    break;
                }
                List<x5.d> list4 = list.get(iArr4[i25]).f21560d;
                for (int i26 = 0; i26 < list4.size(); i26++) {
                    if ("urn:scte:dash:cc:cea-608:2015".equals(list4.get(i26).f21581a)) {
                        z11 = true;
                        break;
                    }
                }
                i25++;
            }
            if (z11) {
                zArr3[i22] = true;
                i21++;
            }
        }
        n[] nVarArr = new n[i21];
        a[] aVarArr = new a[i21];
        int i27 = 0;
        int i28 = 0;
        while (i27 < length) {
            int[] iArr5 = iArr[i27];
            ArrayList arrayList = new ArrayList();
            for (int i29 : iArr5) {
                arrayList.addAll(list.get(i29).f21559c);
            }
            int size2 = arrayList.size();
            i[] iVarArr = new i[size2];
            for (int i30 = 0; i30 < size2; i30++) {
                iVarArr[i30] = ((x5.g) arrayList.get(i30)).f21591a;
            }
            x5.a aVar = list.get(iArr5[0]);
            boolean z12 = zArr2[i27];
            boolean z13 = zArr3[i27];
            nVarArr[i28] = new n(iVarArr);
            int i31 = i28 + 1;
            aVarArr[i28] = new a(aVar.f21558b, iArr5, i28, true, z12, z13);
            int i32 = aVar.f21557a;
            if (z12) {
                nVarArr[i31] = new n(i.createSampleFormat(i32 + ":emsg", "application/x-emsg", null, -1, null));
                aVarArr[i31] = new a(4, iArr5, i28, false, false, false);
                i31++;
            }
            if (z13) {
                nVarArr[i31] = new n(i.createTextSampleFormat(i32 + ":cea608", "application/cea-608", 0, null));
                i13 = i31 + 1;
                aVarArr[i31] = new a(3, iArr5, i28, false, false, false);
            } else {
                i13 = i31;
            }
            i27++;
            i28 = i13;
        }
        Pair pairCreate = Pair.create(new o(nVarArr), aVarArr);
        this.f20960s = (o) pairCreate.first;
        this.f20961t = (a[]) pairCreate.second;
    }

    @Override // u5.g, u5.l
    public boolean continueLoading(long j10) {
        return this.f20964w.continueLoading(j10);
    }

    @Override // u5.g
    public void discardBuffer(long j10) {
        for (v5.f<w5.a> fVar : this.f20963v) {
            fVar.discardEmbeddedTracksTo(j10);
        }
    }

    @Override // u5.g, u5.l
    public long getBufferedPositionUs() {
        return this.f20964w.getBufferedPositionUs();
    }

    @Override // u5.g, u5.l
    public long getNextLoadPositionUs() {
        return this.f20964w.getNextLoadPositionUs();
    }

    @Override // u5.g
    public o getTrackGroups() {
        return this.f20960s;
    }

    @Override // u5.g
    public void maybeThrowPrepareError() throws IOException {
        this.f20958q.maybeThrowError();
    }

    @Override // u5.g
    public void prepare(g.a aVar, long j10) {
        this.f20962u = aVar;
        aVar.onPrepared(this);
    }

    @Override // u5.g
    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    public void release() {
        for (v5.f<w5.a> fVar : this.f20963v) {
            fVar.release();
        }
    }

    @Override // u5.g
    public long seekToUs(long j10) {
        for (v5.f<w5.a> fVar : this.f20963v) {
            fVar.seekToUs(j10);
        }
        return j10;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0135  */
    @Override // u5.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long selectTracks(j6.f[] r30, boolean[] r31, u5.k[] r32, boolean[] r33, long r34) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: w5.b.selectTracks(j6.f[], boolean[], u5.k[], boolean[], long):long");
    }

    public void updateManifest(x5.b bVar, int i10) {
        this.f20965x = bVar;
        this.f20966y = i10;
        this.f20967z = bVar.getPeriod(i10).f21586c;
        v5.f<w5.a>[] fVarArr = this.f20963v;
        if (fVarArr != null) {
            for (v5.f<w5.a> fVar : fVarArr) {
                ((w5.a) fVar.getChunkSource()).updateManifest(bVar, i10);
            }
            this.f20962u.onContinueLoadingRequested(this);
        }
    }

    @Override // u5.l.a
    public void onContinueLoadingRequested(v5.f<w5.a> fVar) {
        this.f20962u.onContinueLoadingRequested(this);
    }
}
