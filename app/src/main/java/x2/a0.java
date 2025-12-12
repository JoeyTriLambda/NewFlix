package x2;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;

/* compiled from: WorkDatabasePathHelper.kt */
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a0 f21387a = new a0();

    public static final void migrateDatabase(Context context) {
        zf.i.checkNotNullParameter(context, "context");
        a0 a0Var = f21387a;
        File defaultDatabasePath = a0Var.getDefaultDatabasePath(context);
        if (Build.VERSION.SDK_INT < 23 || !defaultDatabasePath.exists()) {
            return;
        }
        w2.g.get().debug(b0.f21388a, "Migrating WorkDatabase to the no-backup directory");
        for (Map.Entry<File, File> entry : a0Var.migrationPaths(context).entrySet()) {
            File key = entry.getKey();
            File value = entry.getValue();
            if (key.exists()) {
                if (value.exists()) {
                    w2.g.get().warning(b0.f21388a, "Over-writing contents of " + value);
                }
                w2.g.get().debug(b0.f21388a, key.renameTo(value) ? "Migrated " + key + "to " + value : "Renaming " + key + " to " + value + " failed");
            }
        }
    }

    public final File getDatabasePath(Context context) {
        zf.i.checkNotNullParameter(context, "context");
        return Build.VERSION.SDK_INT < 23 ? getDefaultDatabasePath(context) : new File(a.f21386a.getNoBackupFilesDir(context), "androidx.work.workdb");
    }

    public final File getDefaultDatabasePath(Context context) {
        zf.i.checkNotNullParameter(context, "context");
        File databasePath = context.getDatabasePath("androidx.work.workdb");
        zf.i.checkNotNullExpressionValue(databasePath, "context.getDatabasePath(WORK_DATABASE_NAME)");
        return databasePath;
    }

    public final Map<File, File> migrationPaths(Context context) {
        zf.i.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT < 23) {
            return kotlin.collections.a.emptyMap();
        }
        File defaultDatabasePath = getDefaultDatabasePath(context);
        File databasePath = getDatabasePath(context);
        String[] strArr = b0.f21389b;
        LinkedHashMap linkedHashMap = new LinkedHashMap(fg.h.coerceAtLeast(mf.x.mapCapacity(strArr.length), 16));
        for (String str : strArr) {
            Pair pair = lf.g.to(new File(defaultDatabasePath.getPath() + str), new File(databasePath.getPath() + str));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return kotlin.collections.a.plus(linkedHashMap, lf.g.to(defaultDatabasePath, databasePath));
    }
}
