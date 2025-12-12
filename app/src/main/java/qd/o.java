package qd;

import android.content.Context;
import android.os.AsyncTask;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Movies123HubProcessor.java */
/* loaded from: classes2.dex */
public final class o extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f18115f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList<hd.o> f18116g = new ArrayList<>();

    public o(Context context, Movie movie, gd.f fVar) {
        this.f18115f = movie;
        this.f12433d = "https://123moviesgoto.com/";
    }

    public void Process() {
        new n(this, this.f12433d + this.f18115f.getTitle().replace(StringUtils.SPACE, "-").replace(",", "").replace(":", "").replace(".", "").replace("'", "")).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
