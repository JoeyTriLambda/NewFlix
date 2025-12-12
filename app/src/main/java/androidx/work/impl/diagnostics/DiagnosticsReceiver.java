package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.workers.DiagnosticsWorker;
import w2.g;
import w2.h;
import w2.n;

/* loaded from: classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4580a = g.tagWithPrefix("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        g gVar = g.get();
        String str = f4580a;
        gVar.debug(str, "Requesting diagnostics");
        try {
            n.getInstance(context).enqueue(h.from(DiagnosticsWorker.class));
        } catch (IllegalStateException e10) {
            g.get().error(str, "WorkManager is not initialized", e10);
        }
    }
}
