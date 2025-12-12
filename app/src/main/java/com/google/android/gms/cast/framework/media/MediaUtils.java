package com.google.android.gms.cast.framework.media;

import android.net.Uri;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public class MediaUtils {
    private MediaUtils() {
    }

    public static Uri getImageUri(MediaInfo mediaInfo, int i10) {
        MediaMetadata metadata;
        if (mediaInfo == null || (metadata = mediaInfo.getMetadata()) == null || metadata.getImages() == null || metadata.getImages().size() <= i10) {
            return null;
        }
        return metadata.getImages().get(i10).getUrl();
    }
}
