package com.google.android.gms.cast.framework.media.uicontroller;

import android.view.View;
import android.widget.ImageView;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzb implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UIMediaController f6624b;

    public zzb(UIMediaController uIMediaController) {
        this.f6624b = uIMediaController;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f6624b.onMuteToggleClicked((ImageView) view);
    }
}
