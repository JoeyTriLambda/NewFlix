package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzby implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        MediaMetadata mediaMetadata = null;
        ArrayList arrayListCreateTypedList = null;
        TextTrackStyle textTrackStyle = null;
        String strCreateString3 = null;
        ArrayList arrayListCreateTypedList2 = null;
        ArrayList arrayListCreateTypedList3 = null;
        String strCreateString4 = null;
        VastAdsRequest vastAdsRequest = null;
        String strCreateString5 = null;
        String strCreateString6 = null;
        String strCreateString7 = null;
        String strCreateString8 = null;
        long j10 = 0;
        long j11 = 0;
        int i10 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 3:
                    i10 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 4:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 5:
                    mediaMetadata = (MediaMetadata) SafeParcelReader.createParcelable(parcel, header, MediaMetadata.CREATOR);
                    break;
                case 6:
                    j10 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 7:
                    arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, MediaTrack.CREATOR);
                    break;
                case 8:
                    textTrackStyle = (TextTrackStyle) SafeParcelReader.createParcelable(parcel, header, TextTrackStyle.CREATOR);
                    break;
                case 9:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 10:
                    arrayListCreateTypedList2 = SafeParcelReader.createTypedList(parcel, header, AdBreakInfo.CREATOR);
                    break;
                case 11:
                    arrayListCreateTypedList3 = SafeParcelReader.createTypedList(parcel, header, AdBreakClipInfo.CREATOR);
                    break;
                case 12:
                    strCreateString4 = SafeParcelReader.createString(parcel, header);
                    break;
                case 13:
                    vastAdsRequest = (VastAdsRequest) SafeParcelReader.createParcelable(parcel, header, VastAdsRequest.CREATOR);
                    break;
                case 14:
                    j11 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 15:
                    strCreateString5 = SafeParcelReader.createString(parcel, header);
                    break;
                case 16:
                    strCreateString6 = SafeParcelReader.createString(parcel, header);
                    break;
                case 17:
                    strCreateString7 = SafeParcelReader.createString(parcel, header);
                    break;
                case 18:
                    strCreateString8 = SafeParcelReader.createString(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new MediaInfo(strCreateString, i10, strCreateString2, mediaMetadata, j10, arrayListCreateTypedList, textTrackStyle, strCreateString3, arrayListCreateTypedList2, arrayListCreateTypedList3, strCreateString4, vastAdsRequest, j11, strCreateString5, strCreateString6, strCreateString7, strCreateString8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new MediaInfo[i10];
    }
}
