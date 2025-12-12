package y8;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;

/* compiled from: CachedSettingsIo.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final File f22018a;

    public a(w8.b bVar) {
        this.f22018a = bVar.getCommonFile("com.crashlytics.settings.json");
    }

    public JSONObject readCachedSettings() throws Throwable {
        Throwable th2;
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        o8.e.getLogger().d("Checking for cached settings...");
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File file = this.f22018a;
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        jSONObject = new JSONObject(CommonUtils.streamToString(fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e10) {
                        e = e10;
                        o8.e.getLogger().e("Failed to fetch cached settings", e);
                        CommonUtils.closeOrLog(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } else {
                    o8.e.getLogger().v("Settings file does not exist.");
                    jSONObject = null;
                }
                CommonUtils.closeOrLog(fileInputStream2, "Error while closing settings cache file.");
                return jSONObject;
            } catch (Exception e11) {
                e = e11;
                fileInputStream = null;
            } catch (Throwable th3) {
                th2 = th3;
                CommonUtils.closeOrLog(null, "Error while closing settings cache file.");
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            CommonUtils.closeOrLog(null, "Error while closing settings cache file.");
            throw th2;
        }
    }

    public void writeCachedSettings(long j10, JSONObject jSONObject) throws Throwable {
        o8.e.getLogger().v("Writing settings to cache file...");
        if (jSONObject == null) {
            return;
        }
        FileWriter fileWriter = null;
        try {
            try {
                jSONObject.put("expires_at", j10);
                FileWriter fileWriter2 = new FileWriter(this.f22018a);
                try {
                    fileWriter2.write(jSONObject.toString());
                    fileWriter2.flush();
                    CommonUtils.closeOrLog(fileWriter2, "Failed to close settings writer.");
                } catch (Exception e10) {
                    e = e10;
                    fileWriter = fileWriter2;
                    o8.e.getLogger().e("Failed to cache settings", e);
                    CommonUtils.closeOrLog(fileWriter, "Failed to close settings writer.");
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter = fileWriter2;
                    CommonUtils.closeOrLog(fileWriter, "Failed to close settings writer.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }
}
