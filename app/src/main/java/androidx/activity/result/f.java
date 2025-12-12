package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import zf.i;

/* compiled from: IntentSenderRequest.kt */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR;

    /* renamed from: b, reason: collision with root package name */
    public final IntentSender f840b;

    /* renamed from: m, reason: collision with root package name */
    public final Intent f841m;

    /* renamed from: n, reason: collision with root package name */
    public final int f842n;

    /* renamed from: o, reason: collision with root package name */
    public final int f843o;

    /* compiled from: IntentSenderRequest.kt */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final IntentSender f844a;

        /* renamed from: b, reason: collision with root package name */
        public Intent f845b;

        /* renamed from: c, reason: collision with root package name */
        public int f846c;

        /* renamed from: d, reason: collision with root package name */
        public int f847d;

        public a(IntentSender intentSender) {
            i.checkNotNullParameter(intentSender, "intentSender");
            this.f844a = intentSender;
        }

        public final f build() {
            return new f(this.f844a, this.f845b, this.f846c, this.f847d);
        }

        public final a setFillInIntent(Intent intent) {
            this.f845b = intent;
            return this;
        }

        public final a setFlags(int i10, int i11) {
            this.f847d = i10;
            this.f846c = i11;
            return this;
        }
    }

    /* compiled from: IntentSenderRequest.kt */
    public static final class b implements Parcelable.Creator<f> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public f createFromParcel(Parcel parcel) {
            i.checkNotNullParameter(parcel, "inParcel");
            return new f(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public f[] newArray(int i10) {
            return new f[i10];
        }
    }

    /* compiled from: IntentSenderRequest.kt */
    public static final class c {
        public c(zf.f fVar) {
        }
    }

    static {
        new c(null);
        CREATOR = new b();
    }

    public f(IntentSender intentSender, Intent intent, int i10, int i11) {
        i.checkNotNullParameter(intentSender, "intentSender");
        this.f840b = intentSender;
        this.f841m = intent;
        this.f842n = i10;
        this.f843o = i11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Intent getFillInIntent() {
        return this.f841m;
    }

    public final int getFlagsMask() {
        return this.f842n;
    }

    public final int getFlagsValues() {
        return this.f843o;
    }

    public final IntentSender getIntentSender() {
        return this.f840b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        i.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelable(this.f840b, i10);
        parcel.writeParcelable(this.f841m, i10);
        parcel.writeInt(this.f842n);
        parcel.writeInt(this.f843o);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public f(Parcel parcel) {
        i.checkNotNullParameter(parcel, "parcel");
        Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
        i.checkNotNull(parcelable);
        this((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }
}
