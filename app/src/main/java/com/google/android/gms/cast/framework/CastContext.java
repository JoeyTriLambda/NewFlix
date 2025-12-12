package com.google.android.gms.cast.framework;

import a2.m;
import a2.n;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.cast.zzbn;
import com.google.android.gms.internal.cast.zzcy;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public class CastContext {

    /* renamed from: m, reason: collision with root package name */
    public static final Logger f6337m = new Logger("CastContext");

    /* renamed from: n, reason: collision with root package name */
    public static final Object f6338n = new Object();

    /* renamed from: o, reason: collision with root package name */
    public static volatile CastContext f6339o;

    /* renamed from: a, reason: collision with root package name */
    public final Context f6340a;

    /* renamed from: b, reason: collision with root package name */
    public final zzaj f6341b;

    /* renamed from: c, reason: collision with root package name */
    public final SessionManager f6342c;

    /* renamed from: d, reason: collision with root package name */
    public final zzac f6343d;

    /* renamed from: e, reason: collision with root package name */
    public final CastOptions f6344e;

    /* renamed from: f, reason: collision with root package name */
    public final com.google.android.gms.cast.internal.zzn f6345f;

    /* renamed from: g, reason: collision with root package name */
    public final com.google.android.gms.internal.cast.zzaf f6346g;

    /* renamed from: h, reason: collision with root package name */
    public final com.google.android.gms.internal.cast.zzay f6347h;

    /* renamed from: i, reason: collision with root package name */
    public final List f6348i;

    /* renamed from: j, reason: collision with root package name */
    public final zzbn f6349j;

    /* renamed from: k, reason: collision with root package name */
    public com.google.android.gms.internal.cast.zzai f6350k;

    /* renamed from: l, reason: collision with root package name */
    public CastReasonCodes f6351l;

    public CastContext(Context context, CastOptions castOptions, List list, com.google.android.gms.internal.cast.zzbf zzbfVar, final com.google.android.gms.cast.internal.zzn zznVar) throws ModuleUnavailableException {
        this.f6340a = context;
        this.f6344e = castOptions;
        this.f6345f = zznVar;
        this.f6348i = list;
        this.f6347h = new com.google.android.gms.internal.cast.zzay(context);
        this.f6349j = zzbfVar.zzn();
        this.f6350k = !TextUtils.isEmpty(castOptions.getReceiverApplicationId()) ? new com.google.android.gms.internal.cast.zzai(context, castOptions, zzbfVar) : null;
        HashMap map = new HashMap();
        com.google.android.gms.internal.cast.zzai zzaiVar = this.f6350k;
        if (zzaiVar != null) {
            map.put(zzaiVar.getCategory(), zzaiVar.zza());
        }
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                SessionProvider sessionProvider = (SessionProvider) it.next();
                Preconditions.checkNotNull(sessionProvider, "Additional SessionProvider must not be null.");
                String strCheckNotEmpty = Preconditions.checkNotEmpty(sessionProvider.getCategory(), "Category for SessionProvider must not be null or empty string.");
                Preconditions.checkArgument(!map.containsKey(strCheckNotEmpty), String.format("SessionProvider for category %s already added", strCheckNotEmpty));
                map.put(strCheckNotEmpty, sessionProvider.zza());
            }
        }
        castOptions.zzb(new zzl(1));
        try {
            zzaj zzajVarZza = com.google.android.gms.internal.cast.zzag.zza(context, castOptions, zzbfVar, map);
            this.f6341b = zzajVarZza;
            try {
                this.f6343d = new zzac(zzajVarZza.zzf());
                try {
                    SessionManager sessionManager = new SessionManager(zzajVarZza.zzg(), context);
                    this.f6342c = sessionManager;
                    new MediaNotificationManager(sessionManager);
                    new PrecacheManager(this.f6344e, sessionManager, zznVar);
                    zzbn zzbnVar = this.f6349j;
                    if (zzbnVar != null) {
                        zzbnVar.zzj(sessionManager);
                    }
                    new zzcy(context);
                    com.google.android.gms.internal.cast.zzaf zzafVar = new com.google.android.gms.internal.cast.zzaf();
                    this.f6346g = zzafVar;
                    try {
                        zzajVarZza.zzh(zzafVar);
                        zzafVar.zza.add(this.f6347h.zza);
                        if (!castOptions.zza().isEmpty()) {
                            f6337m.i("Setting Route Discovery for appIds: ".concat(String.valueOf(this.f6344e.zza())), new Object[0]);
                            this.f6347h.zza(this.f6344e.zza());
                        }
                        zznVar.zza(new String[]{"com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED", "com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_MODE", "com.google.android.gms.cast.FLAG_FIRELOG_UPLOAD_MODE", "com.google.android.gms.cast.FLAG_ANALYTICS_LOGGING_BUCKET_SIZE", "com.google.android.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED"}).addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.gms.cast.framework.zzg
                            @Override // com.google.android.gms.tasks.OnSuccessListener
                            public final void onSuccess(Object obj) {
                                CastContext.zzd(this.f6790a, (Bundle) obj);
                            }
                        });
                        final String[] strArr = {"com.google.android.gms.cast.MAP_CAST_STATUS_CODES_TO_CAST_REASON_CODES"};
                        zznVar.doRead(TaskApiCall.builder().run(new RemoteCall(zznVar, strArr) { // from class: com.google.android.gms.cast.internal.zzh

                            /* renamed from: a, reason: collision with root package name */
                            public final /* synthetic */ String[] f6857a;

                            {
                                this.f6857a = strArr;
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // com.google.android.gms.common.api.internal.RemoteCall
                            public final void accept(Object obj, Object obj2) throws RemoteException {
                                ((zzaj) ((zzo) obj).getService()).zzg(new zzm((TaskCompletionSource) obj2), this.f6857a);
                            }
                        }).setFeatures(com.google.android.gms.cast.zzax.f6937d).setAutoResolveMissingFeatures(false).setMethodKey(8427).build()).addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.gms.cast.framework.zzh
                            @Override // com.google.android.gms.tasks.OnSuccessListener
                            public final void onSuccess(Object obj) {
                                CastContext castContext = this.f6791a;
                                castContext.getClass();
                                castContext.f6351l = new CastReasonCodes((Bundle) obj);
                            }
                        });
                    } catch (RemoteException e10) {
                        throw new IllegalStateException("Failed to call addAppVisibilityListener", e10);
                    }
                } catch (RemoteException e11) {
                    throw new IllegalStateException("Failed to call getSessionManagerImpl", e11);
                }
            } catch (RemoteException e12) {
                throw new IllegalStateException("Failed to call getDiscoveryManagerImpl", e12);
            }
        } catch (RemoteException e13) {
            throw new IllegalStateException("Failed to call newCastContextImpl", e13);
        }
    }

    public static OptionsProvider a(Context context) throws IllegalStateException {
        try {
            Bundle bundle = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                f6337m.e("Bundle is null", new Object[0]);
            }
            String string = bundle.getString("com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME");
            if (string != null) {
                return (OptionsProvider) Class.forName(string).asSubclass(OptionsProvider.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            }
            throw new IllegalStateException("The fully qualified name of the implementation of OptionsProvider must be provided as a metadata in the AndroidManifest.xml with key com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME.");
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | NullPointerException | InvocationTargetException e10) {
            throw new IllegalStateException("Failed to initialize CastContext.", e10);
        }
    }

    public static CastContext getSharedInstance() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return f6339o;
    }

    public static CastContext zza(Context context) throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            return getSharedInstance(context);
        } catch (RuntimeException e10) {
            f6337m.e("Failed to load module from Google Play services. Cast will not work properly. Might due to outdated Google Play services. Ignoring this failure silently.", e10);
            return null;
        }
    }

    public static /* synthetic */ void zzd(CastContext castContext, Bundle bundle) {
        if (com.google.android.gms.internal.cast.zzg.zza) {
            com.google.android.gms.internal.cast.zzg.zza(castContext.f6340a, castContext.f6345f, castContext.f6342c, castContext.f6349j, castContext.f6346g).zzc(bundle);
        }
    }

    public CastOptions getCastOptions() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.f6344e;
    }

    public int getCastReasonCodeForCastStatusCode(int i10) {
        CastReasonCodes castReasonCodes = this.f6351l;
        if (castReasonCodes != null) {
            return castReasonCodes.zza(i10);
        }
        f6337m.w("castReasonCodes hasn't been initialized yet", new Object[0]);
        return 0;
    }

    public m getMergedSelector() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        try {
            return m.fromBundle(this.f6341b.zze());
        } catch (RemoteException e10) {
            f6337m.d(e10, "Unable to call %s on %s.", "getMergedSelectorAsBundle", "zzaj");
            return null;
        }
    }

    public SessionManager getSessionManager() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.f6342c;
    }

    @ShowFirstParty
    public final zzac zzc() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.f6343d;
    }

    public static CastContext getSharedInstance(Context context) throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (f6339o == null) {
            synchronized (f6338n) {
                if (f6339o == null) {
                    Context applicationContext = context.getApplicationContext();
                    OptionsProvider optionsProviderA = a(applicationContext);
                    CastOptions castOptions = optionsProviderA.getCastOptions(applicationContext);
                    com.google.android.gms.cast.internal.zzn zznVar = new com.google.android.gms.cast.internal.zzn(applicationContext);
                    try {
                        f6339o = new CastContext(applicationContext, castOptions, optionsProviderA.getAdditionalSessionProviders(applicationContext), new com.google.android.gms.internal.cast.zzbf(applicationContext, n.getInstance(applicationContext), castOptions, zznVar), zznVar);
                    } catch (ModuleUnavailableException e10) {
                        throw new RuntimeException(e10);
                    }
                }
            }
        }
        return f6339o;
    }
}
