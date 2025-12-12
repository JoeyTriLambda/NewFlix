package m2;

import ac.c;
import android.annotation.SuppressLint;
import android.util.Log;
import com.unity3d.ads.metadata.MediationMetaData;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import zf.f;
import zf.i;

/* compiled from: ProcessLock.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final C0193a f16093e = new C0193a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final HashMap f16094f = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f16095a;

    /* renamed from: b, reason: collision with root package name */
    public final File f16096b;

    /* renamed from: c, reason: collision with root package name */
    @SuppressLint({"SyntheticAccessor"})
    public final Lock f16097c;

    /* renamed from: d, reason: collision with root package name */
    public FileChannel f16098d;

    /* compiled from: ProcessLock.kt */
    /* renamed from: m2.a$a, reason: collision with other inner class name */
    public static final class C0193a {
        public C0193a(f fVar) {
        }

        public static final Lock access$getThreadLock(C0193a c0193a, String str) {
            Lock lock;
            c0193a.getClass();
            synchronized (a.f16094f) {
                Map map = a.f16094f;
                Object reentrantLock = map.get(str);
                if (reentrantLock == null) {
                    reentrantLock = new ReentrantLock();
                    map.put(str, reentrantLock);
                }
                lock = (Lock) reentrantLock;
            }
            return lock;
        }
    }

    public a(String str, File file, boolean z10) {
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        i.checkNotNullParameter(file, "lockDir");
        this.f16095a = z10;
        File file2 = new File(file, c.B(str, ".lck"));
        this.f16096b = file2;
        String absolutePath = file2.getAbsolutePath();
        i.checkNotNullExpressionValue(absolutePath, "lockFile.absolutePath");
        this.f16097c = C0193a.access$getThreadLock(f16093e, absolutePath);
    }

    public static /* synthetic */ void lock$default(a aVar, boolean z10, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            z10 = aVar.f16095a;
        }
        aVar.lock(z10);
    }

    public final void lock(boolean z10) throws IOException {
        this.f16097c.lock();
        if (z10) {
            File file = this.f16096b;
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(file).getChannel();
                channel.lock();
                this.f16098d = channel;
            } catch (IOException e10) {
                this.f16098d = null;
                Log.w("SupportSQLiteLock", "Unable to grab file lock.", e10);
            }
        }
    }

    public final void unlock() throws IOException {
        try {
            FileChannel fileChannel = this.f16098d;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.f16097c.unlock();
    }
}
