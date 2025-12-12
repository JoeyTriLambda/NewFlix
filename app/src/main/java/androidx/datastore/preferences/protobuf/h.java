package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: CodedInputStream.java */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public int f2456a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2457b = 100;

    /* renamed from: c, reason: collision with root package name */
    public final int f2458c = Integer.MAX_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public i f2459d;

    /* compiled from: CodedInputStream.java */
    public static final class a extends h {

        /* renamed from: e, reason: collision with root package name */
        public final byte[] f2460e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f2461f;

        /* renamed from: g, reason: collision with root package name */
        public int f2462g;

        /* renamed from: h, reason: collision with root package name */
        public int f2463h;

        /* renamed from: i, reason: collision with root package name */
        public int f2464i;

        /* renamed from: j, reason: collision with root package name */
        public final int f2465j;

        /* renamed from: k, reason: collision with root package name */
        public int f2466k;

        /* renamed from: l, reason: collision with root package name */
        public int f2467l = Integer.MAX_VALUE;

        public a(byte[] bArr, int i10, int i11, boolean z10) {
            this.f2460e = bArr;
            this.f2462g = i11 + i10;
            this.f2464i = i10;
            this.f2465j = i10;
            this.f2461f = z10;
        }

        public final long a() throws IOException {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                j10 |= (r3 & 127) << i10;
                if ((readRawByte() & 128) == 0) {
                    return j10;
                }
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public void checkLastTagWas(int i10) throws InvalidProtocolBufferException {
            if (this.f2466k != i10) {
                throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
            }
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public int getTotalBytesRead() {
            return this.f2464i - this.f2465j;
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public boolean isAtEnd() throws IOException {
            return this.f2464i == this.f2462g;
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public void popLimit(int i10) {
            this.f2467l = i10;
            int i11 = this.f2462g + this.f2463h;
            this.f2462g = i11;
            int i12 = i11 - this.f2465j;
            if (i12 <= i10) {
                this.f2463h = 0;
                return;
            }
            int i13 = i12 - i10;
            this.f2463h = i13;
            this.f2462g = i11 - i13;
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public int pushLimit(int i10) throws InvalidProtocolBufferException {
            if (i10 < 0) {
                throw InvalidProtocolBufferException.d();
            }
            int totalBytesRead = getTotalBytesRead() + i10;
            int i11 = this.f2467l;
            if (totalBytesRead > i11) {
                throw InvalidProtocolBufferException.f();
            }
            this.f2467l = totalBytesRead;
            int i12 = this.f2462g + this.f2463h;
            this.f2462g = i12;
            int i13 = i12 - this.f2465j;
            if (i13 > totalBytesRead) {
                int i14 = i13 - totalBytesRead;
                this.f2463h = i14;
                this.f2462g = i12 - i14;
            } else {
                this.f2463h = 0;
            }
            return i11;
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public ByteString readBytes() throws IOException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                int i10 = this.f2462g;
                int i11 = this.f2464i;
                if (rawVarint32 <= i10 - i11) {
                    boolean z10 = this.f2461f;
                    ByteString byteStringCopyFrom = ByteString.copyFrom(this.f2460e, i11, rawVarint32);
                    this.f2464i += rawVarint32;
                    return byteStringCopyFrom;
                }
            }
            if (rawVarint32 == 0) {
                return ByteString.f2316m;
            }
            byte[] rawBytes = readRawBytes(rawVarint32);
            ByteString byteString = ByteString.f2316m;
            return new ByteString.LiteralByteString(rawBytes);
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        public byte readRawByte() throws IOException {
            int i10 = this.f2464i;
            if (i10 == this.f2462g) {
                throw InvalidProtocolBufferException.f();
            }
            this.f2464i = i10 + 1;
            return this.f2460e[i10];
        }

        public byte[] readRawBytes(int i10) throws IOException {
            if (i10 > 0) {
                int i11 = this.f2462g;
                int i12 = this.f2464i;
                if (i10 <= i11 - i12) {
                    int i13 = i10 + i12;
                    this.f2464i = i13;
                    return Arrays.copyOfRange(this.f2460e, i12, i13);
                }
            }
            if (i10 > 0) {
                throw InvalidProtocolBufferException.f();
            }
            if (i10 == 0) {
                return w.f2546b;
            }
            throw InvalidProtocolBufferException.d();
        }

        public int readRawLittleEndian32() throws IOException {
            int i10 = this.f2464i;
            if (this.f2462g - i10 < 4) {
                throw InvalidProtocolBufferException.f();
            }
            this.f2464i = i10 + 4;
            byte[] bArr = this.f2460e;
            return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
        }

        public long readRawLittleEndian64() throws IOException {
            int i10 = this.f2464i;
            if (this.f2462g - i10 < 8) {
                throw InvalidProtocolBufferException.f();
            }
            this.f2464i = i10 + 8;
            byte[] bArr = this.f2460e;
            return ((bArr[i10 + 7] & 255) << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
        
            if (r3[r2] < 0) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int readRawVarint32() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.f2464i
                int r1 = r5.f2462g
                if (r1 != r0) goto L7
                goto L6a
            L7:
                int r2 = r0 + 1
                byte[] r3 = r5.f2460e
                r0 = r3[r0]
                if (r0 < 0) goto L12
                r5.f2464i = r2
                return r0
            L12:
                int r1 = r1 - r2
                r4 = 9
                if (r1 >= r4) goto L18
                goto L6a
            L18:
                int r1 = r2 + 1
                r2 = r3[r2]
                int r2 = r2 << 7
                r0 = r0 ^ r2
                if (r0 >= 0) goto L24
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L70
            L24:
                int r2 = r1 + 1
                r1 = r3[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L31
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L2f:
                r1 = r2
                goto L70
            L31:
                int r1 = r2 + 1
                r2 = r3[r2]
                int r2 = r2 << 21
                r0 = r0 ^ r2
                if (r0 >= 0) goto L3f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L70
            L3f:
                int r2 = r1 + 1
                r1 = r3[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L2f
                int r1 = r2 + 1
                r2 = r3[r2]
                if (r2 >= 0) goto L70
                int r2 = r1 + 1
                r1 = r3[r1]
                if (r1 >= 0) goto L2f
                int r1 = r2 + 1
                r2 = r3[r2]
                if (r2 >= 0) goto L70
                int r2 = r1 + 1
                r1 = r3[r1]
                if (r1 >= 0) goto L2f
                int r1 = r2 + 1
                r2 = r3[r2]
                if (r2 >= 0) goto L70
            L6a:
                long r0 = r5.a()
                int r1 = (int) r0
                return r1
            L70:
                r5.f2464i = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.h.a.readRawVarint32():int");
        }

        public long readRawVarint64() throws IOException {
            long j10;
            long j11;
            long j12;
            int i10;
            int i11 = this.f2464i;
            int i12 = this.f2462g;
            if (i12 != i11) {
                int i13 = i11 + 1;
                byte[] bArr = this.f2460e;
                byte b10 = bArr[i11];
                if (b10 >= 0) {
                    this.f2464i = i13;
                    return b10;
                }
                if (i12 - i13 >= 9) {
                    int i14 = i13 + 1;
                    int i15 = b10 ^ (bArr[i13] << 7);
                    if (i15 >= 0) {
                        int i16 = i14 + 1;
                        int i17 = i15 ^ (bArr[i14] << 14);
                        if (i17 >= 0) {
                            j10 = i17 ^ 16256;
                        } else {
                            i14 = i16 + 1;
                            int i18 = i17 ^ (bArr[i16] << 21);
                            if (i18 >= 0) {
                                long j13 = i18;
                                int i19 = i14 + 1;
                                long j14 = (bArr[i14] << 28) ^ j13;
                                if (j14 >= 0) {
                                    j11 = j14 ^ 266354560;
                                    i14 = i19;
                                } else {
                                    int i20 = i19 + 1;
                                    long j15 = j14 ^ (bArr[i19] << 35);
                                    if (j15 < 0) {
                                        j12 = -34093383808L;
                                    } else {
                                        i16 = i20 + 1;
                                        long j16 = j15 ^ (bArr[i20] << 42);
                                        if (j16 >= 0) {
                                            j10 = j16 ^ 4363953127296L;
                                        } else {
                                            i20 = i16 + 1;
                                            j15 = j16 ^ (bArr[i16] << 49);
                                            if (j15 < 0) {
                                                j12 = -558586000294016L;
                                            } else {
                                                i16 = i20 + 1;
                                                j10 = (j15 ^ (bArr[i20] << 56)) ^ 71499008037633920L;
                                                if (j10 < 0) {
                                                    i20 = i16 + 1;
                                                    if (bArr[i16] >= 0) {
                                                        j11 = j10;
                                                        i14 = i20;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j11 = j12 ^ j15;
                                    i14 = i20;
                                }
                                this.f2464i = i14;
                                return j11;
                            }
                            i10 = i18 ^ (-2080896);
                        }
                        i14 = i16;
                        j11 = j10;
                        this.f2464i = i14;
                        return j11;
                    }
                    i10 = i15 ^ (-128);
                    j11 = i10;
                    this.f2464i = i14;
                    return j11;
                }
            }
            return a();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public int readSInt32() throws IOException {
            return h.decodeZigZag32(readRawVarint32());
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public long readSInt64() throws IOException {
            return h.decodeZigZag64(readRawVarint64());
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public String readString() throws IOException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                int i10 = this.f2462g;
                int i11 = this.f2464i;
                if (rawVarint32 <= i10 - i11) {
                    String str = new String(this.f2460e, i11, rawVarint32, w.f2545a);
                    this.f2464i += rawVarint32;
                    return str;
                }
            }
            if (rawVarint32 == 0) {
                return "";
            }
            if (rawVarint32 < 0) {
                throw InvalidProtocolBufferException.d();
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public String readStringRequireUtf8() throws IOException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                int i10 = this.f2462g;
                int i11 = this.f2464i;
                if (rawVarint32 <= i10 - i11) {
                    String strA = Utf8.f2376a.a(i11, this.f2460e, rawVarint32);
                    this.f2464i += rawVarint32;
                    return strA;
                }
            }
            if (rawVarint32 == 0) {
                return "";
            }
            if (rawVarint32 <= 0) {
                throw InvalidProtocolBufferException.d();
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.f2466k = 0;
                return 0;
            }
            int rawVarint32 = readRawVarint32();
            this.f2466k = rawVarint32;
            if (WireFormat.getTagFieldNumber(rawVarint32) != 0) {
                return this.f2466k;
            }
            throw new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public boolean skipField(int i10) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i10);
            int i11 = 0;
            if (tagWireType == 0) {
                if (this.f2462g - this.f2464i < 10) {
                    while (i11 < 10) {
                        if (readRawByte() < 0) {
                            i11++;
                        }
                    }
                    throw InvalidProtocolBufferException.c();
                }
                while (i11 < 10) {
                    int i12 = this.f2464i;
                    this.f2464i = i12 + 1;
                    if (this.f2460e[i12] < 0) {
                        i11++;
                    }
                }
                throw InvalidProtocolBufferException.c();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas((WireFormat.getTagFieldNumber(i10) << 3) | 4);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.b();
            }
            skipRawBytes(4);
            return true;
        }

        public void skipMessage() throws IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag));
        }

        public void skipRawBytes(int i10) throws IOException {
            if (i10 >= 0) {
                int i11 = this.f2462g;
                int i12 = this.f2464i;
                if (i10 <= i11 - i12) {
                    this.f2464i = i12 + i10;
                    return;
                }
            }
            if (i10 >= 0) {
                throw InvalidProtocolBufferException.f();
            }
            throw InvalidProtocolBufferException.d();
        }
    }

    /* compiled from: CodedInputStream.java */
    public static final class b extends h {

        /* renamed from: e, reason: collision with root package name */
        public final InputStream f2468e;

        /* renamed from: f, reason: collision with root package name */
        public final byte[] f2469f;

        /* renamed from: g, reason: collision with root package name */
        public int f2470g;

        /* renamed from: h, reason: collision with root package name */
        public int f2471h;

        /* renamed from: i, reason: collision with root package name */
        public int f2472i;

        /* renamed from: j, reason: collision with root package name */
        public int f2473j;

        /* renamed from: k, reason: collision with root package name */
        public int f2474k;

        /* renamed from: l, reason: collision with root package name */
        public int f2475l = Integer.MAX_VALUE;

        public b(InputStream inputStream, int i10) {
            Charset charset = w.f2545a;
            if (inputStream == null) {
                throw new NullPointerException("input");
            }
            this.f2468e = inputStream;
            this.f2469f = new byte[i10];
            this.f2470g = 0;
            this.f2472i = 0;
            this.f2474k = 0;
        }

        public final byte[] a(int i10) throws IOException {
            byte[] bArrB = b(i10);
            if (bArrB != null) {
                return bArrB;
            }
            int i11 = this.f2472i;
            int i12 = this.f2470g;
            int length = i12 - i11;
            this.f2474k += i12;
            this.f2472i = 0;
            this.f2470g = 0;
            ArrayList arrayListC = c(i10 - length);
            byte[] bArr = new byte[i10];
            System.arraycopy(this.f2469f, i11, bArr, 0, length);
            Iterator it = arrayListC.iterator();
            while (it.hasNext()) {
                byte[] bArr2 = (byte[]) it.next();
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        public final byte[] b(int i10) throws IOException {
            if (i10 == 0) {
                return w.f2546b;
            }
            if (i10 < 0) {
                throw InvalidProtocolBufferException.d();
            }
            int i11 = this.f2474k;
            int i12 = this.f2472i;
            int i13 = i11 + i12 + i10;
            if (i13 - this.f2458c > 0) {
                throw new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
            }
            int i14 = this.f2475l;
            if (i13 > i14) {
                skipRawBytes((i14 - i11) - i12);
                throw InvalidProtocolBufferException.f();
            }
            int i15 = this.f2470g - i12;
            int i16 = i10 - i15;
            InputStream inputStream = this.f2468e;
            if (i16 >= 4096 && i16 > inputStream.available()) {
                return null;
            }
            byte[] bArr = new byte[i10];
            System.arraycopy(this.f2469f, this.f2472i, bArr, 0, i15);
            this.f2474k += this.f2470g;
            this.f2472i = 0;
            this.f2470g = 0;
            while (i15 < i10) {
                int i17 = inputStream.read(bArr, i15, i10 - i15);
                if (i17 == -1) {
                    throw InvalidProtocolBufferException.f();
                }
                this.f2474k += i17;
                i15 += i17;
            }
            return bArr;
        }

        public final ArrayList c(int i10) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i10 > 0) {
                int iMin = Math.min(i10, 4096);
                byte[] bArr = new byte[iMin];
                int i11 = 0;
                while (i11 < iMin) {
                    int i12 = this.f2468e.read(bArr, i11, iMin - i11);
                    if (i12 == -1) {
                        throw InvalidProtocolBufferException.f();
                    }
                    this.f2474k += i12;
                    i11 += i12;
                }
                i10 -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public void checkLastTagWas(int i10) throws InvalidProtocolBufferException {
            if (this.f2473j != i10) {
                throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
            }
        }

        public final long d() throws IOException {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                j10 |= (r3 & 127) << i10;
                if ((readRawByte() & 128) == 0) {
                    return j10;
                }
            }
            throw InvalidProtocolBufferException.c();
        }

        public final void e() {
            int i10 = this.f2470g + this.f2471h;
            this.f2470g = i10;
            int i11 = this.f2474k + i10;
            int i12 = this.f2475l;
            if (i11 <= i12) {
                this.f2471h = 0;
                return;
            }
            int i13 = i11 - i12;
            this.f2471h = i13;
            this.f2470g = i10 - i13;
        }

        public final void f(int i10) throws IOException {
            if (g(i10)) {
                return;
            }
            if (i10 <= (this.f2458c - this.f2474k) - this.f2472i) {
                throw InvalidProtocolBufferException.f();
            }
            throw new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }

        public final boolean g(int i10) throws IOException {
            int i11 = this.f2472i;
            int i12 = i11 + i10;
            int i13 = this.f2470g;
            if (i12 <= i13) {
                throw new IllegalStateException(o1.a.d("refillBuffer() called when ", i10, " bytes were already available in buffer"));
            }
            int i14 = this.f2474k;
            int i15 = this.f2458c;
            if (i10 > (i15 - i14) - i11 || i14 + i11 + i10 > this.f2475l) {
                return false;
            }
            byte[] bArr = this.f2469f;
            if (i11 > 0) {
                if (i13 > i11) {
                    System.arraycopy(bArr, i11, bArr, 0, i13 - i11);
                }
                this.f2474k += i11;
                this.f2470g -= i11;
                this.f2472i = 0;
            }
            int i16 = this.f2470g;
            int iMin = Math.min(bArr.length - i16, (i15 - this.f2474k) - i16);
            InputStream inputStream = this.f2468e;
            int i17 = inputStream.read(bArr, i16, iMin);
            if (i17 == 0 || i17 < -1 || i17 > bArr.length) {
                throw new IllegalStateException(inputStream.getClass() + "#read(byte[]) returned invalid result: " + i17 + "\nThe InputStream implementation is buggy.");
            }
            if (i17 <= 0) {
                return false;
            }
            this.f2470g += i17;
            e();
            if (this.f2470g >= i10) {
                return true;
            }
            return g(i10);
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public int getTotalBytesRead() {
            return this.f2474k + this.f2472i;
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public boolean isAtEnd() throws IOException {
            return this.f2472i == this.f2470g && !g(1);
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public void popLimit(int i10) {
            this.f2475l = i10;
            e();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public int pushLimit(int i10) throws InvalidProtocolBufferException {
            if (i10 < 0) {
                throw InvalidProtocolBufferException.d();
            }
            int i11 = this.f2474k + this.f2472i + i10;
            int i12 = this.f2475l;
            if (i11 > i12) {
                throw InvalidProtocolBufferException.f();
            }
            this.f2475l = i11;
            e();
            return i12;
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public ByteString readBytes() throws IOException {
            int rawVarint32 = readRawVarint32();
            int i10 = this.f2470g;
            int i11 = this.f2472i;
            int i12 = i10 - i11;
            byte[] bArr = this.f2469f;
            if (rawVarint32 <= i12 && rawVarint32 > 0) {
                ByteString byteStringCopyFrom = ByteString.copyFrom(bArr, i11, rawVarint32);
                this.f2472i += rawVarint32;
                return byteStringCopyFrom;
            }
            if (rawVarint32 == 0) {
                return ByteString.f2316m;
            }
            byte[] bArrB = b(rawVarint32);
            if (bArrB != null) {
                return ByteString.copyFrom(bArrB);
            }
            int i13 = this.f2472i;
            int i14 = this.f2470g;
            int length = i14 - i13;
            this.f2474k += i14;
            this.f2472i = 0;
            this.f2470g = 0;
            ArrayList arrayListC = c(rawVarint32 - length);
            byte[] bArr2 = new byte[rawVarint32];
            System.arraycopy(bArr, i13, bArr2, 0, length);
            Iterator it = arrayListC.iterator();
            while (it.hasNext()) {
                byte[] bArr3 = (byte[]) it.next();
                System.arraycopy(bArr3, 0, bArr2, length, bArr3.length);
                length += bArr3.length;
            }
            ByteString byteString = ByteString.f2316m;
            return new ByteString.LiteralByteString(bArr2);
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        public byte readRawByte() throws IOException {
            if (this.f2472i == this.f2470g) {
                f(1);
            }
            int i10 = this.f2472i;
            this.f2472i = i10 + 1;
            return this.f2469f[i10];
        }

        public int readRawLittleEndian32() throws IOException {
            int i10 = this.f2472i;
            if (this.f2470g - i10 < 4) {
                f(4);
                i10 = this.f2472i;
            }
            this.f2472i = i10 + 4;
            byte[] bArr = this.f2469f;
            return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
        }

        public long readRawLittleEndian64() throws IOException {
            int i10 = this.f2472i;
            if (this.f2470g - i10 < 8) {
                f(8);
                i10 = this.f2472i;
            }
            this.f2472i = i10 + 8;
            byte[] bArr = this.f2469f;
            return ((bArr[i10 + 7] & 255) << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
        
            if (r3[r2] < 0) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int readRawVarint32() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.f2472i
                int r1 = r5.f2470g
                if (r1 != r0) goto L7
                goto L6a
            L7:
                int r2 = r0 + 1
                byte[] r3 = r5.f2469f
                r0 = r3[r0]
                if (r0 < 0) goto L12
                r5.f2472i = r2
                return r0
            L12:
                int r1 = r1 - r2
                r4 = 9
                if (r1 >= r4) goto L18
                goto L6a
            L18:
                int r1 = r2 + 1
                r2 = r3[r2]
                int r2 = r2 << 7
                r0 = r0 ^ r2
                if (r0 >= 0) goto L24
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L70
            L24:
                int r2 = r1 + 1
                r1 = r3[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L31
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L2f:
                r1 = r2
                goto L70
            L31:
                int r1 = r2 + 1
                r2 = r3[r2]
                int r2 = r2 << 21
                r0 = r0 ^ r2
                if (r0 >= 0) goto L3f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L70
            L3f:
                int r2 = r1 + 1
                r1 = r3[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L2f
                int r1 = r2 + 1
                r2 = r3[r2]
                if (r2 >= 0) goto L70
                int r2 = r1 + 1
                r1 = r3[r1]
                if (r1 >= 0) goto L2f
                int r1 = r2 + 1
                r2 = r3[r2]
                if (r2 >= 0) goto L70
                int r2 = r1 + 1
                r1 = r3[r1]
                if (r1 >= 0) goto L2f
                int r1 = r2 + 1
                r2 = r3[r2]
                if (r2 >= 0) goto L70
            L6a:
                long r0 = r5.d()
                int r1 = (int) r0
                return r1
            L70:
                r5.f2472i = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.h.b.readRawVarint32():int");
        }

        public long readRawVarint64() throws IOException {
            long j10;
            long j11;
            long j12;
            int i10;
            int i11 = this.f2472i;
            int i12 = this.f2470g;
            if (i12 != i11) {
                int i13 = i11 + 1;
                byte[] bArr = this.f2469f;
                byte b10 = bArr[i11];
                if (b10 >= 0) {
                    this.f2472i = i13;
                    return b10;
                }
                if (i12 - i13 >= 9) {
                    int i14 = i13 + 1;
                    int i15 = b10 ^ (bArr[i13] << 7);
                    if (i15 >= 0) {
                        int i16 = i14 + 1;
                        int i17 = i15 ^ (bArr[i14] << 14);
                        if (i17 >= 0) {
                            j10 = i17 ^ 16256;
                        } else {
                            i14 = i16 + 1;
                            int i18 = i17 ^ (bArr[i16] << 21);
                            if (i18 >= 0) {
                                long j13 = i18;
                                int i19 = i14 + 1;
                                long j14 = (bArr[i14] << 28) ^ j13;
                                if (j14 >= 0) {
                                    j11 = j14 ^ 266354560;
                                    i14 = i19;
                                } else {
                                    int i20 = i19 + 1;
                                    long j15 = j14 ^ (bArr[i19] << 35);
                                    if (j15 < 0) {
                                        j12 = -34093383808L;
                                    } else {
                                        i16 = i20 + 1;
                                        long j16 = j15 ^ (bArr[i20] << 42);
                                        if (j16 >= 0) {
                                            j10 = j16 ^ 4363953127296L;
                                        } else {
                                            i20 = i16 + 1;
                                            j15 = j16 ^ (bArr[i16] << 49);
                                            if (j15 < 0) {
                                                j12 = -558586000294016L;
                                            } else {
                                                i16 = i20 + 1;
                                                j10 = (j15 ^ (bArr[i20] << 56)) ^ 71499008037633920L;
                                                if (j10 < 0) {
                                                    i20 = i16 + 1;
                                                    if (bArr[i16] >= 0) {
                                                        j11 = j10;
                                                        i14 = i20;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j11 = j12 ^ j15;
                                    i14 = i20;
                                }
                                this.f2472i = i14;
                                return j11;
                            }
                            i10 = i18 ^ (-2080896);
                        }
                        i14 = i16;
                        j11 = j10;
                        this.f2472i = i14;
                        return j11;
                    }
                    i10 = i15 ^ (-128);
                    j11 = i10;
                    this.f2472i = i14;
                    return j11;
                }
            }
            return d();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public int readSInt32() throws IOException {
            return h.decodeZigZag32(readRawVarint32());
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public long readSInt64() throws IOException {
            return h.decodeZigZag64(readRawVarint64());
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public String readString() throws IOException {
            int rawVarint32 = readRawVarint32();
            byte[] bArr = this.f2469f;
            if (rawVarint32 > 0) {
                int i10 = this.f2470g;
                int i11 = this.f2472i;
                if (rawVarint32 <= i10 - i11) {
                    String str = new String(bArr, i11, rawVarint32, w.f2545a);
                    this.f2472i += rawVarint32;
                    return str;
                }
            }
            if (rawVarint32 == 0) {
                return "";
            }
            if (rawVarint32 > this.f2470g) {
                return new String(a(rawVarint32), w.f2545a);
            }
            f(rawVarint32);
            String str2 = new String(bArr, this.f2472i, rawVarint32, w.f2545a);
            this.f2472i += rawVarint32;
            return str2;
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public String readStringRequireUtf8() throws IOException {
            int rawVarint32 = readRawVarint32();
            int i10 = this.f2472i;
            int i11 = this.f2470g;
            int i12 = i11 - i10;
            byte[] bArrA = this.f2469f;
            if (rawVarint32 <= i12 && rawVarint32 > 0) {
                this.f2472i = i10 + rawVarint32;
            } else {
                if (rawVarint32 == 0) {
                    return "";
                }
                i10 = 0;
                if (rawVarint32 <= i11) {
                    f(rawVarint32);
                    this.f2472i = rawVarint32 + 0;
                } else {
                    bArrA = a(rawVarint32);
                }
            }
            return Utf8.f2376a.a(i10, bArrA, rawVarint32);
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.f2473j = 0;
                return 0;
            }
            int rawVarint32 = readRawVarint32();
            this.f2473j = rawVarint32;
            if (WireFormat.getTagFieldNumber(rawVarint32) != 0) {
                return this.f2473j;
            }
            throw new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public boolean skipField(int i10) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i10);
            int i11 = 0;
            if (tagWireType == 0) {
                if (this.f2470g - this.f2472i < 10) {
                    while (i11 < 10) {
                        if (readRawByte() < 0) {
                            i11++;
                        }
                    }
                    throw InvalidProtocolBufferException.c();
                }
                while (i11 < 10) {
                    int i12 = this.f2472i;
                    this.f2472i = i12 + 1;
                    if (this.f2469f[i12] < 0) {
                        i11++;
                    }
                }
                throw InvalidProtocolBufferException.c();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas((WireFormat.getTagFieldNumber(i10) << 3) | 4);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.b();
            }
            skipRawBytes(4);
            return true;
        }

        public void skipMessage() throws IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag));
        }

        public void skipRawBytes(int i10) throws IOException {
            int i11 = this.f2470g;
            int i12 = this.f2472i;
            if (i10 <= i11 - i12 && i10 >= 0) {
                this.f2472i = i12 + i10;
                return;
            }
            InputStream inputStream = this.f2468e;
            if (i10 < 0) {
                throw InvalidProtocolBufferException.d();
            }
            int i13 = this.f2474k;
            int i14 = i13 + i12;
            int i15 = i14 + i10;
            int i16 = this.f2475l;
            if (i15 > i16) {
                skipRawBytes((i16 - i13) - i12);
                throw InvalidProtocolBufferException.f();
            }
            this.f2474k = i14;
            int i17 = i11 - i12;
            this.f2470g = 0;
            this.f2472i = 0;
            while (i17 < i10) {
                long j10 = i10 - i17;
                try {
                    long jSkip = inputStream.skip(j10);
                    if (jSkip < 0 || jSkip > j10) {
                        throw new IllegalStateException(inputStream.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i17 += (int) jSkip;
                    }
                } finally {
                    this.f2474k += i17;
                    e();
                }
            }
            if (i17 >= i10) {
                return;
            }
            int i18 = this.f2470g;
            int i19 = i18 - this.f2472i;
            this.f2472i = i18;
            f(1);
            while (true) {
                int i20 = i10 - i19;
                int i21 = this.f2470g;
                if (i20 <= i21) {
                    this.f2472i = i20;
                    return;
                } else {
                    i19 += i21;
                    this.f2472i = i21;
                    f(1);
                }
            }
        }
    }

    public static int decodeZigZag32(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    public static long decodeZigZag64(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    public static h newInstance(InputStream inputStream) {
        return newInstance(inputStream, 4096);
    }

    public abstract void checkLastTagWas(int i10) throws InvalidProtocolBufferException;

    public abstract int getTotalBytesRead();

    public abstract boolean isAtEnd() throws IOException;

    public abstract void popLimit(int i10);

    public abstract int pushLimit(int i10) throws InvalidProtocolBufferException;

    public abstract boolean readBool() throws IOException;

    public abstract ByteString readBytes() throws IOException;

    public abstract double readDouble() throws IOException;

    public abstract int readEnum() throws IOException;

    public abstract int readFixed32() throws IOException;

    public abstract long readFixed64() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract int readInt32() throws IOException;

    public abstract long readInt64() throws IOException;

    public abstract int readSFixed32() throws IOException;

    public abstract long readSFixed64() throws IOException;

    public abstract int readSInt32() throws IOException;

    public abstract long readSInt64() throws IOException;

    public abstract String readString() throws IOException;

    public abstract String readStringRequireUtf8() throws IOException;

    public abstract int readTag() throws IOException;

    public abstract int readUInt32() throws IOException;

    public abstract long readUInt64() throws IOException;

    public abstract boolean skipField(int i10) throws IOException;

    public static h newInstance(InputStream inputStream, int i10) {
        if (i10 > 0) {
            return inputStream == null ? newInstance(w.f2546b) : new b(inputStream, i10);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static h newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static h newInstance(byte[] bArr, int i10, int i11) {
        a aVar = new a(bArr, i10, i11, false);
        try {
            aVar.pushLimit(i11);
            return aVar;
        } catch (InvalidProtocolBufferException e10) {
            throw new IllegalArgumentException(e10);
        }
    }
}
