package x5;

import java.util.Locale;

/* compiled from: UrlTemplate.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final String[] f21614a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f21615b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f21616c;

    /* renamed from: d, reason: collision with root package name */
    public final int f21617d;

    public j(String[] strArr, int[] iArr, String[] strArr2, int i10) {
        this.f21614a = strArr;
        this.f21615b = iArr;
        this.f21616c = strArr2;
        this.f21617d = i10;
    }

    public static j compile(String str) {
        String strSubstring;
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        strArr[0] = "";
        int length = 0;
        int i10 = 0;
        while (length < str.length()) {
            int iIndexOf = str.indexOf("$", length);
            if (iIndexOf == -1) {
                strArr[i10] = strArr[i10] + str.substring(length);
                length = str.length();
            } else if (iIndexOf != length) {
                strArr[i10] = strArr[i10] + str.substring(length, iIndexOf);
                length = iIndexOf;
            } else if (str.startsWith("$$", length)) {
                strArr[i10] = ac.c.o(new StringBuilder(), strArr[i10], "$");
                length += 2;
            } else {
                int i11 = length + 1;
                int iIndexOf2 = str.indexOf("$", i11);
                String strSubstring2 = str.substring(i11, iIndexOf2);
                if (strSubstring2.equals("RepresentationID")) {
                    iArr[i10] = 1;
                } else {
                    int iIndexOf3 = strSubstring2.indexOf("%0");
                    if (iIndexOf3 != -1) {
                        strSubstring = strSubstring2.substring(iIndexOf3);
                        if (!strSubstring.endsWith("d")) {
                            strSubstring = strSubstring.concat("d");
                        }
                        strSubstring2 = strSubstring2.substring(0, iIndexOf3);
                    } else {
                        strSubstring = "%01d";
                    }
                    strSubstring2.getClass();
                    strSubstring2.hashCode();
                    switch (strSubstring2) {
                        case "Number":
                            iArr[i10] = 2;
                            break;
                        case "Time":
                            iArr[i10] = 4;
                            break;
                        case "Bandwidth":
                            iArr[i10] = 3;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid template: ".concat(str));
                    }
                    strArr2[i10] = strSubstring;
                }
                i10++;
                strArr[i10] = "";
                length = iIndexOf2 + 1;
            }
        }
        return new j(strArr, iArr, strArr2, i10);
    }

    public String buildUri(String str, int i10, int i11, long j10) {
        StringBuilder sb2 = new StringBuilder();
        int i12 = 0;
        while (true) {
            String[] strArr = this.f21614a;
            int i13 = this.f21617d;
            if (i12 >= i13) {
                sb2.append(strArr[i13]);
                return sb2.toString();
            }
            sb2.append(strArr[i12]);
            int i14 = this.f21615b[i12];
            if (i14 == 1) {
                sb2.append(str);
            } else {
                String[] strArr2 = this.f21616c;
                if (i14 == 2) {
                    sb2.append(String.format(Locale.US, strArr2[i12], Integer.valueOf(i10)));
                } else if (i14 == 3) {
                    sb2.append(String.format(Locale.US, strArr2[i12], Integer.valueOf(i11)));
                } else if (i14 == 4) {
                    sb2.append(String.format(Locale.US, strArr2[i12], Long.valueOf(j10)));
                }
            }
            i12++;
        }
    }
}
