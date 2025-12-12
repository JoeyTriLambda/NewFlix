package ub;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.snackbar.Snackbar;
import com.uwetrottmann.trakt5.TraktV2;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.AnimesListActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class g implements SwipeRefreshLayout.f, aa.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnimesListActivity f20183b;

    public /* synthetic */ g(AnimesListActivity animesListActivity) {
        this.f20183b = animesListActivity;
    }

    @Override // aa.a
    public final void onMoreAsked(int i10, int i11, int i12) {
        AnimesListActivity animesListActivity = this.f20183b;
        int i13 = animesListActivity.X + 1;
        animesListActivity.X = i13;
        String string = App.getInstance().f11574v.getString("genre_anime", "");
        String string2 = App.getInstance().f11574v.getString("year_anime", "");
        String string3 = App.getInstance().f11574v.getString("type_anime", "");
        String string4 = App.getInstance().f11574v.getString("lang_anime", "");
        if (string.equals("All")) {
            string = "";
        }
        string3.equals("All");
        if (string2.equals("All")) {
            string2 = "";
        }
        if (string4.equals("All")) {
            string4 = "";
        }
        animesListActivity.f11599b0.addAll(App.getInstance().f11573u.getGoAnime(string, string2, animesListActivity.f11598a0.equals(TraktV2.API_VERSION) ? "" : string4, i13));
        if (animesListActivity.f11599b0.size() < 1) {
            Snackbar.make(animesListActivity.findViewById(R.id.activity_player), animesListActivity.getString(R.string.no_more_content), 0).show();
        }
        animesListActivity.f11601d0.getAdapter().notifyDataSetChanged();
        animesListActivity.f11601d0.invalidate();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.f
    public final void onRefresh() {
        AnimesListActivity animesListActivity = this.f20183b;
        animesListActivity.X = 0;
        animesListActivity.f11599b0.clear();
        animesListActivity.d(animesListActivity.X);
    }
}
