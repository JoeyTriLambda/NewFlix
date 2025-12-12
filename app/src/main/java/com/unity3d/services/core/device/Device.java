package com.unity3d.services.core.device;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.preferences.AndroidPreferences;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Device {
    private static SDKMetricsSender sdkMetricsSender = (SDKMetricsSender) Utilities.getService(SDKMetricsSender.class);

    /* renamed from: com.unity3d.services.core.device.Device$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$services$core$device$Device$MemoryInfoType;

        static {
            int[] iArr = new int[MemoryInfoType.values().length];
            $SwitchMap$com$unity3d$services$core$device$Device$MemoryInfoType = iArr;
            try {
                iArr[MemoryInfoType.TOTAL_MEMORY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$unity3d$services$core$device$Device$MemoryInfoType[MemoryInfoType.FREE_MEMORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum MemoryInfoType {
        TOTAL_MEMORY,
        FREE_MEMORY
    }

    public static String getAdvertisingTrackingId() {
        return AdvertisingId.getAdvertisingTrackingId();
    }

    public static int getApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    public static String getApkDigest() throws Exception {
        long length;
        FileInputStream fileInputStream;
        String packageCodePath = ClientProperties.getApplicationContext().getPackageCodePath();
        long jNanoTime = System.nanoTime();
        FileInputStream fileInputStream2 = null;
        try {
            File file = new File(packageCodePath);
            length = file.length() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            String strSha256 = Utilities.Sha256(fileInputStream);
            try {
                fileInputStream.close();
            } catch (IOException unused) {
            }
            if (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime) > 5000) {
                sdkMetricsSender.sendMetric(new Metric("native_device_info_apk_digest_timeout", Long.valueOf(length)));
            }
            sdkMetricsSender.sendMetric(new Metric("native_device_info_apk_size", Long.valueOf(length)));
            return strSha256;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static String getAuid() {
        return AndroidPreferences.getString("supersonic_shared_preferen", JsonStorageKeyNames.AUID_ID_KEY);
    }

    public static float getBatteryLevel() {
        Intent intentRegisterReceiver;
        if (ClientProperties.getApplicationContext() == null || (intentRegisterReceiver = ClientProperties.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))) == null) {
            return -1.0f;
        }
        return intentRegisterReceiver.getIntExtra("level", -1) / intentRegisterReceiver.getIntExtra("scale", -1);
    }

    public static int getBatteryStatus() {
        Intent intentRegisterReceiver;
        if (ClientProperties.getApplicationContext() == null || (intentRegisterReceiver = ClientProperties.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))) == null) {
            return -1;
        }
        return intentRegisterReceiver.getIntExtra("status", -1);
    }

    public static String getBoard() {
        return Build.BOARD;
    }

    public static String getBootloader() {
        return Build.BOOTLOADER;
    }

    public static String getBrand() {
        return Build.BRAND;
    }

    public static String getBuildId() {
        return Build.ID;
    }

    public static String getBuildVersionIncremental() {
        return Build.VERSION.INCREMENTAL;
    }

    public static long getCPUCount() {
        return Runtime.getRuntime().availableProcessors();
    }

    public static String getCertificateFingerprint() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Signature[] signatureArr = ClientProperties.getApplicationContext().getPackageManager().getPackageInfo(ClientProperties.getApplicationContext().getPackageName(), 64).signatures;
            if (signatureArr == null || signatureArr.length < 1) {
                return null;
            }
            return Utilities.toHexString(MessageDigest.getInstance("SHA-1").digest(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getEncoded()));
        } catch (Exception e10) {
            DeviceLog.exception("Exception when signing certificate fingerprint", e10);
            return null;
        }
    }

    public static String getConnectionType() {
        return isUsingWifi() ? "wifi" : isActiveNetworkConnected() ? "cellular" : "none";
    }

    public static String getDevice() {
        return Build.DEVICE;
    }

    public static float getDisplayMetricDensity() {
        if (ClientProperties.getApplicationContext() != null) {
            return ClientProperties.getApplicationContext().getResources().getDisplayMetrics().density;
        }
        return -1.0f;
    }

    public static long getElapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public static String getFingerprint() {
        return Build.FINGERPRINT;
    }

    public static long getFreeMemory() {
        return getMemoryInfo(MemoryInfoType.FREE_MEMORY);
    }

    public static long getFreeSpace(File file) {
        if (file == null || !file.exists()) {
            return -1L;
        }
        return Math.round(file.getFreeSpace() / 1024);
    }

    public static String getGLVersion() {
        ActivityManager activityManager;
        ConfigurationInfo deviceConfigurationInfo;
        if (ClientProperties.getApplicationContext() == null || (activityManager = (ActivityManager) ClientProperties.getApplicationContext().getSystemService("activity")) == null || (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) == null) {
            return null;
        }
        return deviceConfigurationInfo.getGlEsVersion();
    }

    public static String getHardware() {
        return Build.HARDWARE;
    }

    public static String getHost() {
        return Build.HOST;
    }

    public static String getIdfi() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        String string = AndroidPreferences.getString("unityads-installinfo", "unityads-idfi");
        if (string == null) {
            string = getAuid();
        }
        if (string != null) {
            return string;
        }
        String uniqueEventId = getUniqueEventId();
        AndroidPreferences.setString("unityads-installinfo", "unityads-idfi", uniqueEventId);
        return uniqueEventId;
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long getMemoryInfo(com.unity3d.services.core.device.Device.MemoryInfoType r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "Error closing RandomAccessFile"
            int[] r1 = com.unity3d.services.core.device.Device.AnonymousClass1.$SwitchMap$com$unity3d$services$core$device$Device$MemoryInfoType
            int r2 = r6.ordinal()
            r1 = r1[r2]
            r2 = 1
            if (r1 == r2) goto L11
            r2 = 2
            if (r1 == r2) goto L11
            r2 = -1
        L11:
            r1 = 0
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L36
            java.lang.String r4 = "/proc/meminfo"
            java.lang.String r5 = "r"
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L36
            r4 = 0
        L1c:
            if (r4 >= r2) goto L25
            java.lang.String r1 = r3.readLine()     // Catch: java.io.IOException -> L32 java.lang.Throwable -> L5a
            int r4 = r4 + 1
            goto L1c
        L25:
            long r1 = getMemoryValueFromString(r1)     // Catch: java.io.IOException -> L32 java.lang.Throwable -> L5a
            r3.close()     // Catch: java.io.IOException -> L2d
            goto L31
        L2d:
            r6 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r0, r6)
        L31:
            return r1
        L32:
            r1 = move-exception
            goto L39
        L34:
            r6 = move-exception
            goto L5c
        L36:
            r2 = move-exception
            r3 = r1
            r1 = r2
        L39:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a
            r2.<init>()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r4 = "Error while reading memory info: "
            r2.append(r4)     // Catch: java.lang.Throwable -> L5a
            r2.append(r6)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L5a
            com.unity3d.services.core.log.DeviceLog.exception(r6, r1)     // Catch: java.lang.Throwable -> L5a
            if (r3 == 0) goto L57
            r3.close()     // Catch: java.io.IOException -> L53
            goto L57
        L53:
            r6 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r0, r6)
        L57:
            r0 = -1
            return r0
        L5a:
            r6 = move-exception
            r1 = r3
        L5c:
            if (r1 == 0) goto L66
            r1.close()     // Catch: java.io.IOException -> L62
            goto L66
        L62:
            r1 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r0, r1)
        L66:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.device.Device.getMemoryInfo(com.unity3d.services.core.device.Device$MemoryInfoType):long");
    }

    private static long getMemoryValueFromString(String str) {
        if (str == null) {
            return -1L;
        }
        Matcher matcher = Pattern.compile("(\\d+)").matcher(str);
        String strGroup = "";
        while (matcher.find()) {
            strGroup = matcher.group(1);
        }
        return Long.parseLong(strGroup);
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getNetworkCountryISO() {
        return ClientProperties.getApplicationContext() != null ? ((TelephonyManager) ClientProperties.getApplicationContext().getSystemService("phone")).getNetworkCountryIso() : "";
    }

    public static boolean getNetworkMetered() {
        ConnectivityManager connectivityManager;
        if (ClientProperties.getApplicationContext() == null || (connectivityManager = (ConnectivityManager) ClientProperties.getApplicationContext().getSystemService("connectivity")) == null) {
            return false;
        }
        return connectivityManager.isActiveNetworkMetered();
    }

    public static String getNetworkOperator() {
        return ClientProperties.getApplicationContext() != null ? ((TelephonyManager) ClientProperties.getApplicationContext().getSystemService("phone")).getNetworkOperator() : "";
    }

    public static String getNetworkOperatorName() {
        return ClientProperties.getApplicationContext() != null ? ((TelephonyManager) ClientProperties.getApplicationContext().getSystemService("phone")).getNetworkOperatorName() : "";
    }

    public static int getNetworkType() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (ClientProperties.getApplicationContext() == null) {
            return -1;
        }
        try {
            return ((TelephonyManager) ClientProperties.getApplicationContext().getSystemService("phone")).getNetworkType();
        } catch (SecurityException unused) {
            DeviceLog.warning("Unity Ads was not able to get current network type due to missing permission");
            return -1;
        }
    }

    @TargetApi(21)
    private static ArrayList<String> getNewAbiList() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(Build.SUPPORTED_ABIS));
        return arrayList;
    }

    private static ArrayList<String> getOldAbiList() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(Build.CPU_ABI);
        arrayList.add(Build.CPU_ABI2);
        return arrayList;
    }

    public static String getOpenAdvertisingTrackingId() {
        return OpenAdvertisingId.getOpenAdvertisingTrackingId();
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static JSONObject getPackageInfo(PackageManager packageManager) throws JSONException, PackageManager.NameNotFoundException {
        String appName = ClientProperties.getAppName();
        PackageInfo packageInfo = packageManager.getPackageInfo(appName, 0);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("installer", packageManager.getInstallerPackageName(appName));
        jSONObject.put("firstInstallTime", packageInfo.firstInstallTime);
        jSONObject.put("lastUpdateTime", packageInfo.lastUpdateTime);
        jSONObject.put("versionCode", packageInfo.versionCode);
        jSONObject.put("versionName", packageInfo.versionName);
        jSONObject.put("packageName", packageInfo.packageName);
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x003a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0032 -> B:28:0x0035). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.lang.String> getProcessInfo() throws java.lang.Throwable {
        /*
            java.lang.String r0 = "Error closing RandomAccessFile"
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r2 = 0
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L20 java.io.IOException -> L22
            java.lang.String r4 = "/proc/self/stat"
            java.lang.String r5 = "r"
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L20 java.io.IOException -> L22
            java.lang.String r2 = r3.readLine()     // Catch: java.io.IOException -> L1e java.lang.Throwable -> L36
            java.lang.String r4 = "stat"
            r1.put(r4, r2)     // Catch: java.io.IOException -> L1e java.lang.Throwable -> L36
            r3.close()     // Catch: java.io.IOException -> L31
            goto L35
        L1e:
            r2 = move-exception
            goto L26
        L20:
            r1 = move-exception
            goto L38
        L22:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
        L26:
            java.lang.String r4 = "Error while reading processor info: "
            com.unity3d.services.core.log.DeviceLog.exception(r4, r2)     // Catch: java.lang.Throwable -> L36
            if (r3 == 0) goto L35
            r3.close()     // Catch: java.io.IOException -> L31
            goto L35
        L31:
            r2 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r0, r2)
        L35:
            return r1
        L36:
            r1 = move-exception
            r2 = r3
        L38:
            if (r2 == 0) goto L42
            r2.close()     // Catch: java.io.IOException -> L3e
            goto L42
        L3e:
            r2 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r0, r2)
        L42:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.device.Device.getProcessInfo():java.util.Map");
    }

    public static String getProduct() {
        return Build.PRODUCT;
    }

    public static int getRingerMode() {
        if (ClientProperties.getApplicationContext() == null) {
            return -1;
        }
        AudioManager audioManager = (AudioManager) ClientProperties.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager != null) {
            return audioManager.getRingerMode();
        }
        return -2;
    }

    public static int getScreenBrightness() {
        if (ClientProperties.getApplicationContext() != null) {
            return Settings.System.getInt(ClientProperties.getApplicationContext().getContentResolver(), "screen_brightness", -1);
        }
        return -1;
    }

    public static int getScreenDensity() {
        if (ClientProperties.getApplicationContext() != null) {
            return ClientProperties.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
        }
        return -1;
    }

    public static int getScreenHeight() {
        if (ClientProperties.getApplicationContext() != null) {
            return ClientProperties.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
        }
        return -1;
    }

    public static int getScreenLayout() {
        if (ClientProperties.getApplicationContext() != null) {
            return ClientProperties.getApplicationContext().getResources().getConfiguration().screenLayout;
        }
        return -1;
    }

    public static int getScreenWidth() {
        if (ClientProperties.getApplicationContext() != null) {
            return ClientProperties.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
        }
        return -1;
    }

    public static List<Sensor> getSensorList() {
        if (ClientProperties.getApplicationContext() != null) {
            return ((SensorManager) ClientProperties.getApplicationContext().getSystemService("sensor")).getSensorList(-1);
        }
        return null;
    }

    public static int getStreamMaxVolume(int i10) {
        if (ClientProperties.getApplicationContext() == null) {
            return -1;
        }
        AudioManager audioManager = (AudioManager) ClientProperties.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(i10);
        }
        return -2;
    }

    public static int getStreamVolume(int i10) {
        if (ClientProperties.getApplicationContext() == null) {
            return -1;
        }
        AudioManager audioManager = (AudioManager) ClientProperties.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager != null) {
            return audioManager.getStreamVolume(i10);
        }
        return -2;
    }

    public static ArrayList<String> getSupportedAbis() {
        return getApiLevel() < 21 ? getOldAbiList() : getNewAbiList();
    }

    public static String getSystemProperty(String str, String str2) {
        return str2 != null ? System.getProperty(str, str2) : System.getProperty(str);
    }

    public static long getTotalMemory() {
        return getMemoryInfo(MemoryInfoType.TOTAL_MEMORY);
    }

    public static long getTotalSpace(File file) {
        if (file == null || !file.exists()) {
            return -1L;
        }
        return Math.round(file.getTotalSpace() / 1024);
    }

    public static String getUniqueEventId() {
        return UUID.randomUUID().toString();
    }

    public static long getUptime() {
        return SystemClock.uptimeMillis();
    }

    public static boolean hasX264Decoder() {
        return selectAllDecodeCodecs(MimeTypes.VIDEO_H264).size() > 0;
    }

    public static boolean hasX265Decoder() {
        return selectAllDecodeCodecs(MimeTypes.VIDEO_H265).size() > 0;
    }

    public static boolean isActiveNetworkConnected() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        return (ClientProperties.getApplicationContext() == null || (connectivityManager = (ConnectivityManager) ClientProperties.getApplicationContext().getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }

    public static Boolean isAdbEnabled() {
        return getApiLevel() < 17 ? oldAdbStatus() : newAdbStatus();
    }

    private static boolean isHardwareAccelerated(MediaCodecInfo mediaCodecInfo, String str) {
        return getApiLevel() >= 29 ? isHardwareAcceleratedV29(mediaCodecInfo) : !isSoftwareOnly(mediaCodecInfo, str);
    }

    @TargetApi(29)
    private static boolean isHardwareAcceleratedV29(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    public static boolean isLimitAdTrackingEnabled() {
        return AdvertisingId.getLimitedAdTracking();
    }

    public static boolean isLimitOpenAdTrackingEnabled() {
        return OpenAdvertisingId.getLimitedOpenAdTracking();
    }

    public static boolean isRooted() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            return searchPathForBinary("su");
        } catch (Exception e10) {
            DeviceLog.exception("Rooted check failed", e10);
            return false;
        }
    }

    private static boolean isSoftwareOnly(MediaCodecInfo mediaCodecInfo, String str) {
        if (getApiLevel() >= 29) {
            return isSoftwareOnlyV29(mediaCodecInfo);
        }
        String lowerCase = mediaCodecInfo.getName().toLowerCase();
        if (lowerCase.startsWith("arc.")) {
            return false;
        }
        return lowerCase.startsWith("omx.google.") || lowerCase.startsWith("omx.ffmpeg.") || (lowerCase.startsWith("omx.sec.") && lowerCase.contains(".sw.")) || lowerCase.equals("omx.qcom.video.decoder.hevcswvdec") || lowerCase.startsWith("c2.android.") || lowerCase.startsWith("c2.google.") || !(lowerCase.startsWith("omx.") || lowerCase.startsWith("c2."));
    }

    @TargetApi(29)
    private static boolean isSoftwareOnlyV29(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    public static boolean isUSBConnected() {
        Intent intentRegisterReceiver;
        if (ClientProperties.getApplicationContext() == null || (intentRegisterReceiver = ClientProperties.getApplicationContext().registerReceiver(null, new IntentFilter("android.hardware.usb.action.USB_STATE"))) == null) {
            return false;
        }
        return intentRegisterReceiver.getBooleanExtra("connected", false);
    }

    public static boolean isUsingWifi() {
        ConnectivityManager connectivityManager;
        if (ClientProperties.getApplicationContext() == null || (connectivityManager = (ConnectivityManager) ClientProperties.getApplicationContext().getSystemService("connectivity")) == null) {
            return false;
        }
        TelephonyManager telephonyManager = (TelephonyManager) ClientProperties.getApplicationContext().getSystemService("phone");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && connectivityManager.getBackgroundDataSetting() && connectivityManager.getActiveNetworkInfo().isConnected() && telephonyManager != null && activeNetworkInfo.getType() == 1 && activeNetworkInfo.isConnected();
    }

    public static boolean isWiredHeadsetOn() {
        if (ClientProperties.getApplicationContext() != null) {
            return ((AudioManager) ClientProperties.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO)).isWiredHeadsetOn();
        }
        return false;
    }

    @TargetApi(17)
    private static Boolean newAdbStatus() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            return Boolean.valueOf(1 == Settings.Global.getInt(ClientProperties.getApplicationContext().getContentResolver(), "adb_enabled", 0));
        } catch (Exception e10) {
            DeviceLog.exception("Problems fetching adb enabled status", e10);
            return null;
        }
    }

    private static Boolean oldAdbStatus() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            return Boolean.valueOf(1 == Settings.Secure.getInt(ClientProperties.getApplicationContext().getContentResolver(), "adb_enabled", 0));
        } catch (Exception e10) {
            DeviceLog.exception("Problems fetching adb enabled status", e10);
            return null;
        }
    }

    private static boolean searchPathForBinary(String str) {
        File[] fileArrListFiles;
        for (String str2 : System.getenv("PATH").split(":")) {
            File file = new File(str2);
            if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.getName().equals(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static List<MediaCodecInfo> selectAllDecodeCodecs(String str) {
        ArrayList arrayList = new ArrayList();
        int codecCount = MediaCodecList.getCodecCount();
        for (int i10 = 0; i10 < codecCount; i10++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i10);
            if (!codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str) && isHardwareAccelerated(codecInfoAt, str)) {
                        arrayList.add(codecInfoAt);
                    }
                }
            }
        }
        return arrayList;
    }
}
