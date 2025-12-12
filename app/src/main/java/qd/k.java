package qd;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;

/* compiled from: GoMovies123Processor.java */
/* loaded from: classes2.dex */
public final class k extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f18107f;

    public k(Context context, Movie movie, gd.f fVar) {
        this.f18107f = movie;
        this.f12431b = fVar;
        new ArrayList();
        this.f12433d = "https://www1.123moviesgo.ac";
    }

    public hd.o getStreamRequest(String str) {
        String strAttr;
        try {
            Iterator<Element> it = ch.a.parse("<!DOCTYPE html>\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\"><body>" + bc.a.getLinks123MoviesGoMeta(this.f12433d, str).execute().body() + "</body>").getElementsByTag("LI").iterator();
            while (it.hasNext()) {
                Element elementFirst = it.next().getElementsByTag("A").first();
                if (elementFirst != null && (strAttr = elementFirst.attr("data-id")) != null) {
                    bc.a.getLinks123MoviesGo(this.f12433d, strAttr).subscribeOn(gf.a.newThread()).observeOn(gf.a.newThread()).subscribe(new c1.c(this, 26), new pd.a(4));
                }
            }
            return null;
        } catch (Exception e10) {
            Log.d("", e10.getMessage());
            return null;
        }
    }

    public void process() {
        Movie movie = this.f18107f;
        String strReplace = movie.getTitle().replace(",", "").replace("(", "").replace(")", "");
        if (strReplace.toLowerCase().contains("birds of prey") && movie.I.equals("2020")) {
            strReplace = "Birds Of Prey";
        }
        strReplace.replace(StringUtils.SPACE, "+");
        new j(this, ac.c.p(new StringBuilder(), this.f12433d, "/search/", BaseProcessor.removeSpecialCharsOld(movie.getTitle()).replace(StringUtils.SPACE, "-"))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
