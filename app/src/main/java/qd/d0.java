package qd;

import android.content.Context;
import android.os.AsyncTask;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* compiled from: WatchSeriesProcessorSeries.java */
/* loaded from: classes2.dex */
public final class d0 extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f18091f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList<hd.o> f18092g;

    /* renamed from: h, reason: collision with root package name */
    public int f18093h;

    /* renamed from: i, reason: collision with root package name */
    public int f18094i;

    public d0(Context context, Movie movie, gd.f fVar) {
        this.f18091f = movie;
        this.f12431b = fVar;
        this.f12432c = context;
        this.f18092g = new ArrayList<>();
        new yd.a(context, fVar);
        this.f12433d = "https://www5.gowatchseries.tv";
    }

    public void process(int i10, int i11) {
        this.f18093h = i11;
        this.f18094i = i10;
        Movie movie = this.f18091f;
        String strReplace = movie.getTitle().replace("?", "").replace("&", "and");
        int i12 = this.f18094i;
        int i13 = this.f18093h;
        if (strReplace.toLowerCase().contains("birds of prey") && movie.I.equals("2020")) {
            strReplace = "Birds Of Prey";
        }
        String str = strReplace;
        String strF = ac.c.f("season ", i12);
        StringBuilder sb2 = new StringBuilder("episode ");
        StringBuilder sb3 = i13 < 10 ? new StringBuilder("0") : new StringBuilder();
        sb3.append(i13);
        sb3.append(":");
        sb2.append(sb3.toString());
        String string = sb2.toString();
        String strD = o1.a.d("episode ", i13, ":");
        String strD2 = o1.a.d("episode ", i13, StringUtils.SPACE);
        String strD3 = o1.a.d("episode ", i13, "-");
        new c0(this, this.f12433d + "/search.html?keyword=" + str.replace("", "") + " season " + i12, str, strF, string, strD, strD2, ac.c.f("episode ", i13), strD3).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
