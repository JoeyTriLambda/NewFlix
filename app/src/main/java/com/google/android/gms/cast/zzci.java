package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzci implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j10 = 0;
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        MediaQueueContainerMetadata mediaQueueContainerMetadata = null;
        ArrayList arrayListCreateTypedList = null;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
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
                    i10 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 5:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 6:
                    mediaQueueContainerMetadata = (MediaQueueContainerMetadata) SafeParcelReader.createParcelable(parcel, header, MediaQueueContainerMetadata.CREATOR);
                    break;
                case 7:
                    i11 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 8:
                    arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, MediaQueueItem.CREATOR);
                    break;
                case 9:
                    i12 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 10:
                    j10 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 11:
                    z10 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new MediaQueueData(strCreateString, strCreateString2, i10, strCreateString3, mediaQueueContainerMetadata, i11, arrayListCreateTypedList, i12, j10, z10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new MediaQueueData[i10];
    }
}
