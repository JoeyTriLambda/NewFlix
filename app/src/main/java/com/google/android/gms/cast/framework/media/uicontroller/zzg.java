package com.google.android.gms.cast.framework.media.uicontroller;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzg implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f6630b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ UIMediaController f6631m;

    public zzg(UIMediaController uIMediaController, long j10) {
        this.f6631m = uIMediaController;
        this.f6630b = j10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f6631m.onRewindClicked(view, this.f6630b);
    }
}
