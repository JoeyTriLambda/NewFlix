package n8;

import java.util.concurrent.Callable;
import r8.w;

/* compiled from: FirebaseCrashlytics.java */
/* loaded from: classes.dex */
public final class f implements Callable<Void> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f16763b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ w f16764m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ com.google.firebase.crashlytics.internal.settings.a f16765n;

    public f(boolean z10, w wVar, com.google.firebase.crashlytics.internal.settings.a aVar) {
        this.f16763b = z10;
        this.f16764m = wVar;
        this.f16765n = aVar;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        if (!this.f16763b) {
            return null;
        }
        this.f16764m.doBackgroundInitializationAsync(this.f16765n);
        return null;
    }
}
