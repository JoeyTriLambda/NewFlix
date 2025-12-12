package androidx.work;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import w2.g;

/* compiled from: Data.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final String f4505b = g.tagWithPrefix("Data");

    /* renamed from: c, reason: collision with root package name */
    public static final b f4506c = new a().build();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f4507a;

    /* compiled from: Data.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final HashMap f4508a = new HashMap();

        public b build() throws Throwable {
            b bVar = new b(this.f4508a);
            b.toByteArrayInternal(bVar);
            return bVar;
        }

        public a put(String str, Object obj) {
            HashMap map = this.f4508a;
            if (obj == null) {
                map.put(str, null);
            } else {
                Class<?> cls = obj.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    map.put(str, obj);
                } else if (cls == boolean[].class) {
                    map.put(str, b.convertPrimitiveBooleanArray((boolean[]) obj));
                } else if (cls == byte[].class) {
                    map.put(str, b.convertPrimitiveByteArray((byte[]) obj));
                } else if (cls == int[].class) {
                    map.put(str, b.convertPrimitiveIntArray((int[]) obj));
                } else if (cls == long[].class) {
                    map.put(str, b.convertPrimitiveLongArray((long[]) obj));
                } else if (cls == float[].class) {
                    map.put(str, b.convertPrimitiveFloatArray((float[]) obj));
                } else {
                    if (cls != double[].class) {
                        throw new IllegalArgumentException("Key " + str + "has invalid type " + cls);
                    }
                    map.put(str, b.convertPrimitiveDoubleArray((double[]) obj));
                }
            }
            return this;
        }

        public a putAll(b bVar) {
            putAll(bVar.f4507a);
            return this;
        }

        public a putString(String str, String str2) {
            this.f4508a.put(str, str2);
            return this;
        }

        public a putAll(Map<String, Object> map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
            return this;
        }
    }

    public b() {
    }

    public static Boolean[] convertPrimitiveBooleanArray(boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i10 = 0; i10 < zArr.length; i10++) {
            boolArr[i10] = Boolean.valueOf(zArr[i10]);
        }
        return boolArr;
    }

    public static Byte[] convertPrimitiveByteArray(byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr2[i10] = Byte.valueOf(bArr[i10]);
        }
        return bArr2;
    }

    public static Double[] convertPrimitiveDoubleArray(double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i10 = 0; i10 < dArr.length; i10++) {
            dArr2[i10] = Double.valueOf(dArr[i10]);
        }
        return dArr2;
    }

    public static Float[] convertPrimitiveFloatArray(float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i10 = 0; i10 < fArr.length; i10++) {
            fArr2[i10] = Float.valueOf(fArr[i10]);
        }
        return fArr2;
    }

    public static Integer[] convertPrimitiveIntArray(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            numArr[i10] = Integer.valueOf(iArr[i10]);
        }
        return numArr;
    }

    public static Long[] convertPrimitiveLongArray(long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i10 = 0; i10 < jArr.length; i10++) {
            lArr[i10] = Long.valueOf(jArr[i10]);
        }
        return lArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x005b -> B:38:0x005e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static androidx.work.b fromByteArray(byte[] r8) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "Error in Data#fromByteArray: "
            java.lang.String r1 = androidx.work.b.f4505b
            int r2 = r8.length
            r3 = 10240(0x2800, float:1.4349E-41)
            if (r2 > r3) goto L77
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream
            r3.<init>(r8)
            r8 = 0
            java.io.ObjectInputStream r4 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L3f java.lang.ClassNotFoundException -> L43 java.io.IOException -> L45
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L3f java.lang.ClassNotFoundException -> L43 java.io.IOException -> L45
            int r8 = r4.readInt()     // Catch: java.lang.Throwable -> L39 java.lang.ClassNotFoundException -> L3b java.io.IOException -> L3d
        L1d:
            if (r8 <= 0) goto L2d
            java.lang.String r5 = r4.readUTF()     // Catch: java.lang.Throwable -> L39 java.lang.ClassNotFoundException -> L3b java.io.IOException -> L3d
            java.lang.Object r6 = r4.readObject()     // Catch: java.lang.Throwable -> L39 java.lang.ClassNotFoundException -> L3b java.io.IOException -> L3d
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L39 java.lang.ClassNotFoundException -> L3b java.io.IOException -> L3d
            int r8 = r8 + (-1)
            goto L1d
        L2d:
            r4.close()     // Catch: java.io.IOException -> L31
            goto L35
        L31:
            r8 = move-exception
            android.util.Log.e(r1, r0, r8)
        L35:
            r3.close()     // Catch: java.io.IOException -> L5a
            goto L5e
        L39:
            r8 = move-exception
            goto L64
        L3b:
            r8 = move-exception
            goto L49
        L3d:
            r8 = move-exception
            goto L49
        L3f:
            r2 = move-exception
            r4 = r8
            r8 = r2
            goto L64
        L43:
            r4 = move-exception
            goto L46
        L45:
            r4 = move-exception
        L46:
            r7 = r4
            r4 = r8
            r8 = r7
        L49:
            android.util.Log.e(r1, r0, r8)     // Catch: java.lang.Throwable -> L39
            if (r4 == 0) goto L56
            r4.close()     // Catch: java.io.IOException -> L52
            goto L56
        L52:
            r8 = move-exception
            android.util.Log.e(r1, r0, r8)
        L56:
            r3.close()     // Catch: java.io.IOException -> L5a
            goto L5e
        L5a:
            r8 = move-exception
            android.util.Log.e(r1, r0, r8)
        L5e:
            androidx.work.b r8 = new androidx.work.b
            r8.<init>(r2)
            return r8
        L64:
            if (r4 == 0) goto L6e
            r4.close()     // Catch: java.io.IOException -> L6a
            goto L6e
        L6a:
            r2 = move-exception
            android.util.Log.e(r1, r0, r2)
        L6e:
            r3.close()     // Catch: java.io.IOException -> L72
            goto L76
        L72:
            r2 = move-exception
            android.util.Log.e(r1, r0, r2)
        L76:
            throw r8
        L77:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.b.fromByteArray(byte[]):androidx.work.b");
    }

    public static byte[] toByteArrayInternal(b bVar) throws Throwable {
        ObjectOutputStream objectOutputStream;
        String str = f4505b;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeInt(bVar.size());
                    for (Map.Entry entry : bVar.f4507a.entrySet()) {
                        objectOutputStream.writeUTF((String) entry.getKey());
                        objectOutputStream.writeObject(entry.getValue());
                    }
                    try {
                        objectOutputStream.close();
                    } catch (IOException e10) {
                        Log.e(str, "Error in Data#toByteArray: ", e10);
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e11) {
                        Log.e(str, "Error in Data#toByteArray: ", e11);
                    }
                    if (byteArrayOutputStream.size() <= 10240) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                } catch (IOException e12) {
                    e = e12;
                    objectOutputStream2 = objectOutputStream;
                    Log.e(str, "Error in Data#toByteArray: ", e);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (IOException e13) {
                            Log.e(str, "Error in Data#toByteArray: ", e13);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e14) {
                        Log.e(str, "Error in Data#toByteArray: ", e14);
                    }
                    return byteArray;
                } catch (Throwable th2) {
                    th = th2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e15) {
                            Log.e(str, "Error in Data#toByteArray: ", e15);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (IOException e16) {
                        Log.e(str, "Error in Data#toByteArray: ", e16);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                objectOutputStream = objectOutputStream2;
            }
        } catch (IOException e17) {
            e = e17;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        HashMap map = this.f4507a;
        Set<String> setKeySet = map.keySet();
        if (!setKeySet.equals(bVar.f4507a.keySet())) {
            return false;
        }
        for (String str : setKeySet) {
            Object obj2 = map.get(str);
            Object obj3 = bVar.f4507a.get(str);
            if (!((obj2 == null || obj3 == null) ? obj2 == obj3 : ((obj2 instanceof Object[]) && (obj3 instanceof Object[])) ? Arrays.deepEquals((Object[]) obj2, (Object[]) obj3) : obj2.equals(obj3))) {
                return false;
            }
        }
        return true;
    }

    public Map<String, Object> getKeyValueMap() {
        return Collections.unmodifiableMap(this.f4507a);
    }

    public String getString(String str) {
        Object obj = this.f4507a.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public int hashCode() {
        return this.f4507a.hashCode() * 31;
    }

    public int size() {
        return this.f4507a.size();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Data {");
        HashMap map = this.f4507a;
        if (!map.isEmpty()) {
            for (String str : map.keySet()) {
                sb2.append(str);
                sb2.append(" : ");
                Object obj = map.get(str);
                if (obj instanceof Object[]) {
                    sb2.append(Arrays.toString((Object[]) obj));
                } else {
                    sb2.append(obj);
                }
                sb2.append(", ");
            }
        }
        sb2.append("}");
        return sb2.toString();
    }

    public b(b bVar) {
        this.f4507a = new HashMap(bVar.f4507a);
    }

    public b(Map<String, ?> map) {
        this.f4507a = new HashMap(map);
    }
}
