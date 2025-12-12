package a3;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo$State;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import f3.i;
import f3.l;
import f3.m;
import f3.u;
import f3.w;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import w2.g;
import x2.e0;
import x2.t;

/* compiled from: SystemJobScheduler.java */
/* loaded from: classes.dex */
public final class d implements t {

    /* renamed from: p, reason: collision with root package name */
    public static final String f304p = g.tagWithPrefix("SystemJobScheduler");

    /* renamed from: b, reason: collision with root package name */
    public final Context f305b;

    /* renamed from: m, reason: collision with root package name */
    public final JobScheduler f306m;

    /* renamed from: n, reason: collision with root package name */
    public final e0 f307n;

    /* renamed from: o, reason: collision with root package name */
    public final c f308o;

    public d(Context context, e0 e0Var) {
        this(context, e0Var, (JobScheduler) context.getSystemService("jobscheduler"), new c(context));
    }

    public static void a(JobScheduler jobScheduler, int i10) {
        try {
            jobScheduler.cancel(i10);
        } catch (Throwable th2) {
            g.get().error(f304p, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i10)), th2);
        }
    }

    public static ArrayList b(Context context, JobScheduler jobScheduler, String str) {
        ArrayList arrayListC = c(context, jobScheduler);
        if (arrayListC == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        Iterator it = arrayListC.iterator();
        while (it.hasNext()) {
            JobInfo jobInfo = (JobInfo) it.next();
            m mVarD = d(jobInfo);
            if (mVarD != null && str.equals(mVarD.getWorkSpecId())) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    public static ArrayList c(Context context, JobScheduler jobScheduler) {
        List<JobInfo> allPendingJobs;
        try {
            allPendingJobs = jobScheduler.getAllPendingJobs();
        } catch (Throwable th2) {
            g.get().error(f304p, "getAllPendingJobs() is not reliable on this device.", th2);
            allPendingJobs = null;
        }
        if (allPendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(allPendingJobs.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : allPendingJobs) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    public static void cancelAll(Context context) {
        ArrayList arrayListC;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler == null || (arrayListC = c(context, jobScheduler)) == null || arrayListC.isEmpty()) {
            return;
        }
        Iterator it = arrayListC.iterator();
        while (it.hasNext()) {
            a(jobScheduler, ((JobInfo) it.next()).getId());
        }
    }

    public static m d(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (!extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new m(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION", 0));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static boolean reconcileJobs(Context context, e0 e0Var) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        ArrayList arrayListC = c(context, jobScheduler);
        List<String> workSpecIds = e0Var.getWorkDatabase().systemIdInfoDao().getWorkSpecIds();
        boolean z10 = false;
        HashSet hashSet = new HashSet(arrayListC != null ? arrayListC.size() : 0);
        if (arrayListC != null && !arrayListC.isEmpty()) {
            Iterator it = arrayListC.iterator();
            while (it.hasNext()) {
                JobInfo jobInfo = (JobInfo) it.next();
                m mVarD = d(jobInfo);
                if (mVarD != null) {
                    hashSet.add(mVarD.getWorkSpecId());
                } else {
                    a(jobScheduler, jobInfo.getId());
                }
            }
        }
        Iterator<String> it2 = workSpecIds.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            if (!hashSet.contains(it2.next())) {
                g.get().debug(f304p, "Reconciling jobs");
                z10 = true;
                break;
            }
        }
        if (z10) {
            WorkDatabase workDatabase = e0Var.getWorkDatabase();
            workDatabase.beginTransaction();
            try {
                u uVarWorkSpecDao = workDatabase.workSpecDao();
                Iterator<String> it3 = workSpecIds.iterator();
                while (it3.hasNext()) {
                    uVarWorkSpecDao.markWorkSpecScheduled(it3.next(), -1L);
                }
                workDatabase.setTransactionSuccessful();
            } finally {
                workDatabase.endTransaction();
            }
        }
        return z10;
    }

    @Override // x2.t
    public void cancel(String str) {
        Context context = this.f305b;
        JobScheduler jobScheduler = this.f306m;
        ArrayList arrayListB = b(context, jobScheduler, str);
        if (arrayListB == null || arrayListB.isEmpty()) {
            return;
        }
        Iterator it = arrayListB.iterator();
        while (it.hasNext()) {
            a(jobScheduler, ((Integer) it.next()).intValue());
        }
        this.f307n.getWorkDatabase().systemIdInfoDao().removeSystemIdInfo(str);
    }

    @Override // x2.t
    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    @Override // x2.t
    public void schedule(f3.t... tVarArr) {
        ArrayList arrayListB;
        e0 e0Var = this.f307n;
        WorkDatabase workDatabase = e0Var.getWorkDatabase();
        g3.g gVar = new g3.g(workDatabase);
        for (f3.t tVar : tVarArr) {
            workDatabase.beginTransaction();
            try {
                f3.t workSpec = workDatabase.workSpecDao().getWorkSpec(tVar.f11426a);
                String str = f304p;
                String str2 = tVar.f11426a;
                if (workSpec == null) {
                    g.get().warning(str, "Skipping scheduling " + str2 + " because it's no longer in the DB");
                    workDatabase.setTransactionSuccessful();
                } else if (workSpec.f11427b != WorkInfo$State.ENQUEUED) {
                    g.get().warning(str, "Skipping scheduling " + str2 + " because it is no longer enqueued");
                    workDatabase.setTransactionSuccessful();
                } else {
                    m mVarGenerationalId = w.generationalId(tVar);
                    i systemIdInfo = workDatabase.systemIdInfoDao().getSystemIdInfo(mVarGenerationalId);
                    int iNextJobSchedulerIdWithRange = systemIdInfo != null ? systemIdInfo.f11411c : gVar.nextJobSchedulerIdWithRange(e0Var.getConfiguration().getMinJobSchedulerId(), e0Var.getConfiguration().getMaxJobSchedulerId());
                    if (systemIdInfo == null) {
                        e0Var.getWorkDatabase().systemIdInfoDao().insertSystemIdInfo(l.systemIdInfo(mVarGenerationalId, iNextJobSchedulerIdWithRange));
                    }
                    scheduleInternal(tVar, iNextJobSchedulerIdWithRange);
                    if (Build.VERSION.SDK_INT == 23 && (arrayListB = b(this.f305b, this.f306m, str2)) != null) {
                        int iIndexOf = arrayListB.indexOf(Integer.valueOf(iNextJobSchedulerIdWithRange));
                        if (iIndexOf >= 0) {
                            arrayListB.remove(iIndexOf);
                        }
                        scheduleInternal(tVar, !arrayListB.isEmpty() ? ((Integer) arrayListB.get(0)).intValue() : gVar.nextJobSchedulerIdWithRange(e0Var.getConfiguration().getMinJobSchedulerId(), e0Var.getConfiguration().getMaxJobSchedulerId()));
                    }
                    workDatabase.setTransactionSuccessful();
                }
                workDatabase.endTransaction();
            } catch (Throwable th2) {
                workDatabase.endTransaction();
                throw th2;
            }
        }
    }

    public void scheduleInternal(f3.t tVar, int i10) {
        JobScheduler jobScheduler = this.f306m;
        JobInfo jobInfoA = this.f308o.a(tVar, i10);
        g gVar = g.get();
        StringBuilder sb2 = new StringBuilder("Scheduling work ID ");
        String str = tVar.f11426a;
        sb2.append(str);
        sb2.append("Job ID ");
        sb2.append(i10);
        String string = sb2.toString();
        String str2 = f304p;
        gVar.debug(str2, string);
        try {
            if (jobScheduler.schedule(jobInfoA) == 0) {
                g.get().warning(str2, "Unable to schedule work ID " + str);
                if (tVar.f11442q && tVar.f11443r == OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    tVar.f11442q = false;
                    g.get().debug(str2, String.format("Scheduling a non-expedited job (work ID %s)", str));
                    scheduleInternal(tVar, i10);
                }
            }
        } catch (IllegalStateException e10) {
            ArrayList arrayListC = c(this.f305b, jobScheduler);
            int size = arrayListC != null ? arrayListC.size() : 0;
            Locale locale = Locale.getDefault();
            e0 e0Var = this.f307n;
            String str3 = String.format(locale, "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", Integer.valueOf(size), Integer.valueOf(e0Var.getWorkDatabase().workSpecDao().getScheduledWork().size()), Integer.valueOf(e0Var.getConfiguration().getMaxSchedulerLimit()));
            g.get().error(str2, str3);
            IllegalStateException illegalStateException = new IllegalStateException(str3, e10);
            w0.a<Throwable> schedulingExceptionHandler = e0Var.getConfiguration().getSchedulingExceptionHandler();
            if (schedulingExceptionHandler == null) {
                throw illegalStateException;
            }
            schedulingExceptionHandler.accept(illegalStateException);
        } catch (Throwable th2) {
            g.get().error(str2, "Unable to schedule " + tVar, th2);
        }
    }

    public d(Context context, e0 e0Var, JobScheduler jobScheduler, c cVar) {
        this.f305b = context;
        this.f307n = e0Var;
        this.f306m = jobScheduler;
        this.f308o = cVar;
    }
}
