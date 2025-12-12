package rd;

import android.content.Context;
import android.os.AsyncTask;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* compiled from: MoFlix.java */
/* loaded from: classes2.dex */
public final class d extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f18932f;

    public d(Context context, Movie movie, gd.f fVar) {
        this.f18932f = movie;
        this.f12431b = fVar;
        new ArrayList();
        this.f12433d = "https://moflix-stream.xyz";
    }

    public void process() {
        this.f18932f.getTitle().replace(StringUtils.SPACE, "-").getClass();
        new c(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
