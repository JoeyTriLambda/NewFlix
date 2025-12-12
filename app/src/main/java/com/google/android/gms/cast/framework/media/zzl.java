package com.google.android.gms.cast.framework.media;

import android.graphics.Bitmap;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzl implements com.google.android.gms.cast.framework.media.internal.zza {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzn f6767a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaNotificationService f6768b;

    public zzl(MediaNotificationService mediaNotificationService, zzn zznVar) {
        this.f6768b = mediaNotificationService;
        this.f6767a = zznVar;
    }

    @Override // com.google.android.gms.cast.framework.media.internal.zza
    public final void zza(Bitmap bitmap) {
        zzn zznVar = this.f6767a;
        zznVar.f6777b = bitmap;
        MediaNotificationService mediaNotificationService = this.f6768b;
        mediaNotificationService.f6476w = zznVar;
        mediaNotificationService.b();
    }
}
