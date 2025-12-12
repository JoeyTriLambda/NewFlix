package org.adblockplus.libadblockplus;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public abstract class FileSystem {

    public static class Callback implements Disposable {
        private final Disposer disposer;
        protected final long ptr;

        public static final class DisposeWrapper implements Disposable {
            private final long ptr;

            public DisposeWrapper(long j10) {
                this.ptr = j10;
            }

            @Override // org.adblockplus.libadblockplus.Disposable
            public void dispose() {
                FileSystem.callbackDtor(this.ptr);
            }
        }

        public Callback(long j10) {
            this.ptr = j10;
            this.disposer = new Disposer(this, new DisposeWrapper(j10));
        }

        @Override // org.adblockplus.libadblockplus.Disposable
        public void dispose() {
            this.disposer.dispose();
        }

        public void onFinished(String str) {
            FileSystem.callbackOnFinished(this.ptr, str);
        }
    }

    public static class ReadCallback implements Disposable {
        private final Disposer disposer;
        protected final long ptr;

        public static final class DisposeWrapper implements Disposable {
            private final long ptr;

            public DisposeWrapper(long j10) {
                this.ptr = j10;
            }

            @Override // org.adblockplus.libadblockplus.Disposable
            public void dispose() {
                FileSystem.readCallbackDtor(this.ptr);
            }
        }

        public ReadCallback(long j10) {
            this.ptr = j10;
            this.disposer = new Disposer(this, new DisposeWrapper(j10));
        }

        @Override // org.adblockplus.libadblockplus.Disposable
        public void dispose() {
            this.disposer.dispose();
        }

        public void onFinished(ByteBuffer byteBuffer) {
            FileSystem.readCallbackOnFinished(this.ptr, byteBuffer);
        }
    }

    public static class StatCallback implements Disposable {
        private final Disposer disposer;
        protected final long ptr;

        public static final class DisposeWrapper implements Disposable {
            private final long ptr;

            public DisposeWrapper(long j10) {
                this.ptr = j10;
            }

            @Override // org.adblockplus.libadblockplus.Disposable
            public void dispose() {
                FileSystem.statCallbackDtor(this.ptr);
            }
        }

        public StatCallback(long j10) {
            this.ptr = j10;
            this.disposer = new Disposer(this, new DisposeWrapper(j10));
        }

        @Override // org.adblockplus.libadblockplus.Disposable
        public void dispose() {
            this.disposer.dispose();
        }

        public void onFinished(StatResult statResult, String str) {
            FileSystem.statCallbackOnFinished(this.ptr, statResult, str);
        }
    }

    public static class StatResult {
        private boolean exists;
        private long modified;

        public StatResult(boolean z10, long j10) {
            this.exists = z10;
            this.modified = j10;
        }

        public long getModified() {
            return this.modified;
        }

        public boolean isExists() {
            return this.exists;
        }
    }

    static {
        System.loadLibrary(BuildConfig.nativeLibraryName);
        registerNatives();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void callbackDtor(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void callbackOnFinished(long j10, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void readCallbackDtor(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void readCallbackOnFinished(long j10, ByteBuffer byteBuffer);

    private static native void registerNatives();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void statCallbackDtor(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void statCallbackOnFinished(long j10, StatResult statResult, String str);

    public abstract void move(String str, String str2, Callback callback);

    public abstract void read(String str, ReadCallback readCallback, Callback callback);

    public abstract void remove(String str, Callback callback);

    public abstract void stat(String str, StatCallback statCallback);

    public abstract void write(String str, ByteBuffer byteBuffer, Callback callback);
}
