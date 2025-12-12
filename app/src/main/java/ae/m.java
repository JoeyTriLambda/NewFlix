package ae;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;
import flix.com.vision.App;
import flix.com.vision.tv.TVChannelSearchActivity;

/* compiled from: TVChannelSearchActivity.java */
/* loaded from: classes2.dex */
public final class m extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f659a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TVChannelSearchActivity f660b;

    public m(TVChannelSearchActivity tVChannelSearchActivity, String str) {
        this.f660b = tVChannelSearchActivity;
        this.f659a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        for (int i10 = 0; i10 < App.getInstance().f11569q.size(); i10++) {
            try {
                if (App.getInstance().f11569q.get(i10).f12984q.toLowerCase().contains(this.f659a.toLowerCase())) {
                    this.f660b.N.add(App.getInstance().f11569q.get(i10));
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((m) str);
        TVChannelSearchActivity tVChannelSearchActivity = this.f660b;
        if (tVChannelSearchActivity.N.size() > 0) {
            tVChannelSearchActivity.M.notifyDataSetChanged();
        } else {
            Toast.makeText(tVChannelSearchActivity.getBaseContext(), "Nothing found!", 0).show();
        }
        ProgressDialog progressDialog = tVChannelSearchActivity.P;
        if (progressDialog != null) {
            try {
                if (progressDialog.isShowing()) {
                    tVChannelSearchActivity.P.dismiss();
                }
            } catch (Exception unused) {
            }
        }
    }
}
