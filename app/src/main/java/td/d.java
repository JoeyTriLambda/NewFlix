package td;

import android.util.Log;
import com.android.volley.Response;
import com.google.gson.r;
import flix.com.vision.activities.MovieDetailActivity;
import flix.com.vision.utils.JsonUtils;
import java.util.Iterator;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class d implements Response.Listener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19898b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ f f19899m;

    public /* synthetic */ d(f fVar, int i10) {
        this.f19898b = i10;
        this.f19899m = fVar;
    }

    @Override // com.android.volley.Response.Listener
    public final void onResponse(Object obj) {
        int i10 = this.f19898b;
        f fVar = this.f19899m;
        switch (i10) {
            case 0:
                fVar.getClass();
                String strValueOf = String.valueOf((String) obj);
                try {
                    jd.a movieHindiSeries = JsonUtils.parseMovieHindiSeries(strValueOf);
                    if (movieHindiSeries == null) {
                        movieHindiSeries = JsonUtils.parseMovieHindiSeries2(strValueOf);
                    }
                    if (movieHindiSeries != null) {
                        fVar.f19904h = movieHindiSeries.f14690a;
                        String str = fVar.f12433d + movieHindiSeries.f14691b;
                        if (movieHindiSeries.f14691b.contains(fVar.f12433d) || movieHindiSeries.f14691b.contains(".com")) {
                            str = movieHindiSeries.f14691b;
                        }
                        fVar.GetStreamLinkHindi2(str);
                        break;
                    }
                } catch (Exception e10) {
                    Log.d(MovieDetailActivity.class.toString(), "", e10);
                }
                break;
            default:
                fVar.getClass();
                try {
                    Iterator<jd.b> it = JsonUtils.parsePlaylistHindiSeries(r.parseString(String.valueOf((String) obj)).getAsJsonArray(), fVar.f19905i, fVar.f19906j).iterator();
                    while (it.hasNext()) {
                        try {
                            fVar.GetStreamLinkHindi3(it.next());
                        } catch (Exception unused) {
                        }
                    }
                    break;
                } catch (Exception e11) {
                    try {
                        Log.d(MovieDetailActivity.class.toString(), "", e11);
                        return;
                    } catch (Exception e12) {
                        Log.d(MovieDetailActivity.class.toString(), "", e12);
                        return;
                    }
                }
        }
    }
}
