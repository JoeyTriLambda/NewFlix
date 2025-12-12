package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.lifecycle.o;
import androidx.work.impl.background.systemalarm.d;
import g3.t;
import w2.g;

/* loaded from: classes.dex */
public class SystemAlarmService extends o implements d.c {

    /* renamed from: o, reason: collision with root package name */
    public static final String f4536o = g.tagWithPrefix("SystemAlarmService");

    /* renamed from: m, reason: collision with root package name */
    public d f4537m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f4538n;

    @Override // androidx.work.impl.background.systemalarm.d.c
    public void onAllCommandsCompleted() {
        this.f4538n = true;
        g.get().debug(f4536o, "All commands completed in dispatcher");
        t.checkWakeLocks();
        stopSelf();
    }

    @Override // androidx.lifecycle.o, android.app.Service
    public void onCreate() {
        super.onCreate();
        d dVar = new d(this);
        this.f4537m = dVar;
        if (dVar.f4570t != null) {
            g.get().error(d.f4561u, "A completion listener for SystemAlarmDispatcher already exists.");
        } else {
            dVar.f4570t = this;
        }
        this.f4538n = false;
    }

    @Override // androidx.lifecycle.o, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f4538n = true;
        d dVar = this.f4537m;
        dVar.getClass();
        g.get().debug(d.f4561u, "Destroying SystemAlarmDispatcher");
        dVar.f4565o.removeExecutionListener(dVar);
        dVar.f4570t = null;
    }

    @Override // androidx.lifecycle.o, android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        if (this.f4538n) {
            g.get().info(f4536o, "Re-initializing SystemAlarmDispatcher after a request to shut-down.");
            d dVar = this.f4537m;
            dVar.getClass();
            g gVar = g.get();
            String str = d.f4561u;
            gVar.debug(str, "Destroying SystemAlarmDispatcher");
            dVar.f4565o.removeExecutionListener(dVar);
            dVar.f4570t = null;
            d dVar2 = new d(this);
            this.f4537m = dVar2;
            if (dVar2.f4570t != null) {
                g.get().error(str, "A completion listener for SystemAlarmDispatcher already exists.");
            } else {
                dVar2.f4570t = this;
            }
            this.f4538n = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f4537m.add(intent, i11);
        return 3;
    }
}
