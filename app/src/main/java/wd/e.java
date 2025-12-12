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

/* compiled from: SolidTorrentsSeries.java */
/* loaded from: classes2.dex */
public final class e extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f21068a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f21069b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f21070c;

    public e(f fVar, String str, ArrayList arrayList) {
        this.f21070c = fVar;
        this.f21068a = str;
        this.f21069b = arrayList;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        f fVar = this.f21070c;
        String str = null;
        try {
            Document document = ((dh.b) ch.a.connect(this.f21068a)).get();
            if (fVar.f21076k) {
                return null;
            }
            String str2 = be.f.removeSpecialChars(fVar.f21071f.getTitle()) + fVar.f21074i;
            Iterator<Element> it = document.getElementsByTag("LI").iterator();
            int i10 = 0;
            while (true) {
                boolean zHasNext = it.hasNext();
                List<String> list = this.f21069b;
                if (!zHasNext) {
                    if (list.size() <= 0) {
                        return null;
                    }
                    fVar.addMagnetsAllDebrid(list);
                    return null;
                }
                Element next = it.next();
                if (next.attr("class") != null && next.attr("class").contains("card search-result")) {
                    Iterator<Element> it2 = next.getElementsByTag("A").iterator();
                    while (it2.hasNext()) {
                        Element next2 = it2.next();
                        if (fVar.removeSpecialChars(next2.text()).toLowerCase().contains(str2.toLowerCase()) && BaseProcessor.isEnglishlang(next2.text(), fVar.f21071f.getTitle())) {
                            Iterator<Element> it3 = next.getElementsByTag("A").iterator();
                            while (it3.hasNext()) {
                                String strAttr = it3.next().attr("href");
                                if (strAttr.startsWith("magnet")) {
                                    if (fVar.f21076k) {
                                        return str;
                                    }
                                    if (App.getInstance().addHash(strAttr)) {
                                        if (RealDebridCommon.f12051p) {
                                            fVar.getClass();
                                            bc.a.getTorrent(strAttr, RealDebridCommon.f12049n, RealDebridCommon.f12047b).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new c1.c(fVar, 28), new pd.a(13));
                                        }
                                        if (AllDebridCommon.f12043n) {
                                            list.add(strAttr);
                                        }
                                        if (PremiumizeCommon.f12045b) {
                                            fVar.getMagnetPrem(strAttr);
                                        }
                                        i10++;
                                        if (i10 > fVar.f12430a) {
                                            if (list.size() <= 0) {
                                                return null;
                                            }
                                            fVar.addMagnetsAllDebrid(list);
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
        super.onPostExecute((e) str);
    }
}
