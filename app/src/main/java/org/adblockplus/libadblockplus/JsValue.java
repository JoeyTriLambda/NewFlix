package org.adblockplus.libadblockplus;

import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class JsValue implements Disposable {
    private final Disposer disposer;
    protected final long ptr;

    public static final class DisposeWrapper implements Disposable {
        private final long ptr;

        public DisposeWrapper(long j10) {
            this.ptr = j10;
        }

        @Override // org.adblockplus.libadblockplus.Disposable
        public void dispose() {
            JsValue.dtor(this.ptr);
        }
    }

    static {
        System.loadLibrary(BuildConfig.nativeLibraryName);
        registerNatives();
    }

    public JsValue(long j10) {
        this.ptr = j10;
        this.disposer = new Disposer(this, new DisposeWrapper(j10));
    }

    private static native boolean asBoolean(long j10);

    private static native List<JsValue> asList(long j10);

    private static native long asLong(long j10);

    private static native String asString(long j10);

    private static native JsValue call(long j10, long[] jArr);

    private static native JsValue call(long j10, long[] jArr, long j11);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void dtor(long j10);

    private static native String getJsClass(long j10);

    private static native List<String> getOwnPropertyNames(long j10);

    private static native JsValue getProperty(long j10, String str);

    private static native boolean isArray(long j10);

    private static native boolean isBoolean(long j10);

    private static native boolean isFunction(long j10);

    private static native boolean isNull(long j10);

    private static native boolean isNumber(long j10);

    private static native boolean isObject(long j10);

    private static native boolean isString(long j10);

    private static native boolean isUndefined(long j10);

    private static native void registerNatives();

    private static native void setProperty(long j10, String str, long j11);

    public boolean asBoolean() {
        return asBoolean(this.ptr);
    }

    public List<JsValue> asList() {
        return asList(this.ptr);
    }

    public long asLong() {
        return asLong(this.ptr);
    }

    public String asString() {
        return asString(this.ptr);
    }

    public JsValue call(List<JsValue> list) {
        return call(this.ptr, convertToPtrArray(list));
    }

    public long[] convertToPtrArray(List<JsValue> list) {
        long[] jArr = new long[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            jArr[i10] = list.get(i10).ptr;
        }
        return jArr;
    }

    @Override // org.adblockplus.libadblockplus.Disposable
    public void dispose() {
        this.disposer.dispose();
    }

    public String getJsClass() {
        return getJsClass(this.ptr);
    }

    public List<String> getOwnPropertyNames() {
        return getOwnPropertyNames(this.ptr);
    }

    public JsValue getProperty(String str) {
        return getProperty(this.ptr, str);
    }

    public boolean isArray() {
        return isArray(this.ptr);
    }

    public boolean isBoolean() {
        return isBoolean(this.ptr);
    }

    public boolean isFunction() {
        return isFunction(this.ptr);
    }

    public boolean isNull() {
        return isNull(this.ptr);
    }

    public boolean isNumber() {
        return isNumber(this.ptr);
    }

    public boolean isObject() {
        return isObject(this.ptr);
    }

    public boolean isString() {
        return isString(this.ptr);
    }

    public boolean isUndefined() {
        return isUndefined(this.ptr);
    }

    public void setProperty(String str, JsValue jsValue) {
        setProperty(this.ptr, str, jsValue.ptr);
    }

    public String toString() {
        return asString(this.ptr);
    }

    public JsValue call(List<JsValue> list, JsValue jsValue) {
        return call(this.ptr, convertToPtrArray(list), jsValue.ptr);
    }

    public JsValue call() {
        return call(Collections.emptyList());
    }
}
