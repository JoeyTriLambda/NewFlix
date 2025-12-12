package r8;

import android.app.ApplicationExitInfo;
import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.Executor;
import t8.f0;

/* compiled from: SessionReportingCoordinator.java */
/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    public final z f18724a;

    /* renamed from: b, reason: collision with root package name */
    public final w8.a f18725b;

    /* renamed from: c, reason: collision with root package name */
    public final x8.a f18726c;

    /* renamed from: d, reason: collision with root package name */
    public final s8.e f18727d;

    /* renamed from: e, reason: collision with root package name */
    public final s8.m f18728e;

    /* renamed from: f, reason: collision with root package name */
    public final h0 f18729f;

    public m0(z zVar, w8.a aVar, x8.a aVar2, s8.e eVar, s8.m mVar, h0 h0Var) {
        this.f18724a = zVar;
        this.f18725b = aVar;
        this.f18726c = aVar2;
        this.f18727d = eVar;
        this.f18728e = mVar;
        this.f18729f = h0Var;
    }

    public static f0.e.d a(f0.e.d dVar, s8.e eVar, s8.m mVar) {
        f0.e.d.b builder = dVar.toBuilder();
        String logString = eVar.getLogString();
        if (logString != null) {
            builder.setLog(f0.e.d.AbstractC0276d.builder().setContent(logString).build());
        } else {
            o8.e.getLogger().v("No log data to include with this event.");
        }
        List<f0.c> listC = c(mVar.getCustomKeys());
        List<f0.c> listC2 = c(mVar.getInternalKeys());
        if (!listC.isEmpty() || !listC2.isEmpty()) {
            builder.setApp(dVar.getApp().toBuilder().setCustomAttributes(listC).setInternalKeys(listC2).build());
        }
        return builder.build();
    }

    public static f0.e.d b(f0.e.d dVar, s8.m mVar) {
        List<f0.e.d.AbstractC0277e> rolloutsState = mVar.getRolloutsState();
        if (rolloutsState.isEmpty()) {
            return dVar;
        }
        f0.e.d.b builder = dVar.toBuilder();
        builder.setRollouts(f0.e.d.f.builder().setRolloutAssignments(rolloutsState).build());
        return builder.build();
    }

    public static List<f0.c> c(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(f0.c.builder().setKey(entry.getKey()).setValue(entry.getValue()).build());
        }
        Collections.sort(arrayList, new u0.d(2));
        return Collections.unmodifiableList(arrayList);
    }

    public static String convertInputStreamToString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 == -1) {
                return byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
            }
            byteArrayOutputStream.write(bArr, 0, i10);
        }
    }

    public static m0 create(Context context, h0 h0Var, w8.b bVar, a aVar, s8.e eVar, s8.m mVar, z8.d dVar, y8.g gVar, l0 l0Var, k kVar) {
        return new m0(new z(context, h0Var, aVar, dVar, gVar), new w8.a(bVar, gVar, kVar), x8.a.create(context, gVar, l0Var), eVar, mVar, h0Var);
    }

    public void finalizeSessionWithNativeEvent(String str, List<j0> list, f0.a aVar) {
        o8.e.getLogger().d("SessionReportingCoordinator#finalizeSessionWithNativeEvent");
        ArrayList arrayList = new ArrayList();
        Iterator<j0> it = list.iterator();
        while (it.hasNext()) {
            f0.d.b bVarAsFilePayload = it.next().asFilePayload();
            if (bVarAsFilePayload != null) {
                arrayList.add(bVarAsFilePayload);
            }
        }
        this.f18725b.finalizeSessionWithNativeEvent(str, f0.d.builder().setFiles(Collections.unmodifiableList(arrayList)).build(), aVar);
    }

    public void finalizeSessions(long j10, String str) {
        this.f18725b.finalizeReports(str, j10);
    }

    public boolean hasReportsToSend() {
        return this.f18725b.hasFinalizedReports();
    }

    public SortedSet<String> listSortedOpenSessionIds() {
        return this.f18725b.getOpenSessionIds();
    }

    public void onBeginSession(String str, long j10) {
        this.f18725b.persistReport(this.f18724a.captureReportData(str, j10));
    }

    public void persistFatalEvent(Throwable th2, Thread thread, String str, long j10) {
        o8.e.getLogger().v("Persisting fatal event for session " + str);
        f0.e.d dVarCaptureEventData = this.f18724a.captureEventData(th2, thread, "crash", j10, 4, 8, true);
        s8.e eVar = this.f18727d;
        s8.m mVar = this.f18728e;
        this.f18725b.persistEvent(b(a(dVarCaptureEventData, eVar, mVar), mVar), str, true);
    }

    public void persistRelevantAppExitInfoEvent(String str, List<ApplicationExitInfo> list, s8.e eVar, s8.m mVar) throws IOException {
        String strConvertInputStreamToString;
        ApplicationExitInfo next;
        w8.a aVar = this.f18725b;
        long startTimestampMillis = aVar.getStartTimestampMillis(str);
        Iterator<ApplicationExitInfo> it = list.iterator();
        do {
            strConvertInputStreamToString = null;
            if (it.hasNext()) {
                next = it.next();
                if (next.getTimestamp() < startTimestampMillis) {
                }
            }
            next = null;
            break;
        } while (next.getReason() != 6);
        if (next == null) {
            o8.e.getLogger().v("No relevant ApplicationExitInfo occurred during session: " + str);
            return;
        }
        try {
            InputStream traceInputStream = next.getTraceInputStream();
            if (traceInputStream != null) {
                strConvertInputStreamToString = convertInputStreamToString(traceInputStream);
            }
        } catch (IOException e10) {
            o8.e.getLogger().w("Could not get input trace in application exit info: " + next.toString() + " Error: " + e10);
        }
        f0.e.d dVarCaptureAnrEventData = this.f18724a.captureAnrEventData(f0.a.builder().setImportance(next.getImportance()).setProcessName(next.getProcessName()).setReasonCode(next.getReason()).setTimestamp(next.getTimestamp()).setPid(next.getPid()).setPss(next.getPss()).setRss(next.getRss()).setTraceFile(strConvertInputStreamToString).build());
        o8.e.getLogger().d("Persisting anr for session " + str);
        aVar.persistEvent(b(a(dVarCaptureAnrEventData, eVar, mVar), mVar), str, true);
    }

    public void removeAllReports() {
        this.f18725b.deleteAllReports();
    }

    public Task<Void> sendReports(Executor executor) {
        return sendReports(executor, null);
    }

    public Task<Void> sendReports(Executor executor, String str) {
        List<a0> listLoadFinalizedReports = this.f18725b.loadFinalizedReports();
        ArrayList arrayList = new ArrayList();
        Iterator<a0> it = listLoadFinalizedReports.iterator();
        while (it.hasNext()) {
            a0 next = it.next();
            if (str == null || str.equals(next.getSessionId())) {
                if (next.getReport().getFirebaseInstallationId() == null) {
                    next = a0.create(next.getReport().withFirebaseInstallationId(this.f18729f.fetchTrueFid()), next.getSessionId(), next.getReportFile());
                }
                arrayList.add(this.f18726c.enqueueReport(next, str != null).continueWith(executor, new c1.c(this, 13)));
            }
        }
        return Tasks.whenAll(arrayList);
    }
}
