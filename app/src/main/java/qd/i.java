package qd;

import android.content.Context;
import android.os.AsyncTask;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Chill123ToSeries.java */
/* loaded from: classes2.dex */
public final class i extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f18102f;

    /* renamed from: g, reason: collision with root package name */
    public int f18103g;

    /* renamed from: h, reason: collision with root package name */
    public int f18104h;

    public i(Context context, Movie movie, gd.f fVar) {
        this.f18102f = movie;
        this.f12431b = fVar;
        new ArrayList();
        this.f12433d = "https://123chill.site/";
    }

    public void process(int i10, int i11) {
        this.f18104h = i10;
        this.f18103g = i11;
        Movie movie = this.f18102f;
        String strReplace = movie.getTitle().replace(",", "").replace("(", "").replace(")", "");
        if (strReplace.toLowerCase().contains("birds of prey") && movie.I.equals("2020")) {
            strReplace = "Birds Of Prey";
        }
        strReplace.replace(StringUtils.SPACE, "+");
        new h(this, ac.c.p(new StringBuilder(), this.f12433d, "/?s=", BaseProcessor.removeSpecialCharsOld(movie.getTitle()).replace(StringUtils.SPACE, "+"))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
