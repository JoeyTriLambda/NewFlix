package k5;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.UUID;
import k5.a;
import l6.r;
import l6.u;

/* compiled from: FragmentedMp4Extractor.java */
/* loaded from: classes.dex */
public final class e implements g5.e {
    public static final int F = u.getIntegerCodeForString("seig");
    public static final byte[] G = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    public boolean A;
    public g5.g B;
    public g5.m C;
    public g5.m[] D;
    public boolean E;

    /* renamed from: a, reason: collision with root package name */
    public final int f14829a;

    /* renamed from: b, reason: collision with root package name */
    public final j f14830b;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray<b> f14831c;

    /* renamed from: d, reason: collision with root package name */
    public final l6.l f14832d;

    /* renamed from: e, reason: collision with root package name */
    public final l6.l f14833e;

    /* renamed from: f, reason: collision with root package name */
    public final l6.l f14834f;

    /* renamed from: g, reason: collision with root package name */
    public final l6.l f14835g;

    /* renamed from: h, reason: collision with root package name */
    public final l6.l f14836h;

    /* renamed from: i, reason: collision with root package name */
    public final r f14837i;

    /* renamed from: j, reason: collision with root package name */
    public final l6.l f14838j;

    /* renamed from: k, reason: collision with root package name */
    public final byte[] f14839k;

    /* renamed from: l, reason: collision with root package name */
    public final Stack<a.C0177a> f14840l;

    /* renamed from: m, reason: collision with root package name */
    public final LinkedList<a> f14841m;

    /* renamed from: n, reason: collision with root package name */
    public int f14842n;

    /* renamed from: o, reason: collision with root package name */
    public int f14843o;

    /* renamed from: p, reason: collision with root package name */
    public long f14844p;

    /* renamed from: q, reason: collision with root package name */
    public int f14845q;

    /* renamed from: r, reason: collision with root package name */
    public l6.l f14846r;

    /* renamed from: s, reason: collision with root package name */
    public long f14847s;

    /* renamed from: t, reason: collision with root package name */
    public int f14848t;

    /* renamed from: u, reason: collision with root package name */
    public long f14849u;

    /* renamed from: v, reason: collision with root package name */
    public long f14850v;

    /* renamed from: w, reason: collision with root package name */
    public b f14851w;

    /* renamed from: x, reason: collision with root package name */
    public int f14852x;

    /* renamed from: y, reason: collision with root package name */
    public int f14853y;

    /* renamed from: z, reason: collision with root package name */
    public int f14854z;

    /* compiled from: FragmentedMp4Extractor.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f14855a;

        /* renamed from: b, reason: collision with root package name */
        public final int f14856b;

