package vd;

import android.os.AsyncTask;
import flix.com.vision.App;
import org.greenrobot.eventbus.EventBus;
import vd.l;

/* compiled from: ReleasesBBSeries.java */
/* loaded from: classes2.dex */
public final class k extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f20759a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f20760b;

    public k(l lVar, String str) {
        this.f20760b = lVar;
        this.f20759a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        l lVar = this.f20760b;
        String str = this.f20759a;
        try {
            String strHtml = ((dh.b) ((dh.b) ch.a.connect(str)).timeout(5000)).get().html();
            if (strHtml.contains("Checking if the site connection is secure") || strHtml.contains("Checking your browser before accessing")) {
                l.a aVar = new l.a();
                aVar.f20773a = str;
                EventBus.getDefault().post(aVar);
            } else {
                lVar.b(strHtml, false);
            }
            return null;
        } catch (Exception unused) {
            lVar.getClass();
            try {
                String strString = App.get(str, str).body().string();
                if (strString.contains("Checking if the site connection is secure") || strString.contains("Checking your browser before accessing")) {
                    l.a aVar2 = new l.a();
                    aVar2.f20773a = str;
                    EventBus.getDefault().post(aVar2);
                } else {
                    lVar.b(strString, false);
                }
                return null;
            } catch (Exception e10) {
                e10.printStackTrace();
                l.a aVar3 = new l.a();
                aVar3.f20773a = str;
                EventBus.getDefault().post(aVar3);
                return null;
            }
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((k) str);
    }
}
