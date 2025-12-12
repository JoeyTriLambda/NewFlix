package org.adblockplus.libadblockplus;

/* loaded from: classes2.dex */
public abstract class FilterChangeCallback implements Disposable {
    private final Disposer disposer;
    protected final long ptr;

    public static final class DisposeWrapper implements Disposable {
        private final long ptr;

        public DisposeWrapper(long j10) {
            this.ptr = j10;
        }

        @Override // org.adblockplus.libadblockplus.Disposable
        public void dispose() {
            FilterChangeCallback.dtor(this.ptr);
        }
    }

    static {
        System.loadLibrary(BuildConfig.nativeLibraryName);
        registerNatives();
    }

    public FilterChangeCallback() {
        long jCtor = ctor(this);
        this.ptr = jCtor;
        this.disposer = new Disposer(this, new DisposeWrapper(jCtor));
    }

    private static native long ctor(Object obj);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void dtor(long j10);

    private static native void registerNatives();

    @Override // org.adblockplus.libadblockplus.Disposable
    public void dispose() {
        this.disposer.dispose();
    }

    public abstract void filterChangeCallback(String str, JsValue jsValue);
}
