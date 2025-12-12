package com.google.android.gms.cast.framework.media.uicontroller;

import com.google.android.gms.cast.framework.media.widget.CastSeekBar;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzh extends com.google.android.gms.cast.framework.media.widget.zzd {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UIMediaController f6632a;

    public zzh(UIMediaController uIMediaController) {
        this.f6632a = uIMediaController;
    }

    @Override // com.google.android.gms.cast.framework.media.widget.zzd
    public final void zza(CastSeekBar castSeekBar, int i10, boolean z10) {
        this.f6632a.zzc(castSeekBar, i10, z10);
    }

    @Override // com.google.android.gms.cast.framework.media.widget.zzd
    public final void zzb(CastSeekBar castSeekBar) {
        this.f6632a.zzd(castSeekBar);
    }

    @Override // com.google.android.gms.cast.framework.media.widget.zzd
    public final void zzc(CastSeekBar castSeekBar) {
        this.f6632a.zze(castSeekBar);
    }
}
