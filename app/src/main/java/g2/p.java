package g2;

import android.database.Cursor;
import android.database.SQLException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import k2.f;

/* compiled from: RoomOpenHelper.kt */
/* loaded from: classes.dex */
public final class p extends f.a {

    /* renamed from: f, reason: collision with root package name */
    public static final a f12610f = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public g2.c f12611b;

    /* renamed from: c, reason: collision with root package name */
    public final b f12612c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12613d;

    /* renamed from: e, reason: collision with root package name */
    public final String f12614e;

    /* compiled from: RoomOpenHelper.kt */
    public static final class a {
        public a(zf.f fVar) {
        }

        public final boolean hasEmptySchema$room_runtime_release(k2.e eVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
            zf.i.checkNotNullParameter(eVar, "db");
            Cursor cursorQuery = eVar.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
            try {
                boolean z10 = false;
                if (cursorQuery.moveToFirst()) {
                    if (cursorQuery.getInt(0) == 0) {
                        z10 = true;
                    }
                }
                wf.a.closeFinally(cursorQuery, null);
                return z10;
            } finally {
            }
        }

        public final boolean hasRoomMasterTable$room_runtime_release(k2.e eVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
            zf.i.checkNotNullParameter(eVar, "db");
            Cursor cursorQuery = eVar.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
            try {
                boolean z10 = false;
                if (cursorQuery.moveToFirst()) {
                    if (cursorQuery.getInt(0) != 0) {
                        z10 = true;
                    }
                }
                wf.a.closeFinally(cursorQuery, null);
                return z10;
            } finally {
            }
        }
    }

    /* compiled from: RoomOpenHelper.kt */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f12615a;

        public b(int i10) {
            this.f12615a = i10;
        }

        public abstract void createAllTables(k2.e eVar);

        public abstract void dropAllTables(k2.e eVar);

        public abstract void onCreate(k2.e eVar);

        public abstract void onOpen(k2.e eVar);

        public abstract void onPostMigrate(k2.e eVar);

        public abstract void onPreMigrate(k2.e eVar);

        public abstract c onValidateSchema(k2.e eVar);
    }

    /* compiled from: RoomOpenHelper.kt */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f12616a;

        /* renamed from: b, reason: collision with root package name */
        public final String f12617b;

        public c(boolean z10, String str) {
            this.f12616a = z10;
            this.f12617b = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(g2.c cVar, b bVar, String str, String str2) {
        super(bVar.f12615a);
        zf.i.checkNotNullParameter(cVar, "configuration");
        zf.i.checkNotNullParameter(bVar, "delegate");
        zf.i.checkNotNullParameter(str, "identityHash");
        zf.i.checkNotNullParameter(str2, "legacyHash");
        this.f12611b = cVar;
        this.f12612c = bVar;
        this.f12613d = str;
        this.f12614e = str2;
    }

    @Override // k2.f.a
    public void onConfigure(k2.e eVar) {
        zf.i.checkNotNullParameter(eVar, "db");
        super.onConfigure(eVar);
    }

    @Override // k2.f.a
    public void onCreate(k2.e eVar) throws IllegalAccessException, IOException, SQLException, IllegalArgumentException, InvocationTargetException {
        zf.i.checkNotNullParameter(eVar, "db");
        boolean zHasEmptySchema$room_runtime_release = f12610f.hasEmptySchema$room_runtime_release(eVar);
        b bVar = this.f12612c;
        bVar.createAllTables(eVar);
        if (!zHasEmptySchema$room_runtime_release) {
            c cVarOnValidateSchema = bVar.onValidateSchema(eVar);
            if (!cVarOnValidateSchema.f12616a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + cVarOnValidateSchema.f12617b);
            }
        }
        eVar.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        eVar.execSQL(o.createInsertQuery(this.f12613d));
        bVar.onCreate(eVar);
    }

    @Override // k2.f.a
    public void onDowngrade(k2.e eVar, int i10, int i11) throws SQLException {
        zf.i.checkNotNullParameter(eVar, "db");
        onUpgrade(eVar, i10, i11);
    }

    @Override // k2.f.a
    public void onOpen(k2.e eVar) throws IllegalAccessException, IOException, SQLException, IllegalArgumentException, InvocationTargetException {
        zf.i.checkNotNullParameter(eVar, "db");
        super.onOpen(eVar);
        boolean zHasRoomMasterTable$room_runtime_release = f12610f.hasRoomMasterTable$room_runtime_release(eVar);
        String str = this.f12613d;
        b bVar = this.f12612c;
        if (zHasRoomMasterTable$room_runtime_release) {
            Cursor cursorQuery = eVar.query(new k2.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
            try {
                String string = cursorQuery.moveToFirst() ? cursorQuery.getString(0) : null;
                wf.a.closeFinally(cursorQuery, null);
                if (!zf.i.areEqual(str, string) && !zf.i.areEqual(this.f12614e, string)) {
                    throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + str + ", found: " + string);
                }
            } finally {
            }
        } else {
            c cVarOnValidateSchema = bVar.onValidateSchema(eVar);
            if (!cVarOnValidateSchema.f12616a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + cVarOnValidateSchema.f12617b);
            }
            bVar.onPostMigrate(eVar);
            eVar.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            eVar.execSQL(o.createInsertQuery(str));
        }
        bVar.onOpen(eVar);
        this.f12611b = null;
    }

    @Override // k2.f.a
    public void onUpgrade(k2.e eVar, int i10, int i11) throws SQLException {
        boolean z10;
        List<h2.b> listFindMigrationPath;
        zf.i.checkNotNullParameter(eVar, "db");
        g2.c cVar = this.f12611b;
        b bVar = this.f12612c;
        if (cVar == null || (listFindMigrationPath = cVar.f12552d.findMigrationPath(i10, i11)) == null) {
            z10 = false;
        } else {
            bVar.onPreMigrate(eVar);
            Iterator<T> it = listFindMigrationPath.iterator();
            while (it.hasNext()) {
                ((h2.b) it.next()).migrate(eVar);
            }
            c cVarOnValidateSchema = bVar.onValidateSchema(eVar);
            if (!cVarOnValidateSchema.f12616a) {
                throw new IllegalStateException("Migration didn't properly handle: " + cVarOnValidateSchema.f12617b);
            }
            bVar.onPostMigrate(eVar);
            eVar.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            eVar.execSQL(o.createInsertQuery(this.f12613d));
            z10 = true;
        }
        if (z10) {
            return;
        }
        g2.c cVar2 = this.f12611b;
        if (cVar2 != null && !cVar2.isMigrationRequired(i10, i11)) {
            bVar.dropAllTables(eVar);
            bVar.createAllTables(eVar);
            return;
        }
        throw new IllegalStateException("A migration from " + i10 + " to " + i11 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }
}
