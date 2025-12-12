package y8;

import android.text.TextUtils;
import com.unity3d.services.core.request.metrics.MetricCommonTags;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import r8.h0;
import r8.w;

/* compiled from: DefaultSettingsSpiCall.java */
/* loaded from: classes.dex */
public final class c implements i {

    /* renamed from: a, reason: collision with root package name */
    public final String f22019a;

    /* renamed from: b, reason: collision with root package name */
    public final v8.b f22020b;

    /* renamed from: c, reason: collision with root package name */
    public final o8.e f22021c;

    public c(String str, v8.b bVar) {
        o8.e logger = o8.e.getLogger();
        if (str == null) {
            throw new IllegalArgumentException("url must not be null.");
        }
        this.f22021c = logger;
        this.f22020b = bVar;
        this.f22019a = str;
    }

    public static void a(v8.a aVar, h hVar) {
        b(aVar, "X-CRASHLYTICS-GOOGLE-APP-ID", hVar.f22034a);
        b(aVar, "X-CRASHLYTICS-API-CLIENT-TYPE", MetricCommonTags.METRIC_COMMON_TAG_PLATFORM_ANDROID);
        b(aVar, "X-CRASHLYTICS-API-CLIENT-VERSION", w.getVersion());
        b(aVar, "Accept", "application/json");
        b(aVar, "X-CRASHLYTICS-DEVICE-MODEL", hVar.f22035b);
        b(aVar, "X-CRASHLYTICS-OS-BUILD-VERSION", hVar.f22036c);
        b(aVar, "X-CRASHLYTICS-OS-DISPLAY-VERSION", hVar.f22037d);
        b(aVar, "X-CRASHLYTICS-INSTALLATION-ID", ((h0) hVar.f22038e).getInstallIds().getCrashlyticsInstallId());
    }

    public static void b(v8.a aVar, String str, String str2) {
        if (str2 != null) {
            aVar.header(str, str2);
        }
    }

    public static HashMap c(h hVar) {
        HashMap map = new HashMap();
        map.put("build_version", hVar.f22041h);
        map.put("display_version", hVar.f22040g);
        map.put("source", Integer.toString(hVar.f22042i));
        String str = hVar.f22039f;
        if (!TextUtils.isEmpty(str)) {
            map.put("instance", str);
        }
        return map;
    }

    public v8.a createHttpGetRequest(Map<String, String> map) {
        return this.f22020b.buildHttpGetRequest(this.f22019a, map).header("User-Agent", "Crashlytics Android SDK/" + w.getVersion()).header("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    public final JSONObject d(v8.c cVar) {
        int iCode = cVar.code();
        String strF = ac.c.f("Settings response code was: ", iCode);
        o8.e eVar = this.f22021c;
        eVar.v(strF);
        boolean z10 = iCode == 200 || iCode == 201 || iCode == 202 || iCode == 203;
        String str = this.f22019a;
        if (!z10) {
            eVar.e("Settings request failed; (status: " + iCode + ") from " + str);
            return null;
        }
        String strBody = cVar.body();
        try {
            return new JSONObject(strBody);
        } catch (Exception e10) {
            eVar.w("Failed to parse settings JSON from " + str, e10);
            eVar.w("Settings response " + strBody);
            return null;
        }
    }

    public JSONObject invoke(h hVar, boolean z10) {
        o8.e eVar = this.f22021c;
        if (!z10) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        try {
            HashMap mapC = c(hVar);
            v8.a aVarCreateHttpGetRequest = createHttpGetRequest(mapC);
            a(aVarCreateHttpGetRequest, hVar);
            eVar.d("Requesting settings from " + this.f22019a);
            eVar.v("Settings query params were: " + mapC);
            return d(aVarCreateHttpGetRequest.execute());
        } catch (IOException e10) {
            eVar.e("Settings request failed.", e10);
            return null;
        }
    }
}
