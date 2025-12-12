package f3;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import java.util.Collections;
import java.util.List;

/* compiled from: WorkProgressDao_Impl.java */
/* loaded from: classes.dex */
public final class s implements r {

    /* renamed from: a, reason: collision with root package name */
    public final RoomDatabase f11422a;

    /* renamed from: b, reason: collision with root package name */
    public final b f11423b;

    /* renamed from: c, reason: collision with root package name */
    public final c f11424c;

    /* compiled from: WorkProgressDao_Impl.java */
    public class a extends g2.f<q> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }

        @Override // g2.f
        public void bind(k2.i iVar, q qVar) throws Throwable {
            if (qVar.getWorkSpecId() == null) {
                iVar.bindNull(1);
            } else {
                iVar.bindString(1, qVar.getWorkSpecId());
            }
            byte[] byteArrayInternal = androidx.work.b.toByteArrayInternal(qVar.getProgress());
            if (byteArrayInternal == null) {
                iVar.bindNull(2);
            } else {
                iVar.bindBlob(2, byteArrayInternal);
            }
        }
    }

    /* compiled from: WorkProgressDao_Impl.java */
    public class b extends SharedSQLiteStatement {
        public b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE from WorkProgress where work_spec_id=?";
        }
    }

    /* compiled from: WorkProgressDao_Impl.java */
    public class c extends SharedSQLiteStatement {
        public c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM WorkProgress";
        }
    }

    public s(RoomDatabase roomDatabase) {
        this.f11422a = roomDatabase;
        new a(roomDatabase);
        this.f11423b = new b(roomDatabase);
        this.f11424c = new c(roomDatabase);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // f3.r
    public void delete(String str) {
        RoomDatabase roomDatabase = this.f11422a;
        roomDatabase.assertNotSuspendingTransaction();
        b bVar = this.f11423b;
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

    @Override // f3.r
    public void deleteAll() {
        RoomDatabase roomDatabase = this.f11422a;
        roomDatabase.assertNotSuspendingTransaction();
        c cVar = this.f11424c;
        k2.i iVarAcquire = cVar.acquire();
        roomDatabase.beginTransaction();
        try {
            iVarAcquire.executeUpdateDelete();
            roomDatabase.setTransactionSuccessful();
        } finally {
            roomDatabase.endTransaction();
            cVar.release(iVarAcquire);
        }
    }
}
