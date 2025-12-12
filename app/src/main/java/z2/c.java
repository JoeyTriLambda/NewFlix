package z2;

import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import f3.m;
import f3.w;
import w2.g;
import x2.t;

/* compiled from: SystemAlarmScheduler.java */
/* loaded from: classes.dex */
public final class c implements t {

    /* renamed from: m, reason: collision with root package name */
    public static final String f22561m = g.tagWithPrefix("SystemAlarmScheduler");

    /* renamed from: b, reason: collision with root package name */
    public final Context f22562b;

    public c(Context context) {
        this.f22562b = context.getApplicationContext();
    }

    @Override // x2.t
    public void cancel(String str) {
        String str2 = androidx.work.impl.background.systemalarm.a.f4539p;
        Context context = this.f22562b;
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        context.startService(intent);
    }

    @Override // x2.t
    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    @Override // x2.t
    public void schedule(f3.t... tVarArr) {
        for (f3.t tVar : tVarArr) {
            g.get().debug(f22561m, "Scheduling work with workSpecId " + tVar.f11426a);
            m mVarGenerationalId = w.generationalId(tVar);
            String str = androidx.work.impl.background.systemalarm.a.f4539p;
            Context context = this.f22562b;
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction("ACTION_SCHEDULE_WORK");
            androidx.work.impl.background.systemalarm.a.d(intent, mVarGenerationalId);
            context.startService(intent);
        }
    }
}
