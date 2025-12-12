package s2;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.versionedparcelable.ParcelImpl;

/* compiled from: ParcelUtils.java */
/* loaded from: classes.dex */
public final class a {
    public static <T extends c> T fromParcelable(Parcelable parcelable) {
        if (parcelable instanceof ParcelImpl) {
            return (T) ((ParcelImpl) parcelable).getVersionedParcel();
        }
        throw new IllegalArgumentException("Invalid parcel");
    }

    public static <T extends c> T getVersionedParcelable(Bundle bundle, String str) {
        try {
            Bundle bundle2 = (Bundle) bundle.getParcelable(str);
            if (bundle2 == null) {
                return null;
            }
            bundle2.setClassLoader(a.class.getClassLoader());
            return (T) fromParcelable(bundle2.getParcelable("a"));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public static void putVersionedParcelable(Bundle bundle, String str, c cVar) {
        if (cVar == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("a", toParcelable(cVar));
        bundle.putParcelable(str, bundle2);
    }

    public static Parcelable toParcelable(c cVar) {
        return new ParcelImpl(cVar);
    }
}
