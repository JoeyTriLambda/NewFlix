package i3;

import android.os.Handler;
import android.os.Looper;
import g3.p;
import java.util.concurrent.Executor;

/* compiled from: WorkManagerTaskExecutor.java */
/* loaded from: classes.dex */
public final class d implements c {

    /* renamed from: a, reason: collision with root package name */
    public final p f13134a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f13135b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    public final a f13136c = new a();

    /* compiled from: WorkManagerTaskExecutor.java */
    public class a implements Executor {
        public a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            d.this.f13135b.post(runnable);
        }
    }

    public d(Executor executor) {
        this.f13134a = new p(executor);
    }

    public Executor getMainThreadExecutor() {
        return this.f13136c;
    }

    /* renamed from: getSerialTaskExecutor, reason: merged with bridge method [inline-methods] */
    public p m31getSerialTaskExecutor() {
        return this.f13134a;
    }
}
