package rd;

import android.content.Context;
import android.os.AsyncTask;
import flix.com.vision.App;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;

/* compiled from: ZoeChip.java */
/* loaded from: classes2.dex */
public final class h extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f18938f;

    public h(Context context, Movie movie, gd.f fVar) {
        this.f18938f = movie;
        this.f12431b = fVar;
        new ArrayList();
        this.f12433d = "https://www3.zoechip.com";
    }

    public final String b() {
        Movie movie = this.f18938f;
        try {
            Iterator<Element> it = ch.a.parse(App.get(this.f12433d + "/?s=" + movie.getTitle().replace(StringUtils.SPACE, "+"), this.f12433d).body().string()).getElementsByClass("flw-item").iterator();
            while (it.hasNext()) {
                Element next = it.next();
                String strRemoveSpecialCharsKeepSpace = be.f.removeSpecialCharsKeepSpace(next.text().toLowerCase());
                if (strRemoveSpecialCharsKeepSpace.contains(be.f.removeSpecialCharsKeepSpace(movie.getTitle()).toLowerCase()) && strRemoveSpecialCharsKeepSpace.contains(movie.I)) {
                    return next.getElementsByTag("A").first().attr("href");
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void process() {
        this.f18938f.getTitle().replace(StringUtils.SPACE, "-").getClass();
        new g(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
