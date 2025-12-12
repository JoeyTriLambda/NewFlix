package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzcc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        long j10 = 0;
        long j11 = 0;
        MediaInfo mediaInfo = null;
        MediaQueueData mediaQueueData = null;
        Boolean booleanObject = null;
        long[] jArrCreateLongArray = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        String strCreateString4 = null;
        String strCreateString5 = null;
        double d10 = 0.0d;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    mediaInfo = (MediaInfo) SafeParcelReader.createParcelable(parcel, header, MediaInfo.CREATOR);
                    break;
                case 3:
                    mediaQueueData = (MediaQueueData) SafeParcelReader.createParcelable(parcel, header, MediaQueueData.CREATOR);
                    break;
                case 4:
                    booleanObject = SafeParcelReader.readBooleanObject(parcel, header);
                    break;
                case 5:
                    j10 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 6:
                    d10 = SafeParcelReader.readDouble(parcel, header);
                    break;
                case 7:
                    jArrCreateLongArray = SafeParcelReader.createLongArray(parcel, header);
                    break;
                case 8:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 9:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 10:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 11:
                    strCreateString4 = SafeParcelReader.createString(parcel, header);
                    break;
                case 12:
                    strCreateString5 = SafeParcelReader.createString(parcel, header);
                    break;
                case 13:
                    j11 = SafeParcelReader.readLong(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new MediaLoadRequestData(mediaInfo, mediaQueueData, booleanObject, j10, d10, jArrCreateLongArray, CastUtils.jsonStringToJsonObject(strCreateString), strCreateString2, strCreateString3, strCreateString4, strCreateString5, j11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new MediaLoadRequestData[i10];
    }
}
