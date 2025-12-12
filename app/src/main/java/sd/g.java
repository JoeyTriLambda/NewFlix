package sd;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import com.google.gson.q;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import flix.com.vision.App;
import flix.com.vision.models.Movie;
import flix.com.vision.utils.JsonUtils;
import hd.o;
import kotlin.text.Regex;
import okhttp3.Response;

/* compiled from: RidoMoviesSeries.java */
/* loaded from: classes2.dex */
public final class g extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f19264a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Movie f19265b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f19266c;

    public g(h hVar, String str, Movie movie) {
        this.f19266c = hVar;
        this.f19264a = str;
        this.f19265b = movie;
    }

    @Override // android.os.AsyncTask
    @SuppressLint({"StaticFieldLeak"})
    public String doInBackground(Void... voidArr) {
        String strB;
        q asJsonObject;
        h hVar = this.f19266c;
        try {
            Response response = App.get(this.f19264a, hVar.f12433d);
            if (response != null && response.isSuccessful() && (strB = hVar.b(response.body().string(), this.f19265b.J)) != null) {
                String[] strArrSplit = strB.split("-");
                Response response2 = App.get(hVar.f12433d + "/tv/" + strB.replace("-" + strArrSplit[strArrSplit.length - 1], "") + "/season-" + hVar.f19268g + "/episode-" + hVar.f19269h, hVar.f12433d);
                if (response2 != null && response2.isSuccessful()) {
                    Response response3 = App.get(hVar.f12433d + "/core/api/episodes/" + response2.body().string().split("postid")[1].split(",")[0].replace(":", "").replace("\"", "").replace("\\", "") + "/videos", hVar.f12433d);
                    if (response3 != null && response3.isSuccessful() && (asJsonObject = JsonUtils.parse(response3.body().string()).getAsJsonObject()) != null) {
                        com.google.gson.l asJsonArray = asJsonObject.get(JsonStorageKeyNames.DATA_KEY).getAsJsonArray();
                        for (int i10 = 0; i10 < asJsonArray.size(); i10++) {
                            q asJsonObject2 = asJsonArray.get(i10).getAsJsonObject();
                            String asString = asJsonObject2.get("quality").getAsString();
                            String asString2 = asJsonObject2.get("lang").getAsString();
                            String strAttr = ch.a.parse(asJsonObject2.get("url").getAsString()).getElementsByTag("IFRAME").first().attr("data-src");
                            if (strAttr.startsWith("https://closeload.top")) {
                                Response response4 = App.get(strAttr, hVar.f12433d);
                                if (response4 != null && response4.isSuccessful()) {
                                    String strDecodeBase64 = be.f.decodeBase64(new Regex("=\"(aHR.*?)\";").find(new be.e(hVar.getEvalScriptFromHTML(ch.a.parse(response4.body().string()))).unpack(), 0).getGroupValues().get(1));
                                    if (be.f.notNull(strDecodeBase64)) {
                                        o oVar = new o();
                                        oVar.D = strDecodeBase64;
                                        oVar.f13047w = true;
                                        oVar.F = false;
                                        oVar.f13049y = true;
                                        if (asString != null && asString.trim().toLowerCase().equals("hd")) {
                                            asString = "1080p";
                                        }
                                        oVar.C = asString + " - [CLOSELOAD] - [DIRECT] - " + asString2;
                                        oVar.f13040p = strAttr;
                                        hVar.f12431b.OnSuccess(oVar);
                                    }
                                }
                                return null;
                            }
                        }
                    }
                }
                return null;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((g) str);
    }
}
