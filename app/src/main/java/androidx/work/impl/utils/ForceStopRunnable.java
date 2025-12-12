package androidx.work.impl.utils;

import a3.d;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.WorkInfo$State;
import androidx.work.a;
import androidx.work.impl.WorkDatabase;
import f3.r;
import f3.t;
import f3.u;
import g3.n;
import g3.o;
import java.util.List;
import java.util.concurrent.TimeUnit;
import w2.g;
import x2.a0;
import x2.e0;

/* loaded from: classes.dex */
public final class ForceStopRunnable implements Runnable {

    /* renamed from: p, reason: collision with root package name */
    public static final String f4605p = g.tagWithPrefix("ForceStopRunnable");

    /* renamed from: q, reason: collision with root package name */
    public static final long f4606q = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: b, reason: collision with root package name */
    public final Context f4607b;

    /* renamed from: m, reason: collision with root package name */
    public final e0 f4608m;

    /* renamed from: n, reason: collision with root package name */
    public final n f4609n;

    /* renamed from: o, reason: collision with root package name */
    public int f4610o = 0;

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public static final String f4611a = g.tagWithPrefix("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                return;
            }
            g.get().verbose(f4611a, "Rescheduling alarm that keeps track of force-stops.");
            ForceStopRunnable.a(context);
        }
    }

    public ForceStopRunnable(Context context, e0 e0Var) {
        this.f4607b = context.getApplicationContext();
        this.f4608m = e0Var;
        this.f4609n = e0Var.getPreferenceUtils();
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void a(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        int i10 = Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, -1, intent, i10);
        long jCurrentTimeMillis = System.currentTimeMillis() + f4606q;
        if (alarmManager != null) {
            alarmManager.setExact(0, jCurrentTimeMillis, broadcast);
        }
    }

    public boolean cleanUp() {
        int i10 = Build.VERSION.SDK_INT;
        e0 e0Var = this.f4608m;
        boolean zReconcileJobs = i10 >= 23 ? d.reconcileJobs(this.f4607b, e0Var) : false;
        WorkDatabase workDatabase = e0Var.getWorkDatabase();
        u uVarWorkSpecDao = workDatabase.workSpecDao();
        r rVarWorkProgressDao = workDatabase.workProgressDao();
        workDatabase.beginTransaction();
        try {
            List<t> runningWork = uVarWorkSpecDao.getRunningWork();
            boolean z10 = (runningWork == null || runningWork.isEmpty()) ? false : true;
            if (z10) {
                for (t tVar : runningWork) {
                    uVarWorkSpecDao.setState(WorkInfo$State.ENQUEUED, tVar.f11426a);
                    uVarWorkSpecDao.markWorkSpecScheduled(tVar.f11426a, -1L);
                }
            }
            rVarWorkProgressDao.deleteAll();
            workDatabase.setTransactionSuccessful();
            return z10 || zReconcileJobs;
        } finally {
            workDatabase.endTransaction();
        }
    }

    public void forceStopRunnable() {
        boolean zCleanUp = cleanUp();
        boolean zShouldRescheduleWorkers = shouldRescheduleWorkers();
        String str = f4605p;
        e0 e0Var = this.f4608m;
        if (zShouldRescheduleWorkers) {
            g.get().debug(str, "Rescheduling Workers.");
            e0Var.rescheduleEligibleWork();
            e0Var.getPreferenceUtils().setNeedsReschedule(false);
        } else if (isForceStopped()) {
            g.get().debug(str, "Application was force-stopped, rescheduling.");
            e0Var.rescheduleEligibleWork();
            this.f4609n.setLastForceStopEventMillis(System.currentTimeMillis());
        } else if (zCleanUp) {
            g.get().debug(str, "Found unfinished work, scheduling it.");
            x2.u.schedule(e0Var.getConfiguration(), e0Var.getWorkDatabase(), e0Var.getSchedulers());
        }
    }

    @SuppressLint({"ClassVerificationFailure"})
    public boolean isForceStopped() {
        Context context = this.f4607b;
        try {
            int i10 = Build.VERSION.SDK_INT;
            int i11 = i10 >= 31 ? 570425344 : 536870912;
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
            intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
            PendingIntent broadcast = PendingIntent.getBroadcast(context, -1, intent, i11);
            if (i10 >= 30) {
                if (broadcast != null) {
                    broadcast.cancel();
                }
                List historicalProcessExitReasons = ((ActivityManager) context.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
                if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                    long lastForceStopEventMillis = this.f4609n.getLastForceStopEventMillis();
                    for (int i12 = 0; i12 < historicalProcessExitReasons.size(); i12++) {
                        ApplicationExitInfo applicationExitInfo = (ApplicationExitInfo) historicalProcessExitReasons.get(i12);
                        if (applicationExitInfo.getReason() == 10 && applicationExitInfo.getTimestamp() >= lastForceStopEventMillis) {
                            return true;
                        }
                    }
                }
            } else if (broadcast == null) {
                a(context);
                return true;
            }
            return false;
        } catch (IllegalArgumentException | SecurityException e10) {
            g.get().warning(f4605p, "Ignoring exception", e10);
            return true;
        }
    }

    public boolean multiProcessChecks() {
        a configuration = this.f4608m.getConfiguration();
        boolean zIsEmpty = TextUtils.isEmpty(configuration.getDefaultProcessName());
        String str = f4605p;
        if (zIsEmpty) {
            g.get().debug(str, "The default process name was not specified.");
            return true;
        }
        boolean zIsDefaultProcess = o.isDefaultProcess(this.f4607b, configuration);
        g.get().debug(str, "Is default app process = " + zIsDefaultProcess);
        return zIsDefaultProcess;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i10;
        String str = f4605p;
        e0 e0Var = this.f4608m;
        try {
            if (multiProcessChecks()) {
                while (true) {
                    try {
                        a0.migrateDatabase(this.f4607b);
                        g.get().debug(str, "Performing cleanup operations.");
                        try {
                            forceStopRunnable();
                            break;
                        } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteDiskIOException | SQLiteTableLockedException e10) {
                            i10 = this.f4610o + 1;
                            this.f4610o = i10;
                            if (i10 >= 3) {
                                g.get().error(str, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e10);
                                IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e10);
                                w0.a<Throwable> initializationExceptionHandler = e0Var.getConfiguration().getInitializationExceptionHandler();
                                if (initializationExceptionHandler == null) {
                                    throw illegalStateException;
                                }
                                g.get().debug(str, "Routing exception to the specified exception handler", illegalStateException);
                                initializationExceptionHandler.accept(illegalStateException);
                            } else {
                                g.get().debug(str, "Retrying after " + (i10 * 300), e10);
                                sleep(((long) this.f4610o) * 300);
                            }
                        }
                        g.get().debug(str, "Retrying after " + (i10 * 300), e10);
                        sleep(((long) this.f4610o) * 300);
                    } catch (SQLiteException e11) {
                        g.get().error(str, "Unexpected SQLite exception during migrations");
                        IllegalStateException illegalStateException2 = new IllegalStateException("Unexpected SQLite exception during migrations", e11);
                        w0.a<Throwable> initializationExceptionHandler2 = e0Var.getConfiguration().getInitializationExceptionHandler();
                        if (initializationExceptionHandler2 == null) {
                            throw illegalStateException2;
                        }
                        initializationExceptionHandler2.accept(illegalStateException2);
                    }
                }
            }
        } finally {
            e0Var.onForceStopRunnableCompleted();
        }
    }

    public boolean shouldRescheduleWorkers() {
        return this.f4608m.getPreferenceUtils().getNeedsReschedule();
    }

    public void sleep(long j10) throws InterruptedException {
        try {
            Thread.sleep(j10);
        } catch (InterruptedException unused) {
        }
    }
}
