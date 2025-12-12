package com.google.firebase.installations.remote;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import com.loopj.android.http.AsyncHttpClient;
import com.unity3d.ads.metadata.MediationMetaData;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import g9.f;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FirebaseInstallationServiceClient.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f9860d = Pattern.compile("[0-9]+s");

    /* renamed from: e, reason: collision with root package name */
    public static final Charset f9861e = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final Context f9862a;

    /* renamed from: b, reason: collision with root package name */
    public final h9.b<f> f9863b;

    /* renamed from: c, reason: collision with root package name */
    public final l9.a f9864c = new l9.a();

    public c(Context context, h9.b<f> bVar) {
        this.f9862a = context;
        this.f9863b = bVar;
    }

    public static URL a(String str) throws FirebaseInstallationsException {
        try {
            return new URL(String.format("https://%s/%s/%s", "firebaseinstallations.googleapis.com", "v1", str));
        } catch (MalformedURLException e10) {
            throw new FirebaseInstallationsException(e10.getMessage(), FirebaseInstallationsException.Status.UNAVAILABLE);
        }
    }

    public static void b(HttpURLConnection httpURLConnection, String str, String str2, String str3) throws IOException {
        InputStream errorStream = httpURLConnection.getErrorStream();
        String str4 = null;
        if (errorStream != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, f9861e));
            try {
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb2.append(line);
                    sb2.append('\n');
                }
                str4 = String.format("Error when communicating with the Firebase Installations server API. HTTP response: [%d %s: %s]", Integer.valueOf(httpURLConnection.getResponseCode()), httpURLConnection.getResponseMessage(), sb2);
            } catch (IOException unused) {
            } catch (Throwable th2) {
                try {
                    bufferedReader.close();
                } catch (IOException unused2) {
                }
                throw th2;
            }
            try {
                bufferedReader.close();
            } catch (IOException unused3) {
            }
        }
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        Log.w("Firebase-Installations", str4);
        Object[] objArr = new Object[3];
        objArr[0] = str2;
        objArr[1] = str3;
        objArr[2] = TextUtils.isEmpty(str) ? "" : ac.c.j(", ", str);
        Log.w("Firebase-Installations", String.format("Firebase options used while communicating with Firebase server APIs: %s, %s%s", objArr));
    }

    @VisibleForTesting
    public static long d(String str) {
        Preconditions.checkArgument(f9860d.matcher(str).matches(), "Invalid Expiration Timestamp.");
        if (str == null || str.length() == 0) {
            return 0L;
        }
        return Long.parseLong(str.substring(0, str.length() - 1));
    }

    public static InstallationResponse e(HttpURLConnection httpURLConnection) throws IOException, AssertionError {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f9861e));
        TokenResult.a aVarBuilder = TokenResult.builder();
        InstallationResponse.a aVarBuilder2 = InstallationResponse.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals(MediationMetaData.KEY_NAME)) {
                aVarBuilder2.setUri(jsonReader.nextString());
            } else if (strNextName.equals("fid")) {
                aVarBuilder2.setFid(jsonReader.nextString());
            } else if (strNextName.equals("refreshToken")) {
                aVarBuilder2.setRefreshToken(jsonReader.nextString());
            } else if (strNextName.equals("authToken")) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    if (strNextName2.equals("token")) {
                        aVarBuilder.setToken(jsonReader.nextString());
                    } else if (strNextName2.equals("expiresIn")) {
                        aVarBuilder.setTokenExpirationTimestamp(d(jsonReader.nextString()));
                    } else {
                        jsonReader.skipValue();
                    }
                }
                aVarBuilder2.setAuthToken(aVarBuilder.build());
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return aVarBuilder2.setResponseCode(InstallationResponse.ResponseCode.OK).build();
    }

    public static TokenResult f(HttpURLConnection httpURLConnection) throws IOException, AssertionError {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f9861e));
        TokenResult.a aVarBuilder = TokenResult.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals("token")) {
                aVarBuilder.setToken(jsonReader.nextString());
            } else if (strNextName.equals("expiresIn")) {
                aVarBuilder.setTokenExpirationTimestamp(d(jsonReader.nextString()));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return aVarBuilder.setResponseCode(TokenResult.ResponseCode.OK).build();
    }

    public static void g(HttpURLConnection httpURLConnection, String str, String str2) throws JSONException, IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fid", str);
            jSONObject.put("appId", str2);
            jSONObject.put("authVersion", "FIS_v2");
            jSONObject.put("sdkVersion", "a:17.2.0");
            i(httpURLConnection, jSONObject.toString().getBytes("UTF-8"));
        } catch (JSONException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static void h(HttpURLConnection httpURLConnection) throws JSONException, IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sdkVersion", "a:17.2.0");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("installation", jSONObject);
            i(httpURLConnection, jSONObject2.toString().getBytes("UTF-8"));
        } catch (JSONException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static void i(URLConnection uRLConnection, byte[] bArr) throws IOException {
        OutputStream outputStream = uRLConnection.getOutputStream();
        if (outputStream == null) {
            throw new IOException("Cannot send request to FIS servers. No OutputStream available.");
        }
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        try {
            gZIPOutputStream.write(bArr);
        } finally {
            try {
                gZIPOutputStream.close();
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public final HttpURLConnection c(URL url, String str) throws FirebaseInstallationsException {
        String strBytesToStringUppercase;
        byte[] packageCertificateHashBytes;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setReadTimeout(AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT);
            httpURLConnection.addRequestProperty("Content-Type", "application/json");
            httpURLConnection.addRequestProperty("Accept", "application/json");
            httpURLConnection.addRequestProperty("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
            httpURLConnection.addRequestProperty("Cache-Control", HeaderConstants.CACHE_CONTROL_NO_CACHE);
            Context context = this.f9862a;
            httpURLConnection.addRequestProperty("X-Android-Package", context.getPackageName());
            f fVar = this.f9863b.get();
            if (fVar != null) {
                try {
                    httpURLConnection.addRequestProperty("x-firebase-client", (String) Tasks.await(fVar.getHeartBeatsHeader()));
                } catch (InterruptedException e10) {
                    Thread.currentThread().interrupt();
                    Log.w("ContentValues", "Failed to get heartbeats header", e10);
                } catch (ExecutionException e11) {
                    Log.w("ContentValues", "Failed to get heartbeats header", e11);
                }
            }
            try {
                packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, context.getPackageName());
            } catch (PackageManager.NameNotFoundException e12) {
                Log.e("ContentValues", "No such package: " + context.getPackageName(), e12);
            }
            if (packageCertificateHashBytes != null) {
                strBytesToStringUppercase = Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
                httpURLConnection.addRequestProperty("X-Android-Cert", strBytesToStringUppercase);
                httpURLConnection.addRequestProperty("x-goog-api-key", str);
                return httpURLConnection;
            }
            Log.e("ContentValues", "Could not get fingerprint hash for package: " + context.getPackageName());
            strBytesToStringUppercase = null;
            httpURLConnection.addRequestProperty("X-Android-Cert", strBytesToStringUppercase);
            httpURLConnection.addRequestProperty("x-goog-api-key", str);
            return httpURLConnection;
        } catch (IOException unused) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v3 */
    public InstallationResponse createFirebaseInstallation(String str, String str2, String str3, String str4, String str5) throws FirebaseInstallationsException {
        int responseCode;
        InstallationResponse installationResponseE;
        l9.a aVar = this.f9864c;
        boolean zIsRequestAllowed = aVar.isRequestAllowed();
        FirebaseInstallationsException.Status status = FirebaseInstallationsException.Status.UNAVAILABLE;
        if (!zIsRequestAllowed) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", status);
        }
        URL urlA = a(String.format("projects/%s/installations", str3));
        int i10 = 0;
        for (?? r62 = 1; i10 <= r62; r62 = 1) {
            TrafficStats.setThreadStatsTag(32769);
            HttpURLConnection httpURLConnectionC = c(urlA, str);
            try {
                try {
                    httpURLConnectionC.setRequestMethod("POST");
                    httpURLConnectionC.setDoOutput(r62);
                    if (str5 != null) {
                        httpURLConnectionC.addRequestProperty("x-goog-fis-android-iid-migration-auth", str5);
                    }
                    try {
                        g(httpURLConnectionC, str2, str4);
                        responseCode = httpURLConnectionC.getResponseCode();
                        aVar.setNextRequestTime(responseCode);
                    } catch (IOException | AssertionError unused) {
                        continue;
                    }
                } catch (IOException | AssertionError unused2) {
                }
                if (responseCode >= 200 && responseCode < 300) {
                    installationResponseE = e(httpURLConnectionC);
                } else {
                    b(httpURLConnectionC, str4, str, str3);
                    if (responseCode == 429) {
                        throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", FirebaseInstallationsException.Status.TOO_MANY_REQUESTS);
                    }
                    if (responseCode < 500 || responseCode >= 600) {
                        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                        installationResponseE = InstallationResponse.builder().setResponseCode(InstallationResponse.ResponseCode.BAD_CONFIG).build();
                    } else {
                        httpURLConnectionC.disconnect();
                        TrafficStats.clearThreadStatsTag();
                        i10++;
                    }
                }
                return installationResponseE;
            } finally {
                httpURLConnectionC.disconnect();
                TrafficStats.clearThreadStatsTag();
            }
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", status);
    }

    public TokenResult generateAuthToken(String str, String str2, String str3, String str4) throws FirebaseInstallationsException {
        int responseCode;
        TokenResult tokenResultF;
        l9.a aVar = this.f9864c;
        boolean zIsRequestAllowed = aVar.isRequestAllowed();
        FirebaseInstallationsException.Status status = FirebaseInstallationsException.Status.UNAVAILABLE;
        if (!zIsRequestAllowed) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", status);
        }
        URL urlA = a(String.format("projects/%s/installations/%s/authTokens:generate", str3, str2));
        for (int i10 = 0; i10 <= 1; i10++) {
            TrafficStats.setThreadStatsTag(32771);
            HttpURLConnection httpURLConnectionC = c(urlA, str);
            try {
                httpURLConnectionC.setRequestMethod("POST");
                httpURLConnectionC.addRequestProperty("Authorization", "FIS_v2 " + str4);
                httpURLConnectionC.setDoOutput(true);
                h(httpURLConnectionC);
                responseCode = httpURLConnectionC.getResponseCode();
                aVar.setNextRequestTime(responseCode);
            } catch (IOException | AssertionError unused) {
            } catch (Throwable th2) {
                httpURLConnectionC.disconnect();
                TrafficStats.clearThreadStatsTag();
                throw th2;
            }
            if (responseCode >= 200 && responseCode < 300) {
                tokenResultF = f(httpURLConnectionC);
            } else {
                b(httpURLConnectionC, null, str, str3);
                if (responseCode == 401 || responseCode == 404) {
                    tokenResultF = TokenResult.builder().setResponseCode(TokenResult.ResponseCode.AUTH_ERROR).build();
                } else {
                    if (responseCode == 429) {
                        throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", FirebaseInstallationsException.Status.TOO_MANY_REQUESTS);
                    }
                    if (responseCode < 500 || responseCode >= 600) {
                        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                        tokenResultF = TokenResult.builder().setResponseCode(TokenResult.ResponseCode.BAD_CONFIG).build();
                    } else {
                        httpURLConnectionC.disconnect();
                        TrafficStats.clearThreadStatsTag();
                    }
                }
            }
            httpURLConnectionC.disconnect();
            TrafficStats.clearThreadStatsTag();
            return tokenResultF;
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", status);
    }
}
