package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* compiled from: LogWriter.java */
/* loaded from: classes.dex */
public final class m0 extends Writer {

    /* renamed from: m, reason: collision with root package name */
    public final StringBuilder f2878m = new StringBuilder(128);

    /* renamed from: b, reason: collision with root package name */
    public final String f2877b = "FragmentManager";

    public final void a() {
        StringBuilder sb2 = this.f2878m;
        if (sb2.length() > 0) {
            Log.d(this.f2877b, sb2.toString());
            sb2.delete(0, sb2.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            char c10 = cArr[i10 + i12];
            if (c10 == '\n') {
                a();
            } else {
                this.f2878m.append(c10);
            }
        }
    }
}
