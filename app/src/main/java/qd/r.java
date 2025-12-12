package qd;

import android.os.AsyncTask;
import cz.msebera.android.httpclient.HttpHost;
import java.util.Iterator;
import org.jsoup.nodes.Element;

/* compiled from: Movies123To.java */
/* loaded from: classes2.dex */
public final class r extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f18123a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f18124b;

    public r(s sVar, String str) {
        this.f18124b = sVar;
        this.f18123a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        String strAttr;
        s sVar = this.f18124b;
        try {
            Iterator<Element> it = ((dh.b) ch.a.connect(this.f18123a)).get().getElementsByClass("ml-item").iterator();
            while (it.hasNext()) {
                Element elementFirst = it.next().getElementsByTag("A").first();
                if (elementFirst != null) {
                    String strRemoveSpecialChars = sVar.removeSpecialChars(elementFirst.attr("title"));
                    String strRemoveSpecialChars2 = sVar.removeSpecialChars(sVar.f18125f.getTitle());
                    if (strRemoveSpecialChars != null) {
                        if (!strRemoveSpecialChars.equalsIgnoreCase(strRemoveSpecialChars2)) {
                            if (strRemoveSpecialChars.toLowerCase().equals(strRemoveSpecialChars2.toLowerCase() + sVar.f18125f.I)) {
                            }
                        }
                        String strAttr2 = elementFirst.attr("href");
                        if (strAttr2 != null && !strAttr2.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                            if (strAttr2.startsWith("/")) {
                                strAttr2 = sVar.f12433d + strAttr2;
                            } else {
                                strAttr2 = sVar.f12433d + "/" + strAttr2;
                            }
                        }
                        Iterator<Element> it2 = ((dh.b) ch.a.connect(strAttr2)).get().getElementsByClass("les-content").iterator();
                        while (it2.hasNext()) {
                            Element elementFirst2 = it2.next().getElementsByTag("a").first();
                            if (elementFirst2 != null && (strAttr = elementFirst2.attr("data-file")) != null && !strAttr.isEmpty()) {
                                hd.o oVar = new hd.o();
                                oVar.D = strAttr;
                                oVar.F = true;
                                oVar.C = sVar.checkLinkLabel(strAttr);
                                sVar.addLink(oVar);
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
        super.onPostExecute((r) str);
    }
}
