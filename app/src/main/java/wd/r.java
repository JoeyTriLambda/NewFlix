package wd;

import android.os.AsyncTask;
import flix.com.vision.App;
import flix.com.vision.api.alldebrid.AllDebridCommon;
import flix.com.vision.api.premiumize.PremiumizeCommon;
import flix.com.vision.api.realdebrid.RealDebridCommon;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* compiled from: Torrentz2Series.java */
/* loaded from: classes2.dex */
public final class r extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f21112a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f21113b;

    public r(s sVar, String str) {
        this.f21113b = sVar;
        this.f21112a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        s sVar = this.f21113b;
        String str = null;
        try {
            Document document = ((dh.b) ch.a.connect(this.f21112a)).get();
            boolean z10 = sVar.f21120l;
            Movie movie = sVar.f21114f;
            if (z10) {
                return null;
            }
            String str2 = be.f.removeSpecialChars(movie.getTitle()) + sVar.f21119k;
            Iterator<Element> it = document.getElementsByTag("DL").iterator();
            int i10 = 0;
            while (true) {
                boolean zHasNext = it.hasNext();
                ArrayList arrayList = sVar.f21116h;
                if (zHasNext) {
                    Element next = it.next();
                    Iterator<Element> it2 = next.getElementsByTag("A").iterator();
                    while (it2.hasNext()) {
                        Element next2 = it2.next();
                        if (sVar.removeSpecialChars(next2.text()).toLowerCase().contains(str2.toLowerCase()) && BaseProcessor.isEnglishlang(next2.text(), movie.getTitle())) {
                            Iterator<Element> it3 = next.getElementsByTag("A").iterator();
                            while (it3.hasNext()) {
                                String strAttr = it3.next().attr("href");
                                if (strAttr.startsWith("magnet")) {
                                    if (sVar.f21120l) {
                                        return str;
                                    }
                                    if (App.getInstance().addHash(strAttr)) {
                                        if (RealDebridCommon.f12051p) {
                                            try {
                                                bc.a.getTorrent(strAttr, RealDebridCommon.f12049n, RealDebridCommon.f12047b).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new k(sVar, 2), new pd.a(21));
                                            } catch (Exception unused) {
                                                return null;
                                            }
                                        }
                                        if (AllDebridCommon.f12043n) {
                                            arrayList.add(strAttr);
                                        }
                                        if (PremiumizeCommon.f12045b) {
                                            sVar.getMagnetPrem(strAttr);
                                        }
                                        i10++;
                                        if (i10 > sVar.f12430a) {
                                            if (arrayList.size() <= 0) {
                                                return null;
                                            }
                                            sVar.addMagnetsAllDebrid(arrayList);
                                            return null;
                                        }
                                    }
                                }
                                str = null;
                            }
                        } else {
                            str = null;
                        }
                    }
                } else if (arrayList.size() > 0) {
                    sVar.addMagnetsAllDebrid(arrayList);
                }
            }
        } catch (Exception unused2) {
            return str;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((r) str);
    }
}
