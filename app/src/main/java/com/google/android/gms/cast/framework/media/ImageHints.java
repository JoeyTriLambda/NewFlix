package com.google.android.gms.cast.framework.media;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class ImageHints extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ImageHints> CREATOR = new zzh();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6460b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6461m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6462n;

    @ShowFirstParty
    @SafeParcelable.Constructor
    public ImageHints(@SafeParcelable.Param int i10, @SafeParcelable.Param int i11, @SafeParcelable.Param int i12) {
        this.f6460b = i10;
        this.f6461m = i11;
        this.f6462n = i12;
    }

    public int getHeightInPixels() {
        return this.f6462n;
    }

    public int getType() {
        return this.f6460b;
    }

    public int getWidthInPixels() {
        return this.f6461m;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, getType());
        SafeParcelWriter.writeInt(parcel, 3, getWidthInPixels());
        SafeParcelWriter.writeInt(parcel, 4, getHeightInPixels());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
