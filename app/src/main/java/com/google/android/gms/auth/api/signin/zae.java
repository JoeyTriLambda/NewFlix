package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class zae implements Parcelable.Creator<GoogleSignInOptions> {
    @Override // android.os.Parcelable.Creator
    public final GoogleSignInOptions createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList<GoogleSignInOptionsExtensionParcelable> arrayListCreateTypedList = null;
        ArrayList arrayListCreateTypedList2 = null;
        Account account = null;
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        int i10 = 0;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    i10 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 2:
                    arrayListCreateTypedList2 = SafeParcelReader.createTypedList(parcel, header, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) SafeParcelReader.createParcelable(parcel, header, Account.CREATOR);
                    break;
                case 4:
                    z10 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 5:
                    z11 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 6:
                    z12 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 7:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 8:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 9:
                    arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                case 10:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        HashMap map = new HashMap();
        if (arrayListCreateTypedList != null) {
            for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : arrayListCreateTypedList) {
                map.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.getType()), googleSignInOptionsExtensionParcelable);
            }
        }
        return new GoogleSignInOptions(i10, arrayListCreateTypedList2, account, z10, z11, z12, strCreateString, strCreateString2, map, strCreateString3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptions[] newArray(int i10) {
        return new GoogleSignInOptions[i10];
    }
}
