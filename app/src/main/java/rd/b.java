package rd;

import android.content.Context;
import android.os.AsyncTask;
import flix.com.vision.App;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.nodes.Element;

/* compiled from: KissAsian.java */
/* loaded from: classes2.dex */
public final class b extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Context f18930f;

    public b(Context context, Movie movie, gd.f fVar) {
        this.f18930f = context;
        this.f12431b = fVar;
        new ArrayList();
        this.f12433d = "https://kissasiantv.to";
    }

    public static void b() {
        try {
            Element element = ch.a.parse(App.get("https://kissasiantv.to/drama-list.html", "https://kissasiantv.to/drama-list.html").body().string()).getElementsByClass("barContentgenres").get(1);
            ArrayList arrayList = new ArrayList();
            Iterator<Element> it = element.getElementsByTag("LI").iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getElementsByTag("A").first().attr("title"));
            }
            Iterator it2 = arrayList.iterator();
            String str = "";
            while (it2.hasNext()) {
                str = str + ((String) it2.next()) + ",";
            }
        } catch (Exception unused) {
        }
    }

    public void process(String str) {
        new a(this, str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
