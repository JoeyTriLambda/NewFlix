package r9;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: SessionsActivityLifecycleCallbacks.kt */
/* loaded from: classes.dex */
public final class s implements Application.ActivityLifecycleCallbacks {

    /* renamed from: b, reason: collision with root package name */
    public static final s f18892b = new s();

    /* renamed from: m, reason: collision with root package name */
    public static boolean f18893m;

    /* renamed from: n, reason: collision with root package name */
    public static com.google.firebase.sessions.a f18894n;

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
        com.google.firebase.sessions.a aVar = f18894n;
        if (aVar != null) {
            aVar.backgrounded();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        lf.h hVar;
        zf.i.checkNotNullParameter(activity, "activity");
        com.google.firebase.sessions.a aVar = f18894n;
        if (aVar != null) {
            aVar.foregrounded();
            hVar = lf.h.f16056a;
        } else {
            hVar = null;
        }
        if (hVar == null) {
            f18893m = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zf.i.checkNotNullParameter(activity, "activity");
        zf.i.checkNotNullParameter(bundle, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        zf.i.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        zf.i.checkNotNullParameter(activity, "activity");
    }

    public final void setLifecycleClient(com.google.firebase.sessions.a aVar) {
        f18894n = aVar;
        if (aVar == null || !f18893m) {
            return;
        }
        f18893m = false;
        aVar.foregrounded();
    }
}
