package com.google.android.gms.cast.framework.media.widget;

import android.view.View;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzi implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ExpandedControllerActivity f6709b;

    public zzi(ExpandedControllerActivity expandedControllerActivity) {
        this.f6709b = expandedControllerActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RemoteMediaClient remoteMediaClientD;
        ExpandedControllerActivity expandedControllerActivity = this.f6709b;
        if (!expandedControllerActivity.f6666p0.isClickable() || (remoteMediaClientD = expandedControllerActivity.d()) == null) {
            return;
        }
        remoteMediaClientD.skipAd();
    }
}
