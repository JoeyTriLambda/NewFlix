package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import b0.d;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public class GoogleApiManager implements Handler.Callback {
    public static final Status A = new Status(4, "Sign-out occurred while this API call was in progress.");
    public static final Status B = new Status(4, "The user must be signed in to make this API call.");
    public static final Object C = new Object();
    public static GoogleApiManager D;

    /* renamed from: n, reason: collision with root package name */
    public TelemetryData f7090n;

    /* renamed from: o, reason: collision with root package name */
    public TelemetryLoggingClient f7091o;

    /* renamed from: p, reason: collision with root package name */
    public final Context f7092p;

    /* renamed from: q, reason: collision with root package name */
    public final GoogleApiAvailability f7093q;

    /* renamed from: r, reason: collision with root package name */
    public final com.google.android.gms.common.internal.zal f7094r;

    /* renamed from: y, reason: collision with root package name */
    public final com.google.android.gms.internal.base.zaq f7101y;

    /* renamed from: z, reason: collision with root package name */
    public volatile boolean f7102z;

    /* renamed from: b, reason: collision with root package name */
    public long f7088b = 10000;

    /* renamed from: m, reason: collision with root package name */
    public boolean f7089m = false;

    /* renamed from: s, reason: collision with root package name */
    public final AtomicInteger f7095s = new AtomicInteger(1);

    /* renamed from: t, reason: collision with root package name */
    public final AtomicInteger f7096t = new AtomicInteger(0);

    /* renamed from: u, reason: collision with root package name */
    public final ConcurrentHashMap f7097u = new ConcurrentHashMap(5, 0.75f, 1);

    /* renamed from: v, reason: collision with root package name */
    public zaae f7098v = null;

    /* renamed from: w, reason: collision with root package name */
    public final d f7099w = new d();

    /* renamed from: x, reason: collision with root package name */
    public final d f7100x = new d();

    @KeepForSdk
    public GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.f7102z = true;
        this.f7092p = context;
        com.google.android.gms.internal.base.zaq zaqVar = new com.google.android.gms.internal.base.zaq(looper, this);
        this.f7101y = zaqVar;
        this.f7093q = googleApiAvailability;
        this.f7094r = new com.google.android.gms.common.internal.zal(googleApiAvailability);
        if (DeviceProperties.isAuto(context)) {
            this.f7102z = false;
        }
        zaqVar.sendMessage(zaqVar.obtainMessage(6));
    }

    public static Status b(ApiKey<?> apiKey, ConnectionResult connectionResult) {
        String strZab = apiKey.zab();
        String strValueOf = String.valueOf(connectionResult);
        StringBuilder sb2 = new StringBuilder(String.valueOf(strZab).length() + 63 + strValueOf.length());
        sb2.append("API: ");
        sb2.append(strZab);
        sb2.append(" is not available on this device. Connection failed with: ");
        sb2.append(strValueOf);
        return new Status(connectionResult, sb2.toString());
    }

    public static GoogleApiManager zam(Context context) {
        GoogleApiManager googleApiManager;
        synchronized (C) {
            if (D == null) {
                D = new GoogleApiManager(context.getApplicationContext(), GmsClientSupervisor.getOrStartHandlerThread().getLooper(), GoogleApiAvailability.getInstance());
            }
            googleApiManager = D;
        }
        return googleApiManager;
    }

    public final boolean a() {
        if (this.f7089m) {
            return false;
        }
        RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
        if (config != null && !config.getMethodInvocationTelemetryEnabled()) {
            return false;
        }
        int iZaa = this.f7094r.zaa(this.f7092p, 203400000);
        return iZaa == -1 || iZaa == 0;
    }

    public final zabq<?> c(GoogleApi<?> googleApi) {
        Object apiKey = googleApi.getApiKey();
        ConcurrentHashMap concurrentHashMap = this.f7097u;
        zabq<?> zabqVar = (zabq) concurrentHashMap.get(apiKey);
        if (zabqVar == null) {
            zabqVar = new zabq<>(this, googleApi);
            concurrentHashMap.put(apiKey, zabqVar);
        }
        if (zabqVar.zaz()) {
            this.f7100x.add(apiKey);
        }
        zabqVar.zao();
        return zabqVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <T> void d(com.google.android.gms.tasks.TaskCompletionSource<T> r9, int r10, com.google.android.gms.common.api.GoogleApi r11) {
        /*
            r8 = this;
            if (r10 == 0) goto L8a
            com.google.android.gms.common.api.internal.ApiKey r3 = r11.getApiKey()
            boolean r11 = r8.a()
            if (r11 != 0) goto Ld
            goto L4e
        Ld:
            com.google.android.gms.common.internal.RootTelemetryConfigManager r11 = com.google.android.gms.common.internal.RootTelemetryConfigManager.getInstance()
            com.google.android.gms.common.internal.RootTelemetryConfiguration r11 = r11.getConfig()
            r0 = 1
            if (r11 == 0) goto L5b
            boolean r1 = r11.getMethodInvocationTelemetryEnabled()
            if (r1 != 0) goto L1f
            goto L4e
        L1f:
            boolean r11 = r11.getMethodTimingTelemetryEnabled()
            java.util.concurrent.ConcurrentHashMap r1 = r8.f7097u
            java.lang.Object r1 = r1.get(r3)
            com.google.android.gms.common.api.internal.zabq r1 = (com.google.android.gms.common.api.internal.zabq) r1
            if (r1 == 0) goto L5a
            com.google.android.gms.common.api.Api$Client r2 = r1.zaf()
            boolean r2 = r2 instanceof com.google.android.gms.common.internal.BaseGmsClient
            if (r2 != 0) goto L36
            goto L4e
        L36:
            com.google.android.gms.common.api.Api$Client r2 = r1.zaf()
            com.google.android.gms.common.internal.BaseGmsClient r2 = (com.google.android.gms.common.internal.BaseGmsClient) r2
            boolean r4 = r2.hasConnectionInfo()
            if (r4 == 0) goto L5a
            boolean r4 = r2.isConnecting()
            if (r4 != 0) goto L5a
            com.google.android.gms.common.internal.ConnectionTelemetryConfiguration r11 = com.google.android.gms.common.api.internal.zacd.a(r1, r2, r10)
            if (r11 != 0) goto L50
        L4e:
            r10 = 0
            goto L77
        L50:
            int r2 = r1.f7195l
            int r2 = r2 + r0
            r1.f7195l = r2
            boolean r0 = r11.getMethodTimingTelemetryEnabled()
            goto L5b
        L5a:
            r0 = r11
        L5b:
            com.google.android.gms.common.api.internal.zacd r11 = new com.google.android.gms.common.api.internal.zacd
            r1 = 0
            if (r0 == 0) goto L66
            long r4 = java.lang.System.currentTimeMillis()
            goto L67
        L66:
            r4 = r1
        L67:
            if (r0 == 0) goto L6f
            long r0 = android.os.SystemClock.elapsedRealtime()
            r6 = r0
            goto L70
        L6f:
            r6 = r1
        L70:
            r0 = r11
            r1 = r8
            r2 = r10
            r0.<init>(r1, r2, r3, r4, r6)
            r10 = r11
        L77:
            if (r10 == 0) goto L8a
            com.google.android.gms.tasks.Task r9 = r9.getTask()
            com.google.android.gms.internal.base.zaq r11 = r8.f7101y
            r11.getClass()
            com.google.android.gms.common.api.internal.zabk r0 = new com.google.android.gms.common.api.internal.zabk
            r0.<init>()
            r9.addOnCompleteListener(r0, r10)
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.GoogleApiManager.d(com.google.android.gms.tasks.TaskCompletionSource, int, com.google.android.gms.common.api.GoogleApi):void");
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Feature[] featureArrZab;
        int i10 = message.what;
        com.google.android.gms.internal.base.zaq zaqVar = this.f7101y;
        ConcurrentHashMap concurrentHashMap = this.f7097u;
        Context context = this.f7092p;
        zabq zabqVar = null;
        switch (i10) {
            case 1:
                this.f7088b = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                zaqVar.removeMessages(12);
                Iterator it = concurrentHashMap.keySet().iterator();
                while (it.hasNext()) {
                    zaqVar.sendMessageDelayed(zaqVar.obtainMessage(12, (ApiKey) it.next()), this.f7088b);
                }
                return true;
            case 2:
                zal zalVar = (zal) message.obj;
                Iterator<ApiKey<?>> it2 = zalVar.zab().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        ApiKey<?> next = it2.next();
                        zabq zabqVar2 = (zabq) concurrentHashMap.get(next);
                        if (zabqVar2 == null) {
                            zalVar.zac(next, new ConnectionResult(13), null);
                        } else if (zabqVar2.f7185b.isConnected()) {
                            zalVar.zac(next, ConnectionResult.f7014p, zabqVar2.zaf().getEndpointPackageName());
                        } else {
                            ConnectionResult connectionResultZad = zabqVar2.zad();
                            if (connectionResultZad != null) {
                                zalVar.zac(next, connectionResultZad, null);
                            } else {
                                zabqVar2.zat(zalVar);
                                zabqVar2.zao();
                            }
                        }
                    }
                }
                return true;
            case 3:
                for (zabq zabqVar3 : concurrentHashMap.values()) {
                    zabqVar3.zan();
                    zabqVar3.zao();
                }
                return true;
            case 4:
            case 8:
            case 13:
                zach zachVar = (zach) message.obj;
                zabq<?> zabqVarC = (zabq) concurrentHashMap.get(zachVar.f7224c.getApiKey());
                if (zabqVarC == null) {
                    zabqVarC = c(zachVar.f7224c);
                }
                boolean zZaz = zabqVarC.zaz();
                zai zaiVar = zachVar.f7222a;
                if (!zZaz || this.f7096t.get() == zachVar.f7223b) {
                    zabqVarC.zap(zaiVar);
                } else {
                    zaiVar.zad(A);
                    zabqVarC.zav();
                }
                return true;
            case 5:
                int i11 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator it3 = concurrentHashMap.values().iterator();
                while (true) {
                    if (it3.hasNext()) {
                        zabq zabqVar4 = (zabq) it3.next();
                        if (zabqVar4.zab() == i11) {
                            zabqVar = zabqVar4;
                        }
                    }
                }
                if (zabqVar == null) {
                    StringBuilder sb2 = new StringBuilder(76);
                    sb2.append("Could not find API instance ");
                    sb2.append(i11);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                } else if (connectionResult.getErrorCode() == 13) {
                    String errorString = this.f7093q.getErrorString(connectionResult.getErrorCode());
                    String errorMessage = connectionResult.getErrorMessage();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(errorString).length() + 69 + String.valueOf(errorMessage).length());
                    sb3.append("Error resolution was canceled by the user, original error message: ");
                    sb3.append(errorString);
                    sb3.append(": ");
                    sb3.append(errorMessage);
                    zabqVar.c(new Status(17, sb3.toString()));
                } else {
                    zabqVar.c(b(zabqVar.f7186c, connectionResult));
                }
                return true;
            case 6:
                if (context.getApplicationContext() instanceof Application) {
                    BackgroundDetector.initialize((Application) context.getApplicationContext());
                    BackgroundDetector.getInstance().addListener(new zabl(this));
                    if (!BackgroundDetector.getInstance().readCurrentStateIfPossible(true)) {
                        this.f7088b = 300000L;
                    }
                }
                return true;
            case 7:
                c((GoogleApi) message.obj);
                return true;
            case 9:
                if (concurrentHashMap.containsKey(message.obj)) {
                    ((zabq) concurrentHashMap.get(message.obj)).zau();
                }
                return true;
            case 10:
                d dVar = this.f7100x;
                Iterator<E> it4 = dVar.iterator();
                while (it4.hasNext()) {
                    zabq zabqVar5 = (zabq) concurrentHashMap.remove((ApiKey) it4.next());
                    if (zabqVar5 != null) {
                        zabqVar5.zav();
                    }
                }
                dVar.clear();
                return true;
            case 11:
                if (concurrentHashMap.containsKey(message.obj)) {
                    ((zabq) concurrentHashMap.get(message.obj)).zaw();
                }
                return true;
            case 12:
                if (concurrentHashMap.containsKey(message.obj)) {
                    ((zabq) concurrentHashMap.get(message.obj)).zaA();
                }
                return true;
            case 14:
                zaaf zaafVar = (zaaf) message.obj;
                ApiKey<?> apiKeyZaa = zaafVar.zaa();
                if (concurrentHashMap.containsKey(apiKeyZaa)) {
                    zaafVar.zab().setResult(Boolean.valueOf(((zabq) concurrentHashMap.get(apiKeyZaa)).k(false)));
                } else {
                    zaafVar.zab().setResult(Boolean.FALSE);
                }
                return true;
            case 15:
                zabs zabsVar = (zabs) message.obj;
                if (concurrentHashMap.containsKey(zabsVar.f7197a)) {
                    zabq zabqVar6 = (zabq) concurrentHashMap.get(zabsVar.f7197a);
                    if (zabqVar6.f7193j.contains(zabsVar) && !zabqVar6.f7192i) {
                        if (zabqVar6.f7185b.isConnected()) {
                            zabqVar6.e();
                        } else {
                            zabqVar6.zao();
                        }
                    }
                }
                return true;
            case 16:
                zabs zabsVar2 = (zabs) message.obj;
                if (concurrentHashMap.containsKey(zabsVar2.f7197a)) {
                    zabq<?> zabqVar7 = (zabq) concurrentHashMap.get(zabsVar2.f7197a);
                    if (zabqVar7.f7193j.remove(zabsVar2)) {
                        GoogleApiManager googleApiManager = zabqVar7.f7196m;
                        googleApiManager.f7101y.removeMessages(15, zabsVar2);
                        googleApiManager.f7101y.removeMessages(16, zabsVar2);
                        LinkedList linkedList = zabqVar7.f7184a;
                        ArrayList arrayList = new ArrayList(linkedList.size());
                        Iterator it5 = linkedList.iterator();
                        while (true) {
                            boolean zHasNext = it5.hasNext();
                            Feature feature = zabsVar2.f7198b;
                            if (zHasNext) {
                                zai zaiVar2 = (zai) it5.next();
                                if ((zaiVar2 instanceof zac) && (featureArrZab = ((zac) zaiVar2).zab(zabqVar7)) != null && ArrayUtils.contains(featureArrZab, feature)) {
                                    arrayList.add(zaiVar2);
                                }
                            } else {
                                int size = arrayList.size();
                                for (int i12 = 0; i12 < size; i12++) {
                                    zai zaiVar3 = (zai) arrayList.get(i12);
                                    linkedList.remove(zaiVar3);
                                    zaiVar3.zae(new UnsupportedApiCallException(feature));
                                }
                            }
                        }
                    }
                }
                return true;
            case 17:
                TelemetryData telemetryData = this.f7090n;
                if (telemetryData != null) {
                    if (telemetryData.zaa() > 0 || a()) {
                        if (this.f7091o == null) {
                            this.f7091o = TelemetryLogging.getClient(context);
                        }
                        this.f7091o.log(telemetryData);
                    }
                    this.f7090n = null;
                }
                return true;
            case 18:
                zace zaceVar = (zace) message.obj;
                long j10 = zaceVar.f7217c;
                MethodInvocation methodInvocation = zaceVar.f7215a;
                int i13 = zaceVar.f7216b;
                if (j10 == 0) {
                    TelemetryData telemetryData2 = new TelemetryData(i13, Arrays.asList(methodInvocation));
                    if (this.f7091o == null) {
                        this.f7091o = TelemetryLogging.getClient(context);
                    }
                    this.f7091o.log(telemetryData2);
                } else {
                    TelemetryData telemetryData3 = this.f7090n;
                    if (telemetryData3 != null) {
                        List<MethodInvocation> listZab = telemetryData3.zab();
                        if (telemetryData3.zaa() != i13 || (listZab != null && listZab.size() >= zaceVar.f7218d)) {
                            zaqVar.removeMessages(17);
                            TelemetryData telemetryData4 = this.f7090n;
                            if (telemetryData4 != null) {
                                if (telemetryData4.zaa() > 0 || a()) {
                                    if (this.f7091o == null) {
                                        this.f7091o = TelemetryLogging.getClient(context);
                                    }
                                    this.f7091o.log(telemetryData4);
                                }
                                this.f7090n = null;
                            }
                        } else {
                            this.f7090n.zac(methodInvocation);
                        }
                    }
                    if (this.f7090n == null) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(methodInvocation);
                        this.f7090n = new TelemetryData(i13, arrayList2);
                        zaqVar.sendMessageDelayed(zaqVar.obtainMessage(17), zaceVar.f7217c);
                    }
                }
                return true;
            case 19:
                this.f7089m = false;
                return true;
            default:
                StringBuilder sb4 = new StringBuilder(31);
                sb4.append("Unknown message id: ");
                sb4.append(i10);
                Log.w("GoogleApiManager", sb4.toString());
                return false;
        }
    }

    public final void zaA() {
        com.google.android.gms.internal.base.zaq zaqVar = this.f7101y;
        zaqVar.sendMessage(zaqVar.obtainMessage(3));
    }

    public final void zaB(GoogleApi<?> googleApi) {
        com.google.android.gms.internal.base.zaq zaqVar = this.f7101y;
        zaqVar.sendMessage(zaqVar.obtainMessage(7, googleApi));
    }

    public final void zaC(zaae zaaeVar) {
        synchronized (C) {
            if (this.f7098v != zaaeVar) {
                this.f7098v = zaaeVar;
                this.f7099w.clear();
            }
            d dVar = this.f7099w;
            zaaeVar.getClass();
            dVar.addAll(null);
        }
    }

    public final int zaa() {
        return this.f7095s.getAndIncrement();
    }

    public final <O extends Api.ApiOptions> Task<Void> zaq(GoogleApi<O> googleApi, RegisterListenerMethod<Api.AnyClient, ?> registerListenerMethod, UnregisterListenerMethod<Api.AnyClient, ?> unregisterListenerMethod, Runnable runnable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        d(taskCompletionSource, registerListenerMethod.zaa(), googleApi);
        zaf zafVar = new zaf(new zaci(registerListenerMethod, unregisterListenerMethod, runnable), taskCompletionSource);
        com.google.android.gms.internal.base.zaq zaqVar = this.f7101y;
        zaqVar.sendMessage(zaqVar.obtainMessage(8, new zach(zafVar, this.f7096t.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final <O extends Api.ApiOptions> Task<Boolean> zar(GoogleApi<O> googleApi, ListenerHolder.ListenerKey listenerKey, int i10) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        d(taskCompletionSource, i10, googleApi);
        zah zahVar = new zah(listenerKey, taskCompletionSource);
        com.google.android.gms.internal.base.zaq zaqVar = this.f7101y;
        zaqVar.sendMessage(zaqVar.obtainMessage(13, new zach(zahVar, this.f7096t.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final <O extends Api.ApiOptions> void zaw(GoogleApi<O> googleApi, int i10, BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient> apiMethodImpl) {
        zae zaeVar = new zae(i10, apiMethodImpl);
        com.google.android.gms.internal.base.zaq zaqVar = this.f7101y;
        zaqVar.sendMessage(zaqVar.obtainMessage(4, new zach(zaeVar, this.f7096t.get(), googleApi)));
    }

    public final <O extends Api.ApiOptions, ResultT> void zax(GoogleApi<O> googleApi, int i10, TaskApiCall<Api.AnyClient, ResultT> taskApiCall, TaskCompletionSource<ResultT> taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        d(taskCompletionSource, taskApiCall.zaa(), googleApi);
        zag zagVar = new zag(i10, taskApiCall, taskCompletionSource, statusExceptionMapper);
        com.google.android.gms.internal.base.zaq zaqVar = this.f7101y;
        zaqVar.sendMessage(zaqVar.obtainMessage(4, new zach(zagVar, this.f7096t.get(), googleApi)));
    }

    public final void zaz(ConnectionResult connectionResult, int i10) {
        if (this.f7093q.zah(this.f7092p, connectionResult, i10)) {
            return;
        }
        com.google.android.gms.internal.base.zaq zaqVar = this.f7101y;
        zaqVar.sendMessage(zaqVar.obtainMessage(5, i10, 0, connectionResult));
    }
}
