package n5;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import g5.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import n5.v;

/* compiled from: TsExtractor.java */
/* loaded from: classes.dex */
public final class u implements g5.e {

    /* renamed from: l, reason: collision with root package name */
    public static final long f16700l = l6.u.getIntegerCodeForString("AC-3");

    /* renamed from: m, reason: collision with root package name */
    public static final long f16701m = l6.u.getIntegerCodeForString("EAC3");

    /* renamed from: n, reason: collision with root package name */
    public static final long f16702n = l6.u.getIntegerCodeForString("HEVC");

    /* renamed from: a, reason: collision with root package name */
    public final int f16703a;

    /* renamed from: b, reason: collision with root package name */
    public final List<l6.r> f16704b;

    /* renamed from: c, reason: collision with root package name */
    public final l6.l f16705c;

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f16706d;

    /* renamed from: e, reason: collision with root package name */
    public final v.c f16707e;

    /* renamed from: f, reason: collision with root package name */
    public final SparseArray<v> f16708f;

    /* renamed from: g, reason: collision with root package name */
    public final SparseBooleanArray f16709g;

    /* renamed from: h, reason: collision with root package name */
    public g5.g f16710h;

    /* renamed from: i, reason: collision with root package name */
    public int f16711i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f16712j;

    /* renamed from: k, reason: collision with root package name */
    public v f16713k;

    public u(int i10, int i11) {
        this(i10, new l6.r(0L), new e(i11));
    }

