package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;

/* compiled from: ServiceLifecycleDispatcher.kt */
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final m f3527a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f3528b;

    /* renamed from: c, reason: collision with root package name */
    public a f3529c;

    /* compiled from: ServiceLifecycleDispatcher.kt */
    public static final class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final m f3530b;

        /* renamed from: m, reason: collision with root package name */
        public final Lifecycle.Event f3531m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f3532n;

        public a(m mVar, Lifecycle.Event event) {
            zf.i.checkNotNullParameter(mVar, "registry");
            zf.i.checkNotNullParameter(event, "event");
            this.f3530b = mVar;
            this.f3531m = event;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3532n) {
                return;
            }
            this.f3530b.handleLifecycleEvent(this.f3531m);
            this.f3532n = true;
        }
    }

    public y(l lVar) {
        zf.i.checkNotNullParameter(lVar, "provider");
        this.f3527a = new m(lVar);
        this.f3528b = new Handler();
    }

    public final void a(Lifecycle.Event event) {
        a aVar = this.f3529c;
        if (aVar != null) {
            aVar.run();
        }
        a aVar2 = new a(this.f3527a, event);
        this.f3529c = aVar2;
        Handler handler = this.f3528b;
        zf.i.checkNotNull(aVar2);
        handler.postAtFrontOfQueue(aVar2);
    }

    public Lifecycle getLifecycle() {
        return this.f3527a;
    }

    public void onServicePreSuperOnBind() {
        a(Lifecycle.Event.ON_START);
    }

    public void onServicePreSuperOnCreate() {
        a(Lifecycle.Event.ON_CREATE);
    }

    public void onServicePreSuperOnDestroy() {
        a(Lifecycle.Event.ON_STOP);
        a(Lifecycle.Event.ON_DESTROY);
    }

    public void onServicePreSuperOnStart() {
        a(Lifecycle.Event.ON_START);
    }
}
