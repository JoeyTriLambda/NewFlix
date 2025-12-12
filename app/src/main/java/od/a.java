package od;

import a2.x;
import android.os.AsyncTask;
import d4.m;
import flix.com.vision.App;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ub.n0;

/* compiled from: AdultStreamResolver.java */
/* loaded from: classes2.dex */
public final class a extends AsyncTask<Void, Void, String> {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f17071c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f17072a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f17073b;

    public a(b bVar, String str) {
        this.f17073b = bVar;
        this.f17072a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        try {
            Matcher matcher = Pattern.compile("setVideoHLS\\('(.*?)'").matcher(((dh.b) ch.a.connect(this.f17072a)).get().toString());
            while (matcher.find()) {
                String strGroup = matcher.group(1);
                App.getInstance().getRequestQueue().add(new m(0, strGroup, new x(9, this, strGroup), new n0(29)));
            }
            return null;
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((a) str);
    }
}
