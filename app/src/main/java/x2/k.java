package x2;

import android.database.SQLException;

/* compiled from: WorkDatabaseMigrations.kt */
/* loaded from: classes.dex */
public final class k extends h2.b {

    /* renamed from: c, reason: collision with root package name */
    public static final k f21428c = new k();

    public k() {
        super(4, 5);
    }

    @Override // h2.b
    public void migrate(k2.e eVar) throws SQLException {
        zf.i.checkNotNullParameter(eVar, "db");
        eVar.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
        eVar.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
    }
}
