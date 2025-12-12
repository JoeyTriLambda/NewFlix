package k5;

import android.util.Pair;
import java.util.ArrayList;
import k5.a;
import l6.u;
import q5.a;

/* compiled from: AtomParsers.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int f14789a = u.getIntegerCodeForString("vide");

    /* renamed from: b, reason: collision with root package name */
    public static final int f14790b = u.getIntegerCodeForString("soun");

    /* renamed from: c, reason: collision with root package name */
    public static final int f14791c = u.getIntegerCodeForString("text");

    /* renamed from: d, reason: collision with root package name */
    public static final int f14792d = u.getIntegerCodeForString("sbtl");

    /* renamed from: e, reason: collision with root package name */
    public static final int f14793e = u.getIntegerCodeForString("subt");

    /* renamed from: f, reason: collision with root package name */
    public static final int f14794f = u.getIntegerCodeForString("clcp");

    /* renamed from: g, reason: collision with root package name */
    public static final int f14795g;

    /* compiled from: AtomParsers.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f14796a;

        /* renamed from: b, reason: collision with root package name */
        public int f14797b;

        /* renamed from: c, reason: collision with root package name */
        public int f14798c;

        /* renamed from: d, reason: collision with root package name */
        public long f14799d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f14800e;

        /* renamed from: f, reason: collision with root package name */
        public final l6.l f14801f;

        /* renamed from: g, reason: collision with root package name */
        public final l6.l f14802g;

        /* renamed from: h, reason: collision with root package name */
        public int f14803h;

        /* renamed from: i, reason: collision with root package name */
        public int f14804i;

        public a(l6.l lVar, l6.l lVar2, boolean z10) {
            this.f14802g = lVar;
            this.f14801f = lVar2;
            this.f14800e = z10;
            lVar2.setPosition(12);
            this.f14796a = lVar2.readUnsignedIntToInt();
            lVar.setPosition(12);
            this.f14804i = lVar.readUnsignedIntToInt();
            l6.a.checkState(lVar.readInt() == 1, "first_chunk must be 1");
            this.f14797b = -1;
        }

        public boolean moveNext() {
            int i10 = this.f14797b + 1;
            this.f14797b = i10;
            if (i10 == this.f14796a) {
                return false;
            }
            boolean z10 = this.f14800e;
            l6.l lVar = this.f14801f;
            this.f14799d = z10 ? lVar.readUnsignedLongToLong() : lVar.readUnsignedInt();
            if (this.f14797b == this.f14803h) {
                l6.l lVar2 = this.f14802g;
                this.f14798c = lVar2.readUnsignedIntToInt();
                lVar2.skipBytes(4);
                int i11 = this.f14804i - 1;
                this.f14804i = i11;
                this.f14803h = i11 > 0 ? lVar2.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    /* compiled from: AtomParsers.java */
    /* renamed from: k5.b$b, reason: collision with other inner class name */
    public interface InterfaceC0178b {
        int getSampleCount();

        boolean isFixedSampleSize();

        int readNextSampleSize();
    }

    /* compiled from: AtomParsers.java */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final k[] f14805a;

        /* renamed from: b, reason: collision with root package name */
        public c5.i f14806b;

        /* renamed from: c, reason: collision with root package name */
        public int f14807c;

        /* renamed from: d, reason: collision with root package name */
        public int f14808d = 0;

        public c(int i10) {
            this.f14805a = new k[i10];
        }
    }

    /* compiled from: AtomParsers.java */
    public static final class d implements InterfaceC0178b {

        /* renamed from: a, reason: collision with root package name */
        public final int f14809a;

        /* renamed from: b, reason: collision with root package name */
        public final int f14810b;

        /* renamed from: c, reason: collision with root package name */
        public final l6.l f14811c;

        public d(a.b bVar) {
            l6.l lVar = bVar.P0;
            this.f14811c = lVar;
            lVar.setPosition(12);
            this.f14809a = lVar.readUnsignedIntToInt();
            this.f14810b = lVar.readUnsignedIntToInt();
        }

        @Override // k5.b.InterfaceC0178b
        public int getSampleCount() {
            return this.f14810b;
        }

        @Override // k5.b.InterfaceC0178b
        public boolean isFixedSampleSize() {
            return this.f14809a != 0;
        }

        @Override // k5.b.InterfaceC0178b
        public int readNextSampleSize() {
            int i10 = this.f14809a;
            return i10 == 0 ? this.f14811c.readUnsignedIntToInt() : i10;
        }
    }

    /* compiled from: AtomParsers.java */
    public static final class e implements InterfaceC0178b {

        /* renamed from: a, reason: collision with root package name */
        public final l6.l f14812a;

        /* renamed from: b, reason: collision with root package name */
        public final int f14813b;

        /* renamed from: c, reason: collision with root package name */
        public final int f14814c;

        /* renamed from: d, reason: collision with root package name */
        public int f14815d;

        /* renamed from: e, reason: collision with root package name */
        public int f14816e;

        public e(a.b bVar) {
            l6.l lVar = bVar.P0;
            this.f14812a = lVar;
            lVar.setPosition(12);
            this.f14814c = lVar.readUnsignedIntToInt() & 255;
            this.f14813b = lVar.readUnsignedIntToInt();
        }

        @Override // k5.b.InterfaceC0178b
        public int getSampleCount() {
            return this.f14813b;
        }

        @Override // k5.b.InterfaceC0178b
        public boolean isFixedSampleSize() {
            return false;
        }

        @Override // k5.b.InterfaceC0178b
        public int readNextSampleSize() {
            l6.l lVar = this.f14812a;
            int i10 = this.f14814c;
            if (i10 == 8) {
                return lVar.readUnsignedByte();
            }
            if (i10 == 16) {
                return lVar.readUnsignedShort();
            }
            int i11 = this.f14815d;
            this.f14815d = i11 + 1;
            if (i11 % 2 != 0) {
                return this.f14816e & 15;
            }
            int unsignedByte = lVar.readUnsignedByte();
            this.f14816e = unsignedByte;
            return (unsignedByte & 240) >> 4;
        }
    }

    /* compiled from: AtomParsers.java */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public final int f14817a;

        /* renamed from: b, reason: collision with root package name */
        public final long f14818b;

        /* renamed from: c, reason: collision with root package name */
        public final int f14819c;

        public f(int i10, long j10, int i11) {
            this.f14817a = i10;
            this.f14818b = j10;
            this.f14819c = i11;
        }
    }

    static {
        u.getIntegerCodeForString("cenc");
        f14795g = u.getIntegerCodeForString("meta");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair a(int r3, l6.l r4) {
        /*
            int r3 = r3 + 8
            int r3 = r3 + 4
            r4.setPosition(r3)
            r3 = 1
            r4.skipBytes(r3)
            b(r4)
            r0 = 2
            r4.skipBytes(r0)
            int r1 = r4.readUnsignedByte()
            r2 = r1 & 128(0x80, float:1.8E-43)
            if (r2 == 0) goto L1d
            r4.skipBytes(r0)
        L1d:
            r2 = r1 & 64
            if (r2 == 0) goto L28
            int r2 = r4.readUnsignedShort()
            r4.skipBytes(r2)
        L28:
            r2 = 32
            r1 = r1 & r2
            if (r1 == 0) goto L30
            r4.skipBytes(r0)
        L30:
            r4.skipBytes(r3)
            b(r4)
            int r0 = r4.readUnsignedByte()
            if (r0 == r2) goto L8b
            r1 = 33
            if (r0 == r1) goto L88
            r1 = 35
            if (r0 == r1) goto L85
            r1 = 64
            if (r0 == r1) goto L82
            r1 = 107(0x6b, float:1.5E-43)
            r2 = 0
            if (r0 == r1) goto L7b
            r1 = 96
            if (r0 == r1) goto L78
            r1 = 97
            if (r0 == r1) goto L78
            r1 = 165(0xa5, float:2.31E-43)
            if (r0 == r1) goto L75
            r1 = 166(0xa6, float:2.33E-43)
            if (r0 == r1) goto L72
            switch(r0) {
                case 102: goto L82;
                case 103: goto L82;
                case 104: goto L82;
                default: goto L60;
            }
        L60:
            switch(r0) {
                case 169: goto L6b;
                case 170: goto L64;
                case 171: goto L64;
                case 172: goto L6b;
                default: goto L63;
            }
        L63:
            goto L8d
        L64:
            java.lang.String r3 = "audio/vnd.dts.hd"
            android.util.Pair r3 = android.util.Pair.create(r3, r2)
            return r3
        L6b:
            java.lang.String r3 = "audio/vnd.dts"
            android.util.Pair r3 = android.util.Pair.create(r3, r2)
            return r3
        L72:
            java.lang.String r2 = "audio/eac3"
            goto L8d
        L75:
            java.lang.String r2 = "audio/ac3"
            goto L8d
        L78:
            java.lang.String r2 = "video/mpeg2"
            goto L8d
        L7b:
            java.lang.String r3 = "audio/mpeg"
            android.util.Pair r3 = android.util.Pair.create(r3, r2)
            return r3
        L82:
            java.lang.String r2 = "audio/mp4a-latm"
            goto L8d
        L85:
            java.lang.String r2 = "video/hevc"
            goto L8d
        L88:
            java.lang.String r2 = "video/avc"
            goto L8d
        L8b:
            java.lang.String r2 = "video/mp4v-es"
        L8d:
            r0 = 12
            r4.skipBytes(r0)
            r4.skipBytes(r3)
            int r3 = b(r4)
            byte[] r0 = new byte[r3]
            r1 = 0
            r4.readBytes(r0, r1, r3)
            android.util.Pair r3 = android.util.Pair.create(r2, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.b.a(int, l6.l):android.util.Pair");
    }

    public static int b(l6.l lVar) {
        int unsignedByte = lVar.readUnsignedByte();
        int i10 = unsignedByte & 127;
        while ((unsignedByte & 128) == 128) {
            unsignedByte = lVar.readUnsignedByte();
            i10 = (i10 << 7) | (unsignedByte & 127);
        }
        return i10;
    }

    public static Pair c(int i10, int i11, l6.l lVar) {
        Integer num;
        k kVar;
        Pair pairCreate;
        int i12;
        int i13;
        byte[] bArr;
        int position = lVar.getPosition();
        while (position - i10 < i11) {
            lVar.setPosition(position);
            int i14 = lVar.readInt();
            l6.a.checkArgument(i14 > 0, "childAtomSize should be positive");
            if (lVar.readInt() == k5.a.W) {
                int i15 = position + 8;
                int i16 = -1;
                int i17 = 0;
                String string = null;
                Integer numValueOf = null;
                while (i15 - position < i14) {
                    lVar.setPosition(i15);
                    int i18 = lVar.readInt();
                    int i19 = lVar.readInt();
                    if (i19 == k5.a.f14741c0) {
                        numValueOf = Integer.valueOf(lVar.readInt());
                    } else if (i19 == k5.a.X) {
                        lVar.skipBytes(4);
                        string = lVar.readString(4);
                    } else if (i19 == k5.a.Y) {
                        i16 = i15;
                        i17 = i18;
                    }
                    i15 += i18;
                }
                if ("cenc".equals(string) || "cbc1".equals(string) || "cens".equals(string) || "cbcs".equals(string)) {
                    l6.a.checkArgument(numValueOf != null, "frma atom is mandatory");
                    l6.a.checkArgument(i16 != -1, "schi atom is mandatory");
                    int i20 = i16 + 8;
                    while (true) {
                        if (i20 - i16 >= i17) {
                            num = numValueOf;
                            kVar = null;
                            break;
                        }
                        lVar.setPosition(i20);
                        int i21 = lVar.readInt();
                        if (lVar.readInt() == k5.a.Z) {
                            int fullAtomVersion = k5.a.parseFullAtomVersion(lVar.readInt());
                            lVar.skipBytes(1);
                            if (fullAtomVersion == 0) {
                                lVar.skipBytes(1);
                                i12 = 0;
                                i13 = 0;
                            } else {
                                int unsignedByte = lVar.readUnsignedByte();
                                int i22 = (unsignedByte & 240) >> 4;
                                i12 = unsignedByte & 15;
                                i13 = i22;
                            }
                            boolean z10 = lVar.readUnsignedByte() == 1;
                            int unsignedByte2 = lVar.readUnsignedByte();
                            byte[] bArr2 = new byte[16];
                            lVar.readBytes(bArr2, 0, 16);
                            if (z10 && unsignedByte2 == 0) {
                                int unsignedByte3 = lVar.readUnsignedByte();
                                byte[] bArr3 = new byte[unsignedByte3];
                                lVar.readBytes(bArr3, 0, unsignedByte3);
                                bArr = bArr3;
                            } else {
                                bArr = null;
                            }
                            num = numValueOf;
                            kVar = new k(z10, string, unsignedByte2, bArr2, i13, i12, bArr);
                        } else {
                            i20 += i21;
                        }
                    }
                    l6.a.checkArgument(kVar != null, "tenc atom is mandatory");
                    pairCreate = Pair.create(num, kVar);
                } else {
                    pairCreate = null;
                }
                if (pairCreate != null) {
                    return pairCreate;
                }
            }
            position += i14;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0472  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static k5.m parseStbl(k5.j r52, k5.a.C0177a r53, g5.i r54) throws com.google.android.exoplayer2.ParserException {
        /*
            Method dump skipped, instructions count: 1189
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.b.parseStbl(k5.j, k5.a$a, g5.i):k5.m");
    }

    /* JADX WARN: Removed duplicated region for block: B:403:0x06e0  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x0757  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x0760  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x0762  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static k5.j parseTrak(k5.a.C0177a r45, k5.a.b r46, long r47, com.google.android.exoplayer2.drm.c r49, boolean r50, boolean r51) throws com.google.android.exoplayer2.ParserException {
        /*
            Method dump skipped, instructions count: 1934
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.b.parseTrak(k5.a$a, k5.a$b, long, com.google.android.exoplayer2.drm.c, boolean, boolean):k5.j");
    }

    public static q5.a parseUdta(a.b bVar, boolean z10) {
        if (z10) {
            return null;
        }
        l6.l lVar = bVar.P0;
        lVar.setPosition(8);
        while (lVar.bytesLeft() >= 8) {
            int position = lVar.getPosition();
            int i10 = lVar.readInt();
            if (lVar.readInt() == k5.a.B0) {
                lVar.setPosition(position);
                int i11 = position + i10;
                lVar.skipBytes(12);
                while (lVar.getPosition() < i11) {
                    int position2 = lVar.getPosition();
                    int i12 = lVar.readInt();
                    if (lVar.readInt() == k5.a.C0) {
                        lVar.setPosition(position2);
                        int i13 = position2 + i12;
                        lVar.skipBytes(8);
                        ArrayList arrayList = new ArrayList();
                        while (lVar.getPosition() < i13) {
                            a.b ilstElement = k5.f.parseIlstElement(lVar);
                            if (ilstElement != null) {
                                arrayList.add(ilstElement);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            return null;
                        }
                        return new q5.a(arrayList);
                    }
                    lVar.skipBytes(i12 - 8);
                }
                return null;
            }
            lVar.skipBytes(i10 - 8);
        }
        return null;
    }
}
