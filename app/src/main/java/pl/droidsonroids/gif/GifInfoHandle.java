package pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.os.Build;
import android.system.Os;
import java.io.FileDescriptor;
import java.io.IOException;

/* loaded from: classes2.dex */
final class GifInfoHandle {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f17747b = 0;

    /* renamed from: a, reason: collision with root package name */
    public volatile long f17748a;

    static {
        try {
            System.loadLibrary("pl_droidsonroids_gif");
        } catch (UnsatisfiedLinkError unused) {
            if (ai.d.f737a == null) {
                try {
                    ai.d.f737a = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
                } catch (Exception e10) {
                    throw new IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", e10);
                }
            }
            h4.b.loadLibrary(ai.d.f737a, "pl_droidsonroids_gif");
        }
    }

    public GifInfoHandle(String str) throws GifIOException {
        this.f17748a = openFile(str);
    }

    public static native int createTempNativeFileDescriptor() throws GifIOException;

    public static native int extractNativeFileDescriptor(FileDescriptor fileDescriptor, boolean z10) throws GifIOException;

    private static native void free(long j10);

    private static native int getCurrentFrameIndex(long j10);

    private static native int getCurrentLoop(long j10);

    private static native int getCurrentPosition(long j10);

    private static native int getDuration(long j10);

    private static native int getHeight(long j10);

    private static native int getLoopCount(long j10);

    private static native int getNativeErrorCode(long j10);

    private static native int getNumberOfFrames(long j10);

    private static native long[] getSavedState(long j10);

    private static native int getWidth(long j10);

    private static native boolean isOpaque(long j10);

    public static native long openFile(String str) throws GifIOException;

    public static native long openNativeFileDescriptor(int i10, long j10) throws GifIOException;

    private static native long renderFrame(long j10, Bitmap bitmap);

    private static native boolean reset(long j10);

    private static native long restoreRemainder(long j10);

    private static native int restoreSavedState(long j10, long[] jArr, Bitmap bitmap);

    private static native void saveRemainder(long j10);

    private static native void seekToTime(long j10, int i10, Bitmap bitmap);

    private static native void setLoopCount(long j10, char c10);

    public final synchronized int a() {
        return getCurrentFrameIndex(this.f17748a);
    }

    public final synchronized int b() {
        return getCurrentLoop(this.f17748a);
    }

    public final synchronized int c() {
        return getCurrentPosition(this.f17748a);
    }

    public final synchronized int d() {
        return getDuration(this.f17748a);
    }

    public final synchronized int e() {
        return getHeight(this.f17748a);
    }

    public final synchronized int f() {
        return getLoopCount(this.f17748a);
    }

    public void finalize() throws Throwable {
        try {
            m();
        } finally {
            super.finalize();
        }
    }

    public final synchronized int g() {
        return getNativeErrorCode(this.f17748a);
    }

    public final synchronized int h() {
        return getNumberOfFrames(this.f17748a);
    }

    public final synchronized long[] i() {
        return getSavedState(this.f17748a);
    }

    public final synchronized int j() {
        return getWidth(this.f17748a);
    }

    public final synchronized boolean k() {
        return isOpaque(this.f17748a);
    }

    public final synchronized boolean l() {
        return this.f17748a == 0;
    }

    public final synchronized void m() {
        free(this.f17748a);
        this.f17748a = 0L;
    }

    public final synchronized long n(Bitmap bitmap) {
        return renderFrame(this.f17748a, bitmap);
    }

    public final synchronized boolean o() {
        return reset(this.f17748a);
    }

    public final synchronized long p() {
        return restoreRemainder(this.f17748a);
    }

    public final synchronized int q(long[] jArr, Bitmap bitmap) {
        return restoreSavedState(this.f17748a, jArr, bitmap);
    }

    public final synchronized void r() {
        saveRemainder(this.f17748a);
    }

    public final synchronized void s(Bitmap bitmap, int i10) {
        seekToTime(this.f17748a, i10, bitmap);
    }

    public final void t(int i10) {
        if (i10 < 0 || i10 > 65535) {
            throw new IllegalArgumentException("Loop count of range <0, 65535>");
        }
        synchronized (this) {
            setLoopCount(this.f17748a, (char) i10);
        }
    }

    public GifInfoHandle(AssetFileDescriptor assetFileDescriptor) throws IOException {
        int iCreateTempNativeFileDescriptor;
        try {
            FileDescriptor fileDescriptor = assetFileDescriptor.getFileDescriptor();
            long startOffset = assetFileDescriptor.getStartOffset();
            if (Build.VERSION.SDK_INT > 27) {
                try {
                    iCreateTempNativeFileDescriptor = createTempNativeFileDescriptor();
                    Os.dup2(fileDescriptor, iCreateTempNativeFileDescriptor);
                } finally {
                }
            } else {
                iCreateTempNativeFileDescriptor = extractNativeFileDescriptor(fileDescriptor, false);
            }
            this.f17748a = openNativeFileDescriptor(iCreateTempNativeFileDescriptor, startOffset);
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
            }
        } catch (Throwable th2) {
            try {
                assetFileDescriptor.close();
            } catch (IOException unused2) {
            }
            throw th2;
        }
    }
}
