package qd;

import android.content.Context;
import android.os.AsyncTask;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;

/* compiled from: WatchSeriesProcessor.java */
/* loaded from: classes2.dex */
public final class b0 extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f18076f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList<hd.o> f18077g;

    public b0(Context context, Movie movie, gd.f fVar) {
        this.f18076f = movie;
        this.f12431b = fVar;
        this.f12432c = context;
        this.f18077g = new ArrayList<>();
        new yd.a(context, fVar);
        this.f12433d = "https://www5.gowatchseries.tv";
    }

    public void process() {
        Movie movie = this.f18076f;
        String strReplace = movie.getTitle().replace("?", "").replace("&", "and");
        if (strReplace.toLowerCase().contains("birds of prey") && movie.I.equals("2020")) {
            strReplace = "Birds Of Prey";
        } else if (strReplace.toLowerCase().contains("mulan") && movie.I.equals("2020")) {
            strReplace = "Mulan";
        }
        new a0(this, this.f12433d + "/search.html?keyword=" + strReplace.replace("", ""), strReplace).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
