package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.net.Network;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.WorkerParameters;
import f3.m;
import java.util.Arrays;
import java.util.HashMap;
import w2.g;
import x2.e;
import x2.e0;
import x2.v;
import x2.w;

/* loaded from: classes.dex */
public class SystemJobService extends JobService implements e {

    /* renamed from: o, reason: collision with root package name */
    public static final String f4576o = g.tagWithPrefix("SystemJobService");

    /* renamed from: b, reason: collision with root package name */
    public e0 f4577b;

    /* renamed from: m, reason: collision with root package name */
    public final HashMap f4578m = new HashMap();

    /* renamed from: n, reason: collision with root package name */
    public final w f4579n = new w();

    public static class a {
        public static String[] a(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentAuthorities();
        }

        public static Uri[] b(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentUris();
        }
    }

    public static class b {
        public static Network a(JobParameters jobParameters) {
            return jobParameters.getNetwork();
        }
    }

    public static m a(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new m(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION"));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            e0 e0Var = e0.getInstance(getApplicationContext());
            this.f4577b = e0Var;
            e0Var.getProcessor().addExecutionListener(this);
        } catch (IllegalStateException unused) {
            if (!Application.class.equals(getApplication().getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
            }
            g.get().warning(f4576o, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        e0 e0Var = this.f4577b;
        if (e0Var != null) {
            e0Var.getProcessor().removeExecutionListener(this);
        }
    }

    @Override // x2.e
    public void onExecuted(m mVar, boolean z10) {
        JobParameters jobParameters;
        g.get().debug(f4576o, mVar.getWorkSpecId() + " executed on JobScheduler");
        synchronized (this.f4578m) {
            jobParameters = (JobParameters) this.f4578m.remove(mVar);
        }
        this.f4579n.remove(mVar);
        if (jobParameters != null) {
            jobFinished(jobParameters, z10);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        WorkerParameters.a aVar;
        if (this.f4577b == null) {
            g.get().debug(f4576o, "WorkManager is not initialized; requesting retry.");
            jobFinished(jobParameters, true);
            return false;
        }
        m mVarA = a(jobParameters);
        if (mVarA == null) {
            g.get().error(f4576o, "WorkSpec id not found!");
            return false;
        }
        synchronized (this.f4578m) {
            if (this.f4578m.containsKey(mVarA)) {
                g.get().debug(f4576o, "Job is already being executed by SystemJobService: " + mVarA);
                return false;
            }
            g.get().debug(f4576o, "onStartJob for " + mVarA);
            this.f4578m.put(mVarA, jobParameters);
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 24) {
                aVar = new WorkerParameters.a();
                if (a.b(jobParameters) != null) {
                    aVar.f4493b = Arrays.asList(a.b(jobParameters));
                }
                if (a.a(jobParameters) != null) {
                    aVar.f4492a = Arrays.asList(a.a(jobParameters));
                }
                if (i10 >= 28) {
                    b.a(jobParameters);
                }
            } else {
                aVar = null;
            }
            this.f4577b.startWork(this.f4579n.tokenFor(mVarA), aVar);
            return true;
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        if (this.f4577b == null) {
            g.get().debug(f4576o, "WorkManager is not initialized; requesting retry.");
            return true;
        }
        m mVarA = a(jobParameters);
        if (mVarA == null) {
            g.get().error(f4576o, "WorkSpec id not found!");
            return false;
        }
        g.get().debug(f4576o, "onStopJob for " + mVarA);
        synchronized (this.f4578m) {
            this.f4578m.remove(mVarA);
        }
        v vVarRemove = this.f4579n.remove(mVarA);
        if (vVarRemove != null) {
            this.f4577b.stopWork(vVarRemove);
        }
        return !this.f4577b.getProcessor().isCancelled(mVarA.getWorkSpecId());
    }
}
