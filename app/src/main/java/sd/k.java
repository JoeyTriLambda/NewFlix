package sd;

import android.os.AsyncTask;
import flix.com.vision.App;
import flix.com.vision.models.Movie;
import hd.o;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.text.Regex;
import okhttp3.Response;
import org.jsoup.nodes.Element;

/* compiled from: ZoeChipSeries.java */
/* loaded from: classes2.dex */
public final class k extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Movie f19275a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f19276b;

    public k(l lVar, Movie movie) {
        this.f19276b = lVar;
        this.f19275a = movie;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        l lVar = this.f19276b;
        try {
            String str = lVar.f12433d + "/episode/" + be.f.createSlug(this.f19275a.getTitle()) + "-season-" + lVar.f19278g + "-episode-" + lVar.f19279h;
            String strAttr = ch.a.parse(App.get(str, lVar.f12433d).body().string()).getElementById("show_player_ajax").attr("movie-id");
            String str2 = lVar.f12433d + "/wp-admin/admin-ajax.php";
            HashMap map = new HashMap();
            map.put("action", "lazy_player");
            map.put("movieID", strAttr);
            Response responsePost = App.post(str2, map, str2);
            if (!responsePost.isSuccessful()) {
                return null;
            }
            Iterator<Element> it = ch.a.parse(responsePost.body().string()).getElementsByTag("LI").iterator();
            while (it.hasNext()) {
                Element next = it.next();
                if (next.text().toLowerCase().contains("filemoon")) {
                    String evalScriptFromHTML = lVar.getEvalScriptFromHTML(ch.a.parse(App.get(ch.a.parse(App.get(next.getElementsByTag("A").first().attr("data-server"), str).body().string()).getElementsByTag("IFRAME").first().attr("src"), str).body().string()));
                    if (evalScriptFromHTML == null) {
                        return null;
                    }
                    String str3 = new Regex("file:\\s*\"(.*?m3u8.*?)\"").find(new be.e(evalScriptFromHTML).unpack(), 0).getGroupValues().get(1);
                    o oVar = new o();
                    oVar.D = str3;
                    oVar.f13047w = true;
                    oVar.F = false;
                    oVar.f13039o = true;
                    oVar.C = "1080p - [FILEMOON] - [DIRECT] - English";
                    oVar.f13040p = str;
                    lVar.f12431b.OnSuccess(oVar);
                    return null;
                }
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((k) str);
    }
}
