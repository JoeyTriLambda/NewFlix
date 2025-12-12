package eh;

import java.util.Locale;

/* compiled from: Normalizer.java */
/* loaded from: classes2.dex */
public final class b {
    public static String lowerCase(String str) {
        return str != null ? str.toLowerCase(Locale.ENGLISH) : "";
    }

    public static String normalize(String str) {
        return lowerCase(str).trim();
    }
}
