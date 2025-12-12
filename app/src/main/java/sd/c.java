package sd;

import android.os.AsyncTask;
import flix.com.vision.App;
import hd.o;
import java.util.Iterator;
import kotlin.text.Regex;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: LingSeries.java */
/* loaded from: classes2.dex */
public final class c extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f19256a;

    public c(d dVar) {
        this.f19256a = dVar;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        Element elementFirst;
        d dVar = this.f19256a;
        try {
            Elements elementsSelect = ch.a.parse(App.get(dVar.f12433d + "/en/videos/serials/?title=" + dVar.f19257f.getTitle().replace("–", "-"), dVar.f12433d).body().string()).select("div.blk.padding_b0 div.col-sm-30");
            if (elementsSelect.size() == 1) {
                elementFirst = elementsSelect.first();
            } else {
                Iterator<Element> it = elementsSelect.iterator();
                Element element = null;
                while (it.hasNext()) {
                    Element next = it.next();
                    if (elementsSelect.text().contains(dVar.f19257f.getTitle()) && elementsSelect.text().contains(dVar.f19257f.getYear())) {
                        element = next;
                    }
                }
                elementFirst = element;
            }
            if (elementFirst != null) {
                String str = new Regex("((https:|http:)//.*\\.mp4)").find(App.get(dVar.f12433d + ch.a.parse(App.get(dVar.f12433d + elementFirst.selectFirst("div.video-body a").attr("href"), dVar.f12433d).body().string()).select("div.blk div#tab_" + dVar.f19258g + " li").get(dVar.f19259h - 1).select("h5 a").attr("data-href"), dVar.f12433d).body().string(), 0).getValue() + "/index.m3u8";
                o oVar = new o();
                oVar.D = str;
                oVar.f13047w = true;
                oVar.C = "720p - [LINGSTREAM] - [DIRECT] - English";
                oVar.f13040p = dVar.f12433d;
                dVar.f12431b.OnSuccess(oVar);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((c) str);
    }
}
