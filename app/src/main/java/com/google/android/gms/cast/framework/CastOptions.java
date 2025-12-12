package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.cast.zzev;
import com.google.android.gms.internal.cast.zzez;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class CastOptions extends AbstractSafeParcelable {
    public static final zzj B = new zzj(false);
    public static final zzl C = new zzl(0);
    public static final Parcelable.Creator<CastOptions> CREATOR;
    public static final CastMediaOptions D;

    @SafeParcelable.Field
    public zzl A;

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6352b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final ArrayList f6353m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f6354n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final LaunchOptions f6355o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f6356p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public final CastMediaOptions f6357q;

    /* renamed from: r, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f6358r;

    /* renamed from: s, reason: collision with root package name */
    @SafeParcelable.Field
    public final double f6359s;

    /* renamed from: t, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f6360t;

    /* renamed from: u, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f6361u;

    /* renamed from: v, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f6362v;

    /* renamed from: w, reason: collision with root package name */
    @SafeParcelable.Field
    public final List f6363w;

    /* renamed from: x, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f6364x;

    /* renamed from: y, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f6365y;

    /* renamed from: z, reason: collision with root package name */
    @SafeParcelable.Field
    public final zzj f6366z;

    /* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f6367a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f6368b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public final LaunchOptions f6369c = new LaunchOptions();

        /* renamed from: d, reason: collision with root package name */
        public final boolean f6370d = true;

        /* renamed from: e, reason: collision with root package name */
        public zzev f6371e = zzev.zzb();

        /* renamed from: f, reason: collision with root package name */
        public final boolean f6372f = true;

        /* renamed from: g, reason: collision with root package name */
        public final double f6373g = 0.05000000074505806d;

        /* renamed from: h, reason: collision with root package name */
        public final ArrayList f6374h = new ArrayList();

        /* renamed from: i, reason: collision with root package name */
        public final boolean f6375i = true;

        public Builder() {
            zzev.zzb();
            zzev.zzb();
        }

        public CastOptions build() {
            Object objZza = this.f6371e.zza(CastOptions.D);
            zzj zzjVar = CastOptions.B;
            zzez.zzc(zzjVar, "use Optional.orNull() instead of Optional.or(null)");
            zzl zzlVar = CastOptions.C;
            zzez.zzc(zzlVar, "use Optional.orNull() instead of Optional.or(null)");
            return new CastOptions(this.f6367a, this.f6368b, false, this.f6369c, this.f6370d, (CastMediaOptions) objZza, this.f6372f, this.f6373g, false, false, false, this.f6374h, this.f6375i, false, zzjVar, zzlVar);
        }

        public Builder setCastMediaOptions(CastMediaOptions castMediaOptions) {
            this.f6371e = zzev.zzc(castMediaOptions);
            return this;
        }

        public Builder setReceiverApplicationId(String str) {
            this.f6367a = str;
            return this;
        }
    }

    static {
        CastMediaOptions.Builder builder = new CastMediaOptions.Builder();
        builder.setMediaSessionEnabled(false);
        builder.setNotificationOptions(null);
        D = builder.build();
        CREATOR = new zzn();
    }

    @SafeParcelable.Constructor
    public CastOptions(@SafeParcelable.Param String str, @SafeParcelable.Param ArrayList arrayList, @SafeParcelable.Param boolean z10, @SafeParcelable.Param LaunchOptions launchOptions, @SafeParcelable.Param boolean z11, @SafeParcelable.Param CastMediaOptions castMediaOptions, @SafeParcelable.Param boolean z12, @SafeParcelable.Param double d10, @SafeParcelable.Param boolean z13, @SafeParcelable.Param boolean z14, @SafeParcelable.Param boolean z15, @SafeParcelable.Param ArrayList arrayList2, @SafeParcelable.Param boolean z16, @SafeParcelable.Param boolean z17, @SafeParcelable.Param zzj zzjVar, @SafeParcelable.Param zzl zzlVar) {
        this.f6352b = true == TextUtils.isEmpty(str) ? "" : str;
        int size = arrayList == null ? 0 : arrayList.size();
        ArrayList arrayList3 = new ArrayList(size);
        this.f6353m = arrayList3;
        if (size > 0) {
            arrayList3.addAll(arrayList);
        }
        this.f6354n = z10;
        this.f6355o = launchOptions == null ? new LaunchOptions() : launchOptions;
        this.f6356p = z11;
        this.f6357q = castMediaOptions;
        this.f6358r = z12;
        this.f6359s = d10;
        this.f6360t = z13;
        this.f6361u = z14;
        this.f6362v = z15;
        this.f6363w = arrayList2;
        this.f6364x = z16;
        this.f6365y = z17;
        this.f6366z = zzjVar;
        this.A = zzlVar;
    }

    public CastMediaOptions getCastMediaOptions() {
        return this.f6357q;
    }

    public boolean getEnableReconnectionService() {
        return this.f6358r;
    }

    public LaunchOptions getLaunchOptions() {
        return this.f6355o;
    }

    public String getReceiverApplicationId() {
        return this.f6352b;
    }

    public boolean getResumeSavedSession() {
        return this.f6356p;
    }

    public boolean getStopReceiverApplicationWhenEndingSession() {
        return this.f6354n;
    }

    public List<String> getSupportedNamespaces() {
        return Collections.unmodifiableList(this.f6353m);
    }

    @Deprecated
    public double getVolumeDeltaBeforeIceCreamSandwich() {
        return this.f6359s;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getReceiverApplicationId(), false);
        SafeParcelWriter.writeStringList(parcel, 3, getSupportedNamespaces(), false);
        SafeParcelWriter.writeBoolean(parcel, 4, getStopReceiverApplicationWhenEndingSession());
        SafeParcelWriter.writeParcelable(parcel, 5, getLaunchOptions(), i10, false);
        SafeParcelWriter.writeBoolean(parcel, 6, getResumeSavedSession());
        SafeParcelWriter.writeParcelable(parcel, 7, getCastMediaOptions(), i10, false);
        SafeParcelWriter.writeBoolean(parcel, 8, getEnableReconnectionService());
        SafeParcelWriter.writeDouble(parcel, 9, getVolumeDeltaBeforeIceCreamSandwich());
        SafeParcelWriter.writeBoolean(parcel, 10, this.f6360t);
        SafeParcelWriter.writeBoolean(parcel, 11, this.f6361u);
        SafeParcelWriter.writeBoolean(parcel, 12, this.f6362v);
        SafeParcelWriter.writeStringList(parcel, 13, Collections.unmodifiableList(this.f6363w), false);
        SafeParcelWriter.writeBoolean(parcel, 14, this.f6364x);
        SafeParcelWriter.writeInt(parcel, 15, 0);
        SafeParcelWriter.writeBoolean(parcel, 16, this.f6365y);
        SafeParcelWriter.writeParcelable(parcel, 17, this.f6366z, i10, false);
        SafeParcelWriter.writeParcelable(parcel, 18, this.A, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @ShowFirstParty
    public final List zza() {
        return Collections.unmodifiableList(this.f6363w);
    }

    @ShowFirstParty
    public final void zzb(zzl zzlVar) {
        this.A = zzlVar;
    }

    public final boolean zze() {
        return this.f6361u;
    }

    public final boolean zzf() {
        return this.f6362v;
    }

    public final boolean zzg() {
        return this.f6365y;
    }

    public final boolean zzh() {
        return this.f6364x;
    }
}
