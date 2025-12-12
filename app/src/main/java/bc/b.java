package bc;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import com.jakewharton.threetenabp.AndroidThreeTen;
import com.uwetrottmann.trakt5.TraktV2;
import com.uwetrottmann.trakt5.entities.Episode;
import com.uwetrottmann.trakt5.entities.EpisodeCheckin;
import com.uwetrottmann.trakt5.entities.MovieCheckin;
import com.uwetrottmann.trakt5.entities.SearchResult;
import com.uwetrottmann.trakt5.entities.ShareSettings;
import com.uwetrottmann.trakt5.entities.ShowIds;
import com.uwetrottmann.trakt5.entities.SyncEpisode;
import com.uwetrottmann.trakt5.entities.SyncItems;
import com.uwetrottmann.trakt5.entities.SyncMovie;
import com.uwetrottmann.trakt5.entities.SyncSeason;
import com.uwetrottmann.trakt5.entities.SyncShow;
import com.uwetrottmann.trakt5.enums.Extended;
import com.uwetrottmann.trakt5.enums.IdType;
import com.uwetrottmann.trakt5.enums.Type;
import flix.com.vision.App;
import flix.com.vision.models.Movie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import retrofit2.Response;

/* compiled from: TraktAPI.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public TraktV2 f4832a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f4833b;

    /* compiled from: TraktAPI.java */
    public class a extends AsyncTask<String, String, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Movie f4834a;

        public a(Movie movie) {
            this.f4834a = movie;
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strArr) {
            b bVar = b.this;
            Movie movie = this.f4834a;
            try {
                try {
                    bVar.f4832a.checkin().deleteActiveCheckin().execute();
                } catch (Exception unused) {
                    return null;
                }
            } catch (IOException e10) {
                try {
                    e10.printStackTrace();
                } catch (IOException e11) {
                    e11.printStackTrace();
                    return null;
                }
            }
            Response<List<SearchResult>> responseExecute = (movie.getImdbID() == null || movie.getImdbID().length() <= 0) ? bVar.f4832a.search().textQuery(Type.MOVIE, movie.getSimpleNameClean(), movie.getYear(), "", "", "", "", "", null, 1, 3).execute() : bVar.f4832a.search().idLookup(IdType.IMDB, movie.getImdbID(), Type.MOVIE, Extended.FULL, 1, 5).execute();
            if (responseExecute.isSuccessful() && responseExecute.body() != null && responseExecute.body().size() != 0) {
                SearchResult searchResult = responseExecute.body().get(0);
                MovieCheckin movieCheckin = new MovieCheckin();
                SyncMovie syncMovie = new SyncMovie();
                syncMovie.collectedAt(OffsetDateTime.now());
                syncMovie.id(searchResult.movie.ids);
                syncMovie.watchedAt(OffsetDateTime.now());
                movieCheckin.venue_name = "Flix Vision";
                movieCheckin.movie = syncMovie;
                ShareSettings shareSettings = new ShareSettings();
                shareSettings.facebook = Boolean.valueOf(App.getInstance().f11574v.getBoolean("facebook_on", true));
                shareSettings.twitter = Boolean.valueOf(App.getInstance().f11574v.getBoolean("twitter_on", true));
                shareSettings.tumblr = Boolean.valueOf(App.getInstance().f11574v.getBoolean("tumblr_on", true));
                movieCheckin.sharing = shareSettings;
                movieCheckin.message = "Watching " + movie.getTitle() + " on @FlixVisionApp";
                bVar.f4832a.checkin().checkin(movieCheckin).execute();
                return null;
            }
            return Boolean.TRUE;
        }
    }

    /* compiled from: TraktAPI.java */
    /* renamed from: bc.b$b, reason: collision with other inner class name */
    public class AsyncTaskC0056b extends AsyncTask<String, String, Boolean> {
        public AsyncTaskC0056b() {
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strArr) {
            try {
                b.this.f4832a.checkin().deleteActiveCheckin().execute();
                return null;
            } catch (IOException e10) {
                e10.printStackTrace();
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* compiled from: TraktAPI.java */
    public class c extends AsyncTask<String, String, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Movie f4837a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4838b;

        public c(Movie movie, int i10) {
            this.f4837a = movie;
            this.f4838b = i10;
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strArr) {
            Response<List<Episode>> responseExecute;
            int i10;
            Episode next;
            b bVar = b.this;
            Movie movie = this.f4837a;
            try {
                try {
                    bVar.f4832a.checkin().deleteActiveCheckin().execute();
                } catch (IOException e10) {
                    try {
                        e10.printStackTrace();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
                responseExecute = bVar.f4832a.seasons().season(movie.getImdbID(), Integer.parseInt(movie.getSeason()), Extended.EPISODES).execute();
            } catch (Exception unused) {
            }
            if (responseExecute.isSuccessful() && responseExecute.body() != null && responseExecute.body().size() != 0) {
                Iterator<Episode> it = responseExecute.body().iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    i10 = this.f4838b;
                    if (!zHasNext) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (next != null && next.number.intValue() == i10) {
                        break;
                    }
                }
                if (next == null) {
                    return Boolean.FALSE;
                }
                EpisodeCheckin episodeCheckin = new EpisodeCheckin();
                SyncEpisode syncEpisode = new SyncEpisode();
                syncEpisode.collectedAt(OffsetDateTime.now());
                syncEpisode.id(next.ids);
                syncEpisode.watchedAt(OffsetDateTime.now());
                episodeCheckin.venue_name = "Flix Vision";
                episodeCheckin.episode = syncEpisode;
                ShareSettings shareSettings = new ShareSettings();
                shareSettings.facebook = Boolean.valueOf(App.getInstance().f11574v.getBoolean("facebook_on", false));
                shareSettings.twitter = Boolean.valueOf(App.getInstance().f11574v.getBoolean("twitter_on", false));
                shareSettings.tumblr = Boolean.valueOf(App.getInstance().f11574v.getBoolean("tumblr_on", false));
                episodeCheckin.sharing = shareSettings;
                episodeCheckin.message = "Watching " + movie.getTitle() + " S" + movie.getSeason() + ": E" + i10 + " on @FlixVisionApp";
                bVar.f4832a.checkin().checkin(episodeCheckin).execute();
                return null;
            }
            return Boolean.TRUE;
        }
    }

    /* compiled from: TraktAPI.java */
    public class d extends AsyncTask<String, String, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f4840a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SyncItems f4841b;

        public d(ArrayList arrayList, SyncItems syncItems) {
            this.f4840a = arrayList;
            this.f4841b = syncItems;
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(b.this.f4833b, "Trakt Sync Started", 1).show();
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strArr) {
            List<SyncMovie> list;
            b bVar = b.this;
            if (bVar.f4832a == null) {
                AndroidThreeTen.init((Application) App.getInstance());
                bVar.f4832a = new TraktV2("39c944040d5f19862b77e7a66b6c419af653c1e3bf226cc691eb2abbb551730c");
                bVar.f4832a.accessToken(App.getInstance().f11574v.getString("trakt_access_token", ""));
                bVar.f4832a.apiKey("39c944040d5f19862b77e7a66b6c419af653c1e3bf226cc691eb2abbb551730c");
                bVar.f4832a.refreshToken(App.getInstance().f11574v.getString("trakt_refresh_token", ""));
            }
            Iterator<Movie> it = App.getInstance().f11573u.getWatchedMoviesFromDb().iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                list = this.f4840a;
                if (!zHasNext) {
                    break;
                }
                Movie next = it.next();
                if (!next.isSeries()) {
                    try {
                        Response<List<SearchResult>> responseExecute = bVar.f4832a.search().textQuery(Type.MOVIE, next.getSimpleNameClean(), next.getYear(), "", "", "", "", "", null, 1, 3).execute();
                        if (responseExecute.isSuccessful() && responseExecute.body() != null && responseExecute.body().size() != 0) {
                            SearchResult searchResult = responseExecute.body().get(0);
                            SyncMovie syncMovie = new SyncMovie();
                            syncMovie.ids = searchResult.movie.ids;
                            syncMovie.watchedAt(OffsetDateTime.now());
                            list.add(syncMovie);
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            }
            if (list.size() <= 0) {
                return Boolean.TRUE;
            }
            SyncItems syncItems = this.f4841b;
            syncItems.movies(list);
            try {
                if (bVar.f4832a.sync().addItemsToWatchedHistory(syncItems).execute().isSuccessful()) {
                    return Boolean.TRUE;
                }
            } catch (IOException e11) {
                e11.printStackTrace();
            }
            return Boolean.FALSE;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((d) bool);
            if (bool.booleanValue()) {
                o1.a.j(App.getInstance().f11574v, "user_movies_history_synced_with_trakt", true);
                Toast.makeText(b.this.f4833b, "Trakt Sync Complete", 1).show();
            }
        }
    }

    /* compiled from: TraktAPI.java */
    public class e extends AsyncTask<String, String, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Movie f4843a;

        public e(Movie movie) {
            this.f4843a = movie;
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strArr) {
            Movie movie = this.f4843a;
            b bVar = b.this;
            if (bVar.f4832a == null) {
                AndroidThreeTen.init((Application) App.getInstance());
                bVar.f4832a = new TraktV2("39c944040d5f19862b77e7a66b6c419af653c1e3bf226cc691eb2abbb551730c");
                bVar.f4832a.accessToken(App.getInstance().f11574v.getString("trakt_access_token", ""));
                bVar.f4832a.apiKey("39c944040d5f19862b77e7a66b6c419af653c1e3bf226cc691eb2abbb551730c");
                bVar.f4832a.refreshToken(App.getInstance().f11574v.getString("trakt_refresh_token", ""));
            }
            try {
                Response<List<SearchResult>> responseExecute = (movie.getImdbID() == null || movie.getImdbID().length() <= 0) ? bVar.f4832a.search().textQuery(Type.SHOW, movie.getSimpleNameClean(), movie.getYear(), "", "", "", "", "", null, 1, 3).execute() : bVar.f4832a.search().idLookup(IdType.IMDB, movie.getImdbID(), Type.SHOW, Extended.FULL, 1, 3).execute();
                if (responseExecute.isSuccessful() && responseExecute.body().size() > 0) {
                    SearchResult searchResult = responseExecute.body().get(0);
                    SyncItems syncItems = new SyncItems();
                    SyncShow syncShow = new SyncShow();
                    syncShow.ids = searchResult.show.ids;
                    syncItems.shows(syncShow);
                    return Boolean.valueOf(bVar.f4832a.sync().addItemsToCollection(syncItems).execute().isSuccessful());
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                e10.getMessage();
            }
            return Boolean.FALSE;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((e) bool);
            if (bool.booleanValue()) {
                Toast.makeText(b.this.f4833b, this.f4843a.getTitle() + " Sent to Trakt", 1).show();
            }
        }
    }

    /* compiled from: TraktAPI.java */
    public class f extends AsyncTask<String, String, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Movie f4845a;

        public f(Movie movie) {
            this.f4845a = movie;
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strArr) {
            Movie movie = this.f4845a;
            b bVar = b.this;
            if (bVar.f4832a == null) {
                AndroidThreeTen.init((Application) App.getInstance());
                bVar.f4832a = new TraktV2("39c944040d5f19862b77e7a66b6c419af653c1e3bf226cc691eb2abbb551730c");
                bVar.f4832a.accessToken(App.getInstance().f11574v.getString("trakt_access_token", ""));
                bVar.f4832a.apiKey("39c944040d5f19862b77e7a66b6c419af653c1e3bf226cc691eb2abbb551730c");
                bVar.f4832a.refreshToken(App.getInstance().f11574v.getString("trakt_refresh_token", ""));
            }
            try {
                Response<List<SearchResult>> responseExecute = ((movie.getImdbID() == null || movie.getImdbID().length() <= 0) ? bVar.f4832a.search().textQuery(Type.MOVIE, movie.getSimpleNameClean(), movie.getYear(), "", "", "", "", "", null, 1, 2) : bVar.f4832a.search().idLookup(IdType.IMDB, movie.getImdbID(), Type.MOVIE, Extended.FULL, 1, 5)).execute();
                if (responseExecute.isSuccessful() && responseExecute.body().size() > 0) {
                    SearchResult searchResult = responseExecute.body().get(0);
                    SyncItems syncItems = new SyncItems();
                    SyncMovie syncMovie = new SyncMovie();
                    syncMovie.ids = searchResult.movie.ids;
                    syncItems.movies(syncMovie);
                    return Boolean.valueOf(bVar.f4832a.sync().addItemsToWatchlist(syncItems).execute().isSuccessful());
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return Boolean.FALSE;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((f) bool);
            if (bool.booleanValue()) {
                Toast.makeText(b.this.f4833b, this.f4845a.getTitle() + " Sent to Trakt", 1).show();
            }
        }
    }

    /* compiled from: TraktAPI.java */
    public class g extends AsyncTask<String, String, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f4847a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4848b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Movie f4849c;

        public g(int i10, int i11, Movie movie) {
            this.f4847a = i10;
            this.f4848b = i11;
            this.f4849c = movie;
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strArr) {
            int i10 = this.f4847a;
            b bVar = b.this;
            if (bVar.f4832a == null) {
                AndroidThreeTen.init((Application) App.getInstance());
                bVar.f4832a = new TraktV2("39c944040d5f19862b77e7a66b6c419af653c1e3bf226cc691eb2abbb551730c");
                bVar.f4832a.accessToken(App.getInstance().f11574v.getString("trakt_access_token", ""));
                bVar.f4832a.apiKey("39c944040d5f19862b77e7a66b6c419af653c1e3bf226cc691eb2abbb551730c");
                bVar.f4832a.refreshToken(App.getInstance().f11574v.getString("trakt_refresh_token", ""));
            }
            try {
                SyncItems syncItems = new SyncItems();
                SyncEpisode syncEpisode = new SyncEpisode();
                syncEpisode.season = Integer.valueOf(i10);
                syncEpisode.number = Integer.valueOf(this.f4848b);
                SyncShow syncShow = new SyncShow();
                syncShow.id(ShowIds.tmdb((int) this.f4849c.getMovieId()));
                SyncSeason syncSeason = new SyncSeason();
                syncSeason.number(i10);
                syncSeason.episodes(syncEpisode);
                syncShow.seasons(syncSeason);
                syncItems.shows(syncShow);
                return Boolean.valueOf(bVar.f4832a.sync().addItemsToWatchedHistory(syncItems).execute().isSuccessful());
            } catch (Exception e10) {
                e10.printStackTrace();
                return Boolean.FALSE;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((g) bool);
            if (bool.booleanValue()) {
                Toast.makeText(b.this.f4833b, "S" + this.f4847a + "E" + this.f4848b + " Sent to Trakt", 1).show();
            }
        }
    }

    /* compiled from: TraktAPI.java */
    public class h extends AsyncTask<String, String, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Movie f4851a;

        public h(Movie movie) {
            this.f4851a = movie;
        }

        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strArr) {
            Movie movie = this.f4851a;
            b bVar = b.this;
            if (bVar.f4832a == null) {
                AndroidThreeTen.init((Application) App.getInstance());
                bVar.f4832a = new TraktV2("39c944040d5f19862b77e7a66b6c419af653c1e3bf226cc691eb2abbb551730c");
                bVar.f4832a.accessToken(App.getInstance().f11574v.getString("trakt_access_token", ""));
                bVar.f4832a.apiKey("39c944040d5f19862b77e7a66b6c419af653c1e3bf226cc691eb2abbb551730c");
                bVar.f4832a.refreshToken(App.getInstance().f11574v.getString("trakt_refresh_token", ""));
            }
            try {
                Response<List<SearchResult>> responseExecute = ((movie.getImdbID() == null || movie.getImdbID().length() <= 0) ? bVar.f4832a.search().textQuery(Type.MOVIE, movie.getSimpleNameClean(), movie.getYear(), "", "", "", "", "", null, 1, 2) : bVar.f4832a.search().idLookup(IdType.IMDB, movie.getImdbID(), Type.MOVIE, Extended.FULL, 1, 5)).execute();
                if (responseExecute.isSuccessful() && responseExecute.body().size() > 0) {
                    SearchResult searchResult = responseExecute.body().get(0);
                    SyncItems syncItems = new SyncItems();
                    SyncMovie syncMovie = new SyncMovie();
                    syncMovie.ids = searchResult.movie.ids;
                    syncItems.movies(syncMovie);
                    return Boolean.valueOf(bVar.f4832a.sync().addItemsToWatchedHistory(syncItems).execute().isSuccessful());
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return Boolean.FALSE;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((h) bool);
            if (bool.booleanValue()) {
                Toast.makeText(b.this.f4833b, this.f4851a.getTitle() + " Sent to Trakt", 1).show();
            }
        }
    }

    public b(Context context) {
        this.f4833b = context;
    }

    public void checkInEpisode(Movie movie, int i10) {
        if (App.getInstance().f11574v.getBoolean("trakt_user_logged_in", false)) {
            if (this.f4832a == null) {
                AndroidThreeTen.init((Application) App.getInstance());
                TraktV2 traktV2 = new TraktV2("39c944040d5f19862b77e7a66b6c419af653c1e3bf226cc691eb2abbb551730c");
                this.f4832a = traktV2;
                traktV2.accessToken(App.getInstance().f11574v.getString("trakt_access_token", ""));
                this.f4832a.apiKey("39c944040d5f19862b77e7a66b6c419af653c1e3bf226cc691eb2abbb551730c");
                this.f4832a.refreshToken(App.getInstance().f11574v.getString("trakt_refresh_token", ""));
            }
            new c(movie, i10).execute(new String[0]);
        }
    }

    public void checkInMovie(Movie movie) {
        if (App.getInstance().f11574v.getBoolean("trakt_user_logged_in", false) && App.getInstance().f11574v.getBoolean("check_me_in", false)) {
            if (this.f4832a == null) {
                AndroidThreeTen.init((Application) App.getInstance());
                TraktV2 traktV2 = new TraktV2("39c944040d5f19862b77e7a66b6c419af653c1e3bf226cc691eb2abbb551730c");
                this.f4832a = traktV2;
                traktV2.accessToken(App.getInstance().f11574v.getString("trakt_access_token", ""));
                this.f4832a.apiKey("39c944040d5f19862b77e7a66b6c419af653c1e3bf226cc691eb2abbb551730c");
                this.f4832a.refreshToken(App.getInstance().f11574v.getString("trakt_access_token", ""));
            }
            new a(movie).execute(new String[0]);
        }
    }

    public void removeActiveCheckin() {
        if (App.getInstance().f11574v.getBoolean("trakt_user_logged_in", false)) {
            if (this.f4832a == null) {
                AndroidThreeTen.init((Application) App.getInstance());
                TraktV2 traktV2 = new TraktV2("39c944040d5f19862b77e7a66b6c419af653c1e3bf226cc691eb2abbb551730c");
                this.f4832a = traktV2;
                traktV2.accessToken(App.getInstance().f11574v.getString("trakt_access_token", ""));
                this.f4832a.apiKey("39c944040d5f19862b77e7a66b6c419af653c1e3bf226cc691eb2abbb551730c");
                this.f4832a.refreshToken(App.getInstance().f11574v.getString("trakt_access_token", ""));
            }
            try {
                new AsyncTaskC0056b().execute(new String[0]);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public void syncUserHistoryWithTrakt() {
        if (App.getInstance().f11574v.getBoolean("trakt_user_logged_in", false)) {
            new d(new ArrayList(), new SyncItems()).execute(new String[0]);
        }
    }

    public void traktAddMovieToCollection(Movie movie, int i10) {
        if (App.getInstance().f11574v.getBoolean("trakt_user_logged_in", false)) {
            if (!movie.isSeries()) {
                new f(movie).execute(new String[0]);
            } else if (App.getInstance().f11574v.getBoolean("add_favorites_on_shows", true)) {
                new e(movie).execute(new String[0]);
            }
        }
    }

    public void traktAddToWatchedHistory(Movie movie) {
        if (App.getInstance().f11574v.getBoolean("trakt_user_logged_in", false) && !movie.isSeries()) {
            new h(movie).execute(new String[0]);
        }
    }

    public void traktAddToWatchedHistoryEpisode(Movie movie, int i10, int i11) {
        if (App.getInstance().f11574v.getBoolean("trakt_user_logged_in", false) && movie.isSeries()) {
            new g(i10, i11, movie).execute(new String[0]);
        }
    }
}
