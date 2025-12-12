package com.google.android.gms.cast.framework.media;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public abstract class zzc extends com.google.android.gms.internal.cast.zzb implements zzd {
    public zzc() {
        super("com.google.android.gms.cast.framework.media.IImagePicker");
    }

    @Override // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            MediaMetadata mediaMetadata = (MediaMetadata) com.google.android.gms.internal.cast.zzc.zza(parcel, MediaMetadata.CREATOR);
            int i12 = parcel.readInt();
            com.google.android.gms.internal.cast.zzc.zzb(parcel);
            WebImage webImageZze = zze(mediaMetadata, i12);
            parcel2.writeNoException();
            com.google.android.gms.internal.cast.zzc.zzd(parcel2, webImageZze);
        } else if (i10 == 2) {
            IObjectWrapper iObjectWrapperZzg = zzg();
            parcel2.writeNoException();
            com.google.android.gms.internal.cast.zzc.zze(parcel2, iObjectWrapperZzg);
        } else if (i10 == 3) {
            parcel2.writeNoException();
            parcel2.writeInt(12451000);
        } else {
            if (i10 != 4) {
                return false;
            }
            MediaMetadata mediaMetadata2 = (MediaMetadata) com.google.android.gms.internal.cast.zzc.zza(parcel, MediaMetadata.CREATOR);
            ImageHints imageHints = (ImageHints) com.google.android.gms.internal.cast.zzc.zza(parcel, ImageHints.CREATOR);
            com.google.android.gms.internal.cast.zzc.zzb(parcel);
            WebImage webImageZzf = zzf(mediaMetadata2, imageHints);
            parcel2.writeNoException();
            com.google.android.gms.internal.cast.zzc.zzd(parcel2, webImageZzf);
        }
        return true;
    }
}
