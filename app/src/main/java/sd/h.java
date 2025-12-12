package sd;

import android.content.Context;
import android.os.AsyncTask;
import com.google.gson.q;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import flix.com.vision.models.Movie;
import flix.com.vision.processors.english.BaseProcessor;
import flix.com.vision.utils.JsonUtils;
import java.util.ArrayList;

/* compiled from: RidoMoviesSeries.java */
/* loaded from: classes2.dex */
public final class h extends BaseProcessor {

    /* renamed from: f, reason: collision with root package name */
    public final Movie f19267f;

    /* renamed from: g, reason: collision with root package name */
    public int f19268g;

    /* renamed from: h, reason: collision with root package name */
    public int f19269h;

    public h(Context context, Movie movie, gd.f fVar) {
        this.f19267f = movie;
        this.f12431b = fVar;
        new ArrayList();
        this.f12433d = "https://ridomovies.tv";
    }

    public final String b(String str, String str2) {
        try {
            q asJsonObject = JsonUtils.parse(str).getAsJsonObject().get(JsonStorageKeyNames.DATA_KEY).getAsJsonObject().get("items").getAsJsonArray().get(0).getAsJsonObject();
            String asString = asJsonObject.get("contentable").getAsJsonObject().get("imdbId").getAsString();
            if (asString != null && asString.equalsIgnoreCase(str2)) {
                return asJsonObject.get("slug").getAsString();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void process(int i10, int i11) {
        this.f19268g = i10;
        this.f19269h = i11;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f12433d);
        sb2.append("/core/api/search?q=");
        Movie movie = this.f19267f;
        sb2.append(movie.J);
        new g(this, sb2.toString(), movie).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
