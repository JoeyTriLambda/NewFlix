package androidx.work.impl.foreground;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.o;
import androidx.work.impl.foreground.a;
import java.util.UUID;
import w2.g;

/* loaded from: classes.dex */
public class SystemForegroundService extends o implements a.InterfaceC0051a {

    /* renamed from: q, reason: collision with root package name */
    public static final String f4581q = g.tagWithPrefix("SystemFgService");

    /* renamed from: m, reason: collision with root package name */
    public Handler f4582m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f4583n;

    /* renamed from: o, reason: collision with root package name */
    public androidx.work.impl.foreground.a f4584o;

    /* renamed from: p, reason: collision with root package name */
    public NotificationManager f4585p;

    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4586b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Notification f4587m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ int f4588n;

        public a(int i10, Notification notification, int i11) {
            this.f4586b = i10;
            this.f4587m = notification;
            this.f4588n = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = Build.VERSION.SDK_INT;
            int i11 = this.f4588n;
            Notification notification = this.f4587m;
            int i12 = this.f4586b;
            SystemForegroundService systemForegroundService = SystemForegroundService.this;
            if (i10 >= 31) {
                e.a(systemForegroundService, i12, notification, i11);
            } else if (i10 >= 29) {
                d.a(systemForegroundService, i12, notification, i11);
            } else {
                systemForegroundService.startForeground(i12, notification);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4590b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Notification f4591m;

        public b(int i10, Notification notification) {
            this.f4590b = i10;
            this.f4591m = notification;
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemForegroundService.this.f4585p.notify(this.f4590b, this.f4591m);
        }
    }

    public class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4593b;

        public c(int i10) {
            this.f4593b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemForegroundService.this.f4585p.cancel(this.f4593b);
        }
    }

    public static class d {
        public static void a(Service service, int i10, Notification notification, int i11) {
            service.startForeground(i10, notification, i11);
        }
    }

    public static class e {
        public static void a(Service service, int i10, Notification notification, int i11) {
            try {
                service.startForeground(i10, notification, i11);
            } catch (ForegroundServiceStartNotAllowedException e10) {
                g.get().warning(SystemForegroundService.f4581q, "Unable to start foreground service", e10);
            }
        }
    }

    public final void a() {
        this.f4582m = new Handler(Looper.getMainLooper());
        this.f4585p = (NotificationManager) getApplicationContext().getSystemService("notification");
        androidx.work.impl.foreground.a aVar = new androidx.work.impl.foreground.a(getApplicationContext());
        this.f4584o = aVar;
        if (aVar.f4604t != null) {
            g.get().error(androidx.work.impl.foreground.a.f4595u, "A callback already exists.");
        } else {
            aVar.f4604t = this;
        }
    }

    @Override // androidx.work.impl.foreground.a.InterfaceC0051a
    public void cancelNotification(int i10) {
        this.f4582m.post(new c(i10));
    }

    @Override // androidx.work.impl.foreground.a.InterfaceC0051a
    public void notify(int i10, Notification notification) {
        this.f4582m.post(new b(i10, notification));
    }

    @Override // androidx.lifecycle.o, android.app.Service
    public void onCreate() {
        super.onCreate();
        a();
    }

    @Override // androidx.lifecycle.o, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        androidx.work.impl.foreground.a aVar = this.f4584o;
        aVar.f4604t = null;
        synchronized (aVar.f4598n) {
            aVar.f4603s.reset();
        }
        aVar.f4596b.getProcessor().removeExecutionListener(aVar);
    }

    @Override // androidx.lifecycle.o, android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        if (this.f4583n) {
            g.get().info(f4581q, "Re-initializing SystemForegroundService after a request to shut-down.");
            androidx.work.impl.foreground.a aVar = this.f4584o;
            aVar.f4604t = null;
            synchronized (aVar.f4598n) {
                aVar.f4603s.reset();
            }
            aVar.f4596b.getProcessor().removeExecutionListener(aVar);
            a();
            this.f4583n = false;
        }
        if (intent == null) {
            return 3;
        }
        androidx.work.impl.foreground.a aVar2 = this.f4584o;
        aVar2.getClass();
        String action = intent.getAction();
        boolean zEquals = "ACTION_START_FOREGROUND".equals(action);
        String str = androidx.work.impl.foreground.a.f4595u;
        if (zEquals) {
            g.get().info(str, "Started foreground service " + intent);
            e3.b bVar = new e3.b(aVar2, intent.getStringExtra("KEY_WORKSPEC_ID"));
            i3.d dVar = (i3.d) aVar2.f4597m;
            dVar.getClass();
            i3.b.a(dVar, bVar);
            aVar2.a(intent);
            return 3;
        }
        if ("ACTION_NOTIFY".equals(action)) {
            aVar2.a(intent);
            return 3;
        }
        if (!"ACTION_CANCEL_WORK".equals(action)) {
            if (!"ACTION_STOP_FOREGROUND".equals(action)) {
                return 3;
            }
            g.get().info(str, "Stopping foreground service");
            a.InterfaceC0051a interfaceC0051a = aVar2.f4604t;
            if (interfaceC0051a == null) {
                return 3;
            }
            interfaceC0051a.stop();
            return 3;
        }
        g.get().info(str, "Stopping foreground work for " + intent);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
            return 3;
        }
        aVar2.f4596b.cancelWorkById(UUID.fromString(stringExtra));
        return 3;
    }

    @Override // androidx.work.impl.foreground.a.InterfaceC0051a
    public void startForeground(int i10, int i11, Notification notification) {
        this.f4582m.post(new a(i10, notification, i11));
    }

    @Override // androidx.work.impl.foreground.a.InterfaceC0051a
    public void stop() {
        this.f4583n = true;
        g.get().debug(f4581q, "All commands completed.");
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        stopSelf();
    }
}
