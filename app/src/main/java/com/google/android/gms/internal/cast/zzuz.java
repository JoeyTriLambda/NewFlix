package com.google.android.gms.internal.cast;

import ac.c;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzuz {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, TokenParser.SP);
    }

    public static String zza(zzux zzuxVar, String str) throws SecurityException {
        StringBuilder sbU = c.u("# ", str);
        zzd(zzuxVar, sbU, 0);
        return sbU.toString();
    }

    public static void zzb(StringBuilder sb2, int i10, String str, Object obj) throws SecurityException {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb2, i10, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb2, i10, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb2.append('\n');
        zzc(i10, sb2);
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
            sb2.append(zzvx.zza(new zzsr(((String) obj).getBytes(zzty.zzb))));
            sb2.append('\"');
            return;
        }
        if (obj instanceof zzsu) {
            sb2.append(": \"");
            sb2.append(zzvx.zza((zzsu) obj));
            sb2.append('\"');
            return;
        }
        if (obj instanceof zztp) {
            sb2.append(" {");
            zzd((zztp) obj, sb2, i10 + 2);
            sb2.append(StringUtils.LF);
            zzc(i10, sb2);
            sb2.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb2.append(": ");
            sb2.append(obj);
            return;
        }
        int i12 = i10 + 2;
        sb2.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        zzb(sb2, i12, "key", entry.getKey());
        zzb(sb2, i12, "value", entry.getValue());
        sb2.append(StringUtils.LF);
        zzc(i10, sb2);
        sb2.append("}");
    }

    private static void zzc(int i10, StringBuilder sb2) {
        while (i10 > 0) {
            int i11 = 80;
            if (i10 <= 80) {
                i11 = i10;
            }
            sb2.append(zza, 0, i11);
            i10 -= i11;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zzd(com.google.android.gms.internal.cast.zzux r18, java.lang.StringBuilder r19, int r20) throws java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 531
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzuz.zzd(com.google.android.gms.internal.cast.zzux, java.lang.StringBuilder, int):void");
    }
}
