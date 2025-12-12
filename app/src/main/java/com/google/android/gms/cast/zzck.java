package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzck implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        MediaInfo mediaInfo = null;
        long[] jArrCreateLongArray = null;
        String strCreateString = null;
        double d10 = 0.0d;
        double d11 = 0.0d;
        double d12 = 0.0d;
        int i10 = 0;
        boolean z10 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    mediaInfo = (MediaInfo) SafeParcelReader.createParcelable(parcel, header, MediaInfo.CREATOR);
                    break;
                case 3:
                    i10 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 4:
                    z10 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 5:
                    d10 = SafeParcelReader.readDouble(parcel, header);
                    break;
                case 6:
                    d11 = SafeParcelReader.readDouble(parcel, header);
                    break;
                case 7:
                    d12 = SafeParcelReader.readDouble(parcel, header);
                    break;
                case 8:
                    jArrCreateLongArray = SafeParcelReader.createLongArray(parcel, header);
                    break;
                case 9:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new MediaQueueItem(mediaInfo, i10, z10, d10, d11, d12, jArrCreateLongArray, strCreateString);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new MediaQueueItem[i10];
    }
}
