package f3;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo$State;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import f3.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: WorkSpecDao_Impl.java */
/* loaded from: classes.dex */
public final class v implements u {

    /* renamed from: a, reason: collision with root package name */
    public final RoomDatabase f11448a;

    /* renamed from: b, reason: collision with root package name */
    public final e f11449b;

    /* renamed from: c, reason: collision with root package name */
    public final f f11450c;

    /* renamed from: d, reason: collision with root package name */
    public final g f11451d;

    /* renamed from: e, reason: collision with root package name */
    public final h f11452e;

    /* renamed from: f, reason: collision with root package name */
    public final i f11453f;

    /* renamed from: g, reason: collision with root package name */
    public final j f11454g;

    /* renamed from: h, reason: collision with root package name */
    public final k f11455h;

    /* renamed from: i, reason: collision with root package name */
    public final l f11456i;

    /* renamed from: j, reason: collision with root package name */
    public final m f11457j;

    /* renamed from: k, reason: collision with root package name */
    public final a f11458k;

    /* renamed from: l, reason: collision with root package name */
    public final b f11459l;

    /* compiled from: WorkSpecDao_Impl.java */
    public class a extends SharedSQLiteStatement {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    public class b extends SharedSQLiteStatement {
        public b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    public class c extends SharedSQLiteStatement {
        public c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    public class d extends SharedSQLiteStatement {
        public d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE workspec SET generation=generation+1 WHERE id=?";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    public class e extends g2.f<t> {
        public e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // g2.f
        public void bind(k2.i iVar, t tVar) throws Throwable {
            String str = tVar.f11426a;
            if (str == null) {
                iVar.bindNull(1);
            } else {
                iVar.bindString(1, str);
            }
            iVar.bindLong(2, a0.stateToInt(tVar.f11427b));
            String str2 = tVar.f11428c;
            if (str2 == null) {
                iVar.bindNull(3);
            } else {
                iVar.bindString(3, str2);
            }
            String str3 = tVar.f11429d;
            if (str3 == null) {
                iVar.bindNull(4);
            } else {
                iVar.bindString(4, str3);
            }
            byte[] byteArrayInternal = androidx.work.b.toByteArrayInternal(tVar.f11430e);
            if (byteArrayInternal == null) {
                iVar.bindNull(5);
            } else {
                iVar.bindBlob(5, byteArrayInternal);
            }
            byte[] byteArrayInternal2 = androidx.work.b.toByteArrayInternal(tVar.f11431f);
            if (byteArrayInternal2 == null) {
                iVar.bindNull(6);
            } else {
                iVar.bindBlob(6, byteArrayInternal2);
            }
            iVar.bindLong(7, tVar.f11432g);
            iVar.bindLong(8, tVar.f11433h);
            iVar.bindLong(9, tVar.f11434i);
            iVar.bindLong(10, tVar.f11436k);
            iVar.bindLong(11, a0.backoffPolicyToInt(tVar.f11437l));
            iVar.bindLong(12, tVar.f11438m);
            iVar.bindLong(13, tVar.f11439n);
            iVar.bindLong(14, tVar.f11440o);
            iVar.bindLong(15, tVar.f11441p);
            iVar.bindLong(16, tVar.f11442q ? 1L : 0L);
            iVar.bindLong(17, a0.outOfQuotaPolicyToInt(tVar.f11443r));
            iVar.bindLong(18, tVar.getPeriodCount());
            iVar.bindLong(19, tVar.getGeneration());
            w2.b bVar = tVar.f11435j;
            if (bVar == null) {
                iVar.bindNull(20);
                iVar.bindNull(21);
                iVar.bindNull(22);
                iVar.bindNull(23);
                iVar.bindNull(24);
                iVar.bindNull(25);
                iVar.bindNull(26);
                iVar.bindNull(27);
                return;
            }
            iVar.bindLong(20, a0.networkTypeToInt(bVar.getRequiredNetworkType()));
            iVar.bindLong(21, bVar.requiresCharging() ? 1L : 0L);
            iVar.bindLong(22, bVar.requiresDeviceIdle() ? 1L : 0L);
            iVar.bindLong(23, bVar.requiresBatteryNotLow() ? 1L : 0L);
            iVar.bindLong(24, bVar.requiresStorageNotLow() ? 1L : 0L);
            iVar.bindLong(25, bVar.getContentTriggerUpdateDelayMillis());
            iVar.bindLong(26, bVar.getContentTriggerMaxDelayMillis());
            byte[] ofTriggersToByteArray = a0.setOfTriggersToByteArray(bVar.getContentUriTriggers());
            if (ofTriggersToByteArray == null) {
                iVar.bindNull(27);
            } else {
                iVar.bindBlob(27, ofTriggersToByteArray);
            }
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    public class f extends g2.e<t> {
        public f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`required_network_type` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
        }

        @Override // g2.e
        public void bind(k2.i iVar, t tVar) throws Throwable {
            String str = tVar.f11426a;
            if (str == null) {
                iVar.bindNull(1);
            } else {
                iVar.bindString(1, str);
            }
            iVar.bindLong(2, a0.stateToInt(tVar.f11427b));
            String str2 = tVar.f11428c;
            if (str2 == null) {
                iVar.bindNull(3);
            } else {
                iVar.bindString(3, str2);
            }
            String str3 = tVar.f11429d;
            if (str3 == null) {
                iVar.bindNull(4);
            } else {
                iVar.bindString(4, str3);
            }
            byte[] byteArrayInternal = androidx.work.b.toByteArrayInternal(tVar.f11430e);
            if (byteArrayInternal == null) {
                iVar.bindNull(5);
            } else {
                iVar.bindBlob(5, byteArrayInternal);
            }
            byte[] byteArrayInternal2 = androidx.work.b.toByteArrayInternal(tVar.f11431f);
            if (byteArrayInternal2 == null) {
                iVar.bindNull(6);
            } else {
                iVar.bindBlob(6, byteArrayInternal2);
            }
            iVar.bindLong(7, tVar.f11432g);
            iVar.bindLong(8, tVar.f11433h);
            iVar.bindLong(9, tVar.f11434i);
            iVar.bindLong(10, tVar.f11436k);
            iVar.bindLong(11, a0.backoffPolicyToInt(tVar.f11437l));
            iVar.bindLong(12, tVar.f11438m);
            iVar.bindLong(13, tVar.f11439n);
            iVar.bindLong(14, tVar.f11440o);
            iVar.bindLong(15, tVar.f11441p);
            iVar.bindLong(16, tVar.f11442q ? 1L : 0L);
            iVar.bindLong(17, a0.outOfQuotaPolicyToInt(tVar.f11443r));
            iVar.bindLong(18, tVar.getPeriodCount());
            iVar.bindLong(19, tVar.getGeneration());
            w2.b bVar = tVar.f11435j;
            if (bVar != null) {
                iVar.bindLong(20, a0.networkTypeToInt(bVar.getRequiredNetworkType()));
                iVar.bindLong(21, bVar.requiresCharging() ? 1L : 0L);
                iVar.bindLong(22, bVar.requiresDeviceIdle() ? 1L : 0L);
                iVar.bindLong(23, bVar.requiresBatteryNotLow() ? 1L : 0L);
                iVar.bindLong(24, bVar.requiresStorageNotLow() ? 1L : 0L);
                iVar.bindLong(25, bVar.getContentTriggerUpdateDelayMillis());
                iVar.bindLong(26, bVar.getContentTriggerMaxDelayMillis());
                byte[] ofTriggersToByteArray = a0.setOfTriggersToByteArray(bVar.getContentUriTriggers());
                if (ofTriggersToByteArray == null) {
                    iVar.bindNull(27);
                } else {
                    iVar.bindBlob(27, ofTriggersToByteArray);
                }
            } else {
                iVar.bindNull(20);
                iVar.bindNull(21);
                iVar.bindNull(22);
                iVar.bindNull(23);
                iVar.bindNull(24);
                iVar.bindNull(25);
                iVar.bindNull(26);
                iVar.bindNull(27);
            }
            String str4 = tVar.f11426a;
            if (str4 == null) {
                iVar.bindNull(28);
            } else {
                iVar.bindString(28, str4);
            }
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    public class g extends SharedSQLiteStatement {
        public g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    public class h extends SharedSQLiteStatement {
        public h(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE workspec SET state=? WHERE id=?";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    public class i extends SharedSQLiteStatement {
        public i(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE workspec SET period_count=period_count+1 WHERE id=?";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    public class j extends SharedSQLiteStatement {
        public j(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    public class k extends SharedSQLiteStatement {
        public k(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE workspec SET last_enqueue_time=? WHERE id=?";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    public class l extends SharedSQLiteStatement {
        public l(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    /* compiled from: WorkSpecDao_Impl.java */
    public class m extends SharedSQLiteStatement {
        public m(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    public v(RoomDatabase roomDatabase) {
        this.f11448a = roomDatabase;
        this.f11449b = new e(roomDatabase);
        this.f11450c = new f(roomDatabase);
        this.f11451d = new g(roomDatabase);
        this.f11452e = new h(roomDatabase);
        this.f11453f = new i(roomDatabase);
        this.f11454g = new j(roomDatabase);
        this.f11455h = new k(roomDatabase);
        this.f11456i = new l(roomDatabase);
        this.f11457j = new m(roomDatabase);
        this.f11458k = new a(roomDatabase);
        this.f11459l = new b(roomDatabase);
        new c(roomDatabase);
        new d(roomDatabase);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // f3.u
    public void delete(String str) {
        RoomDatabase roomDatabase = this.f11448a;
        roomDatabase.assertNotSuspendingTransaction();
        g gVar = this.f11451d;
        k2.i iVarAcquire = gVar.acquire();
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
            gVar.release(iVarAcquire);
        }
    }

    @Override // f3.u
    public List<t> getAllEligibleWorkSpecsForScheduling(int i10) throws Throwable {
        g2.q qVar;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i11;
        boolean z10;
        int i12;
        boolean z11;
        int i13;
        boolean z12;
        int i14;
        boolean z13;
        int i15;
        boolean z14;
        g2.q qVarAcquire = g2.q.acquire("SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?", 1);
        qVarAcquire.bindLong(1, i10);
        RoomDatabase roomDatabase = this.f11448a;
        roomDatabase.assertNotSuspendingTransaction();
        Cursor cursorQuery = i2.b.query(roomDatabase, qVarAcquire, false, null);
        try {
            columnIndexOrThrow = i2.a.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow2 = i2.a.getColumnIndexOrThrow(cursorQuery, AdOperationMetric.INIT_STATE);
            columnIndexOrThrow3 = i2.a.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            columnIndexOrThrow4 = i2.a.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            columnIndexOrThrow5 = i2.a.getColumnIndexOrThrow(cursorQuery, "input");
            columnIndexOrThrow6 = i2.a.getColumnIndexOrThrow(cursorQuery, "output");
            columnIndexOrThrow7 = i2.a.getColumnIndexOrThrow(cursorQuery, "initial_delay");
            columnIndexOrThrow8 = i2.a.getColumnIndexOrThrow(cursorQuery, "interval_duration");
            columnIndexOrThrow9 = i2.a.getColumnIndexOrThrow(cursorQuery, "flex_duration");
            columnIndexOrThrow10 = i2.a.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
            columnIndexOrThrow11 = i2.a.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
            columnIndexOrThrow12 = i2.a.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
            columnIndexOrThrow13 = i2.a.getColumnIndexOrThrow(cursorQuery, "last_enqueue_time");
            columnIndexOrThrow14 = i2.a.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
            qVar = qVarAcquire;
        } catch (Throwable th2) {
            th = th2;
            qVar = qVarAcquire;
        }
        try {
            int columnIndexOrThrow15 = i2.a.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
            int columnIndexOrThrow16 = i2.a.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
            int columnIndexOrThrow17 = i2.a.getColumnIndexOrThrow(cursorQuery, "out_of_quota_policy");
            int columnIndexOrThrow18 = i2.a.getColumnIndexOrThrow(cursorQuery, "period_count");
            int columnIndexOrThrow19 = i2.a.getColumnIndexOrThrow(cursorQuery, "generation");
            int columnIndexOrThrow20 = i2.a.getColumnIndexOrThrow(cursorQuery, "required_network_type");
            int columnIndexOrThrow21 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_charging");
            int columnIndexOrThrow22 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
            int columnIndexOrThrow23 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
            int columnIndexOrThrow24 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
            int columnIndexOrThrow25 = i2.a.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
            int columnIndexOrThrow26 = i2.a.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
            int columnIndexOrThrow27 = i2.a.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
            int i16 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                WorkInfo$State workInfo$StateIntToState = a0.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                androidx.work.b bVarFromByteArray = androidx.work.b.fromByteArray(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getBlob(columnIndexOrThrow5));
                androidx.work.b bVarFromByteArray2 = androidx.work.b.fromByteArray(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6));
                long j10 = cursorQuery.getLong(columnIndexOrThrow7);
                long j11 = cursorQuery.getLong(columnIndexOrThrow8);
                long j12 = cursorQuery.getLong(columnIndexOrThrow9);
                int i17 = cursorQuery.getInt(columnIndexOrThrow10);
                BackoffPolicy backoffPolicyIntToBackoffPolicy = a0.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow11));
                long j13 = cursorQuery.getLong(columnIndexOrThrow12);
                long j14 = cursorQuery.getLong(columnIndexOrThrow13);
                int i18 = i16;
                long j15 = cursorQuery.getLong(i18);
                int i19 = columnIndexOrThrow;
                int i20 = columnIndexOrThrow15;
                long j16 = cursorQuery.getLong(i20);
                columnIndexOrThrow15 = i20;
                int i21 = columnIndexOrThrow16;
                if (cursorQuery.getInt(i21) != 0) {
                    columnIndexOrThrow16 = i21;
                    i11 = columnIndexOrThrow17;
                    z10 = true;
                } else {
                    columnIndexOrThrow16 = i21;
                    i11 = columnIndexOrThrow17;
                    z10 = false;
                }
                OutOfQuotaPolicy outOfQuotaPolicyIntToOutOfQuotaPolicy = a0.intToOutOfQuotaPolicy(cursorQuery.getInt(i11));
                columnIndexOrThrow17 = i11;
                int i22 = columnIndexOrThrow18;
                int i23 = cursorQuery.getInt(i22);
                columnIndexOrThrow18 = i22;
                int i24 = columnIndexOrThrow19;
                int i25 = cursorQuery.getInt(i24);
                columnIndexOrThrow19 = i24;
                int i26 = columnIndexOrThrow20;
                NetworkType networkTypeIntToNetworkType = a0.intToNetworkType(cursorQuery.getInt(i26));
                columnIndexOrThrow20 = i26;
                int i27 = columnIndexOrThrow21;
                if (cursorQuery.getInt(i27) != 0) {
                    columnIndexOrThrow21 = i27;
                    i12 = columnIndexOrThrow22;
                    z11 = true;
                } else {
                    columnIndexOrThrow21 = i27;
                    i12 = columnIndexOrThrow22;
                    z11 = false;
                }
                if (cursorQuery.getInt(i12) != 0) {
                    columnIndexOrThrow22 = i12;
                    i13 = columnIndexOrThrow23;
                    z12 = true;
                } else {
                    columnIndexOrThrow22 = i12;
                    i13 = columnIndexOrThrow23;
                    z12 = false;
                }
                if (cursorQuery.getInt(i13) != 0) {
                    columnIndexOrThrow23 = i13;
                    i14 = columnIndexOrThrow24;
                    z13 = true;
                } else {
                    columnIndexOrThrow23 = i13;
                    i14 = columnIndexOrThrow24;
                    z13 = false;
                }
                if (cursorQuery.getInt(i14) != 0) {
                    columnIndexOrThrow24 = i14;
                    i15 = columnIndexOrThrow25;
                    z14 = true;
                } else {
                    columnIndexOrThrow24 = i14;
                    i15 = columnIndexOrThrow25;
                    z14 = false;
                }
                long j17 = cursorQuery.getLong(i15);
                columnIndexOrThrow25 = i15;
                int i28 = columnIndexOrThrow26;
                long j18 = cursorQuery.getLong(i28);
                columnIndexOrThrow26 = i28;
                int i29 = columnIndexOrThrow27;
                columnIndexOrThrow27 = i29;
                arrayList.add(new t(string, workInfo$StateIntToState, string2, string3, bVarFromByteArray, bVarFromByteArray2, j10, j11, j12, new w2.b(networkTypeIntToNetworkType, z11, z12, z13, z14, j17, j18, a0.byteArrayToSetOfTriggers(cursorQuery.isNull(i29) ? null : cursorQuery.getBlob(i29))), i17, backoffPolicyIntToBackoffPolicy, j13, j14, j15, j16, z10, outOfQuotaPolicyIntToOutOfQuotaPolicy, i23, i25));
                columnIndexOrThrow = i19;
                i16 = i18;
            }
            cursorQuery.close();
            qVar.release();
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery.close();
            qVar.release();
            throw th;
        }
    }

    @Override // f3.u
    public List<t> getEligibleWorkForScheduling(int i10) throws Throwable {
        g2.q qVar;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i11;
        boolean z10;
        int i12;
        boolean z11;
        int i13;
        boolean z12;
        int i14;
        boolean z13;
        int i15;
        boolean z14;
        g2.q qVarAcquire = g2.q.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        qVarAcquire.bindLong(1, i10);
        RoomDatabase roomDatabase = this.f11448a;
        roomDatabase.assertNotSuspendingTransaction();
        Cursor cursorQuery = i2.b.query(roomDatabase, qVarAcquire, false, null);
        try {
            columnIndexOrThrow = i2.a.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow2 = i2.a.getColumnIndexOrThrow(cursorQuery, AdOperationMetric.INIT_STATE);
            columnIndexOrThrow3 = i2.a.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            columnIndexOrThrow4 = i2.a.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            columnIndexOrThrow5 = i2.a.getColumnIndexOrThrow(cursorQuery, "input");
            columnIndexOrThrow6 = i2.a.getColumnIndexOrThrow(cursorQuery, "output");
            columnIndexOrThrow7 = i2.a.getColumnIndexOrThrow(cursorQuery, "initial_delay");
            columnIndexOrThrow8 = i2.a.getColumnIndexOrThrow(cursorQuery, "interval_duration");
            columnIndexOrThrow9 = i2.a.getColumnIndexOrThrow(cursorQuery, "flex_duration");
            columnIndexOrThrow10 = i2.a.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
            columnIndexOrThrow11 = i2.a.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
            columnIndexOrThrow12 = i2.a.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
            columnIndexOrThrow13 = i2.a.getColumnIndexOrThrow(cursorQuery, "last_enqueue_time");
            columnIndexOrThrow14 = i2.a.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
            qVar = qVarAcquire;
        } catch (Throwable th2) {
            th = th2;
            qVar = qVarAcquire;
        }
        try {
            int columnIndexOrThrow15 = i2.a.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
            int columnIndexOrThrow16 = i2.a.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
            int columnIndexOrThrow17 = i2.a.getColumnIndexOrThrow(cursorQuery, "out_of_quota_policy");
            int columnIndexOrThrow18 = i2.a.getColumnIndexOrThrow(cursorQuery, "period_count");
            int columnIndexOrThrow19 = i2.a.getColumnIndexOrThrow(cursorQuery, "generation");
            int columnIndexOrThrow20 = i2.a.getColumnIndexOrThrow(cursorQuery, "required_network_type");
            int columnIndexOrThrow21 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_charging");
            int columnIndexOrThrow22 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
            int columnIndexOrThrow23 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
            int columnIndexOrThrow24 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
            int columnIndexOrThrow25 = i2.a.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
            int columnIndexOrThrow26 = i2.a.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
            int columnIndexOrThrow27 = i2.a.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
            int i16 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                WorkInfo$State workInfo$StateIntToState = a0.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                androidx.work.b bVarFromByteArray = androidx.work.b.fromByteArray(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getBlob(columnIndexOrThrow5));
                androidx.work.b bVarFromByteArray2 = androidx.work.b.fromByteArray(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6));
                long j10 = cursorQuery.getLong(columnIndexOrThrow7);
                long j11 = cursorQuery.getLong(columnIndexOrThrow8);
                long j12 = cursorQuery.getLong(columnIndexOrThrow9);
                int i17 = cursorQuery.getInt(columnIndexOrThrow10);
                BackoffPolicy backoffPolicyIntToBackoffPolicy = a0.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow11));
                long j13 = cursorQuery.getLong(columnIndexOrThrow12);
                long j14 = cursorQuery.getLong(columnIndexOrThrow13);
                int i18 = i16;
                long j15 = cursorQuery.getLong(i18);
                int i19 = columnIndexOrThrow;
                int i20 = columnIndexOrThrow15;
                long j16 = cursorQuery.getLong(i20);
                columnIndexOrThrow15 = i20;
                int i21 = columnIndexOrThrow16;
                if (cursorQuery.getInt(i21) != 0) {
                    columnIndexOrThrow16 = i21;
                    i11 = columnIndexOrThrow17;
                    z10 = true;
                } else {
                    columnIndexOrThrow16 = i21;
                    i11 = columnIndexOrThrow17;
                    z10 = false;
                }
                OutOfQuotaPolicy outOfQuotaPolicyIntToOutOfQuotaPolicy = a0.intToOutOfQuotaPolicy(cursorQuery.getInt(i11));
                columnIndexOrThrow17 = i11;
                int i22 = columnIndexOrThrow18;
                int i23 = cursorQuery.getInt(i22);
                columnIndexOrThrow18 = i22;
                int i24 = columnIndexOrThrow19;
                int i25 = cursorQuery.getInt(i24);
                columnIndexOrThrow19 = i24;
                int i26 = columnIndexOrThrow20;
                NetworkType networkTypeIntToNetworkType = a0.intToNetworkType(cursorQuery.getInt(i26));
                columnIndexOrThrow20 = i26;
                int i27 = columnIndexOrThrow21;
                if (cursorQuery.getInt(i27) != 0) {
                    columnIndexOrThrow21 = i27;
                    i12 = columnIndexOrThrow22;
                    z11 = true;
                } else {
                    columnIndexOrThrow21 = i27;
                    i12 = columnIndexOrThrow22;
                    z11 = false;
                }
                if (cursorQuery.getInt(i12) != 0) {
                    columnIndexOrThrow22 = i12;
                    i13 = columnIndexOrThrow23;
                    z12 = true;
                } else {
                    columnIndexOrThrow22 = i12;
                    i13 = columnIndexOrThrow23;
                    z12 = false;
                }
                if (cursorQuery.getInt(i13) != 0) {
                    columnIndexOrThrow23 = i13;
                    i14 = columnIndexOrThrow24;
                    z13 = true;
                } else {
                    columnIndexOrThrow23 = i13;
                    i14 = columnIndexOrThrow24;
                    z13 = false;
                }
                if (cursorQuery.getInt(i14) != 0) {
                    columnIndexOrThrow24 = i14;
                    i15 = columnIndexOrThrow25;
                    z14 = true;
                } else {
                    columnIndexOrThrow24 = i14;
                    i15 = columnIndexOrThrow25;
                    z14 = false;
                }
                long j17 = cursorQuery.getLong(i15);
                columnIndexOrThrow25 = i15;
                int i28 = columnIndexOrThrow26;
                long j18 = cursorQuery.getLong(i28);
                columnIndexOrThrow26 = i28;
                int i29 = columnIndexOrThrow27;
                columnIndexOrThrow27 = i29;
                arrayList.add(new t(string, workInfo$StateIntToState, string2, string3, bVarFromByteArray, bVarFromByteArray2, j10, j11, j12, new w2.b(networkTypeIntToNetworkType, z11, z12, z13, z14, j17, j18, a0.byteArrayToSetOfTriggers(cursorQuery.isNull(i29) ? null : cursorQuery.getBlob(i29))), i17, backoffPolicyIntToBackoffPolicy, j13, j14, j15, j16, z10, outOfQuotaPolicyIntToOutOfQuotaPolicy, i23, i25));
                columnIndexOrThrow = i19;
                i16 = i18;
            }
            cursorQuery.close();
            qVar.release();
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery.close();
            qVar.release();
            throw th;
        }
    }

    @Override // f3.u
    public List<androidx.work.b> getInputsFromPrerequisites(String str) {
        g2.q qVarAcquire = g2.q.acquire("SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            qVarAcquire.bindNull(1);
        } else {
            qVarAcquire.bindString(1, str);
        }
        RoomDatabase roomDatabase = this.f11448a;
        roomDatabase.assertNotSuspendingTransaction();
        Cursor cursorQuery = i2.b.query(roomDatabase, qVarAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(androidx.work.b.fromByteArray(cursorQuery.isNull(0) ? null : cursorQuery.getBlob(0)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            qVarAcquire.release();
        }
    }

    @Override // f3.u
    public List<t> getRecentlyCompletedWork(long j10) throws Throwable {
        g2.q qVar;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i10;
        boolean z10;
        int i11;
        boolean z11;
        int i12;
        boolean z12;
        int i13;
        boolean z13;
        int i14;
        boolean z14;
        g2.q qVarAcquire = g2.q.acquire("SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC", 1);
        qVarAcquire.bindLong(1, j10);
        RoomDatabase roomDatabase = this.f11448a;
        roomDatabase.assertNotSuspendingTransaction();
        Cursor cursorQuery = i2.b.query(roomDatabase, qVarAcquire, false, null);
        try {
            columnIndexOrThrow = i2.a.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow2 = i2.a.getColumnIndexOrThrow(cursorQuery, AdOperationMetric.INIT_STATE);
            columnIndexOrThrow3 = i2.a.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            columnIndexOrThrow4 = i2.a.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            columnIndexOrThrow5 = i2.a.getColumnIndexOrThrow(cursorQuery, "input");
            columnIndexOrThrow6 = i2.a.getColumnIndexOrThrow(cursorQuery, "output");
            columnIndexOrThrow7 = i2.a.getColumnIndexOrThrow(cursorQuery, "initial_delay");
            columnIndexOrThrow8 = i2.a.getColumnIndexOrThrow(cursorQuery, "interval_duration");
            columnIndexOrThrow9 = i2.a.getColumnIndexOrThrow(cursorQuery, "flex_duration");
            columnIndexOrThrow10 = i2.a.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
            columnIndexOrThrow11 = i2.a.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
            columnIndexOrThrow12 = i2.a.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
            columnIndexOrThrow13 = i2.a.getColumnIndexOrThrow(cursorQuery, "last_enqueue_time");
            columnIndexOrThrow14 = i2.a.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
            qVar = qVarAcquire;
        } catch (Throwable th2) {
            th = th2;
            qVar = qVarAcquire;
        }
        try {
            int columnIndexOrThrow15 = i2.a.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
            int columnIndexOrThrow16 = i2.a.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
            int columnIndexOrThrow17 = i2.a.getColumnIndexOrThrow(cursorQuery, "out_of_quota_policy");
            int columnIndexOrThrow18 = i2.a.getColumnIndexOrThrow(cursorQuery, "period_count");
            int columnIndexOrThrow19 = i2.a.getColumnIndexOrThrow(cursorQuery, "generation");
            int columnIndexOrThrow20 = i2.a.getColumnIndexOrThrow(cursorQuery, "required_network_type");
            int columnIndexOrThrow21 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_charging");
            int columnIndexOrThrow22 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
            int columnIndexOrThrow23 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
            int columnIndexOrThrow24 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
            int columnIndexOrThrow25 = i2.a.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
            int columnIndexOrThrow26 = i2.a.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
            int columnIndexOrThrow27 = i2.a.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
            int i15 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                WorkInfo$State workInfo$StateIntToState = a0.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                androidx.work.b bVarFromByteArray = androidx.work.b.fromByteArray(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getBlob(columnIndexOrThrow5));
                androidx.work.b bVarFromByteArray2 = androidx.work.b.fromByteArray(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6));
                long j11 = cursorQuery.getLong(columnIndexOrThrow7);
                long j12 = cursorQuery.getLong(columnIndexOrThrow8);
                long j13 = cursorQuery.getLong(columnIndexOrThrow9);
                int i16 = cursorQuery.getInt(columnIndexOrThrow10);
                BackoffPolicy backoffPolicyIntToBackoffPolicy = a0.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow11));
                long j14 = cursorQuery.getLong(columnIndexOrThrow12);
                long j15 = cursorQuery.getLong(columnIndexOrThrow13);
                int i17 = i15;
                long j16 = cursorQuery.getLong(i17);
                int i18 = columnIndexOrThrow;
                int i19 = columnIndexOrThrow15;
                long j17 = cursorQuery.getLong(i19);
                columnIndexOrThrow15 = i19;
                int i20 = columnIndexOrThrow16;
                if (cursorQuery.getInt(i20) != 0) {
                    columnIndexOrThrow16 = i20;
                    i10 = columnIndexOrThrow17;
                    z10 = true;
                } else {
                    columnIndexOrThrow16 = i20;
                    i10 = columnIndexOrThrow17;
                    z10 = false;
                }
                OutOfQuotaPolicy outOfQuotaPolicyIntToOutOfQuotaPolicy = a0.intToOutOfQuotaPolicy(cursorQuery.getInt(i10));
                columnIndexOrThrow17 = i10;
                int i21 = columnIndexOrThrow18;
                int i22 = cursorQuery.getInt(i21);
                columnIndexOrThrow18 = i21;
                int i23 = columnIndexOrThrow19;
                int i24 = cursorQuery.getInt(i23);
                columnIndexOrThrow19 = i23;
                int i25 = columnIndexOrThrow20;
                NetworkType networkTypeIntToNetworkType = a0.intToNetworkType(cursorQuery.getInt(i25));
                columnIndexOrThrow20 = i25;
                int i26 = columnIndexOrThrow21;
                if (cursorQuery.getInt(i26) != 0) {
                    columnIndexOrThrow21 = i26;
                    i11 = columnIndexOrThrow22;
                    z11 = true;
                } else {
                    columnIndexOrThrow21 = i26;
                    i11 = columnIndexOrThrow22;
                    z11 = false;
                }
                if (cursorQuery.getInt(i11) != 0) {
                    columnIndexOrThrow22 = i11;
                    i12 = columnIndexOrThrow23;
                    z12 = true;
                } else {
                    columnIndexOrThrow22 = i11;
                    i12 = columnIndexOrThrow23;
                    z12 = false;
                }
                if (cursorQuery.getInt(i12) != 0) {
                    columnIndexOrThrow23 = i12;
                    i13 = columnIndexOrThrow24;
                    z13 = true;
                } else {
                    columnIndexOrThrow23 = i12;
                    i13 = columnIndexOrThrow24;
                    z13 = false;
                }
                if (cursorQuery.getInt(i13) != 0) {
                    columnIndexOrThrow24 = i13;
                    i14 = columnIndexOrThrow25;
                    z14 = true;
                } else {
                    columnIndexOrThrow24 = i13;
                    i14 = columnIndexOrThrow25;
                    z14 = false;
                }
                long j18 = cursorQuery.getLong(i14);
                columnIndexOrThrow25 = i14;
                int i27 = columnIndexOrThrow26;
                long j19 = cursorQuery.getLong(i27);
                columnIndexOrThrow26 = i27;
                int i28 = columnIndexOrThrow27;
                columnIndexOrThrow27 = i28;
                arrayList.add(new t(string, workInfo$StateIntToState, string2, string3, bVarFromByteArray, bVarFromByteArray2, j11, j12, j13, new w2.b(networkTypeIntToNetworkType, z11, z12, z13, z14, j18, j19, a0.byteArrayToSetOfTriggers(cursorQuery.isNull(i28) ? null : cursorQuery.getBlob(i28))), i16, backoffPolicyIntToBackoffPolicy, j14, j15, j16, j17, z10, outOfQuotaPolicyIntToOutOfQuotaPolicy, i22, i24));
                columnIndexOrThrow = i18;
                i15 = i17;
            }
            cursorQuery.close();
            qVar.release();
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery.close();
            qVar.release();
            throw th;
        }
    }

    @Override // f3.u
    public List<t> getRunningWork() throws Throwable {
        g2.q qVar;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i10;
        boolean z10;
        int i11;
        boolean z11;
        int i12;
        boolean z12;
        int i13;
        boolean z13;
        int i14;
        boolean z14;
        g2.q qVarAcquire = g2.q.acquire("SELECT * FROM workspec WHERE state=1", 0);
        RoomDatabase roomDatabase = this.f11448a;
        roomDatabase.assertNotSuspendingTransaction();
        Cursor cursorQuery = i2.b.query(roomDatabase, qVarAcquire, false, null);
        try {
            columnIndexOrThrow = i2.a.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow2 = i2.a.getColumnIndexOrThrow(cursorQuery, AdOperationMetric.INIT_STATE);
            columnIndexOrThrow3 = i2.a.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            columnIndexOrThrow4 = i2.a.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            columnIndexOrThrow5 = i2.a.getColumnIndexOrThrow(cursorQuery, "input");
            columnIndexOrThrow6 = i2.a.getColumnIndexOrThrow(cursorQuery, "output");
            columnIndexOrThrow7 = i2.a.getColumnIndexOrThrow(cursorQuery, "initial_delay");
            columnIndexOrThrow8 = i2.a.getColumnIndexOrThrow(cursorQuery, "interval_duration");
            columnIndexOrThrow9 = i2.a.getColumnIndexOrThrow(cursorQuery, "flex_duration");
            columnIndexOrThrow10 = i2.a.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
            columnIndexOrThrow11 = i2.a.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
            columnIndexOrThrow12 = i2.a.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
            columnIndexOrThrow13 = i2.a.getColumnIndexOrThrow(cursorQuery, "last_enqueue_time");
            columnIndexOrThrow14 = i2.a.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
            qVar = qVarAcquire;
        } catch (Throwable th2) {
            th = th2;
            qVar = qVarAcquire;
        }
        try {
            int columnIndexOrThrow15 = i2.a.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
            int columnIndexOrThrow16 = i2.a.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
            int columnIndexOrThrow17 = i2.a.getColumnIndexOrThrow(cursorQuery, "out_of_quota_policy");
            int columnIndexOrThrow18 = i2.a.getColumnIndexOrThrow(cursorQuery, "period_count");
            int columnIndexOrThrow19 = i2.a.getColumnIndexOrThrow(cursorQuery, "generation");
            int columnIndexOrThrow20 = i2.a.getColumnIndexOrThrow(cursorQuery, "required_network_type");
            int columnIndexOrThrow21 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_charging");
            int columnIndexOrThrow22 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
            int columnIndexOrThrow23 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
            int columnIndexOrThrow24 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
            int columnIndexOrThrow25 = i2.a.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
            int columnIndexOrThrow26 = i2.a.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
            int columnIndexOrThrow27 = i2.a.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
            int i15 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                WorkInfo$State workInfo$StateIntToState = a0.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                androidx.work.b bVarFromByteArray = androidx.work.b.fromByteArray(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getBlob(columnIndexOrThrow5));
                androidx.work.b bVarFromByteArray2 = androidx.work.b.fromByteArray(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6));
                long j10 = cursorQuery.getLong(columnIndexOrThrow7);
                long j11 = cursorQuery.getLong(columnIndexOrThrow8);
                long j12 = cursorQuery.getLong(columnIndexOrThrow9);
                int i16 = cursorQuery.getInt(columnIndexOrThrow10);
                BackoffPolicy backoffPolicyIntToBackoffPolicy = a0.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow11));
                long j13 = cursorQuery.getLong(columnIndexOrThrow12);
                long j14 = cursorQuery.getLong(columnIndexOrThrow13);
                int i17 = i15;
                long j15 = cursorQuery.getLong(i17);
                int i18 = columnIndexOrThrow;
                int i19 = columnIndexOrThrow15;
                long j16 = cursorQuery.getLong(i19);
                columnIndexOrThrow15 = i19;
                int i20 = columnIndexOrThrow16;
                if (cursorQuery.getInt(i20) != 0) {
                    columnIndexOrThrow16 = i20;
                    i10 = columnIndexOrThrow17;
                    z10 = true;
                } else {
                    columnIndexOrThrow16 = i20;
                    i10 = columnIndexOrThrow17;
                    z10 = false;
                }
                OutOfQuotaPolicy outOfQuotaPolicyIntToOutOfQuotaPolicy = a0.intToOutOfQuotaPolicy(cursorQuery.getInt(i10));
                columnIndexOrThrow17 = i10;
                int i21 = columnIndexOrThrow18;
                int i22 = cursorQuery.getInt(i21);
                columnIndexOrThrow18 = i21;
                int i23 = columnIndexOrThrow19;
                int i24 = cursorQuery.getInt(i23);
                columnIndexOrThrow19 = i23;
                int i25 = columnIndexOrThrow20;
                NetworkType networkTypeIntToNetworkType = a0.intToNetworkType(cursorQuery.getInt(i25));
                columnIndexOrThrow20 = i25;
                int i26 = columnIndexOrThrow21;
                if (cursorQuery.getInt(i26) != 0) {
                    columnIndexOrThrow21 = i26;
                    i11 = columnIndexOrThrow22;
                    z11 = true;
                } else {
                    columnIndexOrThrow21 = i26;
                    i11 = columnIndexOrThrow22;
                    z11 = false;
                }
                if (cursorQuery.getInt(i11) != 0) {
                    columnIndexOrThrow22 = i11;
                    i12 = columnIndexOrThrow23;
                    z12 = true;
                } else {
                    columnIndexOrThrow22 = i11;
                    i12 = columnIndexOrThrow23;
                    z12 = false;
                }
                if (cursorQuery.getInt(i12) != 0) {
                    columnIndexOrThrow23 = i12;
                    i13 = columnIndexOrThrow24;
                    z13 = true;
                } else {
                    columnIndexOrThrow23 = i12;
                    i13 = columnIndexOrThrow24;
                    z13 = false;
                }
                if (cursorQuery.getInt(i13) != 0) {
                    columnIndexOrThrow24 = i13;
                    i14 = columnIndexOrThrow25;
                    z14 = true;
                } else {
                    columnIndexOrThrow24 = i13;
                    i14 = columnIndexOrThrow25;
                    z14 = false;
                }
                long j17 = cursorQuery.getLong(i14);
                columnIndexOrThrow25 = i14;
                int i27 = columnIndexOrThrow26;
                long j18 = cursorQuery.getLong(i27);
                columnIndexOrThrow26 = i27;
                int i28 = columnIndexOrThrow27;
                columnIndexOrThrow27 = i28;
                arrayList.add(new t(string, workInfo$StateIntToState, string2, string3, bVarFromByteArray, bVarFromByteArray2, j10, j11, j12, new w2.b(networkTypeIntToNetworkType, z11, z12, z13, z14, j17, j18, a0.byteArrayToSetOfTriggers(cursorQuery.isNull(i28) ? null : cursorQuery.getBlob(i28))), i16, backoffPolicyIntToBackoffPolicy, j13, j14, j15, j16, z10, outOfQuotaPolicyIntToOutOfQuotaPolicy, i22, i24));
                columnIndexOrThrow = i18;
                i15 = i17;
            }
            cursorQuery.close();
            qVar.release();
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery.close();
            qVar.release();
            throw th;
        }
    }

