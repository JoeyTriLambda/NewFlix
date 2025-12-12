package qd;

import android.os.AsyncTask;
import android.util.Base64;
import cz.msebera.android.httpclient.HttpHost;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Element;

/* compiled from: UpMoviesSeries.java */
/* loaded from: classes2.dex */
public final class y extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f18141a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f18142b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ z f18143c;

    public y(z zVar, String str, String str2) {
        this.f18143c = zVar;
        this.f18141a = str;
        this.f18142b = str2;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        Element elementFirst;
        z zVar = this.f18143c;
        try {
            Iterator<Element> it = ((dh.b) ch.a.connect(this.f18141a)).get().getElementsByClass("itemBody").iterator();
            while (it.hasNext()) {
                Element elementFirst2 = it.next().getElementsByClass("title").first();
                if (elementFirst2 != null) {
                    String strRemoveSpecialChars = zVar.removeSpecialChars(elementFirst2.text().trim());
                    String strRemoveSpecialChars2 = zVar.removeSpecialChars(this.f18142b);
                    if (strRemoveSpecialChars != null && strRemoveSpecialChars.equalsIgnoreCase(strRemoveSpecialChars2) && (elementFirst = elementFirst2.getElementsByTag("A").first()) != null) {
                        String strAttr = elementFirst.attr("href");
                        if (strAttr != null && !strAttr.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                            if (strAttr.startsWith("/")) {
                                strAttr = zVar.f12433d + strAttr;
                            } else {
                                strAttr = zVar.f12433d + "/" + strAttr;
                            }
                        }
                        Element elementById = ((dh.b) ch.a.connect(strAttr)).get().getElementById("details");
                        if (elementById != null) {
                            Iterator<Element> it2 = elementById.getElementsByTag("A").iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    Element next = it2.next();
                                    if (next.text().trim().equalsIgnoreCase(zVar.f18145g + "")) {
                                        Iterator<Element> it3 = ((dh.b) ch.a.connect(next.attr("href"))).get().getElementsByTag("DIV").iterator();
                                        while (true) {
                                            if (!it3.hasNext()) {
                                                break;
                                            }
                                            Element next2 = it3.next();
                                            String strAttr2 = next2.attr("class");
                                            if (strAttr2 != null && strAttr2.contains("player-iframe")) {
                                                Element elementFirst3 = next2.getElementsByTag("SCRIPT").first();
                                                if (elementFirst3 != null) {
                                                    String string = elementFirst3.toString();
                                                    zVar.getClass();
                                                    Matcher matcher = Pattern.compile("Base64.decode\\('(.*?)'").matcher(string.replace("\"", "'"));
                                                    String strGroup = matcher.find() ? matcher.group(1) : null;
                                                    if (strGroup != null) {
                                                        String str = new String(Base64.decode(strGroup, 0), StandardCharsets.UTF_8);
                                                        zVar.getClass();
                                                        Matcher matcher2 = Pattern.compile("src='(.*?)'").matcher(str.replace("\"", "'"));
                                                        String strGroup2 = matcher2.find() ? matcher2.group(1) : null;
                                                        if (strGroup2 != null && !strGroup2.isEmpty()) {
                                                            hd.o oVar = new hd.o();
                                                            oVar.D = strGroup2;
                                                            oVar.F = true;
                                                            oVar.C = zVar.checkLinkLabel(strGroup2) + " - [FPS]";
                                                            zVar.addLink(oVar);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((y) str);
    }
}
