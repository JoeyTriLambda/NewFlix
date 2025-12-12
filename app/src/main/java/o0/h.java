package o0;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import n0.d;
import u0.m;

/* compiled from: TypefaceCompatApi26Impl.java */
/* loaded from: classes.dex */
public class h extends f {

    /* renamed from: f, reason: collision with root package name */
    public final Class<?> f16903f;

    /* renamed from: g, reason: collision with root package name */
    public final Constructor<?> f16904g;

    /* renamed from: h, reason: collision with root package name */
    public final Method f16905h;

    /* renamed from: i, reason: collision with root package name */
    public final Method f16906i;

    /* renamed from: j, reason: collision with root package name */
    public final Method f16907j;

    /* renamed from: k, reason: collision with root package name */
    public final Method f16908k;

    /* renamed from: l, reason: collision with root package name */
    public final Method f16909l;

    public h() {
        Class<?> clsObtainFontFamily;
        Constructor<?> constructorObtainFontFamilyCtor;
        Method methodObtainAddFontFromAssetManagerMethod;
        Method methodObtainAddFontFromBufferMethod;
        Method methodObtainFreezeMethod;
        Method methodObtainAbortCreationMethod;
        Method methodObtainCreateFromFamiliesWithDefaultMethod;
        try {
            clsObtainFontFamily = obtainFontFamily();
            constructorObtainFontFamilyCtor = obtainFontFamilyCtor(clsObtainFontFamily);
            methodObtainAddFontFromAssetManagerMethod = obtainAddFontFromAssetManagerMethod(clsObtainFontFamily);
            methodObtainAddFontFromBufferMethod = obtainAddFontFromBufferMethod(clsObtainFontFamily);
            methodObtainFreezeMethod = obtainFreezeMethod(clsObtainFontFamily);
            methodObtainAbortCreationMethod = obtainAbortCreationMethod(clsObtainFontFamily);
            methodObtainCreateFromFamiliesWithDefaultMethod = obtainCreateFromFamiliesWithDefaultMethod(clsObtainFontFamily);
        } catch (ClassNotFoundException | NoSuchMethodException e10) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e10.getClass().getName()), e10);
            clsObtainFontFamily = null;
            constructorObtainFontFamilyCtor = null;
            methodObtainAddFontFromAssetManagerMethod = null;
            methodObtainAddFontFromBufferMethod = null;
            methodObtainFreezeMethod = null;
            methodObtainAbortCreationMethod = null;
            methodObtainCreateFromFamiliesWithDefaultMethod = null;
        }
        this.f16903f = clsObtainFontFamily;
        this.f16904g = constructorObtainFontFamilyCtor;
        this.f16905h = methodObtainAddFontFromAssetManagerMethod;
        this.f16906i = methodObtainAddFontFromBufferMethod;
        this.f16907j = methodObtainFreezeMethod;
        this.f16908k = methodObtainAbortCreationMethod;
        this.f16909l = methodObtainCreateFromFamiliesWithDefaultMethod;
    }

    public Typeface createFromFamiliesWithDefault(Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        try {
            Object objNewInstance = Array.newInstance(this.f16903f, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f16909l.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // o0.f, o0.l
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, d.c cVar, Resources resources, int i10) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Object objNewInstance;
        if (!f()) {
            return super.createFromFontFamilyFilesResourceEntry(context, cVar, resources, i10);
        }
        try {
            objNewInstance = this.f16904g.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance == null) {
            return null;
        }
        for (d.C0204d c0204d : cVar.getEntries()) {
            if (!d(context, objNewInstance, c0204d.getFileName(), c0204d.getTtcIndex(), c0204d.getWeight(), c0204d.isItalic() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(c0204d.getVariationSettings()))) {
                try {
                    this.f16908k.invoke(objNewInstance, new Object[0]);
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                }
                return null;
            }
        }
        if (e(objNewInstance)) {
            return createFromFamiliesWithDefault(objNewInstance);
        }
        return null;
    }

    @Override // o0.f, o0.l
    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, m.b[] bVarArr, int i10) throws IllegalAccessException, InstantiationException, IOException, IllegalArgumentException, InvocationTargetException {
        Object objNewInstance;
        Typeface typefaceCreateFromFamiliesWithDefault;
        boolean zBooleanValue;
        if (bVarArr.length < 1) {
            return null;
        }
        if (f()) {
            Map<Uri, ByteBuffer> fontInfoIntoByteBuffer = m.readFontInfoIntoByteBuffer(context, bVarArr, cancellationSignal);
            try {
                objNewInstance = this.f16904g.newInstance(new Object[0]);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                objNewInstance = null;
            }
            if (objNewInstance == null) {
                return null;
            }
            int length = bVarArr.length;
            int i11 = 0;
            boolean z10 = false;
            while (true) {
                Method method = this.f16908k;
                if (i11 >= length) {
                    if (!z10) {
                        try {
                            method.invoke(objNewInstance, new Object[0]);
                            return null;
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                            return null;
                        }
                    }
                    if (e(objNewInstance) && (typefaceCreateFromFamiliesWithDefault = createFromFamiliesWithDefault(objNewInstance)) != null) {
                        return Typeface.create(typefaceCreateFromFamiliesWithDefault, i10);
                    }
                    return null;
                }
                m.b bVar = bVarArr[i11];
                ByteBuffer byteBuffer = fontInfoIntoByteBuffer.get(bVar.getUri());
                if (byteBuffer != null) {
                    try {
                        zBooleanValue = ((Boolean) this.f16906i.invoke(objNewInstance, byteBuffer, Integer.valueOf(bVar.getTtcIndex()), null, Integer.valueOf(bVar.getWeight()), Integer.valueOf(bVar.isItalic() ? 1 : 0))).booleanValue();
                    } catch (IllegalAccessException | InvocationTargetException unused3) {
                        zBooleanValue = false;
                    }
                    if (!zBooleanValue) {
                        try {
                            method.invoke(objNewInstance, new Object[0]);
                            return null;
                        } catch (IllegalAccessException | InvocationTargetException unused4) {
                            return null;
                        }
                    }
                    z10 = true;
                }
                i11++;
            }
        } else {
            m.b bVarFindBestInfo = findBestInfo(bVarArr, i10);
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(bVarFindBestInfo.getUri(), "r", cancellationSignal);
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(bVarFindBestInfo.getWeight()).setItalic(bVarFindBestInfo.isItalic()).build();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceBuild;
                } finally {
                }
            } catch (IOException unused5) {
                return null;
            }
        }
    }

    @Override // o0.l
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i10, String str, int i11) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Object objNewInstance;
        if (!f()) {
            return super.createFromResourcesFontFile(context, resources, i10, str, i11);
        }
        try {
            objNewInstance = this.f16904g.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance == null) {
            return null;
        }
        if (!d(context, objNewInstance, str, 0, -1, -1, null)) {
            try {
                this.f16908k.invoke(objNewInstance, new Object[0]);
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
            return null;
        }
        if (e(objNewInstance)) {
            return createFromFamiliesWithDefault(objNewInstance);
        }
        return null;
    }

    public final boolean d(Context context, Object obj, String str, int i10, int i11, int i12, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f16905h.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean e(Object obj) {
        try {
            return ((Boolean) this.f16907j.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean f() {
        Method method = this.f16905h;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return method != null;
    }

    public Method obtainAbortCreationMethod(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    public Method obtainAddFontFromAssetManagerMethod(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public Method obtainAddFontFromBufferMethod(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    public Method obtainCreateFromFamiliesWithDefaultMethod(Class<?> cls) throws NoSuchMethodException, SecurityException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    public Class<?> obtainFontFamily() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    public Constructor<?> obtainFontFamilyCtor(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }

    public Method obtainFreezeMethod(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }
}
