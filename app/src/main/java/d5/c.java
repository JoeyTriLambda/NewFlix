package d5;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;

/* compiled from: AudioCapabilities.java */
@TargetApi(21)
/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final c f10867c = new c(new int[]{2}, 2);

    /* renamed from: a, reason: collision with root package name */
    public final int[] f10868a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10869b;

    public c(int[] iArr, int i10) {
        if (iArr != null) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.f10868a = iArrCopyOf;
            Arrays.sort(iArrCopyOf);
        } else {
            this.f10868a = new int[0];
        }
        this.f10869b = i10;
    }

    public static c getCapabilities(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
        return (intentRegisterReceiver == null || intentRegisterReceiver.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? f10867c : new c(intentRegisterReceiver.getIntArrayExtra("android.media.extra.ENCODINGS"), intentRegisterReceiver.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Arrays.equals(this.f10868a, cVar.f10868a) && this.f10869b == cVar.f10869b;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f10868a) * 31) + this.f10869b;
    }

    public boolean supportsEncoding(int i10) {
        return Arrays.binarySearch(this.f10868a, i10) >= 0;
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f10869b + ", supportedEncodings=" + Arrays.toString(this.f10868a) + "]";
    }
}
