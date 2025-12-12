package y8;

import org.json.JSONException;
import org.json.JSONObject;
import r8.c0;
import r8.n0;

/* compiled from: SettingsJsonParser.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final c0 f22033a;

    public e(n0 n0Var) {
        this.f22033a = n0Var;
    }

    public d parseSettingsJson(JSONObject jSONObject) throws JSONException {
        f jVar;
        int i10 = jSONObject.getInt("settings_version");
        if (i10 != 3) {
            o8.e.getLogger().e("Could not determine SettingsJsonTransform for settings version " + i10 + ". Using default settings values.");
            jVar = new b();
        } else {
            jVar = new j();
        }
        return jVar.buildFromJson(this.f22033a, jSONObject);
    }
}
