package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import g3.m;
import w2.g;
import x2.e0;

/* loaded from: classes.dex */
public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4531a = g.tagWithPrefix("ConstrntProxyUpdtRecvr");

    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Intent f4532b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Context f4533m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ BroadcastReceiver.PendingResult f4534n;

        public a(Intent intent, Context context, BroadcastReceiver.PendingResult pendingResult) {
            this.f4532b = intent;
            this.f4533m = context;
            this.f4534n = pendingResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            BroadcastReceiver.PendingResult pendingResult = this.f4534n;
            Context context = this.f4533m;
            Intent intent = this.f4532b;
            try {
                boolean booleanExtra = intent.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra2 = intent.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                boolean booleanExtra3 = intent.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra4 = intent.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                g.get().debug(ConstraintProxyUpdateReceiver.f4531a, "Updating proxies: (BatteryNotLowProxy (" + booleanExtra + "), BatteryChargingProxy (" + booleanExtra2 + "), StorageNotLowProxy (" + booleanExtra3 + "), NetworkStateProxy (" + booleanExtra4 + "), ");
                m.setComponentEnabled(context, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                m.setComponentEnabled(context, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                m.setComponentEnabled(context, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                m.setComponentEnabled(context, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
            } finally {
                pendingResult.finish();
            }
        }
    }

    public static Intent newConstraintProxyUpdateIntent(Context context, boolean z10, boolean z11, boolean z12, boolean z13) {
        Intent intent = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
        intent.setComponent(new ComponentName(context, (Class<?>) ConstraintProxyUpdateReceiver.class));
        intent.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z10).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z11).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z12).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z13);
        return intent;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(action)) {
            g.get().debug(f4531a, ac.c.j("Ignoring unknown action ", action));
            return;
        }
        BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        i3.c workTaskExecutor = e0.getInstance(context).getWorkTaskExecutor();
        a aVar = new a(intent, context, pendingResultGoAsync);
        i3.d dVar = (i3.d) workTaskExecutor;
        dVar.getClass();
        i3.b.a(dVar, aVar);
    }
}
