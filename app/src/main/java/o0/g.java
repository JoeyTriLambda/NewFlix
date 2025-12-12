package o0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import n0.d;
import u0.m;

/* compiled from: TypefaceCompatApi24Impl.java */
/* loaded from: classes.dex */
public final class g extends l {

    /* renamed from: a, reason: collision with root package name */
    public static final Class<?> f16899a;

    /* renamed from: b, reason: collision with root package name */
    public static final Constructor<?> f16900b;

    /* renamed from: c, reason: collision with root package name */
    public static final Method f16901c;

    /* renamed from: d, reason: collision with root package name */
    public static final Method f16902d;

    static {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method method2;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
        } catch (ClassNotFoundException | NoSuchMethodException e10) {
            Log.e("TypefaceCompatApi24Impl", e10.getClass().getName(), e10);
            cls = null;
            method = null;
            constructor = null;
            method2 = null;
        }
        f16900b = constructor;
        f16899a = cls;
        f16901c = method2;
        f16902d = method;
    }

    public static boolean b(Object obj, ByteBuffer byteBuffer, int i10, int i11, boolean z10) {
        try {
            return ((Boolean) f16901c.invoke(obj, byteBuffer, Integer.valueOf(i10), null, Integer.valueOf(i11), Boolean.valueOf(z10))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static boolean isUsable() {
        Method method = f16901c;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    @Override // o0.l
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, d.c cVar, Resources resources, int i10) throws IllegalAccessException, InstantiationException, ArrayIndexOutOfBoundsException, IllegalArgumentException, InvocationTargetException, NegativeArraySizeException {
        Object objNewInstance;
        try {
            objNewInstance = f16900b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance == null) {
            return null;
        }
        for (d.C0204d c0204d : cVar.getEntries()) {
            ByteBuffer byteBufferCopyToDirectBuffer = m.copyToDirectBuffer(context, resources, c0204d.getResourceId());
            if (byteBufferCopyToDirectBuffer == null || !b(objNewInstance, byteBufferCopyToDirectBuffer, c0204d.getTtcIndex(), c0204d.getWeight(), c0204d.isItalic())) {
                return null;
            }
        }
        try {
            Object objNewInstance2 = Array.newInstance(f16899a, 1);
            Array.set(objNewInstance2, 0, objNewInstance);
            return (Typeface) f16902d.invoke(null, objNewInstance2);
        } catch (IllegalAccessException | InvocationTargetException unused2) {
            return null;
        }
    }

    @Override // o0.l
    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, m.b[] bVarArr, int i10) throws IllegalAccessException, InstantiationException, IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException, InvocationTargetException, NegativeArraySizeException {
        Object objNewInstance;
        Typeface typeface;
        try {
            objNewInstance = f16900b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance == null) {
            return null;
        }
        b0.k kVar = new b0.k();
        for (m.b bVar : bVarArr) {
            Uri uri = bVar.getUri();
            ByteBuffer byteBufferMmap = (ByteBuffer) kVar.get(uri);
            if (byteBufferMmap == null) {
                byteBufferMmap = m.mmap(context, cancellationSignal, uri);
                kVar.put(uri, byteBufferMmap);
            }
            if (byteBufferMmap == null || !b(objNewInstance, byteBufferMmap, bVar.getTtcIndex(), bVar.getWeight(), bVar.isItalic())) {
                return null;
            }
        }
        try {
            Object objNewInstance2 = Array.newInstance(f16899a, 1);
            Array.set(objNewInstance2, 0, objNewInstance);
            typeface = (Typeface) f16902d.invoke(null, objNewInstance2);
        } catch (IllegalAccessException | InvocationTargetException unused2) {
            typeface = null;
        }
        if (typeface == null) {
            return null;
        }
        return Typeface.create(typeface, i10);
    }
}
