package r9;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.google.firebase.sessions.SessionLifecycleService;

/* compiled from: SessionLifecycleServiceBinder.kt */
/* loaded from: classes.dex */
public final class r implements q {

    /* renamed from: b, reason: collision with root package name */
    public final g8.f f18891b;

    /* compiled from: SessionLifecycleServiceBinder.kt */
    public static final class a {
        public a(zf.f fVar) {
        }
    }

    static {
        new a(null);
    }

    public r(g8.f fVar) {
        zf.i.checkNotNullParameter(fVar, "firebaseApp");
        this.f18891b = fVar;
    }

    @Override // r9.q
    public void bindToService(Messenger messenger, ServiceConnection serviceConnection) {
        boolean zBindService;
        zf.i.checkNotNullParameter(messenger, "callback");
        zf.i.checkNotNullParameter(serviceConnection, "serviceConnection");
        Context applicationContext = this.f18891b.getApplicationContext().getApplicationContext();
        Intent intent = new Intent(applicationContext, (Class<?>) SessionLifecycleService.class);
        Log.d("LifecycleServiceBinder", "Binding service to application.");
        intent.setAction(String.valueOf(Process.myPid()));
        intent.putExtra("ClientCallbackMessenger", messenger);
        try {
            zBindService = applicationContext.bindService(intent, serviceConnection, 65);
        } catch (SecurityException e10) {
            Log.w("LifecycleServiceBinder", "Failed to bind session lifecycle service to application.", e10);
            zBindService = false;
        }
        if (zBindService) {
            return;
        }
        applicationContext.unbindService(serviceConnection);
        Log.i("LifecycleServiceBinder", "Session lifecycle service binding failed.");
    }
}
