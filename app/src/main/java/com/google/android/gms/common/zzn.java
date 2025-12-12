package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
final class zzn {

    /* renamed from: e, reason: collision with root package name */
    public static volatile zzag f7536e;

    /* renamed from: g, reason: collision with root package name */
    public static Context f7538g;

    /* renamed from: a, reason: collision with root package name */
    public static final zzf f7532a = new zzf(zzj.zze("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));

    /* renamed from: b, reason: collision with root package name */
    public static final zzg f7533b = new zzg(zzj.zze("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));

    /* renamed from: c, reason: collision with root package name */
    public static final zzh f7534c = new zzh(zzj.zze("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));

    /* renamed from: d, reason: collision with root package name */
    public static final zzi f7535d = new zzi(zzj.zze("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));

    /* renamed from: f, reason: collision with root package name */
    public static final Object f7537f = new Object();

    public static synchronized void a(Context context) {
        if (f7538g != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            f7538g = context.getApplicationContext();
        }
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [com.google.android.gms.common.zze] */
    public static zzx b(final String str, final zzj zzjVar, final boolean z10, boolean z11) {
        try {
            c();
            Preconditions.checkNotNull(f7538g);
            try {
                return f7536e.zzh(new zzs(str, zzjVar, z10, z11), ObjectWrapper.wrap(f7538g.getPackageManager())) ? zzx.f7554d : new zzv(new Callable() { // from class: com.google.android.gms.common.zze
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        zzf zzfVar = zzn.f7532a;
                        boolean z12 = z10;
                        String str2 = str;
                        zzj zzjVar2 = zzjVar;
                        String str3 = true != (!z12 && zzn.b(str2, zzjVar2, true, false).f7555a) ? "not allowed" : "debug cert rejected";
                        MessageDigest messageDigestZza = AndroidUtilsLight.zza("SHA-256");
                        Preconditions.checkNotNull(messageDigestZza);
                        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str3, str2, Hex.bytesToStringLowercase(messageDigestZza.digest(zzjVar2.b())), Boolean.valueOf(z12), "12451000.false");
                    }
                });
            } catch (RemoteException e10) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
                return zzx.c("module call", e10);
            }
        } catch (DynamiteModule.LoadingException e11) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e11);
            return zzx.c("module init: ".concat(String.valueOf(e11.getMessage())), e11);
        }
    }

    public static void c() throws DynamiteModule.LoadingException {
        if (f7536e != null) {
            return;
        }
        Preconditions.checkNotNull(f7538g);
        synchronized (f7537f) {
            if (f7536e == null) {
                f7536e = zzaf.zzb(DynamiteModule.load(f7538g, DynamiteModule.f7569d, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
            }
        }
    }
}
