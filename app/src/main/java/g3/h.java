package g3;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.impl.WorkDatabase;

/* compiled from: IdGenerator.kt */
/* loaded from: classes.dex */
public final class h {
    public static final int access$nextId(WorkDatabase workDatabase, String str) {
        Long longValue = workDatabase.preferenceDao().getLongValue(str);
        int iLongValue = longValue != null ? (int) longValue.longValue() : 0;
        workDatabase.preferenceDao().insertPreference(new f3.d(str, Long.valueOf(iLongValue != Integer.MAX_VALUE ? iLongValue + 1 : 0)));
        return iLongValue;
    }

    public static final void migrateLegacyIdGenerator(Context context, k2.e eVar) {
        zf.i.checkNotNullParameter(context, "context");
        zf.i.checkNotNullParameter(eVar, "sqLiteDatabase");
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.id", 0);
        if (sharedPreferences.contains("next_job_scheduler_id") || sharedPreferences.contains("next_job_scheduler_id")) {
            int i10 = sharedPreferences.getInt("next_job_scheduler_id", 0);
            int i11 = sharedPreferences.getInt("next_alarm_manager_id", 0);
            eVar.beginTransaction();
            try {
                eVar.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i10)});
                eVar.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i11)});
                sharedPreferences.edit().clear().apply();
                eVar.setTransactionSuccessful();
            } finally {
                eVar.endTransaction();
            }
        }
    }
}
