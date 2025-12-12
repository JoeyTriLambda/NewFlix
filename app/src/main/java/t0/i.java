package t0;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

/* compiled from: LocaleListCompatWrapper.java */
/* loaded from: classes.dex */
public final class i implements j {

    /* renamed from: c, reason: collision with root package name */
    public static final Locale[] f19365c = new Locale[0];

    /* renamed from: a, reason: collision with root package name */
    public final Locale[] f19366a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19367b;

    static {
        new Locale("en", "XA");
        new Locale("ar", "XB");
        String[] strArrSplit = "en-Latn".split("-", -1);
        if (strArrSplit.length > 2) {
            new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
        } else if (strArrSplit.length > 1) {
            new Locale(strArrSplit[0], strArrSplit[1]);
        } else {
            if (strArrSplit.length != 1) {
                throw new IllegalArgumentException("Can not parse language tag: [en-Latn]");
            }
            new Locale(strArrSplit[0]);
        }
    }

    public i(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f19366a = f19365c;
            this.f19367b = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < localeArr.length; i10++) {
            Locale locale = localeArr[i10];
            if (locale == null) {
                throw new NullPointerException(o1.a.d("list[", i10, "] is null"));
            }
            if (!hashSet.contains(locale)) {
                Locale locale2 = (Locale) locale.clone();
                arrayList.add(locale2);
                sb2.append(locale2.getLanguage());
                String country = locale2.getCountry();
                if (country != null && !country.isEmpty()) {
                    sb2.append('-');
                    sb2.append(locale2.getCountry());
                }
                if (i10 < localeArr.length - 1) {
                    sb2.append(',');
                }
                hashSet.add(locale2);
            }
        }
        this.f19366a = (Locale[]) arrayList.toArray(new Locale[0]);
        this.f19367b = sb2.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        Locale[] localeArr = ((i) obj).f19366a;
        Locale[] localeArr2 = this.f19366a;
        if (localeArr2.length != localeArr.length) {
            return false;
        }
        for (int i10 = 0; i10 < localeArr2.length; i10++) {
            if (!localeArr2[i10].equals(localeArr[i10])) {
                return false;
            }
        }
        return true;
    }

    @Override // t0.j
    public Locale get(int i10) {
        if (i10 >= 0) {
            Locale[] localeArr = this.f19366a;
            if (i10 < localeArr.length) {
                return localeArr[i10];
            }
        }
        return null;
    }

    @Override // t0.j
    public Object getLocaleList() {
        return null;
    }

    public int hashCode() {
        int iHashCode = 1;
        for (Locale locale : this.f19366a) {
            iHashCode = (iHashCode * 31) + locale.hashCode();
        }
        return iHashCode;
    }

    @Override // t0.j
    public boolean isEmpty() {
        return this.f19366a.length == 0;
    }

    @Override // t0.j
    public int size() {
        return this.f19366a.length;
    }

    @Override // t0.j
    public String toLanguageTags() {
        return this.f19367b;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        int i10 = 0;
        while (true) {
            Locale[] localeArr = this.f19366a;
            if (i10 >= localeArr.length) {
                sb2.append("]");
                return sb2.toString();
            }
            sb2.append(localeArr[i10]);
            if (i10 < localeArr.length - 1) {
                sb2.append(',');
            }
            i10++;
        }
    }
}
