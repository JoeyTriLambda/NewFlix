package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: UnsafeUtil.java */
/* loaded from: classes.dex */
public final class j1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f2486a = Logger.getLogger(j1.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final Unsafe f2487b;

    /* renamed from: c, reason: collision with root package name */
    public static final Class<?> f2488c;

    /* renamed from: d, reason: collision with root package name */
    public static final e f2489d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f2490e;

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f2491f;

    /* renamed from: g, reason: collision with root package name */
    public static final long f2492g;

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f2493h;

    /* compiled from: UnsafeUtil.java */
    public static class a implements PrivilegedExceptionAction<Unsafe> {
        @Override // java.security.PrivilegedExceptionAction
        public Unsafe run() throws Exception {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }
    }

    /* compiled from: UnsafeUtil.java */
    public static final class b extends e {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public boolean getBoolean(Object obj, long j10) {
            return j1.f2493h ? j1.h(j10, obj) != 0 : j1.i(j10, obj) != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public byte getByte(Object obj, long j10) {
            return j1.f2493h ? j1.h(j10, obj) : j1.i(j10, obj);
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public double getDouble(Object obj, long j10) {
            return Double.longBitsToDouble(getLong(obj, j10));
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public float getFloat(Object obj, long j10) {
            return Float.intBitsToFloat(getInt(obj, j10));
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public void putBoolean(Object obj, long j10, boolean z10) {
            if (j1.f2493h) {
                j1.q(obj, j10, z10 ? (byte) 1 : (byte) 0);
            } else {
                j1.r(obj, j10, z10 ? (byte) 1 : (byte) 0);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public void putByte(Object obj, long j10, byte b10) {
            if (j1.f2493h) {
                j1.q(obj, j10, b10);
            } else {
                j1.r(obj, j10, b10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public void putDouble(Object obj, long j10, double d10) {
            putLong(obj, j10, Double.doubleToLongBits(d10));
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public void putFloat(Object obj, long j10, float f10) {
            putInt(obj, j10, Float.floatToIntBits(f10));
        }
    }

    /* compiled from: UnsafeUtil.java */
    public static final class c extends e {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public boolean getBoolean(Object obj, long j10) {
            return j1.f2493h ? j1.h(j10, obj) != 0 : j1.i(j10, obj) != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public byte getByte(Object obj, long j10) {
            return j1.f2493h ? j1.h(j10, obj) : j1.i(j10, obj);
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public double getDouble(Object obj, long j10) {
            return Double.longBitsToDouble(getLong(obj, j10));
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public float getFloat(Object obj, long j10) {
            return Float.intBitsToFloat(getInt(obj, j10));
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public void putBoolean(Object obj, long j10, boolean z10) {
            if (j1.f2493h) {
                j1.q(obj, j10, z10 ? (byte) 1 : (byte) 0);
            } else {
                j1.r(obj, j10, z10 ? (byte) 1 : (byte) 0);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public void putByte(Object obj, long j10, byte b10) {
            if (j1.f2493h) {
                j1.q(obj, j10, b10);
            } else {
                j1.r(obj, j10, b10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public void putDouble(Object obj, long j10, double d10) {
            putLong(obj, j10, Double.doubleToLongBits(d10));
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public void putFloat(Object obj, long j10, float f10) {
            putInt(obj, j10, Float.floatToIntBits(f10));
        }
    }

    /* compiled from: UnsafeUtil.java */
    public static final class d extends e {
        public d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public boolean getBoolean(Object obj, long j10) {
            return this.f2494a.getBoolean(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public byte getByte(Object obj, long j10) {
            return this.f2494a.getByte(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public double getDouble(Object obj, long j10) {
            return this.f2494a.getDouble(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public float getFloat(Object obj, long j10) {
            return this.f2494a.getFloat(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public void putBoolean(Object obj, long j10, boolean z10) {
            this.f2494a.putBoolean(obj, j10, z10);
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public void putByte(Object obj, long j10, byte b10) {
            this.f2494a.putByte(obj, j10, b10);
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public void putDouble(Object obj, long j10, double d10) {
            this.f2494a.putDouble(obj, j10, d10);
        }

        @Override // androidx.datastore.preferences.protobuf.j1.e
        public void putFloat(Object obj, long j10, float f10) {
            this.f2494a.putFloat(obj, j10, f10);
        }
    }

    /* compiled from: UnsafeUtil.java */
    public static abstract class e {

        /* renamed from: a, reason: collision with root package name */
        public final Unsafe f2494a;

        public e(Unsafe unsafe) {
            this.f2494a = unsafe;
        }

        public final int arrayBaseOffset(Class<?> cls) {
            return this.f2494a.arrayBaseOffset(cls);
        }

        public final int arrayIndexScale(Class<?> cls) {
            return this.f2494a.arrayIndexScale(cls);
        }

        public abstract boolean getBoolean(Object obj, long j10);

        public abstract byte getByte(Object obj, long j10);

        public abstract double getDouble(Object obj, long j10);

        public abstract float getFloat(Object obj, long j10);

        public final int getInt(Object obj, long j10) {
            return this.f2494a.getInt(obj, j10);
        }

        public final long getLong(Object obj, long j10) {
            return this.f2494a.getLong(obj, j10);
        }

        public final Object getObject(Object obj, long j10) {
            return this.f2494a.getObject(obj, j10);
        }

        public final long objectFieldOffset(Field field) {
            return this.f2494a.objectFieldOffset(field);
        }

        public abstract void putBoolean(Object obj, long j10, boolean z10);

        public abstract void putByte(Object obj, long j10, byte b10);

        public abstract void putDouble(Object obj, long j10, double d10);

        public abstract void putFloat(Object obj, long j10, float f10);

        public final void putInt(Object obj, long j10, int i10) {
            this.f2494a.putInt(obj, j10, i10);
        }

        public final void putLong(Object obj, long j10, long j11) {
            this.f2494a.putLong(obj, j10, j11);
        }

        public final void putObject(Object obj, long j10, Object obj2) {
            this.f2494a.putObject(obj, j10, obj2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0261  */
    static {
        /*
            Method dump skipped, instructions count: 613
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.j1.<clinit>():void");
    }

    public static <T> T a(Class<T> cls) {
        try {
            return (T) f2487b.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static int b(Class<?> cls) {
        if (f2491f) {
            return f2489d.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static void c(Class cls) {
        if (f2491f) {
            f2489d.arrayIndexScale(cls);
        }
    }

    public static Field d() {
        Field declaredField;
        Field declaredField2;
        if (androidx.datastore.preferences.protobuf.d.a()) {
            try {
                declaredField2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                declaredField2 = null;
            }
            if (declaredField2 != null) {
                return declaredField2;
            }
        }
        try {
            declaredField = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            declaredField = null;
        }
        if (declaredField == null || declaredField.getType() != Long.TYPE) {
            return null;
        }
        return declaredField;
    }

    public static boolean e(Class<?> cls) {
        if (!androidx.datastore.preferences.protobuf.d.a()) {
            return false;
        }
        try {
            Class<?> cls2 = f2488c;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean f(Object obj, long j10) {
        return f2489d.getBoolean(obj, j10);
    }

    public static byte g(long j10, byte[] bArr) {
        return f2489d.getByte(bArr, f2492g + j10);
    }

    public static byte h(long j10, Object obj) {
        return (byte) ((l(obj, (-4) & j10) >>> ((int) (((~j10) & 3) << 3))) & 255);
    }

    public static byte i(long j10, Object obj) {
        return (byte) ((l(obj, (-4) & j10) >>> ((int) ((j10 & 3) << 3))) & 255);
    }

    public static double j(Object obj, long j10) {
        return f2489d.getDouble(obj, j10);
    }

    public static float k(Object obj, long j10) {
        return f2489d.getFloat(obj, j10);
    }

    public static int l(Object obj, long j10) {
        return f2489d.getInt(obj, j10);
    }

    public static long m(Object obj, long j10) {
        return f2489d.getLong(obj, j10);
    }

    public static Object n(Object obj, long j10) {
        return f2489d.getObject(obj, j10);
    }

    public static Unsafe o() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void p(byte[] bArr, long j10, byte b10) {
        f2489d.putByte(bArr, f2492g + j10, b10);
    }

    public static void q(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int iL = l(obj, j11);
        int i10 = ((~((int) j10)) & 3) << 3;
        s(obj, j11, ((255 & b10) << i10) | (iL & (~(255 << i10))));
    }

    public static void r(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int i10 = (((int) j10) & 3) << 3;
        s(obj, j11, ((255 & b10) << i10) | (l(obj, j11) & (~(255 << i10))));
    }

    public static void s(Object obj, long j10, int i10) {
        f2489d.putInt(obj, j10, i10);
    }

    public static void t(Object obj, long j10, long j11) {
        f2489d.putLong(obj, j10, j11);
    }

    public static void u(Object obj, long j10, Object obj2) {
        f2489d.putObject(obj, j10, obj2);
    }
}
