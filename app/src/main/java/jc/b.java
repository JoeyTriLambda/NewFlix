package jc;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: MovieDBHelper.java */
/* loaded from: classes2.dex */
public final class b extends SQLiteOpenHelper {

    /* renamed from: b, reason: collision with root package name */
    public static b f14687b;

    public b(Context context) {
        super(context, "FlixVision.db", (SQLiteDatabase.CursorFactory) null, 33);
    }

    public static synchronized b getInstance(Context context) {
        if (f14687b == null) {
            f14687b = new b(context.getApplicationContext());
        }
        return f14687b;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS favorites (_id INTEGER PRIMARY KEY,url TEXT,_title TEXT,info_url TEXT,image_url TEXT,quality TEXT,rating TEXT,cast_ TEXT,server_ TEXT,plot_ TEXT,_year TEXT,_season TEXT,server_number_ TEXT,movie_id TEXT UNIQUE ,movie_type TEXT,movie_backdrop TEXT )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS history (_id INTEGER PRIMARY KEY,url TEXT,_title TEXT,info_url TEXT,image_url TEXT,quality TEXT,rating TEXT,cast_ TEXT,server_ TEXT,plot_ TEXT,_year TEXT,_season TEXT,server_number_ TEXT,movie_id TEXT UNIQUE ,movie_type TEXT,movie_backdrop TEXT )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS watching (_id INTEGER PRIMARY KEY,url TEXT,_title TEXT,info_url TEXT,image_url TEXT,quality TEXT,rating TEXT,cast_ TEXT,server_ TEXT,plot_ TEXT,_year TEXT,_season TEXT,server_number_ TEXT,movie_id TEXT UNIQUE ,movie_type TEXT,movie_backdrop TEXT )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS anime_history (_id INTEGER PRIMARY KEY,url TEXT UNIQUE,_title TEXT,info_url TEXT,image_url TEXT,quality TEXT,rating TEXT,cast_ TEXT,server_ TEXT,plot_ TEXT,_year TEXT,_season TEXT,server_number_ TEXT )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS anime_favorites (_id INTEGER PRIMARY KEY,url TEXT UNIQUE,_title TEXT,info_url TEXT,image_url TEXT,quality TEXT,rating TEXT,cast_ TEXT,server_ TEXT,plot_ TEXT,_year TEXT,_season TEXT,server_number_ TEXT )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS iptv_history (_id INTEGER PRIMARY KEY,label_name_ TEXT,history_url_ TEXT UNIQUE ,history_type_ TEXT )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS fav_channels (_id INTEGER PRIMARY KEY,channel_url_ TEXT,channel_label_ TEXT UNIQUE ,channel_logo_ TEXT )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS go_anime_table (_id INTEGER PRIMARY KEY,go_anime_title TEXT,go_anime_title_year TEXT,go_anime_url TEXT UNIQUE ,go_anime_code TEXT,go_anime_img_url TEXT,go_anime_plot TEXT,go_anime_genres TEXT,go_anime_year TEXT )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS adult_favorites (_id INTEGER PRIMARY KEY,adult_title TEXT,adult_url TEXT UNIQUE ,adult_img_url TEXT )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS adult_history (_id INTEGER PRIMARY KEY,adult_title TEXT,adult_url TEXT UNIQUE ,adult_img_url TEXT )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS channels_imports (_id INTEGER PRIMARY KEY,channel_url_ TEXT,channel_label_ TEXT UNIQUE ,channel_logo_ TEXT,channel_source_uri_ TEXT )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS drama_continue (_id INTEGER PRIMARY KEY,drama_url TEXT UNIQUE,drama_title TEXT,drama_year TEXT,drama_img_url TEXT,drama_title_year TEXT,drama_is_series TEXT )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS drama_favorites (_id INTEGER PRIMARY KEY,drama_url TEXT UNIQUE,drama_title TEXT,drama_year TEXT,drama_img_url TEXT,drama_title_year TEXT,drama_is_series TEXT )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS drama_history (_id INTEGER PRIMARY KEY,drama_url TEXT UNIQUE,drama_title TEXT,drama_year TEXT,drama_img_url TEXT,drama_title_year TEXT,drama_is_series TEXT )");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        onUpgrade(sQLiteDatabase, i10, i11);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        onCreate(sQLiteDatabase);
    }
}
