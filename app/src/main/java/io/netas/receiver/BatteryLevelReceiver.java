package io.netas.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import he.a;

/* loaded from: classes2.dex */
public class BatteryLevelReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public a f13487a = null;

    public static IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        return intentFilter;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Boolean bool;
        String str;
        try {
            if ("android.intent.action.BATTERY_LOW".equalsIgnoreCase(intent.getAction())) {
                bool = Boolean.TRUE;
                str = "ACTION_BATTERY_LOW indication";
            } else {
                bool = Boolean.FALSE;
                str = "ACTION_BATTERY_OKAY indication";
            }
            Log.d("BatteryLevelReceiver", str);
            a aVar = this.f13487a;
            if (aVar != null) {
                aVar.a(bool.booleanValue());
            }
        } catch (Exception e10) {
            Log.e("BatteryLevelReceiver", "BatteryLevelReceiver failed get battery status: " + e10.getMessage());
        }
    }

    public void a(a aVar) {
        this.f13487a = aVar;
    }
}
