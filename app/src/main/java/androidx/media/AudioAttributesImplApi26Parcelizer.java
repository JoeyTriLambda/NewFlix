package androidx.media;

import android.media.AudioAttributes;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(VersionedParcel versionedParcel) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.f3538a = (AudioAttributes) versionedParcel.readParcelable(audioAttributesImplApi26.f3538a, 1);
        audioAttributesImplApi26.f3539b = versionedParcel.readInt(audioAttributesImplApi26.f3539b, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeParcelable(audioAttributesImplApi26.f3538a, 1);
        versionedParcel.writeInt(audioAttributesImplApi26.f3539b, 2);
    }
}
