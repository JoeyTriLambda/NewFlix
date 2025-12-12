package com.google.android.gms.cast.framework.media.uicontroller;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzf implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f6628b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ UIMediaController f6629m;

    public zzf(UIMediaController uIMediaController, long j10) {
        this.f6629m = uIMediaController;
        this.f6628b = j10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f6629m.onForwardClicked(view, this.f6628b);
    }
}
