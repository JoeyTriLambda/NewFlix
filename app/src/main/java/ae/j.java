package ae;

import android.widget.Toast;
import flix.com.vision.App;
import flix.com.vision.materialsearchview.MaterialSearchView;
import flix.com.vision.tv.TVCategorySearchActivity;

/* compiled from: TVCategorySearchActivity.java */
/* loaded from: classes2.dex */
public final class j implements MaterialSearchView.OnQueryTextListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TVCategorySearchActivity f655a;

    public j(TVCategorySearchActivity tVCategorySearchActivity) {
        this.f655a = tVCategorySearchActivity;
    }

    @Override // flix.com.vision.materialsearchview.MaterialSearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        return false;
    }

    @Override // flix.com.vision.materialsearchview.MaterialSearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        if (str != null && str.length() >= 1) {
            TVCategorySearchActivity tVCategorySearchActivity = this.f655a;
            tVCategorySearchActivity.getSupportActionBar().setTitle("Results for \"" + str + "\"");
            tVCategorySearchActivity.N.clear();
            tVCategorySearchActivity.M.notifyDataSetChanged();
            tVCategorySearchActivity.getClass();
            for (int i10 = 0; i10 < App.getInstance().f11571s.size(); i10++) {
                if (App.getInstance().f11571s.get(i10).getCategoryName().toLowerCase().contains(str.toLowerCase())) {
                    tVCategorySearchActivity.N.add(App.getInstance().f11571s.get(i10));
                }
            }
            if (tVCategorySearchActivity.N.size() > 0) {
                tVCategorySearchActivity.M.notifyDataSetChanged();
            } else {
                Toast.makeText(tVCategorySearchActivity.getBaseContext(), "Nothing found!", 0).show();
            }
        }
        return false;
    }
}
