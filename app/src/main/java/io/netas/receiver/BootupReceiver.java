package io.netas.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import ge.a;
import io.netas.R;
import io.netas.service.NetasService;

/* loaded from: classes2.dex */
public class BootupReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            Log.d("NetasReboot", "BootupReceiver intent received: " + intent.toString());
            Intent intent2 = new Intent(context, (Class<?>) NetasService.class);
            a aVar = new a(context);
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 26 && aVar.b(context.getString(R.string.netas_is_foreground))) {
                Log.d("NetasReboot", "BootupReceiver foreground service ");
                intent2.putExtra("need_forground", true);
                context.startForegroundService(intent2);
            } else if (i10 < 26) {
                intent2.setAction("START_BACKGROUND");
                context.startService(intent2);
            }
        } catch (Exception e10) {
            Log.e("NetasReboot", "BootupReceiver failed init after reboot: " + e10.getMessage());
        }
    }
}
