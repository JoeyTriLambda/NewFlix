package r8;

import java.util.concurrent.Callable;

/* compiled from: CrashlyticsController.java */
/* loaded from: classes.dex */
public final class t implements Callable<Void> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f18770b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ r f18771m;

    public t(r rVar, String str) {
        this.f18771m = rVar;
        this.f18770b = str;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        r.a(this.f18771m, this.f18770b, Boolean.FALSE);
        return null;
    }
}
