package l0;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;

/* compiled from: NotificationManagerCompat.java */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final Context f15702a;

    /* renamed from: b, reason: collision with root package name */
    public final NotificationManager f15703b;

    /* compiled from: NotificationManagerCompat.java */
    public static class a {
        public static boolean a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }

        public static int b(NotificationManager notificationManager) {
            return notificationManager.getImportance();
        }
    }

    static {
        new HashSet();
    }

    public t(Context context) {
        this.f15702a = context;
        this.f15703b = (NotificationManager) context.getSystemService("notification");
    }

    public static t from(Context context) {
        return new t(context);
    }

    public boolean areNotificationsEnabled() throws ClassNotFoundException {
        if (Build.VERSION.SDK_INT >= 24) {
            return a.a(this.f15703b);
        }
        Context context = this.f15702a;
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = context.getApplicationContext().getPackageName();
        int i10 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i10), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }
}
