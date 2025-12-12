package rd;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import com.google.gson.l;
import com.google.gson.q;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import flix.com.vision.App;
import flix.com.vision.models.Movie;
import flix.com.vision.utils.JsonUtils;
import hd.o;
import kotlin.text.Regex;
import okhttp3.Response;

/* compiled from: RidoMovies.java */
/* loaded from: classes2.dex */
public final class e extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f18933a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Movie f18934b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f18935c;

    public e(f fVar, String str, Movie movie) {
        this.f18935c = fVar;
        this.f18933a = str;
        this.f18934b = movie;
    }

    @Override // android.os.AsyncTask
    @SuppressLint({"StaticFieldLeak"})
    public String doInBackground(Void... voidArr) {
        String strB;
        q asJsonObject;
        f fVar = this.f18935c;
        try {
            Response response = App.get(this.f18933a, fVar.f12433d);
            if (response != null && response.isSuccessful() && (strB = fVar.b(response.body().string(), this.f18934b.J)) != null) {
                Response response2 = App.get(fVar.f12433d + "/core/api/movies/" + strB + "/videos", fVar.f12433d);
                if (response2 != null && response2.isSuccessful() && (asJsonObject = JsonUtils.parse(response2.body().string()).getAsJsonObject()) != null) {
                    l asJsonArray = asJsonObject.get(JsonStorageKeyNames.DATA_KEY).getAsJsonArray();
                    for (int i10 = 0; i10 < asJsonArray.size(); i10++) {
                        q asJsonObject2 = asJsonArray.get(i10).getAsJsonObject();
                        String asString = asJsonObject2.get("quality").getAsString();
                        String asString2 = asJsonObject2.get("lang").getAsString();
                        String strAttr = ch.a.parse(asJsonObject2.get("url").getAsString()).getElementsByTag("IFRAME").first().attr("data-src");
                        if (strAttr.startsWith("https://closeload.top")) {
                            Response response3 = App.get(strAttr, fVar.f12433d);
                            if (response3 != null && response3.isSuccessful()) {
                                String strDecodeBase64 = be.f.decodeBase64(new Regex("=\"(aHR.*?)\";").find(new be.e(fVar.getEvalScriptFromHTML(ch.a.parse(response3.body().string()))).unpack(), 0).getGroupValues().get(1));
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
                                    fVar.f12431b.OnSuccess(oVar);
                                }
                            }
                            return null;
                        }
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((e) str);
    }
}
