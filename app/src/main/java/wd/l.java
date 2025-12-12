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

/* compiled from: TorrentBaySeries.java */
/* loaded from: classes2.dex */
public final class l extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f21091a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f21092b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f21093c;

    public l(m mVar, String str, ArrayList arrayList) {
        this.f21093c = mVar;
        this.f21091a = str;
        this.f21092b = arrayList;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        m mVar = this.f21093c;
        try {
            Document document = ((dh.b) ch.a.connect(this.f21091a)).get();
            if (mVar.f21099k) {
                return null;
            }
            String str = be.f.removeSpecialChars(mVar.f21094f.getTitle()) + mVar.f21098j;
            Iterator<Element> it = document.getElementsByTag("TR").iterator();
            int i10 = 0;
            int i11 = 0;
            while (true) {
                boolean zHasNext = it.hasNext();
                List<String> list = this.f21092b;
                if (zHasNext) {
                    Element next = it.next();
                    Iterator<Element> it2 = next.getElementsByTag("A").iterator();
                    while (it2.hasNext()) {
                        Element next2 = it2.next();
                        if (mVar.removeSpecialChars(next2.text()).toLowerCase().contains(str.toLowerCase()) && BaseProcessor.isEnglishlang(next2.text(), mVar.f21094f.getTitle())) {
                            Iterator<Element> it3 = next.getElementsByTag("A").iterator();
                            while (it3.hasNext()) {
                                String strAttr = it3.next().attr("href");
                                if (strAttr.startsWith("magnet")) {
                                    if (mVar.f21099k) {
                                        return null;
                                    }
                                    if (App.getInstance().addHash(strAttr)) {
                                        if (RealDebridCommon.f12051p) {
                                            mVar.getClass();
                                            bc.a.getTorrent(strAttr, RealDebridCommon.f12049n, RealDebridCommon.f12047b).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new k(mVar, i10), new pd.a(17));
                                        }
                                        if (AllDebridCommon.f12043n) {
                                            list.add(strAttr);
                                        }
                                        if (PremiumizeCommon.f12045b) {
                                            mVar.getMagnetPrem(strAttr);
                                        }
                                        i11++;
                                        if (i11 > mVar.f12430a) {
                                            if (list.size() > 0) {
                                                mVar.addMagnetsAllDebrid(list);
                                            }
                                            return null;
                                        }
                                    }
                                }
                                i10 = 0;
                            }
                        }
                        i10 = 0;
                    }
                } else if (list.size() > 0) {
                    mVar.addMagnetsAllDebrid(list);
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((l) str);
    }
}
