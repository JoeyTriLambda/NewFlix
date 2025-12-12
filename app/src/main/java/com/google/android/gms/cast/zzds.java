package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzds implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        float f10 = 0.0f;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    f10 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 3:
                    i10 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 4:
                    i11 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 5:
                    i12 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 6:
                    i13 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 7:
                    i14 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 8:
                    i15 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 9:
                    i16 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 10:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 11:
                    i17 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 12:
                    i18 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 13:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new TextTrackStyle(f10, i10, i11, i12, i13, i14, i15, i16, strCreateString, i17, i18, strCreateString2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new TextTrackStyle[i10];
    }
}
