package r8;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* compiled from: CrashlyticsController.java */
/* loaded from: classes.dex */
public final class u implements Callable<Void> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f18772b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ r f18773m;

    public u(r rVar, long j10) {
        this.f18773m = rVar;
        this.f18772b = j10;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        Bundle bundle = new Bundle();
        bundle.putInt("fatal", 1);
        bundle.putLong("timestamp", this.f18772b);
        this.f18773m.f18754k.logEvent("_ae", bundle);
        return null;
    }
}
