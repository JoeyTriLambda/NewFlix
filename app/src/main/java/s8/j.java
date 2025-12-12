package s8;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

/* compiled from: QueueFileLogStore.java */
/* loaded from: classes.dex */
public final class j implements c {

    /* renamed from: d, reason: collision with root package name */
    public static final Charset f19156d = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final File f19157a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19158b = 65536;

    /* renamed from: c, reason: collision with root package name */
    public h f19159c;

    /* compiled from: QueueFileLogStore.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f19160a;

        /* renamed from: b, reason: collision with root package name */
        public final int f19161b;

        public a(byte[] bArr, int i10) {
            this.f19160a = bArr;
            this.f19161b = i10;
        }
    }

    public j(File file) {
        this.f19157a = file;
    }

    public final void a() {
        File file = this.f19157a;
        if (this.f19159c == null) {
            try {
                this.f19159c = new h(file);
            } catch (IOException e10) {
                o8.e.getLogger().e("Could not open log file: " + file, e10);
            }
        }
    }

    @Override // s8.c
    public void closeLogFile() throws IOException {
        CommonUtils.closeOrLog(this.f19159c, "There was a problem closing the Crashlytics log file.");
        this.f19159c = null;
    }

    @Override // s8.c
    public void deleteLogFile() throws IOException {
        closeLogFile();
        this.f19157a.delete();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    @Override // s8.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] getLogAsBytes() {
        /*
            r7 = this;
            java.io.File r0 = r7.f19157a
            boolean r0 = r0.exists()
            r1 = 0
            r2 = 0
            if (r0 != 0) goto Lb
            goto L12
        Lb:
            r7.a()
            s8.h r0 = r7.f19159c
            if (r0 != 0) goto L14
        L12:
            r4 = r1
            goto L3b
        L14:
            r3 = 1
            int[] r3 = new int[r3]
            r3[r2] = r2
            int r0 = r0.usedBytes()
            byte[] r0 = new byte[r0]
            s8.h r4 = r7.f19159c     // Catch: java.io.IOException -> L2a
            s8.i r5 = new s8.i     // Catch: java.io.IOException -> L2a
            r5.<init>(r0, r3)     // Catch: java.io.IOException -> L2a
            r4.forEach(r5)     // Catch: java.io.IOException -> L2a
            goto L34
        L2a:
            r4 = move-exception
            o8.e r5 = o8.e.getLogger()
            java.lang.String r6 = "A problem occurred while reading the Crashlytics log file."
            r5.e(r6, r4)
        L34:
            s8.j$a r4 = new s8.j$a
            r3 = r3[r2]
            r4.<init>(r0, r3)
        L3b:
            if (r4 != 0) goto L3e
            return r1
        L3e:
            int r0 = r4.f19161b
            byte[] r1 = new byte[r0]
            byte[] r3 = r4.f19160a
            java.lang.System.arraycopy(r3, r2, r1, r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.j.getLogAsBytes():byte[]");
    }

    @Override // s8.c
    public String getLogAsString() {
        byte[] logAsBytes = getLogAsBytes();
        if (logAsBytes != null) {
            return new String(logAsBytes, f19156d);
        }
        return null;
    }

    @Override // s8.c
    public void writeToLog(long j10, String str) {
        a();
        int i10 = this.f19158b;
        if (this.f19159c == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            int i11 = i10 / 4;
            if (str.length() > i11) {
                str = "..." + str.substring(str.length() - i11);
            }
            this.f19159c.add(String.format(Locale.US, "%d %s%n", Long.valueOf(j10), str.replaceAll(StringUtils.CR, StringUtils.SPACE).replaceAll(StringUtils.LF, StringUtils.SPACE)).getBytes(f19156d));
            while (!this.f19159c.isEmpty() && this.f19159c.usedBytes() > i10) {
                this.f19159c.remove();
            }
        } catch (IOException e10) {
            o8.e.getLogger().e("There was a problem writing to the Crashlytics log.", e10);
        }
    }
}
