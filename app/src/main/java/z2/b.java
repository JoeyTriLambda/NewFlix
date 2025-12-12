package z2;

import androidx.work.impl.background.systemalarm.d;
import f3.m;
import w2.g;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f22559b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ androidx.work.impl.background.systemalarm.c f22560m;

    public /* synthetic */ b(androidx.work.impl.background.systemalarm.c cVar, int i10) {
        this.f22559b = i10;
        this.f22560m = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f22559b;
        androidx.work.impl.background.systemalarm.c cVar = this.f22560m;
        switch (i10) {
            case 0:
                androidx.work.impl.background.systemalarm.c.a(cVar);
                break;
            case 1:
                androidx.work.impl.background.systemalarm.c.a(cVar);
                break;
            case 2:
                androidx.work.impl.background.systemalarm.c.a(cVar);
                break;
            default:
                int i11 = cVar.f4555r;
                String str = androidx.work.impl.background.systemalarm.c.f4548x;
                m mVar = cVar.f4551n;
                if (i11 != 0) {
                    g.get().debug(str, "Already started work for " + mVar);
                    break;
                } else {
                    cVar.f4555r = 1;
                    g.get().debug(str, "onAllConstraintsMet for " + mVar);
                    d dVar = cVar.f4552o;
                    if (!dVar.f4565o.startWork(cVar.f4560w)) {
                        cVar.b();
                        break;
                    } else {
                        dVar.f4564n.startTimer(mVar, 600000L, cVar);
                        break;
                    }
                }
        }
    }
}
