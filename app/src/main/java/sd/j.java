package sd;

import android.content.Context;
import android.os.AsyncTask;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;

/* compiled from: TvNowSeries.java */
/* loaded from: classes2.dex */
public final class j extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f19271f;

    /* renamed from: g, reason: collision with root package name */
    public final String f19272g = "https://bflix.gs/";

    /* renamed from: h, reason: collision with root package name */
    public int f19273h;

    /* renamed from: i, reason: collision with root package name */
    public int f19274i;

    public j(Context context, Movie movie, gd.f fVar) {
        this.f19271f = movie;
        this.f12431b = fVar;
        new ArrayList();
        this.f12433d = "https://myfilestorage.xyz";
    }

    public void process(int i10, int i11) {
        this.f19273h = i10;
        this.f19274i = i11;
        new i(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
