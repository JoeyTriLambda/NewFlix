package androidx.datastore.preferences.protobuf;

import com.fasterxml.jackson.core.base.GeneratorBase;

/* loaded from: classes.dex */
public final class Utf8 {

    /* renamed from: a, reason: collision with root package name */
    public static final b f2376a;

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i10, int i11) {
            super(ac.c.g("Unpaired surrogate at index ", i10, " of ", i11));
        }
    }

    public static class a {
        public static void a(byte b10, byte b11, byte b12, byte b13, char[] cArr, int i10) throws InvalidProtocolBufferException {
            if (!c(b11)) {
                if ((((b11 + 112) + (b10 << 28)) >> 30) == 0 && !c(b12) && !c(b13)) {
                    int i11 = ((b10 & 7) << 18) | ((b11 & 63) << 12) | ((b12 & 63) << 6) | (b13 & 63);
                    cArr[i10] = (char) ((i11 >>> 10) + 55232);
                    cArr[i10 + 1] = (char) ((i11 & 1023) + GeneratorBase.SURR2_FIRST);
                    return;
                }
            }
            throw InvalidProtocolBufferException.a();
        }

        public static void b(byte b10, byte b11, byte b12, char[] cArr, int i10) throws InvalidProtocolBufferException {
            if (c(b11) || ((b10 == -32 && b11 < -96) || ((b10 == -19 && b11 >= -96) || c(b12)))) {
                throw InvalidProtocolBufferException.a();
            }
            cArr[i10] = (char) (((b10 & 15) << 12) | ((b11 & 63) << 6) | (b12 & 63));
        }

        public static boolean c(byte b10) {
            return b10 > -65;
        }
    }

    public static abstract class b {
        public abstract String a(int i10, byte[] bArr, int i11) throws InvalidProtocolBufferException;

        public abstract int b(CharSequence charSequence, byte[] bArr, int i10, int i11);

        public abstract int c(byte[] bArr, int i10, int i11);
    }

    public static final class c extends b {
        @Override // androidx.datastore.preferences.protobuf.Utf8.b
        public final String a(int i10, byte[] bArr, int i11) throws InvalidProtocolBufferException {
            if ((i10 | i11 | ((bArr.length - i10) - i11)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
            }
            int i12 = i10 + i11;
            char[] cArr = new char[i11];
            int i13 = 0;
            while (i10 < i12) {
                byte b10 = bArr[i10];
                if (!(b10 >= 0)) {
                    break;
                }
                i10++;
                cArr[i13] = (char) b10;
                i13++;
            }
            int i14 = i13;
            while (i10 < i12) {
                int i15 = i10 + 1;
                byte b11 = bArr[i10];
                if (b11 >= 0) {
                    int i16 = i14 + 1;
                    cArr[i14] = (char) b11;
                    i10 = i15;
                    while (true) {
                        i14 = i16;
                        if (i10 >= i12) {
                            break;
                        }
                        byte b12 = bArr[i10];
                        if (!(b12 >= 0)) {
                            break;
                        }
                        i10++;
                        i16 = i14 + 1;
                        cArr[i14] = (char) b12;
                    }
                } else {
                    if (!(b11 < -32)) {
                        if (b11 < -16) {
                            if (i15 >= i12 - 1) {
                                throw InvalidProtocolBufferException.a();
                            }
                            int i17 = i15 + 1;
                            a.b(b11, bArr[i15], bArr[i17], cArr, i14);
                            i10 = i17 + 1;
                            i14++;
                        } else {
                            if (i15 >= i12 - 2) {
                                throw InvalidProtocolBufferException.a();
                            }
                            int i18 = i15 + 1;
                            byte b13 = bArr[i15];
                            int i19 = i18 + 1;
                            a.a(b11, b13, bArr[i18], bArr[i19], cArr, i14);
                            i14 = i14 + 1 + 1;
                            i10 = i19 + 1;
                        }
                    } else {
                        if (i15 >= i12) {
                            throw InvalidProtocolBufferException.a();
                        }
                        int i20 = i15 + 1;
                        byte b14 = bArr[i15];
                        int i21 = i14 + 1;
                        if (b11 < -62 || a.c(b14)) {
                            throw InvalidProtocolBufferException.a();
                        }
                        cArr[i14] = (char) (((b11 & 31) << 6) | (b14 & 63));
                        i10 = i20;
                        i14 = i21;
                    }
                }
            }
            return new String(cArr, 0, i14);
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.b
        public final int b(CharSequence charSequence, byte[] bArr, int i10, int i11) {
            int i12;
            int i13;
            int i14;
            char cCharAt;
            int length = charSequence.length();
            int i15 = i11 + i10;
            int i16 = 0;
            while (i16 < length && (i14 = i16 + i10) < i15 && (cCharAt = charSequence.charAt(i16)) < 128) {
                bArr[i14] = (byte) cCharAt;
                i16++;
            }
            if (i16 == length) {
                return i10 + length;
            }
            int i17 = i10 + i16;
            while (i16 < length) {
                char cCharAt2 = charSequence.charAt(i16);
                if (cCharAt2 >= 128 || i17 >= i15) {
                    if (cCharAt2 < 2048 && i17 <= i15 - 2) {
                        int i18 = i17 + 1;
                        bArr[i17] = (byte) ((cCharAt2 >>> 6) | 960);
                        i17 = i18 + 1;
                        bArr[i18] = (byte) ((cCharAt2 & '?') | 128);
                    } else {
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i17 > i15 - 3) {
                            if (i17 > i15 - 4) {
                                if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i13 = i16 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i13)))) {
                                    throw new UnpairedSurrogateException(i16, length);
                                }
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i17);
                            }
                            int i19 = i16 + 1;
                            if (i19 != charSequence.length()) {
                                char cCharAt3 = charSequence.charAt(i19);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    int i20 = i17 + 1;
                                    bArr[i17] = (byte) ((codePoint >>> 18) | 240);
                                    int i21 = i20 + 1;
                                    bArr[i20] = (byte) (((codePoint >>> 12) & 63) | 128);
                                    int i22 = i21 + 1;
                                    bArr[i21] = (byte) (((codePoint >>> 6) & 63) | 128);
                                    i17 = i22 + 1;
                                    bArr[i22] = (byte) ((codePoint & 63) | 128);
                                    i16 = i19;
                                } else {
                                    i16 = i19;
                                }
                            }
                            throw new UnpairedSurrogateException(i16 - 1, length);
                        }
                        int i23 = i17 + 1;
                        bArr[i17] = (byte) ((cCharAt2 >>> '\f') | 480);
                        int i24 = i23 + 1;
                        bArr[i23] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                        i12 = i24 + 1;
                        bArr[i24] = (byte) ((cCharAt2 & '?') | 128);
                    }
                    i16++;
                } else {
                    i12 = i17 + 1;
                    bArr[i17] = (byte) cCharAt2;
                }
                i17 = i12;
                i16++;
            }
            return i17;
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.b
        public final int c(byte[] bArr, int i10, int i11) {
            while (i10 < i11 && bArr[i10] >= 0) {
                i10++;
            }
            if (i10 < i11) {
                while (i10 < i11) {
                    int i12 = i10 + 1;
                    byte b10 = bArr[i10];
                    if (b10 < 0) {
                        if (b10 < -32) {
                            if (i12 >= i11) {
                                return b10;
                            }
                            if (b10 >= -62) {
                                i10 = i12 + 1;
                                if (bArr[i12] > -65) {
                                }
                            }
                            return -1;
                        }
                        if (b10 < -16) {
                            if (i12 >= i11 - 1) {
                                return Utf8.a(i12, bArr, i11);
                            }
                            int i13 = i12 + 1;
                            byte b11 = bArr[i12];
                            if (b11 <= -65 && ((b10 != -32 || b11 >= -96) && (b10 != -19 || b11 < -96))) {
                                i10 = i13 + 1;
                                if (bArr[i13] > -65) {
                                }
                            }
                        } else {
                            if (i12 >= i11 - 2) {
                                return Utf8.a(i12, bArr, i11);
                            }
                            int i14 = i12 + 1;
                            byte b12 = bArr[i12];
                            if (b12 <= -65) {
                                if ((((b12 + 112) + (b10 << 28)) >> 30) == 0) {
                                    int i15 = i14 + 1;
                                    if (bArr[i14] <= -65) {
                                        i12 = i15 + 1;
                                        if (bArr[i15] > -65) {
                                        }
                                    }
                                }
                            }
                        }
                        return -1;
                    }
                    i10 = i12;
                }
            }
            return 0;
        }
    }

    public static final class d extends b {
        public static int d(byte[] bArr, int i10, long j10, int i11) {
            if (i11 == 0) {
                b bVar = Utf8.f2376a;
                if (i10 > -12) {
                    return -1;
                }
                return i10;
            }
            if (i11 == 1) {
                return Utf8.c(i10, j1.g(j10, bArr));
            }
            if (i11 == 2) {
                return Utf8.d(i10, j1.g(j10, bArr), j1.g(j10 + 1, bArr));
            }
            throw new AssertionError();
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.b
        public final String a(int i10, byte[] bArr, int i11) throws InvalidProtocolBufferException {
            if ((i10 | i11 | ((bArr.length - i10) - i11)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
            }
            int i12 = i10 + i11;
            char[] cArr = new char[i11];
            int i13 = 0;
            while (i10 < i12) {
                byte bG = j1.g(i10, bArr);
                if (!(bG >= 0)) {
                    break;
                }
                i10++;
                cArr[i13] = (char) bG;
                i13++;
            }
            int i14 = i13;
            while (i10 < i12) {
                int i15 = i10 + 1;
                byte bG2 = j1.g(i10, bArr);
                if (bG2 >= 0) {
                    int i16 = i14 + 1;
                    cArr[i14] = (char) bG2;
                    i10 = i15;
                    while (true) {
                        i14 = i16;
                        if (i10 >= i12) {
                            break;
                        }
                        byte bG3 = j1.g(i10, bArr);
                        if (!(bG3 >= 0)) {
                            break;
                        }
                        i10++;
                        i16 = i14 + 1;
                        cArr[i14] = (char) bG3;
                    }
                } else {
                    if (!(bG2 < -32)) {
                        if (bG2 < -16) {
                            if (i15 >= i12 - 1) {
                                throw InvalidProtocolBufferException.a();
                            }
                            int i17 = i15 + 1;
                            a.b(bG2, j1.g(i15, bArr), j1.g(i17, bArr), cArr, i14);
                            i10 = i17 + 1;
                            i14++;
                        } else {
                            if (i15 >= i12 - 2) {
                                throw InvalidProtocolBufferException.a();
                            }
                            int i18 = i15 + 1;
                            byte bG4 = j1.g(i15, bArr);
                            int i19 = i18 + 1;
                            a.a(bG2, bG4, j1.g(i18, bArr), j1.g(i19, bArr), cArr, i14);
                            i14 = i14 + 1 + 1;
                            i10 = i19 + 1;
                        }
                    } else {
                        if (i15 >= i12) {
                            throw InvalidProtocolBufferException.a();
                        }
                        int i20 = i15 + 1;
                        byte bG5 = j1.g(i15, bArr);
                        int i21 = i14 + 1;
                        if (bG2 < -62 || a.c(bG5)) {
                            throw InvalidProtocolBufferException.a();
                        }
                        cArr[i14] = (char) (((bG2 & 31) << 6) | (bG5 & 63));
                        i10 = i20;
                        i14 = i21;
                    }
                }
            }
            return new String(cArr, 0, i14);
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.b
        public final int b(CharSequence charSequence, byte[] bArr, int i10, int i11) {
            long j10;
            char c10;
            long j11;
            int i12;
            long j12;
            long j13;
            char cCharAt;
            long j14 = i10;
            long j15 = i11 + j14;
            int length = charSequence.length();
            if (length > i11 || bArr.length - i11 < i10) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i10 + i11));
            }
            int i13 = 0;
            while (true) {
                j10 = 1;
                c10 = 128;
                if (i13 >= length || (cCharAt = charSequence.charAt(i13)) >= 128) {
                    break;
                }
                j1.p(bArr, j14, (byte) cCharAt);
                i13++;
                j14 = 1 + j14;
            }
            if (i13 == length) {
                return (int) j14;
            }
            while (i13 < length) {
                char cCharAt2 = charSequence.charAt(i13);
                if (cCharAt2 >= c10 || j14 >= j15) {
                    if (cCharAt2 < 2048 && j14 <= j15 - 2) {
                        long j16 = j14 + j10;
                        j1.p(bArr, j14, (byte) ((cCharAt2 >>> 6) | 960));
                        j1.p(bArr, j16, (byte) ((cCharAt2 & '?') | 128));
                        j13 = j16 + j10;
                        j12 = j10;
                    } else {
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j14 > j15 - 3) {
                            if (j14 > j15 - 4) {
                                if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i12 = i13 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i12)))) {
                                    throw new UnpairedSurrogateException(i13, length);
                                }
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + j14);
                            }
                            int i14 = i13 + 1;
                            if (i14 != length) {
                                char cCharAt3 = charSequence.charAt(i14);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    long j17 = j14 + 1;
                                    j1.p(bArr, j14, (byte) ((codePoint >>> 18) | 240));
                                    long j18 = j17 + 1;
                                    j1.p(bArr, j17, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j19 = j18 + 1;
                                    j1.p(bArr, j18, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j12 = 1;
                                    j13 = j19 + 1;
                                    j1.p(bArr, j19, (byte) ((codePoint & 63) | 128));
                                    i13 = i14;
                                } else {
                                    i13 = i14;
                                }
                            }
                            throw new UnpairedSurrogateException(i13 - 1, length);
                        }
                        long j20 = j14 + j10;
                        j1.p(bArr, j14, (byte) ((cCharAt2 >>> '\f') | 480));
                        long j21 = j20 + j10;
                        j1.p(bArr, j20, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                        j1.p(bArr, j21, (byte) ((cCharAt2 & '?') | 128));
                        j11 = j21 + 1;
                    }
                    i13++;
                    c10 = 128;
                    long j22 = j12;
                    j14 = j13;
                    j10 = j22;
                } else {
                    j11 = j14 + j10;
                    j1.p(bArr, j14, (byte) cCharAt2);
                }
                j13 = j11;
                j12 = 1;
                i13++;
                c10 = 128;
                long j222 = j12;
                j14 = j13;
                j10 = j222;
            }
            return (int) j14;
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.b
        public final int c(byte[] bArr, int i10, int i11) {
            int i12;
            long j10;
            if ((i10 | i11 | (bArr.length - i11)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
            }
            long j11 = i10;
            int i13 = (int) (i11 - j11);
            if (i13 >= 16) {
                long j12 = j11;
                i12 = 0;
                while (true) {
                    if (i12 >= i13) {
                        i12 = i13;
                        break;
                    }
                    long j13 = j12 + 1;
                    if (j1.g(j12, bArr) < 0) {
                        break;
                    }
                    i12++;
                    j12 = j13;
                }
            } else {
                i12 = 0;
            }
            int i14 = i13 - i12;
            long j14 = j11 + i12;
            while (true) {
                byte bG = 0;
                while (true) {
                    if (i14 <= 0) {
                        break;
                    }
                    long j15 = j14 + 1;
                    bG = j1.g(j14, bArr);
                    if (bG < 0) {
                        j14 = j15;
                        break;
                    }
                    i14--;
                    j14 = j15;
                }
                if (i14 != 0) {
                    int i15 = i14 - 1;
                    if (bG >= -32) {
                        if (bG >= -16) {
                            if (i15 >= 3) {
                                i14 = i15 - 3;
                                long j16 = j14 + 1;
                                byte bG2 = j1.g(j14, bArr);
                                if (bG2 <= -65 && (((bG2 + 112) + (bG << 28)) >> 30) == 0) {
                                    long j17 = j16 + 1;
                                    if (j1.g(j16, bArr) > -65) {
                                        break;
                                    }
                                    j10 = j17 + 1;
                                    if (j1.g(j17, bArr) > -65) {
                                        break;
                                    }
                                    j14 = j10;
                                } else {
                                    break;
                                }
                            } else {
                                return d(bArr, bG, j14, i15);
                            }
                        } else {
                            if (i15 < 2) {
                                return d(bArr, bG, j14, i15);
                            }
                            i14 = i15 - 2;
                            long j18 = j14 + 1;
                            byte bG3 = j1.g(j14, bArr);
                            if (bG3 > -65 || ((bG == -32 && bG3 < -96) || (bG == -19 && bG3 >= -96))) {
                                break;
                            }
                            j14 = j18 + 1;
                            if (j1.g(j18, bArr) > -65) {
                                break;
                            }
                        }
                    } else if (i15 != 0) {
                        i14 = i15 - 1;
                        if (bG < -62) {
                            break;
                        }
                        j10 = j14 + 1;
                        if (j1.g(j14, bArr) > -65) {
                            break;
                        }
                        j14 = j10;
                    } else {
                        return bG;
                    }
                } else {
                    return 0;
                }
            }
            return -1;
        }
    }

    static {
        f2376a = (!(j1.f2491f && j1.f2490e) || androidx.datastore.preferences.protobuf.d.a()) ? new c() : new d();
    }

    public static int a(int i10, byte[] bArr, int i11) {
        byte b10 = bArr[i10 - 1];
        int i12 = i11 - i10;
        if (i12 == 0) {
            if (b10 > -12) {
                b10 = -1;
            }
            return b10;
        }
        if (i12 == 1) {
            return c(b10, bArr[i10]);
        }
        if (i12 == 2) {
            return d(b10, bArr[i10], bArr[i10 + 1]);
        }
        throw new AssertionError();
    }

    public static int b(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        int i11 = 0;
        while (i11 < length && charSequence.charAt(i11) < 128) {
            i11++;
        }
        int i12 = length;
        while (true) {
            if (i11 >= length) {
                break;
            }
            char cCharAt = charSequence.charAt(i11);
            if (cCharAt < 2048) {
                i12 += (127 - cCharAt) >>> 31;
                i11++;
            } else {
                int length2 = charSequence.length();
                while (i11 < length2) {
                    char cCharAt2 = charSequence.charAt(i11);
                    if (cCharAt2 < 2048) {
                        i10 += (127 - cCharAt2) >>> 31;
                    } else {
                        i10 += 2;
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i11) < 65536) {
                                throw new UnpairedSurrogateException(i11, length2);
                            }
                            i11++;
                        }
                    }
                    i11++;
                }
                i12 += i10;
            }
        }
        if (i12 >= length) {
            return i12;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i12 + 4294967296L));
    }

    public static int c(int i10, int i11) {
        if (i10 > -12 || i11 > -65) {
            return -1;
        }
        return i10 ^ (i11 << 8);
    }

    public static int d(int i10, int i11, int i12) {
        if (i10 > -12 || i11 > -65 || i12 > -65) {
            return -1;
        }
        return (i10 ^ (i11 << 8)) ^ (i12 << 16);
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return f2376a.c(bArr, 0, bArr.length) == 0;
    }

    public static boolean isValidUtf8(byte[] bArr, int i10, int i11) {
        return f2376a.c(bArr, i10, i11) == 0;
    }
}
