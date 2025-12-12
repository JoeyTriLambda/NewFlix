package r8;

import com.google.auto.value.AutoValue;
import java.io.File;

/* compiled from: CrashlyticsReportWithSessionId.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class a0 {
    public static a0 create(t8.f0 f0Var, String str, File file) {
        return new b(f0Var, str, file);
    }

    public abstract t8.f0 getReport();

    public abstract File getReportFile();

    public abstract String getSessionId();
}
