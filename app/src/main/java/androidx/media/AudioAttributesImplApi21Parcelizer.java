package androidx.media;

import android.media.AudioAttributes;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(VersionedParcel versionedParcel) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f3538a = (AudioAttributes) versionedParcel.readParcelable(audioAttributesImplApi21.f3538a, 1);
        audioAttributesImplApi21.f3539b = versionedParcel.readInt(audioAttributesImplApi21.f3539b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeParcelable(audioAttributesImplApi21.f3538a, 1);
        versionedParcel.writeInt(audioAttributesImplApi21.f3539b, 2);
    }
}
