package com.google.android.gms.measurement.internal;

import ac.c;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.HttpUrl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzfw {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReference<String[]> f7943b = new AtomicReference<>();

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference<String[]> f7944c = new AtomicReference<>();

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicReference<String[]> f7945d = new AtomicReference<>();

    /* renamed from: a, reason: collision with root package name */
    public final zzfz f7946a;

    public zzfw(zzfz zzfzVar) {
        this.f7946a = zzfzVar;
    }

    public static String a(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        Preconditions.checkArgument(strArr.length == strArr2.length);
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if (Objects.equals(str, strArr[i10])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i10] == null) {
                        strArr3[i10] = strArr2[i10] + "(" + strArr[i10] + ")";
                    }
                    str2 = strArr3[i10];
                }
                return str2;
            }
        }
        return str;
    }

    public final String b(Object[] objArr) {
        if (objArr == null) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sbR = c.r("[");
        for (Object obj : objArr) {
            String strZza = obj instanceof Bundle ? zza((Bundle) obj) : String.valueOf(obj);
            if (strZza != null) {
                if (sbR.length() != 1) {
                    sbR.append(", ");
                }
                sbR.append(strZza);
            }
        }
        sbR.append("]");
        return sbR.toString();
    }

    public final String zza(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!this.f7946a.zza()) {
            return bundle.toString();
        }
        StringBuilder sbR = c.r("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sbR.length() != 8) {
                sbR.append(", ");
            }
            sbR.append(zzb(str));
            sbR.append("=");
            Object obj = bundle.get(str);
            sbR.append(obj instanceof Bundle ? b(new Object[]{obj}) : obj instanceof Object[] ? b((Object[]) obj) : obj instanceof ArrayList ? b(((ArrayList) obj).toArray()) : String.valueOf(obj));
        }
        sbR.append("}]");
        return sbR.toString();
    }

    public final String zzb(String str) {
        if (str == null) {
            return null;
        }
        return !this.f7946a.zza() ? str : a(str, zzis.f8209b, zzis.f8208a, f7944c);
    }

    public final String zzc(String str) {
        if (str == null) {
            return null;
        }
        return !this.f7946a.zza() ? str : str.startsWith("_exp_") ? c.k("experiment_id(", str, ")") : a(str, zziv.f8217b, zziv.f8216a, f7945d);
    }

    public final String zza(zzbf zzbfVar) {
        String strZza = null;
        if (zzbfVar == null) {
            return null;
        }
        zzfz zzfzVar = this.f7946a;
        if (!zzfzVar.zza()) {
            return zzbfVar.toString();
        }
        StringBuilder sb2 = new StringBuilder("origin=");
        sb2.append(zzbfVar.f7722n);
        sb2.append(",name=");
        sb2.append(zza(zzbfVar.f7720b));
        sb2.append(",params=");
        zzba zzbaVar = zzbfVar.f7721m;
        if (zzbaVar != null) {
            if (!zzfzVar.zza()) {
                strZza = zzbaVar.toString();
            } else {
                strZza = zza(zzbaVar.zzb());
            }
        }
        sb2.append(strZza);
        return sb2.toString();
    }

    public final String zza(String str) {
        if (str == null) {
            return null;
        }
        return !this.f7946a.zza() ? str : a(str, zzit.f8214c, zzit.f8212a, f7943b);
    }
}
