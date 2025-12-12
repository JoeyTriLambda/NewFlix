package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzn implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        ArrayList<String> arrayListCreateStringList = null;
        LaunchOptions launchOptions = null;
        CastMediaOptions castMediaOptions = null;
        ArrayList<String> arrayListCreateStringList2 = null;
        zzj zzjVar = null;
        zzl zzlVar = null;
        double d10 = 0.0d;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        boolean z16 = false;
        boolean z17 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 3:
                    arrayListCreateStringList = SafeParcelReader.createStringList(parcel, header);
                    break;
                case 4:
                    z10 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 5:
                    launchOptions = (LaunchOptions) SafeParcelReader.createParcelable(parcel, header, LaunchOptions.CREATOR);
                    break;
                case 6:
                    z11 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 7:
                    castMediaOptions = (CastMediaOptions) SafeParcelReader.createParcelable(parcel, header, CastMediaOptions.CREATOR);
                    break;
                case 8:
                    z12 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 9:
                    d10 = SafeParcelReader.readDouble(parcel, header);
                    break;
                case 10:
                    z13 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 11:
                    z14 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 12:
                    z15 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 13:
                    arrayListCreateStringList2 = SafeParcelReader.createStringList(parcel, header);
                    break;
                case 14:
                    z16 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 15:
                    SafeParcelReader.readInt(parcel, header);
                    break;
                case 16:
                    z17 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 17:
                    zzjVar = (zzj) SafeParcelReader.createParcelable(parcel, header, zzj.CREATOR);
                    break;
                case 18:
                    zzlVar = (zzl) SafeParcelReader.createParcelable(parcel, header, zzl.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new CastOptions(strCreateString, arrayListCreateStringList, z10, launchOptions, z11, castMediaOptions, z12, d10, z13, z14, z15, arrayListCreateStringList2, z16, z17, zzjVar, zzlVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new CastOptions[i10];
    }
}
