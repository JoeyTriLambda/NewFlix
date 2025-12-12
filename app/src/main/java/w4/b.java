package w4;

import java.util.concurrent.Executor;
import java.util.logging.Logger;
import q4.i;
import q4.o;
import q4.s;
import r4.k;
import x4.l;

/* compiled from: DefaultScheduler.java */
/* loaded from: classes.dex */
public final class b implements d {

    /* renamed from: f, reason: collision with root package name */
    public static final Logger f20937f = Logger.getLogger(s.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final l f20938a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f20939b;

    /* renamed from: c, reason: collision with root package name */
    public final r4.d f20940c;

    /* renamed from: d, reason: collision with root package name */
    public final y4.d f20941d;

    /* renamed from: e, reason: collision with root package name */
    public final z4.a f20942e;

    public b(Executor executor, r4.d dVar, l lVar, y4.d dVar2, z4.a aVar) {
        this.f20939b = executor;
        this.f20940c = dVar;
        this.f20938a = lVar;
        this.f20941d = dVar2;
        this.f20942e = aVar;
    }

    @Override // w4.d
    public void schedule(final o oVar, final i iVar, final n4.g gVar) {
        this.f20939b.execute(new Runnable() { // from class: w4.a
            @Override // java.lang.Runnable
            public final void run() {
                o oVar2 = oVar;
                n4.g gVar2 = gVar;
                i iVar2 = iVar;
                b bVar = this.f20933b;
                bVar.getClass();
                Logger logger = b.f20937f;
                try {
                    k kVar = bVar.f20940c.get(oVar2.getBackendName());
                    int i10 = 1;
                    if (kVar == null) {
                        String str = String.format("Transport backend '%s' is not registered", oVar2.getBackendName());
                        logger.warning(str);
                        gVar2.onSchedule(new IllegalArgumentException(str));
                    } else {
                        bVar.f20942e.runCriticalSection(new q2.b(i10, bVar, oVar2, kVar.decorate(iVar2)));
                        gVar2.onSchedule(null);
                    }
                } catch (Exception e10) {
                    logger.warning("Error scheduling event " + e10.getMessage());
                    gVar2.onSchedule(e10);
                }
            }
        });
    }
}
