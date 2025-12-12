package vd;

import android.os.AsyncTask;
import flix.com.vision.App;
import org.greenrobot.eventbus.EventBus;
import vd.j;

/* compiled from: ReleasesBBMovies.java */
/* loaded from: classes2.dex */
public final class i extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f20744a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f20745b;

    public i(j jVar, String str) {
        this.f20745b = jVar;
        this.f20744a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        j jVar = this.f20745b;
        String str = this.f20744a;
        try {
            String strHtml = ((dh.b) ((dh.b) ch.a.connect(str)).timeout(5000)).get().html();
            if (strHtml.contains("Checking if the site connection is secure") || strHtml.contains("Checking your browser before accessing")) {
                j.a aVar = new j.a();
                aVar.f20756a = str;
                EventBus.getDefault().post(aVar);
            } else {
                jVar.b(strHtml, false);
            }
            return null;
        } catch (Exception unused) {
            jVar.getClass();
            try {
                String strString = App.get(str, str).body().string();
                if (strString.contains("Checking if the site connection is secure") || strString.contains("Checking your browser before accessing")) {
                    j.a aVar2 = new j.a();
                    aVar2.f20756a = str;
                    EventBus.getDefault().post(aVar2);
                } else {
                    jVar.b(strString, false);
                }
                return null;
            } catch (Exception e10) {
                e10.printStackTrace();
                j.a aVar3 = new j.a();
                aVar3.f20756a = str;
                EventBus.getDefault().post(aVar3);
                return null;
            }
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((i) str);
    }
}
