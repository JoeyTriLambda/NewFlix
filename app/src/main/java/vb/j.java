package vb;

import android.app.FragmentManager;
import flix.com.vision.activities.adult.AdultVideosSearchActivity;
import flix.com.vision.materialsearchview.MaterialSearchView;

/* compiled from: AdultVideosSearchActivity.java */
/* loaded from: classes2.dex */
public final class j implements MaterialSearchView.OnQueryTextListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdultVideosSearchActivity f20668a;

    public j(AdultVideosSearchActivity adultVideosSearchActivity) {
        this.f20668a = adultVideosSearchActivity;
    }

    @Override // flix.com.vision.materialsearchview.MaterialSearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        return false;
    }

    @Override // flix.com.vision.materialsearchview.MaterialSearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        if (str != null && str.length() >= 1) {
            AdultVideosSearchActivity adultVideosSearchActivity = this.f20668a;
            FragmentManager fragmentManager = adultVideosSearchActivity.getFragmentManager();
            kc.d dVarNewInstance = kc.d.newInstance(adultVideosSearchActivity, false);
            adultVideosSearchActivity.Y = dVarNewInstance;
            dVarNewInstance.setloading();
            try {
                adultVideosSearchActivity.Y.show(fragmentManager, "");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            adultVideosSearchActivity.getSupportActionBar().setTitle("Results for \"" + str + "\"");
            adultVideosSearchActivity.O.clear();
            adultVideosSearchActivity.Q.notifyDataSetChanged();
            adultVideosSearchActivity.U = str;
            adultVideosSearchActivity.getVideos(adultVideosSearchActivity.T);
        }
        return false;
    }
}
