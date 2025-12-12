package com.google.android.gms.cast.framework.media.uicontroller;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzd implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UIMediaController f6626b;

    public zzd(UIMediaController uIMediaController) {
        this.f6626b = uIMediaController;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f6626b.onSkipNextClicked(view);
    }
}
