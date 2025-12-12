package androidx.media;

import android.media.AudioAttributes;
import androidx.media.AudioAttributesImpl;

/* loaded from: classes.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public AudioAttributes f3538a;

    /* renamed from: b, reason: collision with root package name */
    public int f3539b = -1;

    public static class a implements AudioAttributesImpl.a {

        /* renamed from: a, reason: collision with root package name */
        public final AudioAttributes.Builder f3540a = new AudioAttributes.Builder();

        @Override // androidx.media.AudioAttributesImpl.a
        public AudioAttributesImpl build() {
            return new AudioAttributesImplApi21(this.f3540a.build());
        }

        public a setLegacyStreamType(int i10) {
            this.f3540a.setLegacyStreamType(i10);
            return this;
        }
    }

    public AudioAttributesImplApi21() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f3538a.equals(((AudioAttributesImplApi21) obj).f3538a);
        }
        return false;
    }

    public int getFlags() {
        return this.f3538a.getFlags();
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getLegacyStreamType() {
        int i10 = this.f3539b;
        return i10 != -1 ? i10 : AudioAttributesCompat.a(getFlags(), getUsage());
    }

    public int getUsage() {
        return this.f3538a.getUsage();
    }

    public int hashCode() {
        return this.f3538a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f3538a;
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this.f3538a = audioAttributes;
    }
}
