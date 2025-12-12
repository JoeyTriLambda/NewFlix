package androidx.work.impl;

import android.database.SQLException;
import androidx.room.RoomDatabase;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import f3.b;
import f3.c;
import f3.e;
import f3.f;
import f3.g;
import f3.h;
import f3.k;
import f3.o;
import f3.p;
import f3.r;
import f3.s;
import f3.u;
import f3.v;
import f3.y;
import f3.z;
import g2.j;
import g2.p;
import i2.d;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k2.f;
import x2.c0;
import x2.d0;

/* loaded from: classes.dex */
public final class WorkDatabase_Impl extends WorkDatabase {

    /* renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f4516u = 0;

    /* renamed from: n, reason: collision with root package name */
    public volatile v f4517n;

    /* renamed from: o, reason: collision with root package name */
    public volatile c f4518o;

    /* renamed from: p, reason: collision with root package name */
    public volatile z f4519p;

    /* renamed from: q, reason: collision with root package name */
    public volatile k f4520q;

    /* renamed from: r, reason: collision with root package name */
    public volatile p f4521r;

    /* renamed from: s, reason: collision with root package name */
    public volatile s f4522s;

    /* renamed from: t, reason: collision with root package name */
    public volatile f f4523t;

    @Override // androidx.room.RoomDatabase
    public j createInvalidationTracker() {
        return new j(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // androidx.room.RoomDatabase
    public k2.f createOpenHelper(g2.c cVar) {
        return cVar.f12551c.create(f.b.builder(cVar.f12549a).name(cVar.f12550b).callback(new g2.p(cVar, new a(), "5181942b9ebc31ce68dacb56c16fd79f", "ae2044fb577e65ee8bb576ca48a2f06e")).build());
    }

    @Override // androidx.work.impl.WorkDatabase
    public b dependencyDao() {
        c cVar;
        if (this.f4518o != null) {
            return this.f4518o;
        }
        synchronized (this) {
            if (this.f4518o == null) {
                this.f4518o = new c(this);
            }
            cVar = this.f4518o;
        }
        return cVar;
    }

    @Override // androidx.room.RoomDatabase
    public List<h2.b> getAutoMigrations(Map<Class<? extends h2.a>, h2.a> map) {
        return Arrays.asList(new c0(), new d0());
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends h2.a>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(u.class, v.getRequiredConverters());
        map.put(b.class, c.getRequiredConverters());
        map.put(y.class, z.getRequiredConverters());
        map.put(f3.j.class, k.getRequiredConverters());
        map.put(o.class, p.getRequiredConverters());
        map.put(r.class, s.getRequiredConverters());
        map.put(e.class, f3.f.getRequiredConverters());
        map.put(g.class, h.getRequiredConverters());
        return map;
    }

    @Override // androidx.work.impl.WorkDatabase
    public e preferenceDao() {
        f3.f fVar;
        if (this.f4523t != null) {
            return this.f4523t;
        }
        synchronized (this) {
            if (this.f4523t == null) {
                this.f4523t = new f3.f(this);
            }
            fVar = this.f4523t;
        }
        return fVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public f3.j systemIdInfoDao() {
        k kVar;
        if (this.f4520q != null) {
            return this.f4520q;
        }
        synchronized (this) {
            if (this.f4520q == null) {
                this.f4520q = new k(this);
            }
            kVar = this.f4520q;
        }
        return kVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public o workNameDao() {
        p pVar;
        if (this.f4521r != null) {
            return this.f4521r;
        }
        synchronized (this) {
            if (this.f4521r == null) {
                this.f4521r = new p(this);
            }
            pVar = this.f4521r;
        }
        return pVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public r workProgressDao() {
        s sVar;
        if (this.f4522s != null) {
            return this.f4522s;
        }
        synchronized (this) {
            if (this.f4522s == null) {
                this.f4522s = new s(this);
            }
            sVar = this.f4522s;
        }
        return sVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public u workSpecDao() {
        v vVar;
        if (this.f4517n != null) {
            return this.f4517n;
        }
        synchronized (this) {
            if (this.f4517n == null) {
                this.f4517n = new v(this);
            }
            vVar = this.f4517n;
        }
        return vVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public y workTagDao() {
        z zVar;
        if (this.f4519p != null) {
            return this.f4519p;
        }
        synchronized (this) {
            if (this.f4519p == null) {
                this.f4519p = new z(this);
            }
            zVar = this.f4519p;
        }
        return zVar;
    }

    public class a extends p.b {
        public a() {
            super(16);
        }

        @Override // g2.p.b
        public void createAllTables(k2.e eVar) throws SQLException {
            eVar.execSQL("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            eVar.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
            eVar.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
            eVar.execSQL("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `last_enqueue_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `period_count` INTEGER NOT NULL DEFAULT 0, `generation` INTEGER NOT NULL DEFAULT 0, `required_network_type` INTEGER NOT NULL, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB NOT NULL, PRIMARY KEY(`id`))");
            eVar.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
            eVar.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_last_enqueue_time` ON `WorkSpec` (`last_enqueue_time`)");
            eVar.execSQL("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            eVar.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
            eVar.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `generation` INTEGER NOT NULL DEFAULT 0, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`, `generation`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            eVar.execSQL("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            eVar.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
            eVar.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            eVar.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            eVar.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            eVar.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5181942b9ebc31ce68dacb56c16fd79f')");
        }

        @Override // g2.p.b
        public void dropAllTables(k2.e eVar) throws SQLException {
            eVar.execSQL("DROP TABLE IF EXISTS `Dependency`");
            eVar.execSQL("DROP TABLE IF EXISTS `WorkSpec`");
            eVar.execSQL("DROP TABLE IF EXISTS `WorkTag`");
            eVar.execSQL("DROP TABLE IF EXISTS `SystemIdInfo`");
            eVar.execSQL("DROP TABLE IF EXISTS `WorkName`");
            eVar.execSQL("DROP TABLE IF EXISTS `WorkProgress`");
            eVar.execSQL("DROP TABLE IF EXISTS `Preference`");
            int i10 = WorkDatabase_Impl.f4516u;
            WorkDatabase_Impl workDatabase_Impl = WorkDatabase_Impl.this;
            List<? extends RoomDatabase.b> list = workDatabase_Impl.f4277f;
            if (list != null) {
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    workDatabase_Impl.f4277f.get(i11).onDestructiveMigration(eVar);
                }
            }
        }

        @Override // g2.p.b
        public void onCreate(k2.e eVar) {
            int i10 = WorkDatabase_Impl.f4516u;
            WorkDatabase_Impl workDatabase_Impl = WorkDatabase_Impl.this;
            List<? extends RoomDatabase.b> list = workDatabase_Impl.f4277f;
            if (list != null) {
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    workDatabase_Impl.f4277f.get(i11).onCreate(eVar);
                }
            }
        }

        @Override // g2.p.b
        public void onOpen(k2.e eVar) throws SQLException {
            WorkDatabase_Impl workDatabase_Impl = WorkDatabase_Impl.this;
            int i10 = WorkDatabase_Impl.f4516u;
            workDatabase_Impl.f4272a = eVar;
            eVar.execSQL("PRAGMA foreign_keys = ON");
            WorkDatabase_Impl.this.internalInitInvalidationTracker(eVar);
            List<? extends RoomDatabase.b> list = WorkDatabase_Impl.this.f4277f;
            if (list != null) {
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    WorkDatabase_Impl.this.f4277f.get(i11).onOpen(eVar);
                }
            }
        }

        @Override // g2.p.b
        public void onPreMigrate(k2.e eVar) throws IllegalAccessException, IOException, SQLException, IllegalArgumentException, InvocationTargetException {
            i2.b.dropFtsSyncTriggers(eVar);
        }

        @Override // g2.p.b
        public p.c onValidateSchema(k2.e eVar) {
            HashMap map = new HashMap(2);
            map.put("work_spec_id", new d.a("work_spec_id", "TEXT", true, 1, null, 1));
            map.put("prerequisite_id", new d.a("prerequisite_id", "TEXT", true, 2, null, 1));
            HashSet hashSet = new HashSet(2);
            hashSet.add(new d.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            hashSet.add(new d.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
            HashSet hashSet2 = new HashSet(2);
            hashSet2.add(new d.e("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
            hashSet2.add(new d.e("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id"), Arrays.asList("ASC")));
            d dVar = new d("Dependency", map, hashSet, hashSet2);
            d dVar2 = d.read(eVar, "Dependency");
            if (!dVar.equals(dVar2)) {
                return new p.c(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + dVar + "\n Found:\n" + dVar2);
            }
            HashMap map2 = new HashMap(27);
            map2.put("id", new d.a("id", "TEXT", true, 1, null, 1));
            map2.put(AdOperationMetric.INIT_STATE, new d.a(AdOperationMetric.INIT_STATE, "INTEGER", true, 0, null, 1));
            map2.put("worker_class_name", new d.a("worker_class_name", "TEXT", true, 0, null, 1));
            map2.put("input_merger_class_name", new d.a("input_merger_class_name", "TEXT", false, 0, null, 1));
            map2.put("input", new d.a("input", "BLOB", true, 0, null, 1));
            map2.put("output", new d.a("output", "BLOB", true, 0, null, 1));
            map2.put("initial_delay", new d.a("initial_delay", "INTEGER", true, 0, null, 1));
            map2.put("interval_duration", new d.a("interval_duration", "INTEGER", true, 0, null, 1));
            map2.put("flex_duration", new d.a("flex_duration", "INTEGER", true, 0, null, 1));
            map2.put("run_attempt_count", new d.a("run_attempt_count", "INTEGER", true, 0, null, 1));
            map2.put("backoff_policy", new d.a("backoff_policy", "INTEGER", true, 0, null, 1));
            map2.put("backoff_delay_duration", new d.a("backoff_delay_duration", "INTEGER", true, 0, null, 1));
            map2.put("last_enqueue_time", new d.a("last_enqueue_time", "INTEGER", true, 0, null, 1));
            map2.put("minimum_retention_duration", new d.a("minimum_retention_duration", "INTEGER", true, 0, null, 1));
            map2.put("schedule_requested_at", new d.a("schedule_requested_at", "INTEGER", true, 0, null, 1));
            map2.put("run_in_foreground", new d.a("run_in_foreground", "INTEGER", true, 0, null, 1));
            map2.put("out_of_quota_policy", new d.a("out_of_quota_policy", "INTEGER", true, 0, null, 1));
            map2.put("period_count", new d.a("period_count", "INTEGER", true, 0, "0", 1));
            map2.put("generation", new d.a("generation", "INTEGER", true, 0, "0", 1));
            map2.put("required_network_type", new d.a("required_network_type", "INTEGER", true, 0, null, 1));
            map2.put("requires_charging", new d.a("requires_charging", "INTEGER", true, 0, null, 1));
            map2.put("requires_device_idle", new d.a("requires_device_idle", "INTEGER", true, 0, null, 1));
            map2.put("requires_battery_not_low", new d.a("requires_battery_not_low", "INTEGER", true, 0, null, 1));
            map2.put("requires_storage_not_low", new d.a("requires_storage_not_low", "INTEGER", true, 0, null, 1));
            map2.put("trigger_content_update_delay", new d.a("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
            map2.put("trigger_max_content_delay", new d.a("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
            map2.put("content_uri_triggers", new d.a("content_uri_triggers", "BLOB", true, 0, null, 1));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(2);
            hashSet4.add(new d.e("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at"), Arrays.asList("ASC")));
            hashSet4.add(new d.e("index_WorkSpec_last_enqueue_time", false, Arrays.asList("last_enqueue_time"), Arrays.asList("ASC")));
            d dVar3 = new d("WorkSpec", map2, hashSet3, hashSet4);
            d dVar4 = d.read(eVar, "WorkSpec");
            if (!dVar3.equals(dVar4)) {
                return new p.c(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + dVar3 + "\n Found:\n" + dVar4);
            }
            HashMap map3 = new HashMap(2);
            map3.put("tag", new d.a("tag", "TEXT", true, 1, null, 1));
            map3.put("work_spec_id", new d.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet5 = new HashSet(1);
            hashSet5.add(new d.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            HashSet hashSet6 = new HashSet(1);
            hashSet6.add(new d.e("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
            d dVar5 = new d("WorkTag", map3, hashSet5, hashSet6);
            d dVar6 = d.read(eVar, "WorkTag");
            if (!dVar5.equals(dVar6)) {
                return new p.c(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + dVar5 + "\n Found:\n" + dVar6);
            }
            HashMap map4 = new HashMap(3);
            map4.put("work_spec_id", new d.a("work_spec_id", "TEXT", true, 1, null, 1));
            map4.put("generation", new d.a("generation", "INTEGER", true, 2, "0", 1));
            map4.put("system_id", new d.a("system_id", "INTEGER", true, 0, null, 1));
            HashSet hashSet7 = new HashSet(1);
            hashSet7.add(new d.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            d dVar7 = new d("SystemIdInfo", map4, hashSet7, new HashSet(0));
            d dVar8 = d.read(eVar, "SystemIdInfo");
            if (!dVar7.equals(dVar8)) {
                return new p.c(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + dVar7 + "\n Found:\n" + dVar8);
            }
            HashMap map5 = new HashMap(2);
            map5.put(MediationMetaData.KEY_NAME, new d.a(MediationMetaData.KEY_NAME, "TEXT", true, 1, null, 1));
            map5.put("work_spec_id", new d.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet8 = new HashSet(1);
            hashSet8.add(new d.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            HashSet hashSet9 = new HashSet(1);
            hashSet9.add(new d.e("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
            d dVar9 = new d("WorkName", map5, hashSet8, hashSet9);
            d dVar10 = d.read(eVar, "WorkName");
            if (!dVar9.equals(dVar10)) {
                return new p.c(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + dVar9 + "\n Found:\n" + dVar10);
            }
            HashMap map6 = new HashMap(2);
            map6.put("work_spec_id", new d.a("work_spec_id", "TEXT", true, 1, null, 1));
            map6.put("progress", new d.a("progress", "BLOB", true, 0, null, 1));
            HashSet hashSet10 = new HashSet(1);
            hashSet10.add(new d.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            d dVar11 = new d("WorkProgress", map6, hashSet10, new HashSet(0));
            d dVar12 = d.read(eVar, "WorkProgress");
            if (!dVar11.equals(dVar12)) {
                return new p.c(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + dVar11 + "\n Found:\n" + dVar12);
            }
            HashMap map7 = new HashMap(2);
            map7.put("key", new d.a("key", "TEXT", true, 1, null, 1));
            map7.put("long_value", new d.a("long_value", "INTEGER", false, 0, null, 1));
            d dVar13 = new d("Preference", map7, new HashSet(0), new HashSet(0));
            d dVar14 = d.read(eVar, "Preference");
            if (dVar13.equals(dVar14)) {
                return new p.c(true, null);
            }
            return new p.c(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + dVar13 + "\n Found:\n" + dVar14);
        }

        @Override // g2.p.b
        public void onPostMigrate(k2.e eVar) {
        }
    }
}
