package androidx.media;

import ac.c;
import java.util.Arrays;

/* loaded from: classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f3541a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f3542b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f3543c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f3544d = -1;

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.f3542b == audioAttributesImplBase.getContentType() && this.f3543c == audioAttributesImplBase.getFlags() && this.f3541a == audioAttributesImplBase.getUsage() && this.f3544d == audioAttributesImplBase.f3544d;
    }

    public int getContentType() {
        return this.f3542b;
    }

    public int getFlags() {
        int i10 = this.f3543c;
        int legacyStreamType = getLegacyStreamType();
        if (legacyStreamType == 6) {
            i10 |= 4;
        } else if (legacyStreamType == 7) {
            i10 |= 1;
        }
        return i10 & 273;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getLegacyStreamType() {
        int i10 = this.f3544d;
        return i10 != -1 ? i10 : AudioAttributesCompat.a(this.f3543c, this.f3541a);
    }

    public int getUsage() {
        return this.f3541a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3542b), Integer.valueOf(this.f3543c), Integer.valueOf(this.f3541a), Integer.valueOf(this.f3544d)});
    }

    public String toString() {
        String strF;
        StringBuilder sb2 = new StringBuilder("AudioAttributesCompat:");
        if (this.f3544d != -1) {
            sb2.append(" stream=");
            sb2.append(this.f3544d);
            sb2.append(" derived");
        }
        sb2.append(" usage=");
        int i10 = this.f3541a;
        int i11 = AudioAttributesCompat.f3535b;
        switch (i10) {
            case 0:
                strF = "USAGE_UNKNOWN";
                break;
            case 1:
                strF = "USAGE_MEDIA";
                break;
            case 2:
                strF = "USAGE_VOICE_COMMUNICATION";
                break;
            case 3:
                strF = "USAGE_VOICE_COMMUNICATION_SIGNALLING";
                break;
            case 4:
                strF = "USAGE_ALARM";
                break;
            case 5:
                strF = "USAGE_NOTIFICATION";
                break;
            case 6:
                strF = "USAGE_NOTIFICATION_RINGTONE";
                break;
            case 7:
                strF = "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
                break;
            case 8:
                strF = "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
                break;
            case 9:
                strF = "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
                break;
            case 10:
                strF = "USAGE_NOTIFICATION_EVENT";
                break;
            case 11:
                strF = "USAGE_ASSISTANCE_ACCESSIBILITY";
                break;
            case 12:
                strF = "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
                break;
            case 13:
                strF = "USAGE_ASSISTANCE_SONIFICATION";
                break;
            case 14:
                strF = "USAGE_GAME";
                break;
            case 15:
            default:
                strF = c.f("unknown usage ", i10);
                break;
            case 16:
                strF = "USAGE_ASSISTANT";
                break;
        }
        sb2.append(strF);
        sb2.append(" content=");
        sb2.append(this.f3542b);
        sb2.append(" flags=0x");
        sb2.append(Integer.toHexString(this.f3543c).toUpperCase());
        return sb2.toString();
    }
}
