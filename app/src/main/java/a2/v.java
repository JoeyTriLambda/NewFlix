package a2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: MediaTransferReceiver.java */
/* loaded from: classes.dex */
public final class v extends BroadcastReceiver {
    public static boolean isDeclared(Context context) {
        Intent intent = new Intent(context, (Class<?>) v.class);
        intent.setPackage(context.getPackageName());
        return context.getPackageManager().queryBroadcastReceivers(intent, 0).size() > 0;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
    }
}
