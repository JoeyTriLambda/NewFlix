package com.google.android.gms.cast.framework.media.internal;

import android.graphics.Bitmap;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzl implements zza {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzn f6553a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzo f6554b;

    public zzl(zzo zzoVar, zzn zznVar) {
        this.f6554b = zzoVar;
        this.f6553a = zznVar;
    }

    @Override // com.google.android.gms.cast.framework.media.internal.zza
    public final void zza(Bitmap bitmap) {
        zzn zznVar = this.f6553a;
        zznVar.f6563b = bitmap;
        zzo zzoVar = this.f6554b;
        zzoVar.f6578n = zznVar;
        zzoVar.b();
    }
}
