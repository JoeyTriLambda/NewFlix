package y8;

import org.json.JSONObject;
import r8.c0;
import r8.n0;
import y8.d;

/* compiled from: DefaultSettingsJsonTransform.java */
/* loaded from: classes.dex */
public final class b implements f {
    public static d a(c0 c0Var) {
        return new d(((n0) c0Var).getCurrentTimeMillis() + 3600000, new d.b(8, 4), new d.a(true, false, false), 0, 3600, 10.0d, 1.2d, 60);
    }

    @Override // y8.f
    public d buildFromJson(c0 c0Var, JSONObject jSONObject) {
        return a(c0Var);
    }
}
