package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f7539b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f7540m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f7541n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final Context f7542o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f7543p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f7544q;

    @SafeParcelable.Constructor
    public zzo(@SafeParcelable.Param String str, @SafeParcelable.Param boolean z10, @SafeParcelable.Param boolean z11, @SafeParcelable.Param IBinder iBinder, @SafeParcelable.Param boolean z12, @SafeParcelable.Param boolean z13) {
        this.f7539b = str;
        this.f7540m = z10;
        this.f7541n = z11;
        this.f7542o = (Context) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.f7543p = z12;
        this.f7544q = z13;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [android.os.IBinder, com.google.android.gms.dynamic.IObjectWrapper] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f7539b, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.f7540m);
        SafeParcelWriter.writeBoolean(parcel, 3, this.f7541n);
        SafeParcelWriter.writeIBinder(parcel, 4, ObjectWrapper.wrap(this.f7542o), false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f7543p);
        SafeParcelWriter.writeBoolean(parcel, 6, this.f7544q);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
