package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzfu extends zzg {

    /* renamed from: c, reason: collision with root package name */
    public final zzfx f7927c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7928d;

    public zzfu(zzho zzhoVar) {
        super(zzhoVar);
        this.f7927c = new zzfx(this, zza());
    }

    public static long a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, null, null, "rowid desc", "1");
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                return -1L;
            }
            long j10 = cursorQuery.getLong(0);
            cursorQuery.close();
            return j10;
        } catch (Throwable th2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0129  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(int r17, byte[] r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfu.b(int, byte[]):boolean");
    }

    public final SQLiteDatabase c() throws IllegalStateException, SQLiteException {
        if (this.f7928d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f7927c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f7928d = true;
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    public final void zzaa() {
        int iDelete;
        zzt();
        try {
            SQLiteDatabase sQLiteDatabaseC = c();
            if (sQLiteDatabaseC == null || (iDelete = sQLiteDatabaseC.delete("messages", null, null) + 0) <= 0) {
                return;
            }
            zzj().zzp().zza("Reset local analytics data. records", Integer.valueOf(iDelete));
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error resetting local analytics data. error", e10);
        }
    }

    public final boolean zzab() {
        return b(3, new byte[0]);
    }

    public final boolean zzac() throws IllegalStateException {
        zzt();
        if (this.f7928d || !zza().getDatabasePath("google_app_measurement_local.db").exists()) {
            return false;
        }
        int i10 = 5;
        for (int i11 = 0; i11 < 5; i11++) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase sQLiteDatabaseC = c();
                if (sQLiteDatabaseC == null) {
                    this.f7928d = true;
                    if (sQLiteDatabaseC != null) {
                        sQLiteDatabaseC.close();
                    }
                    return false;
                }
                sQLiteDatabaseC.beginTransaction();
                sQLiteDatabaseC.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                sQLiteDatabaseC.setTransactionSuccessful();
                sQLiteDatabaseC.endTransaction();
                sQLiteDatabaseC.close();
                return true;
            } catch (SQLiteDatabaseLockedException unused) {
                SystemClock.sleep(i10);
                i10 += 20;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteFullException e10) {
                zzj().zzg().zza("Error deleting app launch break from local database", e10);
                this.f7928d = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteException e11) {
                if (0 != 0) {
                    try {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    } catch (Throwable th2) {
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                        throw th2;
                    }
                }
                zzj().zzg().zza("Error deleting app launch break from local database", e11);
                this.f7928d = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            }
        }
        zzj().zzu().zza("Error deleting app launch break from local database in reasonable time");
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzad zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzae zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzfw zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzgb zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzgm zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzhh zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final boolean zzz() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01fa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01fa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01fa A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zza(int r22) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfu.zza(int):java.util.List");
    }

    public final boolean zza(zzac zzacVar) {
        zzq();
        byte[] bArrZ = zznt.z(zzacVar);
        if (bArrZ.length > 131072) {
            zzj().zzm().zza("Conditional user property too long for local database. Sending directly to service");
            return false;
        }
        return b(2, bArrZ);
    }

    public final boolean zza(zzbf zzbfVar) throws IllegalStateException {
        Parcel parcelObtain = Parcel.obtain();
        zzbfVar.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length > 131072) {
            zzj().zzm().zza("Event is too long for local database. Sending event directly to service");
            return false;
        }
        return b(0, bArrMarshall);
    }

    public final boolean zza(zzno zznoVar) throws IllegalStateException {
        Parcel parcelObtain = Parcel.obtain();
        zznoVar.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length > 131072) {
            zzj().zzm().zza("User property too long for local database. Sending directly to service");
            return false;
        }
        return b(1, bArrMarshall);
    }
}
