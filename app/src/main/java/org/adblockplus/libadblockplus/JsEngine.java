package org.adblockplus.libadblockplus;

import java.util.List;

/* loaded from: classes2.dex */
public final class JsEngine {
    protected final long ptr;

    static {
        System.loadLibrary(BuildConfig.nativeLibraryName);
        registerNatives();
    }

    public JsEngine(long j10) {
        this.ptr = j10;
    }

    private static native JsValue evaluate(long j10, String str, String str2);

    private static native JsValue newValue(long j10, long j11);

    private static native JsValue newValue(long j10, String str);

    private static native JsValue newValue(long j10, boolean z10);

    private static native void onLowMemory(long j10);

    private static native void registerNatives();

    private static native void removeEventCallback(long j10, String str);

    private static native void setEventCallback(long j10, String str, long j11);

    private static native void setGlobalProperty(long j10, String str, long j11);

    private static native void triggerEvent(long j10, String str, long[] jArr);

    public JsValue evaluate(String str, String str2) {
        return evaluate(this.ptr, str, str2);
    }

    public JsValue newValue(long j10) {
        return newValue(this.ptr, j10);
    }

    public void onLowMemory() {
        onLowMemory(this.ptr);
    }

    public void removeEventCallback(String str) {
        removeEventCallback(this.ptr, str);
    }

    public void setEventCallback(String str, EventCallback eventCallback) {
        setEventCallback(this.ptr, str, eventCallback.ptr);
    }

    public void setGlobalProperty(String str, JsValue jsValue) {
        setGlobalProperty(this.ptr, str, jsValue.ptr);
    }

    public void triggerEvent(String str, List<JsValue> list) {
        int size = list.size();
        long[] jArr = new long[size];
        for (int i10 = 0; i10 < size; i10++) {
            jArr[i10] = list.get(i10).ptr;
        }
        triggerEvent(this.ptr, str, jArr);
    }

    public JsValue evaluate(String str) {
        return evaluate(this.ptr, str, "");
    }

    public JsValue newValue(boolean z10) {
        return newValue(this.ptr, z10);
    }

    public JsValue newValue(String str) {
        return newValue(this.ptr, str);
    }

    public void triggerEvent(String str) {
        triggerEvent(this.ptr, str, null);
    }
}
