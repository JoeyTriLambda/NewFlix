package sd;

import android.content.Context;
import android.os.AsyncTask;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* compiled from: EmoviesSeries.java */
/* loaded from: classes2.dex */
public final class b extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f19252f;

    /* renamed from: g, reason: collision with root package name */
    public int f19253g;

    /* renamed from: h, reason: collision with root package name */
    public int f19254h;

    /* renamed from: i, reason: collision with root package name */
    public String f19255i;

    public b(Context context, Movie movie, gd.f fVar) {
        this.f19252f = movie;
        this.f12431b = fVar;
        new ArrayList();
        this.f12433d = "https://emovies.si";
    }

    public void process(int i10, int i11, String str) {
        this.f19255i = str;
        this.f19253g = i10;
        this.f19254h = i11;
        Movie movie = this.f19252f;
        new a(this, movie.getTitle().replace(StringUtils.SPACE, "-").trim(), movie).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
