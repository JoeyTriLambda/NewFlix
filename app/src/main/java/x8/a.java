package x8;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import o8.e;
import q4.s;
import r8.a0;
import r8.l0;
import t8.f0;
import x8.c.a;
import y8.g;

/* compiled from: DataTransportCrashlyticsReportSender.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final u8.b f21640b = new u8.b();

    /* renamed from: c, reason: collision with root package name */
    public static final String f21641c = a("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");

    /* renamed from: d, reason: collision with root package name */
    public static final String f21642d = a("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");

    /* renamed from: e, reason: collision with root package name */
    public static final u8.a f21643e = new u8.a(7);

    /* renamed from: a, reason: collision with root package name */
    public final c f21644a;

    public a(c cVar) {
        this.f21644a = cVar;
    }

    public static String a(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb2 = new StringBuilder(str2.length() + str.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            sb2.append(str.charAt(i10));
            if (str2.length() > i10) {
                sb2.append(str2.charAt(i10));
            }
        }
        return sb2.toString();
    }

    public static a create(Context context, g gVar, l0 l0Var) {
        s.initialize(context);
        return new a(new c(s.getInstance().newFactory(new o4.a(f21641c, f21642d)).getTransport("FIREBASE_CRASHLYTICS_REPORT", f0.class, n4.b.of("json"), f21643e), ((com.google.firebase.crashlytics.internal.settings.a) gVar).getSettingsSync(), l0Var));
    }

    public Task<a0> enqueueReport(a0 a0Var, boolean z10) {
        TaskCompletionSource<a0> taskCompletionSource;
        c cVar = this.f21644a;
        synchronized (cVar.f21654f) {
            taskCompletionSource = new TaskCompletionSource<>();
            if (z10) {
                cVar.f21657i.incrementRecordedOnDemandExceptions();
                if (cVar.f21654f.size() < cVar.f21653e) {
                    e.getLogger().d("Enqueueing report: " + a0Var.getSessionId());
                    e.getLogger().d("Queue size: " + cVar.f21654f.size());
                    cVar.f21655g.execute(cVar.new a(a0Var, taskCompletionSource));
                    e.getLogger().d("Closing task for report: " + a0Var.getSessionId());
                    taskCompletionSource.trySetResult(a0Var);
                } else {
                    cVar.a();
                    e.getLogger().d("Dropping report due to queue being full: " + a0Var.getSessionId());
                    cVar.f21657i.incrementDroppedOnDemandExceptions();
                    taskCompletionSource.trySetResult(a0Var);
                }
            } else {
                cVar.b(a0Var, taskCompletionSource);
            }
        }
        return taskCompletionSource.getTask();
    }
}
