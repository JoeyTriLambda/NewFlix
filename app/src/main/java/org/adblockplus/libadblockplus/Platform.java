package org.adblockplus.libadblockplus;

/* loaded from: classes2.dex */
public class Platform implements Disposable {
    private final Disposer disposer;
    protected final long ptr;

    public static final class DisposeWrapper implements Disposable {
        private final long ptr;

        public DisposeWrapper(long j10) {
            this.ptr = j10;
        }

        @Override // org.adblockplus.libadblockplus.Disposable
        public void dispose() {
            Platform.dtor(this.ptr);
        }
    }

    static {
        System.loadLibrary(BuildConfig.nativeLibraryName);
        registerNatives();
    }

    public Platform(LogSystem logSystem, FileSystem fileSystem, HttpClient httpClient, String str) {
        this(ctor(logSystem, fileSystem, httpClient, str));
    }

    private static native long ctor(LogSystem logSystem, FileSystem fileSystem, HttpClient httpClient, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void dtor(long j10);

    private static native void ensureFilterEngine(long j10);

    private static native long getJsEnginePtr(long j10);

    private static native void registerNatives();

    private static native void setUpFilterEngine(long j10, IsAllowedConnectionCallback isAllowedConnectionCallback, boolean z10);

    private static native void setUpJsEngine(long j10, AppInfo appInfo, long j11);

    @Override // org.adblockplus.libadblockplus.Disposable
    public void dispose() {
        this.disposer.dispose();
    }

    public FilterEngine getFilterEngine() {
        ensureFilterEngine(this.ptr);
        return new FilterEngine(this.ptr);
    }

    public JsEngine getJsEngine() {
        return new JsEngine(getJsEnginePtr(this.ptr));
    }

    public void setUpFilterEngine(IsAllowedConnectionCallback isAllowedConnectionCallback, boolean z10) {
        setUpFilterEngine(this.ptr, isAllowedConnectionCallback, z10);
    }

    public void setUpJsEngine(AppInfo appInfo, long j10) {
        setUpJsEngine(this.ptr, appInfo, j10);
    }

    public Platform(long j10) {
        this.ptr = j10;
        this.disposer = new Disposer(this, new DisposeWrapper(j10));
    }

    public void setUpJsEngine(AppInfo appInfo) {
        setUpJsEngine(appInfo, 0L);
    }
}
