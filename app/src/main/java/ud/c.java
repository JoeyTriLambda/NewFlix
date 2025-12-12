package ud;

import android.os.AsyncTask;
import hd.o;
import java.util.Iterator;
import org.jsoup.nodes.Element;

/* compiled from: HindiMoviesTV.java */
/* loaded from: classes2.dex */
public final class c extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f20366a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f20367b;

    public c(d dVar, String str) {
        this.f20367b = dVar;
        this.f20366a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        String str;
        String strAttr;
        d dVar = this.f20367b;
        try {
            Iterator<Element> it = ((dh.b) ch.a.connect(this.f20366a)).get().getElementsByClass("ml-item").iterator();
            while (it.hasNext()) {
                Element elementFirst = it.next().getElementsByTag("A").first();
                if (elementFirst != null) {
                    String strRemoveSpecialChars = dVar.removeSpecialChars(elementFirst.attr("oldtitle"));
                    String str2 = dVar.removeSpecialChars(dVar.f20368f.getTitle()) + dVar.f20368f.I + "hindi";
                    if (strRemoveSpecialChars != null && (strRemoveSpecialChars.toLowerCase().equals(str2.toLowerCase()) || strRemoveSpecialChars.equalsIgnoreCase(str2))) {
                        String strAttr2 = elementFirst.attr("href");
                        if (strAttr2.startsWith("/")) {
                            str = dVar.f12433d + strAttr2;
                        } else {
                            str = dVar.f12433d + "/" + strAttr2;
                        }
                        Iterator<Element> it2 = ((dh.b) ch.a.connect(str)).get().getElementsByClass("movieplay").iterator();
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
                                oVar.C = dVar.checkLinkLabel(strAttr);
                                dVar.addLink(oVar);
                            }
                        }
                        return null;
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
        super.onPostExecute((c) str);
    }
}
