package x2;

import android.database.SQLException;
import android.os.Build;

/* compiled from: WorkDatabaseMigrations.kt */
/* loaded from: classes.dex */
public final class j extends h2.b {

    /* renamed from: c, reason: collision with root package name */
    public static final j f21425c = new j();

    public j() {
        super(3, 4);
    }

    @Override // h2.b
    public void migrate(k2.e eVar) throws SQLException {
        zf.i.checkNotNullParameter(eVar, "db");
        if (Build.VERSION.SDK_INT >= 23) {
            eVar.execSQL("\n    UPDATE workspec SET schedule_requested_at = 0\n    WHERE state NOT IN (2, 3, 5)\n        AND schedule_requested_at = -1\n        AND interval_duration <> 0\n    ");
        }
    }
}
