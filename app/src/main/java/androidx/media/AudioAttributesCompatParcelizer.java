package androidx.media;

import androidx.versionedparcelable.VersionedParcel;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(VersionedParcel versionedParcel) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f3536a = (AudioAttributesImpl) versionedParcel.readVersionedParcelable(audioAttributesCompat.f3536a, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, VersionedParcel versionedParcel) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeVersionedParcelable(audioAttributesCompat.f3536a, 1);
    }
}
