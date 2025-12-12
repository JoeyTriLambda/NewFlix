package n8;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.CrashlyticsRegistrar;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import l8.r;
import o8.h;
import r8.d0;
import r8.e0;
import r8.h0;
import r8.k;
import r8.w;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements l8.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16761a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f16762b;

    public /* synthetic */ d(Object obj, int i10) {
        this.f16761a = i10;
        this.f16762b = obj;
    }

    @Override // l8.g
    public final Object create(l8.d dVar) throws Resources.NotFoundException {
        int i10 = this.f16761a;
        Object obj = this.f16762b;
        switch (i10) {
            case 0:
                int i11 = CrashlyticsRegistrar.f9760a;
                ((CrashlyticsRegistrar) obj).getClass();
                g8.f fVar = (g8.f) dVar.get(g8.f.class);
                h9.a deferred = dVar.getDeferred(o8.a.class);
                h9.a deferred2 = dVar.getDeferred(i8.a.class);
                i9.c cVar = (i9.c) dVar.get(i9.c.class);
                h9.a deferred3 = dVar.getDeferred(p9.a.class);
                Context applicationContext = fVar.getApplicationContext();
                String packageName = applicationContext.getPackageName();
                o8.e.getLogger().i("Initializing Firebase Crashlytics " + w.getVersion() + " for " + packageName);
                w8.b bVar = new w8.b(applicationContext);
                d0 d0Var = new d0(fVar);
                h0 h0Var = new h0(applicationContext, packageName, cVar, d0Var);
                o8.b bVar2 = new o8.b(deferred);
                b bVar3 = new b(deferred2);
                ExecutorService executorServiceBuildSingleThreadExecutorService = e0.buildSingleThreadExecutorService("Crashlytics Exception Handler");
                k kVar = new k(d0Var, bVar);
                FirebaseSessionsDependencies.register(kVar);
                w wVar = new w(fVar, h0Var, bVar2, d0Var, bVar3.getDeferredBreadcrumbSource(), bVar3.getAnalyticsEventLogger(), bVar, executorServiceBuildSingleThreadExecutorService, kVar, new h(deferred3));
                String applicationId = fVar.getOptions().getApplicationId();
                String mappingFileId = CommonUtils.getMappingFileId(applicationContext);
                List<r8.f> buildIdInfo = CommonUtils.getBuildIdInfo(applicationContext);
                o8.e.getLogger().d("Mapping file ID is: " + mappingFileId);
                for (r8.f fVar2 : buildIdInfo) {
                    o8.e.getLogger().d(String.format("Build id for %s on %s: %s", fVar2.getLibraryName(), fVar2.getArch(), fVar2.getBuildId()));
                }
                try {
                    r8.a aVarCreate = r8.a.create(applicationContext, h0Var, applicationId, mappingFileId, buildIdInfo, new o8.d(applicationContext));
                    o8.e.getLogger().v("Installer package name is: " + aVarCreate.f18659d);
                    ExecutorService executorServiceBuildSingleThreadExecutorService2 = e0.buildSingleThreadExecutorService("com.google.firebase.crashlytics.startup");
                    com.google.firebase.crashlytics.internal.settings.a aVarCreate2 = com.google.firebase.crashlytics.internal.settings.a.create(applicationContext, applicationId, h0Var, new v8.b(), aVarCreate.f18661f, aVarCreate.f18662g, bVar, d0Var);
                    aVarCreate2.loadSettingsData(executorServiceBuildSingleThreadExecutorService2).continueWith(executorServiceBuildSingleThreadExecutorService2, new e());
                    Tasks.call(executorServiceBuildSingleThreadExecutorService2, new f(wVar.onPreExecute(aVarCreate, aVarCreate2), wVar, aVarCreate2));
                    return new g();
                } catch (PackageManager.NameNotFoundException e10) {
                    o8.e.getLogger().e("Error retrieving app package info.", e10);
                    return null;
                }
            default:
                return new g9.c((Context) dVar.get(Context.class), ((g8.f) dVar.get(g8.f.class)).getPersistenceKey(), dVar.setOf(g9.d.class), dVar.getProvider(o9.h.class), (Executor) dVar.get((r) obj));
        }
    }
}
