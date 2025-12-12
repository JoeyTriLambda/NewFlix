package com.google.android.gms.cast.framework.media;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public interface zzd extends IInterface {
    WebImage zze(MediaMetadata mediaMetadata, int i10) throws RemoteException;

    WebImage zzf(MediaMetadata mediaMetadata, ImageHints imageHints) throws RemoteException;

    IObjectWrapper zzg() throws RemoteException;
}
