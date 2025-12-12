package x4;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.zip.Adler32;
import q4.o;

/* compiled from: JobInfoScheduler.java */
/* loaded from: classes.dex */
public final class b implements l {

    /* renamed from: a, reason: collision with root package name */
    public final Context f21510a;

    /* renamed from: b, reason: collision with root package name */
    public final y4.d f21511b;

    /* renamed from: c, reason: collision with root package name */
    public final SchedulerConfig f21512c;

    public b(Context context, y4.d dVar, SchedulerConfig schedulerConfig) {
        this.f21510a = context;
        this.f21511b = dVar;
        this.f21512c = schedulerConfig;
    }

    @Override // x4.l
    public void schedule(o oVar, int i10) {
        schedule(oVar, i10, false);
    }

    @Override // x4.l
    public void schedule(o oVar, int i10, boolean z10) {
        boolean z11;
        Context context = this.f21510a;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(oVar.getBackendName().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(b5.a.toInt(oVar.getPriority())).array());
        if (oVar.getExtras() != null) {
            adler32.update(oVar.getExtras());
        }
        int value = (int) adler32.getValue();
        if (!z10) {
            Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JobInfo next = it.next();
                int i11 = next.getExtras().getInt("attemptNumber");
                if (next.getId() == value) {
                    z11 = i11 >= i10;
                }
            }
            if (z11) {
                u4.a.d("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", oVar);
                return;
            }
        }
        long nextCallTime = this.f21511b.getNextCallTime(oVar);
        JobInfo.Builder builderConfigureJob = this.f21512c.configureJob(new JobInfo.Builder(value, componentName), oVar.getPriority(), nextCallTime, i10);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i10);
        persistableBundle.putString("backendName", oVar.getBackendName());
        persistableBundle.putInt("priority", b5.a.toInt(oVar.getPriority()));
        if (oVar.getExtras() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(oVar.getExtras(), 0));
        }
        builderConfigureJob.setExtras(persistableBundle);
        u4.a.d("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", oVar, Integer.valueOf(value), Long.valueOf(this.f21512c.getScheduleDelay(oVar.getPriority(), nextCallTime, i10)), Long.valueOf(nextCallTime), Integer.valueOf(i10));
        jobScheduler.schedule(builderConfigureJob.build());
    }
}
