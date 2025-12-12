package v0;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: ICUCompat.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f20406a;

    /* compiled from: ICUCompat.java */
    public static class a {
        public static String a(Locale locale) {
            return locale.getScript();
        }
    }

    /* compiled from: ICUCompat.java */
    /* renamed from: v0.b$b, reason: collision with other inner class name */
    public static class C0291b {
        public static ULocale a(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        public static ULocale b(Locale locale) {
            return ULocale.forLocale(locale);
        }

        public static String c(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                f20406a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    public static String maximizeAndGetScript(Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return C0291b.c(C0291b.a(C0291b.b(locale)));
        }
        try {
            return a.a((Locale) f20406a.invoke(null, locale));
        } catch (IllegalAccessException e10) {
            Log.w("ICUCompat", e10);
            return a.a(locale);
        } catch (InvocationTargetException e11) {
            Log.w("ICUCompat", e11);
            return a.a(locale);
        }
    }
}
