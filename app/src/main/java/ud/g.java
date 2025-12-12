package ud;

import android.os.AsyncTask;
import cz.msebera.android.httpclient.HttpHost;
import hd.o;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import org.jsoup.nodes.Element;

/* compiled from: Movies123Hindi.java */
/* loaded from: classes2.dex */
public final class g extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f20372a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f20373b;

    public g(h hVar, String str) {
        this.f20373b = hVar;
        this.f20372a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        String strAttr;
        h hVar = this.f20373b;
        try {
            Iterator<Element> it = ((dh.b) ch.a.connect(this.f20372a)).get().getElementsByTag("ARTICLE").iterator();
            while (it.hasNext()) {
                Element elementFirst = it.next().getElementsByTag("A").first();
                if (elementFirst != null) {
                    String strRemoveSpecialChars = hVar.removeSpecialChars(elementFirst.attr("title"));
                    String str = hVar.removeSpecialChars(hVar.f20374f.getTitle()) + hVar.f20374f.I;
                    if (strRemoveSpecialChars != null) {
                        if (!strRemoveSpecialChars.toLowerCase().equals(str.toLowerCase())) {
                            Locale locale = Locale.ROOT;
                            if (strRemoveSpecialChars.toLowerCase(locale).contains(hVar.removeSpecialChars(hVar.f20374f.getTitle() + "hindi").toLowerCase(locale))) {
                            }
                        }
                        String strAttr2 = elementFirst.attr("href");
                        if (strAttr2 != null && !strAttr2.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                            if (strAttr2.startsWith("/")) {
                                strAttr2 = hVar.f12433d + strAttr2;
                            } else {
                                strAttr2 = hVar.f12433d + "/" + strAttr2;
                            }
                        }
                        Iterator<Element> it2 = ((dh.b) ch.a.connect(strAttr2)).get().getElementsByTag("IFRAME").iterator();
                        while (it2.hasNext()) {
                            Element next = it2.next();
                            if (next != null && (strAttr = next.attr("src")) != null && !strAttr.isEmpty()) {
                                if (strAttr.startsWith("//")) {
                                    strAttr = "http:" + strAttr;
                                }
                                o oVar = new o();
                                oVar.D = strAttr;
                                oVar.F = true;
                                oVar.f13046v = true;
                                oVar.C = hVar.checkLinkLabel(strAttr);
                                hVar.addLink(oVar);
                            }
                        }
                        return null;
                    }
                    continue;
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
        super.onPostExecute((g) str);
    }
}
