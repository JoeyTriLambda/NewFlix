package ub;

import android.content.Intent;
import flix.com.vision.App;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.activities.SearchResultsActivity;
import flix.com.vision.materialsearchview.MaterialSearchView;

/* compiled from: MainActivity.java */
/* loaded from: classes2.dex */
public final class d1 implements MaterialSearchView.OnQueryTextListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MainActivity f20165a;

    public d1(MainActivity mainActivity) {
        this.f20165a = mainActivity;
    }

    @Override // flix.com.vision.materialsearchview.MaterialSearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        if (str.length() > 1) {
            MainActivity mainActivity = this.f20165a;
            qe.b bVar = mainActivity.f11714q0;
            if (bVar != null) {
                bVar.dispose();
            }
            mainActivity.f11714q0 = bc.a.getSuggest(mainActivity.getBaseContext(), str).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new c1.c(mainActivity, 18), new n0(3));
        }
        return true;
    }

    @Override // flix.com.vision.materialsearchview.MaterialSearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        MainActivity mainActivity = this.f20165a;
        if (str == null || str.length() < 1) {
            mainActivity.f11698a0.activityResumed();
            mainActivity.f11698a0.closeSearch();
            mainActivity.f11698a0.clearFocus();
            return true;
        }
        Intent intent = new Intent(mainActivity, (Class<?>) SearchResultsActivity.class);
        intent.putExtra("query", str);
        intent.putExtra("tv_shows_only", App.getInstance().f11574v.getInt("content_type", 0) == 1);
        mainActivity.startActivity(intent);
        mainActivity.f11698a0.saveQueryToDb(str, System.currentTimeMillis());
        return true;
    }
}
