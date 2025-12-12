package z2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import f3.i;
import f3.j;
import f3.l;
import f3.m;
import w2.g;

/* compiled from: Alarms.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f22558a = g.tagWithPrefix("Alarms");

    /* compiled from: Alarms.java */
    /* renamed from: z2.a$a, reason: collision with other inner class name */
    public static class C0330a {
        public static void a(AlarmManager alarmManager, int i10, long j10, PendingIntent pendingIntent) {
            alarmManager.setExact(i10, j10, pendingIntent);
        }
    }

    public static void a(Context context, m mVar, int i10) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        String str = androidx.work.impl.background.systemalarm.a.f4539p;
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        androidx.work.impl.background.systemalarm.a.d(intent, mVar);
        PendingIntent service = PendingIntent.getService(context, i10, intent, Build.VERSION.SDK_INT >= 23 ? 603979776 : 536870912);
        if (service == null || alarmManager == null) {
            return;
        }
        g.get().debug(f22558a, "Cancelling existing alarm with (workSpecId, systemId) (" + mVar + ", " + i10 + ")");
        alarmManager.cancel(service);
    }

    public static void b(Context context, m mVar, int i10, long j10) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        int i11 = Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728;
        String str = androidx.work.impl.background.systemalarm.a.f4539p;
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        androidx.work.impl.background.systemalarm.a.d(intent, mVar);
        PendingIntent service = PendingIntent.getService(context, i10, intent, i11);
        if (alarmManager != null) {
            C0330a.a(alarmManager, 0, j10, service);
        }
    }

    public static void cancelAlarm(Context context, WorkDatabase workDatabase, m mVar) {
        j jVarSystemIdInfoDao = workDatabase.systemIdInfoDao();
        i systemIdInfo = jVarSystemIdInfoDao.getSystemIdInfo(mVar);
        if (systemIdInfo != null) {
            a(context, mVar, systemIdInfo.f11411c);
            g.get().debug(f22558a, "Removing SystemIdInfo for workSpecId (" + mVar + ")");
            jVarSystemIdInfoDao.removeSystemIdInfo(mVar);
        }
    }

    public static void setAlarm(Context context, WorkDatabase workDatabase, m mVar, long j10) {
        j jVarSystemIdInfoDao = workDatabase.systemIdInfoDao();
        i systemIdInfo = jVarSystemIdInfoDao.getSystemIdInfo(mVar);
        if (systemIdInfo != null) {
            int i10 = systemIdInfo.f11411c;
            a(context, mVar, i10);
            b(context, mVar, i10, j10);
        } else {
            int iNextAlarmManagerId = new g3.g(workDatabase).nextAlarmManagerId();
            jVarSystemIdInfoDao.insertSystemIdInfo(l.systemIdInfo(mVar, iNextAlarmManagerId));
            b(context, mVar, iNextAlarmManagerId, j10);
        }
    }
}
