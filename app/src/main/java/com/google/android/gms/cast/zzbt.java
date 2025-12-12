package com.google.android.gms.cast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzed;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes.dex */
public final class zzbt extends GoogleApi implements zzr {
    public static final Logger F = new Logger("CastClient");
    public static final Api G = new Api("Cast.API_CXLESS", new zzbk(), com.google.android.gms.cast.internal.zzak.f6817b);
    public final HashMap A;
    public final HashMap B;
    public final Cast.Listener C;
    public final List D;
    public int E;

    /* renamed from: j, reason: collision with root package name */
    public final zzbs f6977j;

    /* renamed from: k, reason: collision with root package name */
    public zzed f6978k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f6979l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f6980m;

    /* renamed from: n, reason: collision with root package name */
    public TaskCompletionSource f6981n;

    /* renamed from: o, reason: collision with root package name */
    public TaskCompletionSource f6982o;

    /* renamed from: p, reason: collision with root package name */
    public final AtomicLong f6983p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f6984q;

    /* renamed from: r, reason: collision with root package name */
    public final Object f6985r;

    /* renamed from: s, reason: collision with root package name */
    public ApplicationMetadata f6986s;

    /* renamed from: t, reason: collision with root package name */
    public String f6987t;

    /* renamed from: u, reason: collision with root package name */
    public double f6988u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f6989v;

    /* renamed from: w, reason: collision with root package name */
    public int f6990w;

    /* renamed from: x, reason: collision with root package name */
    public int f6991x;

    /* renamed from: y, reason: collision with root package name */
    public zzav f6992y;

    /* renamed from: z, reason: collision with root package name */
    public final CastDevice f6993z;

    public zzbt(Context context, Cast.CastOptions castOptions) {
        super(context, G, castOptions, GoogleApi.Settings.f7061c);
        this.f6977j = new zzbs(this);
        this.f6984q = new Object();
        this.f6985r = new Object();
        this.D = Collections.synchronizedList(new ArrayList());
        Preconditions.checkNotNull(context, "context cannot be null");
        Preconditions.checkNotNull(castOptions, "CastOptions cannot be null");
        this.C = castOptions.f6140m;
        this.f6993z = castOptions.f6139b;
        this.A = new HashMap();
        this.B = new HashMap();
        this.f6983p = new AtomicLong(0L);
        this.E = 1;
        f();
    }

    public static void b(zzbt zzbtVar, long j10, int i10) {
        TaskCompletionSource taskCompletionSource;
        synchronized (zzbtVar.A) {
            HashMap map = zzbtVar.A;
            Long lValueOf = Long.valueOf(j10);
            taskCompletionSource = (TaskCompletionSource) map.get(lValueOf);
            zzbtVar.A.remove(lValueOf);
        }
        if (taskCompletionSource != null) {
            if (i10 == 0) {
                taskCompletionSource.setResult(null);
            } else {
                taskCompletionSource.setException(ApiExceptionUtil.fromStatus(new Status(i10)));
            }
        }
    }

    public static void c(zzbt zzbtVar, int i10) {
        synchronized (zzbtVar.f6985r) {
            TaskCompletionSource taskCompletionSource = zzbtVar.f6982o;
            if (taskCompletionSource == null) {
                return;
            }
            if (i10 == 0) {
                taskCompletionSource.setResult(new Status(0));
            } else {
                taskCompletionSource.setException(ApiExceptionUtil.fromStatus(new Status(i10)));
            }
            zzbtVar.f6982o = null;
        }
    }

    public static /* bridge */ /* synthetic */ Handler g(zzbt zzbtVar) {
        if (zzbtVar.f6978k == null) {
            zzbtVar.f6978k = new zzed(zzbtVar.getLooper());
        }
        return zzbtVar.f6978k;
    }

    public final void d() {
        F.d("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.B) {
            this.B.clear();
        }
    }

    public final void e(int i10) {
        synchronized (this.f6984q) {
            TaskCompletionSource taskCompletionSource = this.f6981n;
            if (taskCompletionSource != null) {
                taskCompletionSource.setException(ApiExceptionUtil.fromStatus(new Status(i10)));
            }
            this.f6981n = null;
        }
    }

    public final void f() {
        CastDevice castDevice = this.f6993z;
        if (castDevice.hasCapability(2048) || !castDevice.hasCapability(4) || castDevice.hasCapability(1)) {
            return;
        }
        "Chromecast Audio".equals(castDevice.getModelName());
    }

