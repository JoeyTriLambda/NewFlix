package qd;

import android.os.AsyncTask;
import cz.msebera.android.httpclient.HttpHost;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;

/* compiled from: Chill123ToSeries.java */
/* loaded from: classes2.dex */
public final class h extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f18100a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f18101b;

    public h(i iVar, String str) {
        this.f18101b = iVar;
        this.f18100a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        Element elementFirst;
        String strAttr;
        i iVar = this.f18101b;
        try {
            Iterator<Element> it = ((dh.b) ch.a.connect(this.f18100a)).get().getElementsByClass("ml-item").iterator();
            while (it.hasNext()) {
                Element elementFirst2 = it.next().getElementsByTag("A").first();
                if (elementFirst2 != null) {
                    String strRemoveSpecialChars = iVar.removeSpecialChars(elementFirst2.attr("title"));
                    String str = iVar.removeSpecialChars(iVar.f18102f.getTitle()) + "season" + iVar.f18104h;
                    if (strRemoveSpecialChars != null) {
                        if (strRemoveSpecialChars.toLowerCase().equals(str.toLowerCase() + iVar.f18102f.I) || strRemoveSpecialChars.equalsIgnoreCase(str)) {
                            String strAttr2 = elementFirst2.attr("href");
                            if (strAttr2 != null && !strAttr2.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                                strAttr2 = strAttr2.startsWith("/") ? iVar.f12433d + strAttr2 : iVar.f12433d + "/" + strAttr2;
                            }
                            String str2 = strAttr2 + "?action=watching&server=";
                            for (int i10 = 0; i10 < 5; i10++) {
                                Element elementById = ((dh.b) ch.a.connect(str2 + i10 + "&movie=" + iVar.f18102f.getTitle().replace("'", "").replace(StringUtils.SPACE, "-") + "-" + iVar.f18104h + "x" + iVar.f18103g)).get().getElementById("playerMovie");
                                if (elementById != null && (elementFirst = elementById.getElementsByTag("IFRAME").first()) != null && (strAttr = elementFirst.attr("src")) != null && !strAttr.isEmpty()) {
                                    if (strAttr.startsWith("//")) {
                                        strAttr = "http:" + strAttr;
                                    }
                                    hd.o oVar = new hd.o();
                                    oVar.D = strAttr;
                                    oVar.F = true;
                                    oVar.C = iVar.checkLinkLabel(strAttr);
                                    iVar.addLink(oVar);
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
        super.onPostExecute((h) str);
    }
}
