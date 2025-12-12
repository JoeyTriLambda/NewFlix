package ub;

import android.content.Intent;
import flix.com.vision.App;
import flix.com.vision.activities.SearchActivityClassic;
import flix.com.vision.activities.SearchResultsActivity;
import flix.com.vision.materialsearchview.MaterialSearchView;

/* compiled from: SearchActivityClassic.java */
/* loaded from: classes2.dex */
public final class p1 implements MaterialSearchView.OnQueryTextListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchActivityClassic f20250a;

    public p1(SearchActivityClassic searchActivityClassic) {
        this.f20250a = searchActivityClassic;
    }

    @Override // flix.com.vision.materialsearchview.MaterialSearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        return false;
    }

    @Override // flix.com.vision.materialsearchview.MaterialSearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        if (str != null) {
            if (str.length() >= 1) {
                SearchActivityClassic searchActivityClassic = this.f20250a;
                Intent intent = new Intent(searchActivityClassic, (Class<?>) SearchResultsActivity.class);
                intent.putExtra("query", str);
                intent.putExtra("tv_shows_only", App.getInstance().f11574v.getInt("content_type", 0) == 1);
                searchActivityClassic.startActivity(intent);
                searchActivityClassic.L.saveQueryToDb(searchActivityClassic.M, System.currentTimeMillis());
            }
        }
        return false;
    }
}
