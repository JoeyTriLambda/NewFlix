package androidx.appcompat.widget;

import android.R;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: SuggestionsAdapter.java */
/* loaded from: classes.dex */
public final class w0 extends e1.c implements View.OnClickListener {
    public final int A;
    public int B;
    public ColorStateList C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;

    /* renamed from: w, reason: collision with root package name */
    public final SearchView f1535w;

    /* renamed from: x, reason: collision with root package name */
    public final SearchableInfo f1536x;

    /* renamed from: y, reason: collision with root package name */
    public final Context f1537y;

    /* renamed from: z, reason: collision with root package name */
    public final WeakHashMap<String, Drawable.ConstantState> f1538z;

    /* compiled from: SuggestionsAdapter.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f1539a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f1540b;

        /* renamed from: c, reason: collision with root package name */
        public final ImageView f1541c;

        /* renamed from: d, reason: collision with root package name */
        public final ImageView f1542d;

        /* renamed from: e, reason: collision with root package name */
        public final ImageView f1543e;

        public a(View view) {
            this.f1539a = (TextView) view.findViewById(R.id.text1);
            this.f1540b = (TextView) view.findViewById(R.id.text2);
            this.f1541c = (ImageView) view.findViewById(R.id.icon1);
            this.f1542d = (ImageView) view.findViewById(R.id.icon2);
            this.f1543e = (ImageView) view.findViewById(androidx.appcompat.R.id.edit_query);
        }
    }

    public w0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.B = 1;
        this.D = -1;
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.H = -1;
        this.I = -1;
        this.f1535w = searchView;
        this.f1536x = searchableInfo;
        this.A = searchView.getSuggestionCommitIconResId();
        this.f1537y = context;
        this.f1538z = weakHashMap;
    }

    public static String d(Cursor cursor, int i10) {
        if (i10 == -1) {
            return null;
        }
        try {
            return cursor.getString(i10);
        } catch (Exception e10) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e10);
            return null;
        }
    }

    public static String getColumnString(Cursor cursor, String str) {
        return d(cursor, cursor.getColumnIndex(str));
    }

    public final Drawable a(Uri uri) throws PackageManager.NameNotFoundException, NumberFormatException, FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException(ac.c.i("No authority: ", uri));
        }
        try {
            Resources resourcesForApplication = this.f1537y.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException(ac.c.i("No path: ", uri));
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException(ac.c.i("Single path segment is not a resource ID: ", uri));
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException(ac.c.i("More than two path segments: ", uri));
                }
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (identifier != 0) {
                return resourcesForApplication.getDrawable(identifier);
            }
            throw new FileNotFoundException(ac.c.i("No resource found for: ", uri));
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException(ac.c.i("No package found for authority: ", uri));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.drawable.Drawable b(java.lang.String r11) throws android.content.pm.PackageManager.NameNotFoundException, java.lang.NumberFormatException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.w0.b(java.lang.String):android.graphics.drawable.Drawable");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013a  */
    @Override // e1.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void bindView(android.view.View r21, android.content.Context r22, android.database.Cursor r23) throws android.content.pm.PackageManager.NameNotFoundException, java.lang.NumberFormatException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.w0.bindView(android.view.View, android.content.Context, android.database.Cursor):void");
    }

    public final Cursor c(SearchableInfo searchableInfo, String str) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        builderFragment.appendQueryParameter("limit", String.valueOf(50));
        return this.f1537y.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr, null);
    }

    @Override // e1.a
    public void changeCursor(Cursor cursor) {
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.D = cursor.getColumnIndex("suggest_text_1");
                this.E = cursor.getColumnIndex("suggest_text_2");
                this.F = cursor.getColumnIndex("suggest_text_2_url");
                this.G = cursor.getColumnIndex("suggest_icon_1");
                this.H = cursor.getColumnIndex("suggest_icon_2");
                this.I = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e10) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e10);
        }
    }

    @Override // e1.a
    public CharSequence convertToString(Cursor cursor) {
        String columnString;
        String columnString2;
        if (cursor == null) {
            return null;
        }
        String columnString3 = getColumnString(cursor, "suggest_intent_query");
        if (columnString3 != null) {
            return columnString3;
        }
        SearchableInfo searchableInfo = this.f1536x;
        if (searchableInfo.shouldRewriteQueryFromData() && (columnString2 = getColumnString(cursor, "suggest_intent_data")) != null) {
            return columnString2;
        }
        if (!searchableInfo.shouldRewriteQueryFromText() || (columnString = getColumnString(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return columnString;
    }

    @Override // e1.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e10);
            View viewNewDropDownView = newDropDownView(this.f1537y, getCursor(), viewGroup);
            if (viewNewDropDownView != null) {
                ((a) viewNewDropDownView.getTag()).f1539a.setText(e10.toString());
            }
            return viewNewDropDownView;
        }
    }

    @Override // e1.a, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e10);
            View viewNewView = newView(this.f1537y, getCursor(), viewGroup);
            if (viewNewView != null) {
                ((a) viewNewView.getTag()).f1539a.setText(e10.toString());
            }
            return viewNewView;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // e1.c, e1.a
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewNewView = super.newView(context, cursor, viewGroup);
        viewNewView.setTag(new a(viewNewView));
        ((ImageView) viewNewView.findViewById(androidx.appcompat.R.id.edit_query)).setImageResource(this.A);
        return viewNewView;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        Cursor cursor = getCursor();
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        Cursor cursor = getCursor();
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1535w.onQueryRefine((CharSequence) tag);
        }
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String string = charSequence == null ? "" : charSequence.toString();
        SearchView searchView = this.f1535w;
        if (searchView.getVisibility() != 0 || searchView.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor cursorC = c(this.f1536x, string);
            if (cursorC == null) {
                return null;
            }
            cursorC.getCount();
            return cursorC;
        } catch (RuntimeException e10) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e10);
            return null;
        }
    }

    public void setQueryRefinement(int i10) {
        this.B = i10;
    }
}
