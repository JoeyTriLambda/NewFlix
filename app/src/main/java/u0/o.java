package u0;

import android.os.Handler;
import java.util.concurrent.Callable;

/* compiled from: RequestExecutor.java */
/* loaded from: classes.dex */
public final class o<T> implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final Callable<T> f19966b;

    /* renamed from: m, reason: collision with root package name */
    public final w0.a<T> f19967m;

    /* renamed from: n, reason: collision with root package name */
    public final Handler f19968n;

    /* compiled from: RequestExecutor.java */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w0.a f19969b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Object f19970m;

        public a(w0.a aVar, Object obj) {
            this.f19969b = aVar;
            this.f19970m = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            this.f19969b.accept(this.f19970m);
        }
    }

    public o(Handler handler, j jVar, k kVar) {
        this.f19966b = jVar;
        this.f19967m = kVar;
        this.f19968n = handler;
    }

    @Override // java.lang.Runnable
    public void run() throws Exception {
        T tCall;
        try {
            tCall = this.f19966b.call();
        } catch (Exception unused) {
            tCall = null;
        }
        this.f19968n.post(new a(this.f19967m, tCall));
    }
}
