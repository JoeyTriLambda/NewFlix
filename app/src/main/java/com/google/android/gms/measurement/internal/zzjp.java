package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzjp implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zziy f8274b;

    public zzjp(zziy zziyVar) {
        this.f8274b = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        zzt zztVar = this.f8274b.f8239n;
        zzho zzhoVar = zztVar.f8616a;
        zzhoVar.zzl().zzt();
        if (zztVar.b()) {
            if (zztVar.c()) {
                zzhoVar.zzn().f8013x.zza(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1L);
                zzhoVar.zzp().o("auto", "_cmpx", bundle);
            } else {
                String strZza = zzhoVar.zzn().f8013x.zza();
                if (TextUtils.isEmpty(strZza)) {
                    zzhoVar.zzj().zzm().zza("Cache still valid but referrer not found");
                } else {
                    long jZza = ((zzhoVar.zzn().f8014y.zza() / DateUtils.MILLIS_PER_HOUR) - 1) * DateUtils.MILLIS_PER_HOUR;
                    Uri uri = Uri.parse(strZza);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(uri.getPath(), bundle2);
                    for (String str : uri.getQueryParameterNames()) {
                        bundle2.putString(str, uri.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", jZza);
                    Object obj = pair.first;
                    zzhoVar.zzp().o(obj == null ? "app" : (String) obj, "_cmp", (Bundle) pair.second);
                }
                zzhoVar.zzn().f8013x.zza(null);
            }
            zzhoVar.zzn().f8014y.zza(0L);
        }
    }
}
