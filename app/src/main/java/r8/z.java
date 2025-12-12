package r8;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import t8.f0;

/* compiled from: CrashlyticsReportDataCapture.java */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: g, reason: collision with root package name */
    public static final HashMap f18799g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f18800h;

    /* renamed from: a, reason: collision with root package name */
    public final Context f18801a;

    /* renamed from: b, reason: collision with root package name */
    public final h0 f18802b;

    /* renamed from: c, reason: collision with root package name */
    public final a f18803c;

    /* renamed from: d, reason: collision with root package name */
    public final z8.d f18804d;

    /* renamed from: e, reason: collision with root package name */
    public final y8.g f18805e;

    /* renamed from: f, reason: collision with root package name */
    public final o8.g f18806f = o8.g.f17048a;

    static {
        HashMap map = new HashMap();
        f18799g = map;
        o1.a.i(5, map, "armeabi", 6, "armeabi-v7a", 9, "arm64-v8a", 0, "x86");
        map.put("x86_64", 1);
        f18800h = String.format(Locale.US, "Crashlytics Android SDK/%s", "18.6.3");
    }

    public z(Context context, h0 h0Var, a aVar, z8.d dVar, y8.g gVar) {
        this.f18801a = context;
        this.f18802b = h0Var;
        this.f18803c = aVar;
        this.f18804d = dVar;
        this.f18805e = gVar;
    }

    public static f0.e.d.a.b.c c(z8.e eVar, int i10, int i11, int i12) {
        int i13 = 0;
        StackTraceElement[] stackTraceElementArr = eVar.f22626c;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        z8.e eVar2 = eVar.f22627d;
        if (i12 >= i11) {
            for (z8.e eVar3 = eVar2; eVar3 != null; eVar3 = eVar3.f22627d) {
                i13++;
            }
        }
        f0.e.d.a.b.c.AbstractC0268a overflowCount = f0.e.d.a.b.c.builder().setType(eVar.f22625b).setReason(eVar.f22624a).setFrames(d(stackTraceElementArr, i10)).setOverflowCount(i13);
        if (eVar2 != null && i13 == 0) {
            overflowCount.setCausedBy(c(eVar2, i10, i11, i12 + 1));
        }
        return overflowCount.build();
    }

    public static List d(StackTraceElement[] stackTraceElementArr, int i10) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            f0.e.d.a.b.AbstractC0271e.AbstractC0273b.AbstractC0274a importance = f0.e.d.a.b.AbstractC0271e.AbstractC0273b.builder().setImportance(i10);
            long lineNumber = 0;
            long jMax = stackTraceElement.isNativeMethod() ? Math.max(stackTraceElement.getLineNumber(), 0L) : 0L;
            String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
            String fileName = stackTraceElement.getFileName();
            if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
                lineNumber = stackTraceElement.getLineNumber();
            }
            arrayList.add(importance.setPc(jMax).setSymbol(str).setFile(fileName).setOffset(lineNumber).build());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static f0.e.d.a.b.AbstractC0271e e(Thread thread, StackTraceElement[] stackTraceElementArr, int i10) {
        return f0.e.d.a.b.AbstractC0271e.builder().setName(thread.getName()).setImportance(i10).setFrames(d(stackTraceElementArr, i10)).build();
    }

    public final List<f0.e.d.a.b.AbstractC0265a> a() {
        f0.e.d.a.b.AbstractC0265a.AbstractC0266a size = f0.e.d.a.b.AbstractC0265a.builder().setBaseAddress(0L).setSize(0L);
        a aVar = this.f18803c;
        return Collections.singletonList(size.setName(aVar.f18660e).setUuid(aVar.f18657b).build());
    }

    public final f0.e.d.c b(int i10) {
        Context context = this.f18801a;
        e eVar = e.get(context);
        Float batteryLevel = eVar.getBatteryLevel();
        Double dValueOf = batteryLevel != null ? Double.valueOf(batteryLevel.doubleValue()) : null;
        int batteryVelocity = eVar.getBatteryVelocity();
        boolean proximitySensorEnabled = CommonUtils.getProximitySensorEnabled(context);
        long jCalculateTotalRamInBytes = CommonUtils.calculateTotalRamInBytes(context) - CommonUtils.calculateFreeRamInBytes(context);
        if (jCalculateTotalRamInBytes <= 0) {
            jCalculateTotalRamInBytes = 0;
        }
        return f0.e.d.c.builder().setBatteryLevel(dValueOf).setBatteryVelocity(batteryVelocity).setProximityOn(proximitySensorEnabled).setOrientation(i10).setRamUsed(jCalculateTotalRamInBytes).setDiskUsed(CommonUtils.calculateUsedDiskSpaceInBytes(Environment.getDataDirectory().getPath())).build();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public t8.f0.e.d captureAnrEventData(t8.f0.a r8) {
        /*
            r7 = this;
            android.content.Context r0 = r7.f18801a
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.orientation
            t8.f0$e$d$b r1 = t8.f0.e.d.builder()
            java.lang.String r2 = "anr"
            t8.f0$e$d$b r1 = r1.setType(r2)
            long r2 = r8.getTimestamp()
            t8.f0$e$d$b r1 = r1.setTimestamp(r2)
            y8.g r2 = r7.f18805e
            com.google.firebase.crashlytics.internal.settings.a r2 = (com.google.firebase.crashlytics.internal.settings.a) r2
            y8.d r2 = r2.getSettingsSync()
            y8.d$a r2 = r2.f22023b
            boolean r2 = r2.f22030c
            if (r2 == 0) goto L76
            r8.a r2 = r7.f18803c
            java.util.List<r8.f> r3 = r2.f18658c
            int r3 = r3.size()
            if (r3 <= 0) goto L76
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List<r8.f> r2 = r2.f18658c
            java.util.Iterator r2 = r2.iterator()
        L41:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L71
            java.lang.Object r4 = r2.next()
            r8.f r4 = (r8.f) r4
            t8.f0$a$a$a r5 = t8.f0.a.AbstractC0261a.builder()
            java.lang.String r6 = r4.getLibraryName()
            t8.f0$a$a$a r5 = r5.setLibraryName(r6)
            java.lang.String r6 = r4.getArch()
            t8.f0$a$a$a r5 = r5.setArch(r6)
            java.lang.String r4 = r4.getBuildId()
            t8.f0$a$a$a r4 = r5.setBuildId(r4)
            t8.f0$a$a r4 = r4.build()
            r3.add(r4)
            goto L41
        L71:
            java.util.List r2 = java.util.Collections.unmodifiableList(r3)
            goto L77
        L76:
            r2 = 0
        L77:
            t8.f0$a$b r3 = t8.f0.a.builder()
            int r4 = r8.getImportance()
            t8.f0$a$b r3 = r3.setImportance(r4)
            java.lang.String r4 = r8.getProcessName()
            t8.f0$a$b r3 = r3.setProcessName(r4)
            int r4 = r8.getReasonCode()
            t8.f0$a$b r3 = r3.setReasonCode(r4)
            long r4 = r8.getTimestamp()
            t8.f0$a$b r3 = r3.setTimestamp(r4)
            int r4 = r8.getPid()
            t8.f0$a$b r3 = r3.setPid(r4)
            long r4 = r8.getPss()
            t8.f0$a$b r3 = r3.setPss(r4)
            long r4 = r8.getRss()
            t8.f0$a$b r3 = r3.setRss(r4)
            java.lang.String r8 = r8.getTraceFile()
            t8.f0$a$b r8 = r3.setTraceFile(r8)
            t8.f0$a$b r8 = r8.setBuildIdMappingForArch(r2)
            t8.f0$a r8 = r8.build()
            int r2 = r8.getImportance()
            r3 = 100
            if (r2 == r3) goto Lcd
            r2 = 1
            goto Lce
        Lcd:
            r2 = 0
        Lce:
            t8.f0$e$d$a$a r3 = t8.f0.e.d.a.builder()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            t8.f0$e$d$a$a r2 = r3.setBackground(r2)
            java.lang.String r3 = r8.getProcessName()
            int r4 = r8.getPid()
            int r5 = r8.getImportance()
            o8.g r6 = r7.f18806f
            t8.f0$e$d$a$c r3 = r6.buildProcessDetails(r3, r4, r5)
            t8.f0$e$d$a$a r2 = r2.setCurrentProcessDetails(r3)
            t8.f0$e$d$a$a r2 = r2.setUiOrientation(r0)
            t8.f0$e$d$a$b$b r3 = t8.f0.e.d.a.b.builder()
            t8.f0$e$d$a$b$b r8 = r3.setAppExitInfo(r8)
            t8.f0$e$d$a$b$d$a r3 = t8.f0.e.d.a.b.AbstractC0269d.builder()
            java.lang.String r4 = "0"
            t8.f0$e$d$a$b$d$a r3 = r3.setName(r4)
            t8.f0$e$d$a$b$d$a r3 = r3.setCode(r4)
            r4 = 0
            t8.f0$e$d$a$b$d$a r3 = r3.setAddress(r4)
            t8.f0$e$d$a$b$d r3 = r3.build()
            t8.f0$e$d$a$b$b r8 = r8.setSignal(r3)
            java.util.List r3 = r7.a()
            t8.f0$e$d$a$b$b r8 = r8.setBinaries(r3)
            t8.f0$e$d$a$b r8 = r8.build()
            t8.f0$e$d$a$a r8 = r2.setExecution(r8)
            t8.f0$e$d$a r8 = r8.build()
            t8.f0$e$d$b r8 = r1.setApp(r8)
            t8.f0$e$d$c r0 = r7.b(r0)
            t8.f0$e$d$b r8 = r8.setDevice(r0)
            t8.f0$e$d r8 = r8.build()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: r8.z.captureAnrEventData(t8.f0$a):t8.f0$e$d");
    }

    public f0.e.d captureEventData(Throwable th2, Thread thread, String str, long j10, int i10, int i11, boolean z10) {
        Context context = this.f18801a;
        int i12 = context.getResources().getConfiguration().orientation;
        z8.d dVar = this.f18804d;
        z8.e eVarMakeTrimmedThrowableData = z8.e.makeTrimmedThrowableData(th2, dVar);
        f0.e.d.b timestamp = f0.e.d.builder().setType(str).setTimestamp(j10);
        o8.g gVar = this.f18806f;
        f0.e.d.a.c currentProcessDetails = gVar.getCurrentProcessDetails(context);
        f0.e.d.a.AbstractC0264a uiOrientation = f0.e.d.a.builder().setBackground(currentProcessDetails.getImportance() > 0 ? Boolean.valueOf(currentProcessDetails.getImportance() != 100) : null).setCurrentProcessDetails(currentProcessDetails).setAppProcessDetails(gVar.getAppProcessDetails(context)).setUiOrientation(i12);
        f0.e.d.a.b.AbstractC0267b abstractC0267bBuilder = f0.e.d.a.b.builder();
        ArrayList arrayList = new ArrayList();
        arrayList.add(e(thread, eVarMakeTrimmedThrowableData.f22626c, i10));
        if (z10) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = entry.getKey();
                if (!key.equals(thread)) {
                    arrayList.add(e(key, dVar.getTrimmedStackTrace(entry.getValue()), 0));
                }
            }
        }
        return timestamp.setApp(uiOrientation.setExecution(abstractC0267bBuilder.setThreads(Collections.unmodifiableList(arrayList)).setException(c(eVarMakeTrimmedThrowableData, i10, i11, 0)).setSignal(f0.e.d.a.b.AbstractC0269d.builder().setName("0").setCode("0").setAddress(0L).build()).setBinaries(a()).build()).build()).setDevice(b(i12)).build();
    }

    public t8.f0 captureReportData(String str, long j10) {
        Integer num;
        f0.b sdkVersion = t8.f0.builder().setSdkVersion("18.6.3");
        a aVar = this.f18803c;
        f0.b gmpAppId = sdkVersion.setGmpAppId(aVar.f18656a);
        h0 h0Var = this.f18802b;
        f0.b firebaseInstallationId = gmpAppId.setInstallationUuid(h0Var.getInstallIds().getCrashlyticsInstallId()).setFirebaseInstallationId(h0Var.getInstallIds().getFirebaseInstallationId());
        String str2 = aVar.f18661f;
        f0.b buildVersion = firebaseInstallationId.setBuildVersion(str2);
        String str3 = aVar.f18662g;
        f0.b platform = buildVersion.setDisplayVersion(str3).setPlatform(4);
        f0.e.b generator = f0.e.builder().setStartedAt(j10).setIdentifier(str).setGenerator(f18800h);
        f0.e.a.AbstractC0263a installationUuid = f0.e.a.builder().setIdentifier(h0Var.getAppIdentifier()).setVersion(str2).setDisplayVersion(str3).setInstallationUuid(h0Var.getInstallIds().getCrashlyticsInstallId());
        o8.d dVar = aVar.f18663h;
        f0.e.b os = generator.setApp(installationUuid.setDevelopmentPlatform(dVar.getDevelopmentPlatform()).setDevelopmentPlatformVersion(dVar.getDevelopmentPlatformVersion()).build()).setOs(f0.e.AbstractC0278e.builder().setPlatform(3).setVersion(Build.VERSION.RELEASE).setBuildVersion(Build.VERSION.CODENAME).setJailbroken(CommonUtils.isRooted()).build());
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        String str4 = Build.CPU_ABI;
        int iIntValue = (TextUtils.isEmpty(str4) || (num = (Integer) f18799g.get(str4.toLowerCase(Locale.US))) == null) ? 7 : num.intValue();
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        long jCalculateTotalRamInBytes = CommonUtils.calculateTotalRamInBytes(this.f18801a);
        long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        return platform.setSession(os.setDevice(f0.e.c.builder().setArch(iIntValue).setModel(Build.MODEL).setCores(iAvailableProcessors).setRam(jCalculateTotalRamInBytes).setDiskSpace(blockCount).setSimulator(CommonUtils.isEmulator()).setState(CommonUtils.getDeviceState()).setManufacturer(Build.MANUFACTURER).setModelClass(Build.PRODUCT).build()).setGeneratorType(3).build()).build();
    }
}
