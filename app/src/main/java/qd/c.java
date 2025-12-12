package qd;

import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.nodes.Element;

/* compiled from: AnimeProcessor.java */
/* loaded from: classes2.dex */
public final class c extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f18078a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f18079b;

    public c(d dVar, String str) {
        this.f18079b = dVar;
        this.f18078a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        d dVar;
        String str = this.f18078a;
        try {
            Iterator<Element> it = ((dh.b) ch.a.connect(str)).get().getElementsByClass("anime_muti_link").first().getElementsByTag("li").iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                dVar = this.f18079b;
                if (!zHasNext) {
                    break;
                }
                Element next = it.next();
                Element elementFirst = next.getElementsByTag("a").first();
                if (elementFirst != null) {
                    String strAttr = elementFirst.attr("data-video");
                    if (strAttr.contains(".php?id=") || next.attr("class").equals("vidcdn")) {
                        new bd.e(dVar.f18089f, str, dVar.f12431b).process(strAttr);
                    } else if (!strAttr.contains("vev.")) {
                        hd.o oVar = new hd.o();
                        oVar.D = strAttr;
                        oVar.C = dVar.checkLinkLabel(strAttr);
                        oVar.F = true;
                        dVar.f18090g.add(oVar);
                    }
                }
            }
            if (dVar.f18090g.size() <= 0) {
                return null;
            }
            new ArrayList();
            Iterator<hd.o> it2 = dVar.f18090g.iterator();
            while (it2.hasNext()) {
                dVar.addLink(it2.next());
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
