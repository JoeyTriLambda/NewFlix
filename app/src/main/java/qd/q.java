package qd;

import android.content.Context;
import android.os.AsyncTask;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Movies123HubProcessorSeries.java */
/* loaded from: classes2.dex */
public final class q extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f18119f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList<hd.o> f18120g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    public int f18121h;

    /* renamed from: i, reason: collision with root package name */
    public int f18122i;

    public q(Context context, Movie movie, gd.f fVar) {
        this.f18119f = movie;
        this.f12433d = "https://123moviesgoto.com/";
    }

    public void Process(int i10, int i11) {
        this.f18121h = i10;
        this.f18122i = i11;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f12433d);
        sb2.append((this.f18119f.getTitle() + "-season-" + this.f18122i).replace(StringUtils.SPACE, "-").replace(",", "").replace(":", "").replace(".", "").replace("'", ""));
        new p(this, sb2.toString()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
