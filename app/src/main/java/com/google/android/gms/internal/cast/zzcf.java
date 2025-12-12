package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.Cast;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzcf extends Cast.Listener {
    final /* synthetic */ zzcg zza;

    public zzcf(zzcg zzcgVar) {
        this.zza = zzcgVar;
    }

    @Override // com.google.android.gms.cast.Cast.Listener
    public final void onVolumeChanged() {
        this.zza.zza();
    }
}
