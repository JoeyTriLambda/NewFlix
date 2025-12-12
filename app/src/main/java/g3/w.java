package g3;

import android.content.Context;
import androidx.work.impl.WorkDatabase;
import java.util.UUID;

/* compiled from: WorkForegroundUpdater.java */
/* loaded from: classes.dex */
public final class w implements w2.d {

    /* renamed from: a, reason: collision with root package name */
    public final i3.c f12678a;

    /* renamed from: b, reason: collision with root package name */
    public final e3.a f12679b;

    /* renamed from: c, reason: collision with root package name */
    public final f3.u f12680c;

    /* compiled from: WorkForegroundUpdater.java */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h3.a f12681b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ UUID f12682m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ w2.c f12683n;

        /* renamed from: o, reason: collision with root package name */
        public final /* synthetic */ Context f12684o;

        public a(h3.a aVar, UUID uuid, w2.c cVar, Context context) {
            this.f12681b = aVar;
            this.f12682m = uuid;
            this.f12683n = cVar;
            this.f12684o = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.f12684o;
            w2.c cVar = this.f12683n;
            w wVar = w.this;
            h3.a aVar = this.f12681b;
            try {
                if (!aVar.isCancelled()) {
                    String string = this.f12682m.toString();
                    f3.t workSpec = wVar.f12680c.getWorkSpec(string);
                    if (workSpec == null || workSpec.f11427b.isFinished()) {
                        throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                    }
                    ((x2.r) wVar.f12679b).startForeground(string, cVar);
                    context.startService(androidx.work.impl.foreground.a.createNotifyIntent(context, f3.w.generationalId(workSpec), cVar));
                }
                aVar.set(null);
            } catch (Throwable th2) {
                aVar.setException(th2);
            }
        }
    }

    static {
        w2.g.tagWithPrefix("WMFgUpdater");
    }

    public w(WorkDatabase workDatabase, e3.a aVar, i3.c cVar) {
        this.f12679b = aVar;
        this.f12678a = cVar;
        this.f12680c = workDatabase.workSpecDao();
    }

    public e8.c<Void> setForegroundAsync(Context context, UUID uuid, w2.c cVar) {
        h3.a aVarCreate = h3.a.create();
        a aVar = new a(aVarCreate, uuid, cVar, context);
        i3.d dVar = (i3.d) this.f12678a;
        dVar.getClass();
        i3.b.a(dVar, aVar);
        return aVarCreate;
    }
}
