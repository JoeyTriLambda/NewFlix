package r8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* compiled from: FileBackedNativeSessionFile.java */
/* loaded from: classes.dex */
public final class g0 implements j0 {

    /* renamed from: a, reason: collision with root package name */
    public final File f18695a;

    /* renamed from: b, reason: collision with root package name */
    public final String f18696b;

    /* renamed from: c, reason: collision with root package name */
    public final String f18697c;

    public g0(String str, String str2, File file) {
        this.f18696b = str;
        this.f18697c = str2;
        this.f18695a = file;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    @Override // r8.j0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public t8.f0.d.b asFilePayload() throws java.io.IOException {
        /*
            r7 = this;
            r0 = 8192(0x2000, float:1.148E-41)
            byte[] r0 = new byte[r0]
            r1 = 0
            java.io.InputStream r2 = r7.getStream()     // Catch: java.io.IOException -> L5d
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L51
            r3.<init>()     // Catch: java.lang.Throwable -> L51
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L47
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L47
            if (r2 != 0) goto L21
            r4.close()     // Catch: java.lang.Throwable -> L47
            r3.close()     // Catch: java.lang.Throwable -> L51
            if (r2 == 0) goto L5d
            r2.close()     // Catch: java.io.IOException -> L5d
            goto L5d
        L21:
            int r5 = r2.read(r0)     // Catch: java.lang.Throwable -> L3d
            if (r5 <= 0) goto L2c
            r6 = 0
            r4.write(r0, r6, r5)     // Catch: java.lang.Throwable -> L3d
            goto L21
        L2c:
            r4.finish()     // Catch: java.lang.Throwable -> L3d
            byte[] r0 = r3.toByteArray()     // Catch: java.lang.Throwable -> L3d
            r4.close()     // Catch: java.lang.Throwable -> L47
            r3.close()     // Catch: java.lang.Throwable -> L51
            r2.close()     // Catch: java.io.IOException -> L5d
            goto L5e
        L3d:
            r0 = move-exception
            r4.close()     // Catch: java.lang.Throwable -> L42
            goto L46
        L42:
            r4 = move-exception
            r0.addSuppressed(r4)     // Catch: java.lang.Throwable -> L47
        L46:
            throw r0     // Catch: java.lang.Throwable -> L47
        L47:
            r0 = move-exception
            r3.close()     // Catch: java.lang.Throwable -> L4c
            goto L50
        L4c:
            r3 = move-exception
            r0.addSuppressed(r3)     // Catch: java.lang.Throwable -> L51
        L50:
            throw r0     // Catch: java.lang.Throwable -> L51
        L51:
            r0 = move-exception
            if (r2 == 0) goto L5c
            r2.close()     // Catch: java.lang.Throwable -> L58
            goto L5c
        L58:
            r2 = move-exception
            r0.addSuppressed(r2)     // Catch: java.io.IOException -> L5d
        L5c:
            throw r0     // Catch: java.io.IOException -> L5d
        L5d:
            r0 = r1
        L5e:
            if (r0 == 0) goto L72
            t8.f0$d$b$a r1 = t8.f0.d.b.builder()
            t8.f0$d$b$a r0 = r1.setContents(r0)
            java.lang.String r1 = r7.f18696b
            t8.f0$d$b$a r0 = r0.setFilename(r1)
            t8.f0$d$b r1 = r0.build()
        L72:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: r8.g0.asFilePayload():t8.f0$d$b");
    }

    @Override // r8.j0
    public String getReportsEndpointFilename() {
        return this.f18697c;
    }

    @Override // r8.j0
    public InputStream getStream() {
        File file = this.f18695a;
        if (file.exists() && file.isFile()) {
            try {
                return new FileInputStream(file);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }
}
