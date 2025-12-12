package qd;

import android.content.Context;
import android.os.AsyncTask;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* compiled from: UpMoviesSeries.java */
/* loaded from: classes2.dex */
public final class z extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f18144f;

    /* renamed from: g, reason: collision with root package name */
    public int f18145g;

    /* renamed from: h, reason: collision with root package name */
    public int f18146h;

    public z(Context context, Movie movie, gd.f fVar) {
        this.f18144f = movie;
        this.f12431b = fVar;
        new ArrayList();
        this.f12433d = "https://upmovies.net";
    }

    public void process(int i10, int i11) {
        this.f18145g = i11;
        this.f18146h = i10;
        StringBuilder sbU = ac.c.u(BaseProcessor.removeSpecialCharsOld(this.f18144f.getTitle()), " season ");
        sbU.append(this.f18146h);
        String string = sbU.toString();
        new y(this, ac.c.p(new StringBuilder(), this.f12433d, "/search-movies/", string.replace(StringUtils.SPACE, "+") + ".html"), string).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
