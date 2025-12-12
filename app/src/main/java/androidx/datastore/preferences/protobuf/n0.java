package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.e0;
import androidx.datastore.preferences.protobuf.w;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: MessageSchema.java */
/* loaded from: classes.dex */
public final class n0<T> implements y0<T> {

    /* renamed from: r, reason: collision with root package name */
    public static final int[] f2503r = new int[0];

    /* renamed from: s, reason: collision with root package name */
    public static final Unsafe f2504s = j1.o();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f2505a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f2506b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2507c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2508d;

    /* renamed from: e, reason: collision with root package name */
    public final k0 f2509e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f2510f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f2511g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f2512h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f2513i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f2514j;

    /* renamed from: k, reason: collision with root package name */
    public final int f2515k;

    /* renamed from: l, reason: collision with root package name */
    public final int f2516l;

    /* renamed from: m, reason: collision with root package name */
    public final p0 f2517m;

    /* renamed from: n, reason: collision with root package name */
    public final b0 f2518n;

    /* renamed from: o, reason: collision with root package name */
    public final f1<?, ?> f2519o;

    /* renamed from: p, reason: collision with root package name */
    public final o<?> f2520p;

    /* renamed from: q, reason: collision with root package name */
    public final f0 f2521q;

    public n0(int[] iArr, Object[] objArr, int i10, int i11, k0 k0Var, boolean z10, boolean z11, int[] iArr2, int i12, int i13, p0 p0Var, b0 b0Var, f1<?, ?> f1Var, o<?> oVar, f0 f0Var) {
        this.f2505a = iArr;
        this.f2506b = objArr;
        this.f2507c = i10;
        this.f2508d = i11;
        this.f2511g = k0Var instanceof GeneratedMessageLite;
        this.f2512h = z10;
        this.f2510f = oVar != null && oVar.e(k0Var);
        this.f2513i = z11;
        this.f2514j = iArr2;
        this.f2515k = i12;
        this.f2516l = i13;
        this.f2517m = p0Var;
        this.f2518n = b0Var;
        this.f2519o = f1Var;
        this.f2520p = oVar;
        this.f2509e = k0Var;
        this.f2521q = f0Var;
    }

