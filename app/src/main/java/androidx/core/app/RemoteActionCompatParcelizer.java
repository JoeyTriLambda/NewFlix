package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f2118a = (IconCompat) versionedParcel.readVersionedParcelable(remoteActionCompat.f2118a, 1);
        remoteActionCompat.f2119b = versionedParcel.readCharSequence(remoteActionCompat.f2119b, 2);
        remoteActionCompat.f2120c = versionedParcel.readCharSequence(remoteActionCompat.f2120c, 3);
        remoteActionCompat.f2121d = (PendingIntent) versionedParcel.readParcelable(remoteActionCompat.f2121d, 4);
        remoteActionCompat.f2122e = versionedParcel.readBoolean(remoteActionCompat.f2122e, 5);
        remoteActionCompat.f2123f = versionedParcel.readBoolean(remoteActionCompat.f2123f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeVersionedParcelable(remoteActionCompat.f2118a, 1);
        versionedParcel.writeCharSequence(remoteActionCompat.f2119b, 2);
        versionedParcel.writeCharSequence(remoteActionCompat.f2120c, 3);
        versionedParcel.writeParcelable(remoteActionCompat.f2121d, 4);
        versionedParcel.writeBoolean(remoteActionCompat.f2122e, 5);
        versionedParcel.writeBoolean(remoteActionCompat.f2123f, 6);
    }
}
