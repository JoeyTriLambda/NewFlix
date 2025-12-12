package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: LifecycleDispatcher.kt */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f3490a = new AtomicBoolean(false);

    /* compiled from: LifecycleDispatcher.kt */
    public static final class a extends d {
        @Override // androidx.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            zf.i.checkNotNullParameter(activity, "activity");
            v.f3517m.injectIfNeededIn(activity);
        }
    }

    public static final void init(Context context) {
        zf.i.checkNotNullParameter(context, "context");
        if (f3490a.getAndSet(true)) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        zf.i.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new a());
    }
}
