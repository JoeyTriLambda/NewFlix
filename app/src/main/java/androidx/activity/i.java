package androidx.activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* compiled from: FullyDrawnReporter.kt */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f816a;

    /* renamed from: b, reason: collision with root package name */
    public final yf.a<lf.h> f817b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f818c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f819d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f820e;

    public i(Executor executor, yf.a<lf.h> aVar) {
        zf.i.checkNotNullParameter(executor, "executor");
        zf.i.checkNotNullParameter(aVar, "reportFullyDrawn");
        this.f816a = executor;
        this.f817b = aVar;
        this.f818c = new Object();
        this.f820e = new ArrayList();
    }

    public final void fullyDrawnReported() {
        synchronized (this.f818c) {
            this.f819d = true;
            Iterator it = this.f820e.iterator();
            while (it.hasNext()) {
                ((yf.a) it.next()).invoke();
            }
            this.f820e.clear();
            lf.h hVar = lf.h.f16056a;
        }
    }

    public final boolean isFullyDrawnReported() {
        boolean z10;
        synchronized (this.f818c) {
            z10 = this.f819d;
        }
        return z10;
    }
}
