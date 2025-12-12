package qd;

import android.os.AsyncTask;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Element;

/* compiled from: Movies123HubProcessor.java */
/* loaded from: classes2.dex */
public final class n extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f18113a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f18114b;

    public n(o oVar, String str) {
        this.f18114b = oVar;
        this.f18113a = str;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void... voidArr) {
        o oVar;
        try {
            Iterator<Element> it = ((dh.b) ch.a.connect(this.f18113a)).get().getElementsByTag("script").iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                oVar = this.f18114b;
                if (!zHasNext) {
                    break;
                }
                Element next = it.next();
                if (next.toString().contains("getJSON")) {
                    Matcher matcher = Pattern.compile("'(.*?)'").matcher(next.childNode(0).toString());
                    while (matcher.find()) {
                        String strGroup = matcher.group(1);
                        if (strGroup != null && !strGroup.contains("api_token") && !strGroup.contains("svetacdn")) {
                            hd.o oVar2 = new hd.o();
                            oVar2.D = strGroup;
                            oVar2.C = oVar.checkLinkLabel(strGroup);
                            oVar2.F = true;
                            oVar.f18116g.add(oVar2);
                        }
                    }
                }
            }
            if (oVar.f18116g.size() <= 0) {
                return null;
            }
            Iterator<hd.o> it2 = oVar.f18116g.iterator();
            while (it2.hasNext()) {
                oVar.addLink(it2.next());
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((n) str);
    }
}
