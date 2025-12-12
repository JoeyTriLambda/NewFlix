package wd;

import android.os.AsyncTask;
import flix.com.vision.App;
import flix.com.vision.api.alldebrid.AllDebridCommon;
import flix.com.vision.api.premiumize.PremiumizeCommon;
import flix.com.vision.api.realdebrid.RealDebridCommon;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* compiled from: SolidTorrentsMovies.java */
/* loaded from: classes2.dex */
public final class b extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f21059a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f21060b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f21061c;

    public b(c cVar, String str, ArrayList arrayList) {
        this.f21061c = cVar;
        this.f21059a = str;
        this.f21060b = arrayList;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        c cVar = this.f21061c;
        String str = null;
        try {
            Document document = ((dh.b) ch.a.connect(this.f21059a)).get();
            if (cVar.f21064h) {
                return null;
            }
            String str2 = be.f.removeSpecialChars(cVar.f21062f.getTitle()) + cVar.f21062f.getYear();
            Iterator<Element> it = document.getElementsByTag("LI").iterator();
            int i10 = 0;
            while (true) {
                boolean zHasNext = it.hasNext();
                List<String> list = this.f21060b;
                if (!zHasNext) {
                    if (list.size() <= 0) {
                        return null;
                    }
                    cVar.addMagnetsAllDebrid(list);
                    return null;
                }
                Element next = it.next();
                if (next.attr("class") != null && next.attr("class").contains("card search-result")) {
                    Iterator<Element> it2 = next.getElementsByTag("A").iterator();
                    while (it2.hasNext()) {
                        Element next2 = it2.next();
                        if (cVar.removeSpecialChars(next2.text()).toLowerCase().contains(str2.toLowerCase()) && BaseProcessor.isEnglishlang(next2.text(), cVar.f21062f.getTitle())) {
                            Iterator<Element> it3 = next.getElementsByTag("A").iterator();
                            while (it3.hasNext()) {
                                String strAttr = it3.next().attr("href");
                                if (strAttr.startsWith("magnet")) {
                                    if (cVar.f21064h) {
                                        return str;
                                    }
                                    if (App.getInstance().addHash(strAttr)) {
                                        if (RealDebridCommon.f12051p) {
                                            cVar.getClass();
                                            bc.a.getTorrent(strAttr, RealDebridCommon.f12049n, RealDebridCommon.f12047b).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new a(cVar), new pd.a(12));
                                        }
                                        if (AllDebridCommon.f12043n) {
                                            list.add(strAttr);
                                        }
                                        if (PremiumizeCommon.f12045b) {
                                            cVar.getMagnetPrem(strAttr);
                                        }
                                        i10++;
                                        if (i10 > cVar.f12430a) {
                                            if (list.size() <= 0) {
                                                return null;
                                            }
                                            cVar.addMagnetsAllDebrid(list);
                                            return null;
                                        }
                                    }
                                }
                                str = null;
                            }
                        }
                        str = null;
                    }
                }
                str = null;
            }
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((b) str);
    }
}
