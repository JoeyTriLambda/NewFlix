package flix.com.vision.activities;

import android.os.AsyncTask;
import com.unity3d.ads.metadata.MediationMetaData;
import flix.com.vision.activities.AnimeDetailActivity;
import hd.f;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: AnimeDetailActivity.java */
/* loaded from: classes2.dex */
public final class a extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11884a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f11885b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AnimeDetailActivity f11886c;

    public a(AnimeDetailActivity animeDetailActivity, String str, String str2) {
        this.f11886c = animeDetailActivity;
        this.f11884a = str;
        this.f11885b = str2;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        AnimeDetailActivity animeDetailActivity = this.f11886c;
        try {
            Document document = ((dh.b) ch.a.connect(this.f11884a)).get();
            Element elementById = document.getElementById("movie_id");
            String strAttr = elementById.attr("value");
            String strAttr2 = elementById.attr("default_ep");
            String strAttr3 = elementById.attr("alias_anime");
            Iterator<Element> it = document.getElementById("episode_page").getElementsByTag("a").iterator();
            while (it.hasNext()) {
                Element next = it.next();
                Elements elementsByTag = ((dh.b) ch.a.connect(this.f11885b + "/ajax/load-list-episode?ep_start=" + next.attr("ep_start") + "&ep_end=" + next.attr("ep_end") + "&id=" + strAttr + "&default_ep=" + strAttr2 + "&alias_anime=" + strAttr3)).get().getElementsByTag("li");
                Collections.reverse(elementsByTag);
                Iterator<Element> it2 = elementsByTag.iterator();
                while (it2.hasNext()) {
                    Element next2 = it2.next();
                    try {
                        String str = animeDetailActivity.W + next2.getElementsByTag("a").first().attr("href").trim();
                        String strTrim = next2.getElementsByClass(MediationMetaData.KEY_NAME).first().text().replace("EP ", "").trim();
                        f fVar = new f();
                        fVar.f12994n = str;
                        fVar.f12996p = strTrim;
                        fVar.f13000t = strTrim;
                        try {
                            fVar.f13001u = Integer.parseInt(strTrim);
                        } catch (Exception unused) {
                        }
                        fVar.f13002v = true;
                        animeDetailActivity.V.add(fVar);
                    } catch (Exception unused2) {
                    }
                }
            }
            return null;
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        } catch (Exception unused3) {
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((a) str);
        AnimeDetailActivity animeDetailActivity = this.f11886c;
        if (animeDetailActivity.V.size() != 1) {
            if (animeDetailActivity.V.size() > 0) {
                EventBus.getDefault().post(AnimeDetailActivity.RESULT_EVENT.SUCCESS);
                return;
            } else {
                EventBus.getDefault().post(AnimeDetailActivity.RESULT_EVENT.EPISODE_FAILED);
                return;
            }
        }
        if (animeDetailActivity.V.size() == 1) {
            animeDetailActivity.Y.setVisibility(0);
            animeDetailActivity.O.setVisibility(8);
            animeDetailActivity.P.setVisibility(8);
            animeDetailActivity.P.clearFocus();
            animeDetailActivity.Y.requestFocus();
        }
    }
}
