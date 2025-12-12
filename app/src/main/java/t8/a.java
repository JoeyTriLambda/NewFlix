package t8;

import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import java.io.IOException;
import t8.f0;

/* compiled from: AutoCrashlyticsReportEncoder.java */
/* loaded from: classes.dex */
public final class a implements c9.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f19469a = new a();

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    /* renamed from: t8.a$a, reason: collision with other inner class name */
    public static final class C0260a implements b9.d<f0.a.AbstractC0261a> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0260a f19470a = new C0260a();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19471b = b9.c.of("arch");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f19472c = b9.c.of("libraryName");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f19473d = b9.c.of("buildId");

        @Override // b9.b
        public void encode(f0.a.AbstractC0261a abstractC0261a, b9.e eVar) throws IOException {
            eVar.add(f19471b, abstractC0261a.getArch());
            eVar.add(f19472c, abstractC0261a.getLibraryName());
            eVar.add(f19473d, abstractC0261a.getBuildId());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class b implements b9.d<f0.a> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f19474a = new b();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19475b = b9.c.of("pid");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f19476c = b9.c.of("processName");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f19477d = b9.c.of("reasonCode");

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f19478e = b9.c.of("importance");

        /* renamed from: f, reason: collision with root package name */
        public static final b9.c f19479f = b9.c.of("pss");

        /* renamed from: g, reason: collision with root package name */
        public static final b9.c f19480g = b9.c.of("rss");

        /* renamed from: h, reason: collision with root package name */
        public static final b9.c f19481h = b9.c.of("timestamp");

        /* renamed from: i, reason: collision with root package name */
        public static final b9.c f19482i = b9.c.of("traceFile");

        /* renamed from: j, reason: collision with root package name */
        public static final b9.c f19483j = b9.c.of("buildIdMappingForArch");

        @Override // b9.b
        public void encode(f0.a aVar, b9.e eVar) throws IOException {
            eVar.add(f19475b, aVar.getPid());
            eVar.add(f19476c, aVar.getProcessName());
            eVar.add(f19477d, aVar.getReasonCode());
            eVar.add(f19478e, aVar.getImportance());
            eVar.add(f19479f, aVar.getPss());
            eVar.add(f19480g, aVar.getRss());
            eVar.add(f19481h, aVar.getTimestamp());
            eVar.add(f19482i, aVar.getTraceFile());
            eVar.add(f19483j, aVar.getBuildIdMappingForArch());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class c implements b9.d<f0.c> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f19484a = new c();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19485b = b9.c.of("key");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f19486c = b9.c.of("value");

        @Override // b9.b
        public void encode(f0.c cVar, b9.e eVar) throws IOException {
            eVar.add(f19485b, cVar.getKey());
            eVar.add(f19486c, cVar.getValue());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class d implements b9.d<f0> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f19487a = new d();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19488b = b9.c.of("sdkVersion");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f19489c = b9.c.of("gmpAppId");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f19490d = b9.c.of("platform");

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f19491e = b9.c.of("installationUuid");

        /* renamed from: f, reason: collision with root package name */
        public static final b9.c f19492f = b9.c.of("firebaseInstallationId");

        /* renamed from: g, reason: collision with root package name */
        public static final b9.c f19493g = b9.c.of("appQualitySessionId");

        /* renamed from: h, reason: collision with root package name */
        public static final b9.c f19494h = b9.c.of("buildVersion");

        /* renamed from: i, reason: collision with root package name */
        public static final b9.c f19495i = b9.c.of("displayVersion");

        /* renamed from: j, reason: collision with root package name */
        public static final b9.c f19496j = b9.c.of("session");

        /* renamed from: k, reason: collision with root package name */
        public static final b9.c f19497k = b9.c.of("ndkPayload");

        /* renamed from: l, reason: collision with root package name */
        public static final b9.c f19498l = b9.c.of("appExitInfo");

        @Override // b9.b
        public void encode(f0 f0Var, b9.e eVar) throws IOException {
            eVar.add(f19488b, f0Var.getSdkVersion());
            eVar.add(f19489c, f0Var.getGmpAppId());
            eVar.add(f19490d, f0Var.getPlatform());
            eVar.add(f19491e, f0Var.getInstallationUuid());
            eVar.add(f19492f, f0Var.getFirebaseInstallationId());
            eVar.add(f19493g, f0Var.getAppQualitySessionId());
            eVar.add(f19494h, f0Var.getBuildVersion());
            eVar.add(f19495i, f0Var.getDisplayVersion());
            eVar.add(f19496j, f0Var.getSession());
            eVar.add(f19497k, f0Var.getNdkPayload());
            eVar.add(f19498l, f0Var.getAppExitInfo());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class e implements b9.d<f0.d> {

        /* renamed from: a, reason: collision with root package name */
        public static final e f19499a = new e();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19500b = b9.c.of("files");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f19501c = b9.c.of("orgId");

        @Override // b9.b
        public void encode(f0.d dVar, b9.e eVar) throws IOException {
            eVar.add(f19500b, dVar.getFiles());
            eVar.add(f19501c, dVar.getOrgId());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class f implements b9.d<f0.d.b> {

        /* renamed from: a, reason: collision with root package name */
        public static final f f19502a = new f();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19503b = b9.c.of("filename");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f19504c = b9.c.of("contents");

        @Override // b9.b
        public void encode(f0.d.b bVar, b9.e eVar) throws IOException {
            eVar.add(f19503b, bVar.getFilename());
            eVar.add(f19504c, bVar.getContents());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class g implements b9.d<f0.e.a> {

        /* renamed from: a, reason: collision with root package name */
        public static final g f19505a = new g();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19506b = b9.c.of("identifier");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f19507c = b9.c.of("version");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f19508d = b9.c.of("displayVersion");

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f19509e = b9.c.of("organization");

        /* renamed from: f, reason: collision with root package name */
        public static final b9.c f19510f = b9.c.of("installationUuid");

        /* renamed from: g, reason: collision with root package name */
        public static final b9.c f19511g = b9.c.of("developmentPlatform");

        /* renamed from: h, reason: collision with root package name */
        public static final b9.c f19512h = b9.c.of("developmentPlatformVersion");

        @Override // b9.b
        public void encode(f0.e.a aVar, b9.e eVar) throws IOException {
            eVar.add(f19506b, aVar.getIdentifier());
            eVar.add(f19507c, aVar.getVersion());
            eVar.add(f19508d, aVar.getDisplayVersion());
            eVar.add(f19509e, aVar.getOrganization());
            eVar.add(f19510f, aVar.getInstallationUuid());
            eVar.add(f19511g, aVar.getDevelopmentPlatform());
            eVar.add(f19512h, aVar.getDevelopmentPlatformVersion());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class h implements b9.d<f0.e.a.b> {

        /* renamed from: a, reason: collision with root package name */
        public static final h f19513a = new h();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19514b = b9.c.of("clsId");

        @Override // b9.b
        public void encode(f0.e.a.b bVar, b9.e eVar) throws IOException {
            eVar.add(f19514b, bVar.getClsId());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class i implements b9.d<f0.e.c> {

        /* renamed from: a, reason: collision with root package name */
        public static final i f19515a = new i();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19516b = b9.c.of("arch");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f19517c = b9.c.of("model");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f19518d = b9.c.of("cores");

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f19519e = b9.c.of("ram");

        /* renamed from: f, reason: collision with root package name */
        public static final b9.c f19520f = b9.c.of("diskSpace");

        /* renamed from: g, reason: collision with root package name */
        public static final b9.c f19521g = b9.c.of("simulator");

        /* renamed from: h, reason: collision with root package name */
        public static final b9.c f19522h = b9.c.of(AdOperationMetric.INIT_STATE);

        /* renamed from: i, reason: collision with root package name */
        public static final b9.c f19523i = b9.c.of("manufacturer");

        /* renamed from: j, reason: collision with root package name */
        public static final b9.c f19524j = b9.c.of("modelClass");

        @Override // b9.b
        public void encode(f0.e.c cVar, b9.e eVar) throws IOException {
            eVar.add(f19516b, cVar.getArch());
            eVar.add(f19517c, cVar.getModel());
            eVar.add(f19518d, cVar.getCores());
            eVar.add(f19519e, cVar.getRam());
            eVar.add(f19520f, cVar.getDiskSpace());
            eVar.add(f19521g, cVar.isSimulator());
            eVar.add(f19522h, cVar.getState());
            eVar.add(f19523i, cVar.getManufacturer());
            eVar.add(f19524j, cVar.getModelClass());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class j implements b9.d<f0.e> {

        /* renamed from: a, reason: collision with root package name */
        public static final j f19525a = new j();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19526b = b9.c.of("generator");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f19527c = b9.c.of("identifier");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f19528d = b9.c.of("appQualitySessionId");

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f19529e = b9.c.of("startedAt");

        /* renamed from: f, reason: collision with root package name */
        public static final b9.c f19530f = b9.c.of("endedAt");

        /* renamed from: g, reason: collision with root package name */
        public static final b9.c f19531g = b9.c.of("crashed");

        /* renamed from: h, reason: collision with root package name */
        public static final b9.c f19532h = b9.c.of("app");

        /* renamed from: i, reason: collision with root package name */
        public static final b9.c f19533i = b9.c.of("user");

        /* renamed from: j, reason: collision with root package name */
        public static final b9.c f19534j = b9.c.of("os");

        /* renamed from: k, reason: collision with root package name */
        public static final b9.c f19535k = b9.c.of("device");

        /* renamed from: l, reason: collision with root package name */
        public static final b9.c f19536l = b9.c.of("events");

        /* renamed from: m, reason: collision with root package name */
        public static final b9.c f19537m = b9.c.of("generatorType");

        @Override // b9.b
        public void encode(f0.e eVar, b9.e eVar2) throws IOException {
            eVar2.add(f19526b, eVar.getGenerator());
            eVar2.add(f19527c, eVar.getIdentifierUtf8Bytes());
            eVar2.add(f19528d, eVar.getAppQualitySessionId());
            eVar2.add(f19529e, eVar.getStartedAt());
            eVar2.add(f19530f, eVar.getEndedAt());
            eVar2.add(f19531g, eVar.isCrashed());
            eVar2.add(f19532h, eVar.getApp());
            eVar2.add(f19533i, eVar.getUser());
            eVar2.add(f19534j, eVar.getOs());
            eVar2.add(f19535k, eVar.getDevice());
            eVar2.add(f19536l, eVar.getEvents());
            eVar2.add(f19537m, eVar.getGeneratorType());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class k implements b9.d<f0.e.d.a> {

        /* renamed from: a, reason: collision with root package name */
        public static final k f19538a = new k();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19539b = b9.c.of("execution");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f19540c = b9.c.of("customAttributes");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f19541d = b9.c.of("internalKeys");

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f19542e = b9.c.of("background");

        /* renamed from: f, reason: collision with root package name */
        public static final b9.c f19543f = b9.c.of("currentProcessDetails");

        /* renamed from: g, reason: collision with root package name */
        public static final b9.c f19544g = b9.c.of("appProcessDetails");

        /* renamed from: h, reason: collision with root package name */
        public static final b9.c f19545h = b9.c.of("uiOrientation");

        @Override // b9.b
        public void encode(f0.e.d.a aVar, b9.e eVar) throws IOException {
            eVar.add(f19539b, aVar.getExecution());
            eVar.add(f19540c, aVar.getCustomAttributes());
            eVar.add(f19541d, aVar.getInternalKeys());
            eVar.add(f19542e, aVar.getBackground());
            eVar.add(f19543f, aVar.getCurrentProcessDetails());
            eVar.add(f19544g, aVar.getAppProcessDetails());
            eVar.add(f19545h, aVar.getUiOrientation());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class l implements b9.d<f0.e.d.a.b.AbstractC0265a> {

        /* renamed from: a, reason: collision with root package name */
        public static final l f19546a = new l();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19547b = b9.c.of("baseAddress");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f19548c = b9.c.of("size");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f19549d = b9.c.of(MediationMetaData.KEY_NAME);

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f19550e = b9.c.of("uuid");

        @Override // b9.b
        public void encode(f0.e.d.a.b.AbstractC0265a abstractC0265a, b9.e eVar) throws IOException {
            eVar.add(f19547b, abstractC0265a.getBaseAddress());
            eVar.add(f19548c, abstractC0265a.getSize());
            eVar.add(f19549d, abstractC0265a.getName());
            eVar.add(f19550e, abstractC0265a.getUuidUtf8Bytes());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class m implements b9.d<f0.e.d.a.b> {

        /* renamed from: a, reason: collision with root package name */
        public static final m f19551a = new m();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19552b = b9.c.of("threads");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f19553c = b9.c.of("exception");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f19554d = b9.c.of("appExitInfo");

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f19555e = b9.c.of("signal");

        /* renamed from: f, reason: collision with root package name */
        public static final b9.c f19556f = b9.c.of("binaries");

        @Override // b9.b
        public void encode(f0.e.d.a.b bVar, b9.e eVar) throws IOException {
            eVar.add(f19552b, bVar.getThreads());
            eVar.add(f19553c, bVar.getException());
            eVar.add(f19554d, bVar.getAppExitInfo());
            eVar.add(f19555e, bVar.getSignal());
            eVar.add(f19556f, bVar.getBinaries());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class n implements b9.d<f0.e.d.a.b.c> {

        /* renamed from: a, reason: collision with root package name */
        public static final n f19557a = new n();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19558b = b9.c.of("type");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f19559c = b9.c.of("reason");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f19560d = b9.c.of("frames");

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f19561e = b9.c.of("causedBy");

        /* renamed from: f, reason: collision with root package name */
        public static final b9.c f19562f = b9.c.of("overflowCount");

        @Override // b9.b
        public void encode(f0.e.d.a.b.c cVar, b9.e eVar) throws IOException {
            eVar.add(f19558b, cVar.getType());
            eVar.add(f19559c, cVar.getReason());
            eVar.add(f19560d, cVar.getFrames());
            eVar.add(f19561e, cVar.getCausedBy());
            eVar.add(f19562f, cVar.getOverflowCount());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class o implements b9.d<f0.e.d.a.b.AbstractC0269d> {

        /* renamed from: a, reason: collision with root package name */
        public static final o f19563a = new o();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19564b = b9.c.of(MediationMetaData.KEY_NAME);

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f19565c = b9.c.of("code");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f19566d = b9.c.of("address");

        @Override // b9.b
        public void encode(f0.e.d.a.b.AbstractC0269d abstractC0269d, b9.e eVar) throws IOException {
            eVar.add(f19564b, abstractC0269d.getName());
            eVar.add(f19565c, abstractC0269d.getCode());
            eVar.add(f19566d, abstractC0269d.getAddress());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class p implements b9.d<f0.e.d.a.b.AbstractC0271e> {

        /* renamed from: a, reason: collision with root package name */
        public static final p f19567a = new p();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19568b = b9.c.of(MediationMetaData.KEY_NAME);

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f19569c = b9.c.of("importance");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f19570d = b9.c.of("frames");

        @Override // b9.b
        public void encode(f0.e.d.a.b.AbstractC0271e abstractC0271e, b9.e eVar) throws IOException {
            eVar.add(f19568b, abstractC0271e.getName());
            eVar.add(f19569c, abstractC0271e.getImportance());
            eVar.add(f19570d, abstractC0271e.getFrames());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class q implements b9.d<f0.e.d.a.b.AbstractC0271e.AbstractC0273b> {

        /* renamed from: a, reason: collision with root package name */
        public static final q f19571a = new q();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19572b = b9.c.of("pc");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f19573c = b9.c.of("symbol");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f19574d = b9.c.of("file");

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f19575e = b9.c.of("offset");

        /* renamed from: f, reason: collision with root package name */
        public static final b9.c f19576f = b9.c.of("importance");

        @Override // b9.b
        public void encode(f0.e.d.a.b.AbstractC0271e.AbstractC0273b abstractC0273b, b9.e eVar) throws IOException {
            eVar.add(f19572b, abstractC0273b.getPc());
            eVar.add(f19573c, abstractC0273b.getSymbol());
            eVar.add(f19574d, abstractC0273b.getFile());
            eVar.add(f19575e, abstractC0273b.getOffset());
            eVar.add(f19576f, abstractC0273b.getImportance());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class r implements b9.d<f0.e.d.a.c> {

        /* renamed from: a, reason: collision with root package name */
        public static final r f19577a = new r();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19578b = b9.c.of("processName");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f19579c = b9.c.of("pid");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f19580d = b9.c.of("importance");

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f19581e = b9.c.of("defaultProcess");

        @Override // b9.b
        public void encode(f0.e.d.a.c cVar, b9.e eVar) throws IOException {
            eVar.add(f19578b, cVar.getProcessName());
            eVar.add(f19579c, cVar.getPid());
            eVar.add(f19580d, cVar.getImportance());
            eVar.add(f19581e, cVar.isDefaultProcess());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class s implements b9.d<f0.e.d.c> {

        /* renamed from: a, reason: collision with root package name */
        public static final s f19582a = new s();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19583b = b9.c.of("batteryLevel");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f19584c = b9.c.of("batteryVelocity");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f19585d = b9.c.of("proximityOn");

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f19586e = b9.c.of(AdUnitActivity.EXTRA_ORIENTATION);

        /* renamed from: f, reason: collision with root package name */
        public static final b9.c f19587f = b9.c.of("ramUsed");

        /* renamed from: g, reason: collision with root package name */
        public static final b9.c f19588g = b9.c.of("diskUsed");

        @Override // b9.b
        public void encode(f0.e.d.c cVar, b9.e eVar) throws IOException {
            eVar.add(f19583b, cVar.getBatteryLevel());
            eVar.add(f19584c, cVar.getBatteryVelocity());
            eVar.add(f19585d, cVar.isProximityOn());
            eVar.add(f19586e, cVar.getOrientation());
            eVar.add(f19587f, cVar.getRamUsed());
            eVar.add(f19588g, cVar.getDiskUsed());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class t implements b9.d<f0.e.d> {

        /* renamed from: a, reason: collision with root package name */
        public static final t f19589a = new t();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19590b = b9.c.of("timestamp");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f19591c = b9.c.of("type");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f19592d = b9.c.of("app");

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f19593e = b9.c.of("device");

        /* renamed from: f, reason: collision with root package name */
        public static final b9.c f19594f = b9.c.of("log");

        /* renamed from: g, reason: collision with root package name */
        public static final b9.c f19595g = b9.c.of("rollouts");

        @Override // b9.b
        public void encode(f0.e.d dVar, b9.e eVar) throws IOException {
            eVar.add(f19590b, dVar.getTimestamp());
            eVar.add(f19591c, dVar.getType());
            eVar.add(f19592d, dVar.getApp());
            eVar.add(f19593e, dVar.getDevice());
            eVar.add(f19594f, dVar.getLog());
            eVar.add(f19595g, dVar.getRollouts());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class u implements b9.d<f0.e.d.AbstractC0276d> {

        /* renamed from: a, reason: collision with root package name */
        public static final u f19596a = new u();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19597b = b9.c.of("content");

        @Override // b9.b
        public void encode(f0.e.d.AbstractC0276d abstractC0276d, b9.e eVar) throws IOException {
            eVar.add(f19597b, abstractC0276d.getContent());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class v implements b9.d<f0.e.d.AbstractC0277e> {

        /* renamed from: a, reason: collision with root package name */
        public static final v f19598a = new v();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19599b = b9.c.of("rolloutVariant");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f19600c = b9.c.of("parameterKey");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f19601d = b9.c.of("parameterValue");

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f19602e = b9.c.of("templateVersion");

        @Override // b9.b
        public void encode(f0.e.d.AbstractC0277e abstractC0277e, b9.e eVar) throws IOException {
            eVar.add(f19599b, abstractC0277e.getRolloutVariant());
            eVar.add(f19600c, abstractC0277e.getParameterKey());
            eVar.add(f19601d, abstractC0277e.getParameterValue());
            eVar.add(f19602e, abstractC0277e.getTemplateVersion());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class w implements b9.d<f0.e.d.AbstractC0277e.b> {

        /* renamed from: a, reason: collision with root package name */
        public static final w f19603a = new w();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19604b = b9.c.of("rolloutId");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f19605c = b9.c.of("variantId");

        @Override // b9.b
        public void encode(f0.e.d.AbstractC0277e.b bVar, b9.e eVar) throws IOException {
            eVar.add(f19604b, bVar.getRolloutId());
            eVar.add(f19605c, bVar.getVariantId());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class x implements b9.d<f0.e.d.f> {

        /* renamed from: a, reason: collision with root package name */
        public static final x f19606a = new x();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19607b = b9.c.of("assignments");

        @Override // b9.b
        public void encode(f0.e.d.f fVar, b9.e eVar) throws IOException {
            eVar.add(f19607b, fVar.getRolloutAssignments());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class y implements b9.d<f0.e.AbstractC0278e> {

        /* renamed from: a, reason: collision with root package name */
        public static final y f19608a = new y();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19609b = b9.c.of("platform");

        /* renamed from: c, reason: collision with root package name */
        public static final b9.c f19610c = b9.c.of("version");

        /* renamed from: d, reason: collision with root package name */
        public static final b9.c f19611d = b9.c.of("buildVersion");

        /* renamed from: e, reason: collision with root package name */
        public static final b9.c f19612e = b9.c.of("jailbroken");

        @Override // b9.b
        public void encode(f0.e.AbstractC0278e abstractC0278e, b9.e eVar) throws IOException {
            eVar.add(f19609b, abstractC0278e.getPlatform());
            eVar.add(f19610c, abstractC0278e.getVersion());
            eVar.add(f19611d, abstractC0278e.getBuildVersion());
            eVar.add(f19612e, abstractC0278e.isJailbroken());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class z implements b9.d<f0.e.f> {

        /* renamed from: a, reason: collision with root package name */
        public static final z f19613a = new z();

        /* renamed from: b, reason: collision with root package name */
        public static final b9.c f19614b = b9.c.of("identifier");

        @Override // b9.b
        public void encode(f0.e.f fVar, b9.e eVar) throws IOException {
            eVar.add(f19614b, fVar.getIdentifier());
        }
    }

    @Override // c9.a
    public void configure(c9.b<?> bVar) {
        d dVar = d.f19487a;
        bVar.registerEncoder(f0.class, dVar);
        bVar.registerEncoder(t8.b.class, dVar);
        j jVar = j.f19525a;
        bVar.registerEncoder(f0.e.class, jVar);
        bVar.registerEncoder(t8.h.class, jVar);
        g gVar = g.f19505a;
        bVar.registerEncoder(f0.e.a.class, gVar);
        bVar.registerEncoder(t8.i.class, gVar);
        h hVar = h.f19513a;
        bVar.registerEncoder(f0.e.a.b.class, hVar);
        bVar.registerEncoder(t8.j.class, hVar);
        z zVar = z.f19613a;
        bVar.registerEncoder(f0.e.f.class, zVar);
        bVar.registerEncoder(a0.class, zVar);
        y yVar = y.f19608a;
        bVar.registerEncoder(f0.e.AbstractC0278e.class, yVar);
        bVar.registerEncoder(t8.z.class, yVar);
        i iVar = i.f19515a;
        bVar.registerEncoder(f0.e.c.class, iVar);
        bVar.registerEncoder(t8.k.class, iVar);
        t tVar = t.f19589a;
        bVar.registerEncoder(f0.e.d.class, tVar);
        bVar.registerEncoder(t8.l.class, tVar);
        k kVar = k.f19538a;
        bVar.registerEncoder(f0.e.d.a.class, kVar);
        bVar.registerEncoder(t8.m.class, kVar);
        m mVar = m.f19551a;
        bVar.registerEncoder(f0.e.d.a.b.class, mVar);
        bVar.registerEncoder(t8.n.class, mVar);
        p pVar = p.f19567a;
        bVar.registerEncoder(f0.e.d.a.b.AbstractC0271e.class, pVar);
        bVar.registerEncoder(t8.r.class, pVar);
        q qVar = q.f19571a;
        bVar.registerEncoder(f0.e.d.a.b.AbstractC0271e.AbstractC0273b.class, qVar);
        bVar.registerEncoder(t8.s.class, qVar);
        n nVar = n.f19557a;
        bVar.registerEncoder(f0.e.d.a.b.c.class, nVar);
        bVar.registerEncoder(t8.p.class, nVar);
        b bVar2 = b.f19474a;
        bVar.registerEncoder(f0.a.class, bVar2);
        bVar.registerEncoder(t8.c.class, bVar2);
        C0260a c0260a = C0260a.f19470a;
        bVar.registerEncoder(f0.a.AbstractC0261a.class, c0260a);
        bVar.registerEncoder(t8.d.class, c0260a);
        o oVar = o.f19563a;
        bVar.registerEncoder(f0.e.d.a.b.AbstractC0269d.class, oVar);
        bVar.registerEncoder(t8.q.class, oVar);
        l lVar = l.f19546a;
        bVar.registerEncoder(f0.e.d.a.b.AbstractC0265a.class, lVar);
        bVar.registerEncoder(t8.o.class, lVar);
        c cVar = c.f19484a;
        bVar.registerEncoder(f0.c.class, cVar);
        bVar.registerEncoder(t8.e.class, cVar);
        r rVar = r.f19577a;
        bVar.registerEncoder(f0.e.d.a.c.class, rVar);
        bVar.registerEncoder(t8.t.class, rVar);
        s sVar = s.f19582a;
        bVar.registerEncoder(f0.e.d.c.class, sVar);
        bVar.registerEncoder(t8.u.class, sVar);
        u uVar = u.f19596a;
        bVar.registerEncoder(f0.e.d.AbstractC0276d.class, uVar);
        bVar.registerEncoder(t8.v.class, uVar);
        x xVar = x.f19606a;
        bVar.registerEncoder(f0.e.d.f.class, xVar);
        bVar.registerEncoder(t8.y.class, xVar);
        v vVar = v.f19598a;
        bVar.registerEncoder(f0.e.d.AbstractC0277e.class, vVar);
        bVar.registerEncoder(t8.w.class, vVar);
        w wVar = w.f19603a;
        bVar.registerEncoder(f0.e.d.AbstractC0277e.b.class, wVar);
        bVar.registerEncoder(t8.x.class, wVar);
        e eVar = e.f19499a;
        bVar.registerEncoder(f0.d.class, eVar);
        bVar.registerEncoder(t8.f.class, eVar);
        f fVar = f.f19502a;
        bVar.registerEncoder(f0.d.b.class, fVar);
        bVar.registerEncoder(t8.g.class, fVar);
    }
}
