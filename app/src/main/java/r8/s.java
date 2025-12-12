package r8;

import java.util.concurrent.Callable;

/* compiled from: CrashlyticsController.java */
/* loaded from: classes.dex */
public final class s implements Callable<Void> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f18767b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f18768m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ r f18769n;

    public s(r rVar, long j10, String str) {
        this.f18769n = rVar;
        this.f18767b = j10;
        this.f18768m = str;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        r rVar = this.f18769n;
        b0 b0Var = rVar.f18757n;
        if (b0Var != null && b0Var.f18671e.get()) {
            return null;
        }
        rVar.f18752i.writeToLog(this.f18767b, this.f18768m);
        return null;
    }
}
