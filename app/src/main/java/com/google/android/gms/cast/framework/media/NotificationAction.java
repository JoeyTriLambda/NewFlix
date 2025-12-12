package com.google.android.gms.cast.framework.media;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class NotificationAction extends AbstractSafeParcelable {
    public static final Parcelable.Creator<NotificationAction> CREATOR = new zzx();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6492b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6493m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6494n;

    /* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
    public static final class Builder {
    }

    @SafeParcelable.Constructor
    public NotificationAction(@SafeParcelable.Param String str, @SafeParcelable.Param int i10, @SafeParcelable.Param String str2) {
        this.f6492b = str;
        this.f6493m = i10;
        this.f6494n = str2;
    }

    public String getAction() {
        return this.f6492b;
    }

    public String getContentDescription() {
        return this.f6494n;
    }

    public int getIconResId() {
        return this.f6493m;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getAction(), false);
        SafeParcelWriter.writeInt(parcel, 3, getIconResId());
        SafeParcelWriter.writeString(parcel, 4, getContentDescription(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
