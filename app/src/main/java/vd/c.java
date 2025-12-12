package vd;

import android.os.AsyncTask;
import org.greenrobot.eventbus.EventBus;
import vd.d;

/* compiled from: DDLValleySeries.java */
/* loaded from: classes2.dex */
public final class c extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f20695a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f20696b;

    public c(d dVar, String str) {
        this.f20696b = dVar;
        this.f20695a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        String str = this.f20695a;
        try {
            String strHtml = ((dh.b) ch.a.connect(str)).get().html();
            if (strHtml.contains("Checking if the site connection is secure") || strHtml.contains("Checking your browser before accessing")) {
                d.a aVar = new d.a();
                aVar.f20710a = str;
                EventBus.getDefault().post(aVar);
            } else {
                this.f20696b.b(strHtml, false);
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            d.a aVar2 = new d.a();
            aVar2.f20710a = str;
            EventBus.getDefault().post(aVar2);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((c) str);
    }
}
