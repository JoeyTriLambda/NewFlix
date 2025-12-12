package ub;

import android.app.Application;
import android.os.AsyncTask;
import com.jakewharton.threetenabp.AndroidThreeTen;
import com.uwetrottmann.trakt5.TraktV2;
import com.uwetrottmann.trakt5.entities.BaseMovie;
import com.uwetrottmann.trakt5.entities.BaseShow;
import com.uwetrottmann.trakt5.entities.UserSlug;
import com.uwetrottmann.trakt5.enums.Extended;
import flix.com.vision.App;
import flix.com.vision.activities.TraktActivity;
import flix.com.vision.models.Movie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Response;

/* compiled from: TraktActivity.java */
/* loaded from: classes2.dex */
public final class m2 extends AsyncTask<String, String, ArrayList<Movie>> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20234a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TraktActivity f20235b;

    public m2(TraktActivity traktActivity, int i10) {
        this.f20235b = traktActivity;
        this.f20234a = i10;
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.f20235b.M.setVisibility(0);
    }

    @Override // android.os.AsyncTask
    public ArrayList<Movie> doInBackground(String... strArr) {
        TraktActivity traktActivity = this.f20235b;
        ArrayList<Movie> arrayList = new ArrayList<>();
        try {
            AndroidThreeTen.init((Application) App.getInstance());
            traktActivity.N = new TraktV2("39c944040d5f19862b77e7a66b6c419af653c1e3bf226cc691eb2abbb551730c");
            traktActivity.N.accessToken(App.getInstance().f11574v.getString("trakt_access_token", ""));
            traktActivity.N.apiKey("39c944040d5f19862b77e7a66b6c419af653c1e3bf226cc691eb2abbb551730c");
            traktActivity.N.refreshToken(App.getInstance().f11574v.getString("trakt_access_token", ""));
            int i10 = this.f20234a;
            Response<List<BaseMovie>> responseExecute = i10 == 1 ? traktActivity.N.users().collectionMovies(UserSlug.ME, Extended.FULL).execute() : i10 == 2 ? traktActivity.N.users().watchlistMovies(UserSlug.ME, Extended.FULL).execute() : null;
            if (responseExecute != null && responseExecute.isSuccessful()) {
                for (BaseMovie baseMovie : responseExecute.body()) {
                    Movie movie = new Movie();
                    movie.setType(0);
                    movie.f12407y = true;
                    try {
                        movie.setPlot(baseMovie.movie.overview);
                        movie.setTitle(baseMovie.movie.title);
                        movie.I = baseMovie.movie.year + "";
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                    movie.J = baseMovie.movie.ids.imdb;
                    movie.setMovieId(r2.tmdb.intValue());
                    arrayList.add(movie);
                }
            }
            Response<List<BaseShow>> responseExecute2 = App.getInstance().f11572t.f4832a.users().collectionShows(UserSlug.ME, Extended.FULL).execute();
            if (responseExecute2.isSuccessful()) {
                for (BaseShow baseShow : responseExecute2.body()) {
                    Movie movie2 = new Movie();
                    movie2.f12407y = true;
                    movie2.setType(1);
                    try {
                        movie2.setPlot(baseShow.show.overview);
                        movie2.setTitle(baseShow.show.title);
                        movie2.I = baseShow.show.year + "";
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    movie2.J = baseShow.show.ids.imdb;
                    movie2.setMovieId(r2.tmdb.intValue());
                    arrayList.add(movie2);
                }
            }
        } catch (IOException e12) {
            e12.printStackTrace();
        } catch (Exception e13) {
            e13.printStackTrace();
        }
        return arrayList;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(ArrayList<Movie> arrayList) {
        super.onPostExecute((m2) arrayList);
        TraktActivity traktActivity = this.f20235b;
        traktActivity.M.setVisibility(8);
        try {
            traktActivity.T.clear();
            traktActivity.T.addAll(arrayList);
            traktActivity.S.getAdapter().notifyDataSetChanged();
            traktActivity.S.requestFocus();
            if (this.f20234a == 1) {
                traktActivity.O.setText("COLLECTION · " + arrayList.size());
            } else {
                traktActivity.P.setText("WATCHLIST · " + arrayList.size());
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
