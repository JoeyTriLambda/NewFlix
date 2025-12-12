package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.e0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* compiled from: BinaryReader.java */
/* loaded from: classes.dex */
public abstract class e implements x0 {

    /* compiled from: BinaryReader.java */
    public static final class a extends e {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f2434a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f2435b;

        /* renamed from: c, reason: collision with root package name */
        public int f2436c;

        /* renamed from: d, reason: collision with root package name */
        public int f2437d;

        /* renamed from: e, reason: collision with root package name */
        public int f2438e;

        /* renamed from: f, reason: collision with root package name */
        public int f2439f;

        public a(ByteBuffer byteBuffer, boolean z10) {
            this.f2434a = z10;
            this.f2435b = byteBuffer.array();
            this.f2436c = byteBuffer.position() + byteBuffer.arrayOffset();
            this.f2437d = byteBuffer.limit() + byteBuffer.arrayOffset();
        }

        public final boolean a() {
            return this.f2436c == this.f2437d;
        }

        public final Object b(WireFormat.FieldType fieldType, Class<?> cls, n nVar) throws IOException {
            switch (fieldType.ordinal()) {
                case 0:
                    return Double.valueOf(readDouble());
                case 1:
                    return Float.valueOf(readFloat());
                case 2:
                    return Long.valueOf(readInt64());
                case 3:
                    return Long.valueOf(readUInt64());
                case 4:
                    return Integer.valueOf(readInt32());
                case 5:
                    return Long.valueOf(readFixed64());
                case 6:
                    return Integer.valueOf(readFixed32());
                case 7:
                    return Boolean.valueOf(readBool());
                case 8:
                    return readStringRequireUtf8();
                case 9:
                default:
                    throw new RuntimeException("unsupported field type.");
                case 10:
                    return readMessage(cls, nVar);
                case 11:
                    return readBytes();
                case 12:
                    return Integer.valueOf(readUInt32());
                case 13:
                    return Integer.valueOf(readEnum());
                case 14:
                    return Integer.valueOf(readSFixed32());
                case 15:
                    return Long.valueOf(readSFixed64());
                case 16:
                    return Integer.valueOf(readSInt32());
                case 17:
                    return Long.valueOf(readSInt64());
            }
        }

        public final <T> T c(y0<T> y0Var, n nVar) throws IOException {
            int i10 = this.f2439f;
            this.f2439f = (WireFormat.getTagFieldNumber(this.f2438e) << 3) | 4;
            try {
                T tNewInstance = y0Var.newInstance();
                y0Var.mergeFrom(tNewInstance, this, nVar);
                y0Var.makeImmutable(tNewInstance);
                if (this.f2438e == this.f2439f) {
                    return tNewInstance;
                }
                throw InvalidProtocolBufferException.e();
            } finally {
                this.f2439f = i10;
            }
        }

        public final int d() {
            int i10 = this.f2436c;
            this.f2436c = i10 + 4;
            byte[] bArr = this.f2435b;
            return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
        }

        public final long e() {
            this.f2436c = this.f2436c + 8;
            byte[] bArr = this.f2435b;
            return ((bArr[r0 + 7] & 255) << 56) | (bArr[r0] & 255) | ((bArr[r0 + 1] & 255) << 8) | ((bArr[r0 + 2] & 255) << 16) | ((bArr[r0 + 3] & 255) << 24) | ((bArr[r0 + 4] & 255) << 32) | ((bArr[r0 + 5] & 255) << 40) | ((bArr[r0 + 6] & 255) << 48);
        }

        public final <T> T f(y0<T> y0Var, n nVar) throws IOException {
            int iG = g();
            i(iG);
            int i10 = this.f2437d;
            int i11 = this.f2436c + iG;
            this.f2437d = i11;
            try {
                T tNewInstance = y0Var.newInstance();
                y0Var.mergeFrom(tNewInstance, this, nVar);
                y0Var.makeImmutable(tNewInstance);
                if (this.f2436c == i11) {
                    return tNewInstance;
                }
                throw InvalidProtocolBufferException.e();
            } finally {
                this.f2437d = i10;
            }
        }

