package qd;

import android.content.Context;
import android.os.AsyncTask;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Movies123ToSeries.java */
/* loaded from: classes2.dex */
public final class u extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f18128f;

    /* renamed from: g, reason: collision with root package name */
    public int f18129g;

    /* renamed from: h, reason: collision with root package name */
    public int f18130h;

    public u(Context context, Movie movie, gd.f fVar) {
        this.f18128f = movie;
        this.f12431b = fVar;
        new ArrayList();
        this.f12433d = "https://www1.123moviesto.to";
    }

    public void Process(int i10, int i11) {
        this.f18129g = i11;
        this.f18130h = i10;
        Movie movie = this.f18128f;
        String strReplace = movie.getTitle().replace(",", "").replace("(", "").replace(")", "");
        if (strReplace.toLowerCase().contains("birds of prey") && movie.I.equals("2020")) {
            strReplace = "Birds Of Prey";
        }
        strReplace.replace(StringUtils.SPACE, "+");
        new t(this, ac.c.p(new StringBuilder(), this.f12433d, "/search/", BaseProcessor.removeSpecialCharsOld(movie.getTitle()).replace(StringUtils.SPACE, "%20"))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
