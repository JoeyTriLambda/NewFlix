package l0;

import android.app.Application;
import l0.f;

/* compiled from: ActivityRecreator.java */
/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Application f15638b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ f.b f15639m;

    public e(Application application, f.b bVar) {
        this.f15638b = application;
        this.f15639m = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15638b.unregisterActivityLifecycleCallbacks(this.f15639m);
    }
}
