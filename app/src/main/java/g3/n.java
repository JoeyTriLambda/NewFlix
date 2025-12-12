package g3;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.impl.WorkDatabase;

/* compiled from: PreferenceUtils.java */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final WorkDatabase f12651a;

    public n(WorkDatabase workDatabase) {
        this.f12651a = workDatabase;
    }

    public static void migrateLegacyPreferences(Context context, k2.e eVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
        if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
            long j10 = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
            long j11 = sharedPreferences.getBoolean("reschedule_needed", false) ? 1L : 0L;
            eVar.beginTransaction();
            try {
                eVar.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j10)});
                eVar.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j11)});
                sharedPreferences.edit().clear().apply();
                eVar.setTransactionSuccessful();
            } finally {
                eVar.endTransaction();
            }
        }
    }

    public long getLastForceStopEventMillis() {
        Long longValue = this.f12651a.preferenceDao().getLongValue("last_force_stop_ms");
        if (longValue != null) {
            return longValue.longValue();
        }
        return 0L;
    }

    public boolean getNeedsReschedule() {
        Long longValue = this.f12651a.preferenceDao().getLongValue("reschedule_needed");
        return longValue != null && longValue.longValue() == 1;
    }

    public void setLastForceStopEventMillis(long j10) {
        this.f12651a.preferenceDao().insertPreference(new f3.d("last_force_stop_ms", Long.valueOf(j10)));
    }

    public void setNeedsReschedule(boolean z10) {
        this.f12651a.preferenceDao().insertPreference(new f3.d("reschedule_needed", z10));
    }
}
