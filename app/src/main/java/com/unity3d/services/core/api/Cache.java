package com.unity3d.services.core.api;

import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import android.util.Base64;
import android.util.SparseArray;
import com.unity3d.services.core.cache.CacheDirectory;
import com.unity3d.services.core.cache.CacheDirectoryType;
import com.unity3d.services.core.cache.CacheError;
import com.unity3d.services.core.cache.CacheThread;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.WebRequestError;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Cache {
    @WebViewExposed
    public static void deleteFile(String str, WebViewCallback webViewCallback) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (new File(fileIdToFilename(str)).delete()) {
            webViewCallback.invoke(new Object[0]);
        } else {
            webViewCallback.error(CacheError.FILE_IO_ERROR, new Object[0]);
        }
    }

    @WebViewExposed
    public static void download(String str, String str2, JSONArray jSONArray, Boolean bool, WebViewCallback webViewCallback) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (CacheThread.isActive()) {
            webViewCallback.error(CacheError.FILE_ALREADY_CACHING, new Object[0]);
            return;
        }
        if (!Device.isActiveNetworkConnected()) {
            webViewCallback.error(CacheError.NO_INTERNET, new Object[0]);
            return;
        }
        try {
            CacheThread.download(str, fileIdToFilename(str2), Request.getHeadersMap(jSONArray), bool.booleanValue(), SharedInstances.INSTANCE.getWebViewEventSender());
            webViewCallback.invoke(new Object[0]);
        } catch (Exception e10) {
            DeviceLog.exception("Error mapping headers for the request", e10);
            webViewCallback.error(WebRequestError.MAPPING_HEADERS_FAILED, str, str2);
        }
    }

    private static String fileIdToFilename(String str) {
        if (SdkProperties.getCacheDirectory() == null) {
            return "";
        }
        return SdkProperties.getCacheDirectory() + "/" + SdkProperties.getCacheFilePrefix() + str;
    }

    @WebViewExposed
    public static void getCacheDirectoryExists(WebViewCallback webViewCallback) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        File cacheDirectory = SdkProperties.getCacheDirectory();
        if (cacheDirectory == null) {
            webViewCallback.error(CacheError.CACHE_DIRECTORY_NULL, new Object[0]);
        } else {
            webViewCallback.invoke(Boolean.valueOf(cacheDirectory.exists()));
        }
    }

    @WebViewExposed
    public static void getCacheDirectoryType(WebViewCallback webViewCallback) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        CacheDirectory cacheDirectoryObject = SdkProperties.getCacheDirectoryObject();
        if (cacheDirectoryObject == null || cacheDirectoryObject.getCacheDirectory(ClientProperties.getApplicationContext()) == null) {
            webViewCallback.error(CacheError.CACHE_DIRECTORY_NULL, new Object[0]);
            return;
        }
        if (!cacheDirectoryObject.getCacheDirectory(ClientProperties.getApplicationContext()).exists()) {
            webViewCallback.error(CacheError.CACHE_DIRECTORY_DOESNT_EXIST, new Object[0]);
            return;
        }
        CacheDirectoryType type = cacheDirectoryObject.getType();
        if (type == null) {
            webViewCallback.error(CacheError.CACHE_DIRECTORY_TYPE_NULL, new Object[0]);
        } else {
            webViewCallback.invoke(type.name());
        }
    }

    @WebViewExposed
    public static void getFileContent(String str, String str2, WebViewCallback webViewCallback) throws Throwable {
        Object objEncodeToString;
        String strFileIdToFilename = fileIdToFilename(str);
        File file = new File(strFileIdToFilename);
        if (!file.exists()) {
            webViewCallback.error(CacheError.FILE_NOT_FOUND, str, strFileIdToFilename);
            return;
        }
        try {
            byte[] fileBytes = Utilities.readFileBytes(file);
            if (str2 == null) {
                webViewCallback.error(CacheError.UNSUPPORTED_ENCODING, str, strFileIdToFilename, str2);
                return;
            }
            if (str2.equals("UTF-8")) {
                objEncodeToString = Charset.forName("UTF-8").decode(ByteBuffer.wrap(fileBytes)).toString();
            } else {
                if (!str2.equals("Base64")) {
                    webViewCallback.error(CacheError.UNSUPPORTED_ENCODING, str, strFileIdToFilename, str2);
                    return;
                }
                objEncodeToString = Base64.encodeToString(fileBytes, 2);
            }
            webViewCallback.invoke(objEncodeToString);
        } catch (IOException e10) {
            webViewCallback.error(CacheError.FILE_IO_ERROR, str, strFileIdToFilename, e10.getMessage() + ", " + e10.getClass().getName());
        }
    }

    @WebViewExposed
    public static void getFileInfo(String str, WebViewCallback webViewCallback) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            webViewCallback.invoke(getFileJson(str));
        } catch (JSONException e10) {
            DeviceLog.exception("Error creating JSON", e10);
            webViewCallback.error(CacheError.JSON_ERROR, new Object[0]);
        }
    }

    private static JSONObject getFileJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", str);
        File file = new File(fileIdToFilename(str));
        if (file.exists()) {
            jSONObject.put("found", true);
            jSONObject.put("size", file.length());
            jSONObject.put("mtime", file.lastModified());
        } else {
            jSONObject.put("found", false);
        }
        return jSONObject;
    }

    @WebViewExposed
    public static void getFilePath(String str, WebViewCallback webViewCallback) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (new File(fileIdToFilename(str)).exists()) {
            webViewCallback.invoke(fileIdToFilename(str));
        } else {
            webViewCallback.error(CacheError.FILE_NOT_FOUND, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getFiles(WebViewCallback webViewCallback) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        File cacheDirectory = SdkProperties.getCacheDirectory();
        if (cacheDirectory == null) {
            return;
        }
        DeviceLog.debug("Unity Ads cache: checking app directory for Unity Ads cached files");
        File[] fileArrListFiles = cacheDirectory.listFiles(new FilenameFilter() { // from class: com.unity3d.services.core.api.Cache.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.startsWith(SdkProperties.getCacheFilePrefix());
            }
        });
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            webViewCallback.invoke(new JSONArray());
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (File file : fileArrListFiles) {
                String strSubstring = file.getName().substring(SdkProperties.getCacheFilePrefix().length());
                DeviceLog.debug("Unity Ads cache: found " + strSubstring + ", " + file.length() + " bytes");
                jSONArray.put(getFileJson(strSubstring));
            }
            webViewCallback.invoke(jSONArray);
        } catch (JSONException e10) {
            DeviceLog.exception("Error creating JSON", e10);
            webViewCallback.error(CacheError.JSON_ERROR, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getFreeSpace(WebViewCallback webViewCallback) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        webViewCallback.invoke(Long.valueOf(Device.getFreeSpace(SdkProperties.getCacheDirectory())));
    }

    @WebViewExposed
    public static void getHash(String str, WebViewCallback webViewCallback) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        webViewCallback.invoke(Utilities.Sha256(str));
    }

    @WebViewExposed
    public static void getMetaData(String str, JSONArray jSONArray, WebViewCallback webViewCallback) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            SparseArray<String> metaData = getMetaData(fileIdToFilename(str), jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (int i10 = 0; i10 < metaData.size(); i10++) {
                JSONArray jSONArray3 = new JSONArray();
                jSONArray3.put(metaData.keyAt(i10));
                jSONArray3.put(metaData.valueAt(i10));
                jSONArray2.put(jSONArray3);
            }
            webViewCallback.invoke(jSONArray2);
        } catch (IOException e10) {
            webViewCallback.error(CacheError.FILE_IO_ERROR, e10.getMessage());
        } catch (RuntimeException e11) {
            webViewCallback.error(CacheError.INVALID_ARGUMENT, e11.getMessage());
        } catch (JSONException e12) {
            webViewCallback.error(CacheError.JSON_ERROR, e12.getMessage());
        }
    }

    @WebViewExposed
    public static void getProgressInterval(WebViewCallback webViewCallback) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        webViewCallback.invoke(Integer.valueOf(CacheThread.getProgressInterval()));
    }

    @WebViewExposed
    public static void getTimeouts(WebViewCallback webViewCallback) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        webViewCallback.invoke(Integer.valueOf(CacheThread.getConnectTimeout()), Integer.valueOf(CacheThread.getReadTimeout()));
    }

    @WebViewExposed
    public static void getTotalSpace(WebViewCallback webViewCallback) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        webViewCallback.invoke(Long.valueOf(Device.getTotalSpace(SdkProperties.getCacheDirectory())));
    }

    @WebViewExposed
    public static void isCaching(WebViewCallback webViewCallback) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        webViewCallback.invoke(Boolean.valueOf(CacheThread.isActive()));
    }

    @WebViewExposed
    public static void recreateCacheDirectory(WebViewCallback webViewCallback) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (SdkProperties.getCacheDirectory().exists()) {
            webViewCallback.error(CacheError.CACHE_DIRECTORY_EXISTS, new Object[0]);
            return;
        }
        SdkProperties.setCacheDirectory(null);
        if (SdkProperties.getCacheDirectory() == null) {
            webViewCallback.error(CacheError.CACHE_DIRECTORY_NULL, new Object[0]);
        } else {
            webViewCallback.invoke(new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    @com.unity3d.services.core.webview.bridge.WebViewExposed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void setFileContent(java.lang.String r9, java.lang.String r10, java.lang.String r11, com.unity3d.services.core.webview.bridge.WebViewCallback r12) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = "Error closing FileOutputStream"
            java.lang.String r2 = fileIdToFilename(r9)
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            byte[] r7 = r11.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L96
            if (r10 == 0) goto L3a
            int r8 = r10.length()
            if (r8 <= 0) goto L3a
            java.lang.String r8 = "Base64"
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto L25
            byte[] r7 = android.util.Base64.decode(r11, r4)
            goto L3a
        L25:
            boolean r11 = r10.equals(r0)
            if (r11 == 0) goto L2c
            goto L3a
        L2c:
            com.unity3d.services.core.cache.CacheError r11 = com.unity3d.services.core.cache.CacheError.UNSUPPORTED_ENCODING
            java.lang.Object[] r0 = new java.lang.Object[r3]
            r0[r6] = r9
            r0[r5] = r2
            r0[r4] = r10
            r12.error(r11, r0)
            return
        L3a:
            r11 = 0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58 java.io.FileNotFoundException -> L6b
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58 java.io.FileNotFoundException -> L6b
            r0.write(r7)     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L52 java.io.FileNotFoundException -> L54
            r0.flush()     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L52 java.io.FileNotFoundException -> L54
            r0.close()     // Catch: java.lang.Exception -> L4a
            goto L83
        L4a:
            r9 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r1, r9)
            goto L83
        L4f:
            r9 = move-exception
            r11 = r0
            goto L8b
        L52:
            r11 = r0
            goto L58
        L54:
            r11 = r0
            goto L6b
        L56:
            r9 = move-exception
            goto L8b
        L58:
            com.unity3d.services.core.cache.CacheError r0 = com.unity3d.services.core.cache.CacheError.FILE_IO_ERROR     // Catch: java.lang.Throwable -> L56
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L56
            r3[r6] = r9     // Catch: java.lang.Throwable -> L56
            r3[r5] = r2     // Catch: java.lang.Throwable -> L56
            r3[r4] = r10     // Catch: java.lang.Throwable -> L56
            r12.error(r0, r3)     // Catch: java.lang.Throwable -> L56
            if (r11 == 0) goto L82
            r11.close()     // Catch: java.lang.Exception -> L7e
            goto L82
        L6b:
            com.unity3d.services.core.cache.CacheError r0 = com.unity3d.services.core.cache.CacheError.FILE_NOT_FOUND     // Catch: java.lang.Throwable -> L56
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L56
            r3[r6] = r9     // Catch: java.lang.Throwable -> L56
            r3[r5] = r2     // Catch: java.lang.Throwable -> L56
            r3[r4] = r10     // Catch: java.lang.Throwable -> L56
            r12.error(r0, r3)     // Catch: java.lang.Throwable -> L56
            if (r11 == 0) goto L82
            r11.close()     // Catch: java.lang.Exception -> L7e
            goto L82
        L7e:
            r9 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r1, r9)
        L82:
            r5 = 0
        L83:
            if (r5 == 0) goto L8a
            java.lang.Object[] r9 = new java.lang.Object[r6]
            r12.invoke(r9)
        L8a:
            return
        L8b:
            if (r11 == 0) goto L95
            r11.close()     // Catch: java.lang.Exception -> L91
            goto L95
        L91:
            r10 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r1, r10)
        L95:
            throw r9
        L96:
            com.unity3d.services.core.cache.CacheError r11 = com.unity3d.services.core.cache.CacheError.UNSUPPORTED_ENCODING
            java.lang.Object[] r0 = new java.lang.Object[r3]
            r0[r6] = r9
            r0[r5] = r2
            r0[r4] = r10
            r12.error(r11, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.api.Cache.setFileContent(java.lang.String, java.lang.String, java.lang.String, com.unity3d.services.core.webview.bridge.WebViewCallback):void");
    }

    @WebViewExposed
    public static void setProgressInterval(Integer num, WebViewCallback webViewCallback) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        CacheThread.setProgressInterval(num.intValue());
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void setTimeouts(Integer num, Integer num2, WebViewCallback webViewCallback) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        CacheThread.setConnectTimeout(num.intValue());
        CacheThread.setReadTimeout(num2.intValue());
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void stop(WebViewCallback webViewCallback) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (!CacheThread.isActive()) {
            webViewCallback.error(CacheError.NOT_CACHING, new Object[0]);
        } else {
            CacheThread.cancel();
            webViewCallback.invoke(new Object[0]);
        }
    }

    @TargetApi(10)
    private static SparseArray<String> getMetaData(String str, JSONArray jSONArray) throws JSONException, IOException, RuntimeException {
        File file = new File(str);
        SparseArray<String> sparseArray = new SparseArray<>();
        if (file.exists()) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(file.getAbsolutePath());
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                int i11 = jSONArray.getInt(i10);
                String strExtractMetadata = mediaMetadataRetriever.extractMetadata(i11);
                if (strExtractMetadata != null) {
                    sparseArray.put(i11, strExtractMetadata);
                }
            }
            return sparseArray;
        }
        throw new IOException("File: " + file.getAbsolutePath() + " doesn't exist");
    }
}
