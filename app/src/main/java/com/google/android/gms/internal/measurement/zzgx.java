package com.google.android.gms.internal.measurement;

import android.os.Binder;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final /* synthetic */ class zzgx {
    public static <V> V zza(zzha<V> zzhaVar) {
        try {
            return zzhaVar.zza();
        } catch (SecurityException unused) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzhaVar.zza();
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }
}
