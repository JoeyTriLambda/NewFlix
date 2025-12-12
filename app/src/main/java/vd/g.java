package vd;

import android.os.AsyncTask;
import org.greenrobot.eventbus.EventBus;
import vd.h;

/* compiled from: RapidMoviesSeries.java */
/* loaded from: classes2.dex */
public final class g extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f20727a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f20728b;

    public g(h hVar, String str) {
        this.f20728b = hVar;
        this.f20727a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        String str = this.f20727a;
        try {
            String strHtml = ((dh.b) ch.a.connect(str)).get().html();
            if (strHtml.contains("Checking if the site connection is secure") || strHtml.contains("Checking your browser before accessing")) {
                h.a aVar = new h.a();
                aVar.f20741a = str;
                EventBus.getDefault().post(aVar);
            } else {
                this.f20728b.b(strHtml, false);
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            h.a aVar2 = new h.a();
            aVar2.f20741a = str;
            EventBus.getDefault().post(aVar2);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((g) str);
    }
}
