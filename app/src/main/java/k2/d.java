package k2;

import android.content.Context;
import java.io.File;

/* compiled from: SupportSQLiteCompat.kt */
/* loaded from: classes.dex */
public final class d {
    public static final File getNoBackupFilesDir(Context context) {
        zf.i.checkNotNullParameter(context, "context");
        File noBackupFilesDir = context.getNoBackupFilesDir();
        zf.i.checkNotNullExpressionValue(noBackupFilesDir, "context.noBackupFilesDir");
        return noBackupFilesDir;
    }
}
