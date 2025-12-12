package x2;

import android.database.SQLException;

/* compiled from: WorkDatabaseMigrations.kt */
/* loaded from: classes.dex */
public final class h extends h2.b {

    /* renamed from: c, reason: collision with root package name */
    public static final h f21414c = new h();

    public h() {
        super(15, 16);
    }

    @Override // h2.b
    public void migrate(k2.e eVar) throws SQLException {
        zf.i.checkNotNullParameter(eVar, "db");
        eVar.execSQL("DELETE FROM SystemIdInfo WHERE work_spec_id IN (SELECT work_spec_id FROM SystemIdInfo LEFT JOIN WorkSpec ON work_spec_id = id WHERE WorkSpec.id IS NULL)");
        eVar.execSQL("ALTER TABLE `WorkSpec` ADD COLUMN `generation` INTEGER NOT NULL DEFAULT 0");
        eVar.execSQL("CREATE TABLE IF NOT EXISTS `_new_SystemIdInfo` (\n            `work_spec_id` TEXT NOT NULL, \n            `generation` INTEGER NOT NULL DEFAULT 0, \n            `system_id` INTEGER NOT NULL, \n            PRIMARY KEY(`work_spec_id`, `generation`), \n            FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) \n                ON UPDATE CASCADE ON DELETE CASCADE )");
        eVar.execSQL("INSERT INTO `_new_SystemIdInfo` (`work_spec_id`,`system_id`) SELECT `work_spec_id`,`system_id` FROM `SystemIdInfo`");
        eVar.execSQL("DROP TABLE `SystemIdInfo`");
        eVar.execSQL("ALTER TABLE `_new_SystemIdInfo` RENAME TO `SystemIdInfo`");
    }
}
