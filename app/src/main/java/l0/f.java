package l0;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: ActivityRecreator.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Class<?> f15640a;

    /* renamed from: b, reason: collision with root package name */
    public static final Field f15641b;

    /* renamed from: c, reason: collision with root package name */
    public static final Field f15642c;

    /* renamed from: d, reason: collision with root package name */
    public static final Method f15643d;

    /* renamed from: e, reason: collision with root package name */
    public static final Method f15644e;

    /* renamed from: f, reason: collision with root package name */
    public static final Method f15645f;

    /* renamed from: g, reason: collision with root package name */
    public static final Handler f15646g = new Handler(Looper.getMainLooper());

    /* compiled from: ActivityRecreator.java */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f15647b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Object f15648m;

        public a(Object obj, Object obj2) {
            this.f15647b = obj;
            this.f15648m = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = f.f15643d;
                Object obj = this.f15648m;
                Object obj2 = this.f15647b;
                if (method != null) {
                    method.invoke(obj2, obj, Boolean.FALSE, "AppCompat recreation");
                } else {
                    f.f15644e.invoke(obj2, obj, Boolean.FALSE);
                }
            } catch (RuntimeException e10) {
                if (e10.getClass() == RuntimeException.class && e10.getMessage() != null && e10.getMessage().startsWith("Unable to stop")) {
                    throw e10;
                }
            } catch (Throwable th2) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th2);
            }
        }
    }

    static {
        Class<?> cls;
        Field declaredField;
        Field declaredField2;
        Method declaredMethod;
        Method declaredMethod2;
        Method method = null;
        try {
            cls = Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            cls = null;
        }
        f15640a = cls;
        try {
            declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
        } catch (Throwable unused2) {
            declaredField = null;
        }
        f15641b = declaredField;
        try {
            declaredField2 = Activity.class.getDeclaredField("mToken");
            declaredField2.setAccessible(true);
        } catch (Throwable unused3) {
            declaredField2 = null;
        }
        f15642c = declaredField2;
        Class<?> cls2 = f15640a;
        if (cls2 == null) {
            declaredMethod = null;
        } else {
            try {
                declaredMethod = cls2.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
                declaredMethod.setAccessible(true);
            } catch (Throwable unused4) {
            }
        }
        f15643d = declaredMethod;
        Class<?> cls3 = f15640a;
        if (cls3 == null) {
            declaredMethod2 = null;
        } else {
            try {
                declaredMethod2 = cls3.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
                declaredMethod2.setAccessible(true);
            } catch (Throwable unused5) {
            }
        }
        f15644e = declaredMethod2;
        Class<?> cls4 = f15640a;
        int i10 = Build.VERSION.SDK_INT;
        if ((i10 == 26 || i10 == 27) && cls4 != null) {
            try {
                Class<?> cls5 = Boolean.TYPE;
                Method declaredMethod3 = cls4.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls5, Configuration.class, Configuration.class, cls5, cls5);
                declaredMethod3.setAccessible(true);
                method = declaredMethod3;
            } catch (Throwable unused6) {
            }
        }
        f15645f = method;
    }

    public static boolean queueOnStopIfNecessary(Object obj, int i10, Activity activity) {
        try {
            Object obj2 = f15642c.get(activity);
            if (obj2 == obj && activity.hashCode() == i10) {
                f15646g.postAtFrontOfQueue(new a(f15641b.get(activity), obj2));
                return true;
            }
            return false;
        } catch (Throwable th2) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th2);
            return false;
        }
    }

    /* compiled from: ActivityRecreator.java */
    public static final class b implements Application.ActivityLifecycleCallbacks {

        /* renamed from: b, reason: collision with root package name */
        public Object f15649b;

        /* renamed from: m, reason: collision with root package name */
        public Activity f15650m;

        /* renamed from: n, reason: collision with root package name */
        public final int f15651n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f15652o = false;

        /* renamed from: p, reason: collision with root package name */
        public boolean f15653p = false;

        /* renamed from: q, reason: collision with root package name */
        public boolean f15654q = false;

        public b(Activity activity) {
            this.f15650m = activity;
            this.f15651n = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f15650m == activity) {
                this.f15650m = null;
                this.f15653p = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f15653p || this.f15654q || this.f15652o || !f.queueOnStopIfNecessary(this.f15649b, this.f15651n, activity)) {
                return;
            }
            this.f15654q = true;
            this.f15649b = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f15650m == activity) {
                this.f15652o = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
