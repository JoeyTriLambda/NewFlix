package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import b0.k;
import com.google.common.base.Optional;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzhd {

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
    public static class zza {
        private static volatile Optional<zzhe> zza;

        private zza() {
        }

        public static Optional<zzhe> zza(Context context) {
            Optional<zzhe> optionalZza;
            Optional<zzhe> optional = zza;
            if (optional == null) {
                synchronized (zza.class) {
                    optional = zza;
                    if (optional == null) {
                        new zzhd();
                        if (zzhh.zza(Build.TYPE, Build.TAGS)) {
                            if (zzgp.zza() && !context.isDeviceProtectedStorage()) {
                                context = context.createDeviceProtectedStorageContext();
                            }
                            optionalZza = zzhd.zza(context);
                        } else {
                            optionalZza = Optional.absent();
                        }
                        zza = optionalZza;
                        optional = optionalZza;
                    }
                }
            }
            return optional;
        }
    }

    private static zzhe zza(Context context, File file) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                k kVar = new k();
                HashMap map = new HashMap();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        Log.w("HermeticFileOverrides", "Parsed " + String.valueOf(file) + " for Android package " + context.getPackageName());
                        zzgv zzgvVar = new zzgv(kVar);
                        bufferedReader.close();
                        return zzgvVar;
                    }
                    String[] strArrSplit = line.split(StringUtils.SPACE, 3);
                    if (strArrSplit.length != 3) {
                        Log.e("HermeticFileOverrides", "Invalid: " + line);
                    } else {
                        String strZza = zza(strArrSplit[0]);
                        String strDecode = Uri.decode(zza(strArrSplit[1]));
                        String strDecode2 = (String) map.get(strArrSplit[2]);
                        if (strDecode2 == null) {
                            String strZza2 = zza(strArrSplit[2]);
                            strDecode2 = Uri.decode(strZza2);
                            if (strDecode2.length() < 1024 || strDecode2 == strZza2) {
                                map.put(strZza2, strDecode2);
                            }
                        }
                        k kVar2 = (k) kVar.get(strZza);
                        if (kVar2 == null) {
                            kVar2 = new k();
                            kVar.put(strZza, kVar2);
                        }
                        kVar2.put(strDecode, strDecode2);
                    }
                }
            } finally {
            }
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    private static Optional<File> zzb(Context context) {
        try {
            File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
            return file.exists() ? Optional.of(file) : Optional.absent();
        } catch (RuntimeException e10) {
            Log.e("HermeticFileOverrides", "no data dir", e10);
            return Optional.absent();
        }
    }

    public static Optional<zzhe> zza(Context context) {
        Optional<zzhe> optionalAbsent;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            Optional<File> optionalZzb = zzb(context);
            if (optionalZzb.isPresent()) {
                optionalAbsent = Optional.of(zza(context, optionalZzb.get()));
            } else {
                optionalAbsent = Optional.absent();
            }
            return optionalAbsent;
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    private static final String zza(String str) {
        return new String(str);
    }
}
