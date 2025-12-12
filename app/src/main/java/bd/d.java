package bd;

import android.os.AsyncTask;
import be.f;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import flix.com.vision.App;
import flix.com.vision.utils.JsonUtils;
import hd.o;
import java.util.Iterator;
import okhttp3.ResponseBody;
import org.jsoup.nodes.Element;

/* compiled from: GogoExtractor.java */
/* loaded from: classes2.dex */
public final class d extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4864a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f4865b;

    public d(e eVar, String str) {
        this.f4865b = eVar;
        this.f4864a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        ResponseBody responseBodyBody;
        String str = this.f4864a;
        e eVar = this.f4865b;
        try {
            responseBodyBody = App.getAjax("https://streamcool.pro/encrypt-ajax.php?" + ("id=" + f.cryptoHandler(str.split("id=")[1].split("&")[0], "9262859232435825", "93422192433952489752342908585752", true))).body();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (responseBodyBody == null) {
            return null;
        }
        String asString = JsonUtils.parse(f.cryptoHandler(JsonUtils.parse(responseBodyBody.string()).getAsJsonObject().get(JsonStorageKeyNames.DATA_KEY).getAsString(), "9262859232435825", "93422192433952489752342908585752", false)).getAsJsonObject().get("source").getAsJsonArray().get(0).getAsJsonObject().get("file").getAsString();
        o oVar = new o();
        oVar.D = asString;
        oVar.f13047w = true;
        oVar.F = false;
        oVar.C = "1080p - [GOGOSTREAM] - [DIRECT] - English";
        oVar.f13040p = eVar.f4866f;
        oVar.f13043s = 1080;
        eVar.f12431b.OnSuccess(oVar);
        pd.c cVar = new pd.c(eVar.f4867g, eVar.f12431b);
        cVar.f17674a = true;
        cVar.process(oVar);
        try {
            Iterator<Element> it = ch.a.parse(App.get(str, str).body().string()).select(".list-server-items > .linkserver").iterator();
            while (it.hasNext()) {
                Element next = it.next();
                try {
                    String strAttr = next.attr("data-status");
                    if (strAttr != null && strAttr.trim().equals("1")) {
                        String strAttr2 = next.attr("data-video");
                        o oVar2 = new o();
                        oVar2.D = strAttr2;
                        oVar2.F = true;
                        oVar2.C = eVar.checkLinkLabel(strAttr2);
                        eVar.addLink(oVar2);
                    }
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((d) str);
    }
}
