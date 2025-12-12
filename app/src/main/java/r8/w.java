package r8;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: CrashlyticsCore.java */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final Context f18775a;

    /* renamed from: b, reason: collision with root package name */
    public final d0 f18776b;

    /* renamed from: e, reason: collision with root package name */
    public y f18779e;

    /* renamed from: f, reason: collision with root package name */
    public y f18780f;

    /* renamed from: g, reason: collision with root package name */
    public r f18781g;

    /* renamed from: h, reason: collision with root package name */
    public final h0 f18782h;

    /* renamed from: i, reason: collision with root package name */
    public final w8.b f18783i;

    /* renamed from: j, reason: collision with root package name */
    public final q8.b f18784j;

    /* renamed from: k, reason: collision with root package name */
    public final p8.a f18785k;

    /* renamed from: l, reason: collision with root package name */
    public final ExecutorService f18786l;

    /* renamed from: m, reason: collision with root package name */
    public final l f18787m;

    /* renamed from: n, reason: collision with root package name */
    public final k f18788n;

    /* renamed from: o, reason: collision with root package name */
    public final o8.a f18789o;

    /* renamed from: p, reason: collision with root package name */
    public final o8.h f18790p;

    /* renamed from: d, reason: collision with root package name */
    public final long f18778d = System.currentTimeMillis();

    /* renamed from: c, reason: collision with root package name */
    public final l0 f18777c = new l0();

    /* compiled from: CrashlyticsCore.java */
    public class a implements Callable<Task<Void>> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y8.g f18791b;

        public a(y8.g gVar) {
            this.f18791b = gVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Task<Void> call() throws Exception {
            return w.a(w.this, this.f18791b);
        }
    }

    /* compiled from: CrashlyticsCore.java */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y8.g f18793b;

        public b(y8.g gVar) {
            this.f18793b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.a(w.this, this.f18793b);
        }
    }

    /* compiled from: CrashlyticsCore.java */
    public class c implements Callable<Boolean> {
        public c() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            try {
                boolean zRemove = w.this.f18779e.remove();
                if (!zRemove) {
                    o8.e.getLogger().w("Initialization marker file was not properly removed.");
                }
                return Boolean.valueOf(zRemove);
            } catch (Exception e10) {
                o8.e.getLogger().e("Problem encountered deleting Crashlytics initialization marker.", e10);
                return Boolean.FALSE;
            }
        }
    }

    public w(g8.f fVar, h0 h0Var, o8.a aVar, d0 d0Var, q8.b bVar, p8.a aVar2, w8.b bVar2, ExecutorService executorService, k kVar, o8.h hVar) {
        this.f18776b = d0Var;
        this.f18775a = fVar.getApplicationContext();
        this.f18782h = h0Var;
        this.f18789o = aVar;
        this.f18784j = bVar;
        this.f18785k = aVar2;
        this.f18786l = executorService;
        this.f18783i = bVar2;
        this.f18787m = new l(executorService);
        this.f18788n = kVar;
        this.f18790p = hVar;
    }

    public static Task a(final w wVar, y8.g gVar) {
        Task<Void> taskForException;
        wVar.f18787m.checkRunningOnThread();
        wVar.f18779e.create();
        o8.e.getLogger().v("Initialization marker file was created.");
        try {
            try {
                wVar.f18784j.registerBreadcrumbHandler(new q8.a() { // from class: r8.v
                    @Override // q8.a
                    public final void handleBreadcrumb(String str) {
                        this.f18774a.log(str);
                    }
                });
                wVar.f18781g.g();
                com.google.firebase.crashlytics.internal.settings.a aVar = (com.google.firebase.crashlytics.internal.settings.a) gVar;
                if (aVar.getSettingsSync().f22023b.f22028a) {
                    if (!wVar.f18781g.e(aVar)) {
                        o8.e.getLogger().w("Previous sessions could not be finalized.");
                    }
                    taskForException = wVar.f18781g.h(aVar.getSettingsAsync());
                } else {
                    o8.e.getLogger().d("Collection of crash reports disabled in Crashlytics settings.");
                    taskForException = Tasks.forException(new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
                }
            } catch (Exception e10) {
                o8.e.getLogger().e("Crashlytics encountered a problem during asynchronous initialization.", e10);
                taskForException = Tasks.forException(e10);
            }
            return taskForException;
        } finally {
            wVar.c();
        }
    }

    public static String getVersion() {
        return "18.6.3";
    }

    public final void b(y8.g gVar) throws ExecutionException, InterruptedException, TimeoutException {
        Future<?> futureSubmit = this.f18786l.submit(new b(gVar));
        o8.e.getLogger().d("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            futureSubmit.get(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e10) {
            o8.e.getLogger().e("Crashlytics was interrupted during initialization.", e10);
        } catch (ExecutionException e11) {
            o8.e.getLogger().e("Crashlytics encountered a problem during initialization.", e11);
        } catch (TimeoutException e12) {
            o8.e.getLogger().e("Crashlytics timed out during initialization.", e12);
        }
    }

    public final void c() {
        this.f18787m.submit(new c());
    }

    public Task<Void> doBackgroundInitializationAsync(y8.g gVar) {
        return p0.callTask(this.f18786l, new a(gVar));
    }

    public void log(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f18778d;
        r rVar = this.f18781g;
        rVar.getClass();
        rVar.f18748e.submit(new s(rVar, jCurrentTimeMillis, str));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x017a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onPreExecute(r8.a r31, y8.g r32) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: r8.w.onPreExecute(r8.a, y8.g):boolean");
    }
}
