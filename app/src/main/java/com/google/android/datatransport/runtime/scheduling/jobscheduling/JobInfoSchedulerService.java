package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import q4.o;
import q4.s;
import r.x;

/* loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f5689b = 0;

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i10 = jobParameters.getExtras().getInt("priority");
        int i11 = jobParameters.getExtras().getInt("attemptNumber");
        s.initialize(getApplicationContext());
        o.a priority = o.builder().setBackendName(string).setPriority(b5.a.valueOf(i10));
        if (string2 != null) {
            priority.setExtras(Base64.decode(string2, 0));
        }
        s.getInstance().getUploader().upload(priority.build(), i11, new x(11, this, jobParameters));
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
