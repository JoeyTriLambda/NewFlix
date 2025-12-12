package com.google.android.gms.internal.cast;

import cz.msebera.android.httpclient.message.TokenParser;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzes {
    public static String zza(String str) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            if (zzb(str.charAt(i10))) {
                char[] charArray = str.toCharArray();
                while (i10 < length) {
                    char c10 = charArray[i10];
                    if (zzb(c10)) {
                        charArray[i10] = (char) (c10 ^ TokenParser.SP);
                    }
                    i10++;
                }
                return String.valueOf(charArray);
            }
            i10++;
        }
        return str;
    }

    public static boolean zzb(char c10) {
        return c10 >= 'a' && c10 <= 'z';
    }
}
