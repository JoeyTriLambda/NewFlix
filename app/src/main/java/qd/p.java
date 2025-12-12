package qd;

import android.os.AsyncTask;
import java.util.Iterator;
import java.util.Locale;
import org.jsoup.nodes.Element;

/* compiled from: Movies123HubProcessorSeries.java */
/* loaded from: classes2.dex */
public final class p extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f18117a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f18118b;

    public p(q qVar, String str) {
        this.f18118b = qVar;
        this.f18117a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        q qVar;
        String strAttr;
        try {
            Iterator<Element> it = ((dh.b) ch.a.connect(this.f18117a)).get().getElementsByTag("a").iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                qVar = this.f18118b;
                if (!zHasNext) {
                    break;
                }
                Element next = it.next();
                if (next.toString().toLowerCase(Locale.ROOT).contains("episode " + qVar.f18121h) && (strAttr = next.attr("href")) != null && strAttr.length() > 0) {
                    hd.o oVar = new hd.o();
                    oVar.D = strAttr;
                    oVar.C = qVar.checkLinkLabel(strAttr);
                    oVar.F = true;
                    qVar.f18120g.add(oVar);
                }
            }
            if (qVar.f18120g.size() <= 0) {
                return null;
            }
            Iterator<hd.o> it2 = qVar.f18120g.iterator();
            while (it2.hasNext()) {
                qVar.addLink(it2.next());
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((p) str);
    }
}
