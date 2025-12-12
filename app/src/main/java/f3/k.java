package f3;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import f3.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SystemIdInfoDao_Impl.java */
/* loaded from: classes.dex */
public final class k implements j {

    /* renamed from: a, reason: collision with root package name */
    public final RoomDatabase f11412a;

    /* renamed from: b, reason: collision with root package name */
    public final a f11413b;

    /* renamed from: c, reason: collision with root package name */
    public final b f11414c;

    /* renamed from: d, reason: collision with root package name */
    public final c f11415d;

    /* compiled from: SystemIdInfoDao_Impl.java */
    public class a extends g2.f<i> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`generation`,`system_id`) VALUES (?,?,?)";
        }

        @Override // g2.f
        public void bind(k2.i iVar, i iVar2) {
            String str = iVar2.f11409a;
            if (str == null) {
                iVar.bindNull(1);
            } else {
                iVar.bindString(1, str);
            }
            iVar.bindLong(2, iVar2.getGeneration());
            iVar.bindLong(3, iVar2.f11411c);
        }
    }

    /* compiled from: SystemIdInfoDao_Impl.java */
    public class b extends SharedSQLiteStatement {
        public b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM SystemIdInfo where work_spec_id=? AND generation=?";
        }
    }

    /* compiled from: SystemIdInfoDao_Impl.java */
    public class c extends SharedSQLiteStatement {
        public c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM SystemIdInfo where work_spec_id=?";
        }
    }

    public k(RoomDatabase roomDatabase) {
        this.f11412a = roomDatabase;
        this.f11413b = new a(roomDatabase);
        this.f11414c = new b(roomDatabase);
        this.f11415d = new c(roomDatabase);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // f3.j
    public i getSystemIdInfo(String str, int i10) {
        g2.q qVarAcquire = g2.q.acquire("SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?", 2);
        if (str == null) {
            qVarAcquire.bindNull(1);
        } else {
            qVarAcquire.bindString(1, str);
        }
        qVarAcquire.bindLong(2, i10);
        RoomDatabase roomDatabase = this.f11412a;
        roomDatabase.assertNotSuspendingTransaction();
        i iVar = null;
        String string = null;
        Cursor cursorQuery = i2.b.query(roomDatabase, qVarAcquire, false, null);
        try {
            int columnIndexOrThrow = i2.a.getColumnIndexOrThrow(cursorQuery, "work_spec_id");
            int columnIndexOrThrow2 = i2.a.getColumnIndexOrThrow(cursorQuery, "generation");
            int columnIndexOrThrow3 = i2.a.getColumnIndexOrThrow(cursorQuery, "system_id");
            if (cursorQuery.moveToFirst()) {
                if (!cursorQuery.isNull(columnIndexOrThrow)) {
                    string = cursorQuery.getString(columnIndexOrThrow);
                }
                iVar = new i(string, cursorQuery.getInt(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3));
            }
            return iVar;
        } finally {
            cursorQuery.close();
            qVarAcquire.release();
        }
    }

    @Override // f3.j
    public List<String> getWorkSpecIds() {
        g2.q qVarAcquire = g2.q.acquire("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
        RoomDatabase roomDatabase = this.f11412a;
        roomDatabase.assertNotSuspendingTransaction();
        Cursor cursorQuery = i2.b.query(roomDatabase, qVarAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            qVarAcquire.release();
        }
    }

    @Override // f3.j
    public void insertSystemIdInfo(i iVar) {
        RoomDatabase roomDatabase = this.f11412a;
        roomDatabase.assertNotSuspendingTransaction();
        roomDatabase.beginTransaction();
        try {
            this.f11413b.insert(iVar);
            roomDatabase.setTransactionSuccessful();
        } finally {
            roomDatabase.endTransaction();
        }
    }

    @Override // f3.j
    public void removeSystemIdInfo(String str, int i10) {
        RoomDatabase roomDatabase = this.f11412a;
        roomDatabase.assertNotSuspendingTransaction();
        b bVar = this.f11414c;
        k2.i iVarAcquire = bVar.acquire();
        if (str == null) {
            iVarAcquire.bindNull(1);
        } else {
            iVarAcquire.bindString(1, str);
        }
        iVarAcquire.bindLong(2, i10);
        roomDatabase.beginTransaction();
        try {
            iVarAcquire.executeUpdateDelete();
            roomDatabase.setTransactionSuccessful();
        } finally {
            roomDatabase.endTransaction();
            bVar.release(iVarAcquire);
        }
    }

    @Override // f3.j
    public void removeSystemIdInfo(String str) {
        RoomDatabase roomDatabase = this.f11412a;
        roomDatabase.assertNotSuspendingTransaction();
        c cVar = this.f11415d;
        k2.i iVarAcquire = cVar.acquire();
        if (str == null) {
            iVarAcquire.bindNull(1);
        } else {
            iVarAcquire.bindString(1, str);
        }
        roomDatabase.beginTransaction();
        try {
            iVarAcquire.executeUpdateDelete();
            roomDatabase.setTransactionSuccessful();
        } finally {
            roomDatabase.endTransaction();
            cVar.release(iVarAcquire);
        }
    }

    @Override // f3.j
    public i getSystemIdInfo(m mVar) {
        return j.a.getSystemIdInfo(this, mVar);
    }

    @Override // f3.j
    public void removeSystemIdInfo(m mVar) {
        j.a.removeSystemIdInfo(this, mVar);
    }
}
