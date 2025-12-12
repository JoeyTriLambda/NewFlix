package com.google.android.gms.internal.measurement;

import cz.msebera.android.httpclient.message.TokenParser;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzmp {
    public static String zza(zzij zzijVar) {
        zzms zzmsVar = new zzms(zzijVar);
        StringBuilder sb2 = new StringBuilder(zzmsVar.zza());
        for (int i10 = 0; i10 < zzmsVar.zza(); i10++) {
            byte bZza = zzmsVar.zza(i10);
            if (bZza == 34) {
                sb2.append("\\\"");
            } else if (bZza == 39) {
                sb2.append("\\'");
            } else if (bZza != 92) {
                switch (bZza) {
                    case 7:
                        sb2.append("\\a");
                        break;
                    case 8:
                        sb2.append("\\b");
                        break;
                    case 9:
                        sb2.append("\\t");
                        break;
                    case 10:
                        sb2.append("\\n");
                        break;
                    case 11:
                        sb2.append("\\v");
                        break;
                    case 12:
                        sb2.append("\\f");
                        break;
                    case 13:
                        sb2.append("\\r");
                        break;
                    default:
                        if (bZza < 32 || bZza > 126) {
                            sb2.append(TokenParser.ESCAPE);
                            sb2.append((char) (((bZza >>> 6) & 3) + 48));
                            sb2.append((char) (((bZza >>> 3) & 7) + 48));
                            sb2.append((char) ((bZza & 7) + 48));
                            break;
                        } else {
                            sb2.append((char) bZza);
                            break;
                        }
                }
            } else {
                sb2.append("\\\\");
            }
        }
        return sb2.toString();
    }
}
