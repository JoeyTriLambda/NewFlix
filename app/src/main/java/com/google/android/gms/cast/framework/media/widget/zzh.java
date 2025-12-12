package com.google.android.gms.cast.framework.media.widget;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzh implements com.google.android.gms.cast.framework.media.internal.zza {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExpandedControllerActivity f6708a;

    public zzh(ExpandedControllerActivity expandedControllerActivity) {
        this.f6708a = expandedControllerActivity;
    }

    @Override // com.google.android.gms.cast.framework.media.internal.zza
    @TargetApi(23)
    public final void zza(Bitmap bitmap) {
        if (bitmap != null) {
            ExpandedControllerActivity expandedControllerActivity = this.f6708a;
            TextView textView = expandedControllerActivity.f6664n0;
            if (textView != null) {
                textView.setVisibility(8);
            }
            ImageView imageView = expandedControllerActivity.f6663m0;
            if (imageView != null) {
                imageView.setVisibility(0);
                expandedControllerActivity.f6663m0.setImageBitmap(bitmap);
            }
        }
    }
}
