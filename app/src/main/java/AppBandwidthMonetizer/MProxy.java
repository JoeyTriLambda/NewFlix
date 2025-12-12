package AppBandwidthMonetizer;

import android.util.Log;

/* compiled from: MProxy.kt */
/* loaded from: classes.dex */
public final class MProxy {
    static {
        System.loadLibrary("mproxy");
        Log.d("mproxy", "Library loaded");
    }

    public static final native void reload();

    public static final native int start(String[] strArr);

    public static final native void stop();
}
