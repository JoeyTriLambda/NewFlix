package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzaf implements Parcelable.Creator<zzac> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzac createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        zzno zznoVar = null;
        String strCreateString3 = null;
        zzbf zzbfVar = null;
        zzbf zzbfVar2 = null;
        zzbf zzbfVar3 = null;
        long j10 = 0;
        long j11 = 0;
        long j12 = 0;
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
                    zznoVar = (zzno) SafeParcelReader.createParcelable(parcel, header, zzno.CREATOR);
                    break;
                case 5:
                    j10 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 6:
                    z10 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 7:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 8:
                    zzbfVar = (zzbf) SafeParcelReader.createParcelable(parcel, header, zzbf.CREATOR);
                    break;
                case 9:
                    j11 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 10:
                    zzbfVar2 = (zzbf) SafeParcelReader.createParcelable(parcel, header, zzbf.CREATOR);
                    break;
                case 11:
                    j12 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 12:
                    zzbfVar3 = (zzbf) SafeParcelReader.createParcelable(parcel, header, zzbf.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzac(strCreateString, strCreateString2, zznoVar, j10, z10, strCreateString3, zzbfVar, j11, zzbfVar2, j12, zzbfVar3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzac[] newArray(int i10) {
        return new zzac[i10];
    }
}
