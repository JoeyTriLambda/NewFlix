package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.v;

/* compiled from: ProcessLifecycleOwner.kt */
/* loaded from: classes.dex */
public final class u implements l {

    /* renamed from: t, reason: collision with root package name */
    public static final b f3506t = new b(null);

    /* renamed from: u, reason: collision with root package name */
    public static final u f3507u = new u();

    /* renamed from: b, reason: collision with root package name */
    public int f3508b;

    /* renamed from: m, reason: collision with root package name */
    public int f3509m;

    /* renamed from: p, reason: collision with root package name */
    public Handler f3512p;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3510n = true;

    /* renamed from: o, reason: collision with root package name */
    public boolean f3511o = true;

    /* renamed from: q, reason: collision with root package name */
    public final m f3513q = new m(this);

    /* renamed from: r, reason: collision with root package name */
    public final androidx.activity.d f3514r = new androidx.activity.d(this, 5);

    /* renamed from: s, reason: collision with root package name */
    public final d f3515s = new d();

    /* compiled from: ProcessLifecycleOwner.kt */
    public static final class a {
        public static final void registerActivityLifecycleCallbacks(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            zf.i.checkNotNullParameter(activity, "activity");
            zf.i.checkNotNullParameter(activityLifecycleCallbacks, "callback");
            activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    /* compiled from: ProcessLifecycleOwner.kt */
    public static final class b {
        public b(zf.f fVar) {
        }

        public final l get() {
            return u.f3507u;
        }

        public final void init$lifecycle_process_release(Context context) {
            zf.i.checkNotNullParameter(context, "context");
            u.f3507u.attach$lifecycle_process_release(context);
        }
    }

    /* compiled from: ProcessLifecycleOwner.kt */
    public static final class c extends androidx.lifecycle.d {

        /* compiled from: ProcessLifecycleOwner.kt */
        public static final class a extends androidx.lifecycle.d {
            final /* synthetic */ u this$0;

            public a(u uVar) {
                this.this$0 = uVar;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                zf.i.checkNotNullParameter(activity, "activity");
                this.this$0.activityResumed$lifecycle_process_release();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                zf.i.checkNotNullParameter(activity, "activity");
                this.this$0.activityStarted$lifecycle_process_release();
            }
        }

        public c() {
        }

        @Override // androidx.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            zf.i.checkNotNullParameter(activity, "activity");
            if (Build.VERSION.SDK_INT < 29) {
                v.f3517m.get(activity).setProcessListener(u.this.f3515s);
            }
        }

        @Override // androidx.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            zf.i.checkNotNullParameter(activity, "activity");
            u.this.activityPaused$lifecycle_process_release();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            zf.i.checkNotNullParameter(activity, "activity");
            a.registerActivityLifecycleCallbacks(activity, new a(u.this));
        }

        @Override // androidx.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            zf.i.checkNotNullParameter(activity, "activity");
            u.this.activityStopped$lifecycle_process_release();
        }
    }

    public static final l get() {
        return f3506t.get();
    }

    public final void activityPaused$lifecycle_process_release() {
        int i10 = this.f3509m - 1;
        this.f3509m = i10;
        if (i10 == 0) {
            Handler handler = this.f3512p;
            zf.i.checkNotNull(handler);
            handler.postDelayed(this.f3514r, 700L);
        }
    }

    public final void activityResumed$lifecycle_process_release() {
        int i10 = this.f3509m + 1;
        this.f3509m = i10;
        if (i10 == 1) {
            if (this.f3510n) {
                this.f3513q.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
                this.f3510n = false;
            } else {
                Handler handler = this.f3512p;
                zf.i.checkNotNull(handler);
                handler.removeCallbacks(this.f3514r);
            }
        }
    }

    public final void activityStarted$lifecycle_process_release() {
        int i10 = this.f3508b + 1;
        this.f3508b = i10;
        if (i10 == 1 && this.f3511o) {
            this.f3513q.handleLifecycleEvent(Lifecycle.Event.ON_START);
            this.f3511o = false;
        }
    }

    public final void activityStopped$lifecycle_process_release() {
        this.f3508b--;
        dispatchStopIfNeeded$lifecycle_process_release();
    }

    public final void attach$lifecycle_process_release(Context context) {
        zf.i.checkNotNullParameter(context, "context");
        this.f3512p = new Handler();
        this.f3513q.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        zf.i.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new c());
    }

    public final void dispatchPauseIfNeeded$lifecycle_process_release() {
        if (this.f3509m == 0) {
            this.f3510n = true;
            this.f3513q.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
    }

    public final void dispatchStopIfNeeded$lifecycle_process_release() {
        if (this.f3508b == 0 && this.f3510n) {
            this.f3513q.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
            this.f3511o = true;
        }
    }

    @Override // androidx.lifecycle.l
    public Lifecycle getLifecycle() {
        return this.f3513q;
    }

    /* compiled from: ProcessLifecycleOwner.kt */
    public static final class d implements v.a {
        public d() {
        }

        @Override // androidx.lifecycle.v.a
        public void onResume() {
            u.this.activityResumed$lifecycle_process_release();
        }

        @Override // androidx.lifecycle.v.a
        public void onStart() {
            u.this.activityStarted$lifecycle_process_release();
        }

        @Override // androidx.lifecycle.v.a
        public void onCreate() {
        }
    }
}
