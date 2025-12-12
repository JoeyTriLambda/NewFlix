package t0;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

/* compiled from: UserManagerCompat.java */
/* loaded from: classes.dex */
public final class n {

    /* compiled from: UserManagerCompat.java */
    public static class a {
        public static boolean a(Context context) {
            return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
        }
    }

    public static boolean isUserUnlocked(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return a.a(context);
        }
        return true;
    }
}
