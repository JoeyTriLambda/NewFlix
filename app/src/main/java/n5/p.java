package n5;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import g5.l;
import java.io.IOException;
import n5.v;

/* compiled from: PsExtractor.java */
/* loaded from: classes.dex */
public final class p implements g5.e {

    /* renamed from: a, reason: collision with root package name */
    public final l6.r f16675a;

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray<a> f16676b;

    /* renamed from: c, reason: collision with root package name */
    public final l6.l f16677c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16678d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16679e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16680f;

    /* renamed from: g, reason: collision with root package name */
    public g5.g f16681g;

    /* compiled from: PsExtractor.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final h f16682a;

        /* renamed from: b, reason: collision with root package name */
        public final l6.r f16683b;

        /* renamed from: c, reason: collision with root package name */
        public final l6.k f16684c = new l6.k(new byte[64]);

        /* renamed from: d, reason: collision with root package name */
        public boolean f16685d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f16686e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f16687f;

        /* renamed from: g, reason: collision with root package name */
        public long f16688g;

        public a(h hVar, l6.r rVar) {
            this.f16682a = hVar;
            this.f16683b = rVar;
        }

        public void consume(l6.l lVar) {
            l6.k kVar = this.f16684c;
            lVar.readBytes(kVar.f15877a, 0, 3);
            kVar.setPosition(0);
            kVar.skipBits(8);
            this.f16685d = kVar.readBit();
            this.f16686e = kVar.readBit();
            kVar.skipBits(6);
            lVar.readBytes(kVar.f15877a, 0, kVar.readBits(8));
            kVar.setPosition(0);
            this.f16688g = 0L;
            if (this.f16685d) {
                kVar.skipBits(4);
                kVar.skipBits(1);
                kVar.skipBits(1);
                long bits = (kVar.readBits(3) << 30) | (kVar.readBits(15) << 15) | kVar.readBits(15);
                kVar.skipBits(1);
                boolean z10 = this.f16687f;
                l6.r rVar = this.f16683b;
                if (!z10 && this.f16686e) {
                    kVar.skipBits(4);
                    kVar.skipBits(1);
                    kVar.skipBits(1);
                    kVar.skipBits(1);
                    rVar.adjustTsTimestamp(kVar.readBits(15) | (kVar.readBits(3) << 30) | (kVar.readBits(15) << 15));
                    this.f16687f = true;
                }
                this.f16688g = rVar.adjustTsTimestamp(bits);
            }
            long j10 = this.f16688g;
            h hVar = this.f16682a;
            hVar.packetStarted(j10, true);
            hVar.consume(lVar);
            hVar.packetFinished();
        }

        public void seek() {
            this.f16687f = false;
            this.f16682a.seek();
        }
    }

    public p() {
        this(new l6.r(0L));
    }

    @Override // g5.e
    public void init(g5.g gVar) {
        this.f16681g = gVar;
        gVar.seekMap(new l.a(-9223372036854775807L));
    }

    @Override // g5.e
    public int read(g5.f fVar, g5.k kVar) throws InterruptedException, IOException {
        h iVar;
        l6.l lVar = this.f16677c;
        g5.b bVar = (g5.b) fVar;
        if (!bVar.peekFully(lVar.f15881a, 0, 4, true)) {
            return -1;
        }
        lVar.setPosition(0);
        int i10 = lVar.readInt();
        if (i10 == 441) {
            return -1;
        }
        if (i10 == 442) {
            bVar.peekFully(lVar.f15881a, 0, 10);
            lVar.setPosition(9);
            bVar.skipFully((lVar.readUnsignedByte() & 7) + 14);
            return 0;
        }
        if (i10 == 443) {
            bVar.peekFully(lVar.f15881a, 0, 2);
            lVar.setPosition(0);
            bVar.skipFully(lVar.readUnsignedShort() + 6);
            return 0;
        }
        if (((i10 & (-256)) >> 8) != 1) {
            bVar.skipFully(1);
            return 0;
        }
        int i11 = i10 & 255;
        SparseArray<a> sparseArray = this.f16676b;
        a aVar = sparseArray.get(i11);
        if (!this.f16678d) {
            if (aVar == null) {
                boolean z10 = this.f16679e;
                if (!z10 && i11 == 189) {
                    iVar = new b();
                    this.f16679e = true;
                } else if (!z10 && (i11 & 224) == 192) {
                    iVar = new m();
                    this.f16679e = true;
                } else if (this.f16680f || (i11 & 240) != 224) {
                    iVar = null;
                } else {
                    iVar = new i();
                    this.f16680f = true;
                }
                if (iVar != null) {
                    iVar.createTracks(this.f16681g, new v.d(i11, 256));
                    aVar = new a(iVar, this.f16675a);
                    sparseArray.put(i11, aVar);
                }
            }
            if ((this.f16679e && this.f16680f) || bVar.getPosition() > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                this.f16678d = true;
                this.f16681g.endTracks();
            }
        }
        bVar.peekFully(lVar.f15881a, 0, 2);
        lVar.setPosition(0);
        int unsignedShort = lVar.readUnsignedShort() + 6;
        if (aVar == null) {
            bVar.skipFully(unsignedShort);
        } else {
            lVar.reset(unsignedShort);
            bVar.readFully(lVar.f15881a, 0, unsignedShort);
            lVar.setPosition(6);
            aVar.consume(lVar);
            lVar.setLimit(lVar.capacity());
        }
        return 0;
    }

    @Override // g5.e
    public void seek(long j10, long j11) {
        this.f16675a.reset();
        int i10 = 0;
        while (true) {
            SparseArray<a> sparseArray = this.f16676b;
            if (i10 >= sparseArray.size()) {
                return;
            }
            sparseArray.valueAt(i10).seek();
            i10++;
        }
    }

    @Override // g5.e
    public boolean sniff(g5.f fVar) throws InterruptedException, IOException {
        byte[] bArr = new byte[14];
        g5.b bVar = (g5.b) fVar;
        bVar.peekFully(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        bVar.advancePeekPosition(bArr[13] & 7);
        bVar.peekFully(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    public p(l6.r rVar) {
        this.f16675a = rVar;
        this.f16677c = new l6.l(4096);
        this.f16676b = new SparseArray<>();
    }

    @Override // g5.e
    public void release() {
    }
}
