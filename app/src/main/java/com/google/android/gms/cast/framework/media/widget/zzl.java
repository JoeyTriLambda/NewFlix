package com.google.android.gms.cast.framework.media.widget;

import com.google.android.gms.cast.Cast;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzl extends Cast.Listener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExpandedControllerActivity f6713a;

    public zzl(ExpandedControllerActivity expandedControllerActivity) {
        this.f6713a = expandedControllerActivity;
    }

    @Override // com.google.android.gms.cast.Cast.Listener
    public final void onDeviceNameChanged() {
        int i10 = ExpandedControllerActivity.f6650z0;
        this.f6713a.g();
    }
}
