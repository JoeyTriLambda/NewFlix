package r8;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.SortedSet;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: CrashlyticsController.java */
/* loaded from: classes.dex */
public final class p implements Callable<Task<Void>> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f18733b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Throwable f18734m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Thread f18735n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ y8.g f18736o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ boolean f18737p = false;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ r f18738q;

    /* compiled from: CrashlyticsController.java */
    public class a implements SuccessContinuation<y8.d, Void> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Executor f18739a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f18740b;

        public a(Executor executor, String str) {
            this.f18739a = executor;
            this.f18740b = str;
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        public Task<Void> then(y8.d dVar) throws Exception {
            if (dVar == null) {
                o8.e.getLogger().w("Received null app settings, cannot send reports at crash time.");
                return Tasks.forResult(null);
            }
            Task[] taskArr = new Task[2];
            p pVar = p.this;
            taskArr[0] = r.b(pVar.f18738q);
            taskArr[1] = pVar.f18738q.f18756m.sendReports(this.f18739a, pVar.f18737p ? this.f18740b : null);
            return Tasks.whenAll((Task<?>[]) taskArr);
        }
    }

    public p(r rVar, long j10, Throwable th2, Thread thread, y8.g gVar) {
        this.f18738q = rVar;
        this.f18733b = j10;
        this.f18734m = th2;
        this.f18735n = thread;
        this.f18736o = gVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Task<Void> call() throws Exception {
        long j10 = this.f18733b;
        long j11 = j10 / 1000;
        r rVar = this.f18738q;
        SortedSet<String> sortedSetListSortedOpenSessionIds = rVar.f18756m.listSortedOpenSessionIds();
        String strFirst = !sortedSetListSortedOpenSessionIds.isEmpty() ? sortedSetListSortedOpenSessionIds.first() : null;
        if (strFirst == null) {
            o8.e.getLogger().e("Tried to write a fatal exception while no session was open.");
            return Tasks.forResult(null);
        }
        rVar.f18746c.create();
        rVar.f18756m.persistFatalEvent(this.f18734m, this.f18735n, strFirst, j11);
        rVar.d(j10);
        y8.g gVar = this.f18736o;
        rVar.c(false, gVar);
        r.a(rVar, new h(rVar.f18749f).toString(), Boolean.valueOf(this.f18737p));
        if (!rVar.f18745b.isAutomaticDataCollectionEnabled()) {
            return Tasks.forResult(null);
        }
        Executor executor = rVar.f18748e.getExecutor();
        return ((com.google.firebase.crashlytics.internal.settings.a) gVar).getSettingsAsync().onSuccessTask(executor, new a(executor, strFirst));
    }
}
