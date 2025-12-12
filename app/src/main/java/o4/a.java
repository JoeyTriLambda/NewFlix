package o4;

import c8.i;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import q4.g;

/* compiled from: CCTDestination.java */
/* loaded from: classes.dex */
public final class a implements g {

    /* renamed from: c, reason: collision with root package name */
    public static final String f16995c;

    /* renamed from: d, reason: collision with root package name */
    public static final Set<n4.b> f16996d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f16997e;

    /* renamed from: f, reason: collision with root package name */
    public static final a f16998f;

    /* renamed from: a, reason: collision with root package name */
    public final String f16999a;

    /* renamed from: b, reason: collision with root package name */
    public final String f17000b;

    static {
        String strF = i.f("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f16995c = strF;
        String strF2 = i.f("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        String strF3 = i.f("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f16996d = Collections.unmodifiableSet(new HashSet(Arrays.asList(n4.b.of("proto"), n4.b.of("json"))));
        f16997e = new a(strF, null);
        f16998f = new a(strF2, strF3);
    }

    public a(String str, String str2) {
        this.f16999a = str;
        this.f17000b = str2;
    }

    public static a fromByteArray(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] strArrSplit = str.substring(2).split(Pattern.quote("\\"), 2);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = strArrSplit[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new a(str2, str3);
    }

    public byte[] asByteArray() {
        String str = this.f16999a;
        String str2 = this.f17000b;
        if (str2 == null && str == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = str;
        objArr[2] = "\\";
        if (str2 == null) {
            str2 = "";
        }
        objArr[3] = str2;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName("UTF-8"));
    }

    public String getAPIKey() {
        return this.f17000b;
    }

    public String getEndPoint() {
        return this.f16999a;
    }

    @Override // q4.f
    public byte[] getExtras() {
        return asByteArray();
    }

    @Override // q4.f
    public String getName() {
        return "cct";
    }

    @Override // q4.g
    public Set<n4.b> getSupportedEncodings() {
        return f16996d;
    }
}
