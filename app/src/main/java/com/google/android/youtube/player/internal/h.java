package com.google.android.youtube.player.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.internal.c;
import com.google.android.youtube.player.internal.e;
import com.google.android.youtube.player.internal.i;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class h<T extends IInterface> implements i {

    /* renamed from: a, reason: collision with root package name */
    public final Context f9575a;

    /* renamed from: b, reason: collision with root package name */
    public final b f9576b;

    /* renamed from: c, reason: collision with root package name */
    public T f9577c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList<i.a> f9578d;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList<i.b> f9581g;

    /* renamed from: i, reason: collision with root package name */
    public f f9583i;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList<i.a> f9579e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public boolean f9580f = false;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList<c<?>> f9582h = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    public boolean f9584j = false;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9585a;

        static {
            int[] iArr = new int[YouTubeInitializationResult.values().length];
            f9585a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 3) {
                h.this.a((YouTubeInitializationResult) message.obj);
                return;
            }
            if (i10 == 4) {
                synchronized (h.this.f9578d) {
                    h hVar = h.this;
                    if (hVar.f9584j && hVar.f() && h.this.f9578d.contains(message.obj)) {
                        ((i.a) message.obj).a();
                    }
                }
                return;
            }
            if (i10 != 2 || h.this.f()) {
                int i11 = message.what;
                if (i11 == 2 || i11 == 1) {
                    ((c) message.obj).a();
                }
            }
        }
    }

    public abstract class c<TListener> {

        /* renamed from: a, reason: collision with root package name */
        public TListener f9587a;

        public c(h hVar, TListener tlistener) {
            this.f9587a = tlistener;
            synchronized (hVar.f9582h) {
                hVar.f9582h.add(this);
            }
        }

        public final void a() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.f9587a;
            }
            a(tlistener);
        }

        public abstract void a(TListener tlistener);

        public final void b() {
            synchronized (this) {
                this.f9587a = null;
            }
        }
    }

    public final class d extends c<Boolean> {

        /* renamed from: b, reason: collision with root package name */
        public final YouTubeInitializationResult f9588b;

        /* renamed from: c, reason: collision with root package name */
        public final IBinder f9589c;

        public d(String str, IBinder iBinder) {
            super(h.this, Boolean.TRUE);
            YouTubeInitializationResult youTubeInitializationResultValueOf = YouTubeInitializationResult.UNKNOWN_ERROR;
            try {
                youTubeInitializationResultValueOf = YouTubeInitializationResult.valueOf(str);
            } catch (IllegalArgumentException | NullPointerException unused) {
            }
            this.f9588b = youTubeInitializationResultValueOf;
            this.f9589c = iBinder;
        }

        @Override // com.google.android.youtube.player.internal.h.c
        public final /* synthetic */ void a(Boolean bool) throws RemoteException {
            IBinder iBinder = this.f9589c;
            if (bool != null) {
                int[] iArr = a.f9585a;
                YouTubeInitializationResult youTubeInitializationResult = this.f9588b;
                int i10 = iArr[youTubeInitializationResult.ordinal()];
                h hVar = h.this;
                if (i10 != 1) {
                    hVar.a(youTubeInitializationResult);
                    return;
                }
                try {
                    if (hVar.b().equals(iBinder.getInterfaceDescriptor())) {
                        hVar.f9577c = (T) hVar.a(iBinder);
                        if (hVar.f9577c != null) {
                            hVar.g();
                            return;
                        }
                    }
                } catch (RemoteException unused) {
                }
                hVar.k();
                hVar.a(YouTubeInitializationResult.INTERNAL_ERROR);
            }
        }
    }

    public final class e extends c.a {
        public e() {
        }

        public final void a(String str, IBinder iBinder) {
            h hVar = h.this;
            b bVar = hVar.f9576b;
            bVar.sendMessage(bVar.obtainMessage(1, new d(str, iBinder)));
        }
    }

    public final class f implements ServiceConnection {
        public f() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            h.this.b(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            h hVar = h.this;
            hVar.f9577c = null;
            hVar.h();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(Context context, i.a aVar, i.b bVar) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Clients must be created on the UI thread.");
        }
        this.f9575a = (Context) a8.a.a(context);
        ArrayList<i.a> arrayList = new ArrayList<>();
        this.f9578d = arrayList;
        arrayList.add(a8.a.a(aVar));
        ArrayList<i.b> arrayList2 = new ArrayList<>();
        this.f9581g = arrayList2;
        arrayList2.add(a8.a.a(bVar));
        this.f9576b = new b();
    }

    public abstract T a(IBinder iBinder);

    public final void a(YouTubeInitializationResult youTubeInitializationResult) {
        this.f9576b.removeMessages(4);
        synchronized (this.f9581g) {
            ArrayList<i.b> arrayList = this.f9581g;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (!this.f9584j) {
                    return;
                }
                if (this.f9581g.contains(arrayList.get(i10))) {
                    arrayList.get(i10).a(youTubeInitializationResult);
                }
            }
        }
    }

    public abstract void a(com.google.android.youtube.player.internal.e eVar, e eVar2) throws RemoteException;

    public abstract String b();

    public final void b(IBinder iBinder) {
        try {
            a(e.a.a(iBinder), new e());
        } catch (RemoteException unused) {
            Log.w("YouTubeClient", "service died");
        }
    }

    public abstract String c();

    @Override // com.google.android.youtube.player.internal.i
    public void d() {
        h();
        this.f9584j = false;
        synchronized (this.f9582h) {
            int size = this.f9582h.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f9582h.get(i10).b();
            }
            this.f9582h.clear();
        }
        k();
    }

    @Override // com.google.android.youtube.player.internal.i
    public final void e() {
        this.f9584j = true;
        Context context = this.f9575a;
        YouTubeInitializationResult youTubeInitializationResultIsYouTubeApiServiceAvailable = z7.a.isYouTubeApiServiceAvailable(context);
        YouTubeInitializationResult youTubeInitializationResult = YouTubeInitializationResult.SUCCESS;
        b bVar = this.f9576b;
        if (youTubeInitializationResultIsYouTubeApiServiceAvailable != youTubeInitializationResult) {
            bVar.sendMessage(bVar.obtainMessage(3, youTubeInitializationResultIsYouTubeApiServiceAvailable));
            return;
        }
        Intent intent = new Intent(c()).setPackage(a8.h.a(context));
        if (this.f9583i != null) {
            Log.e("YouTubeClient", "Calling connect() while still connected, missing disconnect().");
            k();
        }
        f fVar = new f();
        this.f9583i = fVar;
        if (context.bindService(intent, fVar, 129)) {
            return;
        }
        bVar.sendMessage(bVar.obtainMessage(3, YouTubeInitializationResult.ERROR_CONNECTING_TO_SERVICE));
    }

    public final boolean f() {
        return this.f9577c != null;
    }

    public final void g() {
        synchronized (this.f9578d) {
            boolean z10 = true;
            a8.a.a(!this.f9580f);
            this.f9576b.removeMessages(4);
            this.f9580f = true;
            if (this.f9579e.size() != 0) {
                z10 = false;
            }
            a8.a.a(z10);
            ArrayList<i.a> arrayList = this.f9578d;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size && this.f9584j && f(); i10++) {
                if (!this.f9579e.contains(arrayList.get(i10))) {
                    arrayList.get(i10).a();
                }
            }
            this.f9579e.clear();
            this.f9580f = false;
        }
    }

    public final void h() {
        this.f9576b.removeMessages(4);
        synchronized (this.f9578d) {
            this.f9580f = true;
            ArrayList<i.a> arrayList = this.f9578d;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size && this.f9584j; i10++) {
                if (this.f9578d.contains(arrayList.get(i10))) {
                    arrayList.get(i10).b();
                }
            }
            this.f9580f = false;
        }
    }

    public final void i() {
        if (!f()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T j() {
        i();
        return this.f9577c;
    }

    public final void k() {
        f fVar = this.f9583i;
        if (fVar != null) {
            try {
                this.f9575a.unbindService(fVar);
            } catch (IllegalArgumentException e10) {
                Log.w("YouTubeClient", "Unexpected error from unbindService()", e10);
            }
        }
        this.f9577c = null;
        this.f9583i = null;
    }
}
