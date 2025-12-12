package f3;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: DependencyDao_Impl.java */
/* loaded from: classes.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name */
    public final RoomDatabase f11403a;

    /* renamed from: b, reason: collision with root package name */
    public final a f11404b;

    /* compiled from: DependencyDao_Impl.java */
    public class a extends g2.f<f3.a> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }

        @Override // g2.f
        public void bind(k2.i iVar, f3.a aVar) {
            if (aVar.getWorkSpecId() == null) {
                iVar.bindNull(1);
            } else {
                iVar.bindString(1, aVar.getWorkSpecId());
            }
            if (aVar.getPrerequisiteId() == null) {
                iVar.bindNull(2);
            } else {
                iVar.bindString(2, aVar.getPrerequisiteId());
            }
        }
    }

    public c(RoomDatabase roomDatabase) {
        this.f11403a = roomDatabase;
        this.f11404b = new a(roomDatabase);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // f3.b
    public List<String> getDependentWorkIds(String str) {
        g2.q qVarAcquire = g2.q.acquire("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            qVarAcquire.bindNull(1);
        } else {
            qVarAcquire.bindString(1, str);
        }
        RoomDatabase roomDatabase = this.f11403a;
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

    @Override // f3.b
    public boolean hasCompletedAllPrerequisites(String str) {
        g2.q qVarAcquire = g2.q.acquire("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            qVarAcquire.bindNull(1);
        } else {
            qVarAcquire.bindString(1, str);
        }
        RoomDatabase roomDatabase = this.f11403a;
        roomDatabase.assertNotSuspendingTransaction();
        boolean z10 = false;
        Cursor cursorQuery = i2.b.query(roomDatabase, qVarAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                z10 = cursorQuery.getInt(0) != 0;
            }
            return z10;
        } finally {
            cursorQuery.close();
            qVarAcquire.release();
        }
    }

    @Override // f3.b
    public boolean hasDependents(String str) {
        g2.q qVarAcquire = g2.q.acquire("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            qVarAcquire.bindNull(1);
        } else {
            qVarAcquire.bindString(1, str);
        }
        RoomDatabase roomDatabase = this.f11403a;
        roomDatabase.assertNotSuspendingTransaction();
        boolean z10 = false;
        Cursor cursorQuery = i2.b.query(roomDatabase, qVarAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                z10 = cursorQuery.getInt(0) != 0;
            }
            return z10;
        } finally {
            cursorQuery.close();
            qVarAcquire.release();
        }
    }

    @Override // f3.b
    public void insertDependency(f3.a aVar) {
        RoomDatabase roomDatabase = this.f11403a;
        roomDatabase.assertNotSuspendingTransaction();
        roomDatabase.beginTransaction();
        try {
            this.f11404b.insert(aVar);
            roomDatabase.setTransactionSuccessful();
        } finally {
            roomDatabase.endTransaction();
        }
    }
}
