package t5;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: SpliceNullCommand.java */
/* loaded from: classes.dex */
public final class e extends b {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* compiled from: SpliceNullCommand.java */
    public static class a implements Parcelable.Creator<e> {
        @Override // android.os.Parcelable.Creator
        public e createFromParcel(Parcel parcel) {
            return new e();
        }

        @Override // android.os.Parcelable.Creator
        public e[] newArray(int i10) {
            return new e[i10];
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
    }
}
