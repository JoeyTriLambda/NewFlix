package x2;

import android.database.SQLException;

/* compiled from: WorkDatabaseMigrations.kt */
/* loaded from: classes.dex */
public final class g extends h2.b {

    /* renamed from: c, reason: collision with root package name */
    public static final g f21408c = new g();

    public g() {
        super(12, 13);
    }

    @Override // h2.b
    public void migrate(k2.e eVar) throws SQLException {
        zf.i.checkNotNullParameter(eVar, "db");
        eVar.execSQL("UPDATE workspec SET required_network_type = 0 WHERE required_network_type IS NULL ");
        eVar.execSQL("UPDATE workspec SET content_uri_triggers = x'' WHERE content_uri_triggers is NULL");
    }
}
