package t0;

import android.os.Build;
import android.os.ext.SdkExtensions;
import java.util.Locale;

/* compiled from: BuildCompat.kt */
/* loaded from: classes.dex */
public final class a {

    /* compiled from: BuildCompat.kt */
    /* renamed from: t0.a$a, reason: collision with other inner class name */
    public static final class C0255a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0255a f19357a = new C0255a();

        public final int getExtensionVersion(int i10) {
            return SdkExtensions.getExtensionVersion(i10);
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        C0255a c0255a = C0255a.f19357a;
        if (i10 >= 30) {
            c0255a.getExtensionVersion(30);
        }
        if (i10 >= 30) {
            c0255a.getExtensionVersion(31);
        }
        if (i10 >= 30) {
            c0255a.getExtensionVersion(33);
        }
        if (i10 >= 30) {
            c0255a.getExtensionVersion(1000000);
        }
    }

    public static final boolean isAtLeastPreReleaseCodename(String str, String str2) {
        zf.i.checkNotNullParameter(str, "codename");
        zf.i.checkNotNullParameter(str2, "buildCodename");
        if (zf.i.areEqual("REL", str2)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        String upperCase = str2.toUpperCase(locale);
        zf.i.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        String upperCase2 = str.toUpperCase(locale);
        zf.i.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase.compareTo(upperCase2) >= 0;
    }

    public static final boolean isAtLeastT() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 33) {
            if (i10 >= 32) {
                String str = Build.VERSION.CODENAME;
                zf.i.checkNotNullExpressionValue(str, "CODENAME");
                if (isAtLeastPreReleaseCodename("Tiramisu", str)) {
                }
            }
            return false;
        }
        return true;
    }
}
