package j8;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzit;
import com.google.android.gms.measurement.internal.zziv;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.6.1 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final ImmutableSet<String> f14675a = ImmutableSet.of("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire");

    /* renamed from: b, reason: collision with root package name */
    public static final ImmutableList<String> f14676b = ImmutableList.of("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");

    /* renamed from: c, reason: collision with root package name */
    public static final ImmutableList<String> f14677c = ImmutableList.of("auto", "app", "am");

    /* renamed from: d, reason: collision with root package name */
    public static final ImmutableList<String> f14678d = ImmutableList.of("_r", "_dbg");

    static {
        new ImmutableList.a().add((Object[]) zziv.f8216a).add((Object[]) zziv.f8217b).build();
        ImmutableList.of("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");
    }

    public static String zza(String str) {
        String strZza = zzit.zza(str);
        return strZza != null ? strZza : str;
    }

    public static boolean zzb(String str, String str2, Bundle bundle) {
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!zzf(str) || bundle == null) {
            return false;
        }
        ImmutableList<String> immutableList = f14678d;
        int size = immutableList.size();
        int i10 = 0;
        while (i10 < size) {
            String str3 = immutableList.get(i10);
            i10++;
            if (bundle.containsKey(str3)) {
                return false;
            }
        }
        str.getClass();
        switch (str) {
            case "fcm":
                bundle.putString("_cis", "fcm_integration");
                return true;
            case "fdl":
                bundle.putString("_cis", "fdl_integration");
                return true;
            case "fiam":
                bundle.putString("_cis", "fiam_integration");
                return true;
            default:
                return false;
        }
    }

    public static boolean zze(String str) {
        return !f14675a.contains(str);
    }

    public static boolean zzf(String str) {
        return !f14677c.contains(str);
    }

    public static void zza(String str, String str2, Bundle bundle) {
        if ("clx".equals(str) && "_ae".equals(str2)) {
            bundle.putLong("_r", 1L);
        }
    }

    public static boolean zza(String str, Bundle bundle) {
        if (f14676b.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        ImmutableList<String> immutableList = f14678d;
        int size = immutableList.size();
        int i10 = 0;
        while (i10 < size) {
            String str2 = immutableList.get(i10);
            i10++;
            if (bundle.containsKey(str2)) {
                return false;
            }
        }
        return true;
    }
}
