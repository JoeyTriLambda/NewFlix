package qd;

import android.os.AsyncTask;
import cz.msebera.android.httpclient.HttpHost;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;

/* compiled from: Movies123ToSeries.java */
/* loaded from: classes2.dex */
public final class t extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f18126a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f18127b;

    public t(u uVar, String str) {
        this.f18127b = uVar;
        this.f18126a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        String strAttr;
        u uVar = this.f18127b;
        try {
            Iterator<Element> it = ((dh.b) ch.a.connect(this.f18126a)).get().getElementsByClass("ml-item").iterator();
            while (it.hasNext()) {
                Element elementFirst = it.next().getElementsByTag("A").first();
                if (elementFirst != null) {
                    String strRemoveSpecialChars = uVar.removeSpecialChars(elementFirst.attr("title"));
                    String str = uVar.removeSpecialChars(uVar.f18128f.getTitle()) + "season" + uVar.f18130h;
                    String str2 = uVar.removeSpecialChars(uVar.f18128f.getTitle().replace("&", "and")) + "season" + uVar.f18130h;
                    if (strRemoveSpecialChars != null && (strRemoveSpecialChars.equalsIgnoreCase(str) || strRemoveSpecialChars.equalsIgnoreCase(str2))) {
                        String strAttr2 = elementFirst.attr("href");
                        if (strAttr2 != null && !strAttr2.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                            if (strAttr2.startsWith("/")) {
                                strAttr2 = uVar.f12433d + strAttr2;
                            } else {
                                strAttr2 = uVar.f12433d + "/" + strAttr2;
                            }
                        }
                        Iterator<Element> it2 = ((dh.b) ch.a.connect(strAttr2)).get().getElementsByClass("les-content").first().getElementsByTag("A").iterator();
                        while (it2.hasNext()) {
                            Element next = it2.next();
                            if (next != null) {
                                String strReplace = next.text().toLowerCase().trim().replace(StringUtils.SPACE, "");
                                if (!strReplace.equals("episode" + uVar.f18129g)) {
                                    if (strReplace.equals("episode0" + uVar.f18129g)) {
                                    }
                                }
                                String strAttr3 = next.attr("href");
                                if (strAttr3 != null) {
                                    if (strAttr3.startsWith("/")) {
                                        strAttr3 = uVar.f12433d + strAttr3;
                                    } else if (!strAttr3.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                                        strAttr3 = uVar.f12433d + "/" + strAttr3;
                                    }
                                    Element elementById = ((dh.b) ch.a.connect(strAttr3)).get().getElementById("list-eps");
                                    if (elementById != null) {
                                        Iterator<Element> it3 = elementById.getElementsByClass("les-content").iterator();
                                        while (it3.hasNext()) {
                                            Element elementFirst2 = it3.next().getElementsByTag("a").first();
                                            if (elementFirst2 != null && (strAttr = elementFirst2.attr("data-file")) != null && !strAttr.isEmpty()) {
                                                hd.o oVar = new hd.o();
                                                oVar.D = strAttr;
                                                oVar.F = true;
                                                oVar.C = uVar.checkLinkLabel(strAttr);
                                                uVar.addLink(oVar);
                                            }
                                        }
                                    }
                                }
                            }
                        }
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
        super.onPostExecute((t) str);
    }
}
