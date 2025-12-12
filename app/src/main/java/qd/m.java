package qd;

import android.content.Context;
import android.os.AsyncTask;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;

/* compiled from: GoMovies123ProcessorSeries.java */
/* loaded from: classes2.dex */
public final class m extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f18110f;

    /* renamed from: g, reason: collision with root package name */
    public int f18111g;

    /* renamed from: h, reason: collision with root package name */
    public int f18112h;

    public m(Context context, Movie movie, gd.f fVar) {
        this.f18110f = movie;
        this.f12431b = fVar;
        new ArrayList();
        this.f12433d = "https://www1.123moviesgo.ac";
    }

    public String getEpisodeId(String str) {
        String strAttr;
        try {
            Iterator<Element> it = ch.a.parse("<!DOCTYPE html>\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\"><body>" + bc.a.get123MoviesGoSeriesSeasonEpisodes(this.f12433d, str).execute().body() + "</body>").getElementsByClass("swiper-slide").iterator();
            while (it.hasNext()) {
                Element next = it.next();
                if (next.text().trim().toLowerCase(Locale.ROOT).contains("episode " + this.f18111g)) {
                    Iterator<Element> it2 = next.getElementsByTag("DIV").iterator();
                    while (it2.hasNext()) {
                        Element next2 = it2.next();
                        if (next2.attr("id").toLowerCase(Locale.ROOT).contains("episode") && (strAttr = next2.attr("data-id")) != null) {
                            return strAttr;
                        }
                    }
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void getEpisodeServers(String str) {
        String strAttr;
        try {
            Iterator<Element> it = ch.a.parse("<!DOCTYPE html>\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\"><body>" + bc.a.get123MoviesGoSeriesEpisodeServers(this.f12433d, str).execute().body() + "</body>").getElementsByTag("LI").iterator();
            while (it.hasNext()) {
                Element elementFirst = it.next().getElementsByTag("A").first();
                if (elementFirst != null && (strAttr = elementFirst.attr("data-id")) != null) {
                    bc.a.getLinks123MoviesGo(this.f12433d, strAttr).subscribeOn(gf.a.newThread()).observeOn(gf.a.newThread()).subscribe(new c1.c(this, 27), new pd.a(5));
                }
            }
        } catch (Exception unused) {
        }
    }

    public String getSeasonId(String str) {
        try {
            Iterator<Element> it = ch.a.parse("<!DOCTYPE html>\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\"><body>" + bc.a.get123MoviesGoSeriesSeasons(this.f12433d, str).execute().body() + "</body>").getElementsByTag("A").iterator();
            while (it.hasNext()) {
                Element next = it.next();
                if (next.text().trim().equalsIgnoreCase("season " + this.f18112h)) {
                    return next.attr("data-id");
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void process(int i10, int i11) {
        this.f18111g = i11;
        this.f18112h = i10;
        Movie movie = this.f18110f;
        String strReplace = movie.getTitle().replace(",", "").replace("(", "").replace(")", "");
        if (strReplace.toLowerCase().contains("birds of prey") && movie.I.equals("2020")) {
            strReplace = "Birds Of Prey";
        }
        strReplace.replace(StringUtils.SPACE, "+");
        new l(this, ac.c.p(new StringBuilder(), this.f12433d, "/search/", BaseProcessor.removeSpecialCharsOld(movie.getTitle()).replace(StringUtils.SPACE, "-"))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
