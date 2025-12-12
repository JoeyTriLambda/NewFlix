package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ActivityResult.java */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0013a();

    /* renamed from: b, reason: collision with root package name */
    public final int f826b;

    /* renamed from: m, reason: collision with root package name */
    public final Intent f827m;

    /* compiled from: ActivityResult.java */
    /* renamed from: androidx.activity.result.a$a, reason: collision with other inner class name */
    public class C0013a implements Parcelable.Creator<a> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i10) {
            return new a[i10];
        }
    }

    public a(int i10, Intent intent) {
        this.f826b = i10;
        this.f827m = intent;
    }

    public static String resultCodeToString(int i10) {
        return i10 != -1 ? i10 != 0 ? String.valueOf(i10) : "RESULT_CANCELED" : "RESULT_OK";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Intent getData() {
        return this.f827m;
    }

    public int getResultCode() {
        return this.f826b;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + resultCodeToString(this.f826b) + ", data=" + this.f827m + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f826b);
        Intent intent = this.f827m;
        parcel.writeInt(intent == null ? 0 : 1);
        if (intent != null) {
            intent.writeToParcel(parcel, i10);
        }
    }

    public a(Parcel parcel) {
        this.f826b = parcel.readInt();
        this.f827m = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
