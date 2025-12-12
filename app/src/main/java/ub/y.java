package ub;

import android.app.FragmentManager;
import android.os.AsyncTask;
import flix.com.vision.activities.DramaSearchActivityMobile;
import flix.com.vision.materialsearchview.MaterialSearchView;

/* compiled from: DramaSearchActivityMobile.java */
/* loaded from: classes2.dex */
public final class y implements MaterialSearchView.OnQueryTextListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DramaSearchActivityMobile f20323a;

    public y(DramaSearchActivityMobile dramaSearchActivityMobile) {
        this.f20323a = dramaSearchActivityMobile;
    }

    @Override // flix.com.vision.materialsearchview.MaterialSearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        return false;
    }

    @Override // flix.com.vision.materialsearchview.MaterialSearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        if (str != null && str.length() >= 1) {
            DramaSearchActivityMobile dramaSearchActivityMobile = this.f20323a;
            FragmentManager fragmentManager = dramaSearchActivityMobile.getFragmentManager();
            kc.d dVarNewInstance = kc.d.newInstance(dramaSearchActivityMobile, false);
            dramaSearchActivityMobile.T = dVarNewInstance;
            dVarNewInstance.setloading();
            try {
                dramaSearchActivityMobile.T.show(fragmentManager, "");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            dramaSearchActivityMobile.getSupportActionBar().setTitle("Results for \"" + str + "\"");
            dramaSearchActivityMobile.N.clear();
            dramaSearchActivityMobile.P.notifyDataSetChanged();
            new x(dramaSearchActivityMobile, str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
        return false;
    }
}
