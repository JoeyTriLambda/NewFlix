package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzcm implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        MediaInfo mediaInfo = null;
        long[] jArrCreateLongArray = null;
        String strCreateString = null;
        ArrayList arrayListCreateTypedList = null;
        AdBreakStatus adBreakStatus = null;
        VideoInfo videoInfo = null;
        MediaLiveSeekableRange mediaLiveSeekableRange = null;
        MediaQueueData mediaQueueData = null;
        double d10 = 0.0d;
        double d11 = 0.0d;
        long j10 = 0;
        long j11 = 0;
        long j12 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        boolean z10 = false;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        boolean z11 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    mediaInfo = (MediaInfo) SafeParcelReader.createParcelable(parcel, header, MediaInfo.CREATOR);
                    break;
                case 3:
                    j10 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 4:
                    i10 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 5:
                    d10 = SafeParcelReader.readDouble(parcel, header);
                    break;
                case 6:
                    i11 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 7:
                    i12 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 8:
                    j11 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 9:
                    j12 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 10:
                    d11 = SafeParcelReader.readDouble(parcel, header);
                    break;
                case 11:
                    z10 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 12:
                    jArrCreateLongArray = SafeParcelReader.createLongArray(parcel, header);
                    break;
                case 13:
                    i13 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 14:
                    i14 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 15:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 16:
                    i15 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 17:
                    arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, MediaQueueItem.CREATOR);
                    break;
                case 18:
                    z11 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 19:
                    adBreakStatus = (AdBreakStatus) SafeParcelReader.createParcelable(parcel, header, AdBreakStatus.CREATOR);
                    break;
                case 20:
                    videoInfo = (VideoInfo) SafeParcelReader.createParcelable(parcel, header, VideoInfo.CREATOR);
                    break;
                case 21:
                    mediaLiveSeekableRange = (MediaLiveSeekableRange) SafeParcelReader.createParcelable(parcel, header, MediaLiveSeekableRange.CREATOR);
                    break;
                case 22:
                    mediaQueueData = (MediaQueueData) SafeParcelReader.createParcelable(parcel, header, MediaQueueData.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new MediaStatus(mediaInfo, j10, i10, d10, i11, i12, j11, j12, d11, z10, jArrCreateLongArray, i13, i14, strCreateString, i15, arrayListCreateTypedList, z11, adBreakStatus, videoInfo, mediaLiveSeekableRange, mediaQueueData);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new MediaStatus[i10];
    }
}
