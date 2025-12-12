package x2;

import androidx.room.RoomDatabase;

/* compiled from: WorkDatabase.kt */
/* loaded from: classes.dex */
public final class c extends RoomDatabase.b {

    /* renamed from: a, reason: collision with root package name */
    public static final c f21390a = new c();

    public final long getPruneDate() {
        return System.currentTimeMillis() - z.f21497a;
    }

    @Override // androidx.room.RoomDatabase.b
    public void onOpen(k2.e eVar) {
        zf.i.checkNotNullParameter(eVar, "db");
        super.onOpen(eVar);
        eVar.beginTransaction();
        try {
            eVar.execSQL("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (last_enqueue_time + minimum_retention_duration) < " + getPruneDate() + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
            eVar.setTransactionSuccessful();
        } finally {
            eVar.endTransaction();
        }
    }
}
