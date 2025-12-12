package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public class ImagePicker {

    /* renamed from: a, reason: collision with root package name */
    public final zzd f6463a = new zzj(this);

    @Deprecated
    public WebImage onPickImage(MediaMetadata mediaMetadata, int i10) {
        if (mediaMetadata == null || !mediaMetadata.hasImages()) {
            return null;
        }
        return mediaMetadata.getImages().get(0);
    }

    public WebImage onPickImage(MediaMetadata mediaMetadata, ImageHints imageHints) {
        return onPickImage(mediaMetadata, imageHints.getType());
    }
}
