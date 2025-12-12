package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@ShowFirstParty
@KeepForSdk
@SafeParcelable.Class
/* loaded from: classes.dex */
public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {

    @KeepForSdk
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new zaa();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f7278b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public ParcelFileDescriptor f7279m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7280n;

    @SafeParcelable.Constructor
    public BitmapTeleporter(@SafeParcelable.Param int i10, @SafeParcelable.Param ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param int i11) {
        this.f7278b = i10;
        this.f7279m = parcelFileDescriptor;
        this.f7280n = i11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        if (this.f7279m == null) {
            Bitmap bitmap = (Bitmap) Preconditions.checkNotNull(null);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bitmap.getHeight() * bitmap.getRowBytes());
            bitmap.copyPixelsToBuffer(byteBufferAllocate);
            byteBufferAllocate.array();
            throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
        }
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f7278b);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f7279m, i10 | 1, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f7280n);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        this.f7279m = null;
    }
}
