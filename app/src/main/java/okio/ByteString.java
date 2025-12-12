package okio;

import ac.c;
import ah.b0;
import ah.c0;
import ah.d0;
import bh.b;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import ig.l;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import mf.h;
import org.apache.commons.lang3.StringUtils;
import zf.f;
import zf.i;

/* compiled from: ByteString.kt */
/* loaded from: classes2.dex */
public class ByteString implements Serializable, Comparable<ByteString> {

    /* renamed from: o, reason: collision with root package name */
    public static final a f17101o = new a(null);

    /* renamed from: p, reason: collision with root package name */
    public static final ByteString f17102p = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f17103b;

    /* renamed from: m, reason: collision with root package name */
    public transient int f17104m;

    /* renamed from: n, reason: collision with root package name */
    public transient String f17105n;

    /* compiled from: ByteString.kt */
    public static final class a {
        public a(f fVar) {
        }

        public static /* synthetic */ ByteString of$default(a aVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = 0;
            }
            if ((i12 & 2) != 0) {
                i11 = bArr.length;
            }
            return aVar.of(bArr, i10, i11);
        }

        public final ByteString decodeBase64(String str) {
            i.checkNotNullParameter(str, "<this>");
            byte[] bArrDecodeBase64ToArray = b0.decodeBase64ToArray(str);
            if (bArrDecodeBase64ToArray != null) {
                return new ByteString(bArrDecodeBase64ToArray);
            }
            return null;
        }

