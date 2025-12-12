package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import b3.c;
import f3.m;
import f3.t;
import f3.w;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import w2.g;
import x2.e;
import x2.e0;

/* compiled from: SystemForegroundDispatcher.java */
/* loaded from: classes.dex */
public final class a implements c, e {

    /* renamed from: u, reason: collision with root package name */
    public static final String f4595u = g.tagWithPrefix("SystemFgDispatcher");

    /* renamed from: b, reason: collision with root package name */
    public final e0 f4596b;

    /* renamed from: m, reason: collision with root package name */
    public final i3.c f4597m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f4598n = new Object();

    /* renamed from: o, reason: collision with root package name */
    public m f4599o;

    /* renamed from: p, reason: collision with root package name */
    public final LinkedHashMap f4600p;

    /* renamed from: q, reason: collision with root package name */
    public final HashMap f4601q;

    /* renamed from: r, reason: collision with root package name */
    public final HashSet f4602r;

    /* renamed from: s, reason: collision with root package name */
    public final b3.e f4603s;

    /* renamed from: t, reason: collision with root package name */
    public InterfaceC0051a f4604t;

    /* compiled from: SystemForegroundDispatcher.java */
    /* renamed from: androidx.work.impl.foreground.a$a, reason: collision with other inner class name */
    public interface InterfaceC0051a {
        void cancelNotification(int i10);

        void notify(int i10, Notification notification);

        void startForeground(int i10, int i11, Notification notification);

        void stop();
    }

    public a(Context context) {
        e0 e0Var = e0.getInstance(context);
        this.f4596b = e0Var;
        this.f4597m = e0Var.getWorkTaskExecutor();
        this.f4599o = null;
        this.f4600p = new LinkedHashMap();
        this.f4602r = new HashSet();
        this.f4601q = new HashMap();
        this.f4603s = new b3.e(e0Var.getTrackers(), this);
        e0Var.getProcessor().addExecutionListener(this);
    }

    public static Intent createNotifyIntent(Context context, m mVar, w2.c cVar) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", cVar.getNotificationId());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", cVar.getForegroundServiceType());
        intent.putExtra("KEY_NOTIFICATION", cVar.getNotification());
        intent.putExtra("KEY_WORKSPEC_ID", mVar.getWorkSpecId());
        intent.putExtra("KEY_GENERATION", mVar.getGeneration());
        return intent;
    }

    public static Intent createStartForegroundIntent(Context context, m mVar, w2.c cVar) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", mVar.getWorkSpecId());
        intent.putExtra("KEY_GENERATION", mVar.getGeneration());
        intent.putExtra("KEY_NOTIFICATION_ID", cVar.getNotificationId());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", cVar.getForegroundServiceType());
        intent.putExtra("KEY_NOTIFICATION", cVar.getNotification());
        return intent;
    }

    public static Intent createStopForegroundIntent(Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }

    public final void a(Intent intent) {
        int foregroundServiceType = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        m mVar = new m(stringExtra, intent.getIntExtra("KEY_GENERATION", 0));
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        g gVar = g.get();
        StringBuilder sb2 = new StringBuilder("Notifying with (id:");
        sb2.append(intExtra);
        sb2.append(", workSpecId: ");
        sb2.append(stringExtra);
        sb2.append(", notificationType :");
        gVar.debug(f4595u, ac.c.m(sb2, intExtra2, ")"));
        if (notification == null || this.f4604t == null) {
            return;
        }
        w2.c cVar = new w2.c(intExtra, notification, intExtra2);
        LinkedHashMap linkedHashMap = this.f4600p;
        linkedHashMap.put(mVar, cVar);
        if (this.f4599o == null) {
            this.f4599o = mVar;
            this.f4604t.startForeground(intExtra, intExtra2, notification);
            return;
        }
        this.f4604t.notify(intExtra, notification);
        if (intExtra2 == 0 || Build.VERSION.SDK_INT < 29) {
            return;
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            foregroundServiceType |= ((w2.c) ((Map.Entry) it.next()).getValue()).getForegroundServiceType();
        }
        w2.c cVar2 = (w2.c) linkedHashMap.get(this.f4599o);
        if (cVar2 != null) {
            this.f4604t.startForeground(cVar2.getNotificationId(), foregroundServiceType, cVar2.getNotification());
        }
    }

    @Override // b3.c
    public void onAllConstraintsNotMet(List<t> list) {
        if (list.isEmpty()) {
            return;
        }
        for (t tVar : list) {
            String str = tVar.f11426a;
            g.get().debug(f4595u, "Constraints unmet for WorkSpec " + str);
            this.f4596b.stopForegroundWork(w.generationalId(tVar));
        }
    }

    @Override // x2.e
    public void onExecuted(m mVar, boolean z10) {
        Map.Entry entry;
        synchronized (this.f4598n) {
            t tVar = (t) this.f4601q.remove(mVar);
            if (tVar != null ? this.f4602r.remove(tVar) : false) {
                this.f4603s.replace(this.f4602r);
            }
        }
        w2.c cVar = (w2.c) this.f4600p.remove(mVar);
        if (mVar.equals(this.f4599o) && this.f4600p.size() > 0) {
            Iterator it = this.f4600p.entrySet().iterator();
            Object next = it.next();
            while (true) {
                entry = (Map.Entry) next;
                if (!it.hasNext()) {
                    break;
                } else {
                    next = it.next();
                }
            }
            this.f4599o = (m) entry.getKey();
            if (this.f4604t != null) {
                w2.c cVar2 = (w2.c) entry.getValue();
                this.f4604t.startForeground(cVar2.getNotificationId(), cVar2.getForegroundServiceType(), cVar2.getNotification());
                this.f4604t.cancelNotification(cVar2.getNotificationId());
            }
        }
        InterfaceC0051a interfaceC0051a = this.f4604t;
        if (cVar == null || interfaceC0051a == null) {
            return;
        }
        g.get().debug(f4595u, "Removing Notification (id: " + cVar.getNotificationId() + ", workSpecId: " + mVar + ", notificationType: " + cVar.getForegroundServiceType());
        interfaceC0051a.cancelNotification(cVar.getNotificationId());
    }

    @Override // b3.c
    public void onAllConstraintsMet(List<t> list) {
    }
}
