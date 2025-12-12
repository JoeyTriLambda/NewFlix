package ud;

import android.os.AsyncTask;
import cz.msebera.android.httpclient.HttpHost;
import hd.o;
import java.io.IOException;
import java.util.Iterator;
import org.jsoup.nodes.Element;

/* compiled from: HindiLinks4U.java */
/* loaded from: classes2.dex */
public final class a extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f20363a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f20364b;

    public a(b bVar, String str) {
        this.f20364b = bVar;
        this.f20363a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        String strAttr;
        b bVar = this.f20364b;
        try {
            Iterator<Element> it = ((dh.b) ch.a.connect(this.f20363a)).get().getElementsByClass("ml-item").iterator();
            while (it.hasNext()) {
                Element elementFirst = it.next().getElementsByTag("A").first();
                if (elementFirst != null) {
                    String strRemoveSpecialChars = bVar.removeSpecialChars(elementFirst.attr("oldtitle"));
                    String str = bVar.removeSpecialChars(bVar.f20365f.getTitle()) + bVar.f20365f.I;
                    if (strRemoveSpecialChars != null && strRemoveSpecialChars.toLowerCase().contains(str.toLowerCase())) {
                        String strAttr2 = elementFirst.attr("href");
                        if (strAttr2 != null && !strAttr2.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                            if (strAttr2.startsWith("/")) {
                                strAttr2 = bVar.f12433d + strAttr2;
                            } else {
                                strAttr2 = bVar.f12433d + "/" + strAttr2;
                            }
                        }
                        Iterator<Element> it2 = ((dh.b) ch.a.connect(strAttr2)).get().getElementsByClass("movieplay").iterator();
                        while (it2.hasNext()) {
                            Element elementFirst2 = it2.next().getElementsByTag("IFRAME").first();
                            if (elementFirst2 != null && (strAttr = elementFirst2.attr("src")) != null && !strAttr.isEmpty()) {
                                if (strAttr.startsWith("//")) {
                                    strAttr = "http:" + strAttr;
                                }
                                o oVar = new o();
                                oVar.D = strAttr;
                                oVar.F = true;
                                oVar.f13046v = true;
                                oVar.C = bVar.checkLinkLabel(strAttr);
                                bVar.addLink(oVar);
                            }
                        }
                        return null;
                    }
                }
            }
            return null;
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((a) str);
    }
}