    @Override // com.google.android.gms.cast.zzr
    public final Task zze() {
        ListenerHolder listenerHolderRegisterListener = registerListener(this.f6977j, "castDeviceControllerListenerKey");
        RegistrationMethods.Builder builder = RegistrationMethods.builder();
        return doRegisterEventListener(builder.withHolder(listenerHolderRegisterListener).register(new RemoteCall() { // from class: com.google.android.gms.cast.zzbe
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                com.google.android.gms.cast.internal.zzx zzxVar = (com.google.android.gms.cast.internal.zzx) obj;
                ((com.google.android.gms.cast.internal.zzag) zzxVar.getService()).zzj(this.f6951a.f6977j);
                ((com.google.android.gms.cast.internal.zzag) zzxVar.getService()).zze();
                ((TaskCompletionSource) obj2).setResult(null);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.cast.zzbf
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                Logger logger = zzbt.F;
                ((com.google.android.gms.cast.internal.zzag) ((com.google.android.gms.cast.internal.zzx) obj).getService()).zzq();
                ((TaskCompletionSource) obj2).setResult(Boolean.TRUE);
            }
        }).setFeatures(zzax.f6934a).setMethodKey(8428).build());
    }

    @Override // com.google.android.gms.cast.zzr
    public final Task zzf() {
        Task taskDoWrite = doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.cast.zzba
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                Logger logger = zzbt.F;
                ((com.google.android.gms.cast.internal.zzag) ((com.google.android.gms.cast.internal.zzx) obj).getService()).zzf();
                ((TaskCompletionSource) obj2).setResult(null);
            }
        }).setMethodKey(8403).build());
        d();
        doUnregisterEventListener((ListenerHolder.ListenerKey) Preconditions.checkNotNull(registerListener(this.f6977j, "castDeviceControllerListenerKey").getListenerKey(), "Key must not be null"), 8415);
        return taskDoWrite;
    }

    @Override // com.google.android.gms.cast.zzr
    public final Task zzg(final String str) {
        final Cast.MessageReceivedCallback messageReceivedCallback;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.B) {
            messageReceivedCallback = (Cast.MessageReceivedCallback) this.B.remove(str);
        }
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.cast.zzbb
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                com.google.android.gms.cast.internal.zzx zzxVar = (com.google.android.gms.cast.internal.zzx) obj;
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                Preconditions.checkState(this.f6943a.E != 1, "Not active connection");
                if (messageReceivedCallback != null) {
                    ((com.google.android.gms.cast.internal.zzag) zzxVar.getService()).zzr(str);
                }
                taskCompletionSource.setResult(null);
            }
        }).setMethodKey(8414).build());
    }

    @Override // com.google.android.gms.cast.zzr
    public final Task zzh(final String str, final String str2) throws IllegalArgumentException {
        CastUtils.throwIfInvalidNamespace(str);
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        }
        if (str2.length() <= 524288) {
            final String str3 = null;
            return doWrite(TaskApiCall.builder().run(new RemoteCall(str3, str, str2) { // from class: com.google.android.gms.cast.zzbg

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ String f6954b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ String f6955c;

                {
                    this.f6954b = str;
                    this.f6955c = str2;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) {
                    String str4 = this.f6954b;
                    String str5 = this.f6955c;
                    com.google.android.gms.cast.internal.zzx zzxVar = (com.google.android.gms.cast.internal.zzx) obj;
                    TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                    zzbt zzbtVar = this.f6953a;
                    HashMap map = zzbtVar.A;
                    long jIncrementAndGet = zzbtVar.f6983p.incrementAndGet();
                    Preconditions.checkState(zzbtVar.zzl(), "Not connected to device");
                    try {
                        map.put(Long.valueOf(jIncrementAndGet), taskCompletionSource);
                        ((com.google.android.gms.cast.internal.zzag) zzxVar.getService()).zzm(str4, str5, jIncrementAndGet);
                    } catch (RemoteException e10) {
                        map.remove(Long.valueOf(jIncrementAndGet));
                        taskCompletionSource.setException(e10);
                    }
                }
            }).setMethodKey(8405).build());
        }
        F.w("Message send failed. Message exceeds maximum size", new Object[0]);
        throw new IllegalArgumentException("Message exceeds maximum size524288");
    }

    @Override // com.google.android.gms.cast.zzr
    public final Task zzi(final String str, final Cast.MessageReceivedCallback messageReceivedCallback) throws IllegalArgumentException {
        CastUtils.throwIfInvalidNamespace(str);
        if (messageReceivedCallback != null) {
            synchronized (this.B) {
                this.B.put(str, messageReceivedCallback);
            }
        }
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.cast.zzbh
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                com.google.android.gms.cast.internal.zzx zzxVar = (com.google.android.gms.cast.internal.zzx) obj;
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                Preconditions.checkState(this.f6956a.E != 1, "Not active connection");
                com.google.android.gms.cast.internal.zzag zzagVar = (com.google.android.gms.cast.internal.zzag) zzxVar.getService();
                String str2 = str;
                zzagVar.zzr(str2);
                if (messageReceivedCallback != null) {
                    ((com.google.android.gms.cast.internal.zzag) zzxVar.getService()).zzk(str2);
                }
                taskCompletionSource.setResult(null);
            }
        }).setMethodKey(8413).build());
    }

    @Override // com.google.android.gms.cast.zzr
    public final void zzk(zzq zzqVar) {
        Preconditions.checkNotNull(zzqVar);
        this.D.add(zzqVar);
    }

    @Override // com.google.android.gms.cast.zzr
    public final boolean zzl() {
        return this.E == 2;
    }

    @Override // com.google.android.gms.cast.zzr
    public final boolean zzm() {
        Preconditions.checkState(zzl(), "Not connected to device");
        return this.f6989v;
    }
}
