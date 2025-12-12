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

/* compiled from: TorrentBayMovies.java */
/* loaded from: classes2.dex */
public final class h extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f21080a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f21081b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f21082c;

    public h(i iVar, String str, ArrayList arrayList) {
        this.f21082c = iVar;
        this.f21080a = str;
        this.f21081b = arrayList;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        i iVar = this.f21082c;
        try {
            Document document = ((dh.b) ch.a.connect(this.f21080a)).get();
            if (iVar.f21085h) {
                return null;
            }
            String str = be.f.removeSpecialChars(iVar.f21083f.getTitle()) + iVar.f21083f.getYear();
            Iterator<Element> it = document.getElementsByTag("TR").iterator();
            int i10 = 0;
            while (true) {
                boolean zHasNext = it.hasNext();
                List<String> list = this.f21081b;
                if (zHasNext) {
                    Element next = it.next();
                    Iterator<Element> it2 = next.getElementsByTag("A").iterator();
                    while (it2.hasNext()) {
                        Element next2 = it2.next();
                        if (iVar.removeSpecialChars(next2.text()).toLowerCase().contains(str.toLowerCase()) && BaseProcessor.isEnglishlang(next2.text(), iVar.f21083f.getTitle())) {
                            Iterator<Element> it3 = next.getElementsByTag("A").iterator();
                            while (it3.hasNext()) {
                                String strAttr = it3.next().attr("href");
                                if (strAttr.startsWith("magnet")) {
                                    if (iVar.f21085h) {
                                        return null;
                                    }
                                    if (App.getInstance().addHash(strAttr)) {
                                        if (RealDebridCommon.f12051p) {
                                            iVar.getClass();
                                            bc.a.getTorrent(strAttr, RealDebridCommon.f12049n, RealDebridCommon.f12047b).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new c1.c(iVar, 29), new pd.a(15));
                                        }
                                        if (AllDebridCommon.f12043n) {
                                            list.add(strAttr);
                                        }
                                        if (PremiumizeCommon.f12045b) {
                                            iVar.getMagnetPrem(strAttr);
                                        }
                                        i10++;
                                        if (i10 > iVar.f12430a) {
                                            if (list.size() > 0) {
                                                iVar.addMagnetsAllDebrid(list);
                                            }
                                            return null;
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (list.size() > 0) {
                    iVar.addMagnetsAllDebrid(list);
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((h) str);
    }
}
