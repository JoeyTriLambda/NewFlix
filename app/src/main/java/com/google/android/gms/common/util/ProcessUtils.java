package com.google.android.gms.common.util;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes.dex */
public class ProcessUtils {

    /* renamed from: a, reason: collision with root package name */
    public static String f7508a;

    /* renamed from: b, reason: collision with root package name */
    public static int f7509b;

    private ProcessUtils() {
    }

    @KeepForSdk
    public static String getMyProcessName() throws Throwable {
        BufferedReader bufferedReader;
        if (f7508a == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                f7508a = Application.getProcessName();
            } else {
                int iMyPid = f7509b;
                if (iMyPid == 0) {
                    iMyPid = Process.myPid();
                    f7509b = iMyPid;
                }
                String strTrim = null;
                strTrim = null;
                strTrim = null;
                BufferedReader bufferedReader2 = null;
                if (iMyPid > 0) {
                    try {
                        String str = "/proc/" + iMyPid + "/cmdline";
                        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            bufferedReader = new BufferedReader(new FileReader(str));
                            try {
                                String line = bufferedReader.readLine();
                                Preconditions.checkNotNull(line);
                                strTrim = line.trim();
                            } catch (IOException unused) {
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedReader2 = bufferedReader;
                                IOUtils.closeQuietly(bufferedReader2);
                                throw th;
                            }
                        } finally {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        }
                    } catch (IOException unused2) {
                        bufferedReader = null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    IOUtils.closeQuietly(bufferedReader);
                }
                f7508a = strTrim;
            }
        }
        return f7508a;
    }
}
