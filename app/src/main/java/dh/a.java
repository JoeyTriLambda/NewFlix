package dh;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: DataUtil.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f11037a = Pattern.compile("(?i)\\bcharset=\\s*(?:[\"'])?([^\\s,;\"']*)");

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f11038b = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* compiled from: DataUtil.java */
    /* renamed from: dh.a$a, reason: collision with other inner class name */
    public static class C0132a {

        /* renamed from: a, reason: collision with root package name */
        public final String f11039a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f11040b;

        public C0132a(String str, boolean z10) {
            this.f11039a = str;
            this.f11040b = z10;
        }
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = f11037a.matcher(str);
        if (matcher.find()) {
            return b(matcher.group(1).trim().replace("charset=", ""));
        }
        return null;
    }

    public static String b(String str) {
        if (str != null && str.length() != 0) {
            String strReplaceAll = str.trim().replaceAll("[\"']", "");
            try {
                if (Charset.isSupported(strReplaceAll)) {
                    return strReplaceAll;
                }
                String upperCase = strReplaceAll.toUpperCase(Locale.ENGLISH);
                if (Charset.isSupported(upperCase)) {
                    return upperCase;
                }
            } catch (IllegalCharsetNameException unused) {
            }
        }
        return null;
    }

    public static ByteBuffer readToByteBuffer(InputStream inputStream, int i10) throws IOException {
        f.isTrue(i10 >= 0, "maxSize must be 0 (unlimited) or larger");
        return eh.a.wrap(inputStream, 32768, i10).readToByteBuffer(i10);
    }
}
