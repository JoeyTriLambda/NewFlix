package s2;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.versionedparcelable.VersionedParcel;
import java.lang.reflect.Method;

/* compiled from: VersionedParcelParcel.java */
/* loaded from: classes.dex */
public final class b extends VersionedParcel {

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f19010d;

    /* renamed from: e, reason: collision with root package name */
    public final Parcel f19011e;

    /* renamed from: f, reason: collision with root package name */
    public final int f19012f;

    /* renamed from: g, reason: collision with root package name */
    public final int f19013g;

    /* renamed from: h, reason: collision with root package name */
    public final String f19014h;

    /* renamed from: i, reason: collision with root package name */
    public int f19015i;

    /* renamed from: j, reason: collision with root package name */
    public int f19016j;

    /* renamed from: k, reason: collision with root package name */
    public int f19017k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new b0.b(), new b0.b(), new b0.b());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void closeField() {
        int i10 = this.f19015i;
        if (i10 >= 0) {
            int i11 = this.f19010d.get(i10);
            Parcel parcel = this.f19011e;
            int iDataPosition = parcel.dataPosition();
            parcel.setDataPosition(i11);
            parcel.writeInt(iDataPosition - i11);
            parcel.setDataPosition(iDataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public VersionedParcel createSubParcel() {
        Parcel parcel = this.f19011e;
        int iDataPosition = parcel.dataPosition();
        int i10 = this.f19016j;
        if (i10 == this.f19012f) {
            i10 = this.f19013g;
        }
        return new b(parcel, iDataPosition, i10, ac.c.o(new StringBuilder(), this.f19014h, "  "), this.f4450a, this.f4451b, this.f4452c);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readBoolean() {
        return this.f19011e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] readByteArray() {
        Parcel parcel = this.f19011e;
        int i10 = parcel.readInt();
        if (i10 < 0) {
            return null;
        }
        byte[] bArr = new byte[i10];
        parcel.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public CharSequence readCharSequence() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f19011e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readField(int i10) {
        while (this.f19016j < this.f19013g) {
            int i11 = this.f19017k;
            if (i11 == i10) {
                return true;
            }
            if (String.valueOf(i11).compareTo(String.valueOf(i10)) > 0) {
                return false;
            }
            int i12 = this.f19016j;
            Parcel parcel = this.f19011e;
            parcel.setDataPosition(i12);
            int i13 = parcel.readInt();
            this.f19017k = parcel.readInt();
            this.f19016j += i13;
        }
        return this.f19017k == i10;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int readInt() {
        return this.f19011e.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T readParcelable() {
        return (T) this.f19011e.readParcelable(b.class.getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String readString() {
        return this.f19011e.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setOutputField(int i10) {
        closeField();
        this.f19015i = i10;
        this.f19010d.put(i10, this.f19011e.dataPosition());
        writeInt(0);
        writeInt(i10);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBoolean(boolean z10) {
        this.f19011e.writeInt(z10 ? 1 : 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] bArr) {
        Parcel parcel = this.f19011e;
        if (bArr == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeCharSequence(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f19011e, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeInt(int i10) {
        this.f19011e.writeInt(i10);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeParcelable(Parcelable parcelable) {
        this.f19011e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeString(String str) {
        this.f19011e.writeString(str);
    }

    public b(Parcel parcel, int i10, int i11, String str, b0.b<String, Method> bVar, b0.b<String, Method> bVar2, b0.b<String, Class> bVar3) {
        super(bVar, bVar2, bVar3);
        this.f19010d = new SparseIntArray();
        this.f19015i = -1;
        this.f19017k = -1;
        this.f19011e = parcel;
        this.f19012f = i10;
        this.f19013g = i11;
        this.f19016j = i10;
        this.f19014h = str;
    }
}
