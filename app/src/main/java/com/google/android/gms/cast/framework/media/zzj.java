package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzj extends zzc {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImagePicker f6764a;

    public /* synthetic */ zzj(ImagePicker imagePicker) {
        this.f6764a = imagePicker;
    }

    @Override // com.google.android.gms.cast.framework.media.zzd
    public final WebImage zze(MediaMetadata mediaMetadata, int i10) {
        return this.f6764a.onPickImage(mediaMetadata, i10);
    }

    @Override // com.google.android.gms.cast.framework.media.zzd
    public final WebImage zzf(MediaMetadata mediaMetadata, ImageHints imageHints) {
        return this.f6764a.onPickImage(mediaMetadata, imageHints);
    }

    @Override // com.google.android.gms.cast.framework.media.zzd
    public final IObjectWrapper zzg() {
        return ObjectWrapper.wrap(this.f6764a);
    }
}
