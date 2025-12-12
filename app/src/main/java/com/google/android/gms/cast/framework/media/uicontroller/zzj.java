package com.google.android.gms.cast.framework.media.uicontroller;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzj implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UIMediaController f6633b;

    public zzj(UIMediaController uIMediaController) {
        this.f6633b = uIMediaController;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f6633b.onLaunchExpandedControllerClicked(view);
    }
}
