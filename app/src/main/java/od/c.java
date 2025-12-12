package od;

import android.os.AsyncTask;
import java.util.Iterator;
import org.jsoup.nodes.Element;

/* compiled from: AdultVideosFetcher.java */
/* loaded from: classes2.dex */
public final class c extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f17077a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f17078b;

    public c(d dVar, String str) {
        this.f17078b = dVar;
        this.f17077a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        try {
            Element elementById = ((dh.b) ch.a.connect(this.f17077a)).get().getElementById("content");
            d dVar = this.f17078b;
            if (elementById != null) {
                Iterator<Element> it = elementById.getElementsByTag("DIV").iterator();
                while (it.hasNext()) {
                    Element next = it.next();
                    try {
                        String strAttr = next.attr("data-id");
                        if (strAttr != null && strAttr.length() >= 4) {
                            String str = "https://xvideos.com" + next.select("a").first().attr("href");
                            String strAttr2 = next.select("img").first().attr("data-src");
                            String strText = next.select("div[class^=thumb-under]").first().select("a").first().text();
                            id.c cVar = new id.c();
                            Element elementFirst = next.select("span[class^=video-sd-mark]").first();
                            if (elementFirst == null) {
                                elementFirst = next.select("span[class^=video-hd-mark]").first();
                            }
                            if (elementFirst != null) {
                                cVar.f13369e = elementFirst.text();
                            }
                            Element elementFirst2 = next.select("span[class^=duration]").first();
                            cVar.f13365a = strText;
                            cVar.f13367c = strAttr2;
                            if (elementFirst2 != null) {
                                cVar.f13368d = elementFirst2.text();
                            }
                            cVar.f13366b = str;
                            String str2 = cVar.f13368d;
                            if (str2 != null && str2.length() > 0) {
                                cVar.f13365a = cVar.f13365a.replace(cVar.f13368d, "");
                            }
                            dVar.f17079a.add(cVar);
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            }
            if (dVar.f17079a.size() <= 0) {
                return null;
            }
            dVar.f17080b.OnVideoListSuccess(dVar.f17079a);
            return null;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((c) str);
    }
}
