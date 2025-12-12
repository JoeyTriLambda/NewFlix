package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzc implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzh f6423a;

    public zzc(zzh zzhVar) {
        this.f6423a = zzhVar;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        zzh zzhVar = this.f6423a;
        zzhVar.zzk();
        zzhVar.removeOnLayoutChangeListener(this);
    }
}
