package com.squareup.picasso;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import com.squareup.picasso.Picasso;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* compiled from: Dispatcher.java */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f10555a;

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f10556b;

    /* renamed from: c, reason: collision with root package name */
    public final sa.d f10557c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f10558d;

    /* renamed from: e, reason: collision with root package name */
    public final WeakHashMap f10559e;

    /* renamed from: f, reason: collision with root package name */
    public final WeakHashMap f10560f;

    /* renamed from: g, reason: collision with root package name */
    public final LinkedHashSet f10561g;

    /* renamed from: h, reason: collision with root package name */
    public final a f10562h;

    /* renamed from: i, reason: collision with root package name */
    public final Handler f10563i;

    /* renamed from: j, reason: collision with root package name */
    public final sa.a f10564j;

    /* renamed from: k, reason: collision with root package name */
    public final sa.h f10565k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f10566l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f10567m;

    /* compiled from: Dispatcher.java */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final f f10568a;

        /* compiled from: Dispatcher.java */
        /* renamed from: com.squareup.picasso.f$a$a, reason: collision with other inner class name */
        public class RunnableC0117a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Message f10569b;

            public RunnableC0117a(Message message) {
                this.f10569b = message;
            }

            @Override // java.lang.Runnable
            public void run() {
                throw new AssertionError("Unknown handler message received: " + this.f10569b.what);
            }
        }

        public a(Looper looper, f fVar) {
            super(looper);
            this.f10568a = fVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:141:0x02bc  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0182  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void handleMessage(android.os.Message r15) {
            /*
                Method dump skipped, instructions count: 1002
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.f.a.handleMessage(android.os.Message):void");
        }
    }

    /* compiled from: Dispatcher.java */
    public static class b extends HandlerThread {
        public b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    /* compiled from: Dispatcher.java */
    public static class c extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public final f f10570a;

        public c(f fVar) {
            this.f10570a = fVar;
        }

        @Override // android.content.BroadcastReceiver
        @SuppressLint({"MissingPermission"})
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            boolean zEquals = "android.intent.action.AIRPLANE_MODE".equals(action);
            f fVar = this.f10570a;
            if (zEquals) {
                if (intent.hasExtra(AdOperationMetric.INIT_STATE)) {
                    boolean booleanExtra = intent.getBooleanExtra(AdOperationMetric.INIT_STATE, false);
                    a aVar = fVar.f10562h;
                    aVar.sendMessage(aVar.obtainMessage(10, booleanExtra ? 1 : 0, 0));
                    return;
                }
                return;
            }
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                StringBuilder sb2 = o.f10621a;
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                a aVar2 = fVar.f10562h;
                aVar2.sendMessage(aVar2.obtainMessage(9, activeNetworkInfo));
            }
        }
    }

    public f(Context context, ExecutorService executorService, Picasso.a aVar, sa.d dVar, sa.a aVar2, sa.h hVar) {
        b bVar = new b();
        bVar.start();
        Looper looper = bVar.getLooper();
        StringBuilder sb2 = o.f10621a;
        sa.k kVar = new sa.k(looper);
        kVar.sendMessageDelayed(kVar.obtainMessage(), 1000L);
        this.f10555a = context;
        this.f10556b = executorService;
        this.f10558d = new LinkedHashMap();
        this.f10559e = new WeakHashMap();
        this.f10560f = new WeakHashMap();
        this.f10561g = new LinkedHashSet();
        this.f10562h = new a(bVar.getLooper(), this);
        this.f10557c = dVar;
        this.f10563i = aVar;
        this.f10564j = aVar2;
        this.f10565k = hVar;
        this.f10566l = new ArrayList(4);
        try {
            Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (NullPointerException | SecurityException unused) {
        }
        this.f10567m = context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0;
        c cVar = new c(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        f fVar = cVar.f10570a;
        if (fVar.f10567m) {
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        fVar.f10555a.registerReceiver(cVar, intentFilter);
    }

    public final void a(com.squareup.picasso.c cVar) {
        Future<?> future = cVar.f10545y;
        if (future != null && future.isCancelled()) {
            return;
        }
        Bitmap bitmap = cVar.f10544x;
        if (bitmap != null) {
            bitmap.prepareToDraw();
        }
        this.f10566l.add(cVar);
        a aVar = this.f10562h;
        if (aVar.hasMessages(7)) {
            return;
        }
        aVar.sendEmptyMessageDelayed(7, 200L);
    }

    public final void b(com.squareup.picasso.c cVar) {
        a aVar = this.f10562h;
        aVar.sendMessage(aVar.obtainMessage(4, cVar));
    }

    public final void c(com.squareup.picasso.c cVar, boolean z10) {
        if (cVar.f10533m.f10497l) {
            o.d("Dispatcher", "batched", o.a(cVar), "for error".concat(z10 ? " (will replay)" : ""));
        }
        this.f10558d.remove(cVar.f10537q);
        a(cVar);
    }

    public final void d(com.squareup.picasso.a aVar, boolean z10) {
        com.squareup.picasso.c cVar;
        if (this.f10561g.contains(aVar.f10525j)) {
            this.f10560f.put(aVar.b(), aVar);
            if (aVar.f10516a.f10497l) {
                o.d("Dispatcher", "paused", aVar.f10517b.a(), "because tag '" + aVar.f10525j + "' is paused");
                return;
            }
            return;
        }
        com.squareup.picasso.c cVar2 = (com.squareup.picasso.c) this.f10558d.get(aVar.f10524i);
        if (cVar2 != null) {
            boolean z11 = cVar2.f10533m.f10497l;
            k kVar = aVar.f10517b;
            if (cVar2.f10542v == null) {
                cVar2.f10542v = aVar;
                if (z11) {
                    ArrayList arrayList = cVar2.f10543w;
                    if (arrayList == null || arrayList.isEmpty()) {
                        o.d("Hunter", "joined", kVar.a(), "to empty hunter");
                        return;
                    } else {
                        o.d("Hunter", "joined", kVar.a(), o.b(cVar2, "to "));
                        return;
                    }
                }
                return;
            }
            if (cVar2.f10543w == null) {
                cVar2.f10543w = new ArrayList(3);
            }
            cVar2.f10543w.add(aVar);
            if (z11) {
                o.d("Hunter", "joined", kVar.a(), o.b(cVar2, "to "));
            }
            Picasso.Priority priority = aVar.f10517b.f10599r;
            if (priority.ordinal() > cVar2.D.ordinal()) {
                cVar2.D = priority;
                return;
            }
            return;
        }
        if (this.f10556b.isShutdown()) {
            if (aVar.f10516a.f10497l) {
                o.d("Dispatcher", "ignored", aVar.f10517b.a(), "because shut down");
                return;
            }
            return;
        }
        Picasso picasso = aVar.f10516a;
        sa.a aVar2 = this.f10564j;
        sa.h hVar = this.f10565k;
        Object obj = com.squareup.picasso.c.E;
        k kVar2 = aVar.f10517b;
        List<m> list = picasso.f10487b;
        int size = list.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                cVar = new com.squareup.picasso.c(picasso, this, aVar2, hVar, aVar, com.squareup.picasso.c.H);
                break;
            }
            m mVar = list.get(i10);
            if (mVar.canHandleRequest(kVar2)) {
                cVar = new com.squareup.picasso.c(picasso, this, aVar2, hVar, aVar, mVar);
                break;
            }
            i10++;
        }
        cVar.f10545y = this.f10556b.submit(cVar);
        this.f10558d.put(aVar.f10524i, cVar);
        if (z10) {
            this.f10559e.remove(aVar.b());
        }
        if (aVar.f10516a.f10497l) {
            o.c("Dispatcher", "enqueued", aVar.f10517b.a());
        }
    }
}
