package bd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import com.google.gson.l;
import flix.com.vision.App;
import flix.com.vision.processors.english.BaseProcessor;
import flix.com.vision.utils.JsonUtils;
import gd.f;
import hd.o;
import java.util.ArrayList;
import kotlin.text.Regex;

/* compiled from: FileMoonExtractor.java */
/* loaded from: classes2.dex */
public final class c extends BaseProcessor {

    /* compiled from: FileMoonExtractor.java */
    public class a extends AsyncTask<Void, Void, String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f4862a;

        public a(o oVar) {
            this.f4862a = oVar;
        }

        @Override // android.os.AsyncTask
        public String doInBackground(Void... voidArr) {
            String value;
            c cVar = c.this;
            try {
                String strUnpack = new be.e(ch.a.parse(App.get(this.f4862a.D, cVar.f12433d).body().string()).select("script:containsData(function(p,a,c,k,e,d))").last().data()).unpack();
                cVar.getClass();
                try {
                    value = new Regex(".setup(.*?);").find(strUnpack, 0).getValue();
                } catch (Exception unused) {
                    value = null;
                }
                l asJsonArray = JsonUtils.parse(value.replace(".setup(", "").replace(");", "")).getAsJsonObject().get("sources").getAsJsonArray();
                for (int i10 = 0; i10 < asJsonArray.size(); i10++) {
                    String asString = asJsonArray.get(i10).getAsJsonObject().get("file").getAsString();
                    o oVar = new o();
                    oVar.D = asString;
                    oVar.f13047w = true;
                    oVar.F = false;
                    oVar.f13039o = true;
                    oVar.C = "1080p - [FILEMOON] - [DIRECT] - English";
                    oVar.f13040p = cVar.f12433d;
                    cVar.f12431b.OnSuccess(oVar);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
        }
    }

    public c(Context context, f fVar) {
        this.f12431b = fVar;
        new ArrayList();
        this.f12433d = "https://azm.to";
    }

    @SuppressLint({"StaticFieldLeak"})
    public void fetchLinks(o oVar) {
        new a(oVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
