package r8;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: NativeSessionFileGzipper.java */
/* loaded from: classes.dex */
public final class k0 {
    public static void a(File file, InputStream inputStream) throws Throwable {
        GZIPOutputStream gZIPOutputStream;
        byte[] bArr = new byte[8192];
        try {
            gZIPOutputStream = new GZIPOutputStream(new FileOutputStream(file));
            while (true) {
                try {
                    int i10 = inputStream.read(bArr);
                    if (i10 <= 0) {
                        gZIPOutputStream.finish();
                        CommonUtils.closeQuietly(gZIPOutputStream);
                        return;
                    }
                    gZIPOutputStream.write(bArr, 0, i10);
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.closeQuietly(gZIPOutputStream);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            gZIPOutputStream = null;
        }
    }
}
