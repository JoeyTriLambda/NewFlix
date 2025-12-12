package r8;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import o8.b;
import t8.f0;
import t8.g0;

/* compiled from: CrashlyticsController.java */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: r, reason: collision with root package name */
    public static final i f18743r = new i(1);

    /* renamed from: a, reason: collision with root package name */
    public final Context f18744a;

    /* renamed from: b, reason: collision with root package name */
    public final d0 f18745b;

    /* renamed from: c, reason: collision with root package name */
    public final y f18746c;

    /* renamed from: d, reason: collision with root package name */
    public final s8.m f18747d;

    /* renamed from: e, reason: collision with root package name */
    public final l f18748e;

    /* renamed from: f, reason: collision with root package name */
    public final h0 f18749f;

    /* renamed from: g, reason: collision with root package name */
    public final w8.b f18750g;

    /* renamed from: h, reason: collision with root package name */
    public final r8.a f18751h;

    /* renamed from: i, reason: collision with root package name */
    public final s8.e f18752i;

    /* renamed from: j, reason: collision with root package name */
    public final o8.a f18753j;

    /* renamed from: k, reason: collision with root package name */
    public final p8.a f18754k;

    /* renamed from: l, reason: collision with root package name */
    public final k f18755l;

    /* renamed from: m, reason: collision with root package name */
    public final m0 f18756m;

    /* renamed from: n, reason: collision with root package name */
    public b0 f18757n;

    /* renamed from: o, reason: collision with root package name */
    public final TaskCompletionSource<Boolean> f18758o = new TaskCompletionSource<>();

    /* renamed from: p, reason: collision with root package name */
    public final TaskCompletionSource<Boolean> f18759p = new TaskCompletionSource<>();

    /* renamed from: q, reason: collision with root package name */
    public final TaskCompletionSource<Void> f18760q = new TaskCompletionSource<>();

    /* compiled from: CrashlyticsController.java */
    public class a implements SuccessContinuation<Boolean, Void> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Task f18761a;

        /* compiled from: CrashlyticsController.java */
        /* renamed from: r8.r$a$a, reason: collision with other inner class name */
        public class CallableC0242a implements Callable<Task<Void>> {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Boolean f18763b;

            /* compiled from: CrashlyticsController.java */
            /* renamed from: r8.r$a$a$a, reason: collision with other inner class name */
            public class C0243a implements SuccessContinuation<y8.d, Void> {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Executor f18765a;

                public C0243a(Executor executor) {
                    this.f18765a = executor;
                }

                @Override // com.google.android.gms.tasks.SuccessContinuation
                public Task<Void> then(y8.d dVar) throws Exception {
                    if (dVar == null) {
                        o8.e.getLogger().w("Received null app settings at app startup. Cannot send cached reports");
                        return Tasks.forResult(null);
                    }
                    CallableC0242a callableC0242a = CallableC0242a.this;
                    r.b(r.this);
                    r.this.f18756m.sendReports(this.f18765a);
                    r.this.f18760q.trySetResult(null);
                    return Tasks.forResult(null);
                }
            }

            public CallableC0242a(Boolean bool) {
                this.f18763b = bool;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Task<Void> call() throws Exception {
                Boolean bool = this.f18763b;
                boolean zBooleanValue = bool.booleanValue();
                a aVar = a.this;
                if (zBooleanValue) {
                    o8.e.getLogger().d("Sending cached crash reports...");
                    r.this.f18745b.grantDataCollectionPermission(bool.booleanValue());
                    Executor executor = r.this.f18748e.getExecutor();
                    return aVar.f18761a.onSuccessTask(executor, new C0243a(executor));
                }
                o8.e.getLogger().v("Deleting cached crash reports...");
                r rVar = r.this;
                Iterator<File> it = rVar.f18750g.getCommonFiles(r.f18743r).iterator();
                while (it.hasNext()) {
                    it.next().delete();
                }
                r rVar2 = r.this;
                rVar2.f18756m.removeAllReports();
                rVar2.f18760q.trySetResult(null);
                return Tasks.forResult(null);
            }
        }

        public a(Task task) {
            this.f18761a = task;
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        public Task<Void> then(Boolean bool) throws Exception {
            return r.this.f18748e.submitTask(new CallableC0242a(bool));
        }
    }

    public r(Context context, l lVar, h0 h0Var, d0 d0Var, w8.b bVar, y yVar, r8.a aVar, s8.m mVar, s8.e eVar, m0 m0Var, o8.a aVar2, p8.a aVar3, k kVar) {
        new AtomicBoolean(false);
        this.f18744a = context;
        this.f18748e = lVar;
        this.f18749f = h0Var;
        this.f18745b = d0Var;
        this.f18750g = bVar;
        this.f18746c = yVar;
        this.f18751h = aVar;
        this.f18747d = mVar;
        this.f18752i = eVar;
        this.f18753j = aVar2;
        this.f18754k = aVar3;
        this.f18755l = kVar;
        this.f18756m = m0Var;
    }

    public static void a(r rVar, String str, Boolean bool) {
        rVar.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        o8.e.getLogger().d("Opening a new session with ID " + str);
        String str2 = String.format(Locale.US, "Crashlytics Android SDK/%s", w.getVersion());
        h0 h0Var = rVar.f18749f;
        String appIdentifier = h0Var.getAppIdentifier();
        r8.a aVar = rVar.f18751h;
        g0.a aVarCreate = g0.a.create(appIdentifier, aVar.f18661f, aVar.f18662g, h0Var.getInstallIds().getCrashlyticsInstallId(), DeliveryMechanism.determineFrom(aVar.f18659d).getId(), aVar.f18663h);
        g0.c cVarCreate = g0.c.create(Build.VERSION.RELEASE, Build.VERSION.CODENAME, CommonUtils.isRooted());
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        rVar.f18753j.prepareNativeSession(str, str2, jCurrentTimeMillis, t8.g0.create(aVarCreate, cVarCreate, g0.b.create(CommonUtils.getCpuArchitectureInt(), Build.MODEL, Runtime.getRuntime().availableProcessors(), CommonUtils.calculateTotalRamInBytes(rVar.f18744a), statFs.getBlockCount() * statFs.getBlockSize(), CommonUtils.isEmulator(), CommonUtils.getDeviceState(), Build.MANUFACTURER, Build.PRODUCT)));
        if (bool.booleanValue() && str != null) {
            rVar.f18747d.setNewSession(str);
        }
        rVar.f18752i.setCurrentSession(str);
        rVar.f18755l.setSessionId(str);
        rVar.f18756m.onBeginSession(str, jCurrentTimeMillis);
    }

    public static Task b(r rVar) throws NumberFormatException, ClassNotFoundException {
        boolean z10;
        Task taskCall;
        rVar.getClass();
        ArrayList arrayList = new ArrayList();
        for (File file : rVar.f18750g.getCommonFiles(f18743r)) {
            try {
                long j10 = Long.parseLong(file.getName().substring(3));
                try {
                    Class.forName("com.google.firebase.crash.FirebaseCrash");
                    z10 = true;
                } catch (ClassNotFoundException unused) {
                    z10 = false;
                }
                if (z10) {
                    o8.e.getLogger().w("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
                    taskCall = Tasks.forResult(null);
                } else {
                    o8.e.getLogger().d("Logging app exception event to Firebase Analytics");
                    taskCall = Tasks.call(new ScheduledThreadPoolExecutor(1), new u(rVar, j10));
                }
                arrayList.add(taskCall);
            } catch (NumberFormatException unused2) {
                o8.e.getLogger().w("Could not parse app exception timestamp from file " + file.getName());
            }
            file.delete();
        }
        return Tasks.whenAll(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String f() throws java.io.IOException {
        /*
            java.lang.Class<r8.r> r0 = r8.r.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            r1 = 0
            if (r0 != 0) goto L13
            o8.e r0 = o8.e.getLogger()
            java.lang.String r2 = "Couldn't get Class Loader"
            r0.w(r2)
            goto L24
        L13:
            java.lang.String r2 = "META-INF/version-control-info.textproto"
            java.io.InputStream r0 = r0.getResourceAsStream(r2)
            if (r0 != 0) goto L25
            o8.e r0 = o8.e.getLogger()
            java.lang.String r2 = "No version control information found"
            r0.i(r2)
        L24:
            r0 = r1
        L25:
            if (r0 != 0) goto L28
            return r1
        L28:
            o8.e r1 = o8.e.getLogger()
            java.lang.String r2 = "Read version control info"
            r1.d(r2)
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]
        L3a:
            int r3 = r0.read(r2)
            r4 = -1
            r5 = 0
            if (r3 == r4) goto L46
            r1.write(r2, r5, r3)
            goto L3a
        L46:
            byte[] r0 = r1.toByteArray()
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: r8.r.f():java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v11, types: [r8.g0] */
    /* JADX WARN: Type inference failed for: r18v0, types: [boolean] */
    public final void c(boolean z10, y8.g gVar) {
        ArrayList arrayList;
        String str;
        InputStream inputStream;
        InputStream stream;
        m0 m0Var = this.f18756m;
        ArrayList arrayList2 = new ArrayList(m0Var.listSortedOpenSessionIds());
        if (arrayList2.size() <= z10) {
            o8.e.getLogger().v("No open sessions to be closed.");
            return;
        }
        String str2 = (String) arrayList2.get(z10 == true ? 1 : 0);
        boolean z11 = ((com.google.firebase.crashlytics.internal.settings.a) gVar).getSettingsSync().f22023b.f22029b;
        w8.b bVar = this.f18750g;
        if (z11) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                List<ApplicationExitInfo> historicalProcessExitReasons = ((ActivityManager) this.f18744a.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
                if (historicalProcessExitReasons.size() != 0) {
                    m0Var.persistRelevantAppExitInfoEvent(str2, historicalProcessExitReasons, new s8.e(bVar, str2), s8.m.loadFromExistingSession(str2, bVar, this.f18748e));
                } else {
                    o8.e.getLogger().v("No ApplicationExitInfo available. Session: " + str2);
                }
            } else {
                o8.e.getLogger().v("ANR feature enabled, but device is API " + i10);
            }
        } else {
            o8.e.getLogger().v("ANR feature disabled.");
        }
        o8.a aVar = this.f18753j;
        if (aVar.hasCrashDataForSession(str2)) {
            o8.e.getLogger().v("Finalizing native report for session " + str2);
            b.a aVar2 = (b.a) aVar.getSessionFileProvider(str2);
            File minidumpFile = aVar2.getMinidumpFile();
            f0.a applicationExitInto = aVar2.getApplicationExitInto();
            if (minidumpFile == null || !minidumpFile.exists()) {
                o8.e.getLogger().w("No minidump data found for session " + str2);
            }
            if (applicationExitInto == null) {
                o8.e.getLogger().i("No Tombstones data found for session " + str2);
            }
            if ((minidumpFile == null || !minidumpFile.exists()) && applicationExitInto == null) {
                o8.e.getLogger().w("No native core present");
            } else {
                long jLastModified = minidumpFile.lastModified();
                s8.e eVar = new s8.e(bVar, str2);
                File nativeSessionDir = bVar.getNativeSessionDir(str2);
                if (nativeSessionDir.isDirectory()) {
                    d(jLastModified);
                    byte[] bytesForLog = eVar.getBytesForLog();
                    File sessionFile = bVar.getSessionFile(str2, "user-data");
                    File sessionFile2 = bVar.getSessionFile(str2, "keys");
                    File sessionFile3 = bVar.getSessionFile(str2, "rollouts-state");
                    ArrayList arrayList3 = new ArrayList();
                    arrayList = arrayList2;
                    arrayList3.add(new g("logs_file", "logs", bytesForLog));
                    arrayList3.add(new g0("crash_meta_file", "metadata", aVar2.getMetadataFile()));
                    arrayList3.add(new g0("session_meta_file", "session", aVar2.getSessionFile()));
                    arrayList3.add(new g0("app_meta_file", "app", aVar2.getAppFile()));
                    arrayList3.add(new g0("device_meta_file", "device", aVar2.getDeviceFile()));
                    arrayList3.add(new g0("os_meta_file", "os", aVar2.getOsFile()));
                    File minidumpFile2 = aVar2.getMinidumpFile();
                    arrayList3.add((minidumpFile2 == null || !minidumpFile2.exists()) ? new g("minidump_file", "minidump", new byte[]{0}) : new g0("minidump_file", "minidump", minidumpFile2));
                    arrayList3.add(new g0("user_meta_file", "user", sessionFile));
                    arrayList3.add(new g0("keys_file", "keys", sessionFile2));
                    arrayList3.add(new g0("rollouts_file", "rollouts", sessionFile3));
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        j0 j0Var = (j0) it.next();
                        try {
                            stream = j0Var.getStream();
                            if (stream != null) {
                                try {
                                    k0.a(new File(nativeSessionDir, j0Var.getReportsEndpointFilename()), stream);
                                } catch (IOException unused) {
                                } catch (Throwable th2) {
                                    th = th2;
                                    inputStream = stream;
                                    CommonUtils.closeQuietly(inputStream);
                                    throw th;
                                }
                            }
                        } catch (IOException unused2) {
                            stream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = null;
                        }
                        CommonUtils.closeQuietly(stream);
                    }
                    o8.e.getLogger().d("CrashlyticsController#finalizePreviousNativeSession");
                    m0Var.finalizeSessionWithNativeEvent(str2, arrayList3, applicationExitInto);
                    eVar.clearLog();
                } else {
                    o8.e.getLogger().w("Couldn't create directory to store native session files, aborting.");
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = arrayList2;
        }
        if (z10 != 0) {
            str = (String) arrayList.get(0);
        } else {
            this.f18755l.setSessionId(null);
            str = null;
        }
        m0Var.finalizeSessions(System.currentTimeMillis() / 1000, str);
    }

    public final void d(long j10) {
        try {
            if (this.f18750g.getCommonFile(".ae" + j10).createNewFile()) {
            } else {
                throw new IOException("Create new file failed.");
            }
        } catch (IOException e10) {
            o8.e.getLogger().w("Could not create app exception marker file.", e10);
        }
    }

    public final boolean e(y8.g gVar) {
        this.f18748e.checkRunningOnThread();
        b0 b0Var = this.f18757n;
        if (b0Var != null && b0Var.f18671e.get()) {
            o8.e.getLogger().w("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        o8.e.getLogger().v("Finalizing previously open sessions.");
        try {
            c(true, gVar);
            o8.e.getLogger().v("Closed all previously open sessions.");
            return true;
        } catch (Exception e10) {
            o8.e.getLogger().e("Unable to finalize previously open sessions.", e10);
            return false;
        }
    }

    public final void g() {
        try {
            String strF = f();
            if (strF != null) {
                try {
                    this.f18747d.setInternalKey("com.crashlytics.version-control-info", strF);
                } catch (IllegalArgumentException e10) {
                    Context context = this.f18744a;
                    if (context != null && CommonUtils.isAppDebuggable(context)) {
                        throw e10;
                    }
                    o8.e.getLogger().e("Attempting to set custom attribute with null key, ignoring.");
                }
                o8.e.getLogger().i("Saved version control info");
            }
        } catch (IOException e11) {
            o8.e.getLogger().w("Unable to save version control info", e11);
        }
    }

    @SuppressLint({"TaskMainThread"})
    public final Task<Void> h(Task<y8.d> task) {
        Task taskRace;
        boolean zHasReportsToSend = this.f18756m.hasReportsToSend();
        TaskCompletionSource<Boolean> taskCompletionSource = this.f18758o;
        if (!zHasReportsToSend) {
            o8.e.getLogger().v("No crash reports are available to be sent.");
            taskCompletionSource.trySetResult(Boolean.FALSE);
            return Tasks.forResult(null);
        }
        o8.e.getLogger().v("Crash reports are available to be sent.");
        d0 d0Var = this.f18745b;
        if (d0Var.isAutomaticDataCollectionEnabled()) {
            o8.e.getLogger().d("Automatic data collection is enabled. Allowing upload.");
            taskCompletionSource.trySetResult(Boolean.FALSE);
            taskRace = Tasks.forResult(Boolean.TRUE);
        } else {
            o8.e.getLogger().d("Automatic data collection is disabled.");
            o8.e.getLogger().v("Notifying that unsent reports are available.");
            taskCompletionSource.trySetResult(Boolean.TRUE);
            Task<TContinuationResult> taskOnSuccessTask = d0Var.waitForAutomaticDataCollectionEnabled().onSuccessTask(new q());
            o8.e.getLogger().d("Waiting for send/deleteUnsentReports to be called.");
            taskRace = p0.race(taskOnSuccessTask, this.f18759p.getTask());
        }
        return taskRace.onSuccessTask(new a(task));
    }
}
