package td;

import android.util.Log;
import com.android.volley.Response;
import com.google.gson.r;
import flix.com.vision.activities.MovieDetailActivity;
import flix.com.vision.utils.JsonUtils;
import java.util.Iterator;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Response.Listener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19886b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ c f19887m;

    public /* synthetic */ a(c cVar, int i10) {
        this.f19886b = i10;
        this.f19887m = cVar;
    }

    @Override // com.android.volley.Response.Listener
    public final void onResponse(Object obj) {
        int i10 = this.f19886b;
        c cVar = this.f19887m;
        switch (i10) {
            case 0:
                cVar.getClass();
                String strValueOf = String.valueOf((String) obj);
                try {
                    jd.a movieHindi = JsonUtils.parseMovieHindi(strValueOf);
                    if (movieHindi == null) {
                        movieHindi = JsonUtils.parseMovieHindi2(strValueOf);
                    }
                    if (movieHindi != null) {
                        cVar.f19892h = movieHindi.f14690a;
                        String str = cVar.f12433d + movieHindi.f14691b;
                        if (movieHindi.f14691b.contains(cVar.f12433d) || movieHindi.f14691b.contains(".com")) {
                            str = movieHindi.f14691b;
                        }
                        cVar.GetStreamLinkHindi2(str);
                        break;
                    }
                } catch (Exception e10) {
                    Log.d(MovieDetailActivity.class.toString(), "", e10);
                }
                break;
            default:
                cVar.getClass();
                try {
                    Iterator<jd.b> it = JsonUtils.parsePlaylistHindi(r.parseString(String.valueOf((String) obj)).getAsJsonArray()).iterator();
                    while (it.hasNext()) {
                        try {
                            cVar.GetStreamLinkHindi3(it.next());
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
