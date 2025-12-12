package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class CastMediaOptions extends AbstractSafeParcelable {

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6450b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6451m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final zzd f6452n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final NotificationOptions f6453o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f6454p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f6455q;

    /* renamed from: r, reason: collision with root package name */
    public static final Logger f6449r = new Logger("CastMediaOptions");
    public static final Parcelable.Creator<CastMediaOptions> CREATOR = new zza();

    /* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
    public static final class Builder {

        /* renamed from: b, reason: collision with root package name */
        public String f6457b;

        /* renamed from: a, reason: collision with root package name */
        public final String f6456a = "com.google.android.gms.cast.framework.media.MediaIntentReceiver";

        /* renamed from: c, reason: collision with root package name */
        public NotificationOptions f6458c = new NotificationOptions.Builder().build();

        /* renamed from: d, reason: collision with root package name */
        public boolean f6459d = true;

        public CastMediaOptions build() {
            return new CastMediaOptions(this.f6456a, this.f6457b, null, this.f6458c, false, this.f6459d);
        }

        public Builder setExpandedControllerActivityClassName(String str) {
            this.f6457b = str;
            return this;
        }

        public Builder setMediaSessionEnabled(boolean z10) {
            this.f6459d = z10;
            return this;
        }

        public Builder setNotificationOptions(NotificationOptions notificationOptions) {
            this.f6458c = notificationOptions;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public CastMediaOptions(@SafeParcelable.Param String str, @SafeParcelable.Param String str2, @SafeParcelable.Param IBinder iBinder, @SafeParcelable.Param NotificationOptions notificationOptions, @SafeParcelable.Param boolean z10, @SafeParcelable.Param boolean z11) {
        zzd zzbVar;
        this.f6450b = str;
        this.f6451m = str2;
        if (iBinder == null) {
            zzbVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.media.IImagePicker");
            zzbVar = iInterfaceQueryLocalInterface instanceof zzd ? (zzd) iInterfaceQueryLocalInterface : new zzb(iBinder);
        }
        this.f6452n = zzbVar;
        this.f6453o = notificationOptions;
        this.f6454p = z10;
        this.f6455q = z11;
    }

    public String getExpandedControllerActivityClassName() {
        return this.f6451m;
    }

    public ImagePicker getImagePicker() {
        zzd zzdVar = this.f6452n;
        if (zzdVar == null) {
            return null;
        }
        try {
            return (ImagePicker) ObjectWrapper.unwrap(zzdVar.zzg());
        } catch (RemoteException e10) {
            f6449r.d(e10, "Unable to call %s on %s.", "getWrappedClientObject", "zzd");
            return null;
        }
    }

    public String getMediaIntentReceiverClassName() {
        return this.f6450b;
    }

    public boolean getMediaSessionEnabled() {
        return this.f6455q;
    }

    public NotificationOptions getNotificationOptions() {
        return this.f6453o;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getMediaIntentReceiverClassName(), false);
        SafeParcelWriter.writeString(parcel, 3, getExpandedControllerActivityClassName(), false);
        zzd zzdVar = this.f6452n;
        SafeParcelWriter.writeIBinder(parcel, 4, zzdVar == null ? null : zzdVar.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getNotificationOptions(), i10, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.f6454p);
        SafeParcelWriter.writeBoolean(parcel, 7, getMediaSessionEnabled());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @ShowFirstParty
    public final boolean zza() {
        return this.f6454p;
    }
}
