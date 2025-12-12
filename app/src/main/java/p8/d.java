package p8;

import android.os.Bundle;
import com.unity3d.ads.metadata.MediationMetaData;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BreadcrumbAnalyticsEventReceiver.java */
/* loaded from: classes.dex */
public final class d implements b, q8.b {

    /* renamed from: b, reason: collision with root package name */
    public q8.a f17643b;

    public static String a(Bundle bundle, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put(MediationMetaData.KEY_NAME, str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    @Override // p8.b
    public void onEvent(String str, Bundle bundle) {
        q8.a aVar = this.f17643b;
        if (aVar != null) {
            try {
                aVar.handleBreadcrumb("$A$:" + a(bundle, str));
            } catch (JSONException unused) {
                o8.e.getLogger().w("Unable to serialize Firebase Analytics event to breadcrumb.");
            }
        }
    }

    @Override // q8.b
    public void registerBreadcrumbHandler(q8.a aVar) {
        this.f17643b = aVar;
        o8.e.getLogger().d("Registered Firebase Analytics event receiver for breadcrumbs");
    }
}
