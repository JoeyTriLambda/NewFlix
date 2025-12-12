package d3;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: BatteryNotLowTracker.kt */
/* loaded from: classes.dex */
public final class c extends e<Boolean> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, i3.c cVar) {
        super(context, cVar);
        zf.i.checkNotNullParameter(context, "context");
        zf.i.checkNotNullParameter(cVar, "taskExecutor");
    }

    @Override // d3.e
    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    @Override // d3.e
    public void onBroadcastReceive(Intent intent) {
        zf.i.checkNotNullParameter(intent, "intent");
        if (intent.getAction() == null) {
            return;
        }
        w2.g.get().debug(d.f10792a, "Received " + intent.getAction());
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode == -1980154005) {
                if (action.equals("android.intent.action.BATTERY_OKAY")) {
                    setState(Boolean.TRUE);
                }
            } else if (iHashCode == 490310653 && action.equals("android.intent.action.BATTERY_LOW")) {
                setState(Boolean.FALSE);
            }
        }
    }

    @Override // d3.g
    public Boolean getInitialState() {
        Intent intentRegisterReceiver = getAppContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver == null) {
            w2.g.get().error(d.f10792a, "getInitialState - null intent received");
            return Boolean.FALSE;
        }
        int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
        float intExtra2 = intentRegisterReceiver.getIntExtra("level", -1) / intentRegisterReceiver.getIntExtra("scale", -1);
        boolean z10 = true;
        if (intExtra != 1 && intExtra2 <= 0.15f) {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }
}
