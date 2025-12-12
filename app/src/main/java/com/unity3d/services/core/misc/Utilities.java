package com.unity3d.services.core.misc;

import ac.c;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.unity3d.services.core.di.ServiceProvider;
import com.unity3d.services.core.log.DeviceLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import xf.a;

/* loaded from: classes2.dex */
public class Utilities {
    public static String Sha256(String str) {
        return Sha256(str.getBytes());
    }

    public static Map<String, Object> combineJsonIntoMap(Map<String, Object> map, JSONObject jSONObject, String str) {
        HashMap map2 = new HashMap(map);
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map2.put(c.B(str, next), jSONObject.opt(next));
        }
        return map2;
    }

    public static Map<String, Object> convertJsonToMap(JSONObject jSONObject) {
        return combineJsonIntoMap(new HashMap(), jSONObject);
    }

    public static <T> T getService(String str, Class cls) {
        return (T) ServiceProvider.INSTANCE.getRegistry().getService(str, a.getKotlinClass(cls));
    }

    public static JSONObject mergeJsonObjects(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject == null) {
            return jSONObject2;
        }
        if (jSONObject2 == null) {
            return jSONObject;
        }
        JSONObject jSONObject3 = new JSONObject();
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            jSONObject3.put(next, jSONObject2.get(next));
        }
        Iterator<String> itKeys2 = jSONObject.keys();
        while (itKeys2.hasNext()) {
            String next2 = itKeys2.next();
            if (jSONObject3.has(next2) && (jSONObject3.get(next2) instanceof JSONObject) && (jSONObject.get(next2) instanceof JSONObject)) {
                jSONObject3.put(next2, mergeJsonObjects(jSONObject.getJSONObject(next2), jSONObject3.getJSONObject(next2)));
            } else {
                jSONObject3.put(next2, jSONObject.get(next2));
            }
        }
        return jSONObject3;
    }

    public static byte[] readFileBytes(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file == null || !file.exists()) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return Files.readAllBytes(file.toPath());
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            int length = (int) file.length();
            byte[] bArr = new byte[length];
            if (fileInputStream.read(bArr) == length) {
                fileInputStream.close();
                return bArr;
            }
            throw new IOException("Failed to read all bytes from input file path: " + file.getPath());
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
    }

    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(runnable, 0L);
    }

    public static String toHexString(byte[] bArr) {
        String string = "";
        for (byte b10 : bArr) {
            int i10 = b10 & 255;
            if (i10 <= 15) {
                string = c.B(string, "0");
            }
            StringBuilder sbR = c.r(string);
            sbR.append(Integer.toHexString(i10));
            string = sbR.toString();
        }
        return string;
    }

    public static void wrapCustomerListener(Runnable runnable) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            runnable.run();
        } catch (Exception e10) {
            DeviceLog.error("An uncaught exception has occurred in the client application.  Exception: %s", e10.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean writeFile(java.io.File r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "Error closing FileOutputStream"
            r1 = 0
            if (r4 != 0) goto L6
            return r1
        L6:
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            byte[] r5 = r5.getBytes()     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L23
            r3.write(r5)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L23
            r3.flush()     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L23
            r3.close()     // Catch: java.lang.Exception -> L1a
            goto L1e
        L1a:
            r5 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r0, r5)
        L1e:
            r1 = 1
            goto L38
        L20:
            r4 = move-exception
            r2 = r3
            goto L50
        L23:
            r5 = move-exception
            r2 = r3
            goto L29
        L26:
            r4 = move-exception
            goto L50
        L28:
            r5 = move-exception
        L29:
            java.lang.String r3 = "Could not write file"
            com.unity3d.services.core.log.DeviceLog.exception(r3, r5)     // Catch: java.lang.Throwable -> L26
            if (r2 == 0) goto L38
            r2.close()     // Catch: java.lang.Exception -> L34
            goto L38
        L34:
            r5 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r0, r5)
        L38:
            if (r1 == 0) goto L4f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r0 = "Wrote file: "
            r5.<init>(r0)
            java.lang.String r4 = r4.getAbsolutePath()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            com.unity3d.services.core.log.DeviceLog.debug(r4)
        L4f:
            return r1
        L50:
            if (r2 == 0) goto L5a
            r2.close()     // Catch: java.lang.Exception -> L56
            goto L5a
        L56:
            r5 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r0, r5)
        L5a:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.misc.Utilities.writeFile(java.io.File, java.lang.String):boolean");
    }

    public static String Sha256(byte[] bArr) throws IllegalAccessException, NoSuchMethodException, NoSuchAlgorithmException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr, 0, bArr.length);
            return toHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e10) {
            DeviceLog.exception("SHA-256 algorithm not found", e10);
            return null;
        }
    }

    public static <T> T getService(Class cls) {
        return (T) getService("", cls);
    }

    public static void runOnUiThread(Runnable runnable, long j10) {
        Handler handler = new Handler(Looper.getMainLooper());
        if (j10 > 0) {
            handler.postDelayed(runnable, j10);
        } else {
            handler.post(runnable);
        }
    }

    public static String Sha256(InputStream inputStream) throws IllegalAccessException, NoSuchMethodException, NoSuchAlgorithmException, IOException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (inputStream == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bArr = new byte[4096];
            while (true) {
                int i10 = inputStream.read(bArr);
                if (i10 != -1) {
                    messageDigest.update(bArr, 0, i10);
                } else {
                    return toHexString(messageDigest.digest());
                }
            }
        } catch (NoSuchAlgorithmException e10) {
            DeviceLog.exception("SHA-256 algorithm not found", e10);
            return null;
        }
    }

    public static Map<String, Object> combineJsonIntoMap(Map<String, Object> map, JSONObject jSONObject) {
        return combineJsonIntoMap(map, jSONObject, "");
    }
}
