package rd;

import android.os.AsyncTask;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import flix.com.vision.App;
import flix.com.vision.utils.JsonUtils;
import hd.o;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.ResponseBody;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* compiled from: KissAsian.java */
/* loaded from: classes2.dex */
public final class a extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f18928a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f18929b;

    public a(b bVar, String str) {
        this.f18929b = bVar;
        this.f18928a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        String str;
        Document document;
        ResponseBody responseBodyBody;
        b bVar = this.f18929b;
        try {
            bVar.getClass();
            b.b();
            new ArrayList();
            String str2 = this.f18928a;
            str = "https:" + ch.a.parse(App.get(str2, str2).body().string()).getElementsByTag("IFRAME").first().attr("src");
            document = ch.a.parse(App.get(str, bVar.f12433d).body().string());
            String str3 = str.split("id=")[1].split("&")[0];
            responseBodyBody = App.getAjax(("https://" + new URI(str).getHost()) + "/encrypt-ajax.php?" + ("id=" + be.f.cryptoHandler(str3, "9262859232435825", "93422192433952489752342908585752", true))).body();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (responseBodyBody == null) {
            return null;
        }
        String asString = JsonUtils.parse(be.f.cryptoHandler(JsonUtils.parse(responseBodyBody.string()).getAsJsonObject().get(JsonStorageKeyNames.DATA_KEY).getAsString(), "9262859232435825", "93422192433952489752342908585752", false)).getAsJsonObject().get("source").getAsJsonArray().get(0).getAsJsonObject().get("file").getAsString();
        o oVar = new o();
        oVar.D = asString;
        oVar.f13047w = true;
        oVar.F = false;
        oVar.C = "1080p - [GOGOSTREAM] - [DIRECT]";
        oVar.f13040p = str;
        oVar.f13043s = 1080;
        bVar.f12431b.OnSuccess(oVar);
        pd.c cVar = new pd.c(bVar.f18930f, bVar.f12431b);
        cVar.f17674a = true;
        cVar.process(oVar);
        Iterator<Element> it = document.select(".list-server-items > .linkserver").iterator();
        while (it.hasNext()) {
            Element next = it.next();
            try {
                String strAttr = next.attr("data-status");
                if (strAttr != null && strAttr.trim().equals("1")) {
                    String strAttr2 = next.attr("data-video");
                    o oVar2 = new o();
                    oVar2.D = strAttr2;
                    oVar2.F = true;
                    oVar2.C = bVar.checkLinkLabel(strAttr2);
                    bVar.addLink(oVar2);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((a) str);
    }
}
