package bd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import be.f;
import flix.com.vision.App;
import hd.o;
import kotlin.text.Regex;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* compiled from: DoodExtractor.java */
/* loaded from: classes2.dex */
public final class b extends bd.a {

    /* compiled from: DoodExtractor.java */
    public class a extends AsyncTask<Void, Void, String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f4860a;

        public a(o oVar) {
            this.f4860a = oVar;
        }

        @Override // android.os.AsyncTask
        public String doInBackground(Void... voidArr) {
            String strString;
            String value;
            String value2;
            o oVar = this.f4860a;
            b bVar = b.this;
            try {
                strString = App.get(oVar.D, bVar.f4859b).body().string();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (strString == null) {
                return null;
            }
            Document document = ch.a.parse(strString);
            String strReplace = bVar.f4859b;
            try {
                if (f.notNull(document.baseUri())) {
                    strReplace = document.baseUri();
                } else {
                    String baseUrl = f.getBaseUrl(oVar.D);
                    if (f.notNull(oVar.D)) {
                        strReplace = baseUrl;
                    }
                }
            } catch (Exception unused) {
            }
            if (strReplace != null) {
                strReplace = strReplace.replace("http://", "").replace("https://", "");
            }
            if (!f.notNull(strReplace)) {
                strReplace = "DOOD";
            }
            String strHtml = document.html();
            bVar.getClass();
            try {
                value = new Regex("/pass_md5/[^']*").find(strHtml, 0).getValue();
            } catch (Exception unused2) {
                value = null;
            }
            if (value == null) {
                return null;
            }
            Element elementFirst = document.getElementsByTag("TITLE").first();
            String str = "HD";
            if (elementFirst != null) {
                String strText = elementFirst.text();
                bVar.getClass();
                try {
                    value2 = new Regex("\\d{3,4}p").find(strText, 0).getValue();
                } catch (Exception unused3) {
                    value2 = null;
                }
            } else {
                value2 = "HD";
            }
            if (f.notNull(value2)) {
                str = value2;
            }
            String str2 = bVar.f4859b + value;
            String str3 = value.split("/")[value.split("/").length - 1];
            String str4 = App.get(str2, bVar.f4859b).body().string() + "qWMG3yc6F5?token=" + str3;
            o oVar2 = new o();
            oVar2.D = str4;
            oVar2.f13047w = true;
            oVar2.F = false;
            oVar2.C = str + " - [" + strReplace.toUpperCase() + "] - [DIRECT] - English";
            oVar2.f13040p = oVar2.D;
            bVar.f4858a.OnSuccess(oVar2);
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
        }
    }

    public b(Context context, gd.f fVar) {
        this.f4858a = fVar;
        this.f4859b = "https://dood.wf";
    }

    @SuppressLint({"StaticFieldLeak"})
    public void fetchLinks(o oVar) {
        new a(oVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
