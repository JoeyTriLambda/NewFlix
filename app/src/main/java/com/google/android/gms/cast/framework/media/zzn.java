package com.google.android.gms.cast.framework.media;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.images.WebImage;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzn {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f6776a;

    /* renamed from: b, reason: collision with root package name */
    public Bitmap f6777b;

    public zzn(WebImage webImage) {
        this.f6776a = webImage == null ? null : webImage.getUrl();
    }
}