        public final ByteString decodeHex(String str) {
            i.checkNotNullParameter(str, "<this>");
            int i10 = 0;
            if (!(str.length() % 2 == 0)) {
                throw new IllegalArgumentException(i.stringPlus("Unexpected hex string: ", str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            int i11 = length - 1;
            if (i11 >= 0) {
                while (true) {
                    int i12 = i10 + 1;
                    int i13 = i10 * 2;
                    bArr[i10] = (byte) (b.access$decodeHexDigit(str.charAt(i13 + 1)) + (b.access$decodeHexDigit(str.charAt(i13)) << 4));
                    if (i12 > i11) {
                        break;
                    }
                    i10 = i12;
                }
            }
            return new ByteString(bArr);
        }

        public final ByteString encodeString(String str, Charset charset) {
            i.checkNotNullParameter(str, "<this>");
            i.checkNotNullParameter(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            i.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        public final ByteString encodeUtf8(String str) {
            i.checkNotNullParameter(str, "<this>");
            ByteString byteString = new ByteString(c0.asUtf8ToByteArray(str));
            byteString.setUtf8$okio(str);
            return byteString;
        }

        public final ByteString of(byte[] bArr, int i10, int i11) {
            i.checkNotNullParameter(bArr, "<this>");
            d0.checkOffsetAndCount(bArr.length, i10, i11);
            return new ByteString(h.copyOfRange(bArr, i10, i11 + i10));
        }
    }

    public ByteString(byte[] bArr) {
        i.checkNotNullParameter(bArr, JsonStorageKeyNames.DATA_KEY);
        this.f17103b = bArr;
    }

    public static final ByteString encodeUtf8(String str) {
        return f17101o.encodeUtf8(str);
    }

    public String base64() {
        return b0.encodeBase64$default(getData$okio(), null, 1, null);
    }

    public ByteString digest$okio(String str) throws NoSuchAlgorithmException {
        i.checkNotNullParameter(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(getData$okio(), 0, size());
        byte[] bArrDigest = messageDigest.digest();
        i.checkNotNullExpressionValue(bArrDigest, "digestBytes");
        return new ByteString(bArrDigest);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == getData$okio().length && byteString.rangeEquals(0, getData$okio(), 0, getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public final byte getByte(int i10) {
        return internalGet$okio(i10);
    }

    public final byte[] getData$okio() {
        return this.f17103b;
    }

    public final int getHashCode$okio() {
        return this.f17104m;
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    public final String getUtf8$okio() {
        return this.f17105n;
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int iHashCode = Arrays.hashCode(getData$okio());
        setHashCode$okio(iHashCode);
        return iHashCode;
    }

    public String hex() {
        char[] cArr = new char[getData$okio().length * 2];
        byte[] data$okio = getData$okio();
        int length = data$okio.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            byte b10 = data$okio[i10];
            i10++;
            int i12 = i11 + 1;
            cArr[i11] = b.getHEX_DIGIT_CHARS()[(b10 >> 4) & 15];
            i11 = i12 + 1;
            cArr[i12] = b.getHEX_DIGIT_CHARS()[b10 & 15];
        }
        return l.concatToString(cArr);
    }

    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int i10) {
        return getData$okio()[i10];
    }

    public final ByteString md5() {
        return digest$okio("MD5");
    }

    public boolean rangeEquals(int i10, ByteString byteString, int i11, int i12) {
        i.checkNotNullParameter(byteString, "other");
        return byteString.rangeEquals(i11, getData$okio(), i10, i12);
    }

    public final void setHashCode$okio(int i10) {
        this.f17104m = i10;
    }

    public final void setUtf8$okio(String str) {
        this.f17105n = str;
    }

    public final ByteString sha1() {
        return digest$okio("SHA-1");
    }

    public final ByteString sha256() {
        return digest$okio("SHA-256");
    }

    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(ByteString byteString) {
        i.checkNotNullParameter(byteString, "prefix");
        return rangeEquals(0, byteString, 0, byteString.size());
    }

    public ByteString toAsciiLowercase() {
        byte b10;
        for (int i10 = 0; i10 < getData$okio().length; i10++) {
            byte b11 = getData$okio()[i10];
            byte b12 = (byte) 65;
            if (b11 >= b12 && b11 <= (b10 = (byte) 90)) {
                byte[] data$okio = getData$okio();
                byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
                i.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i10] = (byte) (b11 + 32);
                for (int i11 = i10 + 1; i11 < bArrCopyOf.length; i11++) {
                    byte b13 = bArrCopyOf[i11];
                    if (b13 >= b12 && b13 <= b10) {
                        bArrCopyOf[i11] = (byte) (b13 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return this;
    }

    public String toString() {
        String str;
        if (getData$okio().length == 0) {
            str = "[size=0]";
        } else {
            int iAccess$codePointIndexToCharIndex = b.access$codePointIndexToCharIndex(getData$okio(), 64);
            if (iAccess$codePointIndexToCharIndex != -1) {
                String strUtf8 = utf8();
                if (strUtf8 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String strSubstring = strUtf8.substring(0, iAccess$codePointIndexToCharIndex);
                i.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String strReplace$default = l.replace$default(l.replace$default(l.replace$default(strSubstring, "\\", "\\\\", false, 4, (Object) null), StringUtils.LF, "\\n", false, 4, (Object) null), StringUtils.CR, "\\r", false, 4, (Object) null);
                if (iAccess$codePointIndexToCharIndex >= strUtf8.length()) {
                    return "[text=" + strReplace$default + ']';
                }
                return "[size=" + getData$okio().length + " text=" + strReplace$default + "…]";
            }
            if (getData$okio().length > 64) {
                StringBuilder sb2 = new StringBuilder("[size=");
                sb2.append(getData$okio().length);
                sb2.append(" hex=");
                int iResolveDefaultParameter = d0.resolveDefaultParameter(this, 64);
                if (!(iResolveDefaultParameter <= getData$okio().length)) {
                    throw new IllegalArgumentException(c.l(new StringBuilder("endIndex > length("), getData$okio().length, ')').toString());
                }
                if (!(iResolveDefaultParameter + 0 >= 0)) {
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                }
                sb2.append((iResolveDefaultParameter == getData$okio().length ? this : new ByteString(h.copyOfRange(getData$okio(), 0, iResolveDefaultParameter))).hex());
                sb2.append("…]");
                return sb2.toString();
            }
            str = "[hex=" + hex() + ']';
        }
        return str;
    }

    public String utf8() {
        String utf8$okio = getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = c0.toUtf8String(internalArray$okio());
        setUtf8$okio(utf8String);
        return utf8String;
    }

    public void write$okio(ah.c cVar, int i10, int i11) {
        i.checkNotNullParameter(cVar, "buffer");
        b.commonWrite(this, cVar, i10, i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0030 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032 A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(okio.ByteString r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            zf.i.checkNotNullParameter(r10, r0)
            int r0 = r9.size()
            int r1 = r10.size()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2b
            byte r7 = r9.getByte(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.getByte(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L32
            goto L30
        L2b:
            if (r0 != r1) goto L2e
            goto L33
        L2e:
            if (r0 >= r1) goto L32
        L30:
            r3 = -1
            goto L33
        L32:
            r3 = 1
        L33:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(okio.ByteString):int");
    }

    public boolean rangeEquals(int i10, byte[] bArr, int i11, int i12) {
        i.checkNotNullParameter(bArr, "other");
        return i10 >= 0 && i10 <= getData$okio().length - i12 && i11 >= 0 && i11 <= bArr.length - i12 && d0.arrayRangeEquals(getData$okio(), i10, bArr, i11, i12);
    }
}
