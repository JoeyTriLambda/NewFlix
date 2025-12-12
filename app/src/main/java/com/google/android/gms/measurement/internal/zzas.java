package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.unity3d.ads.metadata.MediationMetaData;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzas {
    public static HashSet a(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
        try {
            Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
            return hashSet;
        } finally {
            cursorRawQuery.close();
        }
    }

    public static void b(zzgb zzgbVar, SQLiteDatabase sQLiteDatabase) throws IllegalStateException {
        if (zzgbVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(com.google.android.gms.internal.measurement.zzci.zza().zza(sQLiteDatabase.getPath()));
        if (!file.setReadable(false, false)) {
            zzgbVar.zzu().zza("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            zzgbVar.zzu().zza("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            zzgbVar.zzu().zza("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        zzgbVar.zzu().zza("Failed to turn on database write permission for owner");
    }

    public static void c(zzgb zzgbVar, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws IllegalStateException, SQLException {
        boolean zMoveToFirst;
        if (zzgbVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{MediationMetaData.KEY_NAME}, "name=?", new String[]{str}, null, null, null);
                zMoveToFirst = cursorQuery.moveToFirst();
                cursorQuery.close();
            } catch (SQLiteException e10) {
                zzgbVar.zzu().zza("Error querying for table", str, e10);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                zMoveToFirst = false;
            }
            if (!zMoveToFirst) {
                sQLiteDatabase.execSQL(str2);
            }
            try {
                HashSet hashSetA = a(sQLiteDatabase, str);
                for (String str4 : str3.split(",")) {
                    if (!hashSetA.remove(str4)) {
                        throw new SQLiteException("Table " + str + " is missing required column: " + str4);
                    }
                }
                if (strArr != null) {
                    for (int i10 = 0; i10 < strArr.length; i10 += 2) {
                        if (!hashSetA.remove(strArr[i10])) {
                            sQLiteDatabase.execSQL(strArr[i10 + 1]);
                        }
                    }
                }
                if (hashSetA.isEmpty()) {
                    return;
                }
                zzgbVar.zzu().zza("Table has extra columns. table, columns", str, TextUtils.join(", ", hashSetA));
            } catch (SQLiteException e11) {
                zzgbVar.zzg().zza("Failed to verify columns on table that was just created", str);
                throw e11;
            }
        } catch (Throwable th2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th2;
        }
    }
}
