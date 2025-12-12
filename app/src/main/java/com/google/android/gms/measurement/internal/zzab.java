package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfh;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.PatternSyntaxException;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
abstract class zzab {

    /* renamed from: a, reason: collision with root package name */
    public final String f7621a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7622b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f7623c;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f7624d;

    /* renamed from: e, reason: collision with root package name */
    public Long f7625e;

    /* renamed from: f, reason: collision with root package name */
    public Long f7626f;

    public zzab(String str, int i10) {
        this.f7621a = str;
        this.f7622b = i10;
    }

    public static Boolean b(Boolean bool, boolean z10) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z10);
    }

    public static Boolean c(String str, zzfh.zzf zzfVar, zzgb zzgbVar) throws IllegalStateException {
        List<String> listZzf;
        Preconditions.checkNotNull(zzfVar);
        if (str == null || !zzfVar.zzj() || zzfVar.zzb() == zzfh.zzf.zza.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        zzfh.zzf.zza zzaVarZzb = zzfVar.zzb();
        zzfh.zzf.zza zzaVar = zzfh.zzf.zza.IN_LIST;
        if (zzaVarZzb == zzaVar) {
            if (zzfVar.zza() == 0) {
                return null;
            }
        } else if (!zzfVar.zzi()) {
            return null;
        }
        zzfh.zzf.zza zzaVarZzb2 = zzfVar.zzb();
        boolean zZzg = zzfVar.zzg();
        String strZze = (zZzg || zzaVarZzb2 == zzfh.zzf.zza.REGEXP || zzaVarZzb2 == zzaVar) ? zzfVar.zze() : zzfVar.zze().toUpperCase(Locale.ENGLISH);
        if (zzfVar.zza() == 0) {
            listZzf = null;
        } else {
            listZzf = zzfVar.zzf();
            if (!zZzg) {
                ArrayList arrayList = new ArrayList(listZzf.size());
                Iterator<String> it = listZzf.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().toUpperCase(Locale.ENGLISH));
                }
                listZzf = Collections.unmodifiableList(arrayList);
            }
        }
        zzfh.zzf.zza zzaVar2 = zzfh.zzf.zza.REGEXP;
        String str2 = zzaVarZzb2 == zzaVar2 ? strZze : null;
        if (zzaVarZzb2 == zzfh.zzf.zza.IN_LIST) {
            if (listZzf == null || listZzf.isEmpty()) {
                return null;
            }
        } else if (strZze == null) {
            return null;
        }
        if (!zZzg && zzaVarZzb2 != zzaVar2) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (zzv.f8625a[zzaVarZzb2.ordinal()]) {
            case 1:
                if (str2 != null) {
                    try {
                        break;
                    } catch (PatternSyntaxException unused) {
                        if (zzgbVar == null) {
                            return null;
                        }
                        zzgbVar.zzu().zza("Invalid regular expression in REGEXP audience filter. expression", str2);
                        return null;
                    }
                }
                break;
            case 6:
                if (listZzf != null) {
                    break;
                }
                break;
        }
        return null;
    }

    public static Boolean d(BigDecimal bigDecimal, zzfh.zzd zzdVar, double d10) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzdVar);
        if (zzdVar.zzh() && zzdVar.zza() != zzfh.zzd.zzb.UNKNOWN_COMPARISON_TYPE) {
            zzfh.zzd.zzb zzbVarZza = zzdVar.zza();
            zzfh.zzd.zzb zzbVar = zzfh.zzd.zzb.BETWEEN;
            if (zzbVarZza == zzbVar) {
                if (!zzdVar.zzl() || !zzdVar.zzk()) {
                    return null;
                }
            } else if (!zzdVar.zzi()) {
                return null;
            }
            zzfh.zzd.zzb zzbVarZza2 = zzdVar.zza();
            if (zzdVar.zza() == zzbVar) {
                if (zznm.E(zzdVar.zzf()) && zznm.E(zzdVar.zze())) {
                    try {
                        BigDecimal bigDecimal5 = new BigDecimal(zzdVar.zzf());
                        bigDecimal4 = new BigDecimal(zzdVar.zze());
                        bigDecimal3 = bigDecimal5;
                        bigDecimal2 = null;
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            }
            if (!zznm.E(zzdVar.zzd())) {
                return null;
            }
            try {
                bigDecimal2 = new BigDecimal(zzdVar.zzd());
                bigDecimal3 = null;
                bigDecimal4 = null;
            } catch (NumberFormatException unused2) {
            }
            if (zzbVarZza2 == zzbVar) {
                if (bigDecimal3 == null) {
                    return null;
                }
            } else if (bigDecimal2 != null) {
            }
            int i10 = zzv.f8626b[zzbVarZza2.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 == 4 && bigDecimal3 != null) {
                            return Boolean.valueOf(bigDecimal.compareTo(bigDecimal3) >= 0 && bigDecimal.compareTo(bigDecimal4) <= 0);
                        }
                        return null;
                    }
                    if (bigDecimal2 != null) {
                        if (d10 != 0.0d) {
                            return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d10).multiply(new BigDecimal(2)))) > 0 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d10).multiply(new BigDecimal(2)))) < 0);
                        }
                        return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
                    }
                } else if (bigDecimal2 != null) {
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) > 0);
                }
            } else if (bigDecimal2 != null) {
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) < 0);
            }
        }
        return null;
    }

    public abstract int a();

    public abstract boolean e();

    public abstract boolean f();
}
