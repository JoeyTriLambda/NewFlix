package com.google.android.gms.internal.cast;

import android.graphics.Bitmap;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzby implements com.google.android.gms.cast.framework.media.internal.zza {
    final /* synthetic */ zzca zza;

    public zzby(zzca zzcaVar) {
        this.zza = zzcaVar;
    }

    @Override // com.google.android.gms.cast.framework.media.internal.zza
    public final void zza(Bitmap bitmap) {
        if (bitmap != null) {
            zzca zzcaVar = this.zza;
            if (zzcaVar.zzd != null) {
                zzcaVar.zzd.setVisibility(4);
            }
            this.zza.zza.setVisibility(0);
            this.zza.zza.setImageBitmap(bitmap);
            zzca zzcaVar2 = this.zza;
            if (zzcaVar2.zzf != null) {
                zzcaVar2.zzf.zza();
            }
        }
    }
}
