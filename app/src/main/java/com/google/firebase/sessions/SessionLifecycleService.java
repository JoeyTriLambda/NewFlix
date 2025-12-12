package com.google.firebase.sessions;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.google.firebase.sessions.SessionGenerator;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.ClassUtils;
import r9.k;
import r9.o;
import zf.f;
import zf.i;

/* compiled from: SessionLifecycleService.kt */
/* loaded from: classes.dex */
public final class SessionLifecycleService extends Service {

    /* renamed from: b, reason: collision with root package name */
    public final HandlerThread f9953b = new HandlerThread("FirebaseSessions_HandlerThread");

    /* renamed from: m, reason: collision with root package name */
    public b f9954m;

    /* renamed from: n, reason: collision with root package name */
    public Messenger f9955n;

    /* compiled from: SessionLifecycleService.kt */
    public static final class a {
        public a(f fVar) {
        }
    }

    /* compiled from: SessionLifecycleService.kt */
    public static final class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public boolean f9956a;

        /* renamed from: b, reason: collision with root package name */
        public long f9957b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList<Messenger> f9958c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper) {
            super(looper);
            i.checkNotNullParameter(looper, "looper");
            this.f9958c = new ArrayList<>();
        }

        public final void a(Messenger messenger) throws RemoteException {
            if (this.f9956a) {
                c(messenger, SessionGenerator.f9941f.getInstance().getCurrentSession().getSessionId());
                return;
            }
            int i10 = k.f18869a;
            String currentSessionId = k.a.f18870a.getInstance().getCurrentSessionId();
            Log.d("SessionLifecycleService", "App has not yet foregrounded. Using previously stored session: " + currentSessionId);
            if (currentSessionId != null) {
                c(messenger, currentSessionId);
            }
        }

        public final void b() throws RemoteException {
            SessionGenerator.a aVar = SessionGenerator.f9941f;
            aVar.getInstance().generateNewSession();
            Log.d("SessionLifecycleService", "Generated new session " + aVar.getInstance().getCurrentSession().getSessionId());
            Log.d("SessionLifecycleService", "Broadcasting new session: " + aVar.getInstance().getCurrentSession());
            int i10 = o.f18880a;
            o.a.f18881a.getInstance().logSession(aVar.getInstance().getCurrentSession());
            Iterator it = new ArrayList(this.f9958c).iterator();
            while (it.hasNext()) {
                Messenger messenger = (Messenger) it.next();
                i.checkNotNullExpressionValue(messenger, "it");
                a(messenger);
            }
            int i11 = k.f18869a;
            k.a.f18870a.getInstance().updateSessionId(SessionGenerator.f9941f.getInstance().getCurrentSession().getSessionId());
        }

        public final void c(Messenger messenger, String str) throws RemoteException {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("SessionUpdateExtra", str);
                Message messageObtain = Message.obtain(null, 3, 0, 0);
                messageObtain.setData(bundle);
                messenger.send(messageObtain);
            } catch (DeadObjectException unused) {
                Log.d("SessionLifecycleService", "Removing dead client from list: " + messenger);
                this.f9958c.remove(messenger);
            } catch (Exception e10) {
                Log.w("SessionLifecycleService", "Unable to push new session to " + messenger + ClassUtils.PACKAGE_SEPARATOR_CHAR, e10);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws RemoteException {
            i.checkNotNullParameter(message, "msg");
            if (this.f9957b > message.getWhen()) {
                Log.d("SessionLifecycleService", "Ignoring old message from " + message.getWhen() + " which is older than " + this.f9957b + ClassUtils.PACKAGE_SEPARATOR_CHAR);
                return;
            }
            int i10 = message.what;
            if (i10 == 1) {
                Log.d("SessionLifecycleService", "Activity foregrounding at " + message.getWhen() + ClassUtils.PACKAGE_SEPARATOR_CHAR);
                if (this.f9956a) {
                    if (message.getWhen() - this.f9957b > jg.a.m41getInWholeMillisecondsimpl(SessionsSettings.f10007c.getInstance().m21getSessionRestartTimeoutUwyO8pc())) {
                        Log.d("SessionLifecycleService", "Session too long in background. Creating new session.");
                        b();
                    }
                } else {
                    Log.d("SessionLifecycleService", "Cold start detected.");
                    this.f9956a = true;
                    b();
                }
                this.f9957b = message.getWhen();
                return;
            }
            if (i10 == 2) {
                Log.d("SessionLifecycleService", "Activity backgrounding at " + message.getWhen());
                this.f9957b = message.getWhen();
                return;
            }
            if (i10 != 4) {
                Log.w("SessionLifecycleService", "Received unexpected event from the SessionLifecycleClient: " + message);
                super.handleMessage(message);
                return;
            }
            ArrayList<Messenger> arrayList = this.f9958c;
            arrayList.add(message.replyTo);
            Messenger messenger = message.replyTo;
            i.checkNotNullExpressionValue(messenger, "msg.replyTo");
            a(messenger);
            Log.d("SessionLifecycleService", "Client " + message.replyTo + " bound at " + message.getWhen() + ". Clients: " + arrayList.size());
        }
    }

    static {
        new a(null);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent == null) {
            Log.d("SessionLifecycleService", "Service bound with null intent. Ignoring.");
            return null;
        }
        Log.d("SessionLifecycleService", "Service bound to new client on process " + intent.getAction());
        Messenger messenger = Build.VERSION.SDK_INT >= 33 ? (Messenger) intent.getParcelableExtra("ClientCallbackMessenger", Messenger.class) : (Messenger) intent.getParcelableExtra("ClientCallbackMessenger");
        if (messenger != null) {
            Message messageObtain = Message.obtain(null, 4, 0, 0);
            messageObtain.replyTo = messenger;
            b bVar = this.f9954m;
            if (bVar != null) {
                bVar.sendMessage(messageObtain);
            }
        }
        Messenger messenger2 = this.f9955n;
        if (messenger2 != null) {
            return messenger2.getBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        HandlerThread handlerThread = this.f9953b;
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        i.checkNotNullExpressionValue(looper, "handlerThread.looper");
        this.f9954m = new b(looper);
        this.f9955n = new Messenger(this.f9954m);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f9953b.quit();
    }
}
