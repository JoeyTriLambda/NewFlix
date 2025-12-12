package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import g2.g;
import g2.h;
import java.util.LinkedHashMap;
import java.util.Map;
import zf.i;

/* compiled from: MultiInstanceInvalidationService.kt */
/* loaded from: classes.dex */
public final class MultiInstanceInvalidationService extends Service {

    /* renamed from: b, reason: collision with root package name */
    public int f4266b;

    /* renamed from: m, reason: collision with root package name */
    public final LinkedHashMap f4267m = new LinkedHashMap();

    /* renamed from: n, reason: collision with root package name */
    public final b f4268n = new b();

    /* renamed from: o, reason: collision with root package name */
    public final a f4269o = new a();

    /* compiled from: MultiInstanceInvalidationService.kt */
    public static final class a extends h.a {
        public a() {
        }

        @Override // g2.h
        public void broadcastInvalidation(int i10, String[] strArr) {
            i.checkNotNullParameter(strArr, "tables");
            RemoteCallbackList<g> callbackList$room_runtime_release = MultiInstanceInvalidationService.this.getCallbackList$room_runtime_release();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (callbackList$room_runtime_release) {
                String str = multiInstanceInvalidationService.getClientNames$room_runtime_release().get(Integer.valueOf(i10));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int iBeginBroadcast = multiInstanceInvalidationService.getCallbackList$room_runtime_release().beginBroadcast();
                for (int i11 = 0; i11 < iBeginBroadcast; i11++) {
                    try {
                        Object broadcastCookie = multiInstanceInvalidationService.getCallbackList$room_runtime_release().getBroadcastCookie(i11);
                        i.checkNotNull(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                        int iIntValue = ((Integer) broadcastCookie).intValue();
                        String str2 = multiInstanceInvalidationService.getClientNames$room_runtime_release().get(Integer.valueOf(iIntValue));
                        if (i10 != iIntValue && i.areEqual(str, str2)) {
                            try {
                                ((g) multiInstanceInvalidationService.getCallbackList$room_runtime_release().getBroadcastItem(i11)).onInvalidation(strArr);
                            } catch (RemoteException e10) {
                                Log.w("ROOM", "Error invoking a remote callback", e10);
                            }
                        }
                    } catch (Throwable th2) {
                        multiInstanceInvalidationService.getCallbackList$room_runtime_release().finishBroadcast();
                        throw th2;
                    }
                }
                multiInstanceInvalidationService.getCallbackList$room_runtime_release().finishBroadcast();
                lf.h hVar = lf.h.f16056a;
            }
        }

        @Override // g2.h
        public int registerCallback(g gVar, String str) {
            i.checkNotNullParameter(gVar, "callback");
            int i10 = 0;
            if (str == null) {
                return 0;
            }
            RemoteCallbackList<g> callbackList$room_runtime_release = MultiInstanceInvalidationService.this.getCallbackList$room_runtime_release();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (callbackList$room_runtime_release) {
                multiInstanceInvalidationService.setMaxClientId$room_runtime_release(multiInstanceInvalidationService.getMaxClientId$room_runtime_release() + 1);
                int maxClientId$room_runtime_release = multiInstanceInvalidationService.getMaxClientId$room_runtime_release();
                if (multiInstanceInvalidationService.getCallbackList$room_runtime_release().register(gVar, Integer.valueOf(maxClientId$room_runtime_release))) {
                    multiInstanceInvalidationService.getClientNames$room_runtime_release().put(Integer.valueOf(maxClientId$room_runtime_release), str);
                    i10 = maxClientId$room_runtime_release;
                } else {
                    multiInstanceInvalidationService.setMaxClientId$room_runtime_release(multiInstanceInvalidationService.getMaxClientId$room_runtime_release() - 1);
                    multiInstanceInvalidationService.getMaxClientId$room_runtime_release();
                }
            }
            return i10;
        }

        @Override // g2.h
        public void unregisterCallback(g gVar, int i10) {
            i.checkNotNullParameter(gVar, "callback");
            RemoteCallbackList<g> callbackList$room_runtime_release = MultiInstanceInvalidationService.this.getCallbackList$room_runtime_release();
            MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
            synchronized (callbackList$room_runtime_release) {
                multiInstanceInvalidationService.getCallbackList$room_runtime_release().unregister(gVar);
                multiInstanceInvalidationService.getClientNames$room_runtime_release().remove(Integer.valueOf(i10));
            }
        }
    }

    /* compiled from: MultiInstanceInvalidationService.kt */
    public static final class b extends RemoteCallbackList<g> {
        public b() {
        }

        @Override // android.os.RemoteCallbackList
        public void onCallbackDied(g gVar, Object obj) {
            i.checkNotNullParameter(gVar, "callback");
            i.checkNotNullParameter(obj, "cookie");
            MultiInstanceInvalidationService.this.getClientNames$room_runtime_release().remove((Integer) obj);
        }
    }

    public final RemoteCallbackList<g> getCallbackList$room_runtime_release() {
        return this.f4268n;
    }

    public final Map<Integer, String> getClientNames$room_runtime_release() {
        return this.f4267m;
    }

    public final int getMaxClientId$room_runtime_release() {
        return this.f4266b;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        i.checkNotNullParameter(intent, "intent");
        return this.f4269o;
    }

    public final void setMaxClientId$room_runtime_release(int i10) {
        this.f4266b = i10;
    }
}
