package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class ByteString implements Iterable<Byte>, Serializable {

    /* renamed from: m, reason: collision with root package name */
    public static final ByteString f2316m = new LiteralByteString(w.f2546b);

    /* renamed from: n, reason: collision with root package name */
    public static final d f2317n;

    /* renamed from: b, reason: collision with root package name */
    public int f2318b = 0;

    public static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;

        /* renamed from: p, reason: collision with root package name */
        public final int f2319p;

        /* renamed from: q, reason: collision with root package name */
        public final int f2320q;

        public BoundedByteString(byte[] bArr, int i10, int i11) {
            super(bArr);
            ByteString.a(i10, i10 + i11, bArr.length);
            this.f2319p = i10;
            this.f2320q = i11;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        public final byte b(int i10) {
            return this.f2321o[this.f2319p + i10];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        public byte byteAt(int i10) {
            int size = size();
            if (((size - (i10 + 1)) | i10) >= 0) {
                return this.f2321o[this.f2319p + i10];
            }
            if (i10 < 0) {
                throw new ArrayIndexOutOfBoundsException(ac.c.f("Index < 0: ", i10));
            }
            throw new ArrayIndexOutOfBoundsException(ac.c.g("Index > length: ", i10, ", ", size));
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        public void copyToInternal(byte[] bArr, int i10, int i11, int i12) {
            System.arraycopy(this.f2321o, getOffsetIntoBytes() + i10, bArr, i11, i12);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString
        public int getOffsetIntoBytes() {
            return this.f2319p;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        public int size() {
            return this.f2320q;
        }
    }

    public static abstract class LeafByteString extends ByteString {
        @Override // androidx.datastore.preferences.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator2();
        }
    }

    public static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;

        /* renamed from: o, reason: collision with root package name */
        public final byte[] f2321o;

        public LiteralByteString(byte[] bArr) {
            bArr.getClass();
            this.f2321o = bArr;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public byte b(int i10) {
            return this.f2321o[i10];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public byte byteAt(int i10) {
            return this.f2321o[i10];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final void c(androidx.datastore.preferences.protobuf.g gVar) throws IOException {
            gVar.writeLazy(this.f2321o, getOffsetIntoBytes(), size());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public void copyToInternal(byte[] bArr, int i10, int i11, int i12) {
            System.arraycopy(this.f2321o, i10, bArr, i11, i12);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof LiteralByteString)) {
                return obj.equals(this);
            }
            LiteralByteString literalByteString = (LiteralByteString) obj;
            int iPeekCachedHashCode = peekCachedHashCode();
            int iPeekCachedHashCode2 = literalByteString.peekCachedHashCode();
            if (iPeekCachedHashCode != 0 && iPeekCachedHashCode2 != 0 && iPeekCachedHashCode != iPeekCachedHashCode2) {
                return false;
            }
            int size = size();
            if (size > literalByteString.size()) {
                throw new IllegalArgumentException("Length too large: " + size + size());
            }
            if (0 + size > literalByteString.size()) {
                StringBuilder sbS = ac.c.s("Ran off end of other: 0, ", size, ", ");
                sbS.append(literalByteString.size());
                throw new IllegalArgumentException(sbS.toString());
            }
            int offsetIntoBytes = getOffsetIntoBytes() + size;
            int offsetIntoBytes2 = getOffsetIntoBytes();
            int offsetIntoBytes3 = literalByteString.getOffsetIntoBytes() + 0;
            while (offsetIntoBytes2 < offsetIntoBytes) {
                if (this.f2321o[offsetIntoBytes2] != literalByteString.f2321o[offsetIntoBytes3]) {
                    return false;
                }
                offsetIntoBytes2++;
                offsetIntoBytes3++;
            }
            return true;
        }

        public int getOffsetIntoBytes() {
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final boolean isValidUtf8() {
            int offsetIntoBytes = getOffsetIntoBytes();
            return Utf8.isValidUtf8(this.f2321o, offsetIntoBytes, size() + offsetIntoBytes);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final int partialHash(int i10, int i11, int i12) {
            int offsetIntoBytes = getOffsetIntoBytes() + i11;
            Charset charset = w.f2545a;
            for (int i13 = offsetIntoBytes; i13 < offsetIntoBytes + i12; i13++) {
                i10 = (i10 * 31) + this.f2321o[i13];
            }
            return i10;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public int size() {
            return this.f2321o.length;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final String toStringInternal(Charset charset) {
            return new String(this.f2321o, getOffsetIntoBytes(), size(), charset);
        }
    }

    public class a extends b {

        /* renamed from: b, reason: collision with root package name */
        public int f2322b = 0;

        /* renamed from: m, reason: collision with root package name */
        public final int f2323m;

        public a() {
            this.f2323m = ByteString.this.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2322b < this.f2323m;
        }

        public byte nextByte() {
            int i10 = this.f2322b;
            if (i10 >= this.f2323m) {
                throw new NoSuchElementException();
            }
            this.f2322b = i10 + 1;
            return ByteString.this.b(i10);
        }
    }

    public static abstract class b implements e {
        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public final Byte next() {
            return Byte.valueOf(((a) this).nextByte());
        }
    }

    public static final class c implements d {
        @Override // androidx.datastore.preferences.protobuf.ByteString.d
        public byte[] copyFrom(byte[] bArr, int i10, int i11) {
            return Arrays.copyOfRange(bArr, i10, i11 + i10);
        }
    }

    public interface d {
        byte[] copyFrom(byte[] bArr, int i10, int i11);
    }

    public interface e extends Iterator<Byte> {
    }

    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public final CodedOutputStream f2325a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f2326b;

        public f(int i10) {
            byte[] bArr = new byte[i10];
            this.f2326b = bArr;
            this.f2325a = CodedOutputStream.newInstance(bArr);
        }

        public ByteString build() {
            this.f2325a.checkNoSpaceLeft();
            return new LiteralByteString(this.f2326b);
        }

        public CodedOutputStream getCodedOutput() {
            return this.f2325a;
        }
    }

    public static final class g implements d {
        @Override // androidx.datastore.preferences.protobuf.ByteString.d
        public byte[] copyFrom(byte[] bArr, int i10, int i11) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, i10, bArr2, 0, i11);
            return bArr2;
        }
    }

    static {
        f2317n = androidx.datastore.preferences.protobuf.d.a() ? new g() : new c();
    }

    public static int a(int i10, int i11, int i12) {
        int i13 = i11 - i10;
        if ((i10 | i11 | i13 | (i12 - i11)) >= 0) {
            return i13;
        }
        if (i10 < 0) {
            throw new IndexOutOfBoundsException(o1.a.d("Beginning index: ", i10, " < 0"));
        }
        if (i11 < i10) {
            throw new IndexOutOfBoundsException(ac.c.g("Beginning index larger than ending index: ", i10, ", ", i11));
        }
        throw new IndexOutOfBoundsException(ac.c.g("End index: ", i11, " >= ", i12));
    }

    public static ByteString copyFrom(byte[] bArr, int i10, int i11) {
        a(i10, i10 + i11, bArr.length);
        return new LiteralByteString(f2317n.copyFrom(bArr, i10, i11));
    }

    public static ByteString copyFromUtf8(String str) {
        return new LiteralByteString(str.getBytes(w.f2545a));
    }

    public abstract byte b(int i10);

    public abstract byte byteAt(int i10);

    public abstract void c(androidx.datastore.preferences.protobuf.g gVar) throws IOException;

    public abstract void copyToInternal(byte[] bArr, int i10, int i11, int i12);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iPartialHash = this.f2318b;
        if (iPartialHash == 0) {
            int size = size();
            iPartialHash = partialHash(size, 0, size);
            if (iPartialHash == 0) {
                iPartialHash = 1;
            }
            this.f2318b = iPartialHash;
        }
        return iPartialHash;
    }

    public abstract boolean isValidUtf8();

    public abstract int partialHash(int i10, int i11, int i12);

    public final int peekCachedHashCode() {
        return this.f2318b;
    }

    public abstract int size();

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return w.f2546b;
        }
        byte[] bArr = new byte[size];
        copyToInternal(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString(Charset charset) {
        return size() == 0 ? "" : toStringInternal(charset);
    }

    public abstract String toStringInternal(Charset charset);

    public final String toStringUtf8() {
        return toString(w.f2545a);
    }

    @Override // java.lang.Iterable
    /* renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<Byte> iterator2() {
        return new a();
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }
}
