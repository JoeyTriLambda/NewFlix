package qd;

import android.content.Context;
import android.os.AsyncTask;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* compiled from: UpMovies.java */
/* loaded from: classes2.dex */
public final class x extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f18140f;

    public x(Context context, Movie movie, gd.f fVar) {
        this.f18140f = movie;
        this.f12431b = fVar;
        new ArrayList();
        this.f12433d = "https://upmovies.net";
    }

    public void process() {
        Movie movie = this.f18140f;
        String strReplace = movie.getTitle().replace(",", "").replace("(", "").replace(")", "");
        if (strReplace.toLowerCase().contains("birds of prey") && movie.I.equals("2020")) {
            strReplace = "Birds Of Prey";
        }
        strReplace.replace(StringUtils.SPACE, "+");
        new w(this, ac.c.p(new StringBuilder(), this.f12433d, "/search-movies/", BaseProcessor.removeSpecialCharsOld(movie.getTitle()).replace(StringUtils.SPACE, "+") + ".html")).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
