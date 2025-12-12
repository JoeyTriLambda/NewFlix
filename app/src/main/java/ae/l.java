package ae;

import flix.com.vision.materialsearchview.MaterialSearchView;
import flix.com.vision.tv.TVChannelSearchActivity;

/* compiled from: TVChannelSearchActivity.java */
/* loaded from: classes2.dex */
public final class l implements MaterialSearchView.OnQueryTextListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TVChannelSearchActivity f658a;

    public l(TVChannelSearchActivity tVChannelSearchActivity) {
        this.f658a = tVChannelSearchActivity;
    }

    @Override // flix.com.vision.materialsearchview.MaterialSearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0017  */
    @Override // flix.com.vision.materialsearchview.MaterialSearchView.OnQueryTextListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onQueryTextSubmit(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L4c
            int r1 = r6.length()
            r2 = 1
            if (r1 < r2) goto L4c
            flix.com.vision.tv.TVChannelSearchActivity r1 = r5.f658a
            android.app.ProgressDialog r3 = r1.P
            if (r3 == 0) goto L17
            boolean r3 = r3.isShowing()     // Catch: java.lang.Exception -> L17
            if (r3 == 0) goto L17
            goto L2d
        L17:
            android.app.ProgressDialog r3 = new android.app.ProgressDialog
            r3.<init>(r1)
            r1.P = r3
            java.lang.String r4 = "please wait..."
            r3.setMessage(r4)
            android.app.ProgressDialog r3 = r1.P
            r3.setCancelable(r2)
            android.app.ProgressDialog r2 = r1.P
            r2.show()
        L2d:
            r.a r2 = r1.getSupportActionBar()
            java.lang.String r3 = "searching all channels..."
            r2.setTitle(r3)
            java.util.ArrayList<hd.d> r2 = r1.N
            r2.clear()
            ac.k r2 = r1.M
            r2.notifyDataSetChanged()
            ae.m r2 = new ae.m
            r2.<init>(r1, r6)
            java.util.concurrent.Executor r6 = android.os.AsyncTask.THREAD_POOL_EXECUTOR
            java.lang.Void[] r1 = new java.lang.Void[r0]
            r2.executeOnExecutor(r6, r1)
        L4c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ae.l.onQueryTextSubmit(java.lang.String):boolean");
    }
}
