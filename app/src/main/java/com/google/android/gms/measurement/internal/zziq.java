package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import cz.msebera.android.httpclient.client.config.CookieSpecs;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zziq {

    /* renamed from: c, reason: collision with root package name */
    public static final zziq f8195c = new zziq(null, null, 100);

    /* renamed from: a, reason: collision with root package name */
    public final EnumMap<zza, zzip> f8196a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8197b;

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
    public enum zza {
        AD_STORAGE("ad_storage"),
        ANALYTICS_STORAGE("analytics_storage"),
        AD_USER_DATA("ad_user_data"),
        AD_PERSONALIZATION("ad_personalization");


        /* renamed from: b, reason: collision with root package name */
        public final String f8203b;

        zza(String str) {
            this.f8203b = str;
        }
    }

    public zziq(EnumMap<zza, zzip> enumMap, int i10) {
        EnumMap<zza, zzip> enumMap2 = new EnumMap<>(zza.class);
        this.f8196a = enumMap2;
        enumMap2.putAll(enumMap);
        this.f8197b = i10;
    }

    public static char a(zzip zzipVar) {
        if (zzipVar == null) {
            return '-';
        }
        int iOrdinal = zzipVar.ordinal();
        if (iOrdinal == 1) {
            return '+';
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? '-' : '1';
        }
        return '0';
    }

    public static zzip b(char c10) {
        return c10 != '+' ? c10 != '0' ? c10 != '1' ? zzip.UNINITIALIZED : zzip.GRANTED : zzip.DENIED : zzip.DEFAULT;
    }

    public static zzip c(Boolean bool) {
        return bool == null ? zzip.UNINITIALIZED : bool.booleanValue() ? zzip.GRANTED : zzip.DENIED;
    }

    public static zzip d(String str) {
        zzip zzipVar = zzip.UNINITIALIZED;
        return str == null ? zzipVar : str.equals("granted") ? zzip.GRANTED : str.equals("denied") ? zzip.DENIED : zzipVar;
    }

    public static String e(int i10) {
        return i10 != -30 ? i10 != -20 ? i10 != -10 ? i10 != 0 ? i10 != 30 ? i10 != 90 ? i10 != 100 ? "OTHER" : "UNKNOWN" : "REMOTE_CONFIG" : "1P_INIT" : "1P_API" : "MANIFEST" : "API" : "TCF";
    }

    public static boolean zza(int i10, int i11) {
        return ((i10 == -20 && i11 == -30) || ((i10 == -30 && i11 == -20) || i10 == i11)) || i10 < i11;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zziq)) {
            return false;
        }
        zziq zziqVar = (zziq) obj;
        for (zza zzaVar : zzir.STORAGE.f8207b) {
            if (this.f8196a.get(zzaVar) != zziqVar.f8196a.get(zzaVar)) {
                return false;
            }
        }
        return this.f8197b == zziqVar.f8197b;
    }

    public final int hashCode() {
        int iHashCode = this.f8197b * 17;
        Iterator<zzip> it = this.f8196a.values().iterator();
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + it.next().hashCode();
        }
        return iHashCode;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("source=");
        sb2.append(e(this.f8197b));
        for (zza zzaVar : zzir.STORAGE.f8207b) {
            sb2.append(",");
            sb2.append(zzaVar.f8203b);
            sb2.append("=");
            zzip zzipVar = this.f8196a.get(zzaVar);
            if (zzipVar == null) {
                sb2.append("uninitialized");
            } else {
                int iOrdinal = zzipVar.ordinal();
                if (iOrdinal == 0) {
                    sb2.append("uninitialized");
                } else if (iOrdinal == 1) {
                    sb2.append(CookieSpecs.DEFAULT);
                } else if (iOrdinal == 2) {
                    sb2.append("denied");
                } else if (iOrdinal == 3) {
                    sb2.append("granted");
                }
            }
        }
        return sb2.toString();
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        Iterator it = this.f8196a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            int iOrdinal = ((zzip) entry.getValue()).ordinal();
            String str = iOrdinal != 2 ? iOrdinal != 3 ? null : "granted" : "denied";
            if (str != null) {
                bundle.putString(((zza) entry.getKey()).f8203b, str);
            }
        }
        return bundle;
    }

    public final zzip zzc() {
        zzip zzipVar = this.f8196a.get(zza.AD_STORAGE);
        return zzipVar == null ? zzip.UNINITIALIZED : zzipVar;
    }

    public final zzip zzd() {
        zzip zzipVar = this.f8196a.get(zza.ANALYTICS_STORAGE);
        return zzipVar == null ? zzip.UNINITIALIZED : zzipVar;
    }

    public final Boolean zze() {
        zzip zzipVar = this.f8196a.get(zza.AD_STORAGE);
        if (zzipVar == null) {
            return null;
        }
        int iOrdinal = zzipVar.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return Boolean.FALSE;
            }
            if (iOrdinal != 3) {
                return null;
            }
        }
        return Boolean.TRUE;
    }

    public final Boolean zzf() {
        zzip zzipVar = this.f8196a.get(zza.ANALYTICS_STORAGE);
        if (zzipVar == null) {
            return null;
        }
        int iOrdinal = zzipVar.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return Boolean.FALSE;
            }
            if (iOrdinal != 3) {
                return null;
            }
        }
        return Boolean.TRUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String zzg() {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "G1"
            r0.<init>(r1)
            com.google.android.gms.measurement.internal.zzir r1 = com.google.android.gms.measurement.internal.zzir.STORAGE
            com.google.android.gms.measurement.internal.zziq$zza[] r1 = r1.zza()
            int r2 = r1.length
            r3 = 0
        Lf:
            if (r3 >= r2) goto L3a
            r4 = r1[r3]
            java.util.EnumMap<com.google.android.gms.measurement.internal.zziq$zza, com.google.android.gms.measurement.internal.zzip> r5 = r7.f8196a
            java.lang.Object r4 = r5.get(r4)
            com.google.android.gms.measurement.internal.zzip r4 = (com.google.android.gms.measurement.internal.zzip) r4
            r5 = 45
            if (r4 == 0) goto L34
            int r4 = r4.ordinal()
            if (r4 == 0) goto L34
            r6 = 1
            if (r4 == r6) goto L32
            r6 = 2
            if (r4 == r6) goto L2f
            r6 = 3
            if (r4 == r6) goto L32
            goto L34
        L2f:
            r5 = 48
            goto L34
        L32:
            r5 = 49
        L34:
            r0.append(r5)
            int r3 = r3 + 1
            goto Lf
        L3a:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zziq.zzg():java.lang.String");
    }

    public final String zzh() {
        StringBuilder sb2 = new StringBuilder("G1");
        for (zza zzaVar : zzir.STORAGE.zza()) {
            sb2.append(a(this.f8196a.get(zzaVar)));
        }
        return sb2.toString();
    }

    public final boolean zzi() {
        return zza(zza.AD_STORAGE);
    }

    public final boolean zzj() {
        return zza(zza.ANALYTICS_STORAGE);
    }

    public final boolean zzk() {
        Iterator<zzip> it = this.f8196a.values().iterator();
        while (it.hasNext()) {
            if (it.next() != zzip.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final int zza() {
        return this.f8197b;
    }

    public static zziq zza(Bundle bundle, int i10) {
        if (bundle == null) {
            return new zziq(null, null, i10);
        }
        EnumMap enumMap = new EnumMap(zza.class);
        for (zza zzaVar : zzir.STORAGE.f8207b) {
            enumMap.put((EnumMap) zzaVar, (zza) d(bundle.getString(zzaVar.f8203b)));
        }
        return new zziq(enumMap, i10);
    }

    public final boolean zzc(zziq zziqVar) {
        return zzb(zziqVar, (zza[]) this.f8196a.keySet().toArray(new zza[0]));
    }

    public zziq(Boolean bool, Boolean bool2, int i10) {
        EnumMap<zza, zzip> enumMap = new EnumMap<>(zza.class);
        this.f8196a = enumMap;
        enumMap.put((EnumMap<zza, zzip>) zza.AD_STORAGE, (zza) c(bool));
        enumMap.put((EnumMap<zza, zzip>) zza.ANALYTICS_STORAGE, (zza) c(bool2));
        this.f8197b = i10;
    }

    public static zziq zzb(String str) {
        return zza(str, 100);
    }

    public final zziq zzb(zziq zziqVar) {
        EnumMap enumMap = new EnumMap(zza.class);
        for (zza zzaVar : zzir.STORAGE.f8207b) {
            zzip zzipVar = this.f8196a.get(zzaVar);
            if (zzipVar == zzip.UNINITIALIZED) {
                zzipVar = zziqVar.f8196a.get(zzaVar);
            }
            if (zzipVar != null) {
                enumMap.put((EnumMap) zzaVar, (zza) zzipVar);
            }
        }
        return new zziq(enumMap, this.f8197b);
    }

    public static zziq zza(zzip zzipVar, zzip zzipVar2, int i10) {
        EnumMap enumMap = new EnumMap(zza.class);
        enumMap.put((EnumMap) zza.AD_STORAGE, (zza) zzipVar);
        enumMap.put((EnumMap) zza.ANALYTICS_STORAGE, (zza) zzipVar2);
        return new zziq(enumMap, -10);
    }

    public final boolean zzb(zziq zziqVar, zza... zzaVarArr) {
        for (zza zzaVar : zzaVarArr) {
            zzip zzipVar = this.f8196a.get(zzaVar);
            zzip zzipVar2 = zziqVar.f8196a.get(zzaVar);
            zzip zzipVar3 = zzip.DENIED;
            if (zzipVar == zzipVar3 && zzipVar2 != zzipVar3) {
                return true;
            }
        }
        return false;
    }

    public static zziq zza(String str, int i10) {
        EnumMap enumMap = new EnumMap(zza.class);
        if (str == null) {
            str = "";
        }
        zza[] zzaVarArrZza = zzir.STORAGE.zza();
        for (int i11 = 0; i11 < zzaVarArrZza.length; i11++) {
            zza zzaVar = zzaVarArrZza[i11];
            int i12 = i11 + 2;
            if (i12 < str.length()) {
                enumMap.put((EnumMap) zzaVar, (zza) b(str.charAt(i12)));
            } else {
                enumMap.put((EnumMap) zzaVar, (zza) zzip.UNINITIALIZED);
            }
        }
        return new zziq(enumMap, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zziq zza(com.google.android.gms.measurement.internal.zziq r9) {
        /*
            r8 = this;
            java.util.EnumMap r0 = new java.util.EnumMap
            java.lang.Class<com.google.android.gms.measurement.internal.zziq$zza> r1 = com.google.android.gms.measurement.internal.zziq.zza.class
            r0.<init>(r1)
            com.google.android.gms.measurement.internal.zzir r1 = com.google.android.gms.measurement.internal.zzir.STORAGE
            com.google.android.gms.measurement.internal.zziq$zza[] r1 = r1.f8207b
            int r2 = r1.length
            r3 = 0
        Ld:
            if (r3 >= r2) goto L4b
            r4 = r1[r3]
            java.util.EnumMap<com.google.android.gms.measurement.internal.zziq$zza, com.google.android.gms.measurement.internal.zzip> r5 = r8.f8196a
            java.lang.Object r5 = r5.get(r4)
            com.google.android.gms.measurement.internal.zzip r5 = (com.google.android.gms.measurement.internal.zzip) r5
            java.util.EnumMap<com.google.android.gms.measurement.internal.zziq$zza, com.google.android.gms.measurement.internal.zzip> r6 = r9.f8196a
            java.lang.Object r6 = r6.get(r4)
            com.google.android.gms.measurement.internal.zzip r6 = (com.google.android.gms.measurement.internal.zzip) r6
            if (r5 != 0) goto L24
            goto L33
        L24:
            if (r6 != 0) goto L27
            goto L43
        L27:
            com.google.android.gms.measurement.internal.zzip r7 = com.google.android.gms.measurement.internal.zzip.UNINITIALIZED
            if (r5 != r7) goto L2c
            goto L33
        L2c:
            if (r6 != r7) goto L2f
            goto L43
        L2f:
            com.google.android.gms.measurement.internal.zzip r7 = com.google.android.gms.measurement.internal.zzip.DEFAULT
            if (r5 != r7) goto L35
        L33:
            r5 = r6
            goto L43
        L35:
            if (r6 != r7) goto L38
            goto L43
        L38:
            com.google.android.gms.measurement.internal.zzip r7 = com.google.android.gms.measurement.internal.zzip.DENIED
            if (r5 == r7) goto L42
            if (r6 != r7) goto L3f
            goto L42
        L3f:
            com.google.android.gms.measurement.internal.zzip r5 = com.google.android.gms.measurement.internal.zzip.GRANTED
            goto L43
        L42:
            r5 = r7
        L43:
            if (r5 == 0) goto L48
            r0.put(r4, r5)
        L48:
            int r3 = r3 + 1
            goto Ld
        L4b:
            com.google.android.gms.measurement.internal.zziq r9 = new com.google.android.gms.measurement.internal.zziq
            r1 = 100
            r9.<init>(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zziq.zza(com.google.android.gms.measurement.internal.zziq):com.google.android.gms.measurement.internal.zziq");
    }

    public static String zza(Bundle bundle) {
        String string;
        zza[] zzaVarArr = zzir.STORAGE.f8207b;
        int length = zzaVarArr.length;
        int i10 = 0;
        while (true) {
            Boolean bool = null;
            if (i10 >= length) {
                return null;
            }
            zza zzaVar = zzaVarArr[i10];
            if (bundle.containsKey(zzaVar.f8203b) && (string = bundle.getString(zzaVar.f8203b)) != null) {
                if (string.equals("granted")) {
                    bool = Boolean.TRUE;
                } else if (string.equals("denied")) {
                    bool = Boolean.FALSE;
                }
                if (bool == null) {
                    return string;
                }
            }
            i10++;
        }
    }

    public final boolean zza(zziq zziqVar, zza... zzaVarArr) {
        for (zza zzaVar : zzaVarArr) {
            if (!zziqVar.zza(zzaVar) && zza(zzaVar)) {
                return true;
            }
        }
        return false;
    }

    public final boolean zza(zza zzaVar) {
        return this.f8196a.get(zzaVar) != zzip.DENIED;
    }
}
