package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import b0.b;
import b8.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzgr implements zzgy {
    private static final Map<Uri, zzgr> zza = new b();
    private static final String[] zzb = {"key", "value"};
    private final ContentResolver zzc;
    private final Uri zzd;
    private final Runnable zze;
    private final ContentObserver zzf;
    private final Object zzg;
    private volatile Map<String, String> zzh;
    private final List<zzgw> zzi;

    private zzgr(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        zzgt zzgtVar = new zzgt(this, null);
        this.zzf = zzgtVar;
        this.zzg = new Object();
        this.zzi = new ArrayList();
        e.checkNotNull(contentResolver);
        e.checkNotNull(uri);
        this.zzc = contentResolver;
        this.zzd = uri;
        this.zze = runnable;
        contentResolver.registerContentObserver(uri, false, zzgtVar);
    }

    public static zzgr zza(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        zzgr zzgrVar;
        synchronized (zzgr.class) {
            Map<Uri, zzgr> map = zza;
            zzgrVar = map.get(uri);
            if (zzgrVar == null) {
                try {
                    zzgr zzgrVar2 = new zzgr(contentResolver, uri, runnable);
                    try {
                        map.put(uri, zzgrVar2);
                    } catch (SecurityException unused) {
                    }
                    zzgrVar = zzgrVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzgrVar;
    }

    public static synchronized void zzc() {
        for (zzgr zzgrVar : zza.values()) {
            zzgrVar.zzc.unregisterContentObserver(zzgrVar.zzf);
        }
        zza.clear();
    }

    private final Map<String, String> zze() {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                return (Map) zzgx.zza(new zzha() { // from class: com.google.android.gms.internal.measurement.zzgu
                    @Override // com.google.android.gms.internal.measurement.zzha
                    public final Object zza() {
                        return this.zza.zzb();
                    }
                });
            } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                Log.e("ConfigurationContentLdr", "PhenotypeFlag unable to load ContentProvider, using default values");
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                return null;
            }
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    public final /* synthetic */ Map zzb() {
        Cursor cursorQuery = this.zzc.query(this.zzd, zzb, null, null, null);
        if (cursorQuery == null) {
            return Collections.emptyMap();
        }
        try {
            int count = cursorQuery.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            Map bVar = count <= 256 ? new b(count) : new HashMap(count, 1.0f);
            while (cursorQuery.moveToNext()) {
                bVar.put(cursorQuery.getString(0), cursorQuery.getString(1));
            }
            return bVar;
        } finally {
            cursorQuery.close();
        }
    }

    public final void zzd() {
        synchronized (this.zzg) {
            this.zzh = null;
            this.zze.run();
        }
        synchronized (this) {
            Iterator<zzgw> it = this.zzi.iterator();
            while (it.hasNext()) {
                it.next().zza();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzgy
    public final /* synthetic */ Object zza(String str) {
        return zza().get(str);
    }

    public final Map<String, String> zza() {
        Map<String, String> mapZze = this.zzh;
        if (mapZze == null) {
            synchronized (this.zzg) {
                mapZze = this.zzh;
                if (mapZze == null) {
                    mapZze = zze();
                    this.zzh = mapZze;
                }
            }
        }
        return mapZze != null ? mapZze : Collections.emptyMap();
    }
}
