package flix.com.vision.materialsearchview.db;

import ac.c;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import flix.com.vision.materialsearchview.db.HistoryContract;

/* loaded from: classes2.dex */
public class HistoryProvider extends ContentProvider {

    /* renamed from: m, reason: collision with root package name */
    public static final UriMatcher f12376m = buildUriMatcher();

    /* renamed from: b, reason: collision with root package name */
    public HistoryDbHelper f12377b;

    public static UriMatcher buildUriMatcher() {
        Uri uri = HistoryContract.f12372a;
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI("flix.com.vision.materialsearchview.searchhistorydatabase", "history", 100);
        uriMatcher.addURI("flix.com.vision.materialsearchview.searchhistorydatabase", "history/#", 101);
        uriMatcher.addURI("flix.com.vision.materialsearchview.searchhistorydatabase", "history/#", 102);
        uriMatcher.addURI("flix.com.vision.materialsearchview.searchhistorydatabase", "history/#", 103);
        return uriMatcher;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        Context context;
        SQLiteDatabase writableDatabase = this.f12377b.getWritableDatabase();
        if (f12376m.match(uri) != 100) {
            throw new UnsupportedOperationException(c.i("Unknown uri: ", uri));
        }
        int iDelete = writableDatabase.delete("SEARCH_HISTORY", str, strArr);
        if ((str == null || iDelete != 0) && (context = getContext()) != null) {
            context.getContentResolver().notifyChange(uri, null);
        }
        return iDelete;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (f12376m.match(uri)) {
            case 100:
                return HistoryContract.HistoryEntry.f12374b;
            case 101:
            case 102:
            case 103:
                return HistoryContract.HistoryEntry.f12375c;
            default:
                throw new UnsupportedOperationException(c.i("Uknown Uri: ", uri));
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        SQLiteDatabase writableDatabase = this.f12377b.getWritableDatabase();
        if (f12376m.match(uri) != 100) {
            throw new UnsupportedOperationException(c.i("Unknown uri: ", uri));
        }
        long jInsert = writableDatabase.insert("SEARCH_HISTORY", null, contentValues);
        if (jInsert > 0) {
            return HistoryContract.HistoryEntry.buildHistoryUri(jInsert);
        }
        throw new UnsupportedOperationException(c.i("Unable to insert rows into: ", uri));
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f12377b = new HistoryDbHelper(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursorQuery;
        SQLiteDatabase readableDatabase = this.f12377b.getReadableDatabase();
        switch (f12376m.match(uri)) {
            case 100:
                cursorQuery = readableDatabase.query("SEARCH_HISTORY", strArr, str, strArr2, null, null, str2);
                break;
            case 101:
                cursorQuery = readableDatabase.query("SEARCH_HISTORY", strArr, "insert_date = ?", new String[]{String.valueOf(ContentUris.parseId(uri))}, null, null, str2);
                break;
            case 102:
                cursorQuery = readableDatabase.query("SEARCH_HISTORY", strArr, "_id = ?", new String[]{String.valueOf(ContentUris.parseId(uri))}, null, null, str2);
                break;
            case 103:
                cursorQuery = readableDatabase.query("SEARCH_HISTORY", strArr, "is_history = ?", new String[]{String.valueOf(ContentUris.parseId(uri))}, null, null, str2);
                break;
            default:
                throw new UnsupportedOperationException(c.i("Unknown Uri: ", uri));
        }
        Context context = getContext();
        if (context != null) {
            cursorQuery.setNotificationUri(context.getContentResolver(), uri);
        }
        return cursorQuery;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Context context;
        SQLiteDatabase writableDatabase = this.f12377b.getWritableDatabase();
        if (f12376m.match(uri) != 100) {
            throw new UnsupportedOperationException(c.i("Unknown uri: ", uri));
        }
        int iUpdate = writableDatabase.update("SEARCH_HISTORY", contentValues, str, strArr);
        if (iUpdate != 0 && (context = getContext()) != null) {
            context.getContentResolver().notifyChange(uri, null);
        }
        return iUpdate;
    }
}