    @Override // f3.u
    public List<t> getScheduledWork() throws Throwable {
        g2.q qVar;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i10;
        boolean z10;
        int i11;
        boolean z11;
        int i12;
        boolean z12;
        int i13;
        boolean z13;
        int i14;
        boolean z14;
        g2.q qVarAcquire = g2.q.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        RoomDatabase roomDatabase = this.f11448a;
        roomDatabase.assertNotSuspendingTransaction();
        Cursor cursorQuery = i2.b.query(roomDatabase, qVarAcquire, false, null);
        try {
            columnIndexOrThrow = i2.a.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow2 = i2.a.getColumnIndexOrThrow(cursorQuery, AdOperationMetric.INIT_STATE);
            columnIndexOrThrow3 = i2.a.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            columnIndexOrThrow4 = i2.a.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            columnIndexOrThrow5 = i2.a.getColumnIndexOrThrow(cursorQuery, "input");
            columnIndexOrThrow6 = i2.a.getColumnIndexOrThrow(cursorQuery, "output");
            columnIndexOrThrow7 = i2.a.getColumnIndexOrThrow(cursorQuery, "initial_delay");
            columnIndexOrThrow8 = i2.a.getColumnIndexOrThrow(cursorQuery, "interval_duration");
            columnIndexOrThrow9 = i2.a.getColumnIndexOrThrow(cursorQuery, "flex_duration");
            columnIndexOrThrow10 = i2.a.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
            columnIndexOrThrow11 = i2.a.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
            columnIndexOrThrow12 = i2.a.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
            columnIndexOrThrow13 = i2.a.getColumnIndexOrThrow(cursorQuery, "last_enqueue_time");
            columnIndexOrThrow14 = i2.a.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
            qVar = qVarAcquire;
        } catch (Throwable th2) {
            th = th2;
            qVar = qVarAcquire;
        }
        try {
            int columnIndexOrThrow15 = i2.a.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
            int columnIndexOrThrow16 = i2.a.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
            int columnIndexOrThrow17 = i2.a.getColumnIndexOrThrow(cursorQuery, "out_of_quota_policy");
            int columnIndexOrThrow18 = i2.a.getColumnIndexOrThrow(cursorQuery, "period_count");
            int columnIndexOrThrow19 = i2.a.getColumnIndexOrThrow(cursorQuery, "generation");
            int columnIndexOrThrow20 = i2.a.getColumnIndexOrThrow(cursorQuery, "required_network_type");
            int columnIndexOrThrow21 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_charging");
            int columnIndexOrThrow22 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
            int columnIndexOrThrow23 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
            int columnIndexOrThrow24 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
            int columnIndexOrThrow25 = i2.a.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
            int columnIndexOrThrow26 = i2.a.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
            int columnIndexOrThrow27 = i2.a.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
            int i15 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                WorkInfo$State workInfo$StateIntToState = a0.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                androidx.work.b bVarFromByteArray = androidx.work.b.fromByteArray(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getBlob(columnIndexOrThrow5));
                androidx.work.b bVarFromByteArray2 = androidx.work.b.fromByteArray(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6));
                long j10 = cursorQuery.getLong(columnIndexOrThrow7);
                long j11 = cursorQuery.getLong(columnIndexOrThrow8);
                long j12 = cursorQuery.getLong(columnIndexOrThrow9);
                int i16 = cursorQuery.getInt(columnIndexOrThrow10);
                BackoffPolicy backoffPolicyIntToBackoffPolicy = a0.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow11));
                long j13 = cursorQuery.getLong(columnIndexOrThrow12);
                long j14 = cursorQuery.getLong(columnIndexOrThrow13);
                int i17 = i15;
                long j15 = cursorQuery.getLong(i17);
                int i18 = columnIndexOrThrow;
                int i19 = columnIndexOrThrow15;
                long j16 = cursorQuery.getLong(i19);
                columnIndexOrThrow15 = i19;
                int i20 = columnIndexOrThrow16;
                if (cursorQuery.getInt(i20) != 0) {
                    columnIndexOrThrow16 = i20;
                    i10 = columnIndexOrThrow17;
                    z10 = true;
                } else {
                    columnIndexOrThrow16 = i20;
                    i10 = columnIndexOrThrow17;
                    z10 = false;
                }
                OutOfQuotaPolicy outOfQuotaPolicyIntToOutOfQuotaPolicy = a0.intToOutOfQuotaPolicy(cursorQuery.getInt(i10));
                columnIndexOrThrow17 = i10;
                int i21 = columnIndexOrThrow18;
                int i22 = cursorQuery.getInt(i21);
                columnIndexOrThrow18 = i21;
                int i23 = columnIndexOrThrow19;
                int i24 = cursorQuery.getInt(i23);
                columnIndexOrThrow19 = i23;
                int i25 = columnIndexOrThrow20;
                NetworkType networkTypeIntToNetworkType = a0.intToNetworkType(cursorQuery.getInt(i25));
                columnIndexOrThrow20 = i25;
                int i26 = columnIndexOrThrow21;
                if (cursorQuery.getInt(i26) != 0) {
                    columnIndexOrThrow21 = i26;
                    i11 = columnIndexOrThrow22;
                    z11 = true;
                } else {
                    columnIndexOrThrow21 = i26;
                    i11 = columnIndexOrThrow22;
                    z11 = false;
                }
                if (cursorQuery.getInt(i11) != 0) {
                    columnIndexOrThrow22 = i11;
                    i12 = columnIndexOrThrow23;
                    z12 = true;
                } else {
                    columnIndexOrThrow22 = i11;
                    i12 = columnIndexOrThrow23;
                    z12 = false;
                }
                if (cursorQuery.getInt(i12) != 0) {
                    columnIndexOrThrow23 = i12;
                    i13 = columnIndexOrThrow24;
                    z13 = true;
                } else {
                    columnIndexOrThrow23 = i12;
                    i13 = columnIndexOrThrow24;
                    z13 = false;
                }
                if (cursorQuery.getInt(i13) != 0) {
                    columnIndexOrThrow24 = i13;
                    i14 = columnIndexOrThrow25;
                    z14 = true;
                } else {
                    columnIndexOrThrow24 = i13;
                    i14 = columnIndexOrThrow25;
                    z14 = false;
                }
                long j17 = cursorQuery.getLong(i14);
                columnIndexOrThrow25 = i14;
                int i27 = columnIndexOrThrow26;
                long j18 = cursorQuery.getLong(i27);
                columnIndexOrThrow26 = i27;
                int i28 = columnIndexOrThrow27;
                columnIndexOrThrow27 = i28;
                arrayList.add(new t(string, workInfo$StateIntToState, string2, string3, bVarFromByteArray, bVarFromByteArray2, j10, j11, j12, new w2.b(networkTypeIntToNetworkType, z11, z12, z13, z14, j17, j18, a0.byteArrayToSetOfTriggers(cursorQuery.isNull(i28) ? null : cursorQuery.getBlob(i28))), i16, backoffPolicyIntToBackoffPolicy, j13, j14, j15, j16, z10, outOfQuotaPolicyIntToOutOfQuotaPolicy, i22, i24));
                columnIndexOrThrow = i18;
                i15 = i17;
            }
            cursorQuery.close();
            qVar.release();
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery.close();
            qVar.release();
            throw th;
        }
    }

    @Override // f3.u
    public WorkInfo$State getState(String str) {
        g2.q qVarAcquire = g2.q.acquire("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            qVarAcquire.bindNull(1);
        } else {
            qVarAcquire.bindString(1, str);
        }
        RoomDatabase roomDatabase = this.f11448a;
        roomDatabase.assertNotSuspendingTransaction();
        WorkInfo$State workInfo$StateIntToState = null;
        Cursor cursorQuery = i2.b.query(roomDatabase, qVarAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                Integer numValueOf = cursorQuery.isNull(0) ? null : Integer.valueOf(cursorQuery.getInt(0));
                if (numValueOf != null) {
                    workInfo$StateIntToState = a0.intToState(numValueOf.intValue());
                }
            }
            return workInfo$StateIntToState;
        } finally {
            cursorQuery.close();
            qVarAcquire.release();
        }
    }

    @Override // f3.u
    public List<String> getUnfinishedWorkWithName(String str) {
        g2.q qVarAcquire = g2.q.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            qVarAcquire.bindNull(1);
        } else {
            qVarAcquire.bindString(1, str);
        }
        RoomDatabase roomDatabase = this.f11448a;
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

    @Override // f3.u
    public t getWorkSpec(String str) throws Throwable {
        g2.q qVar;
        t tVar;
        int i10;
        boolean z10;
        int i11;
        boolean z11;
        int i12;
        boolean z12;
        int i13;
        boolean z13;
        int i14;
        boolean z14;
        g2.q qVarAcquire = g2.q.acquire("SELECT * FROM workspec WHERE id=?", 1);
        if (str == null) {
            qVarAcquire.bindNull(1);
        } else {
            qVarAcquire.bindString(1, str);
        }
        RoomDatabase roomDatabase = this.f11448a;
        roomDatabase.assertNotSuspendingTransaction();
        Cursor cursorQuery = i2.b.query(roomDatabase, qVarAcquire, false, null);
        try {
            int columnIndexOrThrow = i2.a.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = i2.a.getColumnIndexOrThrow(cursorQuery, AdOperationMetric.INIT_STATE);
            int columnIndexOrThrow3 = i2.a.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            int columnIndexOrThrow4 = i2.a.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            int columnIndexOrThrow5 = i2.a.getColumnIndexOrThrow(cursorQuery, "input");
            int columnIndexOrThrow6 = i2.a.getColumnIndexOrThrow(cursorQuery, "output");
            int columnIndexOrThrow7 = i2.a.getColumnIndexOrThrow(cursorQuery, "initial_delay");
            int columnIndexOrThrow8 = i2.a.getColumnIndexOrThrow(cursorQuery, "interval_duration");
            int columnIndexOrThrow9 = i2.a.getColumnIndexOrThrow(cursorQuery, "flex_duration");
            int columnIndexOrThrow10 = i2.a.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
            int columnIndexOrThrow11 = i2.a.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
            int columnIndexOrThrow12 = i2.a.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
            int columnIndexOrThrow13 = i2.a.getColumnIndexOrThrow(cursorQuery, "last_enqueue_time");
            int columnIndexOrThrow14 = i2.a.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
            qVar = qVarAcquire;
            try {
                int columnIndexOrThrow15 = i2.a.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
                int columnIndexOrThrow16 = i2.a.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
                int columnIndexOrThrow17 = i2.a.getColumnIndexOrThrow(cursorQuery, "out_of_quota_policy");
                int columnIndexOrThrow18 = i2.a.getColumnIndexOrThrow(cursorQuery, "period_count");
                int columnIndexOrThrow19 = i2.a.getColumnIndexOrThrow(cursorQuery, "generation");
                int columnIndexOrThrow20 = i2.a.getColumnIndexOrThrow(cursorQuery, "required_network_type");
                int columnIndexOrThrow21 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_charging");
                int columnIndexOrThrow22 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
                int columnIndexOrThrow23 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
                int columnIndexOrThrow24 = i2.a.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
                int columnIndexOrThrow25 = i2.a.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
                int columnIndexOrThrow26 = i2.a.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
                int columnIndexOrThrow27 = i2.a.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                    WorkInfo$State workInfo$StateIntToState = a0.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                    String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                    androidx.work.b bVarFromByteArray = androidx.work.b.fromByteArray(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getBlob(columnIndexOrThrow5));
                    androidx.work.b bVarFromByteArray2 = androidx.work.b.fromByteArray(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6));
                    long j10 = cursorQuery.getLong(columnIndexOrThrow7);
                    long j11 = cursorQuery.getLong(columnIndexOrThrow8);
                    long j12 = cursorQuery.getLong(columnIndexOrThrow9);
                    int i15 = cursorQuery.getInt(columnIndexOrThrow10);
                    BackoffPolicy backoffPolicyIntToBackoffPolicy = a0.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow11));
                    long j13 = cursorQuery.getLong(columnIndexOrThrow12);
                    long j14 = cursorQuery.getLong(columnIndexOrThrow13);
                    long j15 = cursorQuery.getLong(columnIndexOrThrow14);
                    long j16 = cursorQuery.getLong(columnIndexOrThrow15);
                    if (cursorQuery.getInt(columnIndexOrThrow16) != 0) {
                        i10 = columnIndexOrThrow17;
                        z10 = true;
                    } else {
                        i10 = columnIndexOrThrow17;
                        z10 = false;
                    }
                    OutOfQuotaPolicy outOfQuotaPolicyIntToOutOfQuotaPolicy = a0.intToOutOfQuotaPolicy(cursorQuery.getInt(i10));
                    int i16 = cursorQuery.getInt(columnIndexOrThrow18);
                    int i17 = cursorQuery.getInt(columnIndexOrThrow19);
                    NetworkType networkTypeIntToNetworkType = a0.intToNetworkType(cursorQuery.getInt(columnIndexOrThrow20));
                    if (cursorQuery.getInt(columnIndexOrThrow21) != 0) {
                        i11 = columnIndexOrThrow22;
                        z11 = true;
                    } else {
                        i11 = columnIndexOrThrow22;
                        z11 = false;
                    }
                    if (cursorQuery.getInt(i11) != 0) {
                        i12 = columnIndexOrThrow23;
                        z12 = true;
                    } else {
                        i12 = columnIndexOrThrow23;
                        z12 = false;
                    }
                    if (cursorQuery.getInt(i12) != 0) {
                        i13 = columnIndexOrThrow24;
                        z13 = true;
                    } else {
                        i13 = columnIndexOrThrow24;
                        z13 = false;
                    }
                    if (cursorQuery.getInt(i13) != 0) {
                        i14 = columnIndexOrThrow25;
                        z14 = true;
                    } else {
                        i14 = columnIndexOrThrow25;
                        z14 = false;
                    }
                    tVar = new t(string, workInfo$StateIntToState, string2, string3, bVarFromByteArray, bVarFromByteArray2, j10, j11, j12, new w2.b(networkTypeIntToNetworkType, z11, z12, z13, z14, cursorQuery.getLong(i14), cursorQuery.getLong(columnIndexOrThrow26), a0.byteArrayToSetOfTriggers(cursorQuery.isNull(columnIndexOrThrow27) ? null : cursorQuery.getBlob(columnIndexOrThrow27))), i15, backoffPolicyIntToBackoffPolicy, j13, j14, j15, j16, z10, outOfQuotaPolicyIntToOutOfQuotaPolicy, i16, i17);
                } else {
                    tVar = null;
                }
                cursorQuery.close();
                qVar.release();
                return tVar;
            } catch (Throwable th2) {
                th = th2;
                cursorQuery.close();
                qVar.release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            qVar = qVarAcquire;
        }
    }

    @Override // f3.u
    public List<t.b> getWorkSpecIdAndStatesForName(String str) {
        g2.q qVarAcquire = g2.q.acquire("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            qVarAcquire.bindNull(1);
        } else {
            qVarAcquire.bindString(1, str);
        }
        RoomDatabase roomDatabase = this.f11448a;
        roomDatabase.assertNotSuspendingTransaction();
        Cursor cursorQuery = i2.b.query(roomDatabase, qVarAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new t.b(cursorQuery.isNull(0) ? null : cursorQuery.getString(0), a0.intToState(cursorQuery.getInt(1))));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            qVarAcquire.release();
        }
    }

    @Override // f3.u
    public boolean hasUnfinishedWork() {
        boolean z10 = false;
        g2.q qVarAcquire = g2.q.acquire("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        RoomDatabase roomDatabase = this.f11448a;
        roomDatabase.assertNotSuspendingTransaction();
        Cursor cursorQuery = i2.b.query(roomDatabase, qVarAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                if (cursorQuery.getInt(0) != 0) {
                    z10 = true;
                }
            }
            return z10;
        } finally {
            cursorQuery.close();
            qVarAcquire.release();
        }
    }

    @Override // f3.u
    public void incrementPeriodCount(String str) {
        RoomDatabase roomDatabase = this.f11448a;
        roomDatabase.assertNotSuspendingTransaction();
        i iVar = this.f11453f;
        k2.i iVarAcquire = iVar.acquire();
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
            iVar.release(iVarAcquire);
        }
    }

    @Override // f3.u
    public int incrementWorkSpecRunAttemptCount(String str) {
        RoomDatabase roomDatabase = this.f11448a;
        roomDatabase.assertNotSuspendingTransaction();
        l lVar = this.f11456i;
        k2.i iVarAcquire = lVar.acquire();
        if (str == null) {
            iVarAcquire.bindNull(1);
        } else {
            iVarAcquire.bindString(1, str);
        }
        roomDatabase.beginTransaction();
        try {
            int iExecuteUpdateDelete = iVarAcquire.executeUpdateDelete();
            roomDatabase.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            roomDatabase.endTransaction();
            lVar.release(iVarAcquire);
        }
    }

    @Override // f3.u
    public void insertWorkSpec(t tVar) {
        RoomDatabase roomDatabase = this.f11448a;
        roomDatabase.assertNotSuspendingTransaction();
        roomDatabase.beginTransaction();
        try {
            this.f11449b.insert(tVar);
            roomDatabase.setTransactionSuccessful();
        } finally {
            roomDatabase.endTransaction();
        }
    }

    @Override // f3.u
    public int markWorkSpecScheduled(String str, long j10) {
        RoomDatabase roomDatabase = this.f11448a;
        roomDatabase.assertNotSuspendingTransaction();
        a aVar = this.f11458k;
        k2.i iVarAcquire = aVar.acquire();
        iVarAcquire.bindLong(1, j10);
        if (str == null) {
            iVarAcquire.bindNull(2);
        } else {
            iVarAcquire.bindString(2, str);
        }
        roomDatabase.beginTransaction();
        try {
            int iExecuteUpdateDelete = iVarAcquire.executeUpdateDelete();
            roomDatabase.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            roomDatabase.endTransaction();
            aVar.release(iVarAcquire);
        }
    }

    @Override // f3.u
    public int resetScheduledState() {
        RoomDatabase roomDatabase = this.f11448a;
        roomDatabase.assertNotSuspendingTransaction();
        b bVar = this.f11459l;
        k2.i iVarAcquire = bVar.acquire();
        roomDatabase.beginTransaction();
        try {
            int iExecuteUpdateDelete = iVarAcquire.executeUpdateDelete();
            roomDatabase.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            roomDatabase.endTransaction();
            bVar.release(iVarAcquire);
        }
    }

    @Override // f3.u
    public int resetWorkSpecRunAttemptCount(String str) {
        RoomDatabase roomDatabase = this.f11448a;
        roomDatabase.assertNotSuspendingTransaction();
        m mVar = this.f11457j;
        k2.i iVarAcquire = mVar.acquire();
        if (str == null) {
            iVarAcquire.bindNull(1);
        } else {
            iVarAcquire.bindString(1, str);
        }
        roomDatabase.beginTransaction();
        try {
            int iExecuteUpdateDelete = iVarAcquire.executeUpdateDelete();
            roomDatabase.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            roomDatabase.endTransaction();
            mVar.release(iVarAcquire);
        }
    }

    @Override // f3.u
    public void setLastEnqueuedTime(String str, long j10) {
        RoomDatabase roomDatabase = this.f11448a;
        roomDatabase.assertNotSuspendingTransaction();
        k kVar = this.f11455h;
        k2.i iVarAcquire = kVar.acquire();
        iVarAcquire.bindLong(1, j10);
        if (str == null) {
            iVarAcquire.bindNull(2);
        } else {
            iVarAcquire.bindString(2, str);
        }
        roomDatabase.beginTransaction();
        try {
            iVarAcquire.executeUpdateDelete();
            roomDatabase.setTransactionSuccessful();
        } finally {
            roomDatabase.endTransaction();
            kVar.release(iVarAcquire);
        }
    }

    @Override // f3.u
    public void setOutput(String str, androidx.work.b bVar) throws Throwable {
        RoomDatabase roomDatabase = this.f11448a;
        roomDatabase.assertNotSuspendingTransaction();
        j jVar = this.f11454g;
        k2.i iVarAcquire = jVar.acquire();
        byte[] byteArrayInternal = androidx.work.b.toByteArrayInternal(bVar);
        if (byteArrayInternal == null) {
            iVarAcquire.bindNull(1);
        } else {
            iVarAcquire.bindBlob(1, byteArrayInternal);
        }
        if (str == null) {
            iVarAcquire.bindNull(2);
        } else {
            iVarAcquire.bindString(2, str);
        }
        roomDatabase.beginTransaction();
        try {
            iVarAcquire.executeUpdateDelete();
            roomDatabase.setTransactionSuccessful();
        } finally {
            roomDatabase.endTransaction();
            jVar.release(iVarAcquire);
        }
    }

    @Override // f3.u
    public int setState(WorkInfo$State workInfo$State, String str) {
        RoomDatabase roomDatabase = this.f11448a;
        roomDatabase.assertNotSuspendingTransaction();
        h hVar = this.f11452e;
        k2.i iVarAcquire = hVar.acquire();
        iVarAcquire.bindLong(1, a0.stateToInt(workInfo$State));
        if (str == null) {
            iVarAcquire.bindNull(2);
        } else {
            iVarAcquire.bindString(2, str);
        }
        roomDatabase.beginTransaction();
        try {
            int iExecuteUpdateDelete = iVarAcquire.executeUpdateDelete();
            roomDatabase.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            roomDatabase.endTransaction();
            hVar.release(iVarAcquire);
        }
    }

    @Override // f3.u
    public void updateWorkSpec(t tVar) {
        RoomDatabase roomDatabase = this.f11448a;
        roomDatabase.assertNotSuspendingTransaction();
        roomDatabase.beginTransaction();
        try {
            this.f11450c.handle(tVar);
            roomDatabase.setTransactionSuccessful();
        } finally {
            roomDatabase.endTransaction();
        }
    }
}
