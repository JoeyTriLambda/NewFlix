package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new zzt();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f7549b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final zzj f7550m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f7551n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f7552o;

    public zzs(String str, zzj zzjVar, boolean z10, boolean z11) {
        this.f7549b = str;
        this.f7550m = zzjVar;
        this.f7551n = z10;
        this.f7552o = z11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f7549b, false);
        zzj zzjVar = this.f7550m;
        if (zzjVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            zzjVar = null;
        }
        SafeParcelWriter.writeIBinder(parcel, 2, zzjVar, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.f7551n);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f7552o);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzs(@SafeParcelable.Param String str, @SafeParcelable.Param IBinder iBinder, @SafeParcelable.Param boolean z10, @SafeParcelable.Param boolean z11) {
        this.f7549b = str;
        zzk zzkVar = null;
        if (iBinder != null) {
            try {
                IObjectWrapper iObjectWrapperZzd = com.google.android.gms.common.internal.zzz.zzg(iBinder).zzd();
                byte[] bArr = iObjectWrapperZzd == null ? null : (byte[]) ObjectWrapper.unwrap(iObjectWrapperZzd);
                if (bArr != null) {
                    zzkVar = new zzk(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e10) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e10);
            }
        }
        this.f7550m = zzkVar;
        this.f7551n = z10;
        this.f7552o = z11;
    }
}
