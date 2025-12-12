package x2;

import android.database.SQLException;

/* compiled from: WorkDatabaseMigrations.kt */
/* loaded from: classes.dex */
public final class f extends h2.b {

    /* renamed from: c, reason: collision with root package name */
    public static final f f21406c = new f();

    public f() {
        super(11, 12);
    }

    @Override // h2.b
    public void migrate(k2.e eVar) throws SQLException {
        zf.i.checkNotNullParameter(eVar, "db");
        eVar.execSQL("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
    }
}
