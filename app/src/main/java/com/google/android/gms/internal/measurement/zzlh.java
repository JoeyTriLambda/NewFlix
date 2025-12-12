package com.google.android.gms.internal.measurement;

import ac.c;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzlh {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, TokenParser.SP);
    }

    public static String zza(zzlg zzlgVar, String str) throws SecurityException {
        StringBuilder sbU = c.u("# ", str);
        zza(zzlgVar, sbU, 0);
        return sbU.toString();
    }

    private static void zza(int i10, StringBuilder sb2) {
        while (i10 > 0) {
            char[] cArr = zza;
            int length = i10 > cArr.length ? cArr.length : i10;
            sb2.append(cArr, 0, length);
            i10 -= length;
        }
    }

    public static void zza(StringBuilder sb2, int i10, String str, Object obj) throws SecurityException {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zza(sb2, i10, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zza(sb2, i10, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb2.append('\n');
        zza(i10, sb2);
        if (!str.isEmpty()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(Character.toLowerCase(str.charAt(0)));
            for (int i11 = 1; i11 < str.length(); i11++) {
                char cCharAt = str.charAt(i11);
                if (Character.isUpperCase(cCharAt)) {
                    sb3.append("_");
                }
                sb3.append(Character.toLowerCase(cCharAt));
            }
            str = sb3.toString();
        }
        sb2.append(str);
        if (obj instanceof String) {
            sb2.append(": \"");
            sb2.append(zzmp.zza(zzij.zza((String) obj)));
            sb2.append('\"');
            return;
        }
        if (obj instanceof zzij) {
            sb2.append(": \"");
            sb2.append(zzmp.zza((zzij) obj));
            sb2.append('\"');
            return;
        }
        if (obj instanceof zzjt) {
            sb2.append(" {");
            zza((zzjt) obj, sb2, i10 + 2);
            sb2.append(StringUtils.LF);
            zza(i10, sb2);
            sb2.append("}");
            return;
        }
        if (obj instanceof Map.Entry) {
            sb2.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            int i12 = i10 + 2;
            zza(sb2, i12, "key", entry.getKey());
            zza(sb2, i12, "value", entry.getValue());
            sb2.append(StringUtils.LF);
            zza(i10, sb2);
            sb2.append("}");
            return;
        }
        sb2.append(": ");
        sb2.append(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zza(com.google.android.gms.internal.measurement.zzlg r19, java.lang.StringBuilder r20, int r21) throws java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 569
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlh.zza(com.google.android.gms.internal.measurement.zzlg, java.lang.StringBuilder, int):void");
    }
}
