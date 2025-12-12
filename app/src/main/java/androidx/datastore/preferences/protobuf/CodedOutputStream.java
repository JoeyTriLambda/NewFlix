package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Utf8;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class CodedOutputStream extends g {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f2327b = Logger.getLogger(CodedOutputStream.class.getName());

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f2328c = j1.f2491f;

    /* renamed from: a, reason: collision with root package name */
    public j f2329a;

    public static abstract class a extends CodedOutputStream {

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f2330d;

        /* renamed from: e, reason: collision with root package name */
        public final int f2331e;

        /* renamed from: f, reason: collision with root package name */
        public int f2332f;

        public a(int i10) {
            if (i10 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i10, 20)];
            this.f2330d = bArr;
            this.f2331e = bArr.length;
        }

        public final void d(int i10) {
            int i11 = this.f2332f;
            int i12 = i11 + 1;
            byte[] bArr = this.f2330d;
            bArr[i11] = (byte) (i10 & 255);
            int i13 = i12 + 1;
            bArr[i12] = (byte) ((i10 >> 8) & 255);
            int i14 = i13 + 1;
            bArr[i13] = (byte) ((i10 >> 16) & 255);
            this.f2332f = i14 + 1;
            bArr[i14] = (byte) ((i10 >> 24) & 255);
        }

        public final void e(long j10) {
            int i10 = this.f2332f;
            int i11 = i10 + 1;
            byte[] bArr = this.f2330d;
            bArr[i10] = (byte) (j10 & 255);
            int i12 = i11 + 1;
            bArr[i11] = (byte) ((j10 >> 8) & 255);
            int i13 = i12 + 1;
            bArr[i12] = (byte) ((j10 >> 16) & 255);
            int i14 = i13 + 1;
            bArr[i13] = (byte) (255 & (j10 >> 24));
            int i15 = i14 + 1;
            bArr[i14] = (byte) (((int) (j10 >> 32)) & 255);
            int i16 = i15 + 1;
            bArr[i15] = (byte) (((int) (j10 >> 40)) & 255);
            int i17 = i16 + 1;
            bArr[i16] = (byte) (((int) (j10 >> 48)) & 255);
            this.f2332f = i17 + 1;
            bArr[i17] = (byte) (((int) (j10 >> 56)) & 255);
        }

        public final void f(int i10, int i11) {
            g((i10 << 3) | i11);
        }

        public final void g(int i10) {
            boolean z10 = CodedOutputStream.f2328c;
            byte[] bArr = this.f2330d;
            if (z10) {
                while ((i10 & (-128)) != 0) {
                    int i11 = this.f2332f;
                    this.f2332f = i11 + 1;
                    j1.p(bArr, i11, (byte) ((i10 & 127) | 128));
                    i10 >>>= 7;
                }
                int i12 = this.f2332f;
                this.f2332f = i12 + 1;
                j1.p(bArr, i12, (byte) i10);
                return;
            }
            while ((i10 & (-128)) != 0) {
                int i13 = this.f2332f;
                this.f2332f = i13 + 1;
                bArr[i13] = (byte) ((i10 & 127) | 128);
                i10 >>>= 7;
            }
            int i14 = this.f2332f;
            this.f2332f = i14 + 1;
            bArr[i14] = (byte) i10;
        }

        public final void h(long j10) {
            boolean z10 = CodedOutputStream.f2328c;
            byte[] bArr = this.f2330d;
            if (z10) {
                while ((j10 & (-128)) != 0) {
                    int i10 = this.f2332f;
                    this.f2332f = i10 + 1;
                    j1.p(bArr, i10, (byte) ((((int) j10) & 127) | 128));
                    j10 >>>= 7;
                }
                int i11 = this.f2332f;
                this.f2332f = i11 + 1;
                j1.p(bArr, i11, (byte) j10);
                return;
            }
            while ((j10 & (-128)) != 0) {
                int i12 = this.f2332f;
                this.f2332f = i12 + 1;
                bArr[i12] = (byte) ((((int) j10) & 127) | 128);
                j10 >>>= 7;
            }
            int i13 = this.f2332f;
            this.f2332f = i13 + 1;
            bArr[i13] = (byte) j10;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final int spaceLeft() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    @Deprecated
    public static int a(int i10, k0 k0Var, y0 y0Var) {
        return ((androidx.datastore.preferences.protobuf.a) k0Var).b(y0Var) + (computeTagSize(i10) * 2);
    }

    public static int computeBoolSize(int i10, boolean z10) {
        return computeBoolSizeNoTag(z10) + computeTagSize(i10);
    }

    public static int computeBoolSizeNoTag(boolean z10) {
        return 1;
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        int length = bArr.length;
        return computeUInt32SizeNoTag(length) + length;
    }

    public static int computeBytesSize(int i10, ByteString byteString) {
        return computeBytesSizeNoTag(byteString) + computeTagSize(i10);
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        int size = byteString.size();
        return computeUInt32SizeNoTag(size) + size;
    }

    public static int computeDoubleSize(int i10, double d10) {
        return computeDoubleSizeNoTag(d10) + computeTagSize(i10);
    }

    public static int computeDoubleSizeNoTag(double d10) {
        return 8;
    }

    public static int computeEnumSize(int i10, int i11) {
        return computeEnumSizeNoTag(i11) + computeTagSize(i10);
    }

    public static int computeEnumSizeNoTag(int i10) {
        return computeInt32SizeNoTag(i10);
    }

    public static int computeFixed32Size(int i10, int i11) {
        return computeFixed32SizeNoTag(i11) + computeTagSize(i10);
    }

    public static int computeFixed32SizeNoTag(int i10) {
        return 4;
    }

    public static int computeFixed64Size(int i10, long j10) {
        return computeFixed64SizeNoTag(j10) + computeTagSize(i10);
    }

    public static int computeFixed64SizeNoTag(long j10) {
        return 8;
    }

    public static int computeFloatSize(int i10, float f10) {
        return computeFloatSizeNoTag(f10) + computeTagSize(i10);
    }

    public static int computeFloatSizeNoTag(float f10) {
        return 4;
    }

    @Deprecated
    public static int computeGroupSizeNoTag(k0 k0Var) {
        return k0Var.getSerializedSize();
    }

    public static int computeInt32Size(int i10, int i11) {
        return computeInt32SizeNoTag(i11) + computeTagSize(i10);
    }

    public static int computeInt32SizeNoTag(int i10) {
        if (i10 >= 0) {
            return computeUInt32SizeNoTag(i10);
        }
        return 10;
    }

    public static int computeInt64Size(int i10, long j10) {
        return computeInt64SizeNoTag(j10) + computeTagSize(i10);
    }

    public static int computeInt64SizeNoTag(long j10) {
        return computeUInt64SizeNoTag(j10);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int i10, y yVar) {
        return computeLazyFieldSize(3, yVar) + computeUInt32Size(2, i10) + (computeTagSize(1) * 2);
    }

    public static int computeLazyFieldSize(int i10, y yVar) {
        return computeLazyFieldSizeNoTag(yVar) + computeTagSize(i10);
    }

    public static int computeLazyFieldSizeNoTag(y yVar) {
        int serializedSize = yVar.getSerializedSize();
        return computeUInt32SizeNoTag(serializedSize) + serializedSize;
    }

    public static int computeMessageSetExtensionSize(int i10, k0 k0Var) {
        return computeMessageSize(3, k0Var) + computeUInt32Size(2, i10) + (computeTagSize(1) * 2);
    }

    public static int computeMessageSize(int i10, k0 k0Var) {
        return computeMessageSizeNoTag(k0Var) + computeTagSize(i10);
    }

    public static int computeMessageSizeNoTag(k0 k0Var) {
        int serializedSize = k0Var.getSerializedSize();
        return computeUInt32SizeNoTag(serializedSize) + serializedSize;
    }

    public static int computeRawMessageSetExtensionSize(int i10, ByteString byteString) {
        return computeBytesSize(3, byteString) + computeUInt32Size(2, i10) + (computeTagSize(1) * 2);
    }

    @Deprecated
    public static int computeRawVarint32Size(int i10) {
        return computeUInt32SizeNoTag(i10);
    }

    public static int computeSFixed32Size(int i10, int i11) {
        return computeSFixed32SizeNoTag(i11) + computeTagSize(i10);
    }

    public static int computeSFixed32SizeNoTag(int i10) {
        return 4;
    }

    public static int computeSFixed64Size(int i10, long j10) {
        return computeSFixed64SizeNoTag(j10) + computeTagSize(i10);
    }

    public static int computeSFixed64SizeNoTag(long j10) {
        return 8;
    }

    public static int computeSInt32Size(int i10, int i11) {
        return computeSInt32SizeNoTag(i11) + computeTagSize(i10);
    }

    public static int computeSInt32SizeNoTag(int i10) {
        return computeUInt32SizeNoTag(encodeZigZag32(i10));
    }

    public static int computeSInt64Size(int i10, long j10) {
        return computeSInt64SizeNoTag(j10) + computeTagSize(i10);
    }

    public static int computeSInt64SizeNoTag(long j10) {
        return computeUInt64SizeNoTag(encodeZigZag64(j10));
    }

    public static int computeStringSize(int i10, String str) {
        return computeStringSizeNoTag(str) + computeTagSize(i10);
    }

    public static int computeStringSizeNoTag(String str) {
        int length;
        try {
            length = Utf8.b(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(w.f2545a).length;
        }
        return computeUInt32SizeNoTag(length) + length;
    }

    public static int computeTagSize(int i10) {
        return computeUInt32SizeNoTag((i10 << 3) | 0);
    }

    public static int computeUInt32Size(int i10, int i11) {
        return computeUInt32SizeNoTag(i11) + computeTagSize(i10);
    }

    public static int computeUInt32SizeNoTag(int i10) {
        if ((i10 & (-128)) == 0) {
            return 1;
        }
        if ((i10 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i10) == 0) {
            return 3;
        }
        return (i10 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int computeUInt64Size(int i10, long j10) {
        return computeUInt64SizeNoTag(j10) + computeTagSize(i10);
    }

    public static int computeUInt64SizeNoTag(long j10) {
        int i10;
        if (((-128) & j10) == 0) {
            return 1;
        }
        if (j10 < 0) {
            return 10;
        }
        if (((-34359738368L) & j10) != 0) {
            j10 >>>= 28;
            i10 = 6;
        } else {
            i10 = 2;
        }
        if (((-2097152) & j10) != 0) {
            i10 += 2;
            j10 >>>= 14;
        }
        return (j10 & (-16384)) != 0 ? i10 + 1 : i10;
    }

    public static int encodeZigZag32(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    public static long encodeZigZag64(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i10) {
        return new c(outputStream, i10);
    }

    public final void b(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        f2327b.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(w.f2545a);
        try {
            writeUInt32NoTag(bytes.length);
            writeLazy(bytes, 0, bytes.length);
        } catch (OutOfSpaceException e10) {
            throw e10;
        } catch (IndexOutOfBoundsException e11) {
            throw new OutOfSpaceException(e11);
        }
    }

    public abstract void c(int i10, k0 k0Var, y0 y0Var) throws IOException;

    public final void checkNoSpaceLeft() {
        if (spaceLeft() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void flush() throws IOException;

    public abstract int spaceLeft();

    public abstract void write(byte b10) throws IOException;

    public abstract void writeBool(int i10, boolean z10) throws IOException;

    public final void writeBoolNoTag(boolean z10) throws IOException {
        write(z10 ? (byte) 1 : (byte) 0);
    }

    public final void writeByteArrayNoTag(byte[] bArr) throws IOException {
        writeByteArrayNoTag(bArr, 0, bArr.length);
    }

    public abstract void writeByteArrayNoTag(byte[] bArr, int i10, int i11) throws IOException;

    public abstract void writeBytes(int i10, ByteString byteString) throws IOException;

    public abstract void writeBytesNoTag(ByteString byteString) throws IOException;

    public final void writeDouble(int i10, double d10) throws IOException {
        writeFixed64(i10, Double.doubleToRawLongBits(d10));
    }

    public final void writeDoubleNoTag(double d10) throws IOException {
        writeFixed64NoTag(Double.doubleToRawLongBits(d10));
    }

    public final void writeEnum(int i10, int i11) throws IOException {
        writeInt32(i10, i11);
    }

    public final void writeEnumNoTag(int i10) throws IOException {
        writeInt32NoTag(i10);
    }

    public abstract void writeFixed32(int i10, int i11) throws IOException;

    public abstract void writeFixed32NoTag(int i10) throws IOException;

    public abstract void writeFixed64(int i10, long j10) throws IOException;

    public abstract void writeFixed64NoTag(long j10) throws IOException;

    public final void writeFloat(int i10, float f10) throws IOException {
        writeFixed32(i10, Float.floatToRawIntBits(f10));
    }

    public final void writeFloatNoTag(float f10) throws IOException {
        writeFixed32NoTag(Float.floatToRawIntBits(f10));
    }

    @Deprecated
    public final void writeGroup(int i10, k0 k0Var) throws IOException {
        writeTag(i10, 3);
        writeGroupNoTag(k0Var);
        writeTag(i10, 4);
    }

    @Deprecated
    public final void writeGroupNoTag(k0 k0Var) throws IOException {
        k0Var.writeTo(this);
    }

    public abstract void writeInt32(int i10, int i11) throws IOException;

    public abstract void writeInt32NoTag(int i10) throws IOException;

    public final void writeInt64(int i10, long j10) throws IOException {
        writeUInt64(i10, j10);
    }

    public final void writeInt64NoTag(long j10) throws IOException {
        writeUInt64NoTag(j10);
    }

    @Override // androidx.datastore.preferences.protobuf.g
    public abstract void writeLazy(byte[] bArr, int i10, int i11) throws IOException;

    public abstract void writeMessageNoTag(k0 k0Var) throws IOException;

    public abstract void writeMessageSetExtension(int i10, k0 k0Var) throws IOException;

    public abstract void writeRawMessageSetExtension(int i10, ByteString byteString) throws IOException;

    public final void writeSFixed32(int i10, int i11) throws IOException {
        writeFixed32(i10, i11);
    }

    public final void writeSFixed32NoTag(int i10) throws IOException {
        writeFixed32NoTag(i10);
    }

    public final void writeSFixed64(int i10, long j10) throws IOException {
        writeFixed64(i10, j10);
    }

    public final void writeSFixed64NoTag(long j10) throws IOException {
        writeFixed64NoTag(j10);
    }

    public final void writeSInt32(int i10, int i11) throws IOException {
        writeUInt32(i10, encodeZigZag32(i11));
    }

    public final void writeSInt32NoTag(int i10) throws IOException {
        writeUInt32NoTag(encodeZigZag32(i10));
    }

    public final void writeSInt64(int i10, long j10) throws IOException {
        writeUInt64(i10, encodeZigZag64(j10));
    }

    public final void writeSInt64NoTag(long j10) throws IOException {
        writeUInt64NoTag(encodeZigZag64(j10));
    }

    public abstract void writeString(int i10, String str) throws IOException;

    public abstract void writeStringNoTag(String str) throws IOException;

    public abstract void writeTag(int i10, int i11) throws IOException;

    public abstract void writeUInt32(int i10, int i11) throws IOException;

    public abstract void writeUInt32NoTag(int i10) throws IOException;

    public abstract void writeUInt64(int i10, long j10) throws IOException;

    public abstract void writeUInt64NoTag(long j10) throws IOException;

    public static CodedOutputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static class b extends CodedOutputStream {

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f2333d;

        /* renamed from: e, reason: collision with root package name */
        public final int f2334e;

        /* renamed from: f, reason: collision with root package name */
        public int f2335f;

        public b(byte[] bArr, int i10, int i11) {
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i12 = i10 + i11;
            if ((i10 | i11 | (bArr.length - i12)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
            }
            this.f2333d = bArr;
            this.f2335f = i10;
            this.f2334e = i12;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void c(int i10, k0 k0Var, y0 y0Var) throws IOException {
            writeTag(i10, 2);
            writeUInt32NoTag(((androidx.datastore.preferences.protobuf.a) k0Var).b(y0Var));
            y0Var.writeTo(k0Var, this.f2329a);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final int spaceLeft() {
            return this.f2334e - this.f2335f;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void write(byte b10) throws IOException {
            try {
                byte[] bArr = this.f2333d;
                int i10 = this.f2335f;
                this.f2335f = i10 + 1;
                bArr[i10] = b10;
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2335f), Integer.valueOf(this.f2334e), 1), e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeBool(int i10, boolean z10) throws IOException {
            writeTag(i10, 0);
            write(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeByteArrayNoTag(byte[] bArr, int i10, int i11) throws IOException {
            writeUInt32NoTag(i11);
            write(bArr, i10, i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeBytes(int i10, ByteString byteString) throws IOException {
            writeTag(i10, 2);
            writeBytesNoTag(byteString);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.c(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeFixed32(int i10, int i11) throws IOException {
            writeTag(i10, 5);
            writeFixed32NoTag(i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeFixed32NoTag(int i10) throws IOException {
            try {
                byte[] bArr = this.f2333d;
                int i11 = this.f2335f;
                int i12 = i11 + 1;
                bArr[i11] = (byte) (i10 & 255);
                int i13 = i12 + 1;
                bArr[i12] = (byte) ((i10 >> 8) & 255);
                int i14 = i13 + 1;
                bArr[i13] = (byte) ((i10 >> 16) & 255);
                this.f2335f = i14 + 1;
                bArr[i14] = (byte) ((i10 >> 24) & 255);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2335f), Integer.valueOf(this.f2334e), 1), e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeFixed64(int i10, long j10) throws IOException {
            writeTag(i10, 1);
            writeFixed64NoTag(j10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeFixed64NoTag(long j10) throws IOException {
            try {
                byte[] bArr = this.f2333d;
                int i10 = this.f2335f;
                int i11 = i10 + 1;
                bArr[i10] = (byte) (((int) j10) & 255);
                int i12 = i11 + 1;
                bArr[i11] = (byte) (((int) (j10 >> 8)) & 255);
                int i13 = i12 + 1;
                bArr[i12] = (byte) (((int) (j10 >> 16)) & 255);
                int i14 = i13 + 1;
                bArr[i13] = (byte) (((int) (j10 >> 24)) & 255);
                int i15 = i14 + 1;
                bArr[i14] = (byte) (((int) (j10 >> 32)) & 255);
                int i16 = i15 + 1;
                bArr[i15] = (byte) (((int) (j10 >> 40)) & 255);
                int i17 = i16 + 1;
                bArr[i16] = (byte) (((int) (j10 >> 48)) & 255);
                this.f2335f = i17 + 1;
                bArr[i17] = (byte) (((int) (j10 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2335f), Integer.valueOf(this.f2334e), 1), e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeInt32(int i10, int i11) throws IOException {
            writeTag(i10, 0);
            writeInt32NoTag(i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeInt32NoTag(int i10) throws IOException {
            if (i10 >= 0) {
                writeUInt32NoTag(i10);
            } else {
                writeUInt64NoTag(i10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.g
        public final void writeLazy(byte[] bArr, int i10, int i11) throws IOException {
            write(bArr, i10, i11);
        }

        public final void writeMessage(int i10, k0 k0Var) throws IOException {
            writeTag(i10, 2);
            writeMessageNoTag(k0Var);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeMessageNoTag(k0 k0Var) throws IOException {
            writeUInt32NoTag(k0Var.getSerializedSize());
            k0Var.writeTo(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeMessageSetExtension(int i10, k0 k0Var) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i10);
            writeMessage(3, k0Var);
            writeTag(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeRawMessageSetExtension(int i10, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i10);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeString(int i10, String str) throws IOException {
            writeTag(i10, 2);
            writeStringNoTag(str);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeStringNoTag(String str) throws IOException {
            int i10 = this.f2335f;
            try {
                int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                byte[] bArr = this.f2333d;
                if (iComputeUInt32SizeNoTag2 == iComputeUInt32SizeNoTag) {
                    int i11 = i10 + iComputeUInt32SizeNoTag2;
                    this.f2335f = i11;
                    int iB = Utf8.f2376a.b(str, bArr, i11, spaceLeft());
                    this.f2335f = i10;
                    writeUInt32NoTag((iB - i10) - iComputeUInt32SizeNoTag2);
                    this.f2335f = iB;
                } else {
                    writeUInt32NoTag(Utf8.b(str));
                    this.f2335f = Utf8.f2376a.b(str, bArr, this.f2335f, spaceLeft());
                }
            } catch (Utf8.UnpairedSurrogateException e10) {
                this.f2335f = i10;
                b(str, e10);
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(e11);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeTag(int i10, int i11) throws IOException {
            writeUInt32NoTag((i10 << 3) | i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeUInt32(int i10, int i11) throws IOException {
            writeTag(i10, 0);
            writeUInt32NoTag(i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeUInt32NoTag(int i10) throws IOException {
            boolean z10 = CodedOutputStream.f2328c;
            byte[] bArr = this.f2333d;
            if (!z10 || d.a() || spaceLeft() < 5) {
                while ((i10 & (-128)) != 0) {
                    try {
                        int i11 = this.f2335f;
                        this.f2335f = i11 + 1;
                        bArr[i11] = (byte) ((i10 & 127) | 128);
                        i10 >>>= 7;
                    } catch (IndexOutOfBoundsException e10) {
                        throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2335f), Integer.valueOf(this.f2334e), 1), e10);
                    }
                }
                int i12 = this.f2335f;
                this.f2335f = i12 + 1;
                bArr[i12] = (byte) i10;
                return;
            }
            if ((i10 & (-128)) == 0) {
                int i13 = this.f2335f;
                this.f2335f = i13 + 1;
                j1.p(bArr, i13, (byte) i10);
                return;
            }
            int i14 = this.f2335f;
            this.f2335f = i14 + 1;
            j1.p(bArr, i14, (byte) (i10 | 128));
            int i15 = i10 >>> 7;
            if ((i15 & (-128)) == 0) {
                int i16 = this.f2335f;
                this.f2335f = i16 + 1;
                j1.p(bArr, i16, (byte) i15);
                return;
            }
            int i17 = this.f2335f;
            this.f2335f = i17 + 1;
            j1.p(bArr, i17, (byte) (i15 | 128));
            int i18 = i15 >>> 7;
            if ((i18 & (-128)) == 0) {
                int i19 = this.f2335f;
                this.f2335f = i19 + 1;
                j1.p(bArr, i19, (byte) i18);
                return;
            }
            int i20 = this.f2335f;
            this.f2335f = i20 + 1;
            j1.p(bArr, i20, (byte) (i18 | 128));
            int i21 = i18 >>> 7;
            if ((i21 & (-128)) == 0) {
                int i22 = this.f2335f;
                this.f2335f = i22 + 1;
                j1.p(bArr, i22, (byte) i21);
            } else {
                int i23 = this.f2335f;
                this.f2335f = i23 + 1;
                j1.p(bArr, i23, (byte) (i21 | 128));
                int i24 = this.f2335f;
                this.f2335f = i24 + 1;
                j1.p(bArr, i24, (byte) (i21 >>> 7));
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeUInt64(int i10, long j10) throws IOException {
            writeTag(i10, 0);
            writeUInt64NoTag(j10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void writeUInt64NoTag(long j10) throws IOException {
            boolean z10 = CodedOutputStream.f2328c;
            byte[] bArr = this.f2333d;
            if (z10 && spaceLeft() >= 10) {
                while ((j10 & (-128)) != 0) {
                    int i10 = this.f2335f;
                    this.f2335f = i10 + 1;
                    j1.p(bArr, i10, (byte) ((((int) j10) & 127) | 128));
                    j10 >>>= 7;
                }
                int i11 = this.f2335f;
                this.f2335f = i11 + 1;
                j1.p(bArr, i11, (byte) j10);
                return;
            }
            while ((j10 & (-128)) != 0) {
                try {
                    int i12 = this.f2335f;
                    this.f2335f = i12 + 1;
                    bArr[i12] = (byte) ((((int) j10) & 127) | 128);
                    j10 >>>= 7;
                } catch (IndexOutOfBoundsException e10) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2335f), Integer.valueOf(this.f2334e), 1), e10);
                }
            }
            int i13 = this.f2335f;
            this.f2335f = i13 + 1;
            bArr[i13] = (byte) j10;
        }

        public final void write(byte[] bArr, int i10, int i11) throws IOException {
            try {
                System.arraycopy(bArr, i10, this.f2333d, this.f2335f, i11);
                this.f2335f += i11;
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2335f), Integer.valueOf(this.f2334e), Integer.valueOf(i11)), e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void flush() {
        }
    }

    public static final class c extends a {

        /* renamed from: g, reason: collision with root package name */
        public final OutputStream f2336g;

        public c(OutputStream outputStream, int i10) {
            super(i10);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.f2336g = outputStream;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void c(int i10, k0 k0Var, y0 y0Var) throws IOException {
            writeTag(i10, 2);
            writeUInt32NoTag(((androidx.datastore.preferences.protobuf.a) k0Var).b(y0Var));
            y0Var.writeTo(k0Var, this.f2329a);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void flush() throws IOException {
            if (this.f2332f > 0) {
                i();
            }
        }

        public final void i() throws IOException {
            this.f2336g.write(this.f2330d, 0, this.f2332f);
            this.f2332f = 0;
        }

        public final void j(int i10) throws IOException {
            if (this.f2331e - this.f2332f < i10) {
                i();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void write(byte b10) throws IOException {
            if (this.f2332f == this.f2331e) {
                i();
            }
            int i10 = this.f2332f;
            this.f2332f = i10 + 1;
            this.f2330d[i10] = b10;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeBool(int i10, boolean z10) throws IOException {
            j(11);
            f(i10, 0);
            byte b10 = z10 ? (byte) 1 : (byte) 0;
            int i11 = this.f2332f;
            this.f2332f = i11 + 1;
            this.f2330d[i11] = b10;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i10, int i11) throws IOException {
            writeUInt32NoTag(i11);
            write(bArr, i10, i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeBytes(int i10, ByteString byteString) throws IOException {
            writeTag(i10, 2);
            writeBytesNoTag(byteString);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.c(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed32(int i10, int i11) throws IOException {
            j(14);
            f(i10, 5);
            d(i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i10) throws IOException {
            j(4);
            d(i10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed64(int i10, long j10) throws IOException {
            j(18);
            f(i10, 1);
            e(j10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j10) throws IOException {
            j(8);
            e(j10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeInt32(int i10, int i11) throws IOException {
            j(20);
            f(i10, 0);
            if (i11 >= 0) {
                g(i11);
            } else {
                h(i11);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i10) throws IOException {
            if (i10 >= 0) {
                writeUInt32NoTag(i10);
            } else {
                writeUInt64NoTag(i10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.g
        public void writeLazy(byte[] bArr, int i10, int i11) throws IOException {
            write(bArr, i10, i11);
        }

        public void writeMessage(int i10, k0 k0Var) throws IOException {
            writeTag(i10, 2);
            writeMessageNoTag(k0Var);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessageNoTag(k0 k0Var) throws IOException {
            writeUInt32NoTag(k0Var.getSerializedSize());
            k0Var.writeTo(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i10, k0 k0Var) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i10);
            writeMessage(3, k0Var);
            writeTag(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i10, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i10);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeString(int i10, String str) throws IOException {
            writeTag(i10, 2);
            writeStringNoTag(str);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            try {
                int length = str.length() * 3;
                int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
                int i10 = iComputeUInt32SizeNoTag + length;
                int i11 = this.f2331e;
                if (i10 > i11) {
                    byte[] bArr = new byte[length];
                    int iB = Utf8.f2376a.b(str, bArr, 0, length);
                    writeUInt32NoTag(iB);
                    writeLazy(bArr, 0, iB);
                    return;
                }
                if (i10 > i11 - this.f2332f) {
                    i();
                }
                int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                int i12 = this.f2332f;
                byte[] bArr2 = this.f2330d;
                try {
                    try {
                        if (iComputeUInt32SizeNoTag2 == iComputeUInt32SizeNoTag) {
                            int i13 = i12 + iComputeUInt32SizeNoTag2;
                            this.f2332f = i13;
                            int iB2 = Utf8.f2376a.b(str, bArr2, i13, i11 - i13);
                            this.f2332f = i12;
                            g((iB2 - i12) - iComputeUInt32SizeNoTag2);
                            this.f2332f = iB2;
                        } else {
                            int iB3 = Utf8.b(str);
                            g(iB3);
                            this.f2332f = Utf8.f2376a.b(str, bArr2, this.f2332f, iB3);
                        }
                    } catch (ArrayIndexOutOfBoundsException e10) {
                        throw new OutOfSpaceException(e10);
                    }
                } catch (Utf8.UnpairedSurrogateException e11) {
                    this.f2332f = i12;
                    throw e11;
                }
            } catch (Utf8.UnpairedSurrogateException e12) {
                b(str, e12);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeTag(int i10, int i11) throws IOException {
            writeUInt32NoTag((i10 << 3) | i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt32(int i10, int i11) throws IOException {
            j(20);
            f(i10, 0);
            g(i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i10) throws IOException {
            j(5);
            g(i10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt64(int i10, long j10) throws IOException {
            j(20);
            f(i10, 0);
            h(j10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j10) throws IOException {
            j(10);
            h(j10);
        }

        public void write(byte[] bArr, int i10, int i11) throws IOException {
            int i12 = this.f2332f;
            int i13 = this.f2331e;
            int i14 = i13 - i12;
            byte[] bArr2 = this.f2330d;
            if (i14 >= i11) {
                System.arraycopy(bArr, i10, bArr2, i12, i11);
                this.f2332f += i11;
                return;
            }
            System.arraycopy(bArr, i10, bArr2, i12, i14);
            int i15 = i10 + i14;
            int i16 = i11 - i14;
            this.f2332f = i13;
            i();
            if (i16 <= i13) {
                System.arraycopy(bArr, i15, bArr2, 0, i16);
                this.f2332f = i16;
            } else {
                this.f2336g.write(bArr, i15, i16);
            }
        }
    }

    public static CodedOutputStream newInstance(byte[] bArr, int i10, int i11) {
        return new b(bArr, i10, i11);
    }

    public static class OutOfSpaceException extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        public OutOfSpaceException(String str, IndexOutOfBoundsException indexOutOfBoundsException) {
            super(ac.c.j("CodedOutputStream was writing to a flat byte array and ran out of space.: ", str), indexOutOfBoundsException);
        }

        public OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        public OutOfSpaceException(IndexOutOfBoundsException indexOutOfBoundsException) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", indexOutOfBoundsException);
        }
    }
}
