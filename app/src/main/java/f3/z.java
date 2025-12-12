package f3;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import f3.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* compiled from: WorkTagDao_Impl.java */
/* loaded from: classes.dex */
public final class z implements y {

    /* renamed from: a, reason: collision with root package name */
    public final RoomDatabase f11462a;

    /* renamed from: b, reason: collision with root package name */
    public final a f11463b;

    /* renamed from: c, reason: collision with root package name */
    public final b f11464c;

    /* compiled from: WorkTagDao_Impl.java */
    public class a extends g2.f<x> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }

        @Override // g2.f
        public void bind(k2.i iVar, x xVar) {
            if (xVar.getTag() == null) {
                iVar.bindNull(1);
            } else {
                iVar.bindString(1, xVar.getTag());
            }
            if (xVar.getWorkSpecId() == null) {
                iVar.bindNull(2);
            } else {
                iVar.bindString(2, xVar.getWorkSpecId());
            }
        }
    }

    /* compiled from: WorkTagDao_Impl.java */
    public class b extends SharedSQLiteStatement {
        public b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM worktag WHERE work_spec_id=?";
        }
    }

    public z(RoomDatabase roomDatabase) {
        this.f11462a = roomDatabase;
        this.f11463b = new a(roomDatabase);
        this.f11464c = new b(roomDatabase);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // f3.y
    public void deleteByWorkSpecId(String str) {
        RoomDatabase roomDatabase = this.f11462a;
        roomDatabase.assertNotSuspendingTransaction();
        b bVar = this.f11464c;
        k2.i iVarAcquire = bVar.acquire();
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
            bVar.release(iVarAcquire);
        }
    }

    @Override // f3.y
    public List<String> getTagsForWorkSpecId(String str) {
        g2.q qVarAcquire = g2.q.acquire("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (str == null) {
            qVarAcquire.bindNull(1);
        } else {
            qVarAcquire.bindString(1, str);
        }
        RoomDatabase roomDatabase = this.f11462a;
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

    @Override // f3.y
    public void insert(x xVar) {
        RoomDatabase roomDatabase = this.f11462a;
        roomDatabase.assertNotSuspendingTransaction();
        roomDatabase.beginTransaction();
        try {
            this.f11463b.insert(xVar);
            roomDatabase.setTransactionSuccessful();
        } finally {
            roomDatabase.endTransaction();
        }
    }

    @Override // f3.y
    public void insertTags(String str, Set<String> set) {
        y.a.insertTags(this, str, set);
    }
}