    public final void a() {
        this.f16709g.clear();
        SparseArray<v> sparseArray = this.f16708f;
        sparseArray.clear();
        SparseArray<v> sparseArrayCreateInitialPayloadReaders = this.f16707e.createInitialPayloadReaders();
        int size = sparseArrayCreateInitialPayloadReaders.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseArray.put(sparseArrayCreateInitialPayloadReaders.keyAt(i10), sparseArrayCreateInitialPayloadReaders.valueAt(i10));
        }
        sparseArray.put(0, new r(new a()));
        this.f16713k = null;
    }

    @Override // g5.e
    public void init(g5.g gVar) {
        this.f16710h = gVar;
        gVar.seekMap(new l.a(-9223372036854775807L));
    }

    @Override // g5.e
    public int read(g5.f fVar, g5.k kVar) throws InterruptedException, IOException {
        v vVar;
        l6.l lVar = this.f16705c;
        byte[] bArr = lVar.f15881a;
        if (9400 - lVar.getPosition() < 188) {
            int iBytesLeft = lVar.bytesLeft();
            if (iBytesLeft > 0) {
                System.arraycopy(bArr, lVar.getPosition(), bArr, 0, iBytesLeft);
            }
            lVar.reset(bArr, iBytesLeft);
        }
        while (lVar.bytesLeft() < 188) {
            int iLimit = lVar.limit();
            int i10 = ((g5.b) fVar).read(bArr, iLimit, 9400 - iLimit);
            if (i10 == -1) {
                return -1;
            }
            lVar.setLimit(iLimit + i10);
        }
        int iLimit2 = lVar.limit();
        int position = lVar.getPosition();
        while (position < iLimit2 && bArr[position] != 71) {
            position++;
        }
        lVar.setPosition(position);
        int i11 = position + 188;
        if (i11 > iLimit2) {
            return 0;
        }
        int i12 = lVar.readInt();
        if ((8388608 & i12) != 0) {
            lVar.setPosition(i11);
            return 0;
        }
        boolean z10 = true;
        boolean z11 = (4194304 & i12) != 0;
        int i13 = (2096896 & i12) >> 8;
        boolean z12 = (i12 & 32) != 0;
        boolean z13 = (i12 & 16) != 0;
        if (this.f16703a != 2) {
            int i14 = i12 & 15;
            SparseIntArray sparseIntArray = this.f16706d;
            int i15 = sparseIntArray.get(i13, i14 - 1);
            sparseIntArray.put(i13, i14);
            if (i15 == i14) {
                if (z13) {
                    lVar.setPosition(i11);
                    return 0;
                }
            } else if (i14 == ((i15 + 1) & 15)) {
            }
            z10 = false;
        } else {
            z10 = false;
        }
        if (z12) {
            lVar.skipBytes(lVar.readUnsignedByte());
        }
        if (z13 && (vVar = this.f16708f.get(i13)) != null) {
            if (z10) {
                vVar.seek();
            }
            lVar.setLimit(i11);
            vVar.consume(lVar, z11);
            lVar.setLimit(iLimit2);
        }
        lVar.setPosition(i11);
        return 0;
    }

    @Override // g5.e
    public void seek(long j10, long j11) {
        List<l6.r> list = this.f16704b;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            list.get(i10).reset();
        }
        this.f16705c.reset();
        this.f16706d.clear();
        a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
    
        r2 = r2 + 1;
     */
    @Override // g5.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean sniff(g5.f r7) throws java.lang.InterruptedException, java.io.IOException {
        /*
            r6 = this;
            l6.l r0 = r6.f16705c
            byte[] r0 = r0.f15881a
            g5.b r7 = (g5.b) r7
            r1 = 0
            r2 = 940(0x3ac, float:1.317E-42)
            r7.peekFully(r0, r1, r2)
            r2 = 0
        Ld:
            r3 = 188(0xbc, float:2.63E-43)
            if (r2 >= r3) goto L29
            r3 = 0
        L12:
            r4 = 5
            if (r3 != r4) goto L1a
            r7.skipFully(r2)
            r7 = 1
            return r7
        L1a:
            int r4 = r3 * 188
            int r4 = r4 + r2
            r4 = r0[r4]
            r5 = 71
            if (r4 == r5) goto L26
            int r2 = r2 + 1
            goto Ld
        L26:
            int r3 = r3 + 1
            goto L12
        L29:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: n5.u.sniff(g5.f):boolean");
    }

    public u(int i10, l6.r rVar, v.c cVar) {
        this.f16707e = (v.c) l6.a.checkNotNull(cVar);
        this.f16703a = i10;
        if (i10 == 1 || i10 == 2) {
            this.f16704b = Collections.singletonList(rVar);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f16704b = arrayList;
            arrayList.add(rVar);
        }
        this.f16705c = new l6.l(9400);
        this.f16709g = new SparseBooleanArray();
        this.f16708f = new SparseArray<>();
        this.f16706d = new SparseIntArray();
        a();
    }

    @Override // g5.e
    public void release() {
    }

    /* compiled from: TsExtractor.java */
    public class a implements q {

        /* renamed from: a, reason: collision with root package name */
        public final l6.k f16714a = new l6.k(new byte[4]);

        public a() {
        }

        @Override // n5.q
        public void consume(l6.l lVar) {
            u uVar;
            if (lVar.readUnsignedByte() != 0) {
                return;
            }
            lVar.skipBytes(7);
            int iBytesLeft = lVar.bytesLeft() / 4;
            int i10 = 0;
            while (true) {
                uVar = u.this;
                if (i10 >= iBytesLeft) {
                    break;
                }
                l6.k kVar = this.f16714a;
                lVar.readBytes(kVar, 4);
                int bits = kVar.readBits(16);
                kVar.skipBits(3);
                if (bits == 0) {
                    kVar.skipBits(13);
                } else {
                    int bits2 = kVar.readBits(13);
                    uVar.f16708f.put(bits2, new r(uVar.new b(bits2)));
                    uVar.f16711i++;
                }
                i10++;
            }
            if (uVar.f16703a != 2) {
                uVar.f16708f.remove(0);
            }
        }

        @Override // n5.q
        public void init(l6.r rVar, g5.g gVar, v.d dVar) {
        }
    }

    /* compiled from: TsExtractor.java */
    public class b implements q {

        /* renamed from: a, reason: collision with root package name */
        public final l6.k f16716a = new l6.k(new byte[5]);

        /* renamed from: b, reason: collision with root package name */
        public final SparseArray<v> f16717b = new SparseArray<>();

        /* renamed from: c, reason: collision with root package name */
        public final SparseIntArray f16718c = new SparseIntArray();

        /* renamed from: d, reason: collision with root package name */
        public final int f16719d;

        public b(int i10) {
            this.f16719d = i10;
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x00f6  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0107  */
        @Override // n5.q
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void consume(l6.l r26) {
            /*
                Method dump skipped, instructions count: 652
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: n5.u.b.consume(l6.l):void");
        }

        @Override // n5.q
        public void init(l6.r rVar, g5.g gVar, v.d dVar) {
        }
    }
}
