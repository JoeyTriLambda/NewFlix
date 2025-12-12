package com.google.android.gms.measurement.internal;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzmr extends zzav {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzmo f8512e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzmr(zzmo zzmoVar, zzho zzhoVar) {
        super(zzhoVar);
        this.f8512e = zzmoVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzav
    public final void zzb() throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        zzmo zzmoVar = this.f8512e;
        zzmoVar.f8509d.zzt();
        zzmi zzmiVar = zzmoVar.f8509d;
        zzmoVar.zza(false, false, zzmiVar.zzb().elapsedRealtime());
        zzmiVar.zzc().zza(zzmiVar.zzb().elapsedRealtime());
    }
}
