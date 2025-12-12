package l0;

import android.app.LocaleManager;
import android.content.Context;
import android.os.Build;
import android.os.LocaleList;

/* compiled from: LocaleManagerCompat.java */
/* loaded from: classes.dex */
public final class k {

    /* compiled from: LocaleManagerCompat.java */
    public static class a {
        public static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        public static LocaleList b(Object obj) {
            return ((LocaleManager) obj).getSystemLocales();
        }
    }

    public static t0.h getApplicationLocales(Context context) {
        if (Build.VERSION.SDK_INT < 33) {
            return t0.h.forLanguageTags(g.readLocales(context));
        }
        Object systemService = context.getSystemService("locale");
        return systemService != null ? t0.h.wrap(a.a(systemService)) : t0.h.getEmptyLocaleList();
    }
}
