package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.k0;
import androidx.datastore.preferences.protobuf.s.a;
import androidx.datastore.preferences.protobuf.w;
import androidx.datastore.preferences.protobuf.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: FieldSet.java */
/* loaded from: classes.dex */
public final class s<T extends a<T>> {

    /* renamed from: d, reason: collision with root package name */
    public static final s f2530d = new s(0);

    /* renamed from: a, reason: collision with root package name */
    public final c1<T, Object> f2531a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2532b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2533c;

    /* compiled from: FieldSet.java */
    public interface a<T extends a<T>> extends Comparable<T> {
        WireFormat.JavaType getLiteJavaType();

        WireFormat.FieldType getLiteType();

        int getNumber();

        k0.a internalMergeFrom(k0.a aVar, k0 k0Var);

        boolean isPacked();

        boolean isRepeated();
    }

    public s() {
        int i10 = c1.f2407s;
        this.f2531a = new b1(16);
    }

    public static int a(WireFormat.FieldType fieldType, int i10, Object obj) {
        int iComputeTagSize = CodedOutputStream.computeTagSize(i10);
        if (fieldType == WireFormat.FieldType.f2378o) {
            iComputeTagSize *= 2;
        }
        return b(fieldType, obj) + iComputeTagSize;
    }

    public static int b(WireFormat.FieldType fieldType, Object obj) {
        switch (fieldType.ordinal()) {
            case 0:
                return CodedOutputStream.computeDoubleSizeNoTag(((Double) obj).doubleValue());
            case 1:
                return CodedOutputStream.computeFloatSizeNoTag(((Float) obj).floatValue());
            case 2:
                return CodedOutputStream.computeInt64SizeNoTag(((Long) obj).longValue());
            case 3:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) obj).intValue());
            case 5:
                return CodedOutputStream.computeFixed64SizeNoTag(((Long) obj).longValue());
            case 6:
                return CodedOutputStream.computeFixed32SizeNoTag(((Integer) obj).intValue());
            case 7:
                return CodedOutputStream.computeBoolSizeNoTag(((Boolean) obj).booleanValue());
            case 8:
                return obj instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) obj) : CodedOutputStream.computeStringSizeNoTag((String) obj);
            case 9:
                return CodedOutputStream.computeGroupSizeNoTag((k0) obj);
            case 10:
                return obj instanceof x ? CodedOutputStream.computeLazyFieldSizeNoTag((x) obj) : CodedOutputStream.computeMessageSizeNoTag((k0) obj);
            case 11:
                return obj instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) obj) : CodedOutputStream.computeByteArraySizeNoTag((byte[]) obj);
            case 12:
                return CodedOutputStream.computeUInt32SizeNoTag(((Integer) obj).intValue());
            case 13:
                return obj instanceof w.c ? CodedOutputStream.computeEnumSizeNoTag(((w.c) obj).getNumber()) : CodedOutputStream.computeEnumSizeNoTag(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.computeSFixed64SizeNoTag(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.computeSInt32SizeNoTag(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.computeSInt64SizeNoTag(((Long) obj).longValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int c(Map.Entry entry) {
        a aVar = (a) entry.getKey();
        Object value = entry.getValue();
        return (aVar.getLiteJavaType() != WireFormat.JavaType.MESSAGE || aVar.isRepeated() || aVar.isPacked()) ? computeFieldSize(aVar, value) : value instanceof x ? CodedOutputStream.computeLazyFieldMessageSetExtensionSize(((a) entry.getKey()).getNumber(), (x) value) : CodedOutputStream.computeMessageSetExtensionSize(((a) entry.getKey()).getNumber(), (k0) value);
    }

    public static int computeFieldSize(a<?> aVar, Object obj) {
        WireFormat.FieldType liteType = aVar.getLiteType();
        int number = aVar.getNumber();
        if (!aVar.isRepeated()) {
            return a(liteType, number, obj);
        }
        int iA = 0;
        if (!aVar.isPacked()) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                iA += a(liteType, number, it.next());
            }
            return iA;
        }
        Iterator it2 = ((List) obj).iterator();
        while (it2.hasNext()) {
            iA += b(liteType, it2.next());
        }
        return CodedOutputStream.computeRawVarint32Size(iA) + CodedOutputStream.computeTagSize(number) + iA;
    }

    public static <T extends a<T>> boolean e(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            if (key.isRepeated()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((k0) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (!(value instanceof k0)) {
                    if (value instanceof x) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((k0) value).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static <T extends a<T>> s<T> emptySet() {
        return f2530d;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void g(androidx.datastore.preferences.protobuf.WireFormat.FieldType r1, java.lang.Object r2) {
        /*
            java.nio.charset.Charset r0 = androidx.datastore.preferences.protobuf.w.f2545a
            r2.getClass()
            androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = r1.getJavaType()
            int r1 = r1.ordinal()
            switch(r1) {
                case 0: goto L3c;
                case 1: goto L39;
                case 2: goto L36;
                case 3: goto L33;
                case 4: goto L30;
                case 5: goto L2d;
                case 6: goto L23;
                case 7: goto L1a;
                case 8: goto L11;
                default: goto L10;
            }
        L10:
            goto L3f
        L11:
            boolean r1 = r2 instanceof androidx.datastore.preferences.protobuf.k0
            if (r1 != 0) goto L2b
            boolean r1 = r2 instanceof androidx.datastore.preferences.protobuf.x
            if (r1 == 0) goto L3f
            goto L2b
        L1a:
            boolean r1 = r2 instanceof java.lang.Integer
            if (r1 != 0) goto L2b
            boolean r1 = r2 instanceof androidx.datastore.preferences.protobuf.w.c
            if (r1 == 0) goto L3f
            goto L2b
        L23:
            boolean r1 = r2 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r1 != 0) goto L2b
            boolean r1 = r2 instanceof byte[]
            if (r1 == 0) goto L3f
        L2b:
            r1 = 1
            goto L40
        L2d:
            boolean r1 = r2 instanceof java.lang.String
            goto L40
        L30:
            boolean r1 = r2 instanceof java.lang.Boolean
            goto L40
        L33:
            boolean r1 = r2 instanceof java.lang.Double
            goto L40
        L36:
            boolean r1 = r2 instanceof java.lang.Float
            goto L40
        L39:
            boolean r1 = r2 instanceof java.lang.Long
            goto L40
        L3c:
            boolean r1 = r2 instanceof java.lang.Integer
            goto L40
        L3f:
            r1 = 0
        L40:
            if (r1 == 0) goto L43
            return
        L43:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Wrong object type used with protocol message reflection."
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.s.g(androidx.datastore.preferences.protobuf.WireFormat$FieldType, java.lang.Object):void");
    }

    public static void h(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i10, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.f2378o) {
            codedOutputStream.writeGroup(i10, (k0) obj);
            return;
        }
        codedOutputStream.writeTag(i10, fieldType.getWireType());
        switch (fieldType.ordinal()) {
            case 0:
                codedOutputStream.writeDoubleNoTag(((Double) obj).doubleValue());
                break;
            case 1:
                codedOutputStream.writeFloatNoTag(((Float) obj).floatValue());
                break;
            case 2:
                codedOutputStream.writeInt64NoTag(((Long) obj).longValue());
                break;
            case 3:
                codedOutputStream.writeUInt64NoTag(((Long) obj).longValue());
                break;
            case 4:
                codedOutputStream.writeInt32NoTag(((Integer) obj).intValue());
                break;
            case 5:
                codedOutputStream.writeFixed64NoTag(((Long) obj).longValue());
                break;
            case 6:
                codedOutputStream.writeFixed32NoTag(((Integer) obj).intValue());
                break;
            case 7:
                codedOutputStream.writeBoolNoTag(((Boolean) obj).booleanValue());
                break;
            case 8:
                if (!(obj instanceof ByteString)) {
                    codedOutputStream.writeStringNoTag((String) obj);
                    break;
                } else {
                    codedOutputStream.writeBytesNoTag((ByteString) obj);
                    break;
                }
            case 9:
                codedOutputStream.writeGroupNoTag((k0) obj);
                break;
            case 10:
                codedOutputStream.writeMessageNoTag((k0) obj);
                break;
            case 11:
                if (!(obj instanceof ByteString)) {
                    codedOutputStream.writeByteArrayNoTag((byte[]) obj);
                    break;
                } else {
                    codedOutputStream.writeBytesNoTag((ByteString) obj);
                    break;
                }
            case 12:
                codedOutputStream.writeUInt32NoTag(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof w.c)) {
                    codedOutputStream.writeEnumNoTag(((Integer) obj).intValue());
                    break;
                } else {
                    codedOutputStream.writeEnumNoTag(((w.c) obj).getNumber());
                    break;
                }
            case 14:
                codedOutputStream.writeSFixed32NoTag(((Integer) obj).intValue());
                break;
            case 15:
                codedOutputStream.writeSFixed64NoTag(((Long) obj).longValue());
                break;
            case 16:
                codedOutputStream.writeSInt32NoTag(((Integer) obj).intValue());
                break;
            case 17:
                codedOutputStream.writeSInt64NoTag(((Long) obj).longValue());
                break;
        }
    }

    public static <T extends a<T>> s<T> newFieldSet() {
        return new s<>();
    }

    public final boolean d() {
        return this.f2531a.isEmpty();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s) {
            return this.f2531a.equals(((s) obj).f2531a);
        }
        return false;
    }

    public final void f(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof x) {
            value = ((x) value).getValue();
        }
        boolean zIsRepeated = key.isRepeated();
        c1<T, Object> c1Var = this.f2531a;
        if (zIsRepeated) {
            Object field = getField(key);
            if (field == null) {
                field = new ArrayList();
            }
            for (Object obj : (List) value) {
                List list = (List) field;
                if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    byte[] bArr2 = new byte[bArr.length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    obj = bArr2;
                }
                list.add(obj);
            }
            c1Var.put((c1<T, Object>) key, (T) field);
            return;
        }
        if (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE) {
            if (value instanceof byte[]) {
                byte[] bArr3 = (byte[]) value;
                byte[] bArr4 = new byte[bArr3.length];
                System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
                value = bArr4;
            }
            c1Var.put((c1<T, Object>) key, (T) value);
            return;
        }
        Object field2 = getField(key);
        if (field2 != null) {
            c1Var.put((c1<T, Object>) key, (T) ((GeneratedMessageLite.a) key.internalMergeFrom(((k0) field2).toBuilder(), (k0) value)).m4build());
            return;
        }
        if (value instanceof byte[]) {
            byte[] bArr5 = (byte[]) value;
            byte[] bArr6 = new byte[bArr5.length];
            System.arraycopy(bArr5, 0, bArr6, 0, bArr5.length);
            value = bArr6;
        }
        c1Var.put((c1<T, Object>) key, (T) value);
    }

    public Object getField(T t10) {
        Object obj = this.f2531a.get(t10);
        return obj instanceof x ? ((x) obj).getValue() : obj;
    }

    public int getMessageSetSerializedSize() {
        c1<T, Object> c1Var;
        int i10 = 0;
        int iC = 0;
        while (true) {
            c1Var = this.f2531a;
            if (i10 >= c1Var.getNumArrayEntries()) {
                break;
            }
            iC += c(c1Var.getArrayEntryAt(i10));
            i10++;
        }
        Iterator it = c1Var.getOverflowEntries().iterator();
        while (it.hasNext()) {
            iC += c((Map.Entry) it.next());
        }
        return iC;
    }

    public int getSerializedSize() {
        c1<T, Object> c1Var;
        int i10 = 0;
        int iComputeFieldSize = 0;
        while (true) {
            c1Var = this.f2531a;
            if (i10 >= c1Var.getNumArrayEntries()) {
                break;
            }
            Map.Entry<K, Object> arrayEntryAt = c1Var.getArrayEntryAt(i10);
            iComputeFieldSize += computeFieldSize((a) arrayEntryAt.getKey(), arrayEntryAt.getValue());
            i10++;
        }
        Iterator it = c1Var.getOverflowEntries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            iComputeFieldSize += computeFieldSize((a) entry.getKey(), entry.getValue());
        }
        return iComputeFieldSize;
    }

    public int hashCode() {
        return this.f2531a.hashCode();
    }

    public boolean isImmutable() {
        return this.f2532b;
    }

    public boolean isInitialized() {
        int i10 = 0;
        while (true) {
            c1<T, Object> c1Var = this.f2531a;
            if (i10 >= c1Var.getNumArrayEntries()) {
                Iterator it = c1Var.getOverflowEntries().iterator();
                while (it.hasNext()) {
                    if (!e((Map.Entry) it.next())) {
                        return false;
                    }
                }
                return true;
            }
            if (!e(c1Var.getArrayEntryAt(i10))) {
                return false;
            }
            i10++;
        }
    }

    public Iterator<Map.Entry<T, Object>> iterator() {
        boolean z10 = this.f2533c;
        c1<T, Object> c1Var = this.f2531a;
        return z10 ? new x.b(c1Var.entrySet().iterator()) : c1Var.entrySet().iterator();
    }

    public void makeImmutable() {
        if (this.f2532b) {
            return;
        }
        this.f2531a.makeImmutable();
        this.f2532b = true;
    }

    public void mergeFrom(s<T> sVar) {
        c1<T, Object> c1Var;
        int i10 = 0;
        while (true) {
            int numArrayEntries = sVar.f2531a.getNumArrayEntries();
            c1Var = sVar.f2531a;
            if (i10 >= numArrayEntries) {
                break;
            }
            f(c1Var.getArrayEntryAt(i10));
            i10++;
        }
        Iterator it = c1Var.getOverflowEntries().iterator();
        while (it.hasNext()) {
            f((Map.Entry) it.next());
        }
    }

    public void setField(T t10, Object obj) {
        if (!t10.isRepeated()) {
            g(t10.getLiteType(), obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                g(t10.getLiteType(), it.next());
            }
            obj = arrayList;
        }
        if (obj instanceof x) {
            this.f2533c = true;
        }
        this.f2531a.put((c1<T, Object>) t10, (T) obj);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public s<T> m8clone() {
        c1<T, Object> c1Var;
        s<T> sVarNewFieldSet = newFieldSet();
        int i10 = 0;
        while (true) {
            c1Var = this.f2531a;
            if (i10 >= c1Var.getNumArrayEntries()) {
                break;
            }
            Map.Entry<K, Object> arrayEntryAt = c1Var.getArrayEntryAt(i10);
            sVarNewFieldSet.setField((a) arrayEntryAt.getKey(), arrayEntryAt.getValue());
            i10++;
        }
        Iterator it = c1Var.getOverflowEntries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            sVarNewFieldSet.setField((a) entry.getKey(), entry.getValue());
        }
        sVarNewFieldSet.f2533c = this.f2533c;
        return sVarNewFieldSet;
    }

    public s(int i10) {
        int i11 = c1.f2407s;
        this.f2531a = new b1(0);
        makeImmutable();
        makeImmutable();
    }
}
