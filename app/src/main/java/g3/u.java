package g3;

import android.os.PowerManager;
import java.util.WeakHashMap;

/* compiled from: WakeLocks.kt */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final u f12667a = new u();

    /* renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<PowerManager.WakeLock, String> f12668b = new WeakHashMap<>();

    public final WeakHashMap<PowerManager.WakeLock, String> getWakeLocks() {
        return f12668b;
    }
}
