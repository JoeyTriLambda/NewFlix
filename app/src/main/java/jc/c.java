package jc;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.widget.Toast;
import flix.com.vision.App;
import flix.com.vision.models.Anime;
import flix.com.vision.models.Drama;
import flix.com.vision.models.Movie;
import hd.d;
import hd.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/* compiled from: MyDB.java */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14688a;

    /* renamed from: b, reason: collision with root package name */
    public b f14689b;

    public c(Context context) {
        this.f14689b = new b(context);
        this.f14688a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean AddAnimeItem(java.util.ArrayList<hd.a> r15) {
        /*
            r14 = this;
            java.lang.String r0 = "go_anime_table"
            java.lang.String r1 = "[^a-zA-Z0-9]"
            java.lang.String r2 = "'"
            java.lang.String r3 = " "
            r4 = 0
            flix.com.vision.App r5 = flix.com.vision.App.getInstance()     // Catch: java.lang.Exception -> Laf
            jc.b r5 = jc.b.getInstance(r5)     // Catch: java.lang.Exception -> Laf
            r14.f14689b = r5     // Catch: java.lang.Exception -> Laf
            android.database.sqlite.SQLiteDatabase r5 = r5.getWritableDatabase()     // Catch: java.lang.Exception -> Laa
            if (r5 != 0) goto L25
            android.content.Context r15 = r14.f14688a     // Catch: java.lang.Exception -> Laf
            java.lang.String r0 = "Operation failed. retry"
            android.widget.Toast r15 = android.widget.Toast.makeText(r15, r0, r4)     // Catch: java.lang.Exception -> Laf
            r15.show()     // Catch: java.lang.Exception -> Laf
            return r4
        L25:
            int r6 = r15.size()     // Catch: java.lang.Exception -> Laf
            java.util.Iterator r15 = r15.iterator()     // Catch: java.lang.Exception -> La8
            r7 = 0
        L2e:
            boolean r8 = r15.hasNext()     // Catch: java.lang.Exception -> La6
            if (r8 == 0) goto La2
            java.lang.Object r8 = r15.next()     // Catch: java.lang.Exception -> La6
            hd.a r8 = (hd.a) r8     // Catch: java.lang.Exception -> La6
            android.content.ContentValues r9 = new android.content.ContentValues     // Catch: java.lang.Exception -> L2e
            r9.<init>()     // Catch: java.lang.Exception -> L2e
            java.lang.String r10 = "go_anime_code"
            r8.getClass()     // Catch: java.lang.Exception -> L2e
            r11 = 0
            r9.put(r10, r11)     // Catch: java.lang.Exception -> L2e
            java.lang.String r10 = "go_anime_title"
            java.lang.String r12 = r8.f12968a     // Catch: java.lang.Exception -> L2e
            java.lang.String r13 = ""
            java.lang.String r12 = r12.replace(r2, r13)     // Catch: java.lang.Exception -> L2e
            r9.put(r10, r12)     // Catch: java.lang.Exception -> L2e
            java.lang.String r10 = "go_anime_title_year"
            java.lang.String r12 = r8.f12968a     // Catch: java.lang.Exception -> L2e
            java.lang.String r12 = r12.replace(r2, r3)     // Catch: java.lang.Exception -> L2e
            r9.put(r10, r12)     // Catch: java.lang.Exception -> L2e
            java.lang.String r10 = "go_anime_year"
            r9.put(r10, r11)     // Catch: java.lang.Exception -> L2e
            java.lang.String r10 = "go_anime_url"
            java.lang.String r11 = r8.f12969b     // Catch: java.lang.Exception -> L2e
            r9.put(r10, r11)     // Catch: java.lang.Exception -> L2e
            java.lang.String r10 = "go_anime_img_url"
            java.lang.String r11 = r8.f12970c     // Catch: java.lang.Exception -> L2e
            r9.put(r10, r11)     // Catch: java.lang.Exception -> L2e
            java.lang.String r10 = "go_anime_plot"
            java.lang.String r11 = r8.f12972e     // Catch: java.lang.Exception -> L2e
            java.lang.String r11 = r11.replaceAll(r1, r3)     // Catch: java.lang.Exception -> L2e
            r9.put(r10, r11)     // Catch: java.lang.Exception -> L2e
            java.lang.String r10 = "go_anime_genres"
            java.lang.String r8 = r8.f12971d     // Catch: java.lang.Exception -> L2e
            java.lang.String r8 = r8.replaceAll(r1, r3)     // Catch: java.lang.Exception -> L2e
            r9.put(r10, r8)     // Catch: java.lang.Exception -> L2e
            boolean r8 = r5.isOpen()     // Catch: java.lang.Exception -> L2e
            if (r8 != 0) goto L9b
            jc.b r8 = r14.f14689b     // Catch: java.lang.Exception -> L96
            android.database.sqlite.SQLiteDatabase r5 = r8.getWritableDatabase()     // Catch: java.lang.Exception -> L96
            goto L9b
        L96:
            r8 = move-exception
            r8.printStackTrace()     // Catch: java.lang.Exception -> L2e
            return r4
        L9b:
            r8 = 5
            r5.insertWithOnConflict(r0, r0, r9, r8)     // Catch: java.lang.Exception -> L2e
            int r7 = r7 + 1
            goto L2e
        La2:
            r5.close()     // Catch: java.lang.Exception -> La6
            goto Lb2
        La6:
            goto Lb2
        La8:
            goto Lb1
        Laa:
            r15 = move-exception
            r15.printStackTrace()     // Catch: java.lang.Exception -> Laf
            return r4
        Laf:
            r6 = 0
        Lb1:
            r7 = 0
        Lb2:
            int r6 = r6 - r7
            r15 = 200(0xc8, float:2.8E-43)
            if (r6 >= r15) goto Lb8
            r4 = 1
        Lb8:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: jc.c.AddAnimeItem(java.util.ArrayList):boolean");
    }

    public final void a(Drama drama, String str) {
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            try {
                SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
                if (writableDatabase == null) {
                    Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
                    return;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("drama_title", drama.f12389n);
                contentValues.put("drama_url", drama.f12391p);
                contentValues.put("drama_img_url", drama.f12392q);
                contentValues.put("drama_year", drama.f12387b);
                contentValues.put("drama_title_year", drama.f12390o);
                contentValues.put("drama_is_series", Boolean.valueOf(drama.f12388m));
                writableDatabase.insertWithOnConflict(str, str, contentValues, 5);
                writableDatabase.close();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } catch (Exception unused) {
        }
    }

    public boolean addAdultHistory(id.c cVar) {
        try {
            b bVar = new b(App.getInstance());
            this.f14689b = bVar;
            try {
                SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
                if (writableDatabase == null) {
                    Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
                    return false;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("adult_title", cVar.f13365a);
                contentValues.put("adult_url", cVar.f13366b);
                contentValues.put("adult_img_url", cVar.f13367c);
                writableDatabase.insertWithOnConflict("adult_history", "adult_history", contentValues, 5);
                writableDatabase.close();
                return true;
            } catch (Exception e10) {
                e10.printStackTrace();
                return false;
            }
        } catch (Exception unused) {
            return true;
        }
    }

    public boolean addChannelToFavorites(d dVar) {
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            try {
                SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
                if (writableDatabase == null) {
                    Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
                    return false;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("channel_label_", dVar.f12984q);
                contentValues.put("channel_logo_", dVar.f12985r);
                contentValues.put("channel_url_", dVar.f12983p);
                writableDatabase.insertWithOnConflict("fav_channels", "fav_channels", contentValues, 5);
                writableDatabase.close();
                return true;
            } catch (Exception e10) {
                e10.printStackTrace();
                return false;
            }
        } catch (Exception unused) {
            return true;
        }
    }

    public void addDramaToContinue(Drama drama) {
        a(drama, "drama_continue");
    }

    public void addDramaToFavorites(Drama drama) {
        a(drama, "drama_favorites");
    }

    public void addDramaToHistory(Drama drama) {
        a(drama, "drama_history");
    }

    public boolean addFavoritesAdult(id.c cVar) {
        try {
            b bVar = new b(App.getInstance());
            this.f14689b = bVar;
            try {
                SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
                if (writableDatabase == null) {
                    Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
                    return false;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("adult_title", cVar.f13365a);
                contentValues.put("adult_url", cVar.f13366b);
                contentValues.put("adult_img_url", cVar.f13367c);
                writableDatabase.insertWithOnConflict("adult_favorites", "adult_favorites", contentValues, 5);
                writableDatabase.close();
                return true;
            } catch (Exception e10) {
                e10.printStackTrace();
                return false;
            }
        } catch (Exception unused) {
            return true;
        }
    }

    public boolean addHistoryIPTV(h hVar) {
        b bVar = new b(App.getInstance());
        this.f14689b = bVar;
        try {
            SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
            if (writableDatabase == null) {
                Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
                return false;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("label_name_", hVar.f13009m);
                contentValues.put("history_url_", hVar.f13008b);
                contentValues.put("history_type_", hVar.f13010n);
                writableDatabase.insertWithOnConflict("iptv_history", "iptv_history", contentValues, 5);
                writableDatabase.close();
                return true;
            } catch (Exception unused) {
                return true;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public boolean addMovieFavorites(Movie movie) {
        SQLiteDatabase writableDatabase;
        try {
            try {
                if (App.getInstance().f11574v.getBoolean("add_favorites_on", true)) {
                    App.getInstance().f11572t.traktAddMovieToCollection(movie, 1);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            try {
                writableDatabase = bVar.getWritableDatabase();
            } catch (Exception e11) {
                e11.printStackTrace();
                return false;
            }
        } catch (Exception unused) {
        }
        if (writableDatabase == null) {
            Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("image_url", movie.getImage_url());
        contentValues.put("url", movie.getUrl());
        contentValues.put("info_url", movie.getInfo_url());
        contentValues.put("rating", movie.getRating());
        contentValues.put("quality", movie.getQuality());
        contentValues.put("_title", movie.getTitle());
        contentValues.put("plot_", movie.getOverview());
        contentValues.put("server_", movie.getServer());
        contentValues.put("cast_", movie.getCast());
        contentValues.put("server_number_", movie.getServerNumberNew());
        contentValues.put("_season", movie.H);
        contentValues.put("_year", movie.I);
        contentValues.put("movie_id", Long.valueOf(movie.getMovieId()));
        contentValues.put("movie_type", Integer.valueOf(movie.getType()));
        contentValues.put("movie_backdrop", movie.f12400r);
        writableDatabase.insertWithOnConflict("favorites", "favorites", contentValues, 5);
        writableDatabase.close();
        return true;
    }

    public boolean addMovieFavorites_Anime(Movie movie) {
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            try {
                SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
                if (writableDatabase == null) {
                    Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
                    return false;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("image_url", movie.getImage_url());
                contentValues.put("url", movie.getUrl());
                contentValues.put("info_url", movie.getInfo_url());
                contentValues.put("rating", movie.getRating());
                contentValues.put("quality", movie.getQuality());
                contentValues.put("_title", movie.getTitle());
                contentValues.put("plot_", movie.getPlot());
                contentValues.put("server_", movie.getServer());
                contentValues.put("cast_", movie.getCast());
                contentValues.put("server_number_", movie.getServerNumberNew());
                writableDatabase.insertWithOnConflict("anime_favorites", "anime_favorites", contentValues, 5);
                writableDatabase.close();
                return true;
            } catch (Exception e10) {
                e10.printStackTrace();
                return false;
            }
        } catch (Exception unused) {
            return true;
        }
    }

    public boolean addMovieHistory_ANIME(Movie movie) {
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            try {
                SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
                if (writableDatabase == null) {
                    Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
                    return false;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("image_url", movie.getImage_url());
                contentValues.put("url", movie.getUrl());
                contentValues.put("info_url", movie.getInfo_url());
                contentValues.put("rating", movie.getRating());
                contentValues.put("quality", movie.getQuality());
                contentValues.put("_title", movie.getTitle());
                contentValues.put("plot_", movie.getPlot());
                contentValues.put("server_", movie.getServer());
                contentValues.put("cast_", movie.getCast());
                contentValues.put("server_number_", movie.getServerNumberNew());
                contentValues.put("_season", movie.H);
                contentValues.put("_year", movie.I);
                writableDatabase.insertWithOnConflict("anime_history", "anime_history", contentValues, 5);
                writableDatabase.close();
                return true;
            } catch (Exception e10) {
                e10.printStackTrace();
                return false;
            }
        } catch (Exception unused) {
            return true;
        }
    }

    public boolean addtoWatched(Movie movie) {
        SQLiteDatabase writableDatabase;
        if (movie.f12396n) {
            return true;
        }
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            try {
                writableDatabase = bVar.getWritableDatabase();
            } catch (Exception e10) {
                e10.printStackTrace();
                return false;
            }
        } catch (Exception unused) {
        }
        if (writableDatabase == null) {
            Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("image_url", movie.getImage_url());
        contentValues.put("url", movie.getUrl());
        contentValues.put("info_url", movie.getInfo_url());
        contentValues.put("rating", movie.getRating());
        contentValues.put("quality", movie.getDuration() + "");
        contentValues.put("_title", movie.getTitle());
        contentValues.put("plot_", movie.getOverview());
        contentValues.put("server_", movie.getServer());
        contentValues.put("cast_", movie.getCast());
        contentValues.put("server_number_", movie.getServerNumberNew());
        contentValues.put("_season", movie.H);
        contentValues.put("_year", movie.I);
        contentValues.put("movie_id", Long.valueOf(movie.getMovieId()));
        contentValues.put("movie_type", Integer.valueOf(movie.getType()));
        contentValues.put("movie_backdrop", movie.f12400r);
        writableDatabase.insertWithOnConflict("history", "history", contentValues, 5);
        writableDatabase.close();
        return true;
    }

    public boolean addtoWatching(Movie movie) {
        if (!movie.f12396n && !movie.f12397o) {
            try {
                b bVar = b.getInstance(App.getInstance());
                this.f14689b = bVar;
                try {
                    SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
                    if (writableDatabase == null) {
                        Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
                        return false;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("image_url", movie.getImage_url());
                    contentValues.put("url", movie.getUrl());
                    contentValues.put("info_url", movie.getInfo_url());
                    contentValues.put("rating", movie.getRating());
                    contentValues.put("quality", movie.getDuration() + "");
                    contentValues.put("_title", movie.getTitle());
                    contentValues.put("plot_", movie.getOverview());
                    contentValues.put("server_", movie.getServer());
                    contentValues.put("cast_", movie.getCast());
                    contentValues.put("server_number_", movie.getServerNumberNew());
                    contentValues.put("_season", movie.H);
                    contentValues.put("_year", movie.I);
                    contentValues.put("movie_id", Long.valueOf(movie.getMovieId()));
                    contentValues.put("movie_type", Integer.valueOf(movie.getType()));
                    contentValues.put("movie_backdrop", movie.f12400r);
                    writableDatabase.insertWithOnConflict("watching", "watching", contentValues, 5);
                    writableDatabase.close();
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return false;
                }
            } catch (Exception unused) {
            }
        }
        return true;
    }

    public final void b(id.c cVar, String str) {
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
            if (writableDatabase == null) {
                Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            } else {
                writableDatabase.delete(str, "adult_url LIKE ?", new String[]{String.valueOf(cVar.f13366b)});
                writableDatabase.close();
            }
        } catch (Exception unused) {
        }
    }

    public final void c(Drama drama, String str) {
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
            if (writableDatabase == null) {
                Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            } else {
                writableDatabase.delete(str, "drama_url LIKE ?", new String[]{String.valueOf(drama.f12391p)});
                writableDatabase.close();
            }
        } catch (Exception unused) {
        }
    }

    public boolean clearFavorites() throws SQLException {
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
            if (writableDatabase == null) {
                Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
                return false;
            }
            writableDatabase.execSQL("delete from favorites");
            writableDatabase.close();
            return true;
        } catch (SQLException unused) {
            return true;
        }
    }

    public boolean clearHistory() throws SQLException {
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
            if (writableDatabase == null) {
                Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
                return false;
            }
            writableDatabase.execSQL("delete from history");
            writableDatabase.close();
            return true;
        } catch (SQLException unused) {
            return true;
        }
    }

    public boolean clearHistoryAdult() throws SQLException {
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
            if (writableDatabase == null) {
                Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
                return false;
            }
            writableDatabase.execSQL("delete from adult_history");
            writableDatabase.close();
            return true;
        } catch (SQLException unused) {
            return true;
        }
    }

    public boolean clearHistoryAnime() throws SQLException {
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
            if (writableDatabase == null) {
                Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
                return false;
            }
            writableDatabase.execSQL("delete from anime_history");
            writableDatabase.close();
            return true;
        } catch (SQLException unused) {
            return true;
        }
    }

    public boolean clearHistoryDrama() throws SQLException {
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
            if (writableDatabase == null) {
                Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
                return false;
            }
            writableDatabase.execSQL("delete from drama_history");
            writableDatabase.close();
            return true;
        } catch (SQLException unused) {
            return true;
        }
    }

    public boolean clearHistory_Anime() throws SQLException {
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
            if (writableDatabase == null) {
                Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
                return false;
            }
            writableDatabase.execSQL("delete from anime_history");
            writableDatabase.close();
            return true;
        } catch (SQLException unused) {
            return true;
        }
    }

    public void deletDramaFromContinue(Drama drama) {
        c(drama, "drama_continue");
    }

    public void deletDramaFromFavorites(Drama drama) {
        c(drama, "drama_favorites");
    }

    public void deleteAdultFromFavorites(id.c cVar) {
        b(cVar, "adult_favorites");
    }

    public void deleteAdultFromHistory(id.c cVar) {
        b(cVar, "adult_history");
    }

    public void deleteChannelFromFavorites(d dVar) {
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
            if (writableDatabase == null) {
                Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            } else {
                writableDatabase.delete("fav_channels", "channel_label_ LIKE ?", new String[]{String.valueOf(dVar.f12984q)});
                writableDatabase.close();
            }
        } catch (Exception unused) {
        }
    }

    public void deleteFavoriteAdultVideo(id.c cVar) {
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
            if (writableDatabase == null) {
                Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            } else {
                writableDatabase.delete("adult_favorites", "adult_url LIKE ?", new String[]{String.valueOf(cVar)});
                writableDatabase.close();
            }
        } catch (Exception unused) {
        }
    }

    public void deleteFavoriteMovie(Movie movie) {
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
            if (writableDatabase == null) {
                Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            } else {
                writableDatabase.delete("favorites", "_title LIKE ?", new String[]{String.valueOf(movie.getTitle())});
                writableDatabase.close();
            }
        } catch (Exception unused) {
        }
    }

    public void deleteFavoriteMovie_ANIME(Movie movie) {
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
            if (writableDatabase == null) {
                Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            } else {
                writableDatabase.delete("anime_favorites", "_title LIKE ?", new String[]{String.valueOf(movie.getTitle())});
                writableDatabase.close();
            }
        } catch (Exception unused) {
        }
    }

    public void deleteHistoryIptvItem(h hVar) {
        try {
            b bVar = new b(App.getInstance());
            this.f14689b = bVar;
            SQLiteDatabase readableDatabase = bVar.getReadableDatabase();
            if (readableDatabase == null) {
                Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            } else {
                readableDatabase.delete("iptv_history", "history_url_ LIKE ?", new String[]{String.valueOf(hVar.f13008b)});
                readableDatabase.close();
            }
        } catch (Exception unused) {
        }
    }

    @SuppressLint({"Range"})
    public ArrayList<id.c> getAdultHistoryFromDb() {
        SQLiteDatabase readableDatabase;
        ArrayList<id.c> arrayList = new ArrayList<>();
        try {
            readableDatabase = this.f14689b.getReadableDatabase();
        } catch (Exception unused) {
        }
        if (readableDatabase == null) {
            Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            return null;
        }
        Cursor cursorQuery = readableDatabase.query("adult_history", new String[]{"_id", "adult_title", "adult_img_url", "adult_url"}, null, null, null, null, null);
        cursorQuery.moveToFirst();
        while (!cursorQuery.isAfterLast()) {
            id.c cVar = new id.c();
            cVar.f13365a = cursorQuery.getString(cursorQuery.getColumnIndex("adult_title"));
            cVar.f13366b = cursorQuery.getString(cursorQuery.getColumnIndex("adult_url"));
            cVar.f13367c = cursorQuery.getString(cursorQuery.getColumnIndex("adult_img_url"));
            arrayList.add(cVar);
            cursorQuery.moveToNext();
        }
        readableDatabase.close();
        Collections.reverse(arrayList);
        return arrayList;
    }

    @SuppressLint({"Range"})
    public ArrayList<id.c> getAdultVideosFromDb() {
        SQLiteDatabase readableDatabase;
        ArrayList<id.c> arrayList = new ArrayList<>();
        try {
            readableDatabase = this.f14689b.getReadableDatabase();
        } catch (Exception unused) {
        }
        if (readableDatabase == null) {
            Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            return null;
        }
        Cursor cursorQuery = readableDatabase.query("adult_favorites", new String[]{"_id", "adult_title", "adult_img_url", "adult_url"}, null, null, null, null, null);
        cursorQuery.moveToFirst();
        while (!cursorQuery.isAfterLast()) {
            id.c cVar = new id.c();
            cVar.f13365a = cursorQuery.getString(cursorQuery.getColumnIndex("adult_title"));
            cVar.f13366b = cursorQuery.getString(cursorQuery.getColumnIndex("adult_url"));
            cVar.f13367c = cursorQuery.getString(cursorQuery.getColumnIndex("adult_img_url"));
            arrayList.add(cVar);
            cursorQuery.moveToNext();
        }
        readableDatabase.close();
        Collections.reverse(arrayList);
        return arrayList;
    }

    public ArrayList<Drama> getDramaContinue() {
        return getDramas("drama_continue");
    }

    public ArrayList<Drama> getDramaFavorites() {
        return getDramas("drama_favorites");
    }

    public ArrayList<Drama> getDramaHistory() {
        return getDramas("drama_history");
    }

    @SuppressLint({"Range"})
    public ArrayList<Drama> getDramas(String str) {
        SQLiteDatabase writableDatabase;
        ArrayList<Drama> arrayList = new ArrayList<>();
        try {
            writableDatabase = this.f14689b.getWritableDatabase();
        } catch (Exception unused) {
        }
        if (writableDatabase == null) {
            Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            return arrayList;
        }
        Cursor cursorQuery = writableDatabase.query(str, new String[]{"_id", "drama_title", "drama_img_url", "drama_url", "drama_is_series", "drama_year", "drama_title_year"}, null, null, null, null, null);
        cursorQuery.moveToFirst();
        while (!cursorQuery.isAfterLast()) {
            Drama drama = new Drama();
            drama.f12389n = cursorQuery.getString(cursorQuery.getColumnIndex("drama_title"));
            drama.f12391p = cursorQuery.getString(cursorQuery.getColumnIndex("drama_url"));
            drama.f12392q = cursorQuery.getString(cursorQuery.getColumnIndex("drama_img_url"));
            drama.f12388m = Objects.equals(cursorQuery.getString(cursorQuery.getColumnIndex("drama_is_series")), "1");
            drama.f12387b = cursorQuery.getString(cursorQuery.getColumnIndex("drama_year"));
            drama.f12390o = cursorQuery.getString(cursorQuery.getColumnIndex("drama_title_year"));
            arrayList.add(drama);
            cursorQuery.moveToNext();
        }
        writableDatabase.close();
        Collections.reverse(arrayList);
        return arrayList;
    }

    @SuppressLint({"Range"})
    public ArrayList<d> getFavoritesChannels() {
        SQLiteDatabase writableDatabase;
        ArrayList<d> arrayList = new ArrayList<>();
        try {
            writableDatabase = this.f14689b.getWritableDatabase();
        } catch (Exception unused) {
        }
        if (writableDatabase == null) {
            Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            return null;
        }
        Cursor cursorQuery = writableDatabase.query("fav_channels", new String[]{"_id", "channel_logo_", "channel_url_", "channel_label_"}, null, null, null, null, null);
        cursorQuery.moveToFirst();
        while (!cursorQuery.isAfterLast()) {
            d dVar = new d();
            dVar.f12983p = cursorQuery.getString(cursorQuery.getColumnIndex("channel_url_"));
            dVar.f12984q = cursorQuery.getString(cursorQuery.getColumnIndex("channel_label_"));
            dVar.f12985r = cursorQuery.getString(cursorQuery.getColumnIndex("channel_logo_"));
            arrayList.add(dVar);
            cursorQuery.moveToNext();
        }
        writableDatabase.close();
        Collections.reverse(arrayList);
        return arrayList;
    }

    @SuppressLint({"Range"})
    public ArrayList<Movie> getFavoritesMoviesFromDb() {
        SQLiteDatabase writableDatabase;
        ArrayList<Movie> arrayList = new ArrayList<>();
        try {
            writableDatabase = this.f14689b.getWritableDatabase();
        } catch (NumberFormatException unused) {
        }
        if (writableDatabase == null) {
            Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            return arrayList;
        }
        Cursor cursorQuery = writableDatabase.query("favorites", new String[]{"_id", "_title", "image_url", "info_url", "quality", "rating", "url", "plot_", "cast_", "server_", "server_number_", "_year", "_season", "movie_type", "movie_id"}, null, null, null, null, null);
        cursorQuery.moveToFirst();
        while (!cursorQuery.isAfterLast()) {
            Movie movie = new Movie();
            movie.setTitle(cursorQuery.getString(cursorQuery.getColumnIndex("_title")));
            movie.setUrl(cursorQuery.getString(cursorQuery.getColumnIndex("url")));
            movie.setInfo_url(cursorQuery.getString(cursorQuery.getColumnIndex("info_url")));
            movie.setImage_url(cursorQuery.getString(cursorQuery.getColumnIndex("image_url")));
            movie.setRating(cursorQuery.getString(cursorQuery.getColumnIndex("rating")));
            movie.setQuality(cursorQuery.getString(cursorQuery.getColumnIndex("quality")));
            movie.setCast(cursorQuery.getString(cursorQuery.getColumnIndex("cast_")));
            movie.setServer(cursorQuery.getString(cursorQuery.getColumnIndex("server_")));
            movie.setOverview(cursorQuery.getString(cursorQuery.getColumnIndex("plot_")));
            movie.H = cursorQuery.getString(cursorQuery.getColumnIndex("_season"));
            movie.I = cursorQuery.getString(cursorQuery.getColumnIndex("_year"));
            movie.setType(Integer.parseInt(cursorQuery.getString(cursorQuery.getColumnIndex("movie_type"))));
            movie.setMovieId(Integer.parseInt(cursorQuery.getString(cursorQuery.getColumnIndex("movie_id"))));
            arrayList.add(movie);
            cursorQuery.moveToNext();
        }
        writableDatabase.close();
        Collections.reverse(arrayList);
        return arrayList;
    }

    @SuppressLint({"Range"})
    public ArrayList<Anime> getFavoritesMoviesFromDb_Anime() {
        SQLiteDatabase writableDatabase;
        ArrayList<Anime> arrayList = new ArrayList<>();
        try {
            writableDatabase = this.f14689b.getWritableDatabase();
        } catch (Exception unused) {
        }
        if (writableDatabase == null) {
            Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            return null;
        }
        Cursor cursorQuery = writableDatabase.query("anime_favorites", new String[]{"_id", "_title", "image_url", "info_url", "quality", "rating", "url", "plot_", "cast_", "server_", "server_number_", "_year", "_season"}, null, null, null, null, null);
        cursorQuery.moveToFirst();
        while (!cursorQuery.isAfterLast()) {
            Movie movie = new Movie();
            movie.setTitle(cursorQuery.getString(cursorQuery.getColumnIndex("_title")));
            movie.setUrl(cursorQuery.getString(cursorQuery.getColumnIndex("url")));
            movie.setInfo_url(cursorQuery.getString(cursorQuery.getColumnIndex("info_url")));
            movie.setImage_url(cursorQuery.getString(cursorQuery.getColumnIndex("image_url")));
            movie.setRating(cursorQuery.getString(cursorQuery.getColumnIndex("rating")));
            movie.setQuality(cursorQuery.getString(cursorQuery.getColumnIndex("quality")));
            movie.setCast(cursorQuery.getString(cursorQuery.getColumnIndex("cast_")));
            movie.setServer(cursorQuery.getString(cursorQuery.getColumnIndex("server_")));
            movie.setPlot(cursorQuery.getString(cursorQuery.getColumnIndex("plot_")));
            movie.H = cursorQuery.getString(cursorQuery.getColumnIndex("_season"));
            movie.I = cursorQuery.getString(cursorQuery.getColumnIndex("_year"));
            movie.setServerNumberNew();
            movie.parseYearfromTitle();
            arrayList.add(movie.toAnime());
            cursorQuery.moveToNext();
        }
        writableDatabase.close();
        Collections.reverse(arrayList);
        return arrayList;
    }

    @SuppressLint({"Range"})
    public ArrayList<Anime> getGoAnime(String str, String str2, String str3, int i10) {
        SQLiteDatabase writableDatabase;
        String strConcat;
        Context context = this.f14688a;
        ArrayList<Anime> arrayList = new ArrayList<>();
        try {
            try {
                writableDatabase = this.f14689b.getWritableDatabase();
            } catch (Exception unused) {
                Toast.makeText(context, "Operation failed. please retry", 0).show();
                return new ArrayList<>();
            }
        } catch (Exception unused2) {
        }
        if (writableDatabase == null) {
            Toast.makeText(context, "Operation failed. retry", 0).show();
            return new ArrayList<>();
        }
        int i11 = i10 * 30;
        if (str == null || str.trim().isEmpty()) {
            strConcat = null;
        } else {
            strConcat = "where go_anime_genres like '%" + str + "%'";
        }
        if (str3 != null && !str3.trim().isEmpty()) {
            if (str3.equalsIgnoreCase("dubbed")) {
                str3 = "Dub";
            }
            if (strConcat != null) {
                if (str3.equalsIgnoreCase("subbed")) {
                    strConcat = strConcat.concat(" and go_anime_title not like '%Dub%'");
                } else if (str3.equalsIgnoreCase("dub")) {
                    strConcat = strConcat + " and go_anime_title like '%" + str3 + "%'";
                }
            } else if (str3.equalsIgnoreCase("subbed")) {
                strConcat = "where go_anime_title not like '%Dub%'";
            } else if (str3.equalsIgnoreCase("dub")) {
                strConcat = "where go_anime_title like '%Dub%'";
            }
        }
        if (str2 != null && !str2.trim().isEmpty()) {
            if (strConcat != null) {
                strConcat = strConcat + " and go_anime_title_year like '%" + str2 + "%'";
            } else {
                strConcat = "where go_anime_title_year like '%" + str2 + "%'";
            }
        }
        if (strConcat == null) {
            strConcat = "";
        }
        try {
            Cursor cursorRawQuery = writableDatabase.rawQuery("select * from go_anime_table " + strConcat + " order by _id asc limit 30 offset " + i11, null);
            cursorRawQuery.moveToFirst();
            while (!cursorRawQuery.isAfterLast()) {
                Anime anime = new Anime();
                anime.f12385s = "gogoanime";
                anime.f12382p = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("go_anime_url"));
                anime.f12380n = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("go_anime_title"));
                anime.f12384r = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("go_anime_plot"));
                cursorRawQuery.getString(cursorRawQuery.getColumnIndex("go_anime_genres"));
                anime.f12383q = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("go_anime_img_url"));
                arrayList.add(anime);
                cursorRawQuery.moveToNext();
            }
            writableDatabase.close();
            Collections.reverse(arrayList);
            return arrayList;
        } catch (Exception unused3) {
            return new ArrayList<>();
        }
    }

    @SuppressLint({"Range"})
    public ArrayList<h> getHistoryIPTVFromDb() {
        SQLiteDatabase readableDatabase;
        ArrayList<h> arrayList = new ArrayList<>();
        try {
            readableDatabase = this.f14689b.getReadableDatabase();
        } catch (Exception unused) {
        }
        if (readableDatabase == null) {
            Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            return null;
        }
        Cursor cursorQuery = readableDatabase.query("iptv_history", new String[]{"_id", "label_name_", "history_url_", "history_type_"}, null, null, null, null, null);
        cursorQuery.moveToFirst();
        while (!cursorQuery.isAfterLast()) {
            h hVar = new h();
            hVar.f13009m = cursorQuery.getString(cursorQuery.getColumnIndex("label_name_"));
            hVar.f13008b = cursorQuery.getString(cursorQuery.getColumnIndex("history_url_"));
            hVar.f13010n = cursorQuery.getString(cursorQuery.getColumnIndex("history_type_"));
            arrayList.add(hVar);
            cursorQuery.moveToNext();
        }
        readableDatabase.close();
        Collections.reverse(arrayList);
        return arrayList;
    }

    @SuppressLint({"Range"})
    public ArrayList<Movie> getWatchedMoviesFromDb() {
        SQLiteDatabase writableDatabase;
        ArrayList<Movie> arrayList = new ArrayList<>();
        try {
            writableDatabase = this.f14689b.getWritableDatabase();
        } catch (NumberFormatException unused) {
        }
        if (writableDatabase == null) {
            Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            return arrayList;
        }
        Cursor cursorQuery = writableDatabase.query("history", new String[]{"_id", "_title", "image_url", "info_url", "quality", "rating", "url", "plot_", "cast_", "server_", "server_number_", "_year", "_season", "movie_id", "movie_type"}, null, null, null, null, null);
        cursorQuery.moveToFirst();
        while (!cursorQuery.isAfterLast()) {
            Movie movie = new Movie();
            movie.setTitle(cursorQuery.getString(cursorQuery.getColumnIndex("_title")));
            movie.setUrl(cursorQuery.getString(cursorQuery.getColumnIndex("url")));
            movie.setInfo_url(cursorQuery.getString(cursorQuery.getColumnIndex("info_url")));
            movie.setImage_url(cursorQuery.getString(cursorQuery.getColumnIndex("image_url")));
            movie.setRating(cursorQuery.getString(cursorQuery.getColumnIndex("rating")));
            movie.setDuration(Integer.parseInt(cursorQuery.getString(cursorQuery.getColumnIndex("quality"))));
            movie.setCast(cursorQuery.getString(cursorQuery.getColumnIndex("cast_")));
            movie.setServer(cursorQuery.getString(cursorQuery.getColumnIndex("server_")));
            movie.setOverview(cursorQuery.getString(cursorQuery.getColumnIndex("plot_")));
            movie.H = cursorQuery.getString(cursorQuery.getColumnIndex("_season"));
            movie.I = cursorQuery.getString(cursorQuery.getColumnIndex("_year"));
            movie.setType(Integer.parseInt(cursorQuery.getString(cursorQuery.getColumnIndex("movie_type"))));
            movie.setMovieId(Integer.parseInt(cursorQuery.getString(cursorQuery.getColumnIndex("movie_id"))));
            movie.setServerNumberNew();
            movie.parseYearfromTitle();
            arrayList.add(movie);
            cursorQuery.moveToNext();
        }
        writableDatabase.close();
        Collections.reverse(arrayList);
        return arrayList;
    }

    @SuppressLint({"Range"})
    public ArrayList<Anime> getWatchedMoviesFromDb_Anime() {
        SQLiteDatabase writableDatabase;
        ArrayList<Anime> arrayList = new ArrayList<>();
        try {
            writableDatabase = this.f14689b.getWritableDatabase();
        } catch (Exception unused) {
        }
        if (writableDatabase == null) {
            Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            return arrayList;
        }
        Cursor cursorQuery = writableDatabase.query("anime_history", new String[]{"_id", "_title", "image_url", "info_url", "quality", "rating", "url", "plot_", "cast_", "server_", "server_number_", "_year", "_season"}, null, null, null, null, null);
        cursorQuery.moveToFirst();
        while (!cursorQuery.isAfterLast()) {
            Movie movie = new Movie();
            movie.setTitle(cursorQuery.getString(cursorQuery.getColumnIndex("_title")));
            movie.setUrl(cursorQuery.getString(cursorQuery.getColumnIndex("url")));
            movie.setInfo_url(cursorQuery.getString(cursorQuery.getColumnIndex("info_url")));
            movie.setImage_url(cursorQuery.getString(cursorQuery.getColumnIndex("image_url")));
            movie.setRating(cursorQuery.getString(cursorQuery.getColumnIndex("rating")));
            movie.setQuality(cursorQuery.getString(cursorQuery.getColumnIndex("quality")));
            movie.setCast(cursorQuery.getString(cursorQuery.getColumnIndex("cast_")));
            movie.setServer(cursorQuery.getString(cursorQuery.getColumnIndex("server_")));
            movie.setPlot(cursorQuery.getString(cursorQuery.getColumnIndex("plot_")));
            movie.H = cursorQuery.getString(cursorQuery.getColumnIndex("_season"));
            movie.I = cursorQuery.getString(cursorQuery.getColumnIndex("_year"));
            movie.setServerNumberNew();
            movie.parseYearfromTitle();
            arrayList.add(movie.toAnime());
            cursorQuery.moveToNext();
        }
        writableDatabase.close();
        Collections.reverse(arrayList);
        return arrayList;
    }

    @SuppressLint({"Range"})
    public ArrayList<Movie> getWatchingMoviesFromDb() {
        SQLiteDatabase writableDatabase;
        ArrayList<Movie> arrayList = new ArrayList<>();
        try {
            writableDatabase = this.f14689b.getWritableDatabase();
        } catch (NumberFormatException unused) {
        }
        if (writableDatabase == null) {
            Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            return arrayList;
        }
        Cursor cursorQuery = writableDatabase.query("watching", new String[]{"_id", "_title", "image_url", "info_url", "quality", "rating", "url", "plot_", "cast_", "server_", "server_number_", "_year", "_season", "movie_id", "movie_type", "movie_backdrop"}, null, null, null, null, null);
        cursorQuery.moveToFirst();
        while (!cursorQuery.isAfterLast()) {
            Movie movie = new Movie();
            movie.setTitle(cursorQuery.getString(cursorQuery.getColumnIndex("_title")));
            movie.setUrl(cursorQuery.getString(cursorQuery.getColumnIndex("url")));
            movie.setInfo_url(cursorQuery.getString(cursorQuery.getColumnIndex("info_url")));
            movie.setImage_url(cursorQuery.getString(cursorQuery.getColumnIndex("image_url")));
            movie.setRating(cursorQuery.getString(cursorQuery.getColumnIndex("rating")));
            movie.setDuration(Integer.parseInt(cursorQuery.getString(cursorQuery.getColumnIndex("quality"))));
            movie.setCast(cursorQuery.getString(cursorQuery.getColumnIndex("cast_")));
            movie.setServer(cursorQuery.getString(cursorQuery.getColumnIndex("server_")));
            movie.setOverview(cursorQuery.getString(cursorQuery.getColumnIndex("plot_")));
            movie.H = cursorQuery.getString(cursorQuery.getColumnIndex("_season"));
            movie.I = cursorQuery.getString(cursorQuery.getColumnIndex("_year"));
            movie.setType(Integer.parseInt(cursorQuery.getString(cursorQuery.getColumnIndex("movie_type"))));
            movie.setMovieId(Integer.parseInt(cursorQuery.getString(cursorQuery.getColumnIndex("movie_id"))));
            movie.f12400r = cursorQuery.getString(cursorQuery.getColumnIndex("movie_backdrop"));
            movie.setServerNumberNew();
            movie.parseYearfromTitle();
            arrayList.add(movie);
            cursorQuery.moveToNext();
        }
        writableDatabase.close();
        Collections.reverse(arrayList);
        return arrayList;
    }

    public boolean isAdultVideoFavorited(id.c cVar) {
        SQLiteDatabase writableDatabase;
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            writableDatabase = bVar.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException | Exception unused) {
        }
        if (writableDatabase == null) {
            Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            return false;
        }
        String[] strArr = {"_id", "adult_title", "adult_url", "adult_img_url"};
        String str = cVar.f13366b;
        String[] strArr2 = {str};
        if (str == null) {
            return false;
        }
        Cursor cursorQuery = writableDatabase.query("adult_favorites", strArr, "adult_url=?", strArr2, null, null, null);
        cursorQuery.moveToFirst();
        if (cursorQuery.isAfterLast()) {
            writableDatabase.close();
            return false;
        }
        writableDatabase.close();
        cursorQuery.moveToNext();
        return true;
    }

    public boolean isChannelFavorited(d dVar) {
        SQLiteDatabase writableDatabase;
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            writableDatabase = bVar.getWritableDatabase();
        } catch (Exception unused) {
        }
        if (writableDatabase == null) {
            Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            return false;
        }
        String[] strArr = {"_id", "channel_logo_", "channel_url_", "channel_label_"};
        String str = dVar.f12984q;
        String[] strArr2 = {str};
        if (str == null) {
            return false;
        }
        Cursor cursorQuery = writableDatabase.query("fav_channels", strArr, "channel_label_=?", strArr2, null, null, null);
        cursorQuery.moveToFirst();
        if (cursorQuery.isAfterLast()) {
            writableDatabase.close();
            return false;
        }
        writableDatabase.close();
        cursorQuery.moveToNext();
        return true;
    }

    public boolean isDramaFavorited(Drama drama) {
        SQLiteDatabase writableDatabase;
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            writableDatabase = bVar.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException | Exception unused) {
        }
        if (writableDatabase == null) {
            Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            return false;
        }
        String[] strArr = {"_id", "drama_title", "drama_img_url", "drama_url", "drama_is_series", "drama_year", "drama_title_year"};
        String str = drama.f12391p;
        String[] strArr2 = {str};
        if (str == null) {
            return false;
        }
        Cursor cursorQuery = writableDatabase.query("drama_favorites", strArr, "drama_url=?", strArr2, null, null, null);
        cursorQuery.moveToFirst();
        if (cursorQuery.isAfterLast()) {
            writableDatabase.close();
            return false;
        }
        writableDatabase.close();
        cursorQuery.moveToNext();
        return true;
    }

    public boolean isMovieFavorited(Movie movie) {
        SQLiteDatabase writableDatabase;
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            writableDatabase = bVar.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException | Exception unused) {
        }
        if (writableDatabase == null) {
            Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            return false;
        }
        String[] strArr = {"_id", "_title", "image_url", "info_url", "quality", "rating", "url", "plot_", "cast_", "server_", "server_number_"};
        String[] strArr2 = {movie.getTitle()};
        if (movie.getTitle() == null) {
            return false;
        }
        Cursor cursorQuery = writableDatabase.query("favorites", strArr, "_title=?", strArr2, null, null, null);
        cursorQuery.moveToFirst();
        if (cursorQuery.isAfterLast()) {
            writableDatabase.close();
            return false;
        }
        writableDatabase.close();
        cursorQuery.moveToNext();
        return true;
    }

    public boolean isMovieFavorited_ANIME(Movie movie) {
        SQLiteDatabase writableDatabase;
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            writableDatabase = bVar.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException | Exception unused) {
        }
        if (writableDatabase == null) {
            Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            return false;
        }
        String[] strArr = {"_id", "_title", "image_url", "info_url", "quality", "rating", "url", "plot_", "cast_", "server_", "server_number_"};
        String[] strArr2 = {movie.getTitle()};
        if (movie.getTitle() == null) {
            return false;
        }
        Cursor cursorQuery = writableDatabase.query("anime_favorites", strArr, "_title=?", strArr2, null, null, null);
        cursorQuery.moveToFirst();
        if (cursorQuery.isAfterLast()) {
            writableDatabase.close();
            return false;
        }
        writableDatabase.close();
        cursorQuery.moveToNext();
        return true;
    }

    public boolean isMovieWatching(Movie movie) {
        SQLiteDatabase writableDatabase;
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            writableDatabase = bVar.getWritableDatabase();
        } catch (Exception unused) {
        }
        if (writableDatabase == null) {
            Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            return false;
        }
        String[] strArr = {"_id", "_title", "image_url", "info_url", "quality", "rating", "url", "plot_", "cast_", "server_", "server_number_"};
        String[] strArr2 = {movie.getTitle()};
        if (movie.getTitle() == null) {
            return false;
        }
        Cursor cursorQuery = writableDatabase.query("watching", strArr, "_title=?", strArr2, null, null, null);
        cursorQuery.moveToFirst();
        if (cursorQuery.isAfterLast()) {
            writableDatabase.close();
            return false;
        }
        writableDatabase.close();
        cursorQuery.moveToNext();
        return true;
    }

    public void markAsWatched(Movie movie) {
        SQLiteDatabase writableDatabase;
        if (movie.f12396n || movie.f12397o) {
            return;
        }
        try {
            App.getInstance().f11572t.traktAddToWatchedHistory(movie);
        } catch (Exception unused) {
        }
        try {
            App.getInstance().f11574v.edit().remove(movie.getMovieId() + "").apply();
        } catch (Exception unused2) {
        }
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            writableDatabase = bVar.getWritableDatabase();
        } catch (Exception unused3) {
        }
        if (writableDatabase == null) {
            Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            return;
        }
        writableDatabase.delete("watching", "_title LIKE ?", new String[]{String.valueOf(movie.getTitle())});
        writableDatabase.close();
        addtoWatched(movie);
    }

    public void removeFromWaching(Movie movie) {
        if (movie.f12396n || movie.f12397o) {
            return;
        }
        try {
            App.getInstance().f11574v.edit().remove(movie.getMovieId() + "").apply();
        } catch (Exception unused) {
        }
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
            if (writableDatabase == null) {
                Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            } else {
                writableDatabase.delete("watching", "_title LIKE ?", new String[]{String.valueOf(movie.getTitle())});
                writableDatabase.close();
            }
        } catch (Exception unused2) {
        }
    }

    public void removeFromWatched(Movie movie) {
        if (movie.f12396n || movie.f12397o) {
            return;
        }
        try {
            b bVar = b.getInstance(App.getInstance());
            this.f14689b = bVar;
            SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
            if (writableDatabase == null) {
                Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            } else {
                writableDatabase.delete("history", "_title LIKE ?", new String[]{String.valueOf(movie.getTitle())});
                writableDatabase.close();
            }
        } catch (Exception unused) {
        }
    }

    @SuppressLint({"Range"})
    public ArrayList<Anime> searchGoAnime(String str) {
        SQLiteDatabase writableDatabase;
        ArrayList<Anime> arrayList = new ArrayList<>();
        try {
            writableDatabase = this.f14689b.getWritableDatabase();
        } catch (Exception unused) {
        }
        if (writableDatabase == null) {
            Toast.makeText(this.f14688a, "Operation failed. retry", 0).show();
            return null;
        }
        try {
            Cursor cursorRawQuery = writableDatabase.rawQuery("select * from go_anime_table where go_anime_title like '%" + str + "%' order by _id asc limit 30", null);
            cursorRawQuery.moveToFirst();
            while (!cursorRawQuery.isAfterLast()) {
                Anime anime = new Anime();
                anime.f12385s = "gogoanime";
                anime.f12382p = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("go_anime_url"));
                anime.f12380n = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("go_anime_title"));
                anime.f12384r = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("go_anime_plot"));
                cursorRawQuery.getString(cursorRawQuery.getColumnIndex("go_anime_genres"));
                anime.f12383q = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("go_anime_img_url"));
                arrayList.add(anime);
                cursorRawQuery.moveToNext();
            }
            writableDatabase.close();
            Collections.reverse(arrayList);
            return arrayList;
        } catch (Exception unused2) {
            return new ArrayList<>();
        }
    }
}
