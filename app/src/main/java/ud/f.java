package ud;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import flix.com.vision.App;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import flix.com.vision.tv.Constant;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* compiled from: MovieRulzHindi.java */
/* loaded from: classes2.dex */
public final class f extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f20371f;

    public f(Context context, Movie movie, gd.f fVar) {
        this.f20371f = movie;
        this.f12431b = fVar;
        new ArrayList();
        this.f12433d = "https://ww9.watchmovierulz.ws/";
    }

    public void process() {
        SharedPreferences sharedPreferences = App.getInstance().f11574v;
        String str = Constant.f12450b;
        this.f12433d = sharedPreferences.getString("MovieRulzHindi_url", this.f12433d);
        Movie movie = this.f20371f;
        String strReplace = movie.getTitle().replace(",", "").replace("(", "").replace(")", "");
        if (strReplace.toLowerCase().contains("birds of prey") && movie.I.equals("2020")) {
            strReplace = "Birds Of Prey";
        }
        strReplace.replace(StringUtils.SPACE, "+");
        new e(this, this.f12433d + "search_movies?s=" + BaseProcessor.removeSpecialCharsOld(movie.getTitle()).replace(StringUtils.SPACE, "+").trim()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
