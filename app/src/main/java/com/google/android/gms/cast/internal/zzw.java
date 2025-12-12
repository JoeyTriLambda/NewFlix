package com.google.android.gms.cast.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.zzav;
import com.google.android.gms.cast.zzbu;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzw extends GmsClient {

    /* renamed from: x, reason: collision with root package name */
    public static final Logger f6882x = new Logger("CastClientImpl");

    /* renamed from: y, reason: collision with root package name */
    public static final Object f6883y = new Object();

    /* renamed from: z, reason: collision with root package name */
    public static final Object f6884z = new Object();

    /* renamed from: a, reason: collision with root package name */
    public ApplicationMetadata f6885a;

    /* renamed from: b, reason: collision with root package name */
    public final CastDevice f6886b;

    /* renamed from: c, reason: collision with root package name */
    public final Cast.Listener f6887c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f6888d;

    /* renamed from: e, reason: collision with root package name */
    public final long f6889e;

    /* renamed from: f, reason: collision with root package name */
    public final Bundle f6890f;

    /* renamed from: g, reason: collision with root package name */
    public zzv f6891g;

    /* renamed from: h, reason: collision with root package name */
    public String f6892h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f6893i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6894j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f6895k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f6896l;

    /* renamed from: m, reason: collision with root package name */
    public double f6897m;

    /* renamed from: n, reason: collision with root package name */
    public zzav f6898n;

    /* renamed from: o, reason: collision with root package name */
    public int f6899o;

    /* renamed from: p, reason: collision with root package name */
    public int f6900p;

    /* renamed from: q, reason: collision with root package name */
    public final AtomicLong f6901q;

    /* renamed from: r, reason: collision with root package name */
    public String f6902r;

    /* renamed from: s, reason: collision with root package name */
    public String f6903s;

    /* renamed from: t, reason: collision with root package name */
    public Bundle f6904t;

    /* renamed from: u, reason: collision with root package name */
    public final HashMap f6905u;

    /* renamed from: v, reason: collision with root package name */
    public BaseImplementation.ResultHolder f6906v;

    /* renamed from: w, reason: collision with root package name */
    public BaseImplementation.ResultHolder f6907w;

    public zzw(Context context, Looper looper, ClientSettings clientSettings, CastDevice castDevice, long j10, Cast.Listener listener, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 10, clientSettings, (ConnectionCallbacks) connectionCallbacks, (OnConnectionFailedListener) onConnectionFailedListener);
        this.f6886b = castDevice;
        this.f6887c = listener;
        this.f6889e = j10;
        this.f6890f = bundle;
        this.f6888d = new HashMap();
        this.f6901q = new AtomicLong(0L);
        this.f6905u = new HashMap();
        this.f6896l = false;
        this.f6899o = -1;
        this.f6900p = -1;
        this.f6885a = null;
        this.f6892h = null;
        this.f6897m = 0.0d;
        e();
        this.f6893i = false;
        this.f6898n = null;
        e();
    }

    public final boolean a() {
        zzv zzvVar;
        return (!this.f6896l || (zzvVar = this.f6891g) == null || zzvVar.zzr()) ? false : true;
    }

    public final void b(int i10, long j10) {
        BaseImplementation.ResultHolder resultHolder;
        synchronized (this.f6905u) {
            resultHolder = (BaseImplementation.ResultHolder) this.f6905u.remove(Long.valueOf(j10));
        }
        if (resultHolder != null) {
            resultHolder.setResult(new Status(i10));
        }
    }

    public final void c(int i10) {
        synchronized (f6884z) {
            BaseImplementation.ResultHolder resultHolder = this.f6907w;
            if (resultHolder != null) {
                resultHolder.setResult(new Status(i10));
                this.f6907w = null;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        return iInterfaceQueryLocalInterface instanceof zzag ? (zzag) iInterfaceQueryLocalInterface : new zzag(iBinder);
    }

    public final void d(BaseImplementation.ResultHolder resultHolder) {
        synchronized (f6883y) {
            BaseImplementation.ResultHolder resultHolder2 = this.f6906v;
            if (resultHolder2 != null) {
                resultHolder2.setResult(new zzq(new Status(2477), null, null, null, false));
            }
            this.f6906v = resultHolder;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        Logger logger = f6882x;
        logger.d("disconnect(); ServiceListener=%s, isConnected=%b", this.f6891g, Boolean.valueOf(isConnected()));
        zzv zzvVar = this.f6891g;
        this.f6891g = null;
        if (zzvVar == null || zzvVar.zzq() == null) {
            logger.d("already disposed, so short-circuiting", new Object[0]);
            return;
        }
        logger.d("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.f6888d) {
            this.f6888d.clear();
        }
        try {
            try {
                ((zzag) getService()).zzf();
            } catch (RemoteException | IllegalStateException e10) {
                logger.d(e10, "Error while disconnecting the controller interface", new Object[0]);
            }
        } finally {
            super.disconnect();
        }
    }

    public final void e() {
        CastDevice castDevice = this.f6886b;
        Preconditions.checkNotNull(castDevice, "device should not be null");
        if (castDevice.hasCapability(2048) || !castDevice.hasCapability(4) || castDevice.hasCapability(1)) {
            return;
        }
        "Chromecast Audio".equals(castDevice.getModelName());
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getConnectionHint() {
        Bundle bundle = this.f6904t;
        if (bundle == null) {
            return super.getConnectionHint();
        }
        this.f6904t = null;
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        f6882x.d("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", this.f6902r, this.f6903s);
        this.f6886b.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.f6889e);
        Bundle bundle2 = this.f6890f;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        this.f6891g = new zzv(this);
        bundle.putParcelable("listener", new BinderWrapper(this.f6891g));
        String str = this.f6902r;
        if (str != null) {
            bundle.putString("last_application_id", str);
            String str2 = this.f6903s;
            if (str2 != null) {
                bundle.putString("last_session_id", str2);
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12800000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        f6882x.d("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.f6888d) {
            this.f6888d.clear();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onPostInitHandler(int i10, IBinder iBinder, Bundle bundle, int i11) {
        f6882x.d("in onPostInitHandler; statusCode=%d", Integer.valueOf(i10));
        if (i10 == 0 || i10 == 2300) {
            this.f6896l = true;
            this.f6894j = true;
            this.f6895k = true;
        } else {
            this.f6896l = false;
        }
        if (i10 == 2300) {
            Bundle bundle2 = new Bundle();
            this.f6904t = bundle2;
            bundle2.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
            i10 = 0;
        }
        super.onPostInitHandler(i10, iBinder, bundle, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzL(String str, String str2, zzbu zzbuVar, BaseImplementation.ResultHolder resultHolder) throws IllegalStateException, RemoteException {
        d(resultHolder);
        zzbu zzbuVar2 = new zzbu();
        zzag zzagVar = (zzag) getService();
        if (a()) {
            zzagVar.zzg(str, str2, zzbuVar2);
        } else {
            zzR(2016);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzM(String str, LaunchOptions launchOptions, BaseImplementation.ResultHolder resultHolder) throws IllegalStateException, RemoteException {
        d(resultHolder);
        zzag zzagVar = (zzag) getService();
        if (a()) {
            zzagVar.zzh(str, launchOptions);
        } else {
            zzR(2016);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzN(BaseImplementation.ResultHolder resultHolder) throws IllegalStateException, RemoteException {
        synchronized (f6884z) {
            if (this.f6907w != null) {
                resultHolder.setResult(new Status(2001));
            } else {
                this.f6907w = resultHolder;
            }
        }
        zzag zzagVar = (zzag) getService();
        if (a()) {
            zzagVar.zzi();
        } else {
            c(2016);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzQ(String str, String str2, BaseImplementation.ResultHolder resultHolder) throws IllegalStateException, RemoteException, IllegalArgumentException {
        HashMap map = this.f6905u;
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        }
        if (str2.length() > 524288) {
            f6882x.w("Message send failed. Message exceeds maximum size", new Object[0]);
            throw new IllegalArgumentException("Message exceeds maximum size");
        }
        CastUtils.throwIfInvalidNamespace(str);
        long jIncrementAndGet = this.f6901q.incrementAndGet();
        try {
            map.put(Long.valueOf(jIncrementAndGet), resultHolder);
            zzag zzagVar = (zzag) getService();
            if (a()) {
                zzagVar.zzm(str, str2, jIncrementAndGet);
            } else {
                b(2016, jIncrementAndGet);
            }
        } catch (Throwable th2) {
            map.remove(Long.valueOf(jIncrementAndGet));
            throw th2;
        }
    }

    public final void zzR(int i10) {
        synchronized (f6883y) {
            BaseImplementation.ResultHolder resultHolder = this.f6906v;
            if (resultHolder != null) {
                resultHolder.setResult(new zzq(new Status(i10), null, null, null, false));
                this.f6906v = null;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzV(String str, BaseImplementation.ResultHolder resultHolder) throws IllegalStateException, RemoteException {
        synchronized (f6884z) {
            if (this.f6907w != null) {
                resultHolder.setResult(new Status(2001));
            } else {
                this.f6907w = resultHolder;
            }
        }
        zzag zzagVar = (zzag) getService();
        if (a()) {
            zzagVar.zzp(str);
        } else {
            c(2016);
        }
    }
}
