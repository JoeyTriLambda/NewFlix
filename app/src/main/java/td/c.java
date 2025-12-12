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

/* compiled from: FlixHindiML.java */
/* loaded from: classes2.dex */
public final class c extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Context f19890f;

    /* renamed from: g, reason: collision with root package name */
    public String f19891g;

    /* renamed from: h, reason: collision with root package name */
    public String f19892h;

    /* renamed from: i, reason: collision with root package name */
    public final String f19893i = "https://allmovieland.fun/";

    /* renamed from: j, reason: collision with root package name */
    public final boolean f19894j;

    /* compiled from: FlixHindiML.java */
    public class a extends m {
        public a(String str, td.a aVar, pd.a aVar2) {
            super(0, str, aVar, aVar2);
        }

        @Override // com.android.volley.Request
        public Map<String, String> getHeaders() {
            HashMap map = new HashMap();
            map.put("Referer", c.this.f19893i);
            return map;
        }
    }

    /* compiled from: FlixHindiML.java */
    public class b extends m {
        public b(String str, td.a aVar, pd.a aVar2) {
            super(1, str, aVar, aVar2);
        }

        @Override // com.android.volley.Request
        public Map<String, String> getHeaders() {
            HashMap map = new HashMap();
            c cVar = c.this;
            map.put("Referer", cVar.f19891g);
            map.put("X-Csrf-Token", cVar.f19892h);
            return map;
        }
    }

    /* compiled from: FlixHindiML.java */
    /* renamed from: td.c$c, reason: collision with other inner class name */
    public class C0280c extends m {
        public C0280c(String str, x xVar, pd.a aVar) {
            super(1, str, xVar, aVar);
        }

        @Override // com.android.volley.Request
        public Map<String, String> getHeaders() {
            HashMap map = new HashMap();
            c cVar = c.this;
            map.put("Referer", cVar.f19891g);
            map.put("X-Csrf-Token", cVar.f19892h);
            return map;
        }
    }

    public c(Context context, gd.f fVar, String str) {
        this.f19894j = true;
        this.f19890f = context;
        this.f12431b = fVar;
        new ArrayList();
        this.f12433d = str;
        this.f19894j = App.getInstance().f11574v.getBoolean("pref_show_hindi_dubbed_direct", true);
    }

    public void GetStreamLinkHindi(String str) {
        App.getInstance().getRequestQueue().add(new a(str, new td.a(this, 0), new pd.a(6)));
    }

    public void GetStreamLinkHindi2(String str) {
        App.getInstance().getRequestQueue().add(new b(str, new td.a(this, 1), new pd.a(7)));
    }

    public void GetStreamLinkHindi3(jd.b bVar) {
        String str;
        if (this.f19894j || (str = bVar.f14693b) == null || str.contains("English")) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f12433d);
            sb2.append("/playlist/");
            App.getInstance().getRequestQueue().add(new C0280c(ac.c.o(sb2, bVar.f14692a, ".txt"), new x(12, this, bVar), new pd.a(8)));
        }
    }

    public void process(String str) {
        this.f19891g = ac.c.p(new StringBuilder(), this.f12433d, "/play/", str);
        new td.b(this, str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
