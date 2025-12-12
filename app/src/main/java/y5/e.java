package y5;

import android.util.Log;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* compiled from: HlsManifest.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final Object f21938a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f21939b;

    public /* synthetic */ e(Object obj, Object obj2) {
        this.f21938a = obj;
        this.f21939b = obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static y5.e a(android.content.Context r5) throws java.io.IOException {
        /*
            java.lang.String r0 = "generatefid.lock"
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L31 java.io.IOException -> L33
            java.io.File r5 = r5.getFilesDir()     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L31 java.io.IOException -> L33
            r2.<init>(r5, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L31 java.io.IOException -> L33
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L31 java.io.IOException -> L33
            java.lang.String r0 = "rw"
            r5.<init>(r2, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L31 java.io.IOException -> L33
            java.nio.channels.FileChannel r5 = r5.getChannel()     // Catch: java.nio.channels.OverlappingFileLockException -> L2f java.lang.Error -> L31 java.io.IOException -> L33
            java.nio.channels.FileLock r0 = r5.lock()     // Catch: java.nio.channels.OverlappingFileLockException -> L27 java.lang.Error -> L29 java.io.IOException -> L2b
            y5.e r2 = new y5.e     // Catch: java.nio.channels.OverlappingFileLockException -> L21 java.lang.Error -> L23 java.io.IOException -> L25
            r2.<init>(r5, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L21 java.lang.Error -> L23 java.io.IOException -> L25
            return r2
        L21:
            r2 = move-exception
            goto L37
        L23:
            r2 = move-exception
            goto L37
        L25:
            r2 = move-exception
            goto L37
        L27:
            r0 = move-exception
            goto L2c
        L29:
            r0 = move-exception
            goto L2c
        L2b:
            r0 = move-exception
        L2c:
            r2 = r0
            r0 = r1
            goto L37
        L2f:
            r5 = move-exception
            goto L34
        L31:
            r5 = move-exception
            goto L34
        L33:
            r5 = move-exception
        L34:
            r2 = r5
            r5 = r1
            r0 = r5
        L37:
            java.lang.String r3 = "CrossProcessLock"
            java.lang.String r4 = "encountered error while creating and acquiring the lock, ignoring"
            android.util.Log.e(r3, r4, r2)
            if (r0 == 0) goto L45
            r0.release()     // Catch: java.io.IOException -> L44
            goto L45
        L44:
        L45:
            if (r5 == 0) goto L4a
            r5.close()     // Catch: java.io.IOException -> L4a
        L4a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: y5.e.a(android.content.Context):y5.e");
    }

    public final void b() throws IOException {
        try {
            ((FileLock) this.f21939b).release();
            ((FileChannel) this.f21938a).close();
        } catch (IOException e10) {
            Log.e("CrossProcessLock", "encountered error while releasing, ignoring", e10);
        }
    }
}