    public static void D(int i10, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            ((j) writer).writeString(i10, (String) obj);
        } else {
            ((j) writer).writeBytes(i10, (ByteString) obj);
        }
    }

    public static List j(long j10, Object obj) {
        return (List) j1.n(obj, j10);
    }

    public static n0 n(i0 i0Var, p0 p0Var, b0 b0Var, f1 f1Var, o oVar, f0 f0Var) {
        if (i0Var instanceof w0) {
            return o((w0) i0Var, p0Var, b0Var, f1Var, oVar, f0Var);
        }
        d1 d1Var = (d1) i0Var;
        boolean z10 = d1Var.getSyntax() == ProtoSyntax.PROTO3;
        r[] fields = d1Var.getFields();
        if (fields.length != 0) {
            r rVar = fields[0];
            throw null;
        }
        int length = fields.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        if (fields.length > 0) {
            r rVar2 = fields[0];
            throw null;
        }
        int[] checkInitialized = d1Var.getCheckInitialized();
        int[] iArr2 = f2503r;
        if (checkInitialized == null) {
            checkInitialized = iArr2;
        }
        if (fields.length > 0) {
            r rVar3 = fields[0];
            throw null;
        }
        int[] iArr3 = new int[checkInitialized.length + 0 + 0];
        System.arraycopy(checkInitialized, 0, iArr3, 0, checkInitialized.length);
        System.arraycopy(iArr2, 0, iArr3, checkInitialized.length, 0);
        System.arraycopy(iArr2, 0, iArr3, checkInitialized.length + 0, 0);
        return new n0(iArr, objArr, 0, 0, d1Var.getDefaultInstance(), z10, true, iArr3, checkInitialized.length, checkInitialized.length + 0, p0Var, b0Var, f1Var, oVar, f0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0392  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> androidx.datastore.preferences.protobuf.n0<T> o(androidx.datastore.preferences.protobuf.w0 r35, androidx.datastore.preferences.protobuf.p0 r36, androidx.datastore.preferences.protobuf.b0 r37, androidx.datastore.preferences.protobuf.f1<?, ?> r38, androidx.datastore.preferences.protobuf.o<?> r39, androidx.datastore.preferences.protobuf.f0 r40) {
        /*
            Method dump skipped, instructions count: 1029
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.o(androidx.datastore.preferences.protobuf.w0, androidx.datastore.preferences.protobuf.p0, androidx.datastore.preferences.protobuf.b0, androidx.datastore.preferences.protobuf.f1, androidx.datastore.preferences.protobuf.o, androidx.datastore.preferences.protobuf.f0):androidx.datastore.preferences.protobuf.n0");
    }

    public static long p(int i10) {
        return i10 & 1048575;
    }

    public static int q(long j10, Object obj) {
        return ((Integer) j1.n(obj, j10)).intValue();
    }

    public static long r(long j10, Object obj) {
        return ((Long) j1.n(obj, j10)).longValue();
    }

    public static Field x(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder sbV = ac.c.v("Field ", str, " for ");
            sbV.append(cls.getName());
            sbV.append(" not found. Known fields are ");
            sbV.append(Arrays.toString(declaredFields));
            throw new RuntimeException(sbV.toString());
        }
    }

    public final int A(int i10) {
        return this.f2505a[i10 + 1];
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void B(T r21, androidx.datastore.preferences.protobuf.Writer r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.B(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    public final <K, V> void C(Writer writer, int i10, Object obj, int i11) throws IOException {
        if (obj != null) {
            Object objD = d(i11);
            f0 f0Var = this.f2521q;
            ((j) writer).writeMap(i10, f0Var.forMapMetadata(objD), f0Var.forMapData(obj));
        }
    }

    public final boolean a(int i10, Object obj, Object obj2) {
        return h(i10, obj) == h(i10, obj2);
    }

    public final <UT, UB> UB b(Object obj, int i10, UB ub2, f1<UT, UB> f1Var) {
        w.d dVarC;
        int i11 = this.f2505a[i10];
        Object objN = j1.n(obj, A(i10) & 1048575);
        if (objN == null || (dVarC = c(i10)) == null) {
            return ub2;
        }
        f0 f0Var = this.f2521q;
        Map<?, ?> mapForMutableMapData = f0Var.forMutableMapData(objN);
        e0.a<?, ?> aVarForMapMetadata = f0Var.forMapMetadata(d(i10));
        Iterator<Map.Entry<?, ?>> it = mapForMutableMapData.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<?, ?> next = it.next();
            if (!dVarC.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub2 == null) {
                    ub2 = (UB) f1Var.m();
                }
                ByteString.f fVar = new ByteString.f(e0.a(aVarForMapMetadata, next.getKey(), next.getValue()));
                CodedOutputStream codedOutput = fVar.getCodedOutput();
                try {
                    Object key = next.getKey();
                    Object value = next.getValue();
                    s.h(codedOutput, aVarForMapMetadata.f2443a, 1, key);
                    s.h(codedOutput, aVarForMapMetadata.f2445c, 2, value);
                    f1Var.d(ub2, i11, fVar.build());
                    it.remove();
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            }
        }
        return ub2;
    }

    public final w.d c(int i10) {
        return (w.d) this.f2506b[((i10 / 3) * 2) + 1];
    }

    public final Object d(int i10) {
        return this.f2506b[(i10 / 3) * 2];
    }

    public final y0 e(int i10) {
        int i11 = (i10 / 3) * 2;
        Object[] objArr = this.f2506b;
        y0 y0Var = (y0) objArr[i11];
        if (y0Var != null) {
            return y0Var;
        }
        y0<T> y0VarSchemaFor = u0.getInstance().schemaFor((Class) objArr[i11 + 1]);
        objArr[i11] = y0VarSchemaFor;
        return y0VarSchemaFor;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01c8  */
    @Override // androidx.datastore.preferences.protobuf.y0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(T r11, T r12) {
        /*
            Method dump skipped, instructions count: 644
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.equals(java.lang.Object, java.lang.Object):boolean");
    }

    public final int f(T t10) {
        int i10;
        int i11;
        int i12;
        int i13;
        int iComputeDoubleSize;
        int iComputeBoolSize;
        int iComputeBytesSize;
        int iComputeSFixed32Size;
        int i14;
        int iComputeTagSize;
        int iComputeUInt32SizeNoTag;
        int i15 = -1;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            int[] iArr = this.f2505a;
            if (i16 >= iArr.length) {
                f1<?, ?> f1Var = this.f2519o;
                int iH = f1Var.h(f1Var.g(t10)) + i17;
                return this.f2510f ? iH + this.f2520p.c(t10).getSerializedSize() : iH;
            }
            int iA = A(i16);
            int i19 = iArr[i16];
            int i20 = (267386880 & iA) >>> 20;
            boolean z10 = this.f2513i;
            Unsafe unsafe = f2504s;
            if (i20 <= 17) {
                i11 = iArr[i16 + 2];
                int i21 = i11 & 1048575;
                i12 = 1 << (i11 >>> 20);
                i10 = i16;
                if (i21 != i15) {
                    i18 = unsafe.getInt(t10, i21);
                    i15 = i21;
                }
            } else {
                i10 = i16;
                i11 = (!z10 || i20 < FieldType.f2337m.id() || i20 > FieldType.f2338n.id()) ? 0 : iArr[i10 + 2] & 1048575;
                i12 = 0;
            }
            long j10 = iA & 1048575;
            switch (i20) {
                case 0:
                    i13 = i10;
                    if ((i18 & i12) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(i19, 0.0d);
                        i17 += iComputeDoubleSize;
                        break;
                    }
                case 1:
                    i13 = i10;
                    if ((i18 & i12) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(i19, 0.0f);
                        i17 += iComputeDoubleSize;
                        break;
                    }
                case 2:
                    i13 = i10;
                    if ((i18 & i12) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(i19, unsafe.getLong(t10, j10));
                        i17 += iComputeDoubleSize;
                        break;
                    }
                case 3:
                    i13 = i10;
                    if ((i18 & i12) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(i19, unsafe.getLong(t10, j10));
                        i17 += iComputeDoubleSize;
                        break;
                    }
                case 4:
                    i13 = i10;
                    if ((i18 & i12) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(i19, unsafe.getInt(t10, j10));
                        i17 += iComputeDoubleSize;
                        break;
                    }
                case 5:
                    i13 = i10;
                    if ((i18 & i12) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(i19, 0L);
                        i17 += iComputeDoubleSize;
                        break;
                    }
                case 6:
                    i13 = i10;
                    if ((i18 & i12) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(i19, 0);
                        i17 += iComputeDoubleSize;
                        break;
                    }
                    break;
                case 7:
                    i13 = i10;
                    if ((i18 & i12) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(i19, true);
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 8:
                    i13 = i10;
                    if ((i18 & i12) != 0) {
                        Object object = unsafe.getObject(t10, j10);
                        iComputeBytesSize = object instanceof ByteString ? CodedOutputStream.computeBytesSize(i19, (ByteString) object) : CodedOutputStream.computeStringSize(i19, (String) object);
                        i17 = iComputeBytesSize + i17;
                    }
                    break;
                case 9:
                    i13 = i10;
                    if ((i18 & i12) != 0) {
                        iComputeBoolSize = a1.o(i19, unsafe.getObject(t10, j10), e(i13));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 10:
                    i13 = i10;
                    if ((i18 & i12) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(i19, (ByteString) unsafe.getObject(t10, j10));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 11:
                    i13 = i10;
                    if ((i18 & i12) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(i19, unsafe.getInt(t10, j10));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 12:
                    i13 = i10;
                    if ((i18 & i12) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(i19, unsafe.getInt(t10, j10));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 13:
                    i13 = i10;
                    if ((i18 & i12) != 0) {
                        iComputeSFixed32Size = CodedOutputStream.computeSFixed32Size(i19, 0);
                        i17 += iComputeSFixed32Size;
                    }
                    break;
                case 14:
                    i13 = i10;
                    if ((i18 & i12) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(i19, 0L);
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 15:
                    i13 = i10;
                    if ((i18 & i12) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(i19, unsafe.getInt(t10, j10));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 16:
                    i13 = i10;
                    if ((i18 & i12) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(i19, unsafe.getLong(t10, j10));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 17:
                    i13 = i10;
                    if ((i18 & i12) != 0) {
                        iComputeBoolSize = CodedOutputStream.a(i19, (k0) unsafe.getObject(t10, j10), e(i13));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 18:
                    i13 = i10;
                    iComputeBoolSize = a1.h(i19, (List) unsafe.getObject(t10, j10));
                    i17 += iComputeBoolSize;
                    break;
                case 19:
                    i13 = i10;
                    iComputeBoolSize = a1.f(i19, (List) unsafe.getObject(t10, j10));
                    i17 += iComputeBoolSize;
                    break;
                case 20:
                    i13 = i10;
                    iComputeBoolSize = a1.m(i19, (List) unsafe.getObject(t10, j10));
                    i17 += iComputeBoolSize;
                    break;
                case 21:
                    i13 = i10;
                    iComputeBoolSize = a1.x(i19, (List) unsafe.getObject(t10, j10));
                    i17 += iComputeBoolSize;
                    break;
                case 22:
                    i13 = i10;
                    iComputeBoolSize = a1.k(i19, (List) unsafe.getObject(t10, j10));
                    i17 += iComputeBoolSize;
                    break;
                case 23:
                    i13 = i10;
                    iComputeBoolSize = a1.h(i19, (List) unsafe.getObject(t10, j10));
                    i17 += iComputeBoolSize;
                    break;
                case 24:
                    i13 = i10;
                    iComputeBoolSize = a1.f(i19, (List) unsafe.getObject(t10, j10));
                    i17 += iComputeBoolSize;
                    break;
                case 25:
                    i13 = i10;
                    iComputeBoolSize = a1.a(i19, (List) unsafe.getObject(t10, j10));
                    i17 += iComputeBoolSize;
                    break;
                case 26:
                    i13 = i10;
                    iComputeBoolSize = a1.u(i19, (List) unsafe.getObject(t10, j10));
                    i17 += iComputeBoolSize;
                    break;
                case 27:
                    i13 = i10;
                    iComputeBoolSize = a1.p(i19, (List) unsafe.getObject(t10, j10), e(i13));
                    i17 += iComputeBoolSize;
                    break;
                case 28:
                    i13 = i10;
                    iComputeBoolSize = a1.c(i19, (List) unsafe.getObject(t10, j10));
                    i17 += iComputeBoolSize;
                    break;
                case 29:
                    i13 = i10;
                    iComputeBoolSize = a1.v(i19, (List) unsafe.getObject(t10, j10));
                    i17 += iComputeBoolSize;
                    break;
                case 30:
                    i13 = i10;
                    iComputeBoolSize = a1.d(i19, (List) unsafe.getObject(t10, j10));
                    i17 += iComputeBoolSize;
                    break;
                case 31:
                    i13 = i10;
                    iComputeBoolSize = a1.f(i19, (List) unsafe.getObject(t10, j10));
                    i17 += iComputeBoolSize;
                    break;
                case 32:
                    i13 = i10;
                    iComputeBoolSize = a1.h(i19, (List) unsafe.getObject(t10, j10));
                    i17 += iComputeBoolSize;
                    break;
                case 33:
                    i13 = i10;
                    iComputeBoolSize = a1.q(i19, (List) unsafe.getObject(t10, j10));
                    i17 += iComputeBoolSize;
                    break;
                case 34:
                    i13 = i10;
                    iComputeBoolSize = a1.s(i19, (List) unsafe.getObject(t10, j10));
                    i17 += iComputeBoolSize;
                    break;
                case 35:
                    i13 = i10;
                    i14 = a1.i((List) unsafe.getObject(t10, j10));
                    if (i14 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i11, i14);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i19);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i14);
                        i17 = iComputeUInt32SizeNoTag + iComputeTagSize + i14 + i17;
                    }
                    break;
                case 36:
                    i13 = i10;
                    i14 = a1.g((List) unsafe.getObject(t10, j10));
                    if (i14 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i11, i14);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i19);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i14);
                        i17 = iComputeUInt32SizeNoTag + iComputeTagSize + i14 + i17;
                    }
                    break;
                case 37:
                    i13 = i10;
                    i14 = a1.n((List) unsafe.getObject(t10, j10));
                    if (i14 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i11, i14);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i19);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i14);
                        i17 = iComputeUInt32SizeNoTag + iComputeTagSize + i14 + i17;
                    }
                    break;
                case 38:
                    i13 = i10;
                    i14 = a1.y((List) unsafe.getObject(t10, j10));
                    if (i14 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i11, i14);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i19);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i14);
                        i17 = iComputeUInt32SizeNoTag + iComputeTagSize + i14 + i17;
                    }
                    break;
                case 39:
                    i13 = i10;
                    i14 = a1.l((List) unsafe.getObject(t10, j10));
                    if (i14 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i11, i14);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i19);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i14);
                        i17 = iComputeUInt32SizeNoTag + iComputeTagSize + i14 + i17;
                    }
                    break;
                case 40:
                    i13 = i10;
                    i14 = a1.i((List) unsafe.getObject(t10, j10));
                    if (i14 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i11, i14);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i19);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i14);
                        i17 = iComputeUInt32SizeNoTag + iComputeTagSize + i14 + i17;
                    }
                    break;
                case 41:
                    i13 = i10;
                    i14 = a1.g((List) unsafe.getObject(t10, j10));
                    if (i14 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i11, i14);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i19);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i14);
                        i17 = iComputeUInt32SizeNoTag + iComputeTagSize + i14 + i17;
                    }
                    break;
                case 42:
                    i13 = i10;
                    i14 = a1.b((List) unsafe.getObject(t10, j10));
                    if (i14 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i11, i14);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i19);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i14);
                        i17 = iComputeUInt32SizeNoTag + iComputeTagSize + i14 + i17;
                    }
                    break;
                case 43:
                    i13 = i10;
                    i14 = a1.w((List) unsafe.getObject(t10, j10));
                    if (i14 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i11, i14);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i19);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i14);
                        i17 = iComputeUInt32SizeNoTag + iComputeTagSize + i14 + i17;
                    }
                    break;
                case 44:
                    i13 = i10;
                    i14 = a1.e((List) unsafe.getObject(t10, j10));
                    if (i14 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i11, i14);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i19);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i14);
                        i17 = iComputeUInt32SizeNoTag + iComputeTagSize + i14 + i17;
                    }
                    break;
                case 45:
                    i13 = i10;
                    i14 = a1.g((List) unsafe.getObject(t10, j10));
                    if (i14 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i11, i14);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i19);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i14);
                        i17 = iComputeUInt32SizeNoTag + iComputeTagSize + i14 + i17;
                    }
                    break;
                case 46:
                    i13 = i10;
                    i14 = a1.i((List) unsafe.getObject(t10, j10));
                    if (i14 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i11, i14);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i19);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i14);
                        i17 = iComputeUInt32SizeNoTag + iComputeTagSize + i14 + i17;
                    }
                    break;
                case 47:
                    i13 = i10;
                    i14 = a1.r((List) unsafe.getObject(t10, j10));
                    if (i14 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i11, i14);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i19);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i14);
                        i17 = iComputeUInt32SizeNoTag + iComputeTagSize + i14 + i17;
                    }
                    break;
                case 48:
                    i13 = i10;
                    i14 = a1.t((List) unsafe.getObject(t10, j10));
                    if (i14 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i11, i14);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i19);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i14);
                        i17 = iComputeUInt32SizeNoTag + iComputeTagSize + i14 + i17;
                    }
                    break;
                case 49:
                    i13 = i10;
                    iComputeBoolSize = a1.j(i19, (List) unsafe.getObject(t10, j10), e(i13));
                    i17 += iComputeBoolSize;
                    break;
                case 50:
                    i13 = i10;
                    iComputeBoolSize = this.f2521q.getSerializedSize(i19, unsafe.getObject(t10, j10), d(i13));
                    i17 += iComputeBoolSize;
                    break;
                case 51:
                    i13 = i10;
                    if (i(i19, i13, t10)) {
                        iComputeBoolSize = CodedOutputStream.computeDoubleSize(i19, 0.0d);
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 52:
                    i13 = i10;
                    if (i(i19, i13, t10)) {
                        iComputeBoolSize = CodedOutputStream.computeFloatSize(i19, 0.0f);
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 53:
                    i13 = i10;
                    if (i(i19, i13, t10)) {
                        iComputeBoolSize = CodedOutputStream.computeInt64Size(i19, r(j10, t10));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 54:
                    i13 = i10;
                    if (i(i19, i13, t10)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt64Size(i19, r(j10, t10));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 55:
                    i13 = i10;
                    if (i(i19, i13, t10)) {
                        iComputeBoolSize = CodedOutputStream.computeInt32Size(i19, q(j10, t10));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 56:
                    i13 = i10;
                    if (i(i19, i13, t10)) {
                        iComputeBoolSize = CodedOutputStream.computeFixed64Size(i19, 0L);
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 57:
                    i13 = i10;
                    if (i(i19, i13, t10)) {
                        iComputeSFixed32Size = CodedOutputStream.computeFixed32Size(i19, 0);
                        i17 += iComputeSFixed32Size;
                    }
                    break;
                case 58:
                    i13 = i10;
                    if (i(i19, i13, t10)) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(i19, true);
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 59:
                    i13 = i10;
                    if (i(i19, i13, t10)) {
                        Object object2 = unsafe.getObject(t10, j10);
                        iComputeBytesSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(i19, (ByteString) object2) : CodedOutputStream.computeStringSize(i19, (String) object2);
                        i17 = iComputeBytesSize + i17;
                    }
                    break;
                case 60:
                    i13 = i10;
                    if (i(i19, i13, t10)) {
                        iComputeBoolSize = a1.o(i19, unsafe.getObject(t10, j10), e(i13));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 61:
                    i13 = i10;
                    if (i(i19, i13, t10)) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(i19, (ByteString) unsafe.getObject(t10, j10));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 62:
                    i13 = i10;
                    if (i(i19, i13, t10)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(i19, q(j10, t10));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 63:
                    i13 = i10;
                    if (i(i19, i13, t10)) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(i19, q(j10, t10));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 64:
                    i13 = i10;
                    if (i(i19, i13, t10)) {
                        iComputeSFixed32Size = CodedOutputStream.computeSFixed32Size(i19, 0);
                        i17 += iComputeSFixed32Size;
                    }
                    break;
                case 65:
                    i13 = i10;
                    if (i(i19, i13, t10)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(i19, 0L);
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 66:
                    i13 = i10;
                    if (i(i19, i13, t10)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(i19, q(j10, t10));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 67:
                    i13 = i10;
                    if (i(i19, i13, t10)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(i19, r(j10, t10));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 68:
                    i13 = i10;
                    if (i(i19, i13, t10)) {
                        iComputeBoolSize = CodedOutputStream.a(i19, (k0) unsafe.getObject(t10, j10), e(i13));
                        i17 += iComputeBoolSize;
                    }
                    break;
                default:
                    i13 = i10;
                    break;
            }
            i16 = i13 + 3;
        }
    }

    public final int g(T t10) {
        int iComputeDoubleSize;
        int iComputeBytesSize;
        int i10;
        int iComputeTagSize;
        int iComputeUInt32SizeNoTag;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int[] iArr = this.f2505a;
            if (i11 >= iArr.length) {
                f1<?, ?> f1Var = this.f2519o;
                return f1Var.h(f1Var.g(t10)) + i12;
            }
            int iA = A(i11);
            int i13 = (267386880 & iA) >>> 20;
            int i14 = iArr[i11];
            long j10 = iA & 1048575;
            int i15 = (i13 < FieldType.f2337m.id() || i13 > FieldType.f2338n.id()) ? 0 : iArr[i11 + 2] & 1048575;
            boolean z10 = this.f2513i;
            Unsafe unsafe = f2504s;
            switch (i13) {
                case 0:
                    if (!h(i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(i14, 0.0d);
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 1:
                    if (!h(i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(i14, 0.0f);
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 2:
                    if (!h(i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(i14, j1.m(t10, j10));
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 3:
                    if (!h(i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(i14, j1.m(t10, j10));
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 4:
                    if (!h(i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(i14, j1.l(t10, j10));
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 5:
                    if (!h(i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(i14, 0L);
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 6:
                    if (!h(i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(i14, 0);
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 7:
                    if (!h(i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(i14, true);
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 8:
                    if (!h(i11, t10)) {
                        break;
                    } else {
                        Object objN = j1.n(t10, j10);
                        iComputeBytesSize = objN instanceof ByteString ? CodedOutputStream.computeBytesSize(i14, (ByteString) objN) : CodedOutputStream.computeStringSize(i14, (String) objN);
                        i12 += iComputeBytesSize;
                        break;
                    }
                case 9:
                    if (!h(i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = a1.o(i14, j1.n(t10, j10), e(i11));
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 10:
                    if (!h(i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(i14, (ByteString) j1.n(t10, j10));
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 11:
                    if (!h(i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(i14, j1.l(t10, j10));
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 12:
                    if (!h(i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(i14, j1.l(t10, j10));
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 13:
                    if (!h(i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(i14, 0);
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 14:
                    if (!h(i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(i14, 0L);
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 15:
                    if (!h(i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(i14, j1.l(t10, j10));
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 16:
                    if (!h(i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(i14, j1.m(t10, j10));
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 17:
                    if (!h(i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.a(i14, (k0) j1.n(t10, j10), e(i11));
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 18:
                    iComputeDoubleSize = a1.h(i14, j(j10, t10));
                    i12 += iComputeDoubleSize;
                    break;
                case 19:
                    iComputeDoubleSize = a1.f(i14, j(j10, t10));
                    i12 += iComputeDoubleSize;
                    break;
                case 20:
                    iComputeDoubleSize = a1.m(i14, j(j10, t10));
                    i12 += iComputeDoubleSize;
                    break;
                case 21:
                    iComputeDoubleSize = a1.x(i14, j(j10, t10));
                    i12 += iComputeDoubleSize;
                    break;
                case 22:
                    iComputeDoubleSize = a1.k(i14, j(j10, t10));
                    i12 += iComputeDoubleSize;
                    break;
                case 23:
                    iComputeDoubleSize = a1.h(i14, j(j10, t10));
                    i12 += iComputeDoubleSize;
                    break;
                case 24:
                    iComputeDoubleSize = a1.f(i14, j(j10, t10));
                    i12 += iComputeDoubleSize;
                    break;
                case 25:
                    iComputeDoubleSize = a1.a(i14, j(j10, t10));
                    i12 += iComputeDoubleSize;
                    break;
                case 26:
                    iComputeDoubleSize = a1.u(i14, j(j10, t10));
                    i12 += iComputeDoubleSize;
                    break;
                case 27:
                    iComputeDoubleSize = a1.p(i14, j(j10, t10), e(i11));
                    i12 += iComputeDoubleSize;
                    break;
                case 28:
                    iComputeDoubleSize = a1.c(i14, j(j10, t10));
                    i12 += iComputeDoubleSize;
                    break;
                case 29:
                    iComputeDoubleSize = a1.v(i14, j(j10, t10));
                    i12 += iComputeDoubleSize;
                    break;
                case 30:
                    iComputeDoubleSize = a1.d(i14, j(j10, t10));
                    i12 += iComputeDoubleSize;
                    break;
                case 31:
                    iComputeDoubleSize = a1.f(i14, j(j10, t10));
                    i12 += iComputeDoubleSize;
                    break;
                case 32:
                    iComputeDoubleSize = a1.h(i14, j(j10, t10));
                    i12 += iComputeDoubleSize;
                    break;
                case 33:
                    iComputeDoubleSize = a1.q(i14, j(j10, t10));
                    i12 += iComputeDoubleSize;
                    break;
                case 34:
                    iComputeDoubleSize = a1.s(i14, j(j10, t10));
                    i12 += iComputeDoubleSize;
                    break;
                case 35:
                    i10 = a1.i((List) unsafe.getObject(t10, j10));
                    if (i10 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i15, i10);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i14);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i10);
                        i12 += iComputeUInt32SizeNoTag + iComputeTagSize + i10;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    i10 = a1.g((List) unsafe.getObject(t10, j10));
                    if (i10 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i15, i10);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i14);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i10);
                        i12 += iComputeUInt32SizeNoTag + iComputeTagSize + i10;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    i10 = a1.n((List) unsafe.getObject(t10, j10));
                    if (i10 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i15, i10);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i14);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i10);
                        i12 += iComputeUInt32SizeNoTag + iComputeTagSize + i10;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    i10 = a1.y((List) unsafe.getObject(t10, j10));
                    if (i10 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i15, i10);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i14);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i10);
                        i12 += iComputeUInt32SizeNoTag + iComputeTagSize + i10;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    i10 = a1.l((List) unsafe.getObject(t10, j10));
                    if (i10 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i15, i10);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i14);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i10);
                        i12 += iComputeUInt32SizeNoTag + iComputeTagSize + i10;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    i10 = a1.i((List) unsafe.getObject(t10, j10));
                    if (i10 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i15, i10);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i14);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i10);
                        i12 += iComputeUInt32SizeNoTag + iComputeTagSize + i10;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    i10 = a1.g((List) unsafe.getObject(t10, j10));
                    if (i10 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i15, i10);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i14);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i10);
                        i12 += iComputeUInt32SizeNoTag + iComputeTagSize + i10;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    i10 = a1.b((List) unsafe.getObject(t10, j10));
                    if (i10 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i15, i10);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i14);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i10);
                        i12 += iComputeUInt32SizeNoTag + iComputeTagSize + i10;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    i10 = a1.w((List) unsafe.getObject(t10, j10));
                    if (i10 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i15, i10);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i14);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i10);
                        i12 += iComputeUInt32SizeNoTag + iComputeTagSize + i10;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    i10 = a1.e((List) unsafe.getObject(t10, j10));
                    if (i10 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i15, i10);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i14);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i10);
                        i12 += iComputeUInt32SizeNoTag + iComputeTagSize + i10;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    i10 = a1.g((List) unsafe.getObject(t10, j10));
                    if (i10 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i15, i10);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i14);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i10);
                        i12 += iComputeUInt32SizeNoTag + iComputeTagSize + i10;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    i10 = a1.i((List) unsafe.getObject(t10, j10));
                    if (i10 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i15, i10);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i14);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i10);
                        i12 += iComputeUInt32SizeNoTag + iComputeTagSize + i10;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    i10 = a1.r((List) unsafe.getObject(t10, j10));
                    if (i10 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i15, i10);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i14);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i10);
                        i12 += iComputeUInt32SizeNoTag + iComputeTagSize + i10;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    i10 = a1.t((List) unsafe.getObject(t10, j10));
                    if (i10 > 0) {
                        if (z10) {
                            unsafe.putInt(t10, i15, i10);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(i14);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(i10);
                        i12 += iComputeUInt32SizeNoTag + iComputeTagSize + i10;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    iComputeDoubleSize = a1.j(i14, j(j10, t10), e(i11));
                    i12 += iComputeDoubleSize;
                    break;
                case 50:
                    iComputeDoubleSize = this.f2521q.getSerializedSize(i14, j1.n(t10, j10), d(i11));
                    i12 += iComputeDoubleSize;
                    break;
                case 51:
                    if (!i(i14, i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(i14, 0.0d);
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 52:
                    if (!i(i14, i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(i14, 0.0f);
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 53:
                    if (!i(i14, i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(i14, r(j10, t10));
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 54:
                    if (!i(i14, i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(i14, r(j10, t10));
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 55:
                    if (!i(i14, i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(i14, q(j10, t10));
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 56:
                    if (!i(i14, i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(i14, 0L);
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 57:
                    if (!i(i14, i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(i14, 0);
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 58:
                    if (!i(i14, i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(i14, true);
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 59:
                    if (!i(i14, i11, t10)) {
                        break;
                    } else {
                        Object objN2 = j1.n(t10, j10);
                        iComputeBytesSize = objN2 instanceof ByteString ? CodedOutputStream.computeBytesSize(i14, (ByteString) objN2) : CodedOutputStream.computeStringSize(i14, (String) objN2);
                        i12 += iComputeBytesSize;
                        break;
                    }
                case 60:
                    if (!i(i14, i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = a1.o(i14, j1.n(t10, j10), e(i11));
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 61:
                    if (!i(i14, i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(i14, (ByteString) j1.n(t10, j10));
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 62:
                    if (!i(i14, i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(i14, q(j10, t10));
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 63:
                    if (!i(i14, i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(i14, q(j10, t10));
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 64:
                    if (!i(i14, i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(i14, 0);
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 65:
                    if (!i(i14, i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(i14, 0L);
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 66:
                    if (!i(i14, i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(i14, q(j10, t10));
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 67:
                    if (!i(i14, i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(i14, r(j10, t10));
                        i12 += iComputeDoubleSize;
                        break;
                    }
                case 68:
                    if (!i(i14, i11, t10)) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.a(i14, (k0) j1.n(t10, j10), e(i11));
                        i12 += iComputeDoubleSize;
                        break;
                    }
            }
            i11 += 3;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public int getSerializedSize(T t10) {
        return this.f2512h ? g(t10) : f(t10);
    }

    public final boolean h(int i10, Object obj) {
        boolean zEquals;
        if (!this.f2512h) {
            int i11 = this.f2505a[i10 + 2];
            return (j1.l(obj, (long) (i11 & 1048575)) & (1 << (i11 >>> 20))) != 0;
        }
        int iA = A(i10);
        long j10 = iA & 1048575;
        switch ((iA & 267386880) >>> 20) {
            case 0:
                return j1.j(obj, j10) != 0.0d;
            case 1:
                return j1.k(obj, j10) != 0.0f;
            case 2:
                return j1.m(obj, j10) != 0;
            case 3:
                return j1.m(obj, j10) != 0;
            case 4:
                return j1.l(obj, j10) != 0;
            case 5:
                return j1.m(obj, j10) != 0;
            case 6:
                return j1.l(obj, j10) != 0;
            case 7:
                return j1.f(obj, j10);
            case 8:
                Object objN = j1.n(obj, j10);
                if (objN instanceof String) {
                    zEquals = ((String) objN).isEmpty();
                    break;
                } else {
                    if (!(objN instanceof ByteString)) {
                        throw new IllegalArgumentException();
                    }
                    zEquals = ByteString.f2316m.equals(objN);
                    break;
                }
            case 9:
                return j1.n(obj, j10) != null;
            case 10:
                zEquals = ByteString.f2316m.equals(j1.n(obj, j10));
                break;
            case 11:
                return j1.l(obj, j10) != 0;
            case 12:
                return j1.l(obj, j10) != 0;
            case 13:
                return j1.l(obj, j10) != 0;
            case 14:
                return j1.m(obj, j10) != 0;
            case 15:
                return j1.l(obj, j10) != 0;
            case 16:
                return j1.m(obj, j10) != 0;
            case 17:
                return j1.n(obj, j10) != null;
            default:
                throw new IllegalArgumentException();
        }
        return !zEquals;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x01d2  */
    @Override // androidx.datastore.preferences.protobuf.y0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int hashCode(T r10) {
        /*
            Method dump skipped, instructions count: 748
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.hashCode(java.lang.Object):int");
    }

    public final boolean i(int i10, int i11, Object obj) {
        return j1.l(obj, (long) (this.f2505a[i11 + 2] & 1048575)) == i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00da  */
    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.datastore.preferences.protobuf.y0] */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.datastore.preferences.protobuf.y0] */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.datastore.preferences.protobuf.y0] */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19, types: [androidx.datastore.preferences.protobuf.y0] */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    @Override // androidx.datastore.preferences.protobuf.y0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isInitialized(T r15) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.isInitialized(java.lang.Object):boolean");
    }

    public final <K, V> void k(Object obj, int i10, Object obj2, n nVar, x0 x0Var) throws IOException {
        long jA = A(i10) & 1048575;
        Object objN = j1.n(obj, jA);
        f0 f0Var = this.f2521q;
        if (objN == null) {
            objN = f0Var.newMapField(obj2);
            j1.u(obj, jA, objN);
        } else if (f0Var.isImmutable(objN)) {
            Object objNewMapField = f0Var.newMapField(obj2);
            f0Var.mergeFrom(objNewMapField, objN);
            j1.u(obj, jA, objNewMapField);
            objN = objNewMapField;
        }
        x0Var.readMap(f0Var.forMutableMapData(objN), f0Var.forMapMetadata(obj2), nVar);
    }

    public final void l(int i10, Object obj, Object obj2) {
        long jA = A(i10) & 1048575;
        if (h(i10, obj2)) {
            Object objN = j1.n(obj, jA);
            Object objN2 = j1.n(obj2, jA);
            if (objN != null && objN2 != null) {
                j1.u(obj, jA, w.a(objN, objN2));
                y(i10, obj);
            } else if (objN2 != null) {
                j1.u(obj, jA, objN2);
                y(i10, obj);
            }
        }
    }

    public final void m(int i10, Object obj, Object obj2) {
        int iA = A(i10);
        int i11 = this.f2505a[i10];
        long j10 = iA & 1048575;
        if (i(i11, i10, obj2)) {
            Object objN = j1.n(obj, j10);
            Object objN2 = j1.n(obj2, j10);
            if (objN != null && objN2 != null) {
                j1.u(obj, j10, w.a(objN, objN2));
                z(i11, i10, obj);
            } else if (objN2 != null) {
                j1.u(obj, j10, objN2);
                z(i11, i10, obj);
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public void makeImmutable(T t10) {
        int[] iArr;
        int i10;
        int i11 = this.f2515k;
        while (true) {
            iArr = this.f2514j;
            i10 = this.f2516l;
            if (i11 >= i10) {
                break;
            }
            long jA = A(iArr[i11]) & 1048575;
            Object objN = j1.n(t10, jA);
            if (objN != null) {
                j1.u(t10, jA, this.f2521q.toImmutable(objN));
            }
            i11++;
        }
        int length = iArr.length;
        while (i10 < length) {
            this.f2518n.a(iArr[i10], t10);
            i10++;
        }
        this.f2519o.j(t10);
        if (this.f2510f) {
            this.f2520p.f(t10);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public void mergeFrom(T t10, T t11) {
        t11.getClass();
        int i10 = 0;
        while (true) {
            int[] iArr = this.f2505a;
            if (i10 >= iArr.length) {
                if (this.f2512h) {
                    return;
                }
                Class<?> cls = a1.f2397a;
                f1<?, ?> f1Var = this.f2519o;
                f1Var.o(t10, f1Var.k(f1Var.g(t10), f1Var.g(t11)));
                if (this.f2510f) {
                    o<?> oVar = this.f2520p;
                    s<T> sVarC = oVar.c(t11);
                    if (sVarC.d()) {
                        return;
                    }
                    oVar.d(t10).mergeFrom(sVarC);
                    return;
                }
                return;
            }
            int iA = A(i10);
            long j10 = 1048575 & iA;
            int i11 = iArr[i10];
            switch ((iA & 267386880) >>> 20) {
                case 0:
                    if (!h(i10, t11)) {
                        break;
                    } else {
                        j1.f2489d.putDouble(t10, j10, j1.j(t11, j10));
                        y(i10, t10);
                        break;
                    }
                case 1:
                    if (!h(i10, t11)) {
                        break;
                    } else {
                        j1.f2489d.putFloat(t10, j10, j1.k(t11, j10));
                        y(i10, t10);
                        break;
                    }
                case 2:
                    if (!h(i10, t11)) {
                        break;
                    } else {
                        j1.t(t10, j10, j1.m(t11, j10));
                        y(i10, t10);
                        break;
                    }
                case 3:
                    if (!h(i10, t11)) {
                        break;
                    } else {
                        j1.t(t10, j10, j1.m(t11, j10));
                        y(i10, t10);
                        break;
                    }
                case 4:
                    if (!h(i10, t11)) {
                        break;
                    } else {
                        j1.s(t10, j10, j1.l(t11, j10));
                        y(i10, t10);
                        break;
                    }
                case 5:
                    if (!h(i10, t11)) {
                        break;
                    } else {
                        j1.t(t10, j10, j1.m(t11, j10));
                        y(i10, t10);
                        break;
                    }
                case 6:
                    if (!h(i10, t11)) {
                        break;
                    } else {
                        j1.s(t10, j10, j1.l(t11, j10));
                        y(i10, t10);
                        break;
                    }
                case 7:
                    if (!h(i10, t11)) {
                        break;
                    } else {
                        j1.f2489d.putBoolean(t10, j10, j1.f(t11, j10));
                        y(i10, t10);
                        break;
                    }
                case 8:
                    if (!h(i10, t11)) {
                        break;
                    } else {
                        j1.u(t10, j10, j1.n(t11, j10));
                        y(i10, t10);
                        break;
                    }
                case 9:
                    l(i10, t10, t11);
                    break;
                case 10:
                    if (!h(i10, t11)) {
                        break;
                    } else {
                        j1.u(t10, j10, j1.n(t11, j10));
                        y(i10, t10);
                        break;
                    }
                case 11:
                    if (!h(i10, t11)) {
                        break;
                    } else {
                        j1.s(t10, j10, j1.l(t11, j10));
                        y(i10, t10);
                        break;
                    }
                case 12:
                    if (!h(i10, t11)) {
                        break;
                    } else {
                        j1.s(t10, j10, j1.l(t11, j10));
                        y(i10, t10);
                        break;
                    }
                case 13:
                    if (!h(i10, t11)) {
                        break;
                    } else {
                        j1.s(t10, j10, j1.l(t11, j10));
                        y(i10, t10);
                        break;
                    }
                case 14:
                    if (!h(i10, t11)) {
                        break;
                    } else {
                        j1.t(t10, j10, j1.m(t11, j10));
                        y(i10, t10);
                        break;
                    }
                case 15:
                    if (!h(i10, t11)) {
                        break;
                    } else {
                        j1.s(t10, j10, j1.l(t11, j10));
                        y(i10, t10);
                        break;
                    }
                case 16:
                    if (!h(i10, t11)) {
                        break;
                    } else {
                        j1.t(t10, j10, j1.m(t11, j10));
                        y(i10, t10);
                        break;
                    }
                case 17:
                    l(i10, t10, t11);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.f2518n.b(t10, j10, t11);
                    break;
                case 50:
                    Class<?> cls2 = a1.f2397a;
                    j1.u(t10, j10, this.f2521q.mergeFrom(j1.n(t10, j10), j1.n(t11, j10)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!i(i11, i10, t11)) {
                        break;
                    } else {
                        j1.u(t10, j10, j1.n(t11, j10));
                        z(i11, i10, t10);
                        break;
                    }
                case 60:
                    m(i10, t10, t11);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!i(i11, i10, t11)) {
                        break;
                    } else {
                        j1.u(t10, j10, j1.n(t11, j10));
                        z(i11, i10, t10);
                        break;
                    }
                case 68:
                    m(i10, t10, t11);
                    break;
            }
            i10 += 3;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public T newInstance() {
        return (T) this.f2517m.newInstance(this.f2509e);
    }

    public final int s(int i10) {
        if (i10 < this.f2507c || i10 > this.f2508d) {
            return -1;
        }
        int[] iArr = this.f2505a;
        int length = (iArr.length / 3) - 1;
        int i11 = 0;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int i14 = iArr[i13];
            if (i10 == i14) {
                return i13;
            }
            if (i10 < i14) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    public final <E> void t(Object obj, long j10, x0 x0Var, y0<E> y0Var, n nVar) throws IOException {
        x0Var.readGroupList(this.f2518n.c(j10, obj), y0Var, nVar);
    }

    public final <E> void u(Object obj, int i10, x0 x0Var, y0<E> y0Var, n nVar) throws IOException {
        x0Var.readMessageList(this.f2518n.c(i10 & 1048575, obj), y0Var, nVar);
    }

    public final void v(Object obj, int i10, x0 x0Var) throws IOException {
        if ((536870912 & i10) != 0) {
            j1.u(obj, i10 & 1048575, x0Var.readStringRequireUtf8());
        } else if (this.f2511g) {
            j1.u(obj, i10 & 1048575, x0Var.readString());
        } else {
            j1.u(obj, i10 & 1048575, x0Var.readBytes());
        }
    }

    public final void w(Object obj, int i10, x0 x0Var) throws IOException {
        boolean z10 = (536870912 & i10) != 0;
        b0 b0Var = this.f2518n;
        if (z10) {
            x0Var.readStringListRequireUtf8(b0Var.c(i10 & 1048575, obj));
        } else {
            x0Var.readStringList(b0Var.c(i10 & 1048575, obj));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:186:0x05c3  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x060f  */
    @Override // androidx.datastore.preferences.protobuf.y0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writeTo(T r19, androidx.datastore.preferences.protobuf.Writer r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.writeTo(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    public final void y(int i10, Object obj) {
        if (this.f2512h) {
            return;
        }
        int i11 = this.f2505a[i10 + 2];
        long j10 = i11 & 1048575;
        j1.s(obj, j10, j1.l(obj, j10) | (1 << (i11 >>> 20)));
    }

    public final void z(int i10, int i11, Object obj) {
        j1.s(obj, this.f2505a[i11 + 2] & 1048575, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:161:0x05cf A[Catch: all -> 0x05ef, TryCatch #7 {all -> 0x05ef, blocks: (B:18:0x0046, B:25:0x005c, B:153:0x05b6, B:159:0x05ca, B:161:0x05cf, B:162:0x05d4), top: B:188:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x05f6 A[LOOP:1: B:175:0x05f4->B:176:0x05f6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0601  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x05da A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x05eb A[SYNTHETIC] */
    @Override // androidx.datastore.preferences.protobuf.y0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mergeFrom(T r20, androidx.datastore.preferences.protobuf.x0 r21, androidx.datastore.preferences.protobuf.n r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1684
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.n0.mergeFrom(java.lang.Object, androidx.datastore.preferences.protobuf.x0, androidx.datastore.preferences.protobuf.n):void");
    }
}
