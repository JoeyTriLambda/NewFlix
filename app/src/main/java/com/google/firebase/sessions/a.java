package com.google.firebase.sessions;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import kg.h;
import kg.h0;
import kg.k1;
import kotlin.coroutines.CoroutineContext;
import r9.q;
import zf.f;
import zf.i;

/* compiled from: SessionLifecycleClient.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f9959a;

    /* renamed from: b, reason: collision with root package name */
    public Messenger f9960b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedBlockingDeque<Message> f9961c;

    /* renamed from: d, reason: collision with root package name */
    public final c f9962d;

    /* compiled from: SessionLifecycleClient.kt */
    /* renamed from: com.google.firebase.sessions.a$a, reason: collision with other inner class name */
    public static final class HandlerC0104a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final CoroutineContext f9963a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0104a(CoroutineContext coroutineContext) {
            super(Looper.getMainLooper());
            i.checkNotNullParameter(coroutineContext, "backgroundDispatcher");
            this.f9963a = coroutineContext;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String string;
            i.checkNotNullParameter(message, "msg");
            if (message.what != 3) {
                Log.w("SessionLifecycleClient", "Received unexpected event from the SessionLifecycleService: " + message);
                super.handleMessage(message);
                return;
            }
            Bundle data = message.getData();
            if (data == null || (string = data.getString("SessionUpdateExtra")) == null) {
                string = "";
            }
            Log.d("SessionLifecycleClient", "Session update received: ".concat(string));
            h.launch$default(h0.CoroutineScope(this.f9963a), null, null, new SessionLifecycleClient$ClientUpdateHandler$handleSessionUpdate$1(string, null), 3, null);
        }
    }

    /* compiled from: SessionLifecycleClient.kt */
    public static final class b {
        public b(f fVar) {
        }
    }

    /* compiled from: SessionLifecycleClient.kt */
    public static final class c implements ServiceConnection {
        public c() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            StringBuilder sb2 = new StringBuilder("Connected to SessionLifecycleService. Queue size ");
            a aVar = a.this;
            sb2.append(aVar.f9961c.size());
            Log.d("SessionLifecycleClient", sb2.toString());
            aVar.f9960b = new Messenger(iBinder);
            aVar.getClass();
            a.access$sendLifecycleEvents(aVar, a.access$drainQueue(aVar));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d("SessionLifecycleClient", "Disconnected from SessionLifecycleService");
            a aVar = a.this;
            aVar.f9960b = null;
            aVar.getClass();
        }
    }

    static {
        new b(null);
    }

    public a(CoroutineContext coroutineContext) {
        i.checkNotNullParameter(coroutineContext, "backgroundDispatcher");
        this.f9959a = coroutineContext;
        this.f9961c = new LinkedBlockingDeque<>(20);
        this.f9962d = new c();
    }

    public static final List access$drainQueue(a aVar) {
        aVar.getClass();
        ArrayList arrayList = new ArrayList();
        aVar.f9961c.drainTo(arrayList);
        return arrayList;
    }

    public static final Message access$getLatestByCode(a aVar, List list, int i10) {
        Object obj;
        aVar.getClass();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (((Message) obj2).what == i10) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long when = ((Message) next).getWhen();
                do {
                    Object next2 = it.next();
                    long when2 = ((Message) next2).getWhen();
                    if (when < when2) {
                        next = next2;
                        when = when2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (Message) obj;
    }

    public static final k1 access$sendLifecycleEvents(a aVar, List list) {
        return h.launch$default(h0.CoroutineScope(aVar.f9959a), null, null, new SessionLifecycleClient$sendLifecycleEvents$1(aVar, list, null), 3, null);
    }

    public static final void access$sendMessageToServer(a aVar, Message message) throws RemoteException {
        if (aVar.f9960b == null) {
            aVar.a(message);
            return;
        }
        try {
            Log.d("SessionLifecycleClient", "Sending lifecycle " + message.what + " to service");
            Messenger messenger = aVar.f9960b;
            if (messenger != null) {
                messenger.send(message);
            }
        } catch (RemoteException e10) {
            Log.w("SessionLifecycleClient", "Unable to deliver message: " + message.what, e10);
            aVar.a(message);
        }
    }

    public final void a(Message message) {
        LinkedBlockingDeque<Message> linkedBlockingDeque = this.f9961c;
        if (!linkedBlockingDeque.offer(message)) {
            Log.d("SessionLifecycleClient", "Failed to enqueue message " + message.what + ". Dropping.");
            return;
        }
        Log.d("SessionLifecycleClient", "Queued message " + message.what + ". Queue size " + linkedBlockingDeque.size());
    }

    public final void backgrounded() {
        ArrayList arrayList = new ArrayList();
        this.f9961c.drainTo(arrayList);
        Message messageObtain = Message.obtain(null, 2, 0, 0);
        i.checkNotNullExpressionValue(messageObtain, "obtain(null, messageCode, 0, 0)");
        arrayList.add(messageObtain);
        h.launch$default(h0.CoroutineScope(this.f9959a), null, null, new SessionLifecycleClient$sendLifecycleEvents$1(this, arrayList, null), 3, null);
    }

    public final void bindToService() {
        int i10 = q.f18889a;
        q.a.f18890a.getInstance().bindToService(new Messenger(new HandlerC0104a(this.f9959a)), this.f9962d);
    }

    public final void foregrounded() {
        ArrayList arrayList = new ArrayList();
        this.f9961c.drainTo(arrayList);
        Message messageObtain = Message.obtain(null, 1, 0, 0);
        i.checkNotNullExpressionValue(messageObtain, "obtain(null, messageCode, 0, 0)");
        arrayList.add(messageObtain);
        h.launch$default(h0.CoroutineScope(this.f9959a), null, null, new SessionLifecycleClient$sendLifecycleEvents$1(this, arrayList, null), 3, null);
    }
}
