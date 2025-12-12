package g2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.unity3d.ads.metadata.MediationMetaData;
import g2.g;
import g2.h;
import g2.j;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import r.x;

/* compiled from: MultiInstanceInvalidationClient.kt */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final String f12596a;

    /* renamed from: b, reason: collision with root package name */
    public final j f12597b;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f12598c;

    /* renamed from: d, reason: collision with root package name */
    public int f12599d;

    /* renamed from: e, reason: collision with root package name */
    public j.c f12600e;

    /* renamed from: f, reason: collision with root package name */
    public h f12601f;

    /* renamed from: g, reason: collision with root package name */
    public final b f12602g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f12603h;

    /* renamed from: i, reason: collision with root package name */
    public final k f12604i;

    /* renamed from: j, reason: collision with root package name */
    public final k f12605j;

    /* compiled from: MultiInstanceInvalidationClient.kt */
    public static final class a extends j.c {
        public a(String[] strArr) {
            super(strArr);
        }

        @Override // g2.j.c
        public boolean isRemote$room_runtime_release() {
            return true;
        }

        @Override // g2.j.c
        public void onInvalidated(Set<String> set) {
            zf.i.checkNotNullParameter(set, "tables");
            l lVar = l.this;
            if (lVar.getStopped().get()) {
                return;
            }
            try {
                h service = lVar.getService();
                if (service != null) {
                    int clientId = lVar.getClientId();
                    Object[] array = set.toArray(new String[0]);
                    zf.i.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    service.broadcastInvalidation(clientId, (String[]) array);
                }
            } catch (RemoteException e10) {
                Log.w("ROOM", "Cannot broadcast invalidation", e10);
            }
        }
    }

    /* compiled from: MultiInstanceInvalidationClient.kt */
    public static final class b extends g.a {

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f12607b = 0;

        public b() {
        }

        @Override // g2.g
        public void onInvalidation(String[] strArr) {
            zf.i.checkNotNullParameter(strArr, "tables");
            l lVar = l.this;
            lVar.getExecutor().execute(new x(5, lVar, strArr));
        }
    }

    /* compiled from: MultiInstanceInvalidationClient.kt */
    public static final class c implements ServiceConnection {
        public c() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            zf.i.checkNotNullParameter(componentName, MediationMetaData.KEY_NAME);
            zf.i.checkNotNullParameter(iBinder, "service");
            h hVarAsInterface = h.a.asInterface(iBinder);
            l lVar = l.this;
            lVar.setService(hVarAsInterface);
            lVar.getExecutor().execute(lVar.getSetUpRunnable());
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            zf.i.checkNotNullParameter(componentName, MediationMetaData.KEY_NAME);
            l lVar = l.this;
            lVar.getExecutor().execute(lVar.getRemoveObserverRunnable());
            lVar.setService(null);
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [g2.k] */
    /* JADX WARN: Type inference failed for: r0v6, types: [g2.k] */
    public l(Context context, String str, Intent intent, j jVar, Executor executor) {
        zf.i.checkNotNullParameter(context, "context");
        zf.i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        zf.i.checkNotNullParameter(intent, "serviceIntent");
        zf.i.checkNotNullParameter(jVar, "invalidationTracker");
        zf.i.checkNotNullParameter(executor, "executor");
        this.f12596a = str;
        this.f12597b = jVar;
        this.f12598c = executor;
        Context applicationContext = context.getApplicationContext();
        this.f12602g = new b();
        final int i10 = 0;
        this.f12603h = new AtomicBoolean(false);
        c cVar = new c();
        this.f12604i = new Runnable(this) { // from class: g2.k

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ l f12595m;

            {
                this.f12595m = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i11 = i10;
                l lVar = this.f12595m;
                switch (i11) {
                    case 0:
                        zf.i.checkNotNullParameter(lVar, "this$0");
                        try {
                            h hVar = lVar.f12601f;
                            if (hVar != null) {
                                lVar.f12599d = hVar.registerCallback(lVar.f12602g, lVar.f12596a);
                                lVar.f12597b.addObserver(lVar.getObserver());
                                break;
                            }
                        } catch (RemoteException e10) {
                            Log.w("ROOM", "Cannot register multi-instance invalidation callback", e10);
                        }
                        break;
                    default:
                        zf.i.checkNotNullParameter(lVar, "this$0");
                        lVar.f12597b.removeObserver(lVar.getObserver());
                        break;
                }
            }
        };
        final int i11 = 1;
        this.f12605j = new Runnable(this) { // from class: g2.k

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ l f12595m;

            {
                this.f12595m = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i112 = i11;
                l lVar = this.f12595m;
                switch (i112) {
                    case 0:
                        zf.i.checkNotNullParameter(lVar, "this$0");
                        try {
                            h hVar = lVar.f12601f;
                            if (hVar != null) {
                                lVar.f12599d = hVar.registerCallback(lVar.f12602g, lVar.f12596a);
                                lVar.f12597b.addObserver(lVar.getObserver());
                                break;
                            }
                        } catch (RemoteException e10) {
                            Log.w("ROOM", "Cannot register multi-instance invalidation callback", e10);
                        }
                        break;
                    default:
                        zf.i.checkNotNullParameter(lVar, "this$0");
                        lVar.f12597b.removeObserver(lVar.getObserver());
                        break;
                }
            }
        };
        Object[] array = jVar.getTableIdLookup$room_runtime_release().keySet().toArray(new String[0]);
        zf.i.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        setObserver(new a((String[]) array));
        applicationContext.bindService(intent, cVar, 1);
    }

    public final int getClientId() {
        return this.f12599d;
    }

    public final Executor getExecutor() {
        return this.f12598c;
    }

    public final j getInvalidationTracker() {
        return this.f12597b;
    }

    public final j.c getObserver() {
        j.c cVar = this.f12600e;
        if (cVar != null) {
            return cVar;
        }
        zf.i.throwUninitializedPropertyAccessException("observer");
        return null;
    }

    public final Runnable getRemoveObserverRunnable() {
        return this.f12605j;
    }

    public final h getService() {
        return this.f12601f;
    }

    public final Runnable getSetUpRunnable() {
        return this.f12604i;
    }

    public final AtomicBoolean getStopped() {
        return this.f12603h;
    }

    public final void setObserver(j.c cVar) {
        zf.i.checkNotNullParameter(cVar, "<set-?>");
        this.f12600e = cVar;
    }

    public final void setService(h hVar) {
        this.f12601f = hVar;
    }
}
