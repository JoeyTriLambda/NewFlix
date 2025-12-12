package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;

/* compiled from: ReportFragment.kt */
/* loaded from: classes.dex */
public final class v extends Fragment {

    /* renamed from: m, reason: collision with root package name */
    public static final b f3517m = new b(null);

    /* renamed from: b, reason: collision with root package name */
    public a f3518b;

    /* compiled from: ReportFragment.kt */
    public interface a {
        void onCreate();

        void onResume();

        void onStart();
    }

    /* compiled from: ReportFragment.kt */
    public static final class b {
        public b(zf.f fVar) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void dispatch$lifecycle_runtime_release(Activity activity, Lifecycle.Event event) {
            zf.i.checkNotNullParameter(activity, "activity");
            zf.i.checkNotNullParameter(event, "event");
            if (activity instanceof n) {
                ((n) activity).getLifecycle().handleLifecycleEvent(event);
            } else if (activity instanceof l) {
                Lifecycle lifecycle = ((l) activity).getLifecycle();
                if (lifecycle instanceof m) {
                    ((m) lifecycle).handleLifecycleEvent(event);
                }
            }
        }

        public final v get(Activity activity) {
            zf.i.checkNotNullParameter(activity, "<this>");
            Fragment fragmentFindFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            zf.i.checkNotNull(fragmentFindFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            return (v) fragmentFindFragmentByTag;
        }

        public final void injectIfNeededIn(Activity activity) {
            zf.i.checkNotNullParameter(activity, "activity");
            if (Build.VERSION.SDK_INT >= 29) {
                c.Companion.registerIn(activity);
            }
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
                fragmentManager.beginTransaction().add(new v(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
                fragmentManager.executePendingTransactions();
            }
        }
    }

    /* compiled from: ReportFragment.kt */
    public static final class c implements Application.ActivityLifecycleCallbacks {
        public static final a Companion = new a(null);

        /* compiled from: ReportFragment.kt */
        public static final class a {
            public a(zf.f fVar) {
            }

            public final void registerIn(Activity activity) {
                zf.i.checkNotNullParameter(activity, "activity");
                activity.registerActivityLifecycleCallbacks(new c());
            }
        }

        public static final void registerIn(Activity activity) {
            Companion.registerIn(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            zf.i.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            zf.i.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            zf.i.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            zf.i.checkNotNullParameter(activity, "activity");
            v.f3517m.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            zf.i.checkNotNullParameter(activity, "activity");
            v.f3517m.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            zf.i.checkNotNullParameter(activity, "activity");
            v.f3517m.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            zf.i.checkNotNullParameter(activity, "activity");
            v.f3517m.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            zf.i.checkNotNullParameter(activity, "activity");
            v.f3517m.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            zf.i.checkNotNullParameter(activity, "activity");
            v.f3517m.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            zf.i.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            zf.i.checkNotNullParameter(activity, "activity");
            zf.i.checkNotNullParameter(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            zf.i.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            zf.i.checkNotNullParameter(activity, "activity");
        }
    }

    public static final void injectIfNeededIn(Activity activity) {
        f3517m.injectIfNeededIn(activity);
    }

    public final void a(Lifecycle.Event event) {
        if (Build.VERSION.SDK_INT < 29) {
            Activity activity = getActivity();
            zf.i.checkNotNullExpressionValue(activity, "activity");
            f3517m.dispatch$lifecycle_runtime_release(activity, event);
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a aVar = this.f3518b;
        if (aVar != null) {
            aVar.onCreate();
        }
        a(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a(Lifecycle.Event.ON_DESTROY);
        this.f3518b = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        a aVar = this.f3518b;
        if (aVar != null) {
            aVar.onResume();
        }
        a(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        a aVar = this.f3518b;
        if (aVar != null) {
            aVar.onStart();
        }
        a(Lifecycle.Event.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a(Lifecycle.Event.ON_STOP);
    }

    public final void setProcessListener(a aVar) {
        this.f3518b = aVar;
    }
}
