package qd;

import android.os.AsyncTask;
import cz.msebera.android.httpclient.HttpHost;
import java.util.Iterator;
import org.jsoup.nodes.Element;

/* compiled from: AZMovies.java */
/* loaded from: classes2.dex */
public final class a extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f18070a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f18071b;

    public a(b bVar, String str) {
        this.f18071b = bVar;
        this.f18070a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        Element elementFirst;
        String strAttr;
        b bVar = this.f18071b;
        try {
            Iterator<Element> it = ((dh.b) ch.a.connect(this.f18070a)).get().getElementsByClass("poster").iterator();
            while (it.hasNext()) {
                Element next = it.next();
                if (next != null && (elementFirst = next.getElementsByTag("IMG").first()) != null) {
                    String strRemoveSpecialChars = bVar.removeSpecialChars(elementFirst.attr("alt"));
                    String strRemoveSpecialChars2 = bVar.removeSpecialChars(bVar.f18075f.getTitle() + " poster");
                    if (strRemoveSpecialChars != null && strRemoveSpecialChars.equalsIgnoreCase(strRemoveSpecialChars2)) {
                        String strAttr2 = next.attr("href");
                        if (strAttr2 != null && !strAttr2.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                            if (strAttr2.startsWith("/")) {
                                strAttr2 = bVar.f12433d + strAttr2;
                            } else {
                                strAttr2 = bVar.f12433d + "/" + strAttr2;
                            }
                        }
                        Iterator<Element> it2 = ((dh.b) ch.a.connect(strAttr2)).get().getElementsByTag("A").iterator();
                        while (it2.hasNext()) {
                            Element next2 = it2.next();
                            String strAttr3 = next2.attr("href");
                            if (strAttr3 != null && strAttr3.equalsIgnoreCase("#") && (strAttr = next2.attr("value")) != null && !strAttr.isEmpty()) {
                                hd.o oVar = new hd.o();
                                oVar.D = strAttr;
                                oVar.F = true;
                                oVar.C = bVar.checkLinkLabel(strAttr) + " AZ";
                                bVar.addLink(oVar);
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
        super.onPostExecute((a) str);
    }
}
