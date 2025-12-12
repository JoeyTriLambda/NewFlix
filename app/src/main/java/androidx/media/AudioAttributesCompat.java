package androidx.media;

import android.media.AudioAttributes;
import android.os.Build;
import android.util.SparseIntArray;
import androidx.media.AudioAttributesImplApi21;
import androidx.media.AudioAttributesImplApi26;
import s2.c;

/* loaded from: classes.dex */
public class AudioAttributesCompat implements c {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f3535b = 0;

    /* renamed from: a, reason: collision with root package name */
    public AudioAttributesImpl f3536a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final AudioAttributesImplApi21.a f3537a;

        public a() {
            int i10 = AudioAttributesCompat.f3535b;
            if (Build.VERSION.SDK_INT >= 26) {
                this.f3537a = new AudioAttributesImplApi26.a();
            } else {
                this.f3537a = new AudioAttributesImplApi21.a();
            }
        }

        public AudioAttributesCompat build() {
            return new AudioAttributesCompat(this.f3537a.build());
        }

        public a setLegacyStreamType(int i10) {
            this.f3537a.setLegacyStreamType(i10);
            return this;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
    }

    public AudioAttributesCompat() {
    }

    public static int a(int i10, int i11) {
        if ((i10 & 1) == 1) {
            return 7;
        }
        if ((i10 & 4) == 4) {
            return 6;
        }
        switch (i11) {
            case 0:
            case 1:
            case 12:
            case 14:
            case 15:
            case 16:
            default:
                return 3;
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 13:
                return 1;
        }
    }

    public static AudioAttributesCompat wrap(Object obj) {
        return Build.VERSION.SDK_INT >= 26 ? new AudioAttributesCompat(new AudioAttributesImplApi26((AudioAttributes) obj)) : new AudioAttributesCompat(new AudioAttributesImplApi21((AudioAttributes) obj));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        AudioAttributesImpl audioAttributesImpl = this.f3536a;
        return audioAttributesImpl == null ? audioAttributesCompat.f3536a == null : audioAttributesImpl.equals(audioAttributesCompat.f3536a);
    }

    public int getLegacyStreamType() {
        return this.f3536a.getLegacyStreamType();
    }

    public int hashCode() {
        return this.f3536a.hashCode();
    }

    public String toString() {
        return this.f3536a.toString();
    }

    public AudioAttributesCompat(AudioAttributesImpl audioAttributesImpl) {
        this.f3536a = audioAttributesImpl;
    }
}
