package sd;

import android.content.Context;
import android.os.AsyncTask;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;

/* compiled from: ZoeChipSeries.java */
/* loaded from: classes2.dex */
public final class l extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f19277f;

    /* renamed from: g, reason: collision with root package name */
    public int f19278g;

    /* renamed from: h, reason: collision with root package name */
    public int f19279h;

    public l(Context context, Movie movie, gd.f fVar) {
        this.f19277f = movie;
        this.f12431b = fVar;
        new ArrayList();
        this.f12433d = "https://zoechip.org";
    }

    public void process(int i10, int i11) {
        this.f19278g = i10;
        this.f19279h = i11;
        new k(this, this.f19277f).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
