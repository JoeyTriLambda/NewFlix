package t0;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

/* compiled from: LocaleListCompat.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public static final h f19362b = create(new Locale[0]);

    /* renamed from: a, reason: collision with root package name */
    public final j f19363a;

    /* compiled from: LocaleListCompat.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final Locale[] f19364a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        public static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        public static boolean b(Locale locale, Locale locale2) {
            boolean z10;
            boolean z11;
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage())) {
                return false;
            }
            Locale[] localeArr = f19364a;
            int length = localeArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    z10 = false;
                    break;
                }
                if (localeArr[i10].equals(locale)) {
                    z10 = true;
                    break;
                }
                i10++;
            }
            if (!z10) {
                int length2 = localeArr.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length2) {
                        z11 = false;
                        break;
                    }
                    if (localeArr[i11].equals(locale2)) {
                        z11 = true;
                        break;
                    }
                    i11++;
                }
                if (!z11) {
                    String strMaximizeAndGetScript = v0.b.maximizeAndGetScript(locale);
                    if (!strMaximizeAndGetScript.isEmpty()) {
                        return strMaximizeAndGetScript.equals(v0.b.maximizeAndGetScript(locale2));
                    }
                    String country = locale.getCountry();
                    return country.isEmpty() || country.equals(locale2.getCountry());
                }
            }
            return false;
        }
    }

    /* compiled from: LocaleListCompat.java */
    public static class b {
        public static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        public static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        public static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    public h(j jVar) {
        this.f19363a = jVar;
    }

    public static h create(Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? wrap(b.a(localeArr)) : new h(new i(localeArr));
    }

    public static h forLanguageTags(String str) {
        if (str == null || str.isEmpty()) {
            return getEmptyLocaleList();
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i10 = 0; i10 < length; i10++) {
            localeArr[i10] = a.a(strArrSplit[i10]);
        }
        return create(localeArr);
    }

    public static h getEmptyLocaleList() {
        return f19362b;
    }

    public static h wrap(LocaleList localeList) {
        return new h(new l(localeList));
    }

    public boolean equals(Object obj) {
        if (obj instanceof h) {
            if (this.f19363a.equals(((h) obj).f19363a)) {
                return true;
            }
        }
        return false;
    }

    public Locale get(int i10) {
        return this.f19363a.get(i10);
    }

    public int hashCode() {
        return this.f19363a.hashCode();
    }

    public boolean isEmpty() {
        return this.f19363a.isEmpty();
    }

    public int size() {
        return this.f19363a.size();
    }

    public String toLanguageTags() {
        return this.f19363a.toLanguageTags();
    }

    public String toString() {
        return this.f19363a.toString();
    }

    public Object unwrap() {
        return this.f19363a.getLocaleList();
    }
}
