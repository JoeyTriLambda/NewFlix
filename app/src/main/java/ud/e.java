package ud;

import android.os.AsyncTask;
import cz.msebera.android.httpclient.HttpHost;
import hd.o;
import java.io.IOException;
import java.util.Iterator;
import org.jsoup.nodes.Element;

/* compiled from: MovieRulzHindi.java */
/* loaded from: classes2.dex */
public final class e extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f20369a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f20370b;

    public e(f fVar, String str) {
        this.f20370b = fVar;
        this.f20369a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        String strAttr;
        f fVar = this.f20370b;
        try {
            Iterator<Element> it = ((dh.b) ch.a.connect(this.f20369a)).get().getElementsByClass("cont_display").iterator();
            while (it.hasNext()) {
                Element elementFirst = it.next().getElementsByTag("A").first();
                if (elementFirst != null) {
                    String strRemoveSpecialChars = fVar.removeSpecialChars(elementFirst.attr("title"));
                    String str = fVar.removeSpecialChars(fVar.f20371f.getTitle()) + fVar.f20371f.I;
                    if (strRemoveSpecialChars != null && strRemoveSpecialChars.toLowerCase().contains(str.toLowerCase())) {
                        String strAttr2 = elementFirst.attr("href");
                        if (strAttr2 != null && !strAttr2.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                            if (strAttr2.startsWith("/")) {
                                strAttr2 = fVar.f12433d + strAttr2;
                            } else {
                                strAttr2 = fVar.f12433d + "/" + strAttr2;
                            }
                        }
                        Iterator<Element> it2 = ((dh.b) ch.a.connect(strAttr2)).get().getElementsByTag("A").iterator();
                        while (it2.hasNext()) {
                            Element next = it2.next();
                            if (fVar.removeSpecialChars(next.text()).contains(str) && (strAttr = next.attr("href")) != null && !strAttr.isEmpty()) {
                                if (strAttr.startsWith("//")) {
                                    strAttr = "http:" + strAttr;
                                }
                                o oVar = new o();
                                oVar.D = strAttr;
                                oVar.F = true;
                                oVar.C = fVar.checkLinkLabel(strAttr);
                                oVar.f13046v = true;
                                fVar.addLink(oVar);
                            }
                        }
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
        super.onPostExecute((e) str);
    }
}
