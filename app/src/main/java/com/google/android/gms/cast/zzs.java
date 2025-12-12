package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzs implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        String strCreateString4 = null;
        String strCreateString5 = null;
        ArrayList arrayListCreateTypedList = null;
        String strCreateString6 = null;
        String strCreateString7 = null;
        String strCreateString8 = null;
        byte[] bArrCreateByteArray = null;
        String strCreateString9 = null;
        com.google.android.gms.cast.internal.zzz zzzVar = null;
        Integer integerObject = null;
        int i10 = 0;
        int i11 = 0;
        int i12 = -1;
        int i13 = 0;
        boolean z10 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 3:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 4:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 5:
                    strCreateString4 = SafeParcelReader.createString(parcel, header);
                    break;
                case 6:
                    strCreateString5 = SafeParcelReader.createString(parcel, header);
                    break;
                case 7:
                    i10 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 8:
                    arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, WebImage.CREATOR);
                    break;
                case 9:
                    i11 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 10:
                    i12 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 11:
                    strCreateString6 = SafeParcelReader.createString(parcel, header);
                    break;
                case 12:
                    strCreateString7 = SafeParcelReader.createString(parcel, header);
                    break;
                case 13:
                    i13 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 14:
                    strCreateString8 = SafeParcelReader.createString(parcel, header);
                    break;
                case 15:
                    bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 16:
                    strCreateString9 = SafeParcelReader.createString(parcel, header);
                    break;
                case 17:
                    z10 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 18:
                    zzzVar = (com.google.android.gms.cast.internal.zzz) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.cast.internal.zzz.CREATOR);
                    break;
                case 19:
                    integerObject = SafeParcelReader.readIntegerObject(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new CastDevice(strCreateString, strCreateString2, strCreateString3, strCreateString4, strCreateString5, i10, arrayListCreateTypedList, i11, i12, strCreateString6, strCreateString7, i13, strCreateString8, bArrCreateByteArray, strCreateString9, z10, zzzVar, integerObject);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new CastDevice[i10];
    }
}
