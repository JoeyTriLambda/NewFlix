package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: SchemaUtil.java */
/* loaded from: classes.dex */
public final class a1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Class<?> f2397a;

    /* renamed from: b, reason: collision with root package name */
    public static final f1<?, ?> f2398b;

    /* renamed from: c, reason: collision with root package name */
    public static final f1<?, ?> f2399c;

    /* renamed from: d, reason: collision with root package name */
    public static final h1 f2400d;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            cls = null;
        }
        f2397a = cls;
        f2398b = A(false);
        f2399c = A(true);
        f2400d = new h1();
    }

    public static f1<?, ?> A(boolean z10) {
        Class<?> cls;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (f1) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z10));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static boolean B(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int a(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return CodedOutputStream.computeBoolSize(i10, true) * size;
    }

    public static int b(List<?> list) {
        return list.size();
    }

    public static int c(int i10, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeTagSize = CodedOutputStream.computeTagSize(i10) * size;
        for (int i11 = 0; i11 < list.size(); i11++) {
            iComputeTagSize += CodedOutputStream.computeBytesSizeNoTag(list.get(i11));
        }
        return iComputeTagSize;
    }

    public static int d(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CodedOutputStream.computeTagSize(i10) * size) + e(list);
    }

    public static int e(List<Integer> list) {
        int iComputeEnumSizeNoTag;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v) {
            v vVar = (v) list;
            iComputeEnumSizeNoTag = 0;
            while (i10 < size) {
                iComputeEnumSizeNoTag += CodedOutputStream.computeEnumSizeNoTag(vVar.getInt(i10));
                i10++;
            }
        } else {
            iComputeEnumSizeNoTag = 0;
            while (i10 < size) {
                iComputeEnumSizeNoTag += CodedOutputStream.computeEnumSizeNoTag(list.get(i10).intValue());
                i10++;
            }
        }
        return iComputeEnumSizeNoTag;
    }

    public static int f(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return CodedOutputStream.computeFixed32Size(i10, 0) * size;
    }

    public static int g(List<?> list) {
        return list.size() * 4;
    }

    public static int h(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return CodedOutputStream.computeFixed64Size(i10, 0L) * size;
    }

    public static int i(List<?> list) {
        return list.size() * 8;
    }

    public static int j(int i10, List<k0> list, y0 y0Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iA = 0;
        for (int i11 = 0; i11 < size; i11++) {
            iA += CodedOutputStream.a(i10, list.get(i11), y0Var);
        }
        return iA;
    }

    public static int k(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CodedOutputStream.computeTagSize(i10) * size) + l(list);
    }

    public static int l(List<Integer> list) {
        int iComputeInt32SizeNoTag;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v) {
            v vVar = (v) list;
            iComputeInt32SizeNoTag = 0;
            while (i10 < size) {
                iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(vVar.getInt(i10));
                i10++;
            }
        } else {
            iComputeInt32SizeNoTag = 0;
            while (i10 < size) {
                iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(list.get(i10).intValue());
                i10++;
            }
        }
        return iComputeInt32SizeNoTag;
    }

    public static int m(int i10, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (CodedOutputStream.computeTagSize(i10) * list.size()) + n(list);
    }

    public static int n(List<Long> list) {
        int iComputeInt64SizeNoTag;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof c0) {
            c0 c0Var = (c0) list;
            iComputeInt64SizeNoTag = 0;
            while (i10 < size) {
                iComputeInt64SizeNoTag += CodedOutputStream.computeInt64SizeNoTag(c0Var.getLong(i10));
                i10++;
            }
        } else {
            iComputeInt64SizeNoTag = 0;
            while (i10 < size) {
                iComputeInt64SizeNoTag += CodedOutputStream.computeInt64SizeNoTag(list.get(i10).longValue());
                i10++;
            }
        }
        return iComputeInt64SizeNoTag;
    }

    public static int o(int i10, Object obj, y0 y0Var) {
        if (obj instanceof y) {
            return CodedOutputStream.computeLazyFieldSize(i10, (y) obj);
        }
        int iComputeTagSize = CodedOutputStream.computeTagSize(i10);
        int iB = ((a) ((k0) obj)).b(y0Var);
        return CodedOutputStream.computeUInt32SizeNoTag(iB) + iB + iComputeTagSize;
    }

    public static int p(int i10, List<?> list, y0 y0Var) {
        int iComputeUInt32SizeNoTag;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeTagSize = CodedOutputStream.computeTagSize(i10) * size;
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            if (obj instanceof y) {
                iComputeUInt32SizeNoTag = CodedOutputStream.computeLazyFieldSizeNoTag((y) obj);
            } else {
                int iB = ((a) ((k0) obj)).b(y0Var);
                iComputeUInt32SizeNoTag = iB + CodedOutputStream.computeUInt32SizeNoTag(iB);
            }
            iComputeTagSize += iComputeUInt32SizeNoTag;
        }
        return iComputeTagSize;
    }

    public static f1<?, ?> proto2UnknownFieldSetSchema() {
        return f2398b;
    }

    public static f1<?, ?> proto3UnknownFieldSetSchema() {
        return f2399c;
    }

    public static int q(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CodedOutputStream.computeTagSize(i10) * size) + r(list);
    }

    public static int r(List<Integer> list) {
        int iComputeSInt32SizeNoTag;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v) {
            v vVar = (v) list;
            iComputeSInt32SizeNoTag = 0;
            while (i10 < size) {
                iComputeSInt32SizeNoTag += CodedOutputStream.computeSInt32SizeNoTag(vVar.getInt(i10));
                i10++;
            }
        } else {
            iComputeSInt32SizeNoTag = 0;
            while (i10 < size) {
                iComputeSInt32SizeNoTag += CodedOutputStream.computeSInt32SizeNoTag(list.get(i10).intValue());
                i10++;
            }
        }
        return iComputeSInt32SizeNoTag;
    }

    public static void requireGeneratedMessage(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = f2397a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static int s(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CodedOutputStream.computeTagSize(i10) * size) + t(list);
    }

    public static int t(List<Long> list) {
        int iComputeSInt64SizeNoTag;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof c0) {
            c0 c0Var = (c0) list;
            iComputeSInt64SizeNoTag = 0;
            while (i10 < size) {
                iComputeSInt64SizeNoTag += CodedOutputStream.computeSInt64SizeNoTag(c0Var.getLong(i10));
                i10++;
            }
        } else {
            iComputeSInt64SizeNoTag = 0;
            while (i10 < size) {
                iComputeSInt64SizeNoTag += CodedOutputStream.computeSInt64SizeNoTag(list.get(i10).longValue());
                i10++;
            }
        }
        return iComputeSInt64SizeNoTag;
    }

    public static int u(int i10, List<?> list) {
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        int iComputeTagSize = CodedOutputStream.computeTagSize(i10) * size;
        if (list instanceof a0) {
            a0 a0Var = (a0) list;
            while (i11 < size) {
                Object raw = a0Var.getRaw(i11);
                iComputeTagSize = (raw instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) raw) : CodedOutputStream.computeStringSizeNoTag((String) raw)) + iComputeTagSize;
                i11++;
            }
        } else {
            while (i11 < size) {
                Object obj = list.get(i11);
                iComputeTagSize = (obj instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) obj) : CodedOutputStream.computeStringSizeNoTag((String) obj)) + iComputeTagSize;
                i11++;
            }
        }
        return iComputeTagSize;
    }

    public static f1<?, ?> unknownFieldSetLiteSchema() {
        return f2400d;
    }

    public static int v(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CodedOutputStream.computeTagSize(i10) * size) + w(list);
    }

    public static int w(List<Integer> list) {
        int iComputeUInt32SizeNoTag;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v) {
            v vVar = (v) list;
            iComputeUInt32SizeNoTag = 0;
            while (i10 < size) {
                iComputeUInt32SizeNoTag += CodedOutputStream.computeUInt32SizeNoTag(vVar.getInt(i10));
                i10++;
            }
        } else {
            iComputeUInt32SizeNoTag = 0;
            while (i10 < size) {
                iComputeUInt32SizeNoTag += CodedOutputStream.computeUInt32SizeNoTag(list.get(i10).intValue());
                i10++;
            }
        }
        return iComputeUInt32SizeNoTag;
    }

    public static void writeBoolList(int i10, List<Boolean> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ((j) writer).writeBoolList(i10, list, z10);
    }

    public static void writeBytesList(int i10, List<ByteString> list, Writer writer) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ((j) writer).writeBytesList(i10, list);
    }

    public static void writeDoubleList(int i10, List<Double> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ((j) writer).writeDoubleList(i10, list, z10);
    }

    public static void writeEnumList(int i10, List<Integer> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ((j) writer).writeEnumList(i10, list, z10);
    }

    public static void writeFixed32List(int i10, List<Integer> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ((j) writer).writeFixed32List(i10, list, z10);
    }

    public static void writeFixed64List(int i10, List<Long> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ((j) writer).writeFixed64List(i10, list, z10);
    }

    public static void writeFloatList(int i10, List<Float> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ((j) writer).writeFloatList(i10, list, z10);
    }

    public static void writeGroupList(int i10, List<?> list, Writer writer, y0 y0Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ((j) writer).writeGroupList(i10, list, y0Var);
    }

    public static void writeInt32List(int i10, List<Integer> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ((j) writer).writeInt32List(i10, list, z10);
    }

    public static void writeInt64List(int i10, List<Long> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ((j) writer).writeInt64List(i10, list, z10);
    }

    public static void writeMessageList(int i10, List<?> list, Writer writer, y0 y0Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ((j) writer).writeMessageList(i10, list, y0Var);
    }

    public static void writeSFixed32List(int i10, List<Integer> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ((j) writer).writeSFixed32List(i10, list, z10);
    }

    public static void writeSFixed64List(int i10, List<Long> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ((j) writer).writeSFixed64List(i10, list, z10);
    }

    public static void writeSInt32List(int i10, List<Integer> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ((j) writer).writeSInt32List(i10, list, z10);
    }

    public static void writeSInt64List(int i10, List<Long> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ((j) writer).writeSInt64List(i10, list, z10);
    }

    public static void writeStringList(int i10, List<String> list, Writer writer) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ((j) writer).writeStringList(i10, list);
    }

    public static void writeUInt32List(int i10, List<Integer> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ((j) writer).writeUInt32List(i10, list, z10);
    }

    public static void writeUInt64List(int i10, List<Long> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        ((j) writer).writeUInt64List(i10, list, z10);
    }

    public static int x(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CodedOutputStream.computeTagSize(i10) * size) + y(list);
    }

    public static int y(List<Long> list) {
        int iComputeUInt64SizeNoTag;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof c0) {
            c0 c0Var = (c0) list;
            iComputeUInt64SizeNoTag = 0;
            while (i10 < size) {
                iComputeUInt64SizeNoTag += CodedOutputStream.computeUInt64SizeNoTag(c0Var.getLong(i10));
                i10++;
            }
        } else {
            iComputeUInt64SizeNoTag = 0;
            while (i10 < size) {
                iComputeUInt64SizeNoTag += CodedOutputStream.computeUInt64SizeNoTag(list.get(i10).longValue());
                i10++;
            }
        }
        return iComputeUInt64SizeNoTag;
    }

    public static <UT, UB> UB z(int i10, List<Integer> list, w.d dVar, UB ub2, f1<UT, UB> f1Var) {
        if (dVar == null) {
            return ub2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                int iIntValue = list.get(i12).intValue();
                if (dVar.isInRange(iIntValue)) {
                    if (i12 != i11) {
                        list.set(i11, Integer.valueOf(iIntValue));
                    }
                    i11++;
                } else {
                    if (ub2 == null) {
                        ub2 = (UB) f1Var.m();
                    }
                    f1Var.e(iIntValue, i10, ub2);
                }
            }
            if (i11 != size) {
                list.subList(i11, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = it.next().intValue();
                if (!dVar.isInRange(iIntValue2)) {
                    if (ub2 == null) {
                        ub2 = (UB) f1Var.m();
                    }
                    f1Var.e(iIntValue2, i10, ub2);
                    it.remove();
                }
            }
        }
        return ub2;
    }
}
