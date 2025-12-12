package s5;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import l6.l;
import l6.u;
import org.apache.commons.lang3.CharEncoding;

/* compiled from: Id3Decoder.java */
/* loaded from: classes.dex */
public final class g implements q5.b {

    /* renamed from: b, reason: collision with root package name */
    public static final int f19091b = u.getIntegerCodeForString("ID3");

    /* renamed from: a, reason: collision with root package name */
    public final a f19092a;

    /* compiled from: Id3Decoder.java */
    public interface a {
    }

    /* compiled from: Id3Decoder.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f19093a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f19094b;

        /* renamed from: c, reason: collision with root package name */
        public final int f19095c;

        public b(int i10, boolean z10, int i11) {
            this.f19093a = i10;
            this.f19094b = z10;
            this.f19095c = i11;
        }
    }

    public g() {
        this(null);
    }

    public static s5.a a(int i10, int i11, l lVar) throws UnsupportedEncodingException {
        int iP;
        String strConcat;
        int unsignedByte = lVar.readUnsignedByte();
        String strM = m(unsignedByte);
        int i12 = i10 - 1;
        byte[] bArr = new byte[i12];
        lVar.readBytes(bArr, 0, i12);
        if (i11 == 2) {
            String str = "image/" + u.toLowerInvariant(new String(bArr, 0, 3, "ISO-8859-1"));
            if (str.equals("image/jpg")) {
                str = "image/jpeg";
            }
            strConcat = str;
            iP = 2;
        } else {
            iP = p(0, bArr);
            String lowerInvariant = u.toLowerInvariant(new String(bArr, 0, iP, "ISO-8859-1"));
            strConcat = lowerInvariant.indexOf(47) == -1 ? "image/".concat(lowerInvariant) : lowerInvariant;
        }
        int i13 = bArr[iP + 1] & 255;
        int i14 = iP + 2;
        int iO = o(i14, bArr, unsignedByte);
        String str2 = new String(bArr, i14, iO - i14, strM);
        int iL = l(unsignedByte) + iO;
        return new s5.a(strConcat, str2, i13, i12 <= iL ? new byte[0] : Arrays.copyOfRange(bArr, iL, i12));
    }

    public static c b(l lVar, int i10, int i11, boolean z10, int i12, a aVar) throws UnsupportedEncodingException {
        int position = lVar.getPosition();
        int iP = p(position, lVar.f15881a);
        String str = new String(lVar.f15881a, position, iP - position, "ISO-8859-1");
        lVar.setPosition(iP + 1);
        int i13 = lVar.readInt();
        int i14 = lVar.readInt();
        long unsignedInt = lVar.readUnsignedInt();
        long j10 = unsignedInt == 4294967295L ? -1L : unsignedInt;
        long unsignedInt2 = lVar.readUnsignedInt();
        long j11 = unsignedInt2 == 4294967295L ? -1L : unsignedInt2;
        ArrayList arrayList = new ArrayList();
        int i15 = position + i10;
        while (lVar.getPosition() < i15) {
            h hVarE = e(i11, lVar, z10, i12, aVar);
            if (hVarE != null) {
                arrayList.add(hVarE);
            }
        }
        h[] hVarArr = new h[arrayList.size()];
        arrayList.toArray(hVarArr);
        return new c(str, i13, i14, j10, j11, hVarArr);
    }

    public static d c(l lVar, int i10, int i11, boolean z10, int i12, a aVar) throws UnsupportedEncodingException {
        int position = lVar.getPosition();
        int iP = p(position, lVar.f15881a);
        String str = new String(lVar.f15881a, position, iP - position, "ISO-8859-1");
        lVar.setPosition(iP + 1);
        int unsignedByte = lVar.readUnsignedByte();
        boolean z11 = (unsignedByte & 2) != 0;
        boolean z12 = (unsignedByte & 1) != 0;
        int unsignedByte2 = lVar.readUnsignedByte();
        String[] strArr = new String[unsignedByte2];
        for (int i13 = 0; i13 < unsignedByte2; i13++) {
            int position2 = lVar.getPosition();
            int iP2 = p(position2, lVar.f15881a);
            strArr[i13] = new String(lVar.f15881a, position2, iP2 - position2, "ISO-8859-1");
            lVar.setPosition(iP2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i14 = position + i10;
        while (lVar.getPosition() < i14) {
            h hVarE = e(i11, lVar, z10, i12, aVar);
            if (hVarE != null) {
                arrayList.add(hVarE);
            }
        }
        h[] hVarArr = new h[arrayList.size()];
        arrayList.toArray(hVarArr);
        return new d(str, z11, z12, strArr, hVarArr);
    }

    public static e d(int i10, l lVar) throws UnsupportedEncodingException {
        if (i10 < 4) {
            return null;
        }
        int unsignedByte = lVar.readUnsignedByte();
        String strM = m(unsignedByte);
        byte[] bArr = new byte[3];
        lVar.readBytes(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i11 = i10 - 4;
        byte[] bArr2 = new byte[i11];
        lVar.readBytes(bArr2, 0, i11);
        int iO = o(0, bArr2, unsignedByte);
        String str2 = new String(bArr2, 0, iO, strM);
        int iL = l(unsignedByte) + iO;
        return new e(str, str2, iL < i11 ? new String(bArr2, iL, o(iL, bArr2, unsignedByte) - iL, strM) : "");
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01df A[Catch: all -> 0x012f, UnsupportedEncodingException -> 0x0132, TryCatch #1 {UnsupportedEncodingException -> 0x0132, blocks: (B:91:0x011d, B:154:0x01f1, B:93:0x0125, B:103:0x0142, B:105:0x014a, B:113:0x0164, B:122:0x017c, B:133:0x0197, B:140:0x01a8, B:146:0x01b7, B:151:0x01cf, B:152:0x01df), top: B:169:0x0113 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static s5.h e(int r19, l6.l r20, boolean r21, int r22, s5.g.a r23) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: s5.g.e(int, l6.l, boolean, int, s5.g$a):s5.h");
    }

    public static f f(int i10, l lVar) throws UnsupportedEncodingException {
        int unsignedByte = lVar.readUnsignedByte();
        String strM = m(unsignedByte);
        int i11 = i10 - 1;
        byte[] bArr = new byte[i11];
        lVar.readBytes(bArr, 0, i11);
        int iP = p(0, bArr);
        String str = new String(bArr, 0, iP, "ISO-8859-1");
        int i12 = iP + 1;
        int iO = o(i12, bArr, unsignedByte);
        String str2 = new String(bArr, i12, iO - i12, strM);
        int iL = l(unsignedByte) + iO;
        int iO2 = o(iL, bArr, unsignedByte);
        String str3 = new String(bArr, iL, iO2 - iL, strM);
        int iL2 = l(unsignedByte) + iO2;
        return new f(str, str2, str3, i11 <= iL2 ? new byte[0] : Arrays.copyOfRange(bArr, iL2, i11));
    }

    public static i g(int i10, l lVar) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i10];
        lVar.readBytes(bArr, 0, i10);
        int iP = p(0, bArr);
        String str = new String(bArr, 0, iP, "ISO-8859-1");
        int i11 = iP + 1;
        return new i(str, i10 <= i11 ? new byte[0] : Arrays.copyOfRange(bArr, i11, i10));
    }

    public static j h(int i10, l lVar, String str) throws UnsupportedEncodingException {
        if (i10 < 1) {
            return null;
        }
        int unsignedByte = lVar.readUnsignedByte();
        String strM = m(unsignedByte);
        int i11 = i10 - 1;
        byte[] bArr = new byte[i11];
        lVar.readBytes(bArr, 0, i11);
        return new j(str, null, new String(bArr, 0, o(0, bArr, unsignedByte), strM));
    }

    public static j i(int i10, l lVar) throws UnsupportedEncodingException {
        if (i10 < 1) {
            return null;
        }
        int unsignedByte = lVar.readUnsignedByte();
        String strM = m(unsignedByte);
        int i11 = i10 - 1;
        byte[] bArr = new byte[i11];
        lVar.readBytes(bArr, 0, i11);
        int iO = o(0, bArr, unsignedByte);
        String str = new String(bArr, 0, iO, strM);
        int iL = l(unsignedByte) + iO;
        return new j("TXXX", str, iL < i11 ? new String(bArr, iL, o(iL, bArr, unsignedByte) - iL, strM) : "");
    }

    public static k j(int i10, l lVar, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i10];
        lVar.readBytes(bArr, 0, i10);
        return new k(str, null, new String(bArr, 0, p(0, bArr), "ISO-8859-1"));
    }

    public static k k(int i10, l lVar) throws UnsupportedEncodingException {
        if (i10 < 1) {
            return null;
        }
        int unsignedByte = lVar.readUnsignedByte();
        String strM = m(unsignedByte);
        int i11 = i10 - 1;
        byte[] bArr = new byte[i11];
        lVar.readBytes(bArr, 0, i11);
        int iO = o(0, bArr, unsignedByte);
        String str = new String(bArr, 0, iO, strM);
        int iL = l(unsignedByte) + iO;
        return new k("WXXX", str, iL < i11 ? new String(bArr, iL, p(iL, bArr) - iL, "ISO-8859-1") : "");
    }

    public static int l(int i10) {
        return (i10 == 0 || i10 == 3) ? 1 : 2;
    }

    public static String m(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? "ISO-8859-1" : "UTF-8" : CharEncoding.UTF_16BE : "UTF-16";
    }

    public static String n(int i10, int i11, int i12, int i13, int i14) {
        return i10 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14));
    }

    public static int o(int i10, byte[] bArr, int i11) {
        int iP = p(i10, bArr);
        if (i11 == 0 || i11 == 3) {
            return iP;
        }
        while (iP < bArr.length - 1) {
            if (iP % 2 == 0 && bArr[iP + 1] == 0) {
                return iP;
            }
            iP = p(iP + 1, bArr);
        }
        return bArr.length;
    }

    public static int p(int i10, byte[] bArr) {
        while (i10 < bArr.length) {
            if (bArr[i10] == 0) {
                return i10;
            }
            i10++;
        }
        return bArr.length;
    }

    public static int q(int i10, l lVar) {
        byte[] bArr = lVar.f15881a;
        int position = lVar.getPosition();
        while (true) {
            int i11 = position + 1;
            if (i11 >= i10) {
                return i10;
            }
            if ((bArr[position] & 255) == 255 && bArr[i11] == 0) {
                System.arraycopy(bArr, position + 2, bArr, i11, (i10 - position) - 2);
                i10--;
            }
            position = i11;
        }
    }

    public static boolean r(l lVar, int i10, int i11, boolean z10) {
        int unsignedInt24;
        long unsignedInt242;
        int unsignedShort;
        int i12;
        int position = lVar.getPosition();
        while (true) {
            try {
                boolean z11 = true;
                if (lVar.bytesLeft() < i11) {
                    return true;
                }
                if (i10 >= 3) {
                    unsignedInt24 = lVar.readInt();
                    unsignedInt242 = lVar.readUnsignedInt();
                    unsignedShort = lVar.readUnsignedShort();
                } else {
                    unsignedInt24 = lVar.readUnsignedInt24();
                    unsignedInt242 = lVar.readUnsignedInt24();
                    unsignedShort = 0;
                }
                if (unsignedInt24 == 0 && unsignedInt242 == 0 && unsignedShort == 0) {
                    return true;
                }
                if (i10 == 4 && !z10) {
                    if ((8421504 & unsignedInt242) != 0) {
                        return false;
                    }
                    unsignedInt242 = (((unsignedInt242 >> 24) & 255) << 21) | (unsignedInt242 & 255) | (((unsignedInt242 >> 8) & 255) << 7) | (((unsignedInt242 >> 16) & 255) << 14);
                }
                if (i10 == 4) {
                    i12 = (unsignedShort & 64) != 0 ? 1 : 0;
                    if ((unsignedShort & 1) == 0) {
                        z11 = false;
                    }
                } else {
                    if (i10 == 3) {
                        i12 = (unsignedShort & 32) != 0 ? 1 : 0;
                        if ((unsignedShort & 128) == 0) {
                        }
                    } else {
                        i12 = 0;
                    }
                    z11 = false;
                }
                if (z11) {
                    i12 += 4;
                }
                if (unsignedInt242 < i12) {
                    return false;
                }
                if (lVar.bytesLeft() < unsignedInt242) {
                    return false;
                }
                lVar.skipBytes((int) unsignedInt242);
            } finally {
                lVar.setPosition(position);
            }
        }
    }

    @Override // q5.b
    public q5.a decode(q5.d dVar) {
        ByteBuffer byteBuffer = dVar.f11142n;
        return decode(byteBuffer.array(), byteBuffer.limit());
    }

    public g(a aVar) {
        this.f19092a = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public q5.a decode(byte[] r13, int r14) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: s5.g.decode(byte[], int):q5.a");
    }
}
