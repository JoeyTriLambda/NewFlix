package qd;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import cz.msebera.android.httpclient.HttpHost;
import java.util.Iterator;
import org.jsoup.nodes.Element;

/* compiled from: Chill123ToMovies.java */
/* loaded from: classes2.dex */
public final class f extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f18097a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f18098b;

    public f(g gVar, String str) {
        this.f18098b = gVar;
        this.f18097a = str;
    }

    @Override // android.os.AsyncTask
    @SuppressLint({"StaticFieldLeak"})
    public String doInBackground(Void... voidArr) {
        Element elementFirst;
        String strAttr;
        g gVar = this.f18098b;
        try {
            Iterator<Element> it = ((dh.b) ch.a.connect(this.f18097a)).get().getElementsByClass("ml-item").iterator();
            while (it.hasNext()) {
                Element elementFirst2 = it.next().getElementsByTag("A").first();
                if (elementFirst2 != null) {
                    String strRemoveSpecialChars = gVar.removeSpecialChars(elementFirst2.attr("title"));
                    if (strRemoveSpecialChars == null || strRemoveSpecialChars.isEmpty()) {
                        strRemoveSpecialChars = gVar.removeSpecialChars(elementFirst2.attr("oldtitle"));
                    }
                    if (strRemoveSpecialChars != null) {
                        strRemoveSpecialChars = strRemoveSpecialChars.replace(gVar.f18099f.I, "");
                    }
                    String strRemoveSpecialChars2 = gVar.removeSpecialChars(gVar.f18099f.getTitle());
                    if (strRemoveSpecialChars != null) {
                        if (strRemoveSpecialChars.toLowerCase().equals(strRemoveSpecialChars2.toLowerCase() + gVar.f18099f.I) || strRemoveSpecialChars.equalsIgnoreCase(strRemoveSpecialChars2)) {
                            String strAttr2 = elementFirst2.attr("href");
                            if (strAttr2 != null && !strAttr2.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                                strAttr2 = strAttr2.startsWith("/") ? gVar.f12433d + strAttr2 : gVar.f12433d + "/" + strAttr2;
                            }
                            String str = strAttr2 + "?action=watching&server=";
                            for (int i10 = 0; i10 < 5; i10++) {
                                Element elementById = ((dh.b) ch.a.connect(str + i10)).get().getElementById("playerMovie");
                                if (elementById != null && (elementFirst = elementById.getElementsByTag("IFRAME").first()) != null && (strAttr = elementFirst.attr("src")) != null && !strAttr.isEmpty()) {
                                    if (strAttr.startsWith("//")) {
                                        strAttr = "http:" + strAttr;
                                    }
                                    hd.o oVar = new hd.o();
                                    oVar.D = strAttr;
                                    oVar.F = true;
                                    oVar.C = gVar.checkLinkLabel(strAttr);
                                    gVar.addLink(oVar);
                                }
                            }
                        }
                    }
                }
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((f) str);
    }
}
