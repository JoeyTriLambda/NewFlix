package sd;

import android.os.AsyncTask;
import flix.com.vision.App;
import hd.o;
import okhttp3.Response;
import org.adblockplus.libadblockplus.HttpClient;

/* compiled from: TvNowSeries.java */
/* loaded from: classes2.dex */
public final class i extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f19270a;

    public i(j jVar) {
        this.f19270a = jVar;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        String str;
        j jVar = this.f19270a;
        try {
            String str2 = jVar.f19274i + "";
            if (jVar.f19274i < 10) {
                str2 = "0" + jVar.f19274i;
            }
            String str3 = jVar.f12433d + "/tv/" + jVar.f19271f.getMovieId() + "/s" + jVar.f19273h + "/e" + str2 + ".mp4";
            Response response = App.get(str3, jVar.f19272g);
            if (!response.isSuccessful()) {
                str3 = jVar.f12433d + "/tv/" + jVar.f19271f.getImdbID() + "/s" + jVar.f19273h + "/e" + str2 + ".mp4";
                response = App.get(str3, jVar.f19272g);
                if (!response.isSuccessful()) {
                    return null;
                }
            }
            try {
                str = response.headers().get(HttpClient.HEADER_CONTENT_LENGTH);
            } catch (Exception unused) {
            }
            String str4 = str != null ? fd.e.readableFileSize(Long.parseLong(str)) : null;
            o oVar = new o();
            oVar.D = str3;
            oVar.f13047w = true;
            oVar.C = "1080p - [FILESTREAM] - [DIRECT] - English";
            if (str4 != null && !str4.contains("/")) {
                oVar.C = "1080p - [FILESTREAM] - [DIRECT] - [" + str4 + "] - English";
            }
            oVar.f13040p = jVar.f19272g;
            jVar.f12431b.OnSuccess(oVar);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((i) str);
    }
}