        public a(long j10, int i10) {
            this.f14855a = j10;
            this.f14856b = i10;
        }
    }

    /* compiled from: FragmentedMp4Extractor.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final l f14857a = new l();

        /* renamed from: b, reason: collision with root package name */
        public final g5.m f14858b;

        /* renamed from: c, reason: collision with root package name */
        public j f14859c;

        /* renamed from: d, reason: collision with root package name */
        public c f14860d;

        /* renamed from: e, reason: collision with root package name */
        public int f14861e;

        /* renamed from: f, reason: collision with root package name */
        public int f14862f;

        /* renamed from: g, reason: collision with root package name */
        public int f14863g;

        public b(g5.m mVar) {
            this.f14858b = mVar;
        }

        public void init(j jVar, c cVar) {
            this.f14859c = (j) l6.a.checkNotNull(jVar);
            this.f14860d = (c) l6.a.checkNotNull(cVar);
            this.f14858b.format(jVar.f14917f);
            reset();
        }

        public void reset() {
            this.f14857a.reset();
            this.f14861e = 0;
            this.f14863g = 0;
            this.f14862f = 0;
        }

        public void updateDrmInitData(com.google.android.exoplayer2.drm.c cVar) {
            k sampleDescriptionEncryptionBox = this.f14859c.getSampleDescriptionEncryptionBox(this.f14857a.f14927a.f14820a);
            this.f14858b.format(this.f14859c.f14917f.copyWithDrmInitData(cVar.copyWithSchemeType(sampleDescriptionEncryptionBox != null ? sampleDescriptionEncryptionBox.f14923a : null)));
        }
    }

    public e(int i10) {
        this(i10, null);
    }

    public static com.google.android.exoplayer2.drm.c a(ArrayList arrayList) {
        int size = arrayList.size();
        ArrayList arrayList2 = null;
        for (int i10 = 0; i10 < size; i10++) {
            a.b bVar = (a.b) arrayList.get(i10);
            if (bVar.f14788a == k5.a.V) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                byte[] bArr = bVar.P0.f15881a;
                UUID uuid = h.parseUuid(bArr);
                if (uuid == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList2.add(new c.b(uuid, null, "video/mp4", bArr));
                }
            }
        }
        if (arrayList2 == null) {
            return null;
        }
        return new com.google.android.exoplayer2.drm.c(arrayList2);
    }

    public static void c(l6.l lVar, int i10, l lVar2) throws ParserException {
        lVar.setPosition(i10 + 8);
        int fullAtomFlags = k5.a.parseFullAtomFlags(lVar.readInt());
        if ((fullAtomFlags & 1) != 0) {
            throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z10 = (fullAtomFlags & 2) != 0;
        int unsignedIntToInt = lVar.readUnsignedIntToInt();
        if (unsignedIntToInt != lVar2.f14931e) {
            StringBuilder sbS = ac.c.s("Length mismatch: ", unsignedIntToInt, ", ");
            sbS.append(lVar2.f14931e);
            throw new ParserException(sbS.toString());
        }
        Arrays.fill(lVar2.f14939m, 0, unsignedIntToInt, z10);
        lVar2.initEncryptionData(lVar.bytesLeft());
        lVar2.fillEncryptionData(lVar);
    }

    public final void b() {
        int i10 = this.f14829a;
        int i11 = i10 & 4;
        SparseArray<b> sparseArray = this.f14831c;
        if (i11 != 0 && this.C == null) {
            g5.m mVarTrack = this.B.track(sparseArray.size(), 4);
            this.C = mVarTrack;
            mVarTrack.format(c5.i.createSampleFormat(null, "application/x-emsg", Long.MAX_VALUE));
        }
        if ((i10 & 8) == 0 || this.D != null) {
            return;
        }
        g5.m mVarTrack2 = this.B.track(sparseArray.size() + 1, 3);
        mVarTrack2.format(c5.i.createTextSampleFormat(null, "application/cea-608", 0, null));
        this.D = new g5.m[]{mVarTrack2};
    }

    /* JADX WARN: Code restructure failed: missing block: B:287:0x064e, code lost:
    
        r1.f14842n = 0;
        r1.f14845q = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x0655, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0362  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d(long r49) throws com.google.android.exoplayer2.ParserException {
        /*
            Method dump skipped, instructions count: 1622
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.e.d(long):void");
    }

    @Override // g5.e
    public void init(g5.g gVar) {
        this.B = gVar;
        j jVar = this.f14830b;
        if (jVar != null) {
            b bVar = new b(gVar.track(0, jVar.f14913b));
            bVar.init(jVar, new c(0, 0, 0, 0));
            this.f14831c.put(0, bVar);
            b();
            this.B.endTracks();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x026a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:281:0x05c4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0004 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ce A[LOOP:7: B:74:0x01ce->B:76:0x01d4, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0225 A[LOOP:6: B:89:0x021f->B:91:0x0225, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x025b  */
    @Override // g5.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read(g5.f r26, g5.k r27) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1484
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.e.read(g5.f, g5.k):int");
    }

    @Override // g5.e
    public void seek(long j10, long j11) {
        SparseArray<b> sparseArray = this.f14831c;
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseArray.valueAt(i10).reset();
        }
        this.f14841m.clear();
        this.f14848t = 0;
        this.f14840l.clear();
        this.f14842n = 0;
        this.f14845q = 0;
    }

    @Override // g5.e
    public boolean sniff(g5.f fVar) throws InterruptedException, IOException {
        return i.sniffFragmented(fVar);
    }

    public e(int i10, r rVar) {
        this(i10, rVar, null);
    }

    public e(int i10, r rVar, j jVar) {
        this.f14829a = i10 | (jVar != null ? 16 : 0);
        this.f14837i = rVar;
        this.f14830b = jVar;
        this.f14838j = new l6.l(16);
        this.f14832d = new l6.l(l6.j.f15860a);
        this.f14833e = new l6.l(5);
        this.f14834f = new l6.l();
        this.f14835g = new l6.l(1);
        this.f14836h = new l6.l();
        this.f14839k = new byte[16];
        this.f14840l = new Stack<>();
        this.f14841m = new LinkedList<>();
        this.f14831c = new SparseArray<>();
        this.f14849u = -9223372036854775807L;
        this.f14850v = -9223372036854775807L;
        this.f14842n = 0;
        this.f14845q = 0;
    }

    @Override // g5.e
    public void release() {
    }
}
