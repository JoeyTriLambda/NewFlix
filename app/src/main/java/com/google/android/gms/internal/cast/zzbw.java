package com.google.android.gms.internal.cast;

import android.graphics.Bitmap;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzbw implements com.google.android.gms.cast.framework.media.internal.zza {
    final /* synthetic */ zzbx zza;

    public zzbw(zzbx zzbxVar) {
        this.zza = zzbxVar;
    }

    @Override // com.google.android.gms.cast.framework.media.internal.zza
    public final void zza(Bitmap bitmap) {
        if (bitmap != null) {
            this.zza.zza.setImageBitmap(bitmap);
        }
    }
}
