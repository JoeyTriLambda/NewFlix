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

/* compiled from: Torrentz2Movies.java */
/* loaded from: classes2.dex */
public final class o extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f21103a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f21104b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p f21105c;

    public o(p pVar, String str, ArrayList arrayList) {
        this.f21105c = pVar;
        this.f21103a = str;
        this.f21104b = arrayList;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        p pVar = this.f21105c;
        try {
            Document document = ((dh.b) ch.a.connect(this.f21103a)).get();
            if (pVar.f21108h) {
                return null;
            }
            String str = be.f.removeSpecialChars(pVar.f21106f.getTitle()) + pVar.f21106f.getYear();
            Iterator<Element> it = document.getElementsByTag("DL").iterator();
            int i10 = 0;
            while (true) {
                boolean zHasNext = it.hasNext();
                List<String> list = this.f21104b;
                if (zHasNext) {
                    Element next = it.next();
                    Iterator<Element> it2 = next.getElementsByTag("A").iterator();
                    while (it2.hasNext()) {
                        Element next2 = it2.next();
                        if (pVar.removeSpecialChars(next2.text()).toLowerCase().contains(str.toLowerCase()) && BaseProcessor.isEnglishlang(next2.text(), pVar.f21106f.getTitle())) {
                            Iterator<Element> it3 = next.getElementsByTag("A").iterator();
                            while (it3.hasNext()) {
                                String strAttr = it3.next().attr("href");
                                if (strAttr.startsWith("magnet")) {
                                    if (pVar.f21108h) {
                                        return null;
                                    }
                                    if (App.getInstance().addHash(strAttr)) {
                                        if (RealDebridCommon.f12051p) {
                                            pVar.getClass();
                                            bc.a.getTorrent(strAttr, RealDebridCommon.f12049n, RealDebridCommon.f12047b).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new k(pVar, 1), new pd.a(19));
                                        }
                                        if (AllDebridCommon.f12043n) {
                                            list.add(strAttr);
                                        }
                                        if (PremiumizeCommon.f12045b) {
                                            pVar.getMagnetPrem(strAttr);
                                        }
                                        i10++;
                                        if (i10 > pVar.f12430a) {
                                            if (list.size() > 0) {
                                                pVar.addMagnetsAllDebrid(list);
                                            }
                                            return null;
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (list.size() > 0) {
                    pVar.addMagnetsAllDebrid(list);
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((o) str);
    }
}
