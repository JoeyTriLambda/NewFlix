package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.zzav;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzac implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        double d10 = 0.0d;
        double d11 = 0.0d;
        ApplicationMetadata applicationMetadata = null;
        zzav zzavVar = null;
        boolean z10 = false;
        int i10 = 0;
        int i11 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    d10 = SafeParcelReader.readDouble(parcel, header);
                    break;
                case 3:
                    z10 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 4:
                    i10 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 5:
                    applicationMetadata = (ApplicationMetadata) SafeParcelReader.createParcelable(parcel, header, ApplicationMetadata.CREATOR);
                    break;
                case 6:
                    i11 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 7:
                    zzavVar = (zzav) SafeParcelReader.createParcelable(parcel, header, zzav.CREATOR);
                    break;
                case 8:
                    d11 = SafeParcelReader.readDouble(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzab(d10, z10, i10, applicationMetadata, i11, zzavVar, d11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzab[i10];
    }
}
