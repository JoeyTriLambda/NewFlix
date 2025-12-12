package x2;

import android.content.Context;
import android.database.SQLException;

/* compiled from: WorkDatabaseMigrations.kt */
/* loaded from: classes.dex */
public final class s extends h2.b {

    /* renamed from: c, reason: collision with root package name */
    public final Context f21481c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(Context context, int i10, int i11) {
        super(i10, i11);
        zf.i.checkNotNullParameter(context, "mContext");
        this.f21481c = context;
    }

    @Override // h2.b
    public void migrate(k2.e eVar) throws SQLException {
        zf.i.checkNotNullParameter(eVar, "db");
        if (this.f12907b >= 10) {
            eVar.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
        } else {
            this.f21481c.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
        }
    }
}
