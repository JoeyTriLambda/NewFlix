package flix.com.vision.activities;

import android.os.AsyncTask;
import flix.com.vision.App;
import flix.com.vision.activities.DramaDetailActivity;
import hd.f;
import java.util.Collections;
import java.util.Iterator;
import kotlin.text.Regex;
import org.greenrobot.eventbus.EventBus;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* compiled from: DramaDetailActivity.java */
/* loaded from: classes2.dex */
public final class b extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public Document f11901a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f11902b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DramaDetailActivity f11903c;

    public b(DramaDetailActivity dramaDetailActivity, String str) {
        this.f11903c = dramaDetailActivity;
        this.f11902b = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        DramaDetailActivity dramaDetailActivity = this.f11903c;
        try {
            String str = this.f11902b;
            Document document = ch.a.parse(App.get(str, str).body().string());
            this.f11901a = document;
            Iterator<Element> it = document.select("ul.listing li, table.listing td.episodeSub").iterator();
            while (it.hasNext()) {
                Element next = it.next();
                String strAttr = next.selectFirst("a").attr("title");
                String str2 = dramaDetailActivity.W + next.selectFirst("a").attr("href");
                String str3 = new Regex("Episode\\s(\\d+)").find(strAttr, 0).getGroupValues().get(1);
                f fVar = new f();
                fVar.f13001u = Integer.parseInt(str3);
                fVar.f12994n = str2;
                fVar.f12996p = strAttr.replace(".", "").trim();
                dramaDetailActivity.V.add(fVar);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((b) str);
        Document document = this.f11901a;
        DramaDetailActivity dramaDetailActivity = this.f11903c;
        dramaDetailActivity.getClass();
        try {
            Iterator<Element> it = document.select("div.barContentInfo p:contains(Genres:) a").iterator();
            String strTrim = "";
            String strSubstring = "";
            while (it.hasNext()) {
                strSubstring = strSubstring + it.next().text().trim();
            }
            dramaDetailActivity.R.setText(document.selectFirst("div.barContentInfo p.des, div.barContentInfo p:last-child").nextElementSibling().select("p").text());
            Element elementFirst = document.getElementsByClass("barContentInfo").first();
            if (elementFirst != null) {
                Iterator<Element> it2 = elementFirst.getElementsByTag("A").iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Element next = it2.next();
                    if (next.attr("href").contains("country")) {
                        strTrim = next.text().trim();
                        break;
                    }
                }
            }
            if (strSubstring.length() > 60) {
                strSubstring = strSubstring.substring(0, 60);
            }
            dramaDetailActivity.M.setText(dramaDetailActivity.U.f12387b + " · " + strTrim + " · " + strSubstring);
        } catch (Exception unused) {
        }
        if (dramaDetailActivity.V.size() != 1) {
            if (dramaDetailActivity.V.size() <= 0) {
                EventBus.getDefault().post(DramaDetailActivity.RESULT_EVENT.EPISODE_FAILED);
                return;
            } else {
                Collections.reverse(dramaDetailActivity.V);
                EventBus.getDefault().post(DramaDetailActivity.RESULT_EVENT.SUCCESS);
                return;
            }
        }
        if (dramaDetailActivity.V.size() == 1) {
            dramaDetailActivity.X.setVisibility(0);
            dramaDetailActivity.O.setVisibility(8);
            dramaDetailActivity.P.setVisibility(8);
            dramaDetailActivity.P.clearFocus();
            dramaDetailActivity.X.requestFocus();
            dramaDetailActivity.openEpisode(0);
        }
    }
}
