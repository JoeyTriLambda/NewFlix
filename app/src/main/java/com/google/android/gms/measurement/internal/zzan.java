package com.google.android.gms.measurement.internal;

import ac.c;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import b0.b;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfh;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zznw;
import com.google.android.gms.internal.measurement.zzoh;
import com.google.android.gms.internal.measurement.zzon;
import com.google.android.gms.internal.measurement.zzoo;
import com.google.android.gms.internal.measurement.zzpy;
import com.google.android.gms.internal.measurement.zzqv;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzan extends zzmy {

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f7658f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f7659g = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f7660h = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;"};

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f7661i = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f7662j = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f7663k = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* renamed from: l, reason: collision with root package name */
    public static final String[] f7664l = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f7665m = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* renamed from: n, reason: collision with root package name */
    public static final String[] f7666n = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;"};

    /* renamed from: o, reason: collision with root package name */
    public static final String[] f7667o = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    /* renamed from: d, reason: collision with root package name */
    public final zzat f7668d;

    /* renamed from: e, reason: collision with root package name */
    public final zzms f7669e;

    public zzan(zznd zzndVar) {
        super(zzndVar);
        this.f7669e = new zzms(zzb());
        this.f7668d = new zzat(this, zza());
    }

    public static void f(ContentValues contentValues, Object obj) {
        Preconditions.checkNotEmpty("value");
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put("value", (Double) obj);
        }
    }

    public final SQLiteDatabase a() {
        zzt();
        try {
            return this.f7668d.getWritableDatabase();
        } catch (SQLiteException e10) {
            zzj().zzu().zza("Error opening database", e10);
            throw e10;
        }
    }

    public final long b(String str, String[] strArr, long j10) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = a().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return j10;
                }
                long j11 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j11;
            } catch (SQLiteException e10) {
                zzj().zzg().zza("Database error", str, e10);
                throw e10;
            }
        } catch (Throwable th2) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th2;
        }
    }

    public final long b_() {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = a().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return -1L;
                }
                long j10 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j10;
            } catch (SQLiteException e10) {
                zzj().zzg().zza("Error querying raw events", e10);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return -1L;
            }
        } catch (Throwable th2) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th2;
        }
    }

    public final Object c(Cursor cursor, int i10) throws IllegalStateException {
        int type = cursor.getType(i10);
        if (type == 0) {
            zzj().zzg().zza("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i10));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i10));
        }
        if (type == 3) {
            return cursor.getString(i10);
        }
        if (type != 4) {
            zzj().zzg().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        zzj().zzg().zza("Loaded invalid blob type value, ignoring it");
        return null;
    }

    public final long c_() {
        return b("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    public final String d(String str, String str2, String[] strArr) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = a().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return str2;
                }
                String string = cursorRawQuery.getString(0);
                cursorRawQuery.close();
                return string;
            } catch (SQLiteException e10) {
                zzj().zzg().zza("Database error", str, e10);
                throw e10;
            }
        } catch (Throwable th2) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th2;
        }
    }

    public final long d_() {
        return b("select max(timestamp) from raw_events", null, 0L);
    }

    public final void e(ContentValues contentValues) throws IllegalStateException {
        try {
            SQLiteDatabase sQLiteDatabaseA = a();
            if (contentValues.getAsString("app_id") == null) {
                zzj().zzh().zza("Value of the primary key is not set.", zzgb.zza("app_id"));
            } else if (sQLiteDatabaseA.update("consent_settings", contentValues, "app_id = ?", new String[]{r3}) == 0 && sQLiteDatabaseA.insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update table (got -1). key", zzgb.zza("consent_settings"), zzgb.zza("app_id"));
            }
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing into table. key", zzgb.zza("consent_settings"), zzgb.zza("app_id"), e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String f_() throws java.lang.Throwable {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.a()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L20 android.database.sqlite.SQLiteException -> L25
            boolean r2 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L1e java.lang.Throwable -> L3a
            if (r2 == 0) goto L1a
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L1e java.lang.Throwable -> L3a
            r0.close()
            return r1
        L1a:
            r0.close()
            return r1
        L1e:
            r2 = move-exception
            goto L27
        L20:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3b
        L25:
            r2 = move-exception
            r0 = r1
        L27:
            com.google.android.gms.measurement.internal.zzgb r3 = r6.zzj()     // Catch: java.lang.Throwable -> L3a
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzg()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zza(r4, r2)     // Catch: java.lang.Throwable -> L3a
            if (r0 == 0) goto L39
            r0.close()
        L39:
            return r1
        L3a:
            r1 = move-exception
        L3b:
            if (r0 == 0) goto L40
            r0.close()
        L40:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.f_():java.lang.String");
    }

    public final void g(List<Long> list) throws IllegalStateException, SQLException {
        zzt();
        zzak();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zza().getDatabasePath("google_app_measurement.db").exists()) {
            String strK = c.k("(", TextUtils.join(",", list), ")");
            if (j(c.k("SELECT COUNT(1) FROM queue WHERE rowid IN ", strK, " AND retry_count =  2147483647 LIMIT 1"), null) > 0) {
                zzj().zzu().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                a().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + strK + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e10) {
                zzj().zzg().zza("Error incrementing retry count. error", e10);
            }
        }
    }

    public final boolean h(String str, int i10, zzfh.zzb zzbVar) throws IllegalStateException {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbVar);
        if (zzbVar.zzf().isEmpty()) {
            zzj().zzu().zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzgb.zza(str), Integer.valueOf(i10), String.valueOf(zzbVar.zzl() ? Integer.valueOf(zzbVar.zzb()) : null));
            return false;
        }
        byte[] bArrZzbv = zzbVar.zzbv();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i10));
        contentValues.put("filter_id", zzbVar.zzl() ? Integer.valueOf(zzbVar.zzb()) : null);
        contentValues.put("event_name", zzbVar.zzf());
        contentValues.put("session_scoped", zzbVar.zzm() ? Boolean.valueOf(zzbVar.zzj()) : null);
        contentValues.put(JsonStorageKeyNames.DATA_KEY, bArrZzbv);
        try {
            if (a().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert event filter (got -1). appId", zzgb.zza(str));
            return true;
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing event filter. appId", zzgb.zza(str), e10);
            return false;
        }
    }

    public final boolean i(String str, int i10, zzfh.zze zzeVar) throws IllegalStateException {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeVar);
        if (zzeVar.zze().isEmpty()) {
            zzj().zzu().zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzgb.zza(str), Integer.valueOf(i10), String.valueOf(zzeVar.zzi() ? Integer.valueOf(zzeVar.zza()) : null));
            return false;
        }
        byte[] bArrZzbv = zzeVar.zzbv();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i10));
        contentValues.put("filter_id", zzeVar.zzi() ? Integer.valueOf(zzeVar.zza()) : null);
        contentValues.put("property_name", zzeVar.zze());
        contentValues.put("session_scoped", zzeVar.zzj() ? Boolean.valueOf(zzeVar.zzh()) : null);
        contentValues.put(JsonStorageKeyNames.DATA_KEY, bArrZzbv);
        try {
            if (a().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert property filter (got -1). appId", zzgb.zza(str));
            return false;
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing property filter. appId", zzgb.zza(str), e10);
            return false;
        }
    }

    public final long j(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = a().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j10 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j10;
            } catch (SQLiteException e10) {
                zzj().zzg().zza("Database error", str, e10);
                throw e10;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final void k(String str, ArrayList arrayList) throws IllegalStateException {
        Preconditions.checkNotEmpty(str);
        zzak();
        zzt();
        SQLiteDatabase sQLiteDatabaseA = a();
        try {
            long j10 = j("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int iMax = Math.max(0, Math.min(2000, zze().zzb(str, zzbh.G)));
            if (j10 <= iMax) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                Integer num = (Integer) arrayList.get(i10);
                if (num == null) {
                    return;
                }
                arrayList2.add(Integer.toString(num.intValue()));
            }
            sQLiteDatabaseA.delete("audience_filter_values", c.k("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ", c.k("(", TextUtils.join(",", arrayList2), ")"), " order by rowid desc limit -1 offset ?)"), new String[]{str, Integer.toString(iMax)});
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Database error querying filters. appId", zzgb.zza(str), e10);
        }
    }

    public final Map<Integer, List<zzfh.zzb>> l(String str, String str2) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        b bVar = new b();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = a().query("event_filters", new String[]{"audience_id", JsonStorageKeyNames.DATA_KEY}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<zzfh.zzb>> mapEmptyMap = Collections.emptyMap();
                    cursorQuery.close();
                    return mapEmptyMap;
                }
                do {
                    try {
                        zzfh.zzb zzbVar = (zzfh.zzb) ((com.google.android.gms.internal.measurement.zzjt) ((zzfh.zzb.zza) zznm.g(zzfh.zzb.zzc(), cursorQuery.getBlob(1))).zzah());
                        int i10 = cursorQuery.getInt(0);
                        List arrayList = (List) bVar.get(Integer.valueOf(i10));
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            bVar.put(Integer.valueOf(i10), arrayList);
                        }
                        arrayList.add(zzbVar);
                    } catch (IOException e10) {
                        zzj().zzg().zza("Failed to merge filter. appId", zzgb.zza(str), e10);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return bVar;
            } catch (SQLiteException e11) {
                zzj().zzg().zza("Database error querying filters. appId", zzgb.zza(str), e11);
                Map<Integer, List<zzfh.zzb>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final Map<Integer, List<zzfh.zze>> m(String str, String str2) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        b bVar = new b();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = a().query("property_filters", new String[]{"audience_id", JsonStorageKeyNames.DATA_KEY}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<zzfh.zze>> mapEmptyMap = Collections.emptyMap();
                    cursorQuery.close();
                    return mapEmptyMap;
                }
                do {
                    try {
                        zzfh.zze zzeVar = (zzfh.zze) ((com.google.android.gms.internal.measurement.zzjt) ((zzfh.zze.zza) zznm.g(zzfh.zze.zzc(), cursorQuery.getBlob(1))).zzah());
                        int i10 = cursorQuery.getInt(0);
                        List arrayList = (List) bVar.get(Integer.valueOf(i10));
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            bVar.put(Integer.valueOf(i10), arrayList);
                        }
                        arrayList.add(zzeVar);
                    } catch (IOException e10) {
                        zzj().zzg().zza("Failed to merge filter", zzgb.zza(str), e10);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return bVar;
            } catch (SQLiteException e11) {
                zzj().zzg().zza("Database error querying filters. appId", zzgb.zza(str), e11);
                Map<Integer, List<zzfh.zze>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final int zza(String str, String str2) throws IllegalStateException {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzak();
        try {
            return a().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error deleting conditional property", zzgb.zza(str), zzi().zzc(str2), e10);
            return 0;
        }
    }

    public final long zzb(String str, String str2) throws Throwable {
        long jB;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzak();
        SQLiteDatabase sQLiteDatabaseA = a();
        sQLiteDatabaseA.beginTransaction();
        long j10 = 0;
        try {
        } catch (SQLiteException e10) {
            e = e10;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            try {
                jB = b("select " + str2 + " from app2 where app_id=?", new String[]{str}, -1L);
                if (jB == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (sQLiteDatabaseA.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        zzj().zzg().zza("Failed to insert column (got -1). appId", zzgb.zza(str), str2);
                        sQLiteDatabaseA.endTransaction();
                        return -1L;
                    }
                    jB = 0;
                }
            } catch (SQLiteException e11) {
                e = e11;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put(str2, Long.valueOf(1 + jB));
                if (sQLiteDatabaseA.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                    zzj().zzg().zza("Failed to update column (got 0). appId", zzgb.zza(str), str2);
                    sQLiteDatabaseA.endTransaction();
                    return -1L;
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                sQLiteDatabaseA.endTransaction();
                return jB;
            } catch (SQLiteException e12) {
                e = e12;
                j10 = jB;
                zzj().zzg().zza("Error inserting column. appId", zzgb.zza(str), str2, e);
                sQLiteDatabaseA.endTransaction();
                return j10;
            }
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabaseA.endTransaction();
            throw th;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzmy
    public final boolean zzc() {
        return false;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0083: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:29:0x0083 */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle zzd(java.lang.String r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r5.zzt()
            r5.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.a()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r4 = 0
            r3[r4] = r6     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L53 java.lang.Throwable -> L82
            if (r2 != 0) goto L2e
            com.google.android.gms.measurement.internal.zzgb r6 = r5.zzj()     // Catch: android.database.sqlite.SQLiteException -> L53 java.lang.Throwable -> L82
            com.google.android.gms.measurement.internal.zzgd r6 = r6.zzp()     // Catch: android.database.sqlite.SQLiteException -> L53 java.lang.Throwable -> L82
            java.lang.String r2 = "Default event parameters not found"
            r6.zza(r2)     // Catch: android.database.sqlite.SQLiteException -> L53 java.lang.Throwable -> L82
            r1.close()
            return r0
        L2e:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L53 java.lang.Throwable -> L82
            com.google.android.gms.internal.measurement.zzft$zze$zza r3 = com.google.android.gms.internal.measurement.zzft.zze.zze()     // Catch: android.database.sqlite.SQLiteException -> L53 java.io.IOException -> L55 java.lang.Throwable -> L82
            com.google.android.gms.internal.measurement.zzlf r2 = com.google.android.gms.measurement.internal.zznm.g(r3, r2)     // Catch: android.database.sqlite.SQLiteException -> L53 java.io.IOException -> L55 java.lang.Throwable -> L82
            com.google.android.gms.internal.measurement.zzft$zze$zza r2 = (com.google.android.gms.internal.measurement.zzft.zze.zza) r2     // Catch: android.database.sqlite.SQLiteException -> L53 java.io.IOException -> L55 java.lang.Throwable -> L82
            com.google.android.gms.internal.measurement.zzlg r2 = r2.zzah()     // Catch: android.database.sqlite.SQLiteException -> L53 java.io.IOException -> L55 java.lang.Throwable -> L82
            com.google.android.gms.internal.measurement.zzjt r2 = (com.google.android.gms.internal.measurement.zzjt) r2     // Catch: android.database.sqlite.SQLiteException -> L53 java.io.IOException -> L55 java.lang.Throwable -> L82
            com.google.android.gms.internal.measurement.zzft$zze r2 = (com.google.android.gms.internal.measurement.zzft.zze) r2     // Catch: android.database.sqlite.SQLiteException -> L53 java.io.IOException -> L55 java.lang.Throwable -> L82
            r5.g_()     // Catch: android.database.sqlite.SQLiteException -> L53 java.lang.Throwable -> L82
            java.util.List r6 = r2.zzh()     // Catch: android.database.sqlite.SQLiteException -> L53 java.lang.Throwable -> L82
            android.os.Bundle r6 = com.google.android.gms.measurement.internal.zznm.zza(r6)     // Catch: android.database.sqlite.SQLiteException -> L53 java.lang.Throwable -> L82
            r1.close()
            return r6
        L53:
            r6 = move-exception
            goto L6f
        L55:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzgb r3 = r5.zzj()     // Catch: android.database.sqlite.SQLiteException -> L53 java.lang.Throwable -> L82
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzg()     // Catch: android.database.sqlite.SQLiteException -> L53 java.lang.Throwable -> L82
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzgb.zza(r6)     // Catch: android.database.sqlite.SQLiteException -> L53 java.lang.Throwable -> L82
            r3.zza(r4, r6, r2)     // Catch: android.database.sqlite.SQLiteException -> L53 java.lang.Throwable -> L82
            r1.close()
            return r0
        L6b:
            r6 = move-exception
            goto L84
        L6d:
            r6 = move-exception
            r1 = r0
        L6f:
            com.google.android.gms.measurement.internal.zzgb r2 = r5.zzj()     // Catch: java.lang.Throwable -> L82
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzg()     // Catch: java.lang.Throwable -> L82
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zza(r3, r6)     // Catch: java.lang.Throwable -> L82
            if (r1 == 0) goto L81
            r1.close()
        L81:
            return r0
        L82:
            r6 = move-exception
            r0 = r1
        L84:
            if (r0 == 0) goto L89
            r0.close()
        L89:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zzd(java.lang.String):android.os.Bundle");
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0332  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzf zze(java.lang.String r47) {
        /*
            Method dump skipped, instructions count: 822
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zze(java.lang.String):com.google.android.gms.measurement.internal.zzf");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0084: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:133), block:B:28:0x0084 */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzap zzf(java.lang.String r12) throws java.lang.Throwable {
        /*
            r11 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r11.zzt()
            r11.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r11.a()     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            java.lang.String r2 = "apps"
            java.lang.String r3 = "remote_config"
            java.lang.String r4 = "config_last_modified_time"
            java.lang.String r5 = "e_tag"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5}     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            java.lang.String r4 = "app_id=?"
            r9 = 1
            java.lang.String[] r5 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            r10 = 0
            r5[r10] = r12     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L66 java.lang.Throwable -> L83
            if (r2 != 0) goto L33
            r1.close()
            return r0
        L33:
            byte[] r2 = r1.getBlob(r10)     // Catch: android.database.sqlite.SQLiteException -> L66 java.lang.Throwable -> L83
            java.lang.String r3 = r1.getString(r9)     // Catch: android.database.sqlite.SQLiteException -> L66 java.lang.Throwable -> L83
            r4 = 2
            java.lang.String r4 = r1.getString(r4)     // Catch: android.database.sqlite.SQLiteException -> L66 java.lang.Throwable -> L83
            boolean r5 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L66 java.lang.Throwable -> L83
            if (r5 == 0) goto L57
            com.google.android.gms.measurement.internal.zzgb r5 = r11.zzj()     // Catch: android.database.sqlite.SQLiteException -> L66 java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzgd r5 = r5.zzg()     // Catch: android.database.sqlite.SQLiteException -> L66 java.lang.Throwable -> L83
            java.lang.String r6 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzgb.zza(r12)     // Catch: android.database.sqlite.SQLiteException -> L66 java.lang.Throwable -> L83
            r5.zza(r6, r7)     // Catch: android.database.sqlite.SQLiteException -> L66 java.lang.Throwable -> L83
        L57:
            if (r2 != 0) goto L5d
            r1.close()
            return r0
        L5d:
            com.google.android.gms.measurement.internal.zzap r5 = new com.google.android.gms.measurement.internal.zzap     // Catch: android.database.sqlite.SQLiteException -> L66 java.lang.Throwable -> L83
            r5.<init>(r2, r3, r4)     // Catch: android.database.sqlite.SQLiteException -> L66 java.lang.Throwable -> L83
            r1.close()
            return r5
        L66:
            r2 = move-exception
            goto L6c
        L68:
            r12 = move-exception
            goto L85
        L6a:
            r2 = move-exception
            r1 = r0
        L6c:
            com.google.android.gms.measurement.internal.zzgb r3 = r11.zzj()     // Catch: java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzg()     // Catch: java.lang.Throwable -> L83
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzgb.zza(r12)     // Catch: java.lang.Throwable -> L83
            r3.zza(r4, r12, r2)     // Catch: java.lang.Throwable -> L83
            if (r1 == 0) goto L82
            r1.close()
        L82:
            return r0
        L83:
            r12 = move-exception
            r0 = r1
        L85:
            if (r0 == 0) goto L8a
            r0.close()
        L8a:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zzf(java.lang.String):com.google.android.gms.measurement.internal.zzap");
    }

    public final zzax zzg(String str) {
        if (!zzon.zza() || !zze().zza(zzbh.M0)) {
            return zzax.f7687f;
        }
        Preconditions.checkNotNull(str);
        zzt();
        zzak();
        return zzax.zza(d("select dma_consent_settings from consent_settings where app_id=? limit 1;", "", new String[]{str}));
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zziq zzh(java.lang.String r5) {
        /*
            r4 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            r4.zzt()
            r4.zzak()
            boolean r0 = com.google.android.gms.internal.measurement.zzon.zza()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L76
            com.google.android.gms.measurement.internal.zzae r0 = r4.zze()
            com.google.android.gms.measurement.internal.zzfo<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbh.M0
            boolean r0 = r0.zza(r3)
            if (r0 == 0) goto L76
            java.lang.String r0 = "select consent_state, consent_source from consent_settings where app_id=? limit 1;"
            java.lang.String[] r2 = new java.lang.String[r2]
            r2[r1] = r5
            com.google.android.gms.measurement.internal.zzam r5 = new com.google.android.gms.measurement.internal.zzaq() { // from class: com.google.android.gms.measurement.internal.zzam
                static {
                    /*
                        com.google.android.gms.measurement.internal.zzam r0 = new com.google.android.gms.measurement.internal.zzam
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.google.android.gms.measurement.internal.zzam) com.google.android.gms.measurement.internal.zzam.a com.google.android.gms.measurement.internal.zzam
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.<init>():void");
                }

                @Override // com.google.android.gms.measurement.internal.zzaq
                public final java.lang.Object zza(android.database.Cursor r3) {
                    /*
                        r2 = this;
                        r0 = 0
                        java.lang.String r0 = r3.getString(r0)
                        r1 = 1
                        int r3 = r3.getInt(r1)
                        com.google.android.gms.measurement.internal.zziq r3 = com.google.android.gms.measurement.internal.zziq.zza(r0, r3)
                        return r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zza(android.database.Cursor):java.lang.Object");
                }
            }
            r1 = 0
            android.database.sqlite.SQLiteDatabase r3 = r4.a()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L54
            android.database.Cursor r0 = r3.rawQuery(r0, r2)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteException -> L54
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L4d android.database.sqlite.SQLiteException -> L50
            if (r2 != 0) goto L45
            com.google.android.gms.measurement.internal.zzgb r5 = r4.zzj()     // Catch: java.lang.Throwable -> L4d android.database.sqlite.SQLiteException -> L50
            com.google.android.gms.measurement.internal.zzgd r5 = r5.zzp()     // Catch: java.lang.Throwable -> L4d android.database.sqlite.SQLiteException -> L50
            java.lang.String r2 = "No data found"
            r5.zza(r2)     // Catch: java.lang.Throwable -> L4d android.database.sqlite.SQLiteException -> L50
            r0.close()
            goto L68
        L45:
            java.lang.Object r1 = r5.zza(r0)     // Catch: java.lang.Throwable -> L4d android.database.sqlite.SQLiteException -> L50
            r0.close()
            goto L68
        L4d:
            r5 = move-exception
            r1 = r0
            goto L70
        L50:
            r5 = move-exception
            goto L56
        L52:
            r5 = move-exception
            goto L70
        L54:
            r5 = move-exception
            r0 = r1
        L56:
            com.google.android.gms.measurement.internal.zzgb r2 = r4.zzj()     // Catch: java.lang.Throwable -> L4d
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzg()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r3 = "Error querying database."
            r2.zza(r3, r5)     // Catch: java.lang.Throwable -> L4d
            if (r0 == 0) goto L68
            r0.close()
        L68:
            com.google.android.gms.measurement.internal.zziq r1 = (com.google.android.gms.measurement.internal.zziq) r1
            if (r1 != 0) goto L6f
            com.google.android.gms.measurement.internal.zziq r5 = com.google.android.gms.measurement.internal.zziq.f8195c
            return r5
        L6f:
            return r1
        L70:
            if (r1 == 0) goto L75
            r1.close()
        L75:
            throw r5
        L76:
            java.lang.String[] r0 = new java.lang.String[r2]
            r0[r1] = r5
            java.lang.String r5 = "G1"
            java.lang.String r1 = "select consent_state from consent_settings where app_id=? limit 1;"
            java.lang.String r5 = r4.d(r1, r5, r0)
            com.google.android.gms.measurement.internal.zziq r5 = com.google.android.gms.measurement.internal.zziq.zzb(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zzh(java.lang.String):com.google.android.gms.measurement.internal.zziq");
    }

    public final List<zzmv> zzi(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = a().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str}, null, null, "rowid", null);
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                do {
                    String string = cursorQuery.getString(0);
                    if (string == null) {
                        string = "";
                    }
                    arrayList.add(new zzmv(cursorQuery.getInt(2), string, cursorQuery.getLong(1)));
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e10) {
                zzj().zzg().zza("Error querying trigger uris. appId", zzgb.zza(str), e10);
                List<zzmv> listEmptyList = Collections.emptyList();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return listEmptyList;
            }
        } catch (Throwable th2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    public final List<zznq> zzj(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = a().query("user_attributes", new String[]{MediationMetaData.KEY_NAME, "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                do {
                    String string = cursorQuery.getString(0);
                    String string2 = cursorQuery.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j10 = cursorQuery.getLong(2);
                    Object objC = c(cursorQuery, 3);
                    if (objC == null) {
                        zzj().zzg().zza("Read invalid user property value, ignoring it. appId", zzgb.zza(str));
                    } else {
                        arrayList.add(new zznq(str, str2, string, j10, objC));
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e10) {
                zzj().zzg().zza("Error querying user properties. appId", zzgb.zza(str), e10);
                List<zznq> listEmptyList = Collections.emptyList();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return listEmptyList;
            }
        } catch (Throwable th2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    public final void zzp() {
        zzak();
        a().beginTransaction();
    }

    public final void zzu() {
        zzak();
        a().endTransaction();
    }

    public final void zzv() {
        int iDelete;
        zzt();
        zzak();
        if (zza().getDatabasePath("google_app_measurement.db").exists()) {
            long jZza = zzn().f8477e.zza();
            long jElapsedRealtime = zzb().elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jZza) > zzbh.f7777z.zza(null).longValue()) {
                zzn().f8477e.zza(jElapsedRealtime);
                zzt();
                zzak();
                if (!zza().getDatabasePath("google_app_measurement.db").exists() || (iDelete = a().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzb().currentTimeMillis()), String.valueOf(zzae.zzm())})) <= 0) {
                    return;
                }
                zzj().zzp().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
            }
        }
    }

    public final void zzw() {
        zzak();
        a().setTransactionSuccessful();
    }

    public final boolean zzx() {
        return j("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean zzy() {
        return j("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    public final boolean zzz() {
        return j("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        return b("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzac zzc(java.lang.String r30, java.lang.String r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zzc(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzac");
    }

    public final long zza(String str) throws IllegalStateException {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        try {
            return a().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zze().zzb(str, zzbh.f7759q))))});
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error deleting over the limit events. appId", zzgb.zza(str), e10);
            return 0L;
        }
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0147: MOVE (r18 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:64:0x0147 */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzbb zzd(java.lang.String r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zzd(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzbb");
    }

    public final void zzh(String str, String str2) throws IllegalStateException {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzak();
        try {
            a().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error deleting user property. appId", zzgb.zza(str), zzi().zzc(str2), e10);
        }
    }

    public final long zza(zzft.zzj zzjVar) throws IllegalStateException, IOException {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzjVar);
        Preconditions.checkNotEmpty(zzjVar.zzx());
        byte[] bArrZzbv = zzjVar.zzbv();
        long jB = g_().b(bArrZzbv);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzjVar.zzx());
        contentValues.put("metadata_fingerprint", Long.valueOf(jB));
        contentValues.put("metadata", bArrZzbv);
        try {
            a().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return jB;
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing raw event metadata. appId", zzgb.zza(zzjVar.zzx()), e10);
            throw e10;
        }
    }

    public final long zzb(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        return b("select first_open_count from app2 where app_id=?", new String[]{str}, -1L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0097, code lost:
    
        zzj().zzg().zza("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zznq> zzb(java.lang.String r23, java.lang.String r24, java.lang.String r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zzb(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x008b: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:29:0x008b */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzft.zze, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) throws java.lang.Throwable {
        /*
            r7 = this;
            r7.zzt()
            r7.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.a()     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            r6 = 1
            r3[r6] = r5     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L5b java.lang.Throwable -> L8a
            if (r2 != 0) goto L35
            com.google.android.gms.measurement.internal.zzgb r8 = r7.zzj()     // Catch: android.database.sqlite.SQLiteException -> L5b java.lang.Throwable -> L8a
            com.google.android.gms.measurement.internal.zzgd r8 = r8.zzp()     // Catch: android.database.sqlite.SQLiteException -> L5b java.lang.Throwable -> L8a
            java.lang.String r9 = "Main event not found"
            r8.zza(r9)     // Catch: android.database.sqlite.SQLiteException -> L5b java.lang.Throwable -> L8a
            r1.close()
            return r0
        L35:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L5b java.lang.Throwable -> L8a
            long r3 = r1.getLong(r6)     // Catch: android.database.sqlite.SQLiteException -> L5b java.lang.Throwable -> L8a
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L5b java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.zzft$zze$zza r4 = com.google.android.gms.internal.measurement.zzft.zze.zze()     // Catch: android.database.sqlite.SQLiteException -> L5b java.io.IOException -> L5d java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.zzlf r2 = com.google.android.gms.measurement.internal.zznm.g(r4, r2)     // Catch: android.database.sqlite.SQLiteException -> L5b java.io.IOException -> L5d java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.zzft$zze$zza r2 = (com.google.android.gms.internal.measurement.zzft.zze.zza) r2     // Catch: android.database.sqlite.SQLiteException -> L5b java.io.IOException -> L5d java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.zzlg r2 = r2.zzah()     // Catch: android.database.sqlite.SQLiteException -> L5b java.io.IOException -> L5d java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.zzjt r2 = (com.google.android.gms.internal.measurement.zzjt) r2     // Catch: android.database.sqlite.SQLiteException -> L5b java.io.IOException -> L5d java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.zzft$zze r2 = (com.google.android.gms.internal.measurement.zzft.zze) r2     // Catch: android.database.sqlite.SQLiteException -> L5b java.io.IOException -> L5d java.lang.Throwable -> L8a
            android.util.Pair r8 = android.util.Pair.create(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L5b java.lang.Throwable -> L8a
            r1.close()
            return r8
        L5b:
            r8 = move-exception
            goto L77
        L5d:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzgb r3 = r7.zzj()     // Catch: android.database.sqlite.SQLiteException -> L5b java.lang.Throwable -> L8a
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzg()     // Catch: android.database.sqlite.SQLiteException -> L5b java.lang.Throwable -> L8a
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgb.zza(r8)     // Catch: android.database.sqlite.SQLiteException -> L5b java.lang.Throwable -> L8a
            r3.zza(r4, r8, r9, r2)     // Catch: android.database.sqlite.SQLiteException -> L5b java.lang.Throwable -> L8a
            r1.close()
            return r0
        L73:
            r8 = move-exception
            goto L8c
        L75:
            r8 = move-exception
            r1 = r0
        L77:
            com.google.android.gms.measurement.internal.zzgb r9 = r7.zzj()     // Catch: java.lang.Throwable -> L8a
            com.google.android.gms.measurement.internal.zzgd r9 = r9.zzg()     // Catch: java.lang.Throwable -> L8a
            java.lang.String r2 = "Error selecting main event"
            r9.zza(r2, r8)     // Catch: java.lang.Throwable -> L8a
            if (r1 == 0) goto L89
            r1.close()
        L89:
            return r0
        L8a:
            r8 = move-exception
            r0 = r1
        L8c:
            if (r0 == 0) goto L91
            r0.close()
        L91:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    public final zzao zza(long j10, String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        return zza(j10, str, 1L, false, false, z12, false, z14, z15);
    }

    public final zzao zza(long j10, String str, long j11, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        String[] strArr = {str};
        zzao zzaoVar = new zzao();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseA = a();
                Cursor cursorQuery = sQLiteDatabaseA.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    zzj().zzu().zza("Not updating daily counts, app is not known. appId", zzgb.zza(str));
                    cursorQuery.close();
                    return zzaoVar;
                }
                if (cursorQuery.getLong(0) == j10) {
                    zzaoVar.f7671b = cursorQuery.getLong(1);
                    zzaoVar.f7670a = cursorQuery.getLong(2);
                    zzaoVar.f7672c = cursorQuery.getLong(3);
                    zzaoVar.f7673d = cursorQuery.getLong(4);
                    zzaoVar.f7674e = cursorQuery.getLong(5);
                    if (zzon.zza() && zze().zza(zzbh.Q0)) {
                        zzaoVar.f7675f = cursorQuery.getLong(6);
                    }
                }
                if (z10) {
                    zzaoVar.f7671b += j11;
                }
                if (z11) {
                    zzaoVar.f7670a += j11;
                }
                if (z12) {
                    zzaoVar.f7672c += j11;
                }
                if (z13) {
                    zzaoVar.f7673d += j11;
                }
                if (z14) {
                    zzaoVar.f7674e += j11;
                }
                if (zzon.zza() && zze().zza(zzbh.Q0) && z15) {
                    zzaoVar.f7675f += j11;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j10));
                contentValues.put("daily_public_events_count", Long.valueOf(zzaoVar.f7670a));
                contentValues.put("daily_events_count", Long.valueOf(zzaoVar.f7671b));
                contentValues.put("daily_conversions_count", Long.valueOf(zzaoVar.f7672c));
                contentValues.put("daily_error_events_count", Long.valueOf(zzaoVar.f7673d));
                contentValues.put("daily_realtime_events_count", Long.valueOf(zzaoVar.f7674e));
                if (zzon.zza() && zze().zza(zzbh.Q0)) {
                    contentValues.put("daily_realtime_dcu_count", Long.valueOf(zzaoVar.f7675f));
                }
                sQLiteDatabaseA.update("apps", contentValues, "app_id=?", strArr);
                cursorQuery.close();
                return zzaoVar;
            } catch (SQLiteException e10) {
                zzj().zzg().zza("Error updating daily counts. appId", zzgb.zza(str), e10);
                if (0 != 0) {
                    cursor.close();
                }
                return zzaoVar;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zznq zze(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            r18.zzt()
            r18.zzak()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.a()     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteException -> L84
            java.lang.String r11 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r1 = "value"
            java.lang.String r2 = "origin"
            java.lang.String[] r12 = new java.lang.String[]{r0, r1, r2}     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteException -> L84
            java.lang.String r13 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r14 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteException -> L84
            r1 = 0
            r14[r1] = r19     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteException -> L84
            r2 = 1
            r14[r2] = r8     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteException -> L84
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteException -> L84
            boolean r3 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7c
            if (r3 != 0) goto L3d
            r10.close()
            return r9
        L3d:
            long r5 = r10.getLong(r1)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7c
            r11 = r18
            java.lang.Object r7 = r11.c(r10, r2)     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> La7
            if (r7 != 0) goto L4d
            r10.close()
            return r9
        L4d:
            java.lang.String r3 = r10.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> La7
            com.google.android.gms.measurement.internal.zznq r0 = new com.google.android.gms.measurement.internal.zznq     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> La7
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> La7
            boolean r1 = r10.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> La7
            if (r1 == 0) goto L72
            com.google.android.gms.measurement.internal.zzgb r1 = r18.zzj()     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> La7
            com.google.android.gms.measurement.internal.zzgd r1 = r1.zzg()     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> La7
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgb.zza(r19)     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> La7
            r1.zza(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> La7
        L72:
            r10.close()
            return r0
        L76:
            r0 = move-exception
            goto L88
        L78:
            r0 = move-exception
            r11 = r18
            goto La8
        L7c:
            r0 = move-exception
            r11 = r18
            goto L88
        L80:
            r0 = move-exception
            r11 = r18
            goto La9
        L84:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L88:
            com.google.android.gms.measurement.internal.zzgb r1 = r18.zzj()     // Catch: java.lang.Throwable -> La7
            com.google.android.gms.measurement.internal.zzgd r1 = r1.zzg()     // Catch: java.lang.Throwable -> La7
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgb.zza(r19)     // Catch: java.lang.Throwable -> La7
            com.google.android.gms.measurement.internal.zzfw r4 = r18.zzi()     // Catch: java.lang.Throwable -> La7
            java.lang.String r4 = r4.zzc(r8)     // Catch: java.lang.Throwable -> La7
            r1.zza(r2, r3, r4, r0)     // Catch: java.lang.Throwable -> La7
            if (r10 == 0) goto La6
            r10.close()
        La6:
            return r9
        La7:
            r0 = move-exception
        La8:
            r9 = r10
        La9:
            if (r9 == 0) goto Lae
            r9.close()
        Lae:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zze(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zznq");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String zza(long r5) throws java.lang.Throwable {
        /*
            r4 = this;
            r4.zzt()
            r4.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.a()     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            r6 = 0
            r3[r6] = r5     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            boolean r1 = r5.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L3a java.lang.Throwable -> L53
            if (r1 != 0) goto L32
            com.google.android.gms.measurement.internal.zzgb r6 = r4.zzj()     // Catch: android.database.sqlite.SQLiteException -> L3a java.lang.Throwable -> L53
            com.google.android.gms.measurement.internal.zzgd r6 = r6.zzp()     // Catch: android.database.sqlite.SQLiteException -> L3a java.lang.Throwable -> L53
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.zza(r1)     // Catch: android.database.sqlite.SQLiteException -> L3a java.lang.Throwable -> L53
            r5.close()
            return r0
        L32:
            java.lang.String r6 = r5.getString(r6)     // Catch: android.database.sqlite.SQLiteException -> L3a java.lang.Throwable -> L53
            r5.close()
            return r6
        L3a:
            r6 = move-exception
            goto L40
        L3c:
            r6 = move-exception
            goto L55
        L3e:
            r6 = move-exception
            r5 = r0
        L40:
            com.google.android.gms.measurement.internal.zzgb r1 = r4.zzj()     // Catch: java.lang.Throwable -> L53
            com.google.android.gms.measurement.internal.zzgd r1 = r1.zzg()     // Catch: java.lang.Throwable -> L53
            java.lang.String r2 = "Error selecting expired configs"
            r1.zza(r2, r6)     // Catch: java.lang.Throwable -> L53
            if (r5 == 0) goto L52
            r5.close()
        L52:
            return r0
        L53:
            r6 = move-exception
            r0 = r5
        L55:
            if (r0 == 0) goto L5a
            r0.close()
        L5a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zza(long):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0185 A[EDGE_INSN: B:91:0x0185->B:76:0x0185 BREAK  A[LOOP:0: B:17:0x0054->B:75:0x0182], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<android.util.Pair<com.google.android.gms.internal.measurement.zzft.zzj, java.lang.Long>> zza(java.lang.String r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zza(java.lang.String, int, int):java.util.List");
    }

    public final List<zzac> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb2 = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb2.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3 + "*");
            sb2.append(" and name glob ?");
        }
        return zza(sb2.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0050, code lost:
    
        zzj().zzg().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzac> zza(java.lang.String r25, java.lang.String[] r26) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zza(java.lang.String, java.lang.String[]):java.util.List");
    }

    public final void zza(zzf zzfVar) {
        Preconditions.checkNotNull(zzfVar);
        zzt();
        zzak();
        String strZzaa = zzfVar.zzaa();
        Preconditions.checkNotNull(strZzaa);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", strZzaa);
        contentValues.put("app_instance_id", zzfVar.zzab());
        contentValues.put("gmp_app_id", zzfVar.zzaf());
        contentValues.put("resettable_device_id_hash", zzfVar.zzah());
        contentValues.put("last_bundle_index", Long.valueOf(zzfVar.zzt()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzfVar.zzu()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzfVar.zzs()));
        contentValues.put("app_version", zzfVar.zzad());
        contentValues.put("app_store", zzfVar.zzac());
        contentValues.put("gmp_version", Long.valueOf(zzfVar.zzq()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzfVar.zzn()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzfVar.zzap()));
        contentValues.put("day", Long.valueOf(zzfVar.zzm()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzfVar.zzk()));
        contentValues.put("daily_events_count", Long.valueOf(zzfVar.zzj()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzfVar.zzh()));
        contentValues.put("config_fetched_time", Long.valueOf(zzfVar.zzg()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzfVar.zzp()));
        contentValues.put("app_version_int", Long.valueOf(zzfVar.zze()));
        contentValues.put("firebase_instance_id", zzfVar.zzae());
        contentValues.put("daily_error_events_count", Long.valueOf(zzfVar.zzi()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzfVar.zzl()));
        contentValues.put("health_monitor_sample", zzfVar.zzag());
        contentValues.put("android_id", Long.valueOf(zzfVar.zzd()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzfVar.zzao()));
        contentValues.put("admob_app_id", zzfVar.zzy());
        contentValues.put("dynamite_version", Long.valueOf(zzfVar.zzo()));
        contentValues.put("session_stitching_token", zzfVar.zzaj());
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(zzfVar.zzar()));
        contentValues.put("target_os_version", Long.valueOf(zzfVar.zzw()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(zzfVar.zzv()));
        if (zzpy.zza() && zze().zze(strZzaa, zzbh.E0)) {
            contentValues.put("ad_services_version", Integer.valueOf(zzfVar.zza()));
            contentValues.put("attribution_eligibility_status", Long.valueOf(zzfVar.zzf()));
        }
        if (zzoh.zza() && zze().zze(strZzaa, zzbh.R0)) {
            contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(zzfVar.zzas()));
        }
        if (zzon.zza() && zze().zze(strZzaa, zzbh.M0)) {
            contentValues.put("npa_metadata_value", zzfVar.zzx());
        }
        if (zzqv.zza() && zze().zze(strZzaa, zzbh.f7766t0)) {
            zzq();
            if (zznt.M(strZzaa)) {
                contentValues.put("bundle_delivery_index", Long.valueOf(zzfVar.zzr()));
            }
        }
        if (zzqv.zza() && zze().zze(strZzaa, zzbh.f7768u0)) {
            contentValues.put("sgtm_preview_key", zzfVar.zzak());
        }
        if (zzon.zza() && zze().zze(strZzaa, zzbh.Q0)) {
            contentValues.put("dma_consent_state", Integer.valueOf(zzfVar.zzc()));
            contentValues.put("daily_realtime_dcu_count", Integer.valueOf(zzfVar.zzb()));
        }
        if (zznw.zza() && zze().zze(strZzaa, zzbh.X0)) {
            contentValues.put("serialized_npa_metadata", zzfVar.zzai());
        }
        List<String> listZzal = zzfVar.zzal();
        if (listZzal != null) {
            if (listZzal.isEmpty()) {
                zzj().zzu().zza("Safelisted events should not be an empty list. appId", strZzaa);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", listZzal));
            }
        }
        if (zzoo.zza() && zze().zza(zzbh.f7756o0) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        try {
            SQLiteDatabase sQLiteDatabaseA = a();
            if (sQLiteDatabaseA.update("apps", contentValues, "app_id = ?", new String[]{strZzaa}) == 0 && sQLiteDatabaseA.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update app (got -1). appId", zzgb.zza(strZzaa));
            }
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing app. appId", zzgb.zza(strZzaa), e10);
        }
    }

    public final void zza(String str, zziq zziqVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zziqVar);
        zzt();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zziqVar.zzh());
        if (zzon.zza() && zze().zza(zzbh.M0)) {
            contentValues.put("consent_source", Integer.valueOf(zziqVar.zza()));
            e(contentValues);
            return;
        }
        try {
            if (a().insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update consent setting (got -1). appId", zzgb.zza(str));
            }
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing consent setting. appId, error", zzgb.zza(str), e10);
        }
    }

    public final void zza(String str, zzax zzaxVar) throws IllegalStateException {
        if (zzon.zza() && zze().zza(zzbh.M0)) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(zzaxVar);
            zzt();
            zzak();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("dma_consent_settings", zzaxVar.zzf());
            e(contentValues);
        }
    }

    public final void zza(zzbb zzbbVar) throws IllegalStateException {
        Preconditions.checkNotNull(zzbbVar);
        zzt();
        zzak();
        ContentValues contentValues = new ContentValues();
        String str = zzbbVar.f7708a;
        String str2 = zzbbVar.f7708a;
        contentValues.put("app_id", str);
        contentValues.put(MediationMetaData.KEY_NAME, zzbbVar.f7709b);
        contentValues.put("lifetime_count", Long.valueOf(zzbbVar.f7710c));
        contentValues.put("current_bundle_count", Long.valueOf(zzbbVar.f7711d));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzbbVar.f7713f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzbbVar.f7714g));
        contentValues.put("last_bundled_day", zzbbVar.f7715h);
        contentValues.put("last_sampled_complex_event_id", zzbbVar.f7716i);
        contentValues.put("last_sampling_rate", zzbbVar.f7717j);
        contentValues.put("current_session_count", Long.valueOf(zzbbVar.f7712e));
        Boolean bool = zzbbVar.f7718k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (a().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update event aggregates (got -1). appId", zzgb.zza(str2));
            }
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing event aggregates. appId", zzgb.zza(str2), e10);
        }
    }

    public final boolean zza(zzft.zzj zzjVar, boolean z10) throws IllegalStateException {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzjVar);
        Preconditions.checkNotEmpty(zzjVar.zzx());
        Preconditions.checkState(zzjVar.zzbe());
        zzv();
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        if (zzjVar.zzl() < jCurrentTimeMillis - zzae.zzm() || zzjVar.zzl() > zzae.zzm() + jCurrentTimeMillis) {
            zzj().zzu().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzgb.zza(zzjVar.zzx()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzjVar.zzl()));
        }
        try {
            byte[] bArrF = g_().F(zzjVar.zzbv());
            zzj().zzp().zza("Saving bundle, size", Integer.valueOf(bArrF.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzjVar.zzx());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzjVar.zzl()));
            contentValues.put(JsonStorageKeyNames.DATA_KEY, bArrF);
            contentValues.put("has_realtime", Integer.valueOf(z10 ? 1 : 0));
            if (zzjVar.zzbl()) {
                contentValues.put("retry_count", Integer.valueOf(zzjVar.zzf()));
            }
            try {
                if (a().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzj().zzg().zza("Failed to insert bundle (got -1). appId", zzgb.zza(zzjVar.zzx()));
                return false;
            } catch (SQLiteException e10) {
                zzj().zzg().zza("Error storing bundle. appId", zzgb.zza(zzjVar.zzx()), e10);
                return false;
            }
        } catch (IOException e11) {
            zzj().zzg().zza("Data loss. Failed to serialize bundle. appId", zzgb.zza(zzjVar.zzx()), e11);
            return false;
        }
    }

    public final boolean zza(zzay zzayVar, long j10, boolean z10) throws IllegalStateException {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzayVar);
        Preconditions.checkNotEmpty(zzayVar.f7693a);
        byte[] bArrZzbv = g_().e(zzayVar).zzbv();
        ContentValues contentValues = new ContentValues();
        String str = zzayVar.f7693a;
        contentValues.put("app_id", str);
        contentValues.put(MediationMetaData.KEY_NAME, zzayVar.f7694b);
        contentValues.put("timestamp", Long.valueOf(zzayVar.f7696d));
        contentValues.put("metadata_fingerprint", Long.valueOf(j10));
        contentValues.put(JsonStorageKeyNames.DATA_KEY, bArrZzbv);
        contentValues.put("realtime", Integer.valueOf(z10 ? 1 : 0));
        try {
            if (a().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert raw event (got -1). appId", zzgb.zza(str));
            return false;
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing raw event. appId", zzgb.zza(str), e10);
            return false;
        }
    }

    public final boolean zza(String str, zzmv zzmvVar) throws IllegalStateException {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzmvVar);
        Preconditions.checkNotEmpty(str);
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        long j10 = zzmvVar.f8518m;
        long jZzm = jCurrentTimeMillis - zzae.zzm();
        long j11 = zzmvVar.f8518m;
        if (j10 < jZzm || j11 > zzae.zzm() + jCurrentTimeMillis) {
            zzj().zzu().zza("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzgb.zza(str), Long.valueOf(jCurrentTimeMillis), Long.valueOf(j11));
        }
        zzj().zzp().zza("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzmvVar.f8517b);
        contentValues.put("source", Integer.valueOf(zzmvVar.f8519n));
        contentValues.put("timestamp_millis", Long.valueOf(j11));
        try {
            if (a().insert("trigger_uris", null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert trigger URI (got -1). appId", zzgb.zza(str));
            return false;
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing trigger URI. appId", zzgb.zza(str), e10);
            return false;
        }
    }

    public final boolean zza(String str, Long l10, long j10, zzft.zze zzeVar) throws IllegalStateException {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzeVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l10);
        byte[] bArrZzbv = zzeVar.zzbv();
        zzj().zzp().zza("Saving complex main event, appId, data size", zzi().zza(str), Integer.valueOf(bArrZzbv.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l10);
        contentValues.put("children_to_process", Long.valueOf(j10));
        contentValues.put("main_event", bArrZzbv);
        try {
            if (a().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert complex main event (got -1). appId", zzgb.zza(str));
            return false;
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing complex main event. appId", zzgb.zza(str), e10);
            return false;
        }
    }

    public final boolean zza(zzac zzacVar) throws IllegalStateException {
        Preconditions.checkNotNull(zzacVar);
        zzt();
        zzak();
        String str = zzacVar.f7627b;
        Preconditions.checkNotNull(str);
        if (zze(str, zzacVar.f7629n.f8589m) == null && j("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzacVar.f7628m);
        contentValues.put(MediationMetaData.KEY_NAME, zzacVar.f7629n.f8589m);
        f(contentValues, Preconditions.checkNotNull(zzacVar.f7629n.zza()));
        contentValues.put("active", Boolean.valueOf(zzacVar.f7631p));
        contentValues.put("trigger_event_name", zzacVar.f7632q);
        contentValues.put("trigger_timeout", Long.valueOf(zzacVar.f7634s));
        zzq();
        contentValues.put("timed_out_event", zznt.z(zzacVar.f7633r));
        contentValues.put("creation_timestamp", Long.valueOf(zzacVar.f7630o));
        zzq();
        contentValues.put("triggered_event", zznt.z(zzacVar.f7635t));
        contentValues.put("triggered_timestamp", Long.valueOf(zzacVar.f7629n.f8590n));
        contentValues.put("time_to_live", Long.valueOf(zzacVar.f7636u));
        zzq();
        contentValues.put("expired_event", zznt.z(zzacVar.f7637v));
        try {
            if (a().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update conditional user property (got -1)", zzgb.zza(str));
            }
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing conditional user property", zzgb.zza(str), e10);
        }
        return true;
    }

    public final boolean zza(zznq zznqVar) {
        Preconditions.checkNotNull(zznqVar);
        zzt();
        zzak();
        String str = zznqVar.f8595a;
        String str2 = zznqVar.f8597c;
        zznq zznqVarZze = zze(str, str2);
        String str3 = zznqVar.f8596b;
        String str4 = zznqVar.f8595a;
        if (zznqVarZze == null) {
            if (zznt.O(str2)) {
                if (j("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{str4}) >= zze().zza(str4, zzbh.H, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(str2) && j("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{str4, str3}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str4);
        contentValues.put("origin", str3);
        contentValues.put(MediationMetaData.KEY_NAME, str2);
        contentValues.put("set_timestamp", Long.valueOf(zznqVar.f8598d));
        f(contentValues, zznqVar.f8599e);
        try {
            if (a().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update user property (got -1). appId", zzgb.zza(str4));
            }
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing user property. appId", zzgb.zza(str4), e10);
        }
        return true;
    }
}
