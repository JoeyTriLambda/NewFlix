package vd;

import android.os.AsyncTask;
import org.greenrobot.eventbus.EventBus;
import vd.f;

/* compiled from: RapidMovies.java */
/* loaded from: classes2.dex */
public final class e extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f20713a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f20714b;

    public e(f fVar, String str) {
        this.f20714b = fVar;
        this.f20713a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        String str = this.f20713a;
        try {
            String strHtml = ((dh.b) ch.a.connect(str)).get().html();
            if (strHtml.contains("Checking if the site connection is secure") || strHtml.contains("Checking your browser before accessing")) {
                f.a aVar = new f.a();
                aVar.f20724a = str;
                EventBus.getDefault().post(aVar);
            } else {
                this.f20714b.b(strHtml, false);
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            f.a aVar2 = new f.a();
            aVar2.f20724a = str;
            EventBus.getDefault().post(aVar2);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((e) str);
    }
}
