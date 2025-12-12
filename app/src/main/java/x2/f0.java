package x2;

import android.content.Context;
import android.database.SQLException;

/* compiled from: WorkDatabaseMigrations.kt */
/* loaded from: classes.dex */
public final class f0 extends h2.b {

    /* renamed from: c, reason: collision with root package name */
    public final Context f21407c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(Context context) {
        super(9, 10);
        zf.i.checkNotNullParameter(context, "context");
        this.f21407c = context;
    }

    @Override // h2.b
    public void migrate(k2.e eVar) throws SQLException {
        zf.i.checkNotNullParameter(eVar, "db");
        eVar.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
        Context context = this.f21407c;
        g3.n.migrateLegacyPreferences(context, eVar);
        g3.h.migrateLegacyIdGenerator(context, eVar);
    }
}
