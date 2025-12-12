package androidx.work.impl.workers;

import android.content.Context;
import androidx.activity.d;
import androidx.work.WorkerParameters;
import androidx.work.c;
import f3.t;
import h3.a;
import java.util.List;
import lf.h;
import w2.g;
import zf.i;

/* compiled from: ConstraintTrackingWorker.kt */
/* loaded from: classes.dex */
public final class ConstraintTrackingWorker extends c implements b3.c {

    /* renamed from: p, reason: collision with root package name */
    public final WorkerParameters f4641p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f4642q;

    /* renamed from: r, reason: collision with root package name */
    public volatile boolean f4643r;

    /* renamed from: s, reason: collision with root package name */
    public final a<c.a> f4644s;

    /* renamed from: t, reason: collision with root package name */
    public c f4645t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        i.checkNotNullParameter(context, "appContext");
        i.checkNotNullParameter(workerParameters, "workerParameters");
        this.f4641p = workerParameters;
        this.f4642q = new Object();
        this.f4644s = a.create();
    }

    @Override // b3.c
    public void onAllConstraintsMet(List<t> list) {
        i.checkNotNullParameter(list, "workSpecs");
    }

    @Override // b3.c
    public void onAllConstraintsNotMet(List<t> list) {
        i.checkNotNullParameter(list, "workSpecs");
        g.get().debug(j3.a.f14582a, "Constraints changed for " + list);
        synchronized (this.f4642q) {
            this.f4643r = true;
            h hVar = h.f16056a;
        }
    }

    @Override // androidx.work.c
    public void onStopped() {
        super.onStopped();
        c cVar = this.f4645t;
        if (cVar == null || cVar.isStopped()) {
            return;
        }
        cVar.stop();
    }

    @Override // androidx.work.c
    public e8.c<c.a> startWork() {
        getBackgroundExecutor().execute(new d(this, 9));
        a<c.a> aVar = this.f4644s;
        i.checkNotNullExpressionValue(aVar, "future");
        return aVar;
    }
}
