package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.framework.media.internal.ResourceProvider;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.cast.zzfq;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class NotificationOptions extends AbstractSafeParcelable {

    @SafeParcelable.Field
    public final int A;

    @SafeParcelable.Field
    public final int B;

    @SafeParcelable.Field
    public final int C;

    @SafeParcelable.Field
    public final int D;

    @SafeParcelable.Field
    public final int E;

    @SafeParcelable.Field
    public final int F;

    @SafeParcelable.Field
    public final int G;

    @SafeParcelable.Field
    public final int H;

    @SafeParcelable.Field
    public final int I;

    @SafeParcelable.Field
    public final int J;

    @SafeParcelable.Field
    public final int K;

    @SafeParcelable.Field
    public final int L;

    @SafeParcelable.Field
    public final int M;

    @SafeParcelable.Field
    public final int N;

    @SafeParcelable.Field
    public final int O;

    @SafeParcelable.Field
    public final int P;

    @SafeParcelable.Field
    public final zzg Q;

    @SafeParcelable.Field
    public final boolean R;

    @SafeParcelable.Field
    public final boolean S;

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final ArrayList f6495b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final int[] f6496m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f6497n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6498o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6499p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6500q;

    /* renamed from: r, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6501r;

    /* renamed from: s, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6502s;

    /* renamed from: t, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6503t;

    /* renamed from: u, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6504u;

    /* renamed from: v, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6505v;

    /* renamed from: w, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6506w;

    /* renamed from: x, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6507x;

    /* renamed from: y, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6508y;

    /* renamed from: z, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6509z;
    public static final zzfq T = zzfq.zzk(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK, MediaIntentReceiver.ACTION_STOP_CASTING);
    public static final int[] U = {0, 1};
    public static final Parcelable.Creator<NotificationOptions> CREATOR = new zzaa();

    /* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f6510a;

        /* renamed from: b, reason: collision with root package name */
        public final zzfq f6511b = NotificationOptions.T;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f6512c = NotificationOptions.U;

        /* renamed from: d, reason: collision with root package name */
        public final int f6513d = a("smallIconDrawableResId");

        /* renamed from: e, reason: collision with root package name */
        public final int f6514e = a("stopLiveStreamDrawableResId");

        /* renamed from: f, reason: collision with root package name */
        public final int f6515f = a("pauseDrawableResId");

        /* renamed from: g, reason: collision with root package name */
        public final int f6516g = a("playDrawableResId");

        /* renamed from: h, reason: collision with root package name */
        public final int f6517h = a("skipNextDrawableResId");

        /* renamed from: i, reason: collision with root package name */
        public final int f6518i = a("skipPrevDrawableResId");

        /* renamed from: j, reason: collision with root package name */
        public final int f6519j = a("forwardDrawableResId");

        /* renamed from: k, reason: collision with root package name */
        public final int f6520k = a("forward10DrawableResId");

        /* renamed from: l, reason: collision with root package name */
        public final int f6521l = a("forward30DrawableResId");

        /* renamed from: m, reason: collision with root package name */
        public final int f6522m = a("rewindDrawableResId");

        /* renamed from: n, reason: collision with root package name */
        public final int f6523n = a("rewind10DrawableResId");

        /* renamed from: o, reason: collision with root package name */
        public final int f6524o = a("rewind30DrawableResId");

        /* renamed from: p, reason: collision with root package name */
        public final int f6525p = a("disconnectDrawableResId");

        /* renamed from: q, reason: collision with root package name */
        public final long f6526q = 10000;

        public static int a(String str) {
            try {
                Map map = ResourceProvider.f6542a;
                Integer num = (Integer) ResourceProvider.class.getMethod("findResourceByName", String.class).invoke(null, str);
                if (num == null) {
                    return 0;
                }
                return num.intValue();
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return 0;
            }
        }

        public NotificationOptions build() {
            return new NotificationOptions(this.f6511b, this.f6512c, this.f6526q, this.f6510a, this.f6513d, this.f6514e, this.f6515f, this.f6516g, this.f6517h, this.f6518i, this.f6519j, this.f6520k, this.f6521l, this.f6522m, this.f6523n, this.f6524o, this.f6525p, a("notificationImageSizeDimenResId"), a("castingToDeviceStringResId"), a("stopLiveStreamStringResId"), a("pauseStringResId"), a("playStringResId"), a("skipNextStringResId"), a("skipPrevStringResId"), a("forwardStringResId"), a("forward10StringResId"), a("forward30StringResId"), a("rewindStringResId"), a("rewind10StringResId"), a("rewind30StringResId"), a("disconnectStringResId"), null, false, false);
        }

        public Builder setTargetActivityClassName(String str) {
            this.f6510a = str;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public NotificationOptions(@SafeParcelable.Param List list, @SafeParcelable.Param int[] iArr, @SafeParcelable.Param long j10, @SafeParcelable.Param String str, @SafeParcelable.Param int i10, @SafeParcelable.Param int i11, @SafeParcelable.Param int i12, @SafeParcelable.Param int i13, @SafeParcelable.Param int i14, @SafeParcelable.Param int i15, @SafeParcelable.Param int i16, @SafeParcelable.Param int i17, @SafeParcelable.Param int i18, @SafeParcelable.Param int i19, @SafeParcelable.Param int i20, @SafeParcelable.Param int i21, @SafeParcelable.Param int i22, @SafeParcelable.Param int i23, @SafeParcelable.Param int i24, @SafeParcelable.Param int i25, @SafeParcelable.Param int i26, @SafeParcelable.Param int i27, @SafeParcelable.Param int i28, @SafeParcelable.Param int i29, @SafeParcelable.Param int i30, @SafeParcelable.Param int i31, @SafeParcelable.Param int i32, @SafeParcelable.Param int i33, @SafeParcelable.Param int i34, @SafeParcelable.Param int i35, @SafeParcelable.Param int i36, @SafeParcelable.Param IBinder iBinder, @SafeParcelable.Param boolean z10, @SafeParcelable.Param boolean z11) {
        zzg zzeVar;
        this.f6495b = new ArrayList(list);
        this.f6496m = Arrays.copyOf(iArr, iArr.length);
        this.f6497n = j10;
        this.f6498o = str;
        this.f6499p = i10;
        this.f6500q = i11;
        this.f6501r = i12;
        this.f6502s = i13;
        this.f6503t = i14;
        this.f6504u = i15;
        this.f6505v = i16;
        this.f6506w = i17;
        this.f6507x = i18;
        this.f6508y = i19;
        this.f6509z = i20;
        this.A = i21;
        this.B = i22;
        this.C = i23;
        this.D = i24;
        this.E = i25;
        this.F = i26;
        this.G = i27;
        this.H = i28;
        this.I = i29;
        this.J = i30;
        this.K = i31;
        this.L = i32;
        this.M = i33;
        this.N = i34;
        this.O = i35;
        this.P = i36;
        this.R = z10;
        this.S = z11;
        if (iBinder == null) {
            zzeVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.media.INotificationActionsProvider");
            zzeVar = iInterfaceQueryLocalInterface instanceof zzg ? (zzg) iInterfaceQueryLocalInterface : new zze(iBinder);
        }
        this.Q = zzeVar;
    }

    public List<String> getActions() {
        return this.f6495b;
    }

    public int getCastingToDeviceStringResId() {
        return this.D;
    }

    public int[] getCompatActionIndices() {
        int[] iArr = this.f6496m;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public int getDisconnectDrawableResId() {
        return this.B;
    }

    public int getForward10DrawableResId() {
        return this.f6506w;
    }

    public int getForward30DrawableResId() {
        return this.f6507x;
    }

    public int getForwardDrawableResId() {
        return this.f6505v;
    }

    public int getPauseDrawableResId() {
        return this.f6501r;
    }

    public int getPlayDrawableResId() {
        return this.f6502s;
    }

    public int getRewind10DrawableResId() {
        return this.f6509z;
    }

    public int getRewind30DrawableResId() {
        return this.A;
    }

    public int getRewindDrawableResId() {
        return this.f6508y;
    }

    public int getSkipNextDrawableResId() {
        return this.f6503t;
    }

    public int getSkipPrevDrawableResId() {
        return this.f6504u;
    }

    public long getSkipStepMs() {
        return this.f6497n;
    }

    public int getSmallIconDrawableResId() {
        return this.f6499p;
    }

    public int getStopLiveStreamDrawableResId() {
        return this.f6500q;
    }

    public int getStopLiveStreamTitleResId() {
        return this.E;
    }

    public String getTargetActivityClassName() {
        return this.f6498o;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringList(parcel, 2, getActions(), false);
        SafeParcelWriter.writeIntArray(parcel, 3, getCompatActionIndices(), false);
        SafeParcelWriter.writeLong(parcel, 4, getSkipStepMs());
        SafeParcelWriter.writeString(parcel, 5, getTargetActivityClassName(), false);
        SafeParcelWriter.writeInt(parcel, 6, getSmallIconDrawableResId());
        SafeParcelWriter.writeInt(parcel, 7, getStopLiveStreamDrawableResId());
        SafeParcelWriter.writeInt(parcel, 8, getPauseDrawableResId());
        SafeParcelWriter.writeInt(parcel, 9, getPlayDrawableResId());
        SafeParcelWriter.writeInt(parcel, 10, getSkipNextDrawableResId());
        SafeParcelWriter.writeInt(parcel, 11, getSkipPrevDrawableResId());
        SafeParcelWriter.writeInt(parcel, 12, getForwardDrawableResId());
        SafeParcelWriter.writeInt(parcel, 13, getForward10DrawableResId());
        SafeParcelWriter.writeInt(parcel, 14, getForward30DrawableResId());
        SafeParcelWriter.writeInt(parcel, 15, getRewindDrawableResId());
        SafeParcelWriter.writeInt(parcel, 16, getRewind10DrawableResId());
        SafeParcelWriter.writeInt(parcel, 17, getRewind30DrawableResId());
        SafeParcelWriter.writeInt(parcel, 18, getDisconnectDrawableResId());
        SafeParcelWriter.writeInt(parcel, 19, this.C);
        SafeParcelWriter.writeInt(parcel, 20, getCastingToDeviceStringResId());
        SafeParcelWriter.writeInt(parcel, 21, getStopLiveStreamTitleResId());
        SafeParcelWriter.writeInt(parcel, 22, this.F);
        SafeParcelWriter.writeInt(parcel, 23, this.G);
        SafeParcelWriter.writeInt(parcel, 24, this.H);
        SafeParcelWriter.writeInt(parcel, 25, this.I);
        SafeParcelWriter.writeInt(parcel, 26, this.J);
        SafeParcelWriter.writeInt(parcel, 27, this.K);
        SafeParcelWriter.writeInt(parcel, 28, this.L);
        SafeParcelWriter.writeInt(parcel, 29, this.M);
        SafeParcelWriter.writeInt(parcel, 30, this.N);
        SafeParcelWriter.writeInt(parcel, 31, this.O);
        SafeParcelWriter.writeInt(parcel, 32, this.P);
        zzg zzgVar = this.Q;
        SafeParcelWriter.writeIBinder(parcel, 33, zzgVar == null ? null : zzgVar.asBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 34, this.R);
        SafeParcelWriter.writeBoolean(parcel, 35, this.S);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        return this.P;
    }

    public final int zzb() {
        return this.K;
    }

    public final int zzc() {
        return this.L;
    }

    public final int zzd() {
        return this.J;
    }

    public final int zze() {
        return this.C;
    }

    public final int zzf() {
        return this.F;
    }

    public final int zzg() {
        return this.G;
    }

    public final int zzh() {
        return this.N;
    }

    public final int zzi() {
        return this.O;
    }

    public final int zzj() {
        return this.M;
    }

    public final int zzk() {
        return this.H;
    }

    public final int zzl() {
        return this.I;
    }

    public final zzg zzm() {
        return this.Q;
    }

    public final boolean zzo() {
        return this.S;
    }

    public final boolean zzp() {
        return this.R;
    }
}
