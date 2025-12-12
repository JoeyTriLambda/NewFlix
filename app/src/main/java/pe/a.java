package pe;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import ne.r;

/* compiled from: AndroidSchedulers.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final r f17679a = oe.a.initMainThreadScheduler(new CallableC0224a());

    /* compiled from: AndroidSchedulers.java */
    /* renamed from: pe.a$a, reason: collision with other inner class name */
    public static class CallableC0224a implements Callable<r> {
        @Override // java.util.concurrent.Callable
        public r call() throws Exception {
            return b.f17680a;
        }
    }

    /* compiled from: AndroidSchedulers.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final pe.b f17680a = new pe.b(new Handler(Looper.getMainLooper()));
    }

    public static r mainThread() {
        return oe.a.onMainThreadScheduler(f17679a);
    }
}
