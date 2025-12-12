package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/* compiled from: CodedInputStreamReader.java */
/* loaded from: classes.dex */
public final class i implements x0 {

    /* renamed from: a, reason: collision with root package name */
    public final h f2478a;

    /* renamed from: b, reason: collision with root package name */
    public int f2479b;

    /* renamed from: c, reason: collision with root package name */
    public int f2480c;

    /* renamed from: d, reason: collision with root package name */
    public int f2481d = 0;

    public i(h hVar) {
        Charset charset = w.f2545a;
        if (hVar == null) {
            throw new NullPointerException("input");
        }
        this.f2478a = hVar;
        hVar.f2459d = this;
    }

    public static i forCodedInput(h hVar) {
        i iVar = hVar.f2459d;
        return iVar != null ? iVar : new i(hVar);
    }

    public final Object a(WireFormat.FieldType fieldType, Class<?> cls, n nVar) throws IOException {
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

    public final <T> T b(y0<T> y0Var, n nVar) throws IOException {
        int i10 = this.f2480c;
        this.f2480c = (WireFormat.getTagFieldNumber(this.f2479b) << 3) | 4;
        try {
            T tNewInstance = y0Var.newInstance();
            y0Var.mergeFrom(tNewInstance, this, nVar);
            y0Var.makeImmutable(tNewInstance);
            if (this.f2479b == this.f2480c) {
                return tNewInstance;
            }
            throw InvalidProtocolBufferException.e();
        } finally {
            this.f2480c = i10;
        }
    }

    public final <T> T c(y0<T> y0Var, n nVar) throws IOException {
        h hVar = this.f2478a;
        int uInt32 = hVar.readUInt32();
        if (hVar.f2456a >= hVar.f2457b) {
            throw new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iPushLimit = hVar.pushLimit(uInt32);
        T tNewInstance = y0Var.newInstance();
        hVar.f2456a++;
        y0Var.mergeFrom(tNewInstance, this, nVar);
        y0Var.makeImmutable(tNewInstance);
        hVar.checkLastTagWas(0);
        hVar.f2456a--;
        hVar.popLimit(iPushLimit);
        return tNewInstance;
    }

    public final void d(int i10) throws IOException {
        if (this.f2478a.getTotalBytesRead() != i10) {
            throw InvalidProtocolBufferException.f();
        }
    }

    public final void e(int i10) throws IOException {
        if (WireFormat.getTagWireType(this.f2479b) != i10) {
            throw InvalidProtocolBufferException.b();
        }
    }

    public final void f(int i10) throws IOException {
        if ((i10 & 3) != 0) {
            throw InvalidProtocolBufferException.e();
        }
    }

    public final void g(int i10) throws IOException {
        if ((i10 & 7) != 0) {
            throw InvalidProtocolBufferException.e();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public int getFieldNumber() throws IOException {
        int i10 = this.f2481d;
        if (i10 != 0) {
            this.f2479b = i10;
            this.f2481d = 0;
        } else {
            this.f2479b = this.f2478a.readTag();
        }
        int i11 = this.f2479b;
        if (i11 == 0 || i11 == this.f2480c) {
            return Integer.MAX_VALUE;
        }
        return WireFormat.getTagFieldNumber(i11);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public int getTag() {
        return this.f2479b;
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public boolean readBool() throws IOException {
        e(0);
        return this.f2478a.readBool();
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void readBoolList(List<Boolean> list) throws IOException {
        int tag;
        int tag2;
        boolean z10 = list instanceof f;
        h hVar = this.f2478a;
        if (!z10) {
            int tagWireType = WireFormat.getTagWireType(this.f2479b);
            if (tagWireType == 0) {
                do {
                    list.add(Boolean.valueOf(hVar.readBool()));
                    if (hVar.isAtEnd()) {
                        return;
                    } else {
                        tag = hVar.readTag();
                    }
                } while (tag == this.f2479b);
                this.f2481d = tag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int totalBytesRead = hVar.getTotalBytesRead() + hVar.readUInt32();
            do {
                list.add(Boolean.valueOf(hVar.readBool()));
            } while (hVar.getTotalBytesRead() < totalBytesRead);
            d(totalBytesRead);
            return;
        }
        f fVar = (f) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f2479b);
        if (tagWireType2 == 0) {
            do {
                fVar.addBoolean(hVar.readBool());
                if (hVar.isAtEnd()) {
                    return;
                } else {
                    tag2 = hVar.readTag();
                }
            } while (tag2 == this.f2479b);
            this.f2481d = tag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int totalBytesRead2 = hVar.getTotalBytesRead() + hVar.readUInt32();
        do {
            fVar.addBoolean(hVar.readBool());
        } while (hVar.getTotalBytesRead() < totalBytesRead2);
        d(totalBytesRead2);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public ByteString readBytes() throws IOException {
        e(2);
        return this.f2478a.readBytes();
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void readBytesList(List<ByteString> list) throws IOException {
        int tag;
        if (WireFormat.getTagWireType(this.f2479b) != 2) {
            throw InvalidProtocolBufferException.b();
        }
        do {
            list.add(readBytes());
            h hVar = this.f2478a;
            if (hVar.isAtEnd()) {
                return;
            } else {
                tag = hVar.readTag();
            }
        } while (tag == this.f2479b);
        this.f2481d = tag;
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public double readDouble() throws IOException {
        e(1);
        return this.f2478a.readDouble();
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void readDoubleList(List<Double> list) throws IOException {
        int tag;
        int tag2;
        boolean z10 = list instanceof k;
        h hVar = this.f2478a;
        if (!z10) {
            int tagWireType = WireFormat.getTagWireType(this.f2479b);
            if (tagWireType == 1) {
                do {
                    list.add(Double.valueOf(hVar.readDouble()));
                    if (hVar.isAtEnd()) {
                        return;
                    } else {
                        tag = hVar.readTag();
                    }
                } while (tag == this.f2479b);
                this.f2481d = tag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int uInt32 = hVar.readUInt32();
            g(uInt32);
            int totalBytesRead = hVar.getTotalBytesRead() + uInt32;
            do {
                list.add(Double.valueOf(hVar.readDouble()));
            } while (hVar.getTotalBytesRead() < totalBytesRead);
            return;
        }
        k kVar = (k) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f2479b);
        if (tagWireType2 == 1) {
            do {
                kVar.addDouble(hVar.readDouble());
                if (hVar.isAtEnd()) {
                    return;
                } else {
                    tag2 = hVar.readTag();
                }
            } while (tag2 == this.f2479b);
            this.f2481d = tag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int uInt322 = hVar.readUInt32();
        g(uInt322);
        int totalBytesRead2 = hVar.getTotalBytesRead() + uInt322;
        do {
            kVar.addDouble(hVar.readDouble());
        } while (hVar.getTotalBytesRead() < totalBytesRead2);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public int readEnum() throws IOException {
        e(0);
        return this.f2478a.readEnum();
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void readEnumList(List<Integer> list) throws IOException {
        int tag;
        int tag2;
        boolean z10 = list instanceof v;
        h hVar = this.f2478a;
        if (!z10) {
            int tagWireType = WireFormat.getTagWireType(this.f2479b);
            if (tagWireType == 0) {
                do {
                    list.add(Integer.valueOf(hVar.readEnum()));
                    if (hVar.isAtEnd()) {
                        return;
                    } else {
                        tag = hVar.readTag();
                    }
                } while (tag == this.f2479b);
                this.f2481d = tag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int totalBytesRead = hVar.getTotalBytesRead() + hVar.readUInt32();
            do {
                list.add(Integer.valueOf(hVar.readEnum()));
            } while (hVar.getTotalBytesRead() < totalBytesRead);
            d(totalBytesRead);
            return;
        }
        v vVar = (v) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f2479b);
        if (tagWireType2 == 0) {
            do {
                vVar.addInt(hVar.readEnum());
                if (hVar.isAtEnd()) {
                    return;
                } else {
                    tag2 = hVar.readTag();
                }
            } while (tag2 == this.f2479b);
            this.f2481d = tag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int totalBytesRead2 = hVar.getTotalBytesRead() + hVar.readUInt32();
        do {
            vVar.addInt(hVar.readEnum());
        } while (hVar.getTotalBytesRead() < totalBytesRead2);
        d(totalBytesRead2);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public int readFixed32() throws IOException {
        e(5);
        return this.f2478a.readFixed32();
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void readFixed32List(List<Integer> list) throws IOException {
        int tag;
        int tag2;
        boolean z10 = list instanceof v;
        h hVar = this.f2478a;
        if (!z10) {
            int tagWireType = WireFormat.getTagWireType(this.f2479b);
            if (tagWireType == 2) {
                int uInt32 = hVar.readUInt32();
                f(uInt32);
                int totalBytesRead = hVar.getTotalBytesRead() + uInt32;
                do {
                    list.add(Integer.valueOf(hVar.readFixed32()));
                } while (hVar.getTotalBytesRead() < totalBytesRead);
                return;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.b();
            }
            do {
                list.add(Integer.valueOf(hVar.readFixed32()));
                if (hVar.isAtEnd()) {
                    return;
                } else {
                    tag = hVar.readTag();
                }
            } while (tag == this.f2479b);
            this.f2481d = tag;
            return;
        }
        v vVar = (v) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f2479b);
        if (tagWireType2 == 2) {
            int uInt322 = hVar.readUInt32();
            f(uInt322);
            int totalBytesRead2 = hVar.getTotalBytesRead() + uInt322;
            do {
                vVar.addInt(hVar.readFixed32());
            } while (hVar.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        if (tagWireType2 != 5) {
            throw InvalidProtocolBufferException.b();
        }
        do {
            vVar.addInt(hVar.readFixed32());
            if (hVar.isAtEnd()) {
                return;
            } else {
                tag2 = hVar.readTag();
            }
        } while (tag2 == this.f2479b);
        this.f2481d = tag2;
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public long readFixed64() throws IOException {
        e(1);
        return this.f2478a.readFixed64();
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void readFixed64List(List<Long> list) throws IOException {
        int tag;
        int tag2;
        boolean z10 = list instanceof c0;
        h hVar = this.f2478a;
        if (!z10) {
            int tagWireType = WireFormat.getTagWireType(this.f2479b);
            if (tagWireType == 1) {
                do {
                    list.add(Long.valueOf(hVar.readFixed64()));
                    if (hVar.isAtEnd()) {
                        return;
                    } else {
                        tag = hVar.readTag();
                    }
                } while (tag == this.f2479b);
                this.f2481d = tag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int uInt32 = hVar.readUInt32();
            g(uInt32);
            int totalBytesRead = hVar.getTotalBytesRead() + uInt32;
            do {
                list.add(Long.valueOf(hVar.readFixed64()));
            } while (hVar.getTotalBytesRead() < totalBytesRead);
            return;
        }
        c0 c0Var = (c0) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f2479b);
        if (tagWireType2 == 1) {
            do {
                c0Var.addLong(hVar.readFixed64());
                if (hVar.isAtEnd()) {
                    return;
                } else {
                    tag2 = hVar.readTag();
                }
            } while (tag2 == this.f2479b);
            this.f2481d = tag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int uInt322 = hVar.readUInt32();
        g(uInt322);
        int totalBytesRead2 = hVar.getTotalBytesRead() + uInt322;
        do {
            c0Var.addLong(hVar.readFixed64());
        } while (hVar.getTotalBytesRead() < totalBytesRead2);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public float readFloat() throws IOException {
        e(5);
        return this.f2478a.readFloat();
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void readFloatList(List<Float> list) throws IOException {
        int tag;
        int tag2;
        boolean z10 = list instanceof t;
        h hVar = this.f2478a;
        if (!z10) {
            int tagWireType = WireFormat.getTagWireType(this.f2479b);
            if (tagWireType == 2) {
                int uInt32 = hVar.readUInt32();
                f(uInt32);
                int totalBytesRead = hVar.getTotalBytesRead() + uInt32;
                do {
                    list.add(Float.valueOf(hVar.readFloat()));
                } while (hVar.getTotalBytesRead() < totalBytesRead);
                return;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.b();
            }
            do {
                list.add(Float.valueOf(hVar.readFloat()));
                if (hVar.isAtEnd()) {
                    return;
                } else {
                    tag = hVar.readTag();
                }
            } while (tag == this.f2479b);
            this.f2481d = tag;
            return;
        }
        t tVar = (t) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f2479b);
        if (tagWireType2 == 2) {
            int uInt322 = hVar.readUInt32();
            f(uInt322);
            int totalBytesRead2 = hVar.getTotalBytesRead() + uInt322;
            do {
                tVar.addFloat(hVar.readFloat());
            } while (hVar.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        if (tagWireType2 != 5) {
            throw InvalidProtocolBufferException.b();
        }
        do {
            tVar.addFloat(hVar.readFloat());
            if (hVar.isAtEnd()) {
                return;
            } else {
                tag2 = hVar.readTag();
            }
        } while (tag2 == this.f2479b);
        this.f2481d = tag2;
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public <T> T readGroupBySchemaWithCheck(y0<T> y0Var, n nVar) throws IOException {
        e(3);
        return (T) b(y0Var, nVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.x0
    public <T> void readGroupList(List<T> list, y0<T> y0Var, n nVar) throws IOException {
        int tag;
        if (WireFormat.getTagWireType(this.f2479b) != 3) {
            throw InvalidProtocolBufferException.b();
        }
        int i10 = this.f2479b;
        do {
            list.add(b(y0Var, nVar));
            h hVar = this.f2478a;
            if (hVar.isAtEnd() || this.f2481d != 0) {
                return;
            } else {
                tag = hVar.readTag();
            }
        } while (tag == i10);
        this.f2481d = tag;
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public int readInt32() throws IOException {
        e(0);
        return this.f2478a.readInt32();
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void readInt32List(List<Integer> list) throws IOException {
        int tag;
        int tag2;
        boolean z10 = list instanceof v;
        h hVar = this.f2478a;
        if (!z10) {
            int tagWireType = WireFormat.getTagWireType(this.f2479b);
            if (tagWireType == 0) {
                do {
                    list.add(Integer.valueOf(hVar.readInt32()));
                    if (hVar.isAtEnd()) {
                        return;
                    } else {
                        tag = hVar.readTag();
                    }
                } while (tag == this.f2479b);
                this.f2481d = tag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int totalBytesRead = hVar.getTotalBytesRead() + hVar.readUInt32();
            do {
                list.add(Integer.valueOf(hVar.readInt32()));
            } while (hVar.getTotalBytesRead() < totalBytesRead);
            d(totalBytesRead);
            return;
        }
        v vVar = (v) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f2479b);
        if (tagWireType2 == 0) {
            do {
                vVar.addInt(hVar.readInt32());
                if (hVar.isAtEnd()) {
                    return;
                } else {
                    tag2 = hVar.readTag();
                }
            } while (tag2 == this.f2479b);
            this.f2481d = tag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int totalBytesRead2 = hVar.getTotalBytesRead() + hVar.readUInt32();
        do {
            vVar.addInt(hVar.readInt32());
        } while (hVar.getTotalBytesRead() < totalBytesRead2);
        d(totalBytesRead2);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public long readInt64() throws IOException {
        e(0);
        return this.f2478a.readInt64();
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void readInt64List(List<Long> list) throws IOException {
        int tag;
        int tag2;
        boolean z10 = list instanceof c0;
        h hVar = this.f2478a;
        if (!z10) {
            int tagWireType = WireFormat.getTagWireType(this.f2479b);
            if (tagWireType == 0) {
                do {
                    list.add(Long.valueOf(hVar.readInt64()));
                    if (hVar.isAtEnd()) {
                        return;
                    } else {
                        tag = hVar.readTag();
                    }
                } while (tag == this.f2479b);
                this.f2481d = tag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int totalBytesRead = hVar.getTotalBytesRead() + hVar.readUInt32();
            do {
                list.add(Long.valueOf(hVar.readInt64()));
            } while (hVar.getTotalBytesRead() < totalBytesRead);
            d(totalBytesRead);
            return;
        }
        c0 c0Var = (c0) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f2479b);
        if (tagWireType2 == 0) {
            do {
                c0Var.addLong(hVar.readInt64());
                if (hVar.isAtEnd()) {
                    return;
                } else {
                    tag2 = hVar.readTag();
                }
            } while (tag2 == this.f2479b);
            this.f2481d = tag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int totalBytesRead2 = hVar.getTotalBytesRead() + hVar.readUInt32();
        do {
            c0Var.addLong(hVar.readInt64());
        } while (hVar.getTotalBytesRead() < totalBytesRead2);
        d(totalBytesRead2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0057, code lost:
    
        r10.put(r3, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.x0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <K, V> void readMap(java.util.Map<K, V> r10, androidx.datastore.preferences.protobuf.e0.a<K, V> r11, androidx.datastore.preferences.protobuf.n r12) throws java.io.IOException {
        /*
            r9 = this;
            r0 = 2
            r9.e(r0)
            androidx.datastore.preferences.protobuf.h r1 = r9.f2478a
            int r2 = r1.readUInt32()
            int r2 = r1.pushLimit(r2)
            K r3 = r11.f2444b
            V r4 = r11.f2446d
            r5 = r4
        L13:
            int r6 = r9.getFieldNumber()     // Catch: java.lang.Throwable -> L5e
            r7 = 2147483647(0x7fffffff, float:NaN)
            if (r6 == r7) goto L57
            boolean r7 = r1.isAtEnd()     // Catch: java.lang.Throwable -> L5e
            if (r7 == 0) goto L23
            goto L57
        L23:
            r7 = 1
            java.lang.String r8 = "Unable to parse map entry."
            if (r6 == r7) goto L42
            if (r6 == r0) goto L37
            boolean r6 = r9.skipField()     // Catch: androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4a java.lang.Throwable -> L5e
            if (r6 == 0) goto L31
            goto L13
        L31:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r6 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch: androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4a java.lang.Throwable -> L5e
            r6.<init>(r8)     // Catch: androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4a java.lang.Throwable -> L5e
            throw r6     // Catch: androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4a java.lang.Throwable -> L5e
        L37:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r6 = r11.f2445c     // Catch: androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4a java.lang.Throwable -> L5e
            java.lang.Class r7 = r4.getClass()     // Catch: androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4a java.lang.Throwable -> L5e
            java.lang.Object r5 = r9.a(r6, r7, r12)     // Catch: androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4a java.lang.Throwable -> L5e
            goto L13
        L42:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r6 = r11.f2443a     // Catch: androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4a java.lang.Throwable -> L5e
            r7 = 0
            java.lang.Object r3 = r9.a(r6, r7, r7)     // Catch: androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4a java.lang.Throwable -> L5e
            goto L13
        L4a:
            boolean r6 = r9.skipField()     // Catch: java.lang.Throwable -> L5e
            if (r6 == 0) goto L51
            goto L13
        L51:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r10 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L5e
            r10.<init>(r8)     // Catch: java.lang.Throwable -> L5e
            throw r10     // Catch: java.lang.Throwable -> L5e
        L57:
            r10.put(r3, r5)     // Catch: java.lang.Throwable -> L5e
            r1.popLimit(r2)
            return
        L5e:
            r10 = move-exception
            r1.popLimit(r2)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.i.readMap(java.util.Map, androidx.datastore.preferences.protobuf.e0$a, androidx.datastore.preferences.protobuf.n):void");
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public <T> T readMessage(Class<T> cls, n nVar) throws IOException {
        e(2);
        return (T) c(u0.getInstance().schemaFor((Class) cls), nVar);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public <T> T readMessageBySchemaWithCheck(y0<T> y0Var, n nVar) throws IOException {
        e(2);
        return (T) c(y0Var, nVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.x0
    public <T> void readMessageList(List<T> list, y0<T> y0Var, n nVar) throws IOException {
        int tag;
        if (WireFormat.getTagWireType(this.f2479b) != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int i10 = this.f2479b;
        do {
            list.add(c(y0Var, nVar));
            h hVar = this.f2478a;
            if (hVar.isAtEnd() || this.f2481d != 0) {
                return;
            } else {
                tag = hVar.readTag();
            }
        } while (tag == i10);
        this.f2481d = tag;
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public int readSFixed32() throws IOException {
        e(5);
        return this.f2478a.readSFixed32();
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void readSFixed32List(List<Integer> list) throws IOException {
        int tag;
        int tag2;
        boolean z10 = list instanceof v;
        h hVar = this.f2478a;
        if (!z10) {
            int tagWireType = WireFormat.getTagWireType(this.f2479b);
            if (tagWireType == 2) {
                int uInt32 = hVar.readUInt32();
                f(uInt32);
                int totalBytesRead = hVar.getTotalBytesRead() + uInt32;
                do {
                    list.add(Integer.valueOf(hVar.readSFixed32()));
                } while (hVar.getTotalBytesRead() < totalBytesRead);
                return;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.b();
            }
            do {
                list.add(Integer.valueOf(hVar.readSFixed32()));
                if (hVar.isAtEnd()) {
                    return;
                } else {
                    tag = hVar.readTag();
                }
            } while (tag == this.f2479b);
            this.f2481d = tag;
            return;
        }
        v vVar = (v) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f2479b);
        if (tagWireType2 == 2) {
            int uInt322 = hVar.readUInt32();
            f(uInt322);
            int totalBytesRead2 = hVar.getTotalBytesRead() + uInt322;
            do {
                vVar.addInt(hVar.readSFixed32());
            } while (hVar.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        if (tagWireType2 != 5) {
            throw InvalidProtocolBufferException.b();
        }
        do {
            vVar.addInt(hVar.readSFixed32());
            if (hVar.isAtEnd()) {
                return;
            } else {
                tag2 = hVar.readTag();
            }
        } while (tag2 == this.f2479b);
        this.f2481d = tag2;
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public long readSFixed64() throws IOException {
        e(1);
        return this.f2478a.readSFixed64();
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void readSFixed64List(List<Long> list) throws IOException {
        int tag;
        int tag2;
        boolean z10 = list instanceof c0;
        h hVar = this.f2478a;
        if (!z10) {
            int tagWireType = WireFormat.getTagWireType(this.f2479b);
            if (tagWireType == 1) {
                do {
                    list.add(Long.valueOf(hVar.readSFixed64()));
                    if (hVar.isAtEnd()) {
                        return;
                    } else {
                        tag = hVar.readTag();
                    }
                } while (tag == this.f2479b);
                this.f2481d = tag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int uInt32 = hVar.readUInt32();
            g(uInt32);
            int totalBytesRead = hVar.getTotalBytesRead() + uInt32;
            do {
                list.add(Long.valueOf(hVar.readSFixed64()));
            } while (hVar.getTotalBytesRead() < totalBytesRead);
            return;
        }
        c0 c0Var = (c0) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f2479b);
        if (tagWireType2 == 1) {
            do {
                c0Var.addLong(hVar.readSFixed64());
                if (hVar.isAtEnd()) {
                    return;
                } else {
                    tag2 = hVar.readTag();
                }
            } while (tag2 == this.f2479b);
            this.f2481d = tag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int uInt322 = hVar.readUInt32();
        g(uInt322);
        int totalBytesRead2 = hVar.getTotalBytesRead() + uInt322;
        do {
            c0Var.addLong(hVar.readSFixed64());
        } while (hVar.getTotalBytesRead() < totalBytesRead2);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public int readSInt32() throws IOException {
        e(0);
        return this.f2478a.readSInt32();
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void readSInt32List(List<Integer> list) throws IOException {
        int tag;
        int tag2;
        boolean z10 = list instanceof v;
        h hVar = this.f2478a;
        if (!z10) {
            int tagWireType = WireFormat.getTagWireType(this.f2479b);
            if (tagWireType == 0) {
                do {
                    list.add(Integer.valueOf(hVar.readSInt32()));
                    if (hVar.isAtEnd()) {
                        return;
                    } else {
                        tag = hVar.readTag();
                    }
                } while (tag == this.f2479b);
                this.f2481d = tag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int totalBytesRead = hVar.getTotalBytesRead() + hVar.readUInt32();
            do {
                list.add(Integer.valueOf(hVar.readSInt32()));
            } while (hVar.getTotalBytesRead() < totalBytesRead);
            d(totalBytesRead);
            return;
        }
        v vVar = (v) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f2479b);
        if (tagWireType2 == 0) {
            do {
                vVar.addInt(hVar.readSInt32());
                if (hVar.isAtEnd()) {
                    return;
                } else {
                    tag2 = hVar.readTag();
                }
            } while (tag2 == this.f2479b);
            this.f2481d = tag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int totalBytesRead2 = hVar.getTotalBytesRead() + hVar.readUInt32();
        do {
            vVar.addInt(hVar.readSInt32());
        } while (hVar.getTotalBytesRead() < totalBytesRead2);
        d(totalBytesRead2);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public long readSInt64() throws IOException {
        e(0);
        return this.f2478a.readSInt64();
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void readSInt64List(List<Long> list) throws IOException {
        int tag;
        int tag2;
        boolean z10 = list instanceof c0;
        h hVar = this.f2478a;
        if (!z10) {
            int tagWireType = WireFormat.getTagWireType(this.f2479b);
            if (tagWireType == 0) {
                do {
                    list.add(Long.valueOf(hVar.readSInt64()));
                    if (hVar.isAtEnd()) {
                        return;
                    } else {
                        tag = hVar.readTag();
                    }
                } while (tag == this.f2479b);
                this.f2481d = tag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int totalBytesRead = hVar.getTotalBytesRead() + hVar.readUInt32();
            do {
                list.add(Long.valueOf(hVar.readSInt64()));
            } while (hVar.getTotalBytesRead() < totalBytesRead);
            d(totalBytesRead);
            return;
        }
        c0 c0Var = (c0) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f2479b);
        if (tagWireType2 == 0) {
            do {
                c0Var.addLong(hVar.readSInt64());
                if (hVar.isAtEnd()) {
                    return;
                } else {
                    tag2 = hVar.readTag();
                }
            } while (tag2 == this.f2479b);
            this.f2481d = tag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int totalBytesRead2 = hVar.getTotalBytesRead() + hVar.readUInt32();
        do {
            c0Var.addLong(hVar.readSInt64());
        } while (hVar.getTotalBytesRead() < totalBytesRead2);
        d(totalBytesRead2);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public String readString() throws IOException {
        e(2);
        return this.f2478a.readString();
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void readStringList(List<String> list) throws IOException {
        readStringListInternal(list, false);
    }

    public void readStringListInternal(List<String> list, boolean z10) throws IOException {
        int tag;
        int tag2;
        if (WireFormat.getTagWireType(this.f2479b) != 2) {
            throw InvalidProtocolBufferException.b();
        }
        boolean z11 = list instanceof a0;
        h hVar = this.f2478a;
        if (!z11 || z10) {
            do {
                list.add(z10 ? readStringRequireUtf8() : readString());
                if (hVar.isAtEnd()) {
                    return;
                } else {
                    tag = hVar.readTag();
                }
            } while (tag == this.f2479b);
            this.f2481d = tag;
            return;
        }
        a0 a0Var = (a0) list;
        do {
            a0Var.add(readBytes());
            if (hVar.isAtEnd()) {
                return;
            } else {
                tag2 = hVar.readTag();
            }
        } while (tag2 == this.f2479b);
        this.f2481d = tag2;
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void readStringListRequireUtf8(List<String> list) throws IOException {
        readStringListInternal(list, true);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public String readStringRequireUtf8() throws IOException {
        e(2);
        return this.f2478a.readStringRequireUtf8();
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public int readUInt32() throws IOException {
        e(0);
        return this.f2478a.readUInt32();
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void readUInt32List(List<Integer> list) throws IOException {
        int tag;
        int tag2;
        boolean z10 = list instanceof v;
        h hVar = this.f2478a;
        if (!z10) {
            int tagWireType = WireFormat.getTagWireType(this.f2479b);
            if (tagWireType == 0) {
                do {
                    list.add(Integer.valueOf(hVar.readUInt32()));
                    if (hVar.isAtEnd()) {
                        return;
                    } else {
                        tag = hVar.readTag();
                    }
                } while (tag == this.f2479b);
                this.f2481d = tag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int totalBytesRead = hVar.getTotalBytesRead() + hVar.readUInt32();
            do {
                list.add(Integer.valueOf(hVar.readUInt32()));
            } while (hVar.getTotalBytesRead() < totalBytesRead);
            d(totalBytesRead);
            return;
        }
        v vVar = (v) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f2479b);
        if (tagWireType2 == 0) {
            do {
                vVar.addInt(hVar.readUInt32());
                if (hVar.isAtEnd()) {
                    return;
                } else {
                    tag2 = hVar.readTag();
                }
            } while (tag2 == this.f2479b);
            this.f2481d = tag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int totalBytesRead2 = hVar.getTotalBytesRead() + hVar.readUInt32();
        do {
            vVar.addInt(hVar.readUInt32());
        } while (hVar.getTotalBytesRead() < totalBytesRead2);
        d(totalBytesRead2);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public long readUInt64() throws IOException {
        e(0);
        return this.f2478a.readUInt64();
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void readUInt64List(List<Long> list) throws IOException {
        int tag;
        int tag2;
        boolean z10 = list instanceof c0;
        h hVar = this.f2478a;
        if (!z10) {
            int tagWireType = WireFormat.getTagWireType(this.f2479b);
            if (tagWireType == 0) {
                do {
                    list.add(Long.valueOf(hVar.readUInt64()));
                    if (hVar.isAtEnd()) {
                        return;
                    } else {
                        tag = hVar.readTag();
                    }
                } while (tag == this.f2479b);
                this.f2481d = tag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.b();
            }
            int totalBytesRead = hVar.getTotalBytesRead() + hVar.readUInt32();
            do {
                list.add(Long.valueOf(hVar.readUInt64()));
            } while (hVar.getTotalBytesRead() < totalBytesRead);
            d(totalBytesRead);
            return;
        }
        c0 c0Var = (c0) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f2479b);
        if (tagWireType2 == 0) {
            do {
                c0Var.addLong(hVar.readUInt64());
                if (hVar.isAtEnd()) {
                    return;
                } else {
                    tag2 = hVar.readTag();
                }
            } while (tag2 == this.f2479b);
            this.f2481d = tag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.b();
        }
        int totalBytesRead2 = hVar.getTotalBytesRead() + hVar.readUInt32();
        do {
            c0Var.addLong(hVar.readUInt64());
        } while (hVar.getTotalBytesRead() < totalBytesRead2);
        d(totalBytesRead2);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public boolean skipField() throws IOException {
        int i10;
        h hVar = this.f2478a;
        if (hVar.isAtEnd() || (i10 = this.f2479b) == this.f2480c) {
            return false;
        }
        return hVar.skipField(i10);
    }
}
