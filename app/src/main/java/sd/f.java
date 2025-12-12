package sd;

import android.content.Context;
import android.os.AsyncTask;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;

/* compiled from: MoFlixSeries.java */
/* loaded from: classes2.dex */
public final class f extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f19261f;

    /* renamed from: g, reason: collision with root package name */
    public int f19262g;

    /* renamed from: h, reason: collision with root package name */
    public int f19263h;

    public f(Context context, Movie movie, gd.f fVar) {
        this.f19261f = movie;
        this.f12431b = fVar;
        new ArrayList();
        this.f12433d = "https://moflix-stream.xyz";
    }

    public void process(int i10, int i11) {
        this.f19262g = i10;
        this.f19263h = i11;
        new e(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
