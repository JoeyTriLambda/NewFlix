package com.google.android.gms.common.data;

import android.os.Parcel;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
/* loaded from: classes.dex */
public class DataBufferSafeParcelable<T extends SafeParcelable> extends AbstractDataBuffer<T> {
    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @KeepForSdk
    public T get(int i10) {
        DataHolder dataHolder = (DataHolder) Preconditions.checkNotNull(null);
        byte[] byteArray = dataHolder.getByteArray(JsonStorageKeyNames.DATA_KEY, i10, dataHolder.getWindowIndex(i10));
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(byteArray, 0, byteArray.length);
        parcelObtain.setDataPosition(0);
        throw null;
    }
}
