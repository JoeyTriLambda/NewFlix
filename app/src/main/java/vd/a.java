package vd;

import android.os.AsyncTask;
import org.greenrobot.eventbus.EventBus;
import vd.b;

/* compiled from: DDLValleyMovies.java */
/* loaded from: classes2.dex */
public final class a extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f20680a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f20681b;

    public a(b bVar, String str) {
        this.f20681b = bVar;
        this.f20680a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        String str = this.f20680a;
        try {
            String strHtml = ((dh.b) ch.a.connect(str)).get().html();
            if (strHtml.contains("Checking if the site connection is secure") || strHtml.contains("Checking your browser before accessing")) {
                b.a aVar = new b.a();
                aVar.f20692a = str;
                EventBus.getDefault().post(aVar);
            } else {
                this.f20681b.b(strHtml, false);
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            b.a aVar2 = new b.a();
            aVar2.f20692a = str;
            EventBus.getDefault().post(aVar2);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((a) str);
    }
}
