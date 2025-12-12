package com.google.android.gms.cast.framework;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzbi extends zzbd {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Session f6786a;

    public /* synthetic */ zzbi(Session session) {
        this.f6786a = session;
    }

    @Override // com.google.android.gms.cast.framework.zzbe
    public final long zzb() {
        return this.f6786a.getSessionRemainingTimeMs();
    }

    @Override // com.google.android.gms.cast.framework.zzbe
    public final IObjectWrapper zzc() {
        return ObjectWrapper.wrap(this.f6786a);
    }

    @Override // com.google.android.gms.cast.framework.zzbe
    public final void zzd(boolean z10) {
        this.f6786a.end(z10);
    }

    @Override // com.google.android.gms.cast.framework.zzbe
    public final void zze(Bundle bundle) {
        this.f6786a.onResuming(bundle);
    }

    @Override // com.google.android.gms.cast.framework.zzbe
    public final void zzf(Bundle bundle) {
        this.f6786a.onStarting(bundle);
    }

    @Override // com.google.android.gms.cast.framework.zzbe
    public final void zzg(Bundle bundle) {
        this.f6786a.resume(bundle);
    }

    @Override // com.google.android.gms.cast.framework.zzbe
    public final void zzh(Bundle bundle) {
        this.f6786a.start(bundle);
    }

    @Override // com.google.android.gms.cast.framework.zzbe
    public final void zzi(Bundle bundle) {
        this.f6786a.zzk(bundle);
    }
}
