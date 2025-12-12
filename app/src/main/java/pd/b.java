package pd;

import a2.x;
import android.os.AsyncTask;
import d4.m;
import flix.com.vision.App;

/* compiled from: M3USpliter.java */
/* loaded from: classes2.dex */
public final class b extends AsyncTask<Void, Void, String> {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f17671c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f17672a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f17673b;

    public b(c cVar, String str) {
        this.f17673b = cVar;
        this.f17672a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        try {
            String str = this.f17672a;
            App.getInstance().getRequestQueue().add(new m(0, str, new x(10, this, str), new a(0)));
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((b) str);
    }
}
