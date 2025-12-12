package sd;

import android.content.Context;
import android.os.AsyncTask;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* compiled from: LingSeries.java */
/* loaded from: classes2.dex */
public final class d extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f19257f;

    /* renamed from: g, reason: collision with root package name */
    public int f19258g;

    /* renamed from: h, reason: collision with root package name */
    public int f19259h;

    public d(Context context, Movie movie, gd.f fVar) {
        this.f19257f = movie;
        this.f12431b = fVar;
        new ArrayList();
        this.f12433d = "https://ling-online.net";
    }

    public void process(int i10, int i11) {
        this.f19258g = i10;
        this.f19259h = i11;
        this.f19257f.getTitle().replace(StringUtils.SPACE, "-").getClass();
        new c(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
