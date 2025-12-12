package ub;

import android.util.Log;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import flix.com.vision.App;
import flix.com.vision.activities.LinksActivity;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.activities.MovieDetailActivity;
import flix.com.vision.activities.SearchActivityTV;
import flix.com.vision.activities.SearchResultsActivity;
import flix.com.vision.activities.SeriesDetailActivity;
import flix.com.vision.activities.TraktSignInActivity;
import flix.com.vision.activities.UserTorrentsActivity;
import flix.com.vision.activities.leanback.FilterActivityLeanBack;
import flix.com.vision.activities.leanback.fragment.TVListFragmentMain;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class n0 implements se.f, Response.ErrorListener, Response.Listener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20237b;

    public /* synthetic */ n0(int i10) {
        this.f20237b = i10;
    }

    @Override // se.f
    public final void accept(Object obj) {
        switch (this.f20237b) {
            case 0:
                int i10 = LinksActivity.C0;
                break;
            case 1:
                int i11 = MainActivity.f11697v0;
                Log.d(MainActivity.class.toString(), "", (Throwable) obj);
                break;
            case 2:
                int i12 = MainActivity.f11697v0;
                Log.d(MainActivity.class.toString(), "", (Throwable) obj);
                break;
            case 3:
                int i13 = MainActivity.f11697v0;
                break;
            case 4:
                int i14 = MovieDetailActivity.f11726u1;
                Log.d(MovieDetailActivity.class.toString(), "", (Throwable) obj);
                break;
            case 5:
                int i15 = MovieDetailActivity.f11726u1;
                Log.d(MovieDetailActivity.class.toString(), "", (Throwable) obj);
                break;
            case 6:
                int i16 = MovieDetailActivity.f11726u1;
                Log.d(MovieDetailActivity.class.toString(), "", (Throwable) obj);
                break;
            case 7:
                int i17 = MovieDetailActivity.f11726u1;
                Log.d(MovieDetailActivity.class.toString(), "", (Throwable) obj);
                break;
            case 8:
                int i18 = MovieDetailActivity.f11726u1;
                Log.d(MovieDetailActivity.class.toString(), "", (Throwable) obj);
                break;
            case 9:
                int i19 = MovieDetailActivity.f11726u1;
                Log.d(MovieDetailActivity.class.toString(), "", (Throwable) obj);
                break;
            case 10:
                int i20 = MovieDetailActivity.f11726u1;
                Log.d(MovieDetailActivity.class.toString(), "", (Throwable) obj);
                break;
            case 11:
                int i21 = MovieDetailActivity.f11726u1;
                break;
            case 12:
                int i22 = MovieDetailActivity.f11726u1;
                break;
            case 13:
                int i23 = MovieDetailActivity.f11726u1;
                Log.d(MovieDetailActivity.class.toString(), "", (Throwable) obj);
                break;
            case 14:
                int i24 = SearchActivityTV.f11775j0;
                Log.d(MainActivity.class.toString(), "", (Throwable) obj);
                break;
            case 15:
                int i25 = SearchResultsActivity.f11791i0;
                break;
            case 16:
                int i26 = SearchResultsActivity.f11791i0;
                break;
            case 17:
                int i27 = SeriesDetailActivity.f11800h0;
                Log.d("", "", (Throwable) obj);
                break;
            case 18:
            case 22:
            default:
                int i28 = TVListFragmentMain.T0;
                break;
            case 19:
                int i29 = UserTorrentsActivity.X;
                break;
            case 20:
                int i30 = UserTorrentsActivity.X;
                break;
            case 21:
                int i31 = UserTorrentsActivity.X;
                break;
            case 23:
                int i32 = UserTorrentsActivity.X;
                break;
            case 24:
                int i33 = FilterActivityLeanBack.f11904o0;
                Log.d(MainActivity.class.toString(), "", (Throwable) obj);
                break;
            case 25:
                int i34 = TVListFragmentMain.T0;
                break;
        }
    }

    @Override // com.android.volley.Response.ErrorListener
    public final void onErrorResponse(VolleyError volleyError) {
        switch (this.f20237b) {
            case 18:
                int i10 = TraktSignInActivity.Z;
                break;
            case 22:
                int i11 = UserTorrentsActivity.X;
                break;
            case 28:
                break;
            default:
                int i12 = od.a.f17071c;
                volleyError.printStackTrace();
                break;
        }
    }

    @Override // com.android.volley.Response.Listener
    public final void onResponse(Object obj) {
        try {
            App.F = ((JSONObject) obj).getJSONObject("images").getString("base_url");
            App.getInstance().f11574v.edit().putString("tmdb_base_url", App.F).apply();
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }
}
