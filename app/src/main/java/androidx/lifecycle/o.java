package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* compiled from: LifecycleService.kt */
/* loaded from: classes.dex */
public class o extends Service implements l {

    /* renamed from: b, reason: collision with root package name */
    public final y f3502b = new y(this);

    @Override // androidx.lifecycle.l
    public Lifecycle getLifecycle() {
        return this.f3502b.getLifecycle();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        zf.i.checkNotNullParameter(intent, "intent");
        this.f3502b.onServicePreSuperOnBind();
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.f3502b.onServicePreSuperOnCreate();
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f3502b.onServicePreSuperOnDestroy();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i10) {
        this.f3502b.onServicePreSuperOnStart();
        super.onStart(intent, i10);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        return super.onStartCommand(intent, i10, i11);
    }
}
