package t0;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;

/* compiled from: ConfigurationCompat.java */
/* loaded from: classes.dex */
public final class e {

    /* compiled from: ConfigurationCompat.java */
    public static class a {
        public static LocaleList a(Configuration configuration) {
            return configuration.getLocales();
        }

        public static void b(Configuration configuration, h hVar) {
            configuration.setLocales((LocaleList) hVar.unwrap());
        }
    }

    public static h getLocales(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? h.wrap(a.a(configuration)) : h.create(configuration.locale);
    }

    public static void setLocales(Configuration configuration, h hVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            a.b(configuration, hVar);
        } else {
            if (hVar.isEmpty()) {
                return;
            }
            configuration.setLocale(hVar.get(0));
        }
    }
}
