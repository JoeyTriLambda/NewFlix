package td;

import a2.x;
import android.content.Context;
import android.os.AsyncTask;
import d4.m;
import flix.com.vision.App;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FlixHindiMLSeries.java */
/* loaded from: classes2.dex */
public final class f extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Context f19902f;

    /* renamed from: g, reason: collision with root package name */
    public String f19903g;

    /* renamed from: h, reason: collision with root package name */
    public String f19904h;

    /* renamed from: i, reason: collision with root package name */
    public int f19905i;

    /* renamed from: j, reason: collision with root package name */
    public int f19906j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f19907k;

    /* renamed from: l, reason: collision with root package name */
    public final String f19908l = "https://allmovieland.fun/";

    /* compiled from: FlixHindiMLSeries.java */
    public class a extends m {
        public a(String str, d dVar, pd.a aVar) {
            super(0, str, dVar, aVar);
        }

        @Override // com.android.volley.Request
        public Map<String, String> getHeaders() {
            HashMap map = new HashMap();
            map.put("Referer", f.this.f19908l);
            return map;
        }
    }

    /* compiled from: FlixHindiMLSeries.java */
    public class b extends m {
        public b(String str, d dVar, pd.a aVar) {
            super(1, str, dVar, aVar);
        }

        @Override // com.android.volley.Request
        public Map<String, String> getHeaders() {
            HashMap map = new HashMap();
            f fVar = f.this;
            map.put("Referer", fVar.f19903g);
            map.put("X-Csrf-Token", fVar.f19904h);
            return map;
        }
    }

    /* compiled from: FlixHindiMLSeries.java */
    public class c extends m {
        public c(String str, x xVar, pd.a aVar) {
            super(1, str, xVar, aVar);
        }

        @Override // com.android.volley.Request
        public Map<String, String> getHeaders() {
            HashMap map = new HashMap();
            f fVar = f.this;
            map.put("Referer", fVar.f19903g);
            map.put("X-Csrf-Token", fVar.f19904h);
            return map;
        }
    }

    public f(Context context, gd.f fVar, String str) {
        this.f19907k = true;
        this.f19902f = context;
        this.f12431b = fVar;
        new ArrayList();
        this.f12433d = str;
        this.f19907k = App.getInstance().f11574v.getBoolean("pref_show_hindi_dubbed_direct", true);
    }

    public void GetStreamLinkHindi(String str) {
        App.getInstance().getRequestQueue().add(new a(str, new d(this, 0), new pd.a(9)));
    }

    public void GetStreamLinkHindi2(String str) {
        App.getInstance().getRequestQueue().add(new b(str, new d(this, 1), new pd.a(10)));
    }

    public void GetStreamLinkHindi3(jd.b bVar) {
        String str;
        if (this.f19907k || (str = bVar.f14693b) == null || str.contains("English")) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f12433d);
            sb2.append("/playlist/");
            App.getInstance().getRequestQueue().add(new c(ac.c.o(sb2, bVar.f14692a, ".txt"), new x(13, this, bVar), new pd.a(11)));
        }
    }

    public void process(String str, int i10, int i11) {
        this.f19903g = ac.c.p(new StringBuilder(), this.f12433d, "/play/", str);
        this.f19905i = i10;
        this.f19906j = i11;
        new e(this, str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
