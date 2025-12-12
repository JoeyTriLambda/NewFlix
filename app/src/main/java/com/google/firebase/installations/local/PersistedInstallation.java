package com.google.firebase.installations.local;

import g8.f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import okhttp3.internal.http2.Http2;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class PersistedInstallation {

    /* renamed from: a, reason: collision with root package name */
    public File f9815a;

    /* renamed from: b, reason: collision with root package name */
    public final f f9816b;

    public enum RegistrationStatus {
        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR
    }

    public PersistedInstallation(f fVar) {
        this.f9816b = fVar;
    }

    public final File a() {
        if (this.f9815a == null) {
            synchronized (this) {
                if (this.f9815a == null) {
                    this.f9815a = new File(this.f9816b.getApplicationContext().getFilesDir(), "PersistedInstallation." + this.f9816b.getPersistenceKey() + ".json");
                }
            }
        }
        return this.f9815a;
    }

    public b insertOrUpdatePersistedInstallationEntry(b bVar) throws JSONException, IOException {
        File fileCreateTempFile;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", bVar.getFirebaseInstallationId());
            jSONObject.put("Status", bVar.getRegistrationStatus().ordinal());
            jSONObject.put("AuthToken", bVar.getAuthToken());
            jSONObject.put("RefreshToken", bVar.getRefreshToken());
            jSONObject.put("TokenCreationEpochInSecs", bVar.getTokenCreationEpochInSecs());
            jSONObject.put("ExpiresInSecs", bVar.getExpiresInSecs());
            jSONObject.put("FisError", bVar.getFisError());
            fileCreateTempFile = File.createTempFile("PersistedInstallation", "tmp", this.f9816b.getApplicationContext().getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
        } catch (IOException | JSONException unused) {
        }
        if (fileCreateTempFile.renameTo(a())) {
            return bVar;
        }
        throw new IOException("unable to rename the tmpfile to PersistedInstallation");
    }

    public b readPersistedInstallationEntryValue() throws IOException {
        JSONObject jSONObject;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
        try {
            FileInputStream fileInputStream = new FileInputStream(a());
            while (true) {
                try {
                    int i10 = fileInputStream.read(bArr, 0, Http2.INITIAL_MAX_FRAME_SIZE);
                    if (i10 < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i10);
                } catch (Throwable th2) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
            jSONObject = new JSONObject(byteArrayOutputStream.toString());
            fileInputStream.close();
        } catch (IOException | JSONException unused) {
            jSONObject = new JSONObject();
        }
        String strOptString = jSONObject.optString("Fid", null);
        int iOptInt = jSONObject.optInt("Status", 0);
        String strOptString2 = jSONObject.optString("AuthToken", null);
        String strOptString3 = jSONObject.optString("RefreshToken", null);
        long jOptLong = jSONObject.optLong("TokenCreationEpochInSecs", 0L);
        long jOptLong2 = jSONObject.optLong("ExpiresInSecs", 0L);
        return b.builder().setFirebaseInstallationId(strOptString).setRegistrationStatus(RegistrationStatus.values()[iOptInt]).setAuthToken(strOptString2).setRefreshToken(strOptString3).setTokenCreationEpochInSecs(jOptLong).setExpiresInSecs(jOptLong2).setFisError(jSONObject.optString("FisError", null)).build();
    }
}