        public final int g() throws IOException {
            int i10;
            int i11 = this.f2436c;
            int i12 = this.f2437d;
            if (i12 == i11) {
                throw InvalidProtocolBufferException.f();
            }
            int i13 = i11 + 1;
            byte[] bArr = this.f2435b;
            byte b10 = bArr[i11];
            if (b10 >= 0) {
                this.f2436c = i13;
                return b10;
            }
            if (i12 - i13 < 9) {
                return (int) h();
            }
            int i14 = i13 + 1;
            int i15 = b10 ^ (bArr[i13] << 7);
            if (i15 < 0) {
                i10 = i15 ^ (-128);
            } else {
                int i16 = i14 + 1;
                int i17 = i15 ^ (bArr[i14] << 14);
                if (i17 >= 0) {
                    i10 = i17 ^ 16256;
                } else {
                    i14 = i16 + 1;
                    int i18 = i17 ^ (bArr[i16] << 21);
                    if (i18 < 0) {
                        i10 = i18 ^ (-2080896);
                    } else {
                        i16 = i14 + 1;
                        byte b11 = bArr[i14];
                        i10 = (i18 ^ (b11 << 28)) ^ 266354560;
                        if (b11 < 0) {
                            i14 = i16 + 1;
                            if (bArr[i16] < 0) {
                                i16 = i14 + 1;
                                if (bArr[i14] < 0) {
                                    i14 = i16 + 1;
                                    if (bArr[i16] < 0) {
                                        i16 = i14 + 1;
                                        if (bArr[i14] < 0) {
                                            i14 = i16 + 1;
                                            if (bArr[i16] < 0) {
                                                throw InvalidProtocolBufferException.c();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                i14 = i16;
            }
            this.f2436c = i14;
            return i10;
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public int getFieldNumber() throws IOException {
            if (a()) {
                return Integer.MAX_VALUE;
            }
            int iG = g();
            this.f2438e = iG;
            if (iG == this.f2439f) {
                return Integer.MAX_VALUE;
            }
            return WireFormat.getTagFieldNumber(iG);
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public int getTag() {
            return this.f2438e;
        }

        public final long h() throws IOException {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                int i11 = this.f2436c;
                if (i11 == this.f2437d) {
                    throw InvalidProtocolBufferException.f();
                }
                this.f2436c = i11 + 1;
                j10 |= (r3 & 127) << i10;
                if ((this.f2435b[i11] & 128) == 0) {
                    return j10;
                }
            }
            throw InvalidProtocolBufferException.c();
        }

        public final void i(int i10) throws IOException {
            if (i10 < 0 || i10 > this.f2437d - this.f2436c) {
                throw InvalidProtocolBufferException.f();
            }
        }

        public final void j(int i10) throws IOException {
            if (this.f2436c != i10) {
                throw InvalidProtocolBufferException.f();
            }
        }

        public final void k(int i10) throws IOException {
            if (WireFormat.getTagWireType(this.f2438e) != i10) {
                throw InvalidProtocolBufferException.b();
            }
        }

        public final void l(int i10) throws IOException {
            i(i10);
            if ((i10 & 3) != 0) {
                throw InvalidProtocolBufferException.e();
            }
        }

        public final void m(int i10) throws IOException {
            i(i10);
            if ((i10 & 7) != 0) {
                throw InvalidProtocolBufferException.e();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public boolean readBool() throws IOException {
            k(0);
            return g() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public void readBoolList(List<Boolean> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof f)) {
                int tagWireType = WireFormat.getTagWireType(this.f2438e);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.b();
                    }
                    int iG = this.f2436c + g();
                    while (this.f2436c < iG) {
                        list.add(Boolean.valueOf(g() != 0));
                    }
                    j(iG);
                    return;
                }
                do {
                    list.add(Boolean.valueOf(readBool()));
                    if (a()) {
                        return;
                    } else {
                        i10 = this.f2436c;
                    }
                } while (g() == this.f2438e);
                this.f2436c = i10;
                return;
            }
            f fVar = (f) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f2438e);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.b();
                }
                int iG2 = this.f2436c + g();
                while (this.f2436c < iG2) {
                    fVar.addBoolean(g() != 0);
                }
                j(iG2);
                return;
            }
            do {
                fVar.addBoolean(readBool());
                if (a()) {
                    return;
                } else {
                    i11 = this.f2436c;
                }
            } while (g() == this.f2438e);
            this.f2436c = i11;
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public ByteString readBytes() throws IOException {
            ByteString byteStringCopyFrom;
            k(2);
            int iG = g();
            if (iG == 0) {
                return ByteString.f2316m;
            }
            i(iG);
            boolean z10 = this.f2434a;
            byte[] bArr = this.f2435b;
            if (z10) {
                int i10 = this.f2436c;
                ByteString byteString = ByteString.f2316m;
                byteStringCopyFrom = new ByteString.BoundedByteString(bArr, i10, iG);
            } else {
                byteStringCopyFrom = ByteString.copyFrom(bArr, this.f2436c, iG);
            }
            this.f2436c += iG;
            return byteStringCopyFrom;
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public void readBytesList(List<ByteString> list) throws IOException {
            int i10;
            if (WireFormat.getTagWireType(this.f2438e) != 2) {
                throw InvalidProtocolBufferException.b();
            }
            do {
                list.add(readBytes());
                if (a()) {
                    return;
                } else {
                    i10 = this.f2436c;
                }
            } while (g() == this.f2438e);
            this.f2436c = i10;
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public double readDouble() throws IOException {
            k(1);
            i(8);
            return Double.longBitsToDouble(e());
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public void readDoubleList(List<Double> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof k)) {
                int tagWireType = WireFormat.getTagWireType(this.f2438e);
                if (tagWireType == 1) {
                    do {
                        list.add(Double.valueOf(readDouble()));
                        if (a()) {
                            return;
                        } else {
                            i10 = this.f2436c;
                        }
                    } while (g() == this.f2438e);
                    this.f2436c = i10;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.b();
                }
                int iG = g();
                m(iG);
                int i12 = this.f2436c + iG;
                while (this.f2436c < i12) {
                    list.add(Double.valueOf(Double.longBitsToDouble(e())));
                }
                return;
            }
            k kVar = (k) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f2438e);
            if (tagWireType2 == 1) {
                do {
                    kVar.addDouble(readDouble());
                    if (a()) {
                        return;
                    } else {
                        i11 = this.f2436c;
                    }
                } while (g() == this.f2438e);
                this.f2436c = i11;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int iG2 = g();
            m(iG2);
            int i13 = this.f2436c + iG2;
            while (this.f2436c < i13) {
                kVar.addDouble(Double.longBitsToDouble(e()));
            }
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public int readEnum() throws IOException {
            k(0);
            return g();
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public void readEnumList(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof v)) {
                int tagWireType = WireFormat.getTagWireType(this.f2438e);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.b();
                    }
                    int iG = this.f2436c + g();
                    while (this.f2436c < iG) {
                        list.add(Integer.valueOf(g()));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(readEnum()));
                    if (a()) {
                        return;
                    } else {
                        i10 = this.f2436c;
                    }
                } while (g() == this.f2438e);
                this.f2436c = i10;
                return;
            }
            v vVar = (v) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f2438e);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.b();
                }
                int iG2 = this.f2436c + g();
                while (this.f2436c < iG2) {
                    vVar.addInt(g());
                }
                return;
            }
            do {
                vVar.addInt(readEnum());
                if (a()) {
                    return;
                } else {
                    i11 = this.f2436c;
                }
            } while (g() == this.f2438e);
            this.f2436c = i11;
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public int readFixed32() throws IOException {
            k(5);
            i(4);
            return d();
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public void readFixed32List(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof v)) {
                int tagWireType = WireFormat.getTagWireType(this.f2438e);
                if (tagWireType == 2) {
                    int iG = g();
                    l(iG);
                    int i12 = this.f2436c + iG;
                    while (this.f2436c < i12) {
                        list.add(Integer.valueOf(d()));
                    }
                    return;
                }
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.b();
                }
                do {
                    list.add(Integer.valueOf(readFixed32()));
                    if (a()) {
                        return;
                    } else {
                        i10 = this.f2436c;
                    }
                } while (g() == this.f2438e);
                this.f2436c = i10;
                return;
            }
            v vVar = (v) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f2438e);
            if (tagWireType2 == 2) {
                int iG2 = g();
                l(iG2);
                int i13 = this.f2436c + iG2;
                while (this.f2436c < i13) {
                    vVar.addInt(d());
                }
                return;
            }
            if (tagWireType2 != 5) {
                throw InvalidProtocolBufferException.b();
            }
            do {
                vVar.addInt(readFixed32());
                if (a()) {
                    return;
                } else {
                    i11 = this.f2436c;
                }
            } while (g() == this.f2438e);
            this.f2436c = i11;
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public long readFixed64() throws IOException {
            k(1);
            i(8);
            return e();
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public void readFixed64List(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof c0)) {
                int tagWireType = WireFormat.getTagWireType(this.f2438e);
                if (tagWireType == 1) {
                    do {
                        list.add(Long.valueOf(readFixed64()));
                        if (a()) {
                            return;
                        } else {
                            i10 = this.f2436c;
                        }
                    } while (g() == this.f2438e);
                    this.f2436c = i10;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.b();
                }
                int iG = g();
                m(iG);
                int i12 = this.f2436c + iG;
                while (this.f2436c < i12) {
                    list.add(Long.valueOf(e()));
                }
                return;
            }
            c0 c0Var = (c0) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f2438e);
            if (tagWireType2 == 1) {
                do {
                    c0Var.addLong(readFixed64());
                    if (a()) {
                        return;
                    } else {
                        i11 = this.f2436c;
                    }
                } while (g() == this.f2438e);
                this.f2436c = i11;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int iG2 = g();
            m(iG2);
            int i13 = this.f2436c + iG2;
            while (this.f2436c < i13) {
                c0Var.addLong(e());
            }
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public float readFloat() throws IOException {
            k(5);
            i(4);
            return Float.intBitsToFloat(d());
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public void readFloatList(List<Float> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof t)) {
                int tagWireType = WireFormat.getTagWireType(this.f2438e);
                if (tagWireType == 2) {
                    int iG = g();
                    l(iG);
                    int i12 = this.f2436c + iG;
                    while (this.f2436c < i12) {
                        list.add(Float.valueOf(Float.intBitsToFloat(d())));
                    }
                    return;
                }
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.b();
                }
                do {
                    list.add(Float.valueOf(readFloat()));
                    if (a()) {
                        return;
                    } else {
                        i10 = this.f2436c;
                    }
                } while (g() == this.f2438e);
                this.f2436c = i10;
                return;
            }
            t tVar = (t) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f2438e);
            if (tagWireType2 == 2) {
                int iG2 = g();
                l(iG2);
                int i13 = this.f2436c + iG2;
                while (this.f2436c < i13) {
                    tVar.addFloat(Float.intBitsToFloat(d()));
                }
                return;
            }
            if (tagWireType2 != 5) {
                throw InvalidProtocolBufferException.b();
            }
            do {
                tVar.addFloat(readFloat());
                if (a()) {
                    return;
                } else {
                    i11 = this.f2436c;
                }
            } while (g() == this.f2438e);
            this.f2436c = i11;
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public <T> T readGroupBySchemaWithCheck(y0<T> y0Var, n nVar) throws IOException {
            k(3);
            return (T) c(y0Var, nVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.x0
        public <T> void readGroupList(List<T> list, y0<T> y0Var, n nVar) throws IOException {
            int i10;
            if (WireFormat.getTagWireType(this.f2438e) != 3) {
                throw InvalidProtocolBufferException.b();
            }
            int i11 = this.f2438e;
            do {
                list.add(c(y0Var, nVar));
                if (a()) {
                    return;
                } else {
                    i10 = this.f2436c;
                }
            } while (g() == i11);
            this.f2436c = i10;
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public int readInt32() throws IOException {
            k(0);
            return g();
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public void readInt32List(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof v)) {
                int tagWireType = WireFormat.getTagWireType(this.f2438e);
                if (tagWireType == 0) {
                    do {
                        list.add(Integer.valueOf(readInt32()));
                        if (a()) {
                            return;
                        } else {
                            i10 = this.f2436c;
                        }
                    } while (g() == this.f2438e);
                    this.f2436c = i10;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.b();
                }
                int iG = this.f2436c + g();
                while (this.f2436c < iG) {
                    list.add(Integer.valueOf(g()));
                }
                j(iG);
                return;
            }
            v vVar = (v) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f2438e);
            if (tagWireType2 == 0) {
                do {
                    vVar.addInt(readInt32());
                    if (a()) {
                        return;
                    } else {
                        i11 = this.f2436c;
                    }
                } while (g() == this.f2438e);
                this.f2436c = i11;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int iG2 = this.f2436c + g();
            while (this.f2436c < iG2) {
                vVar.addInt(g());
            }
            j(iG2);
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public long readInt64() throws IOException {
            k(0);
            return readVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public void readInt64List(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof c0)) {
                int tagWireType = WireFormat.getTagWireType(this.f2438e);
                if (tagWireType == 0) {
                    do {
                        list.add(Long.valueOf(readInt64()));
                        if (a()) {
                            return;
                        } else {
                            i10 = this.f2436c;
                        }
                    } while (g() == this.f2438e);
                    this.f2436c = i10;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.b();
                }
                int iG = this.f2436c + g();
                while (this.f2436c < iG) {
                    list.add(Long.valueOf(readVarint64()));
                }
                j(iG);
                return;
            }
            c0 c0Var = (c0) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f2438e);
            if (tagWireType2 == 0) {
                do {
                    c0Var.addLong(readInt64());
                    if (a()) {
                        return;
                    } else {
                        i11 = this.f2436c;
                    }
                } while (g() == this.f2438e);
                this.f2436c = i11;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int iG2 = this.f2436c + g();
            while (this.f2436c < iG2) {
                c0Var.addLong(readVarint64());
            }
            j(iG2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.x0
        public <K, V> void readMap(Map<K, V> map, e0.a<K, V> aVar, n nVar) throws IOException {
            k(2);
            int iG = g();
            i(iG);
            int i10 = this.f2437d;
            this.f2437d = this.f2436c + iG;
            try {
                Object objB = aVar.f2444b;
                V v10 = aVar.f2446d;
                Object objB2 = v10;
                while (true) {
                    int fieldNumber = getFieldNumber();
                    if (fieldNumber == Integer.MAX_VALUE) {
                        map.put(objB, objB2);
                        return;
                    }
                    if (fieldNumber == 1) {
                        objB = b(aVar.f2443a, null, null);
                    } else if (fieldNumber != 2) {
                        try {
                            if (!skipField()) {
                                throw new InvalidProtocolBufferException("Unable to parse map entry.");
                            }
                        } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                            if (!skipField()) {
                                throw new InvalidProtocolBufferException("Unable to parse map entry.");
                            }
                        }
                    } else {
                        objB2 = b(aVar.f2445c, v10.getClass(), nVar);
                    }
                }
            } finally {
                this.f2437d = i10;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public <T> T readMessage(Class<T> cls, n nVar) throws IOException {
            k(2);
            return (T) f(u0.getInstance().schemaFor((Class) cls), nVar);
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public <T> T readMessageBySchemaWithCheck(y0<T> y0Var, n nVar) throws IOException {
            k(2);
            return (T) f(y0Var, nVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.x0
        public <T> void readMessageList(List<T> list, y0<T> y0Var, n nVar) throws IOException {
            int i10;
            if (WireFormat.getTagWireType(this.f2438e) != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int i11 = this.f2438e;
            do {
                list.add(f(y0Var, nVar));
                if (a()) {
                    return;
                } else {
                    i10 = this.f2436c;
                }
            } while (g() == i11);
            this.f2436c = i10;
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public int readSFixed32() throws IOException {
            k(5);
            i(4);
            return d();
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public void readSFixed32List(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof v)) {
                int tagWireType = WireFormat.getTagWireType(this.f2438e);
                if (tagWireType == 2) {
                    int iG = g();
                    l(iG);
                    int i12 = this.f2436c + iG;
                    while (this.f2436c < i12) {
                        list.add(Integer.valueOf(d()));
                    }
                    return;
                }
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.b();
                }
                do {
                    list.add(Integer.valueOf(readSFixed32()));
                    if (a()) {
                        return;
                    } else {
                        i10 = this.f2436c;
                    }
                } while (g() == this.f2438e);
                this.f2436c = i10;
                return;
            }
            v vVar = (v) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f2438e);
            if (tagWireType2 == 2) {
                int iG2 = g();
                l(iG2);
                int i13 = this.f2436c + iG2;
                while (this.f2436c < i13) {
                    vVar.addInt(d());
                }
                return;
            }
            if (tagWireType2 != 5) {
                throw InvalidProtocolBufferException.b();
            }
            do {
                vVar.addInt(readSFixed32());
                if (a()) {
                    return;
                } else {
                    i11 = this.f2436c;
                }
            } while (g() == this.f2438e);
            this.f2436c = i11;
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public long readSFixed64() throws IOException {
            k(1);
            i(8);
            return e();
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public void readSFixed64List(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof c0)) {
                int tagWireType = WireFormat.getTagWireType(this.f2438e);
                if (tagWireType == 1) {
                    do {
                        list.add(Long.valueOf(readSFixed64()));
                        if (a()) {
                            return;
                        } else {
                            i10 = this.f2436c;
                        }
                    } while (g() == this.f2438e);
                    this.f2436c = i10;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.b();
                }
                int iG = g();
                m(iG);
                int i12 = this.f2436c + iG;
                while (this.f2436c < i12) {
                    list.add(Long.valueOf(e()));
                }
                return;
            }
            c0 c0Var = (c0) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f2438e);
            if (tagWireType2 == 1) {
                do {
                    c0Var.addLong(readSFixed64());
                    if (a()) {
                        return;
                    } else {
                        i11 = this.f2436c;
                    }
                } while (g() == this.f2438e);
                this.f2436c = i11;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int iG2 = g();
            m(iG2);
            int i13 = this.f2436c + iG2;
            while (this.f2436c < i13) {
                c0Var.addLong(e());
            }
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public int readSInt32() throws IOException {
            k(0);
            return h.decodeZigZag32(g());
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public void readSInt32List(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof v)) {
                int tagWireType = WireFormat.getTagWireType(this.f2438e);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.b();
                    }
                    int iG = this.f2436c + g();
                    while (this.f2436c < iG) {
                        list.add(Integer.valueOf(h.decodeZigZag32(g())));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(readSInt32()));
                    if (a()) {
                        return;
                    } else {
                        i10 = this.f2436c;
                    }
                } while (g() == this.f2438e);
                this.f2436c = i10;
                return;
            }
            v vVar = (v) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f2438e);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.b();
                }
                int iG2 = this.f2436c + g();
                while (this.f2436c < iG2) {
                    vVar.addInt(h.decodeZigZag32(g()));
                }
                return;
            }
            do {
                vVar.addInt(readSInt32());
                if (a()) {
                    return;
                } else {
                    i11 = this.f2436c;
                }
            } while (g() == this.f2438e);
            this.f2436c = i11;
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public long readSInt64() throws IOException {
            k(0);
            return h.decodeZigZag64(readVarint64());
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public void readSInt64List(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof c0)) {
                int tagWireType = WireFormat.getTagWireType(this.f2438e);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.b();
                    }
                    int iG = this.f2436c + g();
                    while (this.f2436c < iG) {
                        list.add(Long.valueOf(h.decodeZigZag64(readVarint64())));
                    }
                    return;
                }
                do {
                    list.add(Long.valueOf(readSInt64()));
                    if (a()) {
                        return;
                    } else {
                        i10 = this.f2436c;
                    }
                } while (g() == this.f2438e);
                this.f2436c = i10;
                return;
            }
            c0 c0Var = (c0) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f2438e);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.b();
                }
                int iG2 = this.f2436c + g();
                while (this.f2436c < iG2) {
                    c0Var.addLong(h.decodeZigZag64(readVarint64()));
                }
                return;
            }
            do {
                c0Var.addLong(readSInt64());
                if (a()) {
                    return;
                } else {
                    i11 = this.f2436c;
                }
            } while (g() == this.f2438e);
            this.f2436c = i11;
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public String readString() throws IOException {
            return readStringInternal(false);
        }

        public String readStringInternal(boolean z10) throws IOException {
            k(2);
            int iG = g();
            if (iG == 0) {
                return "";
            }
            i(iG);
            byte[] bArr = this.f2435b;
            if (z10) {
                int i10 = this.f2436c;
                if (!Utf8.isValidUtf8(bArr, i10, i10 + iG)) {
                    throw InvalidProtocolBufferException.a();
                }
            }
            String str = new String(bArr, this.f2436c, iG, w.f2545a);
            this.f2436c += iG;
            return str;
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public void readStringList(List<String> list) throws IOException {
            readStringListInternal(list, false);
        }

        public void readStringListInternal(List<String> list, boolean z10) throws IOException {
            int i10;
            int i11;
            if (WireFormat.getTagWireType(this.f2438e) != 2) {
                throw InvalidProtocolBufferException.b();
            }
            if (!(list instanceof a0) || z10) {
                do {
                    list.add(readStringInternal(z10));
                    if (a()) {
                        return;
                    } else {
                        i10 = this.f2436c;
                    }
                } while (g() == this.f2438e);
                this.f2436c = i10;
                return;
            }
            a0 a0Var = (a0) list;
            do {
                a0Var.add(readBytes());
                if (a()) {
                    return;
                } else {
                    i11 = this.f2436c;
                }
            } while (g() == this.f2438e);
            this.f2436c = i11;
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public void readStringListRequireUtf8(List<String> list) throws IOException {
            readStringListInternal(list, true);
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public String readStringRequireUtf8() throws IOException {
            return readStringInternal(true);
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public int readUInt32() throws IOException {
            k(0);
            return g();
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public void readUInt32List(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof v)) {
                int tagWireType = WireFormat.getTagWireType(this.f2438e);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.b();
                    }
                    int iG = this.f2436c + g();
                    while (this.f2436c < iG) {
                        list.add(Integer.valueOf(g()));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(readUInt32()));
                    if (a()) {
                        return;
                    } else {
                        i10 = this.f2436c;
                    }
                } while (g() == this.f2438e);
                this.f2436c = i10;
                return;
            }
            v vVar = (v) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f2438e);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.b();
                }
                int iG2 = this.f2436c + g();
                while (this.f2436c < iG2) {
                    vVar.addInt(g());
                }
                return;
            }
            do {
                vVar.addInt(readUInt32());
                if (a()) {
                    return;
                } else {
                    i11 = this.f2436c;
                }
            } while (g() == this.f2438e);
            this.f2436c = i11;
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public long readUInt64() throws IOException {
            k(0);
            return readVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.x0
        public void readUInt64List(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof c0)) {
                int tagWireType = WireFormat.getTagWireType(this.f2438e);
                if (tagWireType == 0) {
                    do {
                        list.add(Long.valueOf(readUInt64()));
                        if (a()) {
                            return;
                        } else {
                            i10 = this.f2436c;
                        }
                    } while (g() == this.f2438e);
                    this.f2436c = i10;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.b();
                }
                int iG = this.f2436c + g();
                while (this.f2436c < iG) {
                    list.add(Long.valueOf(readVarint64()));
                }
                j(iG);
                return;
            }
            c0 c0Var = (c0) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f2438e);
            if (tagWireType2 == 0) {
                do {
                    c0Var.addLong(readUInt64());
                    if (a()) {
                        return;
                    } else {
                        i11 = this.f2436c;
                    }
                } while (g() == this.f2438e);
                this.f2436c = i11;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int iG2 = this.f2436c + g();
            while (this.f2436c < iG2) {
                c0Var.addLong(readVarint64());
            }
            j(iG2);
        }

        public long readVarint64() throws IOException {
            long j10;
            long j11;
            long j12;
            int i10;
            int i11 = this.f2436c;
            int i12 = this.f2437d;
            if (i12 == i11) {
                throw InvalidProtocolBufferException.f();
            }
            int i13 = i11 + 1;
            byte[] bArr = this.f2435b;
            byte b10 = bArr[i11];
            if (b10 >= 0) {
                this.f2436c = i13;
                return b10;
            }
            if (i12 - i13 < 9) {
                return h();
            }
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
                                            if (bArr[i16] < 0) {
                                                throw InvalidProtocolBufferException.c();
                                            }
                                            j11 = j10;
                                            i14 = i20;
                                        }
                                    }
                                }
                            }
                            j11 = j12 ^ j15;
                            i14 = i20;
                        }
                        this.f2436c = i14;
                        return j11;
                    }
                    i10 = i18 ^ (-2080896);
                }
                i14 = i16;
                j11 = j10;
                this.f2436c = i14;
                return j11;
            }
            i10 = i15 ^ (-128);
            j11 = i10;
            this.f2436c = i14;
            return j11;
        }

        /* JADX WARN: Removed duplicated region for block: B:44:0x008f  */
        @Override // androidx.datastore.preferences.protobuf.x0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean skipField() throws java.io.IOException {
            /*
                r7 = this;
                boolean r0 = r7.a()
                r1 = 0
                if (r0 != 0) goto Lab
                int r0 = r7.f2438e
                int r2 = r7.f2439f
                if (r0 != r2) goto Lf
                goto Lab
            Lf:
                int r0 = androidx.datastore.preferences.protobuf.WireFormat.getTagWireType(r0)
                r2 = 1
                if (r0 == 0) goto L72
                if (r0 == r2) goto L67
                r1 = 2
                if (r0 == r1) goto L5a
                r1 = 3
                r3 = 4
                if (r0 == r1) goto L30
                r1 = 5
                if (r0 != r1) goto L2b
                r7.i(r3)
                int r0 = r7.f2436c
                int r0 = r0 + r3
                r7.f2436c = r0
                return r2
            L2b:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException$InvalidWireTypeException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.b()
                throw r0
            L30:
                int r0 = r7.f2439f
                int r4 = r7.f2438e
                int r4 = androidx.datastore.preferences.protobuf.WireFormat.getTagFieldNumber(r4)
                int r1 = r4 << 3
                r1 = r1 | r3
                r7.f2439f = r1
            L3d:
                int r1 = r7.getFieldNumber()
                r3 = 2147483647(0x7fffffff, float:NaN)
                if (r1 == r3) goto L4c
                boolean r1 = r7.skipField()
                if (r1 != 0) goto L3d
            L4c:
                int r1 = r7.f2438e
                int r3 = r7.f2439f
                if (r1 != r3) goto L55
                r7.f2439f = r0
                return r2
            L55:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.e()
                throw r0
            L5a:
                int r0 = r7.g()
                r7.i(r0)
                int r1 = r7.f2436c
                int r1 = r1 + r0
                r7.f2436c = r1
                return r2
            L67:
                r0 = 8
                r7.i(r0)
                int r1 = r7.f2436c
                int r1 = r1 + r0
                r7.f2436c = r1
                return r2
            L72:
                int r0 = r7.f2437d
                int r3 = r7.f2436c
                int r0 = r0 - r3
                byte[] r4 = r7.f2435b
                r5 = 10
                if (r0 < r5) goto L8d
                r0 = 0
            L7e:
                if (r0 >= r5) goto L8d
                int r6 = r3 + 1
                r3 = r4[r3]
                if (r3 < 0) goto L89
                r7.f2436c = r6
                goto L9d
            L89:
                int r0 = r0 + 1
                r3 = r6
                goto L7e
            L8d:
                if (r1 >= r5) goto La6
                int r0 = r7.f2436c
                int r3 = r7.f2437d
                if (r0 == r3) goto La1
                int r3 = r0 + 1
                r7.f2436c = r3
                r0 = r4[r0]
                if (r0 < 0) goto L9e
            L9d:
                return r2
            L9e:
                int r1 = r1 + 1
                goto L8d
            La1:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.f()
                throw r0
            La6:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.c()
                throw r0
            Lab:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.e.a.skipField():boolean");
        }
    }

    public static e newInstance(ByteBuffer byteBuffer, boolean z10) {
        if (byteBuffer.hasArray()) {
            return new a(byteBuffer, z10);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }
}
