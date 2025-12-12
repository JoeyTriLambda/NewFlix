package flix.com.vision.materialsearchview.db;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/* loaded from: classes2.dex */
public class HistoryContract {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f12372a = Uri.parse("content://flix.com.vision.materialsearchview.searchhistorydatabase");

    public static final class HistoryEntry implements BaseColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final Uri f12373a;

        /* renamed from: b, reason: collision with root package name */
        public static final String f12374b;

        /* renamed from: c, reason: collision with root package name */
        public static final String f12375c;

        static {
            Uri uriBuild = HistoryContract.f12372a.buildUpon().appendPath("history").build();
            f12373a = uriBuild;
            f12374b = "vnd.android.cursor.dir/" + uriBuild + "/history";
            f12375c = "vnd.android.cursor.item/" + uriBuild + "/history";
        }

        public static Uri buildHistoryUri(long j10) {
            return ContentUris.withAppendedId(f12373a, j10);
        }
    }
}
