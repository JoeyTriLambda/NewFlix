package w8;

import ac.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import o8.e;
import r8.a0;
import r8.i;
import r8.k;
import s8.m;
import t8.f0;
import u0.d;
import y8.g;

/* compiled from: CrashlyticsReportPersistence.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final Charset f21028e = Charset.forName("UTF-8");

    /* renamed from: f, reason: collision with root package name */
    public static final int f21029f = 15;

    /* renamed from: g, reason: collision with root package name */
    public static final u8.b f21030g = new u8.b();

    /* renamed from: h, reason: collision with root package name */
    public static final d f21031h = new d(4);

    /* renamed from: i, reason: collision with root package name */
    public static final i f21032i = new i(3);

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f21033a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    public final b f21034b;

    /* renamed from: c, reason: collision with root package name */
    public final g f21035c;

    /* renamed from: d, reason: collision with root package name */
    public final k f21036d;

    public a(b bVar, g gVar, k kVar) {
        this.f21034b = bVar;
        this.f21035c = gVar;
        this.f21036d = kVar;
    }

    public static void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    public static String c(File file) throws IOException {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int i10 = fileInputStream.read(bArr);
                if (i10 <= 0) {
                    String str = new String(byteArrayOutputStream.toByteArray(), f21028e);
                    fileInputStream.close();
                    return str;
                }
                byteArrayOutputStream.write(bArr, 0, i10);
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static void d(File file, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f21028e);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
        } catch (Throwable th2) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList();
        b bVar = this.f21034b;
        arrayList.addAll(bVar.getPriorityReports());
        arrayList.addAll(bVar.getNativeReports());
        d dVar = f21031h;
        Collections.sort(arrayList, dVar);
        List<File> reports = bVar.getReports();
        Collections.sort(reports, dVar);
        arrayList.addAll(reports);
        return arrayList;
    }

    public void deleteAllReports() {
        b bVar = this.f21034b;
        a(bVar.getReports());
        a(bVar.getPriorityReports());
        a(bVar.getNativeReports());
    }

    public void finalizeReports(String str, long j10) {
        boolean z10;
        u8.b bVar;
        b bVar2 = this.f21034b;
        bVar2.cleanupPreviousFileSystems();
        SortedSet<String> openSessionIds = getOpenSessionIds();
        if (str != null) {
            openSessionIds.remove(str);
        }
        if (openSessionIds.size() > 8) {
            while (openSessionIds.size() > 8) {
                String strLast = openSessionIds.last();
                e.getLogger().d("Removing session over cap: " + strLast);
                bVar2.deleteSessionFiles(strLast);
                openSessionIds.remove(strLast);
            }
        }
        for (String str2 : openSessionIds) {
            e.getLogger().v("Finalizing report for session " + str2);
            List<File> sessionFiles = bVar2.getSessionFiles(str2, f21032i);
            if (sessionFiles.isEmpty()) {
                e.getLogger().v("Session " + str2 + " has no events.");
            } else {
                Collections.sort(sessionFiles);
                ArrayList arrayList = new ArrayList();
                Iterator<File> it = sessionFiles.iterator();
                while (true) {
                    z10 = false;
                    while (true) {
                        boolean zHasNext = it.hasNext();
                        bVar = f21030g;
                        if (!zHasNext) {
                            break;
                        }
                        File next = it.next();
                        try {
                            arrayList.add(bVar.eventFromJson(c(next)));
                            if (!z10) {
                                String name = next.getName();
                                if (!(name.startsWith("event") && name.endsWith("_"))) {
                                    break;
                                }
                            }
                            z10 = true;
                        } catch (IOException e10) {
                            e.getLogger().w("Could not add event to report for " + next, e10);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    e.getLogger().w("Could not parse event files for session " + str2);
                } else {
                    String userId = m.readUserId(str2, bVar2);
                    String appQualitySessionId = this.f21036d.getAppQualitySessionId(str2);
                    File sessionFile = bVar2.getSessionFile(str2, "report");
                    try {
                        f0 f0VarWithEvents = bVar.reportFromJson(c(sessionFile)).withSessionEndFields(j10, z10, userId).withAppQualitySessionId(appQualitySessionId).withEvents(arrayList);
                        f0.e session = f0VarWithEvents.getSession();
                        if (session != null) {
                            e.getLogger().d("appQualitySessionId: " + appQualitySessionId);
                            d(z10 ? bVar2.getPriorityReport(session.getIdentifier()) : bVar2.getReport(session.getIdentifier()), bVar.reportToJson(f0VarWithEvents));
                        }
                    } catch (IOException e11) {
                        e.getLogger().w("Could not synthesize final report file for " + sessionFile, e11);
                    }
                }
            }
            bVar2.deleteSessionFiles(str2);
        }
        int i10 = ((com.google.firebase.crashlytics.internal.settings.a) this.f21035c).getSettingsSync().f22022a.f22032b;
        ArrayList arrayListB = b();
        int size = arrayListB.size();
        if (size <= i10) {
            return;
        }
        Iterator it2 = arrayListB.subList(i10, size).iterator();
        while (it2.hasNext()) {
            ((File) it2.next()).delete();
        }
    }

    public void finalizeSessionWithNativeEvent(String str, f0.d dVar, f0.a aVar) {
        b bVar = this.f21034b;
        File sessionFile = bVar.getSessionFile(str, "report");
        e.getLogger().d("Writing native session report for " + str + " to file: " + sessionFile);
        String appQualitySessionId = this.f21036d.getAppQualitySessionId(str);
        try {
            u8.b bVar2 = f21030g;
            d(bVar.getNativeReport(str), bVar2.reportToJson(bVar2.reportFromJson(c(sessionFile)).withNdkPayload(dVar).withApplicationExitInfo(aVar).withAppQualitySessionId(appQualitySessionId)));
        } catch (IOException e10) {
            e.getLogger().w("Could not synthesize final native report file for " + sessionFile, e10);
        }
    }

    public SortedSet<String> getOpenSessionIds() {
        return new TreeSet(this.f21034b.getAllOpenSessionIds()).descendingSet();
    }

    public long getStartTimestampMillis(String str) {
        return this.f21034b.getSessionFile(str, "start-time").lastModified();
    }

    public boolean hasFinalizedReports() {
        b bVar = this.f21034b;
        return (bVar.getReports().isEmpty() && bVar.getPriorityReports().isEmpty() && bVar.getNativeReports().isEmpty()) ? false : true;
    }

    public List<a0> loadFinalizedReports() {
        ArrayList arrayListB = b();
        ArrayList arrayList = new ArrayList();
        Iterator it = arrayListB.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            try {
                arrayList.add(a0.create(f21030g.reportFromJson(c(file)), file.getName(), file));
            } catch (IOException e10) {
                e.getLogger().w("Could not load report file " + file + "; deleting", e10);
                file.delete();
            }
        }
        return arrayList;
    }

    public void persistEvent(f0.e.d dVar, String str, boolean z10) {
        b bVar = this.f21034b;
        int i10 = ((com.google.firebase.crashlytics.internal.settings.a) this.f21035c).getSettingsSync().f22022a.f22031a;
        try {
            d(bVar.getSessionFile(str, c.k("event", String.format(Locale.US, "%010d", Integer.valueOf(this.f21033a.getAndIncrement())), z10 ? "_" : "")), f21030g.eventToJson(dVar));
        } catch (IOException e10) {
            e.getLogger().w("Could not persist event for session " + str, e10);
        }
        List<File> sessionFiles = bVar.getSessionFiles(str, new i(2));
        Collections.sort(sessionFiles, new d(3));
        int size = sessionFiles.size();
        for (File file : sessionFiles) {
            if (size <= i10) {
                return;
            }
            b.c(file);
            size--;
        }
    }

    public void persistReport(f0 f0Var) {
        b bVar = this.f21034b;
        f0.e session = f0Var.getSession();
        if (session == null) {
            e.getLogger().d("Could not get session for report");
            return;
        }
        String identifier = session.getIdentifier();
        try {
            d(bVar.getSessionFile(identifier, "report"), f21030g.reportToJson(f0Var));
            File sessionFile = bVar.getSessionFile(identifier, "start-time");
            long startedAt = session.getStartedAt();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(sessionFile), f21028e);
            try {
                outputStreamWriter.write("");
                sessionFile.setLastModified(startedAt * 1000);
                outputStreamWriter.close();
            } finally {
            }
        } catch (IOException e10) {
            e.getLogger().d("Could not persist report for session " + identifier, e10);
        }
    }
}
