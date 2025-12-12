package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzmt {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f8515b = {"GoogleConsent", "gdprApplies", "EnableAdvertiserConsentMode", "PolicyVersion", "PurposeConsents", "CmpSdkID"};

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f8516a;

    public zzmt(HashMap map) {
        HashMap map2 = new HashMap();
        this.f8516a = map2;
        map2.putAll(map);
    }

    public final String a() {
        StringBuilder sb2 = new StringBuilder();
        String[] strArr = f8515b;
        for (int i10 = 0; i10 < 6; i10++) {
            String str = strArr[i10];
            HashMap map = this.f8516a;
            if (map.containsKey(str)) {
                if (sb2.length() > 0) {
                    sb2.append(";");
                }
                sb2.append(str);
                sb2.append("=");
                sb2.append((String) map.get(str));
            }
        }
        return sb2.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzmt) {
            return a().equalsIgnoreCase(((zzmt) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final String toString() {
        return a();
    }

    public final Bundle zza() {
        String str;
        HashMap map = this.f8516a;
        if (!("1".equals(map.get("GoogleConsent")) && "1".equals(map.get("gdprApplies")) && "1".equals(map.get("EnableAdvertiserConsentMode")))) {
            return Bundle.EMPTY;
        }
        try {
            str = (String) map.get("PolicyVersion");
        } catch (NumberFormatException unused) {
        }
        int i10 = !TextUtils.isEmpty(str) ? Integer.parseInt(str) : -1;
        if (i10 < 0) {
            return Bundle.EMPTY;
        }
        String str2 = (String) map.get("PurposeConsents");
        if (TextUtils.isEmpty(str2)) {
            return Bundle.EMPTY;
        }
        Bundle bundle = new Bundle();
        if (str2.length() > 0) {
            bundle.putString("ad_storage", str2.charAt(0) == '1' ? "granted" : "denied");
        }
        if (str2.length() > 3) {
            bundle.putString("ad_personalization", (str2.charAt(2) == '1' && str2.charAt(3) == '1') ? "granted" : "denied");
        }
        if (str2.length() > 6 && i10 >= 4) {
            bundle.putString("ad_user_data", (str2.charAt(0) == '1' && str2.charAt(6) == '1') ? "granted" : "denied");
        }
        return bundle;
    }

    public final String zzb() throws NumberFormatException {
        String str;
        HashMap map = this.f8516a;
        StringBuilder sb2 = new StringBuilder("1");
        int i10 = -1;
        try {
            str = (String) map.get("CmpSdkID");
        } catch (NumberFormatException unused) {
        }
        int i11 = !TextUtils.isEmpty(str) ? Integer.parseInt(str) : -1;
        if (i11 < 0 || i11 > 4095) {
            sb2.append("00");
        } else {
            sb2.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt((i11 >> 6) & 63));
            sb2.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i11 & 63));
        }
        try {
            String str2 = (String) map.get("PolicyVersion");
            if (!TextUtils.isEmpty(str2)) {
                i10 = Integer.parseInt(str2);
            }
        } catch (NumberFormatException unused2) {
        }
        if (i10 < 0 || i10 > 63) {
            sb2.append("0");
        } else {
            sb2.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i10));
        }
        Preconditions.checkArgument(true);
        int i12 = ("1".equals(map.get("gdprApplies")) ? 2 : 0) | 4;
        if ("1".equals(map.get("EnableAdvertiserConsentMode"))) {
            i12 |= 8;
        }
        sb2.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i12));
        return sb2.toString();
    }

    public static zzmt zza(SharedPreferences sharedPreferences) {
        String string;
        int i10;
        int i11;
        int i12;
        String string2;
        int i13;
        HashMap map = new HashMap();
        try {
            string = sharedPreferences.getString("IABTCF_VendorConsents", "\u0000");
        } catch (ClassCastException unused) {
            string = "\u0000";
        }
        if (!"\u0000".equals(string) && string.length() > 754) {
            map.put("GoogleConsent", String.valueOf(string.charAt(754)));
        }
        try {
            i10 = sharedPreferences.getInt("IABTCF_gdprApplies", -1);
        } catch (ClassCastException unused2) {
            i10 = -1;
        }
        if (i10 != -1) {
            map.put("gdprApplies", String.valueOf(i10));
        }
        try {
            i11 = sharedPreferences.getInt("IABTCF_EnableAdvertiserConsentMode", -1);
        } catch (ClassCastException unused3) {
            i11 = -1;
        }
        if (i11 != -1) {
            map.put("EnableAdvertiserConsentMode", String.valueOf(i11));
        }
        try {
            i12 = sharedPreferences.getInt("IABTCF_PolicyVersion", -1);
        } catch (ClassCastException unused4) {
            i12 = -1;
        }
        if (i12 != -1) {
            map.put("PolicyVersion", String.valueOf(i12));
        }
        try {
            string2 = sharedPreferences.getString("IABTCF_PurposeConsents", "\u0000");
        } catch (ClassCastException unused5) {
            string2 = "\u0000";
        }
        if (!"\u0000".equals(string2)) {
            map.put("PurposeConsents", string2);
        }
        try {
            i13 = sharedPreferences.getInt("IABTCF_CmpSdkID", -1);
        } catch (ClassCastException unused6) {
            i13 = -1;
        }
        if (i13 != -1) {
            map.put("CmpSdkID", String.valueOf(i13));
        }
        return new zzmt(map);
    }

    public static String zza(String str, boolean z10) {
        if (!z10 || str.length() <= 4) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i10 = 1;
        while (true) {
            if (i10 >= 64) {
                i10 = 0;
                break;
            }
            if (charArray[4] == "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i10)) {
                break;
            }
            i10++;
        }
        charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(1 | i10);
        return String.valueOf(charArray);
    }
}
