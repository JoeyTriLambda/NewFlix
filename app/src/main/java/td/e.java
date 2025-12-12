package td;

import android.os.AsyncTask;
import android.util.Log;
import flix.com.vision.activities.MovieDetailActivity;

/* compiled from: FlixHindiMLSeries.java */
/* loaded from: classes2.dex */
public final class e extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f19900a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f19901b;

    public e(f fVar, String str) {
        this.f19901b = fVar;
        this.f19900a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        f fVar = this.f19901b;
        try {
            fVar.GetStreamLinkHindi(fVar.f12433d + "/play/" + this.f19900a);
            return null;
        } catch (Exception e10) {
            Log.d(MovieDetailActivity.class.toString(), "", e10);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((e) str);
    }
}
