package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new zab();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f7450b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final StringToIntConverter f7451m;

    @SafeParcelable.Constructor
    public zaa(@SafeParcelable.Param int i10, @SafeParcelable.Param StringToIntConverter stringToIntConverter) {
        this.f7450b = i10;
        this.f7451m = stringToIntConverter;
    }

    public static zaa zaa(FastJsonResponse.FieldConverter<?, ?> fieldConverter) {
        if (fieldConverter instanceof StringToIntConverter) {
            return new zaa((StringToIntConverter) fieldConverter);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f7450b);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f7451m, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final FastJsonResponse.FieldConverter<?, ?> zab() {
        StringToIntConverter stringToIntConverter = this.f7451m;
        if (stringToIntConverter != null) {
            return stringToIntConverter;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    public zaa(StringToIntConverter stringToIntConverter) {
        this.f7450b = 1;
        this.f7451m = stringToIntConverter;
    }
}
