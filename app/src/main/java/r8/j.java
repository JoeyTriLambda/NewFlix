package r8;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: CrashlyticsAppQualitySessionsStore.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: d, reason: collision with root package name */
    public static final i f18709d = new i(0);

    /* renamed from: e, reason: collision with root package name */
    public static final u0.d f18710e = new u0.d(1);

    /* renamed from: a, reason: collision with root package name */
    public final w8.b f18711a;

    /* renamed from: b, reason: collision with root package name */
    public String f18712b = null;

    /* renamed from: c, reason: collision with root package name */
    public String f18713c = null;

    public j(w8.b bVar) {
        this.f18711a = bVar;
    }

    public static void a(w8.b bVar, String str, String str2) throws IOException {
        if (str == null || str2 == null) {
            return;
        }
        try {
            bVar.getSessionFile(str, "aqs.".concat(str2)).createNewFile();
        } catch (IOException e10) {
            o8.e.getLogger().w("Failed to persist App Quality Sessions session id.", e10);
        }
    }

    public synchronized String getAppQualitySessionId(String str) {
        String strSubstring;
        if (Objects.equals(this.f18712b, str)) {
            return this.f18713c;
        }
        List<File> sessionFiles = this.f18711a.getSessionFiles(str, f18709d);
        if (sessionFiles.isEmpty()) {
            o8.e.getLogger().w("Unable to read App Quality Sessions session id.");
            strSubstring = null;
        } else {
            strSubstring = ((File) Collections.min(sessionFiles, f18710e)).getName().substring(4);
        }
        return strSubstring;
    }

    public synchronized void rotateAppQualitySessionId(String str) {
        if (!Objects.equals(this.f18713c, str)) {
            a(this.f18711a, this.f18712b, str);
            this.f18713c = str;
        }
    }

    public synchronized void rotateSessionId(String str) {
        if (!Objects.equals(this.f18712b, str)) {
            a(this.f18711a, str, this.f18713c);
            this.f18712b = str;
        }
    }
}
