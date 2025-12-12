package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* compiled from: ProfileVerifier.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final c0.a<c> f3854a = c0.a.create();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f3855b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static c f3856c = null;

    /* compiled from: ProfileVerifier.java */
    public static class a {
        public static PackageInfo a(PackageManager packageManager, Context context) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    /* compiled from: ProfileVerifier.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f3857a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3858b;

        /* renamed from: c, reason: collision with root package name */
        public final long f3859c;

        /* renamed from: d, reason: collision with root package name */
        public final long f3860d;

        public b(long j10, int i10, int i11, long j11) {
            this.f3857a = i10;
            this.f3858b = i11;
            this.f3859c = j10;
            this.f3860d = j11;
        }

        public static b a(File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readLong(), dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } catch (Throwable th2) {
                try {
                    dataInputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }

        public final void b(File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f3857a);
                dataOutputStream.writeInt(this.f3858b);
                dataOutputStream.writeLong(this.f3859c);
                dataOutputStream.writeLong(this.f3860d);
                dataOutputStream.close();
            } catch (Throwable th2) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f3858b == bVar.f3858b && this.f3859c == bVar.f3859c && this.f3857a == bVar.f3857a && this.f3860d == bVar.f3860d;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f3858b), Long.valueOf(this.f3859c), Integer.valueOf(this.f3857a), Long.valueOf(this.f3860d));
        }
    }

    /* compiled from: ProfileVerifier.java */
    public static class c {
    }

    public static long a(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? a.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static c b(int i10, boolean z10, boolean z11) {
        c cVar = new c();
        f3856c = cVar;
        f3854a.set(cVar);
        return f3856c;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(android.content.Context r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.e.c(android.content.Context, boolean):void");
    }
}
