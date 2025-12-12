package f3;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import java.util.Collections;
import java.util.List;

/* compiled from: PreferenceDao_Impl.java */
/* loaded from: classes.dex */
public final class f implements e {

    /* renamed from: a, reason: collision with root package name */
    public final RoomDatabase f11407a;

    /* renamed from: b, reason: collision with root package name */
    public final a f11408b;

    /* compiled from: PreferenceDao_Impl.java */
    public class a extends g2.f<d> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
        }

        @Override // g2.f
        public void bind(k2.i iVar, d dVar) {
            if (dVar.getKey() == null) {
                iVar.bindNull(1);
            } else {
                iVar.bindString(1, dVar.getKey());
            }
            if (dVar.getValue() == null) {
                iVar.bindNull(2);
            } else {
                iVar.bindLong(2, dVar.getValue().longValue());
            }
        }
    }

    public f(RoomDatabase roomDatabase) {
        this.f11407a = roomDatabase;
        this.f11408b = new a(roomDatabase);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // f3.e
    public Long getLongValue(String str) {
        g2.q qVarAcquire = g2.q.acquire("SELECT long_value FROM Preference where `key`=?", 1);
        if (str == null) {
            qVarAcquire.bindNull(1);
        } else {
            qVarAcquire.bindString(1, str);
        }
        RoomDatabase roomDatabase = this.f11407a;
        roomDatabase.assertNotSuspendingTransaction();
        Long lValueOf = null;
        Cursor cursorQuery = i2.b.query(roomDatabase, qVarAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                lValueOf = Long.valueOf(cursorQuery.getLong(0));
            }
            return lValueOf;
        } finally {
            cursorQuery.close();
            qVarAcquire.release();
        }
    }

    @Override // f3.e
    public void insertPreference(d dVar) {
        RoomDatabase roomDatabase = this.f11407a;
        roomDatabase.assertNotSuspendingTransaction();
        roomDatabase.beginTransaction();
        try {
            this.f11408b.insert(dVar);
            roomDatabase.setTransactionSuccessful();
        } finally {
            roomDatabase.endTransaction();
        }
    }
}
