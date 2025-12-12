package td;

import android.os.AsyncTask;
import android.util.Log;
import flix.com.vision.activities.MovieDetailActivity;

/* compiled from: FlixHindiML.java */
/* loaded from: classes2.dex */
public final class b extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f19888a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f19889b;

    public b(c cVar, String str) {
        this.f19889b = cVar;
        this.f19888a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        c cVar = this.f19889b;
        try {
            cVar.GetStreamLinkHindi(cVar.f12433d + "/play/" + this.f19888a);
            return null;
        } catch (Exception e10) {
            Log.d(MovieDetailActivity.class.toString(), "", e10);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((b) str);
    }
}
