package f3;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: WorkNameDao_Impl.java */
/* loaded from: classes.dex */
public final class p implements o {

    /* renamed from: a, reason: collision with root package name */
    public final RoomDatabase f11420a;

    /* renamed from: b, reason: collision with root package name */
    public final a f11421b;

    /* compiled from: WorkNameDao_Impl.java */
    public class a extends g2.f<n> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
        }

        @Override // g2.f
        public void bind(k2.i iVar, n nVar) {
            if (nVar.getName() == null) {
                iVar.bindNull(1);
            } else {
                iVar.bindString(1, nVar.getName());
            }
            if (nVar.getWorkSpecId() == null) {
                iVar.bindNull(2);
            } else {
                iVar.bindString(2, nVar.getWorkSpecId());
            }
        }
    }

    public p(RoomDatabase roomDatabase) {
        this.f11420a = roomDatabase;
        this.f11421b = new a(roomDatabase);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // f3.o
    public List<String> getNamesForWorkSpecId(String str) {
        g2.q qVarAcquire = g2.q.acquire("SELECT name FROM workname WHERE work_spec_id=?", 1);
        if (str == null) {
            qVarAcquire.bindNull(1);
        } else {
            qVarAcquire.bindString(1, str);
        }
        RoomDatabase roomDatabase = this.f11420a;
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

    @Override // f3.o
    public void insert(n nVar) {
        RoomDatabase roomDatabase = this.f11420a;
        roomDatabase.assertNotSuspendingTransaction();
        roomDatabase.beginTransaction();
        try {
            this.f11421b.insert(nVar);
            roomDatabase.setTransactionSuccessful();
        } finally {
            roomDatabase.endTransaction();
        }
    }
}
