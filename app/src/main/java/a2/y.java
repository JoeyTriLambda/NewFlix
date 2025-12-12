package a2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import java.util.ArrayList;

/* compiled from: RegisteredMediaRouteProviderWatcher.java */
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final Context f292a;

    /* renamed from: b, reason: collision with root package name */
    public final d f293b;

    /* renamed from: d, reason: collision with root package name */
    public final PackageManager f295d;

    /* renamed from: f, reason: collision with root package name */
    public boolean f297f;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList<w> f296e = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    public final a f298g = new a();

    /* renamed from: h, reason: collision with root package name */
    public final b f299h = new b();

    /* renamed from: c, reason: collision with root package name */
    public final Handler f294c = new Handler();

    /* compiled from: RegisteredMediaRouteProviderWatcher.java */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            y.this.a();
        }
    }

    /* compiled from: RegisteredMediaRouteProviderWatcher.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            y.this.a();
        }
    }

    /* compiled from: RegisteredMediaRouteProviderWatcher.java */
    public static class c {
        public static void a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, Handler handler, int i10) {
            context.registerReceiver(broadcastReceiver, intentFilter, null, handler, i10);
        }
    }

    /* compiled from: RegisteredMediaRouteProviderWatcher.java */
    public interface d {
    }

    public y(Context context, d dVar) {
        this.f292a = context;
        this.f293b = dVar;
        this.f295d = context.getPackageManager();
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0096 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x004a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.y.a():void");
    }

    public void rescan() {
        this.f294c.post(this.f299h);
    }

    public void start() {
        if (this.f297f) {
            return;
        }
        this.f297f = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_RESTARTED");
        intentFilter.addDataScheme("package");
        int i10 = Build.VERSION.SDK_INT;
        Handler handler = this.f294c;
        a aVar = this.f298g;
        Context context = this.f292a;
        if (i10 < 33) {
            context.registerReceiver(aVar, intentFilter, null, handler);
        } else {
            c.a(context, aVar, intentFilter, handler, 4);
        }
        handler.post(this.f299h);
    }
}
