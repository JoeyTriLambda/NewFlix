package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import w2.g;
import x2.e0;

/* loaded from: classes.dex */
public class RescheduleReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4535a = g.tagWithPrefix("RescheduleReceiver");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str = f4535a;
        g.get().debug(str, "Received intent " + intent);
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                e0.getInstance(context).setReschedulePendingResult(goAsync());
                return;
            } catch (IllegalStateException e10) {
                g.get().error(str, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e10);
                return;
            }
        }
        String str2 = a.f4539p;
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction("ACTION_RESCHEDULE");
        context.startService(intent2);
    }
}
