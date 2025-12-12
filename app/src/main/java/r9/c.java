package r9;

import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.io.IOException;

/* compiled from: AutoSessionEventEncoder.java */
/* loaded from: classes.dex */
public final class c implements c9.a {

    /* renamed from: a, reason: collision with root package name */
    public static final c f18819a = new c();

    /* compiled from: AutoSessionEventEncoder.java */
    public static final class a implements b9.d<r9.a> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f18820a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f18821b = b9.c.of("packageName");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f18822c = b9.c.of("versionName");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f18823d = b9.c.of("appBuildVersion");

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f18824e = b9.c.of("deviceManufacturer");

        /* renamed from: f, reason: collision with root package name */
        public static final b9.c f18825f = b9.c.of("currentProcessDetails");

        /* renamed from: g, reason: collision with root package name */
        public static final b9.c f18826g = b9.c.of("appProcessDetails");

        @Override // b9.b
        public void encode(r9.a aVar, b9.e eVar) throws IOException {
            eVar.add(f18821b, aVar.getPackageName());
            eVar.add(f18822c, aVar.getVersionName());
            eVar.add(f18823d, aVar.getAppBuildVersion());
            eVar.add(f18824e, aVar.getDeviceManufacturer());
            eVar.add(f18825f, aVar.getCurrentProcessDetails());
            eVar.add(f18826g, aVar.getAppProcessDetails());
        }
    }

    /* compiled from: AutoSessionEventEncoder.java */
    public static final class b implements b9.d<r9.b> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f18827a = new b();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f18828b = b9.c.of("appId");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f18829c = b9.c.of("deviceModel");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f18830d = b9.c.of("sessionSdkVersion");

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f18831e = b9.c.of("osVersion");

        /* renamed from: f, reason: collision with root package name */
        public static final b9.c f18832f = b9.c.of("logEnvironment");

        /* renamed from: g, reason: collision with root package name */
        public static final b9.c f18833g = b9.c.of("androidAppInfo");

        @Override // b9.b
        public void encode(r9.b bVar, b9.e eVar) throws IOException {
            eVar.add(f18828b, bVar.getAppId());
            eVar.add(f18829c, bVar.getDeviceModel());
            eVar.add(f18830d, bVar.getSessionSdkVersion());
            eVar.add(f18831e, bVar.getOsVersion());
            eVar.add(f18832f, bVar.getLogEnvironment());
            eVar.add(f18833g, bVar.getAndroidAppInfo());
        }
    }

    /* compiled from: AutoSessionEventEncoder.java */
    /* renamed from: r9.c$c, reason: collision with other inner class name */
    public static final class C0244c implements b9.d<r9.d> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0244c f18834a = new C0244c();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f18835b = b9.c.of("performance");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f18836c = b9.c.of("crashlytics");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f18837d = b9.c.of("sessionSamplingRate");

        @Override // b9.b
        public void encode(r9.d dVar, b9.e eVar) throws IOException {
            eVar.add(f18835b, dVar.getPerformance());
            eVar.add(f18836c, dVar.getCrashlytics());
            eVar.add(f18837d, dVar.getSessionSamplingRate());
        }
    }

    /* compiled from: AutoSessionEventEncoder.java */
    public static final class d implements b9.d<h> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f18838a = new d();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f18839b = b9.c.of("processName");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f18840c = b9.c.of("pid");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f18841d = b9.c.of("importance");

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f18842e = b9.c.of("defaultProcess");

        @Override // b9.b
        public void encode(h hVar, b9.e eVar) throws IOException {
            eVar.add(f18839b, hVar.getProcessName());
            eVar.add(f18840c, hVar.getPid());
            eVar.add(f18841d, hVar.getImportance());
            eVar.add(f18842e, hVar.isDefaultProcess());
        }
    }

    /* compiled from: AutoSessionEventEncoder.java */
    public static final class e implements b9.d<m> {

        /* renamed from: a, reason: collision with root package name */
        public static final e f18843a = new e();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f18844b = b9.c.of("eventType");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f18845c = b9.c.of("sessionData");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f18846d = b9.c.of("applicationInfo");

        @Override // b9.b
        public void encode(m mVar, b9.e eVar) throws IOException {
            eVar.add(f18844b, mVar.getEventType());
            eVar.add(f18845c, mVar.getSessionData());
            eVar.add(f18846d, mVar.getApplicationInfo());
        }
    }

    /* compiled from: AutoSessionEventEncoder.java */
    public static final class f implements b9.d<p> {

        /* renamed from: a, reason: collision with root package name */
        public static final f f18847a = new f();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f18848b = b9.c.of(JsonStorageKeyNames.SESSION_ID_KEY);

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f18849c = b9.c.of("firstSessionId");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f18850d = b9.c.of("sessionIndex");

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f18851e = b9.c.of("eventTimestampUs");

        /* renamed from: f, reason: collision with root package name */
        public static final b9.c f18852f = b9.c.of("dataCollectionStatus");

        /* renamed from: g, reason: collision with root package name */
        public static final b9.c f18853g = b9.c.of("firebaseInstallationId");

        /* renamed from: h, reason: collision with root package name */
        public static final b9.c f18854h = b9.c.of("firebaseAuthenticationToken");

        @Override // b9.b
        public void encode(p pVar, b9.e eVar) throws IOException {
            eVar.add(f18848b, pVar.getSessionId());
            eVar.add(f18849c, pVar.getFirstSessionId());
            eVar.add(f18850d, pVar.getSessionIndex());
            eVar.add(f18851e, pVar.getEventTimestampUs());
            eVar.add(f18852f, pVar.getDataCollectionStatus());
            eVar.add(f18853g, pVar.getFirebaseInstallationId());
            eVar.add(f18854h, pVar.getFirebaseAuthenticationToken());
        }
    }

    @Override // c9.a
    public void configure(c9.b<?> bVar) {
        bVar.registerEncoder(m.class, e.f18843a);
        bVar.registerEncoder(p.class, f.f18847a);
        bVar.registerEncoder(r9.d.class, C0244c.f18834a);
        bVar.registerEncoder(r9.b.class, b.f18827a);
        bVar.registerEncoder(r9.a.class, a.f18820a);
        bVar.registerEncoder(h.class, d.f18838a);
    }
}
