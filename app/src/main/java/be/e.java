package be;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: JsUnpacker.java */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f4871a;

    public e(String str) {
        this.f4871a = null;
        this.f4871a = str;
    }

    public String unpack() throws Exception {
        int i10;
        int i11;
        String strSubstring;
        HashMap map;
        int i12;
        String str;
        int i13;
        HashMap map2;
        int i14;
        try {
            Matcher matcher = Pattern.compile("\\}\\s*\\('(.*)',\\s*(.*?),\\s*(\\d+),\\s*'(.*?)'\\.split\\('\\|'\\)", 32).matcher(new String(this.f4871a));
            if (!matcher.find() || matcher.groupCount() != 4) {
                return null;
            }
            String strReplace = matcher.group(1).replace("\\'", "'");
            String strGroup = matcher.group(2);
            String strGroup2 = matcher.group(3);
            String[] strArrSplit = matcher.group(4).split("\\|");
            try {
                i10 = Integer.parseInt(strGroup);
            } catch (Exception unused) {
                i10 = 36;
            }
            int i15 = 0;
            try {
                i11 = Integer.parseInt(strGroup2);
            } catch (Exception unused2) {
                i11 = 0;
            }
            if (strArrSplit.length != i11) {
                throw new Exception("Unknown p.a.c.k.e.r. encoding");
            }
            if (i10 > 36) {
                strSubstring = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                if (i10 < 62) {
                    strSubstring = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(0, i10);
                } else if (i10 > 62 && i10 < 95) {
                    strSubstring = " !\"#$%&\\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\\\]^_`abcdefghijklmnopqrstuvwxyz{|}~".substring(0, i10);
                } else if (i10 != 62) {
                    strSubstring = i10 == 95 ? " !\"#$%&\\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\\\]^_`abcdefghijklmnopqrstuvwxyz{|}~" : null;
                }
                map = new HashMap(95);
                int i16 = 0;
                while (i16 < strSubstring.length()) {
                    int i17 = i16 + 1;
                    map.put(strSubstring.substring(i16, i17), Integer.valueOf(i16));
                    i16 = i17;
                }
            } else {
                strSubstring = null;
                map = null;
            }
            Matcher matcher2 = Pattern.compile("\\b\\w+\\b").matcher(strReplace);
            StringBuilder sb2 = new StringBuilder(strReplace);
            int length = 0;
            while (matcher2.find()) {
                String strGroup3 = matcher2.group(i15);
                if (strSubstring == null) {
                    i14 = Integer.parseInt(strGroup3, i10);
                    i12 = length;
                    str = strSubstring;
                    i13 = i10;
                    map2 = map;
                } else {
                    String string = new StringBuilder(strGroup3).reverse().toString();
                    int iPow = 0;
                    for (int i18 = 0; i18 < string.length(); i18++) {
                        iPow = (int) ((Math.pow(i10, i18) * ((Integer) r17.get(string.substring(i18, r7))).intValue()) + iPow);
                        map = map;
                        length = length;
                        i10 = i10;
                        strSubstring = strSubstring;
                    }
                    i12 = length;
                    str = strSubstring;
                    i13 = i10;
                    map2 = map;
                    i14 = iPow;
                }
                String str2 = i14 < strArrSplit.length ? strArrSplit[i14] : null;
                if (str2 == null || str2.length() <= 0) {
                    length = i12;
                } else {
                    sb2.replace(matcher2.start() + i12, matcher2.end() + i12, str2);
                    length = (str2.length() - strGroup3.length()) + i12;
                }
                map = map2;
                i10 = i13;
                strSubstring = str;
                i15 = 0;
            }
            return sb2.toString();
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
