package g3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;

/* compiled from: WorkForegroundRunnable.java */
/* loaded from: classes.dex */
public final class v implements Runnable {

    /* renamed from: r, reason: collision with root package name */
    public static final String f12669r = w2.g.tagWithPrefix("WorkForegroundRunnable");

    /* renamed from: b, reason: collision with root package name */
    public final h3.a<Void> f12670b = h3.a.create();

    /* renamed from: m, reason: collision with root package name */
    public final Context f12671m;

    /* renamed from: n, reason: collision with root package name */
    public final f3.t f12672n;

    /* renamed from: o, reason: collision with root package name */
    public final androidx.work.c f12673o;

    /* renamed from: p, reason: collision with root package name */
    public final w2.d f12674p;

    /* renamed from: q, reason: collision with root package name */
    public final i3.c f12675q;

    /* compiled from: WorkForegroundRunnable.java */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h3.a f12676b;

        public a(h3.a aVar) {
            this.f12676b = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            v vVar = v.this;
            if (vVar.f12670b.isCancelled()) {
                return;
            }
            try {
                w2.c cVar = (w2.c) this.f12676b.get();
                if (cVar == null) {
                    throw new IllegalStateException("Worker was marked important (" + vVar.f12672n.f11428c + ") but did not provide ForegroundInfo");
                }
                w2.g.get().debug(v.f12669r, "Updating notification for " + vVar.f12672n.f11428c);
                vVar.f12670b.setFuture(((w) vVar.f12674p).setForegroundAsync(vVar.f12671m, vVar.f12673o.getId(), cVar));
            } catch (Throwable th2) {
                vVar.f12670b.setException(th2);
            }
        }
    }

    @SuppressLint({"LambdaLast"})
    public v(Context context, f3.t tVar, androidx.work.c cVar, w2.d dVar, i3.c cVar2) {
        this.f12671m = context;
        this.f12672n = tVar;
        this.f12673o = cVar;
        this.f12674p = dVar;
        this.f12675q = cVar2;
    }

    public e8.c<Void> getFuture() {
        return this.f12670b;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"UnsafeExperimentalUsageError"})
    public void run() {
        if (!this.f12672n.f11442q || Build.VERSION.SDK_INT >= 31) {
            this.f12670b.set(null);
            return;
        }
        h3.a aVarCreate = h3.a.create();
        i3.c cVar = this.f12675q;
        ((i3.d) cVar).getMainThreadExecutor().execute(new r.x(9, this, aVarCreate));
        aVarCreate.addListener(new a(aVarCreate), ((i3.d) cVar).getMainThreadExecutor());
    }
}
