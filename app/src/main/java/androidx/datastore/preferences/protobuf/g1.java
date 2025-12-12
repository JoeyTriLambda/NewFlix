package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: UnknownFieldSetLite.java */
/* loaded from: classes.dex */
public final class g1 {

    /* renamed from: f, reason: collision with root package name */
    public static final g1 f2450f = new g1(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f2451a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f2452b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f2453c;

    /* renamed from: d, reason: collision with root package name */
    public int f2454d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2455e;

    public g1() {
        this(0, new int[8], new Object[8], true);
    }

    public static void b(int i10, Object obj, Writer writer) throws IOException {
        int tagFieldNumber = WireFormat.getTagFieldNumber(i10);
        int tagWireType = WireFormat.getTagWireType(i10);
        if (tagWireType == 0) {
            ((j) writer).writeInt64(tagFieldNumber, ((Long) obj).longValue());
            return;
        }
        if (tagWireType == 1) {
            ((j) writer).writeFixed64(tagFieldNumber, ((Long) obj).longValue());
            return;
        }
        if (tagWireType == 2) {
            ((j) writer).writeBytes(tagFieldNumber, (ByteString) obj);
            return;
        }
        if (tagWireType != 3) {
            if (tagWireType != 5) {
                throw new RuntimeException(InvalidProtocolBufferException.b());
            }
            ((j) writer).writeFixed32(tagFieldNumber, ((Integer) obj).intValue());
            return;
        }
        j jVar = (j) writer;
        if (jVar.fieldOrder() == Writer.FieldOrder.ASCENDING) {
            jVar.writeStartGroup(tagFieldNumber);
            ((g1) obj).writeTo(jVar);
            jVar.writeEndGroup(tagFieldNumber);
        } else {
            jVar.writeEndGroup(tagFieldNumber);
            ((g1) obj).writeTo(jVar);
            jVar.writeStartGroup(tagFieldNumber);
        }
    }

    public static g1 getDefaultInstance() {
        return f2450f;
    }

    public final void a(int i10, Object obj) {
        if (!this.f2455e) {
            throw new UnsupportedOperationException();
        }
        int i11 = this.f2451a;
        int[] iArr = this.f2452b;
        if (i11 == iArr.length) {
            int i12 = i11 + (i11 < 4 ? 8 : i11 >> 1);
            this.f2452b = Arrays.copyOf(iArr, i12);
            this.f2453c = Arrays.copyOf(this.f2453c, i12);
        }
        int[] iArr2 = this.f2452b;
        int i13 = this.f2451a;
        iArr2[i13] = i10;
        this.f2453c[i13] = obj;
        this.f2451a = i13 + 1;
    }

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof g1)) {
            return false;
        }
        g1 g1Var = (g1) obj;
        int i10 = this.f2451a;
        if (i10 == g1Var.f2451a) {
            int[] iArr = this.f2452b;
            int[] iArr2 = g1Var.f2452b;
            int i11 = 0;
            while (true) {
                if (i11 >= i10) {
                    z10 = true;
                    break;
                }
                if (iArr[i11] != iArr2[i11]) {
                    z10 = false;
                    break;
                }
                i11++;
            }
            if (z10) {
                Object[] objArr = this.f2453c;
                Object[] objArr2 = g1Var.f2453c;
                int i12 = this.f2451a;
                int i13 = 0;
                while (true) {
                    if (i13 >= i12) {
                        z11 = true;
                        break;
                    }
                    if (!objArr[i13].equals(objArr2[i13])) {
                        z11 = false;
                        break;
                    }
                    i13++;
                }
                if (z11) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getSerializedSize() {
        int iComputeUInt64Size;
        int i10 = this.f2454d;
        if (i10 != -1) {
            return i10;
        }
        int serializedSize = 0;
        for (int i11 = 0; i11 < this.f2451a; i11++) {
            int i12 = this.f2452b[i11];
            int tagFieldNumber = WireFormat.getTagFieldNumber(i12);
            int tagWireType = WireFormat.getTagWireType(i12);
            if (tagWireType == 0) {
                iComputeUInt64Size = CodedOutputStream.computeUInt64Size(tagFieldNumber, ((Long) this.f2453c[i11]).longValue());
            } else if (tagWireType == 1) {
                iComputeUInt64Size = CodedOutputStream.computeFixed64Size(tagFieldNumber, ((Long) this.f2453c[i11]).longValue());
            } else if (tagWireType == 2) {
                iComputeUInt64Size = CodedOutputStream.computeBytesSize(tagFieldNumber, (ByteString) this.f2453c[i11]);
            } else if (tagWireType == 3) {
                serializedSize = ((g1) this.f2453c[i11]).getSerializedSize() + (CodedOutputStream.computeTagSize(tagFieldNumber) * 2) + serializedSize;
            } else {
                if (tagWireType != 5) {
                    throw new IllegalStateException(InvalidProtocolBufferException.b());
                }
                iComputeUInt64Size = CodedOutputStream.computeFixed32Size(tagFieldNumber, ((Integer) this.f2453c[i11]).intValue());
            }
            serializedSize = iComputeUInt64Size + serializedSize;
        }
        this.f2454d = serializedSize;
        return serializedSize;
    }

    public int getSerializedSizeAsMessageSet() {
        int i10 = this.f2454d;
        if (i10 != -1) {
            return i10;
        }
        int iComputeRawMessageSetExtensionSize = 0;
        for (int i11 = 0; i11 < this.f2451a; i11++) {
            iComputeRawMessageSetExtensionSize += CodedOutputStream.computeRawMessageSetExtensionSize(WireFormat.getTagFieldNumber(this.f2452b[i11]), (ByteString) this.f2453c[i11]);
        }
        this.f2454d = iComputeRawMessageSetExtensionSize;
        return iComputeRawMessageSetExtensionSize;
    }

    public int hashCode() {
        int i10 = this.f2451a;
        int i11 = (527 + i10) * 31;
        int[] iArr = this.f2452b;
        int iHashCode = 17;
        int i12 = 17;
        for (int i13 = 0; i13 < i10; i13++) {
            i12 = (i12 * 31) + iArr[i13];
        }
        int i14 = (i11 + i12) * 31;
        Object[] objArr = this.f2453c;
        int i15 = this.f2451a;
        for (int i16 = 0; i16 < i15; i16++) {
            iHashCode = (iHashCode * 31) + objArr[i16].hashCode();
        }
        return i14 + iHashCode;
    }

    public void makeImmutable() {
        this.f2455e = false;
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.f2451a == 0) {
            return;
        }
        j jVar = (j) writer;
        if (jVar.fieldOrder() == Writer.FieldOrder.ASCENDING) {
            for (int i10 = 0; i10 < this.f2451a; i10++) {
                b(this.f2452b[i10], this.f2453c[i10], jVar);
            }
            return;
        }
        for (int i11 = this.f2451a - 1; i11 >= 0; i11--) {
            b(this.f2452b[i11], this.f2453c[i11], jVar);
        }
    }

    public g1(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.f2454d = -1;
        this.f2451a = i10;
        this.f2452b = iArr;
        this.f2453c = objArr;
        this.f2455e = z10;
    }
}
