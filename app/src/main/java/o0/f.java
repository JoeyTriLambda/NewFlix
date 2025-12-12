package o0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import n0.d;
import u0.m;

/* compiled from: TypefaceCompatApi21Impl.java */
/* loaded from: classes.dex */
public class f extends l {

    /* renamed from: a, reason: collision with root package name */
    public static Class<?> f16894a = null;

    /* renamed from: b, reason: collision with root package name */
    public static Constructor<?> f16895b = null;

    /* renamed from: c, reason: collision with root package name */
    public static Method f16896c = null;

    /* renamed from: d, reason: collision with root package name */
    public static Method f16897d = null;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f16898e = false;

    public static boolean b(Object obj, String str, int i10, boolean z10) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        c();
        try {
            return ((Boolean) f16896c.invoke(obj, str, Integer.valueOf(i10), Boolean.valueOf(z10))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static void c() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method method2;
        if (f16898e) {
            return;
        }
        f16898e = true;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
        } catch (ClassNotFoundException | NoSuchMethodException e10) {
            Log.e("TypefaceCompatApi21Impl", e10.getClass().getName(), e10);
            cls = null;
            method = null;
            constructor = null;
            method2 = null;
        }
        f16895b = constructor;
        f16894a = cls;
        f16896c = method2;
        f16897d = method;
    }

    @Override // o0.l
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, d.c cVar, Resources resources, int i10) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, SecurityException, ArrayIndexOutOfBoundsException, IllegalArgumentException, InvocationTargetException, NegativeArraySizeException {
        c();
        try {
            Object objNewInstance = f16895b.newInstance(new Object[0]);
            for (d.C0204d c0204d : cVar.getEntries()) {
                File tempFile = m.getTempFile(context);
                if (tempFile == null) {
                    return null;
                }
                try {
                    if (!m.copyToFile(tempFile, resources, c0204d.getResourceId())) {
                        return null;
                    }
                    if (!b(objNewInstance, tempFile.getPath(), c0204d.getWeight(), c0204d.isItalic())) {
                        return null;
                    }
                    tempFile.delete();
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    tempFile.delete();
                }
            }
            c();
            try {
                Object objNewInstance2 = Array.newInstance(f16894a, 1);
                Array.set(objNewInstance2, 0, objNewInstance);
                return (Typeface) f16897d.invoke(null, objNewInstance2);
            } catch (IllegalAccessException | InvocationTargetException e10) {
                throw new RuntimeException(e10);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    @Override // o0.l
    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, m.b[] bVarArr, int i10) throws IOException {
        String str;
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(findBestInfo(bVarArr, i10).getUri(), "r", cancellationSignal);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                }
                return null;
            }
            try {
                try {
                    str = Os.readlink("/proc/self/fd/" + parcelFileDescriptorOpenFileDescriptor.getFd());
                } catch (ErrnoException unused) {
                }
                File file = OsConstants.S_ISREG(Os.stat(str).st_mode) ? new File(str) : null;
                if (file != null && file.canRead()) {
                    Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceCreateFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    Typeface typefaceCreateFromInputStream = createFromInputStream(context, fileInputStream);
                    fileInputStream.close();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceCreateFromInputStream;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused2) {
            return null;
        }
    }
}
