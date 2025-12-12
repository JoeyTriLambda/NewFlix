package com.google.android.gms.cast.internal.media;

import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@KeepForSdk
/* loaded from: classes.dex */
public class MediaCommon {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Integer mediaRepeatModeFromString(java.lang.String r5) {
        /*
            if (r5 != 0) goto L3
            goto L40
        L3:
            int r0 = r5.hashCode()
            r1 = 0
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1118317585: goto L2d;
                case -962896020: goto L23;
                case 1645938909: goto L19;
                case 1645952171: goto Lf;
                default: goto Le;
            }
        Le:
            goto L37
        Lf:
            java.lang.String r0 = "REPEAT_OFF"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L37
            r5 = 0
            goto L38
        L19:
            java.lang.String r0 = "REPEAT_ALL"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L37
            r5 = 1
            goto L38
        L23:
            java.lang.String r0 = "REPEAT_SINGLE"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L37
            r5 = 2
            goto L38
        L2d:
            java.lang.String r0 = "REPEAT_ALL_AND_SHUFFLE"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L37
            r5 = 3
            goto L38
        L37:
            r5 = -1
        L38:
            if (r5 == 0) goto L51
            if (r5 == r4) goto L4c
            if (r5 == r3) goto L47
            if (r5 == r2) goto L42
        L40:
            r5 = 0
            return r5
        L42:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            return r5
        L47:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            return r5
        L4c:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            return r5
        L51:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.internal.media.MediaCommon.mediaRepeatModeFromString(java.lang.String):java.lang.Integer");
    }

    public static String zza(Integer num) {
        if (num == null) {
            return null;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            return "REPEAT_OFF";
        }
        if (iIntValue == 1) {
            return "REPEAT_ALL";
        }
        if (iIntValue == 2) {
            return "REPEAT_SINGLE";
        }
        if (iIntValue != 3) {
            return null;
        }
        return "REPEAT_ALL_AND_SHUFFLE";
    }
}
