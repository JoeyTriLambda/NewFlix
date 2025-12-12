package g8;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.concurrent.UiExecutor;
import com.google.firebase.provider.FirebaseInitProvider;
import com.unity3d.ads.metadata.MediationMetaData;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import l8.j;
import l8.n;

/* compiled from: FirebaseApp.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: k, reason: collision with root package name */
    public static final Object f12783k = new Object();

    /* renamed from: l, reason: collision with root package name */
    public static final b0.b f12784l = new b0.b();

    /* renamed from: a, reason: collision with root package name */
    public final Context f12785a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12786b;

    /* renamed from: c, reason: collision with root package name */
    public final i f12787c;

    /* renamed from: d, reason: collision with root package name */
    public final l8.j f12788d;

    /* renamed from: g, reason: collision with root package name */
    public final n<n9.a> f12791g;

    /* renamed from: h, reason: collision with root package name */
    public final h9.b<g9.c> f12792h;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f12789e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f12790f = new AtomicBoolean();

    /* renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArrayList f12793i = new CopyOnWriteArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final CopyOnWriteArrayList f12794j = new CopyOnWriteArrayList();

    /* compiled from: FirebaseApp.java */
    @KeepForSdk
    public interface a {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z10);
    }

    /* compiled from: FirebaseApp.java */
    @TargetApi(14)
    public static class b implements BackgroundDetector.BackgroundStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public static final AtomicReference<b> f12795a = new AtomicReference<>();

        @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
        public void onBackgroundStateChanged(boolean z10) {
            synchronized (f.f12783k) {
                Iterator it = new ArrayList(f.f12784l.values()).iterator();
                while (it.hasNext()) {
                    f fVar = (f) it.next();
                    if (fVar.f12789e.get()) {
                        Log.d("FirebaseApp", "Notifying background state change listeners.");
                        Iterator it2 = fVar.f12793i.iterator();
                        while (it2.hasNext()) {
                            ((a) it2.next()).onBackgroundStateChanged(z10);
                        }
                    }
                }
            }
        }
    }

    /* compiled from: FirebaseApp.java */
    @TargetApi(24)
    public static class c extends BroadcastReceiver {

        /* renamed from: b, reason: collision with root package name */
        public static final AtomicReference<c> f12796b = new AtomicReference<>();

        /* renamed from: a, reason: collision with root package name */
        public final Context f12797a;

        public c(Context context) {
            this.f12797a = context;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (f.f12783k) {
                Iterator it = f.f12784l.values().iterator();
                while (it.hasNext()) {
                    ((f) it.next()).b();
                }
            }
            unregister();
        }

        public void unregister() {
            this.f12797a.unregisterReceiver(this);
        }
    }

    public f(Context context, String str, i iVar) {
        int i10 = 0;
        this.f12785a = (Context) Preconditions.checkNotNull(context);
        this.f12786b = Preconditions.checkNotEmpty(str);
        this.f12787c = (i) Preconditions.checkNotNull(iVar);
        j startupTime = FirebaseInitProvider.getStartupTime();
        t9.b.pushTrace("Firebase");
        t9.b.pushTrace("ComponentDiscovery");
        List<h9.b<ComponentRegistrar>> listDiscoverLazy = l8.f.forContext(context, ComponentDiscoveryService.class).discoverLazy();
        t9.b.popTrace();
        t9.b.pushTrace("Runtime");
        j.a processor = l8.j.builder(UiExecutor.f9757b).addLazyComponentRegistrars(listDiscoverLazy).addComponentRegistrar(new FirebaseCommonRegistrar()).addComponentRegistrar(new ExecutorsRegistrar()).addComponent(l8.b.of(context, Context.class, new Class[0])).addComponent(l8.b.of(this, f.class, new Class[0])).addComponent(l8.b.of(iVar, i.class, new Class[0])).setProcessor(new t9.a());
        if (t0.n.isUserUnlocked(context) && FirebaseInitProvider.isCurrentlyInitializing()) {
            processor.addComponent(l8.b.of(startupTime, j.class, new Class[0]));
        }
        l8.j jVarBuild = processor.build();
        this.f12788d = jVarBuild;
        t9.b.popTrace();
        this.f12791g = new n<>(new d(i10, this, context));
        jVarBuild.getClass();
        this.f12792h = l8.c.d(jVarBuild, g9.c.class);
        addBackgroundStateChangeListener(new a() { // from class: g8.e
            @Override // g8.f.a
            public final void onBackgroundStateChanged(boolean z10) {
                f fVar = this.f12782a;
                if (z10) {
                    fVar.getClass();
                } else {
                    fVar.f12792h.get().registerHeartBeat();
                }
            }
        });
        t9.b.popTrace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static f getInstance() {
        f fVar;
        synchronized (f12783k) {
            fVar = (f) f12784l.get("[DEFAULT]");
            if (fVar == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.getMyProcessName() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
            fVar.f12792h.get().registerHeartBeat();
        }
        return fVar;
    }

    public static f initializeApp(Context context) {
        synchronized (f12783k) {
            if (f12784l.containsKey("[DEFAULT]")) {
                return getInstance();
            }
            i iVarFromResource = i.fromResource(context);
            if (iVarFromResource == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            return initializeApp(context, iVarFromResource);
        }
    }

    public final void a() {
        Preconditions.checkState(!this.f12790f.get(), "FirebaseApp was deleted");
    }

    @KeepForSdk
    public void addBackgroundStateChangeListener(a aVar) {
        a();
        if (this.f12789e.get() && BackgroundDetector.getInstance().isInBackground()) {
            aVar.onBackgroundStateChanged(true);
        }
        this.f12793i.add(aVar);
    }

    @KeepForSdk
    public void addLifecycleEventListener(g gVar) {
        a();
        Preconditions.checkNotNull(gVar);
        this.f12794j.add(gVar);
    }

    public final void b() {
        Context context = this.f12785a;
        boolean z10 = true;
        if (!(!t0.n.isUserUnlocked(context))) {
            Log.i("FirebaseApp", "Device unlocked: initializing all Firebase APIs for app " + getName());
            this.f12788d.initializeEagerComponents(isDefaultApp());
            this.f12792h.get().registerHeartBeat();
            return;
        }
        Log.i("FirebaseApp", "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + getName());
        AtomicReference<c> atomicReference = c.f12796b;
        if (atomicReference.get() == null) {
            c cVar = new c(context);
            while (true) {
                if (atomicReference.compareAndSet(null, cVar)) {
                    break;
                } else if (atomicReference.get() != null) {
                    z10 = false;
                    break;
                }
            }
            if (z10) {
                context.registerReceiver(cVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        return this.f12786b.equals(((f) obj).getName());
    }

    @KeepForSdk
    public <T> T get(Class<T> cls) {
        a();
        l8.j jVar = this.f12788d;
        jVar.getClass();
        return (T) l8.c.a(jVar, cls);
    }

    public Context getApplicationContext() {
        a();
        return this.f12785a;
    }

    public String getName() {
        a();
        return this.f12786b;
    }

    public i getOptions() {
        a();
        return this.f12787c;
    }

    @KeepForSdk
    public String getPersistenceKey() {
        return Base64Utils.encodeUrlSafeNoPadding(getName().getBytes(Charset.defaultCharset())) + "+" + Base64Utils.encodeUrlSafeNoPadding(getOptions().getApplicationId().getBytes(Charset.defaultCharset()));
    }

    public int hashCode() {
        return this.f12786b.hashCode();
    }

    @KeepForSdk
    public boolean isDataCollectionDefaultEnabled() {
        a();
        return this.f12791g.get().isEnabled();
    }

    @KeepForSdk
    public boolean isDefaultApp() {
        return "[DEFAULT]".equals(getName());
    }

    public String toString() {
        return Objects.toStringHelper(this).add(MediationMetaData.KEY_NAME, this.f12786b).add("options", this.f12787c).toString();
    }

    public static f initializeApp(Context context, i iVar) {
        return initializeApp(context, iVar, "[DEFAULT]");
    }

    public static f initializeApp(Context context, i iVar, String str) {
        f fVar;
        boolean z10;
        AtomicReference<b> atomicReference = b.f12795a;
        if (PlatformVersion.isAtLeastIceCreamSandwich() && (context.getApplicationContext() instanceof Application)) {
            Application application = (Application) context.getApplicationContext();
            AtomicReference<b> atomicReference2 = b.f12795a;
            if (atomicReference2.get() == null) {
                b bVar = new b();
                while (true) {
                    if (atomicReference2.compareAndSet(null, bVar)) {
                        z10 = true;
                        break;
                    }
                    if (atomicReference2.get() != null) {
                        z10 = false;
                        break;
                    }
                }
                if (z10) {
                    BackgroundDetector.initialize(application);
                    BackgroundDetector.getInstance().addListener(bVar);
                }
            }
        }
        String strTrim = str.trim();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f12783k) {
            b0.b bVar2 = f12784l;
            Preconditions.checkState(true ^ bVar2.containsKey(strTrim), "FirebaseApp name " + strTrim + " already exists!");
            Preconditions.checkNotNull(context, "Application context cannot be null.");
            fVar = new f(context, strTrim, iVar);
            bVar2.put(strTrim, fVar);
        }
        fVar.b();
        return fVar;
    }
}
