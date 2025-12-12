package g9;

import android.util.Base64OutputStream;
import com.uwetrottmann.trakt5.TraktV2;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Callable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f12807b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ c f12808m;

    public /* synthetic */ b(c cVar, int i10) {
        this.f12807b = i10;
        this.f12808m = cVar;
    }

    private final String a() {
        String string;
        c cVar = this.f12808m;
        synchronized (cVar) {
            h hVar = cVar.f12809a.get();
            ArrayList arrayListC = hVar.c();
            hVar.b();
            JSONArray jSONArray = new JSONArray();
            for (int i10 = 0; i10 < arrayListC.size(); i10++) {
                i iVar = (i) arrayListC.get(i10);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("agent", iVar.getUserAgent());
                jSONObject.put("dates", new JSONArray((Collection) iVar.getUsedDates()));
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("heartbeats", jSONArray);
            jSONObject2.put("version", TraktV2.API_VERSION);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 11);
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                try {
                    gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                    gZIPOutputStream.close();
                    base64OutputStream.close();
                    string = byteArrayOutputStream.toString("UTF-8");
                } finally {
                }
            } finally {
            }
        }
        return string;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f12807b) {
            case 0:
                c cVar = this.f12808m;
                synchronized (cVar) {
                    cVar.f12809a.get().g(System.currentTimeMillis(), cVar.f12811c.get().getUserAgent());
                }
                return null;
            default:
                return a();
        }
    }
}
