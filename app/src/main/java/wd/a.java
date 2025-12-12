package wd;

import android.util.Log;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import cz.msebera.android.httpclient.HttpHost;
import flix.com.vision.activities.MovieDetailActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements se.f, Response.ErrorListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f21058b;

    @Override // se.f
    public final void accept(Object obj) {
        com.google.gson.o oVar = (com.google.gson.o) obj;
        c cVar = this.f21058b;
        if (cVar.f21064h) {
            return;
        }
        com.google.gson.q asJsonObject = oVar.getAsJsonObject();
        String asString = asJsonObject.get("id").getAsString();
        String asString2 = asJsonObject.get("uri").getAsString();
        if (asString2 != null && asString2.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            cVar.b(asString2, asString);
        } else {
            if (asString == null || asString.length() <= 0) {
                return;
            }
            cVar.b("https://api.real-debrid.com/rest/1.0/torrents/info/".concat(asString), asString);
        }
    }

    @Override // com.android.volley.Response.ErrorListener
    public final void onErrorResponse(VolleyError volleyError) {
        c cVar = this.f21058b;
        cVar.getClass();
        Log.d(MovieDetailActivity.class.toString(), "", null);
        cVar.appendLog("getTorrentInfo:" + volleyError.getMessage());
    }
}
