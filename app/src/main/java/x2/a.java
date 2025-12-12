package x2;

import android.content.Context;
import java.io.File;

/* compiled from: WorkDatabasePathHelper.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f21386a = new a();

    public final File getNoBackupFilesDir(Context context) {
        zf.i.checkNotNullParameter(context, "context");
        File noBackupFilesDir = context.getNoBackupFilesDir();
        zf.i.checkNotNullExpressionValue(noBackupFilesDir, "context.noBackupFilesDir");
        return noBackupFilesDir;
    }
}
