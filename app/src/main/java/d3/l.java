package d3;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: StorageNotLowTracker.kt */
/* loaded from: classes.dex */
public final class l extends e<Boolean> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context context, i3.c cVar) {
        super(context, cVar);
        zf.i.checkNotNullParameter(context, "context");
        zf.i.checkNotNullParameter(cVar, "taskExecutor");
    }

    @Override // d3.e
    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return intentFilter;
    }

    @Override // d3.e
    public void onBroadcastReceive(Intent intent) {
        zf.i.checkNotNullParameter(intent, "intent");
        if (intent.getAction() == null) {
            return;
        }
        w2.g.get().debug(m.f10807a, "Received " + intent.getAction());
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode == -1181163412) {
                if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
                    setState(Boolean.FALSE);
                }
            } else if (iHashCode == -730838620 && action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                setState(Boolean.TRUE);
            }
        }
    }

    @Override // d3.g
    public Boolean getInitialState() {
        Intent intentRegisterReceiver = getAppContext().registerReceiver(null, getIntentFilter());
        boolean z10 = true;
        if (intentRegisterReceiver != null && intentRegisterReceiver.getAction() != null) {
            String action = intentRegisterReceiver.getAction();
            if (action == null) {
                z10 = false;
            } else {
                int iHashCode = action.hashCode();
                if (iHashCode == -1181163412) {
                    action.equals("android.intent.action.DEVICE_STORAGE_LOW");
                } else if (iHashCode != -730838620 || !action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                }
                z10 = false;
            }
        }
        return Boolean.valueOf(z10);
    }
}
