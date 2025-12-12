package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f2134a = versionedParcel.readInt(iconCompat.f2134a, 1);
        iconCompat.f2136c = versionedParcel.readByteArray(iconCompat.f2136c, 2);
        iconCompat.f2137d = versionedParcel.readParcelable(iconCompat.f2137d, 3);
        iconCompat.f2138e = versionedParcel.readInt(iconCompat.f2138e, 4);
        iconCompat.f2139f = versionedParcel.readInt(iconCompat.f2139f, 5);
        iconCompat.f2140g = (ColorStateList) versionedParcel.readParcelable(iconCompat.f2140g, 6);
        iconCompat.f2142i = versionedParcel.readString(iconCompat.f2142i, 7);
        iconCompat.f2143j = versionedParcel.readString(iconCompat.f2143j, 8);
        iconCompat.onPostParceling();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(true, true);
        iconCompat.onPreParceling(versionedParcel.isStream());
        int i10 = iconCompat.f2134a;
        if (-1 != i10) {
            versionedParcel.writeInt(i10, 1);
        }
        byte[] bArr = iconCompat.f2136c;
        if (bArr != null) {
            versionedParcel.writeByteArray(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f2137d;
        if (parcelable != null) {
            versionedParcel.writeParcelable(parcelable, 3);
        }
        int i11 = iconCompat.f2138e;
        if (i11 != 0) {
            versionedParcel.writeInt(i11, 4);
        }
        int i12 = iconCompat.f2139f;
        if (i12 != 0) {
            versionedParcel.writeInt(i12, 5);
        }
        ColorStateList colorStateList = iconCompat.f2140g;
        if (colorStateList != null) {
            versionedParcel.writeParcelable(colorStateList, 6);
        }
        String str = iconCompat.f2142i;
        if (str != null) {
            versionedParcel.writeString(str, 7);
        }
        String str2 = iconCompat.f2143j;
        if (str2 != null) {
            versionedParcel.writeString(str2, 8);
        }
    }
}
