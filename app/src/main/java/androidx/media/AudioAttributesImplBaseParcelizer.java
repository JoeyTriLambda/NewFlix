package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f3541a = versionedParcel.readInt(audioAttributesImplBase.f3541a, 1);
        audioAttributesImplBase.f3542b = versionedParcel.readInt(audioAttributesImplBase.f3542b, 2);
        audioAttributesImplBase.f3543c = versionedParcel.readInt(audioAttributesImplBase.f3543c, 3);
        audioAttributesImplBase.f3544d = versionedParcel.readInt(audioAttributesImplBase.f3544d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeInt(audioAttributesImplBase.f3541a, 1);
        versionedParcel.writeInt(audioAttributesImplBase.f3542b, 2);
        versionedParcel.writeInt(audioAttributesImplBase.f3543c, 3);
        versionedParcel.writeInt(audioAttributesImplBase.f3544d, 4);
    }
}
